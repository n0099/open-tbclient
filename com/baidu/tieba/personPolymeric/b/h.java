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
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TbPageContext GO;
    private String amO;
    private com.baidu.tieba.person.e etn;
    private a eto;
    private MorePopupWindow etp;
    private BlackListModel etq;
    private boolean etr;
    private com.baidu.tieba.personPolymeric.c.n ets;
    private final com.baidu.adp.framework.listener.e ett = new i(this, 104102);
    final com.baidu.adp.framework.listener.e etu = new j(this, 304102);
    final CustomMessageListener etv = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener etw = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e etx = new m(this, 304103);
    private View mHostView;
    private long mUserId;
    private String mUserName;

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.GO = tbPageContext;
        this.eto = aVar;
        this.etq = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.GO.registerListener(this.ett);
        this.GO.registerListener(this.etu);
        this.GO.registerListener(this.etx);
        this.GO.registerListener(this.etw);
        this.GO.registerListener(this.etv);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.etq != null && nVar != null && nVar.getUserData() != null) {
            this.ets = nVar;
            this.etr = nVar.atI();
            BlackListModel blackListModel = this.etq;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.amO = nVar.getUserData().getPortrait();
        }
    }

    public void aPD() {
        if (this.eto != null && this.etq != null) {
            a(this.mHostView, this.etr, this.etq.getMaskType() == 1, this.eto.aPB());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.etn = new com.baidu.tieba.person.e(this.GO, this);
        this.etp = new MorePopupWindow(this.GO.getPageActivity(), this.etn.getView(), view, this.GO.getResources().getDrawable(r.f.bg_pull_down_right_n), new n(this));
        this.etp.onChangeSkinType(this.GO.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.GO.getResources().getDrawable(r.f.bg_pull_down_right_n));
        this.etn.B(z, z2);
        if (i != -1) {
            this.etn.of(i);
        }
        this.etp.refresh();
        this.etp.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.etn.aOx() != null && view.getId() == this.etn.aOx().getId()) {
                com.baidu.adp.lib.h.j.a(this.etp, this.GO.getPageActivity());
                aPE();
            } else if (this.etn.aOw() != null && view.getId() == this.etn.aOw().getId()) {
                com.baidu.adp.lib.h.j.a(this.etp, this.GO.getPageActivity());
                if (this.etr) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.GO.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.amO, null, false, null)));
            } else if (this.etn.aOy() != null && view.getId() == this.etn.aOy().getId()) {
                com.baidu.adp.lib.h.j.a(this.etp, this.GO.getPageActivity());
                if (!com.baidu.adp.lib.util.i.gm()) {
                    this.GO.showToast(r.j.neterror);
                } else if (this.eto != null) {
                    if (this.eto.aPB() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eto.aPC(), this.eto.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eto.getUniqueId();
                        this.eto.a(false, userMuteAddAndDelCustomMessage, this.eto.aPC(), this.mUserName);
                    } else if (this.eto.aPB() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eto.aPC(), this.eto.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eto.getUniqueId();
                        this.eto.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aPE() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
            aVar.a(r.j.confirm, new o(this));
            aVar.b(r.j.cancel, new p(this));
            if (this.etq.getMaskType() == 1) {
                format = String.format(this.GO.getString(r.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.GO.getString(r.j.block_chat_message_alert), this.mUserName);
            }
            aVar.cG(format);
            aVar.b(this.GO);
            aVar.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jc(boolean z) {
        this.etr = z;
        if (this.ets != null) {
            this.ets.je(this.etr);
        }
        if (this.etn != null && this.etq != null) {
            this.etn.B(this.etr, this.etq.getMaskType() == 1);
        }
    }
}
