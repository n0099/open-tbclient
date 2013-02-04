package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ GridView b;
    private final /* synthetic */ Handler c;
    private final /* synthetic */ Runnable d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(SubPbActivity subPbActivity, GridView gridView, Handler handler, Runnable runnable) {
        this.a = subPbActivity;
        this.b = gridView;
        this.c = handler;
        this.d = runnable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        df dfVar;
        int i;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        Button button;
        this.a.A = Integer.valueOf((String) view.getTag()).intValue();
        dfVar = this.a.g;
        i = this.a.A;
        editText = this.a.s;
        editText.setText(this.a.getString(R.string.reply_sub_floor, new Object[]{((com.baidu.tieba.a.am) dfVar.getItem(i)).d().b()}));
        editText2 = this.a.s;
        editText3 = this.a.s;
        editText2.setSelection(editText3.getText().length());
        editText4 = this.a.s;
        editText4.requestFocus();
        if (this.b.getVisibility() == 0) {
            this.b.setVisibility(8);
        }
        SubPbActivity subPbActivity = this.a;
        editText5 = this.a.s;
        com.baidu.tieba.c.ag.b(subPbActivity, editText5);
        button = this.a.x;
        button.setBackgroundResource(R.drawable.sub_pb_face);
        this.c.postDelayed(this.d, 600L);
    }
}
