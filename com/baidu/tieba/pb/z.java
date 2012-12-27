package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ImagePbActivity imagePbActivity) {
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
        if (this.a.D == null || this.a.D.length() == 0) {
            return;
        }
        this.a.h();
        view2 = this.a.j;
        TextView textView = (TextView) view2.findViewById(R.id.text);
        if (textView != null) {
            alertDialog = this.a.i;
            alertDialog.show();
            textView.setText(String.valueOf(this.a.getString(R.string.title)) + this.a.D);
            alertDialog2 = this.a.i;
            view3 = this.a.j;
            alertDialog2.setContentView(view3);
            alertDialog3 = this.a.i;
            WindowManager.LayoutParams attributes = alertDialog3.getWindow().getAttributes();
            attributes.gravity = 51;
            attributes.x = 0;
            attributes.y = (this.a.g.getTop() + this.a.g.getHeight()) - 5;
            attributes.width = -1;
            attributes.height = -2;
            attributes.alpha = 1.0f;
            alertDialog4 = this.a.i;
            alertDialog4.getWindow().setAttributes(attributes);
        }
    }
}
