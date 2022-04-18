package com.baidu.tieba.imageProblem.cdnOptimize;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imageProblem.cdnOptimize.TbMobileCdnGetIPListHttpResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mi;
import com.repackage.of;
import com.repackage.ui;
import com.repackage.vt4;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class TbCdnMobileGetIpModel {
    public static /* synthetic */ Interceptable $ic;
    public static Object d;
    public static long e;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public HttpMessageListener b;
    @SuppressLint({"HandlerLeak"})
    public final Handler c;

    /* loaded from: classes3.dex */
    public class TBCdnMobileTachometerAsyncTask extends BdAsyncTask<Object, Integer, ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData a;
        public ArrayList<TBCdnIpData> b;
        public final /* synthetic */ TbCdnMobileGetIpModel c;

        /* loaded from: classes3.dex */
        public class TBCdnIpData {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;
            public long b;

            public TBCdnIpData(TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tBCdnMobileTachometerAsyncTask};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public TBCdnMobileTachometerAsyncTask(TbCdnMobileGetIpModel tbCdnMobileGetIpModel, TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCdnMobileGetIpModel, tBCdnMobileListData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbCdnMobileGetIpModel;
            this.a = null;
            this.a = tBCdnMobileListData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<String> doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String str;
            String str2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData = this.a;
                if (tBCdnMobileListData != null && (str = tBCdnMobileListData.a) != null && str.length() > 0 && (str2 = this.a.b) != null && str2.length() > 0) {
                    try {
                        String host = new URL(str).getHost();
                        if (host != null && host.length() > 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            Iterator<String> it = this.a.c.iterator();
                            while (true) {
                                i = 0;
                                if (!it.hasNext()) {
                                    break;
                                }
                                String next = it.next();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                of ofVar = new of();
                                ImgHttpClient imgHttpClient = new ImgHttpClient(ofVar);
                                ofVar.b().t(str);
                                imgHttpClient.getNetDataWithIp(next, host, 1);
                                byte[] bArr = ofVar.c().i;
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                if (bArr != null && str2.equalsIgnoreCase(ui.d(bArr))) {
                                    i = 1;
                                }
                                if (i != 0) {
                                    d(next, currentTimeMillis3);
                                }
                            }
                            ArrayList<String> arrayList = new ArrayList<>();
                            while (i < this.b.size() && i < 4) {
                                arrayList.add(this.b.get(i).a);
                                i++;
                            }
                            ImageLogger.mobileTachometerLoger(arrayList, System.currentTimeMillis() - currentTimeMillis);
                            return arrayList;
                        }
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (ArrayList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList == null) {
                    return;
                }
                this.c.g(arrayList);
            }
        }

        public final void d(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                TBCdnIpData tBCdnIpData = new TBCdnIpData();
                tBCdnIpData.a = str;
                tBCdnIpData.b = j;
                if (this.b.size() == 0) {
                    this.b.add(tBCdnIpData);
                } else if (this.b.size() > 5) {
                } else {
                    int size = this.b.size();
                    int i = 0;
                    while (true) {
                        if (i >= this.b.size()) {
                            break;
                        } else if (this.b.get(i).b > j) {
                            size = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    this.b.add(size, tBCdnIpData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1000311856, "Lcom/baidu/tieba/imageProblem/cdnOptimize/TbCdnMobileGetIpModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1000311856, "Lcom/baidu/tieba/imageProblem/cdnOptimize/TbCdnMobileGetIpModel;");
                return;
            }
        }
        d = new Object();
    }

    public TbCdnMobileGetIpModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.b = new HttpMessageListener(this, CmdConfigHttp.MOBILE_CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbCdnMobileGetIpModel a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
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
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && this.a.a == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbMobileCdnGetIPListHttpResponseMsg)) {
                    boolean z = false;
                    TbMobileCdnGetIPListHttpResponseMsg tbMobileCdnGetIPListHttpResponseMsg = (TbMobileCdnGetIPListHttpResponseMsg) httpResponsedMessage;
                    TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData = tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData;
                    if (tBCdnMobileListData != null) {
                        this.a.i(tBCdnMobileListData);
                        if (tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData.c.size() > 0) {
                            z = true;
                        }
                    }
                    ImageLogger.getMobileCDNListError(z, !z ? "list_is_empty" : "");
                }
            }
        };
        Handler handler = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbCdnMobileGetIpModel a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    int i3 = message.what;
                    if (10001 == i3) {
                        this.a.h();
                    } else if (10002 == i3) {
                        this.a.f();
                    }
                }
            }
        };
        this.c = handler;
        handler.sendEmptyMessage(10001);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
            httpMessage.addParam("domain", "hiphotos.jomodns.com");
            httpMessage.setTag(this.a);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void g(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) || arrayList == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
        intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY, arrayList);
        intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, true);
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD, "http://httpdns.baidu.com/ips/v1");
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            tbHttpMessageTask.setResponsedClass(TbMobileCdnGetIPListHttpResponseMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().registerListener(this.b);
        }
    }

    public final void i(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tBCdnMobileListData) == null) || tBCdnMobileListData == null) {
            return;
        }
        g(tBCdnMobileListData.c);
        TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask = new TBCdnMobileTachometerAsyncTask(this, tBCdnMobileListData);
        tBCdnMobileTachometerAsyncTask.setPriority(4);
        tBCdnMobileTachometerAsyncTask.execute(new Object[0]);
    }

    public void startGetMobileIpList() {
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !mi.H() && TbadkCoreApplication.getInst().isMainProcess(true)) {
            synchronized (d) {
                try {
                    if (0 == e) {
                        e = vt4.k().m("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", 0L);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (0 == e || currentTimeMillis - e >= 300000) {
                    e = currentTimeMillis;
                    vt4.k().x("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", currentTimeMillis);
                    this.c.sendEmptyMessage(10002);
                }
            }
        }
    }
}
