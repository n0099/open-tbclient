package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.message.RequestDeleteFriendMessage;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    protected TbPageContext ajP;
    protected String ast;
    protected b eVb;
    private com.baidu.tieba.person.m eVi;
    private BlackListModel eVj;
    protected boolean eVk;
    protected com.baidu.tieba.personPolymeric.c.a eVl;
    private com.baidu.tieba.person.k eVm;
    private final com.baidu.adp.framework.listener.e eVn = new s(this, 104102);
    final com.baidu.adp.framework.listener.e eVo = new t(this, 304102);
    final CustomMessageListener eVp = new u(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener eVq = new v(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eVr = new w(this, 304103);
    protected BdUniqueId mBdUniqueId;
    protected View mHostView;
    protected long mUserId;
    protected String mUserName;

    public r(TbPageContext tbPageContext, b bVar, BlackListModel blackListModel, View view, BdUniqueId bdUniqueId) {
        this.ajP = tbPageContext;
        this.eVb = bVar;
        this.eVj = blackListModel;
        this.mHostView = view;
        this.mBdUniqueId = bdUniqueId;
        registerListener();
    }

    public void registerListener() {
        this.eVn.setTag(this.mBdUniqueId);
        this.eVo.setTag(this.mBdUniqueId);
        this.eVr.setTag(this.mBdUniqueId);
        this.eVq.setTag(this.mBdUniqueId);
        this.eVp.setTag(this.mBdUniqueId);
        this.ajP.registerListener(this.eVn);
        this.ajP.registerListener(this.eVo);
        this.ajP.registerListener(this.eVr);
        this.ajP.registerListener(this.eVq);
        this.ajP.registerListener(this.eVp);
    }

    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        int i;
        if (this.eVj != null && aVar != null && aVar.getUserData() != null) {
            this.eVl = aVar;
            this.eVk = aVar.awG();
            BlackListModel blackListModel = this.eVj;
            if (aVar.getUserData().isMask()) {
                i = 1;
            } else {
                i = 0;
            }
            blackListModel.setMaskType(i);
            this.mUserName = aVar.getUserData() != null ? aVar.getUserData().getUserName() : null;
            this.mUserId = aVar.getUserData().getUserIdLong();
            this.ast = aVar.getUserData().getPortrait();
        }
    }

    public void aVj() {
        if (this.eVb != null && this.eVj != null) {
            a(this.mHostView, this.eVk, this.eVj.getMaskType() == 1, this.eVb.aUX());
        }
    }

    public void a(View view, boolean z, boolean z2, int i) {
        this.eVi = new com.baidu.tieba.person.m(this.ajP, this);
        this.eVi.C(z, z2);
        if (i != -1) {
            this.eVi.pH(i);
        }
        if (this.eVl != null && this.eVl.getUserData() != null) {
            this.eVi.setUserName(this.eVl.getUserData().getUserName());
        }
        this.eVi.onChangeSkinType();
        this.eVm = new com.baidu.tieba.person.k(this.ajP.getPageActivity(), this.eVi.getView());
        this.eVm.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.j.b(this.eVm, this.ajP.getPageActivity());
            if (this.eVi.aTS() != null && view.getId() == this.eVi.aTS().getId()) {
                aVk();
            } else if (this.eVi.aTR() != null && view.getId() == this.eVi.aTR().getId()) {
                if (this.eVk) {
                    RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                    requestDeleteFriendMessage.setFriendId(this.mUserId);
                    MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.ajP.getPageActivity(), String.valueOf(this.mUserId), this.mUserName, this.ast, null, false, null)));
            } else if (this.eVi.aTT() != null && view.getId() == this.eVi.aTT().getId()) {
                if (!com.baidu.adp.lib.util.i.hj()) {
                    this.ajP.showToast(w.l.neterror);
                } else if (this.eVb != null) {
                    if (this.eVb.aUX() == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eVb.aUY(), this.eVb.getUniqueId());
                        userMuteAddAndDelCustomMessage.mId = this.eVb.getUniqueId();
                        this.eVb.a(false, userMuteAddAndDelCustomMessage, this.eVb.aUY(), this.mUserName);
                    } else if (this.eVb.aUX() == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.mUserId), this.mUserName, null, null, 0, this.eVb.aUY(), this.eVb.getUniqueId());
                        userMuteAddAndDelCustomMessage2.mId = this.eVb.getUniqueId();
                        this.eVb.a(true, userMuteAddAndDelCustomMessage2, null, this.mUserName);
                    }
                }
            }
        }
    }

    protected void aVk() {
        String format;
        if (this.mUserName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajP.getPageActivity());
            aVar.a(w.l.confirm, new x(this));
            aVar.b(w.l.cancel, new y(this));
            if (this.eVj.getMaskType() == 1) {
                format = String.format(this.ajP.getString(w.l.block_chat_ensure_toremove_text), this.mUserName);
            } else {
                format = String.format(this.ajP.getString(w.l.block_chat_message_alert), this.mUserName);
            }
            aVar.cI(format);
            aVar.b(this.ajP);
            aVar.ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jU(boolean z) {
        this.eVk = z;
        if (this.eVl != null) {
            this.eVl.jW(this.eVk);
        }
        if (this.eVi != null && this.eVj != null) {
            this.eVi.C(this.eVk, this.eVj.getMaskType() == 1);
        }
    }
}
