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
    protected String aOq;
    private com.baidu.tieba.person.e ajC;
    private com.baidu.tieba.ueg.a eUI;
    protected c gpW;
    private com.baidu.tieba.person.f gqe;
    private BlackListModel gqf;
    protected boolean gqg;
    protected com.baidu.tieba.personPolymeric.c.a gqh;
    private boolean gqi;
    private ai gqj;
    private final com.baidu.adp.framework.listener.c gqk = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.gqf.setMaskType(1);
                    } else {
                        f.this.gqf.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.gqf.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c gql = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.mh(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener gqm = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.mh(true);
            }
        }
    };
    private final CustomMessageListener gqn = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.mh(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.mh(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gqo = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
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
        this.gpW = cVar;
        this.gqf = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.eUI = (com.baidu.tieba.ueg.a) runTask.getData();
            this.eUI.o(bdUniqueId);
        }
        registerListener();
        this.gqj = new ai(tbPageContext, this.mBdUniqueId);
        this.gqj.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.gqi = false;
                }
            }
        });
    }

    public void registerListener() {
        this.gqk.setTag(this.mBdUniqueId);
        this.gql.setTag(this.mBdUniqueId);
        this.gqo.setTag(this.mBdUniqueId);
        this.gqn.setTag(this.mBdUniqueId);
        this.gqm.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.gqk);
        this.mPageContext.registerListener(this.gql);
        this.mPageContext.registerListener(this.gqo);
        this.mPageContext.registerListener(this.gqn);
        this.mPageContext.registerListener(this.gqm);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.gqf != null && aVar != null && aVar.getUserData() != null) {
            this.gqh = aVar;
            UserData userData = aVar.getUserData();
            this.gqg = aVar.aST();
            this.gqf.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aOq = userData.getPortrait();
            this.gqi = userData.getIsMyFans() == 1;
        }
    }

    public void bom() {
        if (this.gpW != null && this.gqf != null) {
            a(this.mHostView, this.gqg, this.gqf.getMaskType() == 1, this.gpW.boc(), this.gqi);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.gqe = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gqe.i(z, z2, z3);
        if (i != -1) {
            this.gqe.sD(i);
        }
        if (this.gqh != null && this.gqh.getUserData() != null) {
            this.gqe.setUserName(this.gqh.getUserData().getUserName());
        }
        this.gqe.onChangeSkinType();
        this.ajC = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gqe.getView());
        this.ajC.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.ajC, this.mPageContext.getPageActivity());
            if (this.gqe.bmz() != null && view.getId() == this.gqe.bmz().getId()) {
                boo();
            } else if (this.gqe.bmy() != null && view.getId() == this.gqe.bmy().getId()) {
                if (this.gqg) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aOq, null, false, null)));
            } else if (this.gqe.bmA() != null && view.getId() == this.gqe.bmA().getId()) {
                if (!j.kV()) {
                    this.mPageContext.showToast(e.j.neterror);
                } else if (this.gpW != null) {
                    if (this.gpW.boc() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gpW.bod(), this.gpW.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.gpW.getUniqueId();
                        this.gpW.a(false, userMuteAddAndDelCustomMessage, this.gpW.bod(), this.mUserName);
                    } else if (this.gpW.boc() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gpW.bod(), this.gpW.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.gpW.getUniqueId();
                        this.gpW.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gqe.bmB() != null && view.getId() == this.gqe.bmB().getId()) {
                if (this.eUI != null) {
                    TiebaStatic.log(new am("c13063").x("obj_locate", 1));
                    this.eUI.lM(String.valueOf(this.mUserId));
                }
            } else if (this.gqe.bmC() != null && view.getId() == this.gqe.bmC().getId()) {
                if (!j.kV()) {
                    l.showToast(this.mPageContext.getPageActivity(), e.j.neterror);
                } else {
                    bon();
                }
            }
        }
    }

    private void bon() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.gqj.A(f.this.mUserId);
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
            aVar.AB();
        }
    }

    protected void boo() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.gqf.getMaskType() == 1) {
                            f.this.gqf.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.gqf.addToBlackList(f.this.mUserId);
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
            if (this.gqf.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(e.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(e.j.block_chat_message_alert), this.mUserName);
            }
            aVar.ej(format);
            aVar.b(this.mPageContext);
            aVar.AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        this.gqg = z;
        if (this.gqh != null) {
            this.gqh.mj(this.gqg);
        }
        if (this.gqe != null && this.gqf != null) {
            this.gqe.i(this.gqg, this.gqf.getMaskType() == 1, this.gqi);
        }
    }
}
