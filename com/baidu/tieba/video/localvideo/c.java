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
    private TextView cVo;
    private RelativeLayout fjQ;
    private LocalVideoActivity gUI;
    private ExpandGridView gUM;
    private a gUN;
    private CustomVideoView gUO;
    private TextView gUP;
    private String gUQ;
    private ImageView gUR;
    private ExpandViewRelativeLayout gUS;
    private FrameLayout gUT;
    private int gUU;
    private int gUV;
    private int gUW;
    private int gUX;
    private int gUY;
    private d gUZ;
    private List<d> gVa;
    private boolean gVb;
    private boolean gVc;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.gVb = false;
        this.gVc = true;
        this.gUI = localVideoActivity;
        this.gUS = (ExpandViewRelativeLayout) this.gUI.findViewById(d.g.container);
        this.gUM = (ExpandGridView) this.gUI.findViewById(d.g.local_video_gridview);
        this.fjQ = (RelativeLayout) this.gUI.findViewById(d.g.preview_videoview_container);
        this.gUR = (ImageView) this.gUI.findViewById(d.g.video_cover);
        this.gUT = (FrameLayout) this.gUI.findViewById(d.g.top_container);
        this.gUO = (CustomVideoView) this.gUI.findViewById(d.g.preview_videoview);
        this.gUO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cd(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gUO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.gVb = true;
                c.this.gUO.stopPlayback();
                return false;
            }
        });
        this.cVo = (TextView) this.gUI.findViewById(d.g.close_btn);
        this.gUP = (TextView) this.gUI.findViewById(d.g.next_step_btn);
        this.gUP.setOnClickListener(onClickListener);
        this.cVo.setOnClickListener(onClickListener);
        this.gUN = new a(this.gUI);
        this.gUM.setAdapter((ListAdapter) this.gUN);
        this.gUM.setSelector(new ColorDrawable(0));
        this.gUM.setVerticalScrollBarEnabled(false);
        this.gUM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.gVb = false;
                    c.this.gUS.setIsCanLayout(true);
                    c.this.fjQ.layout(c.this.fjQ.getLeft(), 0, c.this.fjQ.getRight(), c.this.gUX);
                    c.this.gUM.layout(c.this.gUM.getLeft(), c.this.gUX, c.this.gUM.getRight(), c.this.gUM.getBottom());
                    c.this.gUT.layout(c.this.gUT.getTop(), c.this.gUT.getLeft(), c.this.gUT.getRight(), c.this.gUT.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.gUQ) && c.this.gUO != null) {
                        c.this.gUO.setVisibility(8);
                        c.this.gUO.stopPlayback();
                        c.this.gUO.setVideoPath(dVar.getVideoPath());
                        c.this.gUO.setVisibility(0);
                        c.this.gUQ = dVar.getVideoPath();
                        c.this.gUZ = dVar;
                        if (c.this.gUR != null) {
                            c.this.gUR.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.gUI);
                            blurDrawable.init(12, 8, dVar.bCS());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.gUR.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.gUO.start();
                    }
                }
            }
        });
        this.gUS.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void ao(float f) {
                c.this.gUU = c.this.gUM.getTop();
                c.this.gUV = c.this.fjQ.getTop();
                c.this.gUW = c.this.gUS.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.gUS.setIsCanLayout(false);
                int i2 = (int) (c.this.gUU + f2);
                int i3 = i == 1 ? (int) (c.this.gUV + f2) : (int) (c.this.gUV + (f2 * 0.3d));
                if (i2 >= c.this.gUT.getBottom() && i2 <= l.f(c.this.gUI, d.e.ds902)) {
                    c.this.fjQ.layout(c.this.fjQ.getLeft(), i3, c.this.fjQ.getRight(), c.this.gUX + i3);
                    c.this.gUM.layout(c.this.gUM.getLeft(), i2, c.this.gUM.getRight(), c.this.gUM.getBottom());
                    if (i2 <= l.f(c.this.gUI, d.e.ds400)) {
                        c.this.gVc = false;
                        c.this.gUO.pause();
                    } else {
                        c.this.gVc = true;
                        c.this.gUO.start();
                    }
                    float f3 = (l.f(c.this.gUI, d.e.ds902) - i2) / l.f(c.this.gUI, d.e.ds902);
                    if (f3 == 0.0f) {
                        c.this.gUR.setVisibility(8);
                        return;
                    }
                    c.this.gUR.setVisibility(0);
                    c.this.gUR.setAlpha(f3);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void bBw() {
                if (c.this.gUM.getTop() > c.this.gUW / 2) {
                    c.this.gVc = true;
                    c.this.gUO.start();
                    c.this.gUR.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.fjQ.getBottom(), c.this.gUX);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.fjQ.layout(c.this.fjQ.getLeft(), 0, c.this.fjQ.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.gUM.getTop(), c.this.gUX);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.gUM.layout(c.this.gUM.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gUM.getRight(), c.this.gUM.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.gVc = false;
                c.this.gUO.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.fjQ.getBottom(), l.f(c.this.gUI, d.e.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.fjQ.layout(c.this.fjQ.getLeft(), intValue - c.this.gUX, c.this.fjQ.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.gUM.getTop(), l.f(c.this.gUI, d.e.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.gUM.layout(c.this.gUM.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.gUM.getRight(), c.this.gUM.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.gUM.getTop() > c.this.gUT.getBottom() || c.this.gUM.getFirstVisiblePosition() != 0 || c.this.gUM.getChildCount() <= 0 || c.this.gUM.getChildAt(0).getTop() < 0) {
                    if (c.this.gUM.getTop() <= c.this.gUT.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.gUX - l.f(c.this.gUI, d.e.ds20))) && f2 < ((float) (c.this.gUX + l.f(c.this.gUI, d.e.ds20)));
                }
                return true;
            }
        });
        this.gUX = l.f(this.gUI, d.e.ds902);
    }

    public boolean bCJ() {
        return this.gVb;
    }

    public void dQ(List<d> list) {
        if (!v.w(list)) {
            this.gVa = list;
            d dVar = list.get(0);
            if (this.gUO != null) {
                this.gUO.setVideoPath(dVar.getVideoPath());
                this.gUQ = dVar.getVideoPath();
                this.gUZ = dVar;
                if (this.gUR != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.gUI);
                    blurDrawable.init(12, 8, dVar.bCS());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.gUR.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.gUO.start();
            }
            if (this.gUN != null) {
                this.gUN.setData(list);
                bCR();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
    }

    public void bCK() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gUI).cc(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gUI.getPageContext());
        a.ap(false);
        a.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.gUI) / l.f(this.gUI, d.e.ds902)) {
            i3 = l.ac(this.gUI);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gUI, d.e.ds902);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gUO.setVideoHeight(i4);
        this.gUO.setVideoWidth(i3);
        this.gUO.invalidate();
    }

    public void um(String str) {
        if (this.gUN != null) {
            this.gUN.ul(str);
        }
    }

    public TextView bCL() {
        return this.cVo;
    }

    public TextView bCM() {
        return this.gUP;
    }

    public void bCN() {
        if (this.gUO != null && !StringUtils.isNull(this.gUQ)) {
            this.gUO.start();
        }
    }

    public void bCO() {
        if (this.gUO != null && !StringUtils.isNull(this.gUQ)) {
            this.gUO.resume();
            this.gUO.seekTo(this.gUY);
            if (this.gVc) {
                this.gUO.start();
            }
        }
    }

    public void amL() {
        this.gUY = this.gUO.getCurrentPosition();
        if (this.gUO != null) {
            this.gUO.pause();
        }
    }

    public void amM() {
        this.gUY = this.gUO.getCurrentPosition();
        if (this.gUO != null) {
            this.gUO.stopPlayback();
        }
    }

    public String bCP() {
        return this.gUQ;
    }

    public d bCQ() {
        return this.gUZ;
    }

    private void bCR() {
        if (!v.w(this.gVa)) {
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
                        if (i2 >= c.this.gVa.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.gVa.get(i2);
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
                    c.this.gUN.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    c.this.gUN.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
