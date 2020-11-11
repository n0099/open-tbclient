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
    private static int nPY;
    private static int nPZ;
    private String coverPath;
    private b foE;
    private float gOK;
    private TbImageView jCd;
    private Path nBM;
    private CustomVideoView nQa;
    protected ImageView nQb;
    private TBSpecificationBtn nQc;
    private Paint nQd;
    private Paint nQe;
    private int nrl;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nBM = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nBM = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nBM = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        nPY = l.getDimens(getContext(), R.dimen.tbds728);
        nPZ = l.getDimens(getContext(), R.dimen.tbds658);
        dP(context);
        this.foE = new b();
        this.jCd = new TbImageView(context);
        addView(this.jCd, new FrameLayout.LayoutParams(-2, -2));
        this.nQb = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.nQb.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.nQb, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.btm();
        this.nQc = new TBSpecificationBtn(context);
        this.nQc.setConfig(bVar);
        this.nQc.setText(context.getString(R.string.edit));
        this.nQc.setTextSize(R.dimen.tbds26);
        addView(this.nQc, layoutParams2);
        this.nQd = new Paint();
        this.nQe = new Paint();
        changeSkin();
    }

    private void dP(Context context) {
        this.nQa = new CustomVideoView(context);
        addView(this.nQa, new FrameLayout.LayoutParams(-2, -2));
        this.nQa.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.nQa.start();
            }
        });
        this.nQa.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dF(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.jCd.setVisibility(8);
            }
        });
    }

    public void dF(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > nPZ / nPY) {
            i3 = nPZ;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = nPY;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.nQa.getWidth() != i3 || this.nQa.getHeight() != i4) {
            this.nQa.setVideoHeight(i4);
            this.nQa.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.jCd.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.jCd.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.nQb.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.nrl = 0;
        this.gOK = 0.0f;
        this.coverPath = null;
        cBc();
    }

    public void Vd(String str) {
        if (!StringUtils.isNull(str)) {
            this.nQa.setVideoPath(str);
            this.nQa.start();
            this.nQa.seekTo(this.nrl);
        }
    }

    public void cBc() {
        this.nrl = this.nQa.getCurrentPosition();
        if (this.nQa != null) {
            this.nQa.stopPlayback();
            this.nQa.setVideoURI(null);
        }
        this.jCd.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cBc();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dWU();
            Vd(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dWU() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(nPZ, nPY);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.jCd.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.foE.a(imageFileInfo, false);
        if (a2 != null) {
            dF(a2.getWidth(), a2.getHeight());
            this.jCd.invalidate();
            return;
        }
        this.foE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.jCd != null && aVar != null) {
                    PreviewVideoView.this.dF(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.jCd.invalidate();
                }
            }
        }, false);
    }

    public void dWV() {
        if (this.jCd != null && this.jCd.getTag() != null) {
            c.bBd().deletePic(this.jCd.getTag().toString());
            c.bBd().deletePhoto(this.jCd.getTag().toString());
        }
    }

    public void changeSkin() {
        ap.setImageResource(this.nQb, R.drawable.ic_post_image_delete_n);
        this.nQd.setColor(ap.getColor(R.color.cp_mask_c_alpha50));
        this.nQe.setColor(ap.getColor(R.color.cp_link_tip_a));
    }

    public void aS(float f) {
        this.gOK = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nBM.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nBM.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nBM);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.nQd);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.gOK, l.getDimens(getContext(), R.dimen.tbds5), this.nQe);
        canvas.restore();
    }
}
