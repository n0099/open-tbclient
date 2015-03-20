package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private Rect GY;
    private Rect GZ;
    private MediaData[] Xr;
    private boolean Xs;
    com.baidu.adp.base.j<?> ckA;
    private String ckB;
    private int ckC;
    private int ckD;
    private Paint ckE;
    private Bitmap ckF;
    private String ckG;
    private m ckv;
    private int ckw;
    private int ckx;
    private boolean cky;
    private com.baidu.adp.lib.e.b<TbImageView> ckz;
    private int h;
    private int mChildCount;
    private final Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean mIsFromCDN;
    private int mItemSize;
    private int mNormalShowCount;
    private int mPadding;
    private String mThreadId;
    private Paint paint;
    private int w;

    public void setDrawNum(boolean z) {
        this.cky = z;
    }

    public int getNormalShowCount() {
        return this.mNormalShowCount;
    }

    public void setNormalShowCount(int i) {
        this.mNormalShowCount = i;
    }

    public int getItemSize() {
        return this.mItemSize;
    }

    public void setItemSize(int i) {
        this.mItemSize = com.baidu.adp.lib.util.n.dip2px(this.mContext, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFromCDN = false;
        this.Xs = false;
        this.mItemSize = 0;
        this.mPadding = 3;
        this.ckw = 105;
        this.mNormalShowCount = 3;
        this.cky = false;
        this.ckz = null;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.n.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.n.dip2px(this.mContext, this.ckw);
        setOnHierarchyChangeListener(new j(this));
        this.w = com.baidu.adp.lib.util.n.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.n.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.ckB = String.valueOf(resources.getString(com.baidu.tieba.y.frs_item_common_image_canvas_text1)) + this.ckx + resources.getString(com.baidu.tieba.y.frs_item_common_image_canvas_text2);
        this.ckC = ((this.ckB.length() + 2) * com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f)) / 2;
        this.ckD = com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
        this.ckE = new Paint(257);
        this.ckE.setColor(-1);
        this.ckE.setTextSize(resources.getDimension(com.baidu.tieba.t.ds20));
        this.ckF = com.baidu.tbadk.core.util.c.bO(com.baidu.tieba.u.bg_look_photo_1);
        if (this.ckF != null) {
            this.GY = new Rect(0, 0, this.ckF.getWidth(), this.ckF.getHeight());
            this.GZ = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(m mVar) {
        this.ckv = mVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new l(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new l(this, getChildCount() - 1, null));
    }

    public void a(com.baidu.tbadk.core.data.w wVar, String str, String str2, String str3) {
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void a(com.baidu.adp.base.j<?> jVar, MediaData[] mediaDataArr, int i) {
        reset();
        this.Xr = mediaDataArr;
        this.ckx = i;
        this.ckA = jVar;
        Resources resources = getResources();
        this.ckB = String.valueOf(resources.getString(com.baidu.tieba.y.frs_item_common_image_canvas_text1)) + this.ckx + resources.getString(com.baidu.tieba.y.frs_item_common_image_canvas_text2);
        if (this.ckz == null && (jVar.getOrignalPage() instanceof n)) {
            this.ckz = ((n) jVar.getOrignalPage()).IP();
        }
        if (this.Xr == null || this.Xr.length <= 0) {
            requestLayout();
            return;
        }
        this.mChildCount = this.Xr.length;
        if (this.mChildCount > this.mNormalShowCount) {
            this.mChildCount = this.mNormalShowCount;
        }
        Drawable drawable = ba.getDrawable(com.baidu.tieba.s.pb_default_image_bg);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mChildCount) {
                TbImageView hz = this.ckz.hz();
                hz.setSupportNoImage(true);
                hz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                hz.setDefaultBg(drawable);
                addView(hz);
                a(hz, this.Xr[i3], i3);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (this.mChildCount == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = (this.mItemSize * this.mChildCount) + (this.mPadding * (this.mChildCount - 1));
        if (this.mItemSize == 0) {
            this.mItemSize = this.ckw;
        } else if (i4 > i3) {
            this.mItemSize = (i3 - (this.mPadding * (this.mChildCount - 1))) / this.mChildCount;
        } else {
            i3 = i4;
        }
        setMeasuredDimension(i3, this.mItemSize);
        for (int i5 = 0; i5 < this.mChildCount; i5++) {
            TbImageView tbImageView = (TbImageView) getChildAt(i5);
            if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                measureChild(tbImageView, this.mItemSize, this.mItemSize);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mChildCount != 0) {
            for (int i5 = 0; i5 < this.mChildCount; i5++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i5);
                int i6 = (this.mPadding * i5) + (this.mItemSize * i5);
                int i7 = (this.mPadding * i5) + (this.mItemSize * (i5 + 1));
                if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                    tbImageView.layout(i6, 0, i7, i4 - i2);
                }
            }
        }
    }

    public int getPadding() {
        return this.mPadding;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    private void a(TbImageView tbImageView, MediaData mediaData, int i) {
        if (tbImageView != null) {
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(com.baidu.tieba.u.pic_video);
            }
            tbImageView.c(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Xr != null && this.Xr.length > 0) {
            this.mChildCount = getChildCount();
            if (this.mChildCount != 0) {
                long drawingTime = getDrawingTime();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mChildCount) {
                        break;
                    }
                    drawChild(canvas, (TbImageView) getChildAt(i2), drawingTime);
                    i = i2 + 1;
                }
                if (this.ckx > 3 && this.cky) {
                    g(canvas);
                }
            }
        }
    }

    private void g(Canvas canvas) {
        if (this.ckF == null || this.ckF.isRecycled()) {
            this.ckF = com.baidu.tbadk.core.util.c.bO(com.baidu.tieba.u.bg_look_photo_1);
            if (this.ckF != null) {
                this.GY = new Rect(0, 0, this.ckF.getWidth(), this.ckF.getHeight());
                this.GZ = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.ckF != null && !this.ckF.isRecycled()) {
            this.GY.set(0, 0, this.ckF.getWidth(), this.ckF.getHeight());
            this.GZ.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.ckF, this.GY, this.GZ, this.paint);
        }
        canvas.drawText(this.ckB, (getWidth() - this.w) + ((this.w - this.ckC) / 2), getHeight() + ((this.ckD - this.h) / 2), this.ckE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public void reset() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setImageFrom(String str) {
    }

    public void setShowBig(boolean z) {
        this.Xs = z;
        if (this.Xs) {
            this.ckG = "_small";
        } else {
            this.ckG = "_mobile";
        }
    }

    public static com.baidu.adp.lib.e.b<TbImageView> l(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new k(context), i, 0);
    }
}
