package com.baidu.tieba.stampmission.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.stampmission.view.SingleStampView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SingleStampView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BACKLASH = "/";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f46690e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f46691f;

    /* renamed from: g  reason: collision with root package name */
    public a f46692g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(c.a.r0.v3.c.a aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleStampView(Context context) {
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

    private void setClickListener(final c.a.r0.v3.c.a aVar) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, aVar) == null) || (tbImageView = this.f46690e) == null) {
            return;
        }
        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.v3.f.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    SingleStampView.this.e(aVar, view);
                }
            }
        });
    }

    private void setStampDescData(c.a.r0.v3.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            String str = aVar.c() + aVar.a() + "/" + aVar.b();
            if (aVar.a() > 0) {
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), aVar.c().length(), aVar.c().length() + String.valueOf(aVar.a()).length(), 33);
                this.f46691f.setText(spannableString);
                return;
            }
            this.f46691f.setText(str);
        }
    }

    private void setStampImgData(c.a.r0.v3.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, aVar) == null) {
            String d2 = aVar.d();
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            this.f46690e.startLoad(d2, 10, false);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f46691f == null) {
                this.f46691f = new EMTextView(getContext());
            }
            this.f46691f.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            c d2 = c.d(this.f46691f);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X08);
            addView(this.f46691f);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f46690e == null) {
                this.f46690e = new TbImageView(getContext());
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds146), n.f(getContext(), R.dimen.tbds146));
            layoutParams.setMargins(0, 0, 0, n.f(getContext(), R.dimen.M_H_X004));
            this.f46690e.setLayoutParams(layoutParams);
            this.f46690e.setPlaceHolder(1);
            this.f46690e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f46690e);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            setOrientation(1);
            setGravity(1);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
            b();
            a();
        }
    }

    public /* synthetic */ void e(c.a.r0.v3.c.a aVar, View view) {
        a aVar2 = this.f46692g;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void setData(c.a.r0.v3.c.a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, aVar2) == null) || aVar == null) {
            return;
        }
        this.f46692g = aVar2;
        setStampImgData(aVar);
        setStampDescData(aVar);
        setClickListener(aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleStampView(Context context, @Nullable AttributeSet attributeSet) {
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
    public SingleStampView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        d();
    }
}
