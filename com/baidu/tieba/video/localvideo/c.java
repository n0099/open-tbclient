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
/* loaded from: classes17.dex */
public class c extends com.baidu.adp.base.c {
    private TextView iiO;
    private RelativeLayout kUv;
    private LocalVideoActivity myJ;
    private ExpandGridView myN;
    private a myO;
    private CustomVideoView myP;
    private TextView myQ;
    private String myR;
    private ImageView myS;
    private ExpandViewRelativeLayout myT;
    private FrameLayout myU;
    private int myV;
    private int myW;
    private int myX;
    private int myY;
    private int myZ;
    private d mza;
    private List<d> mzb;
    private boolean mzc;
    private boolean mzd;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.mzc = false;
        this.mzd = true;
        this.myJ = localVideoActivity;
        this.myT = (ExpandViewRelativeLayout) this.myJ.findViewById(R.id.container);
        this.myN = (ExpandGridView) this.myJ.findViewById(R.id.local_video_gridview);
        this.kUv = (RelativeLayout) this.myJ.findViewById(R.id.preview_videoview_container);
        this.myS = (ImageView) this.myJ.findViewById(R.id.video_cover);
        this.myU = (FrameLayout) this.myJ.findViewById(R.id.top_container);
        this.myP = (CustomVideoView) this.myJ.findViewById(R.id.preview_videoview);
        this.myP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dr(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.myP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.mzc = true;
                c.this.myP.stopPlayback();
                return false;
            }
        });
        this.iiO = (TextView) this.myJ.findViewById(R.id.close_btn);
        this.myQ = (TextView) this.myJ.findViewById(R.id.next_step_btn);
        this.myQ.setOnClickListener(onClickListener);
        this.iiO.setOnClickListener(onClickListener);
        this.myO = new a(this.myJ);
        this.myN.setAdapter((ListAdapter) this.myO);
        this.myN.setSelector(new ColorDrawable(0));
        this.myN.setVerticalScrollBarEnabled(false);
        this.myN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.mzc = false;
                    c.this.myT.setIsCanLayout(true);
                    c.this.kUv.layout(c.this.kUv.getLeft(), 0, c.this.kUv.getRight(), c.this.myY);
                    c.this.myN.layout(c.this.myN.getLeft(), c.this.myY, c.this.myN.getRight(), c.this.myN.getBottom());
                    c.this.myU.layout(c.this.myU.getTop(), c.this.myU.getLeft(), c.this.myU.getRight(), c.this.myU.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.myR) && c.this.myP != null) {
                        c.this.myP.setVisibility(8);
                        c.this.myP.stopPlayback();
                        c.this.myP.setVideoPath(dVar.getVideoPath());
                        c.this.myP.setVisibility(0);
                        c.this.myR = dVar.getVideoPath();
                        c.this.mza = dVar;
                        if (c.this.myS != null) {
                            c.this.myS.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.myJ);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.myS.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.myP.start();
                    }
                }
            }
        });
        this.myT.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aF(float f) {
                c.this.myV = c.this.myN.getTop();
                c.this.myW = c.this.kUv.getTop();
                c.this.myX = c.this.myT.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.myT.setIsCanLayout(false);
                int i2 = (int) (c.this.myV + f2);
                int i3 = i == 1 ? (int) (c.this.myW + f2) : (int) (c.this.myW + (f2 * 0.3d));
                if (i2 >= c.this.myU.getBottom() && i2 <= l.getDimens(c.this.myJ, R.dimen.ds902)) {
                    c.this.kUv.layout(c.this.kUv.getLeft(), i3, c.this.kUv.getRight(), c.this.myY + i3);
                    c.this.myN.layout(c.this.myN.getLeft(), i2, c.this.myN.getRight(), c.this.myN.getBottom());
                    if (i2 <= l.getDimens(c.this.myJ, R.dimen.ds400)) {
                        c.this.mzd = false;
                        c.this.myP.pause();
                    } else {
                        c.this.mzd = true;
                        c.this.myP.start();
                    }
                    float dimens = (l.getDimens(c.this.myJ, R.dimen.ds902) - i2) / l.getDimens(c.this.myJ, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.myS.setVisibility(8);
                        return;
                    }
                    c.this.myS.setVisibility(0);
                    c.this.myS.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dBo() {
                if (c.this.myN.getTop() > c.this.myX / 2) {
                    c.this.mzd = true;
                    c.this.myP.start();
                    c.this.myS.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.kUv.getBottom(), c.this.myY);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kUv.layout(c.this.kUv.getLeft(), 0, c.this.kUv.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.myN.getTop(), c.this.myY);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.myN.layout(c.this.myN.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.myN.getRight(), c.this.myN.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.mzd = false;
                c.this.myP.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.kUv.getBottom(), l.getDimens(c.this.myJ, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.kUv.layout(c.this.kUv.getLeft(), intValue - c.this.myY, c.this.kUv.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.myN.getTop(), l.getDimens(c.this.myJ, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.myN.layout(c.this.myN.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.myN.getRight(), c.this.myN.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.myN.getTop() > c.this.myU.getBottom() || c.this.myN.getFirstVisiblePosition() != 0 || c.this.myN.getChildCount() <= 0 || c.this.myN.getChildAt(0).getTop() < 0) {
                    if (c.this.myN.getTop() <= c.this.myU.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.myY - l.getDimens(c.this.myJ, R.dimen.ds20))) && f2 < ((float) (c.this.myY + l.getDimens(c.this.myJ, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.myY = l.getDimens(this.myJ, R.dimen.ds902);
    }

    public boolean dCt() {
        return this.mzc;
    }

    public void fq(List<d> list) {
        if (!y.isEmpty(list)) {
            this.mzb = list;
            d dVar = list.get(0);
            if (this.myP != null) {
                this.myP.setVideoPath(dVar.getVideoPath());
                this.myR = dVar.getVideoPath();
                this.mza = dVar;
                if (this.myS != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.myJ);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.myS.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.myP.start();
            }
            if (this.myO != null) {
                this.myO.setData(list);
                dCA();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dCu() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.myJ).ns(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.myJ.getPageContext());
        a.ig(false);
        a.bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.myJ) / l.getDimens(this.myJ, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.myJ);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.myJ, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.myP.setVideoHeight(i4);
        this.myP.setVideoWidth(i3);
        this.myP.invalidate();
    }

    public void RS(String str) {
        if (this.myO != null) {
            this.myO.RR(str);
        }
    }

    public TextView dCv() {
        return this.iiO;
    }

    public TextView dCw() {
        return this.myQ;
    }

    public void startVideo() {
        if (this.myP != null && !StringUtils.isNull(this.myR)) {
            this.myP.start();
        }
    }

    public void dCx() {
        if (this.myP != null && !StringUtils.isNull(this.myR)) {
            this.myP.resume();
            this.myP.seekTo(this.myZ);
            if (this.mzd) {
                this.myP.start();
            }
        }
    }

    public void coI() {
        this.myZ = this.myP.getCurrentPosition();
        if (this.myP != null) {
            this.myP.pause();
        }
    }

    public void coJ() {
        this.myZ = this.myP.getCurrentPosition();
        if (this.myP != null) {
            this.myP.stopPlayback();
        }
    }

    public String dCy() {
        return this.myR;
    }

    public d dCz() {
        return this.mza;
    }

    private void dCA() {
        if (!y.isEmpty(this.mzb)) {
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
                        if (i2 >= c.this.mzb.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.mzb.get(i2);
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
                                        dVar.S(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.wH(true);
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
                    c.this.myO.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.myO.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
