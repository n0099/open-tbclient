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
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c {
    private TextView gBj;
    private RelativeLayout iXo;
    private LocalVideoActivity kzE;
    private ExpandGridView kzI;
    private a kzJ;
    private CustomVideoView kzK;
    private TextView kzL;
    private String kzM;
    private ImageView kzN;
    private ExpandViewRelativeLayout kzO;
    private FrameLayout kzP;
    private int kzQ;
    private int kzR;
    private int kzS;
    private int kzT;
    private int kzU;
    private d kzV;
    private List<d> kzW;
    private boolean kzX;
    private boolean kzY;

    public c(LocalVideoActivity localVideoActivity, View.OnClickListener onClickListener) {
        super(localVideoActivity.getPageContext());
        this.kzX = false;
        this.kzY = true;
        this.kzE = localVideoActivity;
        this.kzO = (ExpandViewRelativeLayout) this.kzE.findViewById(R.id.container);
        this.kzI = (ExpandGridView) this.kzE.findViewById(R.id.local_video_gridview);
        this.iXo = (RelativeLayout) this.kzE.findViewById(R.id.preview_videoview_container);
        this.kzN = (ImageView) this.kzE.findViewById(R.id.video_cover);
        this.kzP = (FrameLayout) this.kzE.findViewById(R.id.top_container);
        this.kzK = (CustomVideoView) this.kzE.findViewById(R.id.preview_videoview);
        this.kzK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.localvideo.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                c.this.cQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kzK.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.localvideo.c.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                c.this.kzX = true;
                c.this.kzK.stopPlayback();
                return false;
            }
        });
        this.gBj = (TextView) this.kzE.findViewById(R.id.close_btn);
        this.kzL = (TextView) this.kzE.findViewById(R.id.next_step_btn);
        this.kzL.setOnClickListener(onClickListener);
        this.gBj.setOnClickListener(onClickListener);
        this.kzJ = new a(this.kzE);
        this.kzI.setAdapter((ListAdapter) this.kzJ);
        this.kzI.setSelector(new ColorDrawable(0));
        this.kzI.setVerticalScrollBarEnabled(false);
        this.kzI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.localvideo.c.3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.Adapter] */
            /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView != null && adapterView.getAdapter() != null && (adapterView.getAdapter().getItem(i) instanceof d)) {
                    c.this.kzX = false;
                    c.this.kzO.setIsCanLayout(true);
                    c.this.iXo.layout(c.this.iXo.getLeft(), 0, c.this.iXo.getRight(), c.this.kzT);
                    c.this.kzI.layout(c.this.kzI.getLeft(), c.this.kzT, c.this.kzI.getRight(), c.this.kzI.getBottom());
                    c.this.kzP.layout(c.this.kzP.getTop(), c.this.kzP.getLeft(), c.this.kzP.getRight(), c.this.kzP.getBottom());
                    d dVar = (d) adapterView.getAdapter().getItem(i);
                    if (!StringUtils.isNull(dVar.getVideoPath()) && !dVar.getVideoPath().equals(c.this.kzM) && c.this.kzK != null) {
                        c.this.kzK.setVisibility(8);
                        c.this.kzK.stopPlayback();
                        c.this.kzK.setVideoPath(dVar.getVideoPath());
                        c.this.kzK.setVisibility(0);
                        c.this.kzM = dVar.getVideoPath();
                        c.this.kzV = dVar;
                        if (c.this.kzN != null) {
                            c.this.kzN.setVisibility(8);
                            BlurDrawable blurDrawable = new BlurDrawable(c.this.kzE);
                            blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                            if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                                c.this.kzN.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                            }
                        }
                        c.this.kzK.start();
                    }
                }
            }
        });
        this.kzO.setScrollCallBack(new ExpandViewRelativeLayout.a() { // from class: com.baidu.tieba.video.localvideo.c.4
            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void aM(float f) {
                c.this.kzQ = c.this.kzI.getTop();
                c.this.kzR = c.this.iXo.getTop();
                c.this.kzS = c.this.kzO.getHeight();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void c(float f, float f2, int i) {
                c.this.kzO.setIsCanLayout(false);
                int i2 = (int) (c.this.kzQ + f2);
                int i3 = i == 1 ? (int) (c.this.kzR + f2) : (int) (c.this.kzR + (f2 * 0.3d));
                if (i2 >= c.this.kzP.getBottom() && i2 <= l.getDimens(c.this.kzE, R.dimen.ds902)) {
                    c.this.iXo.layout(c.this.iXo.getLeft(), i3, c.this.iXo.getRight(), c.this.kzT + i3);
                    c.this.kzI.layout(c.this.kzI.getLeft(), i2, c.this.kzI.getRight(), c.this.kzI.getBottom());
                    if (i2 <= l.getDimens(c.this.kzE, R.dimen.ds400)) {
                        c.this.kzY = false;
                        c.this.kzK.pause();
                    } else {
                        c.this.kzY = true;
                        c.this.kzK.start();
                    }
                    float dimens = (l.getDimens(c.this.kzE, R.dimen.ds902) - i2) / l.getDimens(c.this.kzE, R.dimen.ds902);
                    if (dimens == 0.0f) {
                        c.this.kzN.setVisibility(8);
                        return;
                    }
                    c.this.kzN.setVisibility(0);
                    c.this.kzN.setAlpha(dimens);
                }
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public void cPy() {
                if (c.this.kzI.getTop() > c.this.kzS / 2) {
                    c.this.kzY = true;
                    c.this.kzK.start();
                    c.this.kzN.setVisibility(8);
                    ValueAnimator ofInt = ValueAnimator.ofInt(c.this.iXo.getBottom(), c.this.kzT);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.iXo.layout(c.this.iXo.getLeft(), 0, c.this.iXo.getRight(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofInt.setDuration(100L);
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(c.this.kzI.getTop(), c.this.kzT);
                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            c.this.kzI.layout(c.this.kzI.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kzI.getRight(), c.this.kzI.getBottom());
                        }
                    });
                    ofInt2.setDuration(100L);
                    ofInt.start();
                    ofInt2.start();
                    return;
                }
                c.this.kzY = false;
                c.this.kzK.pause();
                ValueAnimator ofInt3 = ValueAnimator.ofInt(c.this.iXo.getBottom(), l.getDimens(c.this.kzE, R.dimen.ds134));
                ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        c.this.iXo.layout(c.this.iXo.getLeft(), intValue - c.this.kzT, c.this.iXo.getRight(), intValue);
                    }
                });
                ofInt3.setDuration(100L);
                ValueAnimator ofInt4 = ValueAnimator.ofInt(c.this.kzI.getTop(), l.getDimens(c.this.kzE, R.dimen.ds134));
                ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.video.localvideo.c.4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.kzI.layout(c.this.kzI.getLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), c.this.kzI.getRight(), c.this.kzI.getBottom());
                    }
                });
                ofInt4.setDuration(100L);
                ofInt3.start();
                ofInt4.start();
            }

            @Override // com.baidu.tieba.video.commonview.ExpandViewRelativeLayout.a
            public boolean d(float f, float f2, int i) {
                if (i != 1 || c.this.kzI.getTop() > c.this.kzP.getBottom() || c.this.kzI.getFirstVisiblePosition() != 0 || c.this.kzI.getChildCount() <= 0 || c.this.kzI.getChildAt(0).getTop() < 0) {
                    if (c.this.kzI.getTop() <= c.this.kzP.getBottom()) {
                        return false;
                    }
                    return f2 > ((float) (c.this.kzT - l.getDimens(c.this.kzE, R.dimen.ds20))) && f2 < ((float) (c.this.kzT + l.getDimens(c.this.kzE, R.dimen.ds20)));
                }
                return true;
            }
        });
        this.kzT = l.getDimens(this.kzE, R.dimen.ds902);
    }

    public boolean cQD() {
        return this.kzX;
    }

    public void er(List<d> list) {
        if (!v.isEmpty(list)) {
            this.kzW = list;
            d dVar = list.get(0);
            if (this.kzK != null) {
                this.kzK.setVideoPath(dVar.getVideoPath());
                this.kzM = dVar.getVideoPath();
                this.kzV = dVar;
                if (this.kzN != null) {
                    BlurDrawable blurDrawable = new BlurDrawable(this.kzE);
                    blurDrawable.init(12, 8, dVar.getThumbnailBitmap());
                    if (blurDrawable != null && blurDrawable.getBlurredBitmap() == null && blurDrawable.drawBlur()) {
                        this.kzN.setBackgroundDrawable(new BitmapDrawable(blurDrawable.getBlurredBitmap()));
                    }
                }
                this.kzK.start();
            }
            if (this.kzJ != null) {
                this.kzJ.setData(list);
                cQK();
                return;
            }
            return;
        }
        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.no_local_video_tip);
    }

    public void cQE() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.kzE).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.video.localvideo.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.kzE.getPageContext());
        a.fH(false);
        a.aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kzE) / l.getDimens(this.kzE, R.dimen.ds902)) {
            i3 = l.getEquipmentWidth(this.kzE);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kzE, R.dimen.ds902);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kzK.setVideoHeight(i4);
        this.kzK.setVideoWidth(i3);
        this.kzK.invalidate();
    }

    public void Kh(String str) {
        if (this.kzJ != null) {
            this.kzJ.Kg(str);
        }
    }

    public TextView cQF() {
        return this.gBj;
    }

    public TextView cQG() {
        return this.kzL;
    }

    public void startVideo() {
        if (this.kzK != null && !StringUtils.isNull(this.kzM)) {
            this.kzK.start();
        }
    }

    public void cQH() {
        if (this.kzK != null && !StringUtils.isNull(this.kzM)) {
            this.kzK.resume();
            this.kzK.seekTo(this.kzU);
            if (this.kzY) {
                this.kzK.start();
            }
        }
    }

    public void bGh() {
        this.kzU = this.kzK.getCurrentPosition();
        if (this.kzK != null) {
            this.kzK.pause();
        }
    }

    public void bGi() {
        this.kzU = this.kzK.getCurrentPosition();
        if (this.kzK != null) {
            this.kzK.stopPlayback();
        }
    }

    public String cQI() {
        return this.kzM;
    }

    public d cQJ() {
        return this.kzV;
    }

    private void cQK() {
        if (!v.isEmpty(this.kzW)) {
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
                        if (i2 >= c.this.kzW.size()) {
                            return null;
                        }
                        d dVar = (d) c.this.kzW.get(i2);
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
                    c.this.kzJ.notifyDataSetChanged();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Void r2) {
                    super.onPostExecute((AnonymousClass6) r2);
                    c.this.kzJ.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }
}
