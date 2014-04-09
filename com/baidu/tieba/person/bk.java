package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* loaded from: classes.dex */
final class bk implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PersonImageActivity personImageActivity) {
        this.a = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        bm bmVar;
        ProgressBar progressBar;
        listMenu = this.a.getListMenu();
        if (dialogInterface == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.a.c;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.a.c;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.a.b = new bm(this.a, currentImageUrl, currentImageData);
                            bmVar = this.a.b;
                            bmVar.execute(new String[0]);
                            progressBar = this.a.a;
                            progressBar.setVisibility(0);
                        } else {
                            this.a.showToast(this.a.getString(com.baidu.tieba.a.k.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.f.b("PersonImageActivity click save  error" + e.getMessage());
                        return;
                    }
                case 1:
                    dialogInterface.dismiss();
                    return;
                default:
                    return;
            }
        }
    }
}
