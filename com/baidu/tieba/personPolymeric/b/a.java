package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext ajF;
    private com.baidu.tbadk.core.view.a bER;
    private BdUniqueId eGH;
    private int eGF = -1;
    private String eGG = "";
    private com.baidu.tbadk.core.view.h elc = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eGH;
    }

    public a(TbPageContext tbPageContext) {
        this.ajF = tbPageContext;
        this.elc.ajk = 1000L;
        this.eGH = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eGH;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eGH);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eGH;
        userMuteCheckCustomMessage.setTag(this.eGH);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aRd() {
        return this.eGF;
    }

    public String aRe() {
        return this.eGG;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bER != null) {
            this.bER.aI(false);
        }
        this.eGF = i2;
        this.eGG = str;
        if (i3 == 0) {
            if (i == 1) {
                this.elc.c(this.ajF.getString(w.l.mute_success));
            } else if (i == 2) {
                this.elc.c(this.ajF.getResources().getString(w.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.ajF.getString(w.l.mute_error_beyond_limit);
            }
            fx(str2);
        } else if (i3 == 1990043) {
            aKN();
        } else {
            if (au.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.ajF.getResources().getString(w.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.ajF.getResources().getString(w.l.un_mute_fail);
                }
            }
            this.elc.d(str2);
        }
    }

    public void auC() {
        if (this.bER == null) {
            this.bER = new com.baidu.tbadk.core.view.a(this.ajF);
            this.bER.c(new b(this));
        }
        this.bER.aI(true);
    }

    public void fx(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajF.getPageActivity());
        aVar.cx(str);
        aVar.b(w.l.know, new c(this));
        aVar.b(this.ajF).ts();
    }

    public void aKN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajF.getPageActivity());
        aVar.cx(this.ajF.getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new d(this));
        aVar.b(w.l.cancel, new e(this));
        aVar.b(this.ajF).ts();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            auC();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajF.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.cx(this.ajF.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cx(str);
        }
        aVar.a(w.l.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new g(this));
        aVar.b(this.ajF).ts();
    }
}
