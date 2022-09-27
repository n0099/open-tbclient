package com.baidu.tieba;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f09;
import com.baidu.tieba.y06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class z06 implements y06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f09 a;
    public TextView b;
    public y06.c c;
    public y06.b d;
    public y06.a e;

    /* loaded from: classes6.dex */
    public class a implements f09.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z06 a;

        public a(z06 z06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z06Var;
        }

        @Override // com.baidu.tieba.f09.a
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (this.a.e != null) {
                    this.a.e.a(f);
                }
                TextView textView = this.a.b;
                z06 z06Var = this.a;
                textView.setText(z06Var.h(z06Var.getProgress()));
            }
        }

        @Override // com.baidu.tieba.f09.a
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

        @Override // com.baidu.tieba.f09.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.a();
        }

        @Override // com.baidu.tieba.f09.a
        public void onProgress(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.a.b.setText(this.a.h(f));
            }
        }
    }

    public z06(f09 f09Var, TextView textView, y06.c cVar, y06.b bVar, y06.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f09Var, textView, cVar, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f09Var;
        this.b = textView;
        this.c = cVar;
        this.d = bVar;
        this.e = aVar;
        i();
    }

    @Override // com.baidu.tieba.y06
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                return f09Var.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                return f09Var.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.y06
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                return f09Var.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.y06
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                return f09Var.getSlideNum();
            }
            return 0;
        }
        return invokeV.intValue;
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

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var == null) {
                return false;
            }
            f09Var.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean setMaxDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.setMaxDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean setMinDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.setMinDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.y06
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            f09 f09Var = this.a;
            if (f09Var != null) {
                f09Var.start();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
