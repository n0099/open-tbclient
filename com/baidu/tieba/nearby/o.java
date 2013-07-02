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
        gridView = this.a.g;
        if (gridView.getVisibility() == 0) {
            editText = this.a.f;
            editText.requestFocus();
            gridView2 = this.a.g;
            gridView2.setVisibility(8);
            NearbyPbActivity nearbyPbActivity = this.a;
            editText2 = this.a.f;
            com.baidu.tieba.util.ab.b(nearbyPbActivity, editText2);
            button = this.a.e;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
