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
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TbPageContext GM;
    private String amL;
    private com.baidu.tieba.person.f eHm;
    private a eHn;
    private MorePopupWindow eHo;
    private BlackListModel eHp;
    private boolean eHq;
    private com.baidu.tieba.personPolymeric.c.n eHr;
    private View mHostView;
    private long mUserId;
    private String mUserName;
    private final com.baidu.adp.framework.listener.e eHs = new i(this, 104102);
    final com.baidu.adp.framework.listener.e eHt = new j(this, 304102);
    final CustomMessageListener eHu = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aUM = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eHv = new m(this, 304103);

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.GM = tbPageContext;
        this.eHn = aVar;
        this.eHp = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.GM.registerListener(this.eHs);
        this.GM.registerListener(this.eHt);
        this.GM.registerListener(this.eHv);
        this.GM.registerListener(this.aUM);
        this.GM.registerListener(this.eHu);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.eHp != null && nVar != null && nVar.getUserData() != null) {
            this.eHr = nVar;
            this.eHq = nVar.awN();
            BlackListModel blackListModel = this.eHp;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.amL = nVar.getUserData().getPortrait();
        }
    }

    public void aTp() {
        if (this.eHn != null && this.eHp != null) {
            a(this.mHostView, this.eHq, this.eHp.getMaskType() == 1, this.eHn.aTn());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eHm = new com.baidu.tieba.person.f(this.GM, this);
        this.eHo = new MorePopupWindow(this.GM.getPageActivity(), this.eHm.getView(), view, this.GM.getResources().getDrawable(t.f.bg_pull_down_right_n), new n(this));
        this.eHo.onChangeSkinType(this.GM.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.GM.getResources().getDrawable(t.f.bg_pull_down_right_n));
        this.eHm.w(z, z2);
        if (i != -1) {
            this.eHm.oG(i);
        }
        this.eHo.refresh();
        this.eHo.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eHm.aSd() != null && view.getId() == this.eHm.aSd().getId()) {
                com.baidu.adp.lib.h.j.a(this.eHo, this.GM.getPageActivity());
                aTq();
            } else if (this.eHm.aSc() != null && view.getId() == this.eHm.aSc().getId()) {
                com.baidu.adp.lib.h.j.a(this.eHo, this.GM.getPageActivity());
                if (this.eHq) {
                    com.baidu.tbadk.newFriends.a.FA().Q(this.mUserId);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.GM.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.amL, null, false, null)));
                }
            } else if (this.eHm.aSe() != null && view.getId() == this.eHm.aSe().getId()) {
                com.baidu.adp.lib.h.j.a(this.eHo, this.GM.getPageActivity());
                if (!com.baidu.adp.lib.util.i.gm()) {
                    this.GM.showToast(t.j.neterror);
                } else if (this.eHn != null) {
                    if (this.eHn.aTn() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eHn.aTo(), this.eHn.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eHn.getUniqueId();
                        this.eHn.a(false, userMuteAddAndDelCustomMessage, this.eHn.aTo(), this.mUserName);
                    } else if (this.eHn.aTn() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eHn.aTo(), this.eHn.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eHn.getUniqueId();
                        this.eHn.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aTq() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
            aVar.a(t.j.confirm, new o(this));
            aVar.b(t.j.cancel, new p(this));
            if (this.eHp.getMaskType() == 1) {
                format = String.format(this.GM.getString(t.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.GM.getString(t.j.block_chat_message_alert), this.mUserName);
            }
            aVar.cB(format);
            aVar.b(this.GM);
            aVar.sX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(boolean z) {
        this.eHq = z;
        if (this.eHr != null) {
            this.eHr.iQ(this.eHq);
        }
        if (this.eHm != null && this.eHp != null) {
            this.eHm.w(this.eHq, this.eHp.getMaskType() == 1);
        }
    }
}
