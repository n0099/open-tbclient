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
    protected TbPageContext ako;
    protected String atk;
    protected b fhA;
    private j fhH;
    private BlackListModel fhI;
    protected boolean fhJ;
    protected com.baidu.tieba.personPolymeric.c.a fhK;
    private com.baidu.tieba.person.i fhL;
    private final com.baidu.adp.framework.listener.c fhM = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        e.this.fhI.setMaskType(1);
                    } else {
                        e.this.fhI.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (e.this.fhI.getMaskType() == 1) {
                            e.this.ako.showToast(e.this.ako.getString(d.l.chat_message_blocked));
                            return;
                        } else {
                            e.this.ako.showToast(e.this.ako.getString(d.l.remove_succ));
                            return;
                        }
                    }
                    e.this.ako.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? e.this.ako.getResources().getString(d.l.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fhN = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    e.this.kp(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? e.this.ako.getResources().getString(d.l.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                e.this.ako.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fhO = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                e.this.kp(true);
            }
        }
    };
    private final CustomMessageListener fhP = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    e.this.kp(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    e.this.kp(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fhQ = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                e.this.ako.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? e.this.ako.getResources().getString(d.l.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;

    public e(TbPageContext tbPageContext, b bVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.ako = tbPageContext;
        this.fhA = bVar;
        this.fhI = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.fhM.setTag(this.mBdUniqueId);
        this.fhN.setTag(this.mBdUniqueId);
        this.fhQ.setTag(this.mBdUniqueId);
        this.fhP.setTag(this.mBdUniqueId);
        this.fhO.setTag(this.mBdUniqueId);
        this.ako.registerListener(this.fhM);
        this.ako.registerListener(this.fhN);
        this.ako.registerListener(this.fhQ);
        this.ako.registerListener(this.fhP);
        this.ako.registerListener(this.fhO);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fhI != null && aVar != null && aVar.getUserData() != null) {
            this.fhK = aVar;
            this.fhJ = aVar.ayj();
            this.fhI.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.atk = aVar.getUserData().getPortrait();
        }
    }

    public void aYe() {
        if (this.fhA != null && this.fhI != null) {
            a(this.mHostView, this.fhJ, this.fhI.getMaskType() == 1, this.fhA.aXS());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.fhH = new j(this.ako, this);
        this.fhH.G(z, z2);
        if (i != -1) {
            this.fhH.pX(i);
        }
        if (this.fhK != null && this.fhK.getUserData() != null) {
            this.fhH.setUserName(this.fhK.getUserData().getUserName());
        }
        this.fhH.onChangeSkinType();
        this.fhL = new com.baidu.tieba.person.i(this.ako.getPageActivity(), this.fhH.getView());
        this.fhL.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.fhL, this.ako.getPageActivity());
            if (this.fhH.aWP() != null && view.getId() == this.fhH.aWP().getId()) {
                aYf();
            } else if (this.fhH.aWO() != null && view.getId() == this.fhH.aWO().getId()) {
                if (this.fhJ) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.ako.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.atk, null, false, null)));
            } else if (this.fhH.aWQ() != null && view.getId() == this.fhH.aWQ().getId()) {
                if (!com.baidu.adp.lib.util.i.hh()) {
                    this.ako.showToast(d.l.neterror);
                } else if (this.fhA != null) {
                    if (this.fhA.aXS() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fhA.aXT(), this.fhA.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fhA.getUniqueId();
                        this.fhA.a(false, userMuteAddAndDelCustomMessage, this.fhA.aXT(), this.mUserName);
                    } else if (this.fhA.aXS() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fhA.aXT(), this.fhA.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fhA.getUniqueId();
                        this.fhA.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aYf() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ako.getPageActivity());
            aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (e.this.mUserId > 0) {
                        if (e.this.fhI.getMaskType() == 1) {
                            e.this.fhI.removeFromBlackList(e.this.mUserId);
                        } else {
                            e.this.fhI.addToBlackList(e.this.mUserId);
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
            if (this.fhI.getMaskType() == 1) {
                format = String.format(this.ako.getString(d.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.ako.getString(d.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cN(format);
            aVar.b(this.ako);
            aVar.th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(boolean z) {
        this.fhJ = z;
        if (this.fhK != null) {
            this.fhK.kr(this.fhJ);
        }
        if (this.fhH != null && this.fhI != null) {
            this.fhH.G(this.fhJ, this.fhI.getMaskType() == 1);
        }
    }
}
