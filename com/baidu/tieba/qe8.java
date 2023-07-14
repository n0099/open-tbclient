package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.uz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class qe8 implements uz4.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.uz4.c
    @NonNull
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "personCenter.openNativeSendGifts" : (String) invokeV.objValue;
    }

    public qe8() {
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

    @Override // com.baidu.tieba.uz4.c
    public void a(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("uid");
                String optString2 = jSONObject.optString("name");
                String optString3 = jSONObject.optString("nameShow");
                jSONObject.optString("scene");
                GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), wg.g(optString, 0L), optString2, optString3, GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
                giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
            } catch (Exception e) {
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.c("NativeSendGiftHybridNotify", "发送私聊图片消息失败" + e);
            }
        }
    }
}
