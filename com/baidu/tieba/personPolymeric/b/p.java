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
public class p implements View.OnClickListener {
    protected TbPageContext ajh;
    protected String arq;
    protected boolean bld;
    private com.baidu.tieba.personPolymeric.c.a bxe;
    protected b eLb;
    private com.baidu.tieba.person.k eLf;
    protected MorePopupWindow eLg;
    private BlackListModel eLh;
    protected boolean eLi;
    private final com.baidu.adp.framework.listener.e eLj = new q(this, 104102);
    final com.baidu.adp.framework.listener.e eLk = new r(this, 304102);
    final CustomMessageListener eLl = new s(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener eLm = new t(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eLn = new u(this, 304103);
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;

    public p(TbPageContext tbPageContext, b bVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.ajh = tbPageContext;
        this.eLb = bVar;
        this.eLh = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.eLj.setTag(this.mBdUniqueId);
        this.eLk.setTag(this.mBdUniqueId);
        this.eLn.setTag(this.mBdUniqueId);
        this.eLm.setTag(this.mBdUniqueId);
        this.eLl.setTag(this.mBdUniqueId);
        this.ajh.registerListener(this.eLj);
        this.ajh.registerListener(this.eLk);
        this.ajh.registerListener(this.eLn);
        this.ajh.registerListener(this.eLm);
        this.ajh.registerListener(this.eLl);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        int i;
        if (this.eLh != null && aVar != null && aVar.getUserData() != null) {
            this.bxe = aVar;
            this.eLi = aVar.asW();
            BlackListModel blackListModel = this.eLh;
            if (aVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.arq = aVar.getUserData().getPortrait();
        }
    }

    public void aRc() {
        if (this.eLb != null && this.eLh != null) {
            a(this.mHostView, this.eLi, this.eLh.getMaskType() == 1, this.eLb.aQS());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eLf = new com.baidu.tieba.person.k(this.ajh, this);
        this.eLg = new MorePopupWindow(this.ajh.getPageActivity(), this.eLf.getView(), view, this.ajh.getResources().getDrawable(w.g.bg_pull_down_right_n), new v(this));
        this.eLg.onChangeSkinType(this.ajh.getLayoutMode(), TbadkCoreApplication.m9getInst().getSkinType(), this.ajh.getResources().getDrawable(w.g.bg_pull_down_right_n));
        this.eLf.m(z, z2);
        if (i != -1) {
            this.eLf.hg(i);
        }
        this.eLg.refresh();
        this.eLg.showWindowInRightBottomOfHost();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (this.eLf.TM() != null && view.getId() == this.eLf.TM().getId()) {
                com.baidu.adp.lib.g.j.a(this.eLg, this.ajh.getPageActivity());
                aRd();
            } else if (this.eLf.TL() != null && view.getId() == this.eLf.TL().getId()) {
                com.baidu.adp.lib.g.j.a(this.eLg, this.ajh.getPageActivity());
                if (this.eLi) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.ajh.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.arq, null, false, null)));
            } else if (this.eLf.TN() != null && view.getId() == this.eLf.TN().getId()) {
                com.baidu.adp.lib.g.j.a(this.eLg, this.ajh.getPageActivity());
                if (!com.baidu.adp.lib.util.i.hk()) {
                    this.ajh.showToast(w.l.neterror);
                } else if (this.eLb != null) {
                    if (this.eLb.aQS() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eLb.aQT(), this.eLb.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eLb.getUniqueId();
                        this.eLb.a(false, userMuteAddAndDelCustomMessage, this.eLb.aQT(), this.mUserName);
                    } else if (this.eLb.aQS() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eLb.aQT(), this.eLb.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eLb.getUniqueId();
                        this.eLb.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aRd() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajh.getPageActivity());
            aVar.a(w.l.confirm, new w(this));
            aVar.b(w.l.cancel, new x(this));
            if (this.eLh.getMaskType() == 1) {
                format = String.format(this.ajh.getString(w.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.ajh.getString(w.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cB(format);
            aVar.b(this.ajh);
            aVar.tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(boolean z) {
        this.eLi = z;
        if (this.bxe != null) {
            this.bxe.jw(this.eLi);
        }
        if (this.eLf != null && this.eLh != null) {
            this.eLf.m(this.eLi, this.eLh.getMaskType() == 1);
        }
    }

    public void setIsHost(boolean z) {
        this.bld = z;
    }
}
