package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        String filePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, imageFileInfo)) == null) {
            Intrinsics.checkNotNullParameter(imageFileInfo, "<this>");
            int imageType = imageFileInfo.getImageType();
            if (imageType != 0) {
                if (imageType != 1) {
                    if (!TbadkCoreApplication.getInst().isDebugMode()) {
                        return "";
                    }
                    throw new IllegalStateException(" 暂时不支持的图片类型" + imageFileInfo.getImageType() + StringUtil.ARRAY_ELEMENT_SEPARATOR + imageFileInfo.toJson());
                }
                String d = dp5.b.d(imageFileInfo.getFilePath(), imageFileInfo.isGif());
                Intrinsics.checkNotNullExpressionValue(d, "{\n        EmotionService…lePath, this.isGif)\n    }");
                return d;
            }
            if (imageFileInfo.hasActionsWithoutResize()) {
                filePath = imageFileInfo.toCachedKey(true);
            } else {
                filePath = imageFileInfo.getFilePath();
            }
            Intrinsics.checkNotNullExpressionValue(filePath, "{\n        // 图片如果有缓存的动作，….filePath\n        }\n    }");
            return filePath;
        }
        return (String) invokeL.objValue;
    }

    public static final String b(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageFileInfo)) == null) {
            Intrinsics.checkNotNullParameter(imageFileInfo, "<this>");
            int imageType = imageFileInfo.getImageType();
            if (imageType != 0) {
                if (imageType != 1) {
                    return "";
                }
                return "/write/emotion/" + URLEncoder.encode(imageFileInfo.getFilePath(), "UTF-8");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("/write/image/");
            sb.append(URLEncoder.encode(imageFileInfo.getFilePath(), "UTF-8"));
            sb.append('_');
            sb.append(ListUtils.getCount(imageFileInfo.getPageActionsList()));
            sb.append('_');
            sb.append(ListUtils.getCount(imageFileInfo.getPersistActionsList()));
            sb.append('_');
            String cachedKey = imageFileInfo.toCachedKey(true);
            if (cachedKey != null) {
                num = Integer.valueOf(cachedKey.hashCode());
            } else {
                num = null;
            }
            sb.append(num);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
