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
    private TbPageContext ako;
    private com.baidu.tbadk.core.view.a bXx;
    private BdUniqueId fhs;
    private int fhq = -1;
    private String fhr = "";
    private com.baidu.tbadk.core.view.c eGu = new com.baidu.tbadk.core.view.c();

    public BdUniqueId getUniqueId() {
        return this.fhs;
    }

    public b(TbPageContext tbPageContext) {
        this.ako = tbPageContext;
        this.eGu.ajS = 1000L;
        this.fhs = tbPageContext.getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.fhs;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.fhs);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fhs;
        userMuteCheckCustomMessage.setTag(this.fhs);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int aXS() {
        return this.fhq;
    }

    public String aXT() {
        return this.fhr;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.bXx != null) {
            this.bXx.aH(false);
        }
        this.fhq = i2;
        this.fhr = str;
        if (i3 == 0) {
            if (i == 1) {
                this.eGu.c(this.ako.getString(d.l.mute_success));
            } else if (i == 2) {
                this.eGu.c(this.ako.getResources().getString(d.l.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.ako.getString(d.l.mute_error_beyond_limit);
            }
            fW(str2);
        } else if (i3 == 1990043) {
            aQJ();
        } else {
            if (al.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.ako.getResources().getString(d.l.mute_fail);
                } else if (i == 2) {
                    str2 = this.ako.getResources().getString(d.l.un_mute_fail);
                }
            }
            this.eGu.d(str2);
        }
    }

    public void QS() {
        if (this.bXx == null) {
            this.bXx = new com.baidu.tbadk.core.view.a(this.ako);
            this.bXx.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(b.this.fhs);
                }
            });
        }
        this.bXx.aH(true);
    }

    public void fW(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ako.getPageActivity());
        aVar.cN(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ako).th();
    }

    public void aQJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ako.getPageActivity());
        aVar.cN(this.ako.getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    b.this.ako.showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10038");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) b.this.ako.getPageActivity(), 2, true, 5);
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
        aVar.b(this.ako).th();
    }

    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            QS();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ako.getPageActivity());
        if (al.isEmpty(str)) {
            aVar.cN(this.ako.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cN(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.b.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                b.this.QS();
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
        aVar.b(this.ako).th();
    }
}
