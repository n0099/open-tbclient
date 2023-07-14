package com.baidu.tieba;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bsa;
import com.baidu.tieba.nj6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oj6 implements nj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bsa a;
    public TextView b;
    public nj6.c c;
    public nj6.b d;
    public nj6.a e;

    /* loaded from: classes7.dex */
    public class a implements bsa.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj6 a;

        public a(oj6 oj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj6Var;
        }

        @Override // com.baidu.tieba.bsa.a
        public void onProgress(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.a.b.setText(this.a.h(f));
            }
        }

        @Override // com.baidu.tieba.bsa.a
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (this.a.e != null) {
                    this.a.e.a(f);
                }
                TextView textView = this.a.b;
                oj6 oj6Var = this.a;
                textView.setText(oj6Var.h(oj6Var.getProgress()));
            }
        }

        @Override // com.baidu.tieba.bsa.a
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

        @Override // com.baidu.tieba.bsa.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.c != null) {
                this.a.c.onFinished();
            }
        }
    }

    public oj6(bsa bsaVar, TextView textView, nj6.c cVar, nj6.b bVar, nj6.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bsaVar, textView, cVar, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bsaVar;
        this.b = textView;
        this.c = cVar;
        this.d = bVar;
        this.e = aVar;
        i();
    }

    @Override // com.baidu.tieba.nj6
    public boolean setMaxDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.setMaxDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean setMinDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.setMinDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                return bsaVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                return bsaVar.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nj6
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                return bsaVar.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.nj6
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                return bsaVar.getSlideNum();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar == null) {
                return false;
            }
            bsaVar.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nj6
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            bsa bsaVar = this.a;
            if (bsaVar != null) {
                bsaVar.start();
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
