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
    public static boolean iTH = false;
    private UEGCancelModel.a iTF;
    public int iTG = at.a.bLq;
    private UEGCancelModel iTE = new UEGCancelModel();

    public b() {
        if (this.iTF == null) {
            this.iTF = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.iTH) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.iTE.a(this.iTF);
    }

    public void Ai(int i) {
        this.iTG = i;
        this.iTE.cancelRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BlockPopInfoData blockPopInfoData) {
        boolean z = false;
        if (blockPopInfoData != null && com.baidu.adp.base.a.fT().fU() != null) {
            String str = blockPopInfoData.block_id_code;
            int i = blockPopInfoData.win_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str2 = blockPopInfoData.ahead_url;
            String str3 = blockPopInfoData.ok_info;
            String str4 = blockPopInfoData.ahead_info;
            String str5 = blockPopInfoData.block_info;
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !ap.isEmpty(currentAccount) && !ap.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str + i + currentAccount, false);
                if ((!ap.isEmpty(str2) || i == 4) && !ap.isEmpty(str3) && ((!ap.isEmpty(str4) || i == 4) && !ap.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new am("c12534").T("obj_locate", this.iTG).T("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity fU;
        if (blockPopInfoData != null && (fU = com.baidu.adp.base.a.fT().fU()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fU);
            aVar.ly(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new am("c12535").T("obj_locate", b.this.iTG).T("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new am("c12536").T("obj_locate", b.this.iTG).T("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((f) fU).getPageContext());
            aVar.aaZ();
        }
    }

    public void qx(boolean z) {
        iTH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity fU;
        if (blockPopInfoData != null && (fU = com.baidu.adp.base.a.fT().fU()) != null) {
            AntiHelper.aW(fU, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.iTE != null) {
            this.iTE.onDestroy();
        }
    }
}
