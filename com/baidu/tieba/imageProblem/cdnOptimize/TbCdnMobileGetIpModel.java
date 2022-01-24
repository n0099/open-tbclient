package com.baidu.tieba.imageProblem.cdnOptimize;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.d.f.j.a.e;
import c.a.d.f.p.l;
import c.a.d.f.p.t;
import c.a.s0.s.i0.b;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes12.dex */
public class TbCdnMobileGetIpModel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static Object f45386d;

    /* renamed from: e  reason: collision with root package name */
    public static long f45387e;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f45388b;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: c  reason: collision with root package name */
    public final Handler f45389c;

    /* loaded from: classes12.dex */
    public class TBCdnMobileTachometerAsyncTask extends BdAsyncTask<Object, Integer, ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<TBCdnIpData> f45390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbCdnMobileGetIpModel f45391c;

        /* loaded from: classes12.dex */
        public class TBCdnIpData {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public long f45392b;

            public TBCdnIpData(TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tBCdnMobileTachometerAsyncTask};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45391c = tbCdnMobileGetIpModel;
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
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData = this.a;
                if (tBCdnMobileListData != null && (str = tBCdnMobileListData.a) != null && str.length() > 0 && (str2 = this.a.f45395b) != null && str2.length() > 0) {
                    try {
                        String host = new URL(str).getHost();
                        if (host != null && host.length() > 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            Iterator<String> it = this.a.f45396c.iterator();
                            while (true) {
                                i2 = 0;
                                if (!it.hasNext()) {
                                    break;
                                }
                                String next = it.next();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                e eVar = new e();
                                ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
                                eVar.b().s(str);
                                imgHttpClient.getNetDataWithIp(next, host, 1);
                                byte[] bArr = eVar.c().f2919h;
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                if (bArr != null && str2.equalsIgnoreCase(t.d(bArr))) {
                                    i2 = 1;
                                }
                                if (i2 != 0) {
                                    d(next, currentTimeMillis3);
                                }
                            }
                            ArrayList<String> arrayList = new ArrayList<>();
                            while (i2 < this.f45390b.size() && i2 < 4) {
                                arrayList.add(this.f45390b.get(i2).a);
                                i2++;
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
                this.f45391c.g(arrayList);
            }
        }

        public final void d(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
                if (this.f45390b == null) {
                    this.f45390b = new ArrayList<>();
                }
                TBCdnIpData tBCdnIpData = new TBCdnIpData();
                tBCdnIpData.a = str;
                tBCdnIpData.f45392b = j2;
                if (this.f45390b.size() == 0) {
                    this.f45390b.add(tBCdnIpData);
                } else if (this.f45390b.size() > 5) {
                } else {
                    int size = this.f45390b.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.f45390b.size()) {
                            break;
                        } else if (this.f45390b.get(i2).f45392b > j2) {
                            size = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.f45390b.add(size, tBCdnIpData);
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
        f45386d = new Object();
    }

    public TbCdnMobileGetIpModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.f45388b = new HttpMessageListener(this, CmdConfigHttp.MOBILE_CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.1
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                        if (tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData.f45396c.size() > 0) {
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    int i4 = message.what;
                    if (10001 == i4) {
                        this.a.h();
                    } else if (10002 == i4) {
                        this.a.f();
                    }
                }
            }
        };
        this.f45389c = handler;
        handler.sendEmptyMessage(10001);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
            MessageManager.getInstance().unRegisterListener(this.f45388b);
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
            MessageManager.getInstance().unRegisterListener(this.f45388b);
            MessageManager.getInstance().registerListener(this.f45388b);
        }
    }

    public final void i(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tBCdnMobileListData) == null) || tBCdnMobileListData == null) {
            return;
        }
        g(tBCdnMobileListData.f45396c);
        TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask = new TBCdnMobileTachometerAsyncTask(this, tBCdnMobileListData);
        tBCdnMobileTachometerAsyncTask.setPriority(4);
        tBCdnMobileTachometerAsyncTask.execute(new Object[0]);
    }

    public void startGetMobileIpList() {
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !l.H() && TbadkCoreApplication.getInst().isMainProcess(true)) {
            synchronized (f45386d) {
                try {
                    if (0 == f45387e) {
                        f45387e = b.k().m("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", 0L);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (0 == f45387e || currentTimeMillis - f45387e >= 300000) {
                    f45387e = currentTimeMillis;
                    b.k().x("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", currentTimeMillis);
                    this.f45389c.sendEmptyMessage(10002);
                }
            }
        }
    }
}
