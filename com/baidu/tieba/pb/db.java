package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(SubPbActivity subPbActivity, Handler handler, Runnable runnable) {
        this.a = subPbActivity;
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
        gridView = this.a.ad;
        if (gridView.getVisibility() == 0) {
            editText2 = this.a.t;
            editText2.requestFocus();
            gridView2 = this.a.ad;
            gridView2.setVisibility(8);
            SubPbActivity subPbActivity = this.a;
            editText3 = this.a.t;
            com.baidu.tieba.c.ah.b(subPbActivity, editText3);
            button2 = this.a.y;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        SubPbActivity subPbActivity2 = this.a;
        editText = this.a.t;
        com.baidu.tieba.c.ah.a(subPbActivity2, editText);
        this.b.postDelayed(this.c, 200L);
        button = this.a.y;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
