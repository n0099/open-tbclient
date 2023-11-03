package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedEntrybarComponent;
/* loaded from: classes7.dex */
public final class o87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedEntrybarComponent feedEntrybarComponent, List<za7<? extends Object>> mutableList, m77 m77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedEntrybarComponent, mutableList, m77Var) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            mutableList.add(b(feedEntrybarComponent, m77Var));
        }
    }

    public static final v37 b(FeedEntrybarComponent feedEntrybarComponent, m77 m77Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, feedEntrybarComponent, m77Var)) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            String text = feedEntrybarComponent.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            String schema = feedEntrybarComponent.schema;
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            return new v37(text, schema, null, m77Var, 4, null);
        }
        return (v37) invokeLL.objValue;
    }
}
