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
    private TextView dXn;
    private RelativeLayout gnp;
    private LocalVideoActivity hIe;
    private ExpandGridView hIi;
    private a hIj;
    private CustomVideoView hIk;
    private TextView hIl;
    private String hIm;
    private ImageView hIn;
    private ExpandViewRelativeLayout hIo;
    private FrameLayout hIp;
    private int hIq;
    private int hIr;
    private int hIs;
    private int hIt;
    private int hIu;
    private d hIv;
    private List<d> hIw;
    private boolean hIx;
    private boolean hIy;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hIx = false;
        this.hIy = true;
        this.hIe = localVideoActivity;
        this.hIo = (ExpandViewRelativeLayout) this.hIe.findViewById(e.g.container);
        this.hIi = (ExpandGridView) this.hIe.findViewById(e.g.local_video_gridview);
        this.gnp = (RelativeLayout) this.hIe.findViewById(e.g.preview_videoview_container);
        this.hIn = (ImageView) this.hIe.findViewById(e.g.video_cover);
        this.hIp = (FrameLayout) this.hIe.findViewById(e.g.top_container);
        this.hIk = (CustomVideoView) this.hIe.findViewById(e.g.preview_videoview);
        this.hIk.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.bX(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hIk.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hIx = true;
                c.this.hIk.stopPlayback();
                return false;
            }
        });
        this.dXn = (TextView) this.hIe.findViewById(e.g.close_btn);
        this.hIl = (TextView) this.hIe.findViewById(e.g.next_step_btn);
        this.hIl.setOnClickListener(onClickListener);
        this.dXn.setOnClickListener(onClickListener);
        this.hIj = new a(this.hIe);
        this.hIi.setAdapter((ListAdapter) this.hIj);
        this.hIi.setSelector(new ColorDrawable(0));
        this.hIi.setVerticalScrollBarEnabled(false);
        this.hIi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hIx = false;
                    c.this.hIo.setIsCanLayout(true);
                    c.this.gnp.layout(c.this.gnp.getLeft(), 0, c.this.gnp.getRight(), c.this.hIt);
                    c.this.hIi.layout(c.this.hIi.getLeft(), c.this.hIt, c.this.hIi.getRight(), c.this.hIi.getBottom());
                    c.this.hIp.layout(c.this.hIp.getTop(), c.this.hIp.getLeft(), c.this.hIp.getRight(), c.this.hIp.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hIm) && c.this.hIk != null) {
                        c.this.hIk.setVisibility(8);
                        c.this.hIk.stopPlayback();
                        c.this.hIk.setVideoPath(dVar.getVideoPath());
                        c.this.hIk.setVisibility(0);
                        c.this.hIm = dVar.getVideoPath();
                        c.this.hIv = dVar;
                        if (c.this.hIn != null) {
                            c.this.hIn.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hIe);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hIn.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hIk.start();
                    }
                }
            }
        });
        this.hIo.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aB(float f) {
                c.this.hIq = c.this.hIi.getTop();
                c.this.hIr = c.this.gnp.getTop();
                c.this.hIs = c.this.hIo.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hIo.setIsCanLayout(false);
                int i2 = (int) (c.this.hIq + f2);
                int i3 = i == 1 ? (int) (c.this.hIr + f2) : (int) (c.this.hIr + (f2 * 0.3d));
                if (i2 >= c.this.hIp.getBottom() && i2 <= l.h(c.this.hIe, e.C0210e.ds902)) {
                    c.this.gnp.layout(c.this.gnp.getLeft(), i3, c.this.gnp.getRight(), c.this.hIt + i3);
                    c.this.hIi.layout(c.this.hIi.getLeft(), i2, c.this.hIi.getRight(), c.this.hIi.getBottom());
                    if (i2 <= l.h(c.this.hIe, e.C0210e.ds400)) {
                        c.this.hIy = false;
                        c.this.hIk.pause();
                    } else {
                        c.this.hIy = true;
                        c.this.hIk.start();
                    }
                    float h = (l.h(c.this.hIe, e.C0210e.ds902) - i2) / l.h(c.this.hIe, e.C0210e.ds902);
                    if (h == 0.0f) {
                        c.this.hIn.setVisibility(8);
                        return;
                    }
                    c.this.hIn.setVisibility(0);
                    c.this.hIn.setAlpha(h);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bIZ() {
                if (c.this.hIi.getTop() > c.this.hIs / 2) {
                    c.this.hIy = true;
                    c.this.hIk.start();
                    c.this.hIn.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.gnp.getBottom(), c.this.hIt);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gnp.layout(c.this.gnp.getLeft(), 0, c.this.gnp.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hIi.getTop(), c.this.hIt);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hIi.layout(c.this.hIi.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hIi.getRight(), c.this.hIi.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hIy = false;
                c.this.hIk.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.gnp.getBottom(), l.h(c.this.hIe, e.C0210e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.gnp.layout(c.this.gnp.getLeft(), intValue - c.this.hIt, c.this.gnp.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hIi.getTop(), l.h(c.this.hIe, e.C0210e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hIi.layout(c.this.hIi.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hIi.getRight(), c.this.hIi.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hIi.getTop() > c.this.hIp.getBottom() || c.this.hIi.getFirstVisiblePosition() != 0 || c.this.hIi.getChildCount() <= 0 || c.this.hIi.getChildAt(0).getTop() < 0) {
                    if (c.this.hIi.getTop() <= c.this.hIp.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hIt - l.h(c.this.hIe, e.C0210e.ds20))) && f2 < ((float) (c.this.hIt + l.h(c.this.hIe, e.C0210e.ds20)));
                }
                return true;
            }
        });
        this.hIt = l.h(this.hIe, e.C0210e.ds902);
    }

    public boolean bKk() {
        return this.hIx;
    }

    public void eb(List<d> list) {
        if (!v.I(list)) {
            this.hIw = list;
            d dVar = list.get(0);
            if (this.hIk != null) {
                this.hIk.setVideoPath(dVar.getVideoPath());
                this.hIm = dVar.getVideoPath();
                this.hIv = dVar;
                if (this.hIn != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hIe);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hIn.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hIk.start();
            }
            if (this.hIj != null) {
                this.hIj.setData(list);
                bKs();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), e.j.no_local_video_tip);
    }

    public void bKl() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hIe).da(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hIe.getPageContext());
        a.bg(false);
        a.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hIe) / l.h(this.hIe, e.C0210e.ds902)) {
            i3 = l.aO(this.hIe);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hIe, e.C0210e.ds902);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hIk.setVideoHeight(i4);
        this.hIk.setVideoWidth(i3);
        this.hIk.invalidate();
    }

    public void wR(String str) {
        if (this.hIj != null) {
            this.hIj.wQ(str);
        }
    }

    public TextView bKm() {
        return this.dXn;
    }

    public TextView bKn() {
        return this.hIl;
    }

    public void bKo() {
        if (this.hIk != null && !StringUtils.isNull(this.hIm)) {
            this.hIk.start();
        }
    }

    public void bKp() {
        if (this.hIk != null && !StringUtils.isNull(this.hIm)) {
            this.hIk.resume();
            this.hIk.seekTo(this.hIu);
            if (this.hIy) {
                this.hIk.start();
            }
        }
    }

    public void aDF() {
        this.hIu = this.hIk.getCurrentPosition();
        if (this.hIk != null) {
            this.hIk.pause();
        }
    }

    public void aDG() {
        this.hIu = this.hIk.getCurrentPosition();
        if (this.hIk != null) {
            this.hIk.stopPlayback();
        }
    }

    public String bKq() {
        return this.hIm;
    }

    public d bKr() {
        return this.hIv;
    }

    private void bKs() {
        if (!v.I(this.hIw)) {
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
                        if (i2 >= c.this.hIw.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hIw.get(i2);
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
                            dVar.od(true);
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
                    c.this.hIj.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.hIj.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
