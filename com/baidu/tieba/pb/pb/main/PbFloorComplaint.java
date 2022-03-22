package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbFloorComplaint extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34884b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f34885c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f34886d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f34887e;

    /* renamed from: f  reason: collision with root package name */
    public int f34888f;

    /* renamed from: g  reason: collision with root package name */
    public int f34889g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbFloorComplaint(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d069d, (ViewGroup) this, true);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a3b);
            this.f34884b = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ab0);
            this.f34885c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091a3c);
            this.f34886d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091a6b);
            this.f34887e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0909f8);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ImageView imageView = this.a;
            if (imageView != null) {
                imageView.invalidate();
            }
            int i = this.f34888f;
            if (i == 1) {
                this.f34885c.setText(R.string.obfuscated_res_0x7f0f0f89);
                c.d(this.f34885c).v(R.color.CAM_X0301);
            } else if (i == 2) {
                this.f34885c.setText(R.string.obfuscated_res_0x7f0f0621);
                c.d(this.f34885c).v(R.color.CAM_X0105);
            } else if (i == 3) {
                this.f34885c.setText(R.string.obfuscated_res_0x7f0f0622);
                c.d(this.f34885c).v(R.color.CAM_X0301);
            } else {
                this.f34885c.setText(R.string.obfuscated_res_0x7f0f0f89);
                c.d(this.f34885c).v(R.color.CAM_X0301);
            }
            int i2 = this.f34889g;
            if (i2 == 1 || i2 == 3) {
                WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f0809e5, R.color.CAM_X0301, null);
            } else if (i2 == 2) {
                WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f0808da, R.color.CAM_X0105, null);
            } else {
                WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f0809e5, R.color.CAM_X0301, null);
            }
            WebPManager.setPureDrawable(this.f34884b, R.drawable.obfuscated_res_0x7f0808d8, R.color.CAM_X0304, null);
            c d2 = c.d(this.f34886d);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X09);
        }
    }

    public void setAmendIconListener(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (relativeLayout = this.f34887e) == null) {
            return;
        }
        relativeLayout.setOnClickListener(onClickListener);
    }

    public void setRemindIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f34889g = i;
            b();
        }
    }

    public void setRemindText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f34888f = i;
            b();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbFloorComplaint(Context context, AttributeSet attributeSet) {
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
    public PbFloorComplaint(Context context, AttributeSet attributeSet, int i) {
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
        this.f34888f = 0;
        this.f34889g = 0;
        a(context);
    }
}
