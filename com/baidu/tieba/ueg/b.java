package com.baidu.tieba.ueg;

import android.app.Activity;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
/* loaded from: classes.dex */
public class b {
    public static boolean jtW = false;
    private UEGCancelModel.a jtU;
    public int jtV = au.a.bUo;
    private UEGCancelModel jtT = new UEGCancelModel();

    public b() {
        if (this.jtU == null) {
            this.jtU = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.jtW) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.jtT.a(this.jtU);
    }

    public void BW(int i) {
        this.jtV = i;
        this.jtT.cancelRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BlockPopInfoData blockPopInfoData) {
        boolean z = false;
        if (blockPopInfoData != null && com.baidu.adp.base.a.eT().eU() != null) {
            String str = blockPopInfoData.block_id_code;
            int i = blockPopInfoData.win_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str2 = blockPopInfoData.ahead_url;
            String str3 = blockPopInfoData.ok_info;
            String str4 = blockPopInfoData.ahead_info;
            String str5 = blockPopInfoData.block_info;
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !aq.isEmpty(currentAccount) && !aq.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean(str + i + currentAccount, false);
                if ((!aq.isEmpty(str2) || i == 4) && !aq.isEmpty(str3) && ((!aq.isEmpty(str4) || i == 4) && !aq.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new an("c12534").P("obj_locate", this.jtV).P("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity eU;
        if (blockPopInfoData != null && (eU = com.baidu.adp.base.a.eT().eU()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(eU);
            aVar.mO(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new an("c12535").P("obj_locate", b.this.jtV).P("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new an("c12536").P("obj_locate", b.this.jtV).P("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((f) eU).getPageContext());
            aVar.agK();
        }
    }

    public void rB(boolean z) {
        jtW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity eU;
        if (blockPopInfoData != null && (eU = com.baidu.adp.base.a.eT().eU()) != null) {
            AntiHelper.aK(eU, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.jtT != null) {
            this.jtT.onDestroy();
        }
    }
}
