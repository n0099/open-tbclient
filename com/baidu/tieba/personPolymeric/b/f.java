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
    protected String aSw;
    private com.baidu.tieba.person.e anH;
    private com.baidu.tieba.ueg.a ffc;
    protected c gAI;
    private com.baidu.tieba.person.f gAQ;
    private BlackListModel gAR;
    protected boolean gAS;
    protected com.baidu.tieba.personPolymeric.c.a gAT;
    private boolean gAU;
    private ai gAV;
    private final com.baidu.adp.framework.listener.c gAW = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.gAR.setMaskType(1);
                    } else {
                        f.this.gAR.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.gAR.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c gAX = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
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
    final CustomMessageListener gAY = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.mn(true);
            }
        }
    };
    private final CustomMessageListener gAZ = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
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
    private final com.baidu.adp.framework.listener.c gBa = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
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
        this.gAI = cVar;
        this.gAR = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.ffc = (com.baidu.tieba.ueg.a) runTask.getData();
            this.ffc.o(bdUniqueId);
        }
        registerListener();
        this.gAV = new ai(tbPageContext, this.mBdUniqueId);
        this.gAV.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.gAU = false;
                }
            }
        });
    }

    public void registerListener() {
        this.gAW.setTag(this.mBdUniqueId);
        this.gAX.setTag(this.mBdUniqueId);
        this.gBa.setTag(this.mBdUniqueId);
        this.gAZ.setTag(this.mBdUniqueId);
        this.gAY.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.gAW);
        this.mPageContext.registerListener(this.gAX);
        this.mPageContext.registerListener(this.gBa);
        this.mPageContext.registerListener(this.gAZ);
        this.mPageContext.registerListener(this.gAY);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.gAR != null && aVar != null && aVar.getUserData() != null) {
            this.gAT = aVar;
            UserData userData = aVar.getUserData();
            this.gAS = aVar.aVY();
            this.gAR.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aSw = userData.getPortrait();
            this.gAU = userData.getIsMyFans() == 1;
        }
    }

    public void brz() {
        if (this.gAI != null && this.gAR != null) {
            a(this.mHostView, this.gAS, this.gAR.getMaskType() == 1, this.gAI.brp(), this.gAU);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.gAQ = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gAQ.i(z, z2, z3);
        if (i != -1) {
            this.gAQ.to(i);
        }
        if (this.gAT != null && this.gAT.getUserData() != null) {
            this.gAQ.setUserName(this.gAT.getUserData().getUserName());
        }
        this.gAQ.onChangeSkinType();
        this.anH = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gAQ.getView());
        this.anH.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.anH, this.mPageContext.getPageActivity());
            if (this.gAQ.bpM() != null && view.getId() == this.gAQ.bpM().getId()) {
                brB();
            } else if (this.gAQ.bpL() != null && view.getId() == this.gAQ.bpL().getId()) {
                if (this.gAS) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aSw, null, false, null)));
            } else if (this.gAQ.bpN() != null && view.getId() == this.gAQ.bpN().getId()) {
                if (!j.kV()) {
                    this.mPageContext.showToast(e.j.neterror);
                } else if (this.gAI != null) {
                    if (this.gAI.brp() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gAI.brq(), this.gAI.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.gAI.getUniqueId();
                        this.gAI.a(false, userMuteAddAndDelCustomMessage, this.gAI.brq(), this.mUserName);
                    } else if (this.gAI.brp() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gAI.brq(), this.gAI.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.gAI.getUniqueId();
                        this.gAI.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gAQ.bpO() != null && view.getId() == this.gAQ.bpO().getId()) {
                if (this.ffc != null) {
                    TiebaStatic.log(new am("c13063").y("obj_locate", 1));
                    this.ffc.mz(String.valueOf(this.mUserId));
                }
            } else if (this.gAQ.bpP() != null && view.getId() == this.gAQ.bpP().getId()) {
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
                    f.this.gAV.F(f.this.mUserId);
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
                        if (f.this.gAR.getMaskType() == 1) {
                            f.this.gAR.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.gAR.addToBlackList(f.this.mUserId);
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
            if (this.gAR.getMaskType() == 1) {
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
        this.gAS = z;
        if (this.gAT != null) {
            this.gAT.mp(this.gAS);
        }
        if (this.gAQ != null && this.gAR != null) {
            this.gAQ.i(this.gAS, this.gAR.getMaskType() == 1, this.gAU);
        }
    }
}
