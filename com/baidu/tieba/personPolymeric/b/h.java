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
    private com.baidu.tieba.ueg.a kFD;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;
    protected d mqA;
    private com.baidu.tieba.person.f mqK;
    private BlackListModel mqL;
    protected boolean mqM;
    protected com.baidu.tieba.personPolymeric.c.a mqN;
    private boolean mqO;
    private al mqP;
    private final com.baidu.adp.framework.listener.c mqQ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.h.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        h.this.mqL.setMaskType(1);
                    } else {
                        h.this.mqL.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (h.this.mqL.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c mqR = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.h.8
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
    final CustomMessageListener mqS = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                h.this.wC(true);
            }
        }
    };
    private final CustomMessageListener mqT = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.10
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
    private final com.baidu.adp.framework.listener.c mqU = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.h.2
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
        this.mqA = dVar;
        this.mqL = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.kFD = (com.baidu.tieba.ueg.a) runTask.getData();
            this.kFD.w(bdUniqueId);
        }
        registerListener();
        this.mqP = new al(tbPageContext, this.mBdUniqueId);
        this.mqP.a(new al.a() { // from class: com.baidu.tieba.personPolymeric.b.h.1
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
                    h.this.mqO = false;
                }
            }
        });
    }

    public void registerListener() {
        this.mqQ.setTag(this.mBdUniqueId);
        this.mqR.setTag(this.mBdUniqueId);
        this.mqU.setTag(this.mBdUniqueId);
        this.mqT.setTag(this.mBdUniqueId);
        this.mqS.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.mqQ);
        this.mPageContext.registerListener(this.mqR);
        this.mPageContext.registerListener(this.mqU);
        this.mPageContext.registerListener(this.mqT);
        this.mPageContext.registerListener(this.mqS);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.mqL != null && aVar != null && aVar.getUserData() != null) {
            this.mqN = aVar;
            UserData userData = aVar.getUserData();
            this.mqM = aVar.daz();
            this.mqL.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.fnb = userData.getPortrait();
            this.mqO = userData.getIsMyFans() == 1;
        }
    }

    public void dAl() {
        if (this.mqA != null && this.mqL != null) {
            a(this.mqM, this.mqL.getMaskType() == 1, this.mqA.dAb(), this.mqO);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.mqK = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.mqK.l(z, z2, z3);
        if (i != -1) {
            this.mqK.Ig(i);
        }
        if (this.mqN != null && this.mqN.getUserData() != null) {
            if (this.mqN.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.mqN.getUserData().getBaijiahaoInfo().name)) {
                this.mqK.setUserName(this.mqN.getUserData().getBaijiahaoInfo().name);
            } else {
                this.mqK.setUserName(this.mqN.getUserData().getUserName());
            }
        }
        this.mqK.onChangeSkinType();
        this.eAQ = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.mqK.getView());
        this.eAQ.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.eAQ, this.mPageContext.getPageActivity());
            if (this.mqK.dyd() != null && view.getId() == this.mqK.dyd().getId()) {
                dAn();
            } else if (this.mqK.dyc() != null && view.getId() == this.mqK.dyc().getId()) {
                if (this.mqM) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.fnb, null, false, null)));
            } else if (this.mqK.dye() != null && view.getId() == this.mqK.dye().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.mqA != null) {
                    if (this.mqA.dAb() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mqA.dAc(), this.mqA.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.mqA.getUniqueId();
                        this.mqA.a(false, userMuteAddAndDelCustomMessage, this.mqA.dAc(), this.mUserName);
                    } else if (this.mqA.dAb() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mqA.dAc(), this.mqA.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.mqA.getUniqueId();
                        this.mqA.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.mqK.dyf() != null && view.getId() == this.mqK.dyf().getId()) {
                if (this.kFD != null) {
                    TiebaStatic.log(new ar("c13063").al("obj_locate", 1));
                    this.kFD.QG(String.valueOf(this.mUserId));
                }
            } else if (this.mqK.dyg() != null && view.getId() == this.mqK.dyg().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    dAm();
                }
            }
        }
    }

    private void dAm() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    h.this.mqP.dL(h.this.mUserId);
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

    protected void dAn() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (h.this.mUserId > 0) {
                        if (h.this.mqL.getMaskType() == 1) {
                            h.this.mqL.removeFromBlackList(h.this.mUserId);
                        } else {
                            h.this.mqL.addToBlackList(h.this.mUserId);
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
            if (this.mqL.getMaskType() == 1) {
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
        this.mqM = z;
        if (this.mqN != null) {
            this.mqN.wD(this.mqM);
        }
        if (this.mqK != null && this.mqL != null) {
            this.mqK.l(this.mqM, this.mqL.getMaskType() == 1, this.mqO);
        }
    }
}
