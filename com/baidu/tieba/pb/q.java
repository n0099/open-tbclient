package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        EditText editText;
        GridView gridView2;
        EditText editText2;
        Button button;
        EditText editText3;
        gridView = this.a.p;
        if (gridView.getVisibility() == 0) {
            editText = this.a.m;
            editText.requestFocus();
            gridView2 = this.a.p;
            gridView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText2 = this.a.m;
            com.baidu.tieba.util.aa.b(imagePbActivity, editText2);
            button = this.a.o;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            editText3 = this.a.m;
            com.mofamulu.tieba.tail.aq.a(editText3);
            return true;
        }
        return false;
    }
}
