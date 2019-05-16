package com.baidu.tieba.ueg;

import android.app.Activity;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
/* loaded from: classes.dex */
public class b {
    public static boolean jmD = false;
    private UEGCancelModel.a jmB;
    public int jmC = at.a.bTg;
    private UEGCancelModel jmA = new UEGCancelModel();

    public b() {
        if (this.jmB == null) {
            this.jmB = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.jmD) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.jmA.a(this.jmB);
    }

    public void Bn(int i) {
        this.jmC = i;
        this.jmA.cancelRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BlockPopInfoData blockPopInfoData) {
        boolean z = false;
        if (blockPopInfoData != null && com.baidu.adp.base.a.eM().eN() != null) {
            String str = blockPopInfoData.block_id_code;
            int i = blockPopInfoData.win_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str2 = blockPopInfoData.ahead_url;
            String str3 = blockPopInfoData.ok_info;
            String str4 = blockPopInfoData.ahead_info;
            String str5 = blockPopInfoData.block_info;
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !ap.isEmpty(currentAccount) && !ap.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(str + i + currentAccount, false);
                if ((!ap.isEmpty(str2) || i == 4) && !ap.isEmpty(str3) && ((!ap.isEmpty(str4) || i == 4) && !ap.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new am("c12534").P("obj_locate", this.jmC).P("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity eN;
        if (blockPopInfoData != null && (eN = com.baidu.adp.base.a.eM().eN()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(eN);
            aVar.mE(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new am("c12535").P("obj_locate", b.this.jmC).P("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new am("c12536").P("obj_locate", b.this.jmC).P("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((f) eN).getPageContext());
            aVar.afG();
        }
    }

    public void rm(boolean z) {
        jmD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity eN;
        if (blockPopInfoData != null && (eN = com.baidu.adp.base.a.eM().eN()) != null) {
            AntiHelper.aJ(eN, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.jmA != null) {
            this.jmA.onDestroy();
        }
    }
}
