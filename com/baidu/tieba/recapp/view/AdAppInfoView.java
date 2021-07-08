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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.q.c;
import d.a.p0.w2.i0.e;
import d.a.p0.w2.i0.g;
import d.a.p0.w2.x;
/* loaded from: classes4.dex */
public class AdAppInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20590e;

    /* renamed from: f  reason: collision with root package name */
    public AdStarRatingBar f20591f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20592g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20593h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20594i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public c m;
    public AdvertAppInfo n;
    public int o;
    public int p;
    public View.OnClickListener q;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context) {
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

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SimpleAdInfoView);
        this.o = obtainStyledAttributes.getResourceId(R$styleable.SimpleAdInfoView_layoutId, this.o);
        obtainStyledAttributes.recycle();
    }

    public void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.f20590e = (TextView) findViewById(R.id.ad_name);
            this.f20591f = (AdStarRatingBar) findViewById(R.id.ad_rating);
            this.f20592g = (TextView) findViewById(R.id.ad_version);
            this.f20593h = (TextView) findViewById(R.id.ad_author_full_name);
            this.f20594i = (TextView) findViewById(R.id.ad_privacy);
            this.j = (TextView) findViewById(R.id.ad_permission);
            this.k = (TextView) findViewById(R.id.ad_tag);
            this.l = (RelativeLayout) findViewById(R.id.download_button_container);
            this.f20594i.setOnClickListener(this.q);
            this.j.setOnClickListener(this.q);
        }
    }

    public final void c() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (viewTreeObserver = this.f20593h.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, viewTreeObserver) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver f20596e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ AdAppInfoView f20597f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, viewTreeObserver};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20597f = this;
                this.f20596e = viewTreeObserver;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Layout layout = this.f20597f.f20593h.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView adAppInfoView = this.f20597f;
                        adAppInfoView.f20593h.setOnClickListener(adAppInfoView.q);
                    }
                    if (this.f20596e.isAlive()) {
                        this.f20596e.removeOnGlobalLayoutListener(this);
                    }
                }
            }
        });
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.n == null || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.p0.w2.i0.c b2 = g.b(this.n, 102, 0);
        b2.c(str);
        e.b().d(b2);
    }

    public RelativeLayout getDownloadButtonContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (RelativeLayout) invokeV.objValue;
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.intValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f20590e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f20592g, this.p);
            SkinManager.setViewTextColor(this.f20593h, this.p);
            SkinManager.setViewTextColor(this.f20594i, this.p);
            SkinManager.setViewTextColor(this.j, this.p);
            this.f20591f.onChangeSkinType();
        }
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            this.n = advertAppInfo;
        }
    }

    public void setAppInfo(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar != null && c.c(cVar)) {
                this.m = cVar;
                if (this.f20590e != null) {
                    if (!TextUtils.isEmpty(cVar.f52593c)) {
                        this.f20590e.setVisibility(0);
                        this.f20590e.setText(cVar.f52593c);
                    } else {
                        this.f20590e.setVisibility(8);
                    }
                }
                AdStarRatingBar adStarRatingBar = this.f20591f;
                if (adStarRatingBar != null) {
                    float f2 = cVar.f52595e;
                    if (f2 >= 0.0f && f2 <= 5.0f) {
                        adStarRatingBar.setVisibility(0);
                        this.f20591f.setRating(cVar.f52595e);
                    } else {
                        this.f20591f.setVisibility(8);
                    }
                }
                if (this.f20592g != null) {
                    if (!TextUtils.isEmpty(cVar.f52596f)) {
                        this.f20592g.setVisibility(0);
                        this.f20592g.setText(cVar.f52596f);
                    } else {
                        this.f20592g.setVisibility(8);
                    }
                }
                if (this.f20593h != null) {
                    if (!TextUtils.isEmpty(cVar.f52594d)) {
                        this.f20593h.setVisibility(0);
                        this.f20593h.setText(cVar.f52594d);
                        c();
                    } else {
                        this.f20593h.setVisibility(8);
                    }
                }
                if (this.f20594i != null) {
                    c.b bVar = cVar.f52597g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.f52603b) && !TextUtils.isEmpty(cVar.f52597g.f52602a)) {
                        this.f20594i.setVisibility(0);
                        this.f20594i.setText(cVar.f52597g.f52602a);
                    } else {
                        this.f20594i.setVisibility(8);
                    }
                }
                if (this.f20594i != null) {
                    c.a aVar = cVar.f52598h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.f52601b) && !TextUtils.isEmpty(cVar.f52598h.f52600a)) {
                        this.j.setVisibility(0);
                        this.j.setText(cVar.f52598h.f52600a);
                    } else {
                        this.j.setVisibility(8);
                    }
                }
                TextView textView = this.k;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
            this.m = null;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
            this.f20591f.setTextColor(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = R.layout.ad_app_info_view;
        this.p = R.color.CAM_X0109;
        this.q = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdAppInfoView f20595e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f20595e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f20595e.m == null) {
                    return;
                }
                int id = view.getId();
                String str2 = "";
                if (id == R.id.ad_privacy) {
                    c.b bVar = this.f20595e.m.f52597g;
                    if (bVar != null) {
                        str2 = bVar.f52603b;
                        str = "app_privacy";
                    }
                    str = "";
                } else {
                    if (id == R.id.ad_permission) {
                        c.a aVar = this.f20595e.m.f52598h;
                        if (aVar != null) {
                            str2 = aVar.f52601b;
                            str = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.M(this.f20595e.getContext(), this.f20595e.m.f52594d);
                        return;
                    }
                    str = "";
                }
                x.d(this.f20595e.getContext(), str2, null, null);
                this.f20595e.d(str);
            }
        };
        b(attributeSet);
    }
}
