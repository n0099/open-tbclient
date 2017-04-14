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
    private TbPageContext ajT;
    private String arE;
    private com.baidu.tieba.person.e eEF;
    private a eEG;
    private MorePopupWindow eEH;
    private BlackListModel eEI;
    private boolean eEJ;
    private com.baidu.tieba.personPolymeric.c.n eEK;
    private final com.baidu.adp.framework.listener.e eEL = new i(this, 104102);
    final com.baidu.adp.framework.listener.e eEM = new j(this, 304102);
    final CustomMessageListener eEN = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener eEO = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eEP = new m(this, 304103);
    private View mHostView;
    private long mUserId;
    private String mUserName;

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.ajT = tbPageContext;
        this.eEG = aVar;
        this.eEI = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.ajT.registerListener(this.eEL);
        this.ajT.registerListener(this.eEM);
        this.ajT.registerListener(this.eEP);
        this.ajT.registerListener(this.eEO);
        this.ajT.registerListener(this.eEN);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.eEI != null && nVar != null && nVar.getUserData() != null) {
            this.eEK = nVar;
            this.eEJ = nVar.auc();
            BlackListModel blackListModel = this.eEI;
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

    public void aRo() {
        if (this.eEG != null && this.eEI != null) {
            a(this.mHostView, this.eEJ, this.eEI.getMaskType() == 1, this.eEG.aRm());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eEF = new com.baidu.tieba.person.e(this.ajT, this);
        this.eEH = new MorePopupWindow(this.ajT.getPageActivity(), this.eEF.getView(), view, this.ajT.getResources().getDrawable(w.g.bg_pull_down_right_n), new n(this));
        this.eEH.onChangeSkinType(this.ajT.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.ajT.getResources().getDrawable(w.g.bg_pull_down_right_n));
        this.eEF.y(z, z2);
        if (i != -1) {
            this.eEF.oR(i);
        }
        this.eEH.refresh();
        this.eEH.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eEF.aQj() != null && view.getId() == this.eEF.aQj().getId()) {
                com.baidu.adp.lib.g.j.a(this.eEH, this.ajT.getPageActivity());
                aRp();
            } else if (this.eEF.aQi() != null && view.getId() == this.eEF.aQi().getId()) {
                com.baidu.adp.lib.g.j.a(this.eEH, this.ajT.getPageActivity());
                if (this.eEJ) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.ajT.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.arE, null, false, null)));
            } else if (this.eEF.aQk() != null && view.getId() == this.eEF.aQk().getId()) {
                com.baidu.adp.lib.g.j.a(this.eEH, this.ajT.getPageActivity());
                if (!com.baidu.adp.lib.util.i.hj()) {
                    this.ajT.showToast(w.l.neterror);
                } else if (this.eEG != null) {
                    if (this.eEG.aRm() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eEG.aRn(), this.eEG.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eEG.getUniqueId();
                        this.eEG.a(false, userMuteAddAndDelCustomMessage, this.eEG.aRn(), this.mUserName);
                    } else if (this.eEG.aRm() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eEG.aRn(), this.eEG.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eEG.getUniqueId();
                        this.eEG.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aRp() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajT.getPageActivity());
            aVar.a(w.l.confirm, new o(this));
            aVar.b(w.l.cancel, new p(this));
            if (this.eEI.getMaskType() == 1) {
                format = String.format(this.ajT.getString(w.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.ajT.getString(w.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cE(format);
            aVar.b(this.ajT);
            aVar.tQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(boolean z) {
        this.eEJ = z;
        if (this.eEK != null) {
            this.eEK.jm(this.eEJ);
        }
        if (this.eEF != null && this.eEI != null) {
            this.eEF.y(this.eEJ, this.eEI.getMaskType() == 1);
        }
    }
}
