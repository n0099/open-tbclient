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
    private TextView dhV;
    private RelativeLayout fwi;
    private LocalVideoActivity gOV;
    private ExpandGridView gOZ;
    private a gPa;
    private CustomVideoView gPb;
    private TextView gPc;
    private String gPd;
    private ImageView gPe;
    private ExpandViewRelativeLayout gPf;
    private FrameLayout gPg;
    private int gPh;
    private int gPi;
    private int gPj;
    private int gPk;
    private int gPl;
    private d gPm;
    private List<d> gPn;
    private boolean gPo;
    private boolean gPp;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gPo = false;
        this.gPp = true;
        this.gOV = localVideoActivity;
        this.gPf = (ExpandViewRelativeLayout) this.gOV.findViewById(d.g.container);
        this.gOZ = (ExpandGridView) this.gOV.findViewById(d.g.local_video_gridview);
        this.fwi = (RelativeLayout) this.gOV.findViewById(d.g.preview_videoview_container);
        this.gPe = (ImageView) this.gOV.findViewById(d.g.video_cover);
        this.gPg = (FrameLayout) this.gOV.findViewById(d.g.top_container);
        this.gPb = (CustomVideoView) this.gOV.findViewById(d.g.preview_videoview);
        this.gPb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bP(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gPb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.gPo = true;
                c.this.gPb.stopPlayback();
                return false;
            }
        });
        this.dhV = (TextView) this.gOV.findViewById(d.g.close_btn);
        this.gPc = (TextView) this.gOV.findViewById(d.g.next_step_btn);
        this.gPc.setOnClickListener(onClickListener);
        this.dhV.setOnClickListener(onClickListener);
        this.gPa = new a(this.gOV);
        this.gOZ.setAdapter((ListAdapter) this.gPa);
        this.gOZ.setSelector(new ColorDrawable(0));
        this.gOZ.setVerticalScrollBarEnabled(false);
        this.gOZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gPo = false;
                    c.this.gPf.setIsCanLayout(true);
                    c.this.fwi.layout(c.this.fwi.getLeft(), 0, c.this.fwi.getRight(), c.this.gPk);
                    c.this.gOZ.layout(c.this.gOZ.getLeft(), c.this.gPk, c.this.gOZ.getRight(), c.this.gOZ.getBottom());
                    c.this.gPg.layout(c.this.gPg.getTop(), c.this.gPg.getLeft(), c.this.gPg.getRight(), c.this.gPg.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gPd) && c.this.gPb != null) {
                        c.this.gPb.setVisibility(8);
                        c.this.gPb.stopPlayback();
                        c.this.gPb.setVideoPath(dVar.getVideoPath());
                        c.this.gPb.setVisibility(0);
                        c.this.gPd = dVar.getVideoPath();
                        c.this.gPm = dVar;
                        if (c.this.gPe != null) {
                            c.this.gPe.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gOV);
                            blurDrawable.init(12, 8, dVar.bxG());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gPe.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gPb.start();
                    }
                }
            }
        });
        this.gPf.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void au(float f) {
                c.this.gPh = c.this.gOZ.getTop();
                c.this.gPi = c.this.fwi.getTop();
                c.this.gPj = c.this.gPf.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.gPf.setIsCanLayout(false);
                int i2 = (int) (c.this.gPh + f2);
                int i3 = i == 1 ? (int) (c.this.gPi + f2) : (int) (c.this.gPi + (f2 * 0.3d));
                if (i2 >= c.this.gPg.getBottom() && i2 <= l.e(c.this.gOV, d.e.ds902)) {
                    c.this.fwi.layout(c.this.fwi.getLeft(), i3, c.this.fwi.getRight(), c.this.gPk + i3);
                    c.this.gOZ.layout(c.this.gOZ.getLeft(), i2, c.this.gOZ.getRight(), c.this.gOZ.getBottom());
                    if (i2 <= l.e(c.this.gOV, d.e.ds400)) {
                        c.this.gPp = false;
                        c.this.gPb.pause();
                    } else {
                        c.this.gPp = true;
                        c.this.gPb.start();
                    }
                    float e = (l.e(c.this.gOV, d.e.ds902) - i2) / l.e(c.this.gOV, d.e.ds902);
                    if (e == 0.0f) {
                        c.this.gPe.setVisibility(8);
                        return;
                    }
                    c.this.gPe.setVisibility(0);
                    c.this.gPe.setAlpha(e);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bwl() {
                if (c.this.gOZ.getTop() > c.this.gPj / 2) {
                    c.this.gPp = true;
                    c.this.gPb.start();
                    c.this.gPe.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fwi.getBottom(), c.this.gPk);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fwi.layout(c.this.fwi.getLeft(), 0, c.this.fwi.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gOZ.getTop(), c.this.gPk);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gOZ.layout(c.this.gOZ.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gOZ.getRight(), c.this.gOZ.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.gPp = false;
                c.this.gPb.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fwi.getBottom(), l.e(c.this.gOV, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fwi.layout(c.this.fwi.getLeft(), intValue - c.this.gPk, c.this.fwi.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gOZ.getTop(), l.e(c.this.gOV, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gOZ.layout(c.this.gOZ.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gOZ.getRight(), c.this.gOZ.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.gOZ.getTop() > c.this.gPg.getBottom() || c.this.gOZ.getFirstVisiblePosition() != 0 || c.this.gOZ.getChildCount() <= 0 || c.this.gOZ.getChildAt(0).getTop() < 0) {
                    if (c.this.gOZ.getTop() <= c.this.gPg.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gPk - l.e(c.this.gOV, d.e.ds20))) && f2 < ((float) (c.this.gPk + l.e(c.this.gOV, d.e.ds20)));
                }
                return true;
            }
        });
        this.gPk = l.e(this.gOV, d.e.ds902);
    }

    public boolean bxx() {
        return this.gPo;
    }

    public void dC(List<d> list) {
        if (!v.w(list)) {
            this.gPn = list;
            d dVar = list.get(0);
            if (this.gPb != null) {
                this.gPb.setVideoPath(dVar.getVideoPath());
                this.gPd = dVar.getVideoPath();
                this.gPm = dVar;
                if (this.gPe != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gOV);
                    blurDrawable.init(12, 8, dVar.bxG());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gPe.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gPb.start();
            }
            if (this.gPa != null) {
                this.gPa.setData(list);
                bxF();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.k.no_local_video_tip);
    }

    public void bxy() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gOV).bZ(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gOV.getPageContext());
        a.as(false);
        a.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.gOV) / l.e(this.gOV, d.e.ds902)) {
            i3 = l.af(this.gOV);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.gOV, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.gPb.setVideoHeight(i4);
        this.gPb.setVideoWidth(i3);
        this.gPb.invalidate();
    }

    public void ub(String str) {
        if (this.gPa != null) {
            this.gPa.ua(str);
        }
    }

    public TextView bxz() {
        return this.dhV;
    }

    public TextView bxA() {
        return this.gPc;
    }

    public void bxB() {
        if (this.gPb != null && !StringUtils.isNull(this.gPd)) {
            this.gPb.start();
        }
    }

    public void bxC() {
        if (this.gPb != null && !StringUtils.isNull(this.gPd)) {
            this.gPb.resume();
            this.gPb.seekTo(this.gPl);
            if (this.gPp) {
                this.gPb.start();
            }
        }
    }

    public void aqR() {
        this.gPl = this.gPb.getCurrentPosition();
        if (this.gPb != null) {
            this.gPb.pause();
        }
    }

    public void aqS() {
        this.gPl = this.gPb.getCurrentPosition();
        if (this.gPb != null) {
            this.gPb.stopPlayback();
        }
    }

    public String bxD() {
        return this.gPd;
    }

    public d bxE() {
        return this.gPm;
    }

    private void bxF() {
        if (!v.w(this.gPn)) {
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
                        if (i2 >= c.this.gPn.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gPn.get(i2);
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
                            dVar.mV(true);
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
                    c.this.gPa.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gPa.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
