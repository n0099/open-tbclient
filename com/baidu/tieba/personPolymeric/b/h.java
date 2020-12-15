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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes24.dex */
public class h implements View.OnClickListener {
    private com.baidu.tieba.person.e eAQ;
    protected String fnb;
    private com.baidu.tieba.ueg.a kFF;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;
    protected d mqC;
    private com.baidu.tieba.person.f mqM;
    private BlackListModel mqN;
    protected boolean mqO;
    protected com.baidu.tieba.personPolymeric.c.a mqP;
    private boolean mqQ;
    private al mqR;
    private final com.baidu.adp.framework.listener.c mqS = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.h.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        h.this.mqN.setMaskType(1);
                    } else {
                        h.this.mqN.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (h.this.mqN.getMaskType() == 1) {
                            h.this.mPageContext.showToast(h.this.mPageContext.getString(R.string.chat_message_blocked));
                            return;
                        } else {
                            h.this.mPageContext.showToast(h.this.mPageContext.getString(R.string.remove_succ));
                            return;
                        }
                    }
                    h.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c mqT = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.h.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    h.this.wC(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                h.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener mqU = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                h.this.wC(true);
            }
        }
    };
    private final CustomMessageListener mqV = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    h.this.wC(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    h.this.wC(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mqW = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.h.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                h.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };

    public h(TbPageContext tbPageContext, d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mqC = dVar;
        this.mqN = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.kFF = (com.baidu.tieba.ueg.a) runTask.getData();
            this.kFF.w(bdUniqueId);
        }
        registerListener();
        this.mqR = new al(tbPageContext, this.mBdUniqueId);
        this.mqR.a(new al.a() { // from class: com.baidu.tieba.personPolymeric.b.h.1
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(h.this.mPageContext.getPageActivity(), i == 0 ? h.this.mPageContext.getString(R.string.remove_fans_success) : h.this.mPageContext.getString(R.string.remove_fans_fail));
                    } else {
                        l.showToast(h.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == h.this.mUserId && i == 0) {
                    h.this.mqQ = false;
                }
            }
        });
    }

    public void registerListener() {
        this.mqS.setTag(this.mBdUniqueId);
        this.mqT.setTag(this.mBdUniqueId);
        this.mqW.setTag(this.mBdUniqueId);
        this.mqV.setTag(this.mBdUniqueId);
        this.mqU.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.mqS);
        this.mPageContext.registerListener(this.mqT);
        this.mPageContext.registerListener(this.mqW);
        this.mPageContext.registerListener(this.mqV);
        this.mPageContext.registerListener(this.mqU);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.mqN != null && aVar != null && aVar.getUserData() != null) {
            this.mqP = aVar;
            UserData userData = aVar.getUserData();
            this.mqO = aVar.daA();
            this.mqN.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.fnb = userData.getPortrait();
            this.mqQ = userData.getIsMyFans() == 1;
        }
    }

    public void dAm() {
        if (this.mqC != null && this.mqN != null) {
            a(this.mqO, this.mqN.getMaskType() == 1, this.mqC.dAc(), this.mqQ);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.mqM = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.mqM.l(z, z2, z3);
        if (i != -1) {
            this.mqM.Ig(i);
        }
        if (this.mqP != null && this.mqP.getUserData() != null) {
            if (this.mqP.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.mqP.getUserData().getBaijiahaoInfo().name)) {
                this.mqM.setUserName(this.mqP.getUserData().getBaijiahaoInfo().name);
            } else {
                this.mqM.setUserName(this.mqP.getUserData().getUserName());
            }
        }
        this.mqM.onChangeSkinType();
        this.eAQ = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.mqM.getView());
        this.eAQ.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.eAQ, this.mPageContext.getPageActivity());
            if (this.mqM.dye() != null && view.getId() == this.mqM.dye().getId()) {
                dAo();
            } else if (this.mqM.dyd() != null && view.getId() == this.mqM.dyd().getId()) {
                if (this.mqO) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.fnb, null, false, null)));
            } else if (this.mqM.dyf() != null && view.getId() == this.mqM.dyf().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.mqC != null) {
                    if (this.mqC.dAc() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mqC.dAd(), this.mqC.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.mqC.getUniqueId();
                        this.mqC.a(false, userMuteAddAndDelCustomMessage, this.mqC.dAd(), this.mUserName);
                    } else if (this.mqC.dAc() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mqC.dAd(), this.mqC.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.mqC.getUniqueId();
                        this.mqC.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.mqM.dyg() != null && view.getId() == this.mqM.dyg().getId()) {
                if (this.kFF != null) {
                    TiebaStatic.log(new ar("c13063").al("obj_locate", 1));
                    this.kFF.QG(String.valueOf(this.mUserId));
                }
            } else if (this.mqM.dyh() != null && view.getId() == this.mqM.dyh().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    dAn();
                }
            }
        }
    }

    private void dAn() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    h.this.mqR.dL(h.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.Bq(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.brv();
        }
    }

    protected void dAo() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (h.this.mUserId > 0) {
                        if (h.this.mqN.getMaskType() == 1) {
                            h.this.mqN.removeFromBlackList(h.this.mUserId);
                        } else {
                            h.this.mqN.addToBlackList(h.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.mqN.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.Bq(format);
            aVar.b(this.mPageContext);
            aVar.brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC(boolean z) {
        this.mqO = z;
        if (this.mqP != null) {
            this.mqP.wD(this.mqO);
        }
        if (this.mqM != null && this.mqN != null) {
            this.mqM.l(this.mqO, this.mqN.getMaskType() == 1, this.mqQ);
        }
    }
}
