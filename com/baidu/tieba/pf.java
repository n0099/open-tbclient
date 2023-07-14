package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.guide.BuildException;
import com.baidu.adp.lib.guide.Configuration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Configuration a;
    public boolean b;
    public List<nf> c;
    public a d;

    /* loaded from: classes7.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public pf() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = new Configuration();
    }

    public pf a(nf nfVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nfVar)) == null) {
            if (!this.b) {
                this.c.add(nfVar);
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (pf) invokeL.objValue;
    }

    public pf c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (!this.b) {
                if (i >= 0 && i <= 255) {
                    this.a.mAlpha = i;
                    return this;
                }
                throw new BuildException("Illegal alpha value, should between [0-255]");
            }
            throw new BuildException("Already created. rebuild a new one.");
        }
        return (pf) invokeI.objValue;
    }

    public pf d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (!this.b) {
                this.a.mAutoDismiss = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (pf) invokeZ.objValue;
    }

    public pf e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (!this.b) {
                if (i > 0) {
                    this.a.mEnterAnimationId = i;
                    return this;
                }
                throw new BuildException("Illegal animation resource id.");
            }
            throw new BuildException("Already created. rebuild a new one.");
        }
        return (pf) invokeI.objValue;
    }

    public pf f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (!this.b) {
                if (i > 0) {
                    this.a.mExitAnimationId = i;
                    return this;
                }
                throw new BuildException("Illegal animation resource id.");
            }
            throw new BuildException("Already created. rebuild a new one.");
        }
        return (pf) invokeI.objValue;
    }

    public pf g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (!this.b) {
                this.a.mKeyBackEventDismiss = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (pf) invokeZ.objValue;
    }

    public pf h(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (!this.b) {
                this.d = aVar;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (pf) invokeL.objValue;
    }

    public pf i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.a.mOutsideTouchable = z;
            return this;
        }
        return (pf) invokeZ.objValue;
    }

    public pf j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (!this.b) {
                this.a.mOverlayTarget = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (pf) invokeZ.objValue;
    }

    public pf k(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) {
            if (!this.b) {
                if (view2 != null) {
                    this.a.mTargetView = view2;
                    return this;
                }
                throw new BuildException("Illegal view.");
            }
            throw new BuildException("Already created. rebuild a new one.");
        }
        return (pf) invokeL.objValue;
    }

    public of b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            of ofVar = new of();
            ofVar.i((nf[]) this.c.toArray(new nf[this.c.size()]));
            ofVar.j(this.a);
            ofVar.h(this.d);
            this.c = null;
            this.a = null;
            this.d = null;
            this.b = true;
            return ofVar;
        }
        return (of) invokeV.objValue;
    }
}
