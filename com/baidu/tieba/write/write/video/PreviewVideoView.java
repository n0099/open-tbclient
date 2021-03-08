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
/* loaded from: classes7.dex */
public class PreviewVideoView extends FrameLayout {
    private static int opZ;
    private static int oqa;
    private String coverPath;
    private b fEc;
    private float hla;
    private TbImageView kjh;
    private Path ocO;
    private CustomVideoView oqb;
    protected ImageView oqc;
    private TBSpecificationBtn oqd;
    private Paint oqe;
    private Paint oqf;
    private int oqg;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.ocO = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ocO = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ocO = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        opZ = l.getDimens(getContext(), R.dimen.tbds429);
        oqa = l.getDimens(getContext(), R.dimen.tbds572);
        eK(context);
        this.fEc = new b();
        this.kjh = new TbImageView(context);
        this.kjh.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.kjh, new FrameLayout.LayoutParams(-2, -2));
        this.oqc = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.M_H_X001);
        int dimens2 = l.getDimens(context, R.dimen.M_W_X003);
        this.oqc.setPadding(dimens2, dimens, dimens2, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.oqc, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X003);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bva();
        this.oqd = new TBSpecificationBtn(context);
        this.oqd.setConfig(bVar);
        this.oqd.setText(context.getString(R.string.edit));
        this.oqd.setTextSize(R.dimen.T_X10);
        addView(this.oqd, layoutParams2);
        this.oqe = new Paint();
        this.oqf = new Paint();
        bur();
    }

    private void eK(Context context) {
        this.oqb = new CustomVideoView(context);
        addView(this.oqb, new FrameLayout.LayoutParams(-2, -2));
        this.oqb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.oqb.start();
            }
        });
        this.oqb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dE(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.kjh.setVisibility(8);
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
            int i5 = oqa;
            i3 = l.getDimens(getContext(), R.dimen.tbds322);
            i4 = i5;
        } else {
            int dimens = l.getDimens(getContext(), R.dimen.tbds322);
            i3 = opZ;
            i4 = dimens;
        }
        if (this.oqb.getWidth() != i4 || this.oqb.getHeight() != i3) {
            this.oqb.setVideoHeight(i3);
            this.oqb.setVideoWidth(i4);
            ViewGroup.LayoutParams layoutParams = this.kjh.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i3;
            this.kjh.setLayoutParams(layoutParams);
            getLayoutParams().height = i3;
            getLayoutParams().width = i4;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.oqc.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.oqg = 0;
        this.hla = 0.0f;
        this.coverPath = null;
        stopVideo();
    }

    public void VM(String str) {
        if (!StringUtils.isNull(str)) {
            this.oqb.setVideoPath(str);
            this.oqb.start();
            this.oqb.seekTo(this.oqg);
        }
    }

    public void stopVideo() {
        this.oqg = this.oqb.getCurrentPosition();
        if (this.oqb != null) {
            this.oqb.stopPlayback();
            this.oqb.setVideoURI(null);
        }
        this.kjh.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        stopVideo();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            eae();
            VM(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void eae() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bd = d.bd(oqa, opZ);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bd);
        this.kjh.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fEc.a(imageFileInfo, false);
        if (a2 != null) {
            dE(a2.getWidth(), a2.getHeight());
            this.kjh.invalidate();
            return;
        }
        this.fEc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.kjh != null && aVar != null) {
                    PreviewVideoView.this.dE(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.kjh.invalidate();
                }
            }
        }, false);
    }

    public void eaf() {
        if (this.kjh != null && this.kjh.getTag() != null) {
            c.bCS().deletePic(this.kjh.getTag().toString());
            c.bCS().deletePhoto(this.kjh.getTag().toString());
        }
    }

    public void bur() {
        this.oqc.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.oqe.setColor(ap.getColor(R.color.CAM_X0618));
        this.oqf.setColor(ap.getColor(R.color.CAM_X0302));
    }

    public void bj(float f) {
        this.hla = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ocO.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.ocO.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.ocO);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.oqe);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.hla, l.getDimens(getContext(), R.dimen.tbds5), this.oqf);
        canvas.restore();
    }
}
