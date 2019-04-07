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
    private RelativeLayout hEk;
    private ExpandGridView iZC;
    private a iZD;
    private CustomVideoView iZE;
    private TextView iZF;
    private String iZG;
    private ImageView iZH;
    private ExpandViewRelativeLayout iZI;
    private FrameLayout iZJ;
    private int iZK;
    private int iZL;
    private int iZM;
    private int iZN;
    private int iZO;
    private d iZP;
    private List<d> iZQ;
    private boolean iZR;
    private boolean iZS;
    private LocalVideoActivity iZy;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.iZR = false;
        this.iZS = true;
        this.iZy = localVideoActivity;
        this.iZI = (ExpandViewRelativeLayout) this.iZy.findViewById(d.g.container);
        this.iZC = (ExpandGridView) this.iZy.findViewById(d.g.local_video_gridview);
        this.hEk = (RelativeLayout) this.iZy.findViewById(d.g.preview_videoview_container);
        this.iZH = (ImageView) this.iZy.findViewById(d.g.video_cover);
        this.iZJ = (FrameLayout) this.iZy.findViewById(d.g.top_container);
        this.iZE = (CustomVideoView) this.iZy.findViewById(d.g.preview_videoview);
        this.iZE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cu(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.iZE.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.iZR = true;
                c.this.iZE.stopPlayback();
                return false;
            }
        });
        this.fli = (TextView) this.iZy.findViewById(d.g.close_btn);
        this.iZF = (TextView) this.iZy.findViewById(d.g.next_step_btn);
        this.iZF.setOnClickListener(onClickListener);
        this.fli.setOnClickListener(onClickListener);
        this.iZD = new a(this.iZy);
        this.iZC.setAdapter((ListAdapter) this.iZD);
        this.iZC.setSelector(new ColorDrawable(0));
        this.iZC.setVerticalScrollBarEnabled(false);
        this.iZC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.iZR = false;
                    c.this.iZI.setIsCanLayout(true);
                    c.this.hEk.layout(c.this.hEk.getLeft(), 0, c.this.hEk.getRight(), c.this.iZN);
                    c.this.iZC.layout(c.this.iZC.getLeft(), c.this.iZN, c.this.iZC.getRight(), c.this.iZC.getBottom());
                    c.this.iZJ.layout(c.this.iZJ.getTop(), c.this.iZJ.getLeft(), c.this.iZJ.getRight(), c.this.iZJ.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.iZG) && c.this.iZE != null) {
                        c.this.iZE.setVisibility(8);
                        c.this.iZE.stopPlayback();
                        c.this.iZE.setVideoPath(dVar.getVideoPath());
                        c.this.iZE.setVisibility(0);
                        c.this.iZG = dVar.getVideoPath();
                        c.this.iZP = dVar;
                        if (c.this.iZH != null) {
                            c.this.iZH.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.iZy);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.iZH.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.iZE.start();
                    }
                }
            }
        });
        this.iZI.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aO(float f) {
                c.this.iZK = c.this.iZC.getTop();
                c.this.iZL = c.this.hEk.getTop();
                c.this.iZM = c.this.iZI.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.iZI.setIsCanLayout(false);
                int i2 = (int) (c.this.iZK + f2);
                int i3 = i == 1 ? (int) (c.this.iZL + f2) : (int) (c.this.iZL + (f2 * 0.3d));
                if (i2 >= c.this.iZJ.getBottom() && i2 <= l.h(c.this.iZy, d.e.ds902)) {
                    c.this.hEk.layout(c.this.hEk.getLeft(), i3, c.this.hEk.getRight(), c.this.iZN + i3);
                    c.this.iZC.layout(c.this.iZC.getLeft(), i2, c.this.iZC.getRight(), c.this.iZC.getBottom());
                    if (i2 <= l.h(c.this.iZy, d.e.ds400)) {
                        c.this.iZS = false;
                        c.this.iZE.pause();
                    } else {
                        c.this.iZS = true;
                        c.this.iZE.start();
                    }
                    float h = (l.h(c.this.iZy, d.e.ds902) - i2) / l.h(c.this.iZy, d.e.ds902);
                    if (h == 0.0f) {
                        c.this.iZH.setVisibility(8);
                        return;
                    }
                    c.this.iZH.setVisibility(0);
                    c.this.iZH.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cjg() {
                if (c.this.iZC.getTop() > c.this.iZM / 2) {
                    c.this.iZS = true;
                    c.this.iZE.start();
                    c.this.iZH.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.hEk.getBottom(), c.this.iZN);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hEk.layout(c.this.hEk.getLeft(), 0, c.this.hEk.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.iZC.getTop(), c.this.iZN);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iZC.layout(c.this.iZC.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.iZC.getRight(), c.this.iZC.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.iZS = false;
                c.this.iZE.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.hEk.getBottom(), l.h(c.this.iZy, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.hEk.layout(c.this.hEk.getLeft(), intValue - c.this.iZN, c.this.hEk.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.iZC.getTop(), l.h(c.this.iZy, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.iZC.layout(c.this.iZC.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.iZC.getRight(), c.this.iZC.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.iZC.getTop() > c.this.iZJ.getBottom() || c.this.iZC.getFirstVisiblePosition() != 0 || c.this.iZC.getChildCount() <= 0 || c.this.iZC.getChildAt(0).getTop() < 0) {
                    if (c.this.iZC.getTop() <= c.this.iZJ.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.iZN - l.h(c.this.iZy, d.e.ds20))) && f2 < ((float) (c.this.iZN + l.h(c.this.iZy, d.e.ds20)));
                }
                return true;
            }
        });
        this.iZN = l.h(this.iZy, d.e.ds902);
    }

    public boolean cks() {
        return this.iZR;
    }

    public void ef(List<d> list) {
        if (!v.T(list)) {
            this.iZQ = list;
            d dVar = list.get(0);
            if (this.iZE != null) {
                this.iZE.setVideoPath(dVar.getVideoPath());
                this.iZG = dVar.getVideoPath();
                this.iZP = dVar;
                if (this.iZH != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.iZy);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.iZH.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.iZE.start();
            }
            if (this.iZD != null) {
                this.iZD.setData(list);
                ckA();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void ckt() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.iZy).gB(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.iZy.getPageContext());
        a.dr(false);
        a.aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.iZy) / l.h(this.iZy, d.e.ds902)) {
            i3 = l.aO(this.iZy);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.iZy, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.iZE.setVideoHeight(i4);
        this.iZE.setVideoWidth(i3);
        this.iZE.invalidate();
    }

    public void DH(String str) {
        if (this.iZD != null) {
            this.iZD.DG(str);
        }
    }

    public TextView cku() {
        return this.fli;
    }

    public TextView ckv() {
        return this.iZF;
    }

    public void ckw() {
        if (this.iZE != null && !StringUtils.isNull(this.iZG)) {
            this.iZE.start();
        }
    }

    public void ckx() {
        if (this.iZE != null && !StringUtils.isNull(this.iZG)) {
            this.iZE.resume();
            this.iZE.seekTo(this.iZO);
            if (this.iZS) {
                this.iZE.start();
            }
        }
    }

    public void beJ() {
        this.iZO = this.iZE.getCurrentPosition();
        if (this.iZE != null) {
            this.iZE.pause();
        }
    }

    public void beK() {
        this.iZO = this.iZE.getCurrentPosition();
        if (this.iZE != null) {
            this.iZE.stopPlayback();
        }
    }

    public String cky() {
        return this.iZG;
    }

    public d ckz() {
        return this.iZP;
    }

    private void ckA() {
        if (!v.T(this.iZQ)) {
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
                        if (i2 >= c.this.iZQ.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.iZQ.get(i2);
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
                    c.this.iZD.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.iZD.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
