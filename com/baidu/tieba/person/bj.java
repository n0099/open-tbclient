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
    final /* synthetic */ PersonImageActivity cLp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonImageActivity personImageActivity) {
        this.cLp = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        PersonImageActivity.a aVar;
        listMenu = this.cLp.getListMenu();
        if (cVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.cLp.bGn;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.cLp.bGn;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.cLp.cLo = new PersonImageActivity.a(currentImageUrl, currentImageData);
                        aVar = this.cLp.cLo;
                        aVar.execute(new String[0]);
                        this.cLp.mProgress.setVisibility(0);
                    } else {
                        this.cLp.showToast(this.cLp.getPageContext().getString(n.i.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            cVar.dismiss();
        }
    }
}
