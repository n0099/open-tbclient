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
    private TextView cVs;
    private RelativeLayout fjV;
    private LocalVideoActivity gUN;
    private ExpandGridView gUR;
    private a gUS;
    private CustomVideoView gUT;
    private TextView gUU;
    private String gUV;
    private ImageView gUW;
    private ExpandViewRelativeLayout gUX;
    private FrameLayout gUY;
    private int gUZ;
    private int gVa;
    private int gVb;
    private int gVc;
    private int gVd;
    private d gVe;
    private List<d> gVf;
    private boolean gVg;
    private boolean gVh;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gVg = false;
        this.gVh = true;
        this.gUN = localVideoActivity;
        this.gUX = (ExpandViewRelativeLayout) this.gUN.findViewById(d.g.container);
        this.gUR = (ExpandGridView) this.gUN.findViewById(d.g.local_video_gridview);
        this.fjV = (RelativeLayout) this.gUN.findViewById(d.g.preview_videoview_container);
        this.gUW = (ImageView) this.gUN.findViewById(d.g.video_cover);
        this.gUY = (FrameLayout) this.gUN.findViewById(d.g.top_container);
        this.gUT = (CustomVideoView) this.gUN.findViewById(d.g.preview_videoview);
        this.gUT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cd(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gUT.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.gVg = true;
                c.this.gUT.stopPlayback();
                return false;
            }
        });
        this.cVs = (TextView) this.gUN.findViewById(d.g.close_btn);
        this.gUU = (TextView) this.gUN.findViewById(d.g.next_step_btn);
        this.gUU.setOnClickListener(onClickListener);
        this.cVs.setOnClickListener(onClickListener);
        this.gUS = new a(this.gUN);
        this.gUR.setAdapter((ListAdapter) this.gUS);
        this.gUR.setSelector(new ColorDrawable(0));
        this.gUR.setVerticalScrollBarEnabled(false);
        this.gUR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gVg = false;
                    c.this.gUX.setIsCanLayout(true);
                    c.this.fjV.layout(c.this.fjV.getLeft(), 0, c.this.fjV.getRight(), c.this.gVc);
                    c.this.gUR.layout(c.this.gUR.getLeft(), c.this.gVc, c.this.gUR.getRight(), c.this.gUR.getBottom());
                    c.this.gUY.layout(c.this.gUY.getTop(), c.this.gUY.getLeft(), c.this.gUY.getRight(), c.this.gUY.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gUV) && c.this.gUT != null) {
                        c.this.gUT.setVisibility(8);
                        c.this.gUT.stopPlayback();
                        c.this.gUT.setVideoPath(dVar.getVideoPath());
                        c.this.gUT.setVisibility(0);
                        c.this.gUV = dVar.getVideoPath();
                        c.this.gVe = dVar;
                        if (c.this.gUW != null) {
                            c.this.gUW.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gUN);
                            blurDrawable.init(12, 8, dVar.bCS());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gUW.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gUT.start();
                    }
                }
            }
        });
        this.gUX.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void ao(float f) {
                c.this.gUZ = c.this.gUR.getTop();
                c.this.gVa = c.this.fjV.getTop();
                c.this.gVb = c.this.gUX.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.gUX.setIsCanLayout(false);
                int i2 = (int) (c.this.gUZ + f2);
                int i3 = i == 1 ? (int) (c.this.gVa + f2) : (int) (c.this.gVa + (f2 * 0.3d));
                if (i2 >= c.this.gUY.getBottom() && i2 <= l.f(c.this.gUN, d.e.ds902)) {
                    c.this.fjV.layout(c.this.fjV.getLeft(), i3, c.this.fjV.getRight(), c.this.gVc + i3);
                    c.this.gUR.layout(c.this.gUR.getLeft(), i2, c.this.gUR.getRight(), c.this.gUR.getBottom());
                    if (i2 <= l.f(c.this.gUN, d.e.ds400)) {
                        c.this.gVh = false;
                        c.this.gUT.pause();
                    } else {
                        c.this.gVh = true;
                        c.this.gUT.start();
                    }
                    float f3 = (l.f(c.this.gUN, d.e.ds902) - i2) / l.f(c.this.gUN, d.e.ds902);
                    if (f3 == 0.0f) {
                        c.this.gUW.setVisibility(8);
                        return;
                    }
                    c.this.gUW.setVisibility(0);
                    c.this.gUW.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bBw() {
                if (c.this.gUR.getTop() > c.this.gVb / 2) {
                    c.this.gVh = true;
                    c.this.gUT.start();
                    c.this.gUW.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fjV.getBottom(), c.this.gVc);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fjV.layout(c.this.fjV.getLeft(), 0, c.this.fjV.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gUR.getTop(), c.this.gVc);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gUR.layout(c.this.gUR.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gUR.getRight(), c.this.gUR.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.gVh = false;
                c.this.gUT.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fjV.getBottom(), l.f(c.this.gUN, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fjV.layout(c.this.fjV.getLeft(), intValue - c.this.gVc, c.this.fjV.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gUR.getTop(), l.f(c.this.gUN, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gUR.layout(c.this.gUR.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gUR.getRight(), c.this.gUR.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.gUR.getTop() > c.this.gUY.getBottom() || c.this.gUR.getFirstVisiblePosition() != 0 || c.this.gUR.getChildCount() <= 0 || c.this.gUR.getChildAt(0).getTop() < 0) {
                    if (c.this.gUR.getTop() <= c.this.gUY.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gVc - l.f(c.this.gUN, d.e.ds20))) && f2 < ((float) (c.this.gVc + l.f(c.this.gUN, d.e.ds20)));
                }
                return true;
            }
        });
        this.gVc = l.f(this.gUN, d.e.ds902);
    }

    public boolean bCJ() {
        return this.gVg;
    }

    public void dQ(List<d> list) {
        if (!v.w(list)) {
            this.gVf = list;
            d dVar = list.get(0);
            if (this.gUT != null) {
                this.gUT.setVideoPath(dVar.getVideoPath());
                this.gUV = dVar.getVideoPath();
                this.gVe = dVar;
                if (this.gUW != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gUN);
                    blurDrawable.init(12, 8, dVar.bCS());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gUW.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gUT.start();
            }
            if (this.gUS != null) {
                this.gUS.setData(list);
                bCR();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bCK() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gUN).cc(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gUN.getPageContext());
        a.ap(false);
        a.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.gUN) / l.f(this.gUN, d.e.ds902)) {
            i3 = l.ac(this.gUN);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gUN, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gUT.setVideoHeight(i4);
        this.gUT.setVideoWidth(i3);
        this.gUT.invalidate();
    }

    public void um(String str) {
        if (this.gUS != null) {
            this.gUS.ul(str);
        }
    }

    public TextView bCL() {
        return this.cVs;
    }

    public TextView bCM() {
        return this.gUU;
    }

    public void bCN() {
        if (this.gUT != null && !StringUtils.isNull(this.gUV)) {
            this.gUT.start();
        }
    }

    public void bCO() {
        if (this.gUT != null && !StringUtils.isNull(this.gUV)) {
            this.gUT.resume();
            this.gUT.seekTo(this.gVd);
            if (this.gVh) {
                this.gUT.start();
            }
        }
    }

    public void amL() {
        this.gVd = this.gUT.getCurrentPosition();
        if (this.gUT != null) {
            this.gUT.pause();
        }
    }

    public void amM() {
        this.gVd = this.gUT.getCurrentPosition();
        if (this.gUT != null) {
            this.gUT.stopPlayback();
        }
    }

    public String bCP() {
        return this.gUV;
    }

    public d bCQ() {
        return this.gVe;
    }

    private void bCR() {
        if (!v.w(this.gVf)) {
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
                        if (i2 >= c.this.gVf.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gVf.get(i2);
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
                            dVar.nH(true);
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
                    c.this.gUS.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gUS.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
