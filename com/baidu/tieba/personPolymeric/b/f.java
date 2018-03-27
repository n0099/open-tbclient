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
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    protected String blb;
    private com.baidu.tieba.person.e cXG;
    protected com.baidu.tieba.personPolymeric.c.a goA;
    private final com.baidu.adp.framework.listener.c goB = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.goy.setMaskType(1);
                    } else {
                        f.this.goy.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.goy.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c goC = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lG(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener goD = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lG(true);
            }
        }
    };
    private final CustomMessageListener goE = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lG(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lG(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c goF = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected c goo;
    private com.baidu.tieba.person.f gow;
    private j gox;
    private BlackListModel goy;
    protected boolean goz;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.goo = cVar;
        this.goy = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        this.gox = new j(tbPageContext, bdUniqueId);
        registerListener();
    }

    public void registerListener() {
        this.goB.setTag(this.mBdUniqueId);
        this.goC.setTag(this.mBdUniqueId);
        this.goF.setTag(this.mBdUniqueId);
        this.goE.setTag(this.mBdUniqueId);
        this.goD.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.goB);
        this.mPageContext.registerListener(this.goC);
        this.mPageContext.registerListener(this.goF);
        this.mPageContext.registerListener(this.goE);
        this.mPageContext.registerListener(this.goD);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.goy != null && aVar != null && aVar.getUserData() != null) {
            this.goA = aVar;
            this.goz = aVar.aMx();
            this.goy.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.blb = aVar.getUserData().getPortrait();
        }
    }

    public void bkg() {
        if (this.goo != null && this.goy != null) {
            a(this.mHostView, this.goz, this.goy.getMaskType() == 1, this.goo.bjW());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.gow = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gow.P(z, z2);
        if (i != -1) {
            this.gow.tD(i);
        }
        if (this.goA != null && this.goA.getUserData() != null) {
            this.gow.setUserName(this.goA.getUserData().getUserName());
        }
        this.gow.onChangeSkinType();
        this.cXG = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gow.getView());
        this.cXG.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.cXG, this.mPageContext.getPageActivity());
            if (this.gow.biy() != null && view.getId() == this.gow.biy().getId()) {
                bkh();
            } else if (this.gow.bix() != null && view.getId() == this.gow.bix().getId()) {
                if (this.goz) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.blb, null, false, null)));
            } else if (this.gow.biz() != null && view.getId() == this.gow.biz().getId()) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.goo != null) {
                    if (this.goo.bjW() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.goo.bjX(), this.goo.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.goo.getUniqueId();
                        this.goo.a(false, userMuteAddAndDelCustomMessage, this.goo.bjX(), this.mUserName);
                    } else if (this.goo.bjW() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.goo.bjX(), this.goo.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.goo.getUniqueId();
                        this.goo.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gow.biA() != null && view.getId() == this.gow.biA().getId()) {
                this.gox.jJ(String.valueOf(this.mUserId));
            }
        }
    }

    protected void bkh() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.goy.getMaskType() == 1) {
                            f.this.goy.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.goy.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.goy.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.j.block_chat_message_alert), this.mUserName);
            }
            aVar.dk(format);
            aVar.b(this.mPageContext);
            aVar.AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        this.goz = z;
        if (this.goA != null) {
            this.goA.lI(this.goz);
        }
        if (this.gow != null && this.goy != null) {
            this.gow.P(this.goz, this.goy.getMaskType() == 1);
        }
    }
}
