package com.baidu.ugc.editvideo.record.processor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b99;
import com.repackage.oe0;
import com.repackage.we0;
/* loaded from: classes4.dex */
public class MiniVideoEffectProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsDraw;

    public MiniVideoEffectProcessor() {
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
        this.mIsDraw = true;
    }

    public void needDrawEffect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.mIsDraw = z;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(oe0 oe0Var, int i, float[] fArr) {
        InterceptResult invokeLIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oe0Var, i, fArr)) == null) {
            if (oe0Var == null || !this.mIsDraw) {
                return i;
            }
            int i3 = 1;
            while (true) {
                if (i3 >= b99.b(oe0Var.l())) {
                    i2 = i;
                    break;
                }
                MediaTrack mediaTrack = (MediaTrack) b99.c(oe0Var.l(), i3);
                if (mediaTrack != null && we0.m(mediaTrack, "effect")) {
                    i2 = oe0Var.i(mediaTrack, i, null);
                    break;
                }
                i3++;
            }
            return i2 == 0 ? i : i2;
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
