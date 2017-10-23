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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.personPolymeric.mode.a {
    private com.baidu.tbadk.core.view.a ccU;
    private BdUniqueId feQ;
    private TbPageContext mH;
    private int feO = -1;
    private String feP = "";
    private com.baidu.tbadk.core.view.c eBU = new com.baidu.tbadk.core.view.c();

    public BdUniqueId getUniqueId() {
        return this.feQ;
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mH = tbPageContext;
        this.eBU.akv = 1000L;
        this.feQ = bdUniqueId;
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.feQ;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.feQ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.feQ;
        userMuteCheckCustomMessage.setTag(this.feQ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aWv() {
        return this.feO;
    }

    public String aWw() {
        return this.feP;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.ccU != null) {
            this.ccU.aG(false);
        }
        this.feO = i2;
        this.feP = str;
        if (i3 == 0) {
            if (i == 1) {
                this.eBU.c(this.mH.getString(d.l.mute_success));
            } else if (i == 2) {
                this.eBU.c(this.mH.getResources().getString(d.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.mH.getString(d.l.mute_error_beyond_limit);
            }
            fS(str2);
        } else if (i3 == 1990043) {
            aOL();
        } else {
            if (am.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.mH.getResources().getString(d.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.mH.getResources().getString(d.l.un_mute_fail);
                }
            }
            this.eBU.d(str2);
        }
    }

    public void showLoadingDialog() {
        if (this.ccU == null) {
            this.ccU = new com.baidu.tbadk.core.view.a(this.mH);
            this.ccU.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(c.this.feQ);
                }
            });
        }
        this.ccU.aG(true);
    }

    public void fS(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mH.getPageActivity());
        aVar.cL(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mH).tb();
    }

    public void aOL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mH.getPageActivity());
        aVar.cL(this.mH.getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    c.this.mH.showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10038");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) c.this.mH.getPageActivity(), 2, true, 5);
                memberPayActivityConfig.setReferPageClickZone("he/her_personal_center_V8.9", "pop_ups_opende_button_V8.9");
                if (!StringUtils.isNULL("4010001002")) {
                    memberPayActivityConfig.setSceneId("4010001002");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mH).tb();
    }

    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mH.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.cL(this.mH.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cL(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                c.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mH).tb();
    }
}
