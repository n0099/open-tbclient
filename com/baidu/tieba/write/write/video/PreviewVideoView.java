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
    private static int ogB;
    private static int ogC;
    private String coverPath;
    private b fvq;
    private float gXG;
    private TbImageView jQE;
    private int nGv;
    private Path nRn;
    private CustomVideoView ogD;
    protected ImageView ogE;
    private TBSpecificationBtn ogF;
    private Paint ogG;
    private Paint ogH;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nRn = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRn = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRn = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        ogB = l.getDimens(getContext(), R.dimen.tbds429);
        ogC = l.getDimens(getContext(), R.dimen.tbds572);
        eu(context);
        this.fvq = new b();
        this.jQE = new TbImageView(context);
        this.jQE.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.jQE, new FrameLayout.LayoutParams(-2, -2));
        this.ogE = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.ogE.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.ogE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bwc();
        this.ogF = new TBSpecificationBtn(context);
        this.ogF.setConfig(bVar);
        this.ogF.setText(context.getString(R.string.edit));
        this.ogF.setTextSize(R.dimen.T_X10);
        addView(this.ogF, layoutParams2);
        this.ogG = new Paint();
        this.ogH = new Paint();
        bvs();
    }

    private void eu(Context context) {
        this.ogD = new CustomVideoView(context);
        addView(this.ogD, new FrameLayout.LayoutParams(-2, -2));
        this.ogD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.ogD.start();
            }
        });
        this.ogD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dL(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.jQE.setVisibility(8);
            }
        });
    }

    public void dL(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i > i2) {
            i3 = ogC;
            i4 = l.getDimens(getContext(), R.dimen.tbds322);
        } else {
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = ogB;
        }
        if (this.ogD.getWidth() != i3 || this.ogD.getHeight() != i4) {
            this.ogD.setVideoHeight(i4);
            this.ogD.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.jQE.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.jQE.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.ogE.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.nGv = 0;
        this.gXG = 0.0f;
        this.coverPath = null;
        cEW();
    }

    public void Wd(String str) {
        if (!StringUtils.isNull(str)) {
            this.ogD.setVideoPath(str);
            this.ogD.start();
            this.ogD.seekTo(this.nGv);
        }
    }

    public void cEW() {
        this.nGv = this.ogD.getCurrentPosition();
        if (this.ogD != null) {
            this.ogD.stopPlayback();
            this.ogD.setVideoURI(null);
        }
        this.jQE.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cEW();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            ecy();
            Wd(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void ecy() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bi = d.bi(ogC, ogB);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bi);
        this.jQE.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fvq.a(imageFileInfo, false);
        if (a2 != null) {
            dL(a2.getWidth(), a2.getHeight());
            this.jQE.invalidate();
            return;
        }
        this.fvq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.jQE != null && aVar != null) {
                    PreviewVideoView.this.dL(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.jQE.invalidate();
                }
            }
        }, false);
    }

    public void ecz() {
        if (this.jQE != null && this.jQE.getTag() != null) {
            c.bDV().deletePic(this.jQE.getTag().toString());
            c.bDV().deletePhoto(this.jQE.getTag().toString());
        }
    }

    public void bvs() {
        this.ogE.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.ogG.setColor(ap.getColor(R.color.CAM_X0618));
        this.ogH.setColor(ap.getColor(R.color.CAM_X0302));
    }

    public void ba(float f) {
        this.gXG = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nRn.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nRn.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nRn);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.ogG);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.gXG, l.getDimens(getContext(), R.dimen.tbds5), this.ogH);
        canvas.restore();
    }
}
