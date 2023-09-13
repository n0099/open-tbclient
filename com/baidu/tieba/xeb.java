package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
/* loaded from: classes8.dex */
public class xeb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioPlayData a;
    public yeb b;

    public xeb(AudioPlayData audioPlayData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioPlayData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = audioPlayData;
        if (audioPlayData == null || !FileUtils.isExists(audioPlayData.audioPath)) {
            return;
        }
        this.b = new yeb(audioPlayData.audioPath);
    }

    public yeb a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (yeb) invokeV.objValue;
    }

    public AudioPlayData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (AudioPlayData) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            yeb yebVar = this.b;
            return yebVar != null && yebVar.i();
        }
        return invokeV.booleanValue;
    }

    public void d(yeb yebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yebVar) == null) {
            this.b = yebVar;
        }
    }
}
