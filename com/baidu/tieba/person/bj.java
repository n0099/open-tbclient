package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements c.b {
    final /* synthetic */ PersonImageActivity cPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonImageActivity personImageActivity) {
        this.cPF = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        PersonImageActivity.a aVar;
        listMenu = this.cPF.getListMenu();
        if (cVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.cPF.bJU;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.cPF.bJU;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.cPF.cPE = new PersonImageActivity.a(currentImageUrl, currentImageData);
                        aVar = this.cPF.cPE;
                        aVar.execute(new String[0]);
                        this.cPF.mProgress.setVisibility(0);
                    } else {
                        this.cPF.showToast(this.cPF.getPageContext().getString(n.j.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            cVar.dismiss();
        }
    }
}
