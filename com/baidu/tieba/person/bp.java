package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonImageActivity bTj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonImageActivity personImageActivity) {
        this.bTj = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        br brVar;
        ProgressBar progressBar;
        listMenu = this.bTj.getListMenu();
        if (eVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.bTj.aYZ;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.bTj.aYZ;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.bTj.bTi = new br(this.bTj, currentImageUrl, currentImageData);
                        brVar = this.bTj.bTi;
                        brVar.execute(new String[0]);
                        progressBar = this.bTj.mProgress;
                        progressBar.setVisibility(0);
                    } else {
                        this.bTj.showToast(this.bTj.getPageContext().getString(com.baidu.tieba.t.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            eVar.dismiss();
        }
    }
}
