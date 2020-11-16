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
import com.baidu.tbadk.core.util.WebPManager;
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
    private static int nRB;
    private static int nRC;
    private String coverPath;
    private b fnM;
    private float gOr;
    private TbImageView jDa;
    private Path nDj;
    private CustomVideoView nRD;
    protected ImageView nRE;
    private TBSpecificationBtn nRF;
    private Paint nRG;
    private Paint nRH;
    private int nss;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nDj = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nDj = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDj = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        nRB = l.getDimens(getContext(), R.dimen.tbds429);
        nRC = l.getDimens(getContext(), R.dimen.tbds572);
        dP(context);
        this.fnM = new b();
        this.jDa = new TbImageView(context);
        this.jDa.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.jDa, new FrameLayout.LayoutParams(-2, -2));
        this.nRE = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.nRE.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.nRE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bsC();
        this.nRF = new TBSpecificationBtn(context);
        this.nRF.setConfig(bVar);
        this.nRF.setText(context.getString(R.string.edit));
        this.nRF.setTextSize(R.dimen.T_X10);
        addView(this.nRF, layoutParams2);
        this.nRG = new Paint();
        this.nRH = new Paint();
        changeSkin();
    }

    private void dP(Context context) {
        this.nRD = new CustomVideoView(context);
        addView(this.nRD, new FrameLayout.LayoutParams(-2, -2));
        this.nRD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.nRD.start();
            }
        });
        this.nRD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dG(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.jDa.setVisibility(8);
            }
        });
    }

    public void dG(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i > i2) {
            i3 = nRC;
            i4 = l.getDimens(getContext(), R.dimen.tbds322);
        } else {
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = nRB;
        }
        if (this.nRD.getWidth() != i3 || this.nRD.getHeight() != i4) {
            this.nRD.setVideoHeight(i4);
            this.nRD.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.jDa.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.jDa.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.nRE.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.nss = 0;
        this.gOr = 0.0f;
        this.coverPath = null;
        cAF();
    }

    public void UO(String str) {
        if (!StringUtils.isNull(str)) {
            this.nRD.setVideoPath(str);
            this.nRD.start();
            this.nRD.seekTo(this.nss);
        }
    }

    public void cAF() {
        this.nss = this.nRD.getCurrentPosition();
        if (this.nRD != null) {
            this.nRD.stopPlayback();
            this.nRD.setVideoURI(null);
        }
        this.jDa.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cAF();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dWT();
            UO(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dWT() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(nRC, nRB);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.jDa.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fnM.a(imageFileInfo, false);
        if (a2 != null) {
            dG(a2.getWidth(), a2.getHeight());
            this.jDa.invalidate();
            return;
        }
        this.fnM.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.jDa != null && aVar != null) {
                    PreviewVideoView.this.dG(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.jDa.invalidate();
                }
            }
        }, false);
    }

    public void dWU() {
        if (this.jDa != null && this.jDa.getTag() != null) {
            c.bAt().deletePic(this.jDa.getTag().toString());
            c.bAt().deletePhoto(this.jDa.getTag().toString());
        }
    }

    public void changeSkin() {
        this.nRE.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.nRG.setColor(ap.getColor(R.color.CAM_X0618));
        this.nRH.setColor(ap.getColor(R.color.CAM_X0302));
    }

    public void aZ(float f) {
        this.gOr = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nDj.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nDj.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nDj);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.nRG);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.gOr, l.getDimens(getContext(), R.dimen.tbds5), this.nRH);
        canvas.restore();
    }
}
