package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tieba.iy7;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.FunNativeViewInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.channel.ModuleConfigCsj;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.kwad.sdk.api.KsCustomController;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class ry7 implements iy7.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public p a;
    public HashMap<String, Long> b;
    public final FunAdCallback c;

    /* loaded from: classes7.dex */
    public class b implements iy7.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunNativeAd2 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ViewGroup d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ FunAdInteractionListener g;

        /* loaded from: classes7.dex */
        public class a extends FunNativeViewInflater {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, FunNativeAd2 funNativeAd2) {
                super(funNativeAd2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, funNativeAd2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((FunNativeAd2) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
            }

            @Override // com.fun.ad.sdk.CustomInflater
            public List<View> getClickViews() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.c.b;
                }
                return (List) invokeV.objValue;
            }

            @Override // com.fun.ad.sdk.CustomInflater
            public List<View> getCreativeViews() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.c.c;
                }
                return (List) invokeV.objValue;
            }
        }

        public b(ry7 ry7Var, FunNativeAd2 funNativeAd2, List list, List list2, ViewGroup viewGroup, Activity activity, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, funNativeAd2, list, list2, viewGroup, activity, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = funNativeAd2;
            this.b = list;
            this.c = list2;
            this.d = viewGroup;
            this.e = activity;
            this.f = str;
            this.g = funAdInteractionListener;
        }

        @Override // com.baidu.tieba.iy7.k
        public void initComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.getNativeType() == FunNativeAd2.NativeType.EXPRESS) {
                return;
            }
            a aVar = new a(this, this.a);
            ViewGroup viewGroup = null;
            if (this.d.getParent() instanceof ViewGroup) {
                viewGroup = (ViewGroup) this.d.getParent();
                viewGroup.removeView(this.d);
            }
            FunNativeView inflate = FunNativeView.inflate(this.e, this.d);
            if (viewGroup != null) {
                viewGroup.addView(inflate);
            }
            aVar.setFunNativeView(inflate);
            this.a.show(this.e, aVar, this.f, this.g);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7.h a;
        public final /* synthetic */ iy7.f b;
        public final /* synthetic */ ry7 c;

        public a(ry7 ry7Var, iy7.h hVar, iy7.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, hVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ry7Var;
            this.a = hVar;
            this.b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            iy7.h hVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (hVar = this.a) != null) {
                hVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            iy7.h hVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (hVar = this.a) != null) {
                hVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            iy7.h hVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (hVar = this.a) != null) {
                hVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7.h a;
        public final /* synthetic */ iy7.f b;
        public final /* synthetic */ ry7 c;

        public c(ry7 ry7Var, iy7.h hVar, iy7.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, hVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ry7Var;
            this.a = hVar;
            this.b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FunAdSdkImpl", "开屏广告：小熊广告onAdClicked， sid is：" + str + " ,sspType is: " + str2 + " ,pid is: " + str3);
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdClicked(str, str2, str3);
                }
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FunAdSdkImpl", "开屏广告：小熊广告onRewardedVideo， sid is：" + str + " ,sspType is: " + str2 + " ,pid is: " + str3);
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str);
                }
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FunAdSdkImpl", "开屏广告：小熊广告onAdClose， sid is：" + str);
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdClose(str);
                }
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FunAdSdkImpl", "开屏广告：小熊广告onAdError， sid is：" + str);
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FunAdSdkImpl", "开屏广告：小熊广告onAdShow， sid is：" + str + " ,sspType is: " + str2 + " ,pid is: " + str3);
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdShow(str, str2, str3);
                }
                if (this.c.a != null) {
                    this.c.a.b = str;
                    this.c.a.c = str2;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "BEAR ad sspType=" + str2 + ", sid=" + str + " ,pid=" + str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements iy7.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;
        public final /* synthetic */ ry7 e;

        public d(ry7 ry7Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ry7Var;
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funAdInteractionListener;
        }

        @Override // com.baidu.tieba.iy7.k
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunSplashAd showSplash = FunAdSdk.getAdFactory().showSplash(this.a, this.b, this.c, this.d);
                if (showSplash != null) {
                    this.e.a = new p();
                    this.e.a.a = showSplash;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "BEAR ad showSplash:" + this.e.a);
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FunAdSdkImpl", "开屏广告：小熊广告initComplete， showSplash, mFunSplashAd is: " + this.e.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends TTCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ry7 ry7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        /* renamed from: a */
        public TTLocation getTTLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new TTLocation(JavaTypesHelper.toDouble(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), JavaTypesHelper.toDouble(TbadkCoreApplication.getInst().getLocationLat(), 0.0d));
            }
            return (TTLocation) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return TbadkCoreApplication.getInst().getImei();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends KsCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public f(ry7 ry7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return TbadkCoreApplication.getInst().getAndroidId();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return TbadkCoreApplication.getInst().getImei();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String[] getImeis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new String[]{TbadkCoreApplication.getInst().getImei(), TbadkCoreApplication.getInst().getImei()} : (String[]) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getMacAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Location location = new Location("");
                location.setLatitude(JavaTypesHelper.toDouble(TbadkCoreApplication.getInst().getLocationLat(), 0.0d));
                location.setLongitude(JavaTypesHelper.toDouble(TbadkCoreApplication.getInst().getLocationLng(), 0.0d));
                return location;
            }
            return (Location) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements FunAdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry7 a;

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClose(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShowError(String str, String str2, String str3, int i, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onRewardedVideo(String str, String str2, String str3, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        public g(ry7 ry7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry7Var;
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoad(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
                this.a.b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoaded(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048580, this, str, str2, str3) != null) {
                return;
            }
            this.a.x(str);
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoadError(String str, String str2, String str3, int i, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
                this.a.x(str);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW_ERROR).param("obj_locate", i).param("obj_source", str).param("obj_param1", str4).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, str3));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements FunAdSdk.SdkInitializeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7.k a;

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onModulesInitComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public h(ry7 ry7Var, iy7.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                iy7.k kVar = this.a;
                if (kVar != null) {
                    kVar.initComplete();
                    xy7.a("小熊SDK开始初始化完成！");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7.g a;
        public final /* synthetic */ iy7.f b;
        public final /* synthetic */ ry7 c;

        public i(ry7 ry7Var, iy7.g gVar, iy7.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, gVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ry7Var;
            this.a = gVar;
            this.b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                iy7.g gVar = this.a;
                if (gVar != null) {
                    gVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                iy7.g gVar = this.a;
                if (gVar != null) {
                    gVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements iy7.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public j(ry7 ry7Var, WeakReference weakReference, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, weakReference, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
            this.b = funAdSlot;
            this.c = funAdLoadListener;
        }

        @Override // com.baidu.tieba.iy7.k
        public void initComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() != null) {
                FunAdSdk.getAdFactory().loadAd((Context) this.a.get(), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7.h a;
        public final /* synthetic */ iy7.f b;
        public final /* synthetic */ ry7 c;

        public k(ry7 ry7Var, iy7.h hVar, iy7.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, hVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ry7Var;
            this.a = hVar;
            this.b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            iy7.h hVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (hVar = this.a) != null) {
                hVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            iy7.h hVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (hVar = this.a) != null) {
                hVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            iy7.h hVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (hVar = this.a) != null) {
                hVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                iy7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements iy7.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;

        public l(ry7 ry7Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funAdInteractionListener;
        }

        @Override // com.baidu.tieba.iy7.k
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements iy7.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public m(ry7 ry7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.tieba.iy7.k
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy7.g a;
        public final /* synthetic */ iy7.f b;
        public final /* synthetic */ ry7 c;

        public n(ry7 ry7Var, iy7.g gVar, iy7.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, gVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ry7Var;
            this.a = gVar;
            this.b = fVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                iy7.g gVar = this.a;
                if (gVar != null) {
                    gVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                iy7.g gVar = this.a;
                if (gVar != null) {
                    gVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements iy7.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public o(ry7 ry7Var, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry7Var, activity, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = funAdSlot;
            this.c = funAdLoadListener;
        }

        @Override // com.baidu.tieba.iy7.k
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FunAdSdk.getAdFactory().loadAd(this.a, this.b, this.c);
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FunSplashAd a;
        public String b;
        public String c;

        public p() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948138041, "Lcom/baidu/tieba/ry7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948138041, "Lcom/baidu/tieba/ry7;");
                return;
            }
        }
        d = GlobalBuildConfig.getFunAdAppId();
    }

    public ry7() {
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
        this.b = new HashMap<>();
        this.c = new g(this);
    }

    public final ModuleConfigCsj.Builder v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return new ModuleConfigCsj.Builder().setTitleBarTheme(1).setTtSupportMultiProcess(true).setTTCustomController(new e(this));
        }
        return (ModuleConfigCsj.Builder) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iy7.e
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            u(new m(this, str));
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public ViewGroup e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return new NativeAdContainer(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.iy7.e
    public View f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                qy7.D(funNativeAd2);
                qy7.E(funNativeAd2);
                return qy7.m(funNativeAd2);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.iy7.e
    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                return qy7.M((FunNativeAd2) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iy7.e
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            u(null);
            if (FunAdSdk.isSdkInitializeComplete() && FunAdSdk.getAdFactory().isAdReady(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u(iy7.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kVar) == null) {
            k(TbadkCoreApplication.getInst(), kVar);
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public void c(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, obj) == null) && (obj instanceof FunNativeAd2) && imageView != null) {
            qy7.L(imageView, (FunNativeAd2) obj);
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public Object i(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().getNativeAd2(TbadkCoreApplication.getInst().getApplicationContext(), str);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.iy7.e
    public void j(Object obj, iy7.i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, obj, iVar) == null) && (obj instanceof FunNativeAd2)) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
            qy7.K(funNativeAd2, qy7.s(funNativeAd2), iVar);
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public void g(Activity activity, String str, ViewGroup viewGroup, iy7.h hVar, iy7.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048583, this, activity, str, viewGroup, hVar, fVar) != null) || viewGroup == null) {
            return;
        }
        u(new d(this, activity, viewGroup, str, new c(this, hVar, fVar)));
    }

    @Override // com.baidu.tieba.iy7.e
    public void n(Activity activity, String str, ViewGroup viewGroup, iy7.h hVar, iy7.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048591, this, activity, str, viewGroup, hVar, fVar) != null) || viewGroup == null) {
            return;
        }
        u(new l(this, activity, viewGroup, str, new k(this, hVar, fVar)));
    }

    @Override // com.baidu.tieba.iy7.e
    public void b(Activity activity, String str, int i2, iy7.g gVar, iy7.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, str, Integer.valueOf(i2), gVar, fVar}) == null) {
            u(new o(this, activity, new FunAdSlot.Builder().setSid(str).setAdCount(i2).setExpressWidth(BdUtilHelper.getEquipmentWidth(activity)).build(), new n(this, gVar, fVar)));
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public void d(Context context, String str, int i2, int i3, iy7.g gVar, iy7.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), gVar, fVar}) == null) {
            FunAdSlot.Builder builder = new FunAdSlot.Builder();
            builder.setSid(str).setAdCount(i2).setExpressWidth(BdUtilHelper.getEquipmentWidth(context));
            if (i3 > 0) {
                builder.setExpressHeight(i3);
            }
            u(new j(this, new WeakReference(context), builder.build(), new i(this, gVar, fVar)));
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public void k(Application application, iy7.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, application, kVar) == null) {
            if (FunAdSdk.isSdkInitializeComplete()) {
                if (kVar != null) {
                    kVar.initComplete();
                    return;
                }
                return;
            }
            FunAdConfig.Builder builder = new FunAdConfig.Builder(application);
            if (hw5.c()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_CSJ);
                xy7.a("不初始化 PLATFORM_CSJ");
            } else {
                xy7.a("初始化 PLATFORM_CSJ");
            }
            if (hw5.d()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_GDT);
                xy7.a("不初始化 PLATFORM_GDT");
            } else {
                xy7.a("初始化 PLATFORM_GDT");
            }
            if (hw5.e()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_KS);
                xy7.a("不初始化 PLATFORM_KS");
            } else {
                xy7.a("初始化 PLATFORM_KS");
            }
            boolean z = true;
            FunAdConfig.Builder videoDataFlowAutoStart = builder.setAppName(application.getString(R.string.obfuscated_res_0x7f0f029e)).setAppId(d).setUserId("").setUseTextureView(true).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false);
            if (!GlobalBuildConfig.isFunAdTestTest() && !GlobalBuildConfig.isTiebaDebugTool() && !TbadkCoreApplication.getInst().isDebugMode()) {
                z = false;
            }
            videoDataFlowAutoStart.setLogEnabled(z).setKsAdConfig(w().build()).setCsjAdConfig(v().build());
            GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
            xy7.a("小熊SDK开始初始化，APPID 是：" + d);
            FunAdSdk.init(builder.build(), this.c, new h(this, kVar));
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public List<hy7> l(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (!FunAdSdk.isSdkInitializeComplete()) {
                return new ArrayList();
            }
            List<CacheStatistic> cacheStatistics = FunAdSdk.getAdFactory().getCacheStatistics(str);
            ArrayList arrayList = new ArrayList(cacheStatistics.size());
            for (CacheStatistic cacheStatistic : cacheStatistics) {
                FunAdType funAdType = cacheStatistic.adType;
                if (funAdType == null) {
                    str2 = "";
                } else {
                    str2 = funAdType.getAdType().toString();
                }
                FunAdType funAdType2 = cacheStatistic.adType;
                if (funAdType2 == null) {
                    str3 = "";
                } else {
                    str3 = funAdType2.getPlatform();
                }
                arrayList.add(new hy7(str2, str3, cacheStatistic.pid, cacheStatistic.hashCode(), cacheStatistic.count, cacheStatistic.basePrice));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void x(String str) {
        Long l2;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (l2 = this.b.get(str)) != null) {
            SpeedStatsManager.getInstance().setTaskRunTime("Ad_load" + str, System.currentTimeMillis() - l2.longValue());
            SpeedStatsManager speedStatsManager = SpeedStatsManager.getInstance();
            String str2 = "Ad_end" + str;
            if (SpeedStatsManager.getInstance().isAdLoadEnd()) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            speedStatsManager.setTaskRunTime(str2, j2);
            this.b.remove(str);
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public void m(Activity activity, @NonNull Object obj, iy7.h hVar, ViewGroup viewGroup, List<View> list, List<View> list2, iy7.f fVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{activity, obj, hVar, viewGroup, list, list2, fVar, str}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd2)) {
            u(new b(this, (FunNativeAd2) obj, list, list2, viewGroup, activity, str, new a(this, hVar, fVar)));
        }
    }

    @Override // com.baidu.tieba.iy7.e
    public ora o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            ora oraVar = null;
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                int s = qy7.s(funNativeAd2);
                if (s == -1) {
                    return null;
                }
                oraVar = new ora();
                String c2 = qy7.c(funNativeAd2, s);
                if (ei.isEmpty(c2)) {
                    c2 = "推广";
                }
                oraVar.k(c2);
                oraVar.l(qy7.v(funNativeAd2, s));
                oraVar.j(qy7.q(funNativeAd2, s));
                oraVar.g(qy7.n(funNativeAd2));
                oraVar.h(qy7.b(funNativeAd2));
                oraVar.i(s);
            }
            return oraVar;
        }
        return (ora) invokeL.objValue;
    }

    public final ModuleConfigKs.Builder w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new ModuleConfigKs.Builder().setKsCustomController(new f(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen());
        }
        return (ModuleConfigKs.Builder) invokeV.objValue;
    }

    public final void y(String str, String str2, int i2, iy7.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048597, this, str, str2, i2, fVar) == null) {
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("type", "bear");
            logItem.append("locate", fVar.a);
            logItem.append("switch", fVar.b);
            logItem.append("sid", str2);
            logItem.append("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, logItem);
        }
    }
}
