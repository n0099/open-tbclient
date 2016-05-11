package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.person.PersonImageActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements c.b {
    final /* synthetic */ PersonImageActivity dwV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PersonImageActivity personImageActivity) {
        this.dwV = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        PersonImageActivity.a aVar;
        listMenu = this.dwV.getListMenu();
        if (cVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.dwV.bYA;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.dwV.bYA;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.dwV.dwU = new PersonImageActivity.a(currentImageUrl, currentImageData);
                        aVar = this.dwV.dwU;
                        aVar.execute(new String[0]);
                        this.dwV.bDI.setVisibility(0);
                    } else {
                        this.dwV.showToast(this.dwV.getPageContext().getString(t.j.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            cVar.dismiss();
        }
    }
}
