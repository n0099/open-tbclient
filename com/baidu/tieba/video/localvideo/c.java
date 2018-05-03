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
    private TextView dhS;
    private RelativeLayout fwf;
    private LocalVideoActivity gOS;
    private ExpandGridView gOW;
    private a gOX;
    private CustomVideoView gOY;
    private TextView gOZ;
    private String gPa;
    private ImageView gPb;
    private ExpandViewRelativeLayout gPc;
    private FrameLayout gPd;
    private int gPe;
    private int gPf;
    private int gPg;
    private int gPh;
    private int gPi;
    private d gPj;
    private List<d> gPk;
    private boolean gPl;
    private boolean gPm;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gPl = false;
        this.gPm = true;
        this.gOS = localVideoActivity;
        this.gPc = (ExpandViewRelativeLayout) this.gOS.findViewById(d.g.container);
        this.gOW = (ExpandGridView) this.gOS.findViewById(d.g.local_video_gridview);
        this.fwf = (RelativeLayout) this.gOS.findViewById(d.g.preview_videoview_container);
        this.gPb = (ImageView) this.gOS.findViewById(d.g.video_cover);
        this.gPd = (FrameLayout) this.gOS.findViewById(d.g.top_container);
        this.gOY = (CustomVideoView) this.gOS.findViewById(d.g.preview_videoview);
        this.gOY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gOY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.gPl = true;
                c.this.gOY.stopPlayback();
                return false;
            }
        });
        this.dhS = (TextView) this.gOS.findViewById(d.g.close_btn);
        this.gOZ = (TextView) this.gOS.findViewById(d.g.next_step_btn);
        this.gOZ.setOnClickListener(onClickListener);
        this.dhS.setOnClickListener(onClickListener);
        this.gOX = new a(this.gOS);
        this.gOW.setAdapter((ListAdapter) this.gOX);
        this.gOW.setSelector(new ColorDrawable(0));
        this.gOW.setVerticalScrollBarEnabled(false);
        this.gOW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gPl = false;
                    c.this.gPc.setIsCanLayout(true);
                    c.this.fwf.layout(c.this.fwf.getLeft(), 0, c.this.fwf.getRight(), c.this.gPh);
                    c.this.gOW.layout(c.this.gOW.getLeft(), c.this.gPh, c.this.gOW.getRight(), c.this.gOW.getBottom());
                    c.this.gPd.layout(c.this.gPd.getTop(), c.this.gPd.getLeft(), c.this.gPd.getRight(), c.this.gPd.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gPa) && c.this.gOY != null) {
                        c.this.gOY.setVisibility(8);
                        c.this.gOY.stopPlayback();
                        c.this.gOY.setVideoPath(dVar.getVideoPath());
                        c.this.gOY.setVisibility(0);
                        c.this.gPa = dVar.getVideoPath();
                        c.this.gPj = dVar;
                        if (c.this.gPb != null) {
                            c.this.gPb.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gOS);
                            blurDrawable.init(12, 8, dVar.bxG());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gPb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gOY.start();
                    }
                }
            }
        });
        this.gPc.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void au(float f) {
                c.this.gPe = c.this.gOW.getTop();
                c.this.gPf = c.this.fwf.getTop();
                c.this.gPg = c.this.gPc.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.gPc.setIsCanLayout(false);
                int i2 = (int) (c.this.gPe + f2);
                int i3 = i == 1 ? (int) (c.this.gPf + f2) : (int) (c.this.gPf + (f2 * 0.3d));
                if (i2 >= c.this.gPd.getBottom() && i2 <= l.e(c.this.gOS, d.e.ds902)) {
                    c.this.fwf.layout(c.this.fwf.getLeft(), i3, c.this.fwf.getRight(), c.this.gPh + i3);
                    c.this.gOW.layout(c.this.gOW.getLeft(), i2, c.this.gOW.getRight(), c.this.gOW.getBottom());
                    if (i2 <= l.e(c.this.gOS, d.e.ds400)) {
                        c.this.gPm = false;
                        c.this.gOY.pause();
                    } else {
                        c.this.gPm = true;
                        c.this.gOY.start();
                    }
                    float e = (l.e(c.this.gOS, d.e.ds902) - i2) / l.e(c.this.gOS, d.e.ds902);
                    if (e == 0.0f) {
                        c.this.gPb.setVisibility(8);
                        return;
                    }
                    c.this.gPb.setVisibility(0);
                    c.this.gPb.setAlpha(e);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bwl() {
                if (c.this.gOW.getTop() > c.this.gPg / 2) {
                    c.this.gPm = true;
                    c.this.gOY.start();
                    c.this.gPb.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fwf.getBottom(), c.this.gPh);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fwf.layout(c.this.fwf.getLeft(), 0, c.this.fwf.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gOW.getTop(), c.this.gPh);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gOW.layout(c.this.gOW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gOW.getRight(), c.this.gOW.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.gPm = false;
                c.this.gOY.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fwf.getBottom(), l.e(c.this.gOS, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fwf.layout(c.this.fwf.getLeft(), intValue - c.this.gPh, c.this.fwf.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gOW.getTop(), l.e(c.this.gOS, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gOW.layout(c.this.gOW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gOW.getRight(), c.this.gOW.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.gOW.getTop() > c.this.gPd.getBottom() || c.this.gOW.getFirstVisiblePosition() != 0 || c.this.gOW.getChildCount() <= 0 || c.this.gOW.getChildAt(0).getTop() < 0) {
                    if (c.this.gOW.getTop() <= c.this.gPd.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gPh - l.e(c.this.gOS, d.e.ds20))) && f2 < ((float) (c.this.gPh + l.e(c.this.gOS, d.e.ds20)));
                }
                return true;
            }
        });
        this.gPh = l.e(this.gOS, d.e.ds902);
    }

    public boolean bxx() {
        return this.gPl;
    }

    public void dC(List<d> list) {
        if (!v.w(list)) {
            this.gPk = list;
            d dVar = list.get(0);
            if (this.gOY != null) {
                this.gOY.setVideoPath(dVar.getVideoPath());
                this.gPa = dVar.getVideoPath();
                this.gPj = dVar;
                if (this.gPb != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gOS);
                    blurDrawable.init(12, 8, dVar.bxG());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gPb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gOY.start();
            }
            if (this.gOX != null) {
                this.gOX.setData(list);
                bxF();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.k.no_local_video_tip);
    }

    public void bxy() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gOS).bY(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gOS.getPageContext());
        a.as(false);
        a.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.gOS) / l.e(this.gOS, d.e.ds902)) {
            i3 = l.af(this.gOS);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.gOS, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.gOY.setVideoHeight(i4);
        this.gOY.setVideoWidth(i3);
        this.gOY.invalidate();
    }

    public void ub(String str) {
        if (this.gOX != null) {
            this.gOX.ua(str);
        }
    }

    public TextView bxz() {
        return this.dhS;
    }

    public TextView bxA() {
        return this.gOZ;
    }

    public void bxB() {
        if (this.gOY != null && !StringUtils.isNull(this.gPa)) {
            this.gOY.start();
        }
    }

    public void bxC() {
        if (this.gOY != null && !StringUtils.isNull(this.gPa)) {
            this.gOY.resume();
            this.gOY.seekTo(this.gPi);
            if (this.gPm) {
                this.gOY.start();
            }
        }
    }

    public void aqR() {
        this.gPi = this.gOY.getCurrentPosition();
        if (this.gOY != null) {
            this.gOY.pause();
        }
    }

    public void aqS() {
        this.gPi = this.gOY.getCurrentPosition();
        if (this.gOY != null) {
            this.gOY.stopPlayback();
        }
    }

    public String bxD() {
        return this.gPa;
    }

    public d bxE() {
        return this.gPj;
    }

    private void bxF() {
        if (!v.w(this.gPk)) {
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
                        if (i2 >= c.this.gPk.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gPk.get(i2);
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
                    c.this.gOX.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gOX.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
