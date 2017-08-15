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
import com.baidu.tieba.person.j;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    protected String auD;
    protected b fkH;
    private j fkO;
    private BlackListModel fkP;
    protected boolean fkQ;
    protected com.baidu.tieba.personPolymeric.c.a fkR;
    private com.baidu.tieba.person.i fkS;
    private final com.baidu.adp.framework.listener.c fkT = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        e.this.fkP.setMaskType(1);
                    } else {
                        e.this.fkP.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (e.this.fkP.getMaskType() == 1) {
                            e.this.oV.showToast(e.this.oV.getString(d.l.chat_message_blocked));
                            return;
                        } else {
                            e.this.oV.showToast(e.this.oV.getString(d.l.remove_succ));
                            return;
                        }
                    }
                    e.this.oV.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? e.this.oV.getResources().getString(d.l.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fkU = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    e.this.ks(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? e.this.oV.getResources().getString(d.l.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                e.this.oV.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fkV = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                e.this.ks(true);
            }
        }
    };
    private final CustomMessageListener fkW = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    e.this.ks(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    e.this.ks(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fkX = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                e.this.oV.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? e.this.oV.getResources().getString(d.l.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;
    protected TbPageContext oV;

    public e(TbPageContext tbPageContext, b bVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.oV = tbPageContext;
        this.fkH = bVar;
        this.fkP = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.fkT.setTag(this.mBdUniqueId);
        this.fkU.setTag(this.mBdUniqueId);
        this.fkX.setTag(this.mBdUniqueId);
        this.fkW.setTag(this.mBdUniqueId);
        this.fkV.setTag(this.mBdUniqueId);
        this.oV.registerListener(this.fkT);
        this.oV.registerListener(this.fkU);
        this.oV.registerListener(this.fkX);
        this.oV.registerListener(this.fkW);
        this.oV.registerListener(this.fkV);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fkP != null && aVar != null && aVar.getUserData() != null) {
            this.fkR = aVar;
            this.fkQ = aVar.azb();
            this.fkP.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.auD = aVar.getUserData().getPortrait();
        }
    }

    public void aYW() {
        if (this.fkH != null && this.fkP != null) {
            a(this.mHostView, this.fkQ, this.fkP.getMaskType() == 1, this.fkH.aYK());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.fkO = new j(this.oV, this);
        this.fkO.H(z, z2);
        if (i != -1) {
            this.fkO.qg(i);
        }
        if (this.fkR != null && this.fkR.getUserData() != null) {
            this.fkO.setUserName(this.fkR.getUserData().getUserName());
        }
        this.fkO.onChangeSkinType();
        this.fkS = new com.baidu.tieba.person.i(this.oV.getPageActivity(), this.fkO.getView());
        this.fkS.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.fkS, this.oV.getPageActivity());
            if (this.fkO.aXH() != null && view.getId() == this.fkO.aXH().getId()) {
                aYX();
            } else if (this.fkO.aXG() != null && view.getId() == this.fkO.aXG().getId()) {
                if (this.fkQ) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.oV.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.auD, null, false, null)));
            } else if (this.fkO.aXI() != null && view.getId() == this.fkO.aXI().getId()) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    this.oV.showToast(d.l.neterror);
                } else if (this.fkH != null) {
                    if (this.fkH.aYK() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fkH.aYL(), this.fkH.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fkH.getUniqueId();
                        this.fkH.a(false, userMuteAddAndDelCustomMessage, this.fkH.aYL(), this.mUserName);
                    } else if (this.fkH.aYK() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fkH.aYL(), this.fkH.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fkH.getUniqueId();
                        this.fkH.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aYX() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.oV.getPageActivity());
            aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (e.this.mUserId > 0) {
                        if (e.this.fkP.getMaskType() == 1) {
                            e.this.fkP.removeFromBlackList(e.this.mUserId);
                        } else {
                            e.this.fkP.addToBlackList(e.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.fkP.getMaskType() == 1) {
                format = String.format(this.oV.getString(d.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.oV.getString(d.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cT(format);
            aVar.b(this.oV);
            aVar.tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(boolean z) {
        this.fkQ = z;
        if (this.fkR != null) {
            this.fkR.ku(this.fkQ);
        }
        if (this.fkO != null && this.fkP != null) {
            this.fkO.H(this.fkQ, this.fkP.getMaskType() == 1);
        }
    }
}
