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
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes6.dex */
public class f implements View.OnClickListener {
    private com.baidu.tieba.person.e buv;
    protected String cbc;
    private com.baidu.tieba.ueg.a guV;
    private com.baidu.tieba.person.f hQB;
    private BlackListModel hQC;
    protected boolean hQD;
    protected com.baidu.tieba.personPolymeric.c.a hQE;
    private boolean hQF;
    private ai hQG;
    private final com.baidu.adp.framework.listener.c hQH = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.hQC.setMaskType(1);
                    } else {
                        f.this.hQC.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.hQC.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c hQI = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.oK(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener hQJ = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.oK(true);
            }
        }
    };
    private final CustomMessageListener hQK = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.oK(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.oK(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hQL = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c hQt;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.hQt = cVar;
        this.hQC = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.guV = (com.baidu.tieba.ueg.a) runTask.getData();
            this.guV.p(bdUniqueId);
        }
        registerListener();
        this.hQG = new ai(tbPageContext, this.mBdUniqueId);
        this.hQG.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(d.j.remove_fans_success) : f.this.mPageContext.getString(d.j.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.hQF = false;
                }
            }
        });
    }

    public void registerListener() {
        this.hQH.setTag(this.mBdUniqueId);
        this.hQI.setTag(this.mBdUniqueId);
        this.hQL.setTag(this.mBdUniqueId);
        this.hQK.setTag(this.mBdUniqueId);
        this.hQJ.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.hQH);
        this.mPageContext.registerListener(this.hQI);
        this.mPageContext.registerListener(this.hQL);
        this.mPageContext.registerListener(this.hQK);
        this.mPageContext.registerListener(this.hQJ);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.hQC != null && aVar != null && aVar.getUserData() != null) {
            this.hQE = aVar;
            UserData userData = aVar.getUserData();
            this.hQD = aVar.bwA();
            this.hQC.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.cbc = userData.getPortrait();
            this.hQF = userData.getIsMyFans() == 1;
        }
    }

    public void bRT() {
        if (this.hQt != null && this.hQC != null) {
            a(this.mHostView, this.hQD, this.hQC.getMaskType() == 1, this.hQt.bRI(), this.hQF);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.hQB = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.hQB.h(z, z2, z3);
        if (i != -1) {
            this.hQB.wU(i);
        }
        if (this.hQE != null && this.hQE.getUserData() != null) {
            this.hQB.setUserName(this.hQE.getUserData().getUserName());
        }
        this.hQB.onChangeSkinType();
        this.buv = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.hQB.getView());
        this.buv.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.buv, this.mPageContext.getPageActivity());
            if (this.hQB.bQg() != null && view.getId() == this.hQB.bQg().getId()) {
                bRV();
            } else if (this.hQB.bQf() != null && view.getId() == this.hQB.bQf().getId()) {
                if (this.hQD) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.cbc, null, false, null)));
            } else if (this.hQB.bQh() != null && view.getId() == this.hQB.bQh().getId()) {
                if (!j.kY()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.hQt != null) {
                    if (this.hQt.bRI() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.hQt.bRJ(), this.hQt.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.hQt.getUniqueId();
                        this.hQt.a(false, userMuteAddAndDelCustomMessage, this.hQt.bRJ(), this.mUserName);
                    } else if (this.hQt.bRI() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.hQt.bRJ(), this.hQt.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.hQt.getUniqueId();
                        this.hQt.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.hQB.bQi() != null && view.getId() == this.hQB.bQi().getId()) {
                if (this.guV != null) {
                    TiebaStatic.log(new am("c13063").T("obj_locate", 1));
                    this.guV.tg(String.valueOf(this.mUserId));
                }
            } else if (this.hQB.bQj() != null && view.getId() == this.hQB.bQj().getId()) {
                if (!j.kY()) {
                    l.showToast(this.mPageContext.getPageActivity(), d.j.neterror);
                } else {
                    bRU();
                }
            }
        }
    }

    private void bRU() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.hQG.ai(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.lz(String.format(this.mPageContext.getString(d.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.aaW();
        }
    }

    protected void bRV() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.hQC.getMaskType() == 1) {
                            f.this.hQC.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.hQC.addToBlackList(f.this.mUserId);
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
            if (this.hQC.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.j.block_chat_message_alert), this.mUserName);
            }
            aVar.lz(format);
            aVar.b(this.mPageContext);
            aVar.aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oK(boolean z) {
        this.hQD = z;
        if (this.hQE != null) {
            this.hQE.oM(this.hQD);
        }
        if (this.hQB != null && this.hQC != null) {
            this.hQB.h(this.hQD, this.hQC.getMaskType() == 1, this.hQF);
        }
    }
}
