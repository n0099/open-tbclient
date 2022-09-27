package com.baidu.tieba;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jb8 extends ib8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public int O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb8(Context context, View view2) {
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
        m0(false);
        this.N0 = ej.k(this.O) / 10;
    }

    @Override // com.baidu.tieba.ib8
    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Context context = this.O;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.Y);
            } else if (context instanceof BaseActivity) {
                ((BaseActivity) context).setSwipeBackEnabled(this.Y);
            }
            super.V(z);
            if (this.Y) {
                this.Q.getLayoutParams().height = -1;
                return;
            }
            this.Q.getLayoutParams().height = this.O0;
        }
    }

    @Override // com.baidu.tieba.ib8
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.tieba.ib8
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? this.Y || motionEvent.getX() > ((float) this.N0) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ib8
    public void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.o0(i);
            this.J.setVisibility(8);
            this.D.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ib8, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPrepared();
            if (this.t.getControl().getPlayerWidth() == 0) {
                return;
            }
            this.T = this.t.getControl().getPlayerHeight() > this.t.getControl().getPlayerWidth();
            int playerHeight = (int) ((this.t.getControl().getPlayerHeight() / this.t.getControl().getPlayerWidth()) * ej.k(this.O));
            this.O0 = playerHeight;
            if (playerHeight > ej.i(this.O)) {
                this.O0 = ej.i(this.O);
            }
            this.Q.getLayoutParams().height = this.O0;
            this.Q.requestLayout();
        }
    }

    public void w0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.U = str2;
            P();
            Q();
            o0(this.b);
            this.F.setPlayer(this.t.getControl());
            this.B.setVisibility(8);
            this.u.setPlaceHolder(3);
            this.u.K(str, 10, false);
            this.H.setShareData(null);
        }
    }
}
