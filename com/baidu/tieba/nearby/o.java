package com.baidu.tieba.nearby;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ NearbyPbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NearbyPbActivity nearbyPbActivity, Handler handler, Runnable runnable) {
        this.a = nearbyPbActivity;
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
        gridView = this.a.j;
        if (gridView.getVisibility() == 0) {
            editText2 = this.a.i;
            editText2.requestFocus();
            gridView2 = this.a.j;
            gridView2.setVisibility(8);
            NearbyPbActivity nearbyPbActivity = this.a;
            editText3 = this.a.i;
            com.baidu.tieba.c.ai.b(nearbyPbActivity, editText3);
            button2 = this.a.h;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        NearbyPbActivity nearbyPbActivity2 = this.a;
        editText = this.a.i;
        com.baidu.tieba.c.ai.a(nearbyPbActivity2, editText);
        this.b.postDelayed(this.c, 200L);
        button = this.a.h;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
