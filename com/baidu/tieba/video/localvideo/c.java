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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private TextView fBE;
    private RelativeLayout hWo;
    private a jsA;
    private CustomVideoView jsB;
    private TextView jsC;
    private String jsD;
    private ImageView jsE;
    private ExpandViewRelativeLayout jsF;
    private FrameLayout jsG;
    private int jsH;
    private int jsI;
    private int jsJ;
    private int jsK;
    private int jsL;
    private d jsM;
    private List<d> jsN;
    private boolean jsO;
    private boolean jsP;
    private LocalVideoActivity jsv;
    private ExpandGridView jsz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.jsO = false;
        this.jsP = true;
        this.jsv = localVideoActivity;
        this.jsF = (ExpandViewRelativeLayout) this.jsv.findViewById(R.id.container);
        this.jsz = (ExpandGridView) this.jsv.findViewById(R.id.local_video_gridview);
        this.hWo = (RelativeLayout) this.jsv.findViewById(R.id.preview_videoview_container);
        this.jsE = (ImageView) this.jsv.findViewById(R.id.video_cover);
        this.jsG = (FrameLayout) this.jsv.findViewById(R.id.top_container);
        this.jsB = (CustomVideoView) this.jsv.findViewById(R.id.preview_videoview);
        this.jsB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jsB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.jsO = true;
                c.this.jsB.stopPlayback();
                return false;
            }
        });
        this.fBE = (TextView) this.jsv.findViewById(R.id.close_btn);
        this.jsC = (TextView) this.jsv.findViewById(R.id.next_step_btn);
        this.jsC.setOnClickListener(onClickListener);
        this.fBE.setOnClickListener(onClickListener);
        this.jsA = new a(this.jsv);
        this.jsz.setAdapter((ListAdapter) this.jsA);
        this.jsz.setSelector(new ColorDrawable(0));
        this.jsz.setVerticalScrollBarEnabled(false);
        this.jsz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.jsO = false;
                    c.this.jsF.setIsCanLayout(true);
                    c.this.hWo.layout(c.this.hWo.getLeft(), 0, c.this.hWo.getRight(), c.this.jsK);
                    c.this.jsz.layout(c.this.jsz.getLeft(), c.this.jsK, c.this.jsz.getRight(), c.this.jsz.getBottom());
                    c.this.jsG.layout(c.this.jsG.getTop(), c.this.jsG.getLeft(), c.this.jsG.getRight(), c.this.jsG.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.jsD) && c.this.jsB != null) {
                        c.this.jsB.setVisibility(8);
                        c.this.jsB.stopPlayback();
                        c.this.jsB.setVideoPath(dVar.getVideoPath());
                        c.this.jsB.setVisibility(0);
                        c.this.jsD = dVar.getVideoPath();
                        c.this.jsM = dVar;
                        if (c.this.jsE != null) {
                            c.this.jsE.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.jsv);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.jsE.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.jsB.start();
                    }
                }
            }
        });
        this.jsF.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aS(float f) {
                c.this.jsH = c.this.jsz.getTop();
                c.this.jsI = c.this.hWo.getTop();
                c.this.jsJ = c.this.jsF.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.jsF.setIsCanLayout(false);
                int i2 = (int) (c.this.jsH + f2);
                int i3 = i == 1 ? (int) (c.this.jsI + f2) : (int) (c.this.jsI + (f2 * 0.3d));
                if (i2 >= c.this.jsG.getBottom() && i2 <= l.g(c.this.jsv, R.dimen.ds902)) {
                    c.this.hWo.layout(c.this.hWo.getLeft(), i3, c.this.hWo.getRight(), c.this.jsK + i3);
                    c.this.jsz.layout(c.this.jsz.getLeft(), i2, c.this.jsz.getRight(), c.this.jsz.getBottom());
                    if (i2 <= l.g(c.this.jsv, R.dimen.ds400)) {
                        c.this.jsP = false;
                        c.this.jsB.pause();
                    } else {
                        c.this.jsP = true;
                        c.this.jsB.start();
                    }
                    float g = (l.g(c.this.jsv, R.dimen.ds902) - i2) / l.g(c.this.jsv, R.dimen.ds902);
                    if (g == 0.0f) {
                        c.this.jsE.setVisibility(8);
                        return;
                    }
                    c.this.jsE.setVisibility(0);
                    c.this.jsE.setAlpha(g);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void crl() {
                if (c.this.jsz.getTop() > c.this.jsJ / 2) {
                    c.this.jsP = true;
                    c.this.jsB.start();
                    c.this.jsE.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.hWo.getBottom(), c.this.jsK);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hWo.layout(c.this.hWo.getLeft(), 0, c.this.hWo.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.jsz.getTop(), c.this.jsK);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jsz.layout(c.this.jsz.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jsz.getRight(), c.this.jsz.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.jsP = false;
                c.this.jsB.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.hWo.getBottom(), l.g(c.this.jsv, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.hWo.layout(c.this.hWo.getLeft(), intValue - c.this.jsK, c.this.hWo.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.jsz.getTop(), l.g(c.this.jsv, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.jsz.layout(c.this.jsz.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jsz.getRight(), c.this.jsz.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.jsz.getTop() > c.this.jsG.getBottom() || c.this.jsz.getFirstVisiblePosition() != 0 || c.this.jsz.getChildCount() <= 0 || c.this.jsz.getChildAt(0).getTop() < 0) {
                    if (c.this.jsz.getTop() <= c.this.jsG.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.jsK - l.g(c.this.jsv, R.dimen.ds20))) && f2 < ((float) (c.this.jsK + l.g(c.this.jsv, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.jsK = l.g(this.jsv, R.dimen.ds902);
    }

    public boolean csx() {
        return this.jsO;
    }

    public void ep(List<d> list) {
        if (!v.aa(list)) {
            this.jsN = list;
            d dVar = list.get(0);
            if (this.jsB != null) {
                this.jsB.setVideoPath(dVar.getVideoPath());
                this.jsD = dVar.getVideoPath();
                this.jsM = dVar;
                if (this.jsE != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.jsv);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.jsE.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.jsB.start();
            }
            if (this.jsA != null) {
                this.jsA.setData(list);
                csF();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void csy() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.jsv).hn(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.jsv.getPageContext());
        a.dN(false);
        a.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jsv) / l.g(this.jsv, R.dimen.ds902)) {
            i3 = l.af(this.jsv);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jsv, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jsB.setVideoHeight(i4);
        this.jsB.setVideoWidth(i3);
        this.jsB.invalidate();
    }

    public void Fd(String str) {
        if (this.jsA != null) {
            this.jsA.Fc(str);
        }
    }

    public TextView csz() {
        return this.fBE;
    }

    public TextView csA() {
        return this.jsC;
    }

    public void csB() {
        if (this.jsB != null && !StringUtils.isNull(this.jsD)) {
            this.jsB.start();
        }
    }

    public void csC() {
        if (this.jsB != null && !StringUtils.isNull(this.jsD)) {
            this.jsB.resume();
            this.jsB.seekTo(this.jsL);
            if (this.jsP) {
                this.jsB.start();
            }
        }
    }

    public void bme() {
        this.jsL = this.jsB.getCurrentPosition();
        if (this.jsB != null) {
            this.jsB.pause();
        }
    }

    public void bmf() {
        this.jsL = this.jsB.getCurrentPosition();
        if (this.jsB != null) {
            this.jsB.stopPlayback();
        }
    }

    public String csD() {
        return this.jsD;
    }

    public d csE() {
        return this.jsM;
    }

    private void csF() {
        if (!v.aa(this.jsN)) {
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
                        if (i2 >= c.this.jsN.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.jsN.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.f(extractMetadata, 0));
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
                                        matrix.postScale(((float) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY) / frameAtTime.getWidth(), ((int) ((150.0f * frameAtTime.getHeight()) / frameAtTime.getWidth())) / frameAtTime.getHeight());
                                        dVar.M(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.rt(true);
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
                /* renamed from: c */
                public void onProgressUpdate(Integer... numArr) {
                    super.onProgressUpdate(numArr);
                    c.this.jsA.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.jsA.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
