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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.scale.ScalableType;
import com.baidu.tieba.video.editvideo.scale.ScalableVideoView;
import java.io.IOException;
/* loaded from: classes10.dex */
public class CoverSeekBar extends FrameLayout {
    private int MAX_IMAGE_SIZE;
    private LinearLayout.LayoutParams dnm;
    private Handler handler;
    private float hmk;
    private LinearLayout lYd;
    private ScalableVideoView lYe;
    private a lYf;
    private float mDownX;
    private float mDownY;
    private int mImageHeight;
    private int mImageWidth;
    private Thread mThread;

    /* loaded from: classes10.dex */
    public interface a {
        void onProgress(int i);

        void onStartTrackingTouch();

        void onStopTrackingTouch();
    }

    public CoverSeekBar(Context context) {
        this(context, null);
    }

    public CoverSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MAX_IMAGE_SIZE = 10;
        this.handler = new Handler() { // from class: com.baidu.tieba.video.editvideo.view.CoverSeekBar.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                CoverSeekBar.this.setImage(message.arg1, (Bitmap) message.obj);
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_cover_progress, this);
        init();
    }

    private void init() {
        this.hmk = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mImageWidth = l.getEquipmentWidth(getContext()) / 10;
        this.mImageHeight = l.getDimens(getContext(), R.dimen.ds112);
        this.dnm = new LinearLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
        this.lYd = (LinearLayout) findViewById(R.id.images_container);
        this.lYe = (ScalableVideoView) findViewById(R.id.cover_select_image);
        this.lYe.setLayoutParams(new FrameLayout.LayoutParams(this.mImageWidth, this.mImageHeight));
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.lYe.setDataSource(str);
                this.lYe.setScalableType(ScalableType.CENTER_CROP);
                this.lYe.a(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverSeekBar.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                        if (Build.VERSION.SDK_INT >= 17) {
                            CoverSeekBar.this.lYe.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverSeekBar.1.1
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3) {
                                        CoverSeekBar.this.lYe.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        CoverSeekBar.this.lYe.seekTo(0);
                    }
                });
                Og(str);
                Of(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCurrentPosition() {
        if (this.lYe == null) {
            return 0;
        }
        return this.lYe.getCurrentPosition();
    }

    public void setImage(int i, Bitmap bitmap) {
        if (bitmap != null) {
            if (this.lYd.getChildCount() > 0) {
                ((ImageView) this.lYd.getChildAt(i)).setBackgroundDrawable(new BitmapDrawable(bitmap));
            }
        }
    }

    private void Of(final String str) {
        this.mThread = new Thread(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.CoverSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                    for (int i = 0; i < CoverSeekBar.this.MAX_IMAGE_SIZE; i++) {
                        Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime((i / (CoverSeekBar.this.MAX_IMAGE_SIZE - 1)) * parseInt * 1000, 2), CoverSeekBar.this.mImageWidth, CoverSeekBar.this.mImageHeight, 2);
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.arg1 = i;
                        obtain.obj = extractThumbnail;
                        CoverSeekBar.this.handler.sendMessage(obtain);
                    }
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mThread.start();
    }

    public void Og(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                boolean z = this.lYd.getChildCount() > 0;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime(), this.mImageWidth, this.mImageHeight, 2);
                for (int i = 0; i < this.MAX_IMAGE_SIZE; i++) {
                    if (z) {
                        ImageView imageView = (ImageView) this.lYd.getChildAt(i);
                        if (extractThumbnail != null) {
                            imageView.setBackgroundDrawable(new BitmapDrawable(extractThumbnail));
                        }
                    } else {
                        ImageView imageView2 = new ImageView(getContext());
                        if (extractThumbnail != null) {
                            imageView2.setBackgroundDrawable(new BitmapDrawable(extractThumbnail));
                        }
                        an.setImageResource(imageView2, R.drawable.bg_seekbar);
                        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        this.lYd.addView(imageView2, this.dnm);
                    }
                }
                mediaMetadataRetriever.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setProgressImage(int i, int i2) {
        this.lYe.seekTo(i2);
        int width = (int) (((i / 1000.0f) * getWidth()) - this.mImageWidth);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lYe.getLayoutParams();
        if (width <= 0) {
            width = 0;
        } else if (width >= getWidth() - this.mImageWidth) {
            width = getWidth() - this.mImageWidth;
        }
        layoutParams.setMargins(width, 0, 0, 0);
        this.lYe.setLayoutParams(layoutParams);
    }

    public void seekTo(int i) {
        this.lYe.seekTo(i);
    }

    public void release() {
        if (this.lYe != null) {
            this.lYe.release();
        }
        if (this.mThread != null) {
            this.mThread.interrupt();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX();
                this.mDownY = motionEvent.getY();
                if (this.lYf != null) {
                    this.lYf.onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    return true;
                }
                return true;
            case 1:
                if (this.lYf != null) {
                    trackTouchEvent(motionEvent);
                    this.lYf.onStopTrackingTouch();
                    return true;
                }
                return true;
            case 2:
                if (!I(motionEvent)) {
                    trackTouchEvent(motionEvent);
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        float paddingLeft;
        int width = getWidth();
        int paddingLeft2 = ((width - getPaddingLeft()) - getPaddingRight()) - this.mImageWidth;
        int x = (int) motionEvent.getX();
        if (x < getPaddingLeft() - (this.mImageWidth / 2)) {
            paddingLeft = 0.0f;
        } else if (x > (width - getPaddingRight()) - (this.mImageWidth / 2)) {
            paddingLeft = 1.0f;
        } else {
            paddingLeft = ((x - getPaddingLeft()) - (this.mImageWidth / 2)) / paddingLeft2;
        }
        float f = (paddingLeft * 1000.0f) + 0.0f;
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1000.0f ? f2 : 1000.0f;
        if (this.lYf != null) {
            this.lYf.onProgress((int) f3);
        }
    }

    private boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX() - this.mDownX) < this.hmk && Math.abs(motionEvent.getY() - this.mDownY) < this.hmk;
    }

    public void setOnProgressChanged(a aVar) {
        this.lYf = aVar;
    }
}
