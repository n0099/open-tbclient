package com.baidu.tieba;

import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Service
/* loaded from: classes7.dex */
public final class l99 implements p95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l99() {
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

    @Override // com.baidu.tieba.p95
    public h95 a(String schema) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schema)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            try {
                if (StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) "tbtopicdetail", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) "unidispatch/topicdetail", false, 2, (Object) null)) {
                    String c = wr5.c(WebviewHelper.getMatchStringFromURL(schema, "topic_id="), null);
                    h95 h95Var = new h95();
                    h95Var.c(c);
                    h95Var.d(true);
                    return h95Var;
                }
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    e.printStackTrace();
                } else {
                    throw e;
                }
            }
            return new h95();
        }
        return (h95) invokeL.objValue;
    }
}
