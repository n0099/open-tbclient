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
/* loaded from: classes7.dex */
public class h implements View.OnClickListener {
    private com.baidu.tieba.person.e eFI;
    protected String fsc;
    private com.baidu.tieba.ueg.a kGj;
    protected BdUniqueId mBdUniqueId;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;
    private final com.baidu.adp.framework.listener.c mrA = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.personPolymeric.b.h.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        h.this.mrv.setMaskType(1);
                    } else {
                        h.this.mrv.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (h.this.mrv.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c mrB = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.personPolymeric.b.h.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    h.this.wz(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                h.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener mrC = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                h.this.wz(true);
            }
        }
    };
    private final CustomMessageListener mrD = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.h.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    h.this.wz(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    h.this.wz(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c mrE = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.personPolymeric.b.h.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                h.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? h.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected d mrj;
    private com.baidu.tieba.person.f mru;
    private BlackListModel mrv;
    protected boolean mrw;
    protected com.baidu.tieba.personPolymeric.c.a mrx;
    private boolean mry;
    private ak mrz;

    public h(TbPageContext tbPageContext, d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mrj = dVar;
        this.mrv = blackListModel;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.kGj = (com.baidu.tieba.ueg.a) runTask.getData();
            this.kGj.w(bdUniqueId);
        }
        registerListener();
        this.mrz = new ak(tbPageContext, this.mBdUniqueId);
        this.mrz.a(new ak.a() { // from class: com.baidu.tieba.personPolymeric.b.h.1
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
                    h.this.mry = false;
                }
            }
        });
    }

    public void registerListener() {
        this.mrA.setTag(this.mBdUniqueId);
        this.mrB.setTag(this.mBdUniqueId);
        this.mrE.setTag(this.mBdUniqueId);
        this.mrD.setTag(this.mBdUniqueId);
        this.mrC.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.mrA);
        this.mPageContext.registerListener(this.mrB);
        this.mPageContext.registerListener(this.mrE);
        this.mPageContext.registerListener(this.mrD);
        this.mPageContext.registerListener(this.mrC);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.mrv != null && aVar != null && aVar.getUserData() != null) {
            this.mrx = aVar;
            UserData userData = aVar.getUserData();
            this.mrw = aVar.cWm();
            this.mrv.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.fsc = userData.getPortrait();
            this.mry = userData.getIsMyFans() == 1;
        }
    }

    public void dwk() {
        if (this.mrj != null && this.mrv != null) {
            a(this.mrw, this.mrv.getMaskType() == 1, this.mrj.dwa(), this.mry);
        }
    }

    private void a(boolean z, boolean z2, int i, boolean z3) {
        this.mru = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.mru.m(z, z2, z3);
        if (i != -1) {
            this.mru.Gt(i);
        }
        if (this.mrx != null && this.mrx.getUserData() != null) {
            if (this.mrx.getUserData().getBaijiahaoInfo() != null && !StringUtils.isNull(this.mrx.getUserData().getBaijiahaoInfo().name)) {
                this.mru.setUserName(this.mrx.getUserData().getBaijiahaoInfo().name);
            } else {
                this.mru.setUserName(this.mrx.getUserData().getUserName());
            }
        }
        this.mru.onChangeSkinType();
        this.eFI = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.mru.getView());
        this.eFI.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.eFI, this.mPageContext.getPageActivity());
            if (this.mru.duc() != null && view.getId() == this.mru.duc().getId()) {
                dwm();
            } else if (this.mru.dub() != null && view.getId() == this.mru.dub().getId()) {
                if (this.mrw) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.fsc, null, false, null)));
            } else if (this.mru.dud() != null && view.getId() == this.mru.dud().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.mrj != null) {
                    if (this.mrj.dwa() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mrj.dwb(), this.mrj.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.mrj.getUniqueId();
                        this.mrj.a(false, userMuteAddAndDelCustomMessage, this.mrj.dwb(), this.mUserName);
                    } else if (this.mrj.dwa() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.mrj.dwb(), this.mrj.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.mrj.getUniqueId();
                        this.mrj.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.mru.due() != null && view.getId() == this.mru.due().getId()) {
                if (this.kGj != null) {
                    TiebaStatic.log(new aq("c13063").an("obj_locate", 1));
                    this.kGj.Pd(String.valueOf(this.mUserId));
                }
            } else if (this.mru.duf() != null && view.getId() == this.mru.duf().getId()) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    l.showToast(this.mPageContext.getPageActivity(), R.string.neterror);
                } else {
                    dwl();
                }
            }
        }
    }

    private void dwl() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    h.this.mrz.dL(h.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.Ad(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.bqe();
        }
    }

    protected void dwm() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (h.this.mUserId > 0) {
                        if (h.this.mrv.getMaskType() == 1) {
                            h.this.mrv.removeFromBlackList(h.this.mUserId);
                        } else {
                            h.this.mrv.addToBlackList(h.this.mUserId);
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
            if (this.mrv.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.Ad(format);
            aVar.b(this.mPageContext);
            aVar.bqe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(boolean z) {
        this.mrw = z;
        if (this.mrx != null) {
            this.mrx.wA(this.mrw);
        }
        if (this.mru != null && this.mrv != null) {
            this.mru.m(this.mrw, this.mrv.getMaskType() == 1, this.mry);
        }
    }
}
