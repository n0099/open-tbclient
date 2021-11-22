package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class aa implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f57713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f57714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f57715c;

    public aa(FeedbackEditActivity feedbackEditActivity, EditText editText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity, editText, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57715c = feedbackEditActivity;
        this.f57713a = editText;
        this.f57714b = str;
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x0049 */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void afterTextChanged(Editable editable) {
        String str;
        String str2;
        Button button;
        String str3;
        List list;
        List list2;
        List list3;
        EditText editText;
        Button button2;
        List list4;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            this.f57715c.ad = this.f57713a.getText().toString();
            unused = this.f57715c.ad;
            FeedbackEditActivity feedbackEditActivity = this.f57715c;
            Map map = feedbackEditActivity.f57651a;
            String str4 = this.f57714b;
            str = feedbackEditActivity.ad;
            map.put(str4, str);
            str2 = this.f57715c.ad;
            if (str2 != null) {
                str3 = this.f57715c.ad;
                if (str3.trim().length() != 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        list2 = this.f57715c.z;
                        if (list2.get(i2) != null) {
                            list4 = this.f57715c.z;
                            if (((TextView) list4.get(i2)).getText().toString().trim().length() == 0) {
                            }
                        }
                        list3 = this.f57715c.z;
                        if (i2 == list3.size() - 1) {
                            editText = this.f57715c.m;
                            if (editText.getText().toString().trim().length() >= 4) {
                                button2 = this.f57715c.V;
                                int i3 = com.baidu.ufosdk.b.v;
                                int i4 = com.baidu.ufosdk.b.y;
                                int i5 = com.baidu.ufosdk.b.v;
                                button2.setTextColor(com.baidu.ufosdk.f.i.a(i3, i4, i5, i5));
                            }
                        }
                    }
                    return;
                }
            }
            button = this.f57715c.V;
            button.setTextColor(com.baidu.ufosdk.b.y);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
        }
    }
}
