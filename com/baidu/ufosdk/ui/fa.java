package com.baidu.ufosdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.ufosdk.R;
import org.json.JSONArray;
/* loaded from: classes21.dex */
public final class fa extends Dialog {
    private Context a;
    private View b;

    public fa(Context context, int i) {
        super(context, i);
        this.a = context;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.dialog_animation);
        this.b = View.inflate(this.a, R.layout.ufo_show_evaluate_dialog, null);
        this.b.findViewById(R.id.btn_dialog_close).setOnClickListener(new fb(this));
        this.b.findViewById(R.id.header_transparent).setOnClickListener(new fc(this));
        window.setContentView(this.b);
        window.setLayout(-1, -2);
    }

    public final void a(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            this.b.findViewById(R.id.ll_checkboxs).setVisibility(8);
        } else {
            this.b.findViewById(R.id.ll_checkboxs).setVisibility(0);
            switch (jSONArray.length()) {
                case 5:
                    this.b.findViewById(R.id.ll_checkboxs_3).setVisibility(0);
                    CheckBox checkBox = (CheckBox) this.b.findViewById(R.id.cb_31);
                    checkBox.setVisibility(0);
                    checkBox.setText(jSONArray.optString(4));
                case 4:
                    this.b.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                    CheckBox checkBox2 = (CheckBox) this.b.findViewById(R.id.cb_22);
                    checkBox2.setVisibility(0);
                    checkBox2.setText(jSONArray.optString(3));
                case 3:
                    this.b.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                    CheckBox checkBox3 = (CheckBox) this.b.findViewById(R.id.cb_21);
                    checkBox3.setVisibility(0);
                    checkBox3.setText(jSONArray.optString(2));
                case 2:
                    this.b.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                    CheckBox checkBox4 = (CheckBox) this.b.findViewById(R.id.cb_12);
                    checkBox4.setVisibility(0);
                    checkBox4.setText(jSONArray.optString(1));
                case 1:
                    this.b.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                    CheckBox checkBox5 = (CheckBox) this.b.findViewById(R.id.cb_11);
                    checkBox5.setVisibility(0);
                    checkBox5.setText(jSONArray.optString(0));
                    break;
            }
            if (jSONArray.length() == 4) {
                this.b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
            }
            if (jSONArray.length() == 3) {
                this.b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                ((CheckBox) this.b.findViewById(R.id.cb_22)).setVisibility(4);
            }
            if (jSONArray.length() == 2) {
                this.b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                this.b.findViewById(R.id.ll_checkboxs_2).setVisibility(8);
            }
            if (jSONArray.length() == 1) {
                this.b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                this.b.findViewById(R.id.ll_checkboxs_2).setVisibility(8);
                ((CheckBox) this.b.findViewById(R.id.cb_12)).setVisibility(4);
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.b.findViewById(R.id.rl_show).setVisibility(8);
            return;
        }
        this.b.findViewById(R.id.rl_show).setVisibility(0);
        ((TextView) this.b.findViewById(R.id.tv_show_reason)).setText(str);
    }
}
