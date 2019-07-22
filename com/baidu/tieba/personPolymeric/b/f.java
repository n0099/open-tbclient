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
    protected String ckh;
    private com.baidu.tieba.ueg.a gSw;
    protected c ipC;
    private com.baidu.tieba.person.f ipK;
    private BlackListModel ipL;
    protected boolean ipM;
    protected com.baidu.tieba.personPolymeric.c.a ipN;
    private boolean ipO;
    private ai ipP;
    private final com.baidu.adp.framework.listener.c ipQ = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.ipL.setMaskType(1);
                    } else {
                        f.this.ipL.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.ipL.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c ipR = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.pO(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener ipS = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.pO(true);
            }
        }
    };
    private final CustomMessageListener ipT = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.pO(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.pO(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c ipU = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
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
        this.ipC = cVar;
        this.ipL = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.gSw = (com.baidu.tieba.ueg.a) runTask.getData();
            this.gSw.r(bdUniqueId);
        }
        registerListener();
        this.ipP = new ai(tbPageContext, this.mBdUniqueId);
        this.ipP.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.ipO = false;
                }
            }
        });
    }

    public void registerListener() {
        this.ipQ.setTag(this.mBdUniqueId);
        this.ipR.setTag(this.mBdUniqueId);
        this.ipU.setTag(this.mBdUniqueId);
        this.ipT.setTag(this.mBdUniqueId);
        this.ipS.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.ipQ);
        this.mPageContext.registerListener(this.ipR);
        this.mPageContext.registerListener(this.ipU);
        this.mPageContext.registerListener(this.ipT);
        this.mPageContext.registerListener(this.ipS);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.ipL != null && aVar != null && aVar.getUserData() != null) {
            this.ipN = aVar;
            UserData userData = aVar.getUserData();
            this.ipM = aVar.bGT();
            this.ipL.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.ckh = userData.getPortrait();
            this.ipO = userData.getIsMyFans() == 1;
        }
    }

    public void ccN() {
        if (this.ipC != null && this.ipL != null) {
            a(this.mHostView, this.ipM, this.ipL.getMaskType() == 1, this.ipC.ccC(), this.ipO);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.ipK = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.ipK.h(z, z2, z3);
        if (i != -1) {
            this.ipK.yF(i);
        }
        if (this.ipN != null && this.ipN.getUserData() != null) {
            this.ipK.setUserName(this.ipN.getUserData().getUserName());
        }
        this.ipK.onChangeSkinType();
        this.bCx = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.ipK.getView());
        this.bCx.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.bCx, this.mPageContext.getPageActivity());
            if (this.ipK.caS() != null && view.getId() == this.ipK.caS().getId()) {
                ccP();
            } else if (this.ipK.caR() != null && view.getId() == this.ipK.caR().getId()) {
                if (this.ipM) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.ckh, null, false, null)));
            } else if (this.ipK.caT() != null && view.getId() == this.ipK.caT().getId()) {
                if (!j.kc()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.ipC != null) {
                    if (this.ipC.ccC() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ipC.ccD(), this.ipC.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.ipC.getUniqueId();
                        this.ipC.a(false, userMuteAddAndDelCustomMessage, this.ipC.ccD(), this.mUserName);
                    } else if (this.ipC.ccC() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ipC.ccD(), this.ipC.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.ipC.getUniqueId();
                        this.ipC.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.ipK.caU() != null && view.getId() == this.ipK.caU().getId()) {
                if (this.gSw != null) {
                    TiebaStatic.log(new an("c13063").P("obj_locate", 1));
                    this.gSw.uV(String.valueOf(this.mUserId));
                }
            } else if (this.ipK.caV() != null && view.getId() == this.ipK.caV().getId()) {
                if (!j.kc()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    ccO();
                }
            }
        }
    }

    private void ccO() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.ipP.av(f.this.mUserId);
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
            aVar.agI();
        }
    }

    protected void ccP() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.ipL.getMaskType() == 1) {
                            f.this.ipL.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.ipL.addToBlackList(f.this.mUserId);
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
            if (this.ipL.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.mO(format);
            aVar.b(this.mPageContext);
            aVar.agI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pO(boolean z) {
        this.ipM = z;
        if (this.ipN != null) {
            this.ipN.pQ(this.ipM);
        }
        if (this.ipK != null && this.ipL != null) {
            this.ipK.h(this.ipM, this.ipL.getMaskType() == 1, this.ipO);
        }
    }
}
