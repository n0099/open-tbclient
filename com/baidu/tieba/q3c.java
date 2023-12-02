package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.CPUAdRequest;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunModuleAdSlot;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdLargeImgView;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdSmallImgView;
import com.fun.ad.sdk.channel.model.baidu.FunModuleAdSlotBaidu;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class q3c extends ReporterPidLoader<IBasicCPUData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<IBasicCPUData, NativeCPUManager.CPUAdListener> e;
    public boolean f;

    /* loaded from: classes7.dex */
    public class a implements NativeCPUManager.CPUAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q3c a;

        public a(q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q3cVar;
        }

        @Override // com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener
        public void onAdError(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                this.a.onError(i, str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener
        public void onAdLoaded(List<IBasicCPUData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (IBasicCPUData iBasicCPUData : list) {
                    if (TextUtils.equals(iBasicCPUData.getType(), "ad")) {
                        arrayList.add(iBasicCPUData);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.a.onError(0, "NoFill");
                } else {
                    this.a.onAdLoaded(arrayList);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener
        public void onDisLikeAdClick(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener
        public void onExitLp() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener
        public void onLpCustomEventCallBack(HashMap<String, Object> hashMap, NativeCPUManager.DataPostBackListener dataPostBackListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, hashMap, dataPostBackListener) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener
        public void onVideoDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener
        public void onVideoDownloadSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q3c(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.NATIVE), pid, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new FunNativeAdListenerHelper<>(this);
        this.f = false;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new e3c(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            IBasicCPUData iBasicCPUData = (IBasicCPUData) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, obj)) == null) {
            IBasicCPUData iBasicCPUData = (IBasicCPUData) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, iBasicCPUData, new t2c(iBasicCPUData), new s3c(this, this, context));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        FunModuleAdSlotBaidu funModuleAdSlotBaidu;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
            this.f = funAdSlot.isSmallImgStyle();
            a aVar = new a(this);
            FunModuleAdSlot funModuleAdSlot = funAdSlot.getModuleAdSlotMap().get("baidu");
            if (funModuleAdSlot instanceof FunModuleAdSlotBaidu) {
                funModuleAdSlotBaidu = (FunModuleAdSlotBaidu) funModuleAdSlot;
            } else {
                funModuleAdSlotBaidu = null;
            }
            NativeCPUManager nativeCPUManager = new NativeCPUManager(context.getApplicationContext(), this.mPid.ssp.sspId, aVar);
            CPUAdRequest.Builder builder = new CPUAdRequest.Builder();
            builder.setCustomUserId(FunAdSdk.getBaiduCustomUserId()).setDownloadAppConfirmPolicy(3);
            if (funModuleAdSlotBaidu != null) {
                builder.setSubChannelId(funModuleAdSlotBaidu.subChannelId);
            }
            nativeCPUManager.setRequestParameter(builder.build());
            nativeCPUManager.setRequestTimeoutMillis(10000);
            nativeCPUManager.setPageSize(10);
            try {
                nativeCPUManager.loadAd(1, Integer.parseInt(this.mPid.pid), true);
            } catch (NumberFormatException unused) {
                onError(1, "F:invalid pid:" + this.mPid.pid);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        View creativeView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            IBasicCPUData iBasicCPUData = (IBasicCPUData) obj;
            LayoutInflater from = LayoutInflater.from(activity);
            this.e.startShow(iBasicCPUData, str, this.mPid, null, null);
            if (this.f) {
                BaiduNativeCpuAdSmallImgView baiduNativeCpuAdSmallImgView = (BaiduNativeCpuAdSmallImgView) from.inflate(R.layout.fun_baidu_ad_native_cpu_small_img_view, viewGroup, false);
                viewGroup.removeAllViews();
                viewGroup.addView(baiduNativeCpuAdSmallImgView);
                baiduNativeCpuAdSmallImgView.a(iBasicCPUData);
                creativeView = baiduNativeCpuAdSmallImgView.getCreativeView();
            } else {
                BaiduNativeCpuAdLargeImgView baiduNativeCpuAdLargeImgView = (BaiduNativeCpuAdLargeImgView) from.inflate(R.layout.fun_baidu_ad_native_cpu_large_img_view, viewGroup, false);
                viewGroup.removeAllViews();
                viewGroup.addView(baiduNativeCpuAdLargeImgView);
                baiduNativeCpuAdLargeImgView.a(iBasicCPUData);
                creativeView = baiduNativeCpuAdLargeImgView.getCreativeView();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(viewGroup);
            ArrayList arrayList2 = new ArrayList();
            if (creativeView != null) {
                arrayList2.add(creativeView);
            }
            if (iBasicCPUData != null) {
                iBasicCPUData.registerViewForInteraction(viewGroup, arrayList, arrayList2, new r3c(this, iBasicCPUData));
                return true;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
