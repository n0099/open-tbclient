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
    private TextView hAL;
    private RelativeLayout kba;
    private LocalVideoActivity lEG;
    private ExpandGridView lEK;
    private a lEL;
    private CustomVideoView lEM;
    private TextView lEN;
    private String lEO;
    private ImageView lEP;
    private ExpandViewRelativeLayout lEQ;
    private FrameLayout lER;
    private int lES;
    private int lET;
    private int lEU;
    private int lEV;
    private int lEW;
    private d lEX;
    private List<d> lEY;
    private boolean lEZ;
    private boolean lFa;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.lEZ = false;
        this.lFa = true;
        this.lEG = localVideoActivity;
        this.lEQ = (ExpandViewRelativeLayout) this.lEG.findViewById(R.id.container);
        this.lEK = (ExpandGridView) this.lEG.findViewById(R.id.local_video_gridview);
        this.kba = (RelativeLayout) this.lEG.findViewById(R.id.preview_videoview_container);
        this.lEP = (ImageView) this.lEG.findViewById(R.id.video_cover);
        this.lER = (FrameLayout) this.lEG.findViewById(R.id.top_container);
        this.lEM = (CustomVideoView) this.lEG.findViewById(R.id.preview_videoview);
        this.lEM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.db(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lEM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.lEZ = true;
                c.this.lEM.stopPlayback();
                return false;
            }
        });
        this.hAL = (TextView) this.lEG.findViewById(R.id.close_btn);
        this.lEN = (TextView) this.lEG.findViewById(R.id.next_step_btn);
        this.lEN.setOnClickListener(onClickListener);
        this.hAL.setOnClickListener(onClickListener);
        this.lEL = new a(this.lEG);
        this.lEK.setAdapter((ListAdapter) this.lEL);
        this.lEK.setSelector(new ColorDrawable(0));
        this.lEK.setVerticalScrollBarEnabled(false);
        this.lEK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.lEZ = false;
                    c.this.lEQ.setIsCanLayout(true);
                    c.this.kba.layout(c.this.kba.getLeft(), 0, c.this.kba.getRight(), c.this.lEV);
                    c.this.lEK.layout(c.this.lEK.getLeft(), c.this.lEV, c.this.lEK.getRight(), c.this.lEK.getBottom());
                    c.this.lER.layout(c.this.lER.getTop(), c.this.lER.getLeft(), c.this.lER.getRight(), c.this.lER.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.lEO) && c.this.lEM != null) {
                        c.this.lEM.setVisibility(8);
                        c.this.lEM.stopPlayback();
                        c.this.lEM.setVideoPath(dVar.getVideoPath());
                        c.this.lEM.setVisibility(0);
                        c.this.lEO = dVar.getVideoPath();
                        c.this.lEX = dVar;
                        if (c.this.lEP != null) {
                            c.this.lEP.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.lEG);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.lEP.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.lEM.start();
                    }
                }
            }
        });
        this.lEQ.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void av(float f) {
                c.this.lES = c.this.lEK.getTop();
                c.this.lET = c.this.kba.getTop();
                c.this.lEU = c.this.lEQ.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.lEQ.setIsCanLayout(false);
                int i2 = (int) (c.this.lES + f2);
                int i3 = i == 1 ? (int) (c.this.lET + f2) : (int) (c.this.lET + (f2 * 0.3d));
                if (i2 >= c.this.lER.getBottom() && i2 <= l.getDimens(c.this.lEG, R.dimen.ds902)) {
                    c.this.kba.layout(c.this.kba.getLeft(), i3, c.this.kba.getRight(), c.this.lEV + i3);
                    c.this.lEK.layout(c.this.lEK.getLeft(), i2, c.this.lEK.getRight(), c.this.lEK.getBottom());
                    if (i2 <= l.getDimens(c.this.lEG, R.dimen.ds400)) {
                        c.this.lFa = false;
                        c.this.lEM.pause();
                    } else {
                        c.this.lFa = true;
                        c.this.lEM.start();
                    }
                    float dimens = (l.getDimens(c.this.lEG, R.dimen.ds902) - i2) / l.getDimens(c.this.lEG, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.lEP.setVisibility(8);
                        return;
                    }
                    c.this.lEP.setVisibility(0);
                    c.this.lEP.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void did() {
                if (c.this.lEK.getTop() > c.this.lEU / 2) {
                    c.this.lFa = true;
                    c.this.lEM.start();
                    c.this.lEP.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.kba.getBottom(), c.this.lEV);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kba.layout(c.this.kba.getLeft(), 0, c.this.kba.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.lEK.getTop(), c.this.lEV);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lEK.layout(c.this.lEK.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lEK.getRight(), c.this.lEK.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.lFa = false;
                c.this.lEM.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.kba.getBottom(), l.getDimens(c.this.lEG, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.kba.layout(c.this.kba.getLeft(), intValue - c.this.lEV, c.this.kba.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.lEK.getTop(), l.getDimens(c.this.lEG, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.lEK.layout(c.this.lEK.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lEK.getRight(), c.this.lEK.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.lEK.getTop() > c.this.lER.getBottom() || c.this.lEK.getFirstVisiblePosition() != 0 || c.this.lEK.getChildCount() <= 0 || c.this.lEK.getChildAt(0).getTop() < 0) {
                    if (c.this.lEK.getTop() <= c.this.lER.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.lEV - l.getDimens(c.this.lEG, R.dimen.ds20))) && f2 < ((float) (c.this.lEV + l.getDimens(c.this.lEG, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.lEV = l.getDimens(this.lEG, R.dimen.ds902);
    }

    public boolean djj() {
        return this.lEZ;
    }

    public void eN(List<d> list) {
        if (!v.isEmpty(list)) {
            this.lEY = list;
            d dVar = list.get(0);
            if (this.lEM != null) {
                this.lEM.setVideoPath(dVar.getVideoPath());
                this.lEO = dVar.getVideoPath();
                this.lEX = dVar;
                if (this.lEP != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.lEG);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.lEP.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.lEM.start();
            }
            if (this.lEL != null) {
                this.lEL.setData(list);
                djq();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void djk() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.lEG).kC(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.lEG.getPageContext());
        a.gX(false);
        a.aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lEG) / l.getDimens(this.lEG, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.lEG);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lEG, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lEM.setVideoHeight(i4);
        this.lEM.setVideoWidth(i3);
        this.lEM.invalidate();
    }

    public void NI(String str) {
        if (this.lEL != null) {
            this.lEL.NH(str);
        }
    }

    public TextView djl() {
        return this.hAL;
    }

    public TextView djm() {
        return this.lEN;
    }

    public void startVideo() {
        if (this.lEM != null && !StringUtils.isNull(this.lEO)) {
            this.lEM.start();
        }
    }

    public void djn() {
        if (this.lEM != null && !StringUtils.isNull(this.lEO)) {
            this.lEM.resume();
            this.lEM.seekTo(this.lEW);
            if (this.lFa) {
                this.lEM.start();
            }
        }
    }

    public void bXs() {
        this.lEW = this.lEM.getCurrentPosition();
        if (this.lEM != null) {
            this.lEM.pause();
        }
    }

    public void bXt() {
        this.lEW = this.lEM.getCurrentPosition();
        if (this.lEM != null) {
            this.lEM.stopPlayback();
        }
    }

    public String djo() {
        return this.lEO;
    }

    public d djp() {
        return this.lEX;
    }

    private void djq() {
        if (!v.isEmpty(this.lEY)) {
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
                        if (i2 >= c.this.lEY.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.lEY.get(i2);
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
                                        dVar.P(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.uW(true);
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
                    c.this.lEL.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.lEL.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
