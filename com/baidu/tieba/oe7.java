package com.baidu.tieba;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.k67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class oe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(View imageView, String iconUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, imageView, iconUrl) == null) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            k67.e a = k67.a().a();
            boolean z = false;
            if (StringsKt__StringsJVMKt.startsWith$default(iconUrl, "local://icon/", false, 2, null)) {
                if (!(imageView instanceof ImageView)) {
                    return;
                }
                Uri parse = Uri.parse(iconUrl);
                List<String> pathSegments = parse.getPathSegments();
                if (pathSegments.size() > 0) {
                    int identifier = h67.a.getResources().getIdentifier(pathSegments.get(pathSegments.size() - 1), ResourceManager.DRAWABLE, h67.a.getPackageName());
                    String queryParameter = parse.getQueryParameter("type");
                    String queryParameter2 = parse.getQueryParameter("color");
                    if ((queryParameter2 == null || queryParameter2.length() == 0) ? true : true) {
                        SkinManager.setImageResource((ImageView) imageView, identifier);
                        return;
                    }
                    int identifier2 = h67.a.getResources().getIdentifier(queryParameter2, "color", h67.a.getPackageName());
                    if (Intrinsics.areEqual(queryParameter, WebpUtils.TYPE_IMG_WEBP)) {
                        ((ImageView) imageView).setImageDrawable(WebPManager.getPureDrawable(identifier, SkinManager.getColor(identifier2), WebPManager.ResourceStateType.NORMAL));
                    } else if (Intrinsics.areEqual(queryParameter, "svg")) {
                        ((ImageView) imageView).setImageDrawable(SvgManager.getInstance().getPureDrawable(identifier, identifier2, null));
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
