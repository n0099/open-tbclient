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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes23.dex */
public class c extends com.baidu.adp.base.c {
    private TextView iEP;
    private RelativeLayout lsx;
    private ExpandGridView mYC;
    private a mYD;
    private CustomVideoView mYE;
    private TextView mYF;
    private String mYG;
    private ImageView mYH;
    private ExpandViewRelativeLayout mYI;
    private FrameLayout mYJ;
    private int mYK;
    private int mYL;
    private int mYM;
    private int mYN;
    private int mYO;
    private d mYP;
    private List<d> mYQ;
    private boolean mYR;
    private boolean mYS;
    private LocalVideoActivity mYy;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.mYR = false;
        this.mYS = true;
        this.mYy = localVideoActivity;
        this.mYI = (ExpandViewRelativeLayout) this.mYy.findViewById(R.id.container);
        this.mYC = (ExpandGridView) this.mYy.findViewById(R.id.local_video_gridview);
        this.lsx = (RelativeLayout) this.mYy.findViewById(R.id.preview_videoview_container);
        this.mYH = (ImageView) this.mYy.findViewById(R.id.video_cover);
        this.mYJ = (FrameLayout) this.mYy.findViewById(R.id.top_container);
        this.mYE = (CustomVideoView) this.mYy.findViewById(R.id.preview_videoview);
        this.mYE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dv(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mYE.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.mYR = true;
                c.this.mYE.stopPlayback();
                return false;
            }
        });
        this.iEP = (TextView) this.mYy.findViewById(R.id.close_btn);
        this.mYF = (TextView) this.mYy.findViewById(R.id.next_step_btn);
        this.mYF.setOnClickListener(onClickListener);
        this.iEP.setOnClickListener(onClickListener);
        this.mYD = new a(this.mYy);
        this.mYC.setAdapter((ListAdapter) this.mYD);
        this.mYC.setSelector(new ColorDrawable(0));
        this.mYC.setVerticalScrollBarEnabled(false);
        this.mYC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.mYR = false;
                    c.this.mYI.setIsCanLayout(true);
                    c.this.lsx.layout(c.this.lsx.getLeft(), 0, c.this.lsx.getRight(), c.this.mYN);
                    c.this.mYC.layout(c.this.mYC.getLeft(), c.this.mYN, c.this.mYC.getRight(), c.this.mYC.getBottom());
                    c.this.mYJ.layout(c.this.mYJ.getTop(), c.this.mYJ.getLeft(), c.this.mYJ.getRight(), c.this.mYJ.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.mYG) && c.this.mYE != null) {
                        c.this.mYE.setVisibility(8);
                        c.this.mYE.stopPlayback();
                        c.this.mYE.setVideoPath(dVar.getVideoPath());
                        c.this.mYE.setVisibility(0);
                        c.this.mYG = dVar.getVideoPath();
                        c.this.mYP = dVar;
                        if (c.this.mYH != null) {
                            c.this.mYH.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.mYy);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.mYH.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.mYE.start();
                    }
                }
            }
        });
        this.mYI.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aL(float f) {
                c.this.mYK = c.this.mYC.getTop();
                c.this.mYL = c.this.lsx.getTop();
                c.this.mYM = c.this.mYI.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.mYI.setIsCanLayout(false);
                int i2 = (int) (c.this.mYK + f2);
                int i3 = i == 1 ? (int) (c.this.mYL + f2) : (int) (c.this.mYL + (f2 * 0.3d));
                if (i2 >= c.this.mYJ.getBottom() && i2 <= l.getDimens(c.this.mYy, R.dimen.ds902)) {
                    c.this.lsx.layout(c.this.lsx.getLeft(), i3, c.this.lsx.getRight(), c.this.mYN + i3);
                    c.this.mYC.layout(c.this.mYC.getLeft(), i2, c.this.mYC.getRight(), c.this.mYC.getBottom());
                    if (i2 <= l.getDimens(c.this.mYy, R.dimen.ds400)) {
                        c.this.mYS = false;
                        c.this.mYE.pause();
                    } else {
                        c.this.mYS = true;
                        c.this.mYE.start();
                    }
                    float dimens = (l.getDimens(c.this.mYy, R.dimen.ds902) - i2) / l.getDimens(c.this.mYy, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.mYH.setVisibility(8);
                        return;
                    }
                    c.this.mYH.setVisibility(0);
                    c.this.mYH.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dJd() {
                if (c.this.mYC.getTop() > c.this.mYM / 2) {
                    c.this.mYS = true;
                    c.this.mYE.start();
                    c.this.mYH.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.lsx.getBottom(), c.this.mYN);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lsx.layout(c.this.lsx.getLeft(), 0, c.this.lsx.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.mYC.getTop(), c.this.mYN);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.mYC.layout(c.this.mYC.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.mYC.getRight(), c.this.mYC.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.mYS = false;
                c.this.mYE.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.lsx.getBottom(), l.getDimens(c.this.mYy, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.lsx.layout(c.this.lsx.getLeft(), intValue - c.this.mYN, c.this.lsx.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.mYC.getTop(), l.getDimens(c.this.mYy, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.mYC.layout(c.this.mYC.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.mYC.getRight(), c.this.mYC.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.mYC.getTop() > c.this.mYJ.getBottom() || c.this.mYC.getFirstVisiblePosition() != 0 || c.this.mYC.getChildCount() <= 0 || c.this.mYC.getChildAt(0).getTop() < 0) {
                    if (c.this.mYC.getTop() <= c.this.mYJ.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.mYN - l.getDimens(c.this.mYy, R.dimen.ds20))) && f2 < ((float) (c.this.mYN + l.getDimens(c.this.mYy, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.mYN = l.getDimens(this.mYy, R.dimen.ds902);
    }

    public boolean dKi() {
        return this.mYR;
    }

    public void fC(List<d> list) {
        if (!y.isEmpty(list)) {
            this.mYQ = list;
            d dVar = list.get(0);
            if (this.mYE != null) {
                this.mYE.setVideoPath(dVar.getVideoPath());
                this.mYG = dVar.getVideoPath();
                this.mYP = dVar;
                if (this.mYH != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.mYy);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.mYH.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.mYE.start();
            }
            if (this.mYD != null) {
                this.mYD.setData(list);
                dKp();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dKj() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.mYy).oa(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.mYy.getPageContext());
        a2.iA(false);
        a2.bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mYy) / l.getDimens(this.mYy, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.mYy);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mYy, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mYE.setVideoHeight(i4);
        this.mYE.setVideoWidth(i3);
        this.mYE.invalidate();
    }

    public void Tg(String str) {
        if (this.mYD != null) {
            this.mYD.Tf(str);
        }
    }

    public TextView dKk() {
        return this.iEP;
    }

    public TextView dKl() {
        return this.mYF;
    }

    public void startVideo() {
        if (this.mYE != null && !StringUtils.isNull(this.mYG)) {
            this.mYE.start();
        }
    }

    public void dKm() {
        if (this.mYE != null && !StringUtils.isNull(this.mYG)) {
            this.mYE.resume();
            this.mYE.seekTo(this.mYO);
            if (this.mYS) {
                this.mYE.start();
            }
        }
    }

    public void pauseVideo() {
        this.mYO = this.mYE.getCurrentPosition();
        if (this.mYE != null) {
            this.mYE.pause();
        }
    }

    public void cvu() {
        this.mYO = this.mYE.getCurrentPosition();
        if (this.mYE != null) {
            this.mYE.stopPlayback();
        }
    }

    public String dKn() {
        return this.mYG;
    }

    public d dKo() {
        return this.mYP;
    }

    private void dKp() {
        if (!y.isEmpty(this.mYQ)) {
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
                        if (i2 >= c.this.mYQ.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.mYQ.get(i2);
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
                                        dVar.R(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.xz(true);
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
                    c.this.mYD.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.mYD.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
