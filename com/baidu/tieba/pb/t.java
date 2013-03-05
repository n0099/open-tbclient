package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        EditText editText;
        GridView gridView2;
        EditText editText2;
        Button button;
        gridView = this.a.p;
        if (gridView.getVisibility() == 0) {
            editText = this.a.m;
            editText.requestFocus();
            gridView2 = this.a.p;
            gridView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText2 = this.a.m;
            com.baidu.tieba.c.ai.b(imagePbActivity, editText2);
            button = this.a.o;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
