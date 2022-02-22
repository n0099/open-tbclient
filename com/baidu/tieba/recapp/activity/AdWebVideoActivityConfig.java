package com.baidu.tieba.recapp.activity;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tbadk.core.atomData.AdWebViewActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class AdWebVideoActivityConfig extends AdWebViewActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_GOOD_STYLE = "good_style";
    public static final String KEY_TAIL_FRAME = "tail_frame";
    public static final String KEY_VIDEO_DURATION = "video_duration";
    public static final String KEY_VIDEO_RATIO = "video_ratio";
    public static final String KEY_VIDEO_THUMB_URL = "video_thumb_url";
    public static final String KEY_VIDEO_URL = "video_url";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdWebVideoActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        super(context, str, str2, z, z2, z3, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue(), (Bundle) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
