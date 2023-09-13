package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class qob implements TTRewardVideoAd.RewardAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ vpb d;
    public final /* synthetic */ jqb e;

    public qob(jqb jqbVar, String str, vpb vpbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jqbVar, str, vpbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = jqbVar;
        this.c = str;
        this.d = vpbVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.e.onAdClose((jqb) this.d, this.c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            HashMap hashMap = new HashMap();
            hashMap.put("tid", this.c);
            hashMap.put("p_req_id", this.d.c());
            this.e.onAdShow((jqb) this.d, this.a, (Map<String, String>) hashMap);
            this.a = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            HashMap hashMap = new HashMap();
            hashMap.put("tid", this.c);
            hashMap.put("p_req_id", this.d.c());
            this.e.onAdClicked((jqb) this.d, this.b, (Map<String, String>) hashMap);
            this.b = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardArrived(boolean z, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), bundle}) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2), str2}) == null) {
            LogPrinter.d("onRewardVerify rewardVerify:%b rewardAmount:%d rewardName:%s errCode:%d errMsg:%s", Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2), str2);
            HashMap hashMap = new HashMap();
            hashMap.put("tid", this.c);
            hashMap.put("p_req_id", this.d.c());
            this.e.onRewardedVideo(this.d, z, i2, hashMap);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LogPrinter.e("CSJRewardVideoAd onSkippedVideo", new Object[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LogPrinter.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LogPrinter.d();
            this.e.onAdError(this.d, 0, "F:onVideoError", this.c);
        }
    }
}
