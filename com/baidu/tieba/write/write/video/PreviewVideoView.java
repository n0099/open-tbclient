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
    private static int nxG;
    private static int nxH;
    private String coverPath;
    private b fao;
    private float gxk;
    private TbImageView jjJ;
    private int mYO;
    private Path njr;
    private CustomVideoView nxI;
    protected ImageView nxJ;
    private TBSpecificationBtn nxK;
    private Paint nxL;
    private Paint nxM;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.njr = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.njr = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.njr = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        nxG = l.getDimens(getContext(), R.dimen.tbds728);
        nxH = l.getDimens(getContext(), R.dimen.tbds658);
        dP(context);
        this.fao = new b();
        this.jjJ = new TbImageView(context);
        addView(this.jjJ, new FrameLayout.LayoutParams(-2, -2));
        this.nxJ = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.nxJ.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.nxJ, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.boT();
        this.nxK = new TBSpecificationBtn(context);
        this.nxK.setConfig(bVar);
        this.nxK.setText(context.getString(R.string.edit));
        this.nxK.setTextSize(R.dimen.tbds26);
        addView(this.nxK, layoutParams2);
        this.nxL = new Paint();
        this.nxM = new Paint();
        changeSkin();
    }

    private void dP(Context context) {
        this.nxI = new CustomVideoView(context);
        addView(this.nxI, new FrameLayout.LayoutParams(-2, -2));
        this.nxI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.nxI.start();
            }
        });
        this.nxI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.jjJ.setVisibility(8);
            }
        });
    }

    public void dB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > nxH / nxG) {
            i3 = nxH;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = nxG;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.nxI.getWidth() != i3 || this.nxI.getHeight() != i4) {
            this.nxI.setVideoHeight(i4);
            this.nxI.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.jjJ.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.jjJ.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.nxJ.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.mYO = 0;
        this.gxk = 0.0f;
        this.coverPath = null;
        cvu();
    }

    public void Un(String str) {
        if (!StringUtils.isNull(str)) {
            this.nxI.setVideoPath(str);
            this.nxI.start();
            this.nxI.seekTo(this.mYO);
        }
    }

    public void cvu() {
        this.mYO = this.nxI.getCurrentPosition();
        if (this.nxI != null) {
            this.nxI.stopPlayback();
            this.nxI.setVideoURI(null);
        }
        this.jjJ.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cvu();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dRm();
            Un(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dRm() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bf = d.bf(nxH, nxG);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bf);
        this.jjJ.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fao.a(imageFileInfo, false);
        if (a2 != null) {
            dB(a2.getWidth(), a2.getHeight());
            this.jjJ.invalidate();
            return;
        }
        this.fao.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.jjJ != null && aVar != null) {
                    PreviewVideoView.this.dB(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.jjJ.invalidate();
                }
            }
        }, false);
    }

    public void dRn() {
        if (this.jjJ != null && this.jjJ.getTag() != null) {
            c.bwL().deletePic(this.jjJ.getTag().toString());
            c.bwL().deletePhoto(this.jjJ.getTag().toString());
        }
    }

    public void changeSkin() {
        ap.setImageResource(this.nxJ, R.drawable.ic_post_image_delete_n);
        this.nxL.setColor(ap.getColor(R.color.cp_mask_c_alpha50));
        this.nxM.setColor(ap.getColor(R.color.cp_link_tip_a));
    }

    public void aO(float f) {
        this.gxk = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.njr.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.njr.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.njr);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.nxL);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.gxk, l.getDimens(getContext(), R.dimen.tbds5), this.nxM);
        canvas.restore();
    }
}
