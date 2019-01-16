package com.baidu.tieba.ueg;

import android.app.Activity;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
/* loaded from: classes.dex */
public class b {
    public static boolean hDs = false;
    private UEGCancelModel.a hDq;
    public int hDr = as.a.aDu;
    private UEGCancelModel hDp = new UEGCancelModel();

    public b() {
        if (this.hDq == null) {
            this.hDq = new UEGCancelModel.a() { // from class: com.baidu.tieba.ueg.b.1
                @Override // com.baidu.tieba.ueg.UEGCancelModel.a
                public void d(BlockPopInfoData blockPopInfoData) {
                    if (blockPopInfoData != null && !b.hDs) {
                        b.this.a(blockPopInfoData);
                    }
                }
            };
        }
        this.hDp.a(this.hDq);
    }

    public void wx(int i) {
        this.hDr = i;
        this.hDp.cancelRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BlockPopInfoData blockPopInfoData) {
        boolean z = false;
        if (blockPopInfoData != null && com.baidu.adp.base.a.fW().fX() != null) {
            String str = blockPopInfoData.block_id_code;
            int i = blockPopInfoData.win_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str2 = blockPopInfoData.ahead_url;
            String str3 = blockPopInfoData.ok_info;
            String str4 = blockPopInfoData.ahead_info;
            String str5 = blockPopInfoData.block_info;
            if ((i == 1 || i == 2 || i == 3 || i == 4) && !ao.isEmpty(currentAccount) && !ao.isEmpty(str)) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str + i + currentAccount, false);
                if ((!ao.isEmpty(str2) || i == 4) && !ao.isEmpty(str3) && ((!ao.isEmpty(str4) || i == 4) && !ao.isEmpty(str5))) {
                    z = true;
                }
                if (!z2 && z) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str + i + currentAccount, true);
                    b(blockPopInfoData);
                    TiebaStatic.log(new am("c12534").y("obj_locate", this.hDr).y("obj_type", i));
                }
            }
        }
    }

    private void b(final BlockPopInfoData blockPopInfoData) {
        Activity fX;
        if (blockPopInfoData != null && (fX = com.baidu.adp.base.a.fW().fX()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fX);
            aVar.eK(blockPopInfoData.block_info);
            aVar.b(blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    TiebaStatic.log(new am("c12535").y("obj_locate", b.this.hDr).y("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.a(blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfoData);
                    TiebaStatic.log(new am("c12536").y("obj_locate", b.this.hDr).y("obj_type", blockPopInfoData.win_type));
                }
            });
            aVar.b(((f) fX).getPageContext());
            aVar.BS();
        }
    }

    public void nX(boolean z) {
        hDs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfoData blockPopInfoData) {
        Activity fX;
        if (blockPopInfoData != null && (fX = com.baidu.adp.base.a.fW().fX()) != null) {
            AntiHelper.aI(fX, blockPopInfoData.ahead_url);
        }
    }

    public void onDestroy() {
        if (this.hDp != null) {
            this.hDp.onDestroy();
        }
    }
}
