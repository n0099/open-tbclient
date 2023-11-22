package com.baidu.tieba;

import android.content.Context;
import android.database.Cursor;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final long a(DownloadUnifiedManager downloadUnifiedManager, Context context, String downloadTitle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, downloadUnifiedManager, context, downloadTitle)) == null) {
            Intrinsics.checkNotNullParameter(downloadUnifiedManager, "<this>");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(downloadTitle, "downloadTitle");
            Cursor query = context.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "title= ?", new String[]{downloadTitle}, null);
            long j = -1;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        j = query.getLong(query.getColumnIndex("_id"));
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(query, null);
                } finally {
                }
            }
            return j;
        }
        return invokeLLL.longValue;
    }
}
