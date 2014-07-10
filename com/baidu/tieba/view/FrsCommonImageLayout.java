package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private r a;
    private boolean b;
    private MediaData[] c;
    private final Context d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private String m;
    private String n;
    private String o;
    private com.baidu.adp.lib.d.b<TbImageView> p;
    private String q;

    public void setDrawNum(boolean z) {
        this.l = z;
    }

    public int getNormalShowCount() {
        return this.j;
    }

    public void setNormalShowCount(int i) {
        this.j = i;
    }

    public int getItemSize() {
        return this.f;
    }

    public void setItemSize(int i) {
        this.f = com.baidu.adp.lib.util.j.a(this.d, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.e = false;
        this.f = 0;
        this.h = 3;
        this.i = 105;
        this.j = 3;
        this.l = false;
        this.p = null;
        this.d = context;
        this.h = com.baidu.adp.lib.util.j.a(this.d, this.h);
        this.f = com.baidu.adp.lib.util.j.a(this.d, this.i);
        if (this.d instanceof s) {
            this.p = ((s) this.d).e();
        }
        setOnHierarchyChangeListener(new o(this));
    }

    public void setOnChildClickListener(r rVar) {
        this.a = rVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new q(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new q(this, getChildCount() - 1, null));
    }

    public void a(com.baidu.tbadk.core.data.m mVar, String str, String str2, String str3) {
        this.n = str;
        this.m = str2;
        this.o = str3;
    }

    public void a(MediaData[] mediaDataArr, int i) {
        Drawable drawable;
        a();
        this.c = mediaDataArr;
        this.k = i;
        if (this.c == null || this.c.length <= 0) {
            requestLayout();
            invalidate();
            return;
        }
        this.g = this.c.length;
        if (this.g > this.j) {
            this.g = this.j;
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            drawable = getResources().getDrawable(com.baidu.tieba.s.pb_default_image_bg_1);
        } else {
            drawable = getResources().getDrawable(com.baidu.tieba.s.pb_default_image_bg);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.g) {
                TbImageView a = this.p.a();
                a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                a.setDefaultBg(drawable);
                addView(a);
                a(a, this.c[i3], i3);
                i2 = i3 + 1;
            } else {
                requestLayout();
                invalidate();
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (this.g == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = (this.f * this.g) + (this.h * (this.g - 1));
        if (this.f == 0) {
            this.f = this.i;
        } else if (i4 > i3) {
            this.f = (i3 - (this.h * (this.g - 1))) / this.g;
        } else {
            i3 = i4;
        }
        setMeasuredDimension(i3, this.f);
        for (int i5 = 0; i5 < this.g; i5++) {
            TbImageView tbImageView = (TbImageView) getChildAt(i5);
            if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                measureChild(tbImageView, this.f, this.f);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g != 0) {
            for (int i5 = 0; i5 < this.g; i5++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i5);
                int i6 = (this.h * i5) + (this.f * i5);
                int i7 = (this.h * i5) + (this.f * (i5 + 1));
                if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                    tbImageView.layout(i6, 0, i7, i4 - i2);
                }
            }
        }
    }

    public int getPadding() {
        return this.h;
    }

    public void setPadding(int i) {
        this.h = i;
    }

    private void a(TbImageView tbImageView, MediaData mediaData, int i) {
        if (tbImageView != null) {
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(com.baidu.tieba.u.pic_video);
                tbImageView.setNightDefaultResource(com.baidu.tieba.u.pic_video_1);
            } else {
                tbImageView.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d);
                tbImageView.setNightDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d_1);
            }
            tbImageView.a(picUrl, this.b ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.c != null && this.c.length > 0) {
            this.g = getChildCount();
            if (this.g != 0) {
                long drawingTime = getDrawingTime();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.g) {
                        break;
                    }
                    drawChild(canvas, (TbImageView) getChildAt(i2), drawingTime);
                    i = i2 + 1;
                }
                if (this.k > 3 && this.l) {
                    a(canvas);
                }
            }
        }
    }

    private void a(Canvas canvas) {
        String str;
        int a = com.baidu.adp.lib.util.j.a(this.d, 50.0f);
        int a2 = com.baidu.adp.lib.util.j.a(this.d, 23.0f);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.tieba.u.bg_look_photo_1);
        canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new Rect(getWidth() - a, getHeight() - a2, getWidth(), getHeight()), paint);
        int a3 = com.baidu.adp.lib.util.j.a(this.d, 10.0f);
        Paint paint2 = new Paint(257);
        paint2.setColor(-1);
        paint2.setTextSize(this.d.getResources().getDimension(com.baidu.tieba.t.ds20));
        canvas.drawText(String.valueOf(this.d.getResources().getString(com.baidu.tieba.y.frs_item_common_image_canvas_text1)) + this.k + this.d.getResources().getString(com.baidu.tieba.y.frs_item_common_image_canvas_text2), ((a - (((str.length() + 2) * com.baidu.adp.lib.util.j.a(this.d, 10.0f)) / 2)) / 2) + (getWidth() - a), ((a3 - a2) / 2) + getHeight(), paint2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void a() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    public void setFromCDN(boolean z) {
        this.b = z;
    }

    public void setImageFrom(String str) {
    }

    public void setShowBig(boolean z) {
        this.e = z;
        if (this.e) {
            this.q = "_small";
        } else {
            this.q = "_mobile";
        }
    }

    public static com.baidu.adp.lib.d.b<TbImageView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new p(context), i, 0);
    }
}
