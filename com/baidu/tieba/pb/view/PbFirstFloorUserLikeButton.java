package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.oa5;
import com.baidu.tieba.pb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements pb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String o;
    public String p;
    public oa5 q;
    public oa5 r;
    public View.OnClickListener s;
    public boolean t;

    @Override // com.baidu.tieba.pb5
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.pb5
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorUserLikeButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
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
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i) {
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
        init();
    }

    @Override // com.baidu.tieba.pb5
    public void b(boolean z, int i, boolean z2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            q(z);
            setVisibility(0);
            if (z && (onClickListener = this.s) != null) {
                onClickListener.onClick(this);
            }
        }
    }

    @Override // com.baidu.tieba.pb5
    public void d(boolean z, int i) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            q(z);
            if (z && (onClickListener = this.s) != null) {
                onClickListener.onClick(this);
            }
        }
    }

    @Override // com.baidu.tieba.pb5
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            k();
        }
    }

    public void setAfterStatusUpdateListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setIsShowIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.t = z;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.setVisibility(i);
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
            this.p = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ea);
            setTextSize(R.dimen.T_X08);
            setText(this.p);
            oa5 oa5Var = new oa5();
            this.q = oa5Var;
            oa5Var.u(R.color.CAM_X0304);
            oa5 oa5Var2 = new oa5();
            this.r = oa5Var2;
            oa5Var2.w(R.color.CAM_X0109);
            setConfig(this.q);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            Object obj = this.a;
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() == z) {
                return;
            }
            this.a = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.o);
                setConfig(this.r);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.p);
                if (this.t) {
                    UtilHelper.addFollowUserIconStyle(this.q);
                }
                setConfig(this.q);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
