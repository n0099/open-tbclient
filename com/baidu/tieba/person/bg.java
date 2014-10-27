package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonImageActivity bCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonImageActivity personImageActivity) {
        this.bCI = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        bi biVar;
        ProgressBar progressBar;
        listMenu = this.bCI.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.bCI.aNr;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.bCI.aNr;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.bCI.bCH = new bi(this.bCI, currentImageUrl, currentImageData);
                    biVar = this.bCI.bCH;
                    biVar.execute(new String[0]);
                    progressBar = this.bCI.mProgress;
                    progressBar.setVisibility(0);
                } else {
                    this.bCI.showToast(this.bCI.getString(com.baidu.tieba.y.no_data));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
