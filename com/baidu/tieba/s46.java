package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.adnotify.receiver.NotInstallNotificationReceiver;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Service
/* loaded from: classes8.dex */
public final class s46 implements wd5 {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ApkDownloadInfoData> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948101492, "Lcom/baidu/tieba/s46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948101492, "Lcom/baidu/tieba/s46;");
                return;
            }
        }
        b = new a(null);
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String string = SharedPrefHelper.getInstance().getString("key_not_install_notify_last_date", "");
                String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                if (!format.equals(string)) {
                    SharedPrefHelper.getInstance().putInt("key_not_install_notify_num", 0);
                    SharedPrefHelper.getInstance().putString("key_not_install_notify_last_date", format);
                }
                return SharedPrefHelper.getInstance().getInt("key_not_install_notify_num", 0);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements uw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s46 a;
        public final /* synthetic */ ApkDownloadInfoData b;

        @Override // com.baidu.tieba.uw5
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(s46 s46Var, ApkDownloadInfoData apkDownloadInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s46Var, apkDownloadInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s46Var;
            this.b = apkDownloadInfoData;
        }

        @Override // com.baidu.tieba.uw5
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                PendingIntent j = this.a.j(NotInstallNotificationReceiver.RECEIVER_ACTION_CLICK_ITEM, this.b);
                PendingIntent j2 = this.a.j(NotInstallNotificationReceiver.RECEIVER_ACTION_REMOVE_ITEM, this.b);
                RemoteViews k = this.a.k(bitmap, this.a.j(NotInstallNotificationReceiver.RECEIVER_ACTION_CLICK_BUTTON, this.b), this.b);
                if (k != null) {
                    s46 s46Var = this.a;
                    ApkDownloadInfoData apkDownloadInfoData = this.b;
                    s46Var.t(bitmap, k, j, j2, apkDownloadInfoData);
                    s46Var.p(apkDownloadInfoData);
                    if (!apkDownloadInfoData.isFromBusiness() || apkDownloadInfoData.getAdDownloadBean() == null) {
                        s46Var.u(apkDownloadInfoData, false);
                        return;
                    }
                    r46 r46Var = r46.a;
                    wg0 adDownloadBean = apkDownloadInfoData.getAdDownloadBean();
                    Intrinsics.checkNotNullExpressionValue(adDownloadBean, "data.adDownloadBean");
                    r46Var.c(adDownloadBean);
                }
            }
        }
    }

    public s46() {
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
        this.a = new ArrayList();
    }

    public static final void o(ApkDownloadInfoData data, s46 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, data, this$0) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            new ww5().d(data.getApkIcon(), new b(this$0, data));
        }
    }

    @Override // com.baidu.tieba.wd5
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !s()) {
            return;
        }
        this.a.clear();
        CollectionsKt__MutableCollectionsKt.addAll(this.a, l());
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.a.size(), 5);
        for (int i = 0; i < coerceAtMost; i++) {
            n(this.a.get(i));
        }
    }

    public final void g(ApkDownloadInfoData apkDownloadInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apkDownloadInfoData) == null) {
            String apkPackageName = apkDownloadInfoData.getApkPackageName();
            Intrinsics.checkNotNullExpressionValue(apkPackageName, "data.apkPackageName");
            if (TextUtils.equals(r(apkPackageName), "notify_type_unactivated")) {
                apkDownloadInfoData.setNotificationShowContent(TbadkCoreApplication.getInst().getString(R.string.nad_notification_active_text));
            } else {
                apkDownloadInfoData.setNotificationShowContent(TbadkCoreApplication.getInst().getString(R.string.nad_notification_text));
            }
        }
    }

    public final NotificationCompat.Builder h() {
        InterceptResult invokeV;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                i();
                builder = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), "com.baidu.tieba.notification.channel");
            } else {
                builder = new NotificationCompat.Builder(TbadkCoreApplication.getInst());
            }
            builder.setSmallIcon(vg0.b().f());
            builder.setWhen(System.currentTimeMillis());
            builder.setPriority(0);
            builder.setDefaults(-1);
            builder.setVisibility(1);
            builder.setVibrate(new long[]{0});
            builder.setSound(null);
            return builder;
        }
        return (NotificationCompat.Builder) invokeV.objValue;
    }

    @RequiresApi(26)
    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NotificationChannel notificationChannel = new NotificationChannel("com.baidu.tieba.notification.channel", "下载消息提示", 4);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            notificationChannel.setSound(null, null);
            Object systemService = TbadkCoreApplication.getInst().getSystemService("notification");
            if (systemService != null) {
                ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
    }

    public final PendingIntent j(String str, ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, apkDownloadInfoData)) == null) {
            Intent intent = new Intent(str);
            intent.setComponent(new ComponentName(TbadkCoreApplication.getInst().getPackageName(), NotInstallNotificationReceiver.class.getName()));
            intent.putExtra("key_package_name", apkDownloadInfoData.getApkPackageName());
            intent.putExtra("key_download_path", apkDownloadInfoData.getApkPath());
            String apkPackageName = apkDownloadInfoData.getApkPackageName();
            Intrinsics.checkNotNullExpressionValue(apkPackageName, "data.apkPackageName");
            intent.putExtra("key_notify_type", r(apkPackageName));
            intent.putExtra("key_notification_id", m(apkDownloadInfoData));
            intent.putExtra(NotInstallNotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_DATA_ID, apkDownloadInfoData.getTitle());
            intent.putExtra("key_source", apkDownloadInfoData.getItemSource());
            intent.putExtra(NotInstallNotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_URL, apkDownloadInfoData.getDownloadUrl());
            intent.putExtra(NotInstallNotificationReceiver.INTENT_PARAMS_KEY_APK_NAME, apkDownloadInfoData.getApkName());
            if (apkDownloadInfoData.isFromBusiness() && apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null) {
                intent.putExtra("key_extra_param", apkDownloadInfoData.getAdDownloadBean().p.a);
            }
            PendingIntent a2 = e21.a(TbadkCoreApplication.getInst(), m(apkDownloadInfoData), intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            Intrinsics.checkNotNullExpressionValue(a2, "getImmutablePendingInten…_UPDATE_CURRENT\n        )");
            return a2;
        }
        return (PendingIntent) invokeLL.objValue;
    }

    public final RemoteViews k(Bitmap bitmap, PendingIntent pendingIntent, ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, bitmap, pendingIntent, apkDownloadInfoData)) == null) {
            xh0 c = vg0.b().c();
            if (c == null || c.a <= 0) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), c.a);
            int i = c.c;
            if (i > 0) {
                remoteViews.setOnClickPendingIntent(i, pendingIntent);
                String apkPackageName = apkDownloadInfoData.getApkPackageName();
                Intrinsics.checkNotNullExpressionValue(apkPackageName, "data.apkPackageName");
                if (TextUtils.equals("notify_type_unactivated", r(apkPackageName))) {
                    remoteViews.setTextViewText(c.c, TbadkCoreApplication.getInst().getString(R.string.nad_notification_btn_active_text));
                } else {
                    remoteViews.setTextViewText(c.c, TbadkCoreApplication.getInst().getString(R.string.nad_notification_btn_text));
                }
            }
            int i2 = c.b;
            if (i2 > 0) {
                remoteViews.setImageViewBitmap(i2, zh0.l().r(bitmap, 24.0f));
            }
            int i3 = c.d;
            if (i3 > 0) {
                remoteViews.setTextViewText(i3, apkDownloadInfoData.getApkName());
            }
            int i4 = c.e;
            if (i4 > 0) {
                remoteViews.setTextViewText(i4, apkDownloadInfoData.getNotificationShowContent());
            }
            return remoteViews;
        }
        return (RemoteViews) invokeLLL.objValue;
    }

    public final List<ApkDownloadInfoData> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<ApkDownloadInfoData> arrayList = new ArrayList();
            HashMap<String, wg0> a2 = ng0.b().a();
            Intrinsics.checkNotNullExpressionValue(a2, "instance().caches");
            if (!a2.isEmpty()) {
                for (String str : a2.keySet()) {
                    ApkDownloadInfoData a3 = f35.a.a(a2.get(str));
                    if (a3 != null && q(a3)) {
                        g(a3);
                        arrayList.add(a3);
                    }
                }
            }
            for (ksa ksaVar : new TbDownloadManager().m().j()) {
                ApkDownloadInfoData b2 = f35.a.b(ksaVar);
                if (b2 != null) {
                    g(b2);
                    if (q(b2)) {
                        arrayList.add(b2);
                    }
                }
            }
            CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList2 = new ArrayList();
            for (ApkDownloadInfoData apkDownloadInfoData : arrayList) {
                if (!linkedHashMap.containsKey(apkDownloadInfoData.getApkPackageName())) {
                    String apkPackageName = apkDownloadInfoData.getApkPackageName();
                    Intrinsics.checkNotNullExpressionValue(apkPackageName, "data.apkPackageName");
                    linkedHashMap.put(apkPackageName, apkDownloadInfoData);
                    arrayList2.add(apkDownloadInfoData);
                }
            }
            return arrayList2;
        }
        return (List) invokeV.objValue;
    }

    public final int m(ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, apkDownloadInfoData)) == null) {
            if (this.a.contains(apkDownloadInfoData)) {
                return this.a.indexOf(apkDownloadInfoData);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void n(final ApkDownloadInfoData apkDownloadInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, apkDownloadInfoData) == null) {
            new Thread(new Runnable() { // from class: com.baidu.tieba.m46
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        s46.o(ApkDownloadInfoData.this, this);
                    }
                }
            }).start();
        }
    }

    public final void p(ApkDownloadInfoData apkDownloadInfoData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, apkDownloadInfoData) == null) {
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_INSTALL_NOTIFICATION_REMIND_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_source", apkDownloadInfoData.getApkName()).addParam(TiebaStatic.Params.OBJ_URL, apkDownloadInfoData.getDownloadUrl()).addParam("obj_name", apkDownloadInfoData.getApkPackageName());
            String apkPackageName = apkDownloadInfoData.getApkPackageName();
            Intrinsics.checkNotNullExpressionValue(apkPackageName, "data.apkPackageName");
            if (Intrinsics.areEqual("notify_type_unactivated", r(apkPackageName))) {
                str = "1";
            } else {
                str = "2";
            }
            StatisticItem addParam2 = addParam.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
            if (UbsABTestHelper.isAdNotInstallRemindA()) {
                str2 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_A;
            } else {
                str2 = UsbAbTestConst.KEY_AD_NOT_INSTALL_REMIND_B;
            }
            TiebaStatic.log(addParam2.addParam(TiebaStatic.Params.OBJ_PARAM3, str2).addParam(TiebaStatic.Params.OBJ_PARAM4, apkDownloadInfoData.getItemSource()));
        }
    }

    public final boolean q(ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, apkDownloadInfoData)) == null) {
            String apkPackageName = apkDownloadInfoData.getApkPackageName();
            Intrinsics.checkNotNullExpressionValue(apkPackageName, "data.apkPackageName");
            String r = r(apkPackageName);
            if (TextUtils.equals("notify_type_activated", r) && apkDownloadInfoData.getItemId() != 0) {
                new TbDownloadManager().m().d(apkDownloadInfoData.getItemId());
            }
            if (TextUtils.equals("notify_type_activated", r) || TextUtils.equals("notify_type_no_permission", r)) {
                return false;
            }
            if (TextUtils.equals("notify_type_uninstall", r) && !gi0.g(apkDownloadInfoData.getApkFile())) {
                return false;
            }
            String apkName = apkDownloadInfoData.getApkName();
            String apkIcon = apkDownloadInfoData.getApkIcon();
            int notificationShowCount = apkDownloadInfoData.getNotificationShowCount();
            long finishDownloadTime = apkDownloadInfoData.getFinishDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            if (finishDownloadTime <= currentTimeMillis && finishDownloadTime >= currentTimeMillis - 604800000) {
                z = true;
            } else {
                z = false;
            }
            if (notificationShowCount >= 2 || !z || TextUtils.isEmpty(apkName) || TextUtils.isEmpty(apkIcon)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String r(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!gi0.c(str)) {
                return "notify_type_uninstall";
            }
            if (TbadkCoreApplication.getInst().checkPermission(com.kuaishou.weapon.p0.g.i, Process.myPid(), Process.myUid()) != 0) {
                return "notify_type_no_permission";
            }
            try {
                if (!new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str).exists()) {
                    str2 = "notify_type_unactivated";
                } else {
                    str2 = "notify_type_activated";
                }
                return str2;
            } catch (Exception e) {
                e.printStackTrace();
                return "notify_type_no_permission";
            }
        }
        return (String) invokeL.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (b.a() > 3) {
                return false;
            }
            if (!fh0.f().g()) {
                for (ApkDownloadInfoData apkDownloadInfoData : l()) {
                    if (apkDownloadInfoData != null && apkDownloadInfoData.isFromBusiness() && apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null) {
                        fh0.f().h(ClogBuilder.LogType.AD_NOTIFICATION_NOTIFY_FAILED.type, "", apkDownloadInfoData.getAdDownloadBean().p.a, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void t(Bitmap bitmap, RemoteViews remoteViews, PendingIntent pendingIntent, PendingIntent pendingIntent2, ApkDownloadInfoData apkDownloadInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048589, this, bitmap, remoteViews, pendingIntent, pendingIntent2, apkDownloadInfoData) == null) {
            Object systemService = TbadkCoreApplication.getInst().getSystemService("notification");
            if (systemService != null) {
                NotificationManager notificationManager = (NotificationManager) systemService;
                notificationManager.cancel(m(apkDownloadInfoData));
                NotificationCompat.Builder h = h();
                if (Build.VERSION.SDK_INT >= 24) {
                    h.setCustomContentView(remoteViews).setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setPriority(2).setAutoCancel(true);
                } else {
                    h.setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setLargeIcon(bitmap).setContentTitle(apkDownloadInfoData.getApkName()).setContentText(apkDownloadInfoData.getNotificationShowContent()).setPriority(2).setAutoCancel(true);
                }
                Notification build = h.build();
                Intrinsics.checkNotNullExpressionValue(build, "retargetBuilder.build()");
                build.flags |= 32;
                notificationManager.notify(m(apkDownloadInfoData), build);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
    }

    public final void u(ApkDownloadInfoData apkDownloadInfoData, boolean z) {
        int notificationShowCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, apkDownloadInfoData, z) == null) {
            if (z) {
                notificationShowCount = 0;
            } else {
                notificationShowCount = apkDownloadInfoData.getNotificationShowCount() + 1;
            }
            apkDownloadInfoData.setNotificationShowCount(notificationShowCount);
            TbDownloadManager tbDownloadManager = new TbDownloadManager();
            ksa i = tbDownloadManager.m().i(apkDownloadInfoData.getItemId());
            if (i == null) {
                return;
            }
            ItemData itemData = new ItemData();
            itemData.parseJson(i.c());
            itemData.notificationShowCount++;
            i.i(tbDownloadManager.m().a(itemData));
            tbDownloadManager.m().m(i);
        }
    }
}
