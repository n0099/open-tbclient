package com.baidu.tieba.nearby;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1171a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NearbyPbActivity nearbyPbActivity, Handler handler, Runnable runnable) {
        this.f1171a = nearbyPbActivity;
        this.b = handler;
        this.c = runnable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        EditText editText;
        Button button;
        EditText editText2;
        GridView gridView2;
        EditText editText3;
        Button button2;
        gridView = this.f1171a.g;
        if (gridView.getVisibility() == 0) {
            editText2 = this.f1171a.f;
            editText2.requestFocus();
            gridView2 = this.f1171a.g;
            gridView2.setVisibility(8);
            NearbyPbActivity nearbyPbActivity = this.f1171a;
            editText3 = this.f1171a.f;
            com.baidu.tieba.util.ab.b(nearbyPbActivity, editText3);
            button2 = this.f1171a.e;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        NearbyPbActivity nearbyPbActivity2 = this.f1171a;
        editText = this.f1171a.f;
        com.baidu.tieba.util.ab.a(nearbyPbActivity2, editText);
        this.b.postDelayed(this.c, 200L);
        button = this.f1171a.e;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
