package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    protected String atA;
    private com.baidu.tieba.person.f fnF;
    private k fnG;
    private BlackListModel fnH;
    protected boolean fnI;
    protected com.baidu.tieba.personPolymeric.c.a fnJ;
    private com.baidu.tieba.person.e fnK;
    private final com.baidu.adp.framework.listener.c fnL = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.fnH.setMaskType(1);
                    } else {
                        f.this.fnH.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.fnH.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.j.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.j.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fnM = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.kf(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fnN = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.kf(true);
            }
        }
    };
    private final CustomMessageListener fnO = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.kf(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.kf(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fnP = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c fnx;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fnx = cVar;
        this.fnH = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        this.fnG = new k(tbPageContext, bdUniqueId);
        registerListener();
    }

    public void registerListener() {
        this.fnL.setTag(this.mBdUniqueId);
        this.fnM.setTag(this.mBdUniqueId);
        this.fnP.setTag(this.mBdUniqueId);
        this.fnO.setTag(this.mBdUniqueId);
        this.fnN.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.fnL);
        this.mPageContext.registerListener(this.fnM);
        this.mPageContext.registerListener(this.fnP);
        this.mPageContext.registerListener(this.fnO);
        this.mPageContext.registerListener(this.fnN);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fnH != null && aVar != null && aVar.getUserData() != null) {
            this.fnJ = aVar;
            this.fnI = aVar.aBX();
            this.fnH.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.atA = aVar.getUserData().getPortrait();
        }
    }

    public void aZI() {
        if (this.fnx != null && this.fnH != null) {
            a(this.mHostView, this.fnI, this.fnH.getMaskType() == 1, this.fnx.aZy());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.fnF = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.fnF.M(z, z2);
        if (i != -1) {
            this.fnF.qt(i);
        }
        if (this.fnJ != null && this.fnJ.getUserData() != null) {
            this.fnF.setUserName(this.fnJ.getUserData().getUserName());
        }
        this.fnF.onChangeSkinType();
        this.fnK = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.fnF.getView());
        this.fnK.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.fnK, this.mPageContext.getPageActivity());
            if (this.fnF.aYe() != null && view.getId() == this.fnF.aYe().getId()) {
                aZJ();
            } else if (this.fnF.aYd() != null && view.getId() == this.fnF.aYd().getId()) {
                if (this.fnI) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.atA, null, false, null)));
            } else if (this.fnF.aYf() != null && view.getId() == this.fnF.aYf().getId()) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.fnx != null) {
                    if (this.fnx.aZy() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fnx.aZz(), this.fnx.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fnx.getUniqueId();
                        this.fnx.a(false, userMuteAddAndDelCustomMessage, this.fnx.aZz(), this.mUserName);
                    } else if (this.fnx.aZy() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fnx.aZz(), this.fnx.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fnx.getUniqueId();
                        this.fnx.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.fnF.aYg() != null && view.getId() == this.fnF.aYg().getId()) {
                this.fnG.jk(String.valueOf(this.mUserId));
            }
        }
    }

    protected void aZJ() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.fnH.getMaskType() == 1) {
                            f.this.fnH.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.fnH.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.fnH.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.j.block_chat_message_alert), this.mUserName);
            }
            aVar.cS(format);
            aVar.b(this.mPageContext);
            aVar.th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(boolean z) {
        this.fnI = z;
        if (this.fnJ != null) {
            this.fnJ.kh(this.fnI);
        }
        if (this.fnF != null && this.fnH != null) {
            this.fnF.M(this.fnI, this.fnH.getMaskType() == 1);
        }
    }
}
