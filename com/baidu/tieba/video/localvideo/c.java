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
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private TextView dMP;
    private RelativeLayout gci;
    private LocalVideoActivity hvX;
    private ExpandGridView hwb;
    private a hwc;
    private CustomVideoView hwd;
    private TextView hwe;
    private String hwf;
    private ImageView hwg;
    private ExpandViewRelativeLayout hwh;
    private FrameLayout hwi;
    private int hwj;
    private int hwk;
    private int hwl;
    private int hwm;
    private int hwn;
    private d hwo;
    private List<d> hwp;
    private boolean hwq;
    private boolean hwr;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hwq = false;
        this.hwr = true;
        this.hvX = localVideoActivity;
        this.hwh = (ExpandViewRelativeLayout) this.hvX.findViewById(e.g.container);
        this.hwb = (ExpandGridView) this.hvX.findViewById(e.g.local_video_gridview);
        this.gci = (RelativeLayout) this.hvX.findViewById(e.g.preview_videoview_container);
        this.hwg = (ImageView) this.hvX.findViewById(e.g.video_cover);
        this.hwi = (FrameLayout) this.hvX.findViewById(e.g.top_container);
        this.hwd = (CustomVideoView) this.hvX.findViewById(e.g.preview_videoview);
        this.hwd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bU(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hwd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hwq = true;
                c.this.hwd.stopPlayback();
                return false;
            }
        });
        this.dMP = (TextView) this.hvX.findViewById(e.g.close_btn);
        this.hwe = (TextView) this.hvX.findViewById(e.g.next_step_btn);
        this.hwe.setOnClickListener(onClickListener);
        this.dMP.setOnClickListener(onClickListener);
        this.hwc = new a(this.hvX);
        this.hwb.setAdapter((ListAdapter) this.hwc);
        this.hwb.setSelector(new ColorDrawable(0));
        this.hwb.setVerticalScrollBarEnabled(false);
        this.hwb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hwq = false;
                    c.this.hwh.setIsCanLayout(true);
                    c.this.gci.layout(c.this.gci.getLeft(), 0, c.this.gci.getRight(), c.this.hwm);
                    c.this.hwb.layout(c.this.hwb.getLeft(), c.this.hwm, c.this.hwb.getRight(), c.this.hwb.getBottom());
                    c.this.hwi.layout(c.this.hwi.getTop(), c.this.hwi.getLeft(), c.this.hwi.getRight(), c.this.hwi.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hwf) && c.this.hwd != null) {
                        c.this.hwd.setVisibility(8);
                        c.this.hwd.stopPlayback();
                        c.this.hwd.setVideoPath(dVar.getVideoPath());
                        c.this.hwd.setVisibility(0);
                        c.this.hwf = dVar.getVideoPath();
                        c.this.hwo = dVar;
                        if (c.this.hwg != null) {
                            c.this.hwg.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hvX);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hwg.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hwd.start();
                    }
                }
            }
        });
        this.hwh.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void az(float f) {
                c.this.hwj = c.this.hwb.getTop();
                c.this.hwk = c.this.gci.getTop();
                c.this.hwl = c.this.hwh.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hwh.setIsCanLayout(false);
                int i2 = (int) (c.this.hwj + f2);
                int i3 = i == 1 ? (int) (c.this.hwk + f2) : (int) (c.this.hwk + (f2 * 0.3d));
                if (i2 >= c.this.hwi.getBottom() && i2 <= l.h(c.this.hvX, e.C0175e.ds902)) {
                    c.this.gci.layout(c.this.gci.getLeft(), i3, c.this.gci.getRight(), c.this.hwm + i3);
                    c.this.hwb.layout(c.this.hwb.getLeft(), i2, c.this.hwb.getRight(), c.this.hwb.getBottom());
                    if (i2 <= l.h(c.this.hvX, e.C0175e.ds400)) {
                        c.this.hwr = false;
                        c.this.hwd.pause();
                    } else {
                        c.this.hwr = true;
                        c.this.hwd.start();
                    }
                    float h = (l.h(c.this.hvX, e.C0175e.ds902) - i2) / l.h(c.this.hvX, e.C0175e.ds902);
                    if (h == 0.0f) {
                        c.this.hwg.setVisibility(8);
                        return;
                    }
                    c.this.hwg.setVisibility(0);
                    c.this.hwg.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bGG() {
                if (c.this.hwb.getTop() > c.this.hwl / 2) {
                    c.this.hwr = true;
                    c.this.hwd.start();
                    c.this.hwg.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.gci.getBottom(), c.this.hwm);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gci.layout(c.this.gci.getLeft(), 0, c.this.gci.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hwb.getTop(), c.this.hwm);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hwb.layout(c.this.hwb.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hwb.getRight(), c.this.hwb.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hwr = false;
                c.this.hwd.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.gci.getBottom(), l.h(c.this.hvX, e.C0175e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.gci.layout(c.this.gci.getLeft(), intValue - c.this.hwm, c.this.gci.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hwb.getTop(), l.h(c.this.hvX, e.C0175e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hwb.layout(c.this.hwb.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hwb.getRight(), c.this.hwb.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hwb.getTop() > c.this.hwi.getBottom() || c.this.hwb.getFirstVisiblePosition() != 0 || c.this.hwb.getChildCount() <= 0 || c.this.hwb.getChildAt(0).getTop() < 0) {
                    if (c.this.hwb.getTop() <= c.this.hwi.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hwm - l.h(c.this.hvX, e.C0175e.ds20))) && f2 < ((float) (c.this.hwm + l.h(c.this.hvX, e.C0175e.ds20)));
                }
                return true;
            }
        });
        this.hwm = l.h(this.hvX, e.C0175e.ds902);
    }

    public boolean bHR() {
        return this.hwq;
    }

    public void dY(List<d> list) {
        if (!v.J(list)) {
            this.hwp = list;
            d dVar = list.get(0);
            if (this.hwd != null) {
                this.hwd.setVideoPath(dVar.getVideoPath());
                this.hwf = dVar.getVideoPath();
                this.hwo = dVar;
                if (this.hwg != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hvX);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hwg.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hwd.start();
            }
            if (this.hwc != null) {
                this.hwc.setData(list);
                bHZ();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), e.j.no_local_video_tip);
    }

    public void bHS() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hvX).cy(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hvX.getPageContext());
        a.aP(false);
        a.Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hvX) / l.h(this.hvX, e.C0175e.ds902)) {
            i3 = l.aO(this.hvX);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hvX, e.C0175e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hwd.setVideoHeight(i4);
        this.hwd.setVideoWidth(i3);
        this.hwd.invalidate();
    }

    public void wg(String str) {
        if (this.hwc != null) {
            this.hwc.wf(str);
        }
    }

    public TextView bHT() {
        return this.dMP;
    }

    public TextView bHU() {
        return this.hwe;
    }

    public void bHV() {
        if (this.hwd != null && !StringUtils.isNull(this.hwf)) {
            this.hwd.start();
        }
    }

    public void bHW() {
        if (this.hwd != null && !StringUtils.isNull(this.hwf)) {
            this.hwd.resume();
            this.hwd.seekTo(this.hwn);
            if (this.hwr) {
                this.hwd.start();
            }
        }
    }

    public void aBI() {
        this.hwn = this.hwd.getCurrentPosition();
        if (this.hwd != null) {
            this.hwd.pause();
        }
    }

    public void aBJ() {
        this.hwn = this.hwd.getCurrentPosition();
        if (this.hwd != null) {
            this.hwd.stopPlayback();
        }
    }

    public String bHX() {
        return this.hwf;
    }

    public d bHY() {
        return this.hwo;
    }

    private void bHZ() {
        if (!v.J(this.hwp)) {
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
                        if (i2 >= c.this.hwp.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hwp.get(i2);
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
                            dVar.nK(true);
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
                    c.this.hwc.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hwc.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
