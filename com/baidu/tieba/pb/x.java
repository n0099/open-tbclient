package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ImagePbActivity imagePbActivity) {
        this.f2287a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        View view3;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        if (this.f2287a.E != null && this.f2287a.E.length() != 0) {
            this.f2287a.b();
            view2 = this.f2287a.k;
            TextView textView = (TextView) view2.findViewById(R.id.text);
            if (textView != null) {
                alertDialog = this.f2287a.j;
                alertDialog.show();
                textView.setText(this.f2287a.getString(R.string.title) + this.f2287a.E);
                alertDialog2 = this.f2287a.j;
                view3 = this.f2287a.k;
                alertDialog2.setContentView(view3);
                alertDialog3 = this.f2287a.j;
                WindowManager.LayoutParams attributes = alertDialog3.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = (this.f2287a.h.getTop() + this.f2287a.h.getHeight()) - 5;
                attributes.width = -1;
                attributes.height = -2;
                attributes.alpha = 1.0f;
                alertDialog4 = this.f2287a.j;
                alertDialog4.getWindow().setAttributes(attributes);
            }
        }
    }
}
