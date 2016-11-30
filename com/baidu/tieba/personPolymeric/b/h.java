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
    private String anm;
    private com.baidu.tieba.person.f ePP;
    private a ePQ;
    private MorePopupWindow ePR;
    private BlackListModel ePS;
    private boolean ePT;
    private com.baidu.tieba.personPolymeric.c.n ePU;
    private View mHostView;
    private long mUserId;
    private String mUserName;
    private final com.baidu.adp.framework.listener.e ePV = new i(this, 104102);
    final com.baidu.adp.framework.listener.e ePW = new j(this, 304102);
    final CustomMessageListener ePX = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aXH = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e ePY = new m(this, 304103);

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.GO = tbPageContext;
        this.ePQ = aVar;
        this.ePS = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.GO.registerListener(this.ePV);
        this.GO.registerListener(this.ePW);
        this.GO.registerListener(this.ePY);
        this.GO.registerListener(this.aXH);
        this.GO.registerListener(this.ePX);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.ePS != null && nVar != null && nVar.getUserData() != null) {
            this.ePU = nVar;
            this.ePT = nVar.azj();
            BlackListModel blackListModel = this.ePS;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.anm = nVar.getUserData().getPortrait();
        }
    }

    public void aVT() {
        if (this.ePQ != null && this.ePS != null) {
            a(this.mHostView, this.ePT, this.ePS.getMaskType() == 1, this.ePQ.aVR());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.ePP = new com.baidu.tieba.person.f(this.GO, this);
        this.ePR = new MorePopupWindow(this.GO.getPageActivity(), this.ePP.getView(), view, this.GO.getResources().getDrawable(r.f.bg_pull_down_right_n), new n(this));
        this.ePR.onChangeSkinType(this.GO.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.GO.getResources().getDrawable(r.f.bg_pull_down_right_n));
        this.ePP.A(z, z2);
        if (i != -1) {
            this.ePP.pd(i);
        }
        this.ePR.refresh();
        this.ePR.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.ePP.aUI() != null && view.getId() == this.ePP.aUI().getId()) {
                com.baidu.adp.lib.h.j.a(this.ePR, this.GO.getPageActivity());
                aVU();
            } else if (this.ePP.aUH() != null && view.getId() == this.ePP.aUH().getId()) {
                com.baidu.adp.lib.h.j.a(this.ePR, this.GO.getPageActivity());
                if (this.ePT) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.GO.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.anm, null, false, null)));
            } else if (this.ePP.aUJ() != null && view.getId() == this.ePP.aUJ().getId()) {
                com.baidu.adp.lib.h.j.a(this.ePR, this.GO.getPageActivity());
                if (!com.baidu.adp.lib.util.i.gm()) {
                    this.GO.showToast(r.j.neterror);
                } else if (this.ePQ != null) {
                    if (this.ePQ.aVR() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ePQ.aVS(), this.ePQ.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.ePQ.getUniqueId();
                        this.ePQ.a(false, userMuteAddAndDelCustomMessage, this.ePQ.aVS(), this.mUserName);
                    } else if (this.ePQ.aVR() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.ePQ.aVS(), this.ePQ.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.ePQ.getUniqueId();
                        this.ePQ.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aVU() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
            aVar.a(r.j.confirm, new o(this));
            aVar.b(r.j.cancel, new p(this));
            if (this.ePS.getMaskType() == 1) {
                format = String.format(this.GO.getString(r.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.GO.getString(r.j.block_chat_message_alert), this.mUserName);
            }
            aVar.cF(format);
            aVar.b(this.GO);
            aVar.tq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(boolean z) {
        this.ePT = z;
        if (this.ePU != null) {
            this.ePU.jt(this.ePT);
        }
        if (this.ePP != null && this.ePS != null) {
            this.ePP.A(this.ePT, this.ePS.getMaskType() == 1);
        }
    }
}
