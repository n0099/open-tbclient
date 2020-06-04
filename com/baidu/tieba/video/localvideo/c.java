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
    private TextView hBy;
    private RelativeLayout kcg;
    private LocalVideoActivity lFP;
    private ExpandGridView lFT;
    private a lFU;
    private CustomVideoView lFV;
    private TextView lFW;
    private String lFX;
    private ImageView lFY;
    private ExpandViewRelativeLayout lFZ;
    private FrameLayout lGa;
    private int lGb;
    private int lGc;
    private int lGd;
    private int lGe;
    private int lGf;
    private d lGg;
    private List<d> lGh;
    private boolean lGi;
    private boolean lGj;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.lGi = false;
        this.lGj = true;
        this.lFP = localVideoActivity;
        this.lFZ = (ExpandViewRelativeLayout) this.lFP.findViewById(R.id.container);
        this.lFT = (ExpandGridView) this.lFP.findViewById(R.id.local_video_gridview);
        this.kcg = (RelativeLayout) this.lFP.findViewById(R.id.preview_videoview_container);
        this.lFY = (ImageView) this.lFP.findViewById(R.id.video_cover);
        this.lGa = (FrameLayout) this.lFP.findViewById(R.id.top_container);
        this.lFV = (CustomVideoView) this.lFP.findViewById(R.id.preview_videoview);
        this.lFV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.db(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lFV.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.lGi = true;
                c.this.lFV.stopPlayback();
                return false;
            }
        });
        this.hBy = (TextView) this.lFP.findViewById(R.id.close_btn);
        this.lFW = (TextView) this.lFP.findViewById(R.id.next_step_btn);
        this.lFW.setOnClickListener(onClickListener);
        this.hBy.setOnClickListener(onClickListener);
        this.lFU = new a(this.lFP);
        this.lFT.setAdapter((ListAdapter) this.lFU);
        this.lFT.setSelector(new ColorDrawable(0));
        this.lFT.setVerticalScrollBarEnabled(false);
        this.lFT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.lGi = false;
                    c.this.lFZ.setIsCanLayout(true);
                    c.this.kcg.layout(c.this.kcg.getLeft(), 0, c.this.kcg.getRight(), c.this.lGe);
                    c.this.lFT.layout(c.this.lFT.getLeft(), c.this.lGe, c.this.lFT.getRight(), c.this.lFT.getBottom());
                    c.this.lGa.layout(c.this.lGa.getTop(), c.this.lGa.getLeft(), c.this.lGa.getRight(), c.this.lGa.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.lFX) && c.this.lFV != null) {
                        c.this.lFV.setVisibility(8);
                        c.this.lFV.stopPlayback();
                        c.this.lFV.setVideoPath(dVar.getVideoPath());
                        c.this.lFV.setVisibility(0);
                        c.this.lFX = dVar.getVideoPath();
                        c.this.lGg = dVar;
                        if (c.this.lFY != null) {
                            c.this.lFY.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.lFP);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.lFY.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.lFV.start();
                    }
                }
            }
        });
        this.lFZ.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void av(float f) {
                c.this.lGb = c.this.lFT.getTop();
                c.this.lGc = c.this.kcg.getTop();
                c.this.lGd = c.this.lFZ.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.lFZ.setIsCanLayout(false);
                int i2 = (int) (c.this.lGb + f2);
                int i3 = i == 1 ? (int) (c.this.lGc + f2) : (int) (c.this.lGc + (f2 * 0.3d));
                if (i2 >= c.this.lGa.getBottom() && i2 <= l.getDimens(c.this.lFP, R.dimen.ds902)) {
                    c.this.kcg.layout(c.this.kcg.getLeft(), i3, c.this.kcg.getRight(), c.this.lGe + i3);
                    c.this.lFT.layout(c.this.lFT.getLeft(), i2, c.this.lFT.getRight(), c.this.lFT.getBottom());
                    if (i2 <= l.getDimens(c.this.lFP, R.dimen.ds400)) {
                        c.this.lGj = false;
                        c.this.lFV.pause();
                    } else {
                        c.this.lGj = true;
                        c.this.lFV.start();
                    }
                    float dimens = (l.getDimens(c.this.lFP, R.dimen.ds902) - i2) / l.getDimens(c.this.lFP, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.lFY.setVisibility(8);
                        return;
                    }
                    c.this.lFY.setVisibility(0);
                    c.this.lFY.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dis() {
                if (c.this.lFT.getTop() > c.this.lGd / 2) {
                    c.this.lGj = true;
                    c.this.lFV.start();
                    c.this.lFY.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.kcg.getBottom(), c.this.lGe);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kcg.layout(c.this.kcg.getLeft(), 0, c.this.kcg.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.lFT.getTop(), c.this.lGe);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lFT.layout(c.this.lFT.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lFT.getRight(), c.this.lFT.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.lGj = false;
                c.this.lFV.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.kcg.getBottom(), l.getDimens(c.this.lFP, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.kcg.layout(c.this.kcg.getLeft(), intValue - c.this.lGe, c.this.kcg.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.lFT.getTop(), l.getDimens(c.this.lFP, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.lFT.layout(c.this.lFT.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lFT.getRight(), c.this.lFT.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.lFT.getTop() > c.this.lGa.getBottom() || c.this.lFT.getFirstVisiblePosition() != 0 || c.this.lFT.getChildCount() <= 0 || c.this.lFT.getChildAt(0).getTop() < 0) {
                    if (c.this.lFT.getTop() <= c.this.lGa.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.lGe - l.getDimens(c.this.lFP, R.dimen.ds20))) && f2 < ((float) (c.this.lGe + l.getDimens(c.this.lFP, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.lGe = l.getDimens(this.lFP, R.dimen.ds902);
    }

    public boolean djy() {
        return this.lGi;
    }

    public void eP(List<d> list) {
        if (!v.isEmpty(list)) {
            this.lGh = list;
            d dVar = list.get(0);
            if (this.lFV != null) {
                this.lFV.setVideoPath(dVar.getVideoPath());
                this.lFX = dVar.getVideoPath();
                this.lGg = dVar;
                if (this.lFY != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.lFP);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.lFY.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.lFV.start();
            }
            if (this.lFU != null) {
                this.lFU.setData(list);
                djF();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void djz() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.lFP).kE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.lFP.getPageContext());
        a.gX(false);
        a.aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lFP) / l.getDimens(this.lFP, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.lFP);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lFP, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lFV.setVideoHeight(i4);
        this.lFV.setVideoWidth(i3);
        this.lFV.invalidate();
    }

    public void NJ(String str) {
        if (this.lFU != null) {
            this.lFU.NI(str);
        }
    }

    public TextView djA() {
        return this.hBy;
    }

    public TextView djB() {
        return this.lFW;
    }

    public void startVideo() {
        if (this.lFV != null && !StringUtils.isNull(this.lFX)) {
            this.lFV.start();
        }
    }

    public void djC() {
        if (this.lFV != null && !StringUtils.isNull(this.lFX)) {
            this.lFV.resume();
            this.lFV.seekTo(this.lGf);
            if (this.lGj) {
                this.lFV.start();
            }
        }
    }

    public void bXu() {
        this.lGf = this.lFV.getCurrentPosition();
        if (this.lFV != null) {
            this.lFV.pause();
        }
    }

    public void bXv() {
        this.lGf = this.lFV.getCurrentPosition();
        if (this.lFV != null) {
            this.lFV.stopPlayback();
        }
    }

    public String djD() {
        return this.lFX;
    }

    public d djE() {
        return this.lGg;
    }

    private void djF() {
        if (!v.isEmpty(this.lGh)) {
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
                        if (i2 >= c.this.lGh.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.lGh.get(i2);
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
                    c.this.lFU.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.lFU.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
