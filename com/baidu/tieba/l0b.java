package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l0b extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0b(MainTabActivity mainTabActivity, eza ezaVar) {
        super(2005016);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ezaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String tempString = TbSingleton.getInstance().getTempString(TbSingleton.TEMP_STRING_KEY_INTEREST_FORUM);
            if (!TextUtils.isEmpty(tempString)) {
                SharedPrefHelper.getInstance().remove("user_interest_info");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
                httpMessage.addParam("interestList", tempString);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(httpMessage);
                TbSingleton.getInstance().removeTempString(TbSingleton.TEMP_STRING_KEY_INTEREST_FORUM);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            this.a.o = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            SharedPrefHelper.getInstance().remove("key_feedback_tip");
            SharedPrefHelper.getInstance().remove("key_feedback_tip_show");
            SharedPrefHelper.getInstance().remove("key_feedback_tip_tab_show");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            this.a.t1();
            g();
            jb5.f();
        }
    }
}
