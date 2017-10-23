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
    protected String ate;
    protected c ffh;
    private com.baidu.tieba.person.f ffp;
    private BlackListModel ffq;
    protected boolean ffr;
    protected com.baidu.tieba.personPolymeric.c.a ffs;
    private com.baidu.tieba.person.e fft;
    private final com.baidu.adp.framework.listener.c ffu = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.ffq.setMaskType(1);
                    } else {
                        f.this.ffq.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.ffq.getMaskType() == 1) {
                            f.this.mH.showToast(f.this.mH.getString(d.l.chat_message_blocked));
                            return;
                        } else {
                            f.this.mH.showToast(f.this.mH.getString(d.l.remove_succ));
                            return;
                        }
                    }
                    f.this.mH.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mH.getResources().getString(d.l.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c ffv = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.4
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
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mH.getResources().getString(d.l.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mH.showToast(errorString);
            }
        }
    };
    final CustomMessageListener ffw = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.kl(true);
            }
        }
    };
    private final CustomMessageListener ffx = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.6
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
    private final com.baidu.adp.framework.listener.c ffy = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mH.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mH.getResources().getString(d.l.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mH;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mH = tbPageContext;
        this.ffh = cVar;
        this.ffq = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.ffu.setTag(this.mBdUniqueId);
        this.ffv.setTag(this.mBdUniqueId);
        this.ffy.setTag(this.mBdUniqueId);
        this.ffx.setTag(this.mBdUniqueId);
        this.ffw.setTag(this.mBdUniqueId);
        this.mH.registerListener(this.ffu);
        this.mH.registerListener(this.ffv);
        this.mH.registerListener(this.ffy);
        this.mH.registerListener(this.ffx);
        this.mH.registerListener(this.ffw);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.ffq != null && aVar != null && aVar.getUserData() != null) {
            this.ffs = aVar;
            this.ffr = aVar.azC();
            this.ffq.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.ate = aVar.getUserData().getPortrait();
        }
    }

    public void aWF() {
        if (this.ffh != null && this.ffq != null) {
            a(this.mHostView, this.ffr, this.ffq.getMaskType() == 1, this.ffh.aWv());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.ffp = new com.baidu.tieba.person.f(this.mH, this);
        this.ffp.J(z, z2);
        if (i != -1) {
            this.ffp.qc(i);
        }
        if (this.ffs != null && this.ffs.getUserData() != null) {
            this.ffp.setUserName(this.ffs.getUserData().getUserName());
        }
        this.ffp.onChangeSkinType();
        this.fft = new com.baidu.tieba.person.e(this.mH.getPageActivity(), this.ffp.getView());
        this.fft.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.fft, this.mH.getPageActivity());
            if (this.ffp.aVc() != null && view.getId() == this.ffp.aVc().getId()) {
                aWG();
            } else if (this.ffp.aVb() != null && view.getId() == this.ffp.aVb().getId()) {
                if (this.ffr) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mH.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.ate, null, false, null)));
            } else if (this.ffp.aVd() != null && view.getId() == this.ffp.aVd().getId()) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    this.mH.showToast(d.l.neterror);
                } else if (this.ffh != null) {
                    if (this.ffh.aWv() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ffh.aWw(), this.ffh.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.ffh.getUniqueId();
                        this.ffh.a(false, userMuteAddAndDelCustomMessage, this.ffh.aWw(), this.mUserName);
                    } else if (this.ffh.aWv() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ffh.aWw(), this.ffh.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.ffh.getUniqueId();
                        this.ffh.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aWG() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mH.getPageActivity());
            aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.ffq.getMaskType() == 1) {
                            f.this.ffq.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.ffq.addToBlackList(f.this.mUserId);
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
            if (this.ffq.getMaskType() == 1) {
                format = String.format(this.mH.getString(d.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mH.getString(d.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cL(format);
            aVar.b(this.mH);
            aVar.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kl(boolean z) {
        this.ffr = z;
        if (this.ffs != null) {
            this.ffs.kn(this.ffr);
        }
        if (this.ffp != null && this.ffq != null) {
            this.ffp.J(this.ffr, this.ffq.getMaskType() == 1);
        }
    }
}
