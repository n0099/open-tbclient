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
    private TextView dPl;
    private RelativeLayout gbJ;
    private LocalVideoActivity hsR;
    private ExpandGridView hsV;
    private a hsW;
    private CustomVideoView hsX;
    private TextView hsY;
    private String hsZ;
    private ImageView hta;
    private ExpandViewRelativeLayout htb;
    private FrameLayout htc;
    private int htd;
    private int hte;
    private int htf;
    private int htg;
    private int hth;
    private d hti;
    private List<d> htj;
    private boolean htk;
    private boolean htl;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.htk = false;
        this.htl = true;
        this.hsR = localVideoActivity;
        this.htb = (ExpandViewRelativeLayout) this.hsR.findViewById(d.g.container);
        this.hsV = (ExpandGridView) this.hsR.findViewById(d.g.local_video_gridview);
        this.gbJ = (RelativeLayout) this.hsR.findViewById(d.g.preview_videoview_container);
        this.hta = (ImageView) this.hsR.findViewById(d.g.video_cover);
        this.htc = (FrameLayout) this.hsR.findViewById(d.g.top_container);
        this.hsX = (CustomVideoView) this.hsR.findViewById(d.g.preview_videoview);
        this.hsX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hsX.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.htk = true;
                c.this.hsX.stopPlayback();
                return false;
            }
        });
        this.dPl = (TextView) this.hsR.findViewById(d.g.close_btn);
        this.hsY = (TextView) this.hsR.findViewById(d.g.next_step_btn);
        this.hsY.setOnClickListener(onClickListener);
        this.dPl.setOnClickListener(onClickListener);
        this.hsW = new a(this.hsR);
        this.hsV.setAdapter((ListAdapter) this.hsW);
        this.hsV.setSelector(new ColorDrawable(0));
        this.hsV.setVerticalScrollBarEnabled(false);
        this.hsV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.htk = false;
                    c.this.htb.setIsCanLayout(true);
                    c.this.gbJ.layout(c.this.gbJ.getLeft(), 0, c.this.gbJ.getRight(), c.this.htg);
                    c.this.hsV.layout(c.this.hsV.getLeft(), c.this.htg, c.this.hsV.getRight(), c.this.hsV.getBottom());
                    c.this.htc.layout(c.this.htc.getTop(), c.this.htc.getLeft(), c.this.htc.getRight(), c.this.htc.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hsZ) && c.this.hsX != null) {
                        c.this.hsX.setVisibility(8);
                        c.this.hsX.stopPlayback();
                        c.this.hsX.setVideoPath(dVar.getVideoPath());
                        c.this.hsX.setVisibility(0);
                        c.this.hsZ = dVar.getVideoPath();
                        c.this.hti = dVar;
                        if (c.this.hta != null) {
                            c.this.hta.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hsR);
                            blurDrawable.init(12, 8, dVar.bCw());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hta.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hsX.start();
                    }
                }
            }
        });
        this.htb.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aG(float f) {
                c.this.htd = c.this.hsV.getTop();
                c.this.hte = c.this.gbJ.getTop();
                c.this.htf = c.this.htb.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.htb.setIsCanLayout(false);
                int i2 = (int) (c.this.htd + f2);
                int i3 = i == 1 ? (int) (c.this.hte + f2) : (int) (c.this.hte + (f2 * 0.3d));
                if (i2 >= c.this.htc.getBottom() && i2 <= l.t(c.this.hsR, d.e.ds902)) {
                    c.this.gbJ.layout(c.this.gbJ.getLeft(), i3, c.this.gbJ.getRight(), c.this.htg + i3);
                    c.this.hsV.layout(c.this.hsV.getLeft(), i2, c.this.hsV.getRight(), c.this.hsV.getBottom());
                    if (i2 <= l.t(c.this.hsR, d.e.ds400)) {
                        c.this.htl = false;
                        c.this.hsX.pause();
                    } else {
                        c.this.htl = true;
                        c.this.hsX.start();
                    }
                    float t = (l.t(c.this.hsR, d.e.ds902) - i2) / l.t(c.this.hsR, d.e.ds902);
                    if (t == 0.0f) {
                        c.this.hta.setVisibility(8);
                        return;
                    }
                    c.this.hta.setVisibility(0);
                    c.this.hta.setAlpha(t);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bBb() {
                if (c.this.hsV.getTop() > c.this.htf / 2) {
                    c.this.htl = true;
                    c.this.hsX.start();
                    c.this.hta.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.gbJ.getBottom(), c.this.htg);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gbJ.layout(c.this.gbJ.getLeft(), 0, c.this.gbJ.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hsV.getTop(), c.this.htg);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hsV.layout(c.this.hsV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hsV.getRight(), c.this.hsV.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.htl = false;
                c.this.hsX.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.gbJ.getBottom(), l.t(c.this.hsR, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.gbJ.layout(c.this.gbJ.getLeft(), intValue - c.this.htg, c.this.gbJ.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hsV.getTop(), l.t(c.this.hsR, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hsV.layout(c.this.hsV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hsV.getRight(), c.this.hsV.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hsV.getTop() > c.this.htc.getBottom() || c.this.hsV.getFirstVisiblePosition() != 0 || c.this.hsV.getChildCount() <= 0 || c.this.hsV.getChildAt(0).getTop() < 0) {
                    if (c.this.hsV.getTop() <= c.this.htc.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.htg - l.t(c.this.hsR, d.e.ds20))) && f2 < ((float) (c.this.htg + l.t(c.this.hsR, d.e.ds20)));
                }
                return true;
            }
        });
        this.htg = l.t(this.hsR, d.e.ds902);
    }

    public boolean bCn() {
        return this.htk;
    }

    public void dL(List<d> list) {
        if (!v.E(list)) {
            this.htj = list;
            d dVar = list.get(0);
            if (this.hsX != null) {
                this.hsX.setVideoPath(dVar.getVideoPath());
                this.hsZ = dVar.getVideoPath();
                this.hti = dVar;
                if (this.hta != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hsR);
                    blurDrawable.init(12, 8, dVar.bCw());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hta.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hsX.start();
            }
            if (this.hsW != null) {
                this.hsW.setData(list);
                bCv();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bCo() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hsR).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hsR.getPageContext());
        a.ba(false);
        a.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hsR) / l.t(this.hsR, d.e.ds902)) {
            i3 = l.ao(this.hsR);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int t = l.t(this.hsR, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((t / i2) * i);
                i4 = t;
            } else {
                i3 = 0;
                i4 = t;
            }
        }
        this.hsX.setVideoHeight(i4);
        this.hsX.setVideoWidth(i3);
        this.hsX.invalidate();
    }

    public void tU(String str) {
        if (this.hsW != null) {
            this.hsW.tT(str);
        }
    }

    public TextView bCp() {
        return this.dPl;
    }

    public TextView bCq() {
        return this.hsY;
    }

    public void bCr() {
        if (this.hsX != null && !StringUtils.isNull(this.hsZ)) {
            this.hsX.start();
        }
    }

    public void bCs() {
        if (this.hsX != null && !StringUtils.isNull(this.hsZ)) {
            this.hsX.resume();
            this.hsX.seekTo(this.hth);
            if (this.htl) {
                this.hsX.start();
            }
        }
    }

    public void aww() {
        this.hth = this.hsX.getCurrentPosition();
        if (this.hsX != null) {
            this.hsX.pause();
        }
    }

    public void awx() {
        this.hth = this.hsX.getCurrentPosition();
        if (this.hsX != null) {
            this.hsX.stopPlayback();
        }
    }

    public String bCt() {
        return this.hsZ;
    }

    public d bCu() {
        return this.hti;
    }

    private void bCv() {
        if (!v.E(this.htj)) {
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
                        if (i2 >= c.this.htj.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.htj.get(i2);
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
                    c.this.hsW.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.hsW.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
