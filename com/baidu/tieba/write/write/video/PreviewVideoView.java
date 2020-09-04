package com.baidu.tieba.write.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.b;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.EditVideoData;
/* loaded from: classes3.dex */
public class PreviewVideoView extends FrameLayout {
    private static int mYj;
    private static int mYk;
    private String coverPath;
    private b eLP;
    private TbImageView iMf;
    private Path mKb;
    private CustomVideoView mYl;
    protected ImageView mYm;
    private TBSpecificationBtn mYn;
    private float mYo;
    private Paint mYp;
    private Paint mYq;
    private int mzr;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.mKb = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mKb = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKb = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        mYj = l.getDimens(getContext(), R.dimen.tbds728);
        mYk = l.getDimens(getContext(), R.dimen.tbds658);
        dK(context);
        this.eLP = new b();
        this.iMf = new TbImageView(context);
        addView(this.iMf, new FrameLayout.LayoutParams(-2, -2));
        this.mYm = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.mYm.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.mYm, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.blo();
        this.mYn = new TBSpecificationBtn(context);
        this.mYn.setConfig(bVar);
        this.mYn.setText(context.getString(R.string.edit));
        this.mYn.setTextSize(R.dimen.tbds26);
        addView(this.mYn, layoutParams2);
        this.mYp = new Paint();
        this.mYq = new Paint();
        changeSkin();
    }

    private void dK(Context context) {
        this.mYl = new CustomVideoView(context);
        addView(this.mYl, new FrameLayout.LayoutParams(-2, -2));
        this.mYl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.mYl.start();
            }
        });
        this.mYl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dx(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.iMf.setVisibility(8);
            }
        });
    }

    public void dx(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > mYk / mYj) {
            i3 = mYk;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = mYj;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.mYl.getWidth() != i3 || this.mYl.getHeight() != i4) {
            this.mYl.setVideoHeight(i4);
            this.mYl.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.iMf.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.iMf.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mYm.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.mzr = 0;
        this.mYo = 0.0f;
        this.coverPath = null;
        coK();
    }

    public void Ta(String str) {
        if (!StringUtils.isNull(str)) {
            this.mYl.setVideoPath(str);
            this.mYl.start();
            this.mYl.seekTo(this.mzr);
        }
    }

    public void coK() {
        this.mzr = this.mYl.getCurrentPosition();
        if (this.mYl != null) {
            this.mYl.stopPlayback();
            this.mYl.setVideoURI(null);
        }
        this.iMf.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        coK();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dJC();
            Ta(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dJC() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(mYk, mYj);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.iMf.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a = this.eLP.a(imageFileInfo, false);
        if (a != null) {
            dx(a.getWidth(), a.getHeight());
            this.iMf.invalidate();
            return;
        }
        this.eLP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.iMf != null && aVar != null) {
                    PreviewVideoView.this.dx(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.iMf.invalidate();
                }
            }
        }, false);
    }

    public void dJD() {
        if (this.iMf != null && this.iMf.getTag() != null) {
            c.bsX().deletePic(this.iMf.getTag().toString());
            c.bsX().deletePhoto(this.iMf.getTag().toString());
        }
    }

    public void changeSkin() {
        ap.setImageResource(this.mYm, R.drawable.ic_post_image_delete_n);
        this.mYp.setColor(ap.getColor(R.color.cp_mask_c_alpha50));
        this.mYq.setColor(ap.getColor(R.color.cp_link_tip_a));
    }

    public void aI(float f) {
        this.mYo = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mKb.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.mKb.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mKb);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.mYp);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.mYo, l.getDimens(getContext(), R.dimen.tbds5), this.mYq);
        canvas.restore();
    }
}
