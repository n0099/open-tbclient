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
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.b.f;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imageProblem.cdnOptimize.TbMobileCdnGetIPListHttpResponseMsg;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class TbCdnMobileGetIpModel {
    private static Object lock = new Object();
    private static long mobileLastTachometerTime = 0;
    private BdUniqueId unique_id = BdUniqueId.gen();
    private HttpMessageListener kOx = new HttpMessageListener(1002601) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && TbCdnMobileGetIpModel.this.unique_id == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbMobileCdnGetIPListHttpResponseMsg)) {
                boolean z = false;
                TbMobileCdnGetIPListHttpResponseMsg tbMobileCdnGetIPListHttpResponseMsg = (TbMobileCdnGetIPListHttpResponseMsg) httpResponsedMessage;
                if (tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData != null) {
                    TbCdnMobileGetIpModel.this.a(tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData);
                    if (tbMobileCdnGetIPListHttpResponseMsg.mobileCdnData.mobileIpList.size() > 0) {
                        z = true;
                    }
                }
                String str = "";
                if (!z) {
                    str = "list_is_empty";
                }
                t.o(z, str);
            }
        }
    };
    @SuppressLint({"HandlerLeak"})
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (10001 == message.what) {
                TbCdnMobileGetIpModel.this.cYz();
            } else if (10002 == message.what) {
                TbCdnMobileGetIpModel.this.cYA();
            }
        }
    };

    public TbCdnMobileGetIpModel() {
        this.handler.sendEmptyMessage(10001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002601, "http://httpdns.baidu.com/ips/v1");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(TbMobileCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.kOx);
        MessageManager.getInstance().registerListener(this.kOx);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1002601);
        MessageManager.getInstance().unRegisterListener(this.kOx);
    }

    public void startGetMobileIpList() {
        long currentTimeMillis;
        if (!j.isWifiNet() && TbadkCoreApplication.getInst().isMainProcess(true)) {
            synchronized (lock) {
                try {
                    if (0 == mobileLastTachometerTime) {
                        mobileLastTachometerTime = b.brx().getLong("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", 0L);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (0 == mobileLastTachometerTime || currentTimeMillis - mobileLastTachometerTime >= 300000) {
                    mobileLastTachometerTime = currentTimeMillis;
                    b.brx().putLong("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", currentTimeMillis);
                    this.handler.sendEmptyMessage(10002);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYA() {
        HttpMessage httpMessage = new HttpMessage(1002601);
        httpMessage.addParam("domain", "hiphotos.jomodns.com");
        httpMessage.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class TBCdnMobileTachometerAsyncTask extends BdAsyncTask<Object, Integer, ArrayList<String>> {
        ArrayList<TBCdnIpData> ipList;
        TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData kOz;

        public TBCdnMobileTachometerAsyncTask(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
            this.kOz = null;
            this.kOz = tBCdnMobileListData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ArrayList<String> doInBackground(Object... objArr) {
            String str;
            String str2;
            if (this.kOz == null || (str = this.kOz.kOE) == null || str.length() <= 0 || (str2 = this.kOz.kOF) == null || str2.length() <= 0) {
                return null;
            }
            try {
                String host = new URL(str).getHost();
                if (host != null) {
                    if (host.length() > 0) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            Iterator<String> it = this.kOz.mobileIpList.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                e eVar = new e();
                                f fVar = new f(eVar);
                                eVar.lV().setUrl(str);
                                fVar.q(next, host, 1);
                                byte[] bArr = eVar.lW().retBytes;
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                boolean z = false;
                                if (bArr != null && str2.equalsIgnoreCase(s.toMd5(bArr))) {
                                    z = true;
                                }
                                if (z) {
                                    N(next, currentTimeMillis3);
                                }
                            }
                            ArrayList<String> arrayList = new ArrayList<>();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.ipList.size() || i2 >= 4) {
                                    break;
                                }
                                arrayList.add(this.ipList.get(i2).ip);
                                i = i2 + 1;
                            }
                            t.a(arrayList, System.currentTimeMillis() - currentTimeMillis);
                            return arrayList;
                        } catch (Exception e) {
                            return null;
                        }
                    }
                }
                return null;
            } catch (Exception e2) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public void onPostExecute(ArrayList<String> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList != null) {
                TbCdnMobileGetIpModel.this.aH(arrayList);
            }
        }

        private void N(String str, long j) {
            int i;
            if (this.ipList == null) {
                this.ipList = new ArrayList<>();
            }
            TBCdnIpData tBCdnIpData = new TBCdnIpData();
            tBCdnIpData.ip = str;
            tBCdnIpData.costTime = j;
            if (this.ipList.size() == 0) {
                this.ipList.add(tBCdnIpData);
            } else if (this.ipList.size() <= 5) {
                int size = this.ipList.size();
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= this.ipList.size()) {
                        i = size;
                        break;
                    } else if (this.ipList.get(i).costTime > j) {
                        break;
                    } else {
                        i2 = i + 1;
                    }
                }
                this.ipList.add(i, tBCdnIpData);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public class TBCdnIpData {
            long costTime;
            String ip;

            private TBCdnIpData() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(ArrayList<String> arrayList) {
        if (arrayList != null) {
            Intent intent = new Intent();
            intent.setAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY, arrayList);
            intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, true);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
        if (tBCdnMobileListData != null) {
            aH(tBCdnMobileListData.mobileIpList);
            TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask = new TBCdnMobileTachometerAsyncTask(tBCdnMobileListData);
            tBCdnMobileTachometerAsyncTask.setPriority(4);
            tBCdnMobileTachometerAsyncTask.execute(new Object[0]);
        }
    }
}
