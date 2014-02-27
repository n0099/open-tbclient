package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class z implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
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
        str = this.a.E;
        if (str != null) {
            str2 = this.a.E;
            if (str2.length() != 0) {
                ImagePbActivity.w(this.a);
                view2 = this.a.k;
                TextView textView3 = (TextView) view2.findViewById(R.id.text);
                if (textView3 != null) {
                    alertDialog = this.a.j;
                    alertDialog.show();
                    StringBuilder sb = new StringBuilder(String.valueOf(this.a.getString(R.string.title)));
                    str3 = this.a.E;
                    textView3.setText(sb.append(str3).toString());
                    alertDialog2 = this.a.j;
                    view3 = this.a.k;
                    alertDialog2.setContentView(view3);
                    textView = this.a.h;
                    int top = textView.getTop();
                    textView2 = this.a.h;
                    alertDialog3 = this.a.j;
                    WindowManager.LayoutParams attributes = alertDialog3.getWindow().getAttributes();
                    attributes.gravity = 51;
                    attributes.x = 0;
                    attributes.y = (top + textView2.getHeight()) - 5;
                    attributes.width = -1;
                    attributes.height = -2;
                    attributes.alpha = 1.0f;
                    alertDialog4 = this.a.j;
                    alertDialog4.getWindow().setAttributes(attributes);
                }
            }
        }
    }
}
