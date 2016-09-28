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
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private TbPageContext GM;
    private String amt;
    private com.baidu.tieba.person.f eJq;
    private a eJr;
    private MorePopupWindow eJs;
    private BlackListModel eJt;
    private boolean eJu;
    private com.baidu.tieba.personPolymeric.c.n eJv;
    private View mHostView;
    private long mUserId;
    private String mUserName;
    private final com.baidu.adp.framework.listener.e eJw = new i(this, 104102);
    final com.baidu.adp.framework.listener.e eJx = new j(this, 304102);
    final CustomMessageListener eJy = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aVv = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eJz = new m(this, 304103);

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.GM = tbPageContext;
        this.eJr = aVar;
        this.eJt = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.GM.registerListener(this.eJw);
        this.GM.registerListener(this.eJx);
        this.GM.registerListener(this.eJz);
        this.GM.registerListener(this.aVv);
        this.GM.registerListener(this.eJy);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.eJt != null && nVar != null && nVar.getUserData() != null) {
            this.eJv = nVar;
            this.eJu = nVar.axm();
            BlackListModel blackListModel = this.eJt;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.amt = nVar.getUserData().getPortrait();
        }
    }

    public void aTM() {
        if (this.eJr != null && this.eJt != null) {
            a(this.mHostView, this.eJu, this.eJt.getMaskType() == 1, this.eJr.aTK());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eJq = new com.baidu.tieba.person.f(this.GM, this);
        this.eJs = new MorePopupWindow(this.GM.getPageActivity(), this.eJq.getView(), view, this.GM.getResources().getDrawable(r.f.bg_pull_down_right_n), new n(this));
        this.eJs.onChangeSkinType(this.GM.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.GM.getResources().getDrawable(r.f.bg_pull_down_right_n));
        this.eJq.y(z, z2);
        if (i != -1) {
            this.eJq.oQ(i);
        }
        this.eJs.refresh();
        this.eJs.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eJq.aSB() != null && view.getId() == this.eJq.aSB().getId()) {
                com.baidu.adp.lib.h.j.a(this.eJs, this.GM.getPageActivity());
                aTN();
            } else if (this.eJq.aSA() != null && view.getId() == this.eJq.aSA().getId()) {
                com.baidu.adp.lib.h.j.a(this.eJs, this.GM.getPageActivity());
                if (this.eJu) {
                    com.baidu.tbadk.newFriends.a.Fz().R(this.mUserId);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.GM.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.amt, null, false, null)));
                }
            } else if (this.eJq.aSC() != null && view.getId() == this.eJq.aSC().getId()) {
                com.baidu.adp.lib.h.j.a(this.eJs, this.GM.getPageActivity());
                if (!com.baidu.adp.lib.util.i.gm()) {
                    this.GM.showToast(r.j.neterror);
                } else if (this.eJr != null) {
                    if (this.eJr.aTK() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eJr.aTL(), this.eJr.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eJr.getUniqueId();
                        this.eJr.a(false, userMuteAddAndDelCustomMessage, this.eJr.aTL(), this.mUserName);
                    } else if (this.eJr.aTK() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eJr.aTL(), this.eJr.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eJr.getUniqueId();
                        this.eJr.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aTN() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
            aVar.a(r.j.confirm, new o(this));
            aVar.b(r.j.cancel, new p(this));
            if (this.eJt.getMaskType() == 1) {
                format = String.format(this.GM.getString(r.j.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.GM.getString(r.j.block_chat_message_alert), this.mUserName);
            }
            aVar.cD(format);
            aVar.b(this.GM);
            aVar.tm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(boolean z) {
        this.eJu = z;
        if (this.eJv != null) {
            this.eJv.iT(this.eJu);
        }
        if (this.eJq != null && this.eJt != null) {
            this.eJq.y(this.eJu, this.eJt.getMaskType() == 1);
        }
    }
}
