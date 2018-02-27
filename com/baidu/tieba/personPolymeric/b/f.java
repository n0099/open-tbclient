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
    protected String bkY;
    private com.baidu.tieba.person.e cXD;
    protected c gnX;
    private com.baidu.tieba.person.f gog;
    private j goh;
    private BlackListModel goi;
    protected boolean goj;
    protected com.baidu.tieba.personPolymeric.c.a gok;
    private final com.baidu.adp.framework.listener.c gol = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.goi.setMaskType(1);
                    } else {
                        f.this.goi.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.goi.getMaskType() == 1) {
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
    final com.baidu.adp.framework.listener.c gom = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.4
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
    final CustomMessageListener gon = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.lB(true);
            }
        }
    };
    private final CustomMessageListener goo = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.6
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
    private final com.baidu.adp.framework.listener.c gop = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.7
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
        this.gnX = cVar;
        this.goi = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        this.goh = new j(tbPageContext, bdUniqueId);
        registerListener();
    }

    public void registerListener() {
        this.gol.setTag(this.mBdUniqueId);
        this.gom.setTag(this.mBdUniqueId);
        this.gop.setTag(this.mBdUniqueId);
        this.goo.setTag(this.mBdUniqueId);
        this.gon.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.gol);
        this.mPageContext.registerListener(this.gom);
        this.mPageContext.registerListener(this.gop);
        this.mPageContext.registerListener(this.goo);
        this.mPageContext.registerListener(this.gon);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.goi != null && aVar != null && aVar.getUserData() != null) {
            this.gok = aVar;
            this.goj = aVar.aMw();
            this.goi.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.bkY = aVar.getUserData().getPortrait();
        }
    }

    public void bkf() {
        if (this.gnX != null && this.goi != null) {
            a(this.mHostView, this.goj, this.goi.getMaskType() == 1, this.gnX.bjV());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.gog = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gog.P(z, z2);
        if (i != -1) {
            this.gog.tD(i);
        }
        if (this.gok != null && this.gok.getUserData() != null) {
            this.gog.setUserName(this.gok.getUserData().getUserName());
        }
        this.gog.onChangeSkinType();
        this.cXD = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gog.getView());
        this.cXD.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.cXD, this.mPageContext.getPageActivity());
            if (this.gog.bix() != null && view.getId() == this.gog.bix().getId()) {
                bkg();
            } else if (this.gog.biw() != null && view.getId() == this.gog.biw().getId()) {
                if (this.goj) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.bkY, null, false, null)));
            } else if (this.gog.biy() != null && view.getId() == this.gog.biy().getId()) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    this.mPageContext.showToast(d.j.neterror);
                } else if (this.gnX != null) {
                    if (this.gnX.bjV() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gnX.bjW(), this.gnX.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.gnX.getUniqueId();
                        this.gnX.a(false, userMuteAddAndDelCustomMessage, this.gnX.bjW(), this.mUserName);
                    } else if (this.gnX.bjV() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gnX.bjW(), this.gnX.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.gnX.getUniqueId();
                        this.gnX.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gog.biz() != null && view.getId() == this.gog.biz().getId()) {
                this.goh.jJ(String.valueOf(this.mUserId));
            }
        }
    }

    protected void bkg() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.goi.getMaskType() == 1) {
                            f.this.goi.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.goi.addToBlackList(f.this.mUserId);
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
            if (this.goi.getMaskType() == 1) {
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
        this.goj = z;
        if (this.gok != null) {
            this.gok.lD(this.goj);
        }
        if (this.gog != null && this.goi != null) {
            this.gog.P(this.goj, this.goi.getMaskType() == 1);
        }
    }
}
