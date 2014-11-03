package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonImageActivity bCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonImageActivity personImageActivity) {
        this.bCW = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        bj bjVar;
        listMenu = this.bCW.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.bCW.aNF;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.bCW.aNF;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.bCW.bCV = new bj(this.bCW, currentImageUrl, currentImageData);
                    bjVar = this.bCW.bCV;
                    bjVar.execute(new String[0]);
                    this.bCW.showProgressBarWithOffset(0, 0);
                } else {
                    this.bCW.showToast(this.bCW.getString(com.baidu.tieba.y.no_data));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
