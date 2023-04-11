package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes6.dex */
public class qq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, obj, z) == null) {
            b(obj, z, false);
        }
    }

    public static void b(Object obj, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{obj, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c(obj, z, z2, false);
        }
    }

    public static void c(Object obj, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{obj, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || obj == null) {
            return;
        }
        try {
            Field field = obj.getClass().getField("common");
            int i = 1;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            CommonReq.Builder builder = new CommonReq.Builder();
            builder._client_type = 2;
            builder._client_version = TbConfig.getVersion();
            builder._client_id = TbadkCoreApplication.getClientId();
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                builder.subapp_type = TbConfig.getSubappType();
            }
            if (!TbadkCoreApplication.getInst().isOfficial()) {
                builder.apid = TbConfig.SW_APID;
            }
            builder._phone_imei = TbadkCoreApplication.getInst().getImei();
            builder.from = TbadkCoreApplication.getFrom();
            builder.cuid = TbadkCoreApplication.getInst().getCuid();
            builder.cuid_galaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            builder.c3_aid = TbadkCoreApplication.getInst().getCuidGalaxy3();
            builder.cuid_gid = TbadkCoreApplication.getInst().getCuidGid();
            builder._timestamp = Long.valueOf(System.currentTimeMillis());
            builder.model = ki.g();
            builder._os_version = ki.k();
            builder.brand = Build.BRAND;
            builder.user_agent = ur5.b();
            if (z) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.BDUSS = zi5.b();
                    if (!StringUtils.isNull(zi5.e())) {
                        builder.stoken = zi5.e();
                    }
                } else {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        builder.BDUSS = currentAccountInfo.getBDUSS();
                        String a = vv4.a(currentAccountInfo);
                        if (!StringUtils.isNull(a)) {
                            builder.stoken = a;
                        }
                    }
                }
            }
            if (z2) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.tbs = zi5.f();
                } else {
                    builder.tbs = TbadkCoreApplication.getInst().getTbs();
                }
            }
            if (z3) {
                builder.applist = TbadkCoreApplication.getInst().getInstalledAppIds();
            }
            builder.mac = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            builder.pversion = TiebaIMConfig.PROTOBUF_VERSION;
            builder.lego_lib_version = TbConfig.getLegoLibVersion();
            if (p45.m().n("android_safe_sdk_open", 0) == 1) {
                builder.z_id = TbadkCoreApplication.getInst().getZid();
            }
            builder.net_type = Integer.valueOf(BdNetTypeUtil.netType());
            builder.oaid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            builder.sample_id = TbSingleton.getInstance().getSampleId();
            builder.is_teenager = 0;
            builder.sdk_ver = TbadkCoreApplication.getInst().getSdk_ver();
            builder.framework_ver = TbadkCoreApplication.getInst().getFramework_ver();
            builder.naws_game_ver = TbadkCoreApplication.getInst().getNaws_game_ver();
            builder.q_type = Integer.valueOf(rv4.c().e());
            builder.scr_h = Integer.valueOf(ii.j(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(ii.l(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(ii.i(TbadkCoreApplication.getInst()));
            builder.active_timestamp = Long.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
            builder.first_install_time = Long.valueOf(TbSingleton.getInstance().getAppFirstInstallTime());
            builder.last_update_time = Long.valueOf(TbSingleton.getInstance().getAppLastUpdateTime());
            builder.event_day = TbSingleton.getInstance().getData();
            builder.android_id = TbadkCoreApplication.getInst().getAndroidId();
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                i = 2;
            }
            builder.cmode = Integer.valueOf(i);
            builder.start_type = Integer.valueOf(e35.f);
            builder.start_scheme = e35.e();
            builder.extra = p45.m().s("key_sync_extra_field", "");
            builder.personalized_rec_switch = Integer.valueOf(TbSingleton.getInstance().getPersonalizedRecSwitch());
            builder.device_score = String.valueOf(ScheduleStrategy.getDeviceScore());
            field.set(obj, builder.build(false));
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                th.printStackTrace();
            }
        }
    }
}
