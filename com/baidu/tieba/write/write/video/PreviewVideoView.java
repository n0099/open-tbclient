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
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes2.dex */
public class PreviewVideoView extends FrameLayout {
    private static int mwL;
    private static int mwM;
    private String coverPath;
    private b euT;
    private TbImageView iri;
    private int lZW;
    private Path mjx;
    private CustomVideoView mwN;
    protected ImageView mwO;
    private TBSpecificationBtn mwP;
    private float mwQ;
    private Paint mwR;
    private Paint mwS;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.mjx = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjx = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjx = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        mwL = l.getDimens(getContext(), R.dimen.tbds728);
        mwM = l.getDimens(getContext(), R.dimen.tbds658);
        dA(context);
        this.euT = new b();
        this.iri = new TbImageView(context);
        addView(this.iri, new FrameLayout.LayoutParams(-2, -2));
        this.mwO = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.mwO.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.mwO, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        c cVar = new c();
        cVar.aYU();
        this.mwP = new TBSpecificationBtn(context);
        this.mwP.setConfig(cVar);
        this.mwP.setText(context.getString(R.string.edit));
        this.mwP.setTextSize(R.dimen.tbds26);
        addView(this.mwP, layoutParams2);
        this.mwR = new Paint();
        this.mwS = new Paint();
        aYi();
    }

    private void dA(Context context) {
        this.mwN = new CustomVideoView(context);
        addView(this.mwN, new FrameLayout.LayoutParams(-2, -2));
        this.mwN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.mwN.start();
            }
        });
        this.mwN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dn(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.iri.setVisibility(8);
            }
        });
    }

    public void dn(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > mwM / mwL) {
            i3 = mwM;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = mwL;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.mwN.getWidth() != i3 || this.mwN.getHeight() != i4) {
            this.mwN.setVideoHeight(i4);
            this.mwN.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.iri.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.iri.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mwO.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.lZW = 0;
        this.mwQ = 0.0f;
        this.coverPath = null;
        caH();
    }

    public void Pq(String str) {
        if (!StringUtils.isNull(str)) {
            this.mwN.setVideoPath(str);
            this.mwN.start();
            this.mwN.seekTo(this.lZW);
        }
    }

    public void caH() {
        this.lZW = this.mwN.getCurrentPosition();
        if (this.mwN != null) {
            this.mwN.stopPlayback();
            this.mwN.setVideoURI(null);
        }
        this.iri.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        caH();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dut();
            Pq(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dut() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation aW = d.aW(mwM, mwL);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(aW);
        this.iri.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a = this.euT.a(imageFileInfo, false);
        if (a != null) {
            dn(a.getWidth(), a.getHeight());
            this.iri.invalidate();
            return;
        }
        this.euT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.iri != null && aVar != null) {
                    PreviewVideoView.this.dn(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.iri.invalidate();
                }
            }
        }, false);
    }

    public void duu() {
        if (this.iri != null && this.iri.getTag() != null) {
            com.baidu.tbadk.imageManager.c.bgz().deletePic(this.iri.getTag().toString());
            com.baidu.tbadk.imageManager.c.bgz().deletePhoto(this.iri.getTag().toString());
        }
    }

    public void aYi() {
        an.setImageResource(this.mwO, R.drawable.ic_post_image_delete_n);
        this.mwR.setColor(an.getColor(R.color.cp_mask_c_alpha50));
        this.mwS.setColor(an.getColor(R.color.cp_link_tip_a));
    }

    public void aD(float f) {
        this.mwQ = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mjx.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.mjx.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mjx);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.mwR);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.mwQ, l.getDimens(getContext(), R.dimen.tbds5), this.mwS);
        canvas.restore();
    }
}
