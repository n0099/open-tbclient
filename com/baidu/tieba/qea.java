package com.baidu.tieba;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qea extends pea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int U0;
    public int V0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qea(Context context, View view2) {
        super(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        u0(false);
        this.U0 = BdUtilHelper.getEquipmentWidth(this.S) / 10;
    }

    public void H0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.Y = str2;
            V();
            W();
            x0(this.b);
            this.F.setPlayer(this.t.getControl());
            this.B.setVisibility(8);
            this.u.setPlaceHolder(3);
            this.u.startLoad(str, 10, false);
            this.H.setShareData(null);
        }
    }

    @Override // com.baidu.tieba.pea
    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            Context context = this.S;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.c0);
            } else if (context instanceof BaseActivity) {
                ((BaseActivity) context).setSwipeBackEnabled(this.c0);
            }
            super.b0(z);
            if (this.c0) {
                this.U.getLayoutParams().height = -1;
                return;
            }
            this.U.getLayoutParams().height = this.V0;
        }
    }

    @Override // com.baidu.tieba.pea
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.tieba.pea
    public boolean k0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (!this.c0 && motionEvent.getX() <= this.U0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pea
    public void x0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.x0(i);
            this.J.setVisibility(8);
            this.D.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.pea, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPrepared();
            if (this.t.getControl().getPlayerWidth() == 0) {
                return;
            }
            if (this.t.getControl().getPlayerHeight() > this.t.getControl().getPlayerWidth()) {
                z = true;
            } else {
                z = false;
            }
            this.X = z;
            int playerHeight = (int) ((this.t.getControl().getPlayerHeight() / this.t.getControl().getPlayerWidth()) * BdUtilHelper.getEquipmentWidth(this.S));
            this.V0 = playerHeight;
            if (playerHeight > BdUtilHelper.getEquipmentHeight(this.S)) {
                this.V0 = BdUtilHelper.getEquipmentHeight(this.S);
            }
            this.U.getLayoutParams().height = this.V0;
            this.U.requestLayout();
        }
    }
}
