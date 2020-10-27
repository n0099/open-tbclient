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
    private static int nKe;
    private static int nKf;
    private String coverPath;
    private b fiN;
    private float gIY;
    private TbImageView jwg;
    private CustomVideoView nKg;
    protected ImageView nKh;
    private TBSpecificationBtn nKi;
    private Paint nKj;
    private Paint nKk;
    private int nlo;
    private Path nvS;
    private RectF rect;

    public PreviewVideoView(@NonNull Context context) {
        super(context);
        this.nvS = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nvS = new Path();
        this.rect = new RectF();
        init(context);
    }

    public PreviewVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvS = new Path();
        this.rect = new RectF();
        init(context);
    }

    private void init(Context context) {
        nKe = l.getDimens(getContext(), R.dimen.tbds728);
        nKf = l.getDimens(getContext(), R.dimen.tbds658);
        dP(context);
        this.fiN = new b();
        this.jwg = new TbImageView(context);
        addView(this.jwg, new FrameLayout.LayoutParams(-2, -2));
        this.nKh = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds21);
        this.nKh.setPadding(dimens, dimens, dimens, dimens);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds94), l.getDimens(context, R.dimen.tbds94));
        layoutParams.gravity = 53;
        addView(this.nKh, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds96), l.getDimens(context, R.dimen.tbds48));
        layoutParams2.gravity = 85;
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        layoutParams2.rightMargin = dimens2;
        layoutParams2.bottomMargin = dimens2;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bqM();
        this.nKi = new TBSpecificationBtn(context);
        this.nKi.setConfig(bVar);
        this.nKi.setText(context.getString(R.string.edit));
        this.nKi.setTextSize(R.dimen.tbds26);
        addView(this.nKi, layoutParams2);
        this.nKj = new Paint();
        this.nKk = new Paint();
        changeSkin();
    }

    private void dP(Context context) {
        this.nKg = new CustomVideoView(context);
        addView(this.nKg, new FrameLayout.LayoutParams(-2, -2));
        this.nKg.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                PreviewVideoView.this.nKg.start();
            }
        });
        this.nKg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                PreviewVideoView.this.dD(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                PreviewVideoView.this.jwg.setVisibility(8);
            }
        });
    }

    public void dD(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > nKf / nKe) {
            i3 = nKf;
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            i4 = nKe;
            i3 = (int) ((i4 / i2) * i);
        }
        if (this.nKg.getWidth() != i3 || this.nKg.getHeight() != i4) {
            this.nKg.setVideoHeight(i4);
            this.nKg.setVideoWidth(i3);
            ViewGroup.LayoutParams layoutParams = this.jwg.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.jwg.setLayoutParams(layoutParams);
            getLayoutParams().height = i4;
            getLayoutParams().width = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.nKh.setOnClickListener(onClickListener);
    }

    public void reset() {
        this.nlo = 0;
        this.gIY = 0.0f;
        this.coverPath = null;
        cyB();
    }

    public void UM(String str) {
        if (!StringUtils.isNull(str)) {
            this.nKg.setVideoPath(str);
            this.nKg.start();
            this.nKg.seekTo(this.nlo);
        }
    }

    public void cyB() {
        this.nlo = this.nKg.getCurrentPosition();
        if (this.nKg != null) {
            this.nKg.stopPlayback();
            this.nKg.setVideoURI(null);
        }
        this.jwg.setVisibility(0);
    }

    public void setVideoInfo(EditVideoData editVideoData) {
        cyB();
        if (editVideoData != null && editVideoData.isLegal()) {
            setVisibility(0);
            this.coverPath = editVideoData.coverPath;
            dUu();
            UM(editVideoData.finalPath);
            return;
        }
        setVisibility(8);
    }

    public void dUu() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(this.coverPath);
        ImageOperation bg = d.bg(nKf, nKe);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(bg);
        this.jwg.setTag(imageFileInfo.toCachedKey(false));
        com.baidu.adp.widget.ImageView.a a2 = this.fiN.a(imageFileInfo, false);
        if (a2 != null) {
            dD(a2.getWidth(), a2.getHeight());
            this.jwg.invalidate();
            return;
        }
        this.fiN.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.video.PreviewVideoView.3
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                if (PreviewVideoView.this.jwg != null && aVar != null) {
                    PreviewVideoView.this.dD(aVar.getWidth(), aVar.getHeight());
                    PreviewVideoView.this.jwg.invalidate();
                }
            }
        }, false);
    }

    public void dUv() {
        if (this.jwg != null && this.jwg.getTag() != null) {
            c.byE().deletePic(this.jwg.getTag().toString());
            c.byE().deletePhoto(this.jwg.getTag().toString());
        }
    }

    public void changeSkin() {
        ap.setImageResource(this.nKh, R.drawable.ic_post_image_delete_n);
        this.nKj.setColor(ap.getColor(R.color.cp_mask_c_alpha50));
        this.nKk.setColor(ap.getColor(R.color.cp_link_tip_a));
    }

    public void aQ(float f) {
        this.gIY = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nvS.reset();
        this.rect.set(0.0f, 0.0f, i, i2);
        this.nvS.addRoundRect(this.rect, l.getDimens(getContext(), R.dimen.tbds10), l.getDimens(getContext(), R.dimen.tbds10), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.nvS);
        super.dispatchDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), l.getDimens(getContext(), R.dimen.tbds5), this.nKj);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.gIY, l.getDimens(getContext(), R.dimen.tbds5), this.nKk);
        canvas.restore();
    }
}
