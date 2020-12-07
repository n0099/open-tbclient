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
    private static int ogA;
    private static int ogz;
    private String coverPath;
    private b fvq;
    private float gXE;
    private TbImageView jQC;
    private int nGt;
    private Path nRl;
    private CustomVideoView ogB;
    protected ImageView ogC;
    private TBSpecificationBtn ogD;
    private Paint ogE;
    private Paint ogF;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nRl = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRl = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRl = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        ogz = l.getDimens(getContext(), R.dimen.tbds429);
        ogA = l.getDimens(getContext(), R.dimen.tbds572);
        eu(context);
        this.fvq = new b();
        this.jQC = new TbImageView(context);
        this.jQC.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.jQC, new FrameLayout.LayoutParams(-2, -2));
        this.ogC = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.ogC.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.ogC, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bwc();
        this.ogD = new TBSpecificationBtn(context);
        this.ogD.setConfig(bVar);
        this.ogD.setText(context.getString(R.string.edit));
        this.ogD.setTextSize(R.dimen.T_X10);
        addView(this.ogD, layoutParams2);
        this.ogE = new Paint();
        this.ogF = new Paint();
        bvs();
    }

    private void eu(Context context) {
        this.ogB = new CustomVideoView(context);
        addView(this.ogB, new FrameLayout.LayoutParams(-2, -2));
        this.ogB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.ogB.start();
            }
        });
        this.ogB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dL(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.jQC.setVisibility(8);
            }
        });
    }

    public void dL(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i > i2) {
            i3 = ogA;
            i4 = l.getDimens(getContext(), R.dimen.tbds322);
        } else {
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = ogz;
        }
        if (this.ogB.getWidth() != i3 || this.ogB.getHeight() != i4) {
            this.ogB.setVideoHeight(i4);
            this.ogB.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.jQC.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.jQC.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.ogC.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.nGt = 0;
        this.gXE = 0.0f;
        this.coverPath = null;
        cEV();
    }

    public void Wd(String str) {
        if (!StringUtils.isNull(str)) {
            this.ogB.setVideoPath(str);
            this.ogB.start();
            this.ogB.seekTo(this.nGt);
        }
    }

    public void cEV() {
        this.nGt = this.ogB.getCurrentPosition();
        if (this.ogB != null) {
            this.ogB.stopPlayback();
            this.ogB.setVideoURI(null);
        }
        this.jQC.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cEV();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            ecx();
            Wd(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void ecx() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bi = d.bi(ogA, ogz);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bi);
        this.jQC.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fvq.a(imageFileInfo, false);
        if (a2 != null) {
            dL(a2.getWidth(), a2.getHeight());
            this.jQC.invalidate();
            return;
        }
        this.fvq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.jQC != null && aVar != null) {
                    PreviewVideoView.this.dL(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.jQC.invalidate();
                }
            }
        }, false);
    }

    public void ecy() {
        if (this.jQC != null && this.jQC.getTag() != null) {
            c.bDV().deletePic(this.jQC.getTag().toString());
            c.bDV().deletePhoto(this.jQC.getTag().toString());
        }
    }

    public void bvs() {
        this.ogC.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.ogE.setColor(ap.getColor(R.color.CAM_X0618));
        this.ogF.setColor(ap.getColor(R.color.CAM_X0302));
    }

    public void ba(float f) {
        this.gXE = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nRl.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nRl.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nRl);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.ogE);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.gXE, l.getDimens(getContext(), R.dimen.tbds5), this.ogF);
        canvas.restore();
    }
}
