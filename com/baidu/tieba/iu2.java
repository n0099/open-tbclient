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
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes4.dex */
public class iu2 extends gu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public iu2() {
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

    @Override // com.baidu.tieba.gu2
    public boolean a(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        boolean z;
        Set set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, rect)) == null) {
            if (gu2.c) {
                Log.d("SimpleErrorPageParser", "SimpleErrorPageParser: start error page parse");
            }
            if (bitmap == null) {
                return false;
            }
            if (!b(bitmap, rect)) {
                rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            try {
                int pixel = bitmap.getPixel(rect.left + 1, rect.top + 1);
                if (pixel != -1 && pixel != -657931) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (set = this.b) != null) {
                    Iterator it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((Integer) it.next()).intValue() == pixel) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
                for (int i = rect.left + 1; i < rect.right - 1; i++) {
                    for (int i2 = rect.top + 1; i2 < rect.bottom - 1; i2++) {
                        if (pixel != bitmap.getPixel(i, i2)) {
                            if (wj1.a) {
                                Log.d("SimpleErrorPageParser", "非白屏, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i + "," + i2 + SmallTailInfo.EMOTION_SUFFIX);
                            }
                            return false;
                        }
                    }
                }
                if (gu2.c) {
                    Log.d("SimpleErrorPageParser", "白屏, 图片大小 " + rect.width() + " x " + rect.height());
                }
                return true;
            } catch (IllegalArgumentException e) {
                if (gu2.c) {
                    Log.d("SimpleErrorPageParser", "W:" + bitmap.getWidth() + "; H:" + bitmap.getHeight());
                    e.printStackTrace();
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
