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
    protected String atI;
    protected c fnU;
    private com.baidu.tieba.person.f foc;
    private k fod;
    private BlackListModel foe;
    protected boolean fof;
    protected com.baidu.tieba.personPolymeric.c.a fog;
    private com.baidu.tieba.person.e foh;
    private final com.baidu.adp.framework.listener.c foi = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.foe.setMaskType(1);
                    } else {
                        f.this.foe.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.foe.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c foj = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.kl(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fok = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.kl(true);
            }
        }
    };
    private final CustomMessageListener fol = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.kl(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.kl(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fom = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fnU = cVar;
        this.foe = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        this.fod = new k(tbPageContext, bdUniqueId);
        registerListener();
    }

    public void registerListener() {
        this.foi.setTag(this.mBdUniqueId);
        this.foj.setTag(this.mBdUniqueId);
        this.fom.setTag(this.mBdUniqueId);
        this.fol.setTag(this.mBdUniqueId);
        this.fok.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.foi);
        this.mPageContext.registerListener(this.foj);
        this.mPageContext.registerListener(this.fom);
        this.mPageContext.registerListener(this.fol);
        this.mPageContext.registerListener(this.fok);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.foe != null && aVar != null && aVar.getUserData() != null) {
            this.fog = aVar;
            this.fof = aVar.aCb();
            this.foe.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.atI = aVar.getUserData().getPortrait();
        }
    }

    public void aZQ() {
        if (this.fnU != null && this.foe != null) {
            a(this.mHostView, this.fof, this.foe.getMaskType() == 1, this.fnU.aZG());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.foc = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.foc.M(z, z2);
        if (i != -1) {
            this.foc.qu(i);
        }
        if (this.fog != null && this.fog.getUserData() != null) {
            this.foc.setUserName(this.fog.getUserData().getUserName());
        }
        this.foc.onChangeSkinType();
        this.foh = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.foc.getView());
        this.foh.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.foh, this.mPageContext.getPageActivity());
            if (this.foc.aYm() != null && view.getId() == this.foc.aYm().getId()) {
                aZR();
            } else if (this.foc.aYl() != null && view.getId() == this.foc.aYl().getId()) {
                if (this.fof) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.atI, null, false, null)));
            } else if (this.foc.aYn() != null && view.getId() == this.foc.aYn().getId()) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.fnU != null) {
                    if (this.fnU.aZG() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fnU.aZH(), this.fnU.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fnU.getUniqueId();
                        this.fnU.a(false, userMuteAddAndDelCustomMessage, this.fnU.aZH(), this.mUserName);
                    } else if (this.fnU.aZG() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fnU.aZH(), this.fnU.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fnU.getUniqueId();
                        this.fnU.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.foc.aYo() != null && view.getId() == this.foc.aYo().getId()) {
                this.fod.jl(String.valueOf(this.mUserId));
            }
        }
    }

    protected void aZR() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.foe.getMaskType() == 1) {
                            f.this.foe.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.foe.addToBlackList(f.this.mUserId);
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
            if (this.foe.getMaskType() == 1) {
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
    public void kl(boolean z) {
        this.fof = z;
        if (this.fog != null) {
            this.fog.kn(this.fof);
        }
        if (this.foc != null && this.foe != null) {
            this.foc.M(this.fof, this.foe.getMaskType() == 1);
        }
    }
}
