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
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private Rect GQ;
    private Rect GR;
    private MediaData[] Yg;
    private boolean Yh;
    private m coM;
    private int coN;
    private int coO;
    private boolean coP;
    private com.baidu.adp.lib.e.b<TbImageView> coQ;
    com.baidu.adp.base.j<?> coR;
    private String coS;
    private int coT;
    private int coU;
    private Paint coV;
    private Bitmap coW;
    private String coX;
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
        this.coP = z;
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
        this.Yh = false;
        this.mItemSize = 0;
        this.mPadding = 3;
        this.coN = 105;
        this.mNormalShowCount = 3;
        this.coP = false;
        this.coQ = null;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.n.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.n.dip2px(this.mContext, this.coN);
        setOnHierarchyChangeListener(new j(this));
        this.w = com.baidu.adp.lib.util.n.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.n.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.coS = String.valueOf(resources.getString(com.baidu.tieba.t.frs_item_common_image_canvas_text1)) + this.coO + resources.getString(com.baidu.tieba.t.frs_item_common_image_canvas_text2);
        this.coT = ((this.coS.length() + 2) * com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f)) / 2;
        this.coU = com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
        this.coV = new Paint(257);
        this.coV.setColor(-1);
        this.coV.setTextSize(resources.getDimension(com.baidu.tieba.o.ds20));
        this.coW = com.baidu.tbadk.core.util.c.bR(com.baidu.tieba.p.bg_look_photo_1);
        if (this.coW != null) {
            this.GQ = new Rect(0, 0, this.coW.getWidth(), this.coW.getHeight());
            this.GR = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(m mVar) {
        this.coM = mVar;
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
        this.Yg = mediaDataArr;
        this.coO = i;
        this.coR = jVar;
        Resources resources = getResources();
        this.coS = String.valueOf(resources.getString(com.baidu.tieba.t.frs_item_common_image_canvas_text1)) + this.coO + resources.getString(com.baidu.tieba.t.frs_item_common_image_canvas_text2);
        if (this.coQ == null && (jVar.getOrignalPage() instanceof n)) {
            this.coQ = ((n) jVar.getOrignalPage()).JW();
        }
        if (this.Yg == null || this.Yg.length <= 0) {
            requestLayout();
            return;
        }
        this.mChildCount = this.Yg.length;
        if (this.mChildCount > this.mNormalShowCount) {
            this.mChildCount = this.mNormalShowCount;
        }
        Drawable drawable = com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.n.pb_default_image_bg);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mChildCount) {
                TbImageView hj = this.coQ.hj();
                hj.setSupportNoImage(true);
                hj.setScaleType(ImageView.ScaleType.CENTER_CROP);
                hj.setDefaultBg(drawable);
                addView(hj);
                a(hj, this.Yg[i3], i3);
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
            this.mItemSize = this.coN;
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
            tbImageView.setDefaultResource(com.baidu.tieba.p.img_default_100);
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(com.baidu.tieba.p.pic_video);
            }
            tbImageView.c(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Yg != null && this.Yg.length > 0) {
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
                if (this.coO > 3 && this.coP) {
                    g(canvas);
                }
            }
        }
    }

    private void g(Canvas canvas) {
        if (this.coW == null || this.coW.isRecycled()) {
            this.coW = com.baidu.tbadk.core.util.c.bR(com.baidu.tieba.p.bg_look_photo_1);
            if (this.coW != null) {
                this.GQ = new Rect(0, 0, this.coW.getWidth(), this.coW.getHeight());
                this.GR = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.coW != null && !this.coW.isRecycled()) {
            this.GQ.set(0, 0, this.coW.getWidth(), this.coW.getHeight());
            this.GR.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.coW, this.GQ, this.GR, this.paint);
        }
        canvas.drawText(this.coS, (getWidth() - this.w) + ((this.w - this.coT) / 2), getHeight() + ((this.coU - this.h) / 2), this.coV);
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
        this.Yh = z;
        if (this.Yh) {
            this.coX = "_small";
        } else {
            this.coX = "_mobile";
        }
    }

    public static com.baidu.adp.lib.e.b<TbImageView> l(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new k(context), i, 0);
    }
}
