package com.baidu.tieba.ueg;

import android.app.Activity;
import com.baidu.adp.base.g;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
/* loaded from: classes.dex */
public class b {
    public static boolean nEv = false;
    private UEGCancelModel.a nEt;
    public int nEu = ax.a.fdK;
    private UEGCancelModel nEs = new UEGCancelModel();

    public b() {
        if (this.nEt == null) {
            this.nEt = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.nEv) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.nEs.a(this.nEt);
    }

    public void LD(int i) {
        this.nEu = i;
        this.nEs.cancelRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BlockPopInfoData blockPopInfoData) {
        boolean z = false;
        if (blockPopInfoData != null && com.baidu.adp.base.b.kC().currentActivity() != null) {
            String str = blockPopInfoData.block_id_code;
            int i = blockPopInfoData.win_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str2 = blockPopInfoData.ahead_url;
            String str3 = blockPopInfoData.ok_info;
            String str4 = blockPopInfoData.ahead_info;
            String str5 = blockPopInfoData.block_info;
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !at.isEmpty(currentAccount) && !at.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(str + i + currentAccount, false);
                if ((!at.isEmpty(str2) || i == 4) && !at.isEmpty(str3) && ((!at.isEmpty(str4) || i == 4) && !at.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", this.nEu).an("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.b.kC().currentActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(currentActivity);
            aVar.Bp(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", b.this.nEu).an("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", b.this.nEu).an("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((g) currentActivity).getPageContext());
            aVar.btX();
        }
    }

    public void yE(boolean z) {
        nEv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity currentActivity;
        if (blockPopInfoData != null && (currentActivity = com.baidu.adp.base.b.kC().currentActivity()) != null) {
            AntiHelper.bt(currentActivity, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.nEs != null) {
            this.nEs.onDestroy();
        }
    }
}
