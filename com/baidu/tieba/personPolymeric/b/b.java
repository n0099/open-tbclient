package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext ajh;
    private com.baidu.tbadk.core.view.a bMH;
    private BdUniqueId eKU;
    private int eKS = -1;
    private String eKT = "";
    private com.baidu.tbadk.core.view.h eml = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eKU;
    }

    public b(TbPageContext tbPageContext) {
        this.ajh = tbPageContext;
        this.eml.aiM = 1000L;
        this.eKU = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eKU;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eKU);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eKU;
        userMuteCheckCustomMessage.setTag(this.eKU);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aQS() {
        return this.eKS;
    }

    public String aQT() {
        return this.eKT;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bMH != null) {
            this.bMH.aH(false);
        }
        this.eKS = i2;
        this.eKT = str;
        if (i3 == 0) {
            if (i == 1) {
                this.eml.c(this.ajh.getString(w.l.mute_success));
            } else if (i == 2) {
                this.eml.c(this.ajh.getResources().getString(w.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.ajh.getString(w.l.mute_error_beyond_limit);
            }
            fy(str2);
        } else if (i3 == 1990043) {
            aKi();
        } else {
            if (com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.ajh.getResources().getString(w.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.ajh.getResources().getString(w.l.un_mute_fail);
                }
            }
            this.eml.d(str2);
        }
    }

    public void Pd() {
        if (this.bMH == null) {
            this.bMH = new com.baidu.tbadk.core.view.a(this.ajh);
            this.bMH.c(new c(this));
        }
        this.bMH.aH(true);
    }

    public void fy(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajh.getPageActivity());
        aVar.cB(str);
        aVar.b(w.l.know, new d(this));
        aVar.b(this.ajh).tc();
    }

    public void aKi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajh.getPageActivity());
        aVar.cB(this.ajh.getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new e(this));
        aVar.b(w.l.cancel, new f(this));
        aVar.b(this.ajh).tc();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            Pd();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajh.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cB(this.ajh.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cB(str);
        }
        aVar.a(w.l.confirm, new g(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new h(this));
        aVar.b(this.ajh).tc();
    }
}
