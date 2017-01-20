package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext FY;
    private com.baidu.tbadk.core.view.a bxL;
    private BdUniqueId eDf;
    private int eDd = -1;
    private String eDe = "";
    private com.baidu.tbadk.core.view.h eil = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eDf;
    }

    public a(TbPageContext tbPageContext) {
        this.FY = tbPageContext;
        this.eil.adV = 1000L;
        this.eDf = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eDf;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eDf);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eDf;
        userMuteCheckCustomMessage.setTag(this.eDf);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aRA() {
        return this.eDd;
    }

    public String aRB() {
        return this.eDe;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bxL != null) {
            this.bxL.aJ(false);
        }
        this.eDd = i2;
        this.eDe = str;
        if (i3 == 0) {
            if (i == 1) {
                this.eil.c(this.FY.getString(r.l.mute_success));
            } else if (i == 2) {
                this.eil.c(this.FY.getResources().getString(r.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.FY.getString(r.l.mute_error_beyond_limit);
            }
            fI(str2);
        } else if (i3 == 1990043) {
            aLs();
        } else {
            if (at.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.FY.getResources().getString(r.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.FY.getResources().getString(r.l.un_mute_fail);
                }
            }
            this.eil.d(str2);
        }
    }

    public void avh() {
        if (this.bxL == null) {
            this.bxL = new com.baidu.tbadk.core.view.a(this.FY);
            this.bxL.c(new b(this));
        }
        this.bxL.aJ(true);
    }

    public void fI(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.FY.getPageActivity());
        aVar.cE(str);
        aVar.b(r.l.know, new c(this));
        aVar.b(this.FY).sV();
    }

    public void aLs() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.FY.getPageActivity());
        aVar.cE(this.FY.getString(r.l.mute_is_super_member_function));
        aVar.a(r.l.open_now, new d(this));
        aVar.b(r.l.cancel, new e(this));
        aVar.b(this.FY).sV();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            avh();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.FY.getPageActivity());
        if (at.isEmpty(str)) {
            aVar.cE(this.FY.getResources().getString(r.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(r.l.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.l.cancel, new g(this));
        aVar.b(this.FY).sV();
    }
}
