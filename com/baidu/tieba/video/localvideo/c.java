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
    private LocalVideoActivity lZD;
    private ExpandGridView lZH;
    private a lZI;
    private CustomVideoView lZJ;
    private TextView lZK;
    private String lZL;
    private ImageView lZM;
    private ExpandViewRelativeLayout lZN;
    private FrameLayout lZO;
    private int lZP;
    private int lZQ;
    private int lZR;
    private int lZS;
    private int lZT;
    private d lZU;
    private List<d> lZV;
    private boolean lZW;
    private boolean lZX;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.lZW = false;
        this.lZX = true;
        this.lZD = localVideoActivity;
        this.lZN = (ExpandViewRelativeLayout) this.lZD.findViewById(R.id.container);
        this.lZH = (ExpandGridView) this.lZD.findViewById(R.id.local_video_gridview);
        this.kvT = (RelativeLayout) this.lZD.findViewById(R.id.preview_videoview_container);
        this.lZM = (ImageView) this.lZD.findViewById(R.id.video_cover);
        this.lZO = (FrameLayout) this.lZD.findViewById(R.id.top_container);
        this.lZJ = (CustomVideoView) this.lZD.findViewById(R.id.preview_videoview);
        this.lZJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dh(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lZJ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.lZW = true;
                c.this.lZJ.stopPlayback();
                return false;
            }
        });
        this.hOG = (TextView) this.lZD.findViewById(R.id.close_btn);
        this.lZK = (TextView) this.lZD.findViewById(R.id.next_step_btn);
        this.lZK.setOnClickListener(onClickListener);
        this.hOG.setOnClickListener(onClickListener);
        this.lZI = new a(this.lZD);
        this.lZH.setAdapter((ListAdapter) this.lZI);
        this.lZH.setSelector(new ColorDrawable(0));
        this.lZH.setVerticalScrollBarEnabled(false);
        this.lZH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.lZW = false;
                    c.this.lZN.setIsCanLayout(true);
                    c.this.kvT.layout(c.this.kvT.getLeft(), 0, c.this.kvT.getRight(), c.this.lZS);
                    c.this.lZH.layout(c.this.lZH.getLeft(), c.this.lZS, c.this.lZH.getRight(), c.this.lZH.getBottom());
                    c.this.lZO.layout(c.this.lZO.getTop(), c.this.lZO.getLeft(), c.this.lZO.getRight(), c.this.lZO.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.lZL) && c.this.lZJ != null) {
                        c.this.lZJ.setVisibility(8);
                        c.this.lZJ.stopPlayback();
                        c.this.lZJ.setVideoPath(dVar.getVideoPath());
                        c.this.lZJ.setVisibility(0);
                        c.this.lZL = dVar.getVideoPath();
                        c.this.lZU = dVar;
                        if (c.this.lZM != null) {
                            c.this.lZM.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.lZD);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.lZM.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.lZJ.start();
                    }
                }
            }
        });
        this.lZN.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aA(float f) {
                c.this.lZP = c.this.lZH.getTop();
                c.this.lZQ = c.this.kvT.getTop();
                c.this.lZR = c.this.lZN.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.lZN.setIsCanLayout(false);
                int i2 = (int) (c.this.lZP + f2);
                int i3 = i == 1 ? (int) (c.this.lZQ + f2) : (int) (c.this.lZQ + (f2 * 0.3d));
                if (i2 >= c.this.lZO.getBottom() && i2 <= l.getDimens(c.this.lZD, R.dimen.ds902)) {
                    c.this.kvT.layout(c.this.kvT.getLeft(), i3, c.this.kvT.getRight(), c.this.lZS + i3);
                    c.this.lZH.layout(c.this.lZH.getLeft(), i2, c.this.lZH.getRight(), c.this.lZH.getBottom());
                    if (i2 <= l.getDimens(c.this.lZD, R.dimen.ds400)) {
                        c.this.lZX = false;
                        c.this.lZJ.pause();
                    } else {
                        c.this.lZX = true;
                        c.this.lZJ.start();
                    }
                    float dimens = (l.getDimens(c.this.lZD, R.dimen.ds902) - i2) / l.getDimens(c.this.lZD, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.lZM.setVisibility(8);
                        return;
                    }
                    c.this.lZM.setVisibility(0);
                    c.this.lZM.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dmD() {
                if (c.this.lZH.getTop() > c.this.lZR / 2) {
                    c.this.lZX = true;
                    c.this.lZJ.start();
                    c.this.lZM.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.kvT.getBottom(), c.this.lZS);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kvT.layout(c.this.kvT.getLeft(), 0, c.this.kvT.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.lZH.getTop(), c.this.lZS);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lZH.layout(c.this.lZH.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lZH.getRight(), c.this.lZH.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.lZX = false;
                c.this.lZJ.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.kvT.getBottom(), l.getDimens(c.this.lZD, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.kvT.layout(c.this.kvT.getLeft(), intValue - c.this.lZS, c.this.kvT.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.lZH.getTop(), l.getDimens(c.this.lZD, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.lZH.layout(c.this.lZH.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.lZH.getRight(), c.this.lZH.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.lZH.getTop() > c.this.lZO.getBottom() || c.this.lZH.getFirstVisiblePosition() != 0 || c.this.lZH.getChildCount() <= 0 || c.this.lZH.getChildAt(0).getTop() < 0) {
                    if (c.this.lZH.getTop() <= c.this.lZO.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.lZS - l.getDimens(c.this.lZD, R.dimen.ds20))) && f2 < ((float) (c.this.lZS + l.getDimens(c.this.lZD, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.lZS = l.getDimens(this.lZD, R.dimen.ds902);
    }

    public boolean dnK() {
        return this.lZW;
    }

    public void fc(List<d> list) {
        if (!w.isEmpty(list)) {
            this.lZV = list;
            d dVar = list.get(0);
            if (this.lZJ != null) {
                this.lZJ.setVideoPath(dVar.getVideoPath());
                this.lZL = dVar.getVideoPath();
                this.lZU = dVar;
                if (this.lZM != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.lZD);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.lZM.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.lZJ.start();
            }
            if (this.lZI != null) {
                this.lZI.setData(list);
                dnR();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void dnL() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.lZD).kS(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.lZD.getPageContext());
        a.hg(false);
        a.aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lZD) / l.getDimens(this.lZD, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.lZD);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lZD, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lZJ.setVideoHeight(i4);
        this.lZJ.setVideoWidth(i3);
        this.lZJ.invalidate();
    }

    public void Ol(String str) {
        if (this.lZI != null) {
            this.lZI.Ok(str);
        }
    }

    public TextView dnM() {
        return this.hOG;
    }

    public TextView dnN() {
        return this.lZK;
    }

    public void startVideo() {
        if (this.lZJ != null && !StringUtils.isNull(this.lZL)) {
            this.lZJ.start();
        }
    }

    public void dnO() {
        if (this.lZJ != null && !StringUtils.isNull(this.lZL)) {
            this.lZJ.resume();
            this.lZJ.seekTo(this.lZT);
            if (this.lZX) {
                this.lZJ.start();
            }
        }
    }

    public void caF() {
        this.lZT = this.lZJ.getCurrentPosition();
        if (this.lZJ != null) {
            this.lZJ.pause();
        }
    }

    public void caG() {
        this.lZT = this.lZJ.getCurrentPosition();
        if (this.lZJ != null) {
            this.lZJ.stopPlayback();
        }
    }

    public String dnP() {
        return this.lZL;
    }

    public d dnQ() {
        return this.lZU;
    }

    private void dnR() {
        if (!w.isEmpty(this.lZV)) {
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
                        if (i2 >= c.this.lZV.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.lZV.get(i2);
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
                    c.this.lZI.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.lZI.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
