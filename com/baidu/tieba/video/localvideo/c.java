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
import com.baidu.tieba.e;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private TextView dEQ;
    private RelativeLayout fUI;
    private LocalVideoActivity hoI;
    private ExpandGridView hoM;
    private a hoN;
    private CustomVideoView hoO;
    private TextView hoP;
    private String hoQ;
    private ImageView hoR;
    private ExpandViewRelativeLayout hoS;
    private FrameLayout hoT;
    private int hoU;
    private int hoV;
    private int hoW;
    private int hoX;
    private int hoY;
    private d hoZ;
    private List<d> hpa;
    private boolean hpb;
    private boolean hpc;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hpb = false;
        this.hpc = true;
        this.hoI = localVideoActivity;
        this.hoS = (ExpandViewRelativeLayout) this.hoI.findViewById(e.g.container);
        this.hoM = (ExpandGridView) this.hoI.findViewById(e.g.local_video_gridview);
        this.fUI = (RelativeLayout) this.hoI.findViewById(e.g.preview_videoview_container);
        this.hoR = (ImageView) this.hoI.findViewById(e.g.video_cover);
        this.hoT = (FrameLayout) this.hoI.findViewById(e.g.top_container);
        this.hoO = (CustomVideoView) this.hoI.findViewById(e.g.preview_videoview);
        this.hoO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bR(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hoO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hpb = true;
                c.this.hoO.stopPlayback();
                return false;
            }
        });
        this.dEQ = (TextView) this.hoI.findViewById(e.g.close_btn);
        this.hoP = (TextView) this.hoI.findViewById(e.g.next_step_btn);
        this.hoP.setOnClickListener(onClickListener);
        this.dEQ.setOnClickListener(onClickListener);
        this.hoN = new a(this.hoI);
        this.hoM.setAdapter((ListAdapter) this.hoN);
        this.hoM.setSelector(new ColorDrawable(0));
        this.hoM.setVerticalScrollBarEnabled(false);
        this.hoM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hpb = false;
                    c.this.hoS.setIsCanLayout(true);
                    c.this.fUI.layout(c.this.fUI.getLeft(), 0, c.this.fUI.getRight(), c.this.hoX);
                    c.this.hoM.layout(c.this.hoM.getLeft(), c.this.hoX, c.this.hoM.getRight(), c.this.hoM.getBottom());
                    c.this.hoT.layout(c.this.hoT.getTop(), c.this.hoT.getLeft(), c.this.hoT.getRight(), c.this.hoT.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hoQ) && c.this.hoO != null) {
                        c.this.hoO.setVisibility(8);
                        c.this.hoO.stopPlayback();
                        c.this.hoO.setVideoPath(dVar.getVideoPath());
                        c.this.hoO.setVisibility(0);
                        c.this.hoQ = dVar.getVideoPath();
                        c.this.hoZ = dVar;
                        if (c.this.hoR != null) {
                            c.this.hoR.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hoI);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hoR.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hoO.start();
                    }
                }
            }
        });
        this.hoS.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void ay(float f) {
                c.this.hoU = c.this.hoM.getTop();
                c.this.hoV = c.this.fUI.getTop();
                c.this.hoW = c.this.hoS.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hoS.setIsCanLayout(false);
                int i2 = (int) (c.this.hoU + f2);
                int i3 = i == 1 ? (int) (c.this.hoV + f2) : (int) (c.this.hoV + (f2 * 0.3d));
                if (i2 >= c.this.hoT.getBottom() && i2 <= l.h(c.this.hoI, e.C0141e.ds902)) {
                    c.this.fUI.layout(c.this.fUI.getLeft(), i3, c.this.fUI.getRight(), c.this.hoX + i3);
                    c.this.hoM.layout(c.this.hoM.getLeft(), i2, c.this.hoM.getRight(), c.this.hoM.getBottom());
                    if (i2 <= l.h(c.this.hoI, e.C0141e.ds400)) {
                        c.this.hpc = false;
                        c.this.hoO.pause();
                    } else {
                        c.this.hpc = true;
                        c.this.hoO.start();
                    }
                    float h = (l.h(c.this.hoI, e.C0141e.ds902) - i2) / l.h(c.this.hoI, e.C0141e.ds902);
                    if (h == 0.0f) {
                        c.this.hoR.setVisibility(8);
                        return;
                    }
                    c.this.hoR.setVisibility(0);
                    c.this.hoR.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bDs() {
                if (c.this.hoM.getTop() > c.this.hoW / 2) {
                    c.this.hpc = true;
                    c.this.hoO.start();
                    c.this.hoR.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fUI.getBottom(), c.this.hoX);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fUI.layout(c.this.fUI.getLeft(), 0, c.this.fUI.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hoM.getTop(), c.this.hoX);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hoM.layout(c.this.hoM.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hoM.getRight(), c.this.hoM.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hpc = false;
                c.this.hoO.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fUI.getBottom(), l.h(c.this.hoI, e.C0141e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fUI.layout(c.this.fUI.getLeft(), intValue - c.this.hoX, c.this.fUI.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hoM.getTop(), l.h(c.this.hoI, e.C0141e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hoM.layout(c.this.hoM.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hoM.getRight(), c.this.hoM.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hoM.getTop() > c.this.hoT.getBottom() || c.this.hoM.getFirstVisiblePosition() != 0 || c.this.hoM.getChildCount() <= 0 || c.this.hoM.getChildAt(0).getTop() < 0) {
                    if (c.this.hoM.getTop() <= c.this.hoT.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hoX - l.h(c.this.hoI, e.C0141e.ds20))) && f2 < ((float) (c.this.hoX + l.h(c.this.hoI, e.C0141e.ds20)));
                }
                return true;
            }
        });
        this.hoX = l.h(this.hoI, e.C0141e.ds902);
    }

    public boolean bEE() {
        return this.hpb;
    }

    public void dK(List<d> list) {
        if (!v.z(list)) {
            this.hpa = list;
            d dVar = list.get(0);
            if (this.hoO != null) {
                this.hoO.setVideoPath(dVar.getVideoPath());
                this.hoQ = dVar.getVideoPath();
                this.hoZ = dVar;
                if (this.hoR != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hoI);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hoR.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hoO.start();
            }
            if (this.hoN != null) {
                this.hoN.setData(list);
                bEM();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), e.j.no_local_video_tip);
    }

    public void bEF() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hoI).co(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hoI.getPageContext());
        a.aF(false);
        a.yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hoI) / l.h(this.hoI, e.C0141e.ds902)) {
            i3 = l.aO(this.hoI);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hoI, e.C0141e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hoO.setVideoHeight(i4);
        this.hoO.setVideoWidth(i3);
        this.hoO.invalidate();
    }

    public void vF(String str) {
        if (this.hoN != null) {
            this.hoN.vE(str);
        }
    }

    public TextView bEG() {
        return this.dEQ;
    }

    public TextView bEH() {
        return this.hoP;
    }

    public void bEI() {
        if (this.hoO != null && !StringUtils.isNull(this.hoQ)) {
            this.hoO.start();
        }
    }

    public void bEJ() {
        if (this.hoO != null && !StringUtils.isNull(this.hoQ)) {
            this.hoO.resume();
            this.hoO.seekTo(this.hoY);
            if (this.hpc) {
                this.hoO.start();
            }
        }
    }

    public void ayn() {
        this.hoY = this.hoO.getCurrentPosition();
        if (this.hoO != null) {
            this.hoO.pause();
        }
    }

    public void ayo() {
        this.hoY = this.hoO.getCurrentPosition();
        if (this.hoO != null) {
            this.hoO.stopPlayback();
        }
    }

    public String bEK() {
        return this.hoQ;
    }

    public d bEL() {
        return this.hoZ;
    }

    private void bEM() {
        if (!v.z(this.hpa)) {
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
                        if (i2 >= c.this.hpa.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hpa.get(i2);
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
                            dVar.nt(true);
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
                    c.this.hoN.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hoN.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
