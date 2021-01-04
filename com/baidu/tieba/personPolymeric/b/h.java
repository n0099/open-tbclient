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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes8.dex */
public class h implements View.OnClickListener {
    private com.baidu.tieba.person.e eKt;
    protected String fwL;
    private com.baidu.tieba.ueg.a kKO;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;
    protected d mvP;
    private com.baidu.tieba.person.f mwa;
    private BlackListModel mwb;
    protected boolean mwc;
    protected com.baidu.tieba.personPolymeric.c.a mwd;
    private boolean mwe;
    private ak mwf;
    private final com.baidu.adp.framework.listener.c mwg = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.h.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        h.this.mwb.setMaskType(1);
                    } else {
                        h.this.mwb.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (h.this.mwb.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c mwh = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.h.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    h.this.wD(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                h.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener mwi = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                h.this.wD(true);
            }
        }
    };
    private final CustomMessageListener mwj = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    h.this.wD(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    h.this.wD(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mwk = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.h.2
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
        this.mvP = dVar;
        this.mwb = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.kKO = (com.baidu.tieba.ueg.a) runTask.getData();
            this.kKO.w(bdUniqueId);
        }
        registerListener();
        this.mwf = new ak(tbPageContext, this.mBdUniqueId);
        this.mwf.a(new ak.a() { // from class: com.baidu.tieba.personPolymeric.b.h.1
            @Override // com.baidu.tbadk.core.util.ak.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(h.this.mPageContext.getPageActivity(), i == 0 ? h.this.mPageContext.getString(R.string.remove_fans_success) : h.this.mPageContext.getString(R.string.remove_fans_fail));
                    } else {
                        l.showToast(h.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == h.this.mUserId && i == 0) {
                    h.this.mwe = false;
                }
            }
        });
    }

    public void registerListener() {
        this.mwg.setTag(this.mBdUniqueId);
        this.mwh.setTag(this.mBdUniqueId);
        this.mwk.setTag(this.mBdUniqueId);
        this.mwj.setTag(this.mBdUniqueId);
        this.mwi.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.mwg);
        this.mPageContext.registerListener(this.mwh);
        this.mPageContext.registerListener(this.mwk);
        this.mPageContext.registerListener(this.mwj);
        this.mPageContext.registerListener(this.mwi);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.mwb != null && aVar != null && aVar.getUserData() != null) {
            this.mwd = aVar;
            UserData userData = aVar.getUserData();
            this.mwc = aVar.dad();
            this.mwb.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.fwL = userData.getPortrait();
            this.mwe = userData.getIsMyFans() == 1;
        }
    }

    public void dAb() {
        if (this.mvP != null && this.mwb != null) {
            a(this.mwc, this.mwb.getMaskType() == 1, this.mvP.dzR(), this.mwe);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.mwa = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.mwa.m(z, z2, z3);
        if (i != -1) {
            this.mwa.HZ(i);
        }
        if (this.mwd != null && this.mwd.getUserData() != null) {
            if (this.mwd.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.mwd.getUserData().getBaijiahaoInfo().name)) {
                this.mwa.setUserName(this.mwd.getUserData().getBaijiahaoInfo().name);
            } else {
                this.mwa.setUserName(this.mwd.getUserData().getUserName());
            }
        }
        this.mwa.onChangeSkinType();
        this.eKt = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.mwa.getView());
        this.eKt.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.eKt, this.mPageContext.getPageActivity());
            if (this.mwa.dxT() != null && view.getId() == this.mwa.dxT().getId()) {
                dAd();
            } else if (this.mwa.dxS() != null && view.getId() == this.mwa.dxS().getId()) {
                if (this.mwc) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.fwL, null, false, null)));
            } else if (this.mwa.dxU() != null && view.getId() == this.mwa.dxU().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.mvP != null) {
                    if (this.mvP.dzR() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mvP.dzS(), this.mvP.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.mvP.getUniqueId();
                        this.mvP.a(false, userMuteAddAndDelCustomMessage, this.mvP.dzS(), this.mUserName);
                    } else if (this.mvP.dzR() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mvP.dzS(), this.mvP.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.mvP.getUniqueId();
                        this.mvP.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.mwa.dxV() != null && view.getId() == this.mwa.dxV().getId()) {
                if (this.kKO != null) {
                    TiebaStatic.log(new aq("c13063").an("obj_locate", 1));
                    this.kKO.Qm(String.valueOf(this.mUserId));
                }
            } else if (this.mwa.dxW() != null && view.getId() == this.mwa.dxW().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), R.string.neterror);
                } else {
                    dAc();
                }
            }
        }
    }

    private void dAc() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    h.this.mwf.dL(h.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.Bp(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.btX();
        }
    }

    protected void dAd() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (h.this.mUserId > 0) {
                        if (h.this.mwb.getMaskType() == 1) {
                            h.this.mwb.removeFromBlackList(h.this.mUserId);
                        } else {
                            h.this.mwb.addToBlackList(h.this.mUserId);
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
            if (this.mwb.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.Bp(format);
            aVar.b(this.mPageContext);
            aVar.btX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD(boolean z) {
        this.mwc = z;
        if (this.mwd != null) {
            this.mwd.wE(this.mwc);
        }
        if (this.mwa != null && this.mwb != null) {
            this.mwa.m(this.mwc, this.mwb.getMaskType() == 1, this.mwe);
        }
    }
}
