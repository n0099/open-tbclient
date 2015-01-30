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
    private MediaData[] Mn;
    private boolean Mo;
    private m bUc;
    private int bUd;
    private int bUe;
    private boolean bUf;
    private com.baidu.adp.lib.e.b<TbImageView> bUg;
    com.baidu.adp.base.j<?> bUh;
    private String bUi;
    private int bUj;
    private int bUk;
    private Paint bUl;
    private Bitmap bUm;
    private String bUn;
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
    private Rect wc;
    private Rect wd;

    public void setDrawNum(boolean z) {
        this.bUf = z;
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
        this.Mo = false;
        this.mItemSize = 0;
        this.mPadding = 3;
        this.bUd = 105;
        this.mNormalShowCount = 3;
        this.bUf = false;
        this.bUg = null;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.bUd);
        setOnHierarchyChangeListener(new j(this));
        this.w = com.baidu.adp.lib.util.l.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.l.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.bUi = String.valueOf(resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text1)) + this.bUe + resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text2);
        this.bUj = ((this.bUi.length() + 2) * com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f)) / 2;
        this.bUk = com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
        this.bUl = new Paint(257);
        this.bUl.setColor(-1);
        this.bUl.setTextSize(resources.getDimension(com.baidu.tieba.u.ds20));
        this.bUm = com.baidu.tbadk.core.util.d.bN(com.baidu.tieba.v.bg_look_photo_1);
        if (this.bUm != null) {
            this.wc = new Rect(0, 0, this.bUm.getWidth(), this.bUm.getHeight());
            this.wd = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(m mVar) {
        this.bUc = mVar;
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
        this.Mn = mediaDataArr;
        this.bUe = i;
        this.bUh = jVar;
        Resources resources = getResources();
        this.bUi = String.valueOf(resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text1)) + this.bUe + resources.getString(com.baidu.tieba.z.frs_item_common_image_canvas_text2);
        if (this.bUg == null && (jVar.getOrignalPage() instanceof n)) {
            this.bUg = ((n) jVar.getOrignalPage()).Fw();
        }
        if (this.Mn == null || this.Mn.length <= 0) {
            requestLayout();
            invalidate();
            return;
        }
        this.mChildCount = this.Mn.length;
        if (this.mChildCount > this.mNormalShowCount) {
            this.mChildCount = this.mNormalShowCount;
        }
        Drawable drawable = bc.getDrawable(com.baidu.tieba.t.pb_default_image_bg);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mChildCount) {
                TbImageView ea = this.bUg.ea();
                ea.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ea.setDefaultBg(drawable);
                addView(ea);
                a(ea, this.Mn[i3], i3);
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
            this.mItemSize = this.bUd;
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
        if (this.Mn != null && this.Mn.length > 0) {
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
                if (this.bUe > 3 && this.bUf) {
                    f(canvas);
                }
            }
        }
    }

    private void f(Canvas canvas) {
        if (this.bUm == null || this.bUm.isRecycled()) {
            this.bUm = com.baidu.tbadk.core.util.d.bN(com.baidu.tieba.v.bg_look_photo_1);
            if (this.bUm != null) {
                this.wc = new Rect(0, 0, this.bUm.getWidth(), this.bUm.getHeight());
                this.wd = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.bUm != null && !this.bUm.isRecycled()) {
            this.wc.set(0, 0, this.bUm.getWidth(), this.bUm.getHeight());
            this.wd.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.bUm, this.wc, this.wd, this.paint);
        }
        canvas.drawText(this.bUi, (getWidth() - this.w) + ((this.w - this.bUj) / 2), getHeight() + ((this.bUk - this.h) / 2), this.bUl);
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
        this.Mo = z;
        if (this.Mo) {
            this.bUn = "_small";
        } else {
            this.bUn = "_mobile";
        }
    }

    public static com.baidu.adp.lib.e.b<TbImageView> k(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new k(context), i, 0);
    }
}
