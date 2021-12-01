package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public final class ae implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackEditActivity a;

    /* renamed from: b  reason: collision with root package name */
    public int f51641b;

    /* renamed from: c  reason: collision with root package name */
    public long f51642c;

    public ae(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackEditActivity;
        this.f51642c = 0L;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        EditText editText;
        EditText editText2;
        TextView textView;
        EditText editText3;
        EditText editText4;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        EditText editText5;
        Button button;
        List list;
        List list2;
        Button button2;
        List list3;
        List list4;
        Button button3;
        List list5;
        Button button4;
        Button button5;
        EditText editText6;
        List list6;
        List list7;
        Button button6;
        List list8;
        List list9;
        Button button7;
        List list10;
        Button button8;
        TextView textView5;
        TextView textView6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            z = this.a.x;
            if (!z) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.a);
                dVar.b(dVar.b() + 1);
                this.a.x = true;
            }
            editText = this.a.m;
            int length = editText.getText().toString().length();
            int i2 = com.baidu.ufosdk.b.aa;
            int i3 = 0;
            if (length < i2 - 10) {
                textView5 = this.a.o;
                textView5.setTextColor(-5131855);
                textView6 = this.a.o;
                textView6.setText("4-" + com.baidu.ufosdk.b.aa + com.baidu.ufosdk.f.s.a("27"));
            } else if (length < i2 - 10 || length > i2) {
                editText2 = this.a.m;
                String substring = editText2.getText().toString().substring(0, com.baidu.ufosdk.b.aa);
                textView = this.a.o;
                textView.setTextColor(-1551537);
                editText3 = this.a.m;
                editText3.setText(substring);
                editText4 = this.a.m;
                FeedbackEditActivity.b(editText4, substring.length());
                textView2 = this.a.o;
                textView2.setText("0" + com.baidu.ufosdk.f.s.a("27"));
                if (System.currentTimeMillis() - this.f51642c > 3000) {
                    Toast.makeText(this.a, com.baidu.ufosdk.f.s.a("16"), 0).show();
                    this.f51642c = System.currentTimeMillis();
                }
            } else {
                textView3 = this.a.o;
                textView3.setTextColor(-5131855);
                textView4 = this.a.o;
                textView4.setText(String.valueOf(com.baidu.ufosdk.b.aa - editable.length()) + com.baidu.ufosdk.f.s.a("27"));
            }
            int i4 = this.f51641b;
            if (i4 == 0) {
                editText5 = this.a.m;
                if (editText5.getText().toString().length() < 4) {
                    button = this.a.V;
                    button.setTextColor(com.baidu.ufosdk.b.y);
                    return;
                }
                while (true) {
                    list = this.a.z;
                    if (i3 >= list.size()) {
                        break;
                    }
                    list3 = this.a.z;
                    if (list3.get(i3) != null) {
                        list5 = this.a.z;
                        if (((TextView) list5.get(i3)).getText().toString().length() == 0) {
                            button4 = this.a.V;
                            button4.setTextColor(com.baidu.ufosdk.b.y);
                            break;
                        }
                    }
                    list4 = this.a.z;
                    if (i3 == list4.size() - 1) {
                        button3 = this.a.V;
                        int i5 = com.baidu.ufosdk.b.v;
                        int i6 = com.baidu.ufosdk.b.y;
                        int i7 = com.baidu.ufosdk.b.v;
                        button3.setTextColor(com.baidu.ufosdk.f.i.a(i5, i6, i7, i7));
                    }
                    i3++;
                }
                list2 = this.a.z;
                if (list2.size() == 0) {
                    button2 = this.a.V;
                    int i8 = com.baidu.ufosdk.b.v;
                    int i9 = com.baidu.ufosdk.b.y;
                    int i10 = com.baidu.ufosdk.b.v;
                    button2.setTextColor(com.baidu.ufosdk.f.i.a(i8, i9, i10, i10));
                    return;
                }
                return;
            }
            if (i4 == 1) {
                editText6 = this.a.m;
                if (editText6.getText().toString().length() >= 4) {
                    while (true) {
                        list6 = this.a.z;
                        if (i3 >= list6.size()) {
                            break;
                        }
                        list8 = this.a.z;
                        if (list8.get(i3) != null) {
                            list10 = this.a.z;
                            if (((TextView) list10.get(i3)).getText().toString().length() == 0) {
                                button8 = this.a.V;
                                button8.setTextColor(com.baidu.ufosdk.b.y);
                                break;
                            }
                        }
                        list9 = this.a.z;
                        if (i3 == list9.size() - 1) {
                            button7 = this.a.V;
                            int i11 = com.baidu.ufosdk.b.v;
                            int i12 = com.baidu.ufosdk.b.y;
                            int i13 = com.baidu.ufosdk.b.v;
                            button7.setTextColor(com.baidu.ufosdk.f.i.a(i11, i12, i13, i13));
                        }
                        i3++;
                    }
                    list7 = this.a.z;
                    if (list7.size() == 0) {
                        button6 = this.a.V;
                        int i14 = com.baidu.ufosdk.b.v;
                        int i15 = com.baidu.ufosdk.b.y;
                        int i16 = com.baidu.ufosdk.b.v;
                        button6.setTextColor(com.baidu.ufosdk.f.i.a(i14, i15, i16, i16));
                        return;
                    }
                    return;
                }
            }
            button5 = this.a.V;
            button5.setTextColor(com.baidu.ufosdk.b.y);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            editText = this.a.m;
            this.f51641b = editText.getText().toString().length() < 4 ? 0 : 1;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
        }
    }
}
