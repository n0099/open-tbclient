package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.refresh.LoadAnimStrategy;
import com.baidu.live.business.view.emotion.EmotionStrategy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ss5 {
    public static /* synthetic */ Interceptable $ic;
    public static ss5 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ss5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-422074218, "Lcom/baidu/tieba/ss5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-422074218, "Lcom/baidu/tieba/ss5$b;");
                    return;
                }
            }
            a = new ss5(null);
        }
    }

    public /* synthetic */ ss5(a aVar) {
        this();
    }

    public static ss5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = b.a;
            }
            return a;
        }
        return (ss5) invokeV.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 1 ? "night" : i == 4 ? "dark" : "day" : (String) invokeI.objValue;
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            if (!LiveFeedPageSdk.getInstance().isInit()) {
                LoadAnimStrategy.getInstance().pullDownLottieResId = R.raw.lottie_common_pull_refresh;
                LoadAnimStrategy.getInstance().pullDownLottieResId1 = R.raw.obfuscated_res_0x7f110031;
                LoadAnimStrategy.getInstance().pullDownLottieResId2 = R.raw.obfuscated_res_0x7f110032;
                LoadAnimStrategy.getInstance().pullDownLottieResId3 = R.raw.obfuscated_res_0x7f110031;
                LoadAnimStrategy.getInstance().pullEndFrame = 15;
                LoadAnimStrategy.getInstance().loopStartFrame = 15;
                LoadAnimStrategy.getInstance().loopEndFrame = 30;
                LoadAnimStrategy.getInstance().lottieTotalFrame = 30;
                LoadAnimStrategy.getInstance().setLoadMoreAnimStrategy("live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json");
                LoadAnimStrategy.getInstance().setLoadingLottieResId(R.raw.lottie_full_screen_refresh, R.raw.obfuscated_res_0x7f11003e, R.raw.obfuscated_res_0x7f11003f, R.raw.obfuscated_res_0x7f11003e, "", 67.0f, 67.0f);
                EmotionStrategy.getInstance().setEmptyImageRes(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                EmotionStrategy.getInstance().setErrorImageRes(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                EmotionStrategy.getInstance().setNetworkImageRes(R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, 125.0f, 125.0f);
                EmotionStrategy.getInstance().setPlaceHolderRes(R.drawable.obfuscated_res_0x7f080cda, R.drawable.obfuscated_res_0x7f080cdb, R.drawable.obfuscated_res_0x7f080cd9, R.drawable.obfuscated_res_0x7f080cda);
                LiveFeedPageSdk.getInstance().initNetWork(new hj7());
                LiveFeedPageSdk.getInstance().initHostInfo("tieba", b(TbadkCoreApplication.getInst().getSkinType()));
                LiveFeedPageSdk.getInstance().initInvoke(new ts5());
                LiveFeedPageSdk.getInstance().setInit();
            }
            LiveFeedPageSdk.getInstance().setContext(context);
            if (LiveFeedPageSdk.getInstance().getInvoker() == null || TextUtils.isEmpty(LiveFeedPageSdk.getInstance().getInvoker().getUIMode())) {
                return;
            }
            LiveFeedPageSdk.getInstance().updateUiMode(LiveFeedPageSdk.getInstance().getInvoker().getUIMode());
        }
    }

    public ss5() {
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
