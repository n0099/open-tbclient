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
    private static int ont;
    private static int onu;
    private String coverPath;
    private b fCD;
    private float hjd;
    private TbImageView kgQ;
    private Path oah;
    private int onA;
    private CustomVideoView onv;
    protected ImageView onw;
    private TBSpecificationBtn onx;
    private Paint ony;
    private Paint onz;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.oah = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oah = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oah = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        ont = l.getDimens(getContext(), R.dimen.tbds429);
        onu = l.getDimens(getContext(), R.dimen.tbds572);
        eL(context);
        this.fCD = new b();
        this.kgQ = new TbImageView(context);
        this.kgQ.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.kgQ, new FrameLayout.LayoutParams(-2, -2));
        this.onw = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.onw.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.onw, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.buX();
        this.onx = new TBSpecificationBtn(context);
        this.onx.setConfig(bVar);
        this.onx.setText(context.getString(R.string.edit));
        this.onx.setTextSize(R.dimen.T_X10);
        addView(this.onx, layoutParams2);
        this.ony = new Paint();
        this.onz = new Paint();
        buo();
    }

    private void eL(Context context) {
        this.onv = new CustomVideoView(context);
        addView(this.onv, new FrameLayout.LayoutParams(-2, -2));
        this.onv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.onv.start();
            }
        });
        this.onv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dD(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.kgQ.setVisibility(8);
            }
        });
    }

    public void dD(int i, int i2) {
        int i3;
        int i4;
        if (i2 <= 0) {
            i3 = 0;
            i4 = 0;
        } else if (i > i2) {
            int i5 = onu;
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = i5;
        } else {
            int dimens = l.getDimens(getContext(), R.dimen.tbds322);
            i3 = ont;
            i4 = dimens;
        }
        if (this.onv.getWidth() != i4 || this.onv.getHeight() != i3) {
            this.onv.setVideoHeight(i3);
            this.onv.setVideoWidth(i4);
            ViewGroup.LayoutParams layoutParams = this.kgQ.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i3;
            this.kgQ.setLayoutParams(layoutParams);
            getLayoutParams().height = i3;
            getLayoutParams().width = i4;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.onw.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.onA = 0;
        this.hjd = 0.0f;
        this.coverPath = null;
        stopVideo();
    }

    public void Vt(String str) {
        if (!StringUtils.isNull(str)) {
            this.onv.setVideoPath(str);
            this.onv.start();
            this.onv.seekTo(this.onA);
        }
    }

    public void stopVideo() {
        this.onA = this.onv.getCurrentPosition();
        if (this.onv != null) {
            this.onv.stopPlayback();
            this.onv.setVideoURI(null);
        }
        this.kgQ.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        stopVideo();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dZO();
            Vt(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dZO() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bd = d.bd(onu, ont);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bd);
        this.kgQ.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fCD.a(imageFileInfo, false);
        if (a2 != null) {
            dD(a2.getWidth(), a2.getHeight());
            this.kgQ.invalidate();
            return;
        }
        this.fCD.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.kgQ != null && aVar != null) {
                    PreviewVideoView.this.dD(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.kgQ.invalidate();
                }
            }
        }, false);
    }

    public void dZP() {
        if (this.kgQ != null && this.kgQ.getTag() != null) {
            c.bCP().deletePic(this.kgQ.getTag().toString());
            c.bCP().deletePhoto(this.kgQ.getTag().toString());
        }
    }

    public void buo() {
        this.onw.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.ony.setColor(ap.getColor(R.color.CAM_X0618));
        this.onz.setColor(ap.getColor(R.color.CAM_X0302));
    }

    public void bf(float f) {
        this.hjd = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oah.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.oah.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.oah);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.ony);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.hjd, l.getDimens(getContext(), R.dimen.tbds5), this.onz);
        canvas.restore();
    }
}
