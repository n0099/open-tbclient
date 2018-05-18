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
    protected String awG;
    private com.baidu.tieba.person.e cqE;
    protected c fJP;
    private com.baidu.tieba.person.f fJX;
    private k fJY;
    private BlackListModel fJZ;
    protected boolean fKa;
    protected com.baidu.tieba.personPolymeric.c.a fKb;
    private boolean fKc;
    private j fKd;
    private final com.baidu.adp.framework.listener.c fKe = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.fJZ.setMaskType(1);
                    } else {
                        f.this.fJZ.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.fJZ.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c fKf = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lh(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fKg = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lh(true);
            }
        }
    };
    private final CustomMessageListener fKh = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lh(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lh(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fKi = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fJP = cVar;
        this.fJZ = blackListModel;
        this.mHostView = view2;
        this.mBdUniqueId = bdUniqueId;
        this.fJY = new k(tbPageContext, bdUniqueId);
        registerListener();
        this.fKd = new j(tbPageContext, this.mBdUniqueId);
        this.fKd.a(new j.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.fKc = false;
                }
            }
        });
    }

    public void registerListener() {
        this.fKe.setTag(this.mBdUniqueId);
        this.fKf.setTag(this.mBdUniqueId);
        this.fKi.setTag(this.mBdUniqueId);
        this.fKh.setTag(this.mBdUniqueId);
        this.fKg.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.fKe);
        this.mPageContext.registerListener(this.fKf);
        this.mPageContext.registerListener(this.fKi);
        this.mPageContext.registerListener(this.fKh);
        this.mPageContext.registerListener(this.fKg);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fJZ != null && aVar != null && aVar.getUserData() != null) {
            this.fKb = aVar;
            this.fKa = aVar.aHv();
            this.fJZ.setMaskType(aVar.getUserData().isMask() ? 1 : 0);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.awG = aVar.getUserData().getPortrait();
            this.fKc = aVar.getUserData().getIsMyFans() == 1;
        }
    }

    public void bfj() {
        if (this.fJP != null && this.fJZ != null) {
            a(this.mHostView, this.fKa, this.fJZ.getMaskType() == 1, this.fJP.beZ(), this.fKc);
        }
    }

    public void a(View view2, boolean z, boolean z2, int i, boolean z3) {
        this.fJX = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.fJX.j(z, z2, z3);
        if (i != -1) {
            this.fJX.qY(i);
        }
        if (this.fKb != null && this.fKb.getUserData() != null) {
            this.fJX.setUserName(this.fKb.getUserData().getUserName());
        }
        this.fJX.onChangeSkinType();
        this.cqE = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.fJX.getView());
        this.cqE.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            com.baidu.adp.lib.g.g.b(this.cqE, this.mPageContext.getPageActivity());
            if (this.fJX.bdy() != null && view2.getId() == this.fJX.bdy().getId()) {
                bfl();
            } else if (this.fJX.bdx() != null && view2.getId() == this.fJX.bdx().getId()) {
                if (this.fKa) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.awG, null, false, null)));
            } else if (this.fJX.bdz() != null && view2.getId() == this.fJX.bdz().getId()) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    this.mPageContext.showToast(d.k.neterror);
                } else if (this.fJP != null) {
                    if (this.fJP.beZ() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fJP.bfa(), this.fJP.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fJP.getUniqueId();
                        this.fJP.a(false, userMuteAddAndDelCustomMessage, this.fJP.bfa(), this.mUserName);
                    } else if (this.fJP.beZ() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fJP.bfa(), this.fJP.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fJP.getUniqueId();
                        this.fJP.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.fJX.bdA() != null && view2.getId() == this.fJX.bdA().getId()) {
                this.fJY.jQ(String.valueOf(this.mUserId));
            } else if (this.fJX.bdB() != null && view2.getId() == this.fJX.bdB().getId()) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    l.showToast(this.mPageContext.getPageActivity(), d.k.neterror);
                } else {
                    bfk();
                }
            }
        }
    }

    private void bfk() {
        if (this.mUserId != 0 && !StringUtils.isNull(this.mUserName)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.fKd.cL(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dc(String.format(this.mPageContext.getString(d.k.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.tC();
        }
    }

    protected void bfl() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.fJZ.getMaskType() == 1) {
                            f.this.fJZ.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.fJZ.addToBlackList(f.this.mUserId);
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
            if (this.fJZ.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.k.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.k.block_chat_message_alert), this.mUserName);
            }
            aVar.dc(format);
            aVar.b(this.mPageContext);
            aVar.tC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh(boolean z) {
        this.fKa = z;
        if (this.fKb != null) {
            this.fKb.lj(this.fKa);
        }
        if (this.fJX != null && this.fJZ != null) {
            this.fJX.j(this.fKa, this.fJZ.getMaskType() == 1, this.fKc);
        }
    }
}
