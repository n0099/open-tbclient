package com.baidu.tieba.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.VideoHolyCardResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoHolyCardModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f54262e;

    /* renamed from: f  reason: collision with root package name */
    public long f54263f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f54264g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HttpMessage f54265e;

        public a(VideoHolyCardModel videoHolyCardModel, HttpMessage httpMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoHolyCardModel, httpMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54265e = httpMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(this.f54265e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoHolyCardModel f54266a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoHolyCardModel videoHolyCardModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoHolyCardModel, Integer.valueOf(i2)};
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
            this.f54266a = videoHolyCardModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof VideoHolyCardResponseMessage) && this.f54266a.f54262e != null) {
                this.f54266a.f54262e.onResult(((VideoHolyCardResponseMessage) httpResponsedMessage).isVideoHolyCard);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onResult(boolean z);
    }

    public VideoHolyCardModel() {
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
        this.f54264g = new b(this, CmdConfigHttp.CMD_VIDEO_HOLY_CARD);
        y();
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
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || System.currentTimeMillis() - this.f54263f <= 200) {
            return;
        }
        String clientIP = UtilHelper.getClientIP();
        int networkOperator = UtilHelper.getNetworkOperator();
        String str = networkOperator == 1 ? "CMNET" : networkOperator == 2 ? "UNICOM" : networkOperator == 3 ? "TELECOM" : RomUtils.UNKNOWN;
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            this.f54262e.onResult(false);
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_HOLY_CARD);
        httpMessage.addParam("localip", clientIP);
        httpMessage.addParam("network", str);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new a(this, httpMessage));
        } else {
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        this.f54263f = System.currentTimeMillis();
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_HOLY_CARD, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_HOLY_CARD);
            tbHttpMessageTask.setResponsedClass(VideoHolyCardResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            MessageManager.getInstance().registerListener(this.f54264g);
        }
    }

    public void z(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f54262e = cVar;
        }
    }
}
