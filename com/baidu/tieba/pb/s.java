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
public class s implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ImagePbActivity imagePbActivity, Handler handler, Runnable runnable) {
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
        gridView = this.a.p;
        if (gridView.getVisibility() == 0) {
            editText2 = this.a.m;
            editText2.requestFocus();
            gridView2 = this.a.p;
            gridView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText3 = this.a.m;
            com.baidu.tieba.c.ai.b(imagePbActivity, editText3);
            button2 = this.a.o;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        keyboardLayout = this.a.t;
        keyboardLayout.setOnkbdStateListener(null);
        ImagePbActivity imagePbActivity2 = this.a;
        editText = this.a.m;
        com.baidu.tieba.c.ai.a(imagePbActivity2, editText);
        this.b.postDelayed(this.c, 200L);
        button = this.a.o;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
