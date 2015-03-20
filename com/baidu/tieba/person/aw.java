package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonImageActivity bQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PersonImageActivity personImageActivity) {
        this.bQo = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        ay ayVar;
        ProgressBar progressBar;
        listMenu = this.bQo.getListMenu();
        if (eVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.bQo.aWe;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.bQo.aWe;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.bQo.bQn = new ay(this.bQo, currentImageUrl, currentImageData);
                        ayVar = this.bQo.bQn;
                        ayVar.execute(new String[0]);
                        progressBar = this.bQo.mProgress;
                        progressBar.setVisibility(0);
                    } else {
                        this.bQo.showToast(this.bQo.getPageContext().getString(com.baidu.tieba.y.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            eVar.dismiss();
        }
    }
}
