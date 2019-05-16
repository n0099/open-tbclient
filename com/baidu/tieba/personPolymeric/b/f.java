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
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes6.dex */
public class f implements View.OnClickListener {
    private com.baidu.tieba.person.e bBz;
    protected String cjb;
    private com.baidu.tieba.ueg.a gMj;
    protected c ijg;
    private com.baidu.tieba.person.f ijo;
    private BlackListModel ijp;
    protected boolean ijq;
    protected com.baidu.tieba.personPolymeric.c.a ijr;
    private boolean ijs;
    private ai ijt;
    private final com.baidu.adp.framework.listener.c iju = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.ijp.setMaskType(1);
                    } else {
                        f.this.ijp.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.ijp.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c ijv = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.pz(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener ijw = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.pz(true);
            }
        }
    };
    private final CustomMessageListener ijx = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.pz(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.pz(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c ijy = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
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
        this.ijg = cVar;
        this.ijp = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.gMj = (com.baidu.tieba.ueg.a) runTask.getData();
            this.gMj.r(bdUniqueId);
        }
        registerListener();
        this.ijt = new ai(tbPageContext, this.mBdUniqueId);
        this.ijt.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
                    f.this.ijs = false;
                }
            }
        });
    }

    public void registerListener() {
        this.iju.setTag(this.mBdUniqueId);
        this.ijv.setTag(this.mBdUniqueId);
        this.ijy.setTag(this.mBdUniqueId);
        this.ijx.setTag(this.mBdUniqueId);
        this.ijw.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.iju);
        this.mPageContext.registerListener(this.ijv);
        this.mPageContext.registerListener(this.ijy);
        this.mPageContext.registerListener(this.ijx);
        this.mPageContext.registerListener(this.ijw);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.ijp != null && aVar != null && aVar.getUserData() != null) {
            this.ijr = aVar;
            UserData userData = aVar.getUserData();
            this.ijq = aVar.bEi();
            this.ijp.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.cjb = userData.getPortrait();
            this.ijs = userData.getIsMyFans() == 1;
        }
    }

    public void bZU() {
        if (this.ijg != null && this.ijp != null) {
            a(this.mHostView, this.ijq, this.ijp.getMaskType() == 1, this.ijg.bZJ(), this.ijs);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.ijo = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.ijo.h(z, z2, z3);
        if (i != -1) {
            this.ijo.ya(i);
        }
        if (this.ijr != null && this.ijr.getUserData() != null) {
            this.ijo.setUserName(this.ijr.getUserData().getUserName());
        }
        this.ijo.onChangeSkinType();
        this.bBz = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.ijo.getView());
        this.bBz.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.bBz, this.mPageContext.getPageActivity());
            if (this.ijo.bXZ() != null && view.getId() == this.ijo.bXZ().getId()) {
                bZW();
            } else if (this.ijo.bXY() != null && view.getId() == this.ijo.bXY().getId()) {
                if (this.ijq) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.cjb, null, false, null)));
            } else if (this.ijo.bYa() != null && view.getId() == this.ijo.bYa().getId()) {
                if (!j.jS()) {
                    this.mPageContext.showToast(R.string.neterror);
                } else if (this.ijg != null) {
                    if (this.ijg.bZJ() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ijg.bZK(), this.ijg.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.ijg.getUniqueId();
                        this.ijg.a(false, userMuteAddAndDelCustomMessage, this.ijg.bZK(), this.mUserName);
                    } else if (this.ijg.bZJ() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ijg.bZK(), this.ijg.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.ijg.getUniqueId();
                        this.ijg.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.ijo.bYb() != null && view.getId() == this.ijo.bYb().getId()) {
                if (this.gMj != null) {
                    TiebaStatic.log(new am("c13063").P("obj_locate", 1));
                    this.gMj.ut(String.valueOf(this.mUserId));
                }
            } else if (this.ijo.bYc() != null && view.getId() == this.ijo.bYc().getId()) {
                if (!j.jS()) {
                    l.showToast(this.mPageContext.getPageActivity(), (int) R.string.neterror);
                } else {
                    bZV();
                }
            }
        }
    }

    private void bZV() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.ijt.au(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.mE(String.format(this.mPageContext.getString(R.string.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.afG();
        }
    }

    protected void bZW() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.ijp.getMaskType() == 1) {
                            f.this.ijp.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.ijp.addToBlackList(f.this.mUserId);
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
            if (this.ijp.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(R.string.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(R.string.block_chat_message_alert), this.mUserName);
            }
            aVar.mE(format);
            aVar.b(this.mPageContext);
            aVar.afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pz(boolean z) {
        this.ijq = z;
        if (this.ijr != null) {
            this.ijr.pB(this.ijq);
        }
        if (this.ijo != null && this.ijp != null) {
            this.ijo.h(this.ijq, this.ijp.getMaskType() == 1, this.ijs);
        }
    }
}
