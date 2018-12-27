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
    protected String aRR;
    private com.baidu.tieba.person.e ane;
    private com.baidu.tieba.ueg.a feo;
    protected c gzD;
    private com.baidu.tieba.person.f gzL;
    private BlackListModel gzM;
    protected boolean gzN;
    protected com.baidu.tieba.personPolymeric.c.a gzO;
    private boolean gzP;
    private ai gzQ;
    private final com.baidu.adp.framework.listener.c gzR = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.gzM.setMaskType(1);
                    } else {
                        f.this.gzM.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.gzM.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c gzS = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
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
    final CustomMessageListener gzT = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.mn(true);
            }
        }
    };
    private final CustomMessageListener gzU = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
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
    private final com.baidu.adp.framework.listener.c gzV = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
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
        this.gzD = cVar;
        this.gzM = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.feo = (com.baidu.tieba.ueg.a) runTask.getData();
            this.feo.o(bdUniqueId);
        }
        registerListener();
        this.gzQ = new ai(tbPageContext, this.mBdUniqueId);
        this.gzQ.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.gzP = false;
                }
            }
        });
    }

    public void registerListener() {
        this.gzR.setTag(this.mBdUniqueId);
        this.gzS.setTag(this.mBdUniqueId);
        this.gzV.setTag(this.mBdUniqueId);
        this.gzU.setTag(this.mBdUniqueId);
        this.gzT.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.gzR);
        this.mPageContext.registerListener(this.gzS);
        this.mPageContext.registerListener(this.gzV);
        this.mPageContext.registerListener(this.gzU);
        this.mPageContext.registerListener(this.gzT);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.gzM != null && aVar != null && aVar.getUserData() != null) {
            this.gzO = aVar;
            UserData userData = aVar.getUserData();
            this.gzN = aVar.aVy();
            this.gzM.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aRR = userData.getPortrait();
            this.gzP = userData.getIsMyFans() == 1;
        }
    }

    public void bqQ() {
        if (this.gzD != null && this.gzM != null) {
            a(this.mHostView, this.gzN, this.gzM.getMaskType() == 1, this.gzD.bqG(), this.gzP);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.gzL = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gzL.i(z, z2, z3);
        if (i != -1) {
            this.gzL.tk(i);
        }
        if (this.gzO != null && this.gzO.getUserData() != null) {
            this.gzL.setUserName(this.gzO.getUserData().getUserName());
        }
        this.gzL.onChangeSkinType();
        this.ane = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gzL.getView());
        this.ane.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.ane, this.mPageContext.getPageActivity());
            if (this.gzL.bpd() != null && view.getId() == this.gzL.bpd().getId()) {
                bqS();
            } else if (this.gzL.bpc() != null && view.getId() == this.gzL.bpc().getId()) {
                if (this.gzN) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aRR, null, false, null)));
            } else if (this.gzL.bpe() != null && view.getId() == this.gzL.bpe().getId()) {
                if (!j.kV()) {
                    this.mPageContext.showToast(e.j.neterror);
                } else if (this.gzD != null) {
                    if (this.gzD.bqG() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gzD.bqH(), this.gzD.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.gzD.getUniqueId();
                        this.gzD.a(false, userMuteAddAndDelCustomMessage, this.gzD.bqH(), this.mUserName);
                    } else if (this.gzD.bqG() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gzD.bqH(), this.gzD.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.gzD.getUniqueId();
                        this.gzD.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gzL.bpf() != null && view.getId() == this.gzL.bpf().getId()) {
                if (this.feo != null) {
                    TiebaStatic.log(new am("c13063").x("obj_locate", 1));
                    this.feo.mj(String.valueOf(this.mUserId));
                }
            } else if (this.gzL.bpg() != null && view.getId() == this.gzL.bpg().getId()) {
                if (!j.kV()) {
                    l.showToast(this.mPageContext.getPageActivity(), e.j.neterror);
                } else {
                    bqR();
                }
            }
        }
    }

    private void bqR() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.gzQ.F(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.eB(String.format(this.mPageContext.getString(e.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.BF();
        }
    }

    protected void bqS() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.gzM.getMaskType() == 1) {
                            f.this.gzM.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.gzM.addToBlackList(f.this.mUserId);
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
            if (this.gzM.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(e.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(e.j.block_chat_message_alert), this.mUserName);
            }
            aVar.eB(format);
            aVar.b(this.mPageContext);
            aVar.BF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(boolean z) {
        this.gzN = z;
        if (this.gzO != null) {
            this.gzO.mp(this.gzN);
        }
        if (this.gzL != null && this.gzM != null) {
            this.gzL.i(this.gzN, this.gzM.getMaskType() == 1, this.gzP);
        }
    }
}
