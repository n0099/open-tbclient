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
    private com.baidu.tieba.person.e buw;
    protected String cbd;
    private com.baidu.tieba.ueg.a guW;
    private com.baidu.tieba.person.f hQC;
    private BlackListModel hQD;
    protected boolean hQE;
    protected com.baidu.tieba.personPolymeric.c.a hQF;
    private boolean hQG;
    private ai hQH;
    private final com.baidu.adp.framework.listener.c hQI = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.hQD.setMaskType(1);
                    } else {
                        f.this.hQD.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.hQD.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c hQJ = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
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
    final CustomMessageListener hQK = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.oK(true);
            }
        }
    };
    private final CustomMessageListener hQL = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
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
    private final com.baidu.adp.framework.listener.c hQM = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c hQu;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.hQu = cVar;
        this.hQD = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.guW = (com.baidu.tieba.ueg.a) runTask.getData();
            this.guW.p(bdUniqueId);
        }
        registerListener();
        this.hQH = new ai(tbPageContext, this.mBdUniqueId);
        this.hQH.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.hQG = false;
                }
            }
        });
    }

    public void registerListener() {
        this.hQI.setTag(this.mBdUniqueId);
        this.hQJ.setTag(this.mBdUniqueId);
        this.hQM.setTag(this.mBdUniqueId);
        this.hQL.setTag(this.mBdUniqueId);
        this.hQK.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.hQI);
        this.mPageContext.registerListener(this.hQJ);
        this.mPageContext.registerListener(this.hQM);
        this.mPageContext.registerListener(this.hQL);
        this.mPageContext.registerListener(this.hQK);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.hQD != null && aVar != null && aVar.getUserData() != null) {
            this.hQF = aVar;
            UserData userData = aVar.getUserData();
            this.hQE = aVar.bwA();
            this.hQD.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.cbd = userData.getPortrait();
            this.hQG = userData.getIsMyFans() == 1;
        }
    }

    public void bRT() {
        if (this.hQu != null && this.hQD != null) {
            a(this.mHostView, this.hQE, this.hQD.getMaskType() == 1, this.hQu.bRI(), this.hQG);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.hQC = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.hQC.h(z, z2, z3);
        if (i != -1) {
            this.hQC.wU(i);
        }
        if (this.hQF != null && this.hQF.getUserData() != null) {
            this.hQC.setUserName(this.hQF.getUserData().getUserName());
        }
        this.hQC.onChangeSkinType();
        this.buw = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.hQC.getView());
        this.buw.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.buw, this.mPageContext.getPageActivity());
            if (this.hQC.bQg() != null && view.getId() == this.hQC.bQg().getId()) {
                bRV();
            } else if (this.hQC.bQf() != null && view.getId() == this.hQC.bQf().getId()) {
                if (this.hQE) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.cbd, null, false, null)));
            } else if (this.hQC.bQh() != null && view.getId() == this.hQC.bQh().getId()) {
                if (!j.kY()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.hQu != null) {
                    if (this.hQu.bRI() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.hQu.bRJ(), this.hQu.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.hQu.getUniqueId();
                        this.hQu.a(false, userMuteAddAndDelCustomMessage, this.hQu.bRJ(), this.mUserName);
                    } else if (this.hQu.bRI() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.hQu.bRJ(), this.hQu.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.hQu.getUniqueId();
                        this.hQu.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.hQC.bQi() != null && view.getId() == this.hQC.bQi().getId()) {
                if (this.guW != null) {
                    TiebaStatic.log(new am("c13063").T("obj_locate", 1));
                    this.guW.tg(String.valueOf(this.mUserId));
                }
            } else if (this.hQC.bQj() != null && view.getId() == this.hQC.bQj().getId()) {
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
                    f.this.hQH.ai(f.this.mUserId);
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
                        if (f.this.hQD.getMaskType() == 1) {
                            f.this.hQD.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.hQD.addToBlackList(f.this.mUserId);
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
            if (this.hQD.getMaskType() == 1) {
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
        this.hQE = z;
        if (this.hQF != null) {
            this.hQF.oM(this.hQE);
        }
        if (this.hQC != null && this.hQD != null) {
            this.hQC.h(this.hQE, this.hQD.getMaskType() == 1, this.hQG);
        }
    }
}
