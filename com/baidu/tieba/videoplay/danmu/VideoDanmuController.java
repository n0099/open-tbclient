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
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.R;
import com.baidu.tieba.cz7;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.tieba.danmu.ui.DanmakuView;
import com.baidu.tieba.dj;
import com.baidu.tieba.ez4;
import com.baidu.tieba.fv4;
import com.baidu.tieba.g56;
import com.baidu.tieba.h56;
import com.baidu.tieba.jv7;
import com.baidu.tieba.k46;
import com.baidu.tieba.k56;
import com.baidu.tieba.l56;
import com.baidu.tieba.mc6;
import com.baidu.tieba.n56;
import com.baidu.tieba.o56;
import com.baidu.tieba.o66;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalResponseMessage;
import com.baidu.tieba.q46;
import com.baidu.tieba.r46;
import com.baidu.tieba.r66;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.PbDanmuModel;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.vx8;
import com.baidu.tieba.zs4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000í\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001O\u0018\u00002\u00020\u0001:\u0004\u008e\u0001\u008f\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000e\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0YH\u0002J\u000e\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0YH\u0002J$\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010`\u001a\u00020\n2\b\u0010a\u001a\u0004\u0018\u00010^H\u0002J3\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0c2\u0006\u0010_\u001a\u00020^2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020^0c2\u0006\u0010e\u001a\u00020\nH\u0002¢\u0006\u0002\u0010fJ\u0012\u0010g\u001a\u00020\n2\b\u0010_\u001a\u0004\u0018\u00010^H\u0002J\u0012\u0010h\u001a\u00020^2\b\u0010i\u001a\u0004\u0018\u00010jH\u0002J\u0012\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020qH\u0002J\u0006\u0010r\u001a\u00020sJ\u0006\u0010t\u001a\u00020uJ\b\u0010v\u001a\u00020uH\u0002J\b\u0010w\u001a\u00020uH\u0002J\b\u0010x\u001a\u00020uH\u0002J\u0006\u0010y\u001a\u00020uJ\u0012\u0010z\u001a\u00020u2\b\u0010{\u001a\u0004\u0018\u00010sH\u0002J\u000e\u0010|\u001a\u00020u2\u0006\u0010}\u001a\u00020^J\u000e\u0010~\u001a\u00020u2\u0006\u0010'\u001a\u00020(J\u0006\u0010\u007f\u001a\u00020uJ\u0007\u0010\u0080\u0001\u001a\u00020uJ\u0007\u0010\u0081\u0001\u001a\u00020uJ\u0007\u0010\u0082\u0001\u001a\u00020uJ\u0010\u0010\u0083\u0001\u001a\u00020u2\u0007\u0010\u0084\u0001\u001a\u00020^J\u0007\u0010\u0085\u0001\u001a\u00020uJ\u0007\u0010\u0086\u0001\u001a\u00020uJ\u0011\u0010\u0087\u0001\u001a\u00020u2\b\u0010{\u001a\u0004\u0018\u00010sJ\u0007\u0010\u0088\u0001\u001a\u00020uJ\t\u0010\u0089\u0001\u001a\u00020uH\u0002J\u001c\u0010\u008a\u0001\u001a\u00020u2\u0011\u0010\u008b\u0001\u001a\f\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u008c\u0001H\u0002R\u000e\u0010\u000f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020605X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010A\"\u0004\bE\u0010CR\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010PR\u001b\u0010Q\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010$\u001a\u0004\bS\u0010TR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController;", "", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "videoFragmentUniqueId", "Lcom/baidu/adp/BdUniqueId;", "rootView", "Landroid/view/View;", "danmuViewId", "", "videoItemData", "Lcom/baidu/tieba/video/VideoItemData;", "currentType", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/adp/BdUniqueId;Landroid/view/View;ILcom/baidu/tieba/video/VideoItemData;I)V", "DANMU_SCORE", "HOT_DANM_MIN_NUM", "INTENT_TO_PAUSE", "INTENT_TO_START", "MAX_DANMU_RANK", "SEND_DANMU_DELAY", "SEND_DANMU_RANK", "SHOW_DANMU_INTERVAL", "clickRange", "colorFilter", "Lcom/baidu/tieba/danmu/ecs/component/filter/TextColorFilter;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "danmakuPlayer", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;", "danmakuView", "Lcom/baidu/tieba/danmu/ui/DanmakuView;", "kotlin.jvm.PlatformType", "getDanmakuView", "()Lcom/baidu/tieba/danmu/ui/DanmakuView;", "danmakuView$delegate", "Lkotlin/Lazy;", "danmuCount", "", "danmuOnClickListener", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;", "getDanmuOnClickListener", "()Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;", "setDanmuOnClickListener", "(Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;)V", "danmuProgress", "danmuTextSize", "getDanmuTextSize", "()I", "setDanmuTextSize", "(I)V", "danmuTotalCount", "dataFilters", "", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuFilter;", "defaultRenderer", "Lcom/baidu/tieba/videoplay/danmu/DefaultRenderer;", "gestureDetector", "Landroid/view/GestureDetector;", "intentToPlayer", "isFirstPbRequest", "", "isHasCache", "isNeedStatPlayNum", "isPlaying", "()Z", "setPlaying", "(Z)V", "isPrepared", "setPrepared", "onPbThreadDataCallBack", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$OnPbThreadDataCallBack;", "getOnPbThreadDataCallBack", "()Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$OnPbThreadDataCallBack;", "setOnPbThreadDataCallBack", "(Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$OnPbThreadDataCallBack;)V", "pbDanmuModel", "Lcom/baidu/tieba/videoplay/danmu/PbDanmuModel;", "pbPageCacheListener", "com/baidu/tieba/videoplay/danmu/VideoDanmuController$pbPageCacheListener$1", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$pbPageCacheListener$1;", "renderer", "Lcom/baidu/tieba/danmu/render/TypedDanmakuRenderer;", "getRenderer", "()Lcom/baidu/tieba/danmu/render/TypedDanmakuRenderer;", "renderer$delegate", "tapRect", "Landroid/graphics/RectF;", "createDataFilters", "", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuDataFilter;", "createLayoutFilters", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuLayoutFilter;", "cutChineseAndEnglishWithEmojiAndEmotion", "", EMABTest.TYPE_STRING, CloudStabilityUBCUtils.KEY_LENGTH, "end", "generateEmotionSplitArray", "", "emotionSplit", "emotionNum", "(Ljava/lang/String;[Ljava/lang/String;I)[Ljava/lang/String;", "getChineseAndEnglishAndEmotionLength", "getDanmuContent", "richContent", "Lcom/baidu/tbadk/widget/richText/TbRichText;", "getDanmuPostDataByMotionEvent", "Lcom/baidu/tieba/danmu/data/DanmakuItemData;", "e", "Landroid/view/MotionEvent;", "getImmersionVideoCommentSource", IntentData.KEY, "Landroid/content/Intent;", "getPbDanmuData", "Lcom/baidu/tieba/pb/data/PbData;", "hide", "", "initModel", "initModelCallBack", "initModelIntent", "loadData", "loadDataWithCache", "pbDanmuData", "logDanmuStat", "key", "openDanmuClick", "pause", "recordProgress", "release", "resume", "send", "danmu", "show", "start", "startWithCache", IntentConfig.STOP, "syncProgress", "updateDanmuData", "postList", "", "Lcom/baidu/tieba/tbadkCore/data/PostData;", "DanmuOnClickListener", "OnPbThreadDataCallBack", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class VideoDanmuController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DefaultRenderer A;
    public final Lazy B;
    public final Lazy C;
    public final DanmakuPlayer D;
    public boolean E;
    public final n56 F;
    public k46 G;
    public final PbDanmuModel H;
    public final f I;
    public final GestureDetector J;
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
    public b o;
    public c p;
    public int q;
    public int r;
    public final int s;
    public long t;
    public long u;
    public long v;
    public boolean w;
    public boolean x;
    public boolean y;
    public final RectF z;

    /* loaded from: classes6.dex */
    public static final class a implements r66 {
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

        @Override // com.baidu.tieba.r66
        public void a(q46 item) {
            zs4 y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.a.u++;
                if ((((float) this.a.u) * 1.0f) / ((float) this.a.t) >= 0.5f) {
                    jv7 k0 = this.a.H.k0();
                    if ((k0 == null || (y = k0.y()) == null || y.b() != 1) ? false : true) {
                        this.a.H.q0(false);
                    }
                }
                if (this.a.x) {
                    this.a.x = false;
                    this.a.O("c14477");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(PostData postData, jv7 jv7Var);
    }

    /* loaded from: classes6.dex */
    public interface c {
        boolean a(ThreadData threadData);
    }

    /* loaded from: classes6.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) ? (motionEvent == null || this.a.C(motionEvent) == null) ? false : true : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            InterceptResult invokeL;
            b B;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                r46 C = this.a.C(e);
                if ((C != null && C.g() == 8) || (B = this.a.B()) == null) {
                    return false;
                }
                return B.a(C == null ? null : C.l(), this.a.F());
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements PbDanmuModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

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
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void b(jv7 jv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void c(boolean z, int i, int i2, int i3, jv7 pbData, String str, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), pbData, str, Integer.valueOf(i4)}) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (z) {
                    ArrayList<PostData> F = pbData.F();
                    if (F == null || F.isEmpty()) {
                        return;
                    }
                    if (this.a.y) {
                        pbData.O().setForum_name(pbData.n());
                        c E = this.a.E();
                        if (E != null) {
                            E.a(pbData.O());
                        }
                        this.a.y = false;
                    }
                    if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                        ArrayList<PostData> F2 = pbData.F();
                        Long valueOf = F2 == null ? null : Long.valueOf(F2.size());
                        Intrinsics.checkNotNull(valueOf);
                        if (valueOf.longValue() > this.a.t) {
                            List<PostData> subList = pbData.F().subList((int) this.a.t, pbData.F().size());
                            Intrinsics.checkNotNullExpressionValue(subList, "pbData.post_list.subList…), pbData.post_list.size)");
                            this.a.e0(subList);
                            this.a.t = pbData.F().size();
                        }
                        if (this.a.L()) {
                            return;
                        }
                        this.a.Y(true);
                        if (this.a.r != this.a.i) {
                            if (this.a.r == this.a.h) {
                                this.a.U();
                            }
                        } else {
                            this.a.R();
                        }
                        this.a.d0();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                jv7 pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData == null) {
                    this.a.w = false;
                    return;
                }
                ThreadData O = pbData.O();
                if (O != null) {
                    this.a.H.a0(O);
                }
                this.a.w = true;
                this.a.H.s0(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
            }
        }
    }

    public VideoDanmuController(TbPageContext<BaseFragmentActivity> pageContext, BdUniqueId videoFragmentUniqueId, View rootView, int i, VideoItemData videoItemData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {pageContext, videoFragmentUniqueId, rootView, Integer.valueOf(i), videoItemData, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
        this.q = UtilHelper.getDimenPixelSize(R.dimen.T_X06);
        this.r = this.i;
        this.s = ViewConfiguration.get(this.a.getPageActivity()).getScaledTouchSlop();
        this.y = true;
        this.z = new RectF();
        this.A = new DefaultRenderer();
        this.B = LazyKt__LazyJVMKt.lazy(new VideoDanmuController$renderer$2(this));
        this.C = LazyKt__LazyJVMKt.lazy(new VideoDanmuController$danmakuView$2(this));
        DanmakuPlayer danmakuPlayer = new DanmakuPlayer(G(), null, 2, null);
        DanmakuView danmakuView = z();
        Intrinsics.checkNotNullExpressionValue(danmakuView, "danmakuView");
        danmakuPlayer.e(danmakuView);
        Unit unit = Unit.INSTANCE;
        this.D = danmakuPlayer;
        this.F = new n56();
        MapsKt__MapsKt.emptyMap();
        k46 k46Var = new k46(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        k46Var.y(u());
        List<h56> i5 = k46Var.i();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(i5, 10)), 16));
        for (Object obj : i5) {
            linkedHashMap.put(Integer.valueOf(((h56) obj).a()), obj);
        }
        k46Var.z(v());
        k46Var.B(0.7f);
        Unit unit2 = Unit.INSTANCE;
        this.G = k46Var;
        this.H = new PbDanmuModel(this.a);
        this.I = new f(this);
        this.J = new GestureDetector(this.a.getPageActivity(), new d(this));
        this.D.w(new a(this));
        I();
    }

    public static final boolean Q(VideoDanmuController this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return this$0.J.onTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public final String A(TbRichText tbRichText) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbRichText)) == null) {
            if (tbRichText == null || (B = tbRichText.B()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = B.iterator();
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        String spannableStringBuilder = next.J().toString();
                        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "item.spannableString.toString()");
                        String replace = new Regex("\n").replace(spannableStringBuilder, " ");
                        int y = y(replace) + 0;
                        if (y < 60) {
                            sb.append(replace);
                        } else if (y == 60) {
                            sb.append(replace);
                        } else {
                            sb.append(w(replace, 60, StringHelper.STRING_MORE));
                        }
                    } else if (next.getType() == 8 || next.getType() == 17) {
                        z = true;
                    } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                        sb.append("");
                    }
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            if ((TextUtils.isEmpty(sb2) || !StringsKt__StringsJVMKt.endsWith$default(sb2, StringHelper.STRING_MORE, false, 2, null)) && !TextUtils.isEmpty(sb2) && z) {
                return sb2 + '[' + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0544) + ']';
            }
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final b B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : (b) invokeV.objValue;
    }

    public final r46 C(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            this.z.set(motionEvent.getX() - this.s, motionEvent.getY() - this.s, motionEvent.getX() + this.s, motionEvent.getY() + this.s);
            List<q46> k = this.D.k(this.z);
            q46 q46Var = k == null ? null : (q46) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) k);
            if (q46Var == null) {
                return null;
            }
            return q46Var.e();
        }
        return (r46) invokeL.objValue;
    }

    public final int D(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) ? intent.getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) : invokeL.intValue;
    }

    public final c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : (c) invokeV.objValue;
    }

    public final jv7 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            jv7 jv7Var = this.H.C;
            Intrinsics.checkNotNullExpressionValue(jv7Var, "pbDanmuModel.mPbData");
            return jv7Var;
        }
        return (jv7) invokeV.objValue;
    }

    public final o66 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (o66) this.B.getValue() : (o66) invokeV.objValue;
    }

    public final void H() {
        k46 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b2 = r1.b((r43 & 1) != 0 ? r1.a : 0, (r43 & 2) != 0 ? r1.b : 0L, (r43 & 4) != 0 ? r1.c : 0L, (r43 & 8) != 0 ? r1.d : 0L, (r43 & 16) != 0 ? r1.e : 0.0f, (r43 & 32) != 0 ? r1.f : 0.0f, (r43 & 64) != 0 ? r1.g : 0.0f, (r43 & 128) != 0 ? r1.h : 0.0f, (r43 & 256) != 0 ? r1.i : false, (r43 & 512) != 0 ? r1.j : 0, (r43 & 1024) != 0 ? r1.k : false, (r43 & 2048) != 0 ? r1.l : false, (r43 & 4096) != 0 ? r1.m : 0, (r43 & 8192) != 0 ? r1.n : 0, (r43 & 16384) != 0 ? r1.o : 0, (r43 & 32768) != 0 ? r1.p : 0, (r43 & 65536) != 0 ? r1.q : 0, (r43 & 131072) != 0 ? r1.r : 0, (r43 & 262144) != 0 ? r1.s : 0, (r43 & 524288) != 0 ? r1.t : 0, (r43 & 1048576) != 0 ? r1.u : null, (r43 & 2097152) != 0 ? this.G.v : null);
            this.G = b2;
            this.D.A(b2);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.H.setUniqueId(this.b);
            K();
            cz7.b().p(this.H.b0(), this.H.g0());
            J();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.H.H0(new e(this));
            this.I.setTag(this.b);
            MessageManager.getInstance().registerListener(this.I);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PbCommentFloatActivityConfig createNormalCfg = new PbCommentFloatActivityConfig(this.a.getPageActivity()).createNormalCfg(this.e.getThreadId(), this.e.post_id, "");
            createNormalCfg.setForumId(this.e.forum_id);
            createNormalCfg.setForumName(this.e.forum_name);
            createNormalCfg.setVideo_source("nani_midpage");
            createNormalCfg.setBjhData(this.e.baijiahaoData);
            int i = this.f;
            createNormalCfg.setFromPageType((i == 3 || i == 4) ? 1 : 2);
            createNormalCfg.setFromVideoPageType(this.f);
            createNormalCfg.setForceInterceptStimeStat(true);
            this.H.initWithIntent(createNormalCfg.getIntent());
            this.H.J0(2);
            PbDanmuModel pbDanmuModel = this.H;
            Intent intent = createNormalCfg.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "config.intent");
            pbDanmuModel.F0(D(intent));
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.H.K();
        }
    }

    public final void N(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jv7Var) == null) {
            this.H.s0(jv7Var, 3, "");
        }
    }

    public final void O(String key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, key) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            TiebaStatic.log(vx8.b(key, this.e.thread_id, this.f));
        }
    }

    public final void P(b danmuOnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, danmuOnClickListener) == null) {
            Intrinsics.checkNotNullParameter(danmuOnClickListener, "danmuOnClickListener");
            this.o = danmuOnClickListener;
            z().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ux8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? VideoDanmuController.Q(VideoDanmuController.this, view2, motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.r = this.i;
            this.D.q();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.D.j() <= 0) {
            return;
        }
        DanmuProgressManager a2 = DanmuProgressManager.b.a();
        String str = this.e.video_url;
        Intrinsics.checkNotNullExpressionValue(str, "videoItemData.video_url");
        a2.d(str, this.D.j());
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.r = this.i;
            S();
            this.D.s();
            this.o = null;
            this.p = null;
            this.H.H0(null);
            MessageManager.getInstance().unRegisterListener(this.I);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && TbSingleton.getInstance().isDanmuSwitchOpen() && this.G.w()) {
            if (!this.E) {
                this.r = this.h;
                return;
            }
            this.r = this.h;
            this.D.x(this.G);
            cz7.b().p(this.H.b0(), this.H.g0());
        }
    }

    public final void V(String danmu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, danmu) == null) {
            Intrinsics.checkNotNullParameter(danmu, "danmu");
            if (danmu.length() == 0) {
                return;
            }
            this.D.v(new r46(Random.Default.nextLong(), this.D.j() + this.l, danmu, danmu, 1, this.q, this.a.getPageActivity().getResources().getColor(R.color.CAM_X0201), this.j, 8, this.m, null, new PostData(), 0, 0.0f, 13312, null));
        }
    }

    public final void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.q = i;
        }
    }

    public final void X(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.E = z;
        }
    }

    public final void Z() {
        k46 b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && TbSingleton.getInstance().isDanmuSwitchOpen()) {
            b2 = r2.b((r43 & 1) != 0 ? r2.a : 0, (r43 & 2) != 0 ? r2.b : 0L, (r43 & 4) != 0 ? r2.c : 0L, (r43 & 8) != 0 ? r2.d : 0L, (r43 & 16) != 0 ? r2.e : 0.0f, (r43 & 32) != 0 ? r2.f : 0.0f, (r43 & 64) != 0 ? r2.g : 0.0f, (r43 & 128) != 0 ? r2.h : 0.0f, (r43 & 256) != 0 ? r2.i : false, (r43 & 512) != 0 ? r2.j : 0, (r43 & 1024) != 0 ? r2.k : true, (r43 & 2048) != 0 ? r2.l : false, (r43 & 4096) != 0 ? r2.m : 0, (r43 & 8192) != 0 ? r2.n : 0, (r43 & 16384) != 0 ? r2.o : 0, (r43 & 32768) != 0 ? r2.p : 0, (r43 & 65536) != 0 ? r2.q : 0, (r43 & 131072) != 0 ? r2.r : 0, (r43 & 262144) != 0 ? r2.s : 0, (r43 & 524288) != 0 ? r2.t : 0, (r43 & 1048576) != 0 ? r2.u : null, (r43 & 2097152) != 0 ? this.G.v : null);
            this.G = b2;
            this.D.A(b2);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.E) {
                U();
                return;
            }
            this.x = true;
            this.G.D();
            M();
            this.r = this.i;
        }
    }

    public final void b0(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jv7Var) == null) {
            this.G.D();
            this.r = this.h;
            N(jv7Var);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.r = this.i;
            S();
            this.D.z();
            this.u = 0L;
            this.E = false;
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            VideoItemData videoItemData = this.e;
            if ((videoItemData == null ? null : videoItemData.video_url) != null) {
                DanmuProgressManager a2 = DanmuProgressManager.b.a();
                String str = this.e.video_url;
                Intrinsics.checkNotNullExpressionValue(str, "videoItemData.video_url");
                this.D.u(a2.c(str));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.text.SpannableStringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public final void e0(List<PostData> list) {
        VideoItemData videoItemData;
        UserItemData userItemData;
        String str;
        float f2;
        float dimenPixelSize;
        int dimenPixelSize2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            int i = 1;
            int i2 = 0;
            if ((list == null || list.isEmpty()) || (videoItemData = this.e) == null || (userItemData = videoItemData.author_info) == null || TextUtils.isEmpty(userItemData.user_id)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int color = this.a.getResources().getColor(R.color.CAM_X0201);
            int i3 = 0;
            for (PostData postData : list) {
                if (postData.C() != i) {
                    String A = A(postData.W());
                    if (!TextUtils.isEmpty(A)) {
                        if (Intrinsics.areEqual(postData.s().getUserId(), this.e.author_info.user_id)) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Intrinsics.stringPlus("楼主", A));
                            float[] y = fv4.y(R.string.J_X04);
                            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.T_X10);
                            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
                            ez4 ez4Var = new ez4(R.color.CAM_X0302, (int) y[i2], dimenPixelSize3, R.color.CAM_X0101, 0, 0, 0);
                            ez4Var.a(dimenPixelSize2);
                            ez4Var.b(dimenPixelSize4);
                            spannableStringBuilder.setSpan(ez4Var, i2, 2, 17);
                            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds73);
                            str2 = spannableStringBuilder;
                        } else if (postData.q().agreeNum >= this.n) {
                            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(Intrinsics.stringPlus(" ", A));
                            spannableStringBuilder2.setSpan(new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f08084c, R.color.CAM_X0201, EMRichTextAnyIconSpan.IconType.PIC), i2, i, 17);
                            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                            str2 = spannableStringBuilder2;
                        } else {
                            str = A;
                            f2 = 0.0f;
                            int i4 = i3 + 1;
                            arrayList.add(new r46(Random.Default.nextLong(), this.v, str.toString(), str, 1, this.q, color, this.j, 1, i4, null, postData, 0, f2, 5120, null));
                            this.v += this.k;
                            i3 = i4 % this.g;
                            i = 1;
                            i2 = 0;
                        }
                        f2 = dimenPixelSize + dimenPixelSize2;
                        str = str2;
                        int i42 = i3 + 1;
                        arrayList.add(new r46(Random.Default.nextLong(), this.v, str.toString(), str, 1, this.q, color, this.j, 1, i42, null, postData, 0, f2, 5120, null));
                        this.v += this.k;
                        i3 = i42 % this.g;
                        i = 1;
                        i2 = 0;
                    }
                }
            }
            this.D.B(arrayList);
        }
    }

    public final List<h56> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? CollectionsKt__CollectionsKt.listOf((Object[]) new h56[]{new o56(), this.F, new l56(false, 1, null), new g56(VideoDanmuController$createDataFilters$1.INSTANCE), new k56()}) : (List) invokeV.objValue;
    }

    public final List<Object> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? CollectionsKt__CollectionsKt.emptyList() : (List) invokeV.objValue;
    }

    public final String w(String str, int i, String str2) {
        InterceptResult invokeLIL;
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048608, this, str, i, str2)) == null) {
            String str4 = str;
            String str5 = "";
            if (str4 == null || i <= 0) {
                return "";
            }
            int y = y(str);
            if (y <= i) {
                return str4;
            }
            int b2 = mc6.b(str);
            if (b2 == 0) {
                String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, i, str2);
                Intrinsics.checkNotNullExpressionValue(cutChineseAndEnglishWithEmoji, "cutChineseAndEnglishWithEmoji(string, length, end)");
                return cutChineseAndEnglishWithEmoji;
            }
            Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str4, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int i3 = 2;
                if (strArr.length == 0) {
                    return i >= 2 ? str4 : str2 == null ? "" : str2;
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
                    if (StringsKt__StringsJVMKt.startsWith$default(str6, "2", false, i3, null)) {
                        if (str6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String substring = str6.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                        x[i4] = substring;
                        i7 = -1;
                        i5 += 2;
                        if (i5 >= i) {
                            break;
                        }
                    } else if (str6 != null) {
                        String substring2 = str6.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                        x[i4] = substring2;
                        String str7 = x[i4];
                        Intrinsics.checkNotNull(str7);
                        int length2 = str7.length();
                        i7 = 0;
                        while (i7 < length2) {
                            i5 += dj.isChinese(str7.charAt(i7)) ? 2 : 1;
                            if (i5 >= i) {
                                break;
                            }
                            i7++;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    if (i5 >= i) {
                        break;
                    }
                    i4++;
                    i6 = i5;
                    i3 = 2;
                }
                if (i6 + i7 + 1 < y) {
                    StringBuilder sb = new StringBuilder();
                    if (i4 > 0) {
                        int i8 = 0;
                        while (true) {
                            int i9 = i8 + 1;
                            sb.append(x[i8]);
                            if (i9 >= i4) {
                                break;
                            }
                            i8 = i9;
                        }
                    }
                    if (i4 < length && (str3 = x[i4]) != null) {
                        str5 = str3;
                    }
                    if ((str5.length() > 0) && (i2 = i7 + 1) > 0 && i2 < str5.length()) {
                        String substring3 = str5.substring(0, str5.offsetByCodePoints(0, str5.codePointCount(0, i2)));
                        Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(substring3);
                    }
                    if (!Intrinsics.areEqual(str4, sb.toString())) {
                        str4 = Intrinsics.stringPlus(sb.toString(), str2);
                    }
                    Intrinsics.checkNotNullExpressionValue(str4, "{\n            val result…d\n            }\n        }");
                }
                return str4;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return (String) invokeLIL.objValue;
    }

    public final String[] x(String str, String[] strArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048609, this, str, strArr, i)) == null) {
            String[] strArr2 = new String[strArr.length + i];
            Matcher matcher = mc6.a.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (matcher.find()) {
                if (i2 < strArr.length) {
                    strArr2[i3] = Intrinsics.stringPlus("1", strArr[i2]);
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
                            strArr2[i3] = Intrinsics.stringPlus("2", group);
                            i3++;
                        }
                    }
                    strArr2[i3] = Intrinsics.stringPlus("1", group);
                    i3++;
                }
            }
            if (i2 < strArr.length) {
                strArr2[i3] = Intrinsics.stringPlus("1", strArr[i2]);
            }
            return strArr2;
        }
        return (String[]) invokeLLI.objValue;
    }

    public final int y(String str) {
        InterceptResult invokeL;
        int chineseAndEnglishLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            int i = 0;
            if (str == null) {
                return 0;
            }
            Matcher matcher = mc6.a.matcher(str);
            int i2 = 0;
            while (matcher.find()) {
                String group = matcher.group();
                if (MessageManager.getInstance().findTask(2004608) != null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                    if (runTask != null && runTask.getData() != null) {
                        Object data = runTask.getData();
                        Intrinsics.checkNotNull(data);
                        if (((Boolean) data).booleanValue()) {
                            chineseAndEnglishLength = 2;
                            i2 += chineseAndEnglishLength;
                        }
                    }
                    chineseAndEnglishLength = StringHelper.getChineseAndEnglishLength(group);
                    i2 += chineseAndEnglishLength;
                }
            }
            Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                if (length > 0) {
                    while (true) {
                        int i3 = i + 1;
                        i2 += StringHelper.getChineseAndEnglishLength(strArr[i]);
                        if (i3 >= length) {
                            break;
                        }
                        i = i3;
                    }
                }
                return i2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return invokeL.intValue;
    }

    public final DanmakuView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (DanmakuView) this.C.getValue() : (DanmakuView) invokeV.objValue;
    }
}
