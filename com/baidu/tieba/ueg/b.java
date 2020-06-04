package com.baidu.tieba.ueg;

import android.app.Activity;
import com.baidu.adp.base.f;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
/* loaded from: classes.dex */
public class b {
    public static boolean lAd = false;
    private UEGCancelModel.a lAb;
    public int lAc = at.a.dOm;
    private UEGCancelModel lAa = new UEGCancelModel();

    public b() {
        if (this.lAb == null) {
            this.lAb = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.lAd) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.lAa.a(this.lAb);
    }

    public void EL(int i) {
        this.lAc = i;
        this.lAa.cancelRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BlockPopInfoData blockPopInfoData) {
        boolean z = false;
        if (blockPopInfoData != null && com.baidu.adp.base.a.jm().currentActivity() != null) {
            String str = blockPopInfoData.block_id_code;
            int i = blockPopInfoData.win_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str2 = blockPopInfoData.ahead_url;
            String str3 = blockPopInfoData.ok_info;
            String str4 = blockPopInfoData.ahead_info;
            String str5 = blockPopInfoData.block_info;
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !aq.isEmpty(currentAccount) && !aq.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(str + i + currentAccount, false);
                if ((!aq.isEmpty(str2) || i == 4) && !aq.isEmpty(str3) && ((!aq.isEmpty(str4) || i == 4) && !aq.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", this.lAc).ag("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.a.jm().currentActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(currentActivity);
            aVar.vO(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", b.this.lAc).ag("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", b.this.lAc).ag("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((f) currentActivity).getPageContext());
            aVar.aST();
        }
    }

    public void uP(boolean z) {
        lAd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.a.jm().currentActivity()) != null) {
            AntiHelper.aY(currentActivity, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.lAa != null) {
            this.lAa.onDestroy();
        }
    }
}
