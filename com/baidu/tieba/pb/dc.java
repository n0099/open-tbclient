package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements View.OnTouchListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        EditText editText;
        GridView gridView2;
        EditText editText2;
        Button button;
        gridView = this.a.ad;
        if (gridView.getVisibility() == 0) {
            editText = this.a.t;
            editText.requestFocus();
            gridView2 = this.a.ad;
            gridView2.setVisibility(8);
            SubPbActivity subPbActivity = this.a;
            editText2 = this.a.t;
            com.baidu.tieba.c.ah.b(subPbActivity, editText2);
            button = this.a.y;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
