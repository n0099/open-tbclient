package com.baidu.ugc.editvideo.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MultiMediaDataConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_EXT_TEXT_WORDS_FONT = "text_font";
    public static final String KEY_EXT_TEXT_WORDS_STYLE = "text_style";
    public static final String KEY_EXT_TEXT_WORDS_TEMP_PATH = "temp_path";
    public static final String KEY_EXT_TEXT_WORDS_TEXT = "text";
    public transient /* synthetic */ FieldHolder $fh;

    public MultiMediaDataConstant() {
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
}
