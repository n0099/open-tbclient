package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.KeyboardLayout;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f2142a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ ImagePbActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImagePbActivity imagePbActivity, Handler handler, Runnable runnable) {
        this.c = imagePbActivity;
        this.f2142a = handler;
        this.b = runnable;
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
        gridView = this.c.p;
        if (gridView.getVisibility() == 0) {
            editText2 = this.c.m;
            editText2.requestFocus();
            gridView2 = this.c.p;
            gridView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.c;
            editText3 = this.c.m;
            UtilHelper.b(imagePbActivity, editText3);
            button2 = this.c.o;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        keyboardLayout = this.c.t;
        keyboardLayout.setOnkbdStateListener(null);
        ImagePbActivity imagePbActivity2 = this.c;
        editText = this.c.m;
        UtilHelper.a(imagePbActivity2, editText);
        this.f2142a.postDelayed(this.b, 200L);
        button = this.c.o;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
