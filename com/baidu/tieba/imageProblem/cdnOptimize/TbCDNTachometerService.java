package com.baidu.tieba.imageProblem.cdnOptimize;

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
import com.baidu.adp.lib.h.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class TbCDNTachometerService extends BdBaseService {
    private static final String LAST_GETCDNLIST_TIME = "com.baidu.tbadk.opTimize.lastGetCdnListTiem";
    private static final long TACHOMETER_INTERVAL = 300000;
    public static final String TB_CDNIP_BROADCASE_ACTION = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastAction";
    public static final String TB_CDNIP_BROADCASE_ISMOBILE = "com.baidu.tbadk.opTimize.ismobile";
    public static final String TB_CDNIP_BROADCASE_KEY = "com.baidu.tbadk.opTimize.cdnIpBroadCast";
    public static final String TB_CDNIP_BROADCASE_NEED_USEIP = "com.baidu.tbadk.opTimize.cdnipBroadCastNeedUseIp";
    public static final String TB_CDNIP_BROADCASE_NUM = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastNum";
    private static Object lock = new Object();
    private static long lastTachometerTime = 0;
    private final long TACHOMETER_MAXTIME = TbConfig.USE_TIME_INTERVAL;
    private final int TIMER_MSG_KEY = 1002;
    private TbCdnTachometerModel cdnTachometerModel = null;
    private ArrayList<String> optimalIpList = new ArrayList<>();
    private ArrayList<String> belowOnePointFiveIpList = new ArrayList<>();
    private boolean isNormal = false;
    private BdUniqueId mId = BdUniqueId.gen();
    private int returnRequestNum = 0;
    private HashMap<String, ArrayList<String>> cdnIpMap = new HashMap<>();
    private int startID = 0;
    private final String cdnHiPhotosDomain = "c.hiphotos.baidu.com";
    private int hiPhotosMaxTime = 3000;
    private boolean canBroadCast = false;
    private boolean isBroadFirstIp = false;
    private final int TB_CDN_MIN_IP_INTERVAL = 2000;
    private long lastNotifyIpTime = 0;
    private int lastNotifyIpCount = 0;
    private int numOfThrowIp = 0;
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_CDN_TACHOMETER) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null) {
                try {
                    CustomMsgData customMsgData = (CustomMsgData) customResponsedMessage.getData();
                    if (customMsgData != null) {
                        String str = customMsgData.cdnIp;
                        boolean z = customMsgData.isSuccess;
                        long j = customMsgData.AA;
                        String valueOf = String.valueOf(j);
                        if (customMsgData.deU != null && customMsgData.deU.length() > 0) {
                            TbCDNTachometerService.this.canBroadCast = true;
                            if (!z || j > TbCDNTachometerService.this.hiPhotosMaxTime) {
                                TbCDNTachometerService.this.isNormal = false;
                            }
                        }
                        if (z) {
                            if (j <= 200 && str != null && str.length() != 0) {
                                ArrayList arrayList = (ArrayList) TbCDNTachometerService.this.cdnIpMap.get(str);
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    TbCDNTachometerService.this.optimalIpList.add((String) arrayList.get(i2));
                                }
                            }
                            if (j <= 1500 && str != null && str.length() != 0) {
                                ArrayList arrayList2 = (ArrayList) TbCDNTachometerService.this.cdnIpMap.get(str);
                                if (TbCDNTachometerService.this.belowOnePointFiveIpList.size() > 0) {
                                    int i3 = 0;
                                    int i4 = 0;
                                    while (true) {
                                        if (i3 >= TbCDNTachometerService.this.belowOnePointFiveIpList.size()) {
                                            break;
                                        }
                                        String[] split = ((String) TbCDNTachometerService.this.belowOnePointFiveIpList.get(i3)).split("_");
                                        if (split.length < 2) {
                                            i = i4;
                                        } else if (b.c(split[1], 0L) > j) {
                                            i4 = i3;
                                            break;
                                        } else {
                                            i = i3 + 1;
                                        }
                                        i3++;
                                        i4 = i;
                                    }
                                    if (i4 <= TbCDNTachometerService.this.belowOnePointFiveIpList.size()) {
                                        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                                            TbCDNTachometerService.this.belowOnePointFiveIpList.add(i4, String.valueOf((String) arrayList2.get(i5)) + "_" + valueOf);
                                        }
                                    }
                                } else {
                                    for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                        TbCDNTachometerService.this.belowOnePointFiveIpList.add(String.valueOf((String) arrayList2.get(i6)) + "_" + valueOf);
                                    }
                                }
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            TbCDNTachometerService.this.returnRequestNum++;
            TbCDNTachometerService.this.judgeIsBroadcastCdnIp();
        }
    };
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (1002 != message.what) {
                return;
            }
            TbCDNTachometerService.this.BroadcastCdnIp();
        }
    };
    private final TbCdnTachometerModel.TbCdnTachometerModelCallBack tachometerModelCallBack = new TbCdnTachometerModel.TbCdnTachometerModelCallBack() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.3
        @Override // com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.TbCdnTachometerModelCallBack
        public void callBack(TbCdnIpListData tbCdnIpListData) {
            if (tbCdnIpListData == null) {
                return;
            }
            TbCDNTachometerService.this.startTachometer(tbCdnIpListData);
        }
    };

    public static void startTachometerService(Context context, boolean z, boolean z2) {
        if (context != null && i.gn() && TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            if (!z2) {
                synchronized (lock) {
                    if (0 == lastTachometerTime) {
                        lastTachometerTime = com.baidu.tbadk.core.sharedPref.b.tW().getLong(LAST_GETCDNLIST_TIME, 0L);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (0 == lastTachometerTime || currentTimeMillis - lastTachometerTime >= TACHOMETER_INTERVAL) {
                        lastTachometerTime = currentTimeMillis;
                        com.baidu.tbadk.core.sharedPref.b.tW().putLong(LAST_GETCDNLIST_TIME, currentTimeMillis);
                    } else {
                        return;
                    }
                }
            }
            Intent intent = new Intent(context, TbCDNTachometerService.class);
            intent.putExtra("isNormal", z);
            com.baidu.adp.lib.h.i.c(context, intent);
        }
    }

    private void registerListener() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        registerListener();
        this.cdnTachometerModel = new TbCdnTachometerModel(null);
        this.cdnTachometerModel.setCndTachometerModelCallBack(this.tachometerModelCallBack);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            this.isNormal = intent.getBooleanExtra("isNormal", false);
        }
        Message message = new Message();
        message.what = 1002;
        this.handler.sendMessageDelayed(message, TbConfig.USE_TIME_INTERVAL);
        this.startID = i;
        getIPList();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
        this.cdnTachometerModel.setCndTachometerModelCallBack(null);
        this.cdnTachometerModel.destroy();
    }

    public void getIPList() {
        this.cdnTachometerModel.setCndTachometerModelCallBack(null);
        this.cdnTachometerModel.setCndTachometerModelCallBack(this.tachometerModelCallBack);
        this.cdnTachometerModel.getCDNIPList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTachometer(TbCdnIpListData tbCdnIpListData) {
        this.numOfThrowIp = 0;
        if (tbCdnIpListData == null || tbCdnIpListData.errorNum != 0) {
            broadCastAndStopSelf(null);
        } else if (!tbCdnIpListData.deX) {
            broadCastAndStopSelf(null);
        } else if (tbCdnIpListData.deW.size() == 0) {
            broadCastAndStopSelf(null);
        } else {
            breakUpIpList(tbCdnIpListData.deW);
            String str = tbCdnIpListData.imageUrl;
            String str2 = tbCdnIpListData.deY;
            String str3 = tbCdnIpListData.deV;
            if (str != null && str2 != null && str3 != null) {
                int size = tbCdnIpListData.deW.size();
                if (size > 0) {
                    CustomMsgData customMsgData = new CustomMsgData(tbCdnIpListData, 0);
                    customMsgData.cdnTachometerModel = this.cdnTachometerModel;
                    customMsgData.isNormal = this.isNormal;
                    customMsgData.deU = "c.hiphotos.baidu.com";
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_CDN_TACHOMETER, customMsgData);
                    customMessage.setTag(this.mId);
                    MessageManager.getInstance().sendMessage(customMessage);
                }
                for (int i = 0; i < size; i++) {
                    ArrayList<String> arrayList = tbCdnIpListData.deW.get(i);
                    String str4 = "";
                    if (arrayList.size() > 0) {
                        str4 = arrayList.get(0);
                    }
                    if (!this.cdnIpMap.containsKey(str4)) {
                        this.cdnIpMap.put(str4, arrayList);
                    }
                    CustomMsgData customMsgData2 = new CustomMsgData(tbCdnIpListData, i);
                    customMsgData2.cdnTachometerModel = this.cdnTachometerModel;
                    customMsgData2.isNormal = this.isNormal;
                    CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.CMD_CDN_TACHOMETER, customMsgData2);
                    customMessage2.setTag(this.mId);
                    MessageManager.getInstance().sendMessage(customMessage2);
                }
            }
        }
    }

    private void breakUpIpList(ArrayList<ArrayList<String>> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            int i = size / 2;
            Random random = new Random();
            for (int i2 = 0; i2 < i; i2++) {
                int nextInt = random.nextInt(size);
                if (nextInt < size) {
                    arrayList.set(i2, arrayList.get(nextInt));
                    arrayList.set(nextInt, arrayList.get(i2));
                }
            }
        }
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
            int i = this.lastNotifyIpCount;
            this.lastNotifyIpCount = this.optimalIpList.size();
            this.lastNotifyIpTime = System.currentTimeMillis();
            if (i != 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                int size = this.optimalIpList.size();
                int i2 = size <= 5 ? size : 5;
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayList2.add(this.optimalIpList.get(i3));
                }
                broadCast(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BroadcastCdnIp() {
        int i = 0;
        if (this.canBroadCast) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (this.optimalIpList.size() >= 5) {
                int size = this.optimalIpList.size();
                if (size > 5) {
                    size = 5;
                }
                while (i < size) {
                    arrayList.add(this.optimalIpList.get(i));
                    i++;
                }
            } else if (this.belowOnePointFiveIpList.size() > 0) {
                int size2 = this.belowOnePointFiveIpList.size();
                if (size2 > 5) {
                    size2 = 5;
                }
                while (i < size2) {
                    try {
                        arrayList.add(this.belowOnePointFiveIpList.get(i).split("_")[0]);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    i++;
                }
            }
            broadCastAndStopSelf(arrayList);
        }
    }

    private void broadCastAndStopSelf(ArrayList<String> arrayList) {
        MessageManager.getInstance().removeMessage(this.mId);
        this.handler.removeMessages(1002);
        broadCast(arrayList);
        stopSelfResult(this.startID);
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

    /* loaded from: classes.dex */
    public class CustomMsgData {
        public long AA;
        public String cdnIp;
        public TbCdnTachometerModel cdnTachometerModel;
        public TbCdnIpListData ipListData;
        public boolean isSuccess;
        public int pos;
        public boolean isNormal = false;
        public String deU = null;

        public CustomMsgData(TbCdnIpListData tbCdnIpListData, int i) {
            this.ipListData = tbCdnIpListData;
            this.pos = i;
        }
    }
}
