package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab9;
import com.repackage.ag0;
import com.repackage.sf0;
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
    public int onProcessFrame(sf0 sf0Var, int i, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, sf0Var, i, fArr)) == null) {
            if (sf0Var == null) {
                return i;
            }
            int b = ab9.b(sf0Var.l());
            int i2 = i;
            for (int i3 = 1; i3 < b; i3++) {
                MediaTrack mediaTrack = (MediaTrack) ab9.c(sf0Var.l(), i3);
                if (!ag0.m(mediaTrack, "effect") && !ag0.m(mediaTrack, "template_effect") && !ag0.m(mediaTrack, "edit_sticker") && !ag0.m(mediaTrack, "multi_input") && !ag0.m(mediaTrack, "only_background") && !ag0.m(mediaTrack, "watermark") && !ag0.m(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND) && !ag0.m(mediaTrack, "user_background")) {
                    i2 = sf0Var.i(mediaTrack, i2, null);
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
