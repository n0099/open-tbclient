package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PersonImageActivity bTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonImageActivity personImageActivity) {
        this.bTk = personImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        br brVar;
        ProgressBar progressBar;
        listMenu = this.bTk.getListMenu();
        if (eVar == listMenu) {
            if (i == 0) {
                try {
                    multiImageView = this.bTk.aZa;
                    byte[] currentImageData = multiImageView.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView2 = this.bTk.aZa;
                        String currentImageUrl = multiImageView2.getCurrentImageUrl();
                        this.bTk.bTj = new br(this.bTk, currentImageUrl, currentImageData);
                        brVar = this.bTk.bTj;
                        brVar.execute(new String[0]);
                        progressBar = this.bTk.mProgress;
                        progressBar.setVisibility(0);
                    } else {
                        this.bTk.showToast(this.bTk.getPageContext().getString(com.baidu.tieba.t.no_data));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            eVar.dismiss();
        }
    }
}
