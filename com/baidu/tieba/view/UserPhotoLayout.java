package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserPhotoLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private ae a;
    private Context b;
    private ArrayList<MetaData> c;
    private com.baidu.tbadk.core.util.b d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public int getNormalShowCount() {
        return this.i;
    }

    public void setNormalShowCount(int i) {
        this.i = i;
    }

    public int getItemSize() {
        return this.e;
    }

    public void setItemSize(int i) {
        this.e = i;
    }

    public UserPhotoLayout(Context context) {
        this(context, null);
    }

    public UserPhotoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.g = 5;
        this.h = 30;
        this.i = 6;
        this.b = context;
        this.g = com.baidu.adp.lib.util.i.a(this.b, this.g);
        this.e = com.baidu.adp.lib.util.i.a(this.b, this.h);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new ad(this, getChildCount() - 1, (byte) 0));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new ad(this, getChildCount() - 1, (byte) 0));
    }

    public final void a(ArrayList<MetaData> arrayList, boolean z) {
        a();
        this.c = arrayList;
        if (this.c == null) {
            requestLayout();
            invalidate();
            return;
        }
        this.f = this.c.size();
        if (this.f > this.i) {
            this.f = this.i;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f) {
                HeadImageView headImageView = new HeadImageView(this.b);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                MetaData metaData = this.c.get(i2);
                if (headImageView != null) {
                    String portrait = metaData.getPortrait();
                    com.baidu.tbadk.core.util.b bVar = this.d;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        headImageView.setTag(null);
                        b.a(headImageView);
                    } else if (z) {
                        this.d.c(portrait, new ac(this, headImageView, portrait));
                    } else {
                        headImageView.setTag(portrait);
                        headImageView.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
                    }
                }
                addView(headImageView);
                i = i2 + 1;
            } else {
                requestLayout();
                invalidate();
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f != 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.f) {
                    measureChild((HeadImageView) getChildAt(i4), this.e, this.e);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f != 0) {
            for (int i5 = 0; i5 < this.f; i5++) {
                ((HeadImageView) getChildAt(i5)).layout((this.g * i5) + (this.e * i5), 0, (this.g * i5) + (this.e * (i5 + 1)), i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.c != null && this.c.size() > 0) {
            this.f = getChildCount();
            if (this.f != 0) {
                long drawingTime = getDrawingTime();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.f) {
                        drawChild(canvas, (HeadImageView) getChildAt(i2), drawingTime);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setImageLoad(com.baidu.tbadk.core.util.b bVar) {
        this.d = bVar;
    }

    public void setOnChildClickListener(ae aeVar) {
        this.a = aeVar;
    }

    public final void a() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null && (view instanceof UserPhotoLayout)) {
            a();
        }
    }
}
