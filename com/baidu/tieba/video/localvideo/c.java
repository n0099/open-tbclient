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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.c {
    private TextView gzj;
    private RelativeLayout iVU;
    private LocalVideoActivity kyE;
    private ExpandGridView kyI;
    private a kyJ;
    private CustomVideoView kyK;
    private TextView kyL;
    private String kyM;
    private ImageView kyN;
    private ExpandViewRelativeLayout kyO;
    private FrameLayout kyP;
    private int kyQ;
    private int kyR;
    private int kyS;
    private int kyT;
    private int kyU;
    private d kyV;
    private List<d> kyW;
    private boolean kyX;
    private boolean kyY;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.kyX = false;
        this.kyY = true;
        this.kyE = localVideoActivity;
        this.kyO = (ExpandViewRelativeLayout) this.kyE.findViewById(R.id.container);
        this.kyI = (ExpandGridView) this.kyE.findViewById(R.id.local_video_gridview);
        this.iVU = (RelativeLayout) this.kyE.findViewById(R.id.preview_videoview_container);
        this.kyN = (ImageView) this.kyE.findViewById(R.id.video_cover);
        this.kyP = (FrameLayout) this.kyE.findViewById(R.id.top_container);
        this.kyK = (CustomVideoView) this.kyE.findViewById(R.id.preview_videoview);
        this.kyK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cN(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kyK.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.kyX = true;
                c.this.kyK.stopPlayback();
                return false;
            }
        });
        this.gzj = (TextView) this.kyE.findViewById(R.id.close_btn);
        this.kyL = (TextView) this.kyE.findViewById(R.id.next_step_btn);
        this.kyL.setOnClickListener(onClickListener);
        this.gzj.setOnClickListener(onClickListener);
        this.kyJ = new a(this.kyE);
        this.kyI.setAdapter((ListAdapter) this.kyJ);
        this.kyI.setSelector(new ColorDrawable(0));
        this.kyI.setVerticalScrollBarEnabled(false);
        this.kyI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.kyX = false;
                    c.this.kyO.setIsCanLayout(true);
                    c.this.iVU.layout(c.this.iVU.getLeft(), 0, c.this.iVU.getRight(), c.this.kyT);
                    c.this.kyI.layout(c.this.kyI.getLeft(), c.this.kyT, c.this.kyI.getRight(), c.this.kyI.getBottom());
                    c.this.kyP.layout(c.this.kyP.getTop(), c.this.kyP.getLeft(), c.this.kyP.getRight(), c.this.kyP.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.kyM) && c.this.kyK != null) {
                        c.this.kyK.setVisibility(8);
                        c.this.kyK.stopPlayback();
                        c.this.kyK.setVideoPath(dVar.getVideoPath());
                        c.this.kyK.setVisibility(0);
                        c.this.kyM = dVar.getVideoPath();
                        c.this.kyV = dVar;
                        if (c.this.kyN != null) {
                            c.this.kyN.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.kyE);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.kyN.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.kyK.start();
                    }
                }
            }
        });
        this.kyO.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aN(float f) {
                c.this.kyQ = c.this.kyI.getTop();
                c.this.kyR = c.this.iVU.getTop();
                c.this.kyS = c.this.kyO.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.kyO.setIsCanLayout(false);
                int i2 = (int) (c.this.kyQ + f2);
                int i3 = i == 1 ? (int) (c.this.kyR + f2) : (int) (c.this.kyR + (f2 * 0.3d));
                if (i2 >= c.this.kyP.getBottom() && i2 <= l.getDimens(c.this.kyE, R.dimen.ds902)) {
                    c.this.iVU.layout(c.this.iVU.getLeft(), i3, c.this.iVU.getRight(), c.this.kyT + i3);
                    c.this.kyI.layout(c.this.kyI.getLeft(), i2, c.this.kyI.getRight(), c.this.kyI.getBottom());
                    if (i2 <= l.getDimens(c.this.kyE, R.dimen.ds400)) {
                        c.this.kyY = false;
                        c.this.kyK.pause();
                    } else {
                        c.this.kyY = true;
                        c.this.kyK.start();
                    }
                    float dimens = (l.getDimens(c.this.kyE, R.dimen.ds902) - i2) / l.getDimens(c.this.kyE, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.kyN.setVisibility(8);
                        return;
                    }
                    c.this.kyN.setVisibility(0);
                    c.this.kyN.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cOb() {
                if (c.this.kyI.getTop() > c.this.kyS / 2) {
                    c.this.kyY = true;
                    c.this.kyK.start();
                    c.this.kyN.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iVU.getBottom(), c.this.kyT);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iVU.layout(c.this.iVU.getLeft(), 0, c.this.iVU.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.kyI.getTop(), c.this.kyT);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kyI.layout(c.this.kyI.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kyI.getRight(), c.this.kyI.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.kyY = false;
                c.this.kyK.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iVU.getBottom(), l.getDimens(c.this.kyE, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iVU.layout(c.this.iVU.getLeft(), intValue - c.this.kyT, c.this.iVU.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.kyI.getTop(), l.getDimens(c.this.kyE, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.kyI.layout(c.this.kyI.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kyI.getRight(), c.this.kyI.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.kyI.getTop() > c.this.kyP.getBottom() || c.this.kyI.getFirstVisiblePosition() != 0 || c.this.kyI.getChildCount() <= 0 || c.this.kyI.getChildAt(0).getTop() < 0) {
                    if (c.this.kyI.getTop() <= c.this.kyP.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.kyT - l.getDimens(c.this.kyE, R.dimen.ds20))) && f2 < ((float) (c.this.kyT + l.getDimens(c.this.kyE, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.kyT = l.getDimens(this.kyE, R.dimen.ds902);
    }

    public boolean cPi() {
        return this.kyX;
    }

    public void ew(List<d> list) {
        if (!v.isEmpty(list)) {
            this.kyW = list;
            d dVar = list.get(0);
            if (this.kyK != null) {
                this.kyK.setVideoPath(dVar.getVideoPath());
                this.kyM = dVar.getVideoPath();
                this.kyV = dVar;
                if (this.kyN != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.kyE);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.kyN.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.kyK.start();
            }
            if (this.kyJ != null) {
                this.kyJ.setData(list);
                cPp();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cPj() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.kyE).jE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.kyE.getPageContext());
        a.fA(false);
        a.aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kyE) / l.getDimens(this.kyE, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.kyE);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kyE, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kyK.setVideoHeight(i4);
        this.kyK.setVideoWidth(i3);
        this.kyK.invalidate();
    }

    public void JU(String str) {
        if (this.kyJ != null) {
            this.kyJ.JT(str);
        }
    }

    public TextView cPk() {
        return this.gzj;
    }

    public TextView cPl() {
        return this.kyL;
    }

    public void startVideo() {
        if (this.kyK != null && !StringUtils.isNull(this.kyM)) {
            this.kyK.start();
        }
    }

    public void cPm() {
        if (this.kyK != null && !StringUtils.isNull(this.kyM)) {
            this.kyK.resume();
            this.kyK.seekTo(this.kyU);
            if (this.kyY) {
                this.kyK.start();
            }
        }
    }

    public void bEF() {
        this.kyU = this.kyK.getCurrentPosition();
        if (this.kyK != null) {
            this.kyK.pause();
        }
    }

    public void bEG() {
        this.kyU = this.kyK.getCurrentPosition();
        if (this.kyK != null) {
            this.kyK.stopPlayback();
        }
    }

    public String cPn() {
        return this.kyM;
    }

    public d cPo() {
        return this.kyV;
    }

    private void cPp() {
        if (!v.isEmpty(this.kyW)) {
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
                        if (i2 >= c.this.kyW.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.kyW.get(i2);
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
                    c.this.kyJ.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.kyJ.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
