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
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private TextView diZ;
    private RelativeLayout fxl;
    private LocalVideoActivity gPV;
    private ExpandGridView gPZ;
    private a gQa;
    private CustomVideoView gQb;
    private TextView gQc;
    private String gQd;
    private ImageView gQe;
    private ExpandViewRelativeLayout gQf;
    private FrameLayout gQg;
    private int gQh;
    private int gQi;
    private int gQj;
    private int gQk;
    private int gQl;
    private d gQm;
    private List<d> gQn;
    private boolean gQo;
    private boolean gQp;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gQo = false;
        this.gQp = true;
        this.gPV = localVideoActivity;
        this.gQf = (ExpandViewRelativeLayout) this.gPV.findViewById(d.g.container);
        this.gPZ = (ExpandGridView) this.gPV.findViewById(d.g.local_video_gridview);
        this.fxl = (RelativeLayout) this.gPV.findViewById(d.g.preview_videoview_container);
        this.gQe = (ImageView) this.gPV.findViewById(d.g.video_cover);
        this.gQg = (FrameLayout) this.gPV.findViewById(d.g.top_container);
        this.gQb = (CustomVideoView) this.gPV.findViewById(d.g.preview_videoview);
        this.gQb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gQb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.gQo = true;
                c.this.gQb.stopPlayback();
                return false;
            }
        });
        this.diZ = (TextView) this.gPV.findViewById(d.g.close_btn);
        this.gQc = (TextView) this.gPV.findViewById(d.g.next_step_btn);
        this.gQc.setOnClickListener(onClickListener);
        this.diZ.setOnClickListener(onClickListener);
        this.gQa = new a(this.gPV);
        this.gPZ.setAdapter((ListAdapter) this.gQa);
        this.gPZ.setSelector(new ColorDrawable(0));
        this.gPZ.setVerticalScrollBarEnabled(false);
        this.gPZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gQo = false;
                    c.this.gQf.setIsCanLayout(true);
                    c.this.fxl.layout(c.this.fxl.getLeft(), 0, c.this.fxl.getRight(), c.this.gQk);
                    c.this.gPZ.layout(c.this.gPZ.getLeft(), c.this.gQk, c.this.gPZ.getRight(), c.this.gPZ.getBottom());
                    c.this.gQg.layout(c.this.gQg.getTop(), c.this.gQg.getLeft(), c.this.gQg.getRight(), c.this.gQg.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gQd) && c.this.gQb != null) {
                        c.this.gQb.setVisibility(8);
                        c.this.gQb.stopPlayback();
                        c.this.gQb.setVideoPath(dVar.getVideoPath());
                        c.this.gQb.setVisibility(0);
                        c.this.gQd = dVar.getVideoPath();
                        c.this.gQm = dVar;
                        if (c.this.gQe != null) {
                            c.this.gQe.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gPV);
                            blurDrawable.init(12, 8, dVar.bxE());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gQe.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gQb.start();
                    }
                }
            }
        });
        this.gQf.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void au(float f) {
                c.this.gQh = c.this.gPZ.getTop();
                c.this.gQi = c.this.fxl.getTop();
                c.this.gQj = c.this.gQf.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.gQf.setIsCanLayout(false);
                int i2 = (int) (c.this.gQh + f2);
                int i3 = i == 1 ? (int) (c.this.gQi + f2) : (int) (c.this.gQi + (f2 * 0.3d));
                if (i2 >= c.this.gQg.getBottom() && i2 <= l.e(c.this.gPV, d.e.ds902)) {
                    c.this.fxl.layout(c.this.fxl.getLeft(), i3, c.this.fxl.getRight(), c.this.gQk + i3);
                    c.this.gPZ.layout(c.this.gPZ.getLeft(), i2, c.this.gPZ.getRight(), c.this.gPZ.getBottom());
                    if (i2 <= l.e(c.this.gPV, d.e.ds400)) {
                        c.this.gQp = false;
                        c.this.gQb.pause();
                    } else {
                        c.this.gQp = true;
                        c.this.gQb.start();
                    }
                    float e = (l.e(c.this.gPV, d.e.ds902) - i2) / l.e(c.this.gPV, d.e.ds902);
                    if (e == 0.0f) {
                        c.this.gQe.setVisibility(8);
                        return;
                    }
                    c.this.gQe.setVisibility(0);
                    c.this.gQe.setAlpha(e);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bwj() {
                if (c.this.gPZ.getTop() > c.this.gQj / 2) {
                    c.this.gQp = true;
                    c.this.gQb.start();
                    c.this.gQe.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fxl.getBottom(), c.this.gQk);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fxl.layout(c.this.fxl.getLeft(), 0, c.this.fxl.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gPZ.getTop(), c.this.gQk);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gPZ.layout(c.this.gPZ.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gPZ.getRight(), c.this.gPZ.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.gQp = false;
                c.this.gQb.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fxl.getBottom(), l.e(c.this.gPV, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fxl.layout(c.this.fxl.getLeft(), intValue - c.this.gQk, c.this.fxl.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gPZ.getTop(), l.e(c.this.gPV, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gPZ.layout(c.this.gPZ.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gPZ.getRight(), c.this.gPZ.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.gPZ.getTop() > c.this.gQg.getBottom() || c.this.gPZ.getFirstVisiblePosition() != 0 || c.this.gPZ.getChildCount() <= 0 || c.this.gPZ.getChildAt(0).getTop() < 0) {
                    if (c.this.gPZ.getTop() <= c.this.gQg.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gQk - l.e(c.this.gPV, d.e.ds20))) && f2 < ((float) (c.this.gQk + l.e(c.this.gPV, d.e.ds20)));
                }
                return true;
            }
        });
        this.gQk = l.e(this.gPV, d.e.ds902);
    }

    public boolean bxv() {
        return this.gQo;
    }

    public void dF(List<d> list) {
        if (!v.w(list)) {
            this.gQn = list;
            d dVar = list.get(0);
            if (this.gQb != null) {
                this.gQb.setVideoPath(dVar.getVideoPath());
                this.gQd = dVar.getVideoPath();
                this.gQm = dVar;
                if (this.gQe != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gPV);
                    blurDrawable.init(12, 8, dVar.bxE());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gQe.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gQb.start();
            }
            if (this.gQa != null) {
                this.gQa.setData(list);
                bxD();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.k.no_local_video_tip);
    }

    public void bxw() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gPV).bZ(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gPV.getPageContext());
        a.as(false);
        a.tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.gPV) / l.e(this.gPV, d.e.ds902)) {
            i3 = l.af(this.gPV);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.gPV, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.gQb.setVideoHeight(i4);
        this.gQb.setVideoWidth(i3);
        this.gQb.invalidate();
    }

    public void ue(String str) {
        if (this.gQa != null) {
            this.gQa.ud(str);
        }
    }

    public TextView bxx() {
        return this.diZ;
    }

    public TextView bxy() {
        return this.gQc;
    }

    public void bxz() {
        if (this.gQb != null && !StringUtils.isNull(this.gQd)) {
            this.gQb.start();
        }
    }

    public void bxA() {
        if (this.gQb != null && !StringUtils.isNull(this.gQd)) {
            this.gQb.resume();
            this.gQb.seekTo(this.gQl);
            if (this.gQp) {
                this.gQb.start();
            }
        }
    }

    public void aqQ() {
        this.gQl = this.gQb.getCurrentPosition();
        if (this.gQb != null) {
            this.gQb.pause();
        }
    }

    public void aqR() {
        this.gQl = this.gQb.getCurrentPosition();
        if (this.gQb != null) {
            this.gQb.stopPlayback();
        }
    }

    public String bxB() {
        return this.gQd;
    }

    public d bxC() {
        return this.gQm;
    }

    private void bxD() {
        if (!v.w(this.gQn)) {
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
                        if (i2 >= c.this.gQn.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gQn.get(i2);
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
                                        dVar.E(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                    c.this.gQa.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gQa.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
