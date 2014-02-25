package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(PersonImageActivity personImageActivity) {
        this.a = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        cl clVar;
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
                            this.a.b = new cl(this.a, currentImageUrl, currentImageData);
                            clVar = this.a.b;
                            clVar.execute(new String[0]);
                            progressBar = this.a.a;
                            progressBar.setVisibility(0);
                        } else {
                            this.a.showToast(this.a.getString(R.string.no_data));
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
