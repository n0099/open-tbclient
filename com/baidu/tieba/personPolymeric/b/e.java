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
    protected String auE;
    protected b fkJ;
    private j fkQ;
    private BlackListModel fkR;
    protected boolean fkS;
    protected com.baidu.tieba.personPolymeric.c.a fkT;
    private com.baidu.tieba.person.i fkU;
    private final com.baidu.adp.framework.listener.c fkV = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        e.this.fkR.setMaskType(1);
                    } else {
                        e.this.fkR.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (e.this.fkR.getMaskType() == 1) {
                            e.this.oW.showToast(e.this.oW.getString(d.l.chat_message_blocked));
                            return;
                        } else {
                            e.this.oW.showToast(e.this.oW.getString(d.l.remove_succ));
                            return;
                        }
                    }
                    e.this.oW.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? e.this.oW.getResources().getString(d.l.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fkW = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.e.4
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
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? e.this.oW.getResources().getString(d.l.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                e.this.oW.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fkX = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                e.this.ks(true);
            }
        }
    };
    private final CustomMessageListener fkY = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.6
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
    private final com.baidu.adp.framework.listener.c fkZ = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                e.this.oW.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? e.this.oW.getResources().getString(d.l.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;
    protected TbPageContext oW;

    public e(TbPageContext tbPageContext, b bVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.oW = tbPageContext;
        this.fkJ = bVar;
        this.fkR = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.fkV.setTag(this.mBdUniqueId);
        this.fkW.setTag(this.mBdUniqueId);
        this.fkZ.setTag(this.mBdUniqueId);
        this.fkY.setTag(this.mBdUniqueId);
        this.fkX.setTag(this.mBdUniqueId);
        this.oW.registerListener(this.fkV);
        this.oW.registerListener(this.fkW);
        this.oW.registerListener(this.fkZ);
        this.oW.registerListener(this.fkY);
        this.oW.registerListener(this.fkX);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fkR != null && aVar != null && aVar.getUserData() != null) {
            this.fkT = aVar;
            this.fkS = aVar.ayW();
            this.fkR.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.auE = aVar.getUserData().getPortrait();
        }
    }

    public void aYR() {
        if (this.fkJ != null && this.fkR != null) {
            a(this.mHostView, this.fkS, this.fkR.getMaskType() == 1, this.fkJ.aYF());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.fkQ = new j(this.oW, this);
        this.fkQ.H(z, z2);
        if (i != -1) {
            this.fkQ.qg(i);
        }
        if (this.fkT != null && this.fkT.getUserData() != null) {
            this.fkQ.setUserName(this.fkT.getUserData().getUserName());
        }
        this.fkQ.onChangeSkinType();
        this.fkU = new com.baidu.tieba.person.i(this.oW.getPageActivity(), this.fkQ.getView());
        this.fkU.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.fkU, this.oW.getPageActivity());
            if (this.fkQ.aXC() != null && view.getId() == this.fkQ.aXC().getId()) {
                aYS();
            } else if (this.fkQ.aXB() != null && view.getId() == this.fkQ.aXB().getId()) {
                if (this.fkS) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.oW.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.auE, null, false, null)));
            } else if (this.fkQ.aXD() != null && view.getId() == this.fkQ.aXD().getId()) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    this.oW.showToast(d.l.neterror);
                } else if (this.fkJ != null) {
                    if (this.fkJ.aYF() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fkJ.aYG(), this.fkJ.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fkJ.getUniqueId();
                        this.fkJ.a(false, userMuteAddAndDelCustomMessage, this.fkJ.aYG(), this.mUserName);
                    } else if (this.fkJ.aYF() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fkJ.aYG(), this.fkJ.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fkJ.getUniqueId();
                        this.fkJ.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aYS() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.oW.getPageActivity());
            aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (e.this.mUserId > 0) {
                        if (e.this.fkR.getMaskType() == 1) {
                            e.this.fkR.removeFromBlackList(e.this.mUserId);
                        } else {
                            e.this.fkR.addToBlackList(e.this.mUserId);
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
            if (this.fkR.getMaskType() == 1) {
                format = String.format(this.oW.getString(d.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.oW.getString(d.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cW(format);
            aVar.b(this.oW);
            aVar.ts();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(boolean z) {
        this.fkS = z;
        if (this.fkT != null) {
            this.fkT.ku(this.fkS);
        }
        if (this.fkQ != null && this.fkR != null) {
            this.fkQ.H(this.fkS, this.fkR.getMaskType() == 1);
        }
    }
}
