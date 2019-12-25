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
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.base.c {
    private TextView gvZ;
    private RelativeLayout iSr;
    private LocalVideoActivity kvb;
    private ExpandGridView kvf;
    private a kvg;
    private CustomVideoView kvh;
    private TextView kvi;
    private String kvj;
    private ImageView kvk;
    private ExpandViewRelativeLayout kvl;
    private FrameLayout kvm;
    private int kvn;
    private int kvo;
    private int kvp;
    private int kvq;
    private int kvr;
    private d kvs;
    private List<d> kvt;
    private boolean kvu;
    private boolean kvv;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.kvu = false;
        this.kvv = true;
        this.kvb = localVideoActivity;
        this.kvl = (ExpandViewRelativeLayout) this.kvb.findViewById(R.id.container);
        this.kvf = (ExpandGridView) this.kvb.findViewById(R.id.local_video_gridview);
        this.iSr = (RelativeLayout) this.kvb.findViewById(R.id.preview_videoview_container);
        this.kvk = (ImageView) this.kvb.findViewById(R.id.video_cover);
        this.kvm = (FrameLayout) this.kvb.findViewById(R.id.top_container);
        this.kvh = (CustomVideoView) this.kvb.findViewById(R.id.preview_videoview);
        this.kvh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kvh.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.kvu = true;
                c.this.kvh.stopPlayback();
                return false;
            }
        });
        this.gvZ = (TextView) this.kvb.findViewById(R.id.close_btn);
        this.kvi = (TextView) this.kvb.findViewById(R.id.next_step_btn);
        this.kvi.setOnClickListener(onClickListener);
        this.gvZ.setOnClickListener(onClickListener);
        this.kvg = new a(this.kvb);
        this.kvf.setAdapter((ListAdapter) this.kvg);
        this.kvf.setSelector(new ColorDrawable(0));
        this.kvf.setVerticalScrollBarEnabled(false);
        this.kvf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.kvu = false;
                    c.this.kvl.setIsCanLayout(true);
                    c.this.iSr.layout(c.this.iSr.getLeft(), 0, c.this.iSr.getRight(), c.this.kvq);
                    c.this.kvf.layout(c.this.kvf.getLeft(), c.this.kvq, c.this.kvf.getRight(), c.this.kvf.getBottom());
                    c.this.kvm.layout(c.this.kvm.getTop(), c.this.kvm.getLeft(), c.this.kvm.getRight(), c.this.kvm.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.kvj) && c.this.kvh != null) {
                        c.this.kvh.setVisibility(8);
                        c.this.kvh.stopPlayback();
                        c.this.kvh.setVideoPath(dVar.getVideoPath());
                        c.this.kvh.setVisibility(0);
                        c.this.kvj = dVar.getVideoPath();
                        c.this.kvs = dVar;
                        if (c.this.kvk != null) {
                            c.this.kvk.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.kvb);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.kvk.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.kvh.start();
                    }
                }
            }
        });
        this.kvl.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aO(float f) {
                c.this.kvn = c.this.kvf.getTop();
                c.this.kvo = c.this.iSr.getTop();
                c.this.kvp = c.this.kvl.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.kvl.setIsCanLayout(false);
                int i2 = (int) (c.this.kvn + f2);
                int i3 = i == 1 ? (int) (c.this.kvo + f2) : (int) (c.this.kvo + (f2 * 0.3d));
                if (i2 >= c.this.kvm.getBottom() && i2 <= l.getDimens(c.this.kvb, R.dimen.ds902)) {
                    c.this.iSr.layout(c.this.iSr.getLeft(), i3, c.this.iSr.getRight(), c.this.kvq + i3);
                    c.this.kvf.layout(c.this.kvf.getLeft(), i2, c.this.kvf.getRight(), c.this.kvf.getBottom());
                    if (i2 <= l.getDimens(c.this.kvb, R.dimen.ds400)) {
                        c.this.kvv = false;
                        c.this.kvh.pause();
                    } else {
                        c.this.kvv = true;
                        c.this.kvh.start();
                    }
                    float dimens = (l.getDimens(c.this.kvb, R.dimen.ds902) - i2) / l.getDimens(c.this.kvb, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.kvk.setVisibility(8);
                        return;
                    }
                    c.this.kvk.setVisibility(0);
                    c.this.kvk.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cMW() {
                if (c.this.kvf.getTop() > c.this.kvp / 2) {
                    c.this.kvv = true;
                    c.this.kvh.start();
                    c.this.kvk.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iSr.getBottom(), c.this.kvq);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iSr.layout(c.this.iSr.getLeft(), 0, c.this.iSr.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.kvf.getTop(), c.this.kvq);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kvf.layout(c.this.kvf.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kvf.getRight(), c.this.kvf.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.kvv = false;
                c.this.kvh.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iSr.getBottom(), l.getDimens(c.this.kvb, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iSr.layout(c.this.iSr.getLeft(), intValue - c.this.kvq, c.this.iSr.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.kvf.getTop(), l.getDimens(c.this.kvb, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.kvf.layout(c.this.kvf.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kvf.getRight(), c.this.kvf.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.kvf.getTop() > c.this.kvm.getBottom() || c.this.kvf.getFirstVisiblePosition() != 0 || c.this.kvf.getChildCount() <= 0 || c.this.kvf.getChildAt(0).getTop() < 0) {
                    if (c.this.kvf.getTop() <= c.this.kvm.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.kvq - l.getDimens(c.this.kvb, R.dimen.ds20))) && f2 < ((float) (c.this.kvq + l.getDimens(c.this.kvb, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.kvq = l.getDimens(this.kvb, R.dimen.ds902);
    }

    public boolean cOf() {
        return this.kvu;
    }

    public void ew(List<d> list) {
        if (!v.isEmpty(list)) {
            this.kvt = list;
            d dVar = list.get(0);
            if (this.kvh != null) {
                this.kvh.setVideoPath(dVar.getVideoPath());
                this.kvj = dVar.getVideoPath();
                this.kvs = dVar;
                if (this.kvk != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.kvb);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.kvk.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.kvh.start();
            }
            if (this.kvg != null) {
                this.kvg.setData(list);
                cOm();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cOg() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.kvb).jE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.kvb.getPageContext());
        a.fv(false);
        a.aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kvb) / l.getDimens(this.kvb, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.kvb);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kvb, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kvh.setVideoHeight(i4);
        this.kvh.setVideoWidth(i3);
        this.kvh.invalidate();
    }

    public void JK(String str) {
        if (this.kvg != null) {
            this.kvg.JJ(str);
        }
    }

    public TextView cOh() {
        return this.gvZ;
    }

    public TextView cOi() {
        return this.kvi;
    }

    public void startVideo() {
        if (this.kvh != null && !StringUtils.isNull(this.kvj)) {
            this.kvh.start();
        }
    }

    public void cOj() {
        if (this.kvh != null && !StringUtils.isNull(this.kvj)) {
            this.kvh.resume();
            this.kvh.seekTo(this.kvr);
            if (this.kvv) {
                this.kvh.start();
            }
        }
    }

    public void bDD() {
        this.kvr = this.kvh.getCurrentPosition();
        if (this.kvh != null) {
            this.kvh.pause();
        }
    }

    public void bDE() {
        this.kvr = this.kvh.getCurrentPosition();
        if (this.kvh != null) {
            this.kvh.stopPlayback();
        }
    }

    public String cOk() {
        return this.kvj;
    }

    public d cOl() {
        return this.kvs;
    }

    private void cOm() {
        if (!v.isEmpty(this.kvt)) {
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
                        if (i2 >= c.this.kvt.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.kvt.get(i2);
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
                                        dVar.setThumbnailBitmap(Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true));
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
                            dVar.setHasLoaded(true);
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
                    c.this.kvg.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.kvg.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
