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
    private TextView dNT;
    private RelativeLayout gdG;
    private LocalVideoActivity hxH;
    private ExpandGridView hxL;
    private a hxM;
    private CustomVideoView hxN;
    private TextView hxO;
    private String hxP;
    private ImageView hxQ;
    private ExpandViewRelativeLayout hxR;
    private FrameLayout hxS;
    private int hxT;
    private int hxU;
    private int hxV;
    private int hxW;
    private int hxX;
    private d hxY;
    private List<d> hxZ;
    private boolean hya;
    private boolean hyb;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hya = false;
        this.hyb = true;
        this.hxH = localVideoActivity;
        this.hxR = (ExpandViewRelativeLayout) this.hxH.findViewById(e.g.container);
        this.hxL = (ExpandGridView) this.hxH.findViewById(e.g.local_video_gridview);
        this.gdG = (RelativeLayout) this.hxH.findViewById(e.g.preview_videoview_container);
        this.hxQ = (ImageView) this.hxH.findViewById(e.g.video_cover);
        this.hxS = (FrameLayout) this.hxH.findViewById(e.g.top_container);
        this.hxN = (CustomVideoView) this.hxH.findViewById(e.g.preview_videoview);
        this.hxN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bY(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hxN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hya = true;
                c.this.hxN.stopPlayback();
                return false;
            }
        });
        this.dNT = (TextView) this.hxH.findViewById(e.g.close_btn);
        this.hxO = (TextView) this.hxH.findViewById(e.g.next_step_btn);
        this.hxO.setOnClickListener(onClickListener);
        this.dNT.setOnClickListener(onClickListener);
        this.hxM = new a(this.hxH);
        this.hxL.setAdapter((ListAdapter) this.hxM);
        this.hxL.setSelector(new ColorDrawable(0));
        this.hxL.setVerticalScrollBarEnabled(false);
        this.hxL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hya = false;
                    c.this.hxR.setIsCanLayout(true);
                    c.this.gdG.layout(c.this.gdG.getLeft(), 0, c.this.gdG.getRight(), c.this.hxW);
                    c.this.hxL.layout(c.this.hxL.getLeft(), c.this.hxW, c.this.hxL.getRight(), c.this.hxL.getBottom());
                    c.this.hxS.layout(c.this.hxS.getTop(), c.this.hxS.getLeft(), c.this.hxS.getRight(), c.this.hxS.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hxP) && c.this.hxN != null) {
                        c.this.hxN.setVisibility(8);
                        c.this.hxN.stopPlayback();
                        c.this.hxN.setVideoPath(dVar.getVideoPath());
                        c.this.hxN.setVisibility(0);
                        c.this.hxP = dVar.getVideoPath();
                        c.this.hxY = dVar;
                        if (c.this.hxQ != null) {
                            c.this.hxQ.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hxH);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hxQ.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hxN.start();
                    }
                }
            }
        });
        this.hxR.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aB(float f) {
                c.this.hxT = c.this.hxL.getTop();
                c.this.hxU = c.this.gdG.getTop();
                c.this.hxV = c.this.hxR.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hxR.setIsCanLayout(false);
                int i2 = (int) (c.this.hxT + f2);
                int i3 = i == 1 ? (int) (c.this.hxU + f2) : (int) (c.this.hxU + (f2 * 0.3d));
                if (i2 >= c.this.hxS.getBottom() && i2 <= l.h(c.this.hxH, e.C0200e.ds902)) {
                    c.this.gdG.layout(c.this.gdG.getLeft(), i3, c.this.gdG.getRight(), c.this.hxW + i3);
                    c.this.hxL.layout(c.this.hxL.getLeft(), i2, c.this.hxL.getRight(), c.this.hxL.getBottom());
                    if (i2 <= l.h(c.this.hxH, e.C0200e.ds400)) {
                        c.this.hyb = false;
                        c.this.hxN.pause();
                    } else {
                        c.this.hyb = true;
                        c.this.hxN.start();
                    }
                    float h = (l.h(c.this.hxH, e.C0200e.ds902) - i2) / l.h(c.this.hxH, e.C0200e.ds902);
                    if (h == 0.0f) {
                        c.this.hxQ.setVisibility(8);
                        return;
                    }
                    c.this.hxQ.setVisibility(0);
                    c.this.hxQ.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bGf() {
                if (c.this.hxL.getTop() > c.this.hxV / 2) {
                    c.this.hyb = true;
                    c.this.hxN.start();
                    c.this.hxQ.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.gdG.getBottom(), c.this.hxW);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gdG.layout(c.this.gdG.getLeft(), 0, c.this.gdG.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hxL.getTop(), c.this.hxW);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hxL.layout(c.this.hxL.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hxL.getRight(), c.this.hxL.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hyb = false;
                c.this.hxN.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.gdG.getBottom(), l.h(c.this.hxH, e.C0200e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.gdG.layout(c.this.gdG.getLeft(), intValue - c.this.hxW, c.this.gdG.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hxL.getTop(), l.h(c.this.hxH, e.C0200e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hxL.layout(c.this.hxL.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hxL.getRight(), c.this.hxL.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hxL.getTop() > c.this.hxS.getBottom() || c.this.hxL.getFirstVisiblePosition() != 0 || c.this.hxL.getChildCount() <= 0 || c.this.hxL.getChildAt(0).getTop() < 0) {
                    if (c.this.hxL.getTop() <= c.this.hxS.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hxW - l.h(c.this.hxH, e.C0200e.ds20))) && f2 < ((float) (c.this.hxW + l.h(c.this.hxH, e.C0200e.ds20)));
                }
                return true;
            }
        });
        this.hxW = l.h(this.hxH, e.C0200e.ds902);
    }

    public boolean bHq() {
        return this.hya;
    }

    public void dW(List<d> list) {
        if (!v.I(list)) {
            this.hxZ = list;
            d dVar = list.get(0);
            if (this.hxN != null) {
                this.hxN.setVideoPath(dVar.getVideoPath());
                this.hxP = dVar.getVideoPath();
                this.hxY = dVar;
                if (this.hxQ != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hxH);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hxQ.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hxN.start();
            }
            if (this.hxM != null) {
                this.hxM.setData(list);
                bHy();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), e.j.no_local_video_tip);
    }

    public void bHr() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hxH).cM(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hxH.getPageContext());
        a.bf(false);
        a.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hxH) / l.h(this.hxH, e.C0200e.ds902)) {
            i3 = l.aO(this.hxH);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hxH, e.C0200e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hxN.setVideoHeight(i4);
        this.hxN.setVideoWidth(i3);
        this.hxN.invalidate();
    }

    public void wl(String str) {
        if (this.hxM != null) {
            this.hxM.wk(str);
        }
    }

    public TextView bHs() {
        return this.dNT;
    }

    public TextView bHt() {
        return this.hxO;
    }

    public void bHu() {
        if (this.hxN != null && !StringUtils.isNull(this.hxP)) {
            this.hxN.start();
        }
    }

    public void bHv() {
        if (this.hxN != null && !StringUtils.isNull(this.hxP)) {
            this.hxN.resume();
            this.hxN.seekTo(this.hxX);
            if (this.hyb) {
                this.hxN.start();
            }
        }
    }

    public void aBg() {
        this.hxX = this.hxN.getCurrentPosition();
        if (this.hxN != null) {
            this.hxN.pause();
        }
    }

    public void aBh() {
        this.hxX = this.hxN.getCurrentPosition();
        if (this.hxN != null) {
            this.hxN.stopPlayback();
        }
    }

    public String bHw() {
        return this.hxP;
    }

    public d bHx() {
        return this.hxY;
    }

    private void bHy() {
        if (!v.I(this.hxZ)) {
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
                        if (i2 >= c.this.hxZ.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hxZ.get(i2);
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
                            dVar.nY(true);
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
                    c.this.hxM.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hxM.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
