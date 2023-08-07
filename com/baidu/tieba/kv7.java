package com.baidu.tieba;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.cv7;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class kv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements TTFeedAd.VideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv7.i a;

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, tTFeedAd) == null) {
            }
        }

        public a(cv7.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.a.a(j, j2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-648277281, "Lcom/baidu/tieba/kv7$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-648277281, "Lcom/baidu/tieba/kv7$b;");
                    return;
                }
            }
            int[] iArr = new int[FunNativeAd.InteractionType.values().length];
            a = iArr;
            try {
                iArr[FunNativeAd.InteractionType.TYPE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FunNativeAd.InteractionType.TYPE_DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FunNativeAd.InteractionType.TYPE_BROWSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static boolean A(FunNativeAd2 funNativeAd2, List<String> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, funNativeAd2, list)) == null) {
            if (ListUtils.getCount(list) == 1) {
                z = true;
            } else {
                z = false;
            }
            int u = u(funNativeAd2);
            if (!z || u != 4) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean z(FunNativeAd2 funNativeAd2, List<String> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, funNativeAd2, list)) == null) {
            if (ListUtils.getCount(list) == 1) {
                z = true;
            } else {
                z = false;
            }
            int u = u(funNativeAd2);
            if (!z || u != 2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean B(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, funNativeAd2)) == null) {
            if (m(funNativeAd2) != null) {
                z = true;
            } else {
                z = false;
            }
            int u = u(funNativeAd2);
            if (z && u == 6) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void E(FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, funNativeAd2) == null) {
            Object f = f(funNativeAd2);
            if (f instanceof NativeUnifiedADData) {
                ((NativeUnifiedADData) f).setVideoMute(false);
            }
        }
    }

    public static boolean M(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, funNativeAd2)) == null) {
            if (f(funNativeAd2) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, funNativeAd2)) == null) {
            int i = b.a[g(funNativeAd2).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return 3;
                }
                if (i != 3) {
                    return 1;
                }
                return 4;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static ChannelNativeAds d(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getChannelNativeAds();
            }
            return null;
        }
        return (ChannelNativeAds) invokeL.objValue;
    }

    public static Object e(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, funNativeAd2)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d != null) {
                return d.csjNative;
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static Object f(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, funNativeAd2)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d != null) {
                return d.gdtNative;
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static FunNativeAd.InteractionType g(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getInteractionType();
            }
            return null;
        }
        return (FunNativeAd.InteractionType) invokeL.objValue;
    }

    public static Object h(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, funNativeAd2)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d != null) {
                return d.ksNative;
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static String i(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getDescription();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String j(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getIconUrl();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static List<String> k(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getImageUrls();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String l(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getTitle();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static View m(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getVideoView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static int r(@DimenRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i)) == null) {
            return BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), i);
        }
        return invokeI.intValue;
    }

    public static int s(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || (d = d(funNativeAd2)) == null) {
                return -1;
            }
            if (d.gdtNative != null) {
                return 1;
            }
            if (d.ksNative != null) {
                return 2;
            }
            if (d.csjNative == null) {
                return -1;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static int w(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, funNativeAd2)) == null) {
            if (m(funNativeAd2) != null) {
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static void C(FunNativeAd2 funNativeAd2) {
        String str;
        String str2;
        String str3;
        String str4;
        NativeUnifiedADData nativeUnifiedADData;
        View m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, funNativeAd2) == null) && GlobalBuildConfig.isTiebaDebugTool() && funNativeAd2 != null && d(funNativeAd2) != null) {
            ChannelNativeAds d = d(funNativeAd2);
            FunNativeAd.InteractionType g = g(funNativeAd2);
            List<String> list = null;
            if (g != null) {
                str = g.name();
            } else {
                str = null;
            }
            if (funNativeAd2.getNativeInfo() != null) {
                list = funNativeAd2.getNativeInfo().getImageUrls();
                str2 = funNativeAd2.getNativeInfo().getDescription();
                str3 = funNativeAd2.getNativeInfo().getIconUrl();
                str4 = funNativeAd2.getNativeInfo().getTitle();
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
            }
            Log.e(LogPrinter.TAG, "===== Show Fun Ad Type START ===== ");
            Log.e(LogPrinter.TAG, "isDownloadAd = " + str);
            Log.e(LogPrinter.TAG, "csjNative = " + d.csjNative);
            Log.e(LogPrinter.TAG, "ksNative = " + d.ksNative);
            Log.e(LogPrinter.TAG, "gdtNative = " + d.gdtNative);
            Log.e(LogPrinter.TAG, "jyNative = " + d.jyNative);
            Log.e(LogPrinter.TAG, "imageurls = " + list);
            Log.e(LogPrinter.TAG, "videoView = " + m(funNativeAd2));
            Log.e(LogPrinter.TAG, "interactionType = " + str);
            Log.e(LogPrinter.TAG, "description = " + str2);
            Log.e(LogPrinter.TAG, "iconUrl = " + str3);
            Log.e(LogPrinter.TAG, "title = " + str4);
            Object obj = d.csjNative;
            if (obj instanceof TTNativeAd) {
                TTNativeAd tTNativeAd = (TTNativeAd) obj;
                Log.e(LogPrinter.TAG, "title=" + tTNativeAd.getTitle());
                Log.e(LogPrinter.TAG, "Description=" + tTNativeAd.getDescription());
                Log.e(LogPrinter.TAG, "AppScore=" + tTNativeAd.getAppScore());
                Log.e(LogPrinter.TAG, "Source=" + tTNativeAd.getSource());
                Log.e(LogPrinter.TAG, "AppSize=" + tTNativeAd.getAppSize());
            } else {
                Object obj2 = d.ksNative;
                if (obj2 instanceof KsNativeAd) {
                    KsNativeAd ksNativeAd = (KsNativeAd) obj2;
                    Log.e(LogPrinter.TAG, "AdSourc=" + ksNativeAd.getAdSource());
                    Log.e(LogPrinter.TAG, "AppName=" + ksNativeAd.getAppName());
                    Log.e(LogPrinter.TAG, "AppScore=" + ksNativeAd.getAppScore());
                    Log.e(LogPrinter.TAG, "AppVersion=" + ksNativeAd.getAppVersion());
                    Log.e(LogPrinter.TAG, "AppDownloadCountDes=" + ksNativeAd.getAppDownloadCountDes());
                    Log.e(LogPrinter.TAG, "CorporationName=" + ksNativeAd.getCorporationName());
                    Log.e(LogPrinter.TAG, "PermissionInfo=" + ksNativeAd.getPermissionInfo());
                    Log.e(LogPrinter.TAG, "getAppPrivacyUrl=" + ksNativeAd.getAppPrivacyUrl());
                    Log.e(LogPrinter.TAG, "getActionDescription=" + ksNativeAd.getActionDescription());
                    Log.e(LogPrinter.TAG, "getAdDescription=" + ksNativeAd.getAdDescription());
                    List<KsImage> imageList = ksNativeAd.getImageList();
                    if (imageList != null) {
                        for (KsImage ksImage : imageList) {
                            System.out.println("Test=>ksImage: height=" + ksImage.getHeight() + " width=" + ksImage.getWidth());
                        }
                    }
                    System.out.println("Test=>ksVideo[1]: height=" + ksNativeAd.getVideoHeight() + " width=" + ksNativeAd.getVideoWidth());
                    if (ksNativeAd.getVideoCoverImage() != null) {
                        System.out.println("Test=>ksVideo[2]: height=" + ksNativeAd.getVideoCoverImage().getHeight() + " width=" + ksNativeAd.getVideoCoverImage().getWidth());
                    }
                } else {
                    Object obj3 = d.gdtNative;
                    if (obj3 instanceof NativeUnifiedADData) {
                        Log.e(LogPrinter.TAG, "CTAText=" + nativeUnifiedADData.getCTAText());
                        Log.e(LogPrinter.TAG, "Title=" + nativeUnifiedADData.getTitle());
                        Log.e(LogPrinter.TAG, "AppScore=" + nativeUnifiedADData.getAppScore());
                        Log.e(LogPrinter.TAG, "DownloadCount=" + nativeUnifiedADData.getDownloadCount());
                        Log.e(LogPrinter.TAG, "ECPM=" + nativeUnifiedADData.getECPM());
                        Log.e(LogPrinter.TAG, "isAppAd=" + nativeUnifiedADData.isAppAd());
                        List<String> imgList = ((NativeUnifiedADData) obj3).getImgList();
                        if (imgList != null) {
                            Iterator<String> it = imgList.iterator();
                            while (it.hasNext()) {
                                System.out.println("Test=>gdtImage: image=" + it.next());
                            }
                        }
                        System.out.println("Test=>gdtImage: height=" + nativeUnifiedADData.getPictureHeight() + " width=" + nativeUnifiedADData.getPictureWidth());
                    }
                }
            }
            if (m(funNativeAd2) != null) {
                System.out.println("Test=>mediaView: width=" + m.getWidth() + " height=" + m.getHeight());
            }
            Log.e(LogPrinter.TAG, "===== Show Fun Ad Type END =====\n\n");
        }
    }

    public static void D(FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, funNativeAd2) == null) && s(funNativeAd2) == 3) {
            Object e = e(funNativeAd2);
            if (e instanceof TTDrawFeedAd) {
                TTDrawFeedAd tTDrawFeedAd = (TTDrawFeedAd) e;
                tTDrawFeedAd.setCanInterruptVideoPlay(true);
                tTDrawFeedAd.setPauseIcon(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.icon_pure_video_play208), 67);
            }
        }
    }

    public static String t(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || (d = d(funNativeAd2)) == null) {
                return "";
            }
            if (d.gdtNative != null) {
                return FunAdSdk.PLATFORM_GDT;
            }
            if (d.ksNative != null) {
                return FunAdSdk.PLATFORM_KS;
            }
            if (d.csjNative == null) {
                return "";
            }
            return "cjs";
        }
        return (String) invokeL.objValue;
    }

    public static int x(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || d(funNativeAd2) == null || (d = d(funNativeAd2)) == null) {
                return 0;
            }
            if (d.gdtNative != null) {
                return w(funNativeAd2);
            }
            if (d.ksNative != null) {
                return w(funNativeAd2);
            }
            if (d.csjNative != null) {
                return p(funNativeAd2);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean y(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || (d = d(funNativeAd2)) == null || d.gdtNative != null || d.csjNative != null) {
                return false;
            }
            Object obj = d.ksNative;
            if (!(obj instanceof KsNativeAd)) {
                return false;
            }
            return !TextUtils.isEmpty(((KsNativeAd) obj).getAppIconUrl());
        }
        return invokeL.booleanValue;
    }

    public static void F(ImageView imageView, FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, imageView, funNativeAd2) == null) && funNativeAd2 != null && imageView != null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d == null) {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            } else if (d.gdtNative != null) {
                imageView.setVisibility(0);
                WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f080990, WebPManager.ResourceStateType.NORMAL);
            } else if (d.ksNative != null) {
                imageView.setVisibility(0);
                WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f080991, WebPManager.ResourceStateType.NORMAL);
            } else if (d.csjNative != null) {
                imageView.setVisibility(0);
                WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f08098f, WebPManager.ResourceStateType.NORMAL);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
    }

    public static void G(View view2, boolean z) {
        int i;
        int r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65542, null, view2, z) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                i = r(R.dimen.tbds447);
                r = r(R.dimen.tbds796);
            } else {
                i = -1;
                r = r(R.dimen.tbds504);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.topMargin = r(R.dimen.M_H_X004);
            if (layoutParams.width != i || layoutParams.height != r) {
                layoutParams.width = i;
                layoutParams.height = r;
                view2.setLayoutParams(layoutParams);
            }
        }
    }

    public static void J(View view2, boolean z) {
        int i;
        int r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65545, null, view2, z) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                i = r(R.dimen.tbds515);
                r = r(R.dimen.tbds915);
            } else {
                i = -1;
                r = r(R.dimen.tbds551);
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams.width != i || layoutParams.height != r) {
                layoutParams.width = i;
                layoutParams.height = r;
                view2.setLayoutParams(layoutParams);
            }
        }
    }

    public static void L(ImageView imageView, FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, imageView, funNativeAd2) != null) || funNativeAd2 == null) {
            return;
        }
        ChannelNativeAds d = d(funNativeAd2);
        if (d == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (d.gdtNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f080994, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (d.ksNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f080995, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (d.csjNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f080993, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static String c(FunNativeAd2 funNativeAd2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, funNativeAd2, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return "";
                    }
                    Object e = e(funNativeAd2);
                    if (e instanceof TTNativeAd) {
                        return ((TTNativeAd) e).getTitle();
                    }
                } else {
                    Object h = h(funNativeAd2);
                    if (h instanceof KsNativeAd) {
                        KsNativeAd ksNativeAd = (KsNativeAd) h;
                        if (bi.isEmpty(ksNativeAd.getAppIconUrl())) {
                            return ksNativeAd.getProductName();
                        }
                        return ksNativeAd.getAppName();
                    }
                }
            } else {
                Object f = f(funNativeAd2);
                if (f instanceof NativeUnifiedADData) {
                    return ((NativeUnifiedADData) f).getTitle();
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String q(FunNativeAd2 funNativeAd2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, funNativeAd2, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return "";
                    }
                    Object e = e(funNativeAd2);
                    if (e instanceof TTNativeAd) {
                        return ((TTNativeAd) e).getDescription();
                    }
                } else {
                    Object h = h(funNativeAd2);
                    if (h instanceof KsNativeAd) {
                        return ((KsNativeAd) h).getAdDescription();
                    }
                }
            } else {
                Object f = f(funNativeAd2);
                if (f instanceof NativeUnifiedADData) {
                    return ((NativeUnifiedADData) f).getDesc();
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String v(FunNativeAd2 funNativeAd2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, funNativeAd2, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return "";
                    }
                    Object e = e(funNativeAd2);
                    if (e instanceof TTNativeAd) {
                        return ((TTNativeAd) e).getIcon().getImageUrl();
                    }
                } else {
                    Object h = h(funNativeAd2);
                    if (h instanceof KsNativeAd) {
                        KsNativeAd ksNativeAd = (KsNativeAd) h;
                        if (bi.isEmpty(ksNativeAd.getAppIconUrl())) {
                            return "";
                        }
                        return ksNativeAd.getAppIconUrl();
                    }
                }
            } else {
                Object f = f(funNativeAd2);
                if (f instanceof NativeUnifiedADData) {
                    return ((NativeUnifiedADData) f).getIconUrl();
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static void H(View view2, boolean z, List<String> list) {
        int i;
        int i2;
        int r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{view2, Boolean.valueOf(z), list}) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                i = r(R.dimen.tbds515);
                r = r(R.dimen.tbds915);
            } else {
                i = -1;
                boolean z2 = true;
                if (ListUtils.getCount(list) != 1) {
                    z2 = false;
                }
                if (z2) {
                    i2 = R.dimen.tbds551;
                } else {
                    i2 = R.dimen.tbds213;
                }
                r = r(i2);
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams.width != i || layoutParams.height != r) {
                layoutParams.width = i;
                layoutParams.height = r;
                view2.setLayoutParams(layoutParams);
            }
        }
    }

    public static void I(View view2, boolean z) {
        int r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65544, null, view2, z) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                r = r(R.dimen.tbds33);
            } else {
                r = r(R.dimen.tbds25);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.topMargin = r;
            layoutParams.bottomMargin = 0;
            view2.setLayoutParams(layoutParams);
        }
    }

    public static void K(FunNativeAd2 funNativeAd2, int i, cv7.i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65546, null, funNativeAd2, i, iVar) == null) && i == 3) {
            Object e = e(funNativeAd2);
            if (e instanceof TTFeedAd) {
                ((TTFeedAd) e).setVideoAdListener(new a(iVar));
            }
        }
    }

    public static void N(int i, String str, String str2, oba obaVar) {
        List<String> list;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), str, str2, obaVar}) == null) && obaVar != null && obaVar.e() != null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) obaVar.e();
            String str5 = null;
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                String title = funNativeAd2.getNativeInfo().getTitle();
                String description = funNativeAd2.getNativeInfo().getDescription();
                list = funNativeAd2.getNativeInfo().getImageUrls();
                str3 = title;
                str4 = description;
            } else {
                list = null;
                str3 = null;
                str4 = null;
            }
            String valueOf = String.valueOf(i);
            String g = obaVar.g();
            String d = obaVar.d();
            if (list != null) {
                str5 = list.toString();
            }
            FunAdRecordHttpMessage.uploadShowOrClickRecord(str, str2, valueOf, g, d, str3, str4, str5, t(funNativeAd2), String.valueOf(x(funNativeAd2)));
        }
    }

    public static void a(StatisticItem statisticItem, oba obaVar) {
        List<String> list;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, null, statisticItem, obaVar) == null) && statisticItem != null && obaVar != null && obaVar.e() != null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) obaVar.e();
            statisticItem.param("tid", obaVar.g());
            statisticItem.param("fid", obaVar.d());
            statisticItem.param(TiebaStatic.Params.AD_TYPE, x(funNativeAd2));
            statisticItem.param(TiebaStatic.Params.AD_SOURCE, t(funNativeAd2));
            String str2 = null;
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                str2 = funNativeAd2.getNativeInfo().getTitle();
                str = funNativeAd2.getNativeInfo().getDescription();
                list = funNativeAd2.getNativeInfo().getImageUrls();
            } else {
                list = null;
                str = null;
            }
            statisticItem.param(TiebaStatic.Params.AD_TITLE, str2);
            statisticItem.param(TiebaStatic.Params.AD_DESC, str);
            if (list != null) {
                statisticItem.param("ad_pic", list.toString());
            }
        }
    }

    public static String o(@NonNull FunNativeAd2 funNativeAd2, @NonNull Context context) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, funNativeAd2, context)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            int i2 = R.string.obfuscated_res_0x7f0f00d7;
            if (d == null) {
                return context.getString(R.string.obfuscated_res_0x7f0f00d7);
            }
            Object obj = d.ksNative;
            if (obj instanceof KsNativeAd) {
                return ((KsNativeAd) obj).getActionDescription();
            }
            int i3 = b.a[g(funNativeAd2).ordinal()];
            int i4 = R.string.obfuscated_res_0x7f0f00da;
            if (i3 != 1) {
                if (i3 != 2) {
                    i = R.string.obfuscated_res_0x7f0f00d7;
                } else {
                    i = R.string.obfuscated_res_0x7f0f00d9;
                }
            } else {
                i = R.string.obfuscated_res_0x7f0f00da;
            }
            Object obj2 = d.gdtNative;
            if (!(obj2 instanceof NativeUnifiedADData) || !((NativeUnifiedADData) obj2).isAppAd()) {
                i4 = i;
            }
            if (i4 != 0) {
                i2 = i4;
            }
            return context.getString(i2);
        }
        return (String) invokeLL.objValue;
    }

    public static String n(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, funNativeAd2)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d == null) {
                return TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f00d7);
            }
            Object obj = d.ksNative;
            if (obj instanceof KsNativeAd) {
                return ((KsNativeAd) obj).getActionDescription();
            }
            int i2 = b.a[g(funNativeAd2).ordinal()];
            int i3 = R.string.obfuscated_res_0x7f0f00d8;
            int i4 = R.string.obfuscated_res_0x7f0f00da;
            if (i2 != 1) {
                if (i2 != 2) {
                    i = R.string.obfuscated_res_0x7f0f00d8;
                } else {
                    i = R.string.obfuscated_res_0x7f0f00d9;
                }
            } else {
                i = R.string.obfuscated_res_0x7f0f00da;
            }
            Object obj2 = d.gdtNative;
            if (!(obj2 instanceof NativeUnifiedADData) || !((NativeUnifiedADData) obj2).isAppAd()) {
                i4 = i;
            }
            if (i4 != 0) {
                i3 = i4;
            }
            return TbadkCoreApplication.getInst().getContext().getString(i3);
        }
        return (String) invokeL.objValue;
    }

    public static int p(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, funNativeAd2)) == null) {
            if (d(funNativeAd2) == null || !(e(funNativeAd2) instanceof TTNativeAd) || (tTNativeAd = (TTNativeAd) e(funNativeAd2)) == null) {
                return 0;
            }
            if (tTNativeAd.getImageMode() == 2) {
                return 6;
            }
            if (tTNativeAd.getImageMode() == 3) {
                return 1;
            }
            if (tTNativeAd.getImageMode() == 4) {
                return 5;
            }
            if (tTNativeAd.getImageMode() == 5) {
                return 2;
            }
            if (tTNativeAd.getImageMode() == 15) {
                return 4;
            }
            if (tTNativeAd.getImageMode() != 16) {
                return 0;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static int u(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        KsImage ksImage;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && d(funNativeAd2) != null) {
                int s = s(funNativeAd2);
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3 || (tTNativeAd = (TTNativeAd) e(funNativeAd2)) == null) {
                            return -1;
                        }
                        if (tTNativeAd.getImageMode() == 2) {
                            return 2;
                        }
                        if (tTNativeAd.getImageMode() == 3) {
                            return 3;
                        }
                        if (tTNativeAd.getImageMode() == 4) {
                            return 1;
                        }
                        if (tTNativeAd.getImageMode() == 5) {
                            return 5;
                        }
                        if (tTNativeAd.getImageMode() == 15) {
                            return 6;
                        }
                        if (tTNativeAd.getImageMode() != 16) {
                            return 0;
                        }
                        return 4;
                    }
                    KsNativeAd ksNativeAd = (KsNativeAd) h(funNativeAd2);
                    if (ksNativeAd == null) {
                        return -1;
                    }
                    if (m(funNativeAd2) != null) {
                        if (ksNativeAd.getVideoWidth() <= ksNativeAd.getVideoHeight()) {
                            return 6;
                        }
                        return 5;
                    }
                    List<KsImage> imageList = ksNativeAd.getImageList();
                    if (!ListUtils.isEmpty(imageList) && (ksImage = (KsImage) ListUtils.getItem(imageList, 0)) != null) {
                        if (ksImage.getWidth() > ksImage.getHeight()) {
                            return 0;
                        }
                        return 4;
                    }
                } else {
                    NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) f(funNativeAd2);
                    if (nativeUnifiedADData != null) {
                        if (m(funNativeAd2) != null) {
                            if (nativeUnifiedADData.getPictureWidth() <= nativeUnifiedADData.getPictureHeight()) {
                                return 6;
                            }
                            return 5;
                        } else if (nativeUnifiedADData.getPictureWidth() > nativeUnifiedADData.getPictureHeight()) {
                            return 0;
                        } else {
                            return 4;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
