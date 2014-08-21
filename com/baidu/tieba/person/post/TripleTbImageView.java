package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    public static final float[] a = {0.5f, 0.33f, 0.25f};
    private static int g;
    public TbImageView b;
    public TbImageView c;
    public TbImageView d;
    public Object[] e;
    public final int f;
    private int h;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new TbImageView(context);
        this.c = new TbImageView(context);
        this.d = new TbImageView(context);
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.b);
        addView(this.c);
        addView(this.d);
        this.f = com.baidu.adp.lib.util.j.a(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.e = objArr;
        if (objArr == null) {
            this.b.setTag(null);
            this.c.setTag(null);
            this.d.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.b.setTag(null);
            this.c.setTag(null);
            this.d.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        switch (length) {
            case 1:
                this.h = 480;
                break;
            case 2:
                this.h = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
                break;
            case 3:
                this.h = Constants.MEDIA_INFO;
                break;
        }
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.b);
            this.c.setTag(null);
            this.d.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.b);
            a((PersonPostModel.Media) objArr[1], this.c);
            this.d.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.b);
            a((PersonPostModel.Media) objArr[1], this.c);
            a((PersonPostModel.Media) objArr[2], this.d);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(com.baidu.tieba.t.img_default_100);
                tbImageView.setNightDefaultResource(com.baidu.tieba.t.img_default_100_1);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(com.baidu.tieba.t.pic_video);
                tbImageView.setNightDefaultResource(com.baidu.tieba.t.pic_video_1);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.h, this.h, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (g == 0) {
            g = i3;
        }
        if (this.e == null || this.e.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * a[this.e.length - 1]) + 0.5f));
        switch (this.e.length) {
            case 1:
                measureChild(this.b, i3 + 1073741824, ((int) ((i3 * a[0]) + 0.5f)) + 1073741824);
                measureChild(this.c, 0, 0);
                measureChild(this.d, 0, 0);
                return;
            case 2:
                int i4 = ((i3 - (this.f * 3)) >> 1) + 1073741824;
                int i5 = ((int) ((i4 * a[1]) + 0.5f)) + 1073741824;
                measureChild(this.b, i4, i5);
                measureChild(this.c, i4, i5);
                measureChild(this.d, 0, 0);
                break;
            case 3:
                break;
            default:
                return;
        }
        int i6 = ((i3 - (this.f * 4)) / 3) + 1073741824;
        int i7 = ((int) ((i6 * a[2]) + 0.5f)) + 1073741824;
        measureChild(this.b, i6, i7);
        measureChild(this.c, i6, i7);
        measureChild(this.d, i6, i7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.e != null && this.e.length != 0) {
            switch (this.e.length) {
                case 1:
                    this.b.layout(0, 0, i3 - this.f, min);
                    this.c.layout(0, 0, 0, 0);
                    this.d.layout(0, 0, 0, 0);
                    return;
                case 2:
                    int measuredWidth = (getMeasuredWidth() - (this.f * 3)) >> 1;
                    this.b.layout(this.f, 0, this.f + measuredWidth, min);
                    this.c.layout((this.f * 2) + measuredWidth, 0, (measuredWidth * 2) + (this.f * 2), min);
                    this.d.layout(0, 0, 0, 0);
                    return;
                case 3:
                    int measuredWidth2 = (getMeasuredWidth() - (this.f * 4)) / 3;
                    this.b.layout(this.f, 0, this.f + measuredWidth2, min);
                    this.c.layout((this.f * 2) + measuredWidth2, 0, (measuredWidth2 * 2) + (this.f * 2), min);
                    this.d.layout((measuredWidth2 * 2) + (this.f * 3), 0, (measuredWidth2 * 3) + (this.f * 3), min);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.e != null && this.e.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.e.length) {
                case 1:
                    drawChild(canvas, this.b, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.b, drawingTime);
                    drawChild(canvas, this.c, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.b, drawingTime);
                    drawChild(canvas, this.c, drawingTime);
                    drawChild(canvas, this.d, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
