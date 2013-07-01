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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NearbyPbActivity nearbyPbActivity) {
        this.f1172a = nearbyPbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        EditText editText;
        GridView gridView2;
        EditText editText2;
        Button button;
        gridView = this.f1172a.g;
        if (gridView.getVisibility() == 0) {
            editText = this.f1172a.f;
            editText.requestFocus();
            gridView2 = this.f1172a.g;
            gridView2.setVisibility(8);
            NearbyPbActivity nearbyPbActivity = this.f1172a;
            editText2 = this.f1172a.f;
            com.baidu.tieba.util.ab.b(nearbyPbActivity, editText2);
            button = this.f1172a.e;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
