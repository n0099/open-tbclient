package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(SubPbActivity subPbActivity, Handler handler, Runnable runnable) {
        this.a = subPbActivity;
        this.b = handler;
        this.c = runnable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dh dhVar;
        int i;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        GridView gridView;
        EditText editText5;
        Button button;
        GridView gridView2;
        this.a.B = Integer.valueOf((String) view.getTag()).intValue();
        dhVar = this.a.h;
        i = this.a.B;
        editText = this.a.t;
        editText.setText(this.a.getString(R.string.reply_sub_floor, new Object[]{((com.baidu.tieba.a.an) dhVar.getItem(i)).d().b()}));
        editText2 = this.a.t;
        editText3 = this.a.t;
        editText2.setSelection(editText3.getText().length());
        editText4 = this.a.t;
        editText4.requestFocus();
        gridView = this.a.ad;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.a.ad;
            gridView2.setVisibility(8);
        }
        SubPbActivity subPbActivity = this.a;
        editText5 = this.a.t;
        com.baidu.tieba.c.ah.b(subPbActivity, editText5);
        button = this.a.y;
        button.setBackgroundResource(R.drawable.sub_pb_face);
        this.b.postDelayed(this.c, 600L);
    }
}
