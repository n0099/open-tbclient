package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.person.PersonImageActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements c.b {
    final /* synthetic */ PersonImageActivity efn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonImageActivity personImageActivity) {
        this.efn = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        PersonImageActivity.a aVar;
        listMenu = this.efn.getListMenu();
        if (cVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.efn.cDK;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.efn.cDK;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.efn.efm = new PersonImageActivity.a(currentImageUrl, currentImageData);
                        aVar = this.efn.efm;
                        aVar.execute(new String[0]);
                        this.efn.cbl.setVisibility(0);
                    } else {
                        this.efn.showToast(this.efn.getPageContext().getString(u.j.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            cVar.dismiss();
        }
    }
}
