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
    private RelativeLayout iVZ;
    private LocalVideoActivity kyJ;
    private ExpandGridView kyN;
    private a kyO;
    private CustomVideoView kyP;
    private TextView kyQ;
    private String kyR;
    private ImageView kyS;
    private ExpandViewRelativeLayout kyT;
    private FrameLayout kyU;
    private int kyV;
    private int kyW;
    private int kyX;
    private int kyY;
    private int kyZ;
    private d kza;
    private List<d> kzb;
    private boolean kzc;
    private boolean kzd;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.kzc = false;
        this.kzd = true;
        this.kyJ = localVideoActivity;
        this.kyT = (ExpandViewRelativeLayout) this.kyJ.findViewById(R.id.container);
        this.kyN = (ExpandGridView) this.kyJ.findViewById(R.id.local_video_gridview);
        this.iVZ = (RelativeLayout) this.kyJ.findViewById(R.id.preview_videoview_container);
        this.kyS = (ImageView) this.kyJ.findViewById(R.id.video_cover);
        this.kyU = (FrameLayout) this.kyJ.findViewById(R.id.top_container);
        this.kyP = (CustomVideoView) this.kyJ.findViewById(R.id.preview_videoview);
        this.kyP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cN(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kyP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.kzc = true;
                c.this.kyP.stopPlayback();
                return false;
            }
        });
        this.gzj = (TextView) this.kyJ.findViewById(R.id.close_btn);
        this.kyQ = (TextView) this.kyJ.findViewById(R.id.next_step_btn);
        this.kyQ.setOnClickListener(onClickListener);
        this.gzj.setOnClickListener(onClickListener);
        this.kyO = new a(this.kyJ);
        this.kyN.setAdapter((ListAdapter) this.kyO);
        this.kyN.setSelector(new ColorDrawable(0));
        this.kyN.setVerticalScrollBarEnabled(false);
        this.kyN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.kzc = false;
                    c.this.kyT.setIsCanLayout(true);
                    c.this.iVZ.layout(c.this.iVZ.getLeft(), 0, c.this.iVZ.getRight(), c.this.kyY);
                    c.this.kyN.layout(c.this.kyN.getLeft(), c.this.kyY, c.this.kyN.getRight(), c.this.kyN.getBottom());
                    c.this.kyU.layout(c.this.kyU.getTop(), c.this.kyU.getLeft(), c.this.kyU.getRight(), c.this.kyU.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.kyR) && c.this.kyP != null) {
                        c.this.kyP.setVisibility(8);
                        c.this.kyP.stopPlayback();
                        c.this.kyP.setVideoPath(dVar.getVideoPath());
                        c.this.kyP.setVisibility(0);
                        c.this.kyR = dVar.getVideoPath();
                        c.this.kza = dVar;
                        if (c.this.kyS != null) {
                            c.this.kyS.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.kyJ);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.kyS.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.kyP.start();
                    }
                }
            }
        });
        this.kyT.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aN(float f) {
                c.this.kyV = c.this.kyN.getTop();
                c.this.kyW = c.this.iVZ.getTop();
                c.this.kyX = c.this.kyT.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.kyT.setIsCanLayout(false);
                int i2 = (int) (c.this.kyV + f2);
                int i3 = i == 1 ? (int) (c.this.kyW + f2) : (int) (c.this.kyW + (f2 * 0.3d));
                if (i2 >= c.this.kyU.getBottom() && i2 <= l.getDimens(c.this.kyJ, R.dimen.ds902)) {
                    c.this.iVZ.layout(c.this.iVZ.getLeft(), i3, c.this.iVZ.getRight(), c.this.kyY + i3);
                    c.this.kyN.layout(c.this.kyN.getLeft(), i2, c.this.kyN.getRight(), c.this.kyN.getBottom());
                    if (i2 <= l.getDimens(c.this.kyJ, R.dimen.ds400)) {
                        c.this.kzd = false;
                        c.this.kyP.pause();
                    } else {
                        c.this.kzd = true;
                        c.this.kyP.start();
                    }
                    float dimens = (l.getDimens(c.this.kyJ, R.dimen.ds902) - i2) / l.getDimens(c.this.kyJ, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.kyS.setVisibility(8);
                        return;
                    }
                    c.this.kyS.setVisibility(0);
                    c.this.kyS.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cOd() {
                if (c.this.kyN.getTop() > c.this.kyX / 2) {
                    c.this.kzd = true;
                    c.this.kyP.start();
                    c.this.kyS.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iVZ.getBottom(), c.this.kyY);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iVZ.layout(c.this.iVZ.getLeft(), 0, c.this.iVZ.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.kyN.getTop(), c.this.kyY);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kyN.layout(c.this.kyN.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kyN.getRight(), c.this.kyN.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.kzd = false;
                c.this.kyP.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iVZ.getBottom(), l.getDimens(c.this.kyJ, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iVZ.layout(c.this.iVZ.getLeft(), intValue - c.this.kyY, c.this.iVZ.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.kyN.getTop(), l.getDimens(c.this.kyJ, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.kyN.layout(c.this.kyN.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kyN.getRight(), c.this.kyN.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.kyN.getTop() > c.this.kyU.getBottom() || c.this.kyN.getFirstVisiblePosition() != 0 || c.this.kyN.getChildCount() <= 0 || c.this.kyN.getChildAt(0).getTop() < 0) {
                    if (c.this.kyN.getTop() <= c.this.kyU.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.kyY - l.getDimens(c.this.kyJ, R.dimen.ds20))) && f2 < ((float) (c.this.kyY + l.getDimens(c.this.kyJ, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.kyY = l.getDimens(this.kyJ, R.dimen.ds902);
    }

    public boolean cPk() {
        return this.kzc;
    }

    public void ew(List<d> list) {
        if (!v.isEmpty(list)) {
            this.kzb = list;
            d dVar = list.get(0);
            if (this.kyP != null) {
                this.kyP.setVideoPath(dVar.getVideoPath());
                this.kyR = dVar.getVideoPath();
                this.kza = dVar;
                if (this.kyS != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.kyJ);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.kyS.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.kyP.start();
            }
            if (this.kyO != null) {
                this.kyO.setData(list);
                cPr();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cPl() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.kyJ).jE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.kyJ.getPageContext());
        a.fA(false);
        a.aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kyJ) / l.getDimens(this.kyJ, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.kyJ);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kyJ, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kyP.setVideoHeight(i4);
        this.kyP.setVideoWidth(i3);
        this.kyP.invalidate();
    }

    public void JU(String str) {
        if (this.kyO != null) {
            this.kyO.JT(str);
        }
    }

    public TextView cPm() {
        return this.gzj;
    }

    public TextView cPn() {
        return this.kyQ;
    }

    public void startVideo() {
        if (this.kyP != null && !StringUtils.isNull(this.kyR)) {
            this.kyP.start();
        }
    }

    public void cPo() {
        if (this.kyP != null && !StringUtils.isNull(this.kyR)) {
            this.kyP.resume();
            this.kyP.seekTo(this.kyZ);
            if (this.kzd) {
                this.kyP.start();
            }
        }
    }

    public void bEF() {
        this.kyZ = this.kyP.getCurrentPosition();
        if (this.kyP != null) {
            this.kyP.pause();
        }
    }

    public void bEG() {
        this.kyZ = this.kyP.getCurrentPosition();
        if (this.kyP != null) {
            this.kyP.stopPlayback();
        }
    }

    public String cPp() {
        return this.kyR;
    }

    public d cPq() {
        return this.kza;
    }

    private void cPr() {
        if (!v.isEmpty(this.kzb)) {
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
                        if (i2 >= c.this.kzb.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.kzb.get(i2);
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
                    c.this.kyO.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.kyO.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
