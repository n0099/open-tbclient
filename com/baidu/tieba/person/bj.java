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
    final /* synthetic */ PersonImageActivity dtF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonImageActivity personImageActivity) {
        this.dtF = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        PersonImageActivity.a aVar;
        listMenu = this.dtF.getListMenu();
        if (cVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.dtF.bXV;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.dtF.bXV;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.dtF.dtE = new PersonImageActivity.a(currentImageUrl, currentImageData);
                        aVar = this.dtF.dtE;
                        aVar.execute(new String[0]);
                        this.dtF.aQj.setVisibility(0);
                    } else {
                        this.dtF.showToast(this.dtF.getPageContext().getString(t.j.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            cVar.dismiss();
        }
    }
}
