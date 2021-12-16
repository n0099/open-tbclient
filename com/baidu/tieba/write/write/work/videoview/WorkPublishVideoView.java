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
import c.a.d.f.p.m;
import c.a.d.m.d.a;
import c.a.r0.c0.c;
import c.a.r0.d0.b;
import c.a.r0.d0.i.d;
import c.a.s0.n4.e;
import c.a.s0.n4.g;
import c.a.s0.n4.h;
import c.a.s0.n4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.write.write.work.videoview.WorkPublishVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tJ\u0006\u00105\u001a\u000202J\u0010\u00106\u001a\u0002022\u0006\u00107\u001a\u000208H\u0014J\u0006\u00109\u001a\u000202J\u0006\u0010:\u001a\u000202J\u0006\u0010;\u001a\u000202J(\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0014J\u0006\u0010A\u001a\u000202J\u0010\u0010B\u001a\u0002022\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u0002022\u0006\u0010&\u001a\u00020'R\u001b\u0010\u000b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MAX_VIDEO_HEIGHT", "getMAX_VIDEO_HEIGHT", "()I", "MAX_VIDEO_HEIGHT$delegate", "Lkotlin/Lazy;", "MAX_VIDEO_WIDTH", "getMAX_VIDEO_WIDTH", "MAX_VIDEO_WIDTH$delegate", "coverBtn", "Landroid/widget/TextView;", "coverPath", "", "coverView", "Lcom/baidu/tbadk/widget/TbImageView;", "editBtn", "iWriteVideoPreviewListener", "Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "getIWriteVideoPreviewListener", "()Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "setIWriteVideoPreviewListener", "(Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;)V", "mAsyncLocalImageLoader", "Lcom/baidu/tbadk/img/AsyncLocalImageLoader;", "mCurrentVideoPosition", "mRootView", "Landroid/view/View;", "maskView", SapiOptions.KEY_CACHE_PERCENT, "", "playView", "Landroid/widget/ImageView;", "progressBarBackgroundPaint", "Landroid/graphics/Paint;", "progressBarPaint", "rect", "Landroid/graphics/RectF;", "roundPath", "Landroid/graphics/Path;", "adjustSize", "", "videoWidth", "videoHeight", "deleteCoverCache", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "initView", "loadCover", "onChangeSkin", "onSizeChanged", "w", "h", "oldw", "oldh", "reset", "setVideoInfo", "editVideoData", "Lcom/baidu/tieba/video/EditVideoData;", "updatePercent", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class WorkPublishVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f51805e;

    /* renamed from: f  reason: collision with root package name */
    public final Lazy f51806f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f51807g;

    /* renamed from: h  reason: collision with root package name */
    public View f51808h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f51809i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51810j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f51811k;
    public View l;
    public float m;
    public b n;
    public Paint o;
    public Paint p;
    public String q;
    public final Path r;
    public final RectF s;
    public c.a.s0.n4.e0.p.x.b t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51805e = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f51806f = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.r = new Path();
        this.s = new RectF();
        initView();
    }

    public static final void a(WorkPublishVideoView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.a.s0.n4.e0.p.x.b iWriteVideoPreviewListener = this$0.getIWriteVideoPreviewListener();
            if (iWriteVideoPreviewListener == null) {
                return;
            }
            iWriteVideoPreviewListener.onPlayClick();
        }
    }

    public static final void b(WorkPublishVideoView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.a.s0.n4.e0.p.x.b iWriteVideoPreviewListener = this$0.getIWriteVideoPreviewListener();
            if (iWriteVideoPreviewListener == null) {
                return;
            }
            iWriteVideoPreviewListener.onCoverEditClick();
        }
    }

    public static final void c(WorkPublishVideoView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.a.s0.n4.e0.p.x.b iWriteVideoPreviewListener = this$0.getIWriteVideoPreviewListener();
            if (iWriteVideoPreviewListener == null) {
                return;
            }
            iWriteVideoPreviewListener.onEditClick();
        }
    }

    public static final void d(WorkPublishVideoView this$0, a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{this$0, aVar, str, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.f51807g == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            TbImageView tbImageView = null;
            if (aVar != null) {
                this$0.adjustSize(aVar.r(), aVar.m());
                TbImageView tbImageView2 = this$0.f51807g;
                if (tbImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.invalidate();
                return;
            }
            this$0.adjustSize(16, 9);
            TbImageView tbImageView3 = this$0.f51807g;
            if (tbImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            } else {
                tbImageView = tbImageView3;
            }
            tbImageView.invalidate();
        }
    }

    private final int getMAX_VIDEO_HEIGHT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? ((Number) this.f51805e.getValue()).intValue() : invokeV.intValue;
    }

    private final int getMAX_VIDEO_WIDTH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? ((Number) this.f51806f.getValue()).intValue() : invokeV.intValue;
    }

    public final void adjustSize(int i2, int i3) {
        int i4;
        int f2;
        int f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int i5 = 0;
            if (i3 > 0) {
                if (i2 >= i3) {
                    f2 = m.f(TbadkCoreApplication.getInst(), e.tbds504);
                    f3 = m.f(TbadkCoreApplication.getInst(), e.tbds286);
                } else {
                    f2 = m.f(TbadkCoreApplication.getInst(), e.tbds336);
                    f3 = m.f(TbadkCoreApplication.getInst(), e.tbds447);
                }
                int i6 = f2;
                i5 = f3;
                i4 = i6;
            } else {
                i4 = 0;
            }
            getLayoutParams().height = i5;
            getLayoutParams().width = i4;
            View view = this.l;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            view.getLayoutParams().width = i4;
            View view3 = this.l;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            view3.getLayoutParams().height = i5;
            TbImageView tbImageView = this.f51807g;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView = null;
            }
            tbImageView.getLayoutParams().width = i4;
            TbImageView tbImageView2 = this.f51807g;
            if (tbImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView2 = null;
            }
            tbImageView2.getLayoutParams().height = i5;
            View view4 = this.f51808h;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view4 = null;
            }
            view4.getLayoutParams().width = i4;
            View view5 = this.f51808h;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
            } else {
                view2 = view5;
            }
            view2.getLayoutParams().height = i5;
            requestLayout();
            invalidate();
        }
    }

    public final void deleteCoverCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f51807g == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            TbImageView tbImageView = this.f51807g;
            TbImageView tbImageView2 = null;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView = null;
            }
            if (tbImageView.getTag() != null) {
                c k2 = c.k();
                TbImageView tbImageView3 = this.f51807g;
                if (tbImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                    tbImageView3 = null;
                }
                k2.h(tbImageView3.getTag().toString());
                c k3 = c.k();
                TbImageView tbImageView4 = this.f51807g;
                if (tbImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                } else {
                    tbImageView2 = tbImageView4;
                }
                k3.g(tbImageView2.getTag().toString());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.save();
            canvas.clipPath(this.r);
            super.dispatchDraw(canvas);
            Paint paint = this.o;
            Intrinsics.checkNotNull(paint);
            canvas.drawRect(0.0f, 0.0f, getWidth(), m.f(getContext(), e.tbds5), paint);
            Paint paint2 = this.p;
            Intrinsics.checkNotNull(paint2);
            canvas.drawRect(0.0f, 0.0f, getWidth() * this.m, m.f(getContext(), e.tbds5), paint2);
            canvas.restore();
        }
    }

    public final c.a.s0.n4.e0.p.x.b getIWriteVideoPreviewListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (c.a.s0.n4.e0.p.x.b) invokeV.objValue;
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(h.work_publish_video_view, (ViewGroup) this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          …h_video_view, this, true)");
            this.l = inflate;
            TextView textView = null;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                inflate = null;
            }
            View findViewById = inflate.findViewById(g.video_thumbnail);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.video_thumbnail)");
            this.f51807g = (TbImageView) findViewById;
            View view = this.l;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            View findViewById2 = view.findViewById(g.video_thumbnail_mask);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.video_thumbnail_mask)");
            this.f51808h = findViewById2;
            View view2 = this.l;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view2 = null;
            }
            View findViewById3 = view2.findViewById(g.video_play);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.video_play)");
            this.f51809i = (ImageView) findViewById3;
            View view3 = this.l;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            View findViewById4 = view3.findViewById(g.video_cover);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.video_cover)");
            this.f51811k = (TextView) findViewById4;
            View view4 = this.l;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view4 = null;
            }
            View findViewById5 = view4.findViewById(g.video_edit);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.video_edit)");
            this.f51810j = (TextView) findViewById5;
            TbImageView tbImageView = this.f51807g;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView = null;
            }
            tbImageView.setConrers(15);
            TbImageView tbImageView2 = this.f51807g;
            if (tbImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView2 = null;
            }
            tbImageView2.setRadiusById(j.J_X05);
            TbImageView tbImageView3 = this.f51807g;
            if (tbImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView3 = null;
            }
            tbImageView3.setDrawCorner(true);
            TbImageView tbImageView4 = this.f51807g;
            if (tbImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView4 = null;
            }
            tbImageView4.setPlaceHolder(3);
            View view5 = this.f51808h;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view5 = null;
            }
            c.a.r0.s.v.c.d(view5).n(j.J_X05);
            onChangeSkin();
            this.n = new b();
            this.o = new Paint();
            this.p = new Paint();
            View view6 = this.l;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view6 = null;
            }
            view6.setOnClickListener(new View.OnClickListener() { // from class: c.a.s0.n4.e0.p.b0.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view7) == null) {
                        WorkPublishVideoView.a(WorkPublishVideoView.this, view7);
                    }
                }
            });
            TextView textView2 = this.f51811k;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverBtn");
                textView2 = null;
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: c.a.s0.n4.e0.p.b0.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view7) == null) {
                        WorkPublishVideoView.b(WorkPublishVideoView.this, view7);
                    }
                }
            });
            TextView textView3 = this.f51810j;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editBtn");
            } else {
                textView = textView3;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: c.a.s0.n4.e0.p.b0.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view7) == null) {
                        WorkPublishVideoView.c(WorkPublishVideoView.this, view7);
                    }
                }
            });
        }
    }

    public final void loadCover() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(this.q);
            ImageOperation g2 = d.g(getMAX_VIDEO_WIDTH(), getMAX_VIDEO_HEIGHT());
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g2);
            TbImageView tbImageView = this.f51807g;
            TbImageView tbImageView2 = null;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView = null;
            }
            tbImageView.setTag(imageFileInfo.toCachedKey(false));
            b bVar = this.n;
            Intrinsics.checkNotNull(bVar);
            a c2 = bVar.c(imageFileInfo, false);
            if (c2 != null) {
                adjustSize(c2.r(), c2.m());
                TbImageView tbImageView3 = this.f51807g;
                if (tbImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                } else {
                    tbImageView2 = tbImageView3;
                }
                tbImageView2.invalidate();
                return;
            }
            b bVar2 = this.n;
            Intrinsics.checkNotNull(bVar2);
            bVar2.d(imageFileInfo, new c.a.r0.c0.b() { // from class: c.a.s0.n4.e0.p.b0.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.r0.c0.b
                public final void imageLoaded(c.a.d.m.d.a aVar, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLZ(1048576, this, aVar, str, z) == null) {
                        WorkPublishVideoView.d(WorkPublishVideoView.this, aVar, str, z);
                    }
                }
            }, false);
        }
    }

    public final void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Paint paint = this.o;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(c.a.s0.n4.d.CAM_X0618));
            }
            Paint paint2 = this.p;
            if (paint2 != null) {
                paint2.setColor(SkinManager.getColor(c.a.s0.n4.d.CAM_X0302));
            }
            View view = this.f51808h;
            TextView textView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view = null;
            }
            c.a.r0.s.v.c.d(view).s(c.a.s0.n4.c.Mask_X003);
            TextView textView2 = this.f51810j;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editBtn");
                textView2 = null;
            }
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(textView2);
            d2.v(c.a.s0.n4.d.CAM_X0101);
            d2.n(j.J_X06);
            d2.f(c.a.s0.n4.d.CAM_X0607);
            TextView textView3 = this.f51811k;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverBtn");
            } else {
                textView = textView3;
            }
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(textView);
            d3.v(c.a.s0.n4.d.CAM_X0101);
            d3.n(j.J_X06);
            d3.f(c.a.s0.n4.d.CAM_X0607);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.r.reset();
            this.s.set(0.0f, 0.0f, i2, i3);
            this.r.addRoundRect(this.s, m.f(getContext(), e.tbds21), m.f(getContext(), e.tbds21), Path.Direction.CW);
        }
    }

    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m = 0.0f;
            this.q = null;
        }
    }

    public final void setIWriteVideoPreviewListener(c.a.s0.n4.e0.p.x.b bVar) {
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51805e = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f51806f = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
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
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51805e = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f51806f = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.r = new Path();
        this.s = new RectF();
        initView();
    }
}
