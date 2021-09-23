package com.baidu.tieba.imageProblem.cdnOptimize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import c.a.e.e.m.b;
import c.a.e.e.m.f;
import c.a.e.e.p.j;
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
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class CustomMsgData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbCdnIpListData f53718a;

        /* renamed from: b  reason: collision with root package name */
        public int f53719b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f53720c;

        /* renamed from: d  reason: collision with root package name */
        public long f53721d;

        /* renamed from: e  reason: collision with root package name */
        public String f53722e;

        /* renamed from: f  reason: collision with root package name */
        public TbCdnTachometerModel f53723f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f53724g;

        /* renamed from: h  reason: collision with root package name */
        public String f53725h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ TbCDNTachometerService f53726i;

        public CustomMsgData(TbCDNTachometerService tbCDNTachometerService, TbCdnIpListData tbCdnIpListData, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCDNTachometerService, tbCdnIpListData, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53726i = tbCDNTachometerService;
            this.f53724g = false;
            this.f53725h = null;
            this.f53718a = tbCdnIpListData;
            this.f53719b = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TbCDNTachometerService f53715a;

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
                this.f53715a = this;
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
                            String str = customMsgData.f53722e;
                            boolean z = customMsgData.f53720c;
                            long j2 = customMsgData.f53721d;
                            String valueOf = String.valueOf(j2);
                            int i4 = 0;
                            if (customMsgData.f53725h != null && customMsgData.f53725h.length() > 0) {
                                this.f53715a.canBroadCast = true;
                                if (!z || j2 > this.f53715a.hiPhotosMaxTime) {
                                    this.f53715a.isNormal = false;
                                }
                            }
                            if (z) {
                                if (j2 <= 200 && str != null && str.length() != 0) {
                                    ArrayList arrayList = (ArrayList) this.f53715a.cdnIpMap.get(str);
                                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                                        this.f53715a.optimalIpList.add((String) arrayList.get(i5));
                                    }
                                }
                                if (j2 <= 1500 && str != null && str.length() != 0) {
                                    ArrayList arrayList2 = (ArrayList) this.f53715a.cdnIpMap.get(str);
                                    if (this.f53715a.belowOnePointFiveIpList.size() > 0) {
                                        int i6 = 0;
                                        int i7 = 0;
                                        while (true) {
                                            if (i6 >= this.f53715a.belowOnePointFiveIpList.size()) {
                                                i6 = i7;
                                                break;
                                            }
                                            String[] split = ((String) this.f53715a.belowOnePointFiveIpList.get(i6)).split("_");
                                            if (split.length >= 2) {
                                                if (b.g(split[1], 0L) > j2) {
                                                    break;
                                                }
                                                i7 = i6 + 1;
                                            }
                                            i6++;
                                        }
                                        if (i6 <= this.f53715a.belowOnePointFiveIpList.size()) {
                                            while (i4 < arrayList2.size()) {
                                                this.f53715a.belowOnePointFiveIpList.add(i6, ((String) arrayList2.get(i4)) + "_" + valueOf);
                                                i4++;
                                            }
                                        }
                                    } else {
                                        while (i4 < arrayList2.size()) {
                                            this.f53715a.belowOnePointFiveIpList.add(((String) arrayList2.get(i4)) + "_" + valueOf);
                                            i4++;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2);
                        }
                    }
                    this.f53715a.returnRequestNum++;
                    this.f53715a.judgeIsBroadcastCdnIp();
                }
            }
        };
        this.handler = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TbCDNTachometerService f53716a;

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
                this.f53716a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (1002 == message.what) {
                        this.f53716a.BroadcastCdnIp();
                    }
                }
            }
        };
        this.tachometerModelCallBack = new TbCdnTachometerModel.TbCdnTachometerModelCallBack(this) { // from class: com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TbCDNTachometerService f53717a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f53717a = this;
            }

            @Override // com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel.TbCdnTachometerModelCallBack
            public void callBack(TbCdnIpListData tbCdnIpListData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, tbCdnIpListData) == null) || tbCdnIpListData == null) {
                    return;
                }
                this.f53717a.startTachometer(tbCdnIpListData);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BroadcastCdnIp() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.canBroadCast) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, arrayList) == null) || arrayList == null || (size = arrayList.size()) <= 1) {
            return;
        }
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

    private void broadCast(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, arrayList) == null) {
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
            if (tbCdnIpListData != null && tbCdnIpListData.f53727a == 0) {
                if (!tbCdnIpListData.f53732f) {
                    broadCastAndStopSelf(null);
                    return;
                } else if (tbCdnIpListData.f53731e.size() == 0) {
                    broadCastAndStopSelf(null);
                    return;
                } else {
                    breakUpIpList(tbCdnIpListData.f53731e);
                    String str = tbCdnIpListData.f53729c;
                    String str2 = tbCdnIpListData.f53733g;
                    String str3 = tbCdnIpListData.f53730d;
                    if (str == null || str2 == null || str3 == null) {
                        return;
                    }
                    int size = tbCdnIpListData.f53731e.size();
                    if (size > 0) {
                        CustomMsgData customMsgData = new CustomMsgData(this, tbCdnIpListData, 0);
                        customMsgData.f53723f = this.cdnTachometerModel;
                        customMsgData.f53724g = this.isNormal;
                        customMsgData.f53725h = "c.hiphotos.baidu.com";
                        CustomMessage customMessage = new CustomMessage(2017000, customMsgData);
                        customMessage.setTag(this.mId);
                        MessageManager.getInstance().sendMessage(customMessage);
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        ArrayList<String> arrayList = tbCdnIpListData.f53731e.get(i2);
                        String str4 = arrayList.size() > 0 ? arrayList.get(0) : "";
                        if (!this.cdnIpMap.containsKey(str4)) {
                            this.cdnIpMap.put(str4, arrayList);
                        }
                        CustomMsgData customMsgData2 = new CustomMsgData(this, tbCdnIpListData, i2);
                        customMsgData2.f53723f = this.cdnTachometerModel;
                        customMsgData2.f53724g = this.isNormal;
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
        if ((interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && context != null && j.H() && TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (!z2) {
                synchronized (lock) {
                    if (0 == lastTachometerTime) {
                        lastTachometerTime = c.a.q0.s.d0.b.j().l(LAST_GETCDNLIST_TIME, 0L);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (0 != lastTachometerTime && currentTimeMillis - lastTachometerTime < 300000) {
                        return;
                    }
                    lastTachometerTime = currentTimeMillis;
                    c.a.q0.s.d0.b.j().w(LAST_GETCDNLIST_TIME, currentTimeMillis);
                }
            }
            Intent intent = new Intent(context, TbCDNTachometerService.class);
            intent.putExtra("isNormal", z);
            f.c(context, intent);
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
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, intent, i2) == null) {
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
}
