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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.j;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    protected TbPageContext alI;
    protected String auC;
    protected b fiO;
    private j fiV;
    private BlackListModel fiW;
    protected boolean fiX;
    protected com.baidu.tieba.personPolymeric.c.a fiY;
    private com.baidu.tieba.person.i fiZ;
    private final com.baidu.adp.framework.listener.c fja = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.personPolymeric.b.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                    if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        e.this.fiW.setMaskType(1);
                    } else {
                        e.this.fiW.setMaskType(0);
                    }
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (e.this.fiW.getMaskType() == 1) {
                            e.this.alI.showToast(e.this.alI.getString(d.l.chat_message_blocked));
                            return;
                        } else {
                            e.this.alI.showToast(e.this.alI.getString(d.l.remove_succ));
                            return;
                        }
                    }
                    e.this.alI.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? e.this.alI.getResources().getString(d.l.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c fjb = new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.personPolymeric.b.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    e.this.kp(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? e.this.alI.getResources().getString(d.l.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                e.this.alI.showToast(errorString);
            }
        }
    };
    final CustomMessageListener fjc = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                e.this.kp(true);
            }
        }
    };
    private final CustomMessageListener fjd = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.personPolymeric.b.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    e.this.kp(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    e.this.kp(true);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c fje = new com.baidu.adp.framework.listener.c(304103) { // from class: com.baidu.tieba.personPolymeric.b.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                e.this.alI.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? e.this.alI.getResources().getString(d.l.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    };
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;

    public e(TbPageContext tbPageContext, b bVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.alI = tbPageContext;
        this.fiO = bVar;
        this.fiW = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.fja.setTag(this.mBdUniqueId);
        this.fjb.setTag(this.mBdUniqueId);
        this.fje.setTag(this.mBdUniqueId);
        this.fjd.setTag(this.mBdUniqueId);
        this.fjc.setTag(this.mBdUniqueId);
        this.alI.registerListener(this.fja);
        this.alI.registerListener(this.fjb);
        this.alI.registerListener(this.fje);
        this.alI.registerListener(this.fjd);
        this.alI.registerListener(this.fjc);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.fiW != null && aVar != null && aVar.getUserData() != null) {
            this.fiY = aVar;
            this.fiX = aVar.ayu();
            this.fiW.setMaskType(!aVar.getUserData().isMask() ? 0 : 1);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.auC = aVar.getUserData().getPortrait();
        }
    }

    public void aYp() {
        if (this.fiO != null && this.fiW != null) {
            a(this.mHostView, this.fiX, this.fiW.getMaskType() == 1, this.fiO.aYd());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.fiV = new j(this.alI, this);
        this.fiV.G(z, z2);
        if (i != -1) {
            this.fiV.pW(i);
        }
        if (this.fiY != null && this.fiY.getUserData() != null) {
            this.fiV.setUserName(this.fiY.getUserData().getUserName());
        }
        this.fiV.onChangeSkinType();
        this.fiZ = new com.baidu.tieba.person.i(this.alI.getPageActivity(), this.fiV.getView());
        this.fiZ.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.fiZ, this.alI.getPageActivity());
            if (this.fiV.aXa() != null && view.getId() == this.fiV.aXa().getId()) {
                aYq();
            } else if (this.fiV.aWZ() != null && view.getId() == this.fiV.aWZ().getId()) {
                if (this.fiX) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.alI.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.auC, null, false, null)));
            } else if (this.fiV.aXb() != null && view.getId() == this.fiV.aXb().getId()) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    this.alI.showToast(d.l.neterror);
                } else if (this.fiO != null) {
                    if (this.fiO.aYd() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fiO.aYe(), this.fiO.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.fiO.getUniqueId();
                        this.fiO.a(false, userMuteAddAndDelCustomMessage, this.fiO.aYe(), this.mUserName);
                    } else if (this.fiO.aYd() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.fiO.aYe(), this.fiO.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.fiO.getUniqueId();
                        this.fiO.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aYq() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.alI.getPageActivity());
            aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (e.this.mUserId > 0) {
                        if (e.this.fiW.getMaskType() == 1) {
                            e.this.fiW.removeFromBlackList(e.this.mUserId);
                        } else {
                            e.this.fiW.addToBlackList(e.this.mUserId);
                        }
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            if (this.fiW.getMaskType() == 1) {
                format = String.format(this.alI.getString(d.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.alI.getString(d.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cT(format);
            aVar.b(this.alI);
            aVar.tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(boolean z) {
        this.fiX = z;
        if (this.fiY != null) {
            this.fiY.kr(this.fiX);
        }
        if (this.fiV != null && this.fiW != null) {
            this.fiV.G(this.fiX, this.fiW.getMaskType() == 1);
        }
    }
}
