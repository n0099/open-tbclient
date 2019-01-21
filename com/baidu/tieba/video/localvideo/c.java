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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.e;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private TextView dXU;
    private RelativeLayout got;
    private int hJA;
    private int hJB;
    private int hJC;
    private d hJD;
    private List<d> hJE;
    private boolean hJF;
    private boolean hJG;
    private LocalVideoActivity hJm;
    private ExpandGridView hJq;
    private a hJr;
    private CustomVideoView hJs;
    private TextView hJt;
    private String hJu;
    private ImageView hJv;
    private ExpandViewRelativeLayout hJw;
    private FrameLayout hJx;
    private int hJy;
    private int hJz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hJF = false;
        this.hJG = true;
        this.hJm = localVideoActivity;
        this.hJw = (ExpandViewRelativeLayout) this.hJm.findViewById(e.g.container);
        this.hJq = (ExpandGridView) this.hJm.findViewById(e.g.local_video_gridview);
        this.got = (RelativeLayout) this.hJm.findViewById(e.g.preview_videoview_container);
        this.hJv = (ImageView) this.hJm.findViewById(e.g.video_cover);
        this.hJx = (FrameLayout) this.hJm.findViewById(e.g.top_container);
        this.hJs = (CustomVideoView) this.hJm.findViewById(e.g.preview_videoview);
        this.hJs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bX(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hJs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hJF = true;
                c.this.hJs.stopPlayback();
                return false;
            }
        });
        this.dXU = (TextView) this.hJm.findViewById(e.g.close_btn);
        this.hJt = (TextView) this.hJm.findViewById(e.g.next_step_btn);
        this.hJt.setOnClickListener(onClickListener);
        this.dXU.setOnClickListener(onClickListener);
        this.hJr = new a(this.hJm);
        this.hJq.setAdapter((ListAdapter) this.hJr);
        this.hJq.setSelector(new ColorDrawable(0));
        this.hJq.setVerticalScrollBarEnabled(false);
        this.hJq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hJF = false;
                    c.this.hJw.setIsCanLayout(true);
                    c.this.got.layout(c.this.got.getLeft(), 0, c.this.got.getRight(), c.this.hJB);
                    c.this.hJq.layout(c.this.hJq.getLeft(), c.this.hJB, c.this.hJq.getRight(), c.this.hJq.getBottom());
                    c.this.hJx.layout(c.this.hJx.getTop(), c.this.hJx.getLeft(), c.this.hJx.getRight(), c.this.hJx.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hJu) && c.this.hJs != null) {
                        c.this.hJs.setVisibility(8);
                        c.this.hJs.stopPlayback();
                        c.this.hJs.setVideoPath(dVar.getVideoPath());
                        c.this.hJs.setVisibility(0);
                        c.this.hJu = dVar.getVideoPath();
                        c.this.hJD = dVar;
                        if (c.this.hJv != null) {
                            c.this.hJv.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hJm);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hJv.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hJs.start();
                    }
                }
            }
        });
        this.hJw.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aB(float f) {
                c.this.hJy = c.this.hJq.getTop();
                c.this.hJz = c.this.got.getTop();
                c.this.hJA = c.this.hJw.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hJw.setIsCanLayout(false);
                int i2 = (int) (c.this.hJy + f2);
                int i3 = i == 1 ? (int) (c.this.hJz + f2) : (int) (c.this.hJz + (f2 * 0.3d));
                if (i2 >= c.this.hJx.getBottom() && i2 <= l.h(c.this.hJm, e.C0210e.ds902)) {
                    c.this.got.layout(c.this.got.getLeft(), i3, c.this.got.getRight(), c.this.hJB + i3);
                    c.this.hJq.layout(c.this.hJq.getLeft(), i2, c.this.hJq.getRight(), c.this.hJq.getBottom());
                    if (i2 <= l.h(c.this.hJm, e.C0210e.ds400)) {
                        c.this.hJG = false;
                        c.this.hJs.pause();
                    } else {
                        c.this.hJG = true;
                        c.this.hJs.start();
                    }
                    float h = (l.h(c.this.hJm, e.C0210e.ds902) - i2) / l.h(c.this.hJm, e.C0210e.ds902);
                    if (h == 0.0f) {
                        c.this.hJv.setVisibility(8);
                        return;
                    }
                    c.this.hJv.setVisibility(0);
                    c.this.hJv.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bJI() {
                if (c.this.hJq.getTop() > c.this.hJA / 2) {
                    c.this.hJG = true;
                    c.this.hJs.start();
                    c.this.hJv.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.got.getBottom(), c.this.hJB);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.got.layout(c.this.got.getLeft(), 0, c.this.got.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hJq.getTop(), c.this.hJB);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hJq.layout(c.this.hJq.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hJq.getRight(), c.this.hJq.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hJG = false;
                c.this.hJs.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.got.getBottom(), l.h(c.this.hJm, e.C0210e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.got.layout(c.this.got.getLeft(), intValue - c.this.hJB, c.this.got.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hJq.getTop(), l.h(c.this.hJm, e.C0210e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hJq.layout(c.this.hJq.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hJq.getRight(), c.this.hJq.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hJq.getTop() > c.this.hJx.getBottom() || c.this.hJq.getFirstVisiblePosition() != 0 || c.this.hJq.getChildCount() <= 0 || c.this.hJq.getChildAt(0).getTop() < 0) {
                    if (c.this.hJq.getTop() <= c.this.hJx.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hJB - l.h(c.this.hJm, e.C0210e.ds20))) && f2 < ((float) (c.this.hJB + l.h(c.this.hJm, e.C0210e.ds20)));
                }
                return true;
            }
        });
        this.hJB = l.h(this.hJm, e.C0210e.ds902);
    }

    public boolean bKT() {
        return this.hJF;
    }

    public void ec(List<d> list) {
        if (!v.I(list)) {
            this.hJE = list;
            d dVar = list.get(0);
            if (this.hJs != null) {
                this.hJs.setVideoPath(dVar.getVideoPath());
                this.hJu = dVar.getVideoPath();
                this.hJD = dVar;
                if (this.hJv != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hJm);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hJv.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hJs.start();
            }
            if (this.hJr != null) {
                this.hJr.setData(list);
                bLb();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), e.j.no_local_video_tip);
    }

    public void bKU() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hJm).da(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hJm.getPageContext());
        a.bh(false);
        a.BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hJm) / l.h(this.hJm, e.C0210e.ds902)) {
            i3 = l.aO(this.hJm);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hJm, e.C0210e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hJs.setVideoHeight(i4);
        this.hJs.setVideoWidth(i3);
        this.hJs.invalidate();
    }

    public void xh(String str) {
        if (this.hJr != null) {
            this.hJr.xg(str);
        }
    }

    public TextView bKV() {
        return this.dXU;
    }

    public TextView bKW() {
        return this.hJt;
    }

    public void bKX() {
        if (this.hJs != null && !StringUtils.isNull(this.hJu)) {
            this.hJs.start();
        }
    }

    public void bKY() {
        if (this.hJs != null && !StringUtils.isNull(this.hJu)) {
            this.hJs.resume();
            this.hJs.seekTo(this.hJC);
            if (this.hJG) {
                this.hJs.start();
            }
        }
    }

    public void aEc() {
        this.hJC = this.hJs.getCurrentPosition();
        if (this.hJs != null) {
            this.hJs.pause();
        }
    }

    public void aEd() {
        this.hJC = this.hJs.getCurrentPosition();
        if (this.hJs != null) {
            this.hJs.stopPlayback();
        }
    }

    public String bKZ() {
        return this.hJu;
    }

    public d bLa() {
        return this.hJD;
    }

    private void bLb() {
        if (!v.I(this.hJE)) {
            new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.video.localvideo.c.6
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
                        if (i2 >= c.this.hJE.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hJE.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.l(extractMetadata, 0));
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
                                        dVar.D(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.oe(true);
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
                /* renamed from: c */
                public void onProgressUpdate(Integer... numArr) {
                    super.onProgressUpdate(numArr);
                    c.this.hJr.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hJr.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
