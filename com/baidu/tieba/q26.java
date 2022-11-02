package com.baidu.tieba;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p26;
import com.baidu.tieba.y19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q26 implements p26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y19 a;
    public TextView b;
    public p26.c c;
    public p26.b d;
    public p26.a e;

    /* loaded from: classes5.dex */
    public class a implements y19.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q26 a;

        public a(q26 q26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q26Var;
        }

        @Override // com.baidu.tieba.y19.a
        public void onProgress(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.a.b.setText(this.a.h(f));
            }
        }

        @Override // com.baidu.tieba.y19.a
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (this.a.e != null) {
                    this.a.e.a(f);
                }
                TextView textView = this.a.b;
                q26 q26Var = this.a;
                textView.setText(q26Var.h(q26Var.getProgress()));
            }
        }

        @Override // com.baidu.tieba.y19.a
        public float getSpeed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.d != null) {
                    return this.a.d.getSpeed();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.y19.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.c != null) {
                this.a.c.a();
            }
        }
    }

    public q26(y19 y19Var, TextView textView, p26.c cVar, p26.b bVar, p26.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y19Var, textView, cVar, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = y19Var;
        this.b = textView;
        this.c = cVar;
        this.d = bVar;
        this.e = aVar;
        i();
    }

    @Override // com.baidu.tieba.p26
    public boolean setMaxDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.setMaxDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean setMinDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.setMinDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                return y19Var.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                return y19Var.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.p26
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                return y19Var.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.p26
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                return y19Var.getSlideNum();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var == null) {
                return false;
            }
            y19Var.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p26
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            y19 y19Var = this.a;
            if (y19Var != null) {
                y19Var.start();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String h(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            if (f >= getMaxDuration()) {
                f = getMaxDuration();
            }
            if (f > 60.0f) {
                return ((int) (f / 60.0f)) + "'" + String.format("%.1f", Float.valueOf(f % 60.0f));
            }
            return String.format("%.1f", Float.valueOf(f));
        }
        return (String) invokeF.objValue;
    }
}
