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
    private TextView hlR;
    private RelativeLayout jJl;
    private LocalVideoActivity llS;
    private ExpandGridView llW;
    private a llX;
    private CustomVideoView llY;
    private TextView llZ;
    private String lma;
    private ImageView lmb;
    private ExpandViewRelativeLayout lmc;
    private FrameLayout lmd;
    private int lme;
    private int lmf;
    private int lmg;
    private int lmh;
    private int lmi;
    private d lmj;
    private List<d> lmk;
    private boolean lml;
    private boolean lmm;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.lml = false;
        this.lmm = true;
        this.llS = localVideoActivity;
        this.lmc = (ExpandViewRelativeLayout) this.llS.findViewById(R.id.container);
        this.llW = (ExpandGridView) this.llS.findViewById(R.id.local_video_gridview);
        this.jJl = (RelativeLayout) this.llS.findViewById(R.id.preview_videoview_container);
        this.lmb = (ImageView) this.llS.findViewById(R.id.video_cover);
        this.lmd = (FrameLayout) this.llS.findViewById(R.id.top_container);
        this.llY = (CustomVideoView) this.llS.findViewById(R.id.preview_videoview);
        this.llY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cW(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.llY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.lml = true;
                c.this.llY.stopPlayback();
                return false;
            }
        });
        this.hlR = (TextView) this.llS.findViewById(R.id.close_btn);
        this.llZ = (TextView) this.llS.findViewById(R.id.next_step_btn);
        this.llZ.setOnClickListener(onClickListener);
        this.hlR.setOnClickListener(onClickListener);
        this.llX = new a(this.llS);
        this.llW.setAdapter((ListAdapter) this.llX);
        this.llW.setSelector(new ColorDrawable(0));
        this.llW.setVerticalScrollBarEnabled(false);
        this.llW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.lml = false;
                    c.this.lmc.setIsCanLayout(true);
                    c.this.jJl.layout(c.this.jJl.getLeft(), 0, c.this.jJl.getRight(), c.this.lmh);
                    c.this.llW.layout(c.this.llW.getLeft(), c.this.lmh, c.this.llW.getRight(), c.this.llW.getBottom());
                    c.this.lmd.layout(c.this.lmd.getTop(), c.this.lmd.getLeft(), c.this.lmd.getRight(), c.this.lmd.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.lma) && c.this.llY != null) {
                        c.this.llY.setVisibility(8);
                        c.this.llY.stopPlayback();
                        c.this.llY.setVideoPath(dVar.getVideoPath());
                        c.this.llY.setVisibility(0);
                        c.this.lma = dVar.getVideoPath();
                        c.this.lmj = dVar;
                        if (c.this.lmb != null) {
                            c.this.lmb.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.llS);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.lmb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.llY.start();
                    }
                }
            }
        });
        this.lmc.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aw(float f) {
                c.this.lme = c.this.llW.getTop();
                c.this.lmf = c.this.jJl.getTop();
                c.this.lmg = c.this.lmc.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.lmc.setIsCanLayout(false);
                int i2 = (int) (c.this.lme + f2);
                int i3 = i == 1 ? (int) (c.this.lmf + f2) : (int) (c.this.lmf + (f2 * 0.3d));
                if (i2 >= c.this.lmd.getBottom() && i2 <= l.getDimens(c.this.llS, R.dimen.ds902)) {
                    c.this.jJl.layout(c.this.jJl.getLeft(), i3, c.this.jJl.getRight(), c.this.lmh + i3);
                    c.this.llW.layout(c.this.llW.getLeft(), i2, c.this.llW.getRight(), c.this.llW.getBottom());
                    if (i2 <= l.getDimens(c.this.llS, R.dimen.ds400)) {
                        c.this.lmm = false;
                        c.this.llY.pause();
                    } else {
                        c.this.lmm = true;
                        c.this.llY.start();
                    }
                    float dimens = (l.getDimens(c.this.llS, R.dimen.ds902) - i2) / l.getDimens(c.this.llS, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.lmb.setVisibility(8);
                        return;
                    }
                    c.this.lmb.setVisibility(0);
                    c.this.lmb.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void daR() {
                if (c.this.llW.getTop() > c.this.lmg / 2) {
                    c.this.lmm = true;
                    c.this.llY.start();
                    c.this.lmb.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.jJl.getBottom(), c.this.lmh);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jJl.layout(c.this.jJl.getLeft(), 0, c.this.jJl.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.llW.getTop(), c.this.lmh);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.llW.layout(c.this.llW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.llW.getRight(), c.this.llW.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.lmm = false;
                c.this.llY.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.jJl.getBottom(), l.getDimens(c.this.llS, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.jJl.layout(c.this.jJl.getLeft(), intValue - c.this.lmh, c.this.jJl.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.llW.getTop(), l.getDimens(c.this.llS, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.llW.layout(c.this.llW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.llW.getRight(), c.this.llW.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.llW.getTop() > c.this.lmd.getBottom() || c.this.llW.getFirstVisiblePosition() != 0 || c.this.llW.getChildCount() <= 0 || c.this.llW.getChildAt(0).getTop() < 0) {
                    if (c.this.llW.getTop() <= c.this.lmd.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.lmh - l.getDimens(c.this.llS, R.dimen.ds20))) && f2 < ((float) (c.this.lmh + l.getDimens(c.this.llS, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.lmh = l.getDimens(this.llS, R.dimen.ds902);
    }

    public boolean dbX() {
        return this.lml;
    }

    public void eG(List<d> list) {
        if (!v.isEmpty(list)) {
            this.lmk = list;
            d dVar = list.get(0);
            if (this.llY != null) {
                this.llY.setVideoPath(dVar.getVideoPath());
                this.lma = dVar.getVideoPath();
                this.lmj = dVar;
                if (this.lmb != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.llS);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.lmb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.llY.start();
            }
            if (this.llX != null) {
                this.llX.setData(list);
                dce();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void dbY() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.llS).kc(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.llS.getPageContext());
        a.gF(false);
        a.aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.llS) / l.getDimens(this.llS, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.llS);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.llS, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.llY.setVideoHeight(i4);
        this.llY.setVideoWidth(i3);
        this.llY.invalidate();
    }

    public void LS(String str) {
        if (this.llX != null) {
            this.llX.LR(str);
        }
    }

    public TextView dbZ() {
        return this.hlR;
    }

    public TextView dca() {
        return this.llZ;
    }

    public void startVideo() {
        if (this.llY != null && !StringUtils.isNull(this.lma)) {
            this.llY.start();
        }
    }

    public void dcb() {
        if (this.llY != null && !StringUtils.isNull(this.lma)) {
            this.llY.resume();
            this.llY.seekTo(this.lmi);
            if (this.lmm) {
                this.llY.start();
            }
        }
    }

    public void bQX() {
        this.lmi = this.llY.getCurrentPosition();
        if (this.llY != null) {
            this.llY.pause();
        }
    }

    public void bQY() {
        this.lmi = this.llY.getCurrentPosition();
        if (this.llY != null) {
            this.llY.stopPlayback();
        }
    }

    public String dcc() {
        return this.lma;
    }

    public d dcd() {
        return this.lmj;
    }

    private void dce() {
        if (!v.isEmpty(this.lmk)) {
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
                        if (i2 >= c.this.lmk.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.lmk.get(i2);
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
                    c.this.llX.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.llX.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
