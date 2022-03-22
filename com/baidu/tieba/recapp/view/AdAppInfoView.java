package com.baidu.tieba.recapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.c;
import c.a.p0.l3.a0;
import c.a.p0.l3.m0.e;
import c.a.p0.l3.m0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AdAppInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public AdStarRatingBar f35746b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35747c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35748d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35749e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35750f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35751g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f35752h;
    public c i;
    public AdvertAppInfo j;
    public int k;
    public int l;
    public View.OnClickListener m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context) {
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

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040383});
        this.k = obtainStyledAttributes.getResourceId(0, this.k);
        obtainStyledAttributes.recycle();
    }

    public void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0900d6);
            this.f35746b = (AdStarRatingBar) findViewById(R.id.obfuscated_res_0x7f0900de);
            this.f35747c = (TextView) findViewById(R.id.obfuscated_res_0x7f0900f7);
            this.f35748d = (TextView) findViewById(R.id.obfuscated_res_0x7f090087);
            this.f35749e = (TextView) findViewById(R.id.obfuscated_res_0x7f0900dd);
            this.f35750f = (TextView) findViewById(R.id.obfuscated_res_0x7f0900da);
            this.f35751g = (TextView) findViewById(R.id.obfuscated_res_0x7f0900eb);
            this.f35752h = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090819);
            this.f35749e.setOnClickListener(this.m);
            this.f35750f.setOnClickListener(this.m);
        }
    }

    public final void c() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (viewTreeObserver = this.f35748d.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, viewTreeObserver) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewTreeObserver a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AdAppInfoView f35753b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, viewTreeObserver};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35753b = this;
                this.a = viewTreeObserver;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Layout layout = this.f35753b.f35748d.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView adAppInfoView = this.f35753b;
                        adAppInfoView.f35748d.setOnClickListener(adAppInfoView.m);
                    }
                    if (this.a.isAlive()) {
                        this.a.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    ViewTreeObserver viewTreeObserver2 = this.f35753b.f35748d.getViewTreeObserver();
                    if (viewTreeObserver2 == null || !viewTreeObserver2.isAlive()) {
                        return;
                    }
                    viewTreeObserver2.removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.j == null || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.p0.l3.m0.c b2 = g.b(this.j, 102, 0);
        b2.c(str);
        e.b().d(b2);
    }

    public RelativeLayout getDownloadButtonContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35752h : (RelativeLayout) invokeV.objValue;
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f35747c, this.l);
            SkinManager.setViewTextColor(this.f35748d, this.l);
            SkinManager.setViewTextColor(this.f35749e, this.l);
            SkinManager.setViewTextColor(this.f35750f, this.l);
            this.f35746b.onChangeSkinType();
        }
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            this.j = advertAppInfo;
        }
    }

    public void setAppInfo(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar != null && c.c(cVar)) {
                this.i = cVar;
                if (this.a != null) {
                    if (!TextUtils.isEmpty(cVar.f10812c)) {
                        this.a.setVisibility(0);
                        this.a.setText(cVar.f10812c);
                    } else {
                        this.a.setVisibility(8);
                    }
                }
                AdStarRatingBar adStarRatingBar = this.f35746b;
                if (adStarRatingBar != null) {
                    float f2 = cVar.f10814e;
                    if (f2 >= 0.0f && f2 <= 5.0f) {
                        adStarRatingBar.setVisibility(0);
                        this.f35746b.setRating(cVar.f10814e);
                    } else {
                        this.f35746b.setVisibility(8);
                    }
                }
                if (this.f35747c != null) {
                    if (!TextUtils.isEmpty(cVar.f10815f)) {
                        this.f35747c.setVisibility(0);
                        this.f35747c.setText(cVar.f10815f);
                    } else {
                        this.f35747c.setVisibility(8);
                    }
                }
                if (this.f35748d != null) {
                    if (!TextUtils.isEmpty(cVar.f10813d)) {
                        this.f35748d.setVisibility(0);
                        this.f35748d.setText(cVar.f10813d);
                        c();
                    } else {
                        this.f35748d.setVisibility(8);
                    }
                }
                if (this.f35749e != null) {
                    c.b bVar = cVar.f10816g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.f10820b) && !TextUtils.isEmpty(cVar.f10816g.a)) {
                        this.f35749e.setVisibility(0);
                        this.f35749e.setText(cVar.f10816g.a);
                    } else {
                        this.f35749e.setVisibility(8);
                    }
                }
                if (this.f35749e != null) {
                    c.a aVar = cVar.f10817h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.f10818b) && !TextUtils.isEmpty(cVar.f10817h.a)) {
                        this.f35750f.setVisibility(0);
                        this.f35750f.setText(cVar.f10817h.a);
                    } else {
                        this.f35750f.setVisibility(8);
                    }
                }
                TextView textView = this.f35751g;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
            this.i = null;
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
            this.f35746b.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f35746b.setTextSize(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = R.layout.obfuscated_res_0x7f0d0065;
        this.l = R.color.CAM_X0109;
        this.m = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdAppInfoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.i == null) {
                    return;
                }
                int id = view.getId();
                String str3 = "";
                if (id == R.id.obfuscated_res_0x7f0900dd) {
                    c.b bVar = this.a.i.f10816g;
                    if (bVar != null) {
                        str3 = bVar.f10820b;
                        str = bVar.f10821c;
                        str2 = "app_privacy";
                    }
                    str = "";
                    str2 = str;
                } else {
                    if (id == R.id.obfuscated_res_0x7f0900da) {
                        c.a aVar = this.a.i.f10817h;
                        if (aVar != null) {
                            str3 = aVar.f10818b;
                            str = aVar.f10819c;
                            str2 = "app_permission";
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090087) {
                        n.N(this.a.getContext(), this.a.i.f10813d);
                        return;
                    }
                    str = "";
                    str2 = str;
                }
                a0.d(this.a.getContext(), str3, null, null, str);
                this.a.d(str2);
            }
        };
        b(attributeSet);
    }
}
