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
import com.baidu.tieba.f;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private TextView dyg;
    private RelativeLayout fMO;
    private LocalVideoActivity hgS;
    private ExpandGridView hgW;
    private a hgX;
    private CustomVideoView hgY;
    private TextView hgZ;
    private String hha;
    private ImageView hhb;
    private ExpandViewRelativeLayout hhc;
    private FrameLayout hhd;
    private int hhe;
    private int hhf;
    private int hhg;
    private int hhh;
    private int hhi;
    private d hhj;
    private List<d> hhk;
    private boolean hhl;
    private boolean hhm;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hhl = false;
        this.hhm = true;
        this.hgS = localVideoActivity;
        this.hhc = (ExpandViewRelativeLayout) this.hgS.findViewById(f.g.container);
        this.hgW = (ExpandGridView) this.hgS.findViewById(f.g.local_video_gridview);
        this.fMO = (RelativeLayout) this.hgS.findViewById(f.g.preview_videoview_container);
        this.hhb = (ImageView) this.hgS.findViewById(f.g.video_cover);
        this.hhd = (FrameLayout) this.hgS.findViewById(f.g.top_container);
        this.hgY = (CustomVideoView) this.hgS.findViewById(f.g.preview_videoview);
        this.hgY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bP(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hgY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hhl = true;
                c.this.hgY.stopPlayback();
                return false;
            }
        });
        this.dyg = (TextView) this.hgS.findViewById(f.g.close_btn);
        this.hgZ = (TextView) this.hgS.findViewById(f.g.next_step_btn);
        this.hgZ.setOnClickListener(onClickListener);
        this.dyg.setOnClickListener(onClickListener);
        this.hgX = new a(this.hgS);
        this.hgW.setAdapter((ListAdapter) this.hgX);
        this.hgW.setSelector(new ColorDrawable(0));
        this.hgW.setVerticalScrollBarEnabled(false);
        this.hgW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hhl = false;
                    c.this.hhc.setIsCanLayout(true);
                    c.this.fMO.layout(c.this.fMO.getLeft(), 0, c.this.fMO.getRight(), c.this.hhh);
                    c.this.hgW.layout(c.this.hgW.getLeft(), c.this.hhh, c.this.hgW.getRight(), c.this.hgW.getBottom());
                    c.this.hhd.layout(c.this.hhd.getTop(), c.this.hhd.getLeft(), c.this.hhd.getRight(), c.this.hhd.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hha) && c.this.hgY != null) {
                        c.this.hgY.setVisibility(8);
                        c.this.hgY.stopPlayback();
                        c.this.hgY.setVideoPath(dVar.getVideoPath());
                        c.this.hgY.setVisibility(0);
                        c.this.hha = dVar.getVideoPath();
                        c.this.hhj = dVar;
                        if (c.this.hhb != null) {
                            c.this.hhb.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hgS);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hhb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hgY.start();
                    }
                }
            }
        });
        this.hhc.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aE(float f) {
                c.this.hhe = c.this.hgW.getTop();
                c.this.hhf = c.this.fMO.getTop();
                c.this.hhg = c.this.hhc.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hhc.setIsCanLayout(false);
                int i2 = (int) (c.this.hhe + f2);
                int i3 = i == 1 ? (int) (c.this.hhf + f2) : (int) (c.this.hhf + (f2 * 0.3d));
                if (i2 >= c.this.hhd.getBottom() && i2 <= l.f(c.this.hgS, f.e.ds902)) {
                    c.this.fMO.layout(c.this.fMO.getLeft(), i3, c.this.fMO.getRight(), c.this.hhh + i3);
                    c.this.hgW.layout(c.this.hgW.getLeft(), i2, c.this.hgW.getRight(), c.this.hgW.getBottom());
                    if (i2 <= l.f(c.this.hgS, f.e.ds400)) {
                        c.this.hhm = false;
                        c.this.hgY.pause();
                    } else {
                        c.this.hhm = true;
                        c.this.hgY.start();
                    }
                    float f3 = (l.f(c.this.hgS, f.e.ds902) - i2) / l.f(c.this.hgS, f.e.ds902);
                    if (f3 == 0.0f) {
                        c.this.hhb.setVisibility(8);
                        return;
                    }
                    c.this.hhb.setVisibility(0);
                    c.this.hhb.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bAD() {
                if (c.this.hgW.getTop() > c.this.hhg / 2) {
                    c.this.hhm = true;
                    c.this.hgY.start();
                    c.this.hhb.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fMO.getBottom(), c.this.hhh);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fMO.layout(c.this.fMO.getLeft(), 0, c.this.fMO.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hgW.getTop(), c.this.hhh);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hgW.layout(c.this.hgW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hgW.getRight(), c.this.hgW.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hhm = false;
                c.this.hgY.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fMO.getBottom(), l.f(c.this.hgS, f.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fMO.layout(c.this.fMO.getLeft(), intValue - c.this.hhh, c.this.fMO.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hgW.getTop(), l.f(c.this.hgS, f.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hgW.layout(c.this.hgW.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hgW.getRight(), c.this.hgW.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hgW.getTop() > c.this.hhd.getBottom() || c.this.hgW.getFirstVisiblePosition() != 0 || c.this.hgW.getChildCount() <= 0 || c.this.hgW.getChildAt(0).getTop() < 0) {
                    if (c.this.hgW.getTop() <= c.this.hhd.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hhh - l.f(c.this.hgS, f.e.ds20))) && f2 < ((float) (c.this.hhh + l.f(c.this.hgS, f.e.ds20)));
                }
                return true;
            }
        });
        this.hhh = l.f(this.hgS, f.e.ds902);
    }

    public boolean bBP() {
        return this.hhl;
    }

    public void dJ(List<d> list) {
        if (!w.z(list)) {
            this.hhk = list;
            d dVar = list.get(0);
            if (this.hgY != null) {
                this.hgY.setVideoPath(dVar.getVideoPath());
                this.hha = dVar.getVideoPath();
                this.hhj = dVar;
                if (this.hhb != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hgS);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hhb.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hgY.start();
            }
            if (this.hgX != null) {
                this.hgX.setData(list);
                bBX();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), f.j.no_local_video_tip);
    }

    public void bBQ() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hgS).ce(f.j.mv_local_video_too_long).a(f.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hgS.getPageContext());
        a.aw(false);
        a.xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hgS) / l.f(this.hgS, f.e.ds902)) {
            i3 = l.ah(this.hgS);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.hgS, f.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.hgY.setVideoHeight(i4);
        this.hgY.setVideoWidth(i3);
        this.hgY.invalidate();
    }

    public void uW(String str) {
        if (this.hgX != null) {
            this.hgX.uV(str);
        }
    }

    public TextView bBR() {
        return this.dyg;
    }

    public TextView bBS() {
        return this.hgZ;
    }

    public void bBT() {
        if (this.hgY != null && !StringUtils.isNull(this.hha)) {
            this.hgY.start();
        }
    }

    public void bBU() {
        if (this.hgY != null && !StringUtils.isNull(this.hha)) {
            this.hgY.resume();
            this.hgY.seekTo(this.hhi);
            if (this.hhm) {
                this.hgY.start();
            }
        }
    }

    public void awd() {
        this.hhi = this.hgY.getCurrentPosition();
        if (this.hgY != null) {
            this.hgY.pause();
        }
    }

    public void awe() {
        this.hhi = this.hgY.getCurrentPosition();
        if (this.hgY != null) {
            this.hgY.stopPlayback();
        }
    }

    public String bBV() {
        return this.hha;
    }

    public d bBW() {
        return this.hhj;
    }

    private void bBX() {
        if (!w.z(this.hhk)) {
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
                        if (i2 >= c.this.hhk.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hhk.get(i2);
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
                                        dVar.C(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.mW(true);
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
                    c.this.hgX.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hgX.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
