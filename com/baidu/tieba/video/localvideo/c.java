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
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.base.c {
    private TextView ipW;
    private RelativeLayout ldg;
    private LocalVideoActivity mIR;
    private ExpandGridView mIV;
    private a mIW;
    private CustomVideoView mIX;
    private TextView mIY;
    private String mIZ;
    private ImageView mJa;
    private ExpandViewRelativeLayout mJb;
    private FrameLayout mJc;
    private int mJd;
    private int mJe;
    private int mJf;
    private int mJg;
    private int mJh;
    private d mJi;
    private List<d> mJj;
    private boolean mJk;
    private boolean mJl;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.mJk = false;
        this.mJl = true;
        this.mIR = localVideoActivity;
        this.mJb = (ExpandViewRelativeLayout) this.mIR.findViewById(R.id.container);
        this.mIV = (ExpandGridView) this.mIR.findViewById(R.id.local_video_gridview);
        this.ldg = (RelativeLayout) this.mIR.findViewById(R.id.preview_videoview_container);
        this.mJa = (ImageView) this.mIR.findViewById(R.id.video_cover);
        this.mJc = (FrameLayout) this.mIR.findViewById(R.id.top_container);
        this.mIX = (CustomVideoView) this.mIR.findViewById(R.id.preview_videoview);
        this.mIX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dv(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mIX.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.mJk = true;
                c.this.mIX.stopPlayback();
                return false;
            }
        });
        this.ipW = (TextView) this.mIR.findViewById(R.id.close_btn);
        this.mIY = (TextView) this.mIR.findViewById(R.id.next_step_btn);
        this.mIY.setOnClickListener(onClickListener);
        this.ipW.setOnClickListener(onClickListener);
        this.mIW = new a(this.mIR);
        this.mIV.setAdapter((ListAdapter) this.mIW);
        this.mIV.setSelector(new ColorDrawable(0));
        this.mIV.setVerticalScrollBarEnabled(false);
        this.mIV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.mJk = false;
                    c.this.mJb.setIsCanLayout(true);
                    c.this.ldg.layout(c.this.ldg.getLeft(), 0, c.this.ldg.getRight(), c.this.mJg);
                    c.this.mIV.layout(c.this.mIV.getLeft(), c.this.mJg, c.this.mIV.getRight(), c.this.mIV.getBottom());
                    c.this.mJc.layout(c.this.mJc.getTop(), c.this.mJc.getLeft(), c.this.mJc.getRight(), c.this.mJc.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.mIZ) && c.this.mIX != null) {
                        c.this.mIX.setVisibility(8);
                        c.this.mIX.stopPlayback();
                        c.this.mIX.setVideoPath(dVar.getVideoPath());
                        c.this.mIX.setVisibility(0);
                        c.this.mIZ = dVar.getVideoPath();
                        c.this.mJi = dVar;
                        if (c.this.mJa != null) {
                            c.this.mJa.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.mIR);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.mJa.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.mIX.start();
                    }
                }
            }
        });
        this.mJb.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aF(float f) {
                c.this.mJd = c.this.mIV.getTop();
                c.this.mJe = c.this.ldg.getTop();
                c.this.mJf = c.this.mJb.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.mJb.setIsCanLayout(false);
                int i2 = (int) (c.this.mJd + f2);
                int i3 = i == 1 ? (int) (c.this.mJe + f2) : (int) (c.this.mJe + (f2 * 0.3d));
                if (i2 >= c.this.mJc.getBottom() && i2 <= l.getDimens(c.this.mIR, R.dimen.ds902)) {
                    c.this.ldg.layout(c.this.ldg.getLeft(), i3, c.this.ldg.getRight(), c.this.mJg + i3);
                    c.this.mIV.layout(c.this.mIV.getLeft(), i2, c.this.mIV.getRight(), c.this.mIV.getBottom());
                    if (i2 <= l.getDimens(c.this.mIR, R.dimen.ds400)) {
                        c.this.mJl = false;
                        c.this.mIX.pause();
                    } else {
                        c.this.mJl = true;
                        c.this.mIX.start();
                    }
                    float dimens = (l.getDimens(c.this.mIR, R.dimen.ds902) - i2) / l.getDimens(c.this.mIR, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.mJa.setVisibility(8);
                        return;
                    }
                    c.this.mJa.setVisibility(0);
                    c.this.mJa.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dFr() {
                if (c.this.mIV.getTop() > c.this.mJf / 2) {
                    c.this.mJl = true;
                    c.this.mIX.start();
                    c.this.mJa.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.ldg.getBottom(), c.this.mJg);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.ldg.layout(c.this.ldg.getLeft(), 0, c.this.ldg.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.mIV.getTop(), c.this.mJg);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.mIV.layout(c.this.mIV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.mIV.getRight(), c.this.mIV.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.mJl = false;
                c.this.mIX.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.ldg.getBottom(), l.getDimens(c.this.mIR, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.ldg.layout(c.this.ldg.getLeft(), intValue - c.this.mJg, c.this.ldg.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.mIV.getTop(), l.getDimens(c.this.mIR, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.mIV.layout(c.this.mIV.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.mIV.getRight(), c.this.mIV.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.mIV.getTop() > c.this.mJc.getBottom() || c.this.mIV.getFirstVisiblePosition() != 0 || c.this.mIV.getChildCount() <= 0 || c.this.mIV.getChildAt(0).getTop() < 0) {
                    if (c.this.mIV.getTop() <= c.this.mJc.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.mJg - l.getDimens(c.this.mIR, R.dimen.ds20))) && f2 < ((float) (c.this.mJg + l.getDimens(c.this.mIR, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.mJg = l.getDimens(this.mIR, R.dimen.ds902);
    }

    public boolean dGw() {
        return this.mJk;
    }

    public void fz(List<d> list) {
        if (!y.isEmpty(list)) {
            this.mJj = list;
            d dVar = list.get(0);
            if (this.mIX != null) {
                this.mIX.setVideoPath(dVar.getVideoPath());
                this.mIZ = dVar.getVideoPath();
                this.mJi = dVar;
                if (this.mJa != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.mIR);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.mJa.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.mIX.start();
            }
            if (this.mIW != null) {
                this.mIW.setData(list);
                dGD();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dGx() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.mIR).nD(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.mIR.getPageContext());
        a.ie(false);
        a.bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mIR) / l.getDimens(this.mIR, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.mIR);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mIR, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mIX.setVideoHeight(i4);
        this.mIX.setVideoWidth(i3);
        this.mIX.invalidate();
    }

    public void Ss(String str) {
        if (this.mIW != null) {
            this.mIW.Sr(str);
        }
    }

    public TextView dGy() {
        return this.ipW;
    }

    public TextView dGz() {
        return this.mIY;
    }

    public void startVideo() {
        if (this.mIX != null && !StringUtils.isNull(this.mIZ)) {
            this.mIX.start();
        }
    }

    public void dGA() {
        if (this.mIX != null && !StringUtils.isNull(this.mIZ)) {
            this.mIX.resume();
            this.mIX.seekTo(this.mJh);
            if (this.mJl) {
                this.mIX.start();
            }
        }
    }

    public void crW() {
        this.mJh = this.mIX.getCurrentPosition();
        if (this.mIX != null) {
            this.mIX.pause();
        }
    }

    public void crX() {
        this.mJh = this.mIX.getCurrentPosition();
        if (this.mIX != null) {
            this.mIX.stopPlayback();
        }
    }

    public String dGB() {
        return this.mIZ;
    }

    public d dGC() {
        return this.mJi;
    }

    private void dGD() {
        if (!y.isEmpty(this.mJj)) {
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
                        if (i2 >= c.this.mJj.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.mJj.get(i2);
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
                                        dVar.R(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.wS(true);
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
                    c.this.mIW.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.mIW.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
