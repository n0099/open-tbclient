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
/* loaded from: classes23.dex */
public class c extends com.baidu.adp.base.c {
    private TextView jlv;
    private RelativeLayout lZk;
    private LocalVideoActivity nGf;
    private ExpandGridView nGj;
    private a nGk;
    private CustomVideoView nGl;
    private TextView nGm;
    private String nGn;
    private ImageView nGo;
    private ExpandViewRelativeLayout nGp;
    private FrameLayout nGq;
    private int nGr;
    private int nGs;
    private int nGt;
    private int nGu;
    private int nGv;
    private d nGw;
    private List<d> nGx;
    private boolean nGy;
    private boolean nGz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.nGy = false;
        this.nGz = true;
        this.nGf = localVideoActivity;
        this.nGp = (ExpandViewRelativeLayout) this.nGf.findViewById(R.id.container);
        this.nGj = (ExpandGridView) this.nGf.findViewById(R.id.local_video_gridview);
        this.lZk = (RelativeLayout) this.nGf.findViewById(R.id.preview_videoview_container);
        this.nGo = (ImageView) this.nGf.findViewById(R.id.video_cover);
        this.nGq = (FrameLayout) this.nGf.findViewById(R.id.top_container);
        this.nGl = (CustomVideoView) this.nGf.findViewById(R.id.preview_videoview);
        this.nGl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dF(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nGl.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.nGy = true;
                c.this.nGl.stopPlayback();
                return false;
            }
        });
        this.jlv = (TextView) this.nGf.findViewById(R.id.close_btn);
        this.nGm = (TextView) this.nGf.findViewById(R.id.next_step_btn);
        this.nGm.setOnClickListener(onClickListener);
        this.jlv.setOnClickListener(onClickListener);
        this.nGk = new a(this.nGf);
        this.nGj.setAdapter((ListAdapter) this.nGk);
        this.nGj.setSelector(new ColorDrawable(0));
        this.nGj.setVerticalScrollBarEnabled(false);
        this.nGj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.nGy = false;
                    c.this.nGp.setIsCanLayout(true);
                    c.this.lZk.layout(c.this.lZk.getLeft(), 0, c.this.lZk.getRight(), c.this.nGu);
                    c.this.nGj.layout(c.this.nGj.getLeft(), c.this.nGu, c.this.nGj.getRight(), c.this.nGj.getBottom());
                    c.this.nGq.layout(c.this.nGq.getTop(), c.this.nGq.getLeft(), c.this.nGq.getRight(), c.this.nGq.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.nGn) && c.this.nGl != null) {
                        c.this.nGl.setVisibility(8);
                        c.this.nGl.stopPlayback();
                        c.this.nGl.setVideoPath(dVar.getVideoPath());
                        c.this.nGl.setVisibility(0);
                        c.this.nGn = dVar.getVideoPath();
                        c.this.nGw = dVar;
                        if (c.this.nGo != null) {
                            c.this.nGo.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.nGf);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.nGo.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.nGl.start();
                    }
                }
            }
        });
        this.nGp.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aX(float f) {
                c.this.nGr = c.this.nGj.getTop();
                c.this.nGs = c.this.lZk.getTop();
                c.this.nGt = c.this.nGp.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.nGp.setIsCanLayout(false);
                int i2 = (int) (c.this.nGr + f2);
                int i3 = i == 1 ? (int) (c.this.nGs + f2) : (int) (c.this.nGs + (f2 * 0.3d));
                if (i2 >= c.this.nGq.getBottom() && i2 <= l.getDimens(c.this.nGf, R.dimen.ds902)) {
                    c.this.lZk.layout(c.this.lZk.getLeft(), i3, c.this.lZk.getRight(), c.this.nGu + i3);
                    c.this.nGj.layout(c.this.nGj.getLeft(), i2, c.this.nGj.getRight(), c.this.nGj.getBottom());
                    if (i2 <= l.getDimens(c.this.nGf, R.dimen.ds400)) {
                        c.this.nGz = false;
                        c.this.nGl.pause();
                    } else {
                        c.this.nGz = true;
                        c.this.nGl.start();
                    }
                    float dimens = (l.getDimens(c.this.nGf, R.dimen.ds902) - i2) / l.getDimens(c.this.nGf, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.nGo.setVisibility(8);
                        return;
                    }
                    c.this.nGo.setVisibility(0);
                    c.this.nGo.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dUf() {
                if (c.this.nGj.getTop() > c.this.nGt / 2) {
                    c.this.nGz = true;
                    c.this.nGl.start();
                    c.this.nGo.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.lZk.getBottom(), c.this.nGu);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lZk.layout(c.this.lZk.getLeft(), 0, c.this.lZk.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.nGj.getTop(), c.this.nGu);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.nGj.layout(c.this.nGj.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nGj.getRight(), c.this.nGj.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.nGz = false;
                c.this.nGl.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.lZk.getBottom(), l.getDimens(c.this.nGf, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.lZk.layout(c.this.lZk.getLeft(), intValue - c.this.nGu, c.this.lZk.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.nGj.getTop(), l.getDimens(c.this.nGf, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.nGj.layout(c.this.nGj.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nGj.getRight(), c.this.nGj.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.nGj.getTop() > c.this.nGq.getBottom() || c.this.nGj.getFirstVisiblePosition() != 0 || c.this.nGj.getChildCount() <= 0 || c.this.nGj.getChildAt(0).getTop() < 0) {
                    if (c.this.nGj.getTop() <= c.this.nGq.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.nGu - l.getDimens(c.this.nGf, R.dimen.ds20))) && f2 < ((float) (c.this.nGu + l.getDimens(c.this.nGf, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.nGu = l.getDimens(this.nGf, R.dimen.ds902);
    }

    public boolean dVm() {
        return this.nGy;
    }

    public void gh(List<d> list) {
        if (!y.isEmpty(list)) {
            this.nGx = list;
            d dVar = list.get(0);
            if (this.nGl != null) {
                this.nGl.setVideoPath(dVar.getVideoPath());
                this.nGn = dVar.getVideoPath();
                this.nGw = dVar;
                if (this.nGo != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.nGf);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.nGo.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.nGl.start();
            }
            if (this.nGk != null) {
                this.nGk.setData(list);
                dVt();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dVn() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.nGf).oP(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.nGf.getPageContext());
        a2.jm(false);
        a2.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nGf) / l.getDimens(this.nGf, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.nGf);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nGf, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nGl.setVideoHeight(i4);
        this.nGl.setVideoWidth(i3);
        this.nGl.invalidate();
    }

    public void UW(String str) {
        if (this.nGk != null) {
            this.nGk.UV(str);
        }
    }

    public TextView dVo() {
        return this.jlv;
    }

    public TextView dVp() {
        return this.nGm;
    }

    public void startVideo() {
        if (this.nGl != null && !StringUtils.isNull(this.nGn)) {
            this.nGl.start();
        }
    }

    public void dVq() {
        if (this.nGl != null && !StringUtils.isNull(this.nGn)) {
            this.nGl.resume();
            this.nGl.seekTo(this.nGv);
            if (this.nGz) {
                this.nGl.start();
            }
        }
    }

    public void pauseVideo() {
        this.nGv = this.nGl.getCurrentPosition();
        if (this.nGl != null) {
            this.nGl.pause();
        }
    }

    public void cEW() {
        this.nGv = this.nGl.getCurrentPosition();
        if (this.nGl != null) {
            this.nGl.stopPlayback();
        }
    }

    public String dVr() {
        return this.nGn;
    }

    public d dVs() {
        return this.nGw;
    }

    private void dVt() {
        if (!y.isEmpty(this.nGx)) {
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
                        if (i2 >= c.this.nGx.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.nGx.get(i2);
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
                            dVar.yL(true);
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
                    c.this.nGk.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.nGk.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
