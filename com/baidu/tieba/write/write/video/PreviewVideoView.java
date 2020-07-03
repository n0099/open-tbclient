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
    private static int mwI;
    private static int mwJ;
    private String coverPath;
    private b euT;
    private TbImageView iri;
    private int lZT;
    private Path mju;
    private CustomVideoView mwK;
    protected ImageView mwL;
    private TBSpecificationBtn mwM;
    private float mwN;
    private Paint mwO;
    private Paint mwP;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.mju = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mju = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mju = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        mwI = l.getDimens(getContext(), R.dimen.tbds728);
        mwJ = l.getDimens(getContext(), R.dimen.tbds658);
        dA(context);
        this.euT = new b();
        this.iri = new TbImageView(context);
        addView(this.iri, new FrameLayout.LayoutParams(-2, -2));
        this.mwL = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.mwL.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.mwL, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        c cVar = new c();
        cVar.aYU();
        this.mwM = new TBSpecificationBtn(context);
        this.mwM.setConfig(cVar);
        this.mwM.setText(context.getString(R.string.edit));
        this.mwM.setTextSize(R.dimen.tbds26);
        addView(this.mwM, layoutParams2);
        this.mwO = new Paint();
        this.mwP = new Paint();
        aYi();
    }

    private void dA(Context context) {
        this.mwK = new CustomVideoView(context);
        addView(this.mwK, new FrameLayout.LayoutParams(-2, -2));
        this.mwK.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.mwK.start();
            }
        });
        this.mwK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
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
        } else if (i / i2 > mwJ / mwI) {
            i3 = mwJ;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = mwI;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.mwK.getWidth() != i3 || this.mwK.getHeight() != i4) {
            this.mwK.setVideoHeight(i4);
            this.mwK.setVideoWidth(i3);
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
        this.mwL.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.lZT = 0;
        this.mwN = 0.0f;
        this.coverPath = null;
        caG();
    }

    public void Pp(String str) {
        if (!StringUtils.isNull(str)) {
            this.mwK.setVideoPath(str);
            this.mwK.start();
            this.mwK.seekTo(this.lZT);
        }
    }

    public void caG() {
        this.lZT = this.mwK.getCurrentPosition();
        if (this.mwK != null) {
            this.mwK.stopPlayback();
            this.mwK.setVideoURI(null);
        }
        this.iri.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        caG();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dup();
            Pp(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dup() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation aW = d.aW(mwJ, mwI);
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

    public void duq() {
        if (this.iri != null && this.iri.getTag() != null) {
            com.baidu.tbadk.imageManager.c.bgz().deletePic(this.iri.getTag().toString());
            com.baidu.tbadk.imageManager.c.bgz().deletePhoto(this.iri.getTag().toString());
        }
    }

    public void aYi() {
        an.setImageResource(this.mwL, R.drawable.ic_post_image_delete_n);
        this.mwO.setColor(an.getColor(R.color.cp_mask_c_alpha50));
        this.mwP.setColor(an.getColor(R.color.cp_link_tip_a));
    }

    public void aD(float f) {
        this.mwN = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mju.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.mju.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mju);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.mwO);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.mwN, l.getDimens(getContext(), R.dimen.tbds5), this.mwP);
        canvas.restore();
    }
}
