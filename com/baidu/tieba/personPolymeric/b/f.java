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
    protected String aSv;
    private com.baidu.tieba.person.e anG;
    private com.baidu.tieba.ueg.a ffb;
    protected c gAH;
    private com.baidu.tieba.person.f gAP;
    private BlackListModel gAQ;
    protected boolean gAR;
    protected com.baidu.tieba.personPolymeric.c.a gAS;
    private boolean gAT;
    private ai gAU;
    private final com.baidu.adp.framework.listener.c gAV = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.gAQ.setMaskType(1);
                    } else {
                        f.this.gAQ.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.gAQ.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c gAW = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.mn(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener gAX = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.mn(true);
            }
        }
    };
    private final CustomMessageListener gAY = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.mn(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.mn(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gAZ = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
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
        this.gAH = cVar;
        this.gAQ = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.ffb = (com.baidu.tieba.ueg.a) runTask.getData();
            this.ffb.o(bdUniqueId);
        }
        registerListener();
        this.gAU = new ai(tbPageContext, this.mBdUniqueId);
        this.gAU.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.gAT = false;
                }
            }
        });
    }

    public void registerListener() {
        this.gAV.setTag(this.mBdUniqueId);
        this.gAW.setTag(this.mBdUniqueId);
        this.gAZ.setTag(this.mBdUniqueId);
        this.gAY.setTag(this.mBdUniqueId);
        this.gAX.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.gAV);
        this.mPageContext.registerListener(this.gAW);
        this.mPageContext.registerListener(this.gAZ);
        this.mPageContext.registerListener(this.gAY);
        this.mPageContext.registerListener(this.gAX);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.gAQ != null && aVar != null && aVar.getUserData() != null) {
            this.gAS = aVar;
            UserData userData = aVar.getUserData();
            this.gAR = aVar.aVY();
            this.gAQ.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aSv = userData.getPortrait();
            this.gAT = userData.getIsMyFans() == 1;
        }
    }

    public void brz() {
        if (this.gAH != null && this.gAQ != null) {
            a(this.mHostView, this.gAR, this.gAQ.getMaskType() == 1, this.gAH.brp(), this.gAT);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.gAP = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gAP.i(z, z2, z3);
        if (i != -1) {
            this.gAP.to(i);
        }
        if (this.gAS != null && this.gAS.getUserData() != null) {
            this.gAP.setUserName(this.gAS.getUserData().getUserName());
        }
        this.gAP.onChangeSkinType();
        this.anG = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gAP.getView());
        this.anG.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.anG, this.mPageContext.getPageActivity());
            if (this.gAP.bpM() != null && view.getId() == this.gAP.bpM().getId()) {
                brB();
            } else if (this.gAP.bpL() != null && view.getId() == this.gAP.bpL().getId()) {
                if (this.gAR) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aSv, null, false, null)));
            } else if (this.gAP.bpN() != null && view.getId() == this.gAP.bpN().getId()) {
                if (!j.kV()) {
                    this.mPageContext.showToast(e.j.neterror);
                } else if (this.gAH != null) {
                    if (this.gAH.brp() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gAH.brq(), this.gAH.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.gAH.getUniqueId();
                        this.gAH.a(false, userMuteAddAndDelCustomMessage, this.gAH.brq(), this.mUserName);
                    } else if (this.gAH.brp() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gAH.brq(), this.gAH.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.gAH.getUniqueId();
                        this.gAH.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gAP.bpO() != null && view.getId() == this.gAP.bpO().getId()) {
                if (this.ffb != null) {
                    TiebaStatic.log(new am("c13063").y("obj_locate", 1));
                    this.ffb.mz(String.valueOf(this.mUserId));
                }
            } else if (this.gAP.bpP() != null && view.getId() == this.gAP.bpP().getId()) {
                if (!j.kV()) {
                    l.showToast(this.mPageContext.getPageActivity(), e.j.neterror);
                } else {
                    brA();
                }
            }
        }
    }

    private void brA() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.gAU.F(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.eK(String.format(this.mPageContext.getString(e.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.BS();
        }
    }

    protected void brB() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.gAQ.getMaskType() == 1) {
                            f.this.gAQ.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.gAQ.addToBlackList(f.this.mUserId);
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
            if (this.gAQ.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(e.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(e.j.block_chat_message_alert), this.mUserName);
            }
            aVar.eK(format);
            aVar.b(this.mPageContext);
            aVar.BS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(boolean z) {
        this.gAR = z;
        if (this.gAS != null) {
            this.gAS.mp(this.gAR);
        }
        if (this.gAP != null && this.gAQ != null) {
            this.gAP.i(this.gAR, this.gAQ.getMaskType() == 1, this.gAT);
        }
    }
}
