package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        com.baidu.tieba.b.n nVar;
        View view2;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        Dialog dialog2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        Dialog dialog3;
        Dialog dialog4;
        Dialog dialog5;
        View view3;
        Dialog dialog6;
        Dialog dialog7;
        View view4;
        EditText editText4;
        View view5;
        View view6;
        dialog = this.a.x;
        if (dialog == null) {
            this.a.x = new Dialog(this.a, R.style.common_alert_dialog);
            dialog3 = this.a.x;
            dialog3.setCanceledOnTouchOutside(true);
            dialog4 = this.a.x;
            dialog4.setCancelable(true);
            this.a.z = this.a.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            dialog5 = this.a.x;
            view3 = this.a.z;
            dialog5.setContentView(view3);
            dialog6 = this.a.x;
            WindowManager.LayoutParams attributes = dialog6.getWindow().getAttributes();
            attributes.gravity = 49;
            attributes.y = com.baidu.tieba.c.ag.a((Context) this.a, 54.0f);
            attributes.width = (int) (com.baidu.tieba.c.ag.a((Context) this.a) * 0.9d);
            dialog7 = this.a.x;
            dialog7.getWindow().setAttributes(attributes);
            PbActivity pbActivity = this.a;
            view4 = this.a.z;
            pbActivity.j = (EditText) view4.findViewById(R.id.input_page_number);
            editText4 = this.a.j;
            editText4.setOnFocusChangeListener(new bj(this));
            view5 = this.a.z;
            view6 = this.a.z;
            ((Button) view5.findViewById(R.id.dialog_button_ok)).setOnClickListener(new bk(this));
            ((Button) view6.findViewById(R.id.dialog_button_cancel)).setOnClickListener(new bl(this));
        }
        nVar = this.a.n;
        if (nVar.a() != null) {
            view2 = this.a.z;
            TextView textView = (TextView) view2.findViewById(R.id.current_page_number);
            nVar2 = this.a.n;
            int b = nVar2.a().d().b();
            nVar3 = this.a.n;
            int a = nVar3.a().d().a();
            if (b <= 0) {
                b = 1;
            }
            if (a <= 0) {
                a = 1;
            }
            textView.setText(MessageFormat.format(this.a.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(b), Integer.valueOf(a)));
            dialog2 = this.a.x;
            dialog2.show();
            editText = this.a.j;
            editText.setText("");
            editText2 = this.a.j;
            editText2.requestFocus();
            PbActivity pbActivity2 = this.a;
            editText3 = this.a.j;
            pbActivity2.a(editText3, 150);
        }
    }
}
