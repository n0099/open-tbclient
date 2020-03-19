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
/* loaded from: classes11.dex */
public class g implements View.OnClickListener {
    private com.baidu.tieba.person.e cLt;
    protected String dqd;
    private com.baidu.tieba.ueg.a hNI;
    protected c jpg;
    private com.baidu.tieba.person.f jpq;
    private BlackListModel jpr;
    protected boolean jps;
    protected com.baidu.tieba.personPolymeric.c.a jpt;
    private boolean jpu;
    private ai jpv;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;
    private final com.baidu.adp.framework.listener.c jpw = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        g.this.jpr.setMaskType(1);
                    } else {
                        g.this.jpr.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (g.this.jpr.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c jpx = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    g.this.ry(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                g.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener jpy = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                g.this.ry(true);
            }
        }
    };
    private final CustomMessageListener jpz = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    g.this.ry(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    g.this.ry(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jpA = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                g.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };

    public g(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.jpg = cVar;
        this.jpr = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.hNI = (com.baidu.tieba.ueg.a) runTask.getData();
            this.hNI.t(bdUniqueId);
        }
        registerListener();
        this.jpv = new ai(tbPageContext, this.mBdUniqueId);
        this.jpv.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.g.1
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
                    g.this.jpu = false;
                }
            }
        });
    }

    public void registerListener() {
        this.jpw.setTag(this.mBdUniqueId);
        this.jpx.setTag(this.mBdUniqueId);
        this.jpA.setTag(this.mBdUniqueId);
        this.jpz.setTag(this.mBdUniqueId);
        this.jpy.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.jpw);
        this.mPageContext.registerListener(this.jpx);
        this.mPageContext.registerListener(this.jpA);
        this.mPageContext.registerListener(this.jpz);
        this.mPageContext.registerListener(this.jpy);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.jpr != null && aVar != null && aVar.getUserData() != null) {
            this.jpt = aVar;
            UserData userData = aVar.getUserData();
            this.jps = aVar.bYV();
            this.jpr.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.dqd = userData.getPortrait();
            this.jpu = userData.getIsMyFans() == 1;
        }
    }

    public void cxn() {
        if (this.jpg != null && this.jpr != null) {
            a(this.jps, this.jpr.getMaskType() == 1, this.jpg.cxd(), this.jpu);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.jpq = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.jpq.j(z, z2, z3);
        if (i != -1) {
            this.jpq.zU(i);
        }
        if (this.jpt != null && this.jpt.getUserData() != null) {
            if (this.jpt.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.jpt.getUserData().getBaijiahaoInfo().name)) {
                this.jpq.setUserName(this.jpt.getUserData().getBaijiahaoInfo().name);
            } else {
                this.jpq.setUserName(this.jpt.getUserData().getUserName());
            }
        }
        this.jpq.onChangeSkinType();
        this.cLt = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.jpq.getView());
        this.cLt.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.cLt, this.mPageContext.getPageActivity());
            if (this.jpq.cvp() != null && view.getId() == this.jpq.cvp().getId()) {
                cxp();
            } else if (this.jpq.cvo() != null && view.getId() == this.jpq.cvo().getId()) {
                if (this.jps) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.dqd, null, false, null)));
            } else if (this.jpq.cvq() != null && view.getId() == this.jpq.cvq().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.jpg != null) {
                    if (this.jpg.cxd() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.jpg.cxe(), this.jpg.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.jpg.getUniqueId();
                        this.jpg.a(false, userMuteAddAndDelCustomMessage, this.jpg.cxe(), this.mUserName);
                    } else if (this.jpg.cxd() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.jpg.cxe(), this.jpg.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.jpg.getUniqueId();
                        this.jpg.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.jpq.cvr() != null && view.getId() == this.jpq.cvr().getId()) {
                if (this.hNI != null) {
                    TiebaStatic.log(new an("c13063").X("obj_locate", 1));
                    this.hNI.zE(String.valueOf(this.mUserId));
                }
            } else if (this.jpq.cvs() != null && view.getId() == this.jpq.cvs().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    cxo();
                }
            }
        }
    }

    private void cxo() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    g.this.jpv.bz(g.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.sS(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.aEG();
        }
    }

    protected void cxp() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (g.this.mUserId > 0) {
                        if (g.this.jpr.getMaskType() == 1) {
                            g.this.jpr.removeFromBlackList(g.this.mUserId);
                        } else {
                            g.this.jpr.addToBlackList(g.this.mUserId);
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
            if (this.jpr.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.sS(format);
            aVar.b(this.mPageContext);
            aVar.aEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry(boolean z) {
        this.jps = z;
        if (this.jpt != null) {
            this.jpt.rz(this.jps);
        }
        if (this.jpq != null && this.jpr != null) {
            this.jpq.j(this.jps, this.jpr.getMaskType() == 1, this.jpu);
        }
    }
}
