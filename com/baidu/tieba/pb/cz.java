package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ GridView b;
    private final /* synthetic */ Handler c;
    private final /* synthetic */ Runnable d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(SubPbActivity subPbActivity, GridView gridView, Handler handler, Runnable runnable) {
        this.a = subPbActivity;
        this.b = gridView;
        this.c = handler;
        this.d = runnable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        Button button;
        EditText editText2;
        EditText editText3;
        Button button2;
        if (this.b.getVisibility() != 0) {
            SubPbActivity subPbActivity = this.a;
            editText = this.a.s;
            com.baidu.tieba.c.ag.a(subPbActivity, editText);
            this.c.postDelayed(this.d, 200L);
            button = this.a.x;
            button.setBackgroundResource(R.drawable.sub_pb_keyboard);
            return;
        }
        editText2 = this.a.s;
        editText2.requestFocus();
        this.b.setVisibility(8);
        SubPbActivity subPbActivity2 = this.a;
        editText3 = this.a.s;
        com.baidu.tieba.c.ag.b(subPbActivity2, editText3);
        button2 = this.a.x;
        button2.setBackgroundResource(R.drawable.sub_pb_face);
    }
}
