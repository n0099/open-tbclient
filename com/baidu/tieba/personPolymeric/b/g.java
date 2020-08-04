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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes18.dex */
public class g implements View.OnClickListener {
    private com.baidu.tieba.person.e dJI;
    protected String ets;
    private com.baidu.tieba.ueg.a jmy;
    private com.baidu.tieba.person.f kVG;
    private BlackListModel kVH;
    protected boolean kVI;
    protected com.baidu.tieba.personPolymeric.c.a kVJ;
    private boolean kVK;
    private ak kVL;
    private final com.baidu.adp.framework.listener.c kVM = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        g.this.kVH.setMaskType(1);
                    } else {
                        g.this.kVH.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (g.this.kVH.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c kVN = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    g.this.tU(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                g.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener kVO = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                g.this.tU(true);
            }
        }
    };
    private final CustomMessageListener kVP = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    g.this.tU(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    g.this.tU(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kVQ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                g.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c kVw;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public g(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.kVw = cVar;
        this.kVH = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.jmy = (com.baidu.tieba.ueg.a) runTask.getData();
            this.jmy.x(bdUniqueId);
        }
        registerListener();
        this.kVL = new ak(tbPageContext, this.mBdUniqueId);
        this.kVL.a(new ak.a() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tbadk.core.util.ak.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(g.this.mPageContext.getPageActivity(), i == 0 ? g.this.mPageContext.getString(R.string.remove_fans_success) : g.this.mPageContext.getString(R.string.remove_fans_fail));
                    } else {
                        l.showToast(g.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == g.this.mUserId && i == 0) {
                    g.this.kVK = false;
                }
            }
        });
    }

    public void registerListener() {
        this.kVM.setTag(this.mBdUniqueId);
        this.kVN.setTag(this.mBdUniqueId);
        this.kVQ.setTag(this.mBdUniqueId);
        this.kVP.setTag(this.mBdUniqueId);
        this.kVO.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.kVM);
        this.mPageContext.registerListener(this.kVN);
        this.mPageContext.registerListener(this.kVQ);
        this.mPageContext.registerListener(this.kVP);
        this.mPageContext.registerListener(this.kVO);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.kVH != null && aVar != null && aVar.getUserData() != null) {
            this.kVJ = aVar;
            UserData userData = aVar.getUserData();
            this.kVI = aVar.cxT();
            this.kVH.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.ets = userData.getPortrait();
            this.kVK = userData.getIsMyFans() == 1;
        }
    }

    public void cXt() {
        if (this.kVw != null && this.kVH != null) {
            a(this.kVI, this.kVH.getMaskType() == 1, this.kVw.cXj(), this.kVK);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.kVG = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.kVG.j(z, z2, z3);
        if (i != -1) {
            this.kVG.CK(i);
        }
        if (this.kVJ != null && this.kVJ.getUserData() != null) {
            if (this.kVJ.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.kVJ.getUserData().getBaijiahaoInfo().name)) {
                this.kVG.setUserName(this.kVJ.getUserData().getBaijiahaoInfo().name);
            } else {
                this.kVG.setUserName(this.kVJ.getUserData().getUserName());
            }
        }
        this.kVG.onChangeSkinType();
        this.dJI = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.kVG.getView());
        this.dJI.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.dJI, this.mPageContext.getPageActivity());
            if (this.kVG.cVr() != null && view.getId() == this.kVG.cVr().getId()) {
                cXv();
            } else if (this.kVG.cVq() != null && view.getId() == this.kVG.cVq().getId()) {
                if (this.kVI) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.ets, null, false, null)));
            } else if (this.kVG.cVs() != null && view.getId() == this.kVG.cVs().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.kVw != null) {
                    if (this.kVw.cXj() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.kVw.cXk(), this.kVw.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.kVw.getUniqueId();
                        this.kVw.a(false, userMuteAddAndDelCustomMessage, this.kVw.cXk(), this.mUserName);
                    } else if (this.kVw.cXj() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.kVw.cXk(), this.kVw.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.kVw.getUniqueId();
                        this.kVw.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.kVG.cVt() != null && view.getId() == this.kVG.cVt().getId()) {
                if (this.jmy != null) {
                    TiebaStatic.log(new ap("c13063").ah("obj_locate", 1));
                    this.jmy.Ld(String.valueOf(this.mUserId));
                }
            } else if (this.kVG.cVu() != null && view.getId() == this.kVG.cVu().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), R.string.neterror);
                } else {
                    cXu();
                }
            }
        }
    }

    private void cXu() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    g.this.kVL.cu(g.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.xl(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.aYL();
        }
    }

    protected void cXv() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (g.this.mUserId > 0) {
                        if (g.this.kVH.getMaskType() == 1) {
                            g.this.kVH.removeFromBlackList(g.this.mUserId);
                        } else {
                            g.this.kVH.addToBlackList(g.this.mUserId);
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
            if (this.kVH.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.xl(format);
            aVar.b(this.mPageContext);
            aVar.aYL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tU(boolean z) {
        this.kVI = z;
        if (this.kVJ != null) {
            this.kVJ.tV(this.kVI);
        }
        if (this.kVG != null && this.kVH != null) {
            this.kVG.j(this.kVI, this.kVH.getMaskType() == 1, this.kVK);
        }
    }
}
