package com.baidu.tieba.livesdk.share.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.livesdk.share.message.AlaShareInBarResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class AlaShareInBarModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f53882e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f53883f;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaShareInBarModel f53884a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaShareInBarModel alaShareInBarModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaShareInBarModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53884a = alaShareInBarModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof AlaShareInBarResponsedMessage)) {
                AlaShareInBarResponsedMessage alaShareInBarResponsedMessage = (AlaShareInBarResponsedMessage) httpResponsedMessage;
                String str = "live share callback errorcode: " + alaShareInBarResponsedMessage.getError();
                String str2 = "live share callback error string: " + alaShareInBarResponsedMessage.getErrorString();
                if (this.f53884a.f53882e != null) {
                    this.f53884a.f53882e.a(alaShareInBarResponsedMessage.getError(), alaShareInBarResponsedMessage.getErrorString(), alaShareInBarResponsedMessage.getShareInBarData());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2, String str, c.a.q0.r1.l.b.a aVar);
    }

    public AlaShareInBarModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53883f = new a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
        x();
        MessageManager.getInstance().registerListener(this.f53883f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
            MessageManager.getInstance().unRegisterListener(this.f53883f);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_LIVE_SHARE_IN_BAR);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(AlaShareInBarResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
            if (TextUtils.isEmpty(str2)) {
                httpMessage.addParam("live_id", str);
            } else {
                httpMessage.addParam(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID, str2);
            }
            httpMessage.addParam("forum_ids", str3);
            httpMessage.addParam("content", str4);
            String str5 = "request live share params: \nlive_id: " + str + StringUtils.LF + "yy_anchor_bduid: " + str2 + StringUtils.LF + "forum_ids: " + str3 + StringUtils.LF + "content: " + str4;
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void z(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f53882e = bVar;
        }
    }
}
