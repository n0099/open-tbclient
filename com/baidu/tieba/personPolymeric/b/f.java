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
    private com.baidu.tieba.person.e abo;
    private com.baidu.tieba.ueg.a eEv;
    protected c fZE;
    private com.baidu.tieba.person.f fZM;
    private BlackListModel fZN;
    protected boolean fZO;
    protected com.baidu.tieba.personPolymeric.c.a fZP;
    private boolean fZQ;
    private aj fZR;
    private final com.baidu.adp.framework.listener.c fZS = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.fZN.setMaskType(1);
                    } else {
                        f.this.fZN.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.fZN.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.j.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.j.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fZT = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lj(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fZU = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lj(true);
            }
        }
    };
    private final CustomMessageListener fZV = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lj(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lj(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fZW = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
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
        this.fZE = cVar;
        this.fZN = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.eEv = (com.baidu.tieba.ueg.a) runTask.getData();
            this.eEv.o(bdUniqueId);
        }
        registerListener();
        this.fZR = new aj(tbPageContext, this.mBdUniqueId);
        this.fZR.a(new aj.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tbadk.core.util.aj.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(d.j.remove_fans_success) : f.this.mPageContext.getString(d.j.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.fZQ = false;
                }
            }
        });
    }

    public void registerListener() {
        this.fZS.setTag(this.mBdUniqueId);
        this.fZT.setTag(this.mBdUniqueId);
        this.fZW.setTag(this.mBdUniqueId);
        this.fZV.setTag(this.mBdUniqueId);
        this.fZU.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.fZS);
        this.mPageContext.registerListener(this.fZT);
        this.mPageContext.registerListener(this.fZW);
        this.mPageContext.registerListener(this.fZV);
        this.mPageContext.registerListener(this.fZU);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fZN != null && aVar != null && aVar.getUserData() != null) {
            this.fZP = aVar;
            UserData userData = aVar.getUserData();
            this.fZO = aVar.aNW();
            this.fZN.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aFL = userData.getPortrait();
            this.fZQ = userData.getIsMyFans() == 1;
        }
    }

    public void bji() {
        if (this.fZE != null && this.fZN != null) {
            a(this.mHostView, this.fZO, this.fZN.getMaskType() == 1, this.fZE.biY(), this.fZQ);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.fZM = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.fZM.i(z, z2, z3);
        if (i != -1) {
            this.fZM.rq(i);
        }
        if (this.fZP != null && this.fZP.getUserData() != null) {
            this.fZM.setUserName(this.fZP.getUserData().getUserName());
        }
        this.fZM.onChangeSkinType();
        this.abo = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.fZM.getView());
        this.abo.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.abo, this.mPageContext.getPageActivity());
            if (this.fZM.bhx() != null && view.getId() == this.fZM.bhx().getId()) {
                bjk();
            } else if (this.fZM.bhw() != null && view.getId() == this.fZM.bhw().getId()) {
                if (this.fZO) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aFL, null, false, null)));
            } else if (this.fZM.bhy() != null && view.getId() == this.fZM.bhy().getId()) {
                if (!j.jE()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.fZE != null) {
                    if (this.fZE.biY() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fZE.biZ(), this.fZE.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fZE.getUniqueId();
                        this.fZE.a(false, userMuteAddAndDelCustomMessage, this.fZE.biZ(), this.mUserName);
                    } else if (this.fZE.biY() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fZE.biZ(), this.fZE.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fZE.getUniqueId();
                        this.fZE.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.fZM.bhz() != null && view.getId() == this.fZM.bhz().getId()) {
                if (this.eEv != null) {
                    TiebaStatic.log(new an("c13063"));
                    this.eEv.kD(String.valueOf(this.mUserId));
                }
            } else if (this.fZM.bhA() != null && view.getId() == this.fZM.bhA().getId()) {
                if (!j.jE()) {
                    l.showToast(this.mPageContext.getPageActivity(), d.j.neterror);
                } else {
                    bjj();
                }
            }
        }
    }

    private void bjj() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.fZR.s(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dB(String.format(this.mPageContext.getString(d.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.xf();
        }
    }

    protected void bjk() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.fZN.getMaskType() == 1) {
                            f.this.fZN.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.fZN.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.fZN.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.j.block_chat_message_alert), this.mUserName);
            }
            aVar.dB(format);
            aVar.b(this.mPageContext);
            aVar.xf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        this.fZO = z;
        if (this.fZP != null) {
            this.fZP.ll(this.fZO);
        }
        if (this.fZM != null && this.fZN != null) {
            this.fZM.i(this.fZO, this.fZN.getMaskType() == 1, this.fZQ);
        }
    }
}
