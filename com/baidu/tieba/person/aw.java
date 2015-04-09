package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonImageActivity bQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PersonImageActivity personImageActivity) {
        this.bQE = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        ay ayVar;
        ProgressBar progressBar;
        listMenu = this.bQE.getListMenu();
        if (eVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.bQE.aWu;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.bQE.aWu;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.bQE.bQD = new ay(this.bQE, currentImageUrl, currentImageData);
                        ayVar = this.bQE.bQD;
                        ayVar.execute(new String[0]);
                        progressBar = this.bQE.mProgress;
                        progressBar.setVisibility(0);
                    } else {
                        this.bQE.showToast(this.bQE.getPageContext().getString(com.baidu.tieba.y.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            eVar.dismiss();
        }
    }
}
