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
import c.a.d.f.p.k;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import c.a.r0.j4.i;
import c.a.r0.m0.f.d.e.h;
import c.a.r0.q2.r.f;
import c.a.r0.q2.u.f.l0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.tieba.danmu.ui.DanmakuView;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.PbDanmuModel;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.ReturnKeyType;
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
import org.apache.commons.lang3.StringUtils;
@Metadata(d1 = {"\u0000å\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001H\u0018\u00002\u00020\u0001:\u0002\u0087\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0002J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020U0RH\u0002J$\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020\n2\b\u0010Z\u001a\u0004\u0018\u00010WH\u0002J3\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010W0\\2\u0006\u0010X\u001a\u00020W2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020W0\\2\u0006\u0010^\u001a\u00020\nH\u0002¢\u0006\u0002\u0010_J\u0012\u0010`\u001a\u00020\n2\b\u0010X\u001a\u0004\u0018\u00010WH\u0002J\u0012\u0010a\u001a\u00020W2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0012\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020gH\u0002J\u0010\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020jH\u0002J\u0006\u0010k\u001a\u00020lJ\u0006\u0010m\u001a\u00020nJ\b\u0010o\u001a\u00020nH\u0002J\b\u0010p\u001a\u00020nH\u0002J\b\u0010q\u001a\u00020nH\u0002J\b\u0010r\u001a\u00020nH\u0002J\u0012\u0010s\u001a\u00020n2\b\u0010t\u001a\u0004\u0018\u00010lH\u0002J\u000e\u0010u\u001a\u00020n2\u0006\u0010v\u001a\u00020WJ\u000e\u0010w\u001a\u00020n2\u0006\u0010'\u001a\u00020(J\u0006\u0010x\u001a\u00020nJ\u0006\u0010y\u001a\u00020nJ\u0006\u0010z\u001a\u00020nJ\u0006\u0010{\u001a\u00020nJ\u000e\u0010|\u001a\u00020n2\u0006\u0010}\u001a\u00020WJ\u0006\u0010~\u001a\u00020nJ\u0006\u0010\u007f\u001a\u00020nJ\u0011\u0010\u0080\u0001\u001a\u00020n2\b\u0010t\u001a\u0004\u0018\u00010lJ\u0007\u0010\u0081\u0001\u001a\u00020nJ\t\u0010\u0082\u0001\u001a\u00020nH\u0002J\u001c\u0010\u0083\u0001\u001a\u00020n2\u0011\u0010\u0084\u0001\u001a\f\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\u0085\u0001H\u0002R\u000e\u0010\u000f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020605X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010@\"\u0004\bD\u0010BR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010IR\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010$\u001a\u0004\bL\u0010MR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController;", "", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "videoFragmentUniqueId", "Lcom/baidu/adp/BdUniqueId;", "rootView", "Landroid/view/View;", "danmuViewId", "", "videoItemData", "Lcom/baidu/tieba/video/VideoItemData;", "currentType", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/adp/BdUniqueId;Landroid/view/View;ILcom/baidu/tieba/video/VideoItemData;I)V", "DANMU_SCORE", "HOT_DANM_MIN_NUM", "INTENT_TO_PAUSE", "INTENT_TO_START", "MAX_DANMU_RANK", "SEND_DANMU_DELAY", "SEND_DANMU_RANK", "SHOW_DANMU_INTERVAL", "clickRange", "colorFilter", "Lcom/baidu/tieba/danmu/ecs/component/filter/TextColorFilter;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "danmakuPlayer", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;", "danmakuView", "Lcom/baidu/tieba/danmu/ui/DanmakuView;", "kotlin.jvm.PlatformType", "getDanmakuView", "()Lcom/baidu/tieba/danmu/ui/DanmakuView;", "danmakuView$delegate", "Lkotlin/Lazy;", "danmuCount", "", "danmuOnClickListener", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;", "getDanmuOnClickListener", "()Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;", "setDanmuOnClickListener", "(Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$DanmuOnClickListener;)V", "danmuProgress", "danmuTextSize", "getDanmuTextSize", "()I", "setDanmuTextSize", "(I)V", "danmuTotalCount", "dataFilters", "", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuFilter;", "defaultRenderer", "Lcom/baidu/tieba/videoplay/danmu/DefaultRenderer;", "gestureDetector", "Landroid/view/GestureDetector;", "intentToPlayer", "isHasCache", "", "isNeedStatPlayNum", "isPlaying", "()Z", "setPlaying", "(Z)V", "isPrepared", "setPrepared", "pbDanmuModel", "Lcom/baidu/tieba/videoplay/danmu/PbDanmuModel;", "pbPageCacheListener", "com/baidu/tieba/videoplay/danmu/VideoDanmuController$pbPageCacheListener$1", "Lcom/baidu/tieba/videoplay/danmu/VideoDanmuController$pbPageCacheListener$1;", "renderer", "Lcom/baidu/tieba/danmu/render/TypedDanmakuRenderer;", "getRenderer", "()Lcom/baidu/tieba/danmu/render/TypedDanmakuRenderer;", "renderer$delegate", "tapRect", "Landroid/graphics/RectF;", "createDataFilters", "", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuDataFilter;", "createLayoutFilters", "Lcom/baidu/tieba/danmu/ecs/component/filter/DanmakuLayoutFilter;", "cutChineseAndEnglishWithEmojiAndEmotion", "", "string", "length", "end", "generateEmotionSplitArray", "", "emotionSplit", "emotionNum", "(Ljava/lang/String;[Ljava/lang/String;I)[Ljava/lang/String;", "getChineseAndEnglishAndEmotionLength", "getDanmuContent", "richContent", "Lcom/baidu/tbadk/widget/richText/TbRichText;", "getDanmuPostDataByMotionEvent", "Lcom/baidu/tieba/danmu/data/DanmakuItemData;", "e", "Landroid/view/MotionEvent;", "getImmersionVideoCommentSource", "intent", "Landroid/content/Intent;", "getPbDanmuData", "Lcom/baidu/tieba/pb/data/PbData;", "hide", "", "initModel", "initModelCallBack", "initModelIntent", "loadData", "loadDataWithCache", "pbDanmuData", "logDanmuStat", "key", "openDanmuClick", "pause", "recordProgress", "release", "resume", ReturnKeyType.SEND, "danmu", "show", "start", "startWithCache", IntentConfig.STOP, "syncProgress", "updateDanmuData", "postList", "", "Lcom/baidu/tieba/tbadkCore/data/PostData;", "DanmuOnClickListener", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class VideoDanmuController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy A;
    public final DanmakuPlayer B;
    public boolean C;
    public final h D;
    public c.a.r0.m0.a E;
    public final PbDanmuModel F;
    public final e G;
    public final GestureDetector H;
    public final TbPageContext<BaseFragmentActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f50026b;

    /* renamed from: c  reason: collision with root package name */
    public final View f50027c;

    /* renamed from: d  reason: collision with root package name */
    public final int f50028d;

    /* renamed from: e  reason: collision with root package name */
    public final VideoItemData f50029e;

    /* renamed from: f  reason: collision with root package name */
    public final int f50030f;

    /* renamed from: g  reason: collision with root package name */
    public final int f50031g;

    /* renamed from: h  reason: collision with root package name */
    public final int f50032h;

    /* renamed from: i  reason: collision with root package name */
    public final int f50033i;

    /* renamed from: j  reason: collision with root package name */
    public final int f50034j;

    /* renamed from: k  reason: collision with root package name */
    public final int f50035k;
    public final int l;
    public final int m;
    public final int n;
    public b o;
    public int p;
    public int q;
    public final int r;
    public long s;
    public long t;
    public long u;
    public boolean v;
    public boolean w;
    public final RectF x;
    public final DefaultRenderer y;
    public final Lazy z;

    /* loaded from: classes11.dex */
    public static final class a implements c.a.r0.m0.j.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoDanmuController;
        }

        @Override // c.a.r0.m0.j.c
        public void a(c.a.r0.m0.e.a item) {
            b1 y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.a.t++;
                if ((((float) this.a.t) * 1.0f) / ((float) this.a.s) >= 0.5f) {
                    f h0 = this.a.F.h0();
                    if ((h0 == null || (y = h0.y()) == null || y.b() != 1) ? false : true) {
                        this.a.F.n0(false);
                    }
                }
                if (this.a.w) {
                    this.a.w = false;
                    this.a.L("c14477");
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        boolean a(PostData postData, f fVar);
    }

    /* loaded from: classes11.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoDanmuController f50036e;

        public c(VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50036e = videoDanmuController;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) ? (motionEvent == null || this.f50036e.A(motionEvent) == null) ? false : true : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e2) {
            InterceptResult invokeL;
            b z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
                Intrinsics.checkNotNullParameter(e2, "e");
                c.a.r0.m0.e.b A = this.f50036e.A(e2);
                if ((A != null && A.g() == 8) || (z = this.f50036e.z()) == null) {
                    return false;
                }
                return z.a(A == null ? null : A.l(), this.f50036e.C());
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class d implements PbDanmuModel.g {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoDanmuController;
        }

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            }
        }

        @Override // com.baidu.tieba.videoplay.danmu.PbDanmuModel.g
        public void c(boolean z, int i2, int i3, int i4, f pbData, String str, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), pbData, str, Integer.valueOf(i5)}) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (z) {
                    ArrayList<PostData> F = pbData.F();
                    if (F == null || F.isEmpty()) {
                        return;
                    }
                    ArrayList<PostData> F2 = pbData.F();
                    Long valueOf = F2 == null ? null : Long.valueOf(F2.size());
                    Intrinsics.checkNotNull(valueOf);
                    if (valueOf.longValue() > this.a.s) {
                        List<PostData> subList = pbData.F().subList((int) this.a.s, pbData.F().size());
                        Intrinsics.checkNotNullExpressionValue(subList, "pbData.post_list.subList…), pbData.post_list.size)");
                        this.a.a0(subList);
                        this.a.s = pbData.F().size();
                    }
                    if (this.a.I()) {
                        return;
                    }
                    this.a.U(true);
                    if (this.a.q != this.a.f50033i) {
                        if (this.a.q == this.a.f50032h) {
                            this.a.R();
                        }
                    } else {
                        this.a.O();
                    }
                    this.a.Z();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoDanmuController videoDanmuController) {
            super(2004003);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (responsedMessage.getOrginalMessage().getTag() != this.a.f50026b) {
                    return;
                }
                PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) responsedMessage;
                f pbData = pbPageReadLocalResponseMessage.getPbData();
                if (pbData == null) {
                    this.a.v = false;
                    return;
                }
                d2 O = pbData.O();
                if (O != null) {
                    this.a.F.X(O);
                }
                this.a.v = true;
                this.a.F.p0(pbData, pbPageReadLocalResponseMessage.getUpdateType(), pbPageReadLocalResponseMessage.getErrorString());
            }
        }
    }

    public VideoDanmuController(TbPageContext<BaseFragmentActivity> pageContext, BdUniqueId videoFragmentUniqueId, View rootView, int i2, VideoItemData videoItemData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {pageContext, videoFragmentUniqueId, rootView, Integer.valueOf(i2), videoItemData, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
        this.f50026b = videoFragmentUniqueId;
        this.f50027c = rootView;
        this.f50028d = i2;
        this.f50029e = videoItemData;
        this.f50030f = i3;
        this.f50031g = 4;
        this.f50032h = 1;
        this.f50033i = 2;
        this.f50034j = 9;
        this.f50035k = 1800;
        this.l = 500;
        this.m = 2;
        this.n = 100;
        this.p = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.T_X06);
        this.q = this.f50033i;
        this.r = ViewConfiguration.get(this.a.getPageActivity()).getScaledTouchSlop();
        this.x = new RectF();
        this.y = new DefaultRenderer();
        this.z = LazyKt__LazyJVMKt.lazy(new VideoDanmuController$renderer$2(this));
        this.A = LazyKt__LazyJVMKt.lazy(new VideoDanmuController$danmakuView$2(this));
        DanmakuPlayer danmakuPlayer = new DanmakuPlayer(D(), null, 2, null);
        DanmakuView danmakuView = x();
        Intrinsics.checkNotNullExpressionValue(danmakuView, "danmakuView");
        danmakuPlayer.e(danmakuView);
        Unit unit = Unit.INSTANCE;
        this.B = danmakuPlayer;
        this.D = new h();
        MapsKt__MapsKt.emptyMap();
        c.a.r0.m0.a aVar = new c.a.r0.m0.a(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        aVar.y(s());
        List<c.a.r0.m0.f.d.e.b> i6 = aVar.i();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(i6, 10)), 16));
        for (Object obj : i6) {
            linkedHashMap.put(Integer.valueOf(((c.a.r0.m0.f.d.e.b) obj).a()), obj);
        }
        aVar.z(t());
        aVar.B(0.7f);
        Unit unit2 = Unit.INSTANCE;
        this.E = aVar;
        this.F = new PbDanmuModel(this.a);
        this.G = new e(this);
        this.H = new GestureDetector(this.a.getPageActivity(), new c(this));
        this.B.w(new a(this));
        F();
    }

    public static final boolean N(VideoDanmuController this$0, View view, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, this$0, view, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return this$0.H.onTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public final c.a.r0.m0.e.b A(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            this.x.set(motionEvent.getX() - this.r, motionEvent.getY() - this.r, motionEvent.getX() + this.r, motionEvent.getY() + this.r);
            List<c.a.r0.m0.e.a> k2 = this.B.k(this.x);
            c.a.r0.m0.e.a aVar = k2 == null ? null : (c.a.r0.m0.e.a) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) k2);
            if (aVar == null) {
                return null;
            }
            return aVar.e();
        }
        return (c.a.r0.m0.e.b) invokeL.objValue;
    }

    public final int B(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) ? intent.getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) : invokeL.intValue;
    }

    public final f C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f fVar = this.F.G;
            Intrinsics.checkNotNullExpressionValue(fVar, "pbDanmuModel.mPbData");
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.r0.m0.i.c D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (c.a.r0.m0.i.c) this.z.getValue() : (c.a.r0.m0.i.c) invokeV.objValue;
    }

    public final void E() {
        c.a.r0.m0.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b2 = r1.b((r43 & 1) != 0 ? r1.a : 0, (r43 & 2) != 0 ? r1.f19826b : 0L, (r43 & 4) != 0 ? r1.f19827c : 0L, (r43 & 8) != 0 ? r1.f19828d : 0L, (r43 & 16) != 0 ? r1.f19829e : 0.0f, (r43 & 32) != 0 ? r1.f19830f : 0.0f, (r43 & 64) != 0 ? r1.f19831g : 0.0f, (r43 & 128) != 0 ? r1.f19832h : 0.0f, (r43 & 256) != 0 ? r1.f19833i : false, (r43 & 512) != 0 ? r1.f19834j : 0, (r43 & 1024) != 0 ? r1.f19835k : false, (r43 & 2048) != 0 ? r1.l : false, (r43 & 4096) != 0 ? r1.m : 0, (r43 & 8192) != 0 ? r1.n : 0, (r43 & 16384) != 0 ? r1.o : 0, (r43 & 32768) != 0 ? r1.p : 0, (r43 & 65536) != 0 ? r1.q : 0, (r43 & 131072) != 0 ? r1.r : 0, (r43 & 262144) != 0 ? r1.s : 0, (r43 & 524288) != 0 ? r1.t : 0, (r43 & 1048576) != 0 ? r1.u : null, (r43 & 2097152) != 0 ? this.E.v : null);
            this.E = b2;
            this.B.A(b2);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.F.setUniqueId(this.f50026b);
            H();
            l0.b().p(this.F.Y(), this.F.d0());
            G();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.F.E0(new d(this));
            this.G.setTag(this.f50026b);
            MessageManager.getInstance().registerListener(this.G);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PbCommentFloatActivityConfig createNormalCfg = new PbCommentFloatActivityConfig(this.a.getPageActivity()).createNormalCfg(this.f50029e.getThreadId(), this.f50029e.post_id, "");
            createNormalCfg.setForumId(this.f50029e.forum_id);
            createNormalCfg.setForumName(this.f50029e.forum_name);
            createNormalCfg.setVideo_source("nani_midpage");
            createNormalCfg.setBjhData(this.f50029e.baijiahaoData);
            int i2 = this.f50030f;
            createNormalCfg.setFromPageType((i2 == 3 || i2 == 4) ? 1 : 2);
            createNormalCfg.setFromVideoPageType(this.f50030f);
            createNormalCfg.setForceInterceptStimeStat(true);
            this.F.initWithIntent(createNormalCfg.getIntent());
            this.F.G0(2);
            PbDanmuModel pbDanmuModel = this.F;
            Intent intent = createNormalCfg.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "config.intent");
            pbDanmuModel.C0(B(intent));
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.F.H();
        }
    }

    public final void K(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.F.p0(fVar, 3, "");
        }
    }

    public final void L(String key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, key) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            TiebaStatic.log(c.a.r0.j4.m.c.b(key, this.f50029e.thread_id, this.f50030f));
        }
    }

    public final void M(b danmuOnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, danmuOnClickListener) == null) {
            Intrinsics.checkNotNullParameter(danmuOnClickListener, "danmuOnClickListener");
            this.o = danmuOnClickListener;
            x().setOnTouchListener(new View.OnTouchListener() { // from class: c.a.r0.j4.m.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? VideoDanmuController.N(VideoDanmuController.this, view, motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.q = this.f50033i;
            this.B.q();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.B.j() <= 0) {
            return;
        }
        DanmuProgressManager a2 = DanmuProgressManager.f50009b.a();
        String str = this.f50029e.video_url;
        Intrinsics.checkNotNullExpressionValue(str, "videoItemData.video_url");
        a2.d(str, this.B.j());
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.q = this.f50033i;
            P();
            this.B.s();
            this.o = null;
            this.F.E0(null);
            MessageManager.getInstance().unRegisterListener(this.G);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && TbSingleton.getInstance().isDanmuSwitchOpen() && this.E.w()) {
            if (!this.C) {
                this.q = this.f50032h;
                return;
            }
            this.q = this.f50032h;
            this.B.x(this.E);
            l0.b().p(this.F.Y(), this.F.d0());
        }
    }

    public final void S(String danmu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, danmu) == null) {
            Intrinsics.checkNotNullParameter(danmu, "danmu");
            if (danmu.length() == 0) {
                return;
            }
            this.B.v(new c.a.r0.m0.e.b(Random.Default.nextLong(), this.B.j() + this.l, danmu, danmu, 1, this.p, this.a.getPageActivity().getResources().getColor(c.a.r0.j4.c.CAM_X0201), this.f50034j, 8, this.m, null, new PostData(), 0, 0.0f, 13312, null));
        }
    }

    public final void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.p = i2;
        }
    }

    public final void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.C = z;
        }
    }

    public final void V() {
        c.a.r0.m0.a b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && TbSingleton.getInstance().isDanmuSwitchOpen()) {
            b2 = r2.b((r43 & 1) != 0 ? r2.a : 0, (r43 & 2) != 0 ? r2.f19826b : 0L, (r43 & 4) != 0 ? r2.f19827c : 0L, (r43 & 8) != 0 ? r2.f19828d : 0L, (r43 & 16) != 0 ? r2.f19829e : 0.0f, (r43 & 32) != 0 ? r2.f19830f : 0.0f, (r43 & 64) != 0 ? r2.f19831g : 0.0f, (r43 & 128) != 0 ? r2.f19832h : 0.0f, (r43 & 256) != 0 ? r2.f19833i : false, (r43 & 512) != 0 ? r2.f19834j : 0, (r43 & 1024) != 0 ? r2.f19835k : true, (r43 & 2048) != 0 ? r2.l : false, (r43 & 4096) != 0 ? r2.m : 0, (r43 & 8192) != 0 ? r2.n : 0, (r43 & 16384) != 0 ? r2.o : 0, (r43 & 32768) != 0 ? r2.p : 0, (r43 & 65536) != 0 ? r2.q : 0, (r43 & 131072) != 0 ? r2.r : 0, (r43 & 262144) != 0 ? r2.s : 0, (r43 & 524288) != 0 ? r2.t : 0, (r43 & 1048576) != 0 ? r2.u : null, (r43 & 2097152) != 0 ? this.E.v : null);
            this.E = b2;
            this.B.A(b2);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.C) {
                R();
                return;
            }
            this.w = true;
            this.E.D();
            J();
            this.q = this.f50033i;
        }
    }

    public final void X(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            this.E.D();
            this.q = this.f50032h;
            K(fVar);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.q = this.f50033i;
            P();
            this.B.z();
            this.t = 0L;
            this.C = false;
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            DanmuProgressManager a2 = DanmuProgressManager.f50009b.a();
            String str = this.f50029e.video_url;
            Intrinsics.checkNotNullExpressionValue(str, "videoItemData.video_url");
            this.B.u(a2.c(str));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.text.SpannableStringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a0(List<PostData> list) {
        String str;
        float f2;
        float dimenPixelSize;
        int dimenPixelSize2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            int i2 = 1;
            int i3 = 0;
            if (list == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int color = this.a.getResources().getColor(c.a.r0.j4.c.CAM_X0201);
            int i4 = 0;
            for (PostData postData : list) {
                if (postData.A() != i2) {
                    String y = y(postData.M());
                    if (!TextUtils.isEmpty(y)) {
                        if (Intrinsics.areEqual(postData.t().getUserId(), this.f50029e.author_info.user_id)) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Intrinsics.stringPlus("楼主", y));
                            float[] y2 = c.a.q0.s.u.a.y(i.J_X04);
                            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.T_X10);
                            dimenPixelSize2 = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.M_W_X002);
                            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.tbds6);
                            c.a.q0.s.g0.r.a aVar = new c.a.q0.s.g0.r.a(c.a.r0.j4.c.CAM_X0302, (int) y2[i3], dimenPixelSize3, c.a.r0.j4.c.CAM_X0101, 0, 0, 0);
                            aVar.a(dimenPixelSize2);
                            aVar.b(dimenPixelSize4);
                            spannableStringBuilder.setSpan(aVar, i3, 2, 17);
                            dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.tbds73);
                            str2 = spannableStringBuilder;
                        } else if (postData.q().agreeNum >= this.n) {
                            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(Intrinsics.stringPlus(" ", y));
                            spannableStringBuilder2.setSpan(new EMRichTextAnyIconSpan(c.a.r0.j4.e.icon_mask_video_hot42, c.a.r0.j4.c.CAM_X0201, EMRichTextAnyIconSpan.IconType.PIC), i3, i2, 17);
                            dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.tbds42);
                            dimenPixelSize2 = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.M_W_X002);
                            str2 = spannableStringBuilder2;
                        } else {
                            str = y;
                            f2 = 0.0f;
                            int i5 = i4 + 1;
                            arrayList.add(new c.a.r0.m0.e.b(Random.Default.nextLong(), this.u, str.toString(), str, 1, this.p, color, this.f50034j, 1, i5, null, postData, 0, f2, 5120, null));
                            this.u += this.f50035k;
                            i4 = i5 % this.f50031g;
                            i2 = 1;
                            i3 = 0;
                        }
                        f2 = dimenPixelSize + dimenPixelSize2;
                        str = str2;
                        int i52 = i4 + 1;
                        arrayList.add(new c.a.r0.m0.e.b(Random.Default.nextLong(), this.u, str.toString(), str, 1, this.p, color, this.f50034j, 1, i52, null, postData, 0, f2, 5120, null));
                        this.u += this.f50035k;
                        i4 = i52 % this.f50031g;
                        i2 = 1;
                        i3 = 0;
                    }
                }
            }
            this.B.B(arrayList);
        }
    }

    public final List<c.a.r0.m0.f.d.e.b> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? CollectionsKt__CollectionsKt.listOf((Object[]) new c.a.r0.m0.f.d.e.b[]{new c.a.r0.m0.f.d.e.i(), this.D, new c.a.r0.m0.f.d.e.f(false, 1, null), new c.a.r0.m0.f.d.e.a(VideoDanmuController$createDataFilters$1.INSTANCE), new c.a.r0.m0.f.d.e.e()}) : (List) invokeV.objValue;
    }

    public final List<Object> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? CollectionsKt__CollectionsKt.emptyList() : (List) invokeV.objValue;
    }

    public final String u(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        int i3;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048604, this, str, i2, str2)) == null) {
            String str4 = str;
            String str5 = "";
            if (str4 == null || i2 <= 0) {
                return "";
            }
            int w = w(str);
            if (w <= i2) {
                return str4;
            }
            int b2 = c.a.r0.x0.a.b(str);
            if (b2 == 0) {
                String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, i2, str2);
                Intrinsics.checkNotNullExpressionValue(cutChineseAndEnglishWithEmoji, "cutChineseAndEnglishWithEmoji(string, length, end)");
                return cutChineseAndEnglishWithEmoji;
            }
            Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str4, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int i4 = 2;
                if (strArr.length == 0) {
                    return i2 >= 2 ? str4 : str2 == null ? "" : str2;
                }
                String[] v = v(str4, strArr, b2);
                int length = v.length;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i5 < length) {
                    String str6 = v[i5];
                    Intrinsics.checkNotNull(str6);
                    if (StringsKt__StringsJVMKt.startsWith$default(str6, "2", false, i4, null)) {
                        if (str6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String substring = str6.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                        v[i5] = substring;
                        i8 = -1;
                        i6 += 2;
                        if (i6 >= i2) {
                            break;
                        }
                    } else if (str6 != null) {
                        String substring2 = str6.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                        v[i5] = substring2;
                        String str7 = v[i5];
                        Intrinsics.checkNotNull(str7);
                        int length2 = str7.length();
                        i8 = 0;
                        while (i8 < length2) {
                            i6 += k.isChinese(str7.charAt(i8)) ? 2 : 1;
                            if (i6 >= i2) {
                                break;
                            }
                            i8++;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    if (i6 >= i2) {
                        break;
                    }
                    i5++;
                    i7 = i6;
                    i4 = 2;
                }
                if (i7 + i8 + 1 < w) {
                    StringBuilder sb = new StringBuilder();
                    if (i5 > 0) {
                        int i9 = 0;
                        while (true) {
                            int i10 = i9 + 1;
                            sb.append(v[i9]);
                            if (i10 >= i5) {
                                break;
                            }
                            i9 = i10;
                        }
                    }
                    if (i5 < length && (str3 = v[i5]) != null) {
                        str5 = str3;
                    }
                    if ((str5.length() > 0) && (i3 = i8 + 1) > 0 && i3 < str5.length()) {
                        String substring3 = str5.substring(0, str5.offsetByCodePoints(0, str5.codePointCount(0, i3)));
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

    public final String[] v(String str, String[] strArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048605, this, str, strArr, i2)) == null) {
            String[] strArr2 = new String[strArr.length + i2];
            Matcher matcher = c.a.r0.x0.a.a.matcher(str);
            int i3 = 0;
            int i4 = 0;
            while (matcher.find()) {
                if (i3 < strArr.length) {
                    strArr2[i4] = Intrinsics.stringPlus("1", strArr[i3]);
                    i4++;
                    i3++;
                }
                String group = matcher.group();
                if (MessageManager.getInstance().findTask(2004608) != null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                    if (runTask != null && runTask.getData() != null) {
                        Object data = runTask.getData();
                        Intrinsics.checkNotNull(data);
                        if (((Boolean) data).booleanValue()) {
                            strArr2[i4] = Intrinsics.stringPlus("2", group);
                            i4++;
                        }
                    }
                    strArr2[i4] = Intrinsics.stringPlus("1", group);
                    i4++;
                }
            }
            if (i3 < strArr.length) {
                strArr2[i4] = Intrinsics.stringPlus("1", strArr[i3]);
            }
            return strArr2;
        }
        return (String[]) invokeLLI.objValue;
    }

    public final int w(String str) {
        InterceptResult invokeL;
        int chineseAndEnglishLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            int i2 = 0;
            if (str == null) {
                return 0;
            }
            Matcher matcher = c.a.r0.x0.a.a.matcher(str);
            int i3 = 0;
            while (matcher.find()) {
                String group = matcher.group();
                if (MessageManager.getInstance().findTask(2004608) != null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                    if (runTask != null && runTask.getData() != null) {
                        Object data = runTask.getData();
                        Intrinsics.checkNotNull(data);
                        if (((Boolean) data).booleanValue()) {
                            chineseAndEnglishLength = 2;
                            i3 += chineseAndEnglishLength;
                        }
                    }
                    chineseAndEnglishLength = StringHelper.getChineseAndEnglishLength(group);
                    i3 += chineseAndEnglishLength;
                }
            }
            Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                if (length > 0) {
                    while (true) {
                        int i4 = i2 + 1;
                        i3 += StringHelper.getChineseAndEnglishLength(strArr[i2]);
                        if (i4 >= length) {
                            break;
                        }
                        i2 = i4;
                    }
                }
                return i3;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return invokeL.intValue;
    }

    public final DanmakuView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (DanmakuView) this.A.getValue() : (DanmakuView) invokeV.objValue;
    }

    public final String y(TbRichText tbRichText) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, tbRichText)) == null) {
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = y.iterator();
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        String spannableStringBuilder = next.G().toString();
                        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "item.spannableString.toString()");
                        String replace = new Regex(StringUtils.LF).replace(spannableStringBuilder, " ");
                        int w = w(replace) + 0;
                        if (w < 60) {
                            sb.append(replace);
                        } else if (w == 60) {
                            sb.append(replace);
                        } else {
                            sb.append(u(replace, 60, "..."));
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
            if ((TextUtils.isEmpty(sb2) || !StringsKt__StringsJVMKt.endsWith$default(sb2, "...", false, 2, null)) && !TextUtils.isEmpty(sb2) && z) {
                return sb2 + '[' + TbadkCoreApplication.getInst().getResources().getString(i.editor_image) + ']';
            }
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.o : (b) invokeV.objValue;
    }
}
