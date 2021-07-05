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
import d.a.r0.r.q.c;
import d.a.s0.w2.i0.e;
import d.a.s0.w2.i0.g;
import d.a.s0.w2.x;
/* loaded from: classes5.dex */
public class AdAppInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20544e;

    /* renamed from: f  reason: collision with root package name */
    public AdStarRatingBar f20545f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20546g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20547h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20548i;
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
        if (!(interceptable == null || interceptable.invokeL(65540, this, attributeSet) == null) || attributeSet == null) {
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
            this.f20544e = (TextView) findViewById(R.id.ad_name);
            this.f20545f = (AdStarRatingBar) findViewById(R.id.ad_rating);
            this.f20546g = (TextView) findViewById(R.id.ad_version);
            this.f20547h = (TextView) findViewById(R.id.ad_author_full_name);
            this.f20548i = (TextView) findViewById(R.id.ad_privacy);
            this.j = (TextView) findViewById(R.id.ad_permission);
            this.k = (TextView) findViewById(R.id.ad_tag);
            this.l = (RelativeLayout) findViewById(R.id.download_button_container);
            this.f20548i.setOnClickListener(this.q);
            this.j.setOnClickListener(this.q);
        }
    }

    public final void c() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (viewTreeObserver = this.f20547h.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, viewTreeObserver) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver f20550e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ AdAppInfoView f20551f;

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
                this.f20551f = this;
                this.f20550e = viewTreeObserver;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Layout layout = this.f20551f.f20547h.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView adAppInfoView = this.f20551f;
                        adAppInfoView.f20547h.setOnClickListener(adAppInfoView.q);
                    }
                    if (this.f20550e.isAlive()) {
                        this.f20550e.removeOnGlobalLayoutListener(this);
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
        d.a.s0.w2.i0.c b2 = g.b(this.n, 102, 0);
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
            SkinManager.setViewTextColor(this.f20544e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f20546g, this.p);
            SkinManager.setViewTextColor(this.f20547h, this.p);
            SkinManager.setViewTextColor(this.f20548i, this.p);
            SkinManager.setViewTextColor(this.j, this.p);
            this.f20545f.onChangeSkinType();
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
                if (this.f20544e != null) {
                    if (!TextUtils.isEmpty(cVar.f55879b)) {
                        this.f20544e.setVisibility(0);
                        this.f20544e.setText(cVar.f55879b);
                    } else {
                        this.f20544e.setVisibility(8);
                    }
                }
                AdStarRatingBar adStarRatingBar = this.f20545f;
                if (adStarRatingBar != null) {
                    float f2 = cVar.f55881d;
                    if (f2 >= 0.0f && f2 <= 5.0f) {
                        adStarRatingBar.setVisibility(0);
                        this.f20545f.setRating(cVar.f55881d);
                    } else {
                        this.f20545f.setVisibility(8);
                    }
                }
                if (this.f20546g != null) {
                    if (!TextUtils.isEmpty(cVar.f55882e)) {
                        this.f20546g.setVisibility(0);
                        this.f20546g.setText(cVar.f55882e);
                    } else {
                        this.f20546g.setVisibility(8);
                    }
                }
                if (this.f20547h != null) {
                    if (!TextUtils.isEmpty(cVar.f55880c)) {
                        this.f20547h.setVisibility(0);
                        this.f20547h.setText(cVar.f55880c);
                        c();
                    } else {
                        this.f20547h.setVisibility(8);
                    }
                }
                if (this.f20548i != null) {
                    c.b bVar = cVar.f55883f;
                    if (bVar != null && !TextUtils.isEmpty(bVar.f55888b) && !TextUtils.isEmpty(cVar.f55883f.f55887a)) {
                        this.f20548i.setVisibility(0);
                        this.f20548i.setText(cVar.f55883f.f55887a);
                    } else {
                        this.f20548i.setVisibility(8);
                    }
                }
                if (this.f20548i != null) {
                    c.a aVar = cVar.f55884g;
                    if (aVar != null && !TextUtils.isEmpty(aVar.f55886b) && !TextUtils.isEmpty(cVar.f55884g.f55885a)) {
                        this.j.setVisibility(0);
                        this.j.setText(cVar.f55884g.f55885a);
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
            this.f20545f.setTextColor(i2);
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
            public final /* synthetic */ AdAppInfoView f20549e;

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
                this.f20549e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f20549e.m == null) {
                    return;
                }
                int id = view.getId();
                String str2 = "";
                if (id == R.id.ad_privacy) {
                    c.b bVar = this.f20549e.m.f55883f;
                    if (bVar != null) {
                        str2 = bVar.f55888b;
                        str = "app_privacy";
                    }
                    str = "";
                } else {
                    if (id == R.id.ad_permission) {
                        c.a aVar = this.f20549e.m.f55884g;
                        if (aVar != null) {
                            str2 = aVar.f55886b;
                            str = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.M(this.f20549e.getContext(), this.f20549e.m.f55880c);
                        return;
                    }
                    str = "";
                }
                x.d(this.f20549e.getContext(), str2, null, null);
                this.f20549e.d(str);
            }
        };
        b(attributeSet);
    }
}
