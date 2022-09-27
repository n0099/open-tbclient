package com.baidu.tieba;

import android.media.MediaMetadataRetriever;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
/* loaded from: classes5.dex */
public class pg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(MediaMetadataRetriever mediaMetadataRetriever) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, mediaMetadataRetriever) == null) || mediaMetadataRetriever == null) {
            return;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (Exception e) {
            qg9.g(e);
        }
    }

    public static void b(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            qg9.d(th.getMessage());
        }
    }
}
