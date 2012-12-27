package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements View.OnTouchListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ GridView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(SubPbActivity subPbActivity, GridView gridView) {
        this.a = subPbActivity;
        this.b = gridView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        EditText editText2;
        Button button;
        if (this.b.getVisibility() == 0) {
            editText = this.a.s;
            editText.requestFocus();
            this.b.setVisibility(8);
            SubPbActivity subPbActivity = this.a;
            editText2 = this.a.s;
            com.baidu.tieba.c.ag.b(subPbActivity, editText2);
            button = this.a.x;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
