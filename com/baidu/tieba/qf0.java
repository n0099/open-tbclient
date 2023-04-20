package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class qf0 implements lf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lf0 a;

    public qf0() {
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
        this.a = new of0();
    }

    @Override // com.baidu.tieba.lf0
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.b();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.lf0
    public List<MediaTrack> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.l();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lf0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.release();
        }
    }

    @Override // com.baidu.tieba.lf0
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a.a(context);
        }
    }

    @Override // com.baidu.tieba.lf0
    public void n(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.a.n(list);
        }
    }

    @Override // com.baidu.tieba.lf0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c(i, i2);
        }
    }

    @Override // com.baidu.tieba.lf0
    public void f(List<MediaTrack> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, map) == null) {
            this.a.f(list, map);
        }
    }

    @Override // com.baidu.tieba.lf0
    public void h(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.a.h(i, j);
        }
    }

    @Override // com.baidu.tieba.lf0
    public int d(int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i, i2, map)) == null) {
            return this.a.d(i, i2, map);
        }
        return invokeIIL.intValue;
    }

    @Override // com.baidu.tieba.lf0
    public int e(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, mediaTrack, i, map)) == null) {
            return this.a.e(mediaTrack, i, map);
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.tieba.lf0
    public int i(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSegment, i, map)) == null) {
            return this.a.i(mediaSegment, i, map);
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.tieba.lf0
    public int j(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, mediaTrack, i, map)) == null) {
            return this.a.j(mediaTrack, i, map);
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.tieba.lf0
    public int g(MediaTrack mediaTrack, int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{mediaTrack, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            return this.a.g(mediaTrack, i, i2, map);
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.lf0
    public int k(int i, float[] fArr, float[] fArr2, int i2, int i3, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)})) == null) {
            return this.a.k(i, fArr, fArr2, i2, i3, f);
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.lf0
    public int m(int i, float[] fArr, float[] fArr2, int i2, int i3, int i4, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) {
            return this.a.m(i, fArr, fArr2, i2, i3, i4, map);
        }
        return invokeCommon.intValue;
    }
}
