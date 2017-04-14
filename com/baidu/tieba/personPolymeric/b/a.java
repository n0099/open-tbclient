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
    private TbPageContext ajT;
    private com.baidu.tbadk.core.view.a bEK;
    private BdUniqueId eED;
    private int eEB = -1;
    private String eEC = "";
    private com.baidu.tbadk.core.view.h eji = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eED;
    }

    public a(TbPageContext tbPageContext) {
        this.ajT = tbPageContext;
        this.eji.ajy = 1000L;
        this.eED = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eED;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eED);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eED;
        userMuteCheckCustomMessage.setTag(this.eED);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aRm() {
        return this.eEB;
    }

    public String aRn() {
        return this.eEC;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bEK != null) {
            this.bEK.aK(false);
        }
        this.eEB = i2;
        this.eEC = str;
        if (i3 == 0) {
            if (i == 1) {
                this.eji.c(this.ajT.getString(w.l.mute_success));
            } else if (i == 2) {
                this.eji.c(this.ajT.getResources().getString(w.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.ajT.getString(w.l.mute_error_beyond_limit);
            }
            fD(str2);
        } else if (i3 == 1990043) {
            aKT();
        } else {
            if (au.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.ajT.getResources().getString(w.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.ajT.getResources().getString(w.l.un_mute_fail);
                }
            }
            this.eji.d(str2);
        }
    }

    public void auv() {
        if (this.bEK == null) {
            this.bEK = new com.baidu.tbadk.core.view.a(this.ajT);
            this.bEK.c(new b(this));
        }
        this.bEK.aK(true);
    }

    public void fD(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajT.getPageActivity());
        aVar.cE(str);
        aVar.b(w.l.know, new c(this));
        aVar.b(this.ajT).tQ();
    }

    public void aKT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajT.getPageActivity());
        aVar.cE(this.ajT.getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new d(this));
        aVar.b(w.l.cancel, new e(this));
        aVar.b(this.ajT).tQ();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            auv();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajT.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.cE(this.ajT.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(w.l.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new g(this));
        aVar.b(this.ajT).tQ();
    }
}
