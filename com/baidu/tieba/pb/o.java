package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity, Handler handler, Runnable runnable) {
        this.a = imagePbActivity;
        this.b = handler;
        this.c = runnable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        KeyboardLayout keyboardLayout;
        EditText editText;
        Button button;
        EditText editText2;
        GridView gridView2;
        EditText editText3;
        Button button2;
        gridView = this.a.n;
        if (gridView.getVisibility() != 0) {
            keyboardLayout = this.a.r;
            keyboardLayout.setOnkbdStateListener(null);
            ImagePbActivity imagePbActivity = this.a;
            editText = this.a.k;
            com.baidu.tieba.c.ag.a(imagePbActivity, editText);
            this.b.postDelayed(this.c, 200L);
            button = this.a.m;
            button.setBackgroundResource(R.drawable.sub_pb_keyboard);
            return;
        }
        editText2 = this.a.k;
        editText2.requestFocus();
        gridView2 = this.a.n;
        gridView2.setVisibility(8);
        ImagePbActivity imagePbActivity2 = this.a;
        editText3 = this.a.k;
        com.baidu.tieba.c.ag.b(imagePbActivity2, editText3);
        button2 = this.a.m;
        button2.setBackgroundResource(R.drawable.sub_pb_face);
    }
}
