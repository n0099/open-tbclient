package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ImagePbActivity imagePbActivity) {
        this.f2153a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        View view3;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        if (this.f2153a.F != null && this.f2153a.F.length() != 0) {
            this.f2153a.c();
            view2 = this.f2153a.l;
            TextView textView = (TextView) view2.findViewById(R.id.text);
            if (textView != null) {
                alertDialog = this.f2153a.k;
                alertDialog.show();
                textView.setText(this.f2153a.getString(R.string.title) + this.f2153a.F);
                alertDialog2 = this.f2153a.k;
                view3 = this.f2153a.l;
                alertDialog2.setContentView(view3);
                alertDialog3 = this.f2153a.k;
                WindowManager.LayoutParams attributes = alertDialog3.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = (this.f2153a.g.getTop() + this.f2153a.g.getHeight()) - 5;
                attributes.width = -1;
                attributes.height = -2;
                attributes.alpha = 1.0f;
                alertDialog4 = this.f2153a.k;
                alertDialog4.getWindow().setAttributes(attributes);
            }
        }
    }
}
