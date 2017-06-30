package com.baidu.tieba.personPolymeric.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext ajP;
    private com.baidu.tbadk.core.view.a bTj;
    private BdUniqueId eUT;
    private int eUR = -1;
    private String eUS = "";
    private com.baidu.tbadk.core.view.h evl = new com.baidu.tbadk.core.view.h();

    public BdUniqueId getUniqueId() {
        return this.eUT;
    }

    public b(TbPageContext tbPageContext) {
        this.ajP = tbPageContext;
        this.evl.aju = 1000L;
        this.eUT = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eUT;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eUT);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eUT;
        userMuteCheckCustomMessage.setTag(this.eUT);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aUX() {
        return this.eUR;
    }

    public String aUY() {
        return this.eUS;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bTj != null) {
            this.bTj.aI(false);
        }
        this.eUR = i2;
        this.eUS = str;
        if (i3 == 0) {
            if (i == 1) {
                this.evl.c(this.ajP.getString(w.l.mute_success));
            } else if (i == 2) {
                this.evl.c(this.ajP.getResources().getString(w.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.ajP.getString(w.l.mute_error_beyond_limit);
            }
            fS(str2);
        } else if (i3 == 1990043) {
            aOf();
        } else {
            if (aw.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.ajP.getResources().getString(w.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.ajP.getResources().getString(w.l.un_mute_fail);
                }
            }
            this.evl.d(str2);
        }
    }

    public void Qx() {
        if (this.bTj == null) {
            this.bTj = new com.baidu.tbadk.core.view.a(this.ajP);
            this.bTj.c(new c(this));
        }
        this.bTj.aI(true);
    }

    public void fS(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajP.getPageActivity());
        aVar.cI(str);
        aVar.b(w.l.know, new d(this));
        aVar.b(this.ajP).ta();
    }

    public void aOf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajP.getPageActivity());
        aVar.cI(this.ajP.getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new e(this));
        aVar.b(w.l.cancel, new f(this));
        aVar.b(this.ajP).ta();
    }

    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            Qx();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ajP.getPageActivity());
        if (aw.isEmpty(str)) {
            aVar.cI(this.ajP.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cI(str);
        }
        aVar.a(w.l.confirm, new g(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new h(this));
        aVar.b(this.ajP).ta();
    }
}
