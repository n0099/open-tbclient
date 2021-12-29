package com.baidu.ugc.editvideo.subtitle;

import androidx.core.view.InputDeviceCompat;
import c.a.a1.t.h;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.RichStickerBaseUnit;
import java.util.List;
/* loaded from: classes13.dex */
public final class SubtitleLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "subtitle";
    public transient /* synthetic */ FieldHolder $fh;

    public SubtitleLog() {
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

    public static void d(RichStickerBaseUnit richStickerBaseUnit) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, richStickerBaseUnit) == null) {
            SubTitleUnit subTitleUnit = richStickerBaseUnit instanceof SubTitleUnit ? (SubTitleUnit) richStickerBaseUnit : null;
            if (subTitleUnit == null) {
                str = "item null";
            } else {
                str = subTitleUnit + ": " + subTitleUnit.line + " [" + subTitleUnit.startTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + subTitleUnit.endTime + PreferencesUtil.RIGHT_MOUNT;
            }
            d(str);
        }
    }

    public static void d(SubTitleUnit subTitleUnit) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, subTitleUnit) == null) {
            if (subTitleUnit == null) {
                str = "item null";
            } else {
                str = subTitleUnit + ": " + subTitleUnit.line + " [" + subTitleUnit.startTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + subTitleUnit.endTime + PreferencesUtil.RIGHT_MOUNT;
            }
            d(str);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
        }
    }

    public static <T extends RichStickerBaseUnit> void d(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) {
            if (h.e(list)) {
                d("list empty");
                return;
            }
            int i2 = 0;
            for (T t : list) {
                if (t instanceof SubTitleUnit) {
                    SubTitleUnit subTitleUnit = (SubTitleUnit) t;
                    d(i2 + ": " + subTitleUnit.line + " [" + subTitleUnit.startTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + subTitleUnit.endTime + PreferencesUtil.RIGHT_MOUNT);
                    i2++;
                }
            }
        }
    }
}
