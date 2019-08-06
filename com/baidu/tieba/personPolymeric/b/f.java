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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes6.dex */
public class f implements View.OnClickListener {
    private com.baidu.tieba.person.e bCx;
    protected String cko;
    private com.baidu.tieba.ueg.a gTo;
    protected c iqG;
    private com.baidu.tieba.person.f iqO;
    private BlackListModel iqP;
    protected boolean iqQ;
    protected com.baidu.tieba.personPolymeric.c.a iqR;
    private boolean iqS;
    private ai iqT;
    private final com.baidu.adp.framework.listener.c iqU = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.iqP.setMaskType(1);
                    } else {
                        f.this.iqP.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.iqP.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(R.string.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(R.string.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c iqV = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.pP(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener iqW = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.pP(true);
            }
        }
    };
    private final CustomMessageListener iqX = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.pP(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.pP(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c iqY = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
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
        this.iqG = cVar;
        this.iqP = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.gTo = (com.baidu.tieba.ueg.a) runTask.getData();
            this.gTo.r(bdUniqueId);
        }
        registerListener();
        this.iqT = new ai(tbPageContext, this.mBdUniqueId);
        this.iqT.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(R.string.remove_fans_success) : f.this.mPageContext.getString(R.string.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.iqS = false;
                }
            }
        });
    }

    public void registerListener() {
        this.iqU.setTag(this.mBdUniqueId);
        this.iqV.setTag(this.mBdUniqueId);
        this.iqY.setTag(this.mBdUniqueId);
        this.iqX.setTag(this.mBdUniqueId);
        this.iqW.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.iqU);
        this.mPageContext.registerListener(this.iqV);
        this.mPageContext.registerListener(this.iqY);
        this.mPageContext.registerListener(this.iqX);
        this.mPageContext.registerListener(this.iqW);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.iqP != null && aVar != null && aVar.getUserData() != null) {
            this.iqR = aVar;
            UserData userData = aVar.getUserData();
            this.iqQ = aVar.bHh();
            this.iqP.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.cko = userData.getPortrait();
            this.iqS = userData.getIsMyFans() == 1;
        }
    }

    public void cdf() {
        if (this.iqG != null && this.iqP != null) {
            a(this.mHostView, this.iqQ, this.iqP.getMaskType() == 1, this.iqG.ccU(), this.iqS);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.iqO = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.iqO.h(z, z2, z3);
        if (i != -1) {
            this.iqO.yH(i);
        }
        if (this.iqR != null && this.iqR.getUserData() != null) {
            this.iqO.setUserName(this.iqR.getUserData().getUserName());
        }
        this.iqO.onChangeSkinType();
        this.bCx = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.iqO.getView());
        this.bCx.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.bCx, this.mPageContext.getPageActivity());
            if (this.iqO.cbk() != null && view.getId() == this.iqO.cbk().getId()) {
                cdh();
            } else if (this.iqO.cbj() != null && view.getId() == this.iqO.cbj().getId()) {
                if (this.iqQ) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.cko, null, false, null)));
            } else if (this.iqO.cbl() != null && view.getId() == this.iqO.cbl().getId()) {
                if (!j.kc()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.iqG != null) {
                    if (this.iqG.ccU() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.iqG.ccV(), this.iqG.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.iqG.getUniqueId();
                        this.iqG.a(false, userMuteAddAndDelCustomMessage, this.iqG.ccV(), this.mUserName);
                    } else if (this.iqG.ccU() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.iqG.ccV(), this.iqG.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.iqG.getUniqueId();
                        this.iqG.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.iqO.cbm() != null && view.getId() == this.iqO.cbm().getId()) {
                if (this.gTo != null) {
                    TiebaStatic.log(new an("c13063").P("obj_locate", 1));
                    this.gTo.uW(String.valueOf(this.mUserId));
                }
            } else if (this.iqO.cbn() != null && view.getId() == this.iqO.cbn().getId()) {
                if (!j.kc()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    cdg();
                }
            }
        }
    }

    private void cdg() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.iqT.av(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.mO(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.agK();
        }
    }

    protected void cdh() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.iqP.getMaskType() == 1) {
                            f.this.iqP.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.iqP.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.iqP.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.mO(format);
            aVar.b(this.mPageContext);
            aVar.agK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(boolean z) {
        this.iqQ = z;
        if (this.iqR != null) {
            this.iqR.pR(this.iqQ);
        }
        if (this.iqO != null && this.iqP != null) {
            this.iqO.h(this.iqQ, this.iqP.getMaskType() == 1, this.iqS);
        }
    }
}
