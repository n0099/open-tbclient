package com.baidu.tieba.nearby;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        EditText editText;
        GridView gridView2;
        EditText editText2;
        Button button;
        gridView = this.a.j;
        if (gridView.getVisibility() == 0) {
            editText = this.a.i;
            editText.requestFocus();
            gridView2 = this.a.j;
            gridView2.setVisibility(8);
            NearbyPbActivity nearbyPbActivity = this.a;
            editText2 = this.a.i;
            com.baidu.tieba.c.ai.b(nearbyPbActivity, editText2);
            button = this.a.h;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
