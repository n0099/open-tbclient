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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c {
    private TextView hOG;
    private RelativeLayout kvT;
    private LocalVideoActivity lZG;
    private ExpandGridView lZK;
    private a lZL;
    private CustomVideoView lZM;
    private TextView lZN;
    private String lZO;
    private ImageView lZP;
    private ExpandViewRelativeLayout lZQ;
    private FrameLayout lZR;
    private int lZS;
    private int lZT;
    private int lZU;
    private int lZV;
    private int lZW;
    private d lZX;
    private List<d> lZY;
    private boolean lZZ;
    private boolean maa;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.lZZ = false;
        this.maa = true;
        this.lZG = localVideoActivity;
        this.lZQ = (ExpandViewRelativeLayout) this.lZG.findViewById(R.id.container);
        this.lZK = (ExpandGridView) this.lZG.findViewById(R.id.local_video_gridview);
        this.kvT = (RelativeLayout) this.lZG.findViewById(R.id.preview_videoview_container);
        this.lZP = (ImageView) this.lZG.findViewById(R.id.video_cover);
        this.lZR = (FrameLayout) this.lZG.findViewById(R.id.top_container);
        this.lZM = (CustomVideoView) this.lZG.findViewById(R.id.preview_videoview);
        this.lZM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dh(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lZM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.lZZ = true;
                c.this.lZM.stopPlayback();
                return false;
            }
        });
        this.hOG = (TextView) this.lZG.findViewById(R.id.close_btn);
        this.lZN = (TextView) this.lZG.findViewById(R.id.next_step_btn);
        this.lZN.setOnClickListener(onClickListener);
        this.hOG.setOnClickListener(onClickListener);
        this.lZL = new a(this.lZG);
        this.lZK.setAdapter((ListAdapter) this.lZL);
        this.lZK.setSelector(new ColorDrawable(0));
        this.lZK.setVerticalScrollBarEnabled(false);
        this.lZK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.lZZ = false;
                    c.this.lZQ.setIsCanLayout(true);
                    c.this.kvT.layout(c.this.kvT.getLeft(), 0, c.this.kvT.getRight(), c.this.lZV);
                    c.this.lZK.layout(c.this.lZK.getLeft(), c.this.lZV, c.this.lZK.getRight(), c.this.lZK.getBottom());
                    c.this.lZR.layout(c.this.lZR.getTop(), c.this.lZR.getLeft(), c.this.lZR.getRight(), c.this.lZR.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.lZO) && c.this.lZM != null) {
                        c.this.lZM.setVisibility(8);
                        c.this.lZM.stopPlayback();
                        c.this.lZM.setVideoPath(dVar.getVideoPath());
                        c.this.lZM.setVisibility(0);
                        c.this.lZO = dVar.getVideoPath();
                        c.this.lZX = dVar;
                        if (c.this.lZP != null) {
                            c.this.lZP.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.lZG);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.lZP.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.lZM.start();
                    }
                }
            }
        });
        this.lZQ.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aA(float f) {
                c.this.lZS = c.this.lZK.getTop();
                c.this.lZT = c.this.kvT.getTop();
                c.this.lZU = c.this.lZQ.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.lZQ.setIsCanLayout(false);
                int i2 = (int) (c.this.lZS + f2);
                int i3 = i == 1 ? (int) (c.this.lZT + f2) : (int) (c.this.lZT + (f2 * 0.3d));
                if (i2 >= c.this.lZR.getBottom() && i2 <= l.getDimens(c.this.lZG, R.dimen.ds902)) {
                    c.this.kvT.layout(c.this.kvT.getLeft(), i3, c.this.kvT.getRight(), c.this.lZV + i3);
                    c.this.lZK.layout(c.this.lZK.getLeft(), i2, c.this.lZK.getRight(), c.this.lZK.getBottom());
                    if (i2 <= l.getDimens(c.this.lZG, R.dimen.ds400)) {
                        c.this.maa = false;
                        c.this.lZM.pause();
                    } else {
                        c.this.maa = true;
                        c.this.lZM.start();
                    }
                    float dimens = (l.getDimens(c.this.lZG, R.dimen.ds902) - i2) / l.getDimens(c.this.lZG, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.lZP.setVisibility(8);
                        return;
                    }
                    c.this.lZP.setVisibility(0);
                    c.this.lZP.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dmH() {
                if (c.this.lZK.getTop() > c.this.lZU / 2) {
                    c.this.maa = true;
                    c.this.lZM.start();
                    c.this.lZP.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.kvT.getBottom(), c.this.lZV);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kvT.layout(c.this.kvT.getLeft(), 0, c.this.kvT.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.lZK.getTop(), c.this.lZV);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lZK.layout(c.this.lZK.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lZK.getRight(), c.this.lZK.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.maa = false;
                c.this.lZM.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.kvT.getBottom(), l.getDimens(c.this.lZG, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.kvT.layout(c.this.kvT.getLeft(), intValue - c.this.lZV, c.this.kvT.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.lZK.getTop(), l.getDimens(c.this.lZG, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.lZK.layout(c.this.lZK.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lZK.getRight(), c.this.lZK.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.lZK.getTop() > c.this.lZR.getBottom() || c.this.lZK.getFirstVisiblePosition() != 0 || c.this.lZK.getChildCount() <= 0 || c.this.lZK.getChildAt(0).getTop() < 0) {
                    if (c.this.lZK.getTop() <= c.this.lZR.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.lZV - l.getDimens(c.this.lZG, R.dimen.ds20))) && f2 < ((float) (c.this.lZV + l.getDimens(c.this.lZG, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.lZV = l.getDimens(this.lZG, R.dimen.ds902);
    }

    public boolean dnO() {
        return this.lZZ;
    }

    public void fc(List<d> list) {
        if (!w.isEmpty(list)) {
            this.lZY = list;
            d dVar = list.get(0);
            if (this.lZM != null) {
                this.lZM.setVideoPath(dVar.getVideoPath());
                this.lZO = dVar.getVideoPath();
                this.lZX = dVar;
                if (this.lZP != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.lZG);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.lZP.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.lZM.start();
            }
            if (this.lZL != null) {
                this.lZL.setData(list);
                dnV();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void dnP() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.lZG).kS(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.lZG.getPageContext());
        a.hg(false);
        a.aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lZG) / l.getDimens(this.lZG, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.lZG);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lZG, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lZM.setVideoHeight(i4);
        this.lZM.setVideoWidth(i3);
        this.lZM.invalidate();
    }

    public void Om(String str) {
        if (this.lZL != null) {
            this.lZL.Ol(str);
        }
    }

    public TextView dnQ() {
        return this.hOG;
    }

    public TextView dnR() {
        return this.lZN;
    }

    public void startVideo() {
        if (this.lZM != null && !StringUtils.isNull(this.lZO)) {
            this.lZM.start();
        }
    }

    public void dnS() {
        if (this.lZM != null && !StringUtils.isNull(this.lZO)) {
            this.lZM.resume();
            this.lZM.seekTo(this.lZW);
            if (this.maa) {
                this.lZM.start();
            }
        }
    }

    public void caG() {
        this.lZW = this.lZM.getCurrentPosition();
        if (this.lZM != null) {
            this.lZM.pause();
        }
    }

    public void caH() {
        this.lZW = this.lZM.getCurrentPosition();
        if (this.lZM != null) {
            this.lZM.stopPlayback();
        }
    }

    public String dnT() {
        return this.lZO;
    }

    public d dnU() {
        return this.lZX;
    }

    private void dnV() {
        if (!w.isEmpty(this.lZY)) {
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
                        if (i2 >= c.this.lZY.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.lZY.get(i2);
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
                            dVar.vo(true);
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
                    c.this.lZL.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.lZL.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
