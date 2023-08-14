package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import tbclient.PrivateForumInfo;
/* loaded from: classes8.dex */
public class xq7 implements f65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xq7() {
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

    public static boolean c() {
        InterceptResult invokeV;
        iaa frsResponseData;
        String str;
        boolean z;
        PrivateForumPopInfoData privateForumPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!LooperBlockSwitch.getIsOn() || (frsResponseData = TbSingleton.getInstance().getFrsResponseData()) == null) {
                return false;
            }
            FrsViewData frsViewData = new FrsViewData();
            frsViewData.receiveData(frsResponseData);
            String str2 = null;
            if (frsViewData.getForum() != null) {
                str2 = frsViewData.getForum().getName();
                str = frsViewData.getForum().getId();
            } else {
                str = null;
            }
            if (StringUtils.isNull(str2) || StringUtils.isNull(str)) {
                return false;
            }
            if ((frsViewData.getPrivateForumTotalInfo() == null || frsViewData.getPrivateForumTotalInfo().a() == null || frsViewData.getUserData().getIs_manager() != 1) && frsViewData.getPrivateForumPopInfo() == null) {
                return false;
            }
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.S(frsViewData.getPrivateForumTotalInfo().c());
            PrivateForumInfo a = frsViewData.getPrivateForumTotalInfo().a();
            if (a != null && a.private_forum_status.intValue() == 1 && (bi.isEmpty(privateForumPopInfoData.Q()) || privateForumPopInfoData.P() != JavaTypesHelper.toInt(str, 0))) {
                privateForumPopInfoData.V("create_success");
                privateForumPopInfoData.W(String.format(fp7.h, str, str2));
                privateForumPopInfoData.U(JavaTypesHelper.toInt(str, -1));
                privateForumPopInfoData.setTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16ea));
                privateForumPopInfoData.T(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16eb));
                z = FrsPrivateCommonDialogView.b(privateForumPopInfoData, false);
            } else if (privateForumPopInfoData.P() == JavaTypesHelper.toInt(str, 0)) {
                z = FrsPrivateCommonDialogView.b(privateForumPopInfoData, false);
            } else {
                z = false;
            }
            if (!z && (privateForumPopInfo = frsViewData.getPrivateForumPopInfo()) != null && privateForumPopInfo.P() == JavaTypesHelper.toInt(str, 0)) {
                return FrsPrivateCommonDialogView.b(privateForumPopInfo, true);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f65
    @NonNull
    public Map<String, Object> a(@NonNull DialogStrategiesData dialogStrategiesData, @NonNull Map<String, Object> map, @NonNull Map<String, Object> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogStrategiesData, map, map2)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("dialogName", "frsExam");
            hashMap.putAll(map);
            hashMap.putAll(map2);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.f65
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            return c();
        }
        return invokeL.booleanValue;
    }
}
