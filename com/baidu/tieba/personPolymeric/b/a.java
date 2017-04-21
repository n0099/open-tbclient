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
    private TbPageContext ajU;
    private com.baidu.tbadk.core.view.a bHb;
    private BdUniqueId eGT;
    private int eGR = -1;
    private String eGS = "";
    private com.baidu.tbadk.core.view.h ely = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eGT;
    }

    public a(TbPageContext tbPageContext) {
        this.ajU = tbPageContext;
        this.ely.ajz = 1000L;
        this.eGT = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eGT;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eGT);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eGT;
        userMuteCheckCustomMessage.setTag(this.eGT);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aSn() {
        return this.eGR;
    }

    public String aSo() {
        return this.eGS;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bHb != null) {
            this.bHb.aK(false);
        }
        this.eGR = i2;
        this.eGS = str;
        if (i3 == 0) {
            if (i == 1) {
                this.ely.c(this.ajU.getString(w.l.mute_success));
            } else if (i == 2) {
                this.ely.c(this.ajU.getResources().getString(w.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.ajU.getString(w.l.mute_error_beyond_limit);
            }
            fD(str2);
        } else if (i3 == 1990043) {
            aLT();
        } else {
            if (au.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.ajU.getResources().getString(w.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.ajU.getResources().getString(w.l.un_mute_fail);
                }
            }
            this.ely.d(str2);
        }
    }

    public void avw() {
        if (this.bHb == null) {
            this.bHb = new com.baidu.tbadk.core.view.a(this.ajU);
            this.bHb.c(new b(this));
        }
        this.bHb.aK(true);
    }

    public void fD(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajU.getPageActivity());
        aVar.cE(str);
        aVar.b(w.l.know, new c(this));
        aVar.b(this.ajU).tQ();
    }

    public void aLT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajU.getPageActivity());
        aVar.cE(this.ajU.getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new d(this));
        aVar.b(w.l.cancel, new e(this));
        aVar.b(this.ajU).tQ();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            avw();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajU.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.cE(this.ajU.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(w.l.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new g(this));
        aVar.b(this.ajU).tQ();
    }
}
