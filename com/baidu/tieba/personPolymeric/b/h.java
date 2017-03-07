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
    private TbPageContext ajF;
    private String aro;
    private com.baidu.tieba.person.e eGJ;
    private a eGK;
    private MorePopupWindow eGL;
    private BlackListModel eGM;
    private boolean eGN;
    private com.baidu.tieba.personPolymeric.c.n eGO;
    private final com.baidu.adp.framework.listener.e eGP = new i(this, 104102);
    final com.baidu.adp.framework.listener.e eGQ = new j(this, 304102);
    final CustomMessageListener eGR = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener eGS = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eGT = new m(this, 304103);
    private View mHostView;
    private long mUserId;
    private String mUserName;

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.ajF = tbPageContext;
        this.eGK = aVar;
        this.eGM = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.ajF.registerListener(this.eGP);
        this.ajF.registerListener(this.eGQ);
        this.ajF.registerListener(this.eGT);
        this.ajF.registerListener(this.eGS);
        this.ajF.registerListener(this.eGR);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.eGM != null && nVar != null && nVar.getUserData() != null) {
            this.eGO = nVar;
            this.eGN = nVar.auj();
            BlackListModel blackListModel = this.eGM;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.aro = nVar.getUserData().getPortrait();
        }
    }

    public void aRf() {
        if (this.eGK != null && this.eGM != null) {
            a(this.mHostView, this.eGN, this.eGM.getMaskType() == 1, this.eGK.aRd());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eGJ = new com.baidu.tieba.person.e(this.ajF, this);
        this.eGL = new MorePopupWindow(this.ajF.getPageActivity(), this.eGJ.getView(), view, this.ajF.getResources().getDrawable(w.g.bg_pull_down_right_n), new n(this));
        this.eGL.onChangeSkinType(this.ajF.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.ajF.getResources().getDrawable(w.g.bg_pull_down_right_n));
        this.eGJ.y(z, z2);
        if (i != -1) {
            this.eGJ.oT(i);
        }
        this.eGL.refresh();
        this.eGL.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eGJ.aQa() != null && view.getId() == this.eGJ.aQa().getId()) {
                com.baidu.adp.lib.g.j.a(this.eGL, this.ajF.getPageActivity());
                aRg();
            } else if (this.eGJ.aPZ() != null && view.getId() == this.eGJ.aPZ().getId()) {
                com.baidu.adp.lib.g.j.a(this.eGL, this.ajF.getPageActivity());
                if (this.eGN) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.ajF.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.aro, null, false, null)));
            } else if (this.eGJ.aQb() != null && view.getId() == this.eGJ.aQb().getId()) {
                com.baidu.adp.lib.g.j.a(this.eGL, this.ajF.getPageActivity());
                if (!com.baidu.adp.lib.util.i.he()) {
                    this.ajF.showToast(w.l.neterror);
                } else if (this.eGK != null) {
                    if (this.eGK.aRd() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eGK.aRe(), this.eGK.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eGK.getUniqueId();
                        this.eGK.a(false, userMuteAddAndDelCustomMessage, this.eGK.aRe(), this.mUserName);
                    } else if (this.eGK.aRd() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eGK.aRe(), this.eGK.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eGK.getUniqueId();
                        this.eGK.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aRg() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajF.getPageActivity());
            aVar.a(w.l.confirm, new o(this));
            aVar.b(w.l.cancel, new p(this));
            if (this.eGM.getMaskType() == 1) {
                format = String.format(this.ajF.getString(w.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.ajF.getString(w.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cx(format);
            aVar.b(this.ajF);
            aVar.ts();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(boolean z) {
        this.eGN = z;
        if (this.eGO != null) {
            this.eGO.jn(this.eGN);
        }
        if (this.eGJ != null && this.eGM != null) {
            this.eGJ.y(this.eGN, this.eGM.getMaskType() == 1);
        }
    }
}
