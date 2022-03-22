package com.baidu.tieba.imageProblem.cdnOptimize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import c.a.d.f.m.b;
import c.a.d.f.m.f;
import c.a.d.f.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes5.dex */
public class TbCDNTachometerService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAST_GETCDNLIST_TIME = "com.baidu.tbadk.opTimize.lastGetCdnListTiem";
    public static final long TACHOMETER_INTERVAL = 300000;
    public static final String TB_CDNIP_BROADCASE_ACTION = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastAction";
    public static final String TB_CDNIP_BROADCASE_ISMOBILE = "com.baidu.tbadk.opTimize.ismobile";
    public static final String TB_CDNIP_BROADCASE_KEY = "com.baidu.tbadk.opTimize.cdnIpBroadCast";
    public static final String TB_CDNIP_BROADCASE_NEED_USEIP = "com.baidu.tbadk.opTimize.cdnipBroadCastNeedUseIp";
    public static final String TB_CDNIP_BROADCASE_NUM = "com.baidu.tbadk.opTimize.tbCdnIpBroadCastNum";
    public static long lastTachometerTime;
    public static Object lock;
    public transient /* synthetic */ FieldHolder $fh;
    public final long TACHOMETER_MAXTIME;
    public final int TB_CDN_MIN_IP_INTERVAL;
    public final int TIMER_MSG_KEY;
    public ArrayList<String> belowOnePointFiveIpList;
    public boolean canBroadCast;
    public final String cdnHiPhotosDomain;
    public HashMap<String, ArrayList<String>> cdnIpMap;
    public TbCdnTachometerModel cdnTachometerModel;
    public CustomMessageListener customNormalListener;
    @SuppressLint({"HandlerLeak"})
    public final Handler handler;
    public int hiPhotosMaxTime;
    public boolean isBroadFirstIp;
    public boolean isNormal;
    public int lastNotifyIpCount;
    public long lastNotifyIpTime;
    public BdUniqueId mId;
    public int numOfThrowIp;
    public ArrayList<String> optimalIpList;
    public int returnRequestNum;
    public int startID;
    public final TbCdnTachometerModel.TbCdnTachometerModelCallBack tachometerModelCallBack;

    /* loaded from: classes5.dex */
    public class CustomMsgData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbCdnIpListData a;

        /* renamed from: b  reason: collision with root package name */
        public int f34081b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34082c;

        /* renamed from: d  reason: collision with root package name */
        public long f34083d;

        /* renamed from: e  reason: collision with root package name */
        public String f34084e;

        /* renamed from: f  reason: collision with root package name */
        public TbCdnTachometerModel f34085f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f34086g;

        /* renamed from: h  reason: collision with root package name */
        public String f34087h;
        public final /* synthetic */ TbCDNTachometerService i;

        public CustomMsgData(TbCDNTachometerService tbCDNTachometerService, TbCdnIpListData tbCdnIpListData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCDNTachometerService, tbCdnIpListData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = tbCDNTachometerService;
            this.f34086g = false;
            this.f34087h = null;
            this.a = tbCdnIpListData;
            this.f34081b = i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-61640433, "Lcom/baidu/tieba/imageProblem/cdnOptimize/TbCDNTachometerService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-61640433, "Lcom/baidu/tieba/imageProblem/cdnOptimize/TbCDNTachometerService;");
                return;
            }
        }
        lock = new Object();
    }

    public TbCDNTachometerService() {
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
        this.TACHOMETER_MAXTIME = 60000L;
        this.TIMER_MSG_KEY = 1002;
        this.cdnTachometerModel = null;
        this.optimalIpList = new ArrayList<>();
        this.belowOnePointFiveIpList = new ArrayList<>();
        this.isNormal = false;
        this.mId = BdUniqueId.gen();
        this.returnRequestNum = 0;
        this.cdnIpMap = new HashMap<>();
        this.startID = 0;
        this.cdnHiPhotosDomain = "c.hiphotos.baidu.com";
        this.hiPhotosMaxTime = 3000;
        this.canBroadCast = false;
        this.isBroadFirstIp = false;
        this.TB_CDN_MIN_IP_INTERVAL = 2000;
        this.lastNotifyIpTime = 0L;
        this.lastNotifyIpCount = 0;
        this.numOfThrowIp = 0;
        this.customNormalListener = new CustomMessageListener(this, 2017000) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbCDNTachometerService a;

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
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    if (customResponsedMessage != null) {
                        try {
                            CustomMsgData customMsgData = (CustomMsgData) customResponsedMessage.getData();
                            if (customMsgData == null) {
                                return;
                            }
                            String str = customMsgData.f34084e;
                            boolean z = customMsgData.f34082c;
                            long j = customMsgData.f34083d;
                            String valueOf = String.valueOf(j);
                            int i3 = 0;
                            if (customMsgData.f34087h != null && customMsgData.f34087h.length() > 0) {
                                this.a.canBroadCast = true;
                                if (!z || j > this.a.hiPhotosMaxTime) {
                                    this.a.isNormal = false;
                                }
                            }
                            if (z) {
                                if (j <= 200 && str != null && str.length() != 0) {
                                    ArrayList arrayList = (ArrayList) this.a.cdnIpMap.get(str);
                                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                        this.a.optimalIpList.add((String) arrayList.get(i4));
                                    }
                                }
                                if (j <= 1500 && str != null && str.length() != 0) {
                                    ArrayList arrayList2 = (ArrayList) this.a.cdnIpMap.get(str);
                                    if (this.a.belowOnePointFiveIpList.size() > 0) {
                                        int i5 = 0;
                                        int i6 = 0;
                                        while (true) {
                                            if (i5 >= this.a.belowOnePointFiveIpList.size()) {
                                                i5 = i6;
                                                break;
                                            }
                                            String[] split = ((String) this.a.belowOnePointFiveIpList.get(i5)).split("_");
                                            if (split.length >= 2) {
                                                if (b.g(split[1], 0L) > j) {
                                                    break;
                                                }
                                                i6 = i5 + 1;
                                            }
                                            i5++;
                                        }
                                        if (i5 <= this.a.belowOnePointFiveIpList.size()) {
                                            while (i3 < arrayList2.size()) {
                                                this.a.belowOnePointFiveIpList.add(i5, ((String) arrayList2.get(i3)) + "_" + valueOf);
                                                i3++;
                                            }
                                        }
                                    } else {
                                        while (i3 < arrayList2.size()) {
                                            this.a.belowOnePointFiveIpList.add(((String) arrayList2.get(i3)) + "_" + valueOf);
                                            i3++;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2);
                        }
                    }
                    this.a.returnRequestNum++;
                    this.a.judgeIsBroadcastCdnIp();
                }
            }
        };
        this.handler = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbCDNTachometerService a;

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
                    if (1002 == message.what) {
                        this.a.BroadcastCdnIp();
                    }
                }
            }
        };
        this.tachometerModelCallBack = new TbCdnTachometerModel.TbCdnTachometerModelCallBack(this) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbCDNTachometerService a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.TbCdnTachometerModelCallBack
            public void callBack(TbCdnIpListData tbCdnIpListData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, tbCdnIpListData) == null) || tbCdnIpListData == null) {
                    return;
                }
                this.a.startTachometer(tbCdnIpListData);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BroadcastCdnIp() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.canBroadCast) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (this.optimalIpList.size() >= 5) {
                int size = this.optimalIpList.size();
                i = size <= 5 ? size : 5;
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(this.optimalIpList.get(i2));
                }
            } else if (this.belowOnePointFiveIpList.size() > 0) {
                int size2 = this.belowOnePointFiveIpList.size();
                i = size2 <= 5 ? size2 : 5;
                for (int i3 = 0; i3 < i; i3++) {
                    try {
                        arrayList.add(this.belowOnePointFiveIpList.get(i3).split("_")[0]);
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, arrayList) == null) || arrayList == null || (size = arrayList.size()) <= 1) {
            return;
        }
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

    private void broadCast(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, arrayList) == null) {
            Intent intent = new Intent();
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.numOfThrowIp++;
            intent.setAction(TB_CDNIP_BROADCASE_ACTION);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.putExtra(TB_CDNIP_BROADCASE_KEY, arrayList);
            intent.putExtra(TB_CDNIP_BROADCASE_NEED_USEIP, !this.isNormal);
            intent.putExtra(TB_CDNIP_BROADCASE_NUM, this.numOfThrowIp);
            intent.putExtra(TB_CDNIP_BROADCASE_ISMOBILE, false);
            sendBroadcast(intent);
        }
    }

    private void broadCastAndStopSelf(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, arrayList) == null) {
            MessageManager.getInstance().removeMessage(this.mId);
            this.handler.removeMessages(1002);
            broadCast(arrayList);
            stopSelfResult(this.startID);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeIsBroadcastCdnIp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
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
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.customNormalListener.setTag(this.mId);
            MessageManager.getInstance().registerListener(this.customNormalListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTachometer(TbCdnIpListData tbCdnIpListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, tbCdnIpListData) == null) {
            this.numOfThrowIp = 0;
            if (tbCdnIpListData != null && tbCdnIpListData.a == 0) {
                if (!tbCdnIpListData.f34092f) {
                    broadCastAndStopSelf(null);
                    return;
                } else if (tbCdnIpListData.f34091e.size() == 0) {
                    broadCastAndStopSelf(null);
                    return;
                } else {
                    breakUpIpList(tbCdnIpListData.f34091e);
                    String str = tbCdnIpListData.f34089c;
                    String str2 = tbCdnIpListData.f34093g;
                    String str3 = tbCdnIpListData.f34090d;
                    if (str == null || str2 == null || str3 == null) {
                        return;
                    }
                    int size = tbCdnIpListData.f34091e.size();
                    if (size > 0) {
                        CustomMsgData customMsgData = new CustomMsgData(this, tbCdnIpListData, 0);
                        customMsgData.f34085f = this.cdnTachometerModel;
                        customMsgData.f34086g = this.isNormal;
                        customMsgData.f34087h = "c.hiphotos.baidu.com";
                        CustomMessage customMessage = new CustomMessage(2017000, customMsgData);
                        customMessage.setTag(this.mId);
                        MessageManager.getInstance().sendMessage(customMessage);
                    }
                    for (int i = 0; i < size; i++) {
                        ArrayList<String> arrayList = tbCdnIpListData.f34091e.get(i);
                        String str4 = arrayList.size() > 0 ? arrayList.get(0) : "";
                        if (!this.cdnIpMap.containsKey(str4)) {
                            this.cdnIpMap.put(str4, arrayList);
                        }
                        CustomMsgData customMsgData2 = new CustomMsgData(this, tbCdnIpListData, i);
                        customMsgData2.f34085f = this.cdnTachometerModel;
                        customMsgData2.f34086g = this.isNormal;
                        CustomMessage customMessage2 = new CustomMessage(2017000, customMsgData2);
                        customMessage2.setTag(this.mId);
                        MessageManager.getInstance().sendMessage(customMessage2);
                    }
                    return;
                }
            }
            broadCastAndStopSelf(null);
        }
    }

    public static void startTachometerService(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && context != null && l.H() && TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (!z2) {
                synchronized (lock) {
                    if (0 == lastTachometerTime) {
                        lastTachometerTime = c.a.o0.r.j0.b.k().m(LAST_GETCDNLIST_TIME, 0L);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (0 != lastTachometerTime && currentTimeMillis - lastTachometerTime < 300000) {
                        return;
                    }
                    lastTachometerTime = currentTimeMillis;
                    c.a.o0.r.j0.b.k().x(LAST_GETCDNLIST_TIME, currentTimeMillis);
                }
            }
            Intent intent = new Intent(context, TbCDNTachometerService.class);
            intent.putExtra("isNormal", z);
            f.startService(context, intent);
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mId);
        }
    }

    public void getIPList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.cdnTachometerModel.setCndTachometerModelCallBack(null);
            this.cdnTachometerModel.setCndTachometerModelCallBack(this.tachometerModelCallBack);
            this.cdnTachometerModel.getCDNIPList();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            registerListener();
            TbCdnTachometerModel tbCdnTachometerModel = new TbCdnTachometerModel(null);
            this.cdnTachometerModel = tbCdnTachometerModel;
            tbCdnTachometerModel.setCndTachometerModelCallBack(this.tachometerModelCallBack);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            unRegisterListener();
            this.cdnTachometerModel.setCndTachometerModelCallBack(null);
            this.cdnTachometerModel.destroy();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, intent, i) == null) {
            super.onStart(intent, i);
            if (intent != null) {
                this.isNormal = intent.getBooleanExtra("isNormal", false);
            }
            Message message = new Message();
            message.what = 1002;
            this.handler.sendMessageDelayed(message, 60000L);
            this.startID = i;
            getIPList();
        }
    }
}
