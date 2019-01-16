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
    private TextView dXT;
    private RelativeLayout gos;
    private int hJA;
    private int hJB;
    private d hJC;
    private List<d> hJD;
    private boolean hJE;
    private boolean hJF;
    private LocalVideoActivity hJl;
    private ExpandGridView hJp;
    private a hJq;
    private CustomVideoView hJr;
    private TextView hJs;
    private String hJt;
    private ImageView hJu;
    private ExpandViewRelativeLayout hJv;
    private FrameLayout hJw;
    private int hJx;
    private int hJy;
    private int hJz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hJE = false;
        this.hJF = true;
        this.hJl = localVideoActivity;
        this.hJv = (ExpandViewRelativeLayout) this.hJl.findViewById(e.g.container);
        this.hJp = (ExpandGridView) this.hJl.findViewById(e.g.local_video_gridview);
        this.gos = (RelativeLayout) this.hJl.findViewById(e.g.preview_videoview_container);
        this.hJu = (ImageView) this.hJl.findViewById(e.g.video_cover);
        this.hJw = (FrameLayout) this.hJl.findViewById(e.g.top_container);
        this.hJr = (CustomVideoView) this.hJl.findViewById(e.g.preview_videoview);
        this.hJr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bX(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hJr.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hJE = true;
                c.this.hJr.stopPlayback();
                return false;
            }
        });
        this.dXT = (TextView) this.hJl.findViewById(e.g.close_btn);
        this.hJs = (TextView) this.hJl.findViewById(e.g.next_step_btn);
        this.hJs.setOnClickListener(onClickListener);
        this.dXT.setOnClickListener(onClickListener);
        this.hJq = new a(this.hJl);
        this.hJp.setAdapter((ListAdapter) this.hJq);
        this.hJp.setSelector(new ColorDrawable(0));
        this.hJp.setVerticalScrollBarEnabled(false);
        this.hJp.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hJE = false;
                    c.this.hJv.setIsCanLayout(true);
                    c.this.gos.layout(c.this.gos.getLeft(), 0, c.this.gos.getRight(), c.this.hJA);
                    c.this.hJp.layout(c.this.hJp.getLeft(), c.this.hJA, c.this.hJp.getRight(), c.this.hJp.getBottom());
                    c.this.hJw.layout(c.this.hJw.getTop(), c.this.hJw.getLeft(), c.this.hJw.getRight(), c.this.hJw.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hJt) && c.this.hJr != null) {
                        c.this.hJr.setVisibility(8);
                        c.this.hJr.stopPlayback();
                        c.this.hJr.setVideoPath(dVar.getVideoPath());
                        c.this.hJr.setVisibility(0);
                        c.this.hJt = dVar.getVideoPath();
                        c.this.hJC = dVar;
                        if (c.this.hJu != null) {
                            c.this.hJu.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hJl);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hJu.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hJr.start();
                    }
                }
            }
        });
        this.hJv.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aB(float f) {
                c.this.hJx = c.this.hJp.getTop();
                c.this.hJy = c.this.gos.getTop();
                c.this.hJz = c.this.hJv.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hJv.setIsCanLayout(false);
                int i2 = (int) (c.this.hJx + f2);
                int i3 = i == 1 ? (int) (c.this.hJy + f2) : (int) (c.this.hJy + (f2 * 0.3d));
                if (i2 >= c.this.hJw.getBottom() && i2 <= l.h(c.this.hJl, e.C0210e.ds902)) {
                    c.this.gos.layout(c.this.gos.getLeft(), i3, c.this.gos.getRight(), c.this.hJA + i3);
                    c.this.hJp.layout(c.this.hJp.getLeft(), i2, c.this.hJp.getRight(), c.this.hJp.getBottom());
                    if (i2 <= l.h(c.this.hJl, e.C0210e.ds400)) {
                        c.this.hJF = false;
                        c.this.hJr.pause();
                    } else {
                        c.this.hJF = true;
                        c.this.hJr.start();
                    }
                    float h = (l.h(c.this.hJl, e.C0210e.ds902) - i2) / l.h(c.this.hJl, e.C0210e.ds902);
                    if (h == 0.0f) {
                        c.this.hJu.setVisibility(8);
                        return;
                    }
                    c.this.hJu.setVisibility(0);
                    c.this.hJu.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bJI() {
                if (c.this.hJp.getTop() > c.this.hJz / 2) {
                    c.this.hJF = true;
                    c.this.hJr.start();
                    c.this.hJu.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.gos.getBottom(), c.this.hJA);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gos.layout(c.this.gos.getLeft(), 0, c.this.gos.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hJp.getTop(), c.this.hJA);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hJp.layout(c.this.hJp.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hJp.getRight(), c.this.hJp.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hJF = false;
                c.this.hJr.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.gos.getBottom(), l.h(c.this.hJl, e.C0210e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.gos.layout(c.this.gos.getLeft(), intValue - c.this.hJA, c.this.gos.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hJp.getTop(), l.h(c.this.hJl, e.C0210e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hJp.layout(c.this.hJp.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hJp.getRight(), c.this.hJp.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hJp.getTop() > c.this.hJw.getBottom() || c.this.hJp.getFirstVisiblePosition() != 0 || c.this.hJp.getChildCount() <= 0 || c.this.hJp.getChildAt(0).getTop() < 0) {
                    if (c.this.hJp.getTop() <= c.this.hJw.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hJA - l.h(c.this.hJl, e.C0210e.ds20))) && f2 < ((float) (c.this.hJA + l.h(c.this.hJl, e.C0210e.ds20)));
                }
                return true;
            }
        });
        this.hJA = l.h(this.hJl, e.C0210e.ds902);
    }

    public boolean bKT() {
        return this.hJE;
    }

    public void ec(List<d> list) {
        if (!v.I(list)) {
            this.hJD = list;
            d dVar = list.get(0);
            if (this.hJr != null) {
                this.hJr.setVideoPath(dVar.getVideoPath());
                this.hJt = dVar.getVideoPath();
                this.hJC = dVar;
                if (this.hJu != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hJl);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hJu.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hJr.start();
            }
            if (this.hJq != null) {
                this.hJq.setData(list);
                bLb();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), e.j.no_local_video_tip);
    }

    public void bKU() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hJl).da(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hJl.getPageContext());
        a.bh(false);
        a.BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hJl) / l.h(this.hJl, e.C0210e.ds902)) {
            i3 = l.aO(this.hJl);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hJl, e.C0210e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hJr.setVideoHeight(i4);
        this.hJr.setVideoWidth(i3);
        this.hJr.invalidate();
    }

    public void xh(String str) {
        if (this.hJq != null) {
            this.hJq.xg(str);
        }
    }

    public TextView bKV() {
        return this.dXT;
    }

    public TextView bKW() {
        return this.hJs;
    }

    public void bKX() {
        if (this.hJr != null && !StringUtils.isNull(this.hJt)) {
            this.hJr.start();
        }
    }

    public void bKY() {
        if (this.hJr != null && !StringUtils.isNull(this.hJt)) {
            this.hJr.resume();
            this.hJr.seekTo(this.hJB);
            if (this.hJF) {
                this.hJr.start();
            }
        }
    }

    public void aEc() {
        this.hJB = this.hJr.getCurrentPosition();
        if (this.hJr != null) {
            this.hJr.pause();
        }
    }

    public void aEd() {
        this.hJB = this.hJr.getCurrentPosition();
        if (this.hJr != null) {
            this.hJr.stopPlayback();
        }
    }

    public String bKZ() {
        return this.hJt;
    }

    public d bLa() {
        return this.hJC;
    }

    private void bLb() {
        if (!v.I(this.hJD)) {
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
                        if (i2 >= c.this.hJD.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hJD.get(i2);
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
                    c.this.hJq.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hJq.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
