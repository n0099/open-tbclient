package com.baidu.tieba.videoplay.danmu;

import android.content.Intent;
import android.graphics.RectF;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.R;
import com.baidu.tieba.a37;
import com.baidu.tieba.au6;
import com.baidu.tieba.av6;
import com.baidu.tieba.bv6;
import com.baidu.tieba.c75;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.tieba.danmu.ui.DanmakuView;
import com.baidu.tieba.di;
import com.baidu.tieba.dv6;
import com.baidu.tieba.ev6;
import com.baidu.tieba.ew6;
import com.baidu.tieba.fsa;
import com.baidu.tieba.gu6;
import com.baidu.tieba.hu6;
import com.baidu.tieba.hw6;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalResponseMessage;
import com.baidu.tieba.ta5;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.PbDanmuModel;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.wu6;
import com.baidu.tieba.xu6;
import com.baidu.tieba.yh9;
import com.baidu.tieba.yl9;
import com.baidu.tieba.z25;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000ï\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001U\u0018\u0000 \u0093\u00012\u00020\u0001:\u0006\u0093\u0001\u0094\u0001\u0095\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_H\u0002J\u000e\u0010a\u001a\b\u0012\u0004\u0012\u00020b0_H\u0002J$\u0010c\u001a\u00020\u00112\b\u0010d\u001a\u0004\u0018\u00010\u00112\u0006\u0010e\u001a\u00020\n2\b\u0010f\u001a\u0004\u0018\u00010\u0011H\u0002J3\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110h2\u0006\u0010d\u001a\u00020\u00112\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00110h2\u0006\u0010j\u001a\u00020\nH\u0002¢\u0006\u0002\u0010kJ\u0012\u0010l\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010m\u001a\u00020\u00112\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J\u0012\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0002J\u0010\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020vH\u0002J\u0006\u0010w\u001a\u00020xJ\u0006\u0010y\u001a\u00020zJ\b\u0010{\u001a\u00020zH\u0002J\b\u0010|\u001a\u00020zH\u0002J\b\u0010}\u001a\u00020zH\u0002J\u0006\u0010~\u001a\u00020zJ\u0013\u0010\u007f\u001a\u00020z2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010xH\u0002J\u0010\u0010\u0081\u0001\u001a\u00020z2\u0007\u0010\u0082\u0001\u001a\u00020\u0011J\u000f\u0010\u0083\u0001\u001a\u00020z2\u0006\u0010-\u001a\u00020.J\u0007\u0010\u0084\u0001\u001a\u00020zJ\u0007\u0010\u0085\u0001\u001a\u00020zJ\u0007\u0010\u0086\u0001\u001a\u00020zJ\u0007\u0010\u0087\u0001\u001a\u00020zJ\u0010\u0010\u0088\u0001\u001a\u00020z2\u0007\u0010\u0089\u0001\u001a\u00020\u0011J\u0007\u0010\u008a\u0001\u001a\u00020zJ\u0007\u0010\u008b\u0001\u001a\u00020zJ\u0012\u0010\u008c\u0001\u001a\u00020z2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010xJ\u0007\u0010\u008d\u0001\u001a\u00020zJ\t\u0010\u008e\u0001\u001a\u00020zH\u0002J\u001c\u0010\u008f\u0001\u001a\u00020z2\u0011\u0010\u0090\u0001\u001a\f\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010\u0091\u0001H\u0002R\u000e\u0010\u000f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0019\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010$\u001a\n &*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020<0;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010G\"\u0004\bK\u0010IR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010VR\u001b\u0010W\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010*\u001a\u0004\bY\u0010ZR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController;", "", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "videoFragmentUniqueId", "Lcom/baidu/adp/BdUniqueId;", "rootView", "Landroid/view/View;", "danmuViewId", "", "videoItemData", "Lcom/baidu/tieba/video/VideoItemData;", "currentType", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/adp/BdUniqueId;Landroid/view/View;ILcom/baidu/tieba/video/VideoItemData;I)V", "DANMU_SCORE", "FROM_VIDEO_PLAY", "", "getFROM_VIDEO_PLAY", "()Ljava/lang/String;", "HOT_DANM_MIN_NUM", "INTENT_TO_PAUSE", "INTENT_TO_START", "KEY_DANMU_VIDEO_START_PLAY", "getKEY_DANMU_VIDEO_START_PLAY", "MAX_DANMU_RANK", "SEND_DANMU_DELAY", "SEND_DANMU_RANK", "SHOW_DANMU_INTERVAL", "clickRange", "colorFilter", "Lcom/baidu/tieba/danmu/ecs/component/filter/TextColorFilter;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "danmakuPlayer", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;", "danmakuView", "Lcom/baidu/tieba/danmu/ui/DanmakuView;", "kotlin.jvm.PlatformType", "getDanmakuView", "()Lcom/baidu/tieba/danmu/ui/DanmakuView;", "danmakuView$delegate", "Lkotlin/Lazy;", "danmuCount", "", "danmuOnClickListener", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;", "getDanmuOnClickListener", "()Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;", "setDanmuOnClickListener", "(Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;)V", "danmuProgress", "danmuTextSize", "getDanmuTextSize", "()I", "setDanmuTextSize", "(I)V", "danmuTotalCount", "dataFilters", "", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuFilter;", "defaultRenderer", "Lcom/baidu/tieba/videoplay/danmu/DefaultRenderer;", "gestureDetector", "Landroid/view/GestureDetector;", "intentToPlayer", "isFirstPbRequest", "", "isHasCache", "isNeedStatPlayNum", "isPlaying", "()Z", "setPlaying", "(Z)V", "isPrepared", "setPrepared", "onPbThreadDataCallBack", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$OnPbThreadDataCallBack;", "getOnPbThreadDataCallBack", "()Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$OnPbThreadDataCallBack;", "setOnPbThreadDataCallBack", "(Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$OnPbThreadDataCallBack;)V", "pbDanmuModel", "Lcom/baidu/tieba/videoplay/danmu/PbDanmuModel;", "pbPageCacheListener", "com/baidu/tieba/videoplay/danmu/VideoDanmuController$pbPageCacheListener$1", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$pbPageCacheListener$1;", "renderer", "Lcom/baidu/tieba/danmu/render/TypedDanmakuRenderer;", "getRenderer", "()Lcom/baidu/tieba/danmu/render/TypedDanmakuRenderer;", "renderer$delegate", "tapRect", "Landroid/graphics/RectF;", "createDataFilters", "", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuDataFilter;", "createLayoutFilters", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuLayoutFilter;", "cutChineseAndEnglishWithEmojiAndEmotion", EMABTest.TYPE_STRING, "length", "end", "generateEmotionSplitArray", "", "emotionSplit", "emotionNum", "(Ljava/lang/String;[Ljava/lang/String;I)[Ljava/lang/String;", "getChineseAndEnglishAndEmotionLength", "getDanmuContent", "richContent", "Lcom/baidu/tbadk/widget/richText/TbRichText;", "getDanmuPostDataByMotionEvent", "Lcom/baidu/tieba/danmu/data/DanmakuItemData;", "e", "Landroid/view/MotionEvent;", "getImmersionVideoCommentSource", "intent", "Landroid/content/Intent;", "getPbDanmuData", "Lcom/baidu/tieba/pb/data/PbData;", "hide", "", "initModel", "initModelCallBack", "initModelIntent", "loadData", "loadDataWithCache", "pbDanmuData", "logDanmuStat", "key", "openDanmuClick", DownloadStatisticConstants.UBC_TYPE_PAUSE, "recordProgress", "release", DownloadStatisticConstants.UBC_TYPE_RESUME, "send", "danmu", "show", "start", "startWithCache", "stop", "syncProgress", "updateDanmuData", "postList", "", "Lcom/baidu/tieba/tbadkCore/data/PostData;", "Companion", "DanmuOnClickListener", "OnPbThreadDataCallBack", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoDanmuController {
    public static /* synthetic */ Interceptable $ic = null;
    @JvmField
    public static int M = 3;
    @JvmField
    public static final int N = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final RectF B;
    public final DefaultRenderer C;
    public final Lazy D;
    public final Lazy E;
    public final DanmakuPlayer F;
    public boolean G;
    public final dv6 H;
    public au6 I;
    public final PbDanmuModel J;
    public final f K;
    public final GestureDetector L;
    public final TbPageContext<BaseFragmentActivity> a;
    public final BdUniqueId b;
    public final View c;
    public final int d;
    public final VideoItemData e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final String o;
    public final String p;
    public b q;
    public c r;
    public int s;
    public int t;
    public final int u;
    public long v;
    public long w;
    public long x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public interface b {
        boolean a(zfa zfaVar, yh9 yh9Var);
    }

    /* loaded from: classes8.dex */
    public interface c {
        boolean a(ThreadData threadData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-333912483, "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-333912483, "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class a implements hw6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

        public a(VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoDanmuController;
        }

        @Override // com.baidu.tieba.hw6
        public void a(gu6 item) {
            z25 y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.a.w++;
                if ((((float) this.a.w) * 1.0f) / ((float) this.a.v) >= 0.5f) {
                    yh9 y0 = this.a.J.y0();
                    boolean z = true;
                    if ((y0 == null || (y = y0.y()) == null || y.b() != 1) ? false : false) {
                        this.a.J.F0(false);
                    }
                }
                if (!this.a.z) {
                    return;
                }
                this.a.z = false;
                VideoDanmuController videoDanmuController = this.a;
                videoDanmuController.P(videoDanmuController.E());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

        public d(VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoDanmuController;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (motionEvent == null || this.a.C(motionEvent) == null) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            InterceptResult invokeL;
            boolean z;
            b B;
            zfa zfaVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                hu6 C = this.a.C(e);
                if (C != null && C.g() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || (B = this.a.B()) == null) {
                    return false;
                }
                if (C != null) {
                    zfaVar = C.l();
                } else {
                    zfaVar = null;
                }
                return B.a(zfaVar, this.a.G());
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements PbDanmuModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void b(yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yh9Var) == null) {
            }
        }

        public e(VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoDanmuController;
        }

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void c(boolean z, int i, int i2, int i3, yh9 pbData, String str, int i4) {
            boolean z2;
            Long l;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), pbData, str, Integer.valueOf(i4)}) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (z) {
                    ArrayList<zfa> F = pbData.F();
                    if (F != null && !F.isEmpty()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        if (this.a.A) {
                            pbData.O().setForum_name(pbData.m());
                            c F2 = this.a.F();
                            if (F2 != null) {
                                F2.a(pbData.O());
                            }
                            this.a.A = false;
                        }
                        if (!UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                            return;
                        }
                        ArrayList<zfa> F3 = pbData.F();
                        if (F3 != null) {
                            l = Long.valueOf(F3.size());
                        } else {
                            l = null;
                        }
                        Intrinsics.checkNotNull(l);
                        if (l.longValue() > this.a.v) {
                            List<zfa> subList = pbData.F().subList((int) this.a.v, pbData.F().size());
                            Intrinsics.checkNotNullExpressionValue(subList, "pbData.post_list.subList…), pbData.post_list.size)");
                            this.a.f0(subList);
                            this.a.v = pbData.F().size();
                        }
                        if (!this.a.M()) {
                            this.a.Z(true);
                            if (this.a.t == this.a.i) {
                                this.a.S();
                            } else if (this.a.t == this.a.h) {
                                this.a.V();
                            }
                            this.a.e0();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(VideoDanmuController videoDanmuController) {
            super(2004003);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoDanmuController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getOrginalMessage().getTag() != this.a.b) {
                    return;
                }
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) responsedMessage;
                yh9 pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData != null) {
                    ThreadData O = pbData.O();
                    if (O != null) {
                        this.a.J.o0(O);
                    }
                    this.a.y = true;
                    this.a.J.H0(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
                    return;
                }
                this.a.y = false;
            }
        }
    }

    public VideoDanmuController(TbPageContext<BaseFragmentActivity> pageContext, BdUniqueId videoFragmentUniqueId, View rootView, int i, VideoItemData videoItemData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {pageContext, videoFragmentUniqueId, rootView, Integer.valueOf(i), videoItemData, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(videoFragmentUniqueId, "videoFragmentUniqueId");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(videoItemData, "videoItemData");
        this.a = pageContext;
        this.b = videoFragmentUniqueId;
        this.c = rootView;
        this.d = i;
        this.e = videoItemData;
        this.f = i2;
        this.g = 4;
        this.h = 1;
        this.i = 2;
        this.j = 9;
        this.k = 1800;
        this.l = 500;
        this.m = 2;
        this.n = 100;
        this.o = "c14477";
        this.p = "nani_midpage";
        this.s = UtilHelper.getDimenPixelSize(R.dimen.T_X06);
        this.t = this.i;
        this.u = ViewConfiguration.get(this.a.getPageActivity()).getScaledTouchSlop();
        this.A = true;
        this.B = new RectF();
        this.C = new DefaultRenderer();
        this.D = LazyKt__LazyJVMKt.lazy(new Function0<ew6>(this) { // from class: com.baidu.tieba.videoplay.danmu.VideoDanmuController$renderer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoDanmuController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ew6 invoke() {
                InterceptResult invokeV;
                DefaultRenderer defaultRenderer;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (ew6) invokeV.objValue;
                }
                defaultRenderer = this.this$0.C;
                return new ew6(defaultRenderer, new Pair[0]);
            }
        });
        this.E = LazyKt__LazyJVMKt.lazy(new Function0<DanmakuView>(this) { // from class: com.baidu.tieba.videoplay.danmu.VideoDanmuController$danmakuView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoDanmuController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanmakuView invoke() {
                InterceptResult invokeV;
                View view2;
                int i5;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (DanmakuView) invokeV.objValue;
                }
                view2 = this.this$0.c;
                i5 = this.this$0.d;
                return (DanmakuView) view2.findViewById(i5);
            }
        });
        DanmakuPlayer danmakuPlayer = new DanmakuPlayer(H(), null, 2, null);
        DanmakuView danmakuView = z();
        Intrinsics.checkNotNullExpressionValue(danmakuView, "danmakuView");
        danmakuPlayer.e(danmakuView);
        this.F = danmakuPlayer;
        this.H = new dv6();
        MapsKt__MapsKt.emptyMap();
        au6 au6Var = new au6(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        au6Var.y(u());
        List<xu6> i5 = au6Var.i();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(i5, 10)), 16));
        for (Object obj : i5) {
            linkedHashMap.put(Integer.valueOf(((xu6) obj).a()), obj);
        }
        au6Var.z(v());
        au6Var.B(0.7f);
        this.I = au6Var;
        this.J = new PbDanmuModel(this.a);
        this.K = new f(this);
        this.L = new GestureDetector(this.a.getPageActivity(), new d(this));
        this.F.w(new a(this));
        J();
    }

    public static final boolean R(VideoDanmuController this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return this$0.L.onTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public final int D(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) {
            return intent.getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0);
        }
        return invokeL.intValue;
    }

    public final void O(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, yh9Var) == null) {
            this.J.H0(yh9Var, 3, "");
        }
    }

    public final void P(String key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, key) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            TiebaStatic.log(fsa.b(key, this.e.thread_id, this.f));
        }
    }

    public final void Q(b danmuOnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, danmuOnClickListener) == null) {
            Intrinsics.checkNotNullParameter(danmuOnClickListener, "danmuOnClickListener");
            this.q = danmuOnClickListener;
            z().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.esa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? VideoDanmuController.R(VideoDanmuController.this, view2, motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    public final void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.s = i;
        }
    }

    public final void Y(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.G = z;
        }
    }

    public final void c0(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, yh9Var) == null) {
            this.I.D();
            this.t = this.h;
            O(yh9Var);
        }
    }

    public final String A(TbRichText tbRichText) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbRichText)) == null) {
            if (tbRichText == null || (P = tbRichText.P()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = P.iterator();
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        String spannableStringBuilder = next.Z().toString();
                        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "item.spannableString.toString()");
                        String replace = new Regex("\n").replace(spannableStringBuilder, " ");
                        int y = y(replace) + 0;
                        if (y < 60) {
                            sb.append(replace);
                        } else if (y == 60) {
                            sb.append(replace);
                        } else {
                            sb.append(w(replace, 60, "..."));
                        }
                    } else if (next.getType() != 8 && next.getType() != 17) {
                        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                            sb.append("");
                        }
                    } else {
                        z = true;
                    }
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            if (!TextUtils.isEmpty(sb2) && StringsKt__StringsJVMKt.endsWith$default(sb2, "...", false, 2, null)) {
                return sb2;
            }
            if (!TextUtils.isEmpty(sb2) && z) {
                return sb2 + '[' + TbadkCoreApplication.getInst().getResources().getString(R.string.editor_image) + ']';
            }
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final b B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q;
        }
        return (b) invokeV.objValue;
    }

    public final String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final c F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (c) invokeV.objValue;
    }

    public final yh9 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            yh9 yh9Var = this.J.C;
            Intrinsics.checkNotNullExpressionValue(yh9Var, "pbDanmuModel.mPbData");
            return yh9Var;
        }
        return (yh9) invokeV.objValue;
    }

    public final ew6 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (ew6) this.D.getValue();
        }
        return (ew6) invokeV.objValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.J.setUniqueId(this.b);
            L();
            yl9.b().n(this.J.p0(), this.J.u0());
            K();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.J.W0(new e(this));
            this.K.setTag(this.b);
            MessageManager.getInstance().registerListener(this.K);
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.J.Y();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = this.i;
            this.F.q();
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.t = this.i;
            T();
            this.F.s();
            this.q = null;
            this.r = null;
            this.J.W0(null);
            MessageManager.getInstance().unRegisterListener(this.K);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.G) {
                V();
                return;
            }
            this.z = true;
            this.I.D();
            N();
            this.t = this.i;
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.t = this.i;
            T();
            this.F.z();
            this.w = 0L;
            this.G = false;
        }
    }

    public final void e0() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            VideoItemData videoItemData = this.e;
            if (videoItemData != null) {
                str = videoItemData.video_url;
            } else {
                str = null;
            }
            if (str != null) {
                DanmuProgressManager a2 = DanmuProgressManager.b.a();
                String str2 = this.e.video_url;
                Intrinsics.checkNotNullExpressionValue(str2, "videoItemData.video_url");
                this.F.u(a2.c(str2));
            }
        }
    }

    public final List<Object> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return (List) invokeV.objValue;
    }

    public final DanmakuView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return (DanmakuView) this.E.getValue();
        }
        return (DanmakuView) invokeV.objValue;
    }

    public final hu6 C(MotionEvent motionEvent) {
        InterceptResult invokeL;
        gu6 gu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            this.B.set(motionEvent.getX() - this.u, motionEvent.getY() - this.u, motionEvent.getX() + this.u, motionEvent.getY() + this.u);
            List<gu6> k = this.F.k(this.B);
            if (k != null) {
                gu6Var = (gu6) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) k);
            } else {
                gu6Var = null;
            }
            if (gu6Var == null) {
                return null;
            }
            return gu6Var.e();
        }
        return (hu6) invokeL.objValue;
    }

    public final void I() {
        au6 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b2 = r1.b((r43 & 1) != 0 ? r1.a : 0, (r43 & 2) != 0 ? r1.b : 0L, (r43 & 4) != 0 ? r1.c : 0L, (r43 & 8) != 0 ? r1.d : 0L, (r43 & 16) != 0 ? r1.e : 0.0f, (r43 & 32) != 0 ? r1.f : 0.0f, (r43 & 64) != 0 ? r1.g : 0.0f, (r43 & 128) != 0 ? r1.h : 0.0f, (r43 & 256) != 0 ? r1.i : false, (r43 & 512) != 0 ? r1.j : 0, (r43 & 1024) != 0 ? r1.k : false, (r43 & 2048) != 0 ? r1.l : false, (r43 & 4096) != 0 ? r1.m : 0, (r43 & 8192) != 0 ? r1.n : 0, (r43 & 16384) != 0 ? r1.o : 0, (r43 & 32768) != 0 ? r1.p : 0, (r43 & 65536) != 0 ? r1.q : 0, (r43 & 131072) != 0 ? r1.r : 0, (r43 & 262144) != 0 ? r1.s : 0, (r43 & 524288) != 0 ? r1.t : 0, (r43 & 1048576) != 0 ? r1.u : null, (r43 & 2097152) != 0 ? this.I.v : null);
            this.I = b2;
            this.F.A(b2);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && TbSingleton.getInstance().isDanmuSwitchOpen() && this.I.w()) {
            if (!this.G) {
                this.t = this.h;
                return;
            }
            this.t = this.h;
            this.F.x(this.I);
            yl9.b().n(this.J.p0(), this.J.u0());
        }
    }

    public final void a0() {
        au6 b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || !TbSingleton.getInstance().isDanmuSwitchOpen()) {
            return;
        }
        b2 = r2.b((r43 & 1) != 0 ? r2.a : 0, (r43 & 2) != 0 ? r2.b : 0L, (r43 & 4) != 0 ? r2.c : 0L, (r43 & 8) != 0 ? r2.d : 0L, (r43 & 16) != 0 ? r2.e : 0.0f, (r43 & 32) != 0 ? r2.f : 0.0f, (r43 & 64) != 0 ? r2.g : 0.0f, (r43 & 128) != 0 ? r2.h : 0.0f, (r43 & 256) != 0 ? r2.i : false, (r43 & 512) != 0 ? r2.j : 0, (r43 & 1024) != 0 ? r2.k : true, (r43 & 2048) != 0 ? r2.l : false, (r43 & 4096) != 0 ? r2.m : 0, (r43 & 8192) != 0 ? r2.n : 0, (r43 & 16384) != 0 ? r2.o : 0, (r43 & 32768) != 0 ? r2.p : 0, (r43 & 65536) != 0 ? r2.q : 0, (r43 & 131072) != 0 ? r2.r : 0, (r43 & 262144) != 0 ? r2.s : 0, (r43 & 524288) != 0 ? r2.t : 0, (r43 & 1048576) != 0 ? r2.u : null, (r43 & 2097152) != 0 ? this.I.v : null);
        this.I = b2;
        this.F.A(b2);
    }

    public final void L() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PbCommentFloatActivityConfig createNormalCfg = new PbCommentFloatActivityConfig(this.a.getPageActivity()).createNormalCfg(this.e.getThreadId(), this.e.post_id, "");
            createNormalCfg.setForumId(this.e.forum_id);
            createNormalCfg.setForumName(this.e.forum_name);
            createNormalCfg.setVideo_source(this.p);
            createNormalCfg.setBjhData(this.e.baijiahaoData);
            int i2 = this.f;
            if (i2 != M && i2 != N) {
                i = 2;
            } else {
                i = 1;
            }
            createNormalCfg.setFromPageType(i);
            createNormalCfg.setFromVideoPageType(this.f);
            createNormalCfg.setForceInterceptStimeStat(true);
            this.J.C0(createNormalCfg.getIntent());
            this.J.Y0(2);
            PbDanmuModel pbDanmuModel = this.J;
            Intent intent = createNormalCfg.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "config.intent");
            pbDanmuModel.U0(D(intent));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.F.j() > 0) {
            DanmuProgressManager a2 = DanmuProgressManager.b.a();
            String str = this.e.video_url;
            Intrinsics.checkNotNullExpressionValue(str, "videoItemData.video_url");
            a2.d(str, this.F.j());
        }
    }

    public final List<xu6> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new xu6[]{new ev6(), this.H, new bv6(false, 1, null), new wu6(VideoDanmuController$createDataFilters$1.INSTANCE), new av6()});
        }
        return (List) invokeV.objValue;
    }

    public final void W(String danmu) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, danmu) == null) {
            Intrinsics.checkNotNullParameter(danmu, "danmu");
            if (danmu.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            this.F.v(new hu6(Random.Default.nextLong(), this.F.j() + this.l, danmu, danmu, 1, this.s, this.a.getPageActivity().getResources().getColor(R.color.CAM_X0201), this.j, 8, this.m, null, new zfa(), 0, 0.0f, 13312, null));
        }
    }

    public final int y(String str) {
        InterceptResult invokeL;
        int chineseAndEnglishLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            if (str == null) {
                return 0;
            }
            Matcher matcher = a37.a.matcher(str);
            int i = 0;
            while (matcher.find()) {
                String group = matcher.group();
                if (MessageManager.getInstance().findTask(2004608) != null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                    if (runTask != null && runTask.getData() != null) {
                        Object data = runTask.getData();
                        Intrinsics.checkNotNull(data);
                        if (((Boolean) data).booleanValue()) {
                            chineseAndEnglishLength = 2;
                            i += chineseAndEnglishLength;
                        }
                    }
                    chineseAndEnglishLength = StringHelper.getChineseAndEnglishLength(group);
                    i += chineseAndEnglishLength;
                }
            }
            Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str, 0).toArray(new String[0]);
            if (array != null) {
                for (String str2 : (String[]) array) {
                    i += StringHelper.getChineseAndEnglishLength(str2);
                }
                return i;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.text.SpannableStringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: android.text.SpannableStringBuilder */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : ?: SGET   com.google.android.exoplayer2.text.webvtt.WebvttCueParser.CHAR_SPACE char), (wrap: java.lang.Object : ?: CAST (java.lang.Object) (r6v4 java.lang.String))] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void f0(List<zfa> list) {
        boolean z;
        VideoItemData videoItemData;
        UserItemData userItemData;
        String str;
        float f2;
        float dimenPixelSize;
        int dimenPixelSize2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            int i = 1;
            int i2 = 0;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && (videoItemData = this.e) != null && (userItemData = videoItemData.author_info) != null && !TextUtils.isEmpty(userItemData.user_id)) {
                ArrayList arrayList = new ArrayList();
                int color = this.a.getResources().getColor(R.color.CAM_X0201);
                int i3 = 0;
                for (zfa zfaVar : list) {
                    if (zfaVar.I() != i) {
                        String A = A(zfaVar.e0());
                        if (!TextUtils.isEmpty(A)) {
                            if (Intrinsics.areEqual(zfaVar.r().getUserId(), this.e.author_info.user_id)) {
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("楼主" + ((Object) A));
                                float[] B = c75.B(R.string.J_X04);
                                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.T_X10);
                                dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
                                ta5 ta5Var = new ta5(R.color.CAM_X0302, (int) B[i2], dimenPixelSize3, R.color.CAM_X0101, 0, 0, 0);
                                ta5Var.b(dimenPixelSize2);
                                ta5Var.c(dimenPixelSize4);
                                spannableStringBuilder.setSpan(ta5Var, i2, 2, 17);
                                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds73);
                                str2 = spannableStringBuilder;
                            } else if (zfaVar.o().agreeNum >= this.n) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(WebvttCueParser.CHAR_SPACE);
                                sb.append((Object) A);
                                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(sb.toString());
                                spannableStringBuilder2.setSpan(new EMRichTextAnyIconSpan(R.drawable.icon_mask_video_hot42, R.color.CAM_X0201, EMRichTextAnyIconSpan.IconType.PIC), i2, i, 17);
                                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                                dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                                str2 = spannableStringBuilder2;
                            } else {
                                str = A;
                                f2 = 0.0f;
                                int i4 = i3 + 1;
                                arrayList.add(new hu6(Random.Default.nextLong(), this.x, str.toString(), str, 1, this.s, color, this.j, 1, i4, null, zfaVar, 0, f2, 5120, null));
                                this.x += this.k;
                                i3 = i4 % this.g;
                                i = 1;
                                i2 = 0;
                            }
                            f2 = dimenPixelSize + dimenPixelSize2;
                            str = str2;
                            int i42 = i3 + 1;
                            arrayList.add(new hu6(Random.Default.nextLong(), this.x, str.toString(), str, 1, this.s, color, this.j, 1, i42, null, zfaVar, 0, f2, 5120, null));
                            this.x += this.k;
                            i3 = i42 % this.g;
                            i = 1;
                            i2 = 0;
                        }
                    }
                }
                this.F.B(arrayList);
            }
        }
    }

    public final String w(String str, int i, String str2) {
        InterceptResult invokeLIL;
        boolean z;
        boolean z2;
        int i2;
        String str3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048609, this, str, i, str2)) == null) {
            String str4 = str;
            String str5 = "";
            if (str4 == null || i <= 0) {
                return "";
            }
            int y = y(str);
            if (y <= i) {
                return str4;
            }
            int b2 = a37.b(str);
            if (b2 == 0) {
                String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, i, str2);
                Intrinsics.checkNotNullExpressionValue(cutChineseAndEnglishWithEmoji, "cutChineseAndEnglishWithEmoji(string, length, end)");
                return cutChineseAndEnglishWithEmoji;
            }
            Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str4, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (i < 2) {
                        if (str2 == null) {
                            return "";
                        }
                        return str2;
                    }
                    return str4;
                }
                String[] x = x(str4, strArr, b2);
                int length = x.length;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i4 < length) {
                    String str6 = x[i4];
                    Intrinsics.checkNotNull(str6);
                    if (StringsKt__StringsJVMKt.startsWith$default(str6, "2", false, 2, null)) {
                        String substring = str6.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        x[i4] = substring;
                        i7 = -1;
                        i5 += 2;
                        if (i5 >= i) {
                            break;
                        }
                    } else {
                        String substring2 = str6.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                        x[i4] = substring2;
                        String str7 = x[i4];
                        Intrinsics.checkNotNull(str7);
                        int length2 = str7.length();
                        int i8 = 0;
                        while (i8 < length2) {
                            if (di.isChinese(str7.charAt(i8))) {
                                i3 = 2;
                            } else {
                                i3 = 1;
                            }
                            i5 += i3;
                            if (i5 >= i) {
                                break;
                            }
                            i8++;
                        }
                        i7 = i8;
                    }
                    if (i5 >= i) {
                        break;
                    }
                    i4++;
                    i6 = i5;
                }
                if (i6 + i7 + 1 < y) {
                    StringBuilder sb = new StringBuilder();
                    for (int i9 = 0; i9 < i4; i9++) {
                        sb.append(x[i9]);
                    }
                    if (i4 < length && (str3 = x[i4]) != null) {
                        str5 = str3;
                    }
                    if (str5.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 && (i2 = i7 + 1) > 0 && i2 < str5.length()) {
                        String substring3 = str5.substring(0, str5.offsetByCodePoints(0, str5.codePointCount(0, i2)));
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(substring3);
                    }
                    if (!Intrinsics.areEqual(str4, sb.toString())) {
                        str4 = sb.toString() + str2;
                    }
                    Intrinsics.checkNotNullExpressionValue(str4, "{\n            val result…d\n            }\n        }");
                }
                return str4;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return (String) invokeLIL.objValue;
    }

    public final String[] x(String str, String[] strArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, str, strArr, i)) == null) {
            String[] strArr2 = new String[strArr.length + i];
            Matcher matcher = a37.a.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (matcher.find()) {
                if (i2 < strArr.length) {
                    strArr2[i3] = '1' + strArr[i2];
                    i3++;
                    i2++;
                }
                String group = matcher.group();
                if (MessageManager.getInstance().findTask(2004608) != null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                    if (runTask != null && runTask.getData() != null) {
                        Object data = runTask.getData();
                        Intrinsics.checkNotNull(data);
                        if (((Boolean) data).booleanValue()) {
                            strArr2[i3] = '2' + group;
                            i3++;
                        }
                    }
                    strArr2[i3] = '1' + group;
                    i3++;
                }
            }
            if (i2 < strArr.length) {
                strArr2[i3] = '1' + strArr[i2];
            }
            return strArr2;
        }
        return (String[]) invokeLLI.objValue;
    }
}
