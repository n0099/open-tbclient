package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.personPolymeric.mode.a {
    private TbPageContext alI;
    private com.baidu.tbadk.core.view.a bYD;
    private BdUniqueId fiG;
    private int fiE = -1;
    private String fiF = "";
    private com.baidu.tbadk.core.view.c eHH = new com.baidu.tbadk.core.view.c();

    public BdUniqueId getUniqueId() {
        return this.fiG;
    }

    public b(TbPageContext tbPageContext) {
        this.alI = tbPageContext;
        this.eHH.alm = 1000L;
        this.fiG = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.fiG;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.fiG);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fiG;
        userMuteCheckCustomMessage.setTag(this.fiG);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aYd() {
        return this.fiE;
    }

    public String aYe() {
        return this.fiF;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bYD != null) {
            this.bYD.aH(false);
        }
        this.fiE = i2;
        this.fiF = str;
        if (i3 == 0) {
            if (i == 1) {
                this.eHH.c(this.alI.getString(d.l.mute_success));
            } else if (i == 2) {
                this.eHH.c(this.alI.getResources().getString(d.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.alI.getString(d.l.mute_error_beyond_limit);
            }
            gc(str2);
        } else if (i3 == 1990043) {
            aQU();
        } else {
            if (al.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.alI.getResources().getString(d.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.alI.getResources().getString(d.l.un_mute_fail);
                }
            }
            this.eHH.d(str2);
        }
    }

    public void QX() {
        if (this.bYD == null) {
            this.bYD = new com.baidu.tbadk.core.view.a(this.alI);
            this.bYD.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(b.this.fiG);
                }
            });
        }
        this.bYD.aH(true);
    }

    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.alI.getPageActivity());
        aVar.cT(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.alI).tr();
    }

    public void aQU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.alI.getPageActivity());
        aVar.cT(this.alI.getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    b.this.alI.showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10038");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) b.this.alI.getPageActivity(), 2, true, 5);
                if (!StringUtils.isNULL("4010001002")) {
                    memberPayActivityConfig.setSceneId("4010001002");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.alI).tr();
    }

    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            QX();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.alI.getPageActivity());
        if (al.isEmpty(str)) {
            aVar.cT(this.alI.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cT(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                b.this.QX();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.alI).tr();
    }
}
