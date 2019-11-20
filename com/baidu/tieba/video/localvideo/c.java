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
    private TextView fHG;
    private RelativeLayout idu;
    private int jBA;
    private d jBB;
    private List<d> jBC;
    private boolean jBD;
    private boolean jBE;
    private LocalVideoActivity jBk;
    private ExpandGridView jBo;
    private a jBp;
    private CustomVideoView jBq;
    private TextView jBr;
    private String jBs;
    private ImageView jBt;
    private ExpandViewRelativeLayout jBu;
    private FrameLayout jBv;
    private int jBw;
    private int jBx;
    private int jBy;
    private int jBz;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.jBD = false;
        this.jBE = true;
        this.jBk = localVideoActivity;
        this.jBu = (ExpandViewRelativeLayout) this.jBk.findViewById(R.id.container);
        this.jBo = (ExpandGridView) this.jBk.findViewById(R.id.local_video_gridview);
        this.idu = (RelativeLayout) this.jBk.findViewById(R.id.preview_videoview_container);
        this.jBt = (ImageView) this.jBk.findViewById(R.id.video_cover);
        this.jBv = (FrameLayout) this.jBk.findViewById(R.id.top_container);
        this.jBq = (CustomVideoView) this.jBk.findViewById(R.id.preview_videoview);
        this.jBq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cw(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jBq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.jBD = true;
                c.this.jBq.stopPlayback();
                return false;
            }
        });
        this.fHG = (TextView) this.jBk.findViewById(R.id.close_btn);
        this.jBr = (TextView) this.jBk.findViewById(R.id.next_step_btn);
        this.jBr.setOnClickListener(onClickListener);
        this.fHG.setOnClickListener(onClickListener);
        this.jBp = new a(this.jBk);
        this.jBo.setAdapter((ListAdapter) this.jBp);
        this.jBo.setSelector(new ColorDrawable(0));
        this.jBo.setVerticalScrollBarEnabled(false);
        this.jBo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.jBD = false;
                    c.this.jBu.setIsCanLayout(true);
                    c.this.idu.layout(c.this.idu.getLeft(), 0, c.this.idu.getRight(), c.this.jBz);
                    c.this.jBo.layout(c.this.jBo.getLeft(), c.this.jBz, c.this.jBo.getRight(), c.this.jBo.getBottom());
                    c.this.jBv.layout(c.this.jBv.getTop(), c.this.jBv.getLeft(), c.this.jBv.getRight(), c.this.jBv.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.jBs) && c.this.jBq != null) {
                        c.this.jBq.setVisibility(8);
                        c.this.jBq.stopPlayback();
                        c.this.jBq.setVideoPath(dVar.getVideoPath());
                        c.this.jBq.setVisibility(0);
                        c.this.jBs = dVar.getVideoPath();
                        c.this.jBB = dVar;
                        if (c.this.jBt != null) {
                            c.this.jBt.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.jBk);
                            blurDrawable.init(12, 8, dVar.cup());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.jBt.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.jBq.start();
                    }
                }
            }
        });
        this.jBu.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void ax(float f) {
                c.this.jBw = c.this.jBo.getTop();
                c.this.jBx = c.this.idu.getTop();
                c.this.jBy = c.this.jBu.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.jBu.setIsCanLayout(false);
                int i2 = (int) (c.this.jBw + f2);
                int i3 = i == 1 ? (int) (c.this.jBx + f2) : (int) (c.this.jBx + (f2 * 0.3d));
                if (i2 >= c.this.jBv.getBottom() && i2 <= l.getDimens(c.this.jBk, R.dimen.ds902)) {
                    c.this.idu.layout(c.this.idu.getLeft(), i3, c.this.idu.getRight(), c.this.jBz + i3);
                    c.this.jBo.layout(c.this.jBo.getLeft(), i2, c.this.jBo.getRight(), c.this.jBo.getBottom());
                    if (i2 <= l.getDimens(c.this.jBk, R.dimen.ds400)) {
                        c.this.jBE = false;
                        c.this.jBq.pause();
                    } else {
                        c.this.jBE = true;
                        c.this.jBq.start();
                    }
                    float dimens = (l.getDimens(c.this.jBk, R.dimen.ds902) - i2) / l.getDimens(c.this.jBk, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.jBt.setVisibility(8);
                        return;
                    }
                    c.this.jBt.setVisibility(0);
                    c.this.jBt.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void csU() {
                if (c.this.jBo.getTop() > c.this.jBy / 2) {
                    c.this.jBE = true;
                    c.this.jBq.start();
                    c.this.jBt.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.idu.getBottom(), c.this.jBz);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.idu.layout(c.this.idu.getLeft(), 0, c.this.idu.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.jBo.getTop(), c.this.jBz);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.jBo.layout(c.this.jBo.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jBo.getRight(), c.this.jBo.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.jBE = false;
                c.this.jBq.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.idu.getBottom(), l.getDimens(c.this.jBk, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.idu.layout(c.this.idu.getLeft(), intValue - c.this.jBz, c.this.idu.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.jBo.getTop(), l.getDimens(c.this.jBk, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.jBo.layout(c.this.jBo.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.jBo.getRight(), c.this.jBo.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.jBo.getTop() > c.this.jBv.getBottom() || c.this.jBo.getFirstVisiblePosition() != 0 || c.this.jBo.getChildCount() <= 0 || c.this.jBo.getChildAt(0).getTop() < 0) {
                    if (c.this.jBo.getTop() <= c.this.jBv.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.jBz - l.getDimens(c.this.jBk, R.dimen.ds20))) && f2 < ((float) (c.this.jBz + l.getDimens(c.this.jBk, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.jBz = l.getDimens(this.jBk, R.dimen.ds902);
    }

    public boolean cuf() {
        return this.jBD;
    }

    public void eE(List<d> list) {
        if (!v.isEmpty(list)) {
            this.jBC = list;
            d dVar = list.get(0);
            if (this.jBq != null) {
                this.jBq.setVideoPath(dVar.getVideoPath());
                this.jBs = dVar.getVideoPath();
                this.jBB = dVar;
                if (this.jBt != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.jBk);
                    blurDrawable.init(12, 8, dVar.cup());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.jBt.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.jBq.start();
            }
            if (this.jBp != null) {
                this.jBp.setData(list);
                cun();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cug() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.jBk).hS(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.jBk.getPageContext());
        a.eh(false);
        a.akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.jBk) / l.getDimens(this.jBk, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.jBk);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.jBk, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.jBq.setVideoHeight(i4);
        this.jBq.setVideoWidth(i3);
        this.jBq.invalidate();
    }

    public void EW(String str) {
        if (this.jBp != null) {
            this.jBp.EV(str);
        }
    }

    public TextView cuh() {
        return this.fHG;
    }

    public TextView cui() {
        return this.jBr;
    }

    public void cuj() {
        if (this.jBq != null && !StringUtils.isNull(this.jBs)) {
            this.jBq.start();
        }
    }

    public void cuk() {
        if (this.jBq != null && !StringUtils.isNull(this.jBs)) {
            this.jBq.resume();
            this.jBq.seekTo(this.jBA);
            if (this.jBE) {
                this.jBq.start();
            }
        }
    }

    public void bmg() {
        this.jBA = this.jBq.getCurrentPosition();
        if (this.jBq != null) {
            this.jBq.pause();
        }
    }

    public void bmh() {
        this.jBA = this.jBq.getCurrentPosition();
        if (this.jBq != null) {
            this.jBq.stopPlayback();
        }
    }

    public String cul() {
        return this.jBs;
    }

    public d cum() {
        return this.jBB;
    }

    private void cun() {
        if (!v.isEmpty(this.jBC)) {
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
                        if (i2 >= c.this.jBC.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.jBC.get(i2);
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
                    c.this.jBp.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.jBp.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
