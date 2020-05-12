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
    protected String dQb;
    private com.baidu.tieba.person.e dkF;
    private com.baidu.tieba.ueg.a ixF;
    private com.baidu.tieba.person.f jZI;
    private BlackListModel jZJ;
    protected boolean jZK;
    protected com.baidu.tieba.personPolymeric.c.a jZL;
    private boolean jZM;
    private ai jZN;
    private final com.baidu.adp.framework.listener.c jZO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        g.this.jZJ.setMaskType(1);
                    } else {
                        g.this.jZJ.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (g.this.jZJ.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c jZP = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    g.this.sC(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                g.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener jZQ = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                g.this.sC(true);
            }
        }
    };
    private final CustomMessageListener jZR = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.g.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    g.this.sC(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    g.this.sC(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jZS = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                g.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? g.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c jZy;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public g(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.jZy = cVar;
        this.jZJ = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.ixF = (com.baidu.tieba.ueg.a) runTask.getData();
            this.ixF.t(bdUniqueId);
        }
        registerListener();
        this.jZN = new ai(tbPageContext, this.mBdUniqueId);
        this.jZN.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.g.1
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
                    g.this.jZM = false;
                }
            }
        });
    }

    public void registerListener() {
        this.jZO.setTag(this.mBdUniqueId);
        this.jZP.setTag(this.mBdUniqueId);
        this.jZS.setTag(this.mBdUniqueId);
        this.jZR.setTag(this.mBdUniqueId);
        this.jZQ.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.jZO);
        this.mPageContext.registerListener(this.jZP);
        this.mPageContext.registerListener(this.jZS);
        this.mPageContext.registerListener(this.jZR);
        this.mPageContext.registerListener(this.jZQ);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.jZJ != null && aVar != null && aVar.getUserData() != null) {
            this.jZL = aVar;
            UserData userData = aVar.getUserData();
            this.jZK = aVar.cjv();
            this.jZJ.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.dQb = userData.getPortrait();
            this.jZM = userData.getIsMyFans() == 1;
        }
    }

    public void cHW() {
        if (this.jZy != null && this.jZJ != null) {
            a(this.jZK, this.jZJ.getMaskType() == 1, this.jZy.cHM(), this.jZM);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.jZI = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.jZI.j(z, z2, z3);
        if (i != -1) {
            this.jZI.Av(i);
        }
        if (this.jZL != null && this.jZL.getUserData() != null) {
            if (this.jZL.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.jZL.getUserData().getBaijiahaoInfo().name)) {
                this.jZI.setUserName(this.jZL.getUserData().getBaijiahaoInfo().name);
            } else {
                this.jZI.setUserName(this.jZL.getUserData().getUserName());
            }
        }
        this.jZI.onChangeSkinType();
        this.dkF = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.jZI.getView());
        this.dkF.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.dkF, this.mPageContext.getPageActivity());
            if (this.jZI.cFU() != null && view.getId() == this.jZI.cFU().getId()) {
                cHY();
            } else if (this.jZI.cFT() != null && view.getId() == this.jZI.cFT().getId()) {
                if (this.jZK) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.dQb, null, false, null)));
            } else if (this.jZI.cFV() != null && view.getId() == this.jZI.cFV().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.jZy != null) {
                    if (this.jZy.cHM() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.jZy.cHN(), this.jZy.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.jZy.getUniqueId();
                        this.jZy.a(false, userMuteAddAndDelCustomMessage, this.jZy.cHN(), this.mUserName);
                    } else if (this.jZy.cHM() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.jZy.cHN(), this.jZy.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.jZy.getUniqueId();
                        this.jZy.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.jZI.cFW() != null && view.getId() == this.jZI.cFW().getId()) {
                if (this.ixF != null) {
                    TiebaStatic.log(new an("c13063").af("obj_locate", 1));
                    this.ixF.Bm(String.valueOf(this.mUserId));
                }
            } else if (this.jZI.cFX() != null && view.getId() == this.jZI.cFX().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    cHX();
                }
            }
        }
    }

    private void cHX() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    g.this.jZN.ce(g.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ui(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.aMS();
        }
    }

    protected void cHY() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (g.this.mUserId > 0) {
                        if (g.this.jZJ.getMaskType() == 1) {
                            g.this.jZJ.removeFromBlackList(g.this.mUserId);
                        } else {
                            g.this.jZJ.addToBlackList(g.this.mUserId);
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
            if (this.jZJ.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.ui(format);
            aVar.b(this.mPageContext);
            aVar.aMS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(boolean z) {
        this.jZK = z;
        if (this.jZL != null) {
            this.jZL.sD(this.jZK);
        }
        if (this.jZI != null && this.jZJ != null) {
            this.jZI.j(this.jZK, this.jZJ.getMaskType() == 1, this.jZM);
        }
    }
}
