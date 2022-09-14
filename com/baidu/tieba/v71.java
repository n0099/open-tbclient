package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.g21;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class v71 {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193593, "Lcom/baidu/tieba/v71;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193593, "Lcom/baidu/tieba/v71;");
                return;
            }
        }
        char[] cArr = {21704};
        a = cArr;
        b = new String(cArr);
    }

    public static final String a(String str, String subTag, float f, TextPaint textPaint, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, subTag, Float.valueOf(f), textPaint, Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(subTag, "subTag");
            if (TextUtils.isEmpty(subTag)) {
                subTag = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f - (textPaint.measureText(GlideException.IndentedAppendable.INDENT) + f2), TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize + GlideException.IndentedAppendable.INDENT + subTag;
            }
            return subTag;
        }
        return (String) invokeCommon.objValue;
    }

    public static final SpannableStringBuilder b(String str, int i, TextView textView, Context context, Drawable drawable, int i2) {
        InterceptResult invokeCommon;
        float e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), textView, context, drawable, Integer.valueOf(i2)})) == null) {
            if (!TextUtils.isEmpty(str) && textView != null && context != null && drawable != null && i > 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                if (textView.getMeasuredWidth() > 0) {
                    e = (textView.getMeasuredWidth() * i) - drawable.getIntrinsicWidth();
                } else {
                    e = ((g21.c.e(context) - i2) * i) - drawable.getIntrinsicWidth();
                }
                float f = e - ((i - 1) * 10);
                Intrinsics.checkNotNull(str);
                int length = str.length() + 1;
                spannableStringBuilder.append((CharSequence) " ").append((CharSequence) b);
                if (f < textView.getPaint().measureText(spannableStringBuilder.toString())) {
                    String a2 = a(spannableStringBuilder.toString(), b, f, textView.getPaint(), drawable.getIntrinsicWidth());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(a2);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    spannableStringBuilder2.setSpan(new u71(drawable), a2.length() - b.length(), a2.length(), 17);
                    return spannableStringBuilder2;
                }
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableStringBuilder.setSpan(new u71(drawable), length, spannableStringBuilder.length(), 17);
                return spannableStringBuilder;
            }
            return new SpannableStringBuilder("");
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }
}
