package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdLargeImgView;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdSmallImgView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class wyb extends FunNativeAd2Bridger<IBasicCPUData, View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ uyb d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wyb(uyb uybVar, ReporterPidLoader reporterPidLoader, Context context) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uybVar, reporterPidLoader, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ReporterPidLoader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = uybVar;
        this.c = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdSmallImgView */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public View createExpressView(IBasicCPUData iBasicCPUData) {
        InterceptResult invokeL;
        View creativeView;
        BaiduNativeCpuAdLargeImgView baiduNativeCpuAdLargeImgView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iBasicCPUData)) == null) {
            IBasicCPUData iBasicCPUData2 = iBasicCPUData;
            LayoutInflater from = LayoutInflater.from(this.c);
            if (this.d.f) {
                BaiduNativeCpuAdSmallImgView baiduNativeCpuAdSmallImgView = (BaiduNativeCpuAdSmallImgView) from.inflate(R.layout.fun_baidu_ad_native_cpu_small_img_view, (ViewGroup) null, false);
                baiduNativeCpuAdSmallImgView.a(iBasicCPUData2);
                creativeView = baiduNativeCpuAdSmallImgView.getCreativeView();
                baiduNativeCpuAdLargeImgView = baiduNativeCpuAdSmallImgView;
            } else {
                BaiduNativeCpuAdLargeImgView baiduNativeCpuAdLargeImgView2 = (BaiduNativeCpuAdLargeImgView) from.inflate(R.layout.fun_baidu_ad_native_cpu_large_img_view, (ViewGroup) null, false);
                baiduNativeCpuAdLargeImgView2.a(iBasicCPUData2);
                creativeView = baiduNativeCpuAdLargeImgView2.getCreativeView();
                baiduNativeCpuAdLargeImgView = baiduNativeCpuAdLargeImgView2;
            }
            this.b = creativeView;
            return baiduNativeCpuAdLargeImgView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, IBasicCPUData iBasicCPUData, BaseNativeAd2<IBasicCPUData, View> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, iBasicCPUData, baseNativeAd2, funAdInteractionListener}) == null) {
            IBasicCPUData iBasicCPUData2 = iBasicCPUData;
            uyb uybVar = this.d;
            FunNativeAdListenerHelper<IBasicCPUData, NativeCPUManager.CPUAdListener> funNativeAdListenerHelper = uybVar.e;
            pid = uybVar.mPid;
            funNativeAdListenerHelper.startShow(iBasicCPUData2, str, pid, null, funAdInteractionListener);
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                inflate = ((FunNativeView) inflate).getRoot();
            }
            uyb uybVar2 = this.d;
            List<View> clickViews = customInflater.getClickViews();
            List<View> creativeViews = customInflater.getCreativeViews();
            uybVar2.getClass();
            if (iBasicCPUData2 != null) {
                iBasicCPUData2.registerViewForInteraction(inflate, clickViews, creativeViews, new vyb(uybVar2, iBasicCPUData2));
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, IBasicCPUData iBasicCPUData, BaseNativeAd2<IBasicCPUData, View> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, iBasicCPUData, baseNativeAd2, funAdInteractionListener}) == null) {
            IBasicCPUData iBasicCPUData2 = iBasicCPUData;
            uyb uybVar = this.d;
            FunNativeAdListenerHelper<IBasicCPUData, NativeCPUManager.CPUAdListener> funNativeAdListenerHelper = uybVar.e;
            pid = uybVar.mPid;
            funNativeAdListenerHelper.startShow(iBasicCPUData2, str, pid, null, funAdInteractionListener);
            ViewGroup inflate = expressInflater.inflate();
            ArrayList arrayList = new ArrayList();
            arrayList.add(inflate);
            ArrayList arrayList2 = new ArrayList();
            View view2 = this.b;
            if (view2 != null) {
                arrayList2.add(view2);
            } else {
                arrayList2.add(inflate);
            }
            uyb uybVar2 = this.d;
            uybVar2.getClass();
            if (iBasicCPUData2 != null) {
                iBasicCPUData2.registerViewForInteraction(inflate, arrayList, arrayList2, new vyb(uybVar2, iBasicCPUData2));
            }
        }
    }
}
