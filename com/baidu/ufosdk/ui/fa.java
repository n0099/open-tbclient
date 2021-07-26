package com.baidu.ufosdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.R;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class fa extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f23813a;

    /* renamed from: b  reason: collision with root package name */
    public View f23814b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23813a = context;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.dialog_animation);
        View inflate = View.inflate(this.f23813a, R.layout.ufo_show_evaluate_dialog, null);
        this.f23814b = inflate;
        inflate.findViewById(R.id.btn_dialog_close).setOnClickListener(new fb(this));
        this.f23814b.findViewById(R.id.header_transparent).setOnClickListener(new fc(this));
        window.setContentView(this.f23814b);
        window.setLayout(-1, -2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONArray, str) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                this.f23814b.findViewById(R.id.ll_checkboxs).setVisibility(8);
            } else {
                this.f23814b.findViewById(R.id.ll_checkboxs).setVisibility(0);
                int length = jSONArray.length();
                if (length != 1) {
                    if (length != 2) {
                        if (length != 3) {
                            if (length != 4) {
                                if (length == 5) {
                                    this.f23814b.findViewById(R.id.ll_checkboxs_3).setVisibility(0);
                                    CheckBox checkBox = (CheckBox) this.f23814b.findViewById(R.id.cb_31);
                                    checkBox.setVisibility(0);
                                    checkBox.setText(jSONArray.optString(4));
                                }
                                if (jSONArray.length() == 4) {
                                    this.f23814b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                                }
                                if (jSONArray.length() == 3) {
                                    this.f23814b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                                    ((CheckBox) this.f23814b.findViewById(R.id.cb_22)).setVisibility(4);
                                }
                                if (jSONArray.length() == 2) {
                                    this.f23814b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                                    this.f23814b.findViewById(R.id.ll_checkboxs_2).setVisibility(8);
                                }
                                if (jSONArray.length() == 1) {
                                    this.f23814b.findViewById(R.id.ll_checkboxs_3).setVisibility(8);
                                    this.f23814b.findViewById(R.id.ll_checkboxs_2).setVisibility(8);
                                    ((CheckBox) this.f23814b.findViewById(R.id.cb_12)).setVisibility(4);
                                }
                            }
                            this.f23814b.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                            CheckBox checkBox2 = (CheckBox) this.f23814b.findViewById(R.id.cb_22);
                            checkBox2.setVisibility(0);
                            checkBox2.setText(jSONArray.optString(3));
                        }
                        this.f23814b.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                        CheckBox checkBox3 = (CheckBox) this.f23814b.findViewById(R.id.cb_21);
                        checkBox3.setVisibility(0);
                        checkBox3.setText(jSONArray.optString(2));
                    }
                    this.f23814b.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                    CheckBox checkBox4 = (CheckBox) this.f23814b.findViewById(R.id.cb_12);
                    checkBox4.setVisibility(0);
                    checkBox4.setText(jSONArray.optString(1));
                }
                this.f23814b.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                CheckBox checkBox5 = (CheckBox) this.f23814b.findViewById(R.id.cb_11);
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
                this.f23814b.findViewById(R.id.rl_show).setVisibility(8);
                return;
            }
            this.f23814b.findViewById(R.id.rl_show).setVisibility(0);
            ((TextView) this.f23814b.findViewById(R.id.tv_show_reason)).setText(str);
        }
    }
}
