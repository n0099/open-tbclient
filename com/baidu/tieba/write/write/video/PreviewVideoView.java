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
/* loaded from: classes8.dex */
public class PreviewVideoView extends FrameLayout {
    private static int oig;
    private static int oih;
    private String coverPath;
    private b fEW;
    private float hju;
    private TbImageView kdS;
    private Path nUH;
    private CustomVideoView oii;
    protected ImageView oij;
    private TBSpecificationBtn oik;
    private Paint oil;
    private Paint oim;
    private int oin;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nUH = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nUH = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUH = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        oig = l.getDimens(getContext(), R.dimen.tbds429);
        oih = l.getDimens(getContext(), R.dimen.tbds572);
        eN(context);
        this.fEW = new b();
        this.kdS = new TbImageView(context);
        this.kdS.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.kdS, new FrameLayout.LayoutParams(-2, -2));
        this.oij = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.oij.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.oij, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.byx();
        this.oik = new TBSpecificationBtn(context);
        this.oik.setConfig(bVar);
        this.oik.setText(context.getString(R.string.edit));
        this.oik.setTextSize(R.dimen.T_X10);
        addView(this.oik, layoutParams2);
        this.oil = new Paint();
        this.oim = new Paint();
        bxO();
    }

    private void eN(Context context) {
        this.oii = new CustomVideoView(context);
        addView(this.oii, new FrameLayout.LayoutParams(-2, -2));
        this.oii.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.oii.start();
            }
        });
        this.oii.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dG(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.kdS.setVisibility(8);
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
            int i5 = oih;
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = i5;
        } else {
            int dimens = l.getDimens(getContext(), R.dimen.tbds322);
            i3 = oig;
            i4 = dimens;
        }
        if (this.oii.getWidth() != i4 || this.oii.getHeight() != i3) {
            this.oii.setVideoHeight(i3);
            this.oii.setVideoWidth(i4);
            ViewGroup.LayoutParams layoutParams = this.kdS.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i3;
            this.kdS.setLayoutParams(layoutParams);
            getLayoutParams().height = i3;
            getLayoutParams().width = i4;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.oij.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.oin = 0;
        this.hju = 0.0f;
        this.coverPath = null;
        stopVideo();
    }

    public void VC(String str) {
        if (!StringUtils.isNull(str)) {
            this.oii.setVideoPath(str);
            this.oii.start();
            this.oii.seekTo(this.oin);
        }
    }

    public void stopVideo() {
        this.oin = this.oii.getCurrentPosition();
        if (this.oii != null) {
            this.oii.stopPlayback();
            this.oii.setVideoURI(null);
        }
        this.kdS.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        stopVideo();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            ebv();
            VC(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void ebv() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(oih, oig);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.kdS.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fEW.a(imageFileInfo, false);
        if (a2 != null) {
            dG(a2.getWidth(), a2.getHeight());
            this.kdS.invalidate();
            return;
        }
        this.fEW.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.kdS != null && aVar != null) {
                    PreviewVideoView.this.dG(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.kdS.invalidate();
                }
            }
        }, false);
    }

    public void ebw() {
        if (this.kdS != null && this.kdS.getTag() != null) {
            c.bGq().deletePic(this.kdS.getTag().toString());
            c.bGq().deletePhoto(this.kdS.getTag().toString());
        }
    }

    public void bxO() {
        this.oij.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.oil.setColor(ao.getColor(R.color.CAM_X0618));
        this.oim.setColor(ao.getColor(R.color.CAM_X0302));
    }

    public void bc(float f) {
        this.hju = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nUH.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nUH.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nUH);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.oil);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.hju, l.getDimens(getContext(), R.dimen.tbds5), this.oim);
        canvas.restore();
    }
}
