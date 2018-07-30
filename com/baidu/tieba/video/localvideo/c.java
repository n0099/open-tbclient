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
    private TextView dyj;
    private RelativeLayout fMV;
    private LocalVideoActivity hgR;
    private ExpandGridView hgV;
    private a hgW;
    private CustomVideoView hgX;
    private TextView hgY;
    private String hgZ;
    private ImageView hha;
    private ExpandViewRelativeLayout hhb;
    private FrameLayout hhc;
    private int hhd;
    private int hhe;
    private int hhf;
    private int hhg;
    private int hhh;
    private d hhi;
    private List<d> hhj;
    private boolean hhk;
    private boolean hhl;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hhk = false;
        this.hhl = true;
        this.hgR = localVideoActivity;
        this.hhb = (ExpandViewRelativeLayout) this.hgR.findViewById(d.g.container);
        this.hgV = (ExpandGridView) this.hgR.findViewById(d.g.local_video_gridview);
        this.fMV = (RelativeLayout) this.hgR.findViewById(d.g.preview_videoview_container);
        this.hha = (ImageView) this.hgR.findViewById(d.g.video_cover);
        this.hhc = (FrameLayout) this.hgR.findViewById(d.g.top_container);
        this.hgX = (CustomVideoView) this.hgR.findViewById(d.g.preview_videoview);
        this.hgX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bP(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hgX.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hhk = true;
                c.this.hgX.stopPlayback();
                return false;
            }
        });
        this.dyj = (TextView) this.hgR.findViewById(d.g.close_btn);
        this.hgY = (TextView) this.hgR.findViewById(d.g.next_step_btn);
        this.hgY.setOnClickListener(onClickListener);
        this.dyj.setOnClickListener(onClickListener);
        this.hgW = new a(this.hgR);
        this.hgV.setAdapter((ListAdapter) this.hgW);
        this.hgV.setSelector(new ColorDrawable(0));
        this.hgV.setVerticalScrollBarEnabled(false);
        this.hgV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hhk = false;
                    c.this.hhb.setIsCanLayout(true);
                    c.this.fMV.layout(c.this.fMV.getLeft(), 0, c.this.fMV.getRight(), c.this.hhg);
                    c.this.hgV.layout(c.this.hgV.getLeft(), c.this.hhg, c.this.hgV.getRight(), c.this.hgV.getBottom());
                    c.this.hhc.layout(c.this.hhc.getTop(), c.this.hhc.getLeft(), c.this.hhc.getRight(), c.this.hhc.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hgZ) && c.this.hgX != null) {
                        c.this.hgX.setVisibility(8);
                        c.this.hgX.stopPlayback();
                        c.this.hgX.setVideoPath(dVar.getVideoPath());
                        c.this.hgX.setVisibility(0);
                        c.this.hgZ = dVar.getVideoPath();
                        c.this.hhi = dVar;
                        if (c.this.hha != null) {
                            c.this.hha.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hgR);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hha.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hgX.start();
                    }
                }
            }
        });
        this.hhb.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aF(float f) {
                c.this.hhd = c.this.hgV.getTop();
                c.this.hhe = c.this.fMV.getTop();
                c.this.hhf = c.this.hhb.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hhb.setIsCanLayout(false);
                int i2 = (int) (c.this.hhd + f2);
                int i3 = i == 1 ? (int) (c.this.hhe + f2) : (int) (c.this.hhe + (f2 * 0.3d));
                if (i2 >= c.this.hhc.getBottom() && i2 <= l.f(c.this.hgR, d.e.ds902)) {
                    c.this.fMV.layout(c.this.fMV.getLeft(), i3, c.this.fMV.getRight(), c.this.hhg + i3);
                    c.this.hgV.layout(c.this.hgV.getLeft(), i2, c.this.hgV.getRight(), c.this.hgV.getBottom());
                    if (i2 <= l.f(c.this.hgR, d.e.ds400)) {
                        c.this.hhl = false;
                        c.this.hgX.pause();
                    } else {
                        c.this.hhl = true;
                        c.this.hgX.start();
                    }
                    float f3 = (l.f(c.this.hgR, d.e.ds902) - i2) / l.f(c.this.hgR, d.e.ds902);
                    if (f3 == 0.0f) {
                        c.this.hha.setVisibility(8);
                        return;
                    }
                    c.this.hha.setVisibility(0);
                    c.this.hha.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bAB() {
                if (c.this.hgV.getTop() > c.this.hhf / 2) {
                    c.this.hhl = true;
                    c.this.hgX.start();
                    c.this.hha.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fMV.getBottom(), c.this.hhg);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fMV.layout(c.this.fMV.getLeft(), 0, c.this.fMV.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hgV.getTop(), c.this.hhg);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hgV.layout(c.this.hgV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hgV.getRight(), c.this.hgV.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hhl = false;
                c.this.hgX.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fMV.getBottom(), l.f(c.this.hgR, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fMV.layout(c.this.fMV.getLeft(), intValue - c.this.hhg, c.this.fMV.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hgV.getTop(), l.f(c.this.hgR, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hgV.layout(c.this.hgV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hgV.getRight(), c.this.hgV.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hgV.getTop() > c.this.hhc.getBottom() || c.this.hgV.getFirstVisiblePosition() != 0 || c.this.hgV.getChildCount() <= 0 || c.this.hgV.getChildAt(0).getTop() < 0) {
                    if (c.this.hgV.getTop() <= c.this.hhc.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hhg - l.f(c.this.hgR, d.e.ds20))) && f2 < ((float) (c.this.hhg + l.f(c.this.hgR, d.e.ds20)));
                }
                return true;
            }
        });
        this.hhg = l.f(this.hgR, d.e.ds902);
    }

    public boolean bBN() {
        return this.hhk;
    }

    public void dJ(List<d> list) {
        if (!w.z(list)) {
            this.hhj = list;
            d dVar = list.get(0);
            if (this.hgX != null) {
                this.hgX.setVideoPath(dVar.getVideoPath());
                this.hgZ = dVar.getVideoPath();
                this.hhi = dVar;
                if (this.hha != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hgR);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hha.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hgX.start();
            }
            if (this.hgW != null) {
                this.hgW.setData(list);
                bBV();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bBO() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hgR).ce(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hgR.getPageContext());
        a.av(false);
        a.xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hgR) / l.f(this.hgR, d.e.ds902)) {
            i3 = l.ah(this.hgR);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.hgR, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.hgX.setVideoHeight(i4);
        this.hgX.setVideoWidth(i3);
        this.hgX.invalidate();
    }

    public void uS(String str) {
        if (this.hgW != null) {
            this.hgW.uR(str);
        }
    }

    public TextView bBP() {
        return this.dyj;
    }

    public TextView bBQ() {
        return this.hgY;
    }

    public void bBR() {
        if (this.hgX != null && !StringUtils.isNull(this.hgZ)) {
            this.hgX.start();
        }
    }

    public void bBS() {
        if (this.hgX != null && !StringUtils.isNull(this.hgZ)) {
            this.hgX.resume();
            this.hgX.seekTo(this.hhh);
            if (this.hhl) {
                this.hgX.start();
            }
        }
    }

    public void awe() {
        this.hhh = this.hgX.getCurrentPosition();
        if (this.hgX != null) {
            this.hgX.pause();
        }
    }

    public void awf() {
        this.hhh = this.hgX.getCurrentPosition();
        if (this.hgX != null) {
            this.hgX.stopPlayback();
        }
    }

    public String bBT() {
        return this.hgZ;
    }

    public d bBU() {
        return this.hhi;
    }

    private void bBV() {
        if (!w.z(this.hhj)) {
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
                        if (i2 >= c.this.hhj.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hhj.get(i2);
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
                                        dVar.C(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.mW(true);
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
                    c.this.hgW.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hgW.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
