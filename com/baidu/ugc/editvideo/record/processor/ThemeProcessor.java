package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
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
public class ThemeProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThemeProcessor() {
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

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(oe0 oe0Var, int i, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, oe0Var, i, fArr)) == null) {
            if (oe0Var == null) {
                return i;
            }
            int b = b99.b(oe0Var.l());
            int i2 = i;
            for (int i3 = 1; i3 < b; i3++) {
                MediaTrack mediaTrack = (MediaTrack) b99.c(oe0Var.l(), i3);
                if (!we0.m(mediaTrack, "effect") && !we0.m(mediaTrack, "template_effect") && !we0.m(mediaTrack, "edit_sticker") && !we0.m(mediaTrack, "multi_input") && !we0.m(mediaTrack, "only_background") && !we0.m(mediaTrack, "watermark") && !we0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !we0.m(mediaTrack, "user_background")) {
                    i2 = oe0Var.i(mediaTrack, i2, null);
                }
            }
            return i2 == 0 ? i : i2;
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
