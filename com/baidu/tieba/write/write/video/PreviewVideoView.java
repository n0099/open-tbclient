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
import c.a.t0.p4.d;
import c.a.t0.p4.e;
import c.a.t0.p4.f;
import c.a.t0.p4.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class PreviewVideoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn coverBtn;
    public ImageView deleteIcon;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f49953e;
    public TBSpecificationBtn editBtn;

    /* renamed from: f  reason: collision with root package name */
    public CustomVideoView f49954f;

    /* renamed from: g  reason: collision with root package name */
    public float f49955g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.d0.b f49956h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f49957i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f49958j;
    public int k;
    public String l;
    public Path m;
    public RectF n;

    /* loaded from: classes13.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreviewVideoView f49959e;

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
            this.f49959e = previewVideoView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreviewVideoView f49960e;

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
            this.f49960e = previewVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                this.f49960e.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                this.f49960e.f49953e.setVisibility(8);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements c.a.s0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PreviewVideoView f49961e;

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
            this.f49961e = previewVideoView;
        }

        @Override // c.a.s0.c0.b
        public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || this.f49961e.f49953e == null || aVar == null) {
                return;
            }
            this.f49961e.adjustSize(aVar.r(), aVar.m());
            this.f49961e.f49953e.invalidate();
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
        this.m = new Path();
        this.n = new RectF();
        b(context);
    }

    public void adjustSize(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int i5 = 0;
            if (i3 <= 0) {
                i4 = 0;
            } else if (i2 >= i3) {
                i5 = p;
                i4 = n.f(getContext(), e.tbds569);
            } else {
                i5 = n.f(getContext(), e.tbds650);
                i4 = o;
            }
            if (this.f49954f.getWidth() == i5 && this.f49954f.getHeight() == i4) {
                return;
            }
            this.f49954f.setVideoHeight(i4);
            this.f49954f.setVideoWidth(i5);
            ViewGroup.LayoutParams layoutParams = this.f49953e.getLayoutParams();
            layoutParams.width = i5;
            layoutParams.height = i4;
            this.f49953e.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i5;
            invalidate();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            o = n.f(getContext(), e.tbds866);
            p = n.k(getContext()) - (UtilHelper.getDimenPixelSize(e.M_W_X007) * 2);
            c(context);
            this.f49956h = new c.a.s0.d0.b();
            TbImageView tbImageView = new TbImageView(context);
            this.f49953e = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f49953e, new FrameLayout.LayoutParams(-2, -2));
            this.deleteIcon = new ImageView(context);
            int f2 = n.f(context, e.M_H_X001);
            int f3 = n.f(context, e.M_W_X003);
            this.deleteIcon.setPadding(f3, f2, f3, f2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n.f(context, e.tbds94), n.f(context, e.tbds94));
            layoutParams.gravity = 53;
            addView(this.deleteIcon, layoutParams);
            c.a.s0.s.k0.n.b bVar = new c.a.s0.s.k0.n.b();
            bVar.q();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n.f(context, e.tbds96), n.f(context, e.tbds48));
            layoutParams2.gravity = 83;
            layoutParams2.bottomMargin = n.f(context, e.M_H_X002);
            layoutParams2.leftMargin = n.f(context, e.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.editBtn = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.editBtn.setText(context.getString(j.edit));
            this.editBtn.setTextSize(e.T_X10);
            addView(this.editBtn, layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n.f(context, e.tbds96), n.f(context, e.tbds48));
            layoutParams3.gravity = 85;
            layoutParams3.bottomMargin = n.f(context, e.M_H_X002);
            layoutParams3.rightMargin = n.f(context, e.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn2 = new TBSpecificationBtn(context);
            this.coverBtn = tBSpecificationBtn2;
            tBSpecificationBtn2.setConfig(bVar);
            this.coverBtn.setText(context.getString(j.cover));
            this.coverBtn.setTextSize(e.T_X10);
            addView(this.coverBtn, layoutParams3);
            this.f49957i = new Paint();
            this.f49958j = new Paint();
            changeSkin();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            CustomVideoView customVideoView = new CustomVideoView(context);
            this.f49954f = customVideoView;
            addView(customVideoView, new FrameLayout.LayoutParams(-2, -2));
            this.f49954f.setOnCompletionListener(new a(this));
            this.f49954f.setOnPreparedListener(new b(this));
        }
    }

    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.deleteIcon.setImageDrawable(WebPManager.getMaskDrawable(f.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            this.f49957i.setColor(SkinManager.getColor(d.CAM_X0618));
            this.f49958j.setColor(SkinManager.getColor(d.CAM_X0302));
        }
    }

    public void deleteCoverCache() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (tbImageView = this.f49953e) == null || tbImageView.getTag() == null) {
            return;
        }
        c.a.s0.c0.c.k().h(this.f49953e.getTag().toString());
        c.a.s0.c0.c.k().g(this.f49953e.getTag().toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            canvas.save();
            canvas.clipPath(this.m);
            super.dispatchDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, getWidth(), n.f(getContext(), e.tbds5), this.f49957i);
            canvas.drawRect(0.0f, 0.0f, getWidth() * this.f49955g, n.f(getContext(), e.tbds5), this.f49958j);
            canvas.restore();
        }
    }

    public void loadCover() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(this.l);
            ImageOperation g2 = c.a.s0.d0.i.d.g(p, o);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g2);
            this.f49953e.setTag(imageFileInfo.toCachedKey(false));
            c.a.d.n.d.a c2 = this.f49956h.c(imageFileInfo, false);
            if (c2 != null) {
                adjustSize(c2.r(), c2.m());
                this.f49953e.invalidate();
                return;
            }
            this.f49956h.d(imageFileInfo, new c(this), false);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.m.reset();
            this.n.set(0.0f, 0.0f, i2, i3);
            this.m.addRoundRect(this.n, n.f(getContext(), e.tbds10), n.f(getContext(), e.tbds10), Path.Direction.CW);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = 0;
            this.f49955g = 0.0f;
            this.l = null;
            stopVideo();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.deleteIcon.setOnClickListener(onClickListener);
            this.editBtn.setOnClickListener(onClickListener);
            this.coverBtn.setOnClickListener(onClickListener);
        }
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editVideoData) == null) {
            stopVideo();
            if (editVideoData != null && editVideoData.isLegal()) {
                setVisibility(0);
                this.l = editVideoData.coverPath;
                loadCover();
                return;
            }
            setVisibility(8);
        }
    }

    public void startVideo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f49954f.setVideoPath(str);
        this.f49954f.start();
        this.f49954f.seekTo(this.k);
    }

    public void stopVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k = this.f49954f.getCurrentPosition();
            CustomVideoView customVideoView = this.f49954f;
            if (customVideoView != null) {
                customVideoView.stopPlayback();
                this.f49954f.setVideoURI(null);
            }
            this.f49953e.setVisibility(0);
        }
    }

    public void updatePercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.f49955g = f2;
            invalidate();
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
        this.m = new Path();
        this.n = new RectF();
        b(context);
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
        this.m = new Path();
        this.n = new RectF();
        b(context);
    }
}
