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
import c.a.o0.r.v.c;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f36075b;

    /* renamed from: c  reason: collision with root package name */
    public a f36076c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(c.a.p0.x3.c.a aVar);
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

    private void setClickListener(final c.a.p0.x3.c.a aVar) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, aVar) == null) || (tbImageView = this.a) == null) {
            return;
        }
        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.x3.f.a
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

    private void setStampDescData(c.a.p0.x3.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            String str = aVar.c() + aVar.a() + "/" + aVar.b();
            if (aVar.a() > 0) {
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), aVar.c().length(), aVar.c().length() + String.valueOf(aVar.a()).length(), 33);
                this.f36075b.setText(spannableString);
                return;
            }
            this.f36075b.setText(str);
        }
    }

    private void setStampImgData(c.a.p0.x3.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, aVar) == null) {
            String d2 = aVar.d();
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            this.a.J(d2, 10, false);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f36075b == null) {
                this.f36075b = new EMTextView(getContext());
            }
            this.f36075b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            c d2 = c.d(this.f36075b);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X08);
            addView(this.f36075b);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                this.a = new TbImageView(getContext());
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds146), n.f(getContext(), R.dimen.tbds146));
            layoutParams.setMargins(0, 0, 0, n.f(getContext(), R.dimen.M_H_X004));
            this.a.setLayoutParams(layoutParams);
            this.a.setPlaceHolder(1);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.a);
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

    public /* synthetic */ void e(c.a.p0.x3.c.a aVar, View view) {
        a aVar2 = this.f36076c;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void setData(c.a.p0.x3.c.a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, aVar2) == null) || aVar == null) {
            return;
        }
        this.f36076c = aVar2;
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
    public SingleStampView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        d();
    }
}
