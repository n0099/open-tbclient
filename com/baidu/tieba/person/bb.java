package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonImageActivity f2328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PersonImageActivity personImageActivity) {
        this.f2328a = personImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        bd bdVar;
        ProgressBar progressBar;
        listMenu = this.f2328a.getListMenu();
        if (dialogInterface == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.f2328a.c;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.f2328a.c;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.f2328a.b = new bd(this.f2328a, currentImageUrl, currentImageData);
                            bdVar = this.f2328a.b;
                            bdVar.execute(new String[0]);
                            progressBar = this.f2328a.f2296a;
                            progressBar.setVisibility(0);
                        } else {
                            this.f2328a.showToast(this.f2328a.getString(R.string.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        com.baidu.adp.lib.h.e.a("PersonImageActivity click save  error" + e.getMessage());
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
