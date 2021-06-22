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
import d.a.c.e.p.l;
import d.a.n0.b0.g.d;
/* loaded from: classes5.dex */
public class PreviewVideoView extends FrameLayout {
    public static int q;
    public static int r;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f22346e;

    /* renamed from: f  reason: collision with root package name */
    public CustomVideoView f22347f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22348g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f22349h;

    /* renamed from: i  reason: collision with root package name */
    public float f22350i;
    public d.a.n0.b0.b j;
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
            PreviewVideoView.this.f22347f.start();
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
            PreviewVideoView.this.f22346e.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.a.n0.a0.b {
        public c() {
        }

        @Override // d.a.n0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            if (PreviewVideoView.this.f22346e == null || aVar == null) {
                return;
            }
            PreviewVideoView.this.c(aVar.r(), aVar.m());
            PreviewVideoView.this.f22346e.invalidate();
        }
    }

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.o = new Path();
        this.p = new RectF();
        f(context);
    }

    public void c(int i2, int i3) {
        int i4;
        int i5 = 0;
        if (i3 <= 0) {
            i4 = 0;
        } else if (i2 > i3) {
            i5 = r;
            i4 = l.g(getContext(), R.dimen.tbds322);
        } else {
            i5 = l.g(getContext(), R.dimen.tbds322);
            i4 = q;
        }
        if (this.f22347f.getWidth() == i5 && this.f22347f.getHeight() == i4) {
            return;
        }
        this.f22347f.setVideoHeight(i4);
        this.f22347f.setVideoWidth(i5);
        ViewGroup.LayoutParams layoutParams = this.f22346e.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = i4;
        this.f22346e.setLayoutParams(layoutParams);
        getLayoutParams().height = i4;
        getLayoutParams().width = i5;
        invalidate();
    }

    public void d() {
        this.f22348g.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.k.setColor(SkinManager.getColor(R.color.CAM_X0618));
        this.l.setColor(SkinManager.getColor(R.color.CAM_X0302));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.o);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.g(getContext(), R.dimen.tbds5), this.k);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.f22350i, l.g(getContext(), R.dimen.tbds5), this.l);
        canvas.restore();
    }

    public void e() {
        TbImageView tbImageView = this.f22346e;
        if (tbImageView == null || tbImageView.getTag() == null) {
            return;
        }
        d.a.n0.a0.c.k().h(this.f22346e.getTag().toString());
        d.a.n0.a0.c.k().g(this.f22346e.getTag().toString());
    }

    public final void f(Context context) {
        q = l.g(getContext(), R.dimen.tbds429);
        r = l.g(getContext(), R.dimen.tbds572);
        g(context);
        this.j = new d.a.n0.b0.b();
        TbImageView tbImageView = new TbImageView(context);
        this.f22346e = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f22346e, new FrameLayout.LayoutParams(-2, -2));
        this.f22348g = new ImageView(context);
        int g2 = l.g(context, R.dimen.M_H_X001);
        int g3 = l.g(context, R.dimen.M_W_X003);
        this.f22348g.setPadding(g3, g2, g3, g2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds94), l.g(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.f22348g, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds96), l.g(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.g(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.g(context, R.dimen.M_W_X003);
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        bVar.p();
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
        this.f22349h = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f22349h.setText(context.getString(R.string.edit));
        this.f22349h.setTextSize(R.dimen.T_X10);
        addView(this.f22349h, layoutParams2);
        this.k = new Paint();
        this.l = new Paint();
        d();
    }

    public final void g(Context context) {
        CustomVideoView customVideoView = new CustomVideoView(context);
        this.f22347f = customVideoView;
        addView(customVideoView, new FrameLayout.LayoutParams(-2, -2));
        this.f22347f.setOnCompletionListener(new a());
        this.f22347f.setOnPreparedListener(new b());
    }

    public void h() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.n);
        ImageOperation g2 = d.g(r, q);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        this.f22346e.setTag(imageFileInfo.toCachedKey(false));
        d.a.c.k.d.a c2 = this.j.c(imageFileInfo, false);
        if (c2 != null) {
            c(c2.r(), c2.m());
            this.f22346e.invalidate();
            return;
        }
        this.j.d(imageFileInfo, new c(), false);
    }

    public void i() {
        this.m = 0;
        this.f22350i = 0.0f;
        this.n = null;
        k();
    }

    public void j(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f22347f.setVideoPath(str);
        this.f22347f.start();
        this.f22347f.seekTo(this.m);
    }

    public void k() {
        this.m = this.f22347f.getCurrentPosition();
        CustomVideoView customVideoView = this.f22347f;
        if (customVideoView != null) {
            customVideoView.stopPlayback();
            this.f22347f.setVideoURI(null);
        }
        this.f22346e.setVisibility(0);
    }

    public void l(float f2) {
        this.f22350i = f2;
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.o.reset();
        this.p.set(0.0f, 0.0f, i2, i3);
        this.o.addRoundRect(this.p, l.g(getContext(), R.dimen.tbds10), l.g(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f22348g.setOnClickListener(onClickListener);
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

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = new Path();
        this.p = new RectF();
        f(context);
    }
}
