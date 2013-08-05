package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImagePbActivity imagePbActivity) {
        this.f1541a = imagePbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        EditText editText;
        GridView gridView2;
        EditText editText2;
        Button button;
        gridView = this.f1541a.p;
        if (gridView.getVisibility() == 0) {
            editText = this.f1541a.m;
            editText.requestFocus();
            gridView2 = this.f1541a.p;
            gridView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.f1541a;
            editText2 = this.f1541a.m;
            com.baidu.tieba.util.am.b(imagePbActivity, editText2);
            button = this.f1541a.o;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
