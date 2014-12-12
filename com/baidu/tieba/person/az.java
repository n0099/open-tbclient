package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonImageActivity bGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonImageActivity personImageActivity) {
        this.bGv = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        bb bbVar;
        ProgressBar progressBar;
        listMenu = this.bGv.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.bGv.aPU;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.bGv.aPU;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.bGv.bGu = new bb(this.bGv, currentImageUrl, currentImageData);
                    bbVar = this.bGv.bGu;
                    bbVar.execute(new String[0]);
                    progressBar = this.bGv.mProgress;
                    progressBar.setVisibility(0);
                } else {
                    this.bGv.showToast(this.bGv.getPageContext().getString(com.baidu.tieba.z.no_data));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
