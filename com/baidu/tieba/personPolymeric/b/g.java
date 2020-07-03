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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes11.dex */
public class g implements View.OnClickListener {
    private com.baidu.tieba.person.e dDL;
    protected String enf;
    private com.baidu.tieba.ueg.a jea;
    private com.baidu.tieba.person.f kME;
    private BlackListModel kMF;
    protected boolean kMG;
    protected com.baidu.tieba.personPolymeric.c.a kMH;
    private boolean kMI;
    private aj kMJ;
    private final com.baidu.adp.framework.listener.c kMK = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        g.this.kMF.setMaskType(1);
                    } else {
                        g.this.kMF.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (g.this.kMF.getMaskType() == 1) {
                            g.this.mPageContext.showToast(g.this.mPageContext.getString(R.string.chat_message_blocked));
                            return;
                        } else {
                            g.this.mPageContext.showToast(g.this.mPageContext.getString(R.string.remove_succ));
                            return;
                        }
                    }
                    g.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c kML = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    g.this.to(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                g.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener kMM = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                g.this.to(true);
            }
        }
    };
    private final CustomMessageListener kMN = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    g.this.to(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    g.this.to(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kMO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                g.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c kMu;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public g(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.kMu = cVar;
        this.kMF = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.jea = (com.baidu.tieba.ueg.a) runTask.getData();
            this.jea.w(bdUniqueId);
        }
        registerListener();
        this.kMJ = new aj(tbPageContext, this.mBdUniqueId);
        this.kMJ.a(new aj.a() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tbadk.core.util.aj.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(g.this.mPageContext.getPageActivity(), i == 0 ? g.this.mPageContext.getString(R.string.remove_fans_success) : g.this.mPageContext.getString(R.string.remove_fans_fail));
                    } else {
                        l.showToast(g.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == g.this.mUserId && i == 0) {
                    g.this.kMI = false;
                }
            }
        });
    }

    public void registerListener() {
        this.kMK.setTag(this.mBdUniqueId);
        this.kML.setTag(this.mBdUniqueId);
        this.kMO.setTag(this.mBdUniqueId);
        this.kMN.setTag(this.mBdUniqueId);
        this.kMM.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.kMK);
        this.mPageContext.registerListener(this.kML);
        this.mPageContext.registerListener(this.kMO);
        this.mPageContext.registerListener(this.kMN);
        this.mPageContext.registerListener(this.kMM);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.kMF != null && aVar != null && aVar.getUserData() != null) {
            this.kMH = aVar;
            UserData userData = aVar.getUserData();
            this.kMG = aVar.ctQ();
            this.kMF.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.enf = userData.getPortrait();
            this.kMI = userData.getIsMyFans() == 1;
        }
    }

    public void cTC() {
        if (this.kMu != null && this.kMF != null) {
            a(this.kMG, this.kMF.getMaskType() == 1, this.kMu.cTs(), this.kMI);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.kME = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.kME.j(z, z2, z3);
        if (i != -1) {
            this.kME.Ck(i);
        }
        if (this.kMH != null && this.kMH.getUserData() != null) {
            if (this.kMH.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.kMH.getUserData().getBaijiahaoInfo().name)) {
                this.kME.setUserName(this.kMH.getUserData().getBaijiahaoInfo().name);
            } else {
                this.kME.setUserName(this.kMH.getUserData().getUserName());
            }
        }
        this.kME.onChangeSkinType();
        this.dDL = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.kME.getView());
        this.dDL.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.dDL, this.mPageContext.getPageActivity());
            if (this.kME.cRA() != null && view.getId() == this.kME.cRA().getId()) {
                cTE();
            } else if (this.kME.cRz() != null && view.getId() == this.kME.cRz().getId()) {
                if (this.kMG) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.enf, null, false, null)));
            } else if (this.kME.cRB() != null && view.getId() == this.kME.cRB().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.kMu != null) {
                    if (this.kMu.cTs() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.kMu.cTt(), this.kMu.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.kMu.getUniqueId();
                        this.kMu.a(false, userMuteAddAndDelCustomMessage, this.kMu.cTt(), this.mUserName);
                    } else if (this.kMu.cTs() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.kMu.cTt(), this.kMu.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.kMu.getUniqueId();
                        this.kMu.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.kME.cRC() != null && view.getId() == this.kME.cRC().getId()) {
                if (this.jea != null) {
                    TiebaStatic.log(new ao("c13063").ag("obj_locate", 1));
                    this.jea.Dv(String.valueOf(this.mUserId));
                }
            } else if (this.kME.cRD() != null && view.getId() == this.kME.cRD().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    cTD();
                }
            }
        }
    }

    private void cTD() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    g.this.kMJ.cf(g.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.we(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.aUN();
        }
    }

    protected void cTE() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (g.this.mUserId > 0) {
                        if (g.this.kMF.getMaskType() == 1) {
                            g.this.kMF.removeFromBlackList(g.this.mUserId);
                        } else {
                            g.this.kMF.addToBlackList(g.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.kMF.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.we(format);
            aVar.b(this.mPageContext);
            aVar.aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(boolean z) {
        this.kMG = z;
        if (this.kMH != null) {
            this.kMH.tp(this.kMG);
        }
        if (this.kME != null && this.kMF != null) {
            this.kME.j(this.kMG, this.kMF.getMaskType() == 1, this.kMI);
        }
    }
}
