package com.baidu.tieba.nearby;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnTouchListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        EditText editText;
        GridView gridView2;
        EditText editText2;
        Button button;
        gridView = this.a.i;
        if (gridView.getVisibility() == 0) {
            editText = this.a.h;
            editText.requestFocus();
            gridView2 = this.a.i;
            gridView2.setVisibility(8);
            NearbyPbActivity nearbyPbActivity = this.a;
            editText2 = this.a.h;
            com.baidu.tieba.d.ag.b(nearbyPbActivity, editText2);
            button = this.a.g;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
