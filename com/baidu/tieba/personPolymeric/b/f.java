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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes6.dex */
public class f implements View.OnClickListener {
    private com.baidu.tieba.person.e bVq;
    protected String cyj;
    private com.baidu.tieba.ueg.a gTh;
    protected c irf;
    private com.baidu.tieba.person.f irn;
    private BlackListModel iro;
    protected boolean irp;
    protected com.baidu.tieba.personPolymeric.c.a irq;
    private boolean irr;
    private ai irs;
    private final com.baidu.adp.framework.listener.c irt = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.iro.setMaskType(1);
                    } else {
                        f.this.iro.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.iro.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(R.string.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(R.string.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c iru = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.pA(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener irv = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.pA(true);
            }
        }
    };
    private final CustomMessageListener irw = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.pA(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.pA(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c irx = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
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
        this.irf = cVar;
        this.iro = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.gTh = (com.baidu.tieba.ueg.a) runTask.getData();
            this.gTh.s(bdUniqueId);
        }
        registerListener();
        this.irs = new ai(tbPageContext, this.mBdUniqueId);
        this.irs.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(R.string.remove_fans_success) : f.this.mPageContext.getString(R.string.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.irr = false;
                }
            }
        });
    }

    public void registerListener() {
        this.irt.setTag(this.mBdUniqueId);
        this.iru.setTag(this.mBdUniqueId);
        this.irx.setTag(this.mBdUniqueId);
        this.irw.setTag(this.mBdUniqueId);
        this.irv.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.irt);
        this.mPageContext.registerListener(this.iru);
        this.mPageContext.registerListener(this.irx);
        this.mPageContext.registerListener(this.irw);
        this.mPageContext.registerListener(this.irv);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.iro != null && aVar != null && aVar.getUserData() != null) {
            this.irq = aVar;
            UserData userData = aVar.getUserData();
            this.irp = aVar.bEG();
            this.iro.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.cyj = userData.getPortrait();
            this.irr = userData.getIsMyFans() == 1;
        }
    }

    public void caU() {
        if (this.irf != null && this.iro != null) {
            a(this.mHostView, this.irp, this.iro.getMaskType() == 1, this.irf.caJ(), this.irr);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.irn = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.irn.j(z, z2, z3);
        if (i != -1) {
            this.irn.xp(i);
        }
        if (this.irq != null && this.irq.getUserData() != null) {
            this.irn.setUserName(this.irq.getUserData().getUserName());
        }
        this.irn.onChangeSkinType();
        this.bVq = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.irn.getView());
        this.bVq.show();
    }

    public void anO() {
        if (this.irn != null) {
            this.irn.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.dismissDialog(this.bVq, this.mPageContext.getPageActivity());
            if (this.irn.bZa() != null && view.getId() == this.irn.bZa().getId()) {
                caW();
            } else if (this.irn.bYZ() != null && view.getId() == this.irn.bYZ().getId()) {
                if (this.irp) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.cyj, null, false, null)));
            } else if (this.irn.bZb() != null && view.getId() == this.irn.bZb().getId()) {
                if (!j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.irf != null) {
                    if (this.irf.caJ() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.irf.caK(), this.irf.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.irf.getUniqueId();
                        this.irf.a(false, userMuteAddAndDelCustomMessage, this.irf.caK(), this.mUserName);
                    } else if (this.irf.caJ() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.irf.caK(), this.irf.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.irf.getUniqueId();
                        this.irf.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.irn.bZc() != null && view.getId() == this.irn.bZc().getId()) {
                if (this.gTh != null) {
                    TiebaStatic.log(new an("c13063").O("obj_locate", 1));
                    this.gTh.ui(String.valueOf(this.mUserId));
                }
            } else if (this.irn.bZd() != null && view.getId() == this.irn.bZd().getId()) {
                if (!j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    caV();
                }
            }
        }
    }

    private void caV() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.irs.aO(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.nn(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.akO();
        }
    }

    protected void caW() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.iro.getMaskType() == 1) {
                            f.this.iro.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.iro.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.iro.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.nn(format);
            aVar.b(this.mPageContext);
            aVar.akO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        this.irp = z;
        if (this.irq != null) {
            this.irq.pC(this.irp);
        }
        if (this.irn != null && this.iro != null) {
            this.irn.j(this.irp, this.iro.getMaskType() == 1, this.irr);
        }
    }
}
