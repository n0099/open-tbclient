package com.baidu.tieba.recapp.request;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.al8;
import com.repackage.iw4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShowStatisticUploadRequest extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public static final TbHttpMessageTask TASK;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class ResponseMessage extends HttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseMessage(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2137960336, "Lcom/baidu/tieba/recapp/request/ShowStatisticUploadRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2137960336, "Lcom/baidu/tieba/recapp/request/ShowStatisticUploadRequest;");
                return;
            }
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CAD_AD_STATISTIC_UPLOAD, "https://als.baidu.com/flog/logFeed");
        TASK = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(ResponseMessage.class);
        TASK.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        TASK.setIsNeedAddCommenParam(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowStatisticUploadRequest(boolean z) {
        super(CmdConfigHttp.CAD_AD_STATISTIC_UPLOAD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        addParam(AdUploadHttpRequest.KEY_PRODUCT_ID, "2");
        addParam("da_type", z ? "2" : "3");
        addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
        String netType = NetWorkUtil.getNetType();
        if (netType != null) {
            addParam("net_type", netType);
        }
        iw4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        TASK.setUrl((adAdSense == null || adAdSense.d()) ? "https://als.baidu.com/flog/logFeed" : "http://als.baidu.com/flog/logFeed");
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<al8.c> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), str, str2, str3, list, str4}) == null) {
            ShowStatisticUploadRequest init = new ShowStatisticUploadRequest(z).init(1, str, str2, str4);
            init.addParam("fid", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (al8.c cVar : list) {
                    if (cVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", cVar.a);
                            jSONObject.put("locate", cVar.c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                    }
                }
                init.addParam("infos", jSONArray.toString());
            }
            MessageManager.getInstance().sendMessage(init, TASK);
        }
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<al8.c> list, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, list, str5}) == null) {
            ShowStatisticUploadRequest init = new ShowStatisticUploadRequest(z).init(2, str, str2, str5);
            init.addParam("fid", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (al8.c cVar : list) {
                    if (cVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pid", cVar.b);
                            jSONObject.put("tid", str4);
                            jSONObject.put("locate", cVar.c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                    }
                }
                init.addParam("infos", jSONArray.toString());
            }
            MessageManager.getInstance().sendMessage(init, TASK);
        }
    }

    public ShowStatisticUploadRequest init(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            addParam(BdVideoAd.AD_VIDEO_DAPAGE, i == 1 ? "FRS" : "PB");
            addParam("da_menu1", str);
            addParam("da_menu2", str2);
            addParam("ext_info", str3);
            return this;
        }
        return (ShowStatisticUploadRequest) invokeCommon.objValue;
    }
}
