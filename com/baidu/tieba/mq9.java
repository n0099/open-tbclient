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
public final class mq9 implements sa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mq9() {
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

    @Override // com.baidu.tieba.sa5
    public ka5 a(String schema) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schema)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            try {
                if (StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) "tbtopicdetail", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) "unidispatch/topicdetail", false, 2, (Object) null)) {
                    String c = du5.c(WebviewHelper.getMatchStringFromURL(schema, "topic_id="), null);
                    ka5 ka5Var = new ka5();
                    ka5Var.c(c);
                    ka5Var.d(true);
                    return ka5Var;
                }
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    e.printStackTrace();
                } else {
                    throw e;
                }
            }
            return new ka5();
        }
        return (ka5) invokeL.objValue;
    }
}
