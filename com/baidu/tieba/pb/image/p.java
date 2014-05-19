package com.baidu.tieba.pb.image;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        View view2;
        AlertDialog alertDialog;
        String str3;
        AlertDialog alertDialog2;
        View view3;
        TextView textView;
        TextView textView2;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        str = this.a.D;
        if (str != null) {
            str2 = this.a.D;
            if (str2.length() != 0) {
                this.a.c();
                view2 = this.a.j;
                TextView textView3 = (TextView) view2.findViewById(com.baidu.tieba.r.text);
                if (textView3 != null) {
                    alertDialog = this.a.i;
                    alertDialog.show();
                    StringBuilder sb = new StringBuilder(String.valueOf(this.a.getString(com.baidu.tieba.u.title)));
                    str3 = this.a.D;
                    textView3.setText(sb.append(str3).toString());
                    alertDialog2 = this.a.i;
                    view3 = this.a.j;
                    alertDialog2.setContentView(view3);
                    textView = this.a.g;
                    int top = textView.getTop();
                    textView2 = this.a.g;
                    alertDialog3 = this.a.i;
                    WindowManager.LayoutParams attributes = alertDialog3.getWindow().getAttributes();
                    attributes.gravity = 51;
                    attributes.x = 0;
                    attributes.y = (top + textView2.getHeight()) - 5;
                    attributes.width = -1;
                    attributes.height = -2;
                    attributes.alpha = 1.0f;
                    alertDialog4 = this.a.i;
                    alertDialog4.getWindow().setAttributes(attributes);
                }
            }
        }
    }
}
