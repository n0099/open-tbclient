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
import com.baidu.tieba.e;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    protected String aRP;
    private com.baidu.tieba.person.e ane;
    private com.baidu.tieba.ueg.a fbx;
    protected c gwM;
    private com.baidu.tieba.person.f gwU;
    private BlackListModel gwV;
    protected boolean gwW;
    protected com.baidu.tieba.personPolymeric.c.a gwX;
    private boolean gwY;
    private ai gwZ;
    private final com.baidu.adp.framework.listener.c gxa = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        f.this.gwV.setMaskType(1);
                    } else {
                        f.this.gwV.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (f.this.gwV.getMaskType() == 1) {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(e.j.chat_message_blocked));
                            return;
                        } else {
                            f.this.mPageContext.showToast(f.this.mPageContext.getString(e.j.remove_succ));
                            return;
                        }
                    }
                    f.this.mPageContext.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c gxb = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    f.this.mk(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                f.this.mPageContext.showToast(errorString);
            }
        }
    };
    final CustomMessageListener gxc = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                f.this.mk(true);
            }
        }
    };
    private final CustomMessageListener gxd = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.personPolymeric.b.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    f.this.mk(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    f.this.mk(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gxe = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                f.this.mPageContext.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? f.this.mPageContext.getResources().getString(e.j.neterror) : socketResponsedMessage.getErrorString());
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
        this.gwM = cVar;
        this.gwV = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            this.fbx = (com.baidu.tieba.ueg.a) runTask.getData();
            this.fbx.o(bdUniqueId);
        }
        registerListener();
        this.gwZ = new ai(tbPageContext, this.mBdUniqueId);
        this.gwZ.a(new ai.a() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.showToast(f.this.mPageContext.getPageActivity(), i == 0 ? f.this.mPageContext.getString(e.j.remove_fans_success) : f.this.mPageContext.getString(e.j.remove_fans_fail));
                    } else {
                        l.showToast(f.this.mPageContext.getPageActivity(), str);
                    }
                }
                if (j == f.this.mUserId && i == 0) {
                    f.this.gwY = false;
                }
            }
        });
    }

    public void registerListener() {
        this.gxa.setTag(this.mBdUniqueId);
        this.gxb.setTag(this.mBdUniqueId);
        this.gxe.setTag(this.mBdUniqueId);
        this.gxd.setTag(this.mBdUniqueId);
        this.gxc.setTag(this.mBdUniqueId);
        this.mPageContext.registerListener(this.gxa);
        this.mPageContext.registerListener(this.gxb);
        this.mPageContext.registerListener(this.gxe);
        this.mPageContext.registerListener(this.gxd);
        this.mPageContext.registerListener(this.gxc);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.gwV != null && aVar != null && aVar.getUserData() != null) {
            this.gwX = aVar;
            UserData userData = aVar.getUserData();
            this.gwW = aVar.aUL();
            this.gwV.setMaskType(userData.isMask() ? 1 : 0);
            this.mUserName = userData.getName_show();
            this.mUserId = userData.getUserIdLong();
            this.aRP = userData.getPortrait();
            this.gwY = userData.getIsMyFans() == 1;
        }
    }

    public void bqf() {
        if (this.gwM != null && this.gwV != null) {
            a(this.mHostView, this.gwW, this.gwV.getMaskType() == 1, this.gwM.bpV(), this.gwY);
        }
    }

    public void a(View view, boolean z, boolean z2, int i, boolean z3) {
        this.gwU = new com.baidu.tieba.person.f(this.mPageContext, this);
        this.gwU.i(z, z2, z3);
        if (i != -1) {
            this.gwU.sX(i);
        }
        if (this.gwX != null && this.gwX.getUserData() != null) {
            this.gwU.setUserName(this.gwX.getUserData().getUserName());
        }
        this.gwU.onChangeSkinType();
        this.ane = new com.baidu.tieba.person.e(this.mPageContext.getPageActivity(), this.gwU.getView());
        this.ane.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.ane, this.mPageContext.getPageActivity());
            if (this.gwU.bos() != null && view.getId() == this.gwU.bos().getId()) {
                bqh();
            } else if (this.gwU.bor() != null && view.getId() == this.gwU.bor().getId()) {
                if (this.gwW) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mPageContext.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aRP, null, false, null)));
            } else if (this.gwU.bot() != null && view.getId() == this.gwU.bot().getId()) {
                if (!j.kV()) {
                    this.mPageContext.showToast(e.j.neterror);
                } else if (this.gwM != null) {
                    if (this.gwM.bpV() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gwM.bpW(), this.gwM.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.gwM.getUniqueId();
                        this.gwM.a(false, userMuteAddAndDelCustomMessage, this.gwM.bpW(), this.mUserName);
                    } else if (this.gwM.bpV() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.gwM.bpW(), this.gwM.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.gwM.getUniqueId();
                        this.gwM.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            } else if (this.gwU.bou() != null && view.getId() == this.gwU.bou().getId()) {
                if (this.fbx != null) {
                    TiebaStatic.log(new am("c13063").x("obj_locate", 1));
                    this.fbx.mg(String.valueOf(this.mUserId));
                }
            } else if (this.gwU.bov() != null && view.getId() == this.gwU.bov().getId()) {
                if (!j.kV()) {
                    l.showToast(this.mPageContext.getPageActivity(), e.j.neterror);
                } else {
                    bqg();
                }
            }
        }
    }

    private void bqg() {
        if (this.mUserId != 0) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    f.this.gwZ.F(f.this.mUserId);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.eB(String.format(this.mPageContext.getString(e.j.remove_fans_alert_text), this.mUserName));
            aVar.b(this.mPageContext);
            aVar.BF();
        }
    }

    protected void bqh() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (f.this.mUserId > 0) {
                        if (f.this.gwV.getMaskType() == 1) {
                            f.this.gwV.removeFromBlackList(f.this.mUserId);
                        } else {
                            f.this.gwV.addToBlackList(f.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.gwV.getMaskType() == 1) {
                format = String.format(this.mPageContext.getString(e.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.mPageContext.getString(e.j.block_chat_message_alert), this.mUserName);
            }
            aVar.eB(format);
            aVar.b(this.mPageContext);
            aVar.BF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk(boolean z) {
        this.gwW = z;
        if (this.gwX != null) {
            this.gwX.mm(this.gwW);
        }
        if (this.gwU != null && this.gwV != null) {
            this.gwU.i(this.gwW, this.gwV.getMaskType() == 1, this.gwY);
        }
    }
}
