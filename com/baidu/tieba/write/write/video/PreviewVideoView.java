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
    private static int mEP;
    private static int mEQ;
    private String coverPath;
    private b eBm;
    private TbImageView ixm;
    private CustomVideoView mER;
    protected ImageView mES;
    private TBSpecificationBtn mET;
    private float mEU;
    private Paint mEV;
    private Paint mEW;
    private int mhn;
    private Path mrv;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.mrv = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mrv = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mrv = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        mEP = l.getDimens(getContext(), R.dimen.tbds728);
        mEQ = l.getDimens(getContext(), R.dimen.tbds658);
        dE(context);
        this.eBm = new b();
        this.ixm = new TbImageView(context);
        addView(this.ixm, new FrameLayout.LayoutParams(-2, -2));
        this.mES = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.mES.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.mES, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        c cVar = new c();
        cVar.bcR();
        this.mET = new TBSpecificationBtn(context);
        this.mET.setConfig(cVar);
        this.mET.setText(context.getString(R.string.edit));
        this.mET.setTextSize(R.dimen.tbds26);
        addView(this.mET, layoutParams2);
        this.mEV = new Paint();
        this.mEW = new Paint();
        changeSkin();
    }

    private void dE(Context context) {
        this.mER = new CustomVideoView(context);
        addView(this.mER, new FrameLayout.LayoutParams(-2, -2));
        this.mER.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.mER.start();
            }
        });
        this.mER.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dp(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.ixm.setVisibility(8);
            }
        });
    }

    public void dp(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > mEQ / mEP) {
            i3 = mEQ;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = mEP;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.mER.getWidth() != i3 || this.mER.getHeight() != i4) {
            this.mER.setVideoHeight(i4);
            this.mER.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.ixm.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.ixm.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mES.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.mhn = 0;
        this.mEU = 0.0f;
        this.coverPath = null;
        cef();
    }

    public void Qb(String str) {
        if (!StringUtils.isNull(str)) {
            this.mER.setVideoPath(str);
            this.mER.start();
            this.mER.seekTo(this.mhn);
        }
    }

    public void cef() {
        this.mhn = this.mER.getCurrentPosition();
        if (this.mER != null) {
            this.mER.stopPlayback();
            this.mER.setVideoURI(null);
        }
        this.ixm.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cef();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dxF();
            Qb(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dxF() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation aX = d.aX(mEQ, mEP);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(aX);
        this.ixm.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a = this.eBm.a(imageFileInfo, false);
        if (a != null) {
            dp(a.getWidth(), a.getHeight());
            this.ixm.invalidate();
            return;
        }
        this.eBm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.ixm != null && aVar != null) {
                    PreviewVideoView.this.dp(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.ixm.invalidate();
                }
            }
        }, false);
    }

    public void dxG() {
        if (this.ixm != null && this.ixm.getTag() != null) {
            com.baidu.tbadk.imageManager.c.bkk().deletePic(this.ixm.getTag().toString());
            com.baidu.tbadk.imageManager.c.bkk().deletePhoto(this.ixm.getTag().toString());
        }
    }

    public void changeSkin() {
        ao.setImageResource(this.mES, R.drawable.ic_post_image_delete_n);
        this.mEV.setColor(ao.getColor(R.color.cp_mask_c_alpha50));
        this.mEW.setColor(ao.getColor(R.color.cp_link_tip_a));
    }

    public void aC(float f) {
        this.mEU = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mrv.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.mrv.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mrv);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.mEV);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.mEU, l.getDimens(getContext(), R.dimen.tbds5), this.mEW);
        canvas.restore();
    }
}
