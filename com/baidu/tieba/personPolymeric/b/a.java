package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext GM;
    private com.baidu.tbadk.core.view.a bGR;
    private BdUniqueId eHk;
    private int eHi = -1;
    private String eHj = "";
    private com.baidu.tbadk.core.view.h enw = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eHk;
    }

    public a(TbPageContext tbPageContext) {
        this.GM = tbPageContext;
        this.enw.aeI = 1000L;
        this.eHk = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eHk;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eHk);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eHk;
        userMuteCheckCustomMessage.setTag(this.eHk);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aTn() {
        return this.eHi;
    }

    public String aTo() {
        return this.eHj;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bGR != null) {
            this.bGR.aF(false);
        }
        this.eHi = i2;
        this.eHj = str;
        if (i3 == 0) {
            if (i == 1) {
                this.enw.c(this.GM.getString(t.j.mute_success));
            } else if (i == 2) {
                this.enw.c(this.GM.getResources().getString(t.j.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.GM.getString(t.j.mute_error_beyond_limit);
            }
            fI(str2);
        } else if (i3 == 1990043) {
            aNj();
        } else {
            if (ba.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.GM.getResources().getString(t.j.mute_fail);
                } else if (i == 2) {
                    str2 = this.GM.getResources().getString(t.j.un_mute_fail);
                }
            }
            this.enw.d(str2);
        }
    }

    public void ayk() {
        if (this.bGR == null) {
            this.bGR = new com.baidu.tbadk.core.view.a(this.GM);
            this.bGR.c(new b(this));
        }
        this.bGR.aF(true);
    }

    public void fI(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
        aVar.cB(str);
        aVar.b(t.j.know, new c(this));
        aVar.b(this.GM).sX();
    }

    public void aNj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
        aVar.cB(this.GM.getString(t.j.mute_is_super_member_function));
        aVar.a(t.j.open_now, new d(this));
        aVar.b(t.j.cancel, new e(this));
        aVar.b(this.GM).sX();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            ayk();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
        if (ba.isEmpty(str)) {
            aVar.cB(this.GM.getResources().getString(t.j.block_mute_message_alert, str2));
        } else {
            aVar.cB(str);
        }
        aVar.a(t.j.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(t.j.cancel, new g(this));
        aVar.b(this.GM).sX();
    }
}
