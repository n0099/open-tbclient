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
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.d;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private TextView cLP;
    private RelativeLayout fbY;
    private a gHA;
    private CustomVideoView gHB;
    private TextView gHC;
    private String gHD;
    private ImageView gHE;
    private ExpandViewRelativeLayout gHF;
    private FrameLayout gHG;
    private int gHH;
    private int gHI;
    private int gHJ;
    private int gHK;
    private int gHL;
    private d gHM;
    private List<d> gHN;
    private boolean gHO;
    private boolean gHP;
    private LocalVideoActivity gHv;
    private ExpandGridView gHz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gHO = false;
        this.gHP = true;
        this.gHv = localVideoActivity;
        this.gHF = (ExpandViewRelativeLayout) this.gHv.findViewById(d.g.container);
        this.gHz = (ExpandGridView) this.gHv.findViewById(d.g.local_video_gridview);
        this.fbY = (RelativeLayout) this.gHv.findViewById(d.g.preview_videoview_container);
        this.gHE = (ImageView) this.gHv.findViewById(d.g.video_cover);
        this.gHG = (FrameLayout) this.gHv.findViewById(d.g.top_container);
        this.gHB = (CustomVideoView) this.gHv.findViewById(d.g.preview_videoview);
        this.gHB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cb(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gHB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.gHO = true;
                c.this.gHB.stopPlayback();
                return false;
            }
        });
        this.cLP = (TextView) this.gHv.findViewById(d.g.close_btn);
        this.gHC = (TextView) this.gHv.findViewById(d.g.next_step_btn);
        this.gHC.setOnClickListener(onClickListener);
        this.cLP.setOnClickListener(onClickListener);
        this.gHA = new a(this.gHv);
        this.gHz.setAdapter((ListAdapter) this.gHA);
        this.gHz.setSelector(new ColorDrawable(0));
        this.gHz.setVerticalScrollBarEnabled(false);
        this.gHz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gHO = false;
                    c.this.gHF.setIsCanLayout(true);
                    c.this.fbY.layout(c.this.fbY.getLeft(), 0, c.this.fbY.getRight(), c.this.gHK);
                    c.this.gHz.layout(c.this.gHz.getLeft(), c.this.gHK, c.this.gHz.getRight(), c.this.gHz.getBottom());
                    c.this.gHG.layout(c.this.gHG.getTop(), c.this.gHG.getLeft(), c.this.gHG.getRight(), c.this.gHG.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gHD) && c.this.gHB != null) {
                        c.this.gHB.setVisibility(8);
                        c.this.gHB.stopPlayback();
                        c.this.gHB.setVideoPath(dVar.getVideoPath());
                        c.this.gHB.setVisibility(0);
                        c.this.gHD = dVar.getVideoPath();
                        c.this.gHM = dVar;
                        if (c.this.gHE != null) {
                            c.this.gHE.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gHv);
                            blurDrawable.init(12, 8, dVar.bzO());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gHE.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gHB.start();
                    }
                }
            }
        });
        this.gHF.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void ae(float f) {
                c.this.gHH = c.this.gHz.getTop();
                c.this.gHI = c.this.fbY.getTop();
                c.this.gHJ = c.this.gHF.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.gHF.setIsCanLayout(false);
                int i2 = (int) (c.this.gHH + f2);
                int i3 = i == 1 ? (int) (c.this.gHI + f2) : (int) (c.this.gHI + (f2 * 0.3d));
                if (i2 >= c.this.gHG.getBottom() && i2 <= l.f(c.this.gHv, d.e.ds902)) {
                    c.this.fbY.layout(c.this.fbY.getLeft(), i3, c.this.fbY.getRight(), c.this.gHK + i3);
                    c.this.gHz.layout(c.this.gHz.getLeft(), i2, c.this.gHz.getRight(), c.this.gHz.getBottom());
                    if (i2 <= l.f(c.this.gHv, d.e.ds400)) {
                        c.this.gHP = false;
                        c.this.gHB.pause();
                    } else {
                        c.this.gHP = true;
                        c.this.gHB.start();
                    }
                    float f3 = (l.f(c.this.gHv, d.e.ds902) - i2) / l.f(c.this.gHv, d.e.ds902);
                    if (f3 == 0.0f) {
                        c.this.gHE.setVisibility(8);
                        return;
                    }
                    c.this.gHE.setVisibility(0);
                    c.this.gHE.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void byM() {
                if (c.this.gHz.getTop() > c.this.gHJ / 2) {
                    c.this.gHP = true;
                    c.this.gHB.start();
                    c.this.gHE.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fbY.getBottom(), c.this.gHK);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fbY.layout(c.this.fbY.getLeft(), 0, c.this.fbY.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gHz.getTop(), c.this.gHK);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gHz.layout(c.this.gHz.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gHz.getRight(), c.this.gHz.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.gHP = false;
                c.this.gHB.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fbY.getBottom(), l.f(c.this.gHv, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fbY.layout(c.this.fbY.getLeft(), intValue - c.this.gHK, c.this.fbY.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gHz.getTop(), l.f(c.this.gHv, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gHz.layout(c.this.gHz.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gHz.getRight(), c.this.gHz.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.gHz.getTop() > c.this.gHG.getBottom() || c.this.gHz.getFirstVisiblePosition() != 0 || c.this.gHz.getChildCount() <= 0 || c.this.gHz.getChildAt(0).getTop() < 0) {
                    if (c.this.gHz.getTop() <= c.this.gHG.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gHK - l.f(c.this.gHv, d.e.ds20))) && f2 < ((float) (c.this.gHK + l.f(c.this.gHv, d.e.ds20)));
                }
                return true;
            }
        });
        this.gHK = l.f(this.gHv, d.e.ds902);
    }

    public boolean bzF() {
        return this.gHO;
    }

    public void dE(List<d> list) {
        if (!v.v(list)) {
            this.gHN = list;
            d dVar = list.get(0);
            if (this.gHB != null) {
                this.gHB.setVideoPath(dVar.getVideoPath());
                this.gHD = dVar.getVideoPath();
                this.gHM = dVar;
                if (this.gHE != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gHv);
                    blurDrawable.init(12, 8, dVar.bzO());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gHE.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gHB.start();
            }
            if (this.gHA != null) {
                this.gHA.setData(list);
                bzN();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bzG() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gHv).cb(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gHv.getPageContext());
        a.ap(false);
        a.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.gHv) / l.f(this.gHv, d.e.ds902)) {
            i3 = l.ac(this.gHv);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gHv, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gHB.setVideoHeight(i4);
        this.gHB.setVideoWidth(i3);
        this.gHB.invalidate();
    }

    public void tw(String str) {
        if (this.gHA != null) {
            this.gHA.tv(str);
        }
    }

    public TextView bzH() {
        return this.cLP;
    }

    public TextView bzI() {
        return this.gHC;
    }

    public void bzJ() {
        if (this.gHB != null && !StringUtils.isNull(this.gHD)) {
            this.gHB.start();
        }
    }

    public void bzK() {
        if (this.gHB != null && !StringUtils.isNull(this.gHD)) {
            this.gHB.resume();
            this.gHB.seekTo(this.gHL);
            if (this.gHP) {
                this.gHB.start();
            }
        }
    }

    public void akG() {
        this.gHL = this.gHB.getCurrentPosition();
        if (this.gHB != null) {
            this.gHB.pause();
        }
    }

    public void akH() {
        this.gHL = this.gHB.getCurrentPosition();
        if (this.gHB != null) {
            this.gHB.stopPlayback();
        }
    }

    public String bzL() {
        return this.gHD;
    }

    public d bzM() {
        return this.gHM;
    }

    private void bzN() {
        if (!v.v(this.gHN)) {
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
                        if (i2 >= c.this.gHN.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gHN.get(i2);
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
                                        dVar.s(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.ng(true);
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
                    c.this.gHA.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gHA.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
