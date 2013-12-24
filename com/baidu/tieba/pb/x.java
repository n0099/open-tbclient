package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        View view3;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        if (this.a.E != null && this.a.E.length() != 0) {
            this.a.b();
            view2 = this.a.k;
            TextView textView = (TextView) view2.findViewById(R.id.text);
            if (textView != null) {
                alertDialog = this.a.j;
                alertDialog.show();
                textView.setText(this.a.getString(R.string.title) + this.a.E);
                alertDialog2 = this.a.j;
                view3 = this.a.k;
                alertDialog2.setContentView(view3);
                alertDialog3 = this.a.j;
                WindowManager.LayoutParams attributes = alertDialog3.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = (this.a.h.getTop() + this.a.h.getHeight()) - 5;
                attributes.width = -1;
                attributes.height = -2;
                attributes.alpha = 1.0f;
                alertDialog4 = this.a.j;
                alertDialog4.getWindow().setAttributes(attributes);
            }
        }
    }
}
