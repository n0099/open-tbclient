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
    private TextView fBD;
    private RelativeLayout hWl;
    private CustomVideoView jsA;
    private TextView jsB;
    private String jsC;
    private ImageView jsD;
    private ExpandViewRelativeLayout jsE;
    private FrameLayout jsF;
    private int jsG;
    private int jsH;
    private int jsI;
    private int jsJ;
    private int jsK;
    private d jsL;
    private List<d> jsM;
    private boolean jsN;
    private boolean jsO;
    private LocalVideoActivity jsu;
    private ExpandGridView jsy;
    private a jsz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.jsN = false;
        this.jsO = true;
        this.jsu = localVideoActivity;
        this.jsE = (ExpandViewRelativeLayout) this.jsu.findViewById(R.id.container);
        this.jsy = (ExpandGridView) this.jsu.findViewById(R.id.local_video_gridview);
        this.hWl = (RelativeLayout) this.jsu.findViewById(R.id.preview_videoview_container);
        this.jsD = (ImageView) this.jsu.findViewById(R.id.video_cover);
        this.jsF = (FrameLayout) this.jsu.findViewById(R.id.top_container);
        this.jsA = (CustomVideoView) this.jsu.findViewById(R.id.preview_videoview);
        this.jsA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jsA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.jsN = true;
                c.this.jsA.stopPlayback();
                return false;
            }
        });
        this.fBD = (TextView) this.jsu.findViewById(R.id.close_btn);
        this.jsB = (TextView) this.jsu.findViewById(R.id.next_step_btn);
        this.jsB.setOnClickListener(onClickListener);
        this.fBD.setOnClickListener(onClickListener);
        this.jsz = new a(this.jsu);
        this.jsy.setAdapter((ListAdapter) this.jsz);
        this.jsy.setSelector(new ColorDrawable(0));
        this.jsy.setVerticalScrollBarEnabled(false);
        this.jsy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.jsN = false;
                    c.this.jsE.setIsCanLayout(true);
                    c.this.hWl.layout(c.this.hWl.getLeft(), 0, c.this.hWl.getRight(), c.this.jsJ);
                    c.this.jsy.layout(c.this.jsy.getLeft(), c.this.jsJ, c.this.jsy.getRight(), c.this.jsy.getBottom());
                    c.this.jsF.layout(c.this.jsF.getTop(), c.this.jsF.getLeft(), c.this.jsF.getRight(), c.this.jsF.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.jsC) && c.this.jsA != null) {
                        c.this.jsA.setVisibility(8);
                        c.this.jsA.stopPlayback();
                        c.this.jsA.setVideoPath(dVar.getVideoPath());
                        c.this.jsA.setVisibility(0);
                        c.this.jsC = dVar.getVideoPath();
                        c.this.jsL = dVar;
                        if (c.this.jsD != null) {
                            c.this.jsD.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.jsu);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.jsD.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.jsA.start();
                    }
                }
            }
        });
        this.jsE.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aS(float f) {
                c.this.jsG = c.this.jsy.getTop();
                c.this.jsH = c.this.hWl.getTop();
                c.this.jsI = c.this.jsE.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.jsE.setIsCanLayout(false);
                int i2 = (int) (c.this.jsG + f2);
                int i3 = i == 1 ? (int) (c.this.jsH + f2) : (int) (c.this.jsH + (f2 * 0.3d));
                if (i2 >= c.this.jsF.getBottom() && i2 <= l.g(c.this.jsu, R.dimen.ds902)) {
                    c.this.hWl.layout(c.this.hWl.getLeft(), i3, c.this.hWl.getRight(), c.this.jsJ + i3);
                    c.this.jsy.layout(c.this.jsy.getLeft(), i2, c.this.jsy.getRight(), c.this.jsy.getBottom());
                    if (i2 <= l.g(c.this.jsu, R.dimen.ds400)) {
                        c.this.jsO = false;
                        c.this.jsA.pause();
                    } else {
                        c.this.jsO = true;
                        c.this.jsA.start();
                    }
                    float g = (l.g(c.this.jsu, R.dimen.ds902) - i2) / l.g(c.this.jsu, R.dimen.ds902);
                    if (g == 0.0f) {
                        c.this.jsD.setVisibility(8);
                        return;
                    }
                    c.this.jsD.setVisibility(0);
                    c.this.jsD.setAlpha(g);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void crj() {
                if (c.this.jsy.getTop() > c.this.jsI / 2) {
                    c.this.jsO = true;
                    c.this.jsA.start();
                    c.this.jsD.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.hWl.getBottom(), c.this.jsJ);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hWl.layout(c.this.hWl.getLeft(), 0, c.this.hWl.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.jsy.getTop(), c.this.jsJ);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jsy.layout(c.this.jsy.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jsy.getRight(), c.this.jsy.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.jsO = false;
                c.this.jsA.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.hWl.getBottom(), l.g(c.this.jsu, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.hWl.layout(c.this.hWl.getLeft(), intValue - c.this.jsJ, c.this.hWl.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.jsy.getTop(), l.g(c.this.jsu, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.jsy.layout(c.this.jsy.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jsy.getRight(), c.this.jsy.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.jsy.getTop() > c.this.jsF.getBottom() || c.this.jsy.getFirstVisiblePosition() != 0 || c.this.jsy.getChildCount() <= 0 || c.this.jsy.getChildAt(0).getTop() < 0) {
                    if (c.this.jsy.getTop() <= c.this.jsF.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.jsJ - l.g(c.this.jsu, R.dimen.ds20))) && f2 < ((float) (c.this.jsJ + l.g(c.this.jsu, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.jsJ = l.g(this.jsu, R.dimen.ds902);
    }

    public boolean csv() {
        return this.jsN;
    }

    public void ep(List<d> list) {
        if (!v.aa(list)) {
            this.jsM = list;
            d dVar = list.get(0);
            if (this.jsA != null) {
                this.jsA.setVideoPath(dVar.getVideoPath());
                this.jsC = dVar.getVideoPath();
                this.jsL = dVar;
                if (this.jsD != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.jsu);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.jsD.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.jsA.start();
            }
            if (this.jsz != null) {
                this.jsz.setData(list);
                csD();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void csw() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.jsu).hn(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.jsu.getPageContext());
        a.dN(false);
        a.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jsu) / l.g(this.jsu, R.dimen.ds902)) {
            i3 = l.af(this.jsu);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jsu, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jsA.setVideoHeight(i4);
        this.jsA.setVideoWidth(i3);
        this.jsA.invalidate();
    }

    public void Fd(String str) {
        if (this.jsz != null) {
            this.jsz.Fc(str);
        }
    }

    public TextView csx() {
        return this.fBD;
    }

    public TextView csy() {
        return this.jsB;
    }

    public void csz() {
        if (this.jsA != null && !StringUtils.isNull(this.jsC)) {
            this.jsA.start();
        }
    }

    public void csA() {
        if (this.jsA != null && !StringUtils.isNull(this.jsC)) {
            this.jsA.resume();
            this.jsA.seekTo(this.jsK);
            if (this.jsO) {
                this.jsA.start();
            }
        }
    }

    public void bmb() {
        this.jsK = this.jsA.getCurrentPosition();
        if (this.jsA != null) {
            this.jsA.pause();
        }
    }

    public void bmc() {
        this.jsK = this.jsA.getCurrentPosition();
        if (this.jsA != null) {
            this.jsA.stopPlayback();
        }
    }

    public String csB() {
        return this.jsC;
    }

    public d csC() {
        return this.jsL;
    }

    private void csD() {
        if (!v.aa(this.jsM)) {
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
                        if (i2 >= c.this.jsM.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.jsM.get(i2);
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
                    c.this.jsz.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.jsz.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
