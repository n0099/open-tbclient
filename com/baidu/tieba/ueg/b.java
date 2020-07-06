package com.baidu.tieba.ueg;

import android.app.Activity;
import com.baidu.adp.base.f;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
/* loaded from: classes.dex */
public class b {
    public static boolean lTL = false;
    private UEGCancelModel.a lTJ;
    public int lTK = av.a.dVe;
    private UEGCancelModel lTI = new UEGCancelModel();

    public b() {
        if (this.lTJ == null) {
            this.lTJ = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.lTL) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.lTI.a(this.lTJ);
    }

    public void FN(int i) {
        this.lTK = i;
        this.lTI.cancelRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BlockPopInfoData blockPopInfoData) {
        boolean z = false;
        if (blockPopInfoData != null && com.baidu.adp.base.a.jC().currentActivity() != null) {
            String str = blockPopInfoData.block_id_code;
            int i = blockPopInfoData.win_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str2 = blockPopInfoData.ahead_url;
            String str3 = blockPopInfoData.ok_info;
            String str4 = blockPopInfoData.ahead_info;
            String str5 = blockPopInfoData.block_info;
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !ar.isEmpty(currentAccount) && !ar.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(str + i + currentAccount, false);
                if ((!ar.isEmpty(str2) || i == 4) && !ar.isEmpty(str3) && ((!ar.isEmpty(str4) || i == 4) && !ar.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", this.lTK).ag("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.a.jC().currentActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(currentActivity);
            aVar.we(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", b.this.lTK).ag("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", b.this.lTK).ag("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((f) currentActivity).getPageContext());
            aVar.aUN();
        }
    }

    public void ve(boolean z) {
        lTL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.a.jC().currentActivity()) != null) {
            AntiHelper.aY(currentActivity, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.lTI != null) {
            this.lTI.onDestroy();
        }
    }
}
