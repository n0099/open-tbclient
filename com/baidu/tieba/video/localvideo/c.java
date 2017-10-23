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
    private TextView cDD;
    private RelativeLayout eSX;
    private LocalVideoActivity gwJ;
    private ExpandGridView gwN;
    private a gwO;
    private CustomVideoView gwP;
    private TextView gwQ;
    private String gwR;
    private ImageView gwS;
    private ExpandViewRelativeLayout gwT;
    private FrameLayout gwU;
    private int gwV;
    private int gwW;
    private int gwX;
    private int gwY;
    private int gwZ;
    private d gxa;
    private List<d> gxb;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gwJ = localVideoActivity;
        this.gwT = (ExpandViewRelativeLayout) this.gwJ.findViewById(d.h.container);
        this.gwN = (ExpandGridView) this.gwJ.findViewById(d.h.local_video_gridview);
        this.eSX = (RelativeLayout) this.gwJ.findViewById(d.h.preview_videoview_container);
        this.gwS = (ImageView) this.gwJ.findViewById(d.h.video_cover);
        this.gwU = (FrameLayout) this.gwJ.findViewById(d.h.top_container);
        this.gwP = (CustomVideoView) this.gwJ.findViewById(d.h.preview_videoview);
        this.gwP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.ca(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.cDD = (TextView) this.gwJ.findViewById(d.h.close_btn);
        this.gwQ = (TextView) this.gwJ.findViewById(d.h.next_step_btn);
        this.gwQ.setOnClickListener(onClickListener);
        this.cDD.setOnClickListener(onClickListener);
        this.gwO = new a(this.gwJ);
        this.gwN.setAdapter((ListAdapter) this.gwO);
        this.gwN.setSelector(new ColorDrawable(0));
        this.gwN.setVerticalScrollBarEnabled(false);
        this.gwN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v12, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gwT.setIsCanLayout(true);
                    c.this.eSX.layout(c.this.eSX.getLeft(), 0, c.this.eSX.getRight(), c.this.gwY);
                    c.this.gwN.layout(c.this.gwN.getLeft(), c.this.gwY, c.this.gwN.getRight(), c.this.gwN.getBottom());
                    c.this.gwU.layout(c.this.gwU.getTop(), c.this.gwU.getLeft(), c.this.gwU.getRight(), c.this.gwU.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gwR) && c.this.gwP != null) {
                        c.this.gwP.setVisibility(8);
                        c.this.gwP.stopPlayback();
                        c.this.gwP.setVideoPath(dVar.getVideoPath());
                        c.this.gwP.setVisibility(0);
                        c.this.gwR = dVar.getVideoPath();
                        c.this.gxa = dVar;
                        if (c.this.gwS != null) {
                            c.this.gwS.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gwJ);
                            blurDrawable.init(12, 8, dVar.bwp());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gwS.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gwP.start();
                    }
                }
            }
        });
        this.gwT.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.3
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void af(float f) {
                c.this.gwV = c.this.gwN.getTop();
                c.this.gwW = c.this.eSX.getTop();
                c.this.gwX = c.this.gwT.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.gwT.setIsCanLayout(false);
                int i2 = (int) (c.this.gwV + f2);
                int i3 = i == 1 ? (int) (c.this.gwW + f2) : (int) (c.this.gwW + (f2 * 0.3d));
                if (i2 >= c.this.gwU.getBottom() && i2 <= l.f(c.this.gwJ, d.f.ds902)) {
                    c.this.eSX.layout(c.this.eSX.getLeft(), i3, c.this.eSX.getRight(), c.this.gwY + i3);
                    c.this.gwN.layout(c.this.gwN.getLeft(), i2, c.this.gwN.getRight(), c.this.gwN.getBottom());
                    if (i2 <= l.f(c.this.gwJ, d.f.ds400)) {
                        c.this.gwP.pause();
                    } else {
                        c.this.gwP.start();
                    }
                    float f3 = (l.f(c.this.gwJ, d.f.ds902) - i2) / l.f(c.this.gwJ, d.f.ds902);
                    if (f3 == 0.0f) {
                        c.this.gwS.setVisibility(8);
                        return;
                    }
                    c.this.gwS.setVisibility(0);
                    c.this.gwS.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bvx() {
                if (c.this.gwN.getTop() > c.this.gwX / 2) {
                    c.this.gwP.start();
                    c.this.gwS.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.eSX.getBottom(), c.this.gwY);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.eSX.layout(c.this.eSX.getLeft(), 0, c.this.eSX.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gwN.getTop(), c.this.gwY);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gwN.layout(c.this.gwN.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gwN.getRight(), c.this.gwN.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.eSX.getBottom(), l.f(c.this.gwJ, d.f.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.eSX.layout(c.this.eSX.getLeft(), intValue - c.this.gwY, c.this.eSX.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gwN.getTop(), l.f(c.this.gwJ, d.f.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.3.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gwN.layout(c.this.gwN.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gwN.getRight(), c.this.gwN.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.gwN.getTop() > c.this.gwU.getBottom() || c.this.gwN.getFirstVisiblePosition() != 0 || c.this.gwN.getChildCount() <= 0 || c.this.gwN.getChildAt(0).getTop() < 0) {
                    if (c.this.gwN.getTop() <= c.this.gwU.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gwY - l.f(c.this.gwJ, d.f.ds20))) && f2 < ((float) (c.this.gwY + l.f(c.this.gwJ, d.f.ds20)));
                }
                return true;
            }
        });
        this.gwY = l.f(this.gwJ, d.f.ds902);
    }

    public void dB(List<d> list) {
        if (!v.u(list)) {
            this.gxb = list;
            d dVar = list.get(0);
            if (this.gwP != null) {
                this.gwP.setVideoPath(dVar.getVideoPath());
                this.gwR = dVar.getVideoPath();
                this.gxa = dVar;
                if (this.gwS != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gwJ);
                    blurDrawable.init(12, 8, dVar.bwp());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gwS.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gwP.start();
            }
        }
        if (this.gwO != null) {
            this.gwO.setData(list);
            bwo();
        }
    }

    public void bwh() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gwJ).cb(d.l.mv_local_video_too_long).a(d.l.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gwJ.getPageContext());
        a.ar(false);
        a.tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ad(this.gwJ) / l.f(this.gwJ, d.f.ds902)) {
            i3 = l.ad(this.gwJ);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gwJ, d.f.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gwP.setVideoHeight(i4);
        this.gwP.setVideoWidth(i3);
        this.gwP.invalidate();
    }

    public void sE(String str) {
        if (this.gwO != null) {
            this.gwO.sD(str);
        }
    }

    public TextView bwi() {
        return this.cDD;
    }

    public TextView bwj() {
        return this.gwQ;
    }

    public void bwk() {
        if (this.gwP != null && !StringUtils.isNull(this.gwR)) {
            this.gwP.start();
        }
    }

    public void bwl() {
        if (this.gwP != null && !StringUtils.isNull(this.gwR)) {
            this.gwP.resume();
            this.gwP.seekTo(this.gwZ);
            this.gwP.start();
        }
    }

    public void aik() {
        this.gwZ = this.gwP.getCurrentPosition();
        if (this.gwP != null) {
            this.gwP.pause();
        }
    }

    public void ail() {
        this.gwZ = this.gwP.getCurrentPosition();
        if (this.gwP != null) {
            this.gwP.stopPlayback();
        }
    }

    public String bwm() {
        return this.gwR;
    }

    public d bwn() {
        return this.gxa;
    }

    private void bwo() {
        if (!v.u(this.gxb)) {
            new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.video.localvideo.c.5
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
                        if (i2 >= c.this.gxb.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gxb.get(i2);
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
                            dVar.nd(true);
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
                    c.this.gwO.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gwO.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
