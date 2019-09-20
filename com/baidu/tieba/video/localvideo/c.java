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
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private TextView fJf;
    private RelativeLayout ifB;
    private d jCA;
    private List<d> jCB;
    private boolean jCC;
    private boolean jCD;
    private LocalVideoActivity jCj;
    private ExpandGridView jCn;
    private a jCo;
    private CustomVideoView jCp;
    private TextView jCq;
    private String jCr;
    private ImageView jCs;
    private ExpandViewRelativeLayout jCt;
    private FrameLayout jCu;
    private int jCv;
    private int jCw;
    private int jCx;
    private int jCy;
    private int jCz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.jCC = false;
        this.jCD = true;
        this.jCj = localVideoActivity;
        this.jCt = (ExpandViewRelativeLayout) this.jCj.findViewById(R.id.container);
        this.jCn = (ExpandGridView) this.jCj.findViewById(R.id.local_video_gridview);
        this.ifB = (RelativeLayout) this.jCj.findViewById(R.id.preview_videoview_container);
        this.jCs = (ImageView) this.jCj.findViewById(R.id.video_cover);
        this.jCu = (FrameLayout) this.jCj.findViewById(R.id.top_container);
        this.jCp = (CustomVideoView) this.jCj.findViewById(R.id.preview_videoview);
        this.jCp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cF(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jCp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.jCC = true;
                c.this.jCp.stopPlayback();
                return false;
            }
        });
        this.fJf = (TextView) this.jCj.findViewById(R.id.close_btn);
        this.jCq = (TextView) this.jCj.findViewById(R.id.next_step_btn);
        this.jCq.setOnClickListener(onClickListener);
        this.fJf.setOnClickListener(onClickListener);
        this.jCo = new a(this.jCj);
        this.jCn.setAdapter((ListAdapter) this.jCo);
        this.jCn.setSelector(new ColorDrawable(0));
        this.jCn.setVerticalScrollBarEnabled(false);
        this.jCn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.jCC = false;
                    c.this.jCt.setIsCanLayout(true);
                    c.this.ifB.layout(c.this.ifB.getLeft(), 0, c.this.ifB.getRight(), c.this.jCy);
                    c.this.jCn.layout(c.this.jCn.getLeft(), c.this.jCy, c.this.jCn.getRight(), c.this.jCn.getBottom());
                    c.this.jCu.layout(c.this.jCu.getTop(), c.this.jCu.getLeft(), c.this.jCu.getRight(), c.this.jCu.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.jCr) && c.this.jCp != null) {
                        c.this.jCp.setVisibility(8);
                        c.this.jCp.stopPlayback();
                        c.this.jCp.setVideoPath(dVar.getVideoPath());
                        c.this.jCp.setVisibility(0);
                        c.this.jCr = dVar.getVideoPath();
                        c.this.jCA = dVar;
                        if (c.this.jCs != null) {
                            c.this.jCs.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.jCj);
                            blurDrawable.init(12, 8, dVar.cwD());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.jCs.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.jCp.start();
                    }
                }
            }
        });
        this.jCt.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aU(float f) {
                c.this.jCv = c.this.jCn.getTop();
                c.this.jCw = c.this.ifB.getTop();
                c.this.jCx = c.this.jCt.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.jCt.setIsCanLayout(false);
                int i2 = (int) (c.this.jCv + f2);
                int i3 = i == 1 ? (int) (c.this.jCw + f2) : (int) (c.this.jCw + (f2 * 0.3d));
                if (i2 >= c.this.jCu.getBottom() && i2 <= l.g(c.this.jCj, R.dimen.ds902)) {
                    c.this.ifB.layout(c.this.ifB.getLeft(), i3, c.this.ifB.getRight(), c.this.jCy + i3);
                    c.this.jCn.layout(c.this.jCn.getLeft(), i2, c.this.jCn.getRight(), c.this.jCn.getBottom());
                    if (i2 <= l.g(c.this.jCj, R.dimen.ds400)) {
                        c.this.jCD = false;
                        c.this.jCp.pause();
                    } else {
                        c.this.jCD = true;
                        c.this.jCp.start();
                    }
                    float g = (l.g(c.this.jCj, R.dimen.ds902) - i2) / l.g(c.this.jCj, R.dimen.ds902);
                    if (g == 0.0f) {
                        c.this.jCs.setVisibility(8);
                        return;
                    }
                    c.this.jCs.setVisibility(0);
                    c.this.jCs.setAlpha(g);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cvh() {
                if (c.this.jCn.getTop() > c.this.jCx / 2) {
                    c.this.jCD = true;
                    c.this.jCp.start();
                    c.this.jCs.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.ifB.getBottom(), c.this.jCy);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.ifB.layout(c.this.ifB.getLeft(), 0, c.this.ifB.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.jCn.getTop(), c.this.jCy);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jCn.layout(c.this.jCn.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jCn.getRight(), c.this.jCn.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.jCD = false;
                c.this.jCp.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.ifB.getBottom(), l.g(c.this.jCj, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.ifB.layout(c.this.ifB.getLeft(), intValue - c.this.jCy, c.this.ifB.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.jCn.getTop(), l.g(c.this.jCj, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.jCn.layout(c.this.jCn.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jCn.getRight(), c.this.jCn.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.jCn.getTop() > c.this.jCu.getBottom() || c.this.jCn.getFirstVisiblePosition() != 0 || c.this.jCn.getChildCount() <= 0 || c.this.jCn.getChildAt(0).getTop() < 0) {
                    if (c.this.jCn.getTop() <= c.this.jCu.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.jCy - l.g(c.this.jCj, R.dimen.ds20))) && f2 < ((float) (c.this.jCy + l.g(c.this.jCj, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.jCy = l.g(this.jCj, R.dimen.ds902);
    }

    public boolean cwt() {
        return this.jCC;
    }

    public void er(List<d> list) {
        if (!v.aa(list)) {
            this.jCB = list;
            d dVar = list.get(0);
            if (this.jCp != null) {
                this.jCp.setVideoPath(dVar.getVideoPath());
                this.jCr = dVar.getVideoPath();
                this.jCA = dVar;
                if (this.jCs != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.jCj);
                    blurDrawable.init(12, 8, dVar.cwD());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.jCs.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.jCp.start();
            }
            if (this.jCo != null) {
                this.jCo.setData(list);
                cwB();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cwu() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.jCj).hu(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.jCj.getPageContext());
        a.dR(false);
        a.agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jCj) / l.g(this.jCj, R.dimen.ds902)) {
            i3 = l.af(this.jCj);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jCj, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jCp.setVideoHeight(i4);
        this.jCp.setVideoWidth(i3);
        this.jCp.invalidate();
    }

    public void Gu(String str) {
        if (this.jCo != null) {
            this.jCo.Gt(str);
        }
    }

    public TextView cwv() {
        return this.fJf;
    }

    public TextView cww() {
        return this.jCq;
    }

    public void cwx() {
        if (this.jCp != null && !StringUtils.isNull(this.jCr)) {
            this.jCp.start();
        }
    }

    public void cwy() {
        if (this.jCp != null && !StringUtils.isNull(this.jCr)) {
            this.jCp.resume();
            this.jCp.seekTo(this.jCz);
            if (this.jCD) {
                this.jCp.start();
            }
        }
    }

    public void bpd() {
        this.jCz = this.jCp.getCurrentPosition();
        if (this.jCp != null) {
            this.jCp.pause();
        }
    }

    public void bpe() {
        this.jCz = this.jCp.getCurrentPosition();
        if (this.jCp != null) {
            this.jCp.stopPlayback();
        }
    }

    public String cwz() {
        return this.jCr;
    }

    public d cwA() {
        return this.jCA;
    }

    private void cwB() {
        if (!v.aa(this.jCB)) {
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
                        if (i2 >= c.this.jCB.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.jCB.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.f(extractMetadata, 0));
                            }
                            dVar.Gv(mediaMetadataRetriever.extractMetadata(12));
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
                                        dVar.M(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.rL(true);
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
                    c.this.jCo.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.jCo.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
