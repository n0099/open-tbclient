package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.switchs.HeadlinesPrefetchSwitch;
import com.baidu.tieba.forum.component.uistate.CardHeadlinesUiStateKt;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class ze7 extends i47 implements ab7<ze7>, o47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String g;
    public final fz4 h;
    public final String i;
    public final Function2<Context, ze7, Unit> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948357149, "Lcom/baidu/tieba/ze7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948357149, "Lcom/baidu/tieba/ze7;");
        }
    }

    @Override // com.baidu.tieba.ab7
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "head_lines" : (String) invokeV.objValue;
    }

    public ze7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (ze7) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze7(String tid, fz4 taskInfoData, String schema, Map<String, String> businessInfo, Map<String, String> logInfo, Function2<? super Context, ? super ze7, Unit> onRootClick) {
        super(businessInfo, logInfo, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {tid, taskInfoData, schema, businessInfo, logInfo, onRootClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], (Map) objArr2[1], (Function2) objArr2[2], (Function1) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tid, "tid");
        Intrinsics.checkNotNullParameter(taskInfoData, "taskInfoData");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        Intrinsics.checkNotNullParameter(logInfo, "logInfo");
        Intrinsics.checkNotNullParameter(onRootClick, "onRootClick");
        this.g = tid;
        this.h = taskInfoData;
        this.i = schema;
        this.j = onRootClick;
    }

    public /* synthetic */ ze7(String str, fz4 fz4Var, String str2, Map map, Map map2, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fz4Var, str2, map, map2, (i & 32) != 0 ? CardHeadlinesUiStateKt.a : function2);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.ab7
    public /* bridge */ /* synthetic */ ze7 b() {
        l();
        return this;
    }

    public final Function2<Context, ze7, Unit> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final fz4 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (fz4) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o47
    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.h.j() == 4) {
                String r = this.h.r();
                if (HeadlinesPrefetchSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PREFETCH_A) && StringUtils.isNotNull(r)) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("CardHeadlinesUiState", "头条卡，点击frs卡片区域预取, url: " + r);
                    xi6.c(r);
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
