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
    protected String aui;
    protected b fjV;
    private j fkd;
    private BlackListModel fke;
    protected boolean fkf;
    protected com.baidu.tieba.personPolymeric.c.a fkg;
    private com.baidu.tieba.person.i fkh;
    private final com.baidu.adp.framework.listener.c fki = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        e.this.fke.setMaskType(1);
                    } else {
                        e.this.fke.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (e.this.fke.getMaskType() == 1) {
                            e.this.mF.showToast(e.this.mF.getString(d.l.chat_message_blocked));
                            return;
                        } else {
                            e.this.mF.showToast(e.this.mF.getString(d.l.remove_succ));
                            return;
                        }
                    }
                    e.this.mF.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? e.this.mF.getResources().getString(d.l.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fkj = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    e.this.kv(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? e.this.mF.getResources().getString(d.l.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                e.this.mF.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fkk = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                e.this.kv(true);
            }
        }
    };
    private final CustomMessageListener fkl = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    e.this.kv(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    e.this.kv(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fkm = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                e.this.mF.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? e.this.mF.getResources().getString(d.l.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mF;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;

    public e(TbPageContext tbPageContext, b bVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mF = tbPageContext;
        this.fjV = bVar;
        this.fke = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.fki.setTag(this.mBdUniqueId);
        this.fkj.setTag(this.mBdUniqueId);
        this.fkm.setTag(this.mBdUniqueId);
        this.fkl.setTag(this.mBdUniqueId);
        this.fkk.setTag(this.mBdUniqueId);
        this.mF.registerListener(this.fki);
        this.mF.registerListener(this.fkj);
        this.mF.registerListener(this.fkm);
        this.mF.registerListener(this.fkl);
        this.mF.registerListener(this.fkk);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fke != null && aVar != null && aVar.getUserData() != null) {
            this.fkg = aVar;
            this.fkf = aVar.aAW();
            this.fke.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.aui = aVar.getUserData().getPortrait();
        }
    }

    public void aYo() {
        if (this.fjV != null && this.fke != null) {
            a(this.mHostView, this.fkf, this.fke.getMaskType() == 1, this.fjV.aYc());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.fkd = new j(this.mF, this);
        this.fkd.I(z, z2);
        if (i != -1) {
            this.fkd.qi(i);
        }
        if (this.fkg != null && this.fkg.getUserData() != null) {
            this.fkd.setUserName(this.fkg.getUserData().getUserName());
        }
        this.fkd.onChangeSkinType();
        this.fkh = new com.baidu.tieba.person.i(this.mF.getPageActivity(), this.fkd.getView());
        this.fkh.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.fkh, this.mF.getPageActivity());
            if (this.fkd.aWZ() != null && view.getId() == this.fkd.aWZ().getId()) {
                aYp();
            } else if (this.fkd.aWY() != null && view.getId() == this.fkd.aWY().getId()) {
                if (this.fkf) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mF.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aui, null, false, null)));
            } else if (this.fkd.aXa() != null && view.getId() == this.fkd.aXa().getId()) {
                if (!com.baidu.adp.lib.util.i.hi()) {
                    this.mF.showToast(d.l.neterror);
                } else if (this.fjV != null) {
                    if (this.fjV.aYc() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fjV.aYd(), this.fjV.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fjV.getUniqueId();
                        this.fjV.a(false, userMuteAddAndDelCustomMessage, this.fjV.aYd(), this.mUserName);
                    } else if (this.fjV.aYc() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fjV.aYd(), this.fjV.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fjV.getUniqueId();
                        this.fjV.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aYp() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mF.getPageActivity());
            aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (e.this.mUserId > 0) {
                        if (e.this.fke.getMaskType() == 1) {
                            e.this.fke.removeFromBlackList(e.this.mUserId);
                        } else {
                            e.this.fke.addToBlackList(e.this.mUserId);
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
            if (this.fke.getMaskType() == 1) {
                format = String.format(this.mF.getString(d.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mF.getString(d.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cM(format);
            aVar.b(this.mF);
            aVar.to();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(boolean z) {
        this.fkf = z;
        if (this.fkg != null) {
            this.fkg.kx(this.fkf);
        }
        if (this.fkd != null && this.fke != null) {
            this.fkd.I(this.fkf, this.fke.getMaskType() == 1);
        }
    }
}
