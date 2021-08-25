package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class RatingView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f56222e;

    /* renamed from: f  reason: collision with root package name */
    public a f56223f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f56224a;

        /* renamed from: b  reason: collision with root package name */
        public String f56225b;

        /* renamed from: c  reason: collision with root package name */
        public Double f56226c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            a aVar = this.f56223f;
            if (aVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(aVar.f56224a)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                TextView textView = new TextView(this.f56222e);
                textView.setText(this.f56223f.f56224a);
                textView.setTextSize(0, l.g(this.f56222e, R.dimen.fontsize24));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                textView.setPadding(0, 0, l.g(this.f56222e, R.dimen.ds30), 0);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                addView(textView);
            }
            if (!TextUtils.isEmpty(this.f56223f.f56225b)) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(this.f56222e);
                textView2.setText(this.f56223f.f56225b);
                textView2.setTextSize(0, l.g(this.f56222e, R.dimen.fontsize24));
                textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                textView2.setPadding(0, 0, l.g(this.f56222e, R.dimen.ds6), 0);
                textView2.setLayoutParams(layoutParams2);
                textView2.setIncludeFontPadding(false);
                addView(textView2);
            }
            Double d2 = this.f56223f.f56226c;
            if (d2 == null || Double.isNaN(d2.doubleValue())) {
                return;
            }
            Integer valueOf = Integer.valueOf(this.f56223f.f56226c.intValue());
            if (valueOf.intValue() > 10) {
                valueOf = 10;
            }
            if (valueOf.intValue() < 0) {
                valueOf = 0;
            }
            int intValue = valueOf.intValue() >> 1;
            for (int i2 = 0; i2 < intValue; i2++) {
                addView(b(SkinManager.getDrawable(R.drawable.icon_star_full)));
            }
            int i3 = 5 - intValue;
            if (valueOf.intValue() > 0 && valueOf.intValue() % 2 == 1) {
                addView(b(SkinManager.getDrawable(R.drawable.icon_star_half)));
                i3--;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                addView(b(SkinManager.getDrawable(R.drawable.icon_star_empty)));
            }
        }
    }

    public final ImageView b(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
            ImageView imageView = new ImageView(this.f56222e);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView.setPadding(0, 0, l.g(this.f56222e, R.dimen.ds4), 0);
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
            aVar.f56225b = "";
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
                if (matcher.find()) {
                    try {
                        if (!TextUtils.isEmpty(matcher.group(1))) {
                            aVar.f56225b = matcher.group(1);
                        }
                        aVar.f56226c = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
                    } catch (NumberFormatException unused) {
                        aVar.f56225b = str;
                    }
                } else {
                    aVar.f56225b = str;
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
        }
    }

    public void setRating(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            a d2 = d(str2);
            this.f56223f = d2;
            d2.f56224a = str;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56222e = context;
        c();
    }
}
