package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.scale.ScalableType;
import com.baidu.tieba.video.editvideo.scale.ScalableVideoView;
import d.b.c.e.p.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public class CoverSeekBar extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f21471e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21472f;

    /* renamed from: g  reason: collision with root package name */
    public ScalableVideoView f21473g;

    /* renamed from: h  reason: collision with root package name */
    public int f21474h;
    public int i;
    public d j;
    public LinearLayout.LayoutParams k;
    public Thread l;
    public float m;
    public float n;
    public float o;
    public Handler p;

    /* loaded from: classes5.dex */
    public class a implements MediaPlayer.OnPreparedListener {

        /* renamed from: com.baidu.tieba.video.editvideo.view.CoverSeekBar$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0229a implements MediaPlayer.OnInfoListener {
            public C0229a() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 3) {
                    CoverSeekBar.this.f21473g.c();
                    return true;
                }
                return true;
            }
        }

        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            if (Build.VERSION.SDK_INT >= 17) {
                CoverSeekBar.this.f21473g.i();
                mediaPlayer.setOnInfoListener(new C0229a());
                return;
            }
            CoverSeekBar.this.f21473g.h(0);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            CoverSeekBar.this.setImage(message.arg1, (Bitmap) message.obj);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21478e;

        public c(String str) {
            this.f21478e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f21478e);
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                for (int i = 0; i < CoverSeekBar.this.f21471e; i++) {
                    Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime((i / (CoverSeekBar.this.f21471e - 1)) * parseInt * 1000, 2), CoverSeekBar.this.f21474h, CoverSeekBar.this.i, 2);
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = i;
                    obtain.obj = extractThumbnail;
                    CoverSeekBar.this.p.sendMessage(obtain);
                }
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b();

        void onProgress(int i);
    }

    public CoverSeekBar(Context context) {
        this(context, null);
    }

    public final void f(String str) {
        Thread thread = new Thread(new c(str));
        this.l = thread;
        thread.start();
    }

    public final void g() {
        this.m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f21474h = l.k(getContext()) / 10;
        this.i = l.g(getContext(), R.dimen.ds112);
        this.k = new LinearLayout.LayoutParams(this.f21474h, this.i);
        this.f21472f = (LinearLayout) findViewById(R.id.images_container);
        this.f21473g = (ScalableVideoView) findViewById(R.id.cover_select_image);
        this.f21473g.setLayoutParams(new FrameLayout.LayoutParams(this.f21474h, this.i));
    }

    public int getCurrentPosition() {
        ScalableVideoView scalableVideoView = this.f21473g;
        if (scalableVideoView == null) {
            return 0;
        }
        return scalableVideoView.getCurrentPosition();
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            boolean z = this.f21472f.getChildCount() > 0;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime(), this.f21474h, this.i, 2);
            for (int i = 0; i < this.f21471e; i++) {
                if (z) {
                    ImageView imageView = (ImageView) this.f21472f.getChildAt(i);
                    if (extractThumbnail != null) {
                        imageView.setBackgroundDrawable(new BitmapDrawable(extractThumbnail));
                    }
                } else {
                    ImageView imageView2 = new ImageView(getContext());
                    if (extractThumbnail != null) {
                        imageView2.setBackgroundDrawable(new BitmapDrawable(extractThumbnail));
                    }
                    SkinManager.setImageResource(imageView2, R.drawable.bg_seekbar);
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.f21472f.addView(imageView2, this.k);
                }
            }
            mediaMetadataRetriever.release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getX() - this.n);
        float abs2 = Math.abs(motionEvent.getY() - this.o);
        float f2 = this.m;
        return abs < f2 && abs2 < f2;
    }

    public void j() {
        ScalableVideoView scalableVideoView = this.f21473g;
        if (scalableVideoView != null) {
            scalableVideoView.e();
        }
        Thread thread = this.l;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public void k(int i) {
        this.f21473g.h(i);
    }

    public final void l(MotionEvent motionEvent) {
        float paddingLeft;
        int width = getWidth();
        int paddingLeft2 = ((width - getPaddingLeft()) - getPaddingRight()) - this.f21474h;
        int x = (int) motionEvent.getX();
        if (x < getPaddingLeft() - (this.f21474h / 2)) {
            paddingLeft = 0.0f;
        } else {
            paddingLeft = x > (width - getPaddingRight()) - (this.f21474h / 2) ? 1.0f : ((x - getPaddingLeft()) - (this.f21474h / 2)) / paddingLeft2;
        }
        float f2 = (paddingLeft * 1000.0f) + 0.0f;
        float f3 = f2 >= 0.0f ? f2 : 0.0f;
        float f4 = f3 <= 1000.0f ? f3 : 1000.0f;
        d dVar = this.j;
        if (dVar != null) {
            dVar.onProgress((int) f4);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = motionEvent.getX();
            this.o = motionEvent.getY();
            d dVar = this.j;
            if (dVar != null) {
                dVar.b();
                l(motionEvent);
            }
        } else if (action != 1) {
            if (action == 2 && !i(motionEvent)) {
                l(motionEvent);
            }
        } else if (this.j != null) {
            l(motionEvent);
            this.j.a();
        }
        return true;
    }

    public void setData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f21473g.setDataSource(str);
            this.f21473g.setScalableType(ScalableType.CENTER_CROP);
            this.f21473g.d(new a());
            h(str);
            f(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void setImage(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (this.f21472f.getChildCount() > 0) {
            ((ImageView) this.f21472f.getChildAt(i)).setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
    }

    public void setOnProgressChanged(d dVar) {
        this.j = dVar;
    }

    public void setProgressImage(int i, int i2) {
        this.f21473g.h(i2);
        int width = (int) (((i / 1000.0f) * getWidth()) - this.f21474h);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21473g.getLayoutParams();
        if (width <= 0) {
            width = 0;
        } else if (width >= getWidth() - this.f21474h) {
            width = getWidth() - this.f21474h;
        }
        layoutParams.setMargins(width, 0, 0, 0);
        this.f21473g.setLayoutParams(layoutParams);
    }

    public CoverSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21471e = 10;
        this.p = new b();
        LayoutInflater.from(context).inflate(R.layout.layout_cover_progress, this);
        g();
    }
}
