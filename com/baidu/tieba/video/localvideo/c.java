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
    private TextView gBx;
    private RelativeLayout iXC;
    private String kAa;
    private ImageView kAb;
    private ExpandViewRelativeLayout kAc;
    private FrameLayout kAd;
    private int kAe;
    private int kAf;
    private int kAg;
    private int kAh;
    private int kAi;
    private d kAj;
    private List<d> kAk;
    private boolean kAl;
    private boolean kAm;
    private LocalVideoActivity kzS;
    private ExpandGridView kzW;
    private a kzX;
    private CustomVideoView kzY;
    private TextView kzZ;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.kAl = false;
        this.kAm = true;
        this.kzS = localVideoActivity;
        this.kAc = (ExpandViewRelativeLayout) this.kzS.findViewById(R.id.container);
        this.kzW = (ExpandGridView) this.kzS.findViewById(R.id.local_video_gridview);
        this.iXC = (RelativeLayout) this.kzS.findViewById(R.id.preview_videoview_container);
        this.kAb = (ImageView) this.kzS.findViewById(R.id.video_cover);
        this.kAd = (FrameLayout) this.kzS.findViewById(R.id.top_container);
        this.kzY = (CustomVideoView) this.kzS.findViewById(R.id.preview_videoview);
        this.kzY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kzY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.kAl = true;
                c.this.kzY.stopPlayback();
                return false;
            }
        });
        this.gBx = (TextView) this.kzS.findViewById(R.id.close_btn);
        this.kzZ = (TextView) this.kzS.findViewById(R.id.next_step_btn);
        this.kzZ.setOnClickListener(onClickListener);
        this.gBx.setOnClickListener(onClickListener);
        this.kzX = new a(this.kzS);
        this.kzW.setAdapter((ListAdapter) this.kzX);
        this.kzW.setSelector(new ColorDrawable(0));
        this.kzW.setVerticalScrollBarEnabled(false);
        this.kzW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.kAl = false;
                    c.this.kAc.setIsCanLayout(true);
                    c.this.iXC.layout(c.this.iXC.getLeft(), 0, c.this.iXC.getRight(), c.this.kAh);
                    c.this.kzW.layout(c.this.kzW.getLeft(), c.this.kAh, c.this.kzW.getRight(), c.this.kzW.getBottom());
                    c.this.kAd.layout(c.this.kAd.getTop(), c.this.kAd.getLeft(), c.this.kAd.getRight(), c.this.kAd.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.kAa) && c.this.kzY != null) {
                        c.this.kzY.setVisibility(8);
                        c.this.kzY.stopPlayback();
                        c.this.kzY.setVideoPath(dVar.getVideoPath());
                        c.this.kzY.setVisibility(0);
                        c.this.kAa = dVar.getVideoPath();
                        c.this.kAj = dVar;
                        if (c.this.kAb != null) {
                            c.this.kAb.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.kzS);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.kAb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.kzY.start();
                    }
                }
            }
        });
        this.kAc.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aM(float f) {
                c.this.kAe = c.this.kzW.getTop();
                c.this.kAf = c.this.iXC.getTop();
                c.this.kAg = c.this.kAc.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.kAc.setIsCanLayout(false);
                int i2 = (int) (c.this.kAe + f2);
                int i3 = i == 1 ? (int) (c.this.kAf + f2) : (int) (c.this.kAf + (f2 * 0.3d));
                if (i2 >= c.this.kAd.getBottom() && i2 <= l.getDimens(c.this.kzS, R.dimen.ds902)) {
                    c.this.iXC.layout(c.this.iXC.getLeft(), i3, c.this.iXC.getRight(), c.this.kAh + i3);
                    c.this.kzW.layout(c.this.kzW.getLeft(), i2, c.this.kzW.getRight(), c.this.kzW.getBottom());
                    if (i2 <= l.getDimens(c.this.kzS, R.dimen.ds400)) {
                        c.this.kAm = false;
                        c.this.kzY.pause();
                    } else {
                        c.this.kAm = true;
                        c.this.kzY.start();
                    }
                    float dimens = (l.getDimens(c.this.kzS, R.dimen.ds902) - i2) / l.getDimens(c.this.kzS, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.kAb.setVisibility(8);
                        return;
                    }
                    c.this.kAb.setVisibility(0);
                    c.this.kAb.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cPB() {
                if (c.this.kzW.getTop() > c.this.kAg / 2) {
                    c.this.kAm = true;
                    c.this.kzY.start();
                    c.this.kAb.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iXC.getBottom(), c.this.kAh);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iXC.layout(c.this.iXC.getLeft(), 0, c.this.iXC.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.kzW.getTop(), c.this.kAh);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kzW.layout(c.this.kzW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kzW.getRight(), c.this.kzW.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.kAm = false;
                c.this.kzY.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iXC.getBottom(), l.getDimens(c.this.kzS, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iXC.layout(c.this.iXC.getLeft(), intValue - c.this.kAh, c.this.iXC.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.kzW.getTop(), l.getDimens(c.this.kzS, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.kzW.layout(c.this.kzW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kzW.getRight(), c.this.kzW.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.kzW.getTop() > c.this.kAd.getBottom() || c.this.kzW.getFirstVisiblePosition() != 0 || c.this.kzW.getChildCount() <= 0 || c.this.kzW.getChildAt(0).getTop() < 0) {
                    if (c.this.kzW.getTop() <= c.this.kAd.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.kAh - l.getDimens(c.this.kzS, R.dimen.ds20))) && f2 < ((float) (c.this.kAh + l.getDimens(c.this.kzS, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.kAh = l.getDimens(this.kzS, R.dimen.ds902);
    }

    public boolean cQG() {
        return this.kAl;
    }

    public void er(List<d> list) {
        if (!v.isEmpty(list)) {
            this.kAk = list;
            d dVar = list.get(0);
            if (this.kzY != null) {
                this.kzY.setVideoPath(dVar.getVideoPath());
                this.kAa = dVar.getVideoPath();
                this.kAj = dVar;
                if (this.kAb != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.kzS);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.kAb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.kzY.start();
            }
            if (this.kzX != null) {
                this.kzX.setData(list);
                cQN();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cQH() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.kzS).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.kzS.getPageContext());
        a.fH(false);
        a.aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kzS) / l.getDimens(this.kzS, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.kzS);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kzS, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kzY.setVideoHeight(i4);
        this.kzY.setVideoWidth(i3);
        this.kzY.invalidate();
    }

    public void Ki(String str) {
        if (this.kzX != null) {
            this.kzX.Kh(str);
        }
    }

    public TextView cQI() {
        return this.gBx;
    }

    public TextView cQJ() {
        return this.kzZ;
    }

    public void startVideo() {
        if (this.kzY != null && !StringUtils.isNull(this.kAa)) {
            this.kzY.start();
        }
    }

    public void cQK() {
        if (this.kzY != null && !StringUtils.isNull(this.kAa)) {
            this.kzY.resume();
            this.kzY.seekTo(this.kAi);
            if (this.kAm) {
                this.kzY.start();
            }
        }
    }

    public void bGk() {
        this.kAi = this.kzY.getCurrentPosition();
        if (this.kzY != null) {
            this.kzY.pause();
        }
    }

    public void bGl() {
        this.kAi = this.kzY.getCurrentPosition();
        if (this.kzY != null) {
            this.kzY.stopPlayback();
        }
    }

    public String cQL() {
        return this.kAa;
    }

    public d cQM() {
        return this.kAj;
    }

    private void cQN() {
        if (!v.isEmpty(this.kAk)) {
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
                        if (i2 >= c.this.kAk.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.kAk.get(i2);
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
                    c.this.kzX.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.kzX.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
