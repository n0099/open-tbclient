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
    protected String aNA;
    private com.baidu.tieba.person.e aiP;
    private com.baidu.tieba.ueg.a eTq;
    private com.baidu.tieba.person.f goF;
    private BlackListModel goG;
    protected boolean goH;
    protected com.baidu.tieba.personPolymeric.c.a goI;
    private boolean goJ;
    private ai goK;
    private final com.baidu.adp.framework.listener.c goL = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.goG.setMaskType(1);
                    } else {
                        f.this.goG.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.goG.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c goM = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lW(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener goN = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lW(true);
            }
        }
    };
    private final CustomMessageListener goO = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lW(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lW(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c goP = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c gox;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.gox = cVar;
        this.goG = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.eTq = (com.baidu.tieba.ueg.a) runTask.getData();
            this.eTq.o(bdUniqueId);
        }
        registerListener();
        this.goK = new ai(tbPageContext, this.mBdUniqueId);
        this.goK.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.goJ = false;
                }
            }
        });
    }

    public void registerListener() {
        this.goL.setTag(this.mBdUniqueId);
        this.goM.setTag(this.mBdUniqueId);
        this.goP.setTag(this.mBdUniqueId);
        this.goO.setTag(this.mBdUniqueId);
        this.goN.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.goL);
        this.mPageContext.registerListener(this.goM);
        this.mPageContext.registerListener(this.goP);
        this.mPageContext.registerListener(this.goO);
        this.mPageContext.registerListener(this.goN);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.goG != null && aVar != null && aVar.getUserData() != null) {
            this.goI = aVar;
            UserData userData = aVar.getUserData();
            this.goH = aVar.aTw();
            this.goG.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aNA = userData.getPortrait();
            this.goJ = userData.getIsMyFans() == 1;
        }
    }

    public void boR() {
        if (this.gox != null && this.goG != null) {
            a(this.mHostView, this.goH, this.goG.getMaskType() == 1, this.gox.boH(), this.goJ);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.goF = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.goF.i(z, z2, z3);
        if (i != -1) {
            this.goF.sk(i);
        }
        if (this.goI != null && this.goI.getUserData() != null) {
            this.goF.setUserName(this.goI.getUserData().getUserName());
        }
        this.goF.onChangeSkinType();
        this.aiP = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.goF.getView());
        this.aiP.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.aiP, this.mPageContext.getPageActivity());
            if (this.goF.bne() != null && view.getId() == this.goF.bne().getId()) {
                boT();
            } else if (this.goF.bnd() != null && view.getId() == this.goF.bnd().getId()) {
                if (this.goH) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aNA, null, false, null)));
            } else if (this.goF.bnf() != null && view.getId() == this.goF.bnf().getId()) {
                if (!j.kX()) {
                    this.mPageContext.showToast(e.j.neterror);
                } else if (this.gox != null) {
                    if (this.gox.boH() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gox.boI(), this.gox.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.gox.getUniqueId();
                        this.gox.a(false, userMuteAddAndDelCustomMessage, this.gox.boI(), this.mUserName);
                    } else if (this.gox.boH() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gox.boI(), this.gox.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.gox.getUniqueId();
                        this.gox.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.goF.bng() != null && view.getId() == this.goF.bng().getId()) {
                if (this.eTq != null) {
                    TiebaStatic.log(new am("c13063").x("obj_locate", 1));
                    this.eTq.lK(String.valueOf(this.mUserId));
                }
            } else if (this.goF.bnh() != null && view.getId() == this.goF.bnh().getId()) {
                if (!j.kX()) {
                    l.showToast(this.mPageContext.getPageActivity(), e.j.neterror);
                } else {
                    boS();
                }
            }
        }
    }

    private void boS() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.goK.y(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ej(String.format(this.mPageContext.getString(e.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.Au();
        }
    }

    protected void boT() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.goG.getMaskType() == 1) {
                            f.this.goG.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.goG.addToBlackList(f.this.mUserId);
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
            if (this.goG.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(e.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(e.j.block_chat_message_alert), this.mUserName);
            }
            aVar.ej(format);
            aVar.b(this.mPageContext);
            aVar.Au();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(boolean z) {
        this.goH = z;
        if (this.goI != null) {
            this.goI.lY(this.goH);
        }
        if (this.goF != null && this.goG != null) {
            this.goF.i(this.goH, this.goG.getMaskType() == 1, this.goJ);
        }
    }
}
