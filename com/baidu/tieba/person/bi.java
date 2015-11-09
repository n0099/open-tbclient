package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements c.b {
    final /* synthetic */ PersonImageActivity crV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonImageActivity personImageActivity) {
        this.crV = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        PersonImageActivity.a aVar;
        listMenu = this.crV.getListMenu();
        if (cVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.crV.brh;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.crV.brh;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.crV.crU = new PersonImageActivity.a(currentImageUrl, currentImageData);
                        aVar = this.crV.crU;
                        aVar.execute(new String[0]);
                        this.crV.mProgress.setVisibility(0);
                    } else {
                        this.crV.showToast(this.crV.getPageContext().getString(i.h.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            cVar.dismiss();
        }
    }
}
