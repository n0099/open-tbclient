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
import com.repackage.k45;
import com.repackage.o45;
import com.repackage.pi;
import com.repackage.uu4;
import com.repackage.x45;
import com.repackage.ym;
/* loaded from: classes4.dex */
public class PreviewVideoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public static int n;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public CustomVideoView b;
    public ImageView c;
    public TBSpecificationBtn d;
    public TBSpecificationBtn e;
    public float f;
    public o45 g;
    public Paint h;
    public Paint i;
    public String j;
    public Path k;
    public RectF l;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class c implements k45 {
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

        @Override // com.repackage.k45
        public void a(ym ymVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, ymVar, str, z) == null) || this.a.a == null || ymVar == null) {
                return;
            }
            this.a.b(ymVar.r(), ymVar.m());
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
                i3 = pi.f(getContext(), R.dimen.tbds569);
            } else {
                i4 = pi.f(getContext(), R.dimen.tbds650);
                i3 = m;
            }
            if (this.b.getWidth() == i4 && this.b.getHeight() == i3) {
                return;
            }
            this.b.setVideoHeight(i3);
            this.b.setVideoWidth(i4);
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
            this.c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0807ee, WebPManager.ResourceStateType.NORMAL));
            this.h.setColor(SkinManager.getColor(R.color.CAM_X0618));
            this.i.setColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            m = pi.f(getContext(), R.dimen.tbds866);
            n = pi.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            e(context);
            this.g = new o45();
            TbImageView tbImageView = new TbImageView(context);
            this.a = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.a, new FrameLayout.LayoutParams(-2, -2));
            this.c = new ImageView(context);
            int f = pi.f(context, R.dimen.M_H_X001);
            int f2 = pi.f(context, R.dimen.M_W_X003);
            this.c.setPadding(f2, f, f2, f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pi.f(context, R.dimen.tbds94), pi.f(context, R.dimen.tbds94));
            layoutParams.gravity = 53;
            addView(this.c, layoutParams);
            uu4 uu4Var = new uu4();
            uu4Var.q();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(pi.f(context, R.dimen.tbds96), pi.f(context, R.dimen.tbds48));
            layoutParams2.gravity = 83;
            layoutParams2.bottomMargin = pi.f(context, R.dimen.M_H_X002);
            layoutParams2.leftMargin = pi.f(context, R.dimen.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.d = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(uu4Var);
            this.d.setText(context.getString(R.string.obfuscated_res_0x7f0f051e));
            this.d.setTextSize(R.dimen.T_X10);
            addView(this.d, layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(pi.f(context, R.dimen.tbds96), pi.f(context, R.dimen.tbds48));
            layoutParams3.gravity = 85;
            layoutParams3.bottomMargin = pi.f(context, R.dimen.M_H_X002);
            layoutParams3.rightMargin = pi.f(context, R.dimen.M_W_X003);
            TBSpecificationBtn tBSpecificationBtn2 = new TBSpecificationBtn(context);
            this.e = tBSpecificationBtn2;
            tBSpecificationBtn2.setConfig(uu4Var);
            this.e.setText(context.getString(R.string.obfuscated_res_0x7f0f0459));
            this.e.setTextSize(R.dimen.T_X10);
            addView(this.e, layoutParams3);
            this.h = new Paint();
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
            canvas.drawRect(0.0f, 0.0f, getWidth(), pi.f(getContext(), R.dimen.tbds5), this.h);
            canvas.drawRect(0.0f, 0.0f, getWidth() * this.f, pi.f(getContext(), R.dimen.tbds5), this.i);
            canvas.restore();
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            CustomVideoView customVideoView = new CustomVideoView(context);
            this.b = customVideoView;
            addView(customVideoView, new FrameLayout.LayoutParams(-2, -2));
            this.b.setOnCompletionListener(new a(this));
            this.b.setOnPreparedListener(new b(this));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(this.j);
            ImageOperation g = x45.g(n, m);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g);
            this.a.setTag(imageFileInfo.toCachedKey(false));
            ym c2 = this.g.c(imageFileInfo, false);
            if (c2 != null) {
                b(c2.r(), c2.m());
                this.a.invalidate();
                return;
            }
            this.g.d(imageFileInfo, new c(this), false);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.getCurrentPosition();
            CustomVideoView customVideoView = this.b;
            if (customVideoView != null) {
                customVideoView.stopPlayback();
                this.b.setVideoURI(null);
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
            this.k.addRoundRect(this.l, pi.f(getContext(), R.dimen.tbds10), pi.f(getContext(), R.dimen.tbds10), Path.Direction.CW);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.c.setOnClickListener(onClickListener);
            this.d.setOnClickListener(onClickListener);
            this.e.setOnClickListener(onClickListener);
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
