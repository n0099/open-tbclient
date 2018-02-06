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
    protected String bll;
    private com.baidu.tieba.person.e cXP;
    protected c goj;
    private com.baidu.tieba.person.f gor;
    private j gos;
    private BlackListModel got;
    protected boolean gou;
    protected com.baidu.tieba.personPolymeric.c.a gov;
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected TbPageContext mPageContext;
    protected long mUserId;
    protected String mUserName;
    private final com.baidu.adp.framework.listener.c gow = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.got.setMaskType(1);
                    } else {
                        f.this.got.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.got.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c gox = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.lB(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener goy = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lB(true);
            }
        }
    };
    private final CustomMessageListener goz = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.lB(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.lB(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c goA = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };

    public f(TbPageContext tbPageContext, c cVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.goj = cVar;
        this.got = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        this.gos = new j(tbPageContext, bdUniqueId);
        registerListener();
    }

    public void registerListener() {
        this.gow.setTag(this.mBdUniqueId);
        this.gox.setTag(this.mBdUniqueId);
        this.goA.setTag(this.mBdUniqueId);
        this.goz.setTag(this.mBdUniqueId);
        this.goy.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.gow);
        this.mPageContext.registerListener(this.gox);
        this.mPageContext.registerListener(this.goA);
        this.mPageContext.registerListener(this.goz);
        this.mPageContext.registerListener(this.goy);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.got != null && aVar != null && aVar.getUserData() != null) {
            this.gov = aVar;
            this.gou = aVar.aMx();
            this.got.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.bll = aVar.getUserData().getPortrait();
        }
    }

    public void bkg() {
        if (this.goj != null && this.got != null) {
            a(this.mHostView, this.gou, this.got.getMaskType() == 1, this.goj.bjW());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.gor = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gor.P(z, z2);
        if (i != -1) {
            this.gor.tC(i);
        }
        if (this.gov != null && this.gov.getUserData() != null) {
            this.gor.setUserName(this.gov.getUserData().getUserName());
        }
        this.gor.onChangeSkinType();
        this.cXP = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gor.getView());
        this.cXP.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.cXP, this.mPageContext.getPageActivity());
            if (this.gor.biy() != null && view.getId() == this.gor.biy().getId()) {
                bkh();
            } else if (this.gor.bix() != null && view.getId() == this.gor.bix().getId()) {
                if (this.gou) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.bll, null, false, null)));
            } else if (this.gor.biz() != null && view.getId() == this.gor.biz().getId()) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.goj != null) {
                    if (this.goj.bjW() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.goj.bjX(), this.goj.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.goj.getUniqueId();
                        this.goj.a(false, userMuteAddAndDelCustomMessage, this.goj.bjX(), this.mUserName);
                    } else if (this.goj.bjW() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.goj.bjX(), this.goj.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.goj.getUniqueId();
                        this.goj.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gor.biA() != null && view.getId() == this.gor.biA().getId()) {
                this.gos.jJ(String.valueOf(this.mUserId));
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
                        if (f.this.got.getMaskType() == 1) {
                            f.this.got.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.got.addToBlackList(f.this.mUserId);
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
            if (this.got.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(d.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(d.j.block_chat_message_alert), this.mUserName);
            }
            aVar.dk(format);
            aVar.b(this.mPageContext);
            aVar.AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(boolean z) {
        this.gou = z;
        if (this.gov != null) {
            this.gov.lD(this.gou);
        }
        if (this.gor != null && this.got != null) {
            this.gor.P(this.gou, this.got.getMaskType() == 1);
        }
    }
}
