package com.baidu.tieba.interestlabel.statics;

import c.a.r0.k3.e0.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.LabelSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import com.baidu.tieba.interestlabel.activity.LabelSettingActivity;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterestLabelStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1120347296, "Lcom/baidu/tieba/interestlabel/statics/InterestLabelStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1120347296, "Lcom/baidu/tieba/interestlabel/statics/InterestLabelStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(LabelSettingActivityConfig.class, LabelSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(LabelRecommendActivityConfig.class, LabelRecommendActivity.class);
        a();
        b();
    }

    public InterestLabelStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a.h(309467, ResponseSocketGetLabelMessage.class, false, false);
            a.c(309467, CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, TbConfig.URL_GET_INTEREST_LABEL_LIST, ResponseHttpGetLabelMessage.class, false, false, true, false);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            a.h(309468, ResponseSocketSubLabelMessage.class, false, false);
            a.c(309468, CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, TbConfig.URL_SUB_INTEREST_LABEL_LIST, ResponseHttpSubLabelMessage.class, false, false, true, false);
        }
    }
}
