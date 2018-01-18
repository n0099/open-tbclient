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
    private TextView dMe;
    private RelativeLayout fYs;
    private CustomVideoView hrA;
    private TextView hrB;
    private String hrC;
    private ImageView hrD;
    private ExpandViewRelativeLayout hrE;
    private FrameLayout hrF;
    private int hrG;
    private int hrH;
    private int hrI;
    private int hrJ;
    private int hrK;
    private d hrL;
    private List<d> hrM;
    private boolean hrN;
    private boolean hrO;
    private LocalVideoActivity hru;
    private ExpandGridView hry;
    private a hrz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hrN = false;
        this.hrO = true;
        this.hru = localVideoActivity;
        this.hrE = (ExpandViewRelativeLayout) this.hru.findViewById(d.g.container);
        this.hry = (ExpandGridView) this.hru.findViewById(d.g.local_video_gridview);
        this.fYs = (RelativeLayout) this.hru.findViewById(d.g.preview_videoview_container);
        this.hrD = (ImageView) this.hru.findViewById(d.g.video_cover);
        this.hrF = (FrameLayout) this.hru.findViewById(d.g.top_container);
        this.hrA = (CustomVideoView) this.hru.findViewById(d.g.preview_videoview);
        this.hrA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cT(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hrA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hrN = true;
                c.this.hrA.stopPlayback();
                return false;
            }
        });
        this.dMe = (TextView) this.hru.findViewById(d.g.close_btn);
        this.hrB = (TextView) this.hru.findViewById(d.g.next_step_btn);
        this.hrB.setOnClickListener(onClickListener);
        this.dMe.setOnClickListener(onClickListener);
        this.hrz = new a(this.hru);
        this.hry.setAdapter((ListAdapter) this.hrz);
        this.hry.setSelector(new ColorDrawable(0));
        this.hry.setVerticalScrollBarEnabled(false);
        this.hry.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hrN = false;
                    c.this.hrE.setIsCanLayout(true);
                    c.this.fYs.layout(c.this.fYs.getLeft(), 0, c.this.fYs.getRight(), c.this.hrJ);
                    c.this.hry.layout(c.this.hry.getLeft(), c.this.hrJ, c.this.hry.getRight(), c.this.hry.getBottom());
                    c.this.hrF.layout(c.this.hrF.getTop(), c.this.hrF.getLeft(), c.this.hrF.getRight(), c.this.hrF.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hrC) && c.this.hrA != null) {
                        c.this.hrA.setVisibility(8);
                        c.this.hrA.stopPlayback();
                        c.this.hrA.setVideoPath(dVar.getVideoPath());
                        c.this.hrA.setVisibility(0);
                        c.this.hrC = dVar.getVideoPath();
                        c.this.hrL = dVar;
                        if (c.this.hrD != null) {
                            c.this.hrD.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hru);
                            blurDrawable.init(12, 8, dVar.bBM());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hrD.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hrA.start();
                    }
                }
            }
        });
        this.hrE.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aA(float f) {
                c.this.hrG = c.this.hry.getTop();
                c.this.hrH = c.this.fYs.getTop();
                c.this.hrI = c.this.hrE.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hrE.setIsCanLayout(false);
                int i2 = (int) (c.this.hrG + f2);
                int i3 = i == 1 ? (int) (c.this.hrH + f2) : (int) (c.this.hrH + (f2 * 0.3d));
                if (i2 >= c.this.hrF.getBottom() && i2 <= l.s(c.this.hru, d.e.ds902)) {
                    c.this.fYs.layout(c.this.fYs.getLeft(), i3, c.this.fYs.getRight(), c.this.hrJ + i3);
                    c.this.hry.layout(c.this.hry.getLeft(), i2, c.this.hry.getRight(), c.this.hry.getBottom());
                    if (i2 <= l.s(c.this.hru, d.e.ds400)) {
                        c.this.hrO = false;
                        c.this.hrA.pause();
                    } else {
                        c.this.hrO = true;
                        c.this.hrA.start();
                    }
                    float s = (l.s(c.this.hru, d.e.ds902) - i2) / l.s(c.this.hru, d.e.ds902);
                    if (s == 0.0f) {
                        c.this.hrD.setVisibility(8);
                        return;
                    }
                    c.this.hrD.setVisibility(0);
                    c.this.hrD.setAlpha(s);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bAq() {
                if (c.this.hry.getTop() > c.this.hrI / 2) {
                    c.this.hrO = true;
                    c.this.hrA.start();
                    c.this.hrD.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fYs.getBottom(), c.this.hrJ);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fYs.layout(c.this.fYs.getLeft(), 0, c.this.fYs.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hry.getTop(), c.this.hrJ);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hry.layout(c.this.hry.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hry.getRight(), c.this.hry.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hrO = false;
                c.this.hrA.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fYs.getBottom(), l.s(c.this.hru, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fYs.layout(c.this.fYs.getLeft(), intValue - c.this.hrJ, c.this.fYs.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hry.getTop(), l.s(c.this.hru, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hry.layout(c.this.hry.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hry.getRight(), c.this.hry.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hry.getTop() > c.this.hrF.getBottom() || c.this.hry.getFirstVisiblePosition() != 0 || c.this.hry.getChildCount() <= 0 || c.this.hry.getChildAt(0).getTop() < 0) {
                    if (c.this.hry.getTop() <= c.this.hrF.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hrJ - l.s(c.this.hru, d.e.ds20))) && f2 < ((float) (c.this.hrJ + l.s(c.this.hru, d.e.ds20)));
                }
                return true;
            }
        });
        this.hrJ = l.s(this.hru, d.e.ds902);
    }

    public boolean bBD() {
        return this.hrN;
    }

    public void dF(List<d> list) {
        if (!v.E(list)) {
            this.hrM = list;
            d dVar = list.get(0);
            if (this.hrA != null) {
                this.hrA.setVideoPath(dVar.getVideoPath());
                this.hrC = dVar.getVideoPath();
                this.hrL = dVar;
                if (this.hrD != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hru);
                    blurDrawable.init(12, 8, dVar.bBM());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hrD.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hrA.start();
            }
            if (this.hrz != null) {
                this.hrz.setData(list);
                bBL();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bBE() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hru).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hru.getPageContext());
        a.aW(false);
        a.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hru) / l.s(this.hru, d.e.ds902)) {
            i3 = l.ao(this.hru);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int s = l.s(this.hru, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((s / i2) * i);
                i4 = s;
            } else {
                i3 = 0;
                i4 = s;
            }
        }
        this.hrA.setVideoHeight(i4);
        this.hrA.setVideoWidth(i3);
        this.hrA.invalidate();
    }

    public void tI(String str) {
        if (this.hrz != null) {
            this.hrz.tH(str);
        }
    }

    public TextView bBF() {
        return this.dMe;
    }

    public TextView bBG() {
        return this.hrB;
    }

    public void bBH() {
        if (this.hrA != null && !StringUtils.isNull(this.hrC)) {
            this.hrA.start();
        }
    }

    public void bBI() {
        if (this.hrA != null && !StringUtils.isNull(this.hrC)) {
            this.hrA.resume();
            this.hrA.seekTo(this.hrK);
            if (this.hrO) {
                this.hrA.start();
            }
        }
    }

    public void avv() {
        this.hrK = this.hrA.getCurrentPosition();
        if (this.hrA != null) {
            this.hrA.pause();
        }
    }

    public void avw() {
        this.hrK = this.hrA.getCurrentPosition();
        if (this.hrA != null) {
            this.hrA.stopPlayback();
        }
    }

    public String bBJ() {
        return this.hrC;
    }

    public d bBK() {
        return this.hrL;
    }

    private void bBL() {
        if (!v.E(this.hrM)) {
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
                        if (i2 >= c.this.hrM.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hrM.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.h(extractMetadata, 0));
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
                                        dVar.x(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.ne(true);
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
                    c.this.hrz.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.hrz.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
