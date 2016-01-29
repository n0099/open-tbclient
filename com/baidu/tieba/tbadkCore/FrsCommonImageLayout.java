package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private Rect HM;
    private Rect HN;
    private Bitmap bmp;
    private int brv;
    private MediaData[] dTl;
    private boolean dTm;
    private b dUq;
    private int dUr;
    private boolean dUs;
    private com.baidu.adp.lib.f.b<TbImageView> dUt;
    private View.OnClickListener dUu;
    com.baidu.adp.base.h<?> dUv;
    private int dUw;
    private int dUx;
    private Paint dUy;
    private String dUz;
    private int h;
    private int mChildCount;
    private final Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean mIsFromCDN;
    private int mItemSize;
    private int mNormalShowCount;
    private int mPadding;
    private int mSkinType;
    private String mThreadId;
    private Paint paint;
    private String str;
    private int w;

    /* loaded from: classes.dex */
    public interface b {
        void dl(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        com.baidu.adp.lib.f.b<TbImageView> OC();
    }

    public void setDrawNum(boolean z) {
        this.dUs = z;
    }

    public int getNormalShowCount() {
        return this.mNormalShowCount;
    }

    public void setNormalShowCount(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.mNormalShowCount = i;
    }

    public int getItemSize() {
        return this.mItemSize;
    }

    public void setItemSize(int i) {
        this.mItemSize = com.baidu.adp.lib.util.k.dip2px(this.mContext, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.dTm = false;
        this.mItemSize = 0;
        this.mPadding = 2;
        this.brv = 0;
        this.mNormalShowCount = 3;
        this.dUs = false;
        this.dUt = null;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.k.dip2px(this.mContext, this.brv);
        setOnHierarchyChangeListener(new e(this));
        this.w = com.baidu.adp.lib.util.k.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.k.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.str = String.valueOf(resources.getString(t.j.frs_item_common_image_canvas_text1)) + this.dUr + resources.getString(t.j.frs_item_common_image_canvas_text2);
        this.dUw = ((this.str.length() + 2) * com.baidu.adp.lib.util.k.dip2px(this.mContext, 10.0f)) / 2;
        this.dUx = com.baidu.adp.lib.util.k.dip2px(this.mContext, 10.0f);
        this.dUy = new Paint((int) SapiErrorCode.PHONE_NULL);
        this.dUy.setColor(-1);
        this.dUy.setTextSize(resources.getDimension(t.e.ds20));
        this.bmp = BitmapHelper.getCashBitmap(t.f.bg_look_photo_1);
        if (this.bmp != null) {
            this.HM = new Rect(0, 0, this.bmp.getWidth(), this.bmp.getHeight());
            this.HN = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(b bVar) {
        this.dUq = bVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int mIndex;

        private a(int i) {
            this.mIndex = i;
        }

        /* synthetic */ a(FrsCommonImageLayout frsCommonImageLayout, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaData[] mediaDataArr;
            Context pageActivity;
            MediaData[] mediaDataArr2;
            if (FrsCommonImageLayout.this.dUq != null) {
                FrsCommonImageLayout.this.dUq.dl(this.mIndex);
            } else if (FrsCommonImageLayout.this.dTl != null && this.mIndex < FrsCommonImageLayout.this.dTl.length) {
                if (FrsCommonImageLayout.this.dTl[this.mIndex].getType() == 5) {
                    if (FrsCommonImageLayout.this.dUv instanceof TbPageContext) {
                        be.wt().c((TbPageContext) FrsCommonImageLayout.this.dUv, new String[]{FrsCommonImageLayout.this.dTl[this.mIndex].getVideoUrl()});
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    for (MediaData mediaData : FrsCommonImageLayout.this.dTl) {
                        if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                            arrayList.add(mediaData.getSrc_pic());
                            if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.urlType = FrsCommonImageLayout.this.mIsFromCDN ? 13 : 14;
                                imageUrlData.imageUrl = mediaData.getPicUrl();
                                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                                imageUrlData.originalSize = mediaData.getOriginalSize();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(FrsCommonImageLayout.this.mThreadId, -1L);
                                imageUrlData.postId = mediaData.getPostId();
                                concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                            }
                        }
                    }
                    if (arrayList.size() <= 0) {
                        for (MediaData mediaData2 : FrsCommonImageLayout.this.dTl) {
                            if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                arrayList.add(mediaData2.getPicUrl());
                            }
                        }
                    }
                    if (FrsCommonImageLayout.this.dUv == null) {
                        pageActivity = FrsCommonImageLayout.this.mContext;
                    } else {
                        pageActivity = FrsCommonImageLayout.this.dUv.getPageActivity();
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(pageActivity).createConfig(arrayList, this.mIndex, FrsCommonImageLayout.this.mForumName, FrsCommonImageLayout.this.mForumId, FrsCommonImageLayout.this.mThreadId, FrsCommonImageLayout.this.mIsFromCDN, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
                    createConfig.getIntent().putExtra("from", "frs");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    TiebaStatic.eventStat(FrsCommonImageLayout.this.mContext, "pic_frs", "");
                }
            } else {
                return;
            }
            if (FrsCommonImageLayout.this.dUu != null) {
                FrsCommonImageLayout.this.dUu.onClick(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new a(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new a(this, getChildCount() - 1, null));
    }

    public void a(com.baidu.tbadk.core.data.ah ahVar, String str, String str2, String str3) {
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void a(com.baidu.adp.base.h<?> hVar, MediaData[] mediaDataArr, int i) {
        this.dTl = mediaDataArr;
        this.dUr = i;
        this.dUv = hVar;
        Resources resources = getResources();
        this.str = String.valueOf(resources.getString(t.j.frs_item_common_image_canvas_text1)) + this.dUr + resources.getString(t.j.frs_item_common_image_canvas_text2);
        if (this.dUt == null && (hVar.getOrignalPage() instanceof c)) {
            this.dUt = ((c) hVar.getOrignalPage()).OC();
        }
        if (this.dUt != null) {
            if (this.dTl == null || this.dTl.length <= 0) {
                requestLayout();
                return;
            }
            this.mChildCount = this.dTl.length;
            if (this.mChildCount > this.mNormalShowCount) {
                this.mChildCount = this.mNormalShowCount;
            }
            int childCount = getChildCount();
            if (this.mChildCount > childCount) {
                int i2 = this.mChildCount - childCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    TbImageView hj = this.dUt.hj();
                    if (hj != null) {
                        addView(hj);
                    }
                }
            } else if (this.mChildCount < childCount) {
                removeViews(this.mChildCount, childCount - this.mChildCount);
            }
            int childCount2 = getChildCount();
            for (int i4 = 0; i4 < childCount2 && i4 < this.dTl.length; i4++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i4);
                if (this.mSkinType != TbadkCoreApplication.m411getInst().getSkinType() && tbImageView != null) {
                    tbImageView.setDefaultBg(ar.getDrawable(t.d.pb_default_image_bg));
                }
                this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
                a(tbImageView, this.dTl[i4], i4);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        if (this.mChildCount == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = (this.mItemSize * this.mChildCount) + (this.mPadding * (this.mChildCount - 1));
        int i5 = (i3 - (this.mPadding * (this.mChildCount - 1))) / this.mNormalShowCount;
        if (this.mItemSize == 0 || i4 > i3) {
            this.mItemSize = i5;
            i4 = i3;
        }
        setMeasuredDimension(i4, this.mItemSize);
        for (int i6 = 0; i6 < this.mChildCount; i6++) {
            TbImageView tbImageView = (TbImageView) getChildAt(i6);
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
            tbImageView.setDefaultResource(t.f.img_default_100);
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(t.f.pic_video);
            }
            tbImageView.d(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.dTl != null && this.dTl.length > 0) {
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
                if (this.dUr > 3 && this.dUs) {
                    m(canvas);
                }
            }
        }
    }

    private void m(Canvas canvas) {
        if (this.bmp == null || this.bmp.isRecycled()) {
            this.bmp = BitmapHelper.getCashBitmap(t.f.bg_look_photo_1);
            if (this.bmp != null) {
                this.HM = new Rect(0, 0, this.bmp.getWidth(), this.bmp.getHeight());
                this.HN = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.bmp != null && !this.bmp.isRecycled()) {
            this.HM.set(0, 0, this.bmp.getWidth(), this.bmp.getHeight());
            this.HN.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.bmp, this.HM, this.HN, this.paint);
        }
        canvas.drawText(this.str, (getWidth() - this.w) + ((this.w - this.dUw) / 2), getHeight() + ((this.dUx - this.h) / 2), this.dUy);
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
        this.dTm = z;
        if (this.dTm) {
            this.dUz = "_small";
        } else {
            this.dUz = "_mobile";
        }
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        this.dUu = onClickListener;
    }

    public static com.baidu.adp.lib.f.b<TbImageView> l(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new f(context), i, 0);
    }
}
