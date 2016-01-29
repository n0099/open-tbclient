package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.person.PersonImageActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements c.b {
    final /* synthetic */ PersonImageActivity cZc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonImageActivity personImageActivity) {
        this.cZc = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        PersonImageActivity.a aVar;
        listMenu = this.cZc.getListMenu();
        if (cVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.cZc.bND;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.cZc.bND;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.cZc.cZb = new PersonImageActivity.a(currentImageUrl, currentImageData);
                        aVar = this.cZc.cZb;
                        aVar.execute(new String[0]);
                        this.cZc.aNo.setVisibility(0);
                    } else {
                        this.cZc.showToast(this.cZc.getPageContext().getString(t.j.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            cVar.dismiss();
        }
    }
}
