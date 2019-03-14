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
    private com.baidu.tieba.person.e bus;
    protected String cba;
    private com.baidu.tieba.ueg.a gvi;
    protected c hQH;
    private com.baidu.tieba.person.f hQP;
    private BlackListModel hQQ;
    protected boolean hQR;
    protected com.baidu.tieba.personPolymeric.c.a hQS;
    private boolean hQT;
    private ai hQU;
    private final com.baidu.adp.framework.listener.c hQV = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.hQQ.setMaskType(1);
                    } else {
                        f.this.hQQ.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.hQQ.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c hQW = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
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
    final CustomMessageListener hQX = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.oK(true);
            }
        }
    };
    private final CustomMessageListener hQY = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
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
    private final com.baidu.adp.framework.listener.c hQZ = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
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
        this.hQH = cVar;
        this.hQQ = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.gvi = (com.baidu.tieba.ueg.a) runTask.getData();
            this.gvi.p(bdUniqueId);
        }
        registerListener();
        this.hQU = new ai(tbPageContext, this.mBdUniqueId);
        this.hQU.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.hQT = false;
                }
            }
        });
    }

    public void registerListener() {
        this.hQV.setTag(this.mBdUniqueId);
        this.hQW.setTag(this.mBdUniqueId);
        this.hQZ.setTag(this.mBdUniqueId);
        this.hQY.setTag(this.mBdUniqueId);
        this.hQX.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.hQV);
        this.mPageContext.registerListener(this.hQW);
        this.mPageContext.registerListener(this.hQZ);
        this.mPageContext.registerListener(this.hQY);
        this.mPageContext.registerListener(this.hQX);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.hQQ != null && aVar != null && aVar.getUserData() != null) {
            this.hQS = aVar;
            UserData userData = aVar.getUserData();
            this.hQR = aVar.bwD();
            this.hQQ.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.cba = userData.getPortrait();
            this.hQT = userData.getIsMyFans() == 1;
        }
    }

    public void bRX() {
        if (this.hQH != null && this.hQQ != null) {
            a(this.mHostView, this.hQR, this.hQQ.getMaskType() == 1, this.hQH.bRM(), this.hQT);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.hQP = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.hQP.h(z, z2, z3);
        if (i != -1) {
            this.hQP.wY(i);
        }
        if (this.hQS != null && this.hQS.getUserData() != null) {
            this.hQP.setUserName(this.hQS.getUserData().getUserName());
        }
        this.hQP.onChangeSkinType();
        this.bus = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.hQP.getView());
        this.bus.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.bus, this.mPageContext.getPageActivity());
            if (this.hQP.bQk() != null && view.getId() == this.hQP.bQk().getId()) {
                bRZ();
            } else if (this.hQP.bQj() != null && view.getId() == this.hQP.bQj().getId()) {
                if (this.hQR) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.cba, null, false, null)));
            } else if (this.hQP.bQl() != null && view.getId() == this.hQP.bQl().getId()) {
                if (!j.kY()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.hQH != null) {
                    if (this.hQH.bRM() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.hQH.bRN(), this.hQH.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.hQH.getUniqueId();
                        this.hQH.a(false, userMuteAddAndDelCustomMessage, this.hQH.bRN(), this.mUserName);
                    } else if (this.hQH.bRM() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.hQH.bRN(), this.hQH.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.hQH.getUniqueId();
                        this.hQH.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.hQP.bQm() != null && view.getId() == this.hQP.bQm().getId()) {
                if (this.gvi != null) {
                    TiebaStatic.log(new am("c13063").T("obj_locate", 1));
                    this.gvi.th(String.valueOf(this.mUserId));
                }
            } else if (this.hQP.bQn() != null && view.getId() == this.hQP.bQn().getId()) {
                if (!j.kY()) {
                    l.showToast(this.mPageContext.getPageActivity(), d.j.neterror);
                } else {
                    bRY();
                }
            }
        }
    }

    private void bRY() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.hQU.ai(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ly(String.format(this.mPageContext.getString(d.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.aaZ();
        }
    }

    protected void bRZ() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.hQQ.getMaskType() == 1) {
                            f.this.hQQ.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.hQQ.addToBlackList(f.this.mUserId);
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
            if (this.hQQ.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.j.block_chat_message_alert), this.mUserName);
            }
            aVar.ly(format);
            aVar.b(this.mPageContext);
            aVar.aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oK(boolean z) {
        this.hQR = z;
        if (this.hQS != null) {
            this.hQS.oM(this.hQR);
        }
        if (this.hQP != null && this.hQQ != null) {
            this.hQP.h(this.hQR, this.hQQ.getMaskType() == 1, this.hQT);
        }
    }
}
