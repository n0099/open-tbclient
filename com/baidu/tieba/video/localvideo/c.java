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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.commonview.ExpandGridView;
import com.baidu.tieba.video.commonview.ExpandViewRelativeLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c {
    private TextView fIx;
    private RelativeLayout iel;
    private LocalVideoActivity jCb;
    private ExpandGridView jCf;
    private a jCg;
    private CustomVideoView jCh;
    private TextView jCi;
    private String jCj;
    private ImageView jCk;
    private ExpandViewRelativeLayout jCl;
    private FrameLayout jCm;
    private int jCn;
    private int jCo;
    private int jCp;
    private int jCq;
    private int jCr;
    private d jCs;
    private List<d> jCt;
    private boolean jCu;
    private boolean jCv;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.jCu = false;
        this.jCv = true;
        this.jCb = localVideoActivity;
        this.jCl = (ExpandViewRelativeLayout) this.jCb.findViewById(R.id.container);
        this.jCf = (ExpandGridView) this.jCb.findViewById(R.id.local_video_gridview);
        this.iel = (RelativeLayout) this.jCb.findViewById(R.id.preview_videoview_container);
        this.jCk = (ImageView) this.jCb.findViewById(R.id.video_cover);
        this.jCm = (FrameLayout) this.jCb.findViewById(R.id.top_container);
        this.jCh = (CustomVideoView) this.jCb.findViewById(R.id.preview_videoview);
        this.jCh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cy(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jCh.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.jCu = true;
                c.this.jCh.stopPlayback();
                return false;
            }
        });
        this.fIx = (TextView) this.jCb.findViewById(R.id.close_btn);
        this.jCi = (TextView) this.jCb.findViewById(R.id.next_step_btn);
        this.jCi.setOnClickListener(onClickListener);
        this.fIx.setOnClickListener(onClickListener);
        this.jCg = new a(this.jCb);
        this.jCf.setAdapter((ListAdapter) this.jCg);
        this.jCf.setSelector(new ColorDrawable(0));
        this.jCf.setVerticalScrollBarEnabled(false);
        this.jCf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.jCu = false;
                    c.this.jCl.setIsCanLayout(true);
                    c.this.iel.layout(c.this.iel.getLeft(), 0, c.this.iel.getRight(), c.this.jCq);
                    c.this.jCf.layout(c.this.jCf.getLeft(), c.this.jCq, c.this.jCf.getRight(), c.this.jCf.getBottom());
                    c.this.jCm.layout(c.this.jCm.getTop(), c.this.jCm.getLeft(), c.this.jCm.getRight(), c.this.jCm.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.jCj) && c.this.jCh != null) {
                        c.this.jCh.setVisibility(8);
                        c.this.jCh.stopPlayback();
                        c.this.jCh.setVideoPath(dVar.getVideoPath());
                        c.this.jCh.setVisibility(0);
                        c.this.jCj = dVar.getVideoPath();
                        c.this.jCs = dVar;
                        if (c.this.jCk != null) {
                            c.this.jCk.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.jCb);
                            blurDrawable.init(12, 8, dVar.cur());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.jCk.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.jCh.start();
                    }
                }
            }
        });
        this.jCl.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void ax(float f) {
                c.this.jCn = c.this.jCf.getTop();
                c.this.jCo = c.this.iel.getTop();
                c.this.jCp = c.this.jCl.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.jCl.setIsCanLayout(false);
                int i2 = (int) (c.this.jCn + f2);
                int i3 = i == 1 ? (int) (c.this.jCo + f2) : (int) (c.this.jCo + (f2 * 0.3d));
                if (i2 >= c.this.jCm.getBottom() && i2 <= l.getDimens(c.this.jCb, R.dimen.ds902)) {
                    c.this.iel.layout(c.this.iel.getLeft(), i3, c.this.iel.getRight(), c.this.jCq + i3);
                    c.this.jCf.layout(c.this.jCf.getLeft(), i2, c.this.jCf.getRight(), c.this.jCf.getBottom());
                    if (i2 <= l.getDimens(c.this.jCb, R.dimen.ds400)) {
                        c.this.jCv = false;
                        c.this.jCh.pause();
                    } else {
                        c.this.jCv = true;
                        c.this.jCh.start();
                    }
                    float dimens = (l.getDimens(c.this.jCb, R.dimen.ds902) - i2) / l.getDimens(c.this.jCb, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.jCk.setVisibility(8);
                        return;
                    }
                    c.this.jCk.setVisibility(0);
                    c.this.jCk.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void csW() {
                if (c.this.jCf.getTop() > c.this.jCp / 2) {
                    c.this.jCv = true;
                    c.this.jCh.start();
                    c.this.jCk.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iel.getBottom(), c.this.jCq);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iel.layout(c.this.iel.getLeft(), 0, c.this.iel.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.jCf.getTop(), c.this.jCq);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jCf.layout(c.this.jCf.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jCf.getRight(), c.this.jCf.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.jCv = false;
                c.this.jCh.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iel.getBottom(), l.getDimens(c.this.jCb, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iel.layout(c.this.iel.getLeft(), intValue - c.this.jCq, c.this.iel.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.jCf.getTop(), l.getDimens(c.this.jCb, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.jCf.layout(c.this.jCf.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jCf.getRight(), c.this.jCf.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.jCf.getTop() > c.this.jCm.getBottom() || c.this.jCf.getFirstVisiblePosition() != 0 || c.this.jCf.getChildCount() <= 0 || c.this.jCf.getChildAt(0).getTop() < 0) {
                    if (c.this.jCf.getTop() <= c.this.jCm.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.jCq - l.getDimens(c.this.jCb, R.dimen.ds20))) && f2 < ((float) (c.this.jCq + l.getDimens(c.this.jCb, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.jCq = l.getDimens(this.jCb, R.dimen.ds902);
    }

    public boolean cuh() {
        return this.jCu;
    }

    public void eE(List<d> list) {
        if (!v.isEmpty(list)) {
            this.jCt = list;
            d dVar = list.get(0);
            if (this.jCh != null) {
                this.jCh.setVideoPath(dVar.getVideoPath());
                this.jCj = dVar.getVideoPath();
                this.jCs = dVar;
                if (this.jCk != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.jCb);
                    blurDrawable.init(12, 8, dVar.cur());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.jCk.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.jCh.start();
            }
            if (this.jCg != null) {
                this.jCg.setData(list);
                cup();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cui() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.jCb).hT(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.jCb.getPageContext());
        a.eh(false);
        a.akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.jCb) / l.getDimens(this.jCb, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.jCb);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.jCb, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.jCh.setVideoHeight(i4);
        this.jCh.setVideoWidth(i3);
        this.jCh.invalidate();
    }

    public void EW(String str) {
        if (this.jCg != null) {
            this.jCg.EV(str);
        }
    }

    public TextView cuj() {
        return this.fIx;
    }

    public TextView cuk() {
        return this.jCi;
    }

    public void cul() {
        if (this.jCh != null && !StringUtils.isNull(this.jCj)) {
            this.jCh.start();
        }
    }

    public void cum() {
        if (this.jCh != null && !StringUtils.isNull(this.jCj)) {
            this.jCh.resume();
            this.jCh.seekTo(this.jCr);
            if (this.jCv) {
                this.jCh.start();
            }
        }
    }

    public void bmi() {
        this.jCr = this.jCh.getCurrentPosition();
        if (this.jCh != null) {
            this.jCh.pause();
        }
    }

    public void bmj() {
        this.jCr = this.jCh.getCurrentPosition();
        if (this.jCh != null) {
            this.jCh.stopPlayback();
        }
    }

    public String cun() {
        return this.jCj;
    }

    public d cuo() {
        return this.jCs;
    }

    private void cup() {
        if (!v.isEmpty(this.jCt)) {
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
                        if (i2 >= c.this.jCt.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.jCt.get(i2);
                        String videoPath = dVar.getVideoPath();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoPath);
                            if (mediaMetadataRetriever.extractMetadata(9) != null) {
                                dVar.setDuration(com.baidu.adp.lib.g.b.toInt(extractMetadata, 0));
                            }
                            dVar.EX(mediaMetadataRetriever.extractMetadata(12));
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
                                        dVar.K(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.ru(true);
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
                    c.this.jCg.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.jCg.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
