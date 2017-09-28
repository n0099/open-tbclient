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
    protected String atq;
    private com.baidu.tieba.person.f ffE;
    private BlackListModel ffF;
    protected boolean ffG;
    protected com.baidu.tieba.personPolymeric.c.a ffH;
    private com.baidu.tieba.person.e ffI;
    private final com.baidu.adp.framework.listener.c ffJ = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.ffF.setMaskType(1);
                    } else {
                        f.this.ffF.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.ffF.getMaskType() == 1) {
                            f.this.mG.showToast(f.this.mG.getString(d.l.chat_message_blocked));
                            return;
                        } else {
                            f.this.mG.showToast(f.this.mG.getString(d.l.remove_succ));
                            return;
                        }
                    }
                    f.this.mG.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mG.getResources().getString(d.l.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c ffK = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.km(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mG.getResources().getString(d.l.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mG.showToast(errorString);
            }
        }
    };
    final CustomMessageListener ffL = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.km(true);
            }
        }
    };
    private final CustomMessageListener ffM = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.km(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.km(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c ffN = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mG.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mG.getResources().getString(d.l.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c ffw;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mG;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mG = tbPageContext;
        this.ffw = cVar;
        this.ffF = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.ffJ.setTag(this.mBdUniqueId);
        this.ffK.setTag(this.mBdUniqueId);
        this.ffN.setTag(this.mBdUniqueId);
        this.ffM.setTag(this.mBdUniqueId);
        this.ffL.setTag(this.mBdUniqueId);
        this.mG.registerListener(this.ffJ);
        this.mG.registerListener(this.ffK);
        this.mG.registerListener(this.ffN);
        this.mG.registerListener(this.ffM);
        this.mG.registerListener(this.ffL);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.ffF != null && aVar != null && aVar.getUserData() != null) {
            this.ffH = aVar;
            this.ffG = aVar.azH();
            this.ffF.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.atq = aVar.getUserData().getPortrait();
        }
    }

    public void aWL() {
        if (this.ffw != null && this.ffF != null) {
            a(this.mHostView, this.ffG, this.ffF.getMaskType() == 1, this.ffw.aWB());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.ffE = new com.baidu.tieba.person.f(this.mG, this);
        this.ffE.J(z, z2);
        if (i != -1) {
            this.ffE.qd(i);
        }
        if (this.ffH != null && this.ffH.getUserData() != null) {
            this.ffE.setUserName(this.ffH.getUserData().getUserName());
        }
        this.ffE.onChangeSkinType();
        this.ffI = new com.baidu.tieba.person.e(this.mG.getPageActivity(), this.ffE.getView());
        this.ffI.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.ffI, this.mG.getPageActivity());
            if (this.ffE.aVh() != null && view.getId() == this.ffE.aVh().getId()) {
                aWM();
            } else if (this.ffE.aVg() != null && view.getId() == this.ffE.aVg().getId()) {
                if (this.ffG) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mG.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.atq, null, false, null)));
            } else if (this.ffE.aVi() != null && view.getId() == this.ffE.aVi().getId()) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    this.mG.showToast(d.l.neterror);
                } else if (this.ffw != null) {
                    if (this.ffw.aWB() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ffw.aWC(), this.ffw.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.ffw.getUniqueId();
                        this.ffw.a(false, userMuteAddAndDelCustomMessage, this.ffw.aWC(), this.mUserName);
                    } else if (this.ffw.aWB() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ffw.aWC(), this.ffw.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.ffw.getUniqueId();
                        this.ffw.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aWM() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mG.getPageActivity());
            aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.ffF.getMaskType() == 1) {
                            f.this.ffF.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.ffF.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.ffF.getMaskType() == 1) {
                format = String.format(this.mG.getString(d.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mG.getString(d.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cM(format);
            aVar.b(this.mG);
            aVar.ti();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        this.ffG = z;
        if (this.ffH != null) {
            this.ffH.ko(this.ffG);
        }
        if (this.ffE != null && this.ffF != null) {
            this.ffE.J(this.ffG, this.ffF.getMaskType() == 1);
        }
    }
}
