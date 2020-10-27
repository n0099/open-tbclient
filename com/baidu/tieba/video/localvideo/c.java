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
    private TextView iRl;
    private RelativeLayout lEW;
    private LocalVideoActivity nkY;
    private ExpandGridView nlc;
    private a nld;
    private CustomVideoView nle;
    private TextView nlf;
    private String nlg;
    private ImageView nlh;
    private ExpandViewRelativeLayout nli;
    private FrameLayout nlj;
    private int nlk;
    private int nll;
    private int nlm;
    private int nln;
    private int nlo;
    private d nlp;
    private List<d> nlq;
    private boolean nlr;
    private boolean nls;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.nlr = false;
        this.nls = true;
        this.nkY = localVideoActivity;
        this.nli = (ExpandViewRelativeLayout) this.nkY.findViewById(R.id.container);
        this.nlc = (ExpandGridView) this.nkY.findViewById(R.id.local_video_gridview);
        this.lEW = (RelativeLayout) this.nkY.findViewById(R.id.preview_videoview_container);
        this.nlh = (ImageView) this.nkY.findViewById(R.id.video_cover);
        this.nlj = (FrameLayout) this.nkY.findViewById(R.id.top_container);
        this.nle = (CustomVideoView) this.nkY.findViewById(R.id.preview_videoview);
        this.nle.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dx(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nle.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.nlr = true;
                c.this.nle.stopPlayback();
                return false;
            }
        });
        this.iRl = (TextView) this.nkY.findViewById(R.id.close_btn);
        this.nlf = (TextView) this.nkY.findViewById(R.id.next_step_btn);
        this.nlf.setOnClickListener(onClickListener);
        this.iRl.setOnClickListener(onClickListener);
        this.nld = new a(this.nkY);
        this.nlc.setAdapter((ListAdapter) this.nld);
        this.nlc.setSelector(new ColorDrawable(0));
        this.nlc.setVerticalScrollBarEnabled(false);
        this.nlc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.nlr = false;
                    c.this.nli.setIsCanLayout(true);
                    c.this.lEW.layout(c.this.lEW.getLeft(), 0, c.this.lEW.getRight(), c.this.nln);
                    c.this.nlc.layout(c.this.nlc.getLeft(), c.this.nln, c.this.nlc.getRight(), c.this.nlc.getBottom());
                    c.this.nlj.layout(c.this.nlj.getTop(), c.this.nlj.getLeft(), c.this.nlj.getRight(), c.this.nlj.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.nlg) && c.this.nle != null) {
                        c.this.nle.setVisibility(8);
                        c.this.nle.stopPlayback();
                        c.this.nle.setVideoPath(dVar.getVideoPath());
                        c.this.nle.setVisibility(0);
                        c.this.nlg = dVar.getVideoPath();
                        c.this.nlp = dVar;
                        if (c.this.nlh != null) {
                            c.this.nlh.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.nkY);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.nlh.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.nle.start();
                    }
                }
            }
        });
        this.nli.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aN(float f) {
                c.this.nlk = c.this.nlc.getTop();
                c.this.nll = c.this.lEW.getTop();
                c.this.nlm = c.this.nli.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.nli.setIsCanLayout(false);
                int i2 = (int) (c.this.nlk + f2);
                int i3 = i == 1 ? (int) (c.this.nll + f2) : (int) (c.this.nll + (f2 * 0.3d));
                if (i2 >= c.this.nlj.getBottom() && i2 <= l.getDimens(c.this.nkY, R.dimen.ds902)) {
                    c.this.lEW.layout(c.this.lEW.getLeft(), i3, c.this.lEW.getRight(), c.this.nln + i3);
                    c.this.nlc.layout(c.this.nlc.getLeft(), i2, c.this.nlc.getRight(), c.this.nlc.getBottom());
                    if (i2 <= l.getDimens(c.this.nkY, R.dimen.ds400)) {
                        c.this.nls = false;
                        c.this.nle.pause();
                    } else {
                        c.this.nls = true;
                        c.this.nle.start();
                    }
                    float dimens = (l.getDimens(c.this.nkY, R.dimen.ds902) - i2) / l.getDimens(c.this.nkY, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.nlh.setVisibility(8);
                        return;
                    }
                    c.this.nlh.setVisibility(0);
                    c.this.nlh.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dMl() {
                if (c.this.nlc.getTop() > c.this.nlm / 2) {
                    c.this.nls = true;
                    c.this.nle.start();
                    c.this.nlh.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.lEW.getBottom(), c.this.nln);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lEW.layout(c.this.lEW.getLeft(), 0, c.this.lEW.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.nlc.getTop(), c.this.nln);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.nlc.layout(c.this.nlc.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nlc.getRight(), c.this.nlc.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.nls = false;
                c.this.nle.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.lEW.getBottom(), l.getDimens(c.this.nkY, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.lEW.layout(c.this.lEW.getLeft(), intValue - c.this.nln, c.this.lEW.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.nlc.getTop(), l.getDimens(c.this.nkY, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.nlc.layout(c.this.nlc.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nlc.getRight(), c.this.nlc.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.nlc.getTop() > c.this.nlj.getBottom() || c.this.nlc.getFirstVisiblePosition() != 0 || c.this.nlc.getChildCount() <= 0 || c.this.nlc.getChildAt(0).getTop() < 0) {
                    if (c.this.nlc.getTop() <= c.this.nlj.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.nln - l.getDimens(c.this.nkY, R.dimen.ds20))) && f2 < ((float) (c.this.nln + l.getDimens(c.this.nkY, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.nln = l.getDimens(this.nkY, R.dimen.ds902);
    }

    public boolean dNq() {
        return this.nlr;
    }

    public void fL(List<d> list) {
        if (!y.isEmpty(list)) {
            this.nlq = list;
            d dVar = list.get(0);
            if (this.nle != null) {
                this.nle.setVideoPath(dVar.getVideoPath());
                this.nlg = dVar.getVideoPath();
                this.nlp = dVar;
                if (this.nlh != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.nkY);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.nlh.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.nle.start();
            }
            if (this.nld != null) {
                this.nld.setData(list);
                dNx();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dNr() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.nkY).ol(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.nkY.getPageContext());
        a2.iN(false);
        a2.bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nkY) / l.getDimens(this.nkY, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.nkY);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nkY, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nle.setVideoHeight(i4);
        this.nle.setVideoWidth(i3);
        this.nle.invalidate();
    }

    public void TF(String str) {
        if (this.nld != null) {
            this.nld.TE(str);
        }
    }

    public TextView dNs() {
        return this.iRl;
    }

    public TextView dNt() {
        return this.nlf;
    }

    public void startVideo() {
        if (this.nle != null && !StringUtils.isNull(this.nlg)) {
            this.nle.start();
        }
    }

    public void dNu() {
        if (this.nle != null && !StringUtils.isNull(this.nlg)) {
            this.nle.resume();
            this.nle.seekTo(this.nlo);
            if (this.nls) {
                this.nle.start();
            }
        }
    }

    public void pauseVideo() {
        this.nlo = this.nle.getCurrentPosition();
        if (this.nle != null) {
            this.nle.pause();
        }
    }

    public void cyB() {
        this.nlo = this.nle.getCurrentPosition();
        if (this.nle != null) {
            this.nle.stopPlayback();
        }
    }

    public String dNv() {
        return this.nlg;
    }

    public d dNw() {
        return this.nlp;
    }

    private void dNx() {
        if (!y.isEmpty(this.nlq)) {
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
                        if (i2 >= c.this.nlq.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.nlq.get(i2);
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
                            dVar.xQ(true);
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
                    c.this.nld.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.nld.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
