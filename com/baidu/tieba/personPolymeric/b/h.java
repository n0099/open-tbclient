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
    private TbPageContext FY;
    private String alU;
    private com.baidu.tieba.person.e eDh;
    private a eDi;
    private MorePopupWindow eDj;
    private BlackListModel eDk;
    private boolean eDl;
    private com.baidu.tieba.personPolymeric.c.n eDm;
    private final com.baidu.adp.framework.listener.e eDn = new i(this, 104102);
    final com.baidu.adp.framework.listener.e eDo = new j(this, 304102);
    final CustomMessageListener eDp = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener eDq = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eDr = new m(this, 304103);
    private View mHostView;
    private long mUserId;
    private String mUserName;

    public h(TbPageContext tbPageContext, a aVar, BlackListModel blackListModel, View view) {
        this.FY = tbPageContext;
        this.eDi = aVar;
        this.eDk = blackListModel;
        this.mHostView = view;
        registerListener();
    }

    public void registerListener() {
        this.FY.registerListener(this.eDn);
        this.FY.registerListener(this.eDo);
        this.FY.registerListener(this.eDr);
        this.FY.registerListener(this.eDq);
        this.FY.registerListener(this.eDp);
    }

    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        int i;
        if (this.eDk != null && nVar != null && nVar.getUserData() != null) {
            this.eDm = nVar;
            this.eDl = nVar.auO();
            BlackListModel blackListModel = this.eDk;
            if (nVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = nVar.getUserData() != null ? nVar.getUserData().getUserName() : null;
            this.mUserId = nVar.getUserData().getUserIdLong();
            this.alU = nVar.getUserData().getPortrait();
        }
    }

    public void aRC() {
        if (this.eDi != null && this.eDk != null) {
            a(this.mHostView, this.eDl, this.eDk.getMaskType() == 1, this.eDi.aRA());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eDh = new com.baidu.tieba.person.e(this.FY, this);
        this.eDj = new MorePopupWindow(this.FY.getPageActivity(), this.eDh.getView(), view, this.FY.getResources().getDrawable(r.g.bg_pull_down_right_n), new n(this));
        this.eDj.onChangeSkinType(this.FY.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.FY.getResources().getDrawable(r.g.bg_pull_down_right_n));
        this.eDh.z(z, z2);
        if (i != -1) {
            this.eDh.oX(i);
        }
        this.eDj.refresh();
        this.eDj.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eDh.aQx() != null && view.getId() == this.eDh.aQx().getId()) {
                com.baidu.adp.lib.g.j.a(this.eDj, this.FY.getPageActivity());
                aRD();
            } else if (this.eDh.aQw() != null && view.getId() == this.eDh.aQw().getId()) {
                com.baidu.adp.lib.g.j.a(this.eDj, this.FY.getPageActivity());
                if (this.eDl) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.FY.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.alU, null, false, null)));
            } else if (this.eDh.aQy() != null && view.getId() == this.eDh.aQy().getId()) {
                com.baidu.adp.lib.g.j.a(this.eDj, this.FY.getPageActivity());
                if (!com.baidu.adp.lib.util.i.gk()) {
                    this.FY.showToast(r.l.neterror);
                } else if (this.eDi != null) {
                    if (this.eDi.aRA() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eDi.aRB(), this.eDi.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eDi.getUniqueId();
                        this.eDi.a(false, userMuteAddAndDelCustomMessage, this.eDi.aRB(), this.mUserName);
                    } else if (this.eDi.aRA() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eDi.aRB(), this.eDi.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eDi.getUniqueId();
                        this.eDi.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    private void aRD() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.FY.getPageActivity());
            aVar.a(r.l.confirm, new o(this));
            aVar.b(r.l.cancel, new p(this));
            if (this.eDk.getMaskType() == 1) {
                format = String.format(this.FY.getString(r.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.FY.getString(r.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cE(format);
            aVar.b(this.FY);
            aVar.sV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(boolean z) {
        this.eDl = z;
        if (this.eDm != null) {
            this.eDm.jq(this.eDl);
        }
        if (this.eDh != null && this.eDk != null) {
            this.eDh.z(this.eDl, this.eDk.getMaskType() == 1);
        }
    }
}
