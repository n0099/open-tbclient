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
    private TextView gCv;
    private RelativeLayout iZd;
    private ExpandGridView kBD;
    private a kBE;
    private CustomVideoView kBF;
    private TextView kBG;
    private String kBH;
    private ImageView kBI;
    private ExpandViewRelativeLayout kBJ;
    private FrameLayout kBK;
    private int kBL;
    private int kBM;
    private int kBN;
    private int kBO;
    private int kBP;
    private d kBQ;
    private List<d> kBR;
    private boolean kBS;
    private boolean kBT;
    private LocalVideoActivity kBz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.kBS = false;
        this.kBT = true;
        this.kBz = localVideoActivity;
        this.kBJ = (ExpandViewRelativeLayout) this.kBz.findViewById(R.id.container);
        this.kBD = (ExpandGridView) this.kBz.findViewById(R.id.local_video_gridview);
        this.iZd = (RelativeLayout) this.kBz.findViewById(R.id.preview_videoview_container);
        this.kBI = (ImageView) this.kBz.findViewById(R.id.video_cover);
        this.kBK = (FrameLayout) this.kBz.findViewById(R.id.top_container);
        this.kBF = (CustomVideoView) this.kBz.findViewById(R.id.preview_videoview);
        this.kBF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cR(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kBF.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.kBS = true;
                c.this.kBF.stopPlayback();
                return false;
            }
        });
        this.gCv = (TextView) this.kBz.findViewById(R.id.close_btn);
        this.kBG = (TextView) this.kBz.findViewById(R.id.next_step_btn);
        this.kBG.setOnClickListener(onClickListener);
        this.gCv.setOnClickListener(onClickListener);
        this.kBE = new a(this.kBz);
        this.kBD.setAdapter((ListAdapter) this.kBE);
        this.kBD.setSelector(new ColorDrawable(0));
        this.kBD.setVerticalScrollBarEnabled(false);
        this.kBD.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.kBS = false;
                    c.this.kBJ.setIsCanLayout(true);
                    c.this.iZd.layout(c.this.iZd.getLeft(), 0, c.this.iZd.getRight(), c.this.kBO);
                    c.this.kBD.layout(c.this.kBD.getLeft(), c.this.kBO, c.this.kBD.getRight(), c.this.kBD.getBottom());
                    c.this.kBK.layout(c.this.kBK.getTop(), c.this.kBK.getLeft(), c.this.kBK.getRight(), c.this.kBK.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.kBH) && c.this.kBF != null) {
                        c.this.kBF.setVisibility(8);
                        c.this.kBF.stopPlayback();
                        c.this.kBF.setVideoPath(dVar.getVideoPath());
                        c.this.kBF.setVisibility(0);
                        c.this.kBH = dVar.getVideoPath();
                        c.this.kBQ = dVar;
                        if (c.this.kBI != null) {
                            c.this.kBI.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.kBz);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.kBI.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.kBF.start();
                    }
                }
            }
        });
        this.kBJ.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aM(float f) {
                c.this.kBL = c.this.kBD.getTop();
                c.this.kBM = c.this.iZd.getTop();
                c.this.kBN = c.this.kBJ.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.kBJ.setIsCanLayout(false);
                int i2 = (int) (c.this.kBL + f2);
                int i3 = i == 1 ? (int) (c.this.kBM + f2) : (int) (c.this.kBM + (f2 * 0.3d));
                if (i2 >= c.this.kBK.getBottom() && i2 <= l.getDimens(c.this.kBz, R.dimen.ds902)) {
                    c.this.iZd.layout(c.this.iZd.getLeft(), i3, c.this.iZd.getRight(), c.this.kBO + i3);
                    c.this.kBD.layout(c.this.kBD.getLeft(), i2, c.this.kBD.getRight(), c.this.kBD.getBottom());
                    if (i2 <= l.getDimens(c.this.kBz, R.dimen.ds400)) {
                        c.this.kBT = false;
                        c.this.kBF.pause();
                    } else {
                        c.this.kBT = true;
                        c.this.kBF.start();
                    }
                    float dimens = (l.getDimens(c.this.kBz, R.dimen.ds902) - i2) / l.getDimens(c.this.kBz, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.kBI.setVisibility(8);
                        return;
                    }
                    c.this.kBI.setVisibility(0);
                    c.this.kBI.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cPV() {
                if (c.this.kBD.getTop() > c.this.kBN / 2) {
                    c.this.kBT = true;
                    c.this.kBF.start();
                    c.this.kBI.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iZd.getBottom(), c.this.kBO);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iZd.layout(c.this.iZd.getLeft(), 0, c.this.iZd.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.kBD.getTop(), c.this.kBO);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kBD.layout(c.this.kBD.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kBD.getRight(), c.this.kBD.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.kBT = false;
                c.this.kBF.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iZd.getBottom(), l.getDimens(c.this.kBz, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iZd.layout(c.this.iZd.getLeft(), intValue - c.this.kBO, c.this.iZd.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.kBD.getTop(), l.getDimens(c.this.kBz, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.kBD.layout(c.this.kBD.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kBD.getRight(), c.this.kBD.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.kBD.getTop() > c.this.kBK.getBottom() || c.this.kBD.getFirstVisiblePosition() != 0 || c.this.kBD.getChildCount() <= 0 || c.this.kBD.getChildAt(0).getTop() < 0) {
                    if (c.this.kBD.getTop() <= c.this.kBK.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.kBO - l.getDimens(c.this.kBz, R.dimen.ds20))) && f2 < ((float) (c.this.kBO + l.getDimens(c.this.kBz, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.kBO = l.getDimens(this.kBz, R.dimen.ds902);
    }

    public boolean cRa() {
        return this.kBS;
    }

    public void er(List<d> list) {
        if (!v.isEmpty(list)) {
            this.kBR = list;
            d dVar = list.get(0);
            if (this.kBF != null) {
                this.kBF.setVideoPath(dVar.getVideoPath());
                this.kBH = dVar.getVideoPath();
                this.kBQ = dVar;
                if (this.kBI != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.kBz);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.kBI.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.kBF.start();
            }
            if (this.kBE != null) {
                this.kBE.setData(list);
                cRh();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cRb() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.kBz).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.kBz.getPageContext());
        a.fI(false);
        a.aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kBz) / l.getDimens(this.kBz, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.kBz);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kBz, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kBF.setVideoHeight(i4);
        this.kBF.setVideoWidth(i3);
        this.kBF.invalidate();
    }

    public void Ki(String str) {
        if (this.kBE != null) {
            this.kBE.Kh(str);
        }
    }

    public TextView cRc() {
        return this.gCv;
    }

    public TextView cRd() {
        return this.kBG;
    }

    public void startVideo() {
        if (this.kBF != null && !StringUtils.isNull(this.kBH)) {
            this.kBF.start();
        }
    }

    public void cRe() {
        if (this.kBF != null && !StringUtils.isNull(this.kBH)) {
            this.kBF.resume();
            this.kBF.seekTo(this.kBP);
            if (this.kBT) {
                this.kBF.start();
            }
        }
    }

    public void bGw() {
        this.kBP = this.kBF.getCurrentPosition();
        if (this.kBF != null) {
            this.kBF.pause();
        }
    }

    public void bGx() {
        this.kBP = this.kBF.getCurrentPosition();
        if (this.kBF != null) {
            this.kBF.stopPlayback();
        }
    }

    public String cRf() {
        return this.kBH;
    }

    public d cRg() {
        return this.kBQ;
    }

    private void cRh() {
        if (!v.isEmpty(this.kBR)) {
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
                        if (i2 >= c.this.kBR.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.kBR.get(i2);
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
                                        dVar.setThumbnailBitmap(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.setHasLoaded(true);
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
                    c.this.kBE.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.kBE.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
