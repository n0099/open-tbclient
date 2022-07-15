package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class RatingView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public a b;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public Double c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RatingView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeAllViews();
            a aVar = this.b;
            if (aVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(aVar.a)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                TextView textView = new TextView(this.a);
                textView.setText(this.b.a);
                textView.setTextSize(0, pi.f(this.a, R.dimen.obfuscated_res_0x7f0702b3));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                textView.setPadding(0, 0, pi.f(this.a, R.dimen.obfuscated_res_0x7f070201), 0);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                addView(textView);
            }
            if (!TextUtils.isEmpty(this.b.b)) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(this.a);
                textView2.setText(this.b.b);
                textView2.setTextSize(0, pi.f(this.a, R.dimen.obfuscated_res_0x7f0702b3));
                textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                textView2.setPadding(0, 0, pi.f(this.a, R.dimen.obfuscated_res_0x7f0702e8), 0);
                textView2.setLayoutParams(layoutParams2);
                textView2.setIncludeFontPadding(false);
                addView(textView2);
            }
            Double d = this.b.c;
            if (d == null || Double.isNaN(d.doubleValue())) {
                return;
            }
            Integer valueOf = Integer.valueOf(this.b.c.intValue());
            if (valueOf.intValue() > 10) {
                valueOf = 10;
            }
            if (valueOf.intValue() < 0) {
                valueOf = 0;
            }
            int intValue = valueOf.intValue() >> 1;
            for (int i = 0; i < intValue; i++) {
                addView(b(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080a54)));
            }
            int i2 = 5 - intValue;
            if (valueOf.intValue() > 0 && valueOf.intValue() % 2 == 1) {
                addView(b(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080a55)));
                i2--;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                addView(b(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080a53)));
            }
        }
    }

    public final ImageView b(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
            ImageView imageView = new ImageView(this.a);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView.setPadding(0, 0, pi.f(this.a, R.dimen.obfuscated_res_0x7f070224), 0);
            imageView.setImageDrawable(drawable);
            return imageView;
        }
        return (ImageView) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOrientation(0);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public final a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            a aVar = new a();
            aVar.b = "";
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
                if (matcher.find()) {
                    try {
                        if (!TextUtils.isEmpty(matcher.group(1))) {
                            aVar.b = matcher.group(1);
                        }
                        aVar.c = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
                    } catch (NumberFormatException unused) {
                        aVar.b = str;
                    }
                } else {
                    aVar.b = str;
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public void setRating(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            a d = d(str2);
            this.b = d;
            d.a = str;
            a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        c();
    }
}
