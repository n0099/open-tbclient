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
    private static int mXR;
    private static int mXS;
    private String coverPath;
    private b eLL;
    private TbImageView iLZ;
    private Path mJJ;
    private CustomVideoView mXT;
    protected ImageView mXU;
    private TBSpecificationBtn mXV;
    private float mXW;
    private Paint mXX;
    private Paint mXY;
    private int myZ;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.mJJ = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mJJ = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mJJ = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        mXR = l.getDimens(getContext(), R.dimen.tbds728);
        mXS = l.getDimens(getContext(), R.dimen.tbds658);
        dK(context);
        this.eLL = new b();
        this.iLZ = new TbImageView(context);
        addView(this.iLZ, new FrameLayout.LayoutParams(-2, -2));
        this.mXU = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.mXU.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.mXU, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.blo();
        this.mXV = new TBSpecificationBtn(context);
        this.mXV.setConfig(bVar);
        this.mXV.setText(context.getString(R.string.edit));
        this.mXV.setTextSize(R.dimen.tbds26);
        addView(this.mXV, layoutParams2);
        this.mXX = new Paint();
        this.mXY = new Paint();
        changeSkin();
    }

    private void dK(Context context) {
        this.mXT = new CustomVideoView(context);
        addView(this.mXT, new FrameLayout.LayoutParams(-2, -2));
        this.mXT.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.mXT.start();
            }
        });
        this.mXT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dx(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.iLZ.setVisibility(8);
            }
        });
    }

    public void dx(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > mXS / mXR) {
            i3 = mXS;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = mXR;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.mXT.getWidth() != i3 || this.mXT.getHeight() != i4) {
            this.mXT.setVideoHeight(i4);
            this.mXT.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.iLZ.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.iLZ.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mXU.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.myZ = 0;
        this.mXW = 0.0f;
        this.coverPath = null;
        coJ();
    }

    public void Ta(String str) {
        if (!StringUtils.isNull(str)) {
            this.mXT.setVideoPath(str);
            this.mXT.start();
            this.mXT.seekTo(this.myZ);
        }
    }

    public void coJ() {
        this.myZ = this.mXT.getCurrentPosition();
        if (this.mXT != null) {
            this.mXT.stopPlayback();
            this.mXT.setVideoURI(null);
        }
        this.iLZ.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        coJ();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dJt();
            Ta(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dJt() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(mXS, mXR);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.iLZ.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a = this.eLL.a(imageFileInfo, false);
        if (a != null) {
            dx(a.getWidth(), a.getHeight());
            this.iLZ.invalidate();
            return;
        }
        this.eLL.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.iLZ != null && aVar != null) {
                    PreviewVideoView.this.dx(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.iLZ.invalidate();
                }
            }
        }, false);
    }

    public void dJu() {
        if (this.iLZ != null && this.iLZ.getTag() != null) {
            c.bsW().deletePic(this.iLZ.getTag().toString());
            c.bsW().deletePhoto(this.iLZ.getTag().toString());
        }
    }

    public void changeSkin() {
        ap.setImageResource(this.mXU, R.drawable.ic_post_image_delete_n);
        this.mXX.setColor(ap.getColor(R.color.cp_mask_c_alpha50));
        this.mXY.setColor(ap.getColor(R.color.cp_link_tip_a));
    }

    public void aI(float f) {
        this.mXW = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mJJ.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.mJJ.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mJJ);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.mXX);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.mXW, l.getDimens(getContext(), R.dimen.tbds5), this.mXY);
        canvas.restore();
    }
}
