package com.baidu.tieba.ueg;

import android.app.Activity;
import com.baidu.adp.base.f;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
/* loaded from: classes.dex */
public class b {
    public static boolean mbd = false;
    private UEGCancelModel.a mbb;
    public int mbc = aw.a.ebz;
    private UEGCancelModel mba = new UEGCancelModel();

    public b() {
        if (this.mbb == null) {
            this.mbb = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.mbd) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.mba.a(this.mbb);
    }

    public void Gj(int i) {
        this.mbc = i;
        this.mba.cancelRequest();
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
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !as.isEmpty(currentAccount) && !as.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(str + i + currentAccount, false);
                if ((!as.isEmpty(str2) || i == 4) && !as.isEmpty(str3) && ((!as.isEmpty(str4) || i == 4) && !as.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", this.mbc).ah("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.a.jC().currentActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(currentActivity);
            aVar.xl(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", b.this.mbc).ah("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", b.this.mbc).ah("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((f) currentActivity).getPageContext());
            aVar.aYL();
        }
    }

    public void vI(boolean z) {
        mbd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.a.jC().currentActivity()) != null) {
            AntiHelper.aX(currentActivity, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.mba != null) {
            this.mba.onDestroy();
        }
    }
}
