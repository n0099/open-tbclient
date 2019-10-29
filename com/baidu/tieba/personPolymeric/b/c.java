package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes6.dex */
public class c implements com.baidu.tieba.personPolymeric.mode.a {
    private BdUniqueId iqN;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private int iqL = -1;
    private String iqM = "";
    private com.baidu.tbadk.core.view.e hMs = new com.baidu.tbadk.core.view.e();

    public BdUniqueId getUniqueId() {
        return this.iqN;
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.hMs.toastTime = 1000L;
        this.iqN = bdUniqueId;
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.iqN;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.iqN);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iqN;
        userMuteCheckCustomMessage.setTag(this.iqN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public int caJ() {
        return this.iqL;
    }

    public String caK() {
        return this.iqM;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.a
    public void a(int i, int i2, String str, int i3, String str2) {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
        }
        this.iqL = i2;
        this.iqM = str;
        if (i3 == 0) {
            if (i == 1) {
                this.hMs.showSuccessToast(this.mPageContext.getString(R.string.mute_success));
            } else if (i == 2) {
                this.hMs.showSuccessToast(this.mPageContext.getResources().getString(R.string.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.mPageContext.getString(R.string.mute_error_beyond_limit);
            }
            pP(str2);
        } else if (i3 == 1990043) {
            bSG();
        } else {
            if (aq.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.mPageContext.getResources().getString(R.string.mute_fail);
                } else if (i == 2) {
                    str2 = this.mPageContext.getResources().getString(R.string.un_mute_fail);
                }
            }
            this.hMs.showFailToast(str2);
        }
    }

    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.mPageContext);
            this.mWaitingDialog.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(c.this.iqN);
                }
            });
        }
        this.mWaitingDialog.setDialogVisiable(true);
    }

    public void pP(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).akO();
    }

    public void bSG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nn(this.mPageContext.getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    c.this.mPageContext.showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10038");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) c.this.mPageContext.getPageActivity(), 2, true, 5);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                if (!StringUtils.isNULL("4010001002")) {
                    memberPayActivityConfig.setSceneId("4010001002");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).akO();
    }

    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.nn(this.mPageContext.getResources().getString(R.string.block_mute_message_alert, str2));
        } else {
            aVar.nn(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                c.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).akO();
    }
}
