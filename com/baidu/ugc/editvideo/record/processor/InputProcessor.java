package com.baidu.ugc.editvideo.record.processor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.v0.t.h;
import d.a.z.b.a.e;
import d.a.z.b.a.k.c;
/* loaded from: classes5.dex */
public class InputProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InputProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(e eVar, int i2, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, eVar, i2, fArr)) == null) {
            if (eVar == null || eVar.k() == null) {
                return i2;
            }
            MediaTrack mediaTrack = (MediaTrack) h.c(eVar.k(), 0);
            boolean l = c.l(mediaTrack, "input_blank");
            int f2 = !l ? eVar.f(mediaTrack, i2, 0, null) : i2;
            if (l) {
                for (int i3 = 1; i3 < eVar.k().size(); i3++) {
                    MediaTrack mediaTrack2 = eVar.k().get(i3);
                    if (mediaTrack2 != null && c.l(mediaTrack2, "multi_input")) {
                        f2 = eVar.i(mediaTrack2, f2, null);
                    }
                }
                f2 = eVar.f(mediaTrack, f2, 1, null);
            }
            return f2 == 0 ? i2 : f2;
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
