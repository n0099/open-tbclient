package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TbPageContext ajU;
    private String arE;
    private com.baidu.tieba.person.e eGV;
    private a eGW;
    private MorePopupWindow eGX;
    private BlackListModel eGY;
    private boolean eGZ;
    private com.baidu.tieba.personPolymeric.c.n eHa;
    private final com.baidu.adp.framework.listener.e eHb = new i(this, 104102);
    final com.baidu.adp.framework.listener.e eHc = new j(this, 304102);
    final CustomMessageListener eHd = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener eHe = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eHf = new m(this, 304103);
    private View mHostView;
    private long mUserId;
    private String mUserName;

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.ajU = tbPageContext;
        this.eGW = aVar;
        this.eGY = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.ajU.registerListener(this.eHb);
        this.ajU.registerListener(this.eHc);
        this.ajU.registerListener(this.eHf);
        this.ajU.registerListener(this.eHe);
        this.ajU.registerListener(this.eHd);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.eGY != null && nVar != null && nVar.getUserData() != null) {
            this.eHa = nVar;
            this.eGZ = nVar.avd();
            BlackListModel blackListModel = this.eGY;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.arE = nVar.getUserData().getPortrait();
        }
    }

    public void aSp() {
        if (this.eGW != null && this.eGY != null) {
            a(this.mHostView, this.eGZ, this.eGY.getMaskType() == 1, this.eGW.aSn());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eGV = new com.baidu.tieba.person.e(this.ajU, this);
        this.eGX = new MorePopupWindow(this.ajU.getPageActivity(), this.eGV.getView(), view, this.ajU.getResources().getDrawable(w.g.bg_pull_down_right_n), new n(this));
        this.eGX.onChangeSkinType(this.ajU.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.ajU.getResources().getDrawable(w.g.bg_pull_down_right_n));
        this.eGV.y(z, z2);
        if (i != -1) {
            this.eGV.oX(i);
        }
        this.eGX.refresh();
        this.eGX.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eGV.aRk() != null && view.getId() == this.eGV.aRk().getId()) {
                com.baidu.adp.lib.g.j.a(this.eGX, this.ajU.getPageActivity());
                aSq();
            } else if (this.eGV.aRj() != null && view.getId() == this.eGV.aRj().getId()) {
                com.baidu.adp.lib.g.j.a(this.eGX, this.ajU.getPageActivity());
                if (this.eGZ) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.ajU.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.arE, null, false, null)));
            } else if (this.eGV.aRl() != null && view.getId() == this.eGV.aRl().getId()) {
                com.baidu.adp.lib.g.j.a(this.eGX, this.ajU.getPageActivity());
                if (!com.baidu.adp.lib.util.i.hk()) {
                    this.ajU.showToast(w.l.neterror);
                } else if (this.eGW != null) {
                    if (this.eGW.aSn() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eGW.aSo(), this.eGW.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eGW.getUniqueId();
                        this.eGW.a(false, userMuteAddAndDelCustomMessage, this.eGW.aSo(), this.mUserName);
                    } else if (this.eGW.aSn() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eGW.aSo(), this.eGW.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eGW.getUniqueId();
                        this.eGW.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aSq() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajU.getPageActivity());
            aVar.a(w.l.confirm, new o(this));
            aVar.b(w.l.cancel, new p(this));
            if (this.eGY.getMaskType() == 1) {
                format = String.format(this.ajU.getString(w.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.ajU.getString(w.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cE(format);
            aVar.b(this.ajU);
            aVar.tQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(boolean z) {
        this.eGZ = z;
        if (this.eHa != null) {
            this.eHa.jw(this.eGZ);
        }
        if (this.eGV != null && this.eGY != null) {
            this.eGV.y(this.eGZ, this.eGY.getMaskType() == 1);
        }
    }
}
