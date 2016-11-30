package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.a bJU;
    private BdUniqueId ePN;
    private int ePL = -1;
    private String ePM = "";
    private com.baidu.tbadk.core.view.h evf = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.ePN;
    }

    public a(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
        this.evf.afr = 1000L;
        this.ePN = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.ePN;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.ePN);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.ePN;
        userMuteCheckCustomMessage.setTag(this.ePN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aVR() {
        return this.ePL;
    }

    public String aVS() {
        return this.ePM;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bJU != null) {
            this.bJU.aI(false);
        }
        this.ePL = i2;
        this.ePM = str;
        if (i3 == 0) {
            if (i == 1) {
                this.evf.c(this.GO.getString(r.j.mute_success));
            } else if (i == 2) {
                this.evf.c(this.GO.getResources().getString(r.j.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.GO.getString(r.j.mute_error_beyond_limit);
            }
            fP(str2);
        } else if (i3 == 1990043) {
            aPG();
        } else {
            if (ax.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.GO.getResources().getString(r.j.mute_fail);
                } else if (i == 2) {
                    str2 = this.GO.getResources().getString(r.j.un_mute_fail);
                }
            }
            this.evf.d(str2);
        }
    }

    public void aAF() {
        if (this.bJU == null) {
            this.bJU = new com.baidu.tbadk.core.view.a(this.GO);
            this.bJU.c(new b(this));
        }
        this.bJU.aI(true);
    }

    public void fP(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
        aVar.cF(str);
        aVar.b(r.j.know, new c(this));
        aVar.b(this.GO).tq();
    }

    public void aPG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
        aVar.cF(this.GO.getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new d(this));
        aVar.b(r.j.cancel, new e(this));
        aVar.b(this.GO).tq();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            aAF();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
        if (ax.isEmpty(str)) {
            aVar.cF(this.GO.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cF(str);
        }
        aVar.a(r.j.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new g(this));
        aVar.b(this.GO).tq();
    }
}
