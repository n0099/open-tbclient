package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(SubPbActivity subPbActivity, Handler handler, Runnable runnable) {
        this.a = subPbActivity;
        this.b = handler;
        this.c = runnable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Cdo cdo;
        int i;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        GridView gridView;
        EditText editText5;
        Button button;
        GridView gridView2;
        this.a.x = Integer.valueOf((String) view.getTag()).intValue();
        cdo = this.a.h;
        i = this.a.x;
        editText = this.a.p;
        editText.setText(this.a.getString(R.string.reply_sub_floor, new Object[]{((com.baidu.tieba.a.an) cdo.getItem(i)).e().b()}));
        editText2 = this.a.p;
        editText3 = this.a.p;
        editText2.setSelection(editText3.getText().length());
        editText4 = this.a.p;
        editText4.requestFocus();
        gridView = this.a.Y;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.a.Y;
            gridView2.setVisibility(8);
        }
        SubPbActivity subPbActivity = this.a;
        editText5 = this.a.p;
        com.baidu.tieba.c.ai.b(subPbActivity, editText5);
        button = this.a.u;
        button.setBackgroundResource(R.drawable.sub_pb_face);
        this.b.postDelayed(this.c, 600L);
    }
}
