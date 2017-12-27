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
    private TextView dHD;
    private RelativeLayout fWR;
    private LocalVideoActivity hBR;
    private ExpandGridView hBV;
    private a hBW;
    private CustomVideoView hBX;
    private TextView hBY;
    private String hBZ;
    private ImageView hCa;
    private ExpandViewRelativeLayout hCb;
    private FrameLayout hCc;
    private int hCd;
    private int hCe;
    private int hCf;
    private int hCg;
    private int hCh;
    private d hCi;
    private List<d> hCj;
    private boolean hCk;
    private boolean hCl;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.hCk = false;
        this.hCl = true;
        this.hBR = localVideoActivity;
        this.hCb = (ExpandViewRelativeLayout) this.hBR.findViewById(d.g.container);
        this.hBV = (ExpandGridView) this.hBR.findViewById(d.g.local_video_gridview);
        this.fWR = (RelativeLayout) this.hBR.findViewById(d.g.preview_videoview_container);
        this.hCa = (ImageView) this.hBR.findViewById(d.g.video_cover);
        this.hCc = (FrameLayout) this.hBR.findViewById(d.g.top_container);
        this.hBX = (CustomVideoView) this.hBR.findViewById(d.g.preview_videoview);
        this.hBX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.da(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hBX.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.hCk = true;
                c.this.hBX.stopPlayback();
                return false;
            }
        });
        this.dHD = (TextView) this.hBR.findViewById(d.g.close_btn);
        this.hBY = (TextView) this.hBR.findViewById(d.g.next_step_btn);
        this.hBY.setOnClickListener(onClickListener);
        this.dHD.setOnClickListener(onClickListener);
        this.hBW = new a(this.hBR);
        this.hBV.setAdapter((ListAdapter) this.hBW);
        this.hBV.setSelector(new ColorDrawable(0));
        this.hBV.setVerticalScrollBarEnabled(false);
        this.hBV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.hCk = false;
                    c.this.hCb.setIsCanLayout(true);
                    c.this.fWR.layout(c.this.fWR.getLeft(), 0, c.this.fWR.getRight(), c.this.hCg);
                    c.this.hBV.layout(c.this.hBV.getLeft(), c.this.hCg, c.this.hBV.getRight(), c.this.hBV.getBottom());
                    c.this.hCc.layout(c.this.hCc.getTop(), c.this.hCc.getLeft(), c.this.hCc.getRight(), c.this.hCc.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.hBZ) && c.this.hBX != null) {
                        c.this.hBX.setVisibility(8);
                        c.this.hBX.stopPlayback();
                        c.this.hBX.setVideoPath(dVar.getVideoPath());
                        c.this.hBX.setVisibility(0);
                        c.this.hBZ = dVar.getVideoPath();
                        c.this.hCi = dVar;
                        if (c.this.hCa != null) {
                            c.this.hCa.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.hBR);
                            blurDrawable.init(12, 8, dVar.bIp());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.hCa.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.hBX.start();
                    }
                }
            }
        });
        this.hCb.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aC(float f) {
                c.this.hCd = c.this.hBV.getTop();
                c.this.hCe = c.this.fWR.getTop();
                c.this.hCf = c.this.hCb.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.hCb.setIsCanLayout(false);
                int i2 = (int) (c.this.hCd + f2);
                int i3 = i == 1 ? (int) (c.this.hCe + f2) : (int) (c.this.hCe + (f2 * 0.3d));
                if (i2 >= c.this.hCc.getBottom() && i2 <= l.s(c.this.hBR, d.e.ds902)) {
                    c.this.fWR.layout(c.this.fWR.getLeft(), i3, c.this.fWR.getRight(), c.this.hCg + i3);
                    c.this.hBV.layout(c.this.hBV.getLeft(), i2, c.this.hBV.getRight(), c.this.hBV.getBottom());
                    if (i2 <= l.s(c.this.hBR, d.e.ds400)) {
                        c.this.hCl = false;
                        c.this.hBX.pause();
                    } else {
                        c.this.hCl = true;
                        c.this.hBX.start();
                    }
                    float s = (l.s(c.this.hBR, d.e.ds902) - i2) / l.s(c.this.hBR, d.e.ds902);
                    if (s == 0.0f) {
                        c.this.hCa.setVisibility(8);
                        return;
                    }
                    c.this.hCa.setVisibility(0);
                    c.this.hCa.setAlpha(s);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bGT() {
                if (c.this.hBV.getTop() > c.this.hCf / 2) {
                    c.this.hCl = true;
                    c.this.hBX.start();
                    c.this.hCa.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fWR.getBottom(), c.this.hCg);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fWR.layout(c.this.fWR.getLeft(), 0, c.this.fWR.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.hBV.getTop(), c.this.hCg);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.hBV.layout(c.this.hBV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hBV.getRight(), c.this.hBV.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.hCl = false;
                c.this.hBX.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fWR.getBottom(), l.s(c.this.hBR, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fWR.layout(c.this.fWR.getLeft(), intValue - c.this.hCg, c.this.fWR.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.hBV.getTop(), l.s(c.this.hBR, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.hBV.layout(c.this.hBV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.hBV.getRight(), c.this.hBV.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.hBV.getTop() > c.this.hCc.getBottom() || c.this.hBV.getFirstVisiblePosition() != 0 || c.this.hBV.getChildCount() <= 0 || c.this.hBV.getChildAt(0).getTop() < 0) {
                    if (c.this.hBV.getTop() <= c.this.hCc.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.hCg - l.s(c.this.hBR, d.e.ds20))) && f2 < ((float) (c.this.hCg + l.s(c.this.hBR, d.e.ds20)));
                }
                return true;
            }
        });
        this.hCg = l.s(this.hBR, d.e.ds902);
    }

    public boolean bIg() {
        return this.hCk;
    }

    public void dW(List<d> list) {
        if (!v.G(list)) {
            this.hCj = list;
            d dVar = list.get(0);
            if (this.hBX != null) {
                this.hBX.setVideoPath(dVar.getVideoPath());
                this.hBZ = dVar.getVideoPath();
                this.hCi = dVar;
                if (this.hCa != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.hBR);
                    blurDrawable.init(12, 8, dVar.bIp());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.hCa.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.hBX.start();
            }
            if (this.hBW != null) {
                this.hBW.setData(list);
                bIo();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bIh() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hBR).fc(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hBR.getPageContext());
        a.aW(false);
        a.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hBR) / l.s(this.hBR, d.e.ds902)) {
            i3 = l.ao(this.hBR);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int s = l.s(this.hBR, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((s / i2) * i);
                i4 = s;
            } else {
                i3 = 0;
                i4 = s;
            }
        }
        this.hBX.setVideoHeight(i4);
        this.hBX.setVideoWidth(i3);
        this.hBX.invalidate();
    }

    public void un(String str) {
        if (this.hBW != null) {
            this.hBW.um(str);
        }
    }

    public TextView bIi() {
        return this.dHD;
    }

    public TextView bIj() {
        return this.hBY;
    }

    public void bIk() {
        if (this.hBX != null && !StringUtils.isNull(this.hBZ)) {
            this.hBX.start();
        }
    }

    public void bIl() {
        if (this.hBX != null && !StringUtils.isNull(this.hBZ)) {
            this.hBX.resume();
            this.hBX.seekTo(this.hCh);
            if (this.hCl) {
                this.hBX.start();
            }
        }
    }

    public void aus() {
        this.hCh = this.hBX.getCurrentPosition();
        if (this.hBX != null) {
            this.hBX.pause();
        }
    }

    public void aut() {
        this.hCh = this.hBX.getCurrentPosition();
        if (this.hBX != null) {
            this.hBX.stopPlayback();
        }
    }

    public String bIm() {
        return this.hBZ;
    }

    public d bIn() {
        return this.hCi;
    }

    private void bIo() {
        if (!v.G(this.hCj)) {
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
                        if (i2 >= c.this.hCj.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.hCj.get(i2);
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
                            dVar.ob(true);
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
                    c.this.hBW.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.hBW.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
