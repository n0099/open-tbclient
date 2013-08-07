package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.view.KeyboardLayout;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1538a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ImagePbActivity imagePbActivity, Handler handler, Runnable runnable) {
        this.f1538a = imagePbActivity;
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
        gridView = this.f1538a.p;
        if (gridView.getVisibility() == 0) {
            editText2 = this.f1538a.m;
            editText2.requestFocus();
            gridView2 = this.f1538a.p;
            gridView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.f1538a;
            editText3 = this.f1538a.m;
            com.baidu.tieba.util.am.b(imagePbActivity, editText3);
            button2 = this.f1538a.o;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        keyboardLayout = this.f1538a.t;
        keyboardLayout.setOnkbdStateListener(null);
        ImagePbActivity imagePbActivity2 = this.f1538a;
        editText = this.f1538a.m;
        com.baidu.tieba.util.am.a(imagePbActivity2, editText);
        this.b.postDelayed(this.c, 200L);
        button = this.f1538a.o;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
