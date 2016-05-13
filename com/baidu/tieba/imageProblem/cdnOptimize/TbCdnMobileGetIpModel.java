package com.baidu.tieba.imageProblem.cdnOptimize;

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
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imageProblem.cdnOptimize.TbMobileCdnGetIPListHttpResponseMsg;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbCdnMobileGetIpModel {
    private static Object lock = new Object();
    private static long mobileLastTachometerTime = 0;
    private BdUniqueId unique_id = BdUniqueId.gen();
    private HttpMessageListener cAU = new HttpMessageListener(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.1
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
                v.d(z, str);
            }
        }
    };
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (10001 == message.what) {
                TbCdnMobileGetIpModel.this.amn();
            } else if (10002 == message.what) {
                TbCdnMobileGetIpModel.this.amo();
            }
        }
    };

    public TbCdnMobileGetIpModel() {
        this.handler.sendEmptyMessage(10001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD, "http://httpdns.baidu.com/ips/v1");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(TbMobileCdnGetIPListHttpResponseMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterListener(this.cAU);
        MessageManager.getInstance().registerListener(this.cAU);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
        MessageManager.getInstance().unRegisterListener(this.cAU);
    }

    public void startGetMobileIpList() {
        long currentTimeMillis;
        if (!i.fr() && TbadkCoreApplication.m11getInst().isMainProcess(true)) {
            synchronized (lock) {
                try {
                    if (0 == mobileLastTachometerTime) {
                        mobileLastTachometerTime = b.sR().getLong("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", 0L);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (0 == mobileLastTachometerTime || currentTimeMillis - mobileLastTachometerTime >= 300000) {
                    mobileLastTachometerTime = currentTimeMillis;
                    b.sR().putLong("com.baidu.tbadk.opTimize.mobileLastGetCdnListTiem", currentTimeMillis);
                    this.handler.sendEmptyMessage(10002);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amo() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MOBILE_CDN_IPLIST_CMD);
        httpMessage.addParam("domain", "hiphotos.jomodns.com");
        httpMessage.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TBCdnMobileTachometerAsyncTask extends BdAsyncTask<Object, Integer, ArrayList<String>> {
        TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData cAW;
        ArrayList<TBCdnIpData> ipList;

        public TBCdnMobileTachometerAsyncTask(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
            this.cAW = null;
            this.cAW = tBCdnMobileListData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public ArrayList<String> doInBackground(Object... objArr) {
            String str;
            String str2;
            if (this.cAW == null || (str = this.cAW.cBc) == null || str.length() <= 0 || (str2 = this.cAW.cBd) == null || str2.length() <= 0) {
                return null;
            }
            try {
                String host = new URL(str).getHost();
                if (host != null) {
                    if (host.length() > 0) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            Iterator<String> it = this.cAW.mobileIpList.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                f fVar = new f();
                                com.baidu.tbadk.core.util.a.f fVar2 = new com.baidu.tbadk.core.util.a.f(fVar);
                                fVar.du().setUrl(str);
                                fVar2.d(next, host, 1);
                                byte[] bArr = fVar.dv().lG;
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                boolean z = false;
                                if (bArr != null && str2.equalsIgnoreCase(t.toMd5(bArr))) {
                                    z = true;
                                }
                                if (z) {
                                    l(next, currentTimeMillis3);
                                }
                            }
                            ArrayList<String> arrayList = new ArrayList<>();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.ipList.size() && i2 < 4) {
                                    arrayList.add(this.ipList.get(i2).ip);
                                    i = i2 + 1;
                                }
                            }
                            v.a(arrayList, System.currentTimeMillis() - currentTimeMillis);
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
        /* renamed from: N */
        public void onPostExecute(ArrayList<String> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList == null) {
                return;
            }
            TbCdnMobileGetIpModel.this.M(arrayList);
        }

        private void l(String str, long j) {
            int i;
            if (this.ipList == null) {
                this.ipList = new ArrayList<>();
            }
            TBCdnIpData tBCdnIpData = new TBCdnIpData(this, null);
            tBCdnIpData.ip = str;
            tBCdnIpData.xK = j;
            if (this.ipList.size() == 0) {
                this.ipList.add(tBCdnIpData);
            } else if (this.ipList.size() <= 5) {
                int size = this.ipList.size();
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i < this.ipList.size()) {
                        if (this.ipList.get(i).xK > j) {
                            break;
                        }
                        i2 = i + 1;
                    } else {
                        i = size;
                        break;
                    }
                }
                this.ipList.add(i, tBCdnIpData);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class TBCdnIpData {
            String ip;
            long xK;

            private TBCdnIpData() {
            }

            /* synthetic */ TBCdnIpData(TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask, TBCdnIpData tBCdnIpData) {
                this();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(ArrayList<String> arrayList) {
        if (arrayList != null) {
            Intent intent = new Intent();
            intent.setAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY, arrayList);
            intent.putExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, true);
            TbadkCoreApplication.m11getInst().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbMobileCdnGetIPListHttpResponseMsg.TBCdnMobileListData tBCdnMobileListData) {
        if (tBCdnMobileListData != null) {
            M(tBCdnMobileListData.mobileIpList);
            TBCdnMobileTachometerAsyncTask tBCdnMobileTachometerAsyncTask = new TBCdnMobileTachometerAsyncTask(tBCdnMobileListData);
            tBCdnMobileTachometerAsyncTask.setPriority(4);
            tBCdnMobileTachometerAsyncTask.execute(new Object[0]);
        }
    }
}
