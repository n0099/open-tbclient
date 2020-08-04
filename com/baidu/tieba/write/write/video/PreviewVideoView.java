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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
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
    private static int mER;
    private static int mES;
    private String coverPath;
    private b eBm;
    private TbImageView ixo;
    private CustomVideoView mET;
    protected ImageView mEU;
    private TBSpecificationBtn mEV;
    private float mEW;
    private Paint mEX;
    private Paint mEY;
    private int mhp;
    private Path mrx;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.mrx = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mrx = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mrx = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        mER = l.getDimens(getContext(), R.dimen.tbds728);
        mES = l.getDimens(getContext(), R.dimen.tbds658);
        dE(context);
        this.eBm = new b();
        this.ixo = new TbImageView(context);
        addView(this.ixo, new FrameLayout.LayoutParams(-2, -2));
        this.mEU = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.mEU.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.mEU, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        c cVar = new c();
        cVar.bcR();
        this.mEV = new TBSpecificationBtn(context);
        this.mEV.setConfig(cVar);
        this.mEV.setText(context.getString(R.string.edit));
        this.mEV.setTextSize(R.dimen.tbds26);
        addView(this.mEV, layoutParams2);
        this.mEX = new Paint();
        this.mEY = new Paint();
        changeSkin();
    }

    private void dE(Context context) {
        this.mET = new CustomVideoView(context);
        addView(this.mET, new FrameLayout.LayoutParams(-2, -2));
        this.mET.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.mET.start();
            }
        });
        this.mET.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dp(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.ixo.setVisibility(8);
            }
        });
    }

    public void dp(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > mES / mER) {
            i3 = mES;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = mER;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.mET.getWidth() != i3 || this.mET.getHeight() != i4) {
            this.mET.setVideoHeight(i4);
            this.mET.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.ixo.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.ixo.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mEU.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.mhp = 0;
        this.mEW = 0.0f;
        this.coverPath = null;
        cef();
    }

    public void Qb(String str) {
        if (!StringUtils.isNull(str)) {
            this.mET.setVideoPath(str);
            this.mET.start();
            this.mET.seekTo(this.mhp);
        }
    }

    public void cef() {
        this.mhp = this.mET.getCurrentPosition();
        if (this.mET != null) {
            this.mET.stopPlayback();
            this.mET.setVideoURI(null);
        }
        this.ixo.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cef();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dxG();
            Qb(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dxG() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation aX = d.aX(mES, mER);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(aX);
        this.ixo.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a = this.eBm.a(imageFileInfo, false);
        if (a != null) {
            dp(a.getWidth(), a.getHeight());
            this.ixo.invalidate();
            return;
        }
        this.eBm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.ixo != null && aVar != null) {
                    PreviewVideoView.this.dp(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.ixo.invalidate();
                }
            }
        }, false);
    }

    public void dxH() {
        if (this.ixo != null && this.ixo.getTag() != null) {
            com.baidu.tbadk.imageManager.c.bkk().deletePic(this.ixo.getTag().toString());
            com.baidu.tbadk.imageManager.c.bkk().deletePhoto(this.ixo.getTag().toString());
        }
    }

    public void changeSkin() {
        ao.setImageResource(this.mEU, R.drawable.ic_post_image_delete_n);
        this.mEX.setColor(ao.getColor(R.color.cp_mask_c_alpha50));
        this.mEY.setColor(ao.getColor(R.color.cp_link_tip_a));
    }

    public void aC(float f) {
        this.mEW = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mrx.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.mrx.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mrx);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.mEX);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.mEW, l.getDimens(getContext(), R.dimen.tbds5), this.mEY);
        canvas.restore();
    }
}
