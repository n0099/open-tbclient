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
/* loaded from: classes8.dex */
public class PreviewVideoView extends FrameLayout {
    private static int onT;
    private static int onU;
    private String coverPath;
    private b fCD;
    private float hjr;
    private TbImageView khe;
    private Path oaH;
    private CustomVideoView onV;
    protected ImageView onW;
    private TBSpecificationBtn onX;
    private Paint onY;
    private Paint onZ;
    private int ooa;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.oaH = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oaH = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oaH = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        onT = l.getDimens(getContext(), R.dimen.tbds429);
        onU = l.getDimens(getContext(), R.dimen.tbds572);
        eL(context);
        this.fCD = new b();
        this.khe = new TbImageView(context);
        this.khe.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.khe, new FrameLayout.LayoutParams(-2, -2));
        this.onW = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.onW.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.onW, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.buX();
        this.onX = new TBSpecificationBtn(context);
        this.onX.setConfig(bVar);
        this.onX.setText(context.getString(R.string.edit));
        this.onX.setTextSize(R.dimen.T_X10);
        addView(this.onX, layoutParams2);
        this.onY = new Paint();
        this.onZ = new Paint();
        buo();
    }

    private void eL(Context context) {
        this.onV = new CustomVideoView(context);
        addView(this.onV, new FrameLayout.LayoutParams(-2, -2));
        this.onV.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.onV.start();
            }
        });
        this.onV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dE(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.khe.setVisibility(8);
            }
        });
    }

    public void dE(int i, int i2) {
        int i3;
        int i4;
        if (i2 <= 0) {
            i3 = 0;
            i4 = 0;
        } else if (i > i2) {
            int i5 = onU;
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = i5;
        } else {
            int dimens = l.getDimens(getContext(), R.dimen.tbds322);
            i3 = onT;
            i4 = dimens;
        }
        if (this.onV.getWidth() != i4 || this.onV.getHeight() != i3) {
            this.onV.setVideoHeight(i3);
            this.onV.setVideoWidth(i4);
            ViewGroup.LayoutParams layoutParams = this.khe.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i3;
            this.khe.setLayoutParams(layoutParams);
            getLayoutParams().height = i3;
            getLayoutParams().width = i4;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.onW.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.ooa = 0;
        this.hjr = 0.0f;
        this.coverPath = null;
        stopVideo();
    }

    public void VF(String str) {
        if (!StringUtils.isNull(str)) {
            this.onV.setVideoPath(str);
            this.onV.start();
            this.onV.seekTo(this.ooa);
        }
    }

    public void stopVideo() {
        this.ooa = this.onV.getCurrentPosition();
        if (this.onV != null) {
            this.onV.stopPlayback();
            this.onV.setVideoURI(null);
        }
        this.khe.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        stopVideo();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dZW();
            VF(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dZW() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bd = d.bd(onU, onT);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bd);
        this.khe.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fCD.a(imageFileInfo, false);
        if (a2 != null) {
            dE(a2.getWidth(), a2.getHeight());
            this.khe.invalidate();
            return;
        }
        this.fCD.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.khe != null && aVar != null) {
                    PreviewVideoView.this.dE(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.khe.invalidate();
                }
            }
        }, false);
    }

    public void dZX() {
        if (this.khe != null && this.khe.getTag() != null) {
            c.bCP().deletePic(this.khe.getTag().toString());
            c.bCP().deletePhoto(this.khe.getTag().toString());
        }
    }

    public void buo() {
        this.onW.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.onY.setColor(ap.getColor(R.color.CAM_X0618));
        this.onZ.setColor(ap.getColor(R.color.CAM_X0302));
    }

    public void bf(float f) {
        this.hjr = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oaH.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.oaH.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.oaH);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.onY);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.hjr, l.getDimens(getContext(), R.dimen.tbds5), this.onZ);
        canvas.restore();
    }
}
