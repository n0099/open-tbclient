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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.j;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    protected String aER;
    private com.baidu.tieba.person.e czh;
    protected c fVk;
    private com.baidu.tieba.person.f fVs;
    private com.baidu.tieba.s.a fVt;
    private BlackListModel fVu;
    protected boolean fVv;
    protected com.baidu.tieba.personPolymeric.c.a fVw;
    private boolean fVx;
    private j fVy;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;
    private final com.baidu.adp.framework.listener.c fVz = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.fVu.setMaskType(1);
                    } else {
                        f.this.fVu.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.fVu.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c fVA = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.ln(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fVB = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.ln(true);
            }
        }
    };
    private final CustomMessageListener fVC = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.ln(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.ln(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fVD = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fVk = cVar;
        this.fVu = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.s.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.fVt = (com.baidu.tieba.s.a) runTask.getData();
            this.fVt.o(bdUniqueId);
        }
        registerListener();
        this.fVy = new j(tbPageContext, this.mBdUniqueId);
        this.fVy.a(new j.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.j.a
            public void a(int i, String str, long j, boolean z) {
                if (z) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(d.k.remove_fans_success) : f.this.mPageContext.getString(d.k.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.fVx = false;
                }
            }
        });
    }

    public void registerListener() {
        this.fVz.setTag(this.mBdUniqueId);
        this.fVA.setTag(this.mBdUniqueId);
        this.fVD.setTag(this.mBdUniqueId);
        this.fVC.setTag(this.mBdUniqueId);
        this.fVB.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.fVz);
        this.mPageContext.registerListener(this.fVA);
        this.mPageContext.registerListener(this.fVD);
        this.mPageContext.registerListener(this.fVC);
        this.mPageContext.registerListener(this.fVB);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fVu != null && aVar != null && aVar.getUserData() != null) {
            this.fVw = aVar;
            this.fVv = aVar.aMq();
            this.fVu.setMaskType(aVar.getUserData().isMask() ? 1 : 0);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.aER = aVar.getUserData().getPortrait();
            this.fVx = aVar.getUserData().getIsMyFans() == 1;
        }
    }

    public void bkj() {
        if (this.fVk != null && this.fVu != null) {
            a(this.mHostView, this.fVv, this.fVu.getMaskType() == 1, this.fVk.bjZ(), this.fVx);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.fVs = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.fVs.j(z, z2, z3);
        if (i != -1) {
            this.fVs.rk(i);
        }
        if (this.fVw != null && this.fVw.getUserData() != null) {
            this.fVs.setUserName(this.fVw.getUserData().getUserName());
        }
        this.fVs.onChangeSkinType();
        this.czh = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.fVs.getView());
        this.czh.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.czh, this.mPageContext.getPageActivity());
            if (this.fVs.biy() != null && view.getId() == this.fVs.biy().getId()) {
                bkl();
            } else if (this.fVs.bix() != null && view.getId() == this.fVs.bix().getId()) {
                if (this.fVv) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aER, null, false, null)));
            } else if (this.fVs.biz() != null && view.getId() == this.fVs.biz().getId()) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    this.mPageContext.showToast(d.k.neterror);
                } else if (this.fVk != null) {
                    if (this.fVk.bjZ() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fVk.bka(), this.fVk.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fVk.getUniqueId();
                        this.fVk.a(false, userMuteAddAndDelCustomMessage, this.fVk.bka(), this.mUserName);
                    } else if (this.fVk.bjZ() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fVk.bka(), this.fVk.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fVk.getUniqueId();
                        this.fVk.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.fVs.biA() != null && view.getId() == this.fVs.biA().getId()) {
                if (this.fVt != null) {
                    TiebaStatic.log(new am("c13063"));
                    this.fVt.kC(String.valueOf(this.mUserId));
                }
            } else if (this.fVs.biB() != null && view.getId() == this.fVs.biB().getId()) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    l.showToast(this.mPageContext.getPageActivity(), d.k.neterror);
                } else {
                    bkk();
                }
            }
        }
    }

    private void bkk() {
        if (this.mUserId != 0 && !StringUtils.isNull(this.mUserName)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.fVy.cR(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dB(String.format(this.mPageContext.getString(d.k.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.xa();
        }
    }

    protected void bkl() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.fVu.getMaskType() == 1) {
                            f.this.fVu.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.fVu.addToBlackList(f.this.mUserId);
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
            if (this.fVu.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.k.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.k.block_chat_message_alert), this.mUserName);
            }
            aVar.dB(format);
            aVar.b(this.mPageContext);
            aVar.xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(boolean z) {
        this.fVv = z;
        if (this.fVw != null) {
            this.fVw.lp(this.fVv);
        }
        if (this.fVs != null && this.fVu != null) {
            this.fVs.j(this.fVv, this.fVu.getMaskType() == 1, this.fVx);
        }
    }
}
