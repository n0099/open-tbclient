package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
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
    private TbPageContext ajr;
    private String arG;
    private com.baidu.tieba.person.e eCk;
    private a eCl;
    private MorePopupWindow eCm;
    private BlackListModel eCn;
    private boolean eCo;
    private com.baidu.tieba.personPolymeric.c.n eCp;
    private final com.baidu.adp.framework.listener.e eCq = new i(this, 104102);
    final com.baidu.adp.framework.listener.e eCr = new j(this, 304102);
    final CustomMessageListener eCs = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener eCt = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eCu = new m(this, 304103);
    private BdUniqueId mBdUniqueId;
    private View mHostView;
    private long mUserId;
    private String mUserName;

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.ajr = tbPageContext;
        this.eCl = aVar;
        this.eCn = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.eCq.setTag(this.mBdUniqueId);
        this.eCr.setTag(this.mBdUniqueId);
        this.eCu.setTag(this.mBdUniqueId);
        this.eCt.setTag(this.mBdUniqueId);
        this.eCs.setTag(this.mBdUniqueId);
        this.ajr.registerListener(this.eCq);
        this.ajr.registerListener(this.eCr);
        this.ajr.registerListener(this.eCu);
        this.ajr.registerListener(this.eCt);
        this.ajr.registerListener(this.eCs);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.eCn != null && nVar != null && nVar.getUserData() != null) {
            this.eCp = nVar;
            this.eCo = nVar.arY();
            BlackListModel blackListModel = this.eCn;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.arG = nVar.getUserData().getPortrait();
        }
    }

    public void aPC() {
        if (this.eCl != null && this.eCn != null) {
            a(this.mHostView, this.eCo, this.eCn.getMaskType() == 1, this.eCl.aPA());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eCk = new com.baidu.tieba.person.e(this.ajr, this);
        this.eCm = new MorePopupWindow(this.ajr.getPageActivity(), this.eCk.getView(), view, this.ajr.getResources().getDrawable(w.g.bg_pull_down_right_n), new n(this));
        this.eCm.onChangeSkinType(this.ajr.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.ajr.getResources().getDrawable(w.g.bg_pull_down_right_n));
        this.eCk.y(z, z2);
        if (i != -1) {
            this.eCk.oO(i);
        }
        this.eCm.refresh();
        this.eCm.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eCk.aOC() != null && view.getId() == this.eCk.aOC().getId()) {
                com.baidu.adp.lib.g.j.a(this.eCm, this.ajr.getPageActivity());
                aPD();
            } else if (this.eCk.aOB() != null && view.getId() == this.eCk.aOB().getId()) {
                com.baidu.adp.lib.g.j.a(this.eCm, this.ajr.getPageActivity());
                if (this.eCo) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.ajr.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.arG, null, false, null)));
            } else if (this.eCk.aOD() != null && view.getId() == this.eCk.aOD().getId()) {
                com.baidu.adp.lib.g.j.a(this.eCm, this.ajr.getPageActivity());
                if (!com.baidu.adp.lib.util.i.hk()) {
                    this.ajr.showToast(w.l.neterror);
                } else if (this.eCl != null) {
                    if (this.eCl.aPA() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eCl.aPB(), this.eCl.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eCl.getUniqueId();
                        this.eCl.a(false, userMuteAddAndDelCustomMessage, this.eCl.aPB(), this.mUserName);
                    } else if (this.eCl.aPA() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eCl.aPB(), this.eCl.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eCl.getUniqueId();
                        this.eCl.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aPD() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajr.getPageActivity());
            aVar.a(w.l.confirm, new o(this));
            aVar.b(w.l.cancel, new p(this));
            if (this.eCn.getMaskType() == 1) {
                format = String.format(this.ajr.getString(w.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.ajr.getString(w.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cC(format);
            aVar.b(this.ajr);
            aVar.td();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(boolean z) {
        this.eCo = z;
        if (this.eCp != null) {
            this.eCp.jc(this.eCo);
        }
        if (this.eCk != null && this.eCn != null) {
            this.eCk.y(this.eCo, this.eCn.getMaskType() == 1);
        }
    }
}
