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
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.nd8;
import com.baidu.tieba.nq4;
import com.baidu.tieba.un5;
import com.baidu.tieba.uz0;
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
    public AdStarRatingBar b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public RelativeLayout h;
    public nq4 i;
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
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, un5.SimpleAdInfoView);
        this.k = obtainStyledAttributes.getResourceId(0, this.k);
        obtainStyledAttributes.recycle();
    }

    public void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0900da);
            this.b = (AdStarRatingBar) findViewById(R.id.obfuscated_res_0x7f0900e4);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0900fc);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09008d);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0900e3);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0900e0);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0900f1);
            this.h = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090831);
            this.e.setOnClickListener(this.m);
            this.f.setOnClickListener(this.m);
        }
    }

    public final void c() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (viewTreeObserver = this.d.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, viewTreeObserver) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewTreeObserver a;
            public final /* synthetic */ AdAppInfoView b;

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
                this.b = this;
                this.a = viewTreeObserver;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Layout layout = this.b.d.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView adAppInfoView = this.b;
                        adAppInfoView.d.setOnClickListener(adAppInfoView.m);
                    }
                    if (this.a.isAlive()) {
                        this.a.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    ViewTreeObserver viewTreeObserver2 = this.b.d.getViewTreeObserver();
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
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.FREE_CLICK).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.j.position + 1)).j(str).p(this.j.g);
        uz0.b(clogBuilder);
    }

    public RelativeLayout getDownloadButtonContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (RelativeLayout) invokeV.objValue;
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
            SkinManager.setViewTextColor(this.c, this.l);
            SkinManager.setViewTextColor(this.d, this.l);
            SkinManager.setViewTextColor(this.e, this.l);
            SkinManager.setViewTextColor(this.f, this.l);
            this.b.onChangeSkinType();
        }
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            this.j = advertAppInfo;
        }
    }

    public void setAppInfo(nq4 nq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nq4Var) == null) {
            if (nq4Var != null && nq4.c(nq4Var)) {
                this.i = nq4Var;
                if (this.a != null) {
                    if (!TextUtils.isEmpty(nq4Var.c)) {
                        this.a.setVisibility(0);
                        this.a.setText(nq4Var.c);
                    } else {
                        this.a.setVisibility(8);
                    }
                }
                AdStarRatingBar adStarRatingBar = this.b;
                if (adStarRatingBar != null) {
                    float f = nq4Var.e;
                    if (f >= 0.0f && f <= 5.0f) {
                        adStarRatingBar.setVisibility(0);
                        this.b.setRating(nq4Var.e);
                    } else {
                        this.b.setVisibility(8);
                    }
                }
                if (this.c != null) {
                    if (!TextUtils.isEmpty(nq4Var.f)) {
                        this.c.setVisibility(0);
                        this.c.setText(nq4Var.f);
                    } else {
                        this.c.setVisibility(8);
                    }
                }
                if (this.d != null) {
                    if (!TextUtils.isEmpty(nq4Var.d)) {
                        this.d.setVisibility(0);
                        this.d.setText(nq4Var.d);
                        c();
                    } else {
                        this.d.setVisibility(8);
                    }
                }
                if (this.e != null) {
                    nq4.b bVar = nq4Var.g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(nq4Var.g.a)) {
                        this.e.setVisibility(0);
                        this.e.setText(nq4Var.g.a);
                    } else {
                        this.e.setVisibility(8);
                    }
                }
                if (this.e != null) {
                    nq4.a aVar = nq4Var.h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(nq4Var.h.a)) {
                        this.f.setVisibility(0);
                        this.f.setText(nq4Var.h.a);
                    } else {
                        this.f.setVisibility(8);
                    }
                }
                TextView textView = this.g;
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
            this.b.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.b.setTextSize(i);
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
        this.k = R.layout.obfuscated_res_0x7f0d0064;
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
            public void onClick(View view2) {
                String str;
                String str2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                    return;
                }
                int id = view2.getId();
                String str3 = "";
                if (id == R.id.obfuscated_res_0x7f0900e3) {
                    nq4.b bVar = this.a.i.g;
                    if (bVar != null) {
                        str3 = bVar.b;
                        str = bVar.c;
                        str2 = "app_privacy";
                    }
                    str = "";
                    str2 = str;
                } else {
                    if (id == R.id.obfuscated_res_0x7f0900e0) {
                        nq4.a aVar = this.a.i.h;
                        if (aVar != null) {
                            str3 = aVar.b;
                            str = aVar.c;
                            str2 = "app_permission";
                        }
                    } else if (id == R.id.obfuscated_res_0x7f09008d) {
                        ej.N(this.a.getContext(), this.a.i.d);
                        return;
                    }
                    str = "";
                    str2 = str;
                }
                nd8.a(this.a.getContext(), str3, null, null, str);
                this.a.d(str2);
            }
        };
        b(attributeSet);
    }
}
