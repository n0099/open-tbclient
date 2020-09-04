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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes17.dex */
public class c extends com.baidu.adp.base.c {
    private TextView iiU;
    private RelativeLayout kUC;
    private LocalVideoActivity mzb;
    private ExpandGridView mzf;
    private a mzg;
    private CustomVideoView mzh;
    private TextView mzi;
    private String mzj;
    private ImageView mzk;
    private ExpandViewRelativeLayout mzl;
    private FrameLayout mzm;
    private int mzn;
    private int mzo;
    private int mzp;
    private int mzq;
    private int mzr;
    private d mzs;
    private List<d> mzt;
    private boolean mzu;
    private boolean mzv;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.mzu = false;
        this.mzv = true;
        this.mzb = localVideoActivity;
        this.mzl = (ExpandViewRelativeLayout) this.mzb.findViewById(R.id.container);
        this.mzf = (ExpandGridView) this.mzb.findViewById(R.id.local_video_gridview);
        this.kUC = (RelativeLayout) this.mzb.findViewById(R.id.preview_videoview_container);
        this.mzk = (ImageView) this.mzb.findViewById(R.id.video_cover);
        this.mzm = (FrameLayout) this.mzb.findViewById(R.id.top_container);
        this.mzh = (CustomVideoView) this.mzb.findViewById(R.id.preview_videoview);
        this.mzh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dr(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mzh.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.mzu = true;
                c.this.mzh.stopPlayback();
                return false;
            }
        });
        this.iiU = (TextView) this.mzb.findViewById(R.id.close_btn);
        this.mzi = (TextView) this.mzb.findViewById(R.id.next_step_btn);
        this.mzi.setOnClickListener(onClickListener);
        this.iiU.setOnClickListener(onClickListener);
        this.mzg = new a(this.mzb);
        this.mzf.setAdapter((ListAdapter) this.mzg);
        this.mzf.setSelector(new ColorDrawable(0));
        this.mzf.setVerticalScrollBarEnabled(false);
        this.mzf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.mzu = false;
                    c.this.mzl.setIsCanLayout(true);
                    c.this.kUC.layout(c.this.kUC.getLeft(), 0, c.this.kUC.getRight(), c.this.mzq);
                    c.this.mzf.layout(c.this.mzf.getLeft(), c.this.mzq, c.this.mzf.getRight(), c.this.mzf.getBottom());
                    c.this.mzm.layout(c.this.mzm.getTop(), c.this.mzm.getLeft(), c.this.mzm.getRight(), c.this.mzm.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.mzj) && c.this.mzh != null) {
                        c.this.mzh.setVisibility(8);
                        c.this.mzh.stopPlayback();
                        c.this.mzh.setVideoPath(dVar.getVideoPath());
                        c.this.mzh.setVisibility(0);
                        c.this.mzj = dVar.getVideoPath();
                        c.this.mzs = dVar;
                        if (c.this.mzk != null) {
                            c.this.mzk.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.mzb);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.mzk.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.mzh.start();
                    }
                }
            }
        });
        this.mzl.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aF(float f) {
                c.this.mzn = c.this.mzf.getTop();
                c.this.mzo = c.this.kUC.getTop();
                c.this.mzp = c.this.mzl.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.mzl.setIsCanLayout(false);
                int i2 = (int) (c.this.mzn + f2);
                int i3 = i == 1 ? (int) (c.this.mzo + f2) : (int) (c.this.mzo + (f2 * 0.3d));
                if (i2 >= c.this.mzm.getBottom() && i2 <= l.getDimens(c.this.mzb, R.dimen.ds902)) {
                    c.this.kUC.layout(c.this.kUC.getLeft(), i3, c.this.kUC.getRight(), c.this.mzq + i3);
                    c.this.mzf.layout(c.this.mzf.getLeft(), i2, c.this.mzf.getRight(), c.this.mzf.getBottom());
                    if (i2 <= l.getDimens(c.this.mzb, R.dimen.ds400)) {
                        c.this.mzv = false;
                        c.this.mzh.pause();
                    } else {
                        c.this.mzv = true;
                        c.this.mzh.start();
                    }
                    float dimens = (l.getDimens(c.this.mzb, R.dimen.ds902) - i2) / l.getDimens(c.this.mzb, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.mzk.setVisibility(8);
                        return;
                    }
                    c.this.mzk.setVisibility(0);
                    c.this.mzk.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dBx() {
                if (c.this.mzf.getTop() > c.this.mzp / 2) {
                    c.this.mzv = true;
                    c.this.mzh.start();
                    c.this.mzk.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.kUC.getBottom(), c.this.mzq);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kUC.layout(c.this.kUC.getLeft(), 0, c.this.kUC.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.mzf.getTop(), c.this.mzq);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.mzf.layout(c.this.mzf.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.mzf.getRight(), c.this.mzf.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.mzv = false;
                c.this.mzh.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.kUC.getBottom(), l.getDimens(c.this.mzb, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.kUC.layout(c.this.kUC.getLeft(), intValue - c.this.mzq, c.this.kUC.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.mzf.getTop(), l.getDimens(c.this.mzb, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.mzf.layout(c.this.mzf.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.mzf.getRight(), c.this.mzf.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.mzf.getTop() > c.this.mzm.getBottom() || c.this.mzf.getFirstVisiblePosition() != 0 || c.this.mzf.getChildCount() <= 0 || c.this.mzf.getChildAt(0).getTop() < 0) {
                    if (c.this.mzf.getTop() <= c.this.mzm.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.mzq - l.getDimens(c.this.mzb, R.dimen.ds20))) && f2 < ((float) (c.this.mzq + l.getDimens(c.this.mzb, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.mzq = l.getDimens(this.mzb, R.dimen.ds902);
    }

    public boolean dCC() {
        return this.mzu;
    }

    public void fq(List<d> list) {
        if (!y.isEmpty(list)) {
            this.mzt = list;
            d dVar = list.get(0);
            if (this.mzh != null) {
                this.mzh.setVideoPath(dVar.getVideoPath());
                this.mzj = dVar.getVideoPath();
                this.mzs = dVar;
                if (this.mzk != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.mzb);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.mzk.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.mzh.start();
            }
            if (this.mzg != null) {
                this.mzg.setData(list);
                dCJ();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dCD() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.mzb).ns(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.mzb.getPageContext());
        a.ih(false);
        a.bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mzb) / l.getDimens(this.mzb, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.mzb);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mzb, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mzh.setVideoHeight(i4);
        this.mzh.setVideoWidth(i3);
        this.mzh.invalidate();
    }

    public void RS(String str) {
        if (this.mzg != null) {
            this.mzg.RR(str);
        }
    }

    public TextView dCE() {
        return this.iiU;
    }

    public TextView dCF() {
        return this.mzi;
    }

    public void startVideo() {
        if (this.mzh != null && !StringUtils.isNull(this.mzj)) {
            this.mzh.start();
        }
    }

    public void dCG() {
        if (this.mzh != null && !StringUtils.isNull(this.mzj)) {
            this.mzh.resume();
            this.mzh.seekTo(this.mzr);
            if (this.mzv) {
                this.mzh.start();
            }
        }
    }

    public void coJ() {
        this.mzr = this.mzh.getCurrentPosition();
        if (this.mzh != null) {
            this.mzh.pause();
        }
    }

    public void coK() {
        this.mzr = this.mzh.getCurrentPosition();
        if (this.mzh != null) {
            this.mzh.stopPlayback();
        }
    }

    public String dCH() {
        return this.mzj;
    }

    public d dCI() {
        return this.mzs;
    }

    private void dCJ() {
        if (!y.isEmpty(this.mzt)) {
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
                        if (i2 >= c.this.mzt.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.mzt.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.f.b.toInt(extractMetadata, 0));
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
                                        matrix.postScale(150 / frameAtTime.getWidth(), ((int) ((150.0f * frameAtTime.getHeight()) / frameAtTime.getWidth())) / frameAtTime.getHeight());
                                        dVar.S(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.wJ(true);
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
                    c.this.mzg.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.mzg.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
