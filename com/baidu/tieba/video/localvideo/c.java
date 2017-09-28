package com.baidu.tieba.video.localvideo;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.d;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private TextView cDP;
    private RelativeLayout eTl;
    private LocalVideoActivity gwY;
    private ExpandGridView gxc;
    private a gxd;
    private CustomVideoView gxe;
    private TextView gxf;
    private String gxg;
    private ImageView gxh;
    private ExpandViewRelativeLayout gxi;
    private FrameLayout gxj;
    private int gxk;
    private int gxl;
    private int gxm;
    private int gxn;
    private int gxo;
    private d gxp;
    private List<d> gxq;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gwY = localVideoActivity;
        this.gxi = (ExpandViewRelativeLayout) this.gwY.findViewById(d.h.container);
        this.gxc = (ExpandGridView) this.gwY.findViewById(d.h.local_video_gridview);
        this.eTl = (RelativeLayout) this.gwY.findViewById(d.h.preview_videoview_container);
        this.gxh = (ImageView) this.gwY.findViewById(d.h.video_cover);
        this.gxj = (FrameLayout) this.gwY.findViewById(d.h.top_container);
        this.gxe = (CustomVideoView) this.gwY.findViewById(d.h.preview_videoview);
        this.gxe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.ca(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.cDP = (TextView) this.gwY.findViewById(d.h.close_btn);
        this.gxf = (TextView) this.gwY.findViewById(d.h.next_step_btn);
        this.gxf.setOnClickListener(onClickListener);
        this.cDP.setOnClickListener(onClickListener);
        this.gxd = new a(this.gwY);
        this.gxc.setAdapter((ListAdapter) this.gxd);
        this.gxc.setSelector(new ColorDrawable(0));
        this.gxc.setVerticalScrollBarEnabled(false);
        this.gxc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v12, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gxi.setIsCanLayout(true);
                    c.this.eTl.layout(c.this.eTl.getLeft(), 0, c.this.eTl.getRight(), c.this.gxn);
                    c.this.gxc.layout(c.this.gxc.getLeft(), c.this.gxn, c.this.gxc.getRight(), c.this.gxc.getBottom());
                    c.this.gxj.layout(c.this.gxj.getTop(), c.this.gxj.getLeft(), c.this.gxj.getRight(), c.this.gxj.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gxg) && c.this.gxe != null) {
                        c.this.gxe.setVisibility(8);
                        c.this.gxe.stopPlayback();
                        c.this.gxe.setVideoPath(dVar.getVideoPath());
                        c.this.gxe.setVisibility(0);
                        c.this.gxg = dVar.getVideoPath();
                        c.this.gxp = dVar;
                        if (c.this.gxh != null) {
                            c.this.gxh.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gwY);
                            blurDrawable.init(12, 8, dVar.bwy());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gxh.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gxe.start();
                    }
                }
            }
        });
        this.gxi.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.3
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void af(float f) {
                c.this.gxk = c.this.gxc.getTop();
                c.this.gxl = c.this.eTl.getTop();
                c.this.gxm = c.this.gxi.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.gxi.setIsCanLayout(false);
                int i2 = (int) (c.this.gxk + f2);
                int i3 = i == 1 ? (int) (c.this.gxl + f2) : (int) (c.this.gxl + (f2 * 0.3d));
                if (i2 >= c.this.gxj.getBottom() && i2 <= l.f(c.this.gwY, d.f.ds902)) {
                    c.this.eTl.layout(c.this.eTl.getLeft(), i3, c.this.eTl.getRight(), c.this.gxn + i3);
                    c.this.gxc.layout(c.this.gxc.getLeft(), i2, c.this.gxc.getRight(), c.this.gxc.getBottom());
                    if (i2 <= l.f(c.this.gwY, d.f.ds400)) {
                        c.this.gxe.pause();
                    } else {
                        c.this.gxe.start();
                    }
                    float f3 = (l.f(c.this.gwY, d.f.ds902) - i2) / l.f(c.this.gwY, d.f.ds902);
                    if (f3 == 0.0f) {
                        c.this.gxh.setVisibility(8);
                        return;
                    }
                    c.this.gxh.setVisibility(0);
                    c.this.gxh.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bvG() {
                if (c.this.gxc.getTop() > c.this.gxm / 2) {
                    c.this.gxe.start();
                    c.this.gxh.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.eTl.getBottom(), c.this.gxn);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.eTl.layout(c.this.eTl.getLeft(), 0, c.this.eTl.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gxc.getTop(), c.this.gxn);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gxc.layout(c.this.gxc.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gxc.getRight(), c.this.gxc.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.eTl.getBottom(), l.f(c.this.gwY, d.f.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.eTl.layout(c.this.eTl.getLeft(), intValue - c.this.gxn, c.this.eTl.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gxc.getTop(), l.f(c.this.gwY, d.f.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gxc.layout(c.this.gxc.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gxc.getRight(), c.this.gxc.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.gxc.getTop() > c.this.gxj.getBottom() || c.this.gxc.getFirstVisiblePosition() != 0 || c.this.gxc.getChildCount() <= 0 || c.this.gxc.getChildAt(0).getTop() < 0) {
                    if (c.this.gxc.getTop() <= c.this.gxj.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gxn - l.f(c.this.gwY, d.f.ds20))) && f2 < ((float) (c.this.gxn + l.f(c.this.gwY, d.f.ds20)));
                }
                return true;
            }
        });
        this.gxn = l.f(this.gwY, d.f.ds902);
    }

    public void dB(List<d> list) {
        if (!v.u(list)) {
            this.gxq = list;
            d dVar = list.get(0);
            if (this.gxe != null) {
                this.gxe.setVideoPath(dVar.getVideoPath());
                this.gxg = dVar.getVideoPath();
                this.gxp = dVar;
                if (this.gxh != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gwY);
                    blurDrawable.init(12, 8, dVar.bwy());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gxh.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gxe.start();
            }
        }
        if (this.gxd != null) {
            this.gxd.setData(list);
            bwx();
        }
    }

    public void bwq() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gwY).cc(d.l.mv_local_video_too_long).a(d.l.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gwY.getPageContext());
        a.as(false);
        a.ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ad(this.gwY) / l.f(this.gwY, d.f.ds902)) {
            i3 = l.ad(this.gwY);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gwY, d.f.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gxe.setVideoHeight(i4);
        this.gxe.setVideoWidth(i3);
        this.gxe.invalidate();
    }

    public void sF(String str) {
        if (this.gxd != null) {
            this.gxd.sE(str);
        }
    }

    public TextView bwr() {
        return this.cDP;
    }

    public TextView bws() {
        return this.gxf;
    }

    public void bwt() {
        if (this.gxe != null && !StringUtils.isNull(this.gxg)) {
            this.gxe.start();
        }
    }

    public void bwu() {
        if (this.gxe != null && !StringUtils.isNull(this.gxg)) {
            this.gxe.resume();
            this.gxe.seekTo(this.gxo);
            this.gxe.start();
        }
    }

    public void aip() {
        this.gxo = this.gxe.getCurrentPosition();
        if (this.gxe != null) {
            this.gxe.pause();
        }
    }

    public void aiq() {
        this.gxo = this.gxe.getCurrentPosition();
        if (this.gxe != null) {
            this.gxe.stopPlayback();
        }
    }

    public String bwv() {
        return this.gxg;
    }

    public d bww() {
        return this.gxp;
    }

    private void bwx() {
        if (!v.u(this.gxq)) {
            new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.video.localvideo.c.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Removed duplicated region for block: B:54:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Void doInBackground(Void... voidArr) {
                    Bitmap bitmap;
                    String extractMetadata;
                    Bitmap bitmap2 = null;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= c.this.gxq.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gxq.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.g(extractMetadata, 0));
                            }
                            dVar.setMimeType(mediaMetadataRetriever.extractMetadata(12));
                            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                            if (extractMetadata2 != null) {
                                dVar.setVideoWidth(Integer.parseInt(extractMetadata2));
                            }
                            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                            if (extractMetadata3 != null) {
                                dVar.setVideoHeight(Integer.parseInt(extractMetadata3));
                            }
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 1);
                            if (frameAtTime != null) {
                                try {
                                    if (frameAtTime.getWidth() > 0) {
                                        Matrix matrix = new Matrix();
                                        matrix.postScale(((float) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY) / frameAtTime.getWidth(), ((int) ((150.0f * frameAtTime.getHeight()) / frameAtTime.getWidth())) / frameAtTime.getHeight());
                                        dVar.s(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
                                    }
                                } catch (Exception e) {
                                    bitmap = frameAtTime;
                                    e = e;
                                    try {
                                        e.printStackTrace();
                                        if (bitmap != null) {
                                            try {
                                                bitmap.recycle();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        mediaMetadataRetriever.release();
                                        i = i2 + 1;
                                    } catch (Throwable th) {
                                        th = th;
                                        bitmap2 = bitmap;
                                        if (bitmap2 != null) {
                                            try {
                                                bitmap2.recycle();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        mediaMetadataRetriever.release();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    bitmap2 = frameAtTime;
                                    th = th2;
                                    if (bitmap2 != null) {
                                    }
                                    mediaMetadataRetriever.release();
                                    throw th;
                                }
                            }
                            dVar.ne(true);
                            publishProgress(1);
                            if (frameAtTime != null) {
                                try {
                                    frameAtTime.recycle();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            mediaMetadataRetriever.release();
                        } catch (Exception e5) {
                            e = e5;
                            bitmap = null;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        i = i2 + 1;
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: b */
                public void onProgressUpdate(Integer... numArr) {
                    super.onProgressUpdate(numArr);
                    c.this.gxd.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gxd.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
