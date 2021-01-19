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
    private static int odB;
    private static int odC;
    private String coverPath;
    private b fAo;
    private float heN;
    private TbImageView jZn;
    private Path nQd;
    private CustomVideoView odD;
    protected ImageView odE;
    private TBSpecificationBtn odF;
    private Paint odG;
    private Paint odH;
    private int odI;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nQd = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQd = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQd = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        odB = l.getDimens(getContext(), R.dimen.tbds429);
        odC = l.getDimens(getContext(), R.dimen.tbds572);
        eM(context);
        this.fAo = new b();
        this.jZn = new TbImageView(context);
        this.jZn.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.jZn, new FrameLayout.LayoutParams(-2, -2));
        this.odE = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.odE.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.odE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.buD();
        this.odF = new TBSpecificationBtn(context);
        this.odF.setConfig(bVar);
        this.odF.setText(context.getString(R.string.edit));
        this.odF.setTextSize(R.dimen.T_X10);
        addView(this.odF, layoutParams2);
        this.odG = new Paint();
        this.odH = new Paint();
        btU();
    }

    private void eM(Context context) {
        this.odD = new CustomVideoView(context);
        addView(this.odD, new FrameLayout.LayoutParams(-2, -2));
        this.odD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.odD.start();
            }
        });
        this.odD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
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
            int i5 = odC;
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = i5;
        } else {
            int dimens = l.getDimens(getContext(), R.dimen.tbds322);
            i3 = odB;
            i4 = dimens;
        }
        if (this.odD.getWidth() != i4 || this.odD.getHeight() != i3) {
            this.odD.setVideoHeight(i3);
            this.odD.setVideoWidth(i4);
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
        this.odE.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.odI = 0;
        this.heN = 0.0f;
        this.coverPath = null;
        stopVideo();
    }

    public void Uv(String str) {
        if (!StringUtils.isNull(str)) {
            this.odD.setVideoPath(str);
            this.odD.start();
            this.odD.seekTo(this.odI);
        }
    }

    public void stopVideo() {
        this.odI = this.odD.getCurrentPosition();
        if (this.odD != null) {
            this.odD.stopPlayback();
            this.odD.setVideoURI(null);
        }
        this.jZn.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        stopVideo();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dXD();
            Uv(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dXD() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(odC, odB);
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
        this.odE.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.odG.setColor(ao.getColor(R.color.CAM_X0618));
        this.odH.setColor(ao.getColor(R.color.CAM_X0302));
    }

    public void bc(float f) {
        this.heN = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nQd.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nQd.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nQd);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.odG);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.heN, l.getDimens(getContext(), R.dimen.tbds5), this.odH);
        canvas.restore();
    }
}
