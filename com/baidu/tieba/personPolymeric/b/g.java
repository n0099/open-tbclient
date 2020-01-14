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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes9.dex */
public class g implements View.OnClickListener {
    private com.baidu.tieba.person.e cHd;
    protected String dlu;
    private com.baidu.tieba.ueg.a hJW;
    protected c jmA;
    private com.baidu.tieba.person.f jmK;
    private BlackListModel jmL;
    protected boolean jmM;
    protected com.baidu.tieba.personPolymeric.c.a jmN;
    private boolean jmO;
    private ai jmP;
    private final com.baidu.adp.framework.listener.c jmQ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        g.this.jmL.setMaskType(1);
                    } else {
                        g.this.jmL.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (g.this.jmL.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c jmR = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    g.this.ro(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                g.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener jmS = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                g.this.ro(true);
            }
        }
    };
    private final CustomMessageListener jmT = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    g.this.ro(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    g.this.ro(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jmU = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                g.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public g(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.jmA = cVar;
        this.jmL = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.hJW = (com.baidu.tieba.ueg.a) runTask.getData();
            this.hJW.t(bdUniqueId);
        }
        registerListener();
        this.jmP = new ai(tbPageContext, this.mBdUniqueId);
        this.jmP.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(g.this.mPageContext.getPageActivity(), i == 0 ? g.this.mPageContext.getString(R.string.remove_fans_success) : g.this.mPageContext.getString(R.string.remove_fans_fail));
                    } else {
                        l.showToast(g.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == g.this.mUserId && i == 0) {
                    g.this.jmO = false;
                }
            }
        });
    }

    public void registerListener() {
        this.jmQ.setTag(this.mBdUniqueId);
        this.jmR.setTag(this.mBdUniqueId);
        this.jmU.setTag(this.mBdUniqueId);
        this.jmT.setTag(this.mBdUniqueId);
        this.jmS.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.jmQ);
        this.mPageContext.registerListener(this.jmR);
        this.mPageContext.registerListener(this.jmU);
        this.mPageContext.registerListener(this.jmT);
        this.mPageContext.registerListener(this.jmS);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.jmL != null && aVar != null && aVar.getUserData() != null) {
            this.jmN = aVar;
            UserData userData = aVar.getUserData();
            this.jmM = aVar.bWZ();
            this.jmL.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.dlu = userData.getPortrait();
            this.jmO = userData.getIsMyFans() == 1;
        }
    }

    public void cvy() {
        if (this.jmA != null && this.jmL != null) {
            a(this.jmM, this.jmL.getMaskType() == 1, this.jmA.cvo(), this.jmO);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.jmK = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.jmK.j(z, z2, z3);
        if (i != -1) {
            this.jmK.zF(i);
        }
        if (this.jmN != null && this.jmN.getUserData() != null) {
            if (this.jmN.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.jmN.getUserData().getBaijiahaoInfo().name)) {
                this.jmK.setUserName(this.jmN.getUserData().getBaijiahaoInfo().name);
            } else {
                this.jmK.setUserName(this.jmN.getUserData().getUserName());
            }
        }
        this.jmK.onChangeSkinType();
        this.cHd = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.jmK.getView());
        this.cHd.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.cHd, this.mPageContext.getPageActivity());
            if (this.jmK.ctA() != null && view.getId() == this.jmK.ctA().getId()) {
                cvA();
            } else if (this.jmK.ctz() != null && view.getId() == this.jmK.ctz().getId()) {
                if (this.jmM) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.dlu, null, false, null)));
            } else if (this.jmK.ctB() != null && view.getId() == this.jmK.ctB().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.jmA != null) {
                    if (this.jmA.cvo() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.jmA.cvp(), this.jmA.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.jmA.getUniqueId();
                        this.jmA.a(false, userMuteAddAndDelCustomMessage, this.jmA.cvp(), this.mUserName);
                    } else if (this.jmA.cvo() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.jmA.cvp(), this.jmA.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.jmA.getUniqueId();
                        this.jmA.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.jmK.ctC() != null && view.getId() == this.jmK.ctC().getId()) {
                if (this.hJW != null) {
                    TiebaStatic.log(new an("c13063").Z("obj_locate", 1));
                    this.hJW.zk(String.valueOf(this.mUserId));
                }
            } else if (this.jmK.ctD() != null && view.getId() == this.jmK.ctD().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    cvz();
                }
            }
        }
    }

    private void cvz() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    g.this.jmP.bv(g.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.sC(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.aCp();
        }
    }

    protected void cvA() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (g.this.mUserId > 0) {
                        if (g.this.jmL.getMaskType() == 1) {
                            g.this.jmL.removeFromBlackList(g.this.mUserId);
                        } else {
                            g.this.jmL.addToBlackList(g.this.mUserId);
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
            if (this.jmL.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.sC(format);
            aVar.b(this.mPageContext);
            aVar.aCp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro(boolean z) {
        this.jmM = z;
        if (this.jmN != null) {
            this.jmN.rq(this.jmM);
        }
        if (this.jmK != null && this.jmL != null) {
            this.jmK.j(this.jmM, this.jmL.getMaskType() == 1, this.jmO);
        }
    }
}
