package com.baidu.ugc.editvideo.subtitle;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.o9b;
import com.baidu.ugc.editvideo.data.RichStickerBaseUnit;
import java.util.List;
/* loaded from: classes9.dex */
public final class SubtitleLog {
    public static final boolean DEBUG = false;
    public static final String TAG = "subtitle";

    public static void d(RichStickerBaseUnit richStickerBaseUnit) {
        String str;
        SubTitleUnit subTitleUnit = richStickerBaseUnit instanceof SubTitleUnit ? (SubTitleUnit) richStickerBaseUnit : null;
        if (subTitleUnit == null) {
            str = "item null";
        } else {
            str = subTitleUnit + ": " + subTitleUnit.line + " [" + subTitleUnit.startTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + subTitleUnit.endTime + PreferencesUtil.RIGHT_MOUNT;
        }
        d(str);
    }

    public static void d(SubTitleUnit subTitleUnit) {
        String str;
        if (subTitleUnit == null) {
            str = "item null";
        } else {
            str = subTitleUnit + ": " + subTitleUnit.line + " [" + subTitleUnit.startTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + subTitleUnit.endTime + PreferencesUtil.RIGHT_MOUNT;
        }
        d(str);
    }

    public static void d(String str) {
        Log.d(TAG, str);
    }

    public static <T extends RichStickerBaseUnit> void d(List<T> list) {
        if (o9b.e(list)) {
            d("list empty");
            return;
        }
        int i = 0;
        for (T t : list) {
            if (t instanceof SubTitleUnit) {
                SubTitleUnit subTitleUnit = (SubTitleUnit) t;
                d(i + ": " + subTitleUnit.line + " [" + subTitleUnit.startTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + subTitleUnit.endTime + PreferencesUtil.RIGHT_MOUNT);
                i++;
            }
        }
    }
}
