package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonImageActivity bIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonImageActivity personImageActivity) {
        this.bIh = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        ba baVar;
        ProgressBar progressBar;
        listMenu = this.bIh.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.bIh.aQZ;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.bIh.aQZ;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.bIh.bIg = new ba(this.bIh, currentImageUrl, currentImageData);
                    baVar = this.bIh.bIg;
                    baVar.execute(new String[0]);
                    progressBar = this.bIh.mProgress;
                    progressBar.setVisibility(0);
                } else {
                    this.bIh.showToast(this.bIh.getPageContext().getString(com.baidu.tieba.z.no_data));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
