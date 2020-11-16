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
    private TextView iXU;
    private RelativeLayout lLk;
    private LocalVideoActivity nsc;
    private ExpandGridView nsg;
    private a nsh;
    private CustomVideoView nsi;
    private TextView nsj;
    private String nsk;
    private ImageView nsl;
    private ExpandViewRelativeLayout nsm;
    private FrameLayout nsn;
    private int nso;
    private int nsp;
    private int nsq;
    private int nsr;
    private int nss;
    private d nst;
    private List<d> nsu;
    private boolean nsv;
    private boolean nsw;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.nsv = false;
        this.nsw = true;
        this.nsc = localVideoActivity;
        this.nsm = (ExpandViewRelativeLayout) this.nsc.findViewById(R.id.container);
        this.nsg = (ExpandGridView) this.nsc.findViewById(R.id.local_video_gridview);
        this.lLk = (RelativeLayout) this.nsc.findViewById(R.id.preview_videoview_container);
        this.nsl = (ImageView) this.nsc.findViewById(R.id.video_cover);
        this.nsn = (FrameLayout) this.nsc.findViewById(R.id.top_container);
        this.nsi = (CustomVideoView) this.nsc.findViewById(R.id.preview_videoview);
        this.nsi.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.dA(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nsi.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.nsv = true;
                c.this.nsi.stopPlayback();
                return false;
            }
        });
        this.iXU = (TextView) this.nsc.findViewById(R.id.close_btn);
        this.nsj = (TextView) this.nsc.findViewById(R.id.next_step_btn);
        this.nsj.setOnClickListener(onClickListener);
        this.iXU.setOnClickListener(onClickListener);
        this.nsh = new a(this.nsc);
        this.nsg.setAdapter((ListAdapter) this.nsh);
        this.nsg.setSelector(new ColorDrawable(0));
        this.nsg.setVerticalScrollBarEnabled(false);
        this.nsg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.nsv = false;
                    c.this.nsm.setIsCanLayout(true);
                    c.this.lLk.layout(c.this.lLk.getLeft(), 0, c.this.lLk.getRight(), c.this.nsr);
                    c.this.nsg.layout(c.this.nsg.getLeft(), c.this.nsr, c.this.nsg.getRight(), c.this.nsg.getBottom());
                    c.this.nsn.layout(c.this.nsn.getTop(), c.this.nsn.getLeft(), c.this.nsn.getRight(), c.this.nsn.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.nsk) && c.this.nsi != null) {
                        c.this.nsi.setVisibility(8);
                        c.this.nsi.stopPlayback();
                        c.this.nsi.setVideoPath(dVar.getVideoPath());
                        c.this.nsi.setVisibility(0);
                        c.this.nsk = dVar.getVideoPath();
                        c.this.nst = dVar;
                        if (c.this.nsl != null) {
                            c.this.nsl.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.nsc);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.nsl.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.nsi.start();
                    }
                }
            }
        });
        this.nsm.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aW(float f) {
                c.this.nso = c.this.nsg.getTop();
                c.this.nsp = c.this.lLk.getTop();
                c.this.nsq = c.this.nsm.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void d(float f, float f2, int i) {
                c.this.nsm.setIsCanLayout(false);
                int i2 = (int) (c.this.nso + f2);
                int i3 = i == 1 ? (int) (c.this.nsp + f2) : (int) (c.this.nsp + (f2 * 0.3d));
                if (i2 >= c.this.nsn.getBottom() && i2 <= l.getDimens(c.this.nsc, R.dimen.ds902)) {
                    c.this.lLk.layout(c.this.lLk.getLeft(), i3, c.this.lLk.getRight(), c.this.nsr + i3);
                    c.this.nsg.layout(c.this.nsg.getLeft(), i2, c.this.nsg.getRight(), c.this.nsg.getBottom());
                    if (i2 <= l.getDimens(c.this.nsc, R.dimen.ds400)) {
                        c.this.nsw = false;
                        c.this.nsi.pause();
                    } else {
                        c.this.nsw = true;
                        c.this.nsi.start();
                    }
                    float dimens = (l.getDimens(c.this.nsc, R.dimen.ds902) - i2) / l.getDimens(c.this.nsc, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.nsl.setVisibility(8);
                        return;
                    }
                    c.this.nsl.setVisibility(0);
                    c.this.nsl.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void dOM() {
                if (c.this.nsg.getTop() > c.this.nsq / 2) {
                    c.this.nsw = true;
                    c.this.nsi.start();
                    c.this.nsl.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.lLk.getBottom(), c.this.nsr);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.lLk.layout(c.this.lLk.getLeft(), 0, c.this.lLk.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.nsg.getTop(), c.this.nsr);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.nsg.layout(c.this.nsg.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nsg.getRight(), c.this.nsg.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.nsw = false;
                c.this.nsi.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.lLk.getBottom(), l.getDimens(c.this.nsc, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.lLk.layout(c.this.lLk.getLeft(), intValue - c.this.nsr, c.this.lLk.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.nsg.getTop(), l.getDimens(c.this.nsc, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.nsg.layout(c.this.nsg.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.nsg.getRight(), c.this.nsg.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean e(float f, float f2, int i) {
                if (i != 1 || c.this.nsg.getTop() > c.this.nsn.getBottom() || c.this.nsg.getFirstVisiblePosition() != 0 || c.this.nsg.getChildCount() <= 0 || c.this.nsg.getChildAt(0).getTop() < 0) {
                    if (c.this.nsg.getTop() <= c.this.nsn.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.nsr - l.getDimens(c.this.nsc, R.dimen.ds20))) && f2 < ((float) (c.this.nsr + l.getDimens(c.this.nsc, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.nsr = l.getDimens(this.nsc, R.dimen.ds902);
    }

    public boolean dPR() {
        return this.nsv;
    }

    public void fT(List<d> list) {
        if (!y.isEmpty(list)) {
            this.nsu = list;
            d dVar = list.get(0);
            if (this.nsi != null) {
                this.nsi.setVideoPath(dVar.getVideoPath());
                this.nsk = dVar.getVideoPath();
                this.nst = dVar;
                if (this.nsl != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.nsc);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.nsl.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.nsi.start();
            }
            if (this.nsh != null) {
                this.nsh.setData(list);
                dPY();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), R.string.no_local_video_tip);
    }

    public void dPS() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.nsc).or(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.nsc.getPageContext());
        a2.iX(false);
        a2.bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nsc) / l.getDimens(this.nsc, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.nsc);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nsc, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nsi.setVideoHeight(i4);
        this.nsi.setVideoWidth(i3);
        this.nsi.invalidate();
    }

    public void TH(String str) {
        if (this.nsh != null) {
            this.nsh.TG(str);
        }
    }

    public TextView dPT() {
        return this.iXU;
    }

    public TextView dPU() {
        return this.nsj;
    }

    public void startVideo() {
        if (this.nsi != null && !StringUtils.isNull(this.nsk)) {
            this.nsi.start();
        }
    }

    public void dPV() {
        if (this.nsi != null && !StringUtils.isNull(this.nsk)) {
            this.nsi.resume();
            this.nsi.seekTo(this.nss);
            if (this.nsw) {
                this.nsi.start();
            }
        }
    }

    public void pauseVideo() {
        this.nss = this.nsi.getCurrentPosition();
        if (this.nsi != null) {
            this.nsi.pause();
        }
    }

    public void cAF() {
        this.nss = this.nsi.getCurrentPosition();
        if (this.nsi != null) {
            this.nsi.stopPlayback();
        }
    }

    public String dPW() {
        return this.nsk;
    }

    public d dPX() {
        return this.nst;
    }

    private void dPY() {
        if (!y.isEmpty(this.nsu)) {
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
                        if (i2 >= c.this.nsu.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.nsu.get(i2);
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
                            dVar.yg(true);
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
                    c.this.nsh.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.nsh.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
