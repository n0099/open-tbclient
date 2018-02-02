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
    private TextView dMz;
    private RelativeLayout fYN;
    private LocalVideoActivity hrO;
    private ExpandGridView hrS;
    private a hrT;
    private CustomVideoView hrU;
    private TextView hrV;
    private String hrW;
    private ImageView hrX;
    private ExpandViewRelativeLayout hrY;
    private FrameLayout hrZ;
    private int hsa;
    private int hsb;
    private int hsc;
    private int hsd;
    private int hse;
    private d hsf;
    private List<d> hsg;
    private boolean hsh;
    private boolean hsi;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hsh = false;
        this.hsi = true;
        this.hrO = localVideoActivity;
        this.hrY = (ExpandViewRelativeLayout) this.hrO.findViewById(d.g.container);
        this.hrS = (ExpandGridView) this.hrO.findViewById(d.g.local_video_gridview);
        this.fYN = (RelativeLayout) this.hrO.findViewById(d.g.preview_videoview_container);
        this.hrX = (ImageView) this.hrO.findViewById(d.g.video_cover);
        this.hrZ = (FrameLayout) this.hrO.findViewById(d.g.top_container);
        this.hrU = (CustomVideoView) this.hrO.findViewById(d.g.preview_videoview);
        this.hrU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cT(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hrU.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hsh = true;
                c.this.hrU.stopPlayback();
                return false;
            }
        });
        this.dMz = (TextView) this.hrO.findViewById(d.g.close_btn);
        this.hrV = (TextView) this.hrO.findViewById(d.g.next_step_btn);
        this.hrV.setOnClickListener(onClickListener);
        this.dMz.setOnClickListener(onClickListener);
        this.hrT = new a(this.hrO);
        this.hrS.setAdapter((ListAdapter) this.hrT);
        this.hrS.setSelector(new ColorDrawable(0));
        this.hrS.setVerticalScrollBarEnabled(false);
        this.hrS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hsh = false;
                    c.this.hrY.setIsCanLayout(true);
                    c.this.fYN.layout(c.this.fYN.getLeft(), 0, c.this.fYN.getRight(), c.this.hsd);
                    c.this.hrS.layout(c.this.hrS.getLeft(), c.this.hsd, c.this.hrS.getRight(), c.this.hrS.getBottom());
                    c.this.hrZ.layout(c.this.hrZ.getTop(), c.this.hrZ.getLeft(), c.this.hrZ.getRight(), c.this.hrZ.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hrW) && c.this.hrU != null) {
                        c.this.hrU.setVisibility(8);
                        c.this.hrU.stopPlayback();
                        c.this.hrU.setVideoPath(dVar.getVideoPath());
                        c.this.hrU.setVisibility(0);
                        c.this.hrW = dVar.getVideoPath();
                        c.this.hsf = dVar;
                        if (c.this.hrX != null) {
                            c.this.hrX.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hrO);
                            blurDrawable.init(12, 8, dVar.bBO());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hrX.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hrU.start();
                    }
                }
            }
        });
        this.hrY.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aA(float f) {
                c.this.hsa = c.this.hrS.getTop();
                c.this.hsb = c.this.fYN.getTop();
                c.this.hsc = c.this.hrY.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hrY.setIsCanLayout(false);
                int i2 = (int) (c.this.hsa + f2);
                int i3 = i == 1 ? (int) (c.this.hsb + f2) : (int) (c.this.hsb + (f2 * 0.3d));
                if (i2 >= c.this.hrZ.getBottom() && i2 <= l.s(c.this.hrO, d.e.ds902)) {
                    c.this.fYN.layout(c.this.fYN.getLeft(), i3, c.this.fYN.getRight(), c.this.hsd + i3);
                    c.this.hrS.layout(c.this.hrS.getLeft(), i2, c.this.hrS.getRight(), c.this.hrS.getBottom());
                    if (i2 <= l.s(c.this.hrO, d.e.ds400)) {
                        c.this.hsi = false;
                        c.this.hrU.pause();
                    } else {
                        c.this.hsi = true;
                        c.this.hrU.start();
                    }
                    float s = (l.s(c.this.hrO, d.e.ds902) - i2) / l.s(c.this.hrO, d.e.ds902);
                    if (s == 0.0f) {
                        c.this.hrX.setVisibility(8);
                        return;
                    }
                    c.this.hrX.setVisibility(0);
                    c.this.hrX.setAlpha(s);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bAs() {
                if (c.this.hrS.getTop() > c.this.hsc / 2) {
                    c.this.hsi = true;
                    c.this.hrU.start();
                    c.this.hrX.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fYN.getBottom(), c.this.hsd);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fYN.layout(c.this.fYN.getLeft(), 0, c.this.fYN.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hrS.getTop(), c.this.hsd);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hrS.layout(c.this.hrS.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hrS.getRight(), c.this.hrS.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hsi = false;
                c.this.hrU.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fYN.getBottom(), l.s(c.this.hrO, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fYN.layout(c.this.fYN.getLeft(), intValue - c.this.hsd, c.this.fYN.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hrS.getTop(), l.s(c.this.hrO, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hrS.layout(c.this.hrS.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hrS.getRight(), c.this.hrS.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hrS.getTop() > c.this.hrZ.getBottom() || c.this.hrS.getFirstVisiblePosition() != 0 || c.this.hrS.getChildCount() <= 0 || c.this.hrS.getChildAt(0).getTop() < 0) {
                    if (c.this.hrS.getTop() <= c.this.hrZ.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hsd - l.s(c.this.hrO, d.e.ds20))) && f2 < ((float) (c.this.hsd + l.s(c.this.hrO, d.e.ds20)));
                }
                return true;
            }
        });
        this.hsd = l.s(this.hrO, d.e.ds902);
    }

    public boolean bBF() {
        return this.hsh;
    }

    public void dF(List<d> list) {
        if (!v.E(list)) {
            this.hsg = list;
            d dVar = list.get(0);
            if (this.hrU != null) {
                this.hrU.setVideoPath(dVar.getVideoPath());
                this.hrW = dVar.getVideoPath();
                this.hsf = dVar;
                if (this.hrX != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hrO);
                    blurDrawable.init(12, 8, dVar.bBO());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hrX.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hrU.start();
            }
            if (this.hrT != null) {
                this.hrT.setData(list);
                bBN();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bBG() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hrO).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hrO.getPageContext());
        a.aX(false);
        a.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hrO) / l.s(this.hrO, d.e.ds902)) {
            i3 = l.ao(this.hrO);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int s = l.s(this.hrO, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((s / i2) * i);
                i4 = s;
            } else {
                i3 = 0;
                i4 = s;
            }
        }
        this.hrU.setVideoHeight(i4);
        this.hrU.setVideoWidth(i3);
        this.hrU.invalidate();
    }

    public void tQ(String str) {
        if (this.hrT != null) {
            this.hrT.tP(str);
        }
    }

    public TextView bBH() {
        return this.dMz;
    }

    public TextView bBI() {
        return this.hrV;
    }

    public void bBJ() {
        if (this.hrU != null && !StringUtils.isNull(this.hrW)) {
            this.hrU.start();
        }
    }

    public void bBK() {
        if (this.hrU != null && !StringUtils.isNull(this.hrW)) {
            this.hrU.resume();
            this.hrU.seekTo(this.hse);
            if (this.hsi) {
                this.hrU.start();
            }
        }
    }

    public void avA() {
        this.hse = this.hrU.getCurrentPosition();
        if (this.hrU != null) {
            this.hrU.pause();
        }
    }

    public void avB() {
        this.hse = this.hrU.getCurrentPosition();
        if (this.hrU != null) {
            this.hrU.stopPlayback();
        }
    }

    public String bBL() {
        return this.hrW;
    }

    public d bBM() {
        return this.hsf;
    }

    private void bBN() {
        if (!v.E(this.hsg)) {
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
                        if (i2 >= c.this.hsg.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hsg.get(i2);
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
                            dVar.nh(true);
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
                    c.this.hrT.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.hrT.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
