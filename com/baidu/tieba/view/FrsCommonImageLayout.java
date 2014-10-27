package com.baidu.tieba.view;

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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private MediaData[] bQL;
    private boolean bQM;
    private p bRj;
    private int bRk;
    private int bRl;
    private boolean bRm;
    private com.baidu.adp.lib.e.b<TbImageView> bRn;
    private String bRo;
    private int mChildCount;
    private final Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean mIsFromCDN;
    private int mItemSize;
    private int mNormalShowCount;
    private int mPadding;
    private String mThreadId;

    public void setDrawNum(boolean z) {
        this.bRm = z;
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
        this.mItemSize = com.baidu.adp.lib.util.m.dip2px(this.mContext, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFromCDN = false;
        this.bQM = false;
        this.mItemSize = 0;
        this.mPadding = 3;
        this.bRk = 105;
        this.mNormalShowCount = 3;
        this.bRm = false;
        this.bRn = null;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.m.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.m.dip2px(this.mContext, this.bRk);
        if (this.mContext instanceof q) {
            this.bRn = ((q) this.mContext).EF();
        }
        setOnHierarchyChangeListener(new m(this));
    }

    public void setOnChildClickListener(p pVar) {
        this.bRj = pVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new o(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new o(this, getChildCount() - 1, null));
    }

    public void a(com.baidu.tbadk.core.data.q qVar, String str, String str2, String str3) {
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void a(MediaData[] mediaDataArr, int i) {
        reset();
        this.bQL = mediaDataArr;
        this.bRl = i;
        if (this.bQL == null || this.bQL.length <= 0) {
            requestLayout();
            invalidate();
            return;
        }
        this.mChildCount = this.bQL.length;
        if (this.mChildCount > this.mNormalShowCount) {
            this.mChildCount = this.mNormalShowCount;
        }
        TbadkApplication.m251getInst().getSkinType();
        Drawable drawable = aw.getDrawable(com.baidu.tieba.s.pb_default_image_bg);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mChildCount) {
                TbImageView ed = this.bRn.ed();
                ed.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ed.setDefaultBg(drawable);
                addView(ed);
                a(ed, this.bQL[i3], i3);
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
            this.mItemSize = this.bRk;
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
        if (this.bQL != null && this.bQL.length > 0) {
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
                if (this.bRl > 3 && this.bRm) {
                    f(canvas);
                }
            }
        }
    }

    private void f(Canvas canvas) {
        String str;
        int dip2px = com.baidu.adp.lib.util.m.dip2px(this.mContext, 50.0f);
        int dip2px2 = com.baidu.adp.lib.util.m.dip2px(this.mContext, 23.0f);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        Resources resources = getResources();
        Bitmap bl = com.baidu.tbadk.core.util.d.bl(com.baidu.tieba.u.bg_look_photo_1);
        if (bl != null) {
            canvas.drawBitmap(bl, new Rect(0, 0, bl.getWidth(), bl.getHeight()), new Rect(getWidth() - dip2px, getHeight() - dip2px2, getWidth(), getHeight()), paint);
        }
        int dip2px3 = com.baidu.adp.lib.util.m.dip2px(this.mContext, 10.0f);
        Paint paint2 = new Paint(257);
        paint2.setColor(-1);
        paint2.setTextSize(resources.getDimension(com.baidu.tieba.t.ds20));
        canvas.drawText(String.valueOf(resources.getString(com.baidu.tieba.y.frs_item_common_image_canvas_text1)) + this.bRl + resources.getString(com.baidu.tieba.y.frs_item_common_image_canvas_text2), ((dip2px - (((str.length() + 2) * com.baidu.adp.lib.util.m.dip2px(this.mContext, 10.0f)) / 2)) / 2) + (getWidth() - dip2px), ((dip2px3 - dip2px2) / 2) + getHeight(), paint2);
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
        this.bQM = z;
        if (this.bQM) {
            this.bRo = "_small";
        } else {
            this.bRo = "_mobile";
        }
    }

    public static com.baidu.adp.lib.e.b<TbImageView> l(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new n(context), i, 0);
    }
}
