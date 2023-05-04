package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedEntrybarComponent;
/* loaded from: classes6.dex */
public final class uz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedEntrybarComponent feedEntrybarComponent, List<s17<? extends Object>> mutableList, lz6 lz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedEntrybarComponent, mutableList, lz6Var) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            mutableList.add(b(feedEntrybarComponent, lz6Var));
        }
    }

    public static final nx6 b(FeedEntrybarComponent feedEntrybarComponent, lz6 lz6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, feedEntrybarComponent, lz6Var)) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            String text = feedEntrybarComponent.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            String schema = feedEntrybarComponent.schema;
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            return new nx6(text, schema, null, lz6Var, 4, null);
        }
        return (nx6) invokeLL.objValue;
    }
}
