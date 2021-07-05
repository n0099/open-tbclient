package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.f0.s.b;
/* loaded from: classes5.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String s;
    public String t;
    public d.a.r0.r.f0.m.b u;
    public d.a.r0.r.f0.m.b v;
    public View.OnClickListener w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorUserLikeButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        m();
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.s = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
            this.t = TbadkCoreApplication.getInst().getString(R.string.attention);
            setTextSize(R.dimen.T_X08);
            setText(this.t);
            d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
            this.u = bVar;
            bVar.q(R.color.CAM_X0302);
            d.a.r0.r.f0.m.b bVar2 = new d.a.r0.r.f0.m.b();
            this.v = bVar2;
            bVar2.r(R.color.CAM_X0109);
            setConfig(this.u);
        }
    }

    public void a(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.w) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // d.a.r0.r.f0.s.b
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // d.a.r0.r.f0.s.b
    public void c(boolean z, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            s(z);
            setVisibility(0);
        }
    }

    @Override // d.a.r0.r.f0.s.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    @Override // d.a.r0.r.f0.s.b
    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            s(z);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            k();
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            Object obj = this.f12660e;
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() == z) {
                return;
            }
            this.f12660e = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.s);
                setConfig(this.v);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.t);
                setConfig(this.u);
            }
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setFollowIconSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.u.g(i2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.setVisibility(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet) {
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
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i2) {
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
        m();
    }
}
