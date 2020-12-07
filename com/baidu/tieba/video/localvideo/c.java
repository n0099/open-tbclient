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
    private TextView jlt;
    private RelativeLayout lZi;
    private LocalVideoActivity nGd;
    private ExpandGridView nGh;
    private a nGi;
    private CustomVideoView nGj;
    private TextView nGk;
    private String nGl;
    private ImageView nGm;
    private ExpandViewRelativeLayout nGn;
    private FrameLayout nGo;
    private int nGp;
    private int nGq;
    private int nGr;
    private int nGs;
    private int nGt;
    private d nGu;
    private List<d> nGv;
    private boolean nGw;
    private boolean nGx;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.nGw = false;
        this.nGx = true;
        this.nGd = localVideoActivity;
        this.nGn = (ExpandViewRelativeLayout) this.nGd.findViewById(R.id.container);
        this.nGh = (ExpandGridView) this.nGd.findViewById(R.id.local_video_gridview);
        this.lZi = (RelativeLayout) this.nGd.findViewById(R.id.preview_videoview_container);
        this.nGm = (ImageView) this.nGd.findViewById(R.id.video_cover);
        this.nGo = (FrameLayout) this.nGd.findViewById(R.id.top_container);
        this.nGj = (CustomVideoView) this.nGd.findViewById(R.id.preview_videoview);
        this.nGj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dF(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nGj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.nGw = true;
                c.this.nGj.stopPlayback();
                return false;
            }
        });
        this.jlt = (TextView) this.nGd.findViewById(R.id.close_btn);
        this.nGk = (TextView) this.nGd.findViewById(R.id.next_step_btn);
        this.nGk.setOnClickListener(onClickListener);
        this.jlt.setOnClickListener(onClickListener);
        this.nGi = new a(this.nGd);
        this.nGh.setAdapter((ListAdapter) this.nGi);
        this.nGh.setSelector(new ColorDrawable(0));
        this.nGh.setVerticalScrollBarEnabled(false);
        this.nGh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.nGw = false;
                    c.this.nGn.setIsCanLayout(true);
                    c.this.lZi.layout(c.this.lZi.getLeft(), 0, c.this.lZi.getRight(), c.this.nGs);
                    c.this.nGh.layout(c.this.nGh.getLeft(), c.this.nGs, c.this.nGh.getRight(), c.this.nGh.getBottom());
                    c.this.nGo.layout(c.this.nGo.getTop(), c.this.nGo.getLeft(), c.this.nGo.getRight(), c.this.nGo.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.nGl) && c.this.nGj != null) {
                        c.this.nGj.setVisibility(8);
                        c.this.nGj.stopPlayback();
                        c.this.nGj.setVideoPath(dVar.getVideoPath());
                        c.this.nGj.setVisibility(0);
                        c.this.nGl = dVar.getVideoPath();
                        c.this.nGu = dVar;
                        if (c.this.nGm != null) {
                            c.this.nGm.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.nGd);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.nGm.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.nGj.start();
                    }
                }
            }
        });
        this.nGn.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aX(float f) {
                c.this.nGp = c.this.nGh.getTop();
                c.this.nGq = c.this.lZi.getTop();
                c.this.nGr = c.this.nGn.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.nGn.setIsCanLayout(false);
                int i2 = (int) (c.this.nGp + f2);
                int i3 = i == 1 ? (int) (c.this.nGq + f2) : (int) (c.this.nGq + (f2 * 0.3d));
                if (i2 >= c.this.nGo.getBottom() && i2 <= l.getDimens(c.this.nGd, R.dimen.ds902)) {
                    c.this.lZi.layout(c.this.lZi.getLeft(), i3, c.this.lZi.getRight(), c.this.nGs + i3);
                    c.this.nGh.layout(c.this.nGh.getLeft(), i2, c.this.nGh.getRight(), c.this.nGh.getBottom());
                    if (i2 <= l.getDimens(c.this.nGd, R.dimen.ds400)) {
                        c.this.nGx = false;
                        c.this.nGj.pause();
                    } else {
                        c.this.nGx = true;
                        c.this.nGj.start();
                    }
                    float dimens = (l.getDimens(c.this.nGd, R.dimen.ds902) - i2) / l.getDimens(c.this.nGd, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.nGm.setVisibility(8);
                        return;
                    }
                    c.this.nGm.setVisibility(0);
                    c.this.nGm.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dUe() {
                if (c.this.nGh.getTop() > c.this.nGr / 2) {
                    c.this.nGx = true;
                    c.this.nGj.start();
                    c.this.nGm.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.lZi.getBottom(), c.this.nGs);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lZi.layout(c.this.lZi.getLeft(), 0, c.this.lZi.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.nGh.getTop(), c.this.nGs);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.nGh.layout(c.this.nGh.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nGh.getRight(), c.this.nGh.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.nGx = false;
                c.this.nGj.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.lZi.getBottom(), l.getDimens(c.this.nGd, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.lZi.layout(c.this.lZi.getLeft(), intValue - c.this.nGs, c.this.lZi.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.nGh.getTop(), l.getDimens(c.this.nGd, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.nGh.layout(c.this.nGh.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nGh.getRight(), c.this.nGh.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.nGh.getTop() > c.this.nGo.getBottom() || c.this.nGh.getFirstVisiblePosition() != 0 || c.this.nGh.getChildCount() <= 0 || c.this.nGh.getChildAt(0).getTop() < 0) {
                    if (c.this.nGh.getTop() <= c.this.nGo.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.nGs - l.getDimens(c.this.nGd, R.dimen.ds20))) && f2 < ((float) (c.this.nGs + l.getDimens(c.this.nGd, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.nGs = l.getDimens(this.nGd, R.dimen.ds902);
    }

    public boolean dVl() {
        return this.nGw;
    }

    public void gh(List<d> list) {
        if (!y.isEmpty(list)) {
            this.nGv = list;
            d dVar = list.get(0);
            if (this.nGj != null) {
                this.nGj.setVideoPath(dVar.getVideoPath());
                this.nGl = dVar.getVideoPath();
                this.nGu = dVar;
                if (this.nGm != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.nGd);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.nGm.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.nGj.start();
            }
            if (this.nGi != null) {
                this.nGi.setData(list);
                dVs();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dVm() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.nGd).oP(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.nGd.getPageContext());
        a2.jm(false);
        a2.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nGd) / l.getDimens(this.nGd, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.nGd);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nGd, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nGj.setVideoHeight(i4);
        this.nGj.setVideoWidth(i3);
        this.nGj.invalidate();
    }

    public void UW(String str) {
        if (this.nGi != null) {
            this.nGi.UV(str);
        }
    }

    public TextView dVn() {
        return this.jlt;
    }

    public TextView dVo() {
        return this.nGk;
    }

    public void startVideo() {
        if (this.nGj != null && !StringUtils.isNull(this.nGl)) {
            this.nGj.start();
        }
    }

    public void dVp() {
        if (this.nGj != null && !StringUtils.isNull(this.nGl)) {
            this.nGj.resume();
            this.nGj.seekTo(this.nGt);
            if (this.nGx) {
                this.nGj.start();
            }
        }
    }

    public void pauseVideo() {
        this.nGt = this.nGj.getCurrentPosition();
        if (this.nGj != null) {
            this.nGj.pause();
        }
    }

    public void cEV() {
        this.nGt = this.nGj.getCurrentPosition();
        if (this.nGj != null) {
            this.nGj.stopPlayback();
        }
    }

    public String dVq() {
        return this.nGl;
    }

    public d dVr() {
        return this.nGu;
    }

    private void dVs() {
        if (!y.isEmpty(this.nGv)) {
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
                        if (i2 >= c.this.nGv.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.nGv.get(i2);
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
                    c.this.nGi.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.nGi.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
