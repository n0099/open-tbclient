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
import d.a.c.e.p.l;
import d.a.o0.b0.g.d;
/* loaded from: classes4.dex */
public class PreviewVideoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static int q;
    public static int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f22922e;

    /* renamed from: f  reason: collision with root package name */
    public CustomVideoView f22923f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22924g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f22925h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f22926i;
    public float j;
    public d.a.o0.b0.b k;
    public Paint l;
    public Paint m;
    public String n;
    public Path o;
    public RectF p;

    /* loaded from: classes4.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreviewVideoView f22927e;

        public a(PreviewVideoView previewVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {previewVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22927e = previewVideoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreviewVideoView f22928e;

        public b(PreviewVideoView previewVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {previewVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22928e = previewVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                this.f22928e.b(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                this.f22928e.f22922e.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.o0.a0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreviewVideoView f22929e;

        public c(PreviewVideoView previewVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {previewVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22929e = previewVideoView;
        }

        @Override // d.a.o0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || this.f22929e.f22922e == null || aVar == null) {
                return;
            }
            this.f22929e.b(aVar.r(), aVar.m());
            this.f22929e.f22922e.invalidate();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new Path();
        this.p = new RectF();
        e(context);
    }

    public void b(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int i5 = 0;
            if (i3 <= 0) {
                i4 = 0;
            } else if (i2 >= i3) {
                i5 = r;
                i4 = l.g(getContext(), R.dimen.tbds569);
            } else {
                i5 = l.g(getContext(), R.dimen.tbds650);
                i4 = q;
            }
            if (this.f22923f.getWidth() == i5 && this.f22923f.getHeight() == i4) {
                return;
            }
            this.f22923f.setVideoHeight(i4);
            this.f22923f.setVideoWidth(i5);
            ViewGroup.LayoutParams layoutParams = this.f22922e.getLayoutParams();
            layoutParams.width = i5;
            layoutParams.height = i4;
            this.f22922e.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i5;
            invalidate();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22924g.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            this.l.setColor(SkinManager.getColor(R.color.CAM_X0618));
            this.m.setColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbImageView = this.f22922e) == null || tbImageView.getTag() == null) {
            return;
        }
        d.a.o0.a0.c.k().h(this.f22922e.getTag().toString());
        d.a.o0.a0.c.k().g(this.f22922e.getTag().toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.save();
            canvas.clipPath(this.o);
            super.dispatchDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, getWidth(), l.g(getContext(), R.dimen.tbds5), this.l);
            canvas.drawRect(0.0f, 0.0f, getWidth() * this.j, l.g(getContext(), R.dimen.tbds5), this.m);
            canvas.restore();
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            q = l.g(getContext(), R.dimen.tbds866);
            r = l.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            f(context);
            this.k = new d.a.o0.b0.b();
            TbImageView tbImageView = new TbImageView(context);
            this.f22922e = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f22922e, new FrameLayout.LayoutParams(-2, -2));
            this.f22924g = new ImageView(context);
            int g2 = l.g(context, R.dimen.M_H_X001);
            int g3 = l.g(context, R.dimen.M_W_X003);
            this.f22924g.setPadding(g3, g2, g3, g2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds94), l.g(context, R.dimen.tbds94));
            layoutParams.gravity = 53;
            addView(this.f22924g, layoutParams);
            d.a.o0.r.f0.n.b bVar = new d.a.o0.r.f0.n.b();
            bVar.p();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds96), l.g(context, R.dimen.tbds48));
            layoutParams2.gravity = 83;
            layoutParams2.bottomMargin = l.g(context, R.dimen.M_H_X002);
            layoutParams2.leftMargin = l.g(context, R.dimen.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f22925h = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f22925h.setText(context.getString(R.string.edit));
            this.f22925h.setTextSize(R.dimen.T_X10);
            addView(this.f22925h, layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds96), l.g(context, R.dimen.tbds48));
            layoutParams3.gravity = 85;
            layoutParams3.bottomMargin = l.g(context, R.dimen.M_H_X002);
            layoutParams3.rightMargin = l.g(context, R.dimen.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn2 = new TBSpecificationBtn(context);
            this.f22926i = tBSpecificationBtn2;
            tBSpecificationBtn2.setConfig(bVar);
            this.f22926i.setText(context.getString(R.string.cover));
            this.f22926i.setTextSize(R.dimen.T_X10);
            addView(this.f22926i, layoutParams3);
            this.l = new Paint();
            this.m = new Paint();
            c();
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            CustomVideoView customVideoView = new CustomVideoView(context);
            this.f22923f = customVideoView;
            addView(customVideoView, new FrameLayout.LayoutParams(-2, -2));
            this.f22923f.setOnCompletionListener(new a(this));
            this.f22923f.setOnPreparedListener(new b(this));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(this.n);
            ImageOperation g2 = d.g(r, q);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g2);
            this.f22922e.setTag(imageFileInfo.toCachedKey(false));
            d.a.c.k.d.a c2 = this.k.c(imageFileInfo, false);
            if (c2 != null) {
                b(c2.r(), c2.m());
                this.f22922e.invalidate();
                return;
            }
            this.k.d(imageFileInfo, new c(this), false);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j = 0.0f;
            this.n = null;
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f22923f.getCurrentPosition();
            CustomVideoView customVideoView = this.f22923f;
            if (customVideoView != null) {
                customVideoView.stopPlayback();
                this.f22923f.setVideoURI(null);
            }
            this.f22922e.setVisibility(0);
        }
    }

    public void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.j = f2;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.o.reset();
            this.p.set(0.0f, 0.0f, i2, i3);
            this.o.addRoundRect(this.p, l.g(getContext(), R.dimen.tbds10), l.g(getContext(), R.dimen.tbds10), Path.Direction.CW);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.f22924g.setOnClickListener(onClickListener);
            this.f22925h.setOnClickListener(onClickListener);
            this.f22926i.setOnClickListener(onClickListener);
        }
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editVideoData) == null) {
            i();
            if (editVideoData != null && editVideoData.isLegal()) {
                setVisibility(0);
                this.n = editVideoData.coverPath;
                g();
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
        this.o = new Path();
        this.p = new RectF();
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.o = new Path();
        this.p = new RectF();
        e(context);
    }
}
