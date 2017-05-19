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
    private TbPageContext ajr;
    private com.baidu.tbadk.core.view.a bGT;
    private BdUniqueId eCi;
    private int eCg = -1;
    private String eCh = "";
    private com.baidu.tbadk.core.view.h egK = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eCi;
    }

    public a(TbPageContext tbPageContext) {
        this.ajr = tbPageContext;
        this.egK.aiW = 1000L;
        this.eCi = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eCi;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eCi);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eCi;
        userMuteCheckCustomMessage.setTag(this.eCi);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aPA() {
        return this.eCg;
    }

    public String aPB() {
        return this.eCh;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bGT != null) {
            this.bGT.aI(false);
        }
        this.eCg = i2;
        this.eCh = str;
        if (i3 == 0) {
            if (i == 1) {
                this.egK.c(this.ajr.getString(w.l.mute_success));
            } else if (i == 2) {
                this.egK.c(this.ajr.getResources().getString(w.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.ajr.getString(w.l.mute_error_beyond_limit);
            }
            fA(str2);
        } else if (i3 == 1990043) {
            aJq();
        } else {
            if (au.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.ajr.getResources().getString(w.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.ajr.getResources().getString(w.l.un_mute_fail);
                }
            }
            this.egK.d(str2);
        }
    }

    public void asr() {
        if (this.bGT == null) {
            this.bGT = new com.baidu.tbadk.core.view.a(this.ajr);
            this.bGT.c(new b(this));
        }
        this.bGT.aI(true);
    }

    public void fA(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajr.getPageActivity());
        aVar.cC(str);
        aVar.b(w.l.know, new c(this));
        aVar.b(this.ajr).td();
    }

    public void aJq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajr.getPageActivity());
        aVar.cC(this.ajr.getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new d(this));
        aVar.b(w.l.cancel, new e(this));
        aVar.b(this.ajr).td();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            asr();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajr.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.cC(this.ajr.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cC(str);
        }
        aVar.a(w.l.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new g(this));
        aVar.b(this.ajr).td();
    }
}
