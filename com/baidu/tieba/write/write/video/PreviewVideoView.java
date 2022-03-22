package com.baidu.tieba.write.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.c0.i.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PreviewVideoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public static int n;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public CustomVideoView f37493b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37494c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f37495d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f37496e;

    /* renamed from: f  reason: collision with root package name */
    public float f37497f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.c0.b f37498g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f37499h;
    public Paint i;
    public String j;
    public Path k;
    public RectF l;

    /* loaded from: classes6.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PreviewVideoView a;

        public a(PreviewVideoView previewVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {previewVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = previewVideoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PreviewVideoView a;

        public b(PreviewVideoView previewVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {previewVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = previewVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                this.a.b(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                this.a.a.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.o0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PreviewVideoView a;

        public c(PreviewVideoView previewVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {previewVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = previewVideoView;
        }

        @Override // c.a.o0.b0.b
        public void a(c.a.d.o.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || this.a.a == null || aVar == null) {
                return;
            }
            this.a.b(aVar.r(), aVar.m());
            this.a.a.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewVideoView(@NonNull Context context) {
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
        this.k = new Path();
        this.l = new RectF();
        d(context);
    }

    public void b(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            int i4 = 0;
            if (i2 <= 0) {
                i3 = 0;
            } else if (i >= i2) {
                i4 = n;
                i3 = n.f(getContext(), R.dimen.tbds569);
            } else {
                i4 = n.f(getContext(), R.dimen.tbds650);
                i3 = m;
            }
            if (this.f37493b.getWidth() == i4 && this.f37493b.getHeight() == i3) {
                return;
            }
            this.f37493b.setVideoHeight(i3);
            this.f37493b.setVideoWidth(i4);
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i3;
            this.a.setLayoutParams(layoutParams);
            getLayoutParams().height = i3;
            getLayoutParams().width = i4;
            invalidate();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f37494c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08080f, WebPManager.ResourceStateType.NORMAL));
            this.f37499h.setColor(SkinManager.getColor(R.color.CAM_X0618));
            this.i.setColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            m = n.f(getContext(), R.dimen.tbds866);
            n = n.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            e(context);
            this.f37498g = new c.a.o0.c0.b();
            TbImageView tbImageView = new TbImageView(context);
            this.a = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.a, new FrameLayout.LayoutParams(-2, -2));
            this.f37494c = new ImageView(context);
            int f2 = n.f(context, R.dimen.M_H_X001);
            int f3 = n.f(context, R.dimen.M_W_X003);
            this.f37494c.setPadding(f3, f2, f3, f2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n.f(context, R.dimen.tbds94), n.f(context, R.dimen.tbds94));
            layoutParams.gravity = 53;
            addView(this.f37494c, layoutParams);
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            bVar.q();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n.f(context, R.dimen.tbds96), n.f(context, R.dimen.tbds48));
            layoutParams2.gravity = 83;
            layoutParams2.bottomMargin = n.f(context, R.dimen.M_H_X002);
            layoutParams2.leftMargin = n.f(context, R.dimen.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f37495d = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f37495d.setText(context.getString(R.string.obfuscated_res_0x7f0f050c));
            this.f37495d.setTextSize(R.dimen.T_X10);
            addView(this.f37495d, layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n.f(context, R.dimen.tbds96), n.f(context, R.dimen.tbds48));
            layoutParams3.gravity = 85;
            layoutParams3.bottomMargin = n.f(context, R.dimen.M_H_X002);
            layoutParams3.rightMargin = n.f(context, R.dimen.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn2 = new TBSpecificationBtn(context);
            this.f37496e = tBSpecificationBtn2;
            tBSpecificationBtn2.setConfig(bVar);
            this.f37496e.setText(context.getString(R.string.obfuscated_res_0x7f0f044b));
            this.f37496e.setTextSize(R.dimen.T_X10);
            addView(this.f37496e, layoutParams3);
            this.f37499h = new Paint();
            this.i = new Paint();
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.save();
            canvas.clipPath(this.k);
            super.dispatchDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, getWidth(), n.f(getContext(), R.dimen.tbds5), this.f37499h);
            canvas.drawRect(0.0f, 0.0f, getWidth() * this.f37497f, n.f(getContext(), R.dimen.tbds5), this.i);
            canvas.restore();
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            CustomVideoView customVideoView = new CustomVideoView(context);
            this.f37493b = customVideoView;
            addView(customVideoView, new FrameLayout.LayoutParams(-2, -2));
            this.f37493b.setOnCompletionListener(new a(this));
            this.f37493b.setOnPreparedListener(new b(this));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(this.j);
            ImageOperation g2 = d.g(n, m);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g2);
            this.a.setTag(imageFileInfo.toCachedKey(false));
            c.a.d.o.d.a c2 = this.f37498g.c(imageFileInfo, false);
            if (c2 != null) {
                b(c2.r(), c2.m());
                this.a.invalidate();
                return;
            }
            this.f37498g.d(imageFileInfo, new c(this), false);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f37493b.getCurrentPosition();
            CustomVideoView customVideoView = this.f37493b;
            if (customVideoView != null) {
                customVideoView.stopPlayback();
                this.f37493b.setVideoURI(null);
            }
            this.a.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.k.reset();
            this.l.set(0.0f, 0.0f, i, i2);
            this.k.addRoundRect(this.l, n.f(getContext(), R.dimen.tbds10), n.f(getContext(), R.dimen.tbds10), Path.Direction.CW);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.f37494c.setOnClickListener(onClickListener);
            this.f37495d.setOnClickListener(onClickListener);
            this.f37496e.setOnClickListener(onClickListener);
        }
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editVideoData) == null) {
            g();
            if (editVideoData != null && editVideoData.isLegal()) {
                setVisibility(0);
                this.j = editVideoData.coverPath;
                f();
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.k = new Path();
        this.l = new RectF();
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.k = new Path();
        this.l = new RectF();
        d(context);
    }
}
