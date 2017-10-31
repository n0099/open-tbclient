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
    private TextView cLw;
    private RelativeLayout fbD;
    private int gGA;
    private int gGB;
    private int gGC;
    private int gGD;
    private d gGE;
    private List<d> gGF;
    private boolean gGG;
    private boolean gGH;
    private LocalVideoActivity gGn;
    private ExpandGridView gGr;
    private a gGs;
    private CustomVideoView gGt;
    private TextView gGu;
    private String gGv;
    private ImageView gGw;
    private ExpandViewRelativeLayout gGx;
    private FrameLayout gGy;
    private int gGz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gGG = false;
        this.gGH = true;
        this.gGn = localVideoActivity;
        this.gGx = (ExpandViewRelativeLayout) this.gGn.findViewById(d.g.container);
        this.gGr = (ExpandGridView) this.gGn.findViewById(d.g.local_video_gridview);
        this.fbD = (RelativeLayout) this.gGn.findViewById(d.g.preview_videoview_container);
        this.gGw = (ImageView) this.gGn.findViewById(d.g.video_cover);
        this.gGy = (FrameLayout) this.gGn.findViewById(d.g.top_container);
        this.gGt = (CustomVideoView) this.gGn.findViewById(d.g.preview_videoview);
        this.gGt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cc(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gGt.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.gGG = true;
                c.this.gGt.stopPlayback();
                return false;
            }
        });
        this.cLw = (TextView) this.gGn.findViewById(d.g.close_btn);
        this.gGu = (TextView) this.gGn.findViewById(d.g.next_step_btn);
        this.gGu.setOnClickListener(onClickListener);
        this.cLw.setOnClickListener(onClickListener);
        this.gGs = new a(this.gGn);
        this.gGr.setAdapter((ListAdapter) this.gGs);
        this.gGr.setSelector(new ColorDrawable(0));
        this.gGr.setVerticalScrollBarEnabled(false);
        this.gGr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gGG = false;
                    c.this.gGx.setIsCanLayout(true);
                    c.this.fbD.layout(c.this.fbD.getLeft(), 0, c.this.fbD.getRight(), c.this.gGC);
                    c.this.gGr.layout(c.this.gGr.getLeft(), c.this.gGC, c.this.gGr.getRight(), c.this.gGr.getBottom());
                    c.this.gGy.layout(c.this.gGy.getTop(), c.this.gGy.getLeft(), c.this.gGy.getRight(), c.this.gGy.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gGv) && c.this.gGt != null) {
                        c.this.gGt.setVisibility(8);
                        c.this.gGt.stopPlayback();
                        c.this.gGt.setVideoPath(dVar.getVideoPath());
                        c.this.gGt.setVisibility(0);
                        c.this.gGv = dVar.getVideoPath();
                        c.this.gGE = dVar;
                        if (c.this.gGw != null) {
                            c.this.gGw.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gGn);
                            blurDrawable.init(12, 8, dVar.bzC());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gGw.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gGt.start();
                    }
                }
            }
        });
        this.gGx.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void ae(float f) {
                c.this.gGz = c.this.gGr.getTop();
                c.this.gGA = c.this.fbD.getTop();
                c.this.gGB = c.this.gGx.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.gGx.setIsCanLayout(false);
                int i2 = (int) (c.this.gGz + f2);
                int i3 = i == 1 ? (int) (c.this.gGA + f2) : (int) (c.this.gGA + (f2 * 0.3d));
                if (i2 >= c.this.gGy.getBottom() && i2 <= l.f(c.this.gGn, d.e.ds902)) {
                    c.this.fbD.layout(c.this.fbD.getLeft(), i3, c.this.fbD.getRight(), c.this.gGC + i3);
                    c.this.gGr.layout(c.this.gGr.getLeft(), i2, c.this.gGr.getRight(), c.this.gGr.getBottom());
                    if (i2 <= l.f(c.this.gGn, d.e.ds400)) {
                        c.this.gGH = false;
                        c.this.gGt.pause();
                    } else {
                        c.this.gGH = true;
                        c.this.gGt.start();
                    }
                    float f3 = (l.f(c.this.gGn, d.e.ds902) - i2) / l.f(c.this.gGn, d.e.ds902);
                    if (f3 == 0.0f) {
                        c.this.gGw.setVisibility(8);
                        return;
                    }
                    c.this.gGw.setVisibility(0);
                    c.this.gGw.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void byA() {
                if (c.this.gGr.getTop() > c.this.gGB / 2) {
                    c.this.gGH = true;
                    c.this.gGt.start();
                    c.this.gGw.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fbD.getBottom(), c.this.gGC);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fbD.layout(c.this.fbD.getLeft(), 0, c.this.fbD.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gGr.getTop(), c.this.gGC);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gGr.layout(c.this.gGr.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gGr.getRight(), c.this.gGr.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.gGH = false;
                c.this.gGt.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fbD.getBottom(), l.f(c.this.gGn, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fbD.layout(c.this.fbD.getLeft(), intValue - c.this.gGC, c.this.fbD.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gGr.getTop(), l.f(c.this.gGn, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gGr.layout(c.this.gGr.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gGr.getRight(), c.this.gGr.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.gGr.getTop() > c.this.gGy.getBottom() || c.this.gGr.getFirstVisiblePosition() != 0 || c.this.gGr.getChildCount() <= 0 || c.this.gGr.getChildAt(0).getTop() < 0) {
                    if (c.this.gGr.getTop() <= c.this.gGy.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gGC - l.f(c.this.gGn, d.e.ds20))) && f2 < ((float) (c.this.gGC + l.f(c.this.gGn, d.e.ds20)));
                }
                return true;
            }
        });
        this.gGC = l.f(this.gGn, d.e.ds902);
    }

    public boolean bzt() {
        return this.gGG;
    }

    public void dD(List<d> list) {
        if (!v.v(list)) {
            this.gGF = list;
            d dVar = list.get(0);
            if (this.gGt != null) {
                this.gGt.setVideoPath(dVar.getVideoPath());
                this.gGv = dVar.getVideoPath();
                this.gGE = dVar;
                if (this.gGw != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gGn);
                    blurDrawable.init(12, 8, dVar.bzC());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gGw.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gGt.start();
            }
            if (this.gGs != null) {
                this.gGs.setData(list);
                bzB();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bzu() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gGn).cb(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gGn.getPageContext());
        a.ap(false);
        a.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.gGn) / l.f(this.gGn, d.e.ds902)) {
            i3 = l.ac(this.gGn);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gGn, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gGt.setVideoHeight(i4);
        this.gGt.setVideoWidth(i3);
        this.gGt.invalidate();
    }

    public void tq(String str) {
        if (this.gGs != null) {
            this.gGs.tp(str);
        }
    }

    public TextView bzv() {
        return this.cLw;
    }

    public TextView bzw() {
        return this.gGu;
    }

    public void bzx() {
        if (this.gGt != null && !StringUtils.isNull(this.gGv)) {
            this.gGt.start();
        }
    }

    public void bzy() {
        if (this.gGt != null && !StringUtils.isNull(this.gGv)) {
            this.gGt.resume();
            this.gGt.seekTo(this.gGD);
            if (this.gGH) {
                this.gGt.start();
            }
        }
    }

    public void aks() {
        this.gGD = this.gGt.getCurrentPosition();
        if (this.gGt != null) {
            this.gGt.pause();
        }
    }

    public void akt() {
        this.gGD = this.gGt.getCurrentPosition();
        if (this.gGt != null) {
            this.gGt.stopPlayback();
        }
    }

    public String bzz() {
        return this.gGv;
    }

    public d bzA() {
        return this.gGE;
    }

    private void bzB() {
        if (!v.v(this.gGF)) {
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
                        if (i2 >= c.this.gGF.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gGF.get(i2);
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
                            dVar.mY(true);
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
                    c.this.gGs.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gGs.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
