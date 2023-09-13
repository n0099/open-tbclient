package com.baidu.tieba;

import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class lj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdImage a;
    public BdImage b;
    public int c;
    public int d;

    public abstract String b(int i);

    public abstract int c();

    public abstract String f();

    public abstract String g();

    public abstract EmotionGroupType h();

    public abstract int i();

    public abstract boolean j();

    public abstract int l();

    public abstract boolean m(String str);

    public abstract BdImage n(String str);

    public abstract BdImage o(String str);

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    public lj5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public BdImage d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (BdImage) invokeV.objValue;
    }

    public BdImage e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (BdImage) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.d = i;
        }
    }

    public void r(BdImage bdImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdImage) == null) {
            if (bdImage != null) {
                bdImage.getRawBitmap();
            }
            this.a = bdImage;
        }
    }

    public void s(BdImage bdImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bdImage) == null) {
            if (bdImage != null) {
                bdImage.getRawBitmap();
            }
            this.b = bdImage;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.c = i;
        }
    }
}
