package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z23 extends w23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public z23() {
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

    @Override // com.baidu.tieba.w23
    public boolean a(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, rect)) == null) {
            if (w23.c) {
                Log.d("SolidErrorPageParser", "SolidErrorPageParser: start error page parse");
            }
            if (bitmap == null) {
                return false;
            }
            if (!b(bitmap, rect)) {
                rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            int i = 0;
            for (int i2 = rect.left + 1; i2 < rect.right - 1; i2++) {
                for (int i3 = rect.top + 1; i3 < rect.bottom - 1; i3++) {
                    int pixel = bitmap.getPixel(i2, i3);
                    if (i == 0) {
                        i = pixel;
                    }
                    if (i != pixel && pixel != 0) {
                        if (ms1.a) {
                            Log.d("SolidErrorPageParser", "非纯色, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i2 + "," + i3 + SmallTailInfo.EMOTION_SUFFIX);
                        }
                        return false;
                    }
                }
            }
            if (w23.c) {
                Log.d("SolidErrorPageParser", "color = " + i + "图片大小 " + rect.width() + " x " + rect.height());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
