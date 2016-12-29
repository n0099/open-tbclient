package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.a bpY;
    private BdUniqueId etl;
    private int etj = -1;
    private String etk = "";
    private com.baidu.tbadk.core.view.h dZA = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.etl;
    }

    public a(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
        this.dZA.aeK = 1000L;
        this.etl = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.etl;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.etl);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.etl;
        userMuteCheckCustomMessage.setTag(this.etl);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aPB() {
        return this.etj;
    }

    public String aPC() {
        return this.etk;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bpY != null) {
            this.bpY.aJ(false);
        }
        this.etj = i2;
        this.etk = str;
        if (i3 == 0) {
            if (i == 1) {
                this.dZA.c(this.GO.getString(r.j.mute_success));
            } else if (i == 2) {
                this.dZA.c(this.GO.getResources().getString(r.j.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.GO.getString(r.j.mute_error_beyond_limit);
            }
            fL(str2);
        } else if (i3 == 1990043) {
            aJF();
        } else {
            if (av.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.GO.getResources().getString(r.j.mute_fail);
                } else if (i == 2) {
                    str2 = this.GO.getResources().getString(r.j.un_mute_fail);
                }
            }
            this.dZA.d(str2);
        }
    }

    public void aub() {
        if (this.bpY == null) {
            this.bpY = new com.baidu.tbadk.core.view.a(this.GO);
            this.bpY.c(new b(this));
        }
        this.bpY.aJ(true);
    }

    public void fL(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
        aVar.cG(str);
        aVar.b(r.j.know, new c(this));
        aVar.b(this.GO).tb();
    }

    public void aJF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
        aVar.cG(this.GO.getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new d(this));
        aVar.b(r.j.cancel, new e(this));
        aVar.b(this.GO).tb();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            aub();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.GO.getPageActivity());
        if (av.isEmpty(str)) {
            aVar.cG(this.GO.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cG(str);
        }
        aVar.a(r.j.confirm, new f(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new g(this));
        aVar.b(this.GO).tb();
    }
}
