package com.baidu.tieba.imageProblem.cdnOptimize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import d.a.c.e.m.b;
import d.a.c.e.m.f;
import d.a.c.e.p.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes4.dex */
public class TbCDNTachometerService extends BdBaseService {
    public static final String LAST_GETCDNLIST_TIME = "com.baidu.tbadk.opTimize.lastGetCdnListTiem";
    public static final long TACHOMETER_INTERVAL = 300000;
    public static final String TB_CDNIP_BROADCASE_ACTION = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastAction";
    public static final String TB_CDNIP_BROADCASE_ISMOBILE = "com.baidu.tbadk.opTimize.ismobile";
    public static final String TB_CDNIP_BROADCASE_KEY = "com.baidu.tbadk.opTimize.cdnIpBroadCast";
    public static final String TB_CDNIP_BROADCASE_NEED_USEIP = "com.baidu.tbadk.opTimize.cdnipBroadCastNeedUseIp";
    public static final String TB_CDNIP_BROADCASE_NUM = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastNum";
    public static long lastTachometerTime;
    public static Object lock = new Object();
    public final long TACHOMETER_MAXTIME = 60000;
    public final int TIMER_MSG_KEY = 1002;
    public TbCdnTachometerModel cdnTachometerModel = null;
    public ArrayList<String> optimalIpList = new ArrayList<>();
    public ArrayList<String> belowOnePointFiveIpList = new ArrayList<>();
    public boolean isNormal = false;
    public BdUniqueId mId = BdUniqueId.gen();
    public int returnRequestNum = 0;
    public HashMap<String, ArrayList<String>> cdnIpMap = new HashMap<>();
    public int startID = 0;
    public final String cdnHiPhotosDomain = "c.hiphotos.baidu.com";
    public int hiPhotosMaxTime = 3000;
    public boolean canBroadCast = false;
    public boolean isBroadFirstIp = false;
    public final int TB_CDN_MIN_IP_INTERVAL = 2000;
    public long lastNotifyIpTime = 0;
    public int lastNotifyIpCount = 0;
    public int numOfThrowIp = 0;
    public CustomMessageListener customNormalListener = new CustomMessageListener(2017000) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                try {
                    CustomMsgData customMsgData = (CustomMsgData) customResponsedMessage.getData();
                    if (customMsgData == null) {
                        return;
                    }
                    String str = customMsgData.f17730e;
                    boolean z = customMsgData.f17728c;
                    long j = customMsgData.f17729d;
                    String valueOf = String.valueOf(j);
                    int i2 = 0;
                    if (customMsgData.f17733h != null && customMsgData.f17733h.length() > 0) {
                        TbCDNTachometerService.this.canBroadCast = true;
                        if (!z || j > TbCDNTachometerService.this.hiPhotosMaxTime) {
                            TbCDNTachometerService.this.isNormal = false;
                        }
                    }
                    if (z) {
                        if (j <= 200 && str != null && str.length() != 0) {
                            ArrayList arrayList = (ArrayList) TbCDNTachometerService.this.cdnIpMap.get(str);
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                TbCDNTachometerService.this.optimalIpList.add((String) arrayList.get(i3));
                            }
                        }
                        if (j <= 1500 && str != null && str.length() != 0) {
                            ArrayList arrayList2 = (ArrayList) TbCDNTachometerService.this.cdnIpMap.get(str);
                            if (TbCDNTachometerService.this.belowOnePointFiveIpList.size() > 0) {
                                int i4 = 0;
                                int i5 = 0;
                                while (true) {
                                    if (i4 >= TbCDNTachometerService.this.belowOnePointFiveIpList.size()) {
                                        i4 = i5;
                                        break;
                                    }
                                    String[] split = ((String) TbCDNTachometerService.this.belowOnePointFiveIpList.get(i4)).split("_");
                                    if (split.length >= 2) {
                                        if (b.f(split[1], 0L) > j) {
                                            break;
                                        }
                                        i5 = i4 + 1;
                                    }
                                    i4++;
                                }
                                if (i4 <= TbCDNTachometerService.this.belowOnePointFiveIpList.size()) {
                                    while (i2 < arrayList2.size()) {
                                        TbCDNTachometerService.this.belowOnePointFiveIpList.add(i4, ((String) arrayList2.get(i2)) + "_" + valueOf);
                                        i2++;
                                    }
                                }
                            } else {
                                while (i2 < arrayList2.size()) {
                                    TbCDNTachometerService.this.belowOnePointFiveIpList.add(((String) arrayList2.get(i2)) + "_" + valueOf);
                                    i2++;
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            TbCDNTachometerService.this.returnRequestNum++;
            TbCDNTachometerService.this.judgeIsBroadcastCdnIp();
        }
    };
    @SuppressLint({"HandlerLeak"})
    public final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (1002 == message.what) {
                TbCDNTachometerService.this.BroadcastCdnIp();
            }
        }
    };
    public final TbCdnTachometerModel.TbCdnTachometerModelCallBack tachometerModelCallBack = new TbCdnTachometerModel.TbCdnTachometerModelCallBack() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.3
        @Override // com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.TbCdnTachometerModelCallBack
        public void callBack(TbCdnIpListData tbCdnIpListData) {
            if (tbCdnIpListData == null) {
                return;
            }
            TbCDNTachometerService.this.startTachometer(tbCdnIpListData);
        }
    };

    /* loaded from: classes4.dex */
    public class CustomMsgData {

        /* renamed from: a  reason: collision with root package name */
        public TbCdnIpListData f17726a;

        /* renamed from: b  reason: collision with root package name */
        public int f17727b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17728c;

        /* renamed from: d  reason: collision with root package name */
        public long f17729d;

        /* renamed from: e  reason: collision with root package name */
        public String f17730e;

        /* renamed from: f  reason: collision with root package name */
        public TbCdnTachometerModel f17731f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17732g = false;

        /* renamed from: h  reason: collision with root package name */
        public String f17733h = null;

        public CustomMsgData(TbCdnIpListData tbCdnIpListData, int i2) {
            this.f17726a = tbCdnIpListData;
            this.f17727b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BroadcastCdnIp() {
        int i2;
        if (this.canBroadCast) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (this.optimalIpList.size() >= 5) {
                int size = this.optimalIpList.size();
                i2 = size <= 5 ? size : 5;
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayList.add(this.optimalIpList.get(i3));
                }
            } else if (this.belowOnePointFiveIpList.size() > 0) {
                int size2 = this.belowOnePointFiveIpList.size();
                i2 = size2 <= 5 ? size2 : 5;
                for (int i4 = 0; i4 < i2; i4++) {
                    try {
                        arrayList.add(this.belowOnePointFiveIpList.get(i4).split("_")[0]);
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
            }
            broadCastAndStopSelf(arrayList);
        }
    }

    private void breakUpIpList(ArrayList<ArrayList<String>> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            int i2 = size / 2;
            Random random = new Random();
            for (int i3 = 0; i3 < i2; i3++) {
                int nextInt = random.nextInt(size);
                if (nextInt < size) {
                    arrayList.set(i3, arrayList.get(nextInt));
                    arrayList.set(nextInt, arrayList.get(i3));
                }
            }
        }
    }

    private void broadCast(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.numOfThrowIp++;
        intent.setAction(TB_CDNIP_BROADCASE_ACTION);
        intent.putExtra(TB_CDNIP_BROADCASE_KEY, arrayList);
        intent.putExtra(TB_CDNIP_BROADCASE_NEED_USEIP, !this.isNormal);
        intent.putExtra(TB_CDNIP_BROADCASE_NUM, this.numOfThrowIp);
        intent.putExtra(TB_CDNIP_BROADCASE_ISMOBILE, false);
        sendBroadcast(intent);
    }

    private void broadCastAndStopSelf(ArrayList<String> arrayList) {
        MessageManager.getInstance().removeMessage(this.mId);
        this.handler.removeMessages(1002);
        broadCast(arrayList);
        stopSelfResult(this.startID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeIsBroadcastCdnIp() {
        if (!this.isBroadFirstIp && this.belowOnePointFiveIpList.size() > 0) {
            this.isBroadFirstIp = true;
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.belowOnePointFiveIpList.get(0).split("_")[0]);
            broadCast(arrayList);
        }
        if (this.optimalIpList.size() >= 5) {
            BroadcastCdnIp();
        } else if (this.returnRequestNum >= this.cdnIpMap.size()) {
            BroadcastCdnIp();
        } else if (this.lastNotifyIpCount < this.optimalIpList.size() && System.currentTimeMillis() - this.lastNotifyIpTime >= 2000) {
            int i2 = this.lastNotifyIpCount;
            this.lastNotifyIpCount = this.optimalIpList.size();
            this.lastNotifyIpTime = System.currentTimeMillis();
            if (i2 != 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                int size = this.optimalIpList.size();
                int i3 = size <= 5 ? size : 5;
                for (int i4 = 0; i4 < i3; i4++) {
                    arrayList2.add(this.optimalIpList.get(i4));
                }
                broadCast(arrayList2);
            }
        }
    }

    private void registerListener() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTachometer(TbCdnIpListData tbCdnIpListData) {
        this.numOfThrowIp = 0;
        if (tbCdnIpListData != null && tbCdnIpListData.f17735a == 0) {
            if (!tbCdnIpListData.f17740f) {
                broadCastAndStopSelf(null);
                return;
            } else if (tbCdnIpListData.f17739e.size() == 0) {
                broadCastAndStopSelf(null);
                return;
            } else {
                breakUpIpList(tbCdnIpListData.f17739e);
                String str = tbCdnIpListData.f17737c;
                String str2 = tbCdnIpListData.f17741g;
                String str3 = tbCdnIpListData.f17738d;
                if (str == null || str2 == null || str3 == null) {
                    return;
                }
                int size = tbCdnIpListData.f17739e.size();
                if (size > 0) {
                    CustomMsgData customMsgData = new CustomMsgData(tbCdnIpListData, 0);
                    customMsgData.f17731f = this.cdnTachometerModel;
                    customMsgData.f17732g = this.isNormal;
                    customMsgData.f17733h = "c.hiphotos.baidu.com";
                    CustomMessage customMessage = new CustomMessage(2017000, customMsgData);
                    customMessage.setTag(this.mId);
                    MessageManager.getInstance().sendMessage(customMessage);
                }
                for (int i2 = 0; i2 < size; i2++) {
                    ArrayList<String> arrayList = tbCdnIpListData.f17739e.get(i2);
                    String str4 = arrayList.size() > 0 ? arrayList.get(0) : "";
                    if (!this.cdnIpMap.containsKey(str4)) {
                        this.cdnIpMap.put(str4, arrayList);
                    }
                    CustomMsgData customMsgData2 = new CustomMsgData(tbCdnIpListData, i2);
                    customMsgData2.f17731f = this.cdnTachometerModel;
                    customMsgData2.f17732g = this.isNormal;
                    CustomMessage customMessage2 = new CustomMessage(2017000, customMsgData2);
                    customMessage2.setTag(this.mId);
                    MessageManager.getInstance().sendMessage(customMessage2);
                }
                return;
            }
        }
        broadCastAndStopSelf(null);
    }

    public static void startTachometerService(Context context, boolean z, boolean z2) {
        if (context != null && j.H() && TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (!z2) {
                synchronized (lock) {
                    if (0 == lastTachometerTime) {
                        lastTachometerTime = d.a.m0.r.d0.b.j().l(LAST_GETCDNLIST_TIME, 0L);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (0 != lastTachometerTime && currentTimeMillis - lastTachometerTime < 300000) {
                        return;
                    }
                    lastTachometerTime = currentTimeMillis;
                    d.a.m0.r.d0.b.j().w(LAST_GETCDNLIST_TIME, currentTimeMillis);
                }
            }
            Intent intent = new Intent(context, TbCDNTachometerService.class);
            intent.putExtra("isNormal", z);
            f.c(context, intent);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void getIPList() {
        this.cdnTachometerModel.setCndTachometerModelCallBack(null);
        this.cdnTachometerModel.setCndTachometerModelCallBack(this.tachometerModelCallBack);
        this.cdnTachometerModel.getCDNIPList();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        registerListener();
        TbCdnTachometerModel tbCdnTachometerModel = new TbCdnTachometerModel(null);
        this.cdnTachometerModel = tbCdnTachometerModel;
        tbCdnTachometerModel.setCndTachometerModelCallBack(this.tachometerModelCallBack);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
        this.cdnTachometerModel.setCndTachometerModelCallBack(null);
        this.cdnTachometerModel.destroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (intent != null) {
            this.isNormal = intent.getBooleanExtra("isNormal", false);
        }
        Message message = new Message();
        message.what = 1002;
        this.handler.sendMessageDelayed(message, 60000L);
        this.startID = i2;
        getIPList();
    }
}
