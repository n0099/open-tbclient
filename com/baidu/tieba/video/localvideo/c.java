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
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private TextView flw;
    private RelativeLayout hEy;
    private LocalVideoActivity iZK;
    private ExpandGridView iZO;
    private a iZP;
    private CustomVideoView iZQ;
    private TextView iZR;
    private String iZS;
    private ImageView iZT;
    private ExpandViewRelativeLayout iZU;
    private FrameLayout iZV;
    private int iZW;
    private int iZX;
    private int iZY;
    private int iZZ;
    private int jaa;
    private d jab;
    private List<d> jac;
    private boolean jad;
    private boolean jae;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.jad = false;
        this.jae = true;
        this.iZK = localVideoActivity;
        this.iZU = (ExpandViewRelativeLayout) this.iZK.findViewById(d.g.container);
        this.iZO = (ExpandGridView) this.iZK.findViewById(d.g.local_video_gridview);
        this.hEy = (RelativeLayout) this.iZK.findViewById(d.g.preview_videoview_container);
        this.iZT = (ImageView) this.iZK.findViewById(d.g.video_cover);
        this.iZV = (FrameLayout) this.iZK.findViewById(d.g.top_container);
        this.iZQ = (CustomVideoView) this.iZK.findViewById(d.g.preview_videoview);
        this.iZQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cu(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.iZQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.jad = true;
                c.this.iZQ.stopPlayback();
                return false;
            }
        });
        this.flw = (TextView) this.iZK.findViewById(d.g.close_btn);
        this.iZR = (TextView) this.iZK.findViewById(d.g.next_step_btn);
        this.iZR.setOnClickListener(onClickListener);
        this.flw.setOnClickListener(onClickListener);
        this.iZP = new a(this.iZK);
        this.iZO.setAdapter((ListAdapter) this.iZP);
        this.iZO.setSelector(new ColorDrawable(0));
        this.iZO.setVerticalScrollBarEnabled(false);
        this.iZO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.jad = false;
                    c.this.iZU.setIsCanLayout(true);
                    c.this.hEy.layout(c.this.hEy.getLeft(), 0, c.this.hEy.getRight(), c.this.iZZ);
                    c.this.iZO.layout(c.this.iZO.getLeft(), c.this.iZZ, c.this.iZO.getRight(), c.this.iZO.getBottom());
                    c.this.iZV.layout(c.this.iZV.getTop(), c.this.iZV.getLeft(), c.this.iZV.getRight(), c.this.iZV.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.iZS) && c.this.iZQ != null) {
                        c.this.iZQ.setVisibility(8);
                        c.this.iZQ.stopPlayback();
                        c.this.iZQ.setVideoPath(dVar.getVideoPath());
                        c.this.iZQ.setVisibility(0);
                        c.this.iZS = dVar.getVideoPath();
                        c.this.jab = dVar;
                        if (c.this.iZT != null) {
                            c.this.iZT.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.iZK);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.iZT.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.iZQ.start();
                    }
                }
            }
        });
        this.iZU.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aO(float f) {
                c.this.iZW = c.this.iZO.getTop();
                c.this.iZX = c.this.hEy.getTop();
                c.this.iZY = c.this.iZU.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.iZU.setIsCanLayout(false);
                int i2 = (int) (c.this.iZW + f2);
                int i3 = i == 1 ? (int) (c.this.iZX + f2) : (int) (c.this.iZX + (f2 * 0.3d));
                if (i2 >= c.this.iZV.getBottom() && i2 <= l.h(c.this.iZK, d.e.ds902)) {
                    c.this.hEy.layout(c.this.hEy.getLeft(), i3, c.this.hEy.getRight(), c.this.iZZ + i3);
                    c.this.iZO.layout(c.this.iZO.getLeft(), i2, c.this.iZO.getRight(), c.this.iZO.getBottom());
                    if (i2 <= l.h(c.this.iZK, d.e.ds400)) {
                        c.this.jae = false;
                        c.this.iZQ.pause();
                    } else {
                        c.this.jae = true;
                        c.this.iZQ.start();
                    }
                    float h = (l.h(c.this.iZK, d.e.ds902) - i2) / l.h(c.this.iZK, d.e.ds902);
                    if (h == 0.0f) {
                        c.this.iZT.setVisibility(8);
                        return;
                    }
                    c.this.iZT.setVisibility(0);
                    c.this.iZT.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cji() {
                if (c.this.iZO.getTop() > c.this.iZY / 2) {
                    c.this.jae = true;
                    c.this.iZQ.start();
                    c.this.iZT.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.hEy.getBottom(), c.this.iZZ);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hEy.layout(c.this.hEy.getLeft(), 0, c.this.hEy.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.iZO.getTop(), c.this.iZZ);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iZO.layout(c.this.iZO.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.iZO.getRight(), c.this.iZO.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.jae = false;
                c.this.iZQ.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.hEy.getBottom(), l.h(c.this.iZK, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.hEy.layout(c.this.hEy.getLeft(), intValue - c.this.iZZ, c.this.hEy.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.iZO.getTop(), l.h(c.this.iZK, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.iZO.layout(c.this.iZO.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.iZO.getRight(), c.this.iZO.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.iZO.getTop() > c.this.iZV.getBottom() || c.this.iZO.getFirstVisiblePosition() != 0 || c.this.iZO.getChildCount() <= 0 || c.this.iZO.getChildAt(0).getTop() < 0) {
                    if (c.this.iZO.getTop() <= c.this.iZV.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.iZZ - l.h(c.this.iZK, d.e.ds20))) && f2 < ((float) (c.this.iZZ + l.h(c.this.iZK, d.e.ds20)));
                }
                return true;
            }
        });
        this.iZZ = l.h(this.iZK, d.e.ds902);
    }

    public boolean cku() {
        return this.jad;
    }

    public void ei(List<d> list) {
        if (!v.T(list)) {
            this.jac = list;
            d dVar = list.get(0);
            if (this.iZQ != null) {
                this.iZQ.setVideoPath(dVar.getVideoPath());
                this.iZS = dVar.getVideoPath();
                this.jab = dVar;
                if (this.iZT != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.iZK);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.iZT.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.iZQ.start();
            }
            if (this.iZP != null) {
                this.iZP.setData(list);
                ckC();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void ckv() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.iZK).gC(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.iZK.getPageContext());
        a.dr(false);
        a.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.iZK) / l.h(this.iZK, d.e.ds902)) {
            i3 = l.aO(this.iZK);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.iZK, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.iZQ.setVideoHeight(i4);
        this.iZQ.setVideoWidth(i3);
        this.iZQ.invalidate();
    }

    public void DI(String str) {
        if (this.iZP != null) {
            this.iZP.DH(str);
        }
    }

    public TextView ckw() {
        return this.flw;
    }

    public TextView ckx() {
        return this.iZR;
    }

    public void cky() {
        if (this.iZQ != null && !StringUtils.isNull(this.iZS)) {
            this.iZQ.start();
        }
    }

    public void ckz() {
        if (this.iZQ != null && !StringUtils.isNull(this.iZS)) {
            this.iZQ.resume();
            this.iZQ.seekTo(this.jaa);
            if (this.jae) {
                this.iZQ.start();
            }
        }
    }

    public void beL() {
        this.jaa = this.iZQ.getCurrentPosition();
        if (this.iZQ != null) {
            this.iZQ.pause();
        }
    }

    public void beM() {
        this.jaa = this.iZQ.getCurrentPosition();
        if (this.iZQ != null) {
            this.iZQ.stopPlayback();
        }
    }

    public String ckA() {
        return this.iZS;
    }

    public d ckB() {
        return this.jab;
    }

    private void ckC() {
        if (!v.T(this.jac)) {
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
                        if (i2 >= c.this.jac.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.jac.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.l(extractMetadata, 0));
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
                                        dVar.L(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.qE(true);
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
                    c.this.iZP.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.iZP.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
