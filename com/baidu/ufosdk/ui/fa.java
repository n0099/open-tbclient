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
/* loaded from: classes5.dex */
public final class fa extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public Context f22949a;

    /* renamed from: b  reason: collision with root package name */
    public View f22950b;

    public fa(Context context, int i) {
        super(context, i);
        this.f22949a = context;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.dialog_animation);
        View inflate = View.inflate(this.f22949a, R.layout.ufo_show_evaluate_dialog, null);
        this.f22950b = inflate;
        inflate.findViewById(R.id.btn_dialog_close).setOnClickListener(new fb(this));
        this.f22950b.findViewById(R.id.header_transparent).setOnClickListener(new fc(this));
        window.setContentView(this.f22950b);
        window.setLayout(-1, -2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            this.f22950b.findViewById(R.id.ll_checkboxs).setVisibility(8);
        } else {
            this.f22950b.findViewById(R.id.ll_checkboxs).setVisibility(0);
            int length = jSONArray.length();
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            if (length == 5) {
                                this.f22950b.findViewById(R.id.ll_checkboxs_3).setVisibility(0);
                                CheckBox checkBox = (CheckBox) this.f22950b.findViewById(R.id.cb_31);
                                checkBox.setVisibility(0);
                                checkBox.setText(jSONArray.optString(4));
                            }
                            if (jSONArray.length() == 4) {
                                this.f22950b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                            }
                            if (jSONArray.length() == 3) {
                                this.f22950b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                                ((CheckBox) this.f22950b.findViewById(R.id.cb_22)).setVisibility(4);
                            }
                            if (jSONArray.length() == 2) {
                                this.f22950b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                                this.f22950b.findViewById(R.id.ll_checkboxs_2).setVisibility(8);
                            }
                            if (jSONArray.length() == 1) {
                                this.f22950b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                                this.f22950b.findViewById(R.id.ll_checkboxs_2).setVisibility(8);
                                ((CheckBox) this.f22950b.findViewById(R.id.cb_12)).setVisibility(4);
                            }
                        }
                        this.f22950b.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                        CheckBox checkBox2 = (CheckBox) this.f22950b.findViewById(R.id.cb_22);
                        checkBox2.setVisibility(0);
                        checkBox2.setText(jSONArray.optString(3));
                    }
                    this.f22950b.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                    CheckBox checkBox3 = (CheckBox) this.f22950b.findViewById(R.id.cb_21);
                    checkBox3.setVisibility(0);
                    checkBox3.setText(jSONArray.optString(2));
                }
                this.f22950b.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                CheckBox checkBox4 = (CheckBox) this.f22950b.findViewById(R.id.cb_12);
                checkBox4.setVisibility(0);
                checkBox4.setText(jSONArray.optString(1));
            }
            this.f22950b.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
            CheckBox checkBox5 = (CheckBox) this.f22950b.findViewById(R.id.cb_11);
            checkBox5.setVisibility(0);
            checkBox5.setText(jSONArray.optString(0));
            if (jSONArray.length() == 4) {
            }
            if (jSONArray.length() == 3) {
            }
            if (jSONArray.length() == 2) {
            }
            if (jSONArray.length() == 1) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.f22950b.findViewById(R.id.rl_show).setVisibility(8);
            return;
        }
        this.f22950b.findViewById(R.id.rl_show).setVisibility(0);
        ((TextView) this.f22950b.findViewById(R.id.tv_show_reason)).setText(str);
    }
}
