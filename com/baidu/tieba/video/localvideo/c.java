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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c {
    private TextView hlX;
    private RelativeLayout jJp;
    private LocalVideoActivity llW;
    private ExpandGridView lma;
    private a lmb;
    private CustomVideoView lmc;
    private TextView lmd;
    private String lme;
    private ImageView lmf;
    private ExpandViewRelativeLayout lmg;
    private FrameLayout lmh;
    private int lmi;
    private int lmj;
    private int lmk;
    private int lml;
    private int lmm;
    private d lmn;
    private List<d> lmo;
    private boolean lmp;
    private boolean lmq;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.lmp = false;
        this.lmq = true;
        this.llW = localVideoActivity;
        this.lmg = (ExpandViewRelativeLayout) this.llW.findViewById(R.id.container);
        this.lma = (ExpandGridView) this.llW.findViewById(R.id.local_video_gridview);
        this.jJp = (RelativeLayout) this.llW.findViewById(R.id.preview_videoview_container);
        this.lmf = (ImageView) this.llW.findViewById(R.id.video_cover);
        this.lmh = (FrameLayout) this.llW.findViewById(R.id.top_container);
        this.lmc = (CustomVideoView) this.llW.findViewById(R.id.preview_videoview);
        this.lmc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cW(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lmc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.lmp = true;
                c.this.lmc.stopPlayback();
                return false;
            }
        });
        this.hlX = (TextView) this.llW.findViewById(R.id.close_btn);
        this.lmd = (TextView) this.llW.findViewById(R.id.next_step_btn);
        this.lmd.setOnClickListener(onClickListener);
        this.hlX.setOnClickListener(onClickListener);
        this.lmb = new a(this.llW);
        this.lma.setAdapter((ListAdapter) this.lmb);
        this.lma.setSelector(new ColorDrawable(0));
        this.lma.setVerticalScrollBarEnabled(false);
        this.lma.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.lmp = false;
                    c.this.lmg.setIsCanLayout(true);
                    c.this.jJp.layout(c.this.jJp.getLeft(), 0, c.this.jJp.getRight(), c.this.lml);
                    c.this.lma.layout(c.this.lma.getLeft(), c.this.lml, c.this.lma.getRight(), c.this.lma.getBottom());
                    c.this.lmh.layout(c.this.lmh.getTop(), c.this.lmh.getLeft(), c.this.lmh.getRight(), c.this.lmh.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.lme) && c.this.lmc != null) {
                        c.this.lmc.setVisibility(8);
                        c.this.lmc.stopPlayback();
                        c.this.lmc.setVideoPath(dVar.getVideoPath());
                        c.this.lmc.setVisibility(0);
                        c.this.lme = dVar.getVideoPath();
                        c.this.lmn = dVar;
                        if (c.this.lmf != null) {
                            c.this.lmf.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.llW);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.lmf.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.lmc.start();
                    }
                }
            }
        });
        this.lmg.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aw(float f) {
                c.this.lmi = c.this.lma.getTop();
                c.this.lmj = c.this.jJp.getTop();
                c.this.lmk = c.this.lmg.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.lmg.setIsCanLayout(false);
                int i2 = (int) (c.this.lmi + f2);
                int i3 = i == 1 ? (int) (c.this.lmj + f2) : (int) (c.this.lmj + (f2 * 0.3d));
                if (i2 >= c.this.lmh.getBottom() && i2 <= l.getDimens(c.this.llW, R.dimen.ds902)) {
                    c.this.jJp.layout(c.this.jJp.getLeft(), i3, c.this.jJp.getRight(), c.this.lml + i3);
                    c.this.lma.layout(c.this.lma.getLeft(), i2, c.this.lma.getRight(), c.this.lma.getBottom());
                    if (i2 <= l.getDimens(c.this.llW, R.dimen.ds400)) {
                        c.this.lmq = false;
                        c.this.lmc.pause();
                    } else {
                        c.this.lmq = true;
                        c.this.lmc.start();
                    }
                    float dimens = (l.getDimens(c.this.llW, R.dimen.ds902) - i2) / l.getDimens(c.this.llW, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.lmf.setVisibility(8);
                        return;
                    }
                    c.this.lmf.setVisibility(0);
                    c.this.lmf.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void daO() {
                if (c.this.lma.getTop() > c.this.lmk / 2) {
                    c.this.lmq = true;
                    c.this.lmc.start();
                    c.this.lmf.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.jJp.getBottom(), c.this.lml);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jJp.layout(c.this.jJp.getLeft(), 0, c.this.jJp.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.lma.getTop(), c.this.lml);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lma.layout(c.this.lma.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lma.getRight(), c.this.lma.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.lmq = false;
                c.this.lmc.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.jJp.getBottom(), l.getDimens(c.this.llW, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.jJp.layout(c.this.jJp.getLeft(), intValue - c.this.lml, c.this.jJp.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.lma.getTop(), l.getDimens(c.this.llW, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.lma.layout(c.this.lma.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lma.getRight(), c.this.lma.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.lma.getTop() > c.this.lmh.getBottom() || c.this.lma.getFirstVisiblePosition() != 0 || c.this.lma.getChildCount() <= 0 || c.this.lma.getChildAt(0).getTop() < 0) {
                    if (c.this.lma.getTop() <= c.this.lmh.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.lml - l.getDimens(c.this.llW, R.dimen.ds20))) && f2 < ((float) (c.this.lml + l.getDimens(c.this.llW, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.lml = l.getDimens(this.llW, R.dimen.ds902);
    }

    public boolean dbU() {
        return this.lmp;
    }

    public void eG(List<d> list) {
        if (!v.isEmpty(list)) {
            this.lmo = list;
            d dVar = list.get(0);
            if (this.lmc != null) {
                this.lmc.setVideoPath(dVar.getVideoPath());
                this.lme = dVar.getVideoPath();
                this.lmn = dVar;
                if (this.lmf != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.llW);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.lmf.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.lmc.start();
            }
            if (this.lmb != null) {
                this.lmb.setData(list);
                dcb();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void dbV() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.llW).kc(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.llW.getPageContext());
        a.gF(false);
        a.aMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.llW) / l.getDimens(this.llW, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.llW);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.llW, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lmc.setVideoHeight(i4);
        this.lmc.setVideoWidth(i3);
        this.lmc.invalidate();
    }

    public void LV(String str) {
        if (this.lmb != null) {
            this.lmb.LU(str);
        }
    }

    public TextView dbW() {
        return this.hlX;
    }

    public TextView dbX() {
        return this.lmd;
    }

    public void startVideo() {
        if (this.lmc != null && !StringUtils.isNull(this.lme)) {
            this.lmc.start();
        }
    }

    public void dbY() {
        if (this.lmc != null && !StringUtils.isNull(this.lme)) {
            this.lmc.resume();
            this.lmc.seekTo(this.lmm);
            if (this.lmq) {
                this.lmc.start();
            }
        }
    }

    public void bQV() {
        this.lmm = this.lmc.getCurrentPosition();
        if (this.lmc != null) {
            this.lmc.pause();
        }
    }

    public void bQW() {
        this.lmm = this.lmc.getCurrentPosition();
        if (this.lmc != null) {
            this.lmc.stopPlayback();
        }
    }

    public String dbZ() {
        return this.lme;
    }

    public d dca() {
        return this.lmn;
    }

    private void dcb() {
        if (!v.isEmpty(this.lmo)) {
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
                        if (i2 >= c.this.lmo.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.lmo.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.f.b.toInt(extractMetadata, 0));
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
                                        matrix.postScale(150 / frameAtTime.getWidth(), ((int) ((150.0f * frameAtTime.getHeight()) / frameAtTime.getWidth())) / frameAtTime.getHeight());
                                        dVar.N(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.uy(true);
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
                public void onProgressUpdate(Integer... numArr) {
                    super.onProgressUpdate((Object[]) numArr);
                    c.this.lmb.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.lmb.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
