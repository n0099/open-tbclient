package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext GM;
    private com.baidu.tbadk.core.view.a bHa;
    private BdUniqueId eJo;
    private int eJm = -1;
    private String eJn = "";
    private com.baidu.tbadk.core.view.h ept = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eJo;
    }

    public a(TbPageContext tbPageContext) {
        this.GM = tbPageContext;
        this.ept.aeT = 1000L;
        this.eJo = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eJo;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eJo);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eJo;
        userMuteCheckCustomMessage.setTag(this.eJo);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aTK() {
        return this.eJm;
    }

    public String aTL() {
        return this.eJn;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bHa != null) {
            this.bHa.aF(false);
        }
        this.eJm = i2;
        this.eJn = str;
        if (i3 == 0) {
            if (i == 1) {
                this.ept.c(this.GM.getString(r.j.mute_success));
            } else if (i == 2) {
                this.ept.c(this.GM.getResources().getString(r.j.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.GM.getString(r.j.mute_error_beyond_limit);
            }
            fM(str2);
        } else if (i3 == 1990043) {
            aNP();
        } else {
            if (az.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.GM.getResources().getString(r.j.mute_fail);
                } else if (i == 2) {
                    str2 = this.GM.getResources().getString(r.j.un_mute_fail);
                }
            }
            this.ept.d(str2);
        }
    }

    public void ayI() {
        if (this.bHa == null) {
            this.bHa = new com.baidu.tbadk.core.view.a(this.GM);
            this.bHa.c(new b(this));
        }
        this.bHa.aF(true);
    }

    public void fM(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
        aVar.cD(str);
        aVar.b(r.j.know, new c(this));
        aVar.b(this.GM).tm();
    }

    public void aNP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
        aVar.cD(this.GM.getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new d(this));
        aVar.b(r.j.cancel, new e(this));
        aVar.b(this.GM).tm();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            ayI();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GM.getPageActivity());
        if (az.isEmpty(str)) {
            aVar.cD(this.GM.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cD(str);
        }
        aVar.a(r.j.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new g(this));
        aVar.b(this.GM).tm();
    }
}
