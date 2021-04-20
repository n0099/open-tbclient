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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imageProblem.cdnOptimize.TbMobileCdnGetIPListHttpResponseMsg;
import d.b.c.e.j.a.e;
import d.b.c.e.p.j;
import d.b.c.e.p.q;
import d.b.h0.r.d0.b;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class TbCdnMobileGetIpModel {

    /* renamed from: d  reason: collision with root package name */
    public static Object f18087d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static long f18088e;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f18089a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f18090b = new HttpMessageListener(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && TbCdnMobileGetIpModel.this.f18089a == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbMobileCdnGetIPListHttpResponseMsg)) {
                boolean z = false;
                TbMobileCdnGetIPListHttpResponseMsg tbMobileCdnGetIPListHttpResponseMsg = (TbMobileCdnGetIPListHttpResponseMsg) httpResponsedMessage;
                TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData = tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData;
                if (tBCdnMobileListData != null) {
                    TbCdnMobileGetIpModel.this.i(tBCdnMobileListData);
                    if (tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData.f18104c.size() > 0) {
                        z = true;
                    }
                }
                ImageLogger.getMobileCDNListError(z, !z ? "list_is_empty" : "");
            }
        }
    };
    @SuppressLint({"HandlerLeak"})

    /* renamed from: c  reason: collision with root package name */
    public final Handler f18091c;

    /* loaded from: classes4.dex */
    public class TBCdnMobileTachometerAsyncTask extends BdAsyncTask<Object, Integer, ArrayList<String>> {

        /* renamed from: a  reason: collision with root package name */
        public TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData f18094a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<TBCdnIpData> f18095b;

        /* loaded from: classes4.dex */
        public class TBCdnIpData {

            /* renamed from: a  reason: collision with root package name */
            public String f18097a;

            /* renamed from: b  reason: collision with root package name */
            public long f18098b;

            public TBCdnIpData(TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask) {
            }
        }

        public TBCdnMobileTachometerAsyncTask(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
            this.f18094a = null;
            this.f18094a = tBCdnMobileListData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<String> doInBackground(Object... objArr) {
            String str;
            String str2;
            int i;
            TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData = this.f18094a;
            if (tBCdnMobileListData != null && (str = tBCdnMobileListData.f18102a) != null && str.length() > 0 && (str2 = this.f18094a.f18103b) != null && str2.length() > 0) {
                try {
                    String host = new URL(str).getHost();
                    if (host != null && host.length() > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Iterator<String> it = this.f18094a.f18104c.iterator();
                        while (true) {
                            i = 0;
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            e eVar = new e();
                            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
                            eVar.b().s(str);
                            imgHttpClient.getNetDataWithIp(next, host, 1);
                            byte[] bArr = eVar.c().f42301h;
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                            if (bArr != null && str2.equalsIgnoreCase(q.d(bArr))) {
                                i = 1;
                            }
                            if (i != 0) {
                                d(next, currentTimeMillis3);
                            }
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        while (i < this.f18095b.size() && i < 4) {
                            arrayList.add(this.f18095b.get(i).f18097a);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<String> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList == null) {
                return;
            }
            TbCdnMobileGetIpModel.this.g(arrayList);
        }

        public final void d(String str, long j) {
            if (this.f18095b == null) {
                this.f18095b = new ArrayList<>();
            }
            TBCdnIpData tBCdnIpData = new TBCdnIpData();
            tBCdnIpData.f18097a = str;
            tBCdnIpData.f18098b = j;
            if (this.f18095b.size() == 0) {
                this.f18095b.add(tBCdnIpData);
            } else if (this.f18095b.size() > 5) {
            } else {
                int size = this.f18095b.size();
                int i = 0;
                while (true) {
                    if (i >= this.f18095b.size()) {
                        break;
                    } else if (this.f18095b.get(i).f18098b > j) {
                        size = i;
                        break;
                    } else {
                        i++;
                    }
                }
                this.f18095b.add(size, tBCdnIpData);
            }
        }
    }

    public TbCdnMobileGetIpModel() {
        Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (10001 == i) {
                    TbCdnMobileGetIpModel.this.h();
                } else if (10002 == i) {
                    TbCdnMobileGetIpModel.this.f();
                }
            }
        };
        this.f18091c = handler;
        handler.sendEmptyMessage(10001);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.f18090b);
    }

    public final void f() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
        httpMessage.addParam("domain", "hiphotos.jomodns.com");
        httpMessage.setTag(this.f18089a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void g(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
        intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY, arrayList);
        intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, true);
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public final void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD, "http://httpdns.baidu.com/ips/v1");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(TbMobileCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.f18090b);
        MessageManager.getInstance().registerListener(this.f18090b);
    }

    public final void i(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
        if (tBCdnMobileListData == null) {
            return;
        }
        g(tBCdnMobileListData.f18104c);
        TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask = new TBCdnMobileTachometerAsyncTask(tBCdnMobileListData);
        tBCdnMobileTachometerAsyncTask.setPriority(4);
        tBCdnMobileTachometerAsyncTask.execute(new Object[0]);
    }

    public void startGetMobileIpList() {
        long currentTimeMillis;
        if (j.H() || !TbadkCoreApplication.getInst().isMainProcess(true)) {
            return;
        }
        synchronized (f18087d) {
            try {
                if (0 == f18088e) {
                    f18088e = b.j().l("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", 0L);
                }
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (0 == f18088e || currentTimeMillis - f18088e >= 300000) {
                f18088e = currentTimeMillis;
                b.j().w("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", currentTimeMillis);
                this.f18091c.sendEmptyMessage(10002);
            }
        }
    }
}
