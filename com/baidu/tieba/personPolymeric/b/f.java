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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    protected String aFL;
    private com.baidu.tieba.person.e abL;
    private aj fZA;
    private final com.baidu.adp.framework.listener.c fZB = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.fZw.setMaskType(1);
                    } else {
                        f.this.fZw.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.fZw.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.k.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.k.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fZC = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lx(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fZD = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lx(true);
            }
        }
    };
    private final CustomMessageListener fZE = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lx(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lx(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fZF = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c fZm;
    private com.baidu.tieba.person.f fZu;
    private com.baidu.tieba.s.a fZv;
    private BlackListModel fZw;
    protected boolean fZx;
    protected com.baidu.tieba.personPolymeric.c.a fZy;
    private boolean fZz;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fZm = cVar;
        this.fZw = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.s.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.fZv = (com.baidu.tieba.s.a) runTask.getData();
            this.fZv.o(bdUniqueId);
        }
        registerListener();
        this.fZA = new aj(tbPageContext, this.mBdUniqueId);
        this.fZA.a(new aj.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tbadk.core.util.aj.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(d.k.remove_fans_success) : f.this.mPageContext.getString(d.k.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.fZz = false;
                }
            }
        });
    }

    public void registerListener() {
        this.fZB.setTag(this.mBdUniqueId);
        this.fZC.setTag(this.mBdUniqueId);
        this.fZF.setTag(this.mBdUniqueId);
        this.fZE.setTag(this.mBdUniqueId);
        this.fZD.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.fZB);
        this.mPageContext.registerListener(this.fZC);
        this.mPageContext.registerListener(this.fZF);
        this.mPageContext.registerListener(this.fZE);
        this.mPageContext.registerListener(this.fZD);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fZw != null && aVar != null && aVar.getUserData() != null) {
            this.fZy = aVar;
            UserData userData = aVar.getUserData();
            this.fZx = aVar.aMW();
            this.fZw.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aFL = userData.getPortrait();
            this.fZz = userData.getIsMyFans() == 1;
        }
    }

    public void bkO() {
        if (this.fZm != null && this.fZw != null) {
            a(this.mHostView, this.fZx, this.fZw.getMaskType() == 1, this.fZm.bkE(), this.fZz);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.fZu = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.fZu.j(z, z2, z3);
        if (i != -1) {
            this.fZu.rt(i);
        }
        if (this.fZy != null && this.fZy.getUserData() != null) {
            this.fZu.setUserName(this.fZy.getUserData().getUserName());
        }
        this.fZu.onChangeSkinType();
        this.abL = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.fZu.getView());
        this.abL.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.abL, this.mPageContext.getPageActivity());
            if (this.fZu.bje() != null && view.getId() == this.fZu.bje().getId()) {
                bkQ();
            } else if (this.fZu.bjd() != null && view.getId() == this.fZu.bjd().getId()) {
                if (this.fZx) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aFL, null, false, null)));
            } else if (this.fZu.bjf() != null && view.getId() == this.fZu.bjf().getId()) {
                if (!j.jD()) {
                    this.mPageContext.showToast(d.k.neterror);
                } else if (this.fZm != null) {
                    if (this.fZm.bkE() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fZm.bkF(), this.fZm.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fZm.getUniqueId();
                        this.fZm.a(false, userMuteAddAndDelCustomMessage, this.fZm.bkF(), this.mUserName);
                    } else if (this.fZm.bkE() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fZm.bkF(), this.fZm.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fZm.getUniqueId();
                        this.fZm.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.fZu.bjg() != null && view.getId() == this.fZu.bjg().getId()) {
                if (this.fZv != null) {
                    TiebaStatic.log(new an("c13063"));
                    this.fZv.kG(String.valueOf(this.mUserId));
                }
            } else if (this.fZu.bjh() != null && view.getId() == this.fZu.bjh().getId()) {
                if (!j.jD()) {
                    l.showToast(this.mPageContext.getPageActivity(), d.k.neterror);
                } else {
                    bkP();
                }
            }
        }
    }

    private void bkP() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.fZA.s(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dE(String.format(this.mPageContext.getString(d.k.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.xn();
        }
    }

    protected void bkQ() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.fZw.getMaskType() == 1) {
                            f.this.fZw.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.fZw.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.fZw.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.k.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.k.block_chat_message_alert), this.mUserName);
            }
            aVar.dE(format);
            aVar.b(this.mPageContext);
            aVar.xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx(boolean z) {
        this.fZx = z;
        if (this.fZy != null) {
            this.fZy.lz(this.fZx);
        }
        if (this.fZu != null && this.fZw != null) {
            this.fZu.j(this.fZx, this.fZw.getMaskType() == 1, this.fZz);
        }
    }
}
