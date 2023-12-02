package com.baidu.tieba;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.k37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class ld7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return 0;
            }
            return BdUtilHelper.getDimens(v27.a, v27.a.getResources().getIdentifier(str, EMABTest.TYPE_DIMEN, v27.a.getPackageName()));
        }
        return invokeL.intValue;
    }

    public static final void b(View imageView, String iconUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, imageView, iconUrl) == null) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            k37.e a = k37.a().a();
            boolean z = false;
            if (StringsKt__StringsJVMKt.startsWith$default(iconUrl, "local://icon/", false, 2, null)) {
                if (!(imageView instanceof ImageView)) {
                    return;
                }
                Uri parse = Uri.parse(iconUrl);
                List<String> pathSegments = parse.getPathSegments();
                if (pathSegments.size() > 0) {
                    int identifier = v27.a.getResources().getIdentifier(pathSegments.get(pathSegments.size() - 1), ResourceManager.DRAWABLE, v27.a.getPackageName());
                    String queryParameter = parse.getQueryParameter("type");
                    String queryParameter2 = parse.getQueryParameter("color");
                    if ((queryParameter2 == null || queryParameter2.length() == 0) ? true : true) {
                        SkinManager.setImageResource((ImageView) imageView, identifier);
                        return;
                    }
                    int identifier2 = v27.a.getResources().getIdentifier(queryParameter2, "color", v27.a.getPackageName());
                    if (Intrinsics.areEqual(queryParameter, WebpUtils.TYPE_IMG_WEBP)) {
                        ((ImageView) imageView).setImageDrawable(WebPManager.getPureDrawable(identifier, SkinManager.getColor(identifier2), WebPManager.ResourceStateType.NORMAL));
                        if (imageView instanceof TbImageView) {
                            ((TbImageView) imageView).setContentColorFilter(new PorterDuffColorFilter(SkinManager.getColor(identifier2), PorterDuff.Mode.SRC_ATOP));
                        }
                    } else if (Intrinsics.areEqual(queryParameter, "svg")) {
                        ((ImageView) imageView).setImageDrawable(SvgManager.getInstance().getPureDrawable(identifier, identifier2, null));
                        if (imageView instanceof TbImageView) {
                            ((TbImageView) imageView).setContentColorFilter(new PorterDuffColorFilter(SkinManager.getColor(identifier2), PorterDuff.Mode.SRC_ATOP));
                        }
                    } else {
                        SkinManager.setImageResource((ImageView) imageView, identifier);
                    }
                }
            } else if (a != null) {
                a.f(imageView, iconUrl);
            }
        }
    }
}
