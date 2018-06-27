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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.d;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private TextView dvw;
    private RelativeLayout fMH;
    private LocalVideoActivity hfC;
    private ExpandGridView hfG;
    private a hfH;
    private CustomVideoView hfI;
    private TextView hfJ;
    private String hfK;
    private ImageView hfL;
    private ExpandViewRelativeLayout hfM;
    private FrameLayout hfN;
    private int hfO;
    private int hfP;
    private int hfQ;
    private int hfR;
    private int hfS;
    private d hfT;
    private List<d> hfU;
    private boolean hfV;
    private boolean hfW;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hfV = false;
        this.hfW = true;
        this.hfC = localVideoActivity;
        this.hfM = (ExpandViewRelativeLayout) this.hfC.findViewById(d.g.container);
        this.hfG = (ExpandGridView) this.hfC.findViewById(d.g.local_video_gridview);
        this.fMH = (RelativeLayout) this.hfC.findViewById(d.g.preview_videoview_container);
        this.hfL = (ImageView) this.hfC.findViewById(d.g.video_cover);
        this.hfN = (FrameLayout) this.hfC.findViewById(d.g.top_container);
        this.hfI = (CustomVideoView) this.hfC.findViewById(d.g.preview_videoview);
        this.hfI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hfI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hfV = true;
                c.this.hfI.stopPlayback();
                return false;
            }
        });
        this.dvw = (TextView) this.hfC.findViewById(d.g.close_btn);
        this.hfJ = (TextView) this.hfC.findViewById(d.g.next_step_btn);
        this.hfJ.setOnClickListener(onClickListener);
        this.dvw.setOnClickListener(onClickListener);
        this.hfH = new a(this.hfC);
        this.hfG.setAdapter((ListAdapter) this.hfH);
        this.hfG.setSelector(new ColorDrawable(0));
        this.hfG.setVerticalScrollBarEnabled(false);
        this.hfG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hfV = false;
                    c.this.hfM.setIsCanLayout(true);
                    c.this.fMH.layout(c.this.fMH.getLeft(), 0, c.this.fMH.getRight(), c.this.hfR);
                    c.this.hfG.layout(c.this.hfG.getLeft(), c.this.hfR, c.this.hfG.getRight(), c.this.hfG.getBottom());
                    c.this.hfN.layout(c.this.hfN.getTop(), c.this.hfN.getLeft(), c.this.hfN.getRight(), c.this.hfN.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hfK) && c.this.hfI != null) {
                        c.this.hfI.setVisibility(8);
                        c.this.hfI.stopPlayback();
                        c.this.hfI.setVideoPath(dVar.getVideoPath());
                        c.this.hfI.setVisibility(0);
                        c.this.hfK = dVar.getVideoPath();
                        c.this.hfT = dVar;
                        if (c.this.hfL != null) {
                            c.this.hfL.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hfC);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hfL.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hfI.start();
                    }
                }
            }
        });
        this.hfM.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aE(float f) {
                c.this.hfO = c.this.hfG.getTop();
                c.this.hfP = c.this.fMH.getTop();
                c.this.hfQ = c.this.hfM.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hfM.setIsCanLayout(false);
                int i2 = (int) (c.this.hfO + f2);
                int i3 = i == 1 ? (int) (c.this.hfP + f2) : (int) (c.this.hfP + (f2 * 0.3d));
                if (i2 >= c.this.hfN.getBottom() && i2 <= l.e(c.this.hfC, d.e.ds902)) {
                    c.this.fMH.layout(c.this.fMH.getLeft(), i3, c.this.fMH.getRight(), c.this.hfR + i3);
                    c.this.hfG.layout(c.this.hfG.getLeft(), i2, c.this.hfG.getRight(), c.this.hfG.getBottom());
                    if (i2 <= l.e(c.this.hfC, d.e.ds400)) {
                        c.this.hfW = false;
                        c.this.hfI.pause();
                    } else {
                        c.this.hfW = true;
                        c.this.hfI.start();
                    }
                    float e = (l.e(c.this.hfC, d.e.ds902) - i2) / l.e(c.this.hfC, d.e.ds902);
                    if (e == 0.0f) {
                        c.this.hfL.setVisibility(8);
                        return;
                    }
                    c.this.hfL.setVisibility(0);
                    c.this.hfL.setAlpha(e);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bBQ() {
                if (c.this.hfG.getTop() > c.this.hfQ / 2) {
                    c.this.hfW = true;
                    c.this.hfI.start();
                    c.this.hfL.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fMH.getBottom(), c.this.hfR);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fMH.layout(c.this.fMH.getLeft(), 0, c.this.fMH.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hfG.getTop(), c.this.hfR);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hfG.layout(c.this.hfG.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hfG.getRight(), c.this.hfG.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hfW = false;
                c.this.hfI.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fMH.getBottom(), l.e(c.this.hfC, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fMH.layout(c.this.fMH.getLeft(), intValue - c.this.hfR, c.this.fMH.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hfG.getTop(), l.e(c.this.hfC, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hfG.layout(c.this.hfG.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hfG.getRight(), c.this.hfG.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hfG.getTop() > c.this.hfN.getBottom() || c.this.hfG.getFirstVisiblePosition() != 0 || c.this.hfG.getChildCount() <= 0 || c.this.hfG.getChildAt(0).getTop() < 0) {
                    if (c.this.hfG.getTop() <= c.this.hfN.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hfR - l.e(c.this.hfC, d.e.ds20))) && f2 < ((float) (c.this.hfR + l.e(c.this.hfC, d.e.ds20)));
                }
                return true;
            }
        });
        this.hfR = l.e(this.hfC, d.e.ds902);
    }

    public boolean bDc() {
        return this.hfV;
    }

    public void dN(List<d> list) {
        if (!w.A(list)) {
            this.hfU = list;
            d dVar = list.get(0);
            if (this.hfI != null) {
                this.hfI.setVideoPath(dVar.getVideoPath());
                this.hfK = dVar.getVideoPath();
                this.hfT = dVar;
                if (this.hfL != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hfC);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hfL.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hfI.start();
            }
            if (this.hfH != null) {
                this.hfH.setData(list);
                bDk();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.k.no_local_video_tip);
    }

    public void bDd() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hfC).cc(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hfC.getPageContext());
        a.ax(false);
        a.xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hfC) / l.e(this.hfC, d.e.ds902)) {
            i3 = l.ah(this.hfC);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.hfC, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.hfI.setVideoHeight(i4);
        this.hfI.setVideoWidth(i3);
        this.hfI.invalidate();
    }

    public void uU(String str) {
        if (this.hfH != null) {
            this.hfH.uT(str);
        }
    }

    public TextView bDe() {
        return this.dvw;
    }

    public TextView bDf() {
        return this.hfJ;
    }

    public void bDg() {
        if (this.hfI != null && !StringUtils.isNull(this.hfK)) {
            this.hfI.start();
        }
    }

    public void bDh() {
        if (this.hfI != null && !StringUtils.isNull(this.hfK)) {
            this.hfI.resume();
            this.hfI.seekTo(this.hfS);
            if (this.hfW) {
                this.hfI.start();
            }
        }
    }

    public void avz() {
        this.hfS = this.hfI.getCurrentPosition();
        if (this.hfI != null) {
            this.hfI.pause();
        }
    }

    public void avA() {
        this.hfS = this.hfI.getCurrentPosition();
        if (this.hfI != null) {
            this.hfI.stopPlayback();
        }
    }

    public String bDi() {
        return this.hfK;
    }

    public d bDj() {
        return this.hfT;
    }

    private void bDk() {
        if (!w.A(this.hfU)) {
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
                        if (i2 >= c.this.hfU.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hfU.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.g(extractMetadata, 0));
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
                                        dVar.D(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.nk(true);
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
                /* renamed from: b */
                public void onProgressUpdate(Integer... numArr) {
                    super.onProgressUpdate(numArr);
                    c.this.hfH.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hfH.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
