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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.e;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    protected String aIY;
    private com.baidu.tieba.person.e adS;
    private com.baidu.tieba.ueg.a eLH;
    protected c ggV;
    private com.baidu.tieba.person.f ghd;
    private BlackListModel ghe;
    protected boolean ghf;
    protected com.baidu.tieba.personPolymeric.c.a ghg;
    private boolean ghh;
    private ai ghi;
    private final com.baidu.adp.framework.listener.c ghj = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.ghe.setMaskType(1);
                    } else {
                        f.this.ghe.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.ghe.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(e.j.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(e.j.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c ghk = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lF(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener ghl = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lF(true);
            }
        }
    };
    private final CustomMessageListener ghm = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lF(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lF(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c ghn = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.ggV = cVar;
        this.ghe = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.eLH = (com.baidu.tieba.ueg.a) runTask.getData();
            this.eLH.o(bdUniqueId);
        }
        registerListener();
        this.ghi = new ai(tbPageContext, this.mBdUniqueId);
        this.ghi.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(e.j.remove_fans_success) : f.this.mPageContext.getString(e.j.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.ghh = false;
                }
            }
        });
    }

    public void registerListener() {
        this.ghj.setTag(this.mBdUniqueId);
        this.ghk.setTag(this.mBdUniqueId);
        this.ghn.setTag(this.mBdUniqueId);
        this.ghm.setTag(this.mBdUniqueId);
        this.ghl.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.ghj);
        this.mPageContext.registerListener(this.ghk);
        this.mPageContext.registerListener(this.ghn);
        this.mPageContext.registerListener(this.ghm);
        this.mPageContext.registerListener(this.ghl);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.ghe != null && aVar != null && aVar.getUserData() != null) {
            this.ghg = aVar;
            UserData userData = aVar.getUserData();
            this.ghf = aVar.aQi();
            this.ghe.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aIY = userData.getPortrait();
            this.ghh = userData.getIsMyFans() == 1;
        }
    }

    public void blG() {
        if (this.ggV != null && this.ghe != null) {
            a(this.mHostView, this.ghf, this.ghe.getMaskType() == 1, this.ggV.blw(), this.ghh);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.ghd = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.ghd.i(z, z2, z3);
        if (i != -1) {
            this.ghd.rN(i);
        }
        if (this.ghg != null && this.ghg.getUserData() != null) {
            this.ghd.setUserName(this.ghg.getUserData().getUserName());
        }
        this.ghd.onChangeSkinType();
        this.adS = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.ghd.getView());
        this.adS.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.adS, this.mPageContext.getPageActivity());
            if (this.ghd.bjT() != null && view.getId() == this.ghd.bjT().getId()) {
                blI();
            } else if (this.ghd.bjS() != null && view.getId() == this.ghd.bjS().getId()) {
                if (this.ghf) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aIY, null, false, null)));
            } else if (this.ghd.bjU() != null && view.getId() == this.ghd.bjU().getId()) {
                if (!j.kK()) {
                    this.mPageContext.showToast(e.j.neterror);
                } else if (this.ggV != null) {
                    if (this.ggV.blw() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ggV.blx(), this.ggV.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.ggV.getUniqueId();
                        this.ggV.a(false, userMuteAddAndDelCustomMessage, this.ggV.blx(), this.mUserName);
                    } else if (this.ggV.blw() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ggV.blx(), this.ggV.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.ggV.getUniqueId();
                        this.ggV.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.ghd.bjV() != null && view.getId() == this.ghd.bjV().getId()) {
                if (this.eLH != null) {
                    TiebaStatic.log(new am("c13063").w("obj_locate", 1));
                    this.eLH.lg(String.valueOf(this.mUserId));
                }
            } else if (this.ghd.bjW() != null && view.getId() == this.ghd.bjW().getId()) {
                if (!j.kK()) {
                    l.showToast(this.mPageContext.getPageActivity(), e.j.neterror);
                } else {
                    blH();
                }
            }
        }
    }

    private void blH() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.ghi.w(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dT(String.format(this.mPageContext.getString(e.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.yl();
        }
    }

    protected void blI() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.ghe.getMaskType() == 1) {
                            f.this.ghe.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.ghe.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.ghe.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(e.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(e.j.block_chat_message_alert), this.mUserName);
            }
            aVar.dT(format);
            aVar.b(this.mPageContext);
            aVar.yl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        this.ghf = z;
        if (this.ghg != null) {
            this.ghg.lH(this.ghf);
        }
        if (this.ghd != null && this.ghe != null) {
            this.ghd.i(this.ghf, this.ghe.getMaskType() == 1, this.ghh);
        }
    }
}
