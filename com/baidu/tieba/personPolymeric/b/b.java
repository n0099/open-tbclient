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
    private com.baidu.tbadk.core.view.a bZq;
    private BdUniqueId fkB;
    private TbPageContext oW;
    private int fkz = -1;
    private String fkA = "";
    private com.baidu.tbadk.core.view.c eJD = new com.baidu.tbadk.core.view.c();

    public BdUniqueId getUniqueId() {
        return this.fkB;
    }

    public b(TbPageContext tbPageContext) {
        this.oW = tbPageContext;
        this.eJD.alo = 1000L;
        this.fkB = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.fkB;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.fkB);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fkB;
        userMuteCheckCustomMessage.setTag(this.fkB);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aYF() {
        return this.fkz;
    }

    public String aYG() {
        return this.fkA;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bZq != null) {
            this.bZq.aH(false);
        }
        this.fkz = i2;
        this.fkA = str;
        if (i3 == 0) {
            if (i == 1) {
                this.eJD.c(this.oW.getString(d.l.mute_success));
            } else if (i == 2) {
                this.eJD.c(this.oW.getResources().getString(d.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.oW.getString(d.l.mute_error_beyond_limit);
            }
            gg(str2);
        } else if (i3 == 1990043) {
            aRw();
        } else {
            if (al.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.oW.getResources().getString(d.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.oW.getResources().getString(d.l.un_mute_fail);
                }
            }
            this.eJD.d(str2);
        }
    }

    public void showLoadingDialog() {
        if (this.bZq == null) {
            this.bZq = new com.baidu.tbadk.core.view.a(this.oW);
            this.bZq.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(b.this.fkB);
                }
            });
        }
        this.bZq.aH(true);
    }

    public void gg(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.oW.getPageActivity());
        aVar.cW(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.oW).ts();
    }

    public void aRw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.oW.getPageActivity());
        aVar.cW(this.oW.getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    b.this.oW.showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10038");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) b.this.oW.getPageActivity(), 2, true, 5);
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
        aVar.b(this.oW).ts();
    }

    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.oW.getPageActivity());
        if (al.isEmpty(str)) {
            aVar.cW(this.oW.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cW(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                b.this.showLoadingDialog();
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
        aVar.b(this.oW).ts();
    }
}
