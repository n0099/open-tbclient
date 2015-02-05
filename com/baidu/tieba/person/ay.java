package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonImageActivity bIg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonImageActivity personImageActivity) {
        this.bIg = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        ba baVar;
        ProgressBar progressBar;
        listMenu = this.bIg.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.bIg.aQY;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.bIg.aQY;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.bIg.bIf = new ba(this.bIg, currentImageUrl, currentImageData);
                    baVar = this.bIg.bIf;
                    baVar.execute(new String[0]);
                    progressBar = this.bIg.mProgress;
                    progressBar.setVisibility(0);
                } else {
                    this.bIg.showToast(this.bIg.getPageContext().getString(com.baidu.tieba.z.no_data));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
