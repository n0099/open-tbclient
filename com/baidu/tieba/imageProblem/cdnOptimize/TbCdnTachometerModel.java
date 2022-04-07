package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.jc5;
import com.repackage.of;
import com.repackage.ui;
/* loaded from: classes3.dex */
public class TbCdnTachometerModel<T> extends BdBaseModel<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IPLIST_ADDRESS;
    public static final String IPLIST_ADDRESS_PATH = "c/s/checkcdn";
    public transient /* synthetic */ FieldHolder $fh;
    public TbCdnTachometerModelCallBack a;
    public HttpMessageListener b;

    /* loaded from: classes3.dex */
    public interface TbCdnTachometerModelCallBack {
        void callBack(TbCdnIpListData tbCdnIpListData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1129908901, "Lcom/baidu/tieba/imageProblem/cdnOptimize/TbCdnTachometerModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1129908901, "Lcom/baidu/tieba/imageProblem/cdnOptimize/TbCdnTachometerModel;");
                return;
            }
        }
        IPLIST_ADDRESS = TbConfig.SERVER_ADDRESS + IPLIST_ADDRESS_PATH;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbCdnTachometerModel(TbPageContext<T> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new HttpMessageListener(this, CmdConfigHttp.CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbCdnTachometerModel a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String str;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && this.a.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                    TbCdnIpListData tbCdnIpListData = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                    int i3 = -1;
                    boolean z = false;
                    boolean z2 = true;
                    if (httpResponsedMessage.getError() != 0 || tbCdnIpListData == null || tbCdnIpListData.a != 0) {
                        if (this.a.a != null) {
                            i3 = httpResponsedMessage.getError();
                            String errorString = httpResponsedMessage.getErrorString();
                            if (httpResponsedMessage.getError() == 0) {
                                i3 = tbCdnIpListData.a;
                                str = tbCdnIpListData.b;
                                ImageLogger.getCDNListError(z, z2, String.valueOf(i3), str);
                            }
                            str = errorString;
                            z2 = false;
                            ImageLogger.getCDNListError(z, z2, String.valueOf(i3), str);
                        }
                    } else {
                        if (this.a.a != null) {
                            this.a.a.callBack(tbCdnIpListData);
                        }
                        if (tbCdnIpListData.e.size() == 0) {
                            str = "noList";
                            z = true;
                            z2 = false;
                            ImageLogger.getCDNListError(z, z2, String.valueOf(i3), str);
                        }
                    }
                    str = "";
                    z = true;
                    z2 = false;
                    ImageLogger.getCDNListError(z, z2, String.valueOf(i3), str);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CDN_IPLIST_CMD, IPLIST_ADDRESS);
        tbHttpMessageTask.setResponsedClass(TbCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.b);
        MessageManager.getInstance().registerListener(this.b);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CDN_IPLIST_CMD);
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    public void getCDNIPList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CDN_IPLIST_CMD));
        }
    }

    public boolean getTestImageData(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        String str5;
        String str6;
        boolean z2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (str == null || str2 == null || str3 == null || str4 == null || !jc5.b(str)) {
                return false;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                of ofVar = new of();
                ImgHttpClient imgHttpClient = new ImgHttpClient(ofVar);
                ofVar.b().t(str);
                boolean z3 = true;
                imgHttpClient.getNetDataWithIp(str2, str3, 1);
                byte[] bArr = ofVar.c().i;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (ofVar.c().b != 200) {
                    z3 = false;
                }
                String str7 = "";
                if (!z3) {
                    str5 = "NETError_" + ofVar.c().b + "-" + (ofVar.a() != null ? ofVar.a().h : null);
                } else if (bArr != null) {
                    i = bArr.length;
                    String d = ui.d(bArr);
                    if (!str4.equalsIgnoreCase(d)) {
                        String str8 = "MD5Error_" + d + "_" + str4;
                        if (ofVar.a() != null && ofVar.a().h != null && ofVar.a().h.length() != 0) {
                            str8 = str8 + ":" + ofVar.c().b + "-" + ofVar.a().h;
                            ofVar.f(null);
                        }
                        str7 = str8;
                        z3 = false;
                    }
                    str6 = str7;
                    z2 = z3;
                    ImageLogger.tachometerCdnIpLog(z2, str, str2, "0", str6, String.valueOf(i), currentTimeMillis2, z);
                    return z2;
                } else {
                    str5 = "downSizeZero";
                    if (ofVar.a() != null && ofVar.a().h != null && ofVar.a().h.length() != 0) {
                        str5 = "downSizeZero:" + ofVar.c().b + "-" + ofVar.a().h;
                        ofVar.f(null);
                    }
                }
                str6 = str5;
                z2 = z3;
                i = 0;
                ImageLogger.tachometerCdnIpLog(z2, str, str2, "0", str6, String.valueOf(i), currentTimeMillis2, z);
                return z2;
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(DealIntentService.KEY_CLASS);
                stringBuffer.append(e.getClass());
                stringBuffer.append(" message");
                stringBuffer.append(e.getMessage());
                ImageLogger.tachometerCdnIpLog(false, str, str2, "-1", stringBuffer.toString(), "0", 0L, z);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setCndTachometerModelCallBack(TbCdnTachometerModelCallBack tbCdnTachometerModelCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbCdnTachometerModelCallBack) == null) {
            this.a = tbCdnTachometerModelCallBack;
        }
    }
}
