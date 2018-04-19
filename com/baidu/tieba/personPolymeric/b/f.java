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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.j;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    protected String awF;
    private com.baidu.tieba.person.e cpy;
    protected c fIM;
    private com.baidu.tieba.person.f fIU;
    private k fIV;
    private BlackListModel fIW;
    protected boolean fIX;
    protected com.baidu.tieba.personPolymeric.c.a fIY;
    private boolean fIZ;
    private j fJa;
    private final com.baidu.adp.framework.listener.c fJb = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.fIW.setMaskType(1);
                    } else {
                        f.this.fIW.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.fIW.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.k.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(d.k.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fJc = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lg(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fJd = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lg(true);
            }
        }
    };
    private final CustomMessageListener fJe = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lg(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lg(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fJf = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.k.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view2, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fIM = cVar;
        this.fIW = blackListModel;
        this.mHostView = view2;
        this.mBdUniqueId = bdUniqueId;
        this.fIV = new k(tbPageContext, bdUniqueId);
        registerListener();
        this.fJa = new j(tbPageContext, this.mBdUniqueId);
        this.fJa.a(new j.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.j.a
            public void a(int i, String str, long j, boolean z) {
                if (z) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(d.k.remove_fans_success) : f.this.mPageContext.getString(d.k.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.fIZ = false;
                }
            }
        });
    }

    public void registerListener() {
        this.fJb.setTag(this.mBdUniqueId);
        this.fJc.setTag(this.mBdUniqueId);
        this.fJf.setTag(this.mBdUniqueId);
        this.fJe.setTag(this.mBdUniqueId);
        this.fJd.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.fJb);
        this.mPageContext.registerListener(this.fJc);
        this.mPageContext.registerListener(this.fJf);
        this.mPageContext.registerListener(this.fJe);
        this.mPageContext.registerListener(this.fJd);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fIW != null && aVar != null && aVar.getUserData() != null) {
            this.fIY = aVar;
            this.fIX = aVar.aHx();
            this.fIW.setMaskType(aVar.getUserData().isMask() ? 1 : 0);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.awF = aVar.getUserData().getPortrait();
            this.fIZ = aVar.getUserData().getIsMyFans() == 1;
        }
    }

    public void bfj() {
        if (this.fIM != null && this.fIW != null) {
            a(this.mHostView, this.fIX, this.fIW.getMaskType() == 1, this.fIM.beZ(), this.fIZ);
        }
    }

    public void a(View view2, boolean z, boolean z2, int i, boolean z3) {
        this.fIU = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.fIU.j(z, z2, z3);
        if (i != -1) {
            this.fIU.qZ(i);
        }
        if (this.fIY != null && this.fIY.getUserData() != null) {
            this.fIU.setUserName(this.fIY.getUserData().getUserName());
        }
        this.fIU.onChangeSkinType();
        this.cpy = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.fIU.getView());
        this.cpy.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            com.baidu.adp.lib.g.g.b(this.cpy, this.mPageContext.getPageActivity());
            if (this.fIU.bdy() != null && view2.getId() == this.fIU.bdy().getId()) {
                bfl();
            } else if (this.fIU.bdx() != null && view2.getId() == this.fIU.bdx().getId()) {
                if (this.fIX) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.awF, null, false, null)));
            } else if (this.fIU.bdz() != null && view2.getId() == this.fIU.bdz().getId()) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    this.mPageContext.showToast(d.k.neterror);
                } else if (this.fIM != null) {
                    if (this.fIM.beZ() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fIM.bfa(), this.fIM.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fIM.getUniqueId();
                        this.fIM.a(false, userMuteAddAndDelCustomMessage, this.fIM.bfa(), this.mUserName);
                    } else if (this.fIM.beZ() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fIM.bfa(), this.fIM.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fIM.getUniqueId();
                        this.fIM.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.fIU.bdA() != null && view2.getId() == this.fIU.bdA().getId()) {
                this.fIV.jN(String.valueOf(this.mUserId));
            } else if (this.fIU.bdB() != null && view2.getId() == this.fIU.bdB().getId()) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    l.showToast(this.mPageContext.getPageActivity(), d.k.neterror);
                } else {
                    bfk();
                }
            }
        }
    }

    private void bfk() {
        if (this.mUserId != 0 && !StringUtils.isNull(this.mUserName)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.fJa.cL(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.dc(String.format(this.mPageContext.getString(d.k.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.tD();
        }
    }

    protected void bfl() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.fIW.getMaskType() == 1) {
                            f.this.fIW.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.fIW.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.fIW.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.k.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.k.block_chat_message_alert), this.mUserName);
            }
            aVar.dc(format);
            aVar.b(this.mPageContext);
            aVar.tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg(boolean z) {
        this.fIX = z;
        if (this.fIY != null) {
            this.fIY.li(this.fIX);
        }
        if (this.fIU != null && this.fIW != null) {
            this.fIU.j(this.fIX, this.fIW.getMaskType() == 1, this.fIZ);
        }
    }
}
