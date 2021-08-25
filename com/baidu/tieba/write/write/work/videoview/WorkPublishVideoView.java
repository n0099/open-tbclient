package com.baidu.tieba.write.write.work.videoview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SB\u001d\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bR\u0010VB%\b\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010W\u001a\u00020\u0002¢\u0006\u0004\bR\u0010XJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\tJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\tJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\tJ/\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010$\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010'\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u0010*R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006Y"}, d2 = {"Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;", "Landroid/widget/RelativeLayout;", "", "videoWidth", "videoHeight", "", "adjustSize", "(II)V", "deleteCoverCache", "()V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "initView", "loadCover", "onChangeSkin", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "reset", "Lcom/baidu/tieba/video/EditVideoData;", "editVideoData", "setVideoInfo", "(Lcom/baidu/tieba/video/EditVideoData;)V", "", SapiOptions.KEY_CACHE_PERCENT, "updatePercent", "(F)V", "MAX_VIDEO_HEIGHT$delegate", "Lkotlin/Lazy;", "getMAX_VIDEO_HEIGHT", "()I", "MAX_VIDEO_HEIGHT", "MAX_VIDEO_WIDTH$delegate", "getMAX_VIDEO_WIDTH", "MAX_VIDEO_WIDTH", "Landroid/widget/TextView;", "coverBtn", "Landroid/widget/TextView;", "", "coverPath", "Ljava/lang/String;", "Lcom/baidu/tbadk/widget/TbImageView;", "coverView", "Lcom/baidu/tbadk/widget/TbImageView;", "editBtn", "Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "iWriteVideoPreviewListener", "Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "getIWriteVideoPreviewListener", "()Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "setIWriteVideoPreviewListener", "(Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;)V", "Lcom/baidu/tbadk/img/AsyncLocalImageLoader;", "mAsyncLocalImageLoader", "Lcom/baidu/tbadk/img/AsyncLocalImageLoader;", "mCurrentVideoPosition", "I", "Landroid/view/View;", "mRootView", "Landroid/view/View;", "maskView", "F", "Landroid/widget/ImageView;", "playView", "Landroid/widget/ImageView;", "Landroid/graphics/Paint;", "progressBarBackgroundPaint", "Landroid/graphics/Paint;", "progressBarPaint", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/RectF;", "Landroid/graphics/Path;", "roundPath", "Landroid/graphics/Path;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class WorkPublishVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty[] u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f59063e;

    /* renamed from: f  reason: collision with root package name */
    public final Lazy f59064f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f59065g;

    /* renamed from: h  reason: collision with root package name */
    public View f59066h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f59067i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f59068j;
    public TextView k;
    public View l;
    public float m;
    public c.a.p0.c0.b n;
    public Paint o;
    public Paint p;
    public String q;
    public final Path r;
    public final RectF s;
    public c.a.q0.b4.u.q.b.b t;

    /* loaded from: classes7.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishVideoView f59069e;

        public a(WorkPublishVideoView workPublishVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59069e = workPublishVideoView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.a.q0.b4.u.q.b.b iWriteVideoPreviewListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (iWriteVideoPreviewListener = this.f59069e.getIWriteVideoPreviewListener()) == null) {
                return;
            }
            iWriteVideoPreviewListener.onPlayClick();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishVideoView f59070e;

        public b(WorkPublishVideoView workPublishVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59070e = workPublishVideoView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.a.q0.b4.u.q.b.b iWriteVideoPreviewListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (iWriteVideoPreviewListener = this.f59070e.getIWriteVideoPreviewListener()) == null) {
                return;
            }
            iWriteVideoPreviewListener.onCoverEditClick();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishVideoView f59071e;

        public c(WorkPublishVideoView workPublishVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59071e = workPublishVideoView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.a.q0.b4.u.q.b.b iWriteVideoPreviewListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (iWriteVideoPreviewListener = this.f59071e.getIWriteVideoPreviewListener()) == null) {
                return;
            }
            iWriteVideoPreviewListener.onEditClick();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements c.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishVideoView f59072e;

        public d(WorkPublishVideoView workPublishVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59072e = workPublishVideoView;
        }

        @Override // c.a.p0.b0.b
        public final void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                if (WorkPublishVideoView.access$getCoverView$p(this.f59072e) != null && aVar != null) {
                    this.f59072e.adjustSize(aVar.r(), aVar.m());
                    WorkPublishVideoView.access$getCoverView$p(this.f59072e).invalidate();
                    return;
                }
                this.f59072e.adjustSize(16, 9);
                WorkPublishVideoView.access$getCoverView$p(this.f59072e).invalidate();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-489046598, "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-489046598, "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;");
                return;
            }
        }
        u = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(WorkPublishVideoView.class), "MAX_VIDEO_HEIGHT", "getMAX_VIDEO_HEIGHT()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(WorkPublishVideoView.class), "MAX_VIDEO_WIDTH", "getMAX_VIDEO_WIDTH()I"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59063e = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f59064f = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.r = new Path();
        this.s = new RectF();
        initView();
    }

    public static final /* synthetic */ TbImageView access$getCoverView$p(WorkPublishVideoView workPublishVideoView) {
        TbImageView tbImageView = workPublishVideoView.f59065g;
        if (tbImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
        }
        return tbImageView;
    }

    private final int getMAX_VIDEO_HEIGHT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            Lazy lazy = this.f59063e;
            KProperty kProperty = u[0];
            return ((Number) lazy.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    private final int getMAX_VIDEO_WIDTH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Lazy lazy = this.f59064f;
            KProperty kProperty = u[1];
            return ((Number) lazy.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final void adjustSize(int i2, int i3) {
        int i4;
        int g2;
        int max_video_height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int i5 = 0;
            if (i3 > 0) {
                if (i2 >= i3) {
                    g2 = getMAX_VIDEO_WIDTH();
                    max_video_height = l.g(getContext(), R.dimen.tbds569);
                } else {
                    g2 = l.g(getContext(), R.dimen.tbds650);
                    max_video_height = getMAX_VIDEO_HEIGHT();
                }
                int i6 = g2;
                i5 = max_video_height;
                i4 = i6;
            } else {
                i4 = 0;
            }
            getLayoutParams().height = i5;
            getLayoutParams().width = i4;
            View view = this.l;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            view.getLayoutParams().width = i4;
            View view2 = this.l;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            view2.getLayoutParams().height = i5;
            TbImageView tbImageView = this.f59065g;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            tbImageView.getLayoutParams().width = i4;
            TbImageView tbImageView2 = this.f59065g;
            if (tbImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            tbImageView2.getLayoutParams().height = i5;
            View view3 = this.f59066h;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
            }
            view3.getLayoutParams().width = i4;
            View view4 = this.f59066h;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
            }
            view4.getLayoutParams().height = i5;
            invalidate();
        }
    }

    public final void deleteCoverCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbImageView tbImageView = this.f59065g;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            if (tbImageView != null) {
                TbImageView tbImageView2 = this.f59065g;
                if (tbImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                }
                if (tbImageView2.getTag() != null) {
                    c.a.p0.b0.c k = c.a.p0.b0.c.k();
                    TbImageView tbImageView3 = this.f59065g;
                    if (tbImageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverView");
                    }
                    k.h(tbImageView3.getTag().toString());
                    c.a.p0.b0.c k2 = c.a.p0.b0.c.k();
                    TbImageView tbImageView4 = this.f59065g;
                    if (tbImageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverView");
                    }
                    k2.g(tbImageView4.getTag().toString());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            canvas.save();
            canvas.clipPath(this.r);
            super.dispatchDraw(canvas);
            float width = getWidth();
            float g2 = l.g(getContext(), R.dimen.tbds5);
            Paint paint = this.o;
            if (paint == null) {
                Intrinsics.throwNpe();
            }
            canvas.drawRect(0.0f, 0.0f, width, g2, paint);
            float width2 = getWidth() * this.m;
            float g3 = l.g(getContext(), R.dimen.tbds5);
            Paint paint2 = this.p;
            if (paint2 == null) {
                Intrinsics.throwNpe();
            }
            canvas.drawRect(0.0f, 0.0f, width2, g3, paint2);
            canvas.restore();
        }
    }

    public final c.a.q0.b4.u.q.b.b getIWriteVideoPreviewListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (c.a.q0.b4.u.q.b.b) invokeV.objValue;
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.work_publish_video_view, (ViewGroup) this, true);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…h_video_view, this, true)");
            this.l = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById = inflate.findViewById(R.id.video_thumbnail);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mRootView.findViewById(R.id.video_thumbnail)");
            this.f59065g = (TbImageView) findViewById;
            View view = this.l;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById2 = view.findViewById(R.id.video_thumbnail_mask);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mRootView.findViewById(R.id.video_thumbnail_mask)");
            this.f59066h = findViewById2;
            View view2 = this.l;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById3 = view2.findViewById(R.id.video_play);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "mRootView.findViewById(R.id.video_play)");
            this.f59067i = (ImageView) findViewById3;
            View view3 = this.l;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById4 = view3.findViewById(R.id.video_cover);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "mRootView.findViewById(R.id.video_cover)");
            this.k = (TextView) findViewById4;
            View view4 = this.l;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById5 = view4.findViewById(R.id.video_edit);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "mRootView.findViewById(R.id.video_edit)");
            this.f59068j = (TextView) findViewById5;
            TbImageView tbImageView = this.f59065g;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            tbImageView.setConrers(15);
            TbImageView tbImageView2 = this.f59065g;
            if (tbImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            tbImageView2.setRadiusById(R.string.J_X05);
            TbImageView tbImageView3 = this.f59065g;
            if (tbImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            tbImageView3.setDrawCorner(true);
            TbImageView tbImageView4 = this.f59065g;
            if (tbImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            tbImageView4.setPlaceHolder(3);
            View view5 = this.f59066h;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
            }
            c.a.p0.s.u.c.d(view5).n(R.string.J_X05);
            onChangeSkin();
            this.n = new c.a.p0.c0.b();
            this.o = new Paint();
            this.p = new Paint();
            ImageView imageView = this.f59067i;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
            }
            imageView.setOnClickListener(new a(this));
            TextView textView = this.k;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverBtn");
            }
            textView.setOnClickListener(new b(this));
            TextView textView2 = this.f59068j;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editBtn");
            }
            textView2.setOnClickListener(new c(this));
        }
    }

    public final void loadCover() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(this.q);
            ImageOperation g2 = c.a.p0.c0.i.d.g(getMAX_VIDEO_WIDTH(), getMAX_VIDEO_HEIGHT());
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g2);
            TbImageView tbImageView = this.f59065g;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            tbImageView.setTag(imageFileInfo.toCachedKey(false));
            c.a.p0.c0.b bVar = this.n;
            if (bVar == null) {
                Intrinsics.throwNpe();
            }
            c.a.e.l.d.a c2 = bVar.c(imageFileInfo, false);
            if (c2 != null) {
                adjustSize(c2.r(), c2.m());
                TbImageView tbImageView2 = this.f59065g;
                if (tbImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                }
                tbImageView2.invalidate();
                return;
            }
            c.a.p0.c0.b bVar2 = this.n;
            if (bVar2 == null) {
                Intrinsics.throwNpe();
            }
            bVar2.d(imageFileInfo, new d(this), false);
        }
    }

    public final void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Paint paint = this.o;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(R.color.CAM_X0618));
            }
            Paint paint2 = this.p;
            if (paint2 != null) {
                paint2.setColor(SkinManager.getColor(R.color.CAM_X0302));
            }
            View view = this.f59066h;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
            }
            c.a.p0.s.u.c.d(view).r(R.array.Mask_X003);
            TextView textView = this.f59068j;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editBtn");
            }
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView);
            d2.u(R.color.CAM_X0101);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0607);
            TextView textView2 = this.k;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverBtn");
            }
            c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(textView2);
            d3.u(R.color.CAM_X0101);
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0607);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.r.reset();
            this.s.set(0.0f, 0.0f, i2, i3);
            this.r.addRoundRect(this.s, l.g(getContext(), R.dimen.tbds21), l.g(getContext(), R.dimen.tbds21), Path.Direction.CW);
        }
    }

    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m = 0.0f;
            this.q = null;
        }
    }

    public final void setIWriteVideoPreviewListener(c.a.q0.b4.u.q.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.t = bVar;
        }
    }

    public final void setVideoInfo(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editVideoData) == null) {
            if (editVideoData != null && editVideoData.isLegal()) {
                setVisibility(0);
                this.q = editVideoData.coverPath;
                loadCover();
                return;
            }
            setVisibility(8);
        }
    }

    public final void updatePercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.m = f2;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f59063e = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f59064f = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.r = new Path();
        this.s = new RectF();
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f59063e = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f59064f = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.r = new Path();
        this.s = new RectF();
        initView();
    }
}
