package com.baidu.tieba.write.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes7.dex */
public class PreviewVideoView extends FrameLayout {
    private static int odA;
    private static int odB;
    private String coverPath;
    private b fAo;
    private float heN;
    private TbImageView jZn;
    private Path nQc;
    private CustomVideoView odC;
    protected ImageView odD;
    private TBSpecificationBtn odE;
    private Paint odF;
    private Paint odG;
    private int odH;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nQc = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQc = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQc = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        odA = l.getDimens(getContext(), R.dimen.tbds429);
        odB = l.getDimens(getContext(), R.dimen.tbds572);
        eM(context);
        this.fAo = new b();
        this.jZn = new TbImageView(context);
        this.jZn.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.jZn, new FrameLayout.LayoutParams(-2, -2));
        this.odD = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.odD.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.odD, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.buD();
        this.odE = new TBSpecificationBtn(context);
        this.odE.setConfig(bVar);
        this.odE.setText(context.getString(R.string.edit));
        this.odE.setTextSize(R.dimen.T_X10);
        addView(this.odE, layoutParams2);
        this.odF = new Paint();
        this.odG = new Paint();
        btU();
    }

    private void eM(Context context) {
        this.odC = new CustomVideoView(context);
        addView(this.odC, new FrameLayout.LayoutParams(-2, -2));
        this.odC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.odC.start();
            }
        });
        this.odC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dG(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.jZn.setVisibility(8);
            }
        });
    }

    public void dG(int i, int i2) {
        int i3;
        int i4;
        if (i2 <= 0) {
            i3 = 0;
            i4 = 0;
        } else if (i > i2) {
            int i5 = odB;
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = i5;
        } else {
            int dimens = l.getDimens(getContext(), R.dimen.tbds322);
            i3 = odA;
            i4 = dimens;
        }
        if (this.odC.getWidth() != i4 || this.odC.getHeight() != i3) {
            this.odC.setVideoHeight(i3);
            this.odC.setVideoWidth(i4);
            ViewGroup.LayoutParams layoutParams = this.jZn.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i3;
            this.jZn.setLayoutParams(layoutParams);
            getLayoutParams().height = i3;
            getLayoutParams().width = i4;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.odD.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.odH = 0;
        this.heN = 0.0f;
        this.coverPath = null;
        stopVideo();
    }

    public void Uu(String str) {
        if (!StringUtils.isNull(str)) {
            this.odC.setVideoPath(str);
            this.odC.start();
            this.odC.seekTo(this.odH);
        }
    }

    public void stopVideo() {
        this.odH = this.odC.getCurrentPosition();
        if (this.odC != null) {
            this.odC.stopPlayback();
            this.odC.setVideoURI(null);
        }
        this.jZn.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        stopVideo();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dXD();
            Uu(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dXD() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(odB, odA);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.jZn.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fAo.a(imageFileInfo, false);
        if (a2 != null) {
            dG(a2.getWidth(), a2.getHeight());
            this.jZn.invalidate();
            return;
        }
        this.fAo.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.jZn != null && aVar != null) {
                    PreviewVideoView.this.dG(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.jZn.invalidate();
                }
            }
        }, false);
    }

    public void dXE() {
        if (this.jZn != null && this.jZn.getTag() != null) {
            c.bCx().deletePic(this.jZn.getTag().toString());
            c.bCx().deletePhoto(this.jZn.getTag().toString());
        }
    }

    public void btU() {
        this.odD.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.odF.setColor(ao.getColor(R.color.CAM_X0618));
        this.odG.setColor(ao.getColor(R.color.CAM_X0302));
    }

    public void bc(float f) {
        this.heN = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nQc.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nQc.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nQc);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.odF);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.heN, l.getDimens(getContext(), R.dimen.tbds5), this.odG);
        canvas.restore();
    }
}
