package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedEntrybarComponent;
/* loaded from: classes7.dex */
public final class q67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedEntrybarComponent feedEntrybarComponent, List<o87<? extends Object>> mutableList, h67 h67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedEntrybarComponent, mutableList, h67Var) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            mutableList.add(b(feedEntrybarComponent, h67Var));
        }
    }

    public static final j47 b(FeedEntrybarComponent feedEntrybarComponent, h67 h67Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, feedEntrybarComponent, h67Var)) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            String text = feedEntrybarComponent.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            String schema = feedEntrybarComponent.schema;
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            return new j47(text, schema, null, h67Var, 4, null);
        }
        return (j47) invokeLL.objValue;
    }
}
