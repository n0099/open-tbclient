package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AdConstrainImageLayout extends ConstrainImageLayout {
    private TbImageView.b gvM;

    public AdConstrainImageLayout(Context context) {
        super(context);
        this.gvM = new TbImageView.b() { // from class: com.baidu.tieba.recapp.widget.AdConstrainImageLayout.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    a he = c.IQ().he(com.baidu.adp.lib.f.c.ih().f(tbImageView.getUrl(), 17));
                    if (he != null) {
                        int width = he.getWidth();
                        i = he.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (AdConstrainImageLayout.this.bcJ && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
    }

    public AdConstrainImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvM = new TbImageView.b() { // from class: com.baidu.tieba.recapp.widget.AdConstrainImageLayout.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    a he = c.IQ().he(com.baidu.adp.lib.f.c.ih().f(tbImageView.getUrl(), 17));
                    if (he != null) {
                        int width = he.getWidth();
                        i = he.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (AdConstrainImageLayout.this.bcJ && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
    }

    public AdConstrainImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvM = new TbImageView.b() { // from class: com.baidu.tieba.recapp.widget.AdConstrainImageLayout.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                int i22;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    a he = c.IQ().he(com.baidu.adp.lib.f.c.ih().f(tbImageView.getUrl(), 17));
                    if (he != null) {
                        int width = he.getWidth();
                        i2 = he.getHeight();
                        i22 = width;
                    } else {
                        i2 = 0;
                        i22 = 0;
                    }
                    if (i22 != 0 && i2 != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i22 * height > width2 * i2) {
                                f4 = height / i2;
                            } else {
                                f4 = width2 / i22;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i22 * height > width2 * i2) {
                                float f5 = height / i2;
                                f2 = f5;
                                f3 = (width2 - (i22 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i22;
                                f = (height - (i2 * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (AdConstrainImageLayout.this.bcJ && i2 > i22) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout
    public void setUrls(List<MediaData> list, int i, boolean z) {
        int y;
        super.setUrls(list, i, z);
        if (this.bcA != null && (y = w.y(list)) > 0) {
            sy(y);
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                MediaData mediaData = list.get(i2);
                if ((childAt instanceof TbImageView) && mediaData != null) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i2 == childCount + (-1);
                    tbImageView.setForegroundColor(0);
                    tbImageView.setIsLongPic(mediaData.isLongPic());
                    if (z2 && z) {
                        tbImageView.setLongIconSupport(false);
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setLongIconSupport(true);
                        tbImageView.setGifIconSupport(true);
                    }
                    String thumbnails_url = mediaData.getThumbnails_url();
                    if (TextUtils.isEmpty(thumbnails_url)) {
                        thumbnails_url = mediaData.getSmallUrl();
                    }
                    if (TextUtils.isEmpty(thumbnails_url)) {
                        thumbnails_url = mediaData.getPicUrl();
                    }
                    if (TextUtils.isEmpty(thumbnails_url)) {
                        thumbnails_url = mediaData.getSrc_pic();
                    }
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setForegroundColor(0);
                    tbImageView.setOnDrawListener(this.gvM);
                    tbImageView.startLoad(thumbnails_url, 17, false);
                }
                i2++;
            }
        }
    }

    private void sy(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView m9if = this.bcA.m9if();
                m9if.setContentDescription(getResources().getString(d.j.editor_image));
                m9if.setScaleType(ImageView.ScaleType.CENTER_CROP);
                m9if.setDefaultBg(am.getDrawable(d.C0140d.common_color_10220));
                m9if.setPageId(this.aRF);
                addView(m9if);
            }
        }
    }
}
