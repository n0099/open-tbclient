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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.zl7;
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
/* loaded from: classes4.dex */
public class im7 implements zl7.f {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public p a;
    public HashMap<String, Long> b;
    public final FunAdCallback c;

    /* loaded from: classes4.dex */
    public class b implements zl7.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunNativeAd2 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ViewGroup d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ FunAdInteractionListener g;

        /* loaded from: classes4.dex */
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

        public b(im7 im7Var, FunNativeAd2 funNativeAd2, List list, List list2, ViewGroup viewGroup, Activity activity, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, funNativeAd2, list, list2, viewGroup, activity, str, funAdInteractionListener};
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

        @Override // com.baidu.tieba.zl7.l
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

    /* loaded from: classes4.dex */
    public class a implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl7.i a;
        public final /* synthetic */ zl7.g b;
        public final /* synthetic */ im7 c;

        public a(im7 im7Var, zl7.i iVar, zl7.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im7Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                zl7.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (iVar = this.a) != null) {
                iVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                zl7.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl7.i a;
        public final /* synthetic */ zl7.g b;
        public final /* synthetic */ im7 c;

        public c(im7 im7Var, zl7.i iVar, zl7.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im7Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (iVar = this.a) != null) {
                iVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                zl7.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                zl7.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
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

    /* loaded from: classes4.dex */
    public class d implements zl7.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;
        public final /* synthetic */ im7 e;

        public d(im7 im7Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = im7Var;
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funAdInteractionListener;
        }

        @Override // com.baidu.tieba.zl7.l
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
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends TTCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(im7 im7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var};
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
                return new TTLocation(gg.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), gg.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d));
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

    /* loaded from: classes4.dex */
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

        public f(im7 im7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var};
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
                location.setLatitude(gg.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d));
                location.setLongitude(gg.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d));
                return location;
            }
            return (Location) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements FunAdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im7 a;

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

        public g(im7 im7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im7Var;
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

    /* loaded from: classes4.dex */
    public class h implements FunAdSdk.SdkInitializeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl7.l a;

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onModulesInitComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public h(im7 im7Var, zl7.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                zl7.l lVar = this.a;
                if (lVar != null) {
                    lVar.initComplete();
                    om7.a("小熊SDK开始初始化完成！");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl7.h a;
        public final /* synthetic */ zl7.g b;
        public final /* synthetic */ im7 c;

        public i(im7 im7Var, zl7.h hVar, zl7.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im7Var;
            this.a = hVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zl7.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                zl7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements zl7.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public j(im7 im7Var, WeakReference weakReference, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, weakReference, funAdSlot, funAdLoadListener};
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

        @Override // com.baidu.tieba.zl7.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() != null) {
                FunAdSdk.getAdFactory().loadAd((Context) this.a.get(), this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl7.i a;
        public final /* synthetic */ zl7.g b;
        public final /* synthetic */ im7 c;

        public k(im7 im7Var, zl7.i iVar, zl7.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im7Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                zl7.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            zl7.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (iVar = this.a) != null) {
                iVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                zl7.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements zl7.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;

        public l(im7 im7Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, activity, viewGroup, str, funAdInteractionListener};
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

        @Override // com.baidu.tieba.zl7.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements zl7.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public m(im7 im7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, str};
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

        @Override // com.baidu.tieba.zl7.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl7.h a;
        public final /* synthetic */ zl7.g b;
        public final /* synthetic */ im7 c;

        public n(im7 im7Var, zl7.h hVar, zl7.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im7Var;
            this.a = hVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zl7.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                zl7.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements zl7.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public o(im7 im7Var, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, activity, funAdSlot, funAdLoadListener};
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

        @Override // com.baidu.tieba.zl7.l
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

    /* loaded from: classes4.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947858390, "Lcom/baidu/tieba/im7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947858390, "Lcom/baidu/tieba/im7;");
                return;
            }
        }
        d = aw4.a();
    }

    public im7() {
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

    @Override // com.baidu.tieba.zl7.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            u(new m(this, str));
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public ViewGroup e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return new NativeAdContainer(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zl7.f
    public View f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                hm7.D(funNativeAd2);
                hm7.E(funNativeAd2);
                return hm7.m(funNativeAd2);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zl7.f
    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                return hm7.M((FunNativeAd2) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zl7.f
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

    public final void u(zl7.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, lVar) == null) {
            k(TbadkCoreApplication.getInst(), lVar);
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public void c(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, obj) == null) && (obj instanceof FunNativeAd2) && imageView != null) {
            hm7.L(imageView, (FunNativeAd2) obj);
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public Object i(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().getNativeAd2(activity, str);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zl7.f
    public void j(Object obj, zl7.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, obj, jVar) == null) && (obj instanceof FunNativeAd2)) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
            hm7.K(funNativeAd2, hm7.s(funNativeAd2), jVar);
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public void g(Activity activity, String str, ViewGroup viewGroup, zl7.i iVar, zl7.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048583, this, activity, str, viewGroup, iVar, gVar) != null) || viewGroup == null) {
            return;
        }
        u(new d(this, activity, viewGroup, str, new c(this, iVar, gVar)));
    }

    @Override // com.baidu.tieba.zl7.f
    public void n(Activity activity, String str, ViewGroup viewGroup, zl7.i iVar, zl7.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048591, this, activity, str, viewGroup, iVar, gVar) != null) || viewGroup == null) {
            return;
        }
        u(new l(this, activity, viewGroup, str, new k(this, iVar, gVar)));
    }

    @Override // com.baidu.tieba.zl7.f
    public void b(Activity activity, String str, int i2, zl7.h hVar, zl7.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, str, Integer.valueOf(i2), hVar, gVar}) == null) {
            u(new o(this, activity, new FunAdSlot.Builder().setSid(str).setAdCount(i2).setExpressWidth(ii.l(activity)).build(), new n(this, hVar, gVar)));
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public void d(Context context, String str, int i2, int i3, zl7.h hVar, zl7.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), hVar, gVar}) == null) {
            FunAdSlot.Builder builder = new FunAdSlot.Builder();
            builder.setSid(str).setAdCount(i2).setExpressWidth(ii.l(context));
            if (i3 > 0) {
                builder.setExpressHeight(i3);
            }
            u(new j(this, new WeakReference(context), builder.build(), new i(this, hVar, gVar)));
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public void k(Application application, zl7.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, application, lVar) == null) {
            if (FunAdSdk.isSdkInitializeComplete()) {
                if (lVar != null) {
                    lVar.initComplete();
                    return;
                }
                return;
            }
            FunAdConfig.Builder builder = new FunAdConfig.Builder(application);
            if (eq5.c()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_CSJ);
                om7.a("不初始化 PLATFORM_CSJ");
            } else {
                om7.a("初始化 PLATFORM_CSJ");
            }
            if (eq5.d()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_GDT);
                om7.a("不初始化 PLATFORM_GDT");
            } else {
                om7.a("初始化 PLATFORM_GDT");
            }
            if (eq5.e()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_KS);
                om7.a("不初始化 PLATFORM_KS");
            } else {
                om7.a("初始化 PLATFORM_KS");
            }
            boolean z = true;
            FunAdConfig.Builder videoDataFlowAutoStart = builder.setAppName(application.getString(R.string.obfuscated_res_0x7f0f029e)).setAppId(d).setUserId("").setUseTextureView(true).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false);
            if (!aw4.g() && !aw4.h() && !TbadkCoreApplication.getInst().isDebugMode()) {
                z = false;
            }
            videoDataFlowAutoStart.setLogEnabled(z).setKsAdConfig(w().build()).setCsjAdConfig(v().build());
            GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
            om7.a("小熊SDK开始初始化，APPID 是：" + d);
            FunAdSdk.init(builder.build(), this.c, new h(this, lVar));
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public List<yl7> l(String str) {
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
                arrayList.add(new yl7(str2, str3, cacheStatistic.pid, cacheStatistic.hashCode(), cacheStatistic.count, cacheStatistic.basePrice));
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

    @Override // com.baidu.tieba.zl7.f
    public void m(Activity activity, @NonNull Object obj, zl7.i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, zl7.g gVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar, str}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd2)) {
            u(new b(this, (FunNativeAd2) obj, list, list2, viewGroup, activity, str, new a(this, iVar, gVar)));
        }
    }

    @Override // com.baidu.tieba.zl7.f
    public oy9 o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            oy9 oy9Var = null;
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                int s = hm7.s(funNativeAd2);
                if (s == -1) {
                    return null;
                }
                oy9Var = new oy9();
                String c2 = hm7.c(funNativeAd2, s);
                if (hi.isEmpty(c2)) {
                    c2 = "推广";
                }
                oy9Var.k(c2);
                oy9Var.l(hm7.v(funNativeAd2, s));
                oy9Var.j(hm7.q(funNativeAd2, s));
                oy9Var.g(hm7.n(funNativeAd2));
                oy9Var.h(hm7.b(funNativeAd2));
                oy9Var.i(s);
            }
            return oy9Var;
        }
        return (oy9) invokeL.objValue;
    }

    public final ModuleConfigKs.Builder w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new ModuleConfigKs.Builder().setKsCustomController(new f(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen());
        }
        return (ModuleConfigKs.Builder) invokeV.objValue;
    }

    public final void y(String str, String str2, int i2, zl7.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048597, this, str, str2, i2, gVar) == null) {
            og a2 = en5.a();
            a2.b("type", "bear");
            a2.b("locate", gVar.a);
            a2.b(SetImageWatermarkTypeReqMsg.SWITCH, gVar.b);
            a2.b("sid", str2);
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
