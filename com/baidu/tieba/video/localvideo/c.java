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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.d;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private TextView dsn;
    private RelativeLayout fIF;
    private ExpandGridView hbB;
    private a hbC;
    private CustomVideoView hbD;
    private TextView hbE;
    private String hbF;
    private ImageView hbG;
    private ExpandViewRelativeLayout hbH;
    private FrameLayout hbI;
    private int hbJ;
    private int hbK;
    private int hbL;
    private int hbM;
    private int hbN;
    private d hbO;
    private List<d> hbP;
    private boolean hbQ;
    private boolean hbR;
    private LocalVideoActivity hbx;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hbQ = false;
        this.hbR = true;
        this.hbx = localVideoActivity;
        this.hbH = (ExpandViewRelativeLayout) this.hbx.findViewById(d.g.container);
        this.hbB = (ExpandGridView) this.hbx.findViewById(d.g.local_video_gridview);
        this.fIF = (RelativeLayout) this.hbx.findViewById(d.g.preview_videoview_container);
        this.hbG = (ImageView) this.hbx.findViewById(d.g.video_cover);
        this.hbI = (FrameLayout) this.hbx.findViewById(d.g.top_container);
        this.hbD = (CustomVideoView) this.hbx.findViewById(d.g.preview_videoview);
        this.hbD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hbD.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hbQ = true;
                c.this.hbD.stopPlayback();
                return false;
            }
        });
        this.dsn = (TextView) this.hbx.findViewById(d.g.close_btn);
        this.hbE = (TextView) this.hbx.findViewById(d.g.next_step_btn);
        this.hbE.setOnClickListener(onClickListener);
        this.dsn.setOnClickListener(onClickListener);
        this.hbC = new a(this.hbx);
        this.hbB.setAdapter((ListAdapter) this.hbC);
        this.hbB.setSelector(new ColorDrawable(0));
        this.hbB.setVerticalScrollBarEnabled(false);
        this.hbB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hbQ = false;
                    c.this.hbH.setIsCanLayout(true);
                    c.this.fIF.layout(c.this.fIF.getLeft(), 0, c.this.fIF.getRight(), c.this.hbM);
                    c.this.hbB.layout(c.this.hbB.getLeft(), c.this.hbM, c.this.hbB.getRight(), c.this.hbB.getBottom());
                    c.this.hbI.layout(c.this.hbI.getTop(), c.this.hbI.getLeft(), c.this.hbI.getRight(), c.this.hbI.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hbF) && c.this.hbD != null) {
                        c.this.hbD.setVisibility(8);
                        c.this.hbD.stopPlayback();
                        c.this.hbD.setVideoPath(dVar.getVideoPath());
                        c.this.hbD.setVisibility(0);
                        c.this.hbF = dVar.getVideoPath();
                        c.this.hbO = dVar;
                        if (c.this.hbG != null) {
                            c.this.hbG.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hbx);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hbG.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hbD.start();
                    }
                }
            }
        });
        this.hbH.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aE(float f) {
                c.this.hbJ = c.this.hbB.getTop();
                c.this.hbK = c.this.fIF.getTop();
                c.this.hbL = c.this.hbH.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hbH.setIsCanLayout(false);
                int i2 = (int) (c.this.hbJ + f2);
                int i3 = i == 1 ? (int) (c.this.hbK + f2) : (int) (c.this.hbK + (f2 * 0.3d));
                if (i2 >= c.this.hbI.getBottom() && i2 <= l.e(c.this.hbx, d.e.ds902)) {
                    c.this.fIF.layout(c.this.fIF.getLeft(), i3, c.this.fIF.getRight(), c.this.hbM + i3);
                    c.this.hbB.layout(c.this.hbB.getLeft(), i2, c.this.hbB.getRight(), c.this.hbB.getBottom());
                    if (i2 <= l.e(c.this.hbx, d.e.ds400)) {
                        c.this.hbR = false;
                        c.this.hbD.pause();
                    } else {
                        c.this.hbR = true;
                        c.this.hbD.start();
                    }
                    float e = (l.e(c.this.hbx, d.e.ds902) - i2) / l.e(c.this.hbx, d.e.ds902);
                    if (e == 0.0f) {
                        c.this.hbG.setVisibility(8);
                        return;
                    }
                    c.this.hbG.setVisibility(0);
                    c.this.hbG.setAlpha(e);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bBq() {
                if (c.this.hbB.getTop() > c.this.hbL / 2) {
                    c.this.hbR = true;
                    c.this.hbD.start();
                    c.this.hbG.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fIF.getBottom(), c.this.hbM);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fIF.layout(c.this.fIF.getLeft(), 0, c.this.fIF.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hbB.getTop(), c.this.hbM);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hbB.layout(c.this.hbB.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hbB.getRight(), c.this.hbB.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hbR = false;
                c.this.hbD.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fIF.getBottom(), l.e(c.this.hbx, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fIF.layout(c.this.fIF.getLeft(), intValue - c.this.hbM, c.this.fIF.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hbB.getTop(), l.e(c.this.hbx, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hbB.layout(c.this.hbB.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hbB.getRight(), c.this.hbB.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hbB.getTop() > c.this.hbI.getBottom() || c.this.hbB.getFirstVisiblePosition() != 0 || c.this.hbB.getChildCount() <= 0 || c.this.hbB.getChildAt(0).getTop() < 0) {
                    if (c.this.hbB.getTop() <= c.this.hbI.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hbM - l.e(c.this.hbx, d.e.ds20))) && f2 < ((float) (c.this.hbM + l.e(c.this.hbx, d.e.ds20)));
                }
                return true;
            }
        });
        this.hbM = l.e(this.hbx, d.e.ds902);
    }

    public boolean bCC() {
        return this.hbQ;
    }

    public void dK(List<d> list) {
        if (!w.z(list)) {
            this.hbP = list;
            d dVar = list.get(0);
            if (this.hbD != null) {
                this.hbD.setVideoPath(dVar.getVideoPath());
                this.hbF = dVar.getVideoPath();
                this.hbO = dVar;
                if (this.hbG != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hbx);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hbG.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hbD.start();
            }
            if (this.hbC != null) {
                this.hbC.setData(list);
                bCK();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.k.no_local_video_tip);
    }

    public void bCD() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hbx).cb(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hbx.getPageContext());
        a.av(false);
        a.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hbx) / l.e(this.hbx, d.e.ds902)) {
            i3 = l.ah(this.hbx);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.hbx, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.hbD.setVideoHeight(i4);
        this.hbD.setVideoWidth(i3);
        this.hbD.invalidate();
    }

    public void uY(String str) {
        if (this.hbC != null) {
            this.hbC.uX(str);
        }
    }

    public TextView bCE() {
        return this.dsn;
    }

    public TextView bCF() {
        return this.hbE;
    }

    public void bCG() {
        if (this.hbD != null && !StringUtils.isNull(this.hbF)) {
            this.hbD.start();
        }
    }

    public void bCH() {
        if (this.hbD != null && !StringUtils.isNull(this.hbF)) {
            this.hbD.resume();
            this.hbD.seekTo(this.hbN);
            if (this.hbR) {
                this.hbD.start();
            }
        }
    }

    public void auV() {
        this.hbN = this.hbD.getCurrentPosition();
        if (this.hbD != null) {
            this.hbD.pause();
        }
    }

    public void auW() {
        this.hbN = this.hbD.getCurrentPosition();
        if (this.hbD != null) {
            this.hbD.stopPlayback();
        }
    }

    public String bCI() {
        return this.hbF;
    }

    public d bCJ() {
        return this.hbO;
    }

    private void bCK() {
        if (!w.z(this.hbP)) {
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
                        if (i2 >= c.this.hbP.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hbP.get(i2);
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
                            dVar.nc(true);
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
                    c.this.hbC.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hbC.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
