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
import com.baidu.tieba.d;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private TextView fli;
    private RelativeLayout hEl;
    private ExpandGridView iZD;
    private a iZE;
    private CustomVideoView iZF;
    private TextView iZG;
    private String iZH;
    private ImageView iZI;
    private ExpandViewRelativeLayout iZJ;
    private FrameLayout iZK;
    private int iZL;
    private int iZM;
    private int iZN;
    private int iZO;
    private int iZP;
    private d iZQ;
    private List<d> iZR;
    private boolean iZS;
    private boolean iZT;
    private LocalVideoActivity iZz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.iZS = false;
        this.iZT = true;
        this.iZz = localVideoActivity;
        this.iZJ = (ExpandViewRelativeLayout) this.iZz.findViewById(d.g.container);
        this.iZD = (ExpandGridView) this.iZz.findViewById(d.g.local_video_gridview);
        this.hEl = (RelativeLayout) this.iZz.findViewById(d.g.preview_videoview_container);
        this.iZI = (ImageView) this.iZz.findViewById(d.g.video_cover);
        this.iZK = (FrameLayout) this.iZz.findViewById(d.g.top_container);
        this.iZF = (CustomVideoView) this.iZz.findViewById(d.g.preview_videoview);
        this.iZF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cu(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.iZF.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.iZS = true;
                c.this.iZF.stopPlayback();
                return false;
            }
        });
        this.fli = (TextView) this.iZz.findViewById(d.g.close_btn);
        this.iZG = (TextView) this.iZz.findViewById(d.g.next_step_btn);
        this.iZG.setOnClickListener(onClickListener);
        this.fli.setOnClickListener(onClickListener);
        this.iZE = new a(this.iZz);
        this.iZD.setAdapter((ListAdapter) this.iZE);
        this.iZD.setSelector(new ColorDrawable(0));
        this.iZD.setVerticalScrollBarEnabled(false);
        this.iZD.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.iZS = false;
                    c.this.iZJ.setIsCanLayout(true);
                    c.this.hEl.layout(c.this.hEl.getLeft(), 0, c.this.hEl.getRight(), c.this.iZO);
                    c.this.iZD.layout(c.this.iZD.getLeft(), c.this.iZO, c.this.iZD.getRight(), c.this.iZD.getBottom());
                    c.this.iZK.layout(c.this.iZK.getTop(), c.this.iZK.getLeft(), c.this.iZK.getRight(), c.this.iZK.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.iZH) && c.this.iZF != null) {
                        c.this.iZF.setVisibility(8);
                        c.this.iZF.stopPlayback();
                        c.this.iZF.setVideoPath(dVar.getVideoPath());
                        c.this.iZF.setVisibility(0);
                        c.this.iZH = dVar.getVideoPath();
                        c.this.iZQ = dVar;
                        if (c.this.iZI != null) {
                            c.this.iZI.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.iZz);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.iZI.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.iZF.start();
                    }
                }
            }
        });
        this.iZJ.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aO(float f) {
                c.this.iZL = c.this.iZD.getTop();
                c.this.iZM = c.this.hEl.getTop();
                c.this.iZN = c.this.iZJ.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.iZJ.setIsCanLayout(false);
                int i2 = (int) (c.this.iZL + f2);
                int i3 = i == 1 ? (int) (c.this.iZM + f2) : (int) (c.this.iZM + (f2 * 0.3d));
                if (i2 >= c.this.iZK.getBottom() && i2 <= l.h(c.this.iZz, d.e.ds902)) {
                    c.this.hEl.layout(c.this.hEl.getLeft(), i3, c.this.hEl.getRight(), c.this.iZO + i3);
                    c.this.iZD.layout(c.this.iZD.getLeft(), i2, c.this.iZD.getRight(), c.this.iZD.getBottom());
                    if (i2 <= l.h(c.this.iZz, d.e.ds400)) {
                        c.this.iZT = false;
                        c.this.iZF.pause();
                    } else {
                        c.this.iZT = true;
                        c.this.iZF.start();
                    }
                    float h = (l.h(c.this.iZz, d.e.ds902) - i2) / l.h(c.this.iZz, d.e.ds902);
                    if (h == 0.0f) {
                        c.this.iZI.setVisibility(8);
                        return;
                    }
                    c.this.iZI.setVisibility(0);
                    c.this.iZI.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cjg() {
                if (c.this.iZD.getTop() > c.this.iZN / 2) {
                    c.this.iZT = true;
                    c.this.iZF.start();
                    c.this.iZI.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.hEl.getBottom(), c.this.iZO);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hEl.layout(c.this.hEl.getLeft(), 0, c.this.hEl.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.iZD.getTop(), c.this.iZO);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iZD.layout(c.this.iZD.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.iZD.getRight(), c.this.iZD.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.iZT = false;
                c.this.iZF.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.hEl.getBottom(), l.h(c.this.iZz, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.hEl.layout(c.this.hEl.getLeft(), intValue - c.this.iZO, c.this.hEl.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.iZD.getTop(), l.h(c.this.iZz, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.iZD.layout(c.this.iZD.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.iZD.getRight(), c.this.iZD.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.iZD.getTop() > c.this.iZK.getBottom() || c.this.iZD.getFirstVisiblePosition() != 0 || c.this.iZD.getChildCount() <= 0 || c.this.iZD.getChildAt(0).getTop() < 0) {
                    if (c.this.iZD.getTop() <= c.this.iZK.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.iZO - l.h(c.this.iZz, d.e.ds20))) && f2 < ((float) (c.this.iZO + l.h(c.this.iZz, d.e.ds20)));
                }
                return true;
            }
        });
        this.iZO = l.h(this.iZz, d.e.ds902);
    }

    public boolean cks() {
        return this.iZS;
    }

    public void ef(List<d> list) {
        if (!v.T(list)) {
            this.iZR = list;
            d dVar = list.get(0);
            if (this.iZF != null) {
                this.iZF.setVideoPath(dVar.getVideoPath());
                this.iZH = dVar.getVideoPath();
                this.iZQ = dVar;
                if (this.iZI != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.iZz);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.iZI.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.iZF.start();
            }
            if (this.iZE != null) {
                this.iZE.setData(list);
                ckA();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void ckt() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.iZz).gB(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.iZz.getPageContext());
        a.dr(false);
        a.aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.iZz) / l.h(this.iZz, d.e.ds902)) {
            i3 = l.aO(this.iZz);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.iZz, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.iZF.setVideoHeight(i4);
        this.iZF.setVideoWidth(i3);
        this.iZF.invalidate();
    }

    public void DH(String str) {
        if (this.iZE != null) {
            this.iZE.DG(str);
        }
    }

    public TextView cku() {
        return this.fli;
    }

    public TextView ckv() {
        return this.iZG;
    }

    public void ckw() {
        if (this.iZF != null && !StringUtils.isNull(this.iZH)) {
            this.iZF.start();
        }
    }

    public void ckx() {
        if (this.iZF != null && !StringUtils.isNull(this.iZH)) {
            this.iZF.resume();
            this.iZF.seekTo(this.iZP);
            if (this.iZT) {
                this.iZF.start();
            }
        }
    }

    public void beJ() {
        this.iZP = this.iZF.getCurrentPosition();
        if (this.iZF != null) {
            this.iZF.pause();
        }
    }

    public void beK() {
        this.iZP = this.iZF.getCurrentPosition();
        if (this.iZF != null) {
            this.iZF.stopPlayback();
        }
    }

    public String cky() {
        return this.iZH;
    }

    public d ckz() {
        return this.iZQ;
    }

    private void ckA() {
        if (!v.T(this.iZR)) {
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
                        if (i2 >= c.this.iZR.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.iZR.get(i2);
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
                                        dVar.L(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.qE(true);
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
                    c.this.iZE.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.iZE.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
