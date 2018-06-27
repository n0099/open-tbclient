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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes3.dex */
public class c implements com.baidu.tieba.personPolymeric.mode.a {
    private BdUniqueId fYU;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private int fYS = -1;
    private String fYT = "";
    private com.baidu.tbadk.core.view.d fvC = new com.baidu.tbadk.core.view.d();

    public BdUniqueId getUniqueId() {
        return this.fYU;
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.fvC.avm = 1000L;
        this.fYU = bdUniqueId;
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.mId = this.fYU;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.fYU);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fYU;
        userMuteCheckCustomMessage.setTag(this.fYU);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int bkE() {
        return this.fYS;
    }

    public String bkF() {
        return this.fYT;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.aO(false);
        }
        this.fYS = i2;
        this.fYT = str;
        if (i3 == 0) {
            if (i == 1) {
                this.fvC.i(this.mPageContext.getString(d.k.mute_success));
            } else if (i == 2) {
                this.fvC.i(this.mPageContext.getResources().getString(d.k.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.mPageContext.getString(d.k.mute_error_beyond_limit);
            }
            gV(str2);
        } else if (i3 == 1990043) {
            bcY();
        } else {
            if (ap.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.mPageContext.getResources().getString(d.k.mute_fail);
                } else if (i == 2) {
                    str2 = this.mPageContext.getResources().getString(d.k.un_mute_fail);
                }
            }
            this.fvC.j(str2);
        }
    }

    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.mPageContext);
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(c.this.fYU);
                }
            });
        }
        this.mWaitingDialog.aO(true);
    }

    public void gV(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.dE(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).xn();
    }

    public void bcY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.dE(this.mPageContext.getString(d.k.mute_is_super_member_function));
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    c.this.mPageContext.showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10038");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) c.this.mPageContext.getPageActivity(), 2, true, 5);
                memberPayActivityConfig.setReferPageClickZone("he/her_personal_center_V8.9", "pop_ups_opende_button_V8.9");
                if (!StringUtils.isNULL("4010001002")) {
                    memberPayActivityConfig.setSceneId("4010001002");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).xn();
    }

    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        if (ap.isEmpty(str)) {
            aVar.dE(this.mPageContext.getResources().getString(d.k.block_mute_message_alert, str2));
        } else {
            aVar.dE(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                c.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).xn();
    }
}
