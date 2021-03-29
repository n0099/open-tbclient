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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.EditVideoData;
import d.b.b.e.p.l;
import d.b.h0.b0.g.d;
/* loaded from: classes5.dex */
public class PreviewVideoView extends FrameLayout {
    public static int q;
    public static int r;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f22603e;

    /* renamed from: f  reason: collision with root package name */
    public CustomVideoView f22604f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22605g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f22606h;
    public float i;
    public d.b.h0.b0.b j;
    public Paint k;
    public Paint l;
    public int m;
    public String n;
    public Path o;
    public RectF p;

    /* loaded from: classes5.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            PreviewVideoView.this.f22604f.start();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            PreviewVideoView.this.c(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            PreviewVideoView.this.f22603e.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.b.h0.a0.b {
        public c() {
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            if (PreviewVideoView.this.f22603e == null || aVar == null) {
                return;
            }
            PreviewVideoView.this.c(aVar.r(), aVar.m());
            PreviewVideoView.this.f22603e.invalidate();
        }
    }

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.o = new Path();
        this.p = new RectF();
        f(context);
    }

    public void c(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i > i2) {
            i4 = r;
            i3 = l.g(getContext(), R.dimen.tbds322);
        } else {
            i4 = l.g(getContext(), R.dimen.tbds322);
            i3 = q;
        }
        if (this.f22604f.getWidth() == i4 && this.f22604f.getHeight() == i3) {
            return;
        }
        this.f22604f.setVideoHeight(i3);
        this.f22604f.setVideoWidth(i4);
        ViewGroup.LayoutParams layoutParams = this.f22603e.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i3;
        this.f22603e.setLayoutParams(layoutParams);
        getLayoutParams().height = i3;
        getLayoutParams().width = i4;
        invalidate();
    }

    public void d() {
        this.f22605g.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.k.setColor(SkinManager.getColor(R.color.CAM_X0618));
        this.l.setColor(SkinManager.getColor(R.color.CAM_X0302));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.o);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.g(getContext(), R.dimen.tbds5), this.k);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.i, l.g(getContext(), R.dimen.tbds5), this.l);
        canvas.restore();
    }

    public void e() {
        TbImageView tbImageView = this.f22603e;
        if (tbImageView == null || tbImageView.getTag() == null) {
            return;
        }
        d.b.h0.a0.c.j().g(this.f22603e.getTag().toString());
        d.b.h0.a0.c.j().f(this.f22603e.getTag().toString());
    }

    public final void f(Context context) {
        q = l.g(getContext(), R.dimen.tbds429);
        r = l.g(getContext(), R.dimen.tbds572);
        g(context);
        this.j = new d.b.h0.b0.b();
        TbImageView tbImageView = new TbImageView(context);
        this.f22603e = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f22603e, new FrameLayout.LayoutParams(-2, -2));
        this.f22605g = new ImageView(context);
        int g2 = l.g(context, R.dimen.M_H_X001);
        int g3 = l.g(context, R.dimen.M_W_X003);
        this.f22605g.setPadding(g3, g2, g3, g2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds94), l.g(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.f22605g, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds96), l.g(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.g(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.g(context, R.dimen.M_W_X003);
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        bVar.p();
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
        this.f22606h = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f22606h.setText(context.getString(R.string.edit));
        this.f22606h.setTextSize(R.dimen.T_X10);
        addView(this.f22606h, layoutParams2);
        this.k = new Paint();
        this.l = new Paint();
        d();
    }

    public final void g(Context context) {
        CustomVideoView customVideoView = new CustomVideoView(context);
        this.f22604f = customVideoView;
        addView(customVideoView, new FrameLayout.LayoutParams(-2, -2));
        this.f22604f.setOnCompletionListener(new a());
        this.f22604f.setOnPreparedListener(new b());
    }

    public void h() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.n);
        ImageOperation g2 = d.g(r, q);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        this.f22603e.setTag(imageFileInfo.toCachedKey(false));
        d.b.b.j.d.a c2 = this.j.c(imageFileInfo, false);
        if (c2 != null) {
            c(c2.r(), c2.m());
            this.f22603e.invalidate();
            return;
        }
        this.j.d(imageFileInfo, new c(), false);
    }

    public void i() {
        this.m = 0;
        this.i = 0.0f;
        this.n = null;
        k();
    }

    public void j(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f22604f.setVideoPath(str);
        this.f22604f.start();
        this.f22604f.seekTo(this.m);
    }

    public void k() {
        this.m = this.f22604f.getCurrentPosition();
        CustomVideoView customVideoView = this.f22604f;
        if (customVideoView != null) {
            customVideoView.stopPlayback();
            this.f22604f.setVideoURI(null);
        }
        this.f22603e.setVisibility(0);
    }

    public void l(float f2) {
        this.i = f2;
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.o.reset();
        this.p.set(0.0f, 0.0f, i, i2);
        this.o.addRoundRect(this.p, l.g(getContext(), R.dimen.tbds10), l.g(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f22605g.setOnClickListener(onClickListener);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        k();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.n = editVideoData.coverPath;
            h();
            j(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new Path();
        this.p = new RectF();
        f(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = new Path();
        this.p = new RectF();
        f(context);
    }
}
