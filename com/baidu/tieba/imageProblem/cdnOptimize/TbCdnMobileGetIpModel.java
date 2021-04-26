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
import d.a.c.e.j.a.e;
import d.a.c.e.p.j;
import d.a.c.e.p.q;
import d.a.i0.r.d0.b;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class TbCdnMobileGetIpModel {

    /* renamed from: d  reason: collision with root package name */
    public static Object f18441d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static long f18442e;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f18443a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f18444b = new HttpMessageListener(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && TbCdnMobileGetIpModel.this.f18443a == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbMobileCdnGetIPListHttpResponseMsg)) {
                boolean z = false;
                TbMobileCdnGetIPListHttpResponseMsg tbMobileCdnGetIPListHttpResponseMsg = (TbMobileCdnGetIPListHttpResponseMsg) httpResponsedMessage;
                TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData = tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData;
                if (tBCdnMobileListData != null) {
                    TbCdnMobileGetIpModel.this.i(tBCdnMobileListData);
                    if (tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData.f18458c.size() > 0) {
                        z = true;
                    }
                }
                ImageLogger.getMobileCDNListError(z, !z ? "list_is_empty" : "");
            }
        }
    };
    @SuppressLint({"HandlerLeak"})

    /* renamed from: c  reason: collision with root package name */
    public final Handler f18445c;

    /* loaded from: classes4.dex */
    public class TBCdnMobileTachometerAsyncTask extends BdAsyncTask<Object, Integer, ArrayList<String>> {

        /* renamed from: a  reason: collision with root package name */
        public TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData f18448a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<TBCdnIpData> f18449b;

        /* loaded from: classes4.dex */
        public class TBCdnIpData {

            /* renamed from: a  reason: collision with root package name */
            public String f18451a;

            /* renamed from: b  reason: collision with root package name */
            public long f18452b;

            public TBCdnIpData(TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask) {
            }
        }

        public TBCdnMobileTachometerAsyncTask(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
            this.f18448a = null;
            this.f18448a = tBCdnMobileListData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<String> doInBackground(Object... objArr) {
            String str;
            String str2;
            int i2;
            TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData = this.f18448a;
            if (tBCdnMobileListData != null && (str = tBCdnMobileListData.f18456a) != null && str.length() > 0 && (str2 = this.f18448a.f18457b) != null && str2.length() > 0) {
                try {
                    String host = new URL(str).getHost();
                    if (host != null && host.length() > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Iterator<String> it = this.f18448a.f18458c.iterator();
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
                            byte[] bArr = eVar.c().f39739h;
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                            if (bArr != null && str2.equalsIgnoreCase(q.d(bArr))) {
                                i2 = 1;
                            }
                            if (i2 != 0) {
                                d(next, currentTimeMillis3);
                            }
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        while (i2 < this.f18449b.size() && i2 < 4) {
                            arrayList.add(this.f18449b.get(i2).f18451a);
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
            if (this.f18449b == null) {
                this.f18449b = new ArrayList<>();
            }
            TBCdnIpData tBCdnIpData = new TBCdnIpData();
            tBCdnIpData.f18451a = str;
            tBCdnIpData.f18452b = j;
            if (this.f18449b.size() == 0) {
                this.f18449b.add(tBCdnIpData);
            } else if (this.f18449b.size() > 5) {
            } else {
                int size = this.f18449b.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f18449b.size()) {
                        break;
                    } else if (this.f18449b.get(i2).f18452b > j) {
                        size = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                this.f18449b.add(size, tBCdnIpData);
            }
        }
    }

    public TbCdnMobileGetIpModel() {
        Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i2 = message.what;
                if (10001 == i2) {
                    TbCdnMobileGetIpModel.this.h();
                } else if (10002 == i2) {
                    TbCdnMobileGetIpModel.this.f();
                }
            }
        };
        this.f18445c = handler;
        handler.sendEmptyMessage(10001);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.f18444b);
    }

    public final void f() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
        httpMessage.addParam("domain", "hiphotos.jomodns.com");
        httpMessage.setTag(this.f18443a);
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
        MessageManager.getInstance().unRegisterListener(this.f18444b);
        MessageManager.getInstance().registerListener(this.f18444b);
    }

    public final void i(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
        if (tBCdnMobileListData == null) {
            return;
        }
        g(tBCdnMobileListData.f18458c);
        TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask = new TBCdnMobileTachometerAsyncTask(tBCdnMobileListData);
        tBCdnMobileTachometerAsyncTask.setPriority(4);
        tBCdnMobileTachometerAsyncTask.execute(new Object[0]);
    }

    public void startGetMobileIpList() {
        long currentTimeMillis;
        if (j.H() || !TbadkCoreApplication.getInst().isMainProcess(true)) {
            return;
        }
        synchronized (f18441d) {
            try {
                if (0 == f18442e) {
                    f18442e = b.j().l("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", 0L);
                }
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (0 == f18442e || currentTimeMillis - f18442e >= 300000) {
                f18442e = currentTimeMillis;
                b.j().w("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", currentTimeMillis);
                this.f18445c.sendEmptyMessage(10002);
            }
        }
    }
}
