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
import c.a.d.f.p.n;
import c.a.d.o.d.a;
import c.a.o0.c0.b;
import c.a.o0.c0.i.d;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
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
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tJ\u0006\u00105\u001a\u000202J\u0010\u00106\u001a\u0002022\u0006\u00107\u001a\u000208H\u0014J\u0006\u00109\u001a\u000202J\u0006\u0010:\u001a\u000202J\u0006\u0010;\u001a\u000202J(\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0014J\u0006\u0010A\u001a\u000202J\u0010\u0010B\u001a\u0002022\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u0002022\u0006\u0010&\u001a\u00020'R\u001b\u0010\u000b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MAX_VIDEO_HEIGHT", "getMAX_VIDEO_HEIGHT", "()I", "MAX_VIDEO_HEIGHT$delegate", "Lkotlin/Lazy;", "MAX_VIDEO_WIDTH", "getMAX_VIDEO_WIDTH", "MAX_VIDEO_WIDTH$delegate", "coverBtn", "Landroid/widget/TextView;", "coverPath", "", "coverView", "Lcom/baidu/tbadk/widget/TbImageView;", "editBtn", "iWriteVideoPreviewListener", "Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "getIWriteVideoPreviewListener", "()Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "setIWriteVideoPreviewListener", "(Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;)V", "mAsyncLocalImageLoader", "Lcom/baidu/tbadk/img/AsyncLocalImageLoader;", "mCurrentVideoPosition", "mRootView", "Landroid/view/View;", "maskView", "percent", "", "playView", "Landroid/widget/ImageView;", "progressBarBackgroundPaint", "Landroid/graphics/Paint;", "progressBarPaint", "rect", "Landroid/graphics/RectF;", "roundPath", "Landroid/graphics/Path;", "adjustSize", "", "videoWidth", "videoHeight", "deleteCoverCache", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "initView", "loadCover", "onChangeSkin", "onSizeChanged", "w", "h", "oldw", "oldh", "reset", "setVideoInfo", "editVideoData", "Lcom/baidu/tieba/video/EditVideoData;", "updatePercent", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkPublishVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f37619b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f37620c;

    /* renamed from: d  reason: collision with root package name */
    public View f37621d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f37622e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37623f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37624g;

    /* renamed from: h  reason: collision with root package name */
    public View f37625h;
    public float i;
    public b j;
    public Paint k;
    public Paint l;
    public String m;
    public final Path n;
    public final RectF o;
    public c.a.p0.s4.u.p.x.b p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f37619b = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.n = new Path();
        this.o = new RectF();
        b();
    }

    public static final void c(WorkPublishVideoView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.a.p0.s4.u.p.x.b iWriteVideoPreviewListener = this$0.getIWriteVideoPreviewListener();
            if (iWriteVideoPreviewListener == null) {
                return;
            }
            iWriteVideoPreviewListener.b();
        }
    }

    public static final void d(WorkPublishVideoView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.a.p0.s4.u.p.x.b iWriteVideoPreviewListener = this$0.getIWriteVideoPreviewListener();
            if (iWriteVideoPreviewListener == null) {
                return;
            }
            iWriteVideoPreviewListener.a();
        }
    }

    public static final void e(WorkPublishVideoView this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.a.p0.s4.u.p.x.b iWriteVideoPreviewListener = this$0.getIWriteVideoPreviewListener();
            if (iWriteVideoPreviewListener == null) {
                return;
            }
            iWriteVideoPreviewListener.c();
        }
    }

    public static final void g(WorkPublishVideoView this$0, a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{this$0, aVar, str, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.f37620c == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            }
            TbImageView tbImageView = null;
            if (aVar != null) {
                this$0.a(aVar.r(), aVar.m());
                TbImageView tbImageView2 = this$0.f37620c;
                if (tbImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.invalidate();
                return;
            }
            this$0.a(16, 9);
            TbImageView tbImageView3 = this$0.f37620c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? ((Number) this.a.getValue()).intValue() : invokeV.intValue;
    }

    private final int getMAX_VIDEO_WIDTH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? ((Number) this.f37619b.getValue()).intValue() : invokeV.intValue;
    }

    public final void a(int i, int i2) {
        int i3;
        int f2;
        int f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            int i4 = 0;
            if (i2 > 0) {
                if (i >= i2) {
                    f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds504);
                    f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds286);
                } else {
                    f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds336);
                    f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds447);
                }
                int i5 = f2;
                i4 = f3;
                i3 = i5;
            } else {
                i3 = 0;
            }
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            View view = this.f37625h;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            view.getLayoutParams().width = i3;
            View view3 = this.f37625h;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            view3.getLayoutParams().height = i4;
            TbImageView tbImageView = this.f37620c;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView = null;
            }
            tbImageView.getLayoutParams().width = i3;
            TbImageView tbImageView2 = this.f37620c;
            if (tbImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView2 = null;
            }
            tbImageView2.getLayoutParams().height = i4;
            View view4 = this.f37621d;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view4 = null;
            }
            view4.getLayoutParams().width = i3;
            View view5 = this.f37621d;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
            } else {
                view2 = view5;
            }
            view2.getLayoutParams().height = i4;
            requestLayout();
            invalidate();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08de, (ViewGroup) this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          …h_video_view, this, true)");
            this.f37625h = inflate;
            TextView textView = null;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f092392);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.video_thumbnail)");
            this.f37620c = (TbImageView) findViewById;
            View view = this.f37625h;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            View findViewById2 = view.findViewById(R.id.obfuscated_res_0x7f092393);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.video_thumbnail_mask)");
            this.f37621d = findViewById2;
            View view2 = this.f37625h;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view2 = null;
            }
            View findViewById3 = view2.findViewById(R.id.obfuscated_res_0x7f092361);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.video_play)");
            this.f37622e = (ImageView) findViewById3;
            View view3 = this.f37625h;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            View findViewById4 = view3.findViewById(R.id.obfuscated_res_0x7f09231e);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.video_cover)");
            this.f37624g = (TextView) findViewById4;
            View view4 = this.f37625h;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view4 = null;
            }
            View findViewById5 = view4.findViewById(R.id.obfuscated_res_0x7f092324);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.video_edit)");
            this.f37623f = (TextView) findViewById5;
            TbImageView tbImageView = this.f37620c;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView = null;
            }
            tbImageView.setConrers(15);
            TbImageView tbImageView2 = this.f37620c;
            if (tbImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView2 = null;
            }
            tbImageView2.setRadiusById(R.string.J_X05);
            TbImageView tbImageView3 = this.f37620c;
            if (tbImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView3 = null;
            }
            tbImageView3.setDrawCorner(true);
            TbImageView tbImageView4 = this.f37620c;
            if (tbImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView4 = null;
            }
            tbImageView4.setPlaceHolder(3);
            View view5 = this.f37621d;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view5 = null;
            }
            c.d(view5).n(R.string.J_X05);
            h();
            this.j = new b();
            this.k = new Paint();
            this.l = new Paint();
            View view6 = this.f37625h;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view6 = null;
            }
            view6.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.b0.b
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
            TextView textView2 = this.f37624g;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverBtn");
                textView2 = null;
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.b0.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view7) == null) {
                        WorkPublishVideoView.d(WorkPublishVideoView.this, view7);
                    }
                }
            });
            TextView textView3 = this.f37623f;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editBtn");
            } else {
                textView = textView3;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.b0.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view7) == null) {
                        WorkPublishVideoView.e(WorkPublishVideoView.this, view7);
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.save();
            canvas.clipPath(this.n);
            super.dispatchDraw(canvas);
            Paint paint = this.k;
            Intrinsics.checkNotNull(paint);
            canvas.drawRect(0.0f, 0.0f, getWidth(), n.f(getContext(), R.dimen.tbds5), paint);
            Paint paint2 = this.l;
            Intrinsics.checkNotNull(paint2);
            canvas.drawRect(0.0f, 0.0f, getWidth() * this.i, n.f(getContext(), R.dimen.tbds5), paint2);
            canvas.restore();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(this.m);
            ImageOperation g2 = d.g(getMAX_VIDEO_WIDTH(), getMAX_VIDEO_HEIGHT());
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g2);
            TbImageView tbImageView = this.f37620c;
            TbImageView tbImageView2 = null;
            if (tbImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
                tbImageView = null;
            }
            tbImageView.setTag(imageFileInfo.toCachedKey(false));
            b bVar = this.j;
            Intrinsics.checkNotNull(bVar);
            a c2 = bVar.c(imageFileInfo, false);
            if (c2 != null) {
                a(c2.r(), c2.m());
                TbImageView tbImageView3 = this.f37620c;
                if (tbImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverView");
                } else {
                    tbImageView2 = tbImageView3;
                }
                tbImageView2.invalidate();
                return;
            }
            b bVar2 = this.j;
            Intrinsics.checkNotNull(bVar2);
            bVar2.d(imageFileInfo, new c.a.o0.b0.b() { // from class: c.a.p0.s4.u.p.b0.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.o0.b0.b
                public final void a(c.a.d.o.d.a aVar, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLZ(1048576, this, aVar, str, z) == null) {
                        WorkPublishVideoView.g(WorkPublishVideoView.this, aVar, str, z);
                    }
                }
            }, false);
        }
    }

    public final c.a.p0.s4.u.p.x.b getIWriteVideoPreviewListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : (c.a.p0.s4.u.p.x.b) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Paint paint = this.k;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(R.color.CAM_X0618));
            }
            Paint paint2 = this.l;
            if (paint2 != null) {
                paint2.setColor(SkinManager.getColor(R.color.CAM_X0302));
            }
            View view = this.f37621d;
            TextView textView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view = null;
            }
            c.d(view).s(R.array.Mask_X003);
            TextView textView2 = this.f37623f;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editBtn");
                textView2 = null;
            }
            c d2 = c.d(textView2);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0607);
            TextView textView3 = this.f37624g;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverBtn");
            } else {
                textView = textView3;
            }
            c d3 = c.d(textView);
            d3.v(R.color.CAM_X0101);
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0607);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i = 0.0f;
            this.m = null;
        }
    }

    public final void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.i = f2;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.n.reset();
            this.o.set(0.0f, 0.0f, i, i2);
            this.n.addRoundRect(this.o, n.f(getContext(), R.dimen.tbds21), n.f(getContext(), R.dimen.tbds21), Path.Direction.CW);
        }
    }

    public final void setIWriteVideoPreviewListener(c.a.p0.s4.u.p.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public final void setVideoInfo(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editVideoData) == null) {
            if (editVideoData != null && editVideoData.isLegal()) {
                setVisibility(0);
                this.m = editVideoData.coverPath;
                f();
                return;
            }
            setVisibility(8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f37619b = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.n = new Path();
        this.o = new RectF();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_HEIGHT$2(this));
        this.f37619b = LazyKt__LazyJVMKt.lazy(new WorkPublishVideoView$MAX_VIDEO_WIDTH$2(this));
        this.n = new Path();
        this.o = new RectF();
        b();
    }
}
