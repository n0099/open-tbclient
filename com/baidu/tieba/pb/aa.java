package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ImagePbActivity imagePbActivity) {
        this.f1478a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        View view3;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        if (this.f1478a.F != null && this.f1478a.F.length() != 0) {
            this.f1478a.c();
            view2 = this.f1478a.l;
            TextView textView = (TextView) view2.findViewById(R.id.text);
            if (textView != null) {
                alertDialog = this.f1478a.k;
                alertDialog.show();
                textView.setText(String.valueOf(this.f1478a.getString(R.string.title)) + this.f1478a.F);
                alertDialog2 = this.f1478a.k;
                view3 = this.f1478a.l;
                alertDialog2.setContentView(view3);
                alertDialog3 = this.f1478a.k;
                WindowManager.LayoutParams attributes = alertDialog3.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = (this.f1478a.g.getTop() + this.f1478a.g.getHeight()) - 5;
                attributes.width = -1;
                attributes.height = -2;
                attributes.alpha = 1.0f;
                alertDialog4 = this.f1478a.k;
                alertDialog4.getWindow().setAttributes(attributes);
            }
        }
    }
}
