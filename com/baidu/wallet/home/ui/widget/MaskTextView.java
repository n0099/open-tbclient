package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
/* loaded from: classes11.dex */
public class MaskTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mOriginalText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf("#");
                int lastIndexOf = str.lastIndexOf("#");
                if (indexOf != -1 && lastIndexOf != -1 && indexOf < lastIndexOf) {
                    String replace = str.substring(indexOf, lastIndexOf + 1).replace("#", "");
                    try {
                        return Color.parseColor("#" + replace);
                    } catch (Exception unused) {
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("#");
            int lastIndexOf = str.lastIndexOf("#");
            return (indexOf == -1 || lastIndexOf == -1 || indexOf >= lastIndexOf) ? str : str.replace(str.substring(indexOf, lastIndexOf + 1), "");
        }
        return (String) invokeL.objValue;
    }

    private String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (com.baidu.wallet.home.storage.a.a(getContext())) {
                int indexOf = str.indexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
                int lastIndexOf = str.lastIndexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
                if (indexOf == -1 || lastIndexOf == -1 || indexOf == lastIndexOf) {
                    return str;
                }
                String substring = str.substring(indexOf, lastIndexOf + 1);
                if (substring.length() <= 2) {
                    return str.replace(substring, "");
                }
                return str.replace(substring, "****");
            }
            return str.replace(PayTypeItemView.PayTypeItemViewData.MASK_FLAG, "");
        }
        return (String) invokeL.objValue;
    }

    public void resetMaskText() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.mOriginalText)) {
            return;
        }
        setMaskText(this.mOriginalText);
    }

    public void setMaskText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mOriginalText = str;
        int a = a(str);
        String b2 = b(str);
        if (b2.contains(PayTypeItemView.PayTypeItemViewData.MASK_FLAG)) {
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (com.baidu.wallet.home.storage.a.a(getContext())) {
                super.setText(c(b2));
                return;
            }
            int indexOf = b2.indexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
            int lastIndexOf = b2.lastIndexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
            int length = (lastIndexOf - (b2.length() - c(b2).length())) + 1;
            if (indexOf != -1 && lastIndexOf != -1 && indexOf != lastIndexOf) {
                String c2 = c(b2);
                if (a != -1 && indexOf <= length && length <= c2.length()) {
                    SpannableString spannableString = new SpannableString(c2);
                    spannableString.setSpan(new ForegroundColorSpan(a), indexOf, length, 33);
                    super.setText(spannableString);
                    return;
                }
                super.setText(c2);
                return;
            }
            super.setText(c(b2));
            return;
        }
        if (a != -1) {
            setTextColor(a);
        }
        super.setText(b2);
    }
}
