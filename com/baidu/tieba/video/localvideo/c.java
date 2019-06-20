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
    private RelativeLayout hWp;
    private ExpandGridView jsC;
    private a jsD;
    private CustomVideoView jsE;
    private TextView jsF;
    private String jsG;
    private ImageView jsH;
    private ExpandViewRelativeLayout jsI;
    private FrameLayout jsJ;
    private int jsK;
    private int jsL;
    private int jsM;
    private int jsN;
    private int jsO;
    private d jsP;
    private List<d> jsQ;
    private boolean jsR;
    private boolean jsS;
    private LocalVideoActivity jsy;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.jsR = false;
        this.jsS = true;
        this.jsy = localVideoActivity;
        this.jsI = (ExpandViewRelativeLayout) this.jsy.findViewById(R.id.container);
        this.jsC = (ExpandGridView) this.jsy.findViewById(R.id.local_video_gridview);
        this.hWp = (RelativeLayout) this.jsy.findViewById(R.id.preview_videoview_container);
        this.jsH = (ImageView) this.jsy.findViewById(R.id.video_cover);
        this.jsJ = (FrameLayout) this.jsy.findViewById(R.id.top_container);
        this.jsE = (CustomVideoView) this.jsy.findViewById(R.id.preview_videoview);
        this.jsE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jsE.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.jsR = true;
                c.this.jsE.stopPlayback();
                return false;
            }
        });
        this.fBE = (TextView) this.jsy.findViewById(R.id.close_btn);
        this.jsF = (TextView) this.jsy.findViewById(R.id.next_step_btn);
        this.jsF.setOnClickListener(onClickListener);
        this.fBE.setOnClickListener(onClickListener);
        this.jsD = new a(this.jsy);
        this.jsC.setAdapter((ListAdapter) this.jsD);
        this.jsC.setSelector(new ColorDrawable(0));
        this.jsC.setVerticalScrollBarEnabled(false);
        this.jsC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.jsR = false;
                    c.this.jsI.setIsCanLayout(true);
                    c.this.hWp.layout(c.this.hWp.getLeft(), 0, c.this.hWp.getRight(), c.this.jsN);
                    c.this.jsC.layout(c.this.jsC.getLeft(), c.this.jsN, c.this.jsC.getRight(), c.this.jsC.getBottom());
                    c.this.jsJ.layout(c.this.jsJ.getTop(), c.this.jsJ.getLeft(), c.this.jsJ.getRight(), c.this.jsJ.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.jsG) && c.this.jsE != null) {
                        c.this.jsE.setVisibility(8);
                        c.this.jsE.stopPlayback();
                        c.this.jsE.setVideoPath(dVar.getVideoPath());
                        c.this.jsE.setVisibility(0);
                        c.this.jsG = dVar.getVideoPath();
                        c.this.jsP = dVar;
                        if (c.this.jsH != null) {
                            c.this.jsH.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.jsy);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.jsH.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.jsE.start();
                    }
                }
            }
        });
        this.jsI.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aS(float f) {
                c.this.jsK = c.this.jsC.getTop();
                c.this.jsL = c.this.hWp.getTop();
                c.this.jsM = c.this.jsI.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.jsI.setIsCanLayout(false);
                int i2 = (int) (c.this.jsK + f2);
                int i3 = i == 1 ? (int) (c.this.jsL + f2) : (int) (c.this.jsL + (f2 * 0.3d));
                if (i2 >= c.this.jsJ.getBottom() && i2 <= l.g(c.this.jsy, R.dimen.ds902)) {
                    c.this.hWp.layout(c.this.hWp.getLeft(), i3, c.this.hWp.getRight(), c.this.jsN + i3);
                    c.this.jsC.layout(c.this.jsC.getLeft(), i2, c.this.jsC.getRight(), c.this.jsC.getBottom());
                    if (i2 <= l.g(c.this.jsy, R.dimen.ds400)) {
                        c.this.jsS = false;
                        c.this.jsE.pause();
                    } else {
                        c.this.jsS = true;
                        c.this.jsE.start();
                    }
                    float g = (l.g(c.this.jsy, R.dimen.ds902) - i2) / l.g(c.this.jsy, R.dimen.ds902);
                    if (g == 0.0f) {
                        c.this.jsH.setVisibility(8);
                        return;
                    }
                    c.this.jsH.setVisibility(0);
                    c.this.jsH.setAlpha(g);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void crm() {
                if (c.this.jsC.getTop() > c.this.jsM / 2) {
                    c.this.jsS = true;
                    c.this.jsE.start();
                    c.this.jsH.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.hWp.getBottom(), c.this.jsN);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hWp.layout(c.this.hWp.getLeft(), 0, c.this.hWp.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.jsC.getTop(), c.this.jsN);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jsC.layout(c.this.jsC.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jsC.getRight(), c.this.jsC.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.jsS = false;
                c.this.jsE.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.hWp.getBottom(), l.g(c.this.jsy, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.hWp.layout(c.this.hWp.getLeft(), intValue - c.this.jsN, c.this.hWp.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.jsC.getTop(), l.g(c.this.jsy, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.jsC.layout(c.this.jsC.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jsC.getRight(), c.this.jsC.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.jsC.getTop() > c.this.jsJ.getBottom() || c.this.jsC.getFirstVisiblePosition() != 0 || c.this.jsC.getChildCount() <= 0 || c.this.jsC.getChildAt(0).getTop() < 0) {
                    if (c.this.jsC.getTop() <= c.this.jsJ.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.jsN - l.g(c.this.jsy, R.dimen.ds20))) && f2 < ((float) (c.this.jsN + l.g(c.this.jsy, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.jsN = l.g(this.jsy, R.dimen.ds902);
    }

    public boolean csw() {
        return this.jsR;
    }

    public void ep(List<d> list) {
        if (!v.aa(list)) {
            this.jsQ = list;
            d dVar = list.get(0);
            if (this.jsE != null) {
                this.jsE.setVideoPath(dVar.getVideoPath());
                this.jsG = dVar.getVideoPath();
                this.jsP = dVar;
                if (this.jsH != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.jsy);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.jsH.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.jsE.start();
            }
            if (this.jsD != null) {
                this.jsD.setData(list);
                csE();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void csx() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.jsy).hn(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.jsy.getPageContext());
        a.dN(false);
        a.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jsy) / l.g(this.jsy, R.dimen.ds902)) {
            i3 = l.af(this.jsy);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jsy, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jsE.setVideoHeight(i4);
        this.jsE.setVideoWidth(i3);
        this.jsE.invalidate();
    }

    public void Ff(String str) {
        if (this.jsD != null) {
            this.jsD.Fe(str);
        }
    }

    public TextView csy() {
        return this.fBE;
    }

    public TextView csz() {
        return this.jsF;
    }

    public void csA() {
        if (this.jsE != null && !StringUtils.isNull(this.jsG)) {
            this.jsE.start();
        }
    }

    public void csB() {
        if (this.jsE != null && !StringUtils.isNull(this.jsG)) {
            this.jsE.resume();
            this.jsE.seekTo(this.jsO);
            if (this.jsS) {
                this.jsE.start();
            }
        }
    }

    public void bme() {
        this.jsO = this.jsE.getCurrentPosition();
        if (this.jsE != null) {
            this.jsE.pause();
        }
    }

    public void bmf() {
        this.jsO = this.jsE.getCurrentPosition();
        if (this.jsE != null) {
            this.jsE.stopPlayback();
        }
    }

    public String csC() {
        return this.jsG;
    }

    public d csD() {
        return this.jsP;
    }

    private void csE() {
        if (!v.aa(this.jsQ)) {
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
                        if (i2 >= c.this.jsQ.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.jsQ.get(i2);
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
                            dVar.ru(true);
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
                    c.this.jsD.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.jsD.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
