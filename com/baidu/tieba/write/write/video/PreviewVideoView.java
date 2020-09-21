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
    private static int nii;
    private static int nij;
    private String coverPath;
    private b eOh;
    private TbImageView iUL;
    private int mJh;
    private Path mTR;
    private CustomVideoView nik;
    protected ImageView nil;
    private TBSpecificationBtn nim;
    private float nin;
    private Paint nio;
    private Paint nip;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.mTR = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTR = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTR = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        nii = l.getDimens(getContext(), R.dimen.tbds728);
        nij = l.getDimens(getContext(), R.dimen.tbds658);
        dJ(context);
        this.eOh = new b();
        this.iUL = new TbImageView(context);
        addView(this.iUL, new FrameLayout.LayoutParams(-2, -2));
        this.nil = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.nil.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.nil, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bmj();
        this.nim = new TBSpecificationBtn(context);
        this.nim.setConfig(bVar);
        this.nim.setText(context.getString(R.string.edit));
        this.nim.setTextSize(R.dimen.tbds26);
        addView(this.nim, layoutParams2);
        this.nio = new Paint();
        this.nip = new Paint();
        changeSkin();
    }

    private void dJ(Context context) {
        this.nik = new CustomVideoView(context);
        addView(this.nik, new FrameLayout.LayoutParams(-2, -2));
        this.nik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.nik.start();
            }
        });
        this.nik.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.iUL.setVisibility(8);
            }
        });
    }

    public void dB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > nij / nii) {
            i3 = nij;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = nii;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.nik.getWidth() != i3 || this.nik.getHeight() != i4) {
            this.nik.setVideoHeight(i4);
            this.nik.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.iUL.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.iUL.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.nil.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.mJh = 0;
        this.nin = 0.0f;
        this.coverPath = null;
        crX();
    }

    public void Tz(String str) {
        if (!StringUtils.isNull(str)) {
            this.nik.setVideoPath(str);
            this.nik.start();
            this.nik.seekTo(this.mJh);
        }
    }

    public void crX() {
        this.mJh = this.nik.getCurrentPosition();
        if (this.nik != null) {
            this.nik.stopPlayback();
            this.nik.setVideoURI(null);
        }
        this.iUL.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        crX();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dNA();
            Tz(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dNA() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(nij, nii);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.iUL.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a = this.eOh.a(imageFileInfo, false);
        if (a != null) {
            dB(a.getWidth(), a.getHeight());
            this.iUL.invalidate();
            return;
        }
        this.eOh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.iUL != null && aVar != null) {
                    PreviewVideoView.this.dB(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.iUL.invalidate();
                }
            }
        }, false);
    }

    public void dNB() {
        if (this.iUL != null && this.iUL.getTag() != null) {
            c.bub().deletePic(this.iUL.getTag().toString());
            c.bub().deletePhoto(this.iUL.getTag().toString());
        }
    }

    public void changeSkin() {
        ap.setImageResource(this.nil, R.drawable.ic_post_image_delete_n);
        this.nio.setColor(ap.getColor(R.color.cp_mask_c_alpha50));
        this.nip.setColor(ap.getColor(R.color.cp_link_tip_a));
    }

    public void aI(float f) {
        this.nin = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mTR.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.mTR.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mTR);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.nio);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.nin, l.getDimens(getContext(), R.dimen.tbds5), this.nip);
        canvas.restore();
    }
}
