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
    private TextView dPq;
    private RelativeLayout gbZ;
    private FrameLayout htA;
    private int htB;
    private int htC;
    private int htD;
    private int htE;
    private int htF;
    private d htG;
    private List<d> htH;
    private boolean htI;
    private boolean htJ;
    private LocalVideoActivity htp;
    private ExpandGridView htt;
    private a htu;
    private CustomVideoView htv;
    private TextView htw;
    private String htx;
    private ImageView hty;
    private ExpandViewRelativeLayout htz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.htI = false;
        this.htJ = true;
        this.htp = localVideoActivity;
        this.htz = (ExpandViewRelativeLayout) this.htp.findViewById(d.g.container);
        this.htt = (ExpandGridView) this.htp.findViewById(d.g.local_video_gridview);
        this.gbZ = (RelativeLayout) this.htp.findViewById(d.g.preview_videoview_container);
        this.hty = (ImageView) this.htp.findViewById(d.g.video_cover);
        this.htA = (FrameLayout) this.htp.findViewById(d.g.top_container);
        this.htv = (CustomVideoView) this.htp.findViewById(d.g.preview_videoview);
        this.htv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.htv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.htI = true;
                c.this.htv.stopPlayback();
                return false;
            }
        });
        this.dPq = (TextView) this.htp.findViewById(d.g.close_btn);
        this.htw = (TextView) this.htp.findViewById(d.g.next_step_btn);
        this.htw.setOnClickListener(onClickListener);
        this.dPq.setOnClickListener(onClickListener);
        this.htu = new a(this.htp);
        this.htt.setAdapter((ListAdapter) this.htu);
        this.htt.setSelector(new ColorDrawable(0));
        this.htt.setVerticalScrollBarEnabled(false);
        this.htt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.htI = false;
                    c.this.htz.setIsCanLayout(true);
                    c.this.gbZ.layout(c.this.gbZ.getLeft(), 0, c.this.gbZ.getRight(), c.this.htE);
                    c.this.htt.layout(c.this.htt.getLeft(), c.this.htE, c.this.htt.getRight(), c.this.htt.getBottom());
                    c.this.htA.layout(c.this.htA.getTop(), c.this.htA.getLeft(), c.this.htA.getRight(), c.this.htA.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.htx) && c.this.htv != null) {
                        c.this.htv.setVisibility(8);
                        c.this.htv.stopPlayback();
                        c.this.htv.setVideoPath(dVar.getVideoPath());
                        c.this.htv.setVisibility(0);
                        c.this.htx = dVar.getVideoPath();
                        c.this.htG = dVar;
                        if (c.this.hty != null) {
                            c.this.hty.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.htp);
                            blurDrawable.init(12, 8, dVar.bCB());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hty.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.htv.start();
                    }
                }
            }
        });
        this.htz.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aG(float f) {
                c.this.htB = c.this.htt.getTop();
                c.this.htC = c.this.gbZ.getTop();
                c.this.htD = c.this.htz.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.htz.setIsCanLayout(false);
                int i2 = (int) (c.this.htB + f2);
                int i3 = i == 1 ? (int) (c.this.htC + f2) : (int) (c.this.htC + (f2 * 0.3d));
                if (i2 >= c.this.htA.getBottom() && i2 <= l.t(c.this.htp, d.e.ds902)) {
                    c.this.gbZ.layout(c.this.gbZ.getLeft(), i3, c.this.gbZ.getRight(), c.this.htE + i3);
                    c.this.htt.layout(c.this.htt.getLeft(), i2, c.this.htt.getRight(), c.this.htt.getBottom());
                    if (i2 <= l.t(c.this.htp, d.e.ds400)) {
                        c.this.htJ = false;
                        c.this.htv.pause();
                    } else {
                        c.this.htJ = true;
                        c.this.htv.start();
                    }
                    float t = (l.t(c.this.htp, d.e.ds902) - i2) / l.t(c.this.htp, d.e.ds902);
                    if (t == 0.0f) {
                        c.this.hty.setVisibility(8);
                        return;
                    }
                    c.this.hty.setVisibility(0);
                    c.this.hty.setAlpha(t);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bBg() {
                if (c.this.htt.getTop() > c.this.htD / 2) {
                    c.this.htJ = true;
                    c.this.htv.start();
                    c.this.hty.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.gbZ.getBottom(), c.this.htE);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gbZ.layout(c.this.gbZ.getLeft(), 0, c.this.gbZ.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.htt.getTop(), c.this.htE);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.htt.layout(c.this.htt.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.htt.getRight(), c.this.htt.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.htJ = false;
                c.this.htv.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.gbZ.getBottom(), l.t(c.this.htp, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.gbZ.layout(c.this.gbZ.getLeft(), intValue - c.this.htE, c.this.gbZ.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.htt.getTop(), l.t(c.this.htp, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.htt.layout(c.this.htt.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.htt.getRight(), c.this.htt.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.htt.getTop() > c.this.htA.getBottom() || c.this.htt.getFirstVisiblePosition() != 0 || c.this.htt.getChildCount() <= 0 || c.this.htt.getChildAt(0).getTop() < 0) {
                    if (c.this.htt.getTop() <= c.this.htA.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.htE - l.t(c.this.htp, d.e.ds20))) && f2 < ((float) (c.this.htE + l.t(c.this.htp, d.e.ds20)));
                }
                return true;
            }
        });
        this.htE = l.t(this.htp, d.e.ds902);
    }

    public boolean bCs() {
        return this.htI;
    }

    public void dL(List<d> list) {
        if (!v.E(list)) {
            this.htH = list;
            d dVar = list.get(0);
            if (this.htv != null) {
                this.htv.setVideoPath(dVar.getVideoPath());
                this.htx = dVar.getVideoPath();
                this.htG = dVar;
                if (this.hty != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.htp);
                    blurDrawable.init(12, 8, dVar.bCB());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hty.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.htv.start();
            }
            if (this.htu != null) {
                this.htu.setData(list);
                bCA();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bCt() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.htp).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.htp.getPageContext());
        a.ba(false);
        a.AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.htp) / l.t(this.htp, d.e.ds902)) {
            i3 = l.ao(this.htp);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int t = l.t(this.htp, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((t / i2) * i);
                i4 = t;
            } else {
                i3 = 0;
                i4 = t;
            }
        }
        this.htv.setVideoHeight(i4);
        this.htv.setVideoWidth(i3);
        this.htv.invalidate();
    }

    public void tU(String str) {
        if (this.htu != null) {
            this.htu.tT(str);
        }
    }

    public TextView bCu() {
        return this.dPq;
    }

    public TextView bCv() {
        return this.htw;
    }

    public void bCw() {
        if (this.htv != null && !StringUtils.isNull(this.htx)) {
            this.htv.start();
        }
    }

    public void bCx() {
        if (this.htv != null && !StringUtils.isNull(this.htx)) {
            this.htv.resume();
            this.htv.seekTo(this.htF);
            if (this.htJ) {
                this.htv.start();
            }
        }
    }

    public void awy() {
        this.htF = this.htv.getCurrentPosition();
        if (this.htv != null) {
            this.htv.pause();
        }
    }

    public void awz() {
        this.htF = this.htv.getCurrentPosition();
        if (this.htv != null) {
            this.htv.stopPlayback();
        }
    }

    public String bCy() {
        return this.htx;
    }

    public d bCz() {
        return this.htG;
    }

    private void bCA() {
        if (!v.E(this.htH)) {
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
                        if (i2 >= c.this.htH.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.htH.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.h(extractMetadata, 0));
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
                                        dVar.A(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.nt(true);
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
                    c.this.htu.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.htu.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
