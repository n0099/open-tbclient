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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes18.dex */
public class h implements View.OnClickListener {
    private com.baidu.tieba.person.e dSQ;
    protected String eDP;
    private com.baidu.tieba.ueg.a jBw;
    protected com.baidu.tieba.personPolymeric.c.a llA;
    private boolean llB;
    private al llC;
    private final com.baidu.adp.framework.listener.c llD = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.h.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        h.this.lly.setMaskType(1);
                    } else {
                        h.this.lly.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (h.this.lly.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c llE = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.h.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    h.this.uE(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                h.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener llF = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                h.this.uE(true);
            }
        }
    };
    private final CustomMessageListener llG = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    h.this.uE(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    h.this.uE(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c llH = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.h.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                h.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected d lln;
    private com.baidu.tieba.person.f llx;
    private BlackListModel lly;
    protected boolean llz;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public h(TbPageContext tbPageContext, d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.lln = dVar;
        this.lly = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.jBw = (com.baidu.tieba.ueg.a) runTask.getData();
            this.jBw.x(bdUniqueId);
        }
        registerListener();
        this.llC = new al(tbPageContext, this.mBdUniqueId);
        this.llC.a(new al.a() { // from class: com.baidu.tieba.personPolymeric.b.h.1
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
                    h.this.llB = false;
                }
            }
        });
    }

    public void registerListener() {
        this.llD.setTag(this.mBdUniqueId);
        this.llE.setTag(this.mBdUniqueId);
        this.llH.setTag(this.mBdUniqueId);
        this.llG.setTag(this.mBdUniqueId);
        this.llF.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.llD);
        this.mPageContext.registerListener(this.llE);
        this.mPageContext.registerListener(this.llH);
        this.mPageContext.registerListener(this.llG);
        this.mPageContext.registerListener(this.llF);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.lly != null && aVar != null && aVar.getUserData() != null) {
            this.llA = aVar;
            UserData userData = aVar.getUserData();
            this.llz = aVar.cIK();
            this.lly.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.eDP = userData.getPortrait();
            this.llB = userData.getIsMyFans() == 1;
        }
    }

    public void dis() {
        if (this.lln != null && this.lly != null) {
            a(this.llz, this.lly.getMaskType() == 1, this.lln.dii(), this.llB);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.llx = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.llx.k(z, z2, z3);
        if (i != -1) {
            this.llx.Fe(i);
        }
        if (this.llA != null && this.llA.getUserData() != null) {
            if (this.llA.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.llA.getUserData().getBaijiahaoInfo().name)) {
                this.llx.setUserName(this.llA.getUserData().getBaijiahaoInfo().name);
            } else {
                this.llx.setUserName(this.llA.getUserData().getUserName());
            }
        }
        this.llx.onChangeSkinType();
        this.dSQ = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.llx.getView());
        this.dSQ.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.dSQ, this.mPageContext.getPageActivity());
            if (this.llx.dgo() != null && view.getId() == this.llx.dgo().getId()) {
                diu();
            } else if (this.llx.dgn() != null && view.getId() == this.llx.dgn().getId()) {
                if (this.llz) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.eDP, null, false, null)));
            } else if (this.llx.dgp() != null && view.getId() == this.llx.dgp().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.lln != null) {
                    if (this.lln.dii() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.lln.dij(), this.lln.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.lln.getUniqueId();
                        this.lln.a(false, userMuteAddAndDelCustomMessage, this.lln.dij(), this.mUserName);
                    } else if (this.lln.dii() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.lln.dij(), this.lln.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.lln.getUniqueId();
                        this.lln.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.llx.dgq() != null && view.getId() == this.llx.dgq().getId()) {
                if (this.jBw != null) {
                    TiebaStatic.log(new aq("c13063").ai("obj_locate", 1));
                    this.jBw.NW(String.valueOf(this.mUserId));
                }
            } else if (this.llx.dgr() != null && view.getId() == this.llx.dgr().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), R.string.neterror);
                } else {
                    dit();
                }
            }
        }
    }

    private void dit() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    h.this.llC.cF(h.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.zz(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.bhg();
        }
    }

    protected void diu() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (h.this.mUserId > 0) {
                        if (h.this.lly.getMaskType() == 1) {
                            h.this.lly.removeFromBlackList(h.this.mUserId);
                        } else {
                            h.this.lly.addToBlackList(h.this.mUserId);
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
            if (this.lly.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.zz(format);
            aVar.b(this.mPageContext);
            aVar.bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(boolean z) {
        this.llz = z;
        if (this.llA != null) {
            this.llA.uF(this.llz);
        }
        if (this.llx != null && this.lly != null) {
            this.llx.k(this.llz, this.lly.getMaskType() == 1, this.llB);
        }
    }
}
