package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tieba.feed.log.FeedStat;
import com.baidu.tieba.forum.statistic.ForumStatConstant$TabType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class qm7 implements FeedStat.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bundle a;
    public final ForumStatConstant$TabType b;
    public final long c;

    public qm7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.a = bundle;
        this.b = pm7.a(bundle);
        this.c = this.a.getLong("forum_id");
    }

    @Override // com.baidu.tieba.feed.log.FeedStat.a
    public void a(String id, Map<String, String> businessInfo, Map<String, String> logInfo, Map<String, String> runInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, id, businessInfo, logInfo, runInfo) == null) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            Intrinsics.checkNotNullParameter(logInfo, "logInfo");
            Intrinsics.checkNotNullParameter(runInfo, "runInfo");
            um7.a.b(id, businessInfo, this.b, String.valueOf(this.c), JavaTypesHelper.toInt(runInfo.get("get_position"), 0) - 1);
            sm7.a.a(id, businessInfo, logInfo, runInfo);
        }
    }
}
