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
    private TextView gBl;
    private RelativeLayout iXq;
    private boolean kAa;
    private LocalVideoActivity kzG;
    private ExpandGridView kzK;
    private a kzL;
    private CustomVideoView kzM;
    private TextView kzN;
    private String kzO;
    private ImageView kzP;
    private ExpandViewRelativeLayout kzQ;
    private FrameLayout kzR;
    private int kzS;
    private int kzT;
    private int kzU;
    private int kzV;
    private int kzW;
    private d kzX;
    private List<d> kzY;
    private boolean kzZ;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.kzZ = false;
        this.kAa = true;
        this.kzG = localVideoActivity;
        this.kzQ = (ExpandViewRelativeLayout) this.kzG.findViewById(R.id.container);
        this.kzK = (ExpandGridView) this.kzG.findViewById(R.id.local_video_gridview);
        this.iXq = (RelativeLayout) this.kzG.findViewById(R.id.preview_videoview_container);
        this.kzP = (ImageView) this.kzG.findViewById(R.id.video_cover);
        this.kzR = (FrameLayout) this.kzG.findViewById(R.id.top_container);
        this.kzM = (CustomVideoView) this.kzG.findViewById(R.id.preview_videoview);
        this.kzM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kzM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.kzZ = true;
                c.this.kzM.stopPlayback();
                return false;
            }
        });
        this.gBl = (TextView) this.kzG.findViewById(R.id.close_btn);
        this.kzN = (TextView) this.kzG.findViewById(R.id.next_step_btn);
        this.kzN.setOnClickListener(onClickListener);
        this.gBl.setOnClickListener(onClickListener);
        this.kzL = new a(this.kzG);
        this.kzK.setAdapter((ListAdapter) this.kzL);
        this.kzK.setSelector(new ColorDrawable(0));
        this.kzK.setVerticalScrollBarEnabled(false);
        this.kzK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.kzZ = false;
                    c.this.kzQ.setIsCanLayout(true);
                    c.this.iXq.layout(c.this.iXq.getLeft(), 0, c.this.iXq.getRight(), c.this.kzV);
                    c.this.kzK.layout(c.this.kzK.getLeft(), c.this.kzV, c.this.kzK.getRight(), c.this.kzK.getBottom());
                    c.this.kzR.layout(c.this.kzR.getTop(), c.this.kzR.getLeft(), c.this.kzR.getRight(), c.this.kzR.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.kzO) && c.this.kzM != null) {
                        c.this.kzM.setVisibility(8);
                        c.this.kzM.stopPlayback();
                        c.this.kzM.setVideoPath(dVar.getVideoPath());
                        c.this.kzM.setVisibility(0);
                        c.this.kzO = dVar.getVideoPath();
                        c.this.kzX = dVar;
                        if (c.this.kzP != null) {
                            c.this.kzP.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.kzG);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.kzP.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.kzM.start();
                    }
                }
            }
        });
        this.kzQ.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aM(float f) {
                c.this.kzS = c.this.kzK.getTop();
                c.this.kzT = c.this.iXq.getTop();
                c.this.kzU = c.this.kzQ.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.kzQ.setIsCanLayout(false);
                int i2 = (int) (c.this.kzS + f2);
                int i3 = i == 1 ? (int) (c.this.kzT + f2) : (int) (c.this.kzT + (f2 * 0.3d));
                if (i2 >= c.this.kzR.getBottom() && i2 <= l.getDimens(c.this.kzG, R.dimen.ds902)) {
                    c.this.iXq.layout(c.this.iXq.getLeft(), i3, c.this.iXq.getRight(), c.this.kzV + i3);
                    c.this.kzK.layout(c.this.kzK.getLeft(), i2, c.this.kzK.getRight(), c.this.kzK.getBottom());
                    if (i2 <= l.getDimens(c.this.kzG, R.dimen.ds400)) {
                        c.this.kAa = false;
                        c.this.kzM.pause();
                    } else {
                        c.this.kAa = true;
                        c.this.kzM.start();
                    }
                    float dimens = (l.getDimens(c.this.kzG, R.dimen.ds902) - i2) / l.getDimens(c.this.kzG, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.kzP.setVisibility(8);
                        return;
                    }
                    c.this.kzP.setVisibility(0);
                    c.this.kzP.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cPA() {
                if (c.this.kzK.getTop() > c.this.kzU / 2) {
                    c.this.kAa = true;
                    c.this.kzM.start();
                    c.this.kzP.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iXq.getBottom(), c.this.kzV);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iXq.layout(c.this.iXq.getLeft(), 0, c.this.iXq.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.kzK.getTop(), c.this.kzV);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kzK.layout(c.this.kzK.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kzK.getRight(), c.this.kzK.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.kAa = false;
                c.this.kzM.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iXq.getBottom(), l.getDimens(c.this.kzG, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iXq.layout(c.this.iXq.getLeft(), intValue - c.this.kzV, c.this.iXq.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.kzK.getTop(), l.getDimens(c.this.kzG, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.kzK.layout(c.this.kzK.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kzK.getRight(), c.this.kzK.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.kzK.getTop() > c.this.kzR.getBottom() || c.this.kzK.getFirstVisiblePosition() != 0 || c.this.kzK.getChildCount() <= 0 || c.this.kzK.getChildAt(0).getTop() < 0) {
                    if (c.this.kzK.getTop() <= c.this.kzR.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.kzV - l.getDimens(c.this.kzG, R.dimen.ds20))) && f2 < ((float) (c.this.kzV + l.getDimens(c.this.kzG, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.kzV = l.getDimens(this.kzG, R.dimen.ds902);
    }

    public boolean cQF() {
        return this.kzZ;
    }

    public void er(List<d> list) {
        if (!v.isEmpty(list)) {
            this.kzY = list;
            d dVar = list.get(0);
            if (this.kzM != null) {
                this.kzM.setVideoPath(dVar.getVideoPath());
                this.kzO = dVar.getVideoPath();
                this.kzX = dVar;
                if (this.kzP != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.kzG);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.kzP.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.kzM.start();
            }
            if (this.kzL != null) {
                this.kzL.setData(list);
                cQM();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cQG() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.kzG).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.kzG.getPageContext());
        a.fH(false);
        a.aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kzG) / l.getDimens(this.kzG, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.kzG);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kzG, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kzM.setVideoHeight(i4);
        this.kzM.setVideoWidth(i3);
        this.kzM.invalidate();
    }

    public void Kh(String str) {
        if (this.kzL != null) {
            this.kzL.Kg(str);
        }
    }

    public TextView cQH() {
        return this.gBl;
    }

    public TextView cQI() {
        return this.kzN;
    }

    public void startVideo() {
        if (this.kzM != null && !StringUtils.isNull(this.kzO)) {
            this.kzM.start();
        }
    }

    public void cQJ() {
        if (this.kzM != null && !StringUtils.isNull(this.kzO)) {
            this.kzM.resume();
            this.kzM.seekTo(this.kzW);
            if (this.kAa) {
                this.kzM.start();
            }
        }
    }

    public void bGj() {
        this.kzW = this.kzM.getCurrentPosition();
        if (this.kzM != null) {
            this.kzM.pause();
        }
    }

    public void bGk() {
        this.kzW = this.kzM.getCurrentPosition();
        if (this.kzM != null) {
            this.kzM.stopPlayback();
        }
    }

    public String cQK() {
        return this.kzO;
    }

    public d cQL() {
        return this.kzX;
    }

    private void cQM() {
        if (!v.isEmpty(this.kzY)) {
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
                        if (i2 >= c.this.kzY.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.kzY.get(i2);
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
                    c.this.kzL.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.kzL.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
