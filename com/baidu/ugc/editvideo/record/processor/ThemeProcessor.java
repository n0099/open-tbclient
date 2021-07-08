package com.baidu.ugc.editvideo.record.processor;

import androidx.core.app.NotificationCompat;
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
public class ThemeProcessor extends BaseEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThemeProcessor() {
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
            if (eVar == null) {
                return i2;
            }
            int b2 = h.b(eVar.k());
            int i3 = i2;
            for (int i4 = 1; i4 < b2; i4++) {
                MediaTrack mediaTrack = (MediaTrack) h.c(eVar.k(), i4);
                if (!c.l(mediaTrack, "effect") && !c.l(mediaTrack, "edit_sticker") && !c.l(mediaTrack, "multi_input") && !c.l(mediaTrack, "only_background") && !c.l(mediaTrack, "watermark") && !c.l(mediaTrack, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                    i3 = eVar.i(mediaTrack, i3, null);
                }
            }
            return i3 == 0 ? i2 : i3;
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
