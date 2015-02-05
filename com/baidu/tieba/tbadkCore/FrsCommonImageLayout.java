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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private MediaData[] Mk;
    private boolean Ml;
    private m bUb;
    private int bUc;
    private int bUd;
    private boolean bUe;
    private com.baidu.adp.lib.e.b<TbImageView> bUf;
    com.baidu.adp.base.j<?> bUg;
    private String bUh;
    private int bUi;
    private int bUj;
    private Paint bUk;
    private Bitmap bUl;
    private String bUm;
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
    private Rect vZ;
    private int w;
    private Rect wa;

    public void setDrawNum(boolean z) {
        this.bUe = z;
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
        this.mItemSize = com.baidu.adp.lib.util.l.dip2px(this.mContext, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFromCDN = false;
        this.Ml = false;
        this.mItemSize = 0;
        this.mPadding = 3;
        this.bUc = 105;
        this.mNormalShowCount = 3;
        this.bUe = false;
        this.bUf = null;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.bUc);
        setOnHierarchyChangeListener(new j(this));
        this.w = com.baidu.adp.lib.util.l.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.l.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.bUh = String.valueOf(resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text1)) + this.bUd + resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text2);
        this.bUi = ((this.bUh.length() + 2) * com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f)) / 2;
        this.bUj = com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
        this.bUk = new Paint(257);
        this.bUk.setColor(-1);
        this.bUk.setTextSize(resources.getDimension(com.baidu.tieba.u.ds20));
        this.bUl = com.baidu.tbadk.core.util.d.bN(com.baidu.tieba.v.bg_look_photo_1);
        if (this.bUl != null) {
            this.vZ = new Rect(0, 0, this.bUl.getWidth(), this.bUl.getHeight());
            this.wa = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(m mVar) {
        this.bUb = mVar;
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

    public void a(com.baidu.tbadk.core.data.x xVar, String str, String str2, String str3) {
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void a(com.baidu.adp.base.j<?> jVar, MediaData[] mediaDataArr, int i) {
        reset();
        this.Mk = mediaDataArr;
        this.bUd = i;
        this.bUg = jVar;
        Resources resources = getResources();
        this.bUh = String.valueOf(resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text1)) + this.bUd + resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text2);
        if (this.bUf == null && (jVar.getOrignalPage() instanceof n)) {
            this.bUf = ((n) jVar.getOrignalPage()).Fq();
        }
        if (this.Mk == null || this.Mk.length <= 0) {
            requestLayout();
            invalidate();
            return;
        }
        this.mChildCount = this.Mk.length;
        if (this.mChildCount > this.mNormalShowCount) {
            this.mChildCount = this.mNormalShowCount;
        }
        Drawable drawable = bc.getDrawable(com.baidu.tieba.t.pb_default_image_bg);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mChildCount) {
                TbImageView ea = this.bUf.ea();
                ea.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ea.setDefaultBg(drawable);
                addView(ea);
                a(ea, this.Mk[i3], i3);
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
        if (this.mChildCount == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = (this.mItemSize * this.mChildCount) + (this.mPadding * (this.mChildCount - 1));
        if (this.mItemSize == 0) {
            this.mItemSize = this.bUc;
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
                tbImageView.setDefaultResource(com.baidu.tieba.v.pic_video);
            }
            tbImageView.d(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Mk != null && this.Mk.length > 0) {
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
                if (this.bUd > 3 && this.bUe) {
                    f(canvas);
                }
            }
        }
    }

    private void f(Canvas canvas) {
        if (this.bUl == null || this.bUl.isRecycled()) {
            this.bUl = com.baidu.tbadk.core.util.d.bN(com.baidu.tieba.v.bg_look_photo_1);
            if (this.bUl != null) {
                this.vZ = new Rect(0, 0, this.bUl.getWidth(), this.bUl.getHeight());
                this.wa = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.bUl != null && !this.bUl.isRecycled()) {
            this.vZ.set(0, 0, this.bUl.getWidth(), this.bUl.getHeight());
            this.wa.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.bUl, this.vZ, this.wa, this.paint);
        }
        canvas.drawText(this.bUh, (getWidth() - this.w) + ((this.w - this.bUi) / 2), getHeight() + ((this.bUj - this.h) / 2), this.bUk);
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
        this.Ml = z;
        if (this.Ml) {
            this.bUm = "_small";
        } else {
            this.bUm = "_mobile";
        }
    }

    public static com.baidu.adp.lib.e.b<TbImageView> k(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new k(context), i, 0);
    }
}
