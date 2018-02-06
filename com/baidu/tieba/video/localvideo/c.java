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
    private TextView dPx;
    private RelativeLayout gbU;
    private LocalVideoActivity hte;
    private ExpandGridView hti;
    private a htj;
    private CustomVideoView htk;
    private TextView htl;
    private String htm;
    private ImageView htn;
    private ExpandViewRelativeLayout hto;
    private FrameLayout htp;
    private int htq;
    private int htr;
    private int hts;
    private int htt;
    private int htu;
    private d htv;
    private List<d> htw;
    private boolean htx;
    private boolean hty;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.htx = false;
        this.hty = true;
        this.hte = localVideoActivity;
        this.hto = (ExpandViewRelativeLayout) this.hte.findViewById(d.g.container);
        this.hti = (ExpandGridView) this.hte.findViewById(d.g.local_video_gridview);
        this.gbU = (RelativeLayout) this.hte.findViewById(d.g.preview_videoview_container);
        this.htn = (ImageView) this.hte.findViewById(d.g.video_cover);
        this.htp = (FrameLayout) this.hte.findViewById(d.g.top_container);
        this.htk = (CustomVideoView) this.hte.findViewById(d.g.preview_videoview);
        this.htk.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.htk.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.htx = true;
                c.this.htk.stopPlayback();
                return false;
            }
        });
        this.dPx = (TextView) this.hte.findViewById(d.g.close_btn);
        this.htl = (TextView) this.hte.findViewById(d.g.next_step_btn);
        this.htl.setOnClickListener(onClickListener);
        this.dPx.setOnClickListener(onClickListener);
        this.htj = new a(this.hte);
        this.hti.setAdapter((ListAdapter) this.htj);
        this.hti.setSelector(new ColorDrawable(0));
        this.hti.setVerticalScrollBarEnabled(false);
        this.hti.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.htx = false;
                    c.this.hto.setIsCanLayout(true);
                    c.this.gbU.layout(c.this.gbU.getLeft(), 0, c.this.gbU.getRight(), c.this.htt);
                    c.this.hti.layout(c.this.hti.getLeft(), c.this.htt, c.this.hti.getRight(), c.this.hti.getBottom());
                    c.this.htp.layout(c.this.htp.getTop(), c.this.htp.getLeft(), c.this.htp.getRight(), c.this.htp.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.htm) && c.this.htk != null) {
                        c.this.htk.setVisibility(8);
                        c.this.htk.stopPlayback();
                        c.this.htk.setVideoPath(dVar.getVideoPath());
                        c.this.htk.setVisibility(0);
                        c.this.htm = dVar.getVideoPath();
                        c.this.htv = dVar;
                        if (c.this.htn != null) {
                            c.this.htn.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hte);
                            blurDrawable.init(12, 8, dVar.bCx());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.htn.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.htk.start();
                    }
                }
            }
        });
        this.hto.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aG(float f) {
                c.this.htq = c.this.hti.getTop();
                c.this.htr = c.this.gbU.getTop();
                c.this.hts = c.this.hto.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hto.setIsCanLayout(false);
                int i2 = (int) (c.this.htq + f2);
                int i3 = i == 1 ? (int) (c.this.htr + f2) : (int) (c.this.htr + (f2 * 0.3d));
                if (i2 >= c.this.htp.getBottom() && i2 <= l.t(c.this.hte, d.e.ds902)) {
                    c.this.gbU.layout(c.this.gbU.getLeft(), i3, c.this.gbU.getRight(), c.this.htt + i3);
                    c.this.hti.layout(c.this.hti.getLeft(), i2, c.this.hti.getRight(), c.this.hti.getBottom());
                    if (i2 <= l.t(c.this.hte, d.e.ds400)) {
                        c.this.hty = false;
                        c.this.htk.pause();
                    } else {
                        c.this.hty = true;
                        c.this.htk.start();
                    }
                    float t = (l.t(c.this.hte, d.e.ds902) - i2) / l.t(c.this.hte, d.e.ds902);
                    if (t == 0.0f) {
                        c.this.htn.setVisibility(8);
                        return;
                    }
                    c.this.htn.setVisibility(0);
                    c.this.htn.setAlpha(t);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bBc() {
                if (c.this.hti.getTop() > c.this.hts / 2) {
                    c.this.hty = true;
                    c.this.htk.start();
                    c.this.htn.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.gbU.getBottom(), c.this.htt);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gbU.layout(c.this.gbU.getLeft(), 0, c.this.gbU.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hti.getTop(), c.this.htt);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hti.layout(c.this.hti.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hti.getRight(), c.this.hti.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hty = false;
                c.this.htk.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.gbU.getBottom(), l.t(c.this.hte, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.gbU.layout(c.this.gbU.getLeft(), intValue - c.this.htt, c.this.gbU.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hti.getTop(), l.t(c.this.hte, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hti.layout(c.this.hti.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hti.getRight(), c.this.hti.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hti.getTop() > c.this.htp.getBottom() || c.this.hti.getFirstVisiblePosition() != 0 || c.this.hti.getChildCount() <= 0 || c.this.hti.getChildAt(0).getTop() < 0) {
                    if (c.this.hti.getTop() <= c.this.htp.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.htt - l.t(c.this.hte, d.e.ds20))) && f2 < ((float) (c.this.htt + l.t(c.this.hte, d.e.ds20)));
                }
                return true;
            }
        });
        this.htt = l.t(this.hte, d.e.ds902);
    }

    public boolean bCo() {
        return this.htx;
    }

    public void dL(List<d> list) {
        if (!v.E(list)) {
            this.htw = list;
            d dVar = list.get(0);
            if (this.htk != null) {
                this.htk.setVideoPath(dVar.getVideoPath());
                this.htm = dVar.getVideoPath();
                this.htv = dVar;
                if (this.htn != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hte);
                    blurDrawable.init(12, 8, dVar.bCx());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.htn.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.htk.start();
            }
            if (this.htj != null) {
                this.htj.setData(list);
                bCw();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bCp() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hte).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hte.getPageContext());
        a.ba(false);
        a.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hte) / l.t(this.hte, d.e.ds902)) {
            i3 = l.ao(this.hte);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int t = l.t(this.hte, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((t / i2) * i);
                i4 = t;
            } else {
                i3 = 0;
                i4 = t;
            }
        }
        this.htk.setVideoHeight(i4);
        this.htk.setVideoWidth(i3);
        this.htk.invalidate();
    }

    public void tU(String str) {
        if (this.htj != null) {
            this.htj.tT(str);
        }
    }

    public TextView bCq() {
        return this.dPx;
    }

    public TextView bCr() {
        return this.htl;
    }

    public void bCs() {
        if (this.htk != null && !StringUtils.isNull(this.htm)) {
            this.htk.start();
        }
    }

    public void bCt() {
        if (this.htk != null && !StringUtils.isNull(this.htm)) {
            this.htk.resume();
            this.htk.seekTo(this.htu);
            if (this.hty) {
                this.htk.start();
            }
        }
    }

    public void awx() {
        this.htu = this.htk.getCurrentPosition();
        if (this.htk != null) {
            this.htk.pause();
        }
    }

    public void awy() {
        this.htu = this.htk.getCurrentPosition();
        if (this.htk != null) {
            this.htk.stopPlayback();
        }
    }

    public String bCu() {
        return this.htm;
    }

    public d bCv() {
        return this.htv;
    }

    private void bCw() {
        if (!v.E(this.htw)) {
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
                        if (i2 >= c.this.htw.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.htw.get(i2);
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
                                        dVar.A(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.no(true);
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
                    c.this.htj.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.htj.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
