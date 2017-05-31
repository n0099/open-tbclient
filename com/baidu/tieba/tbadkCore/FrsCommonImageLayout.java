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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private Rect HA;
    private Rect HB;
    private b fzf;
    private MediaData[] fzg;
    private boolean fzh;
    private int fzi;
    private int fzj;
    private boolean fzk;
    private com.baidu.adp.lib.e.b<TbImageView> fzl;
    private View.OnClickListener fzm;
    private boolean fzn;
    private boolean fzo;
    com.baidu.adp.base.g<?> fzp;
    private String fzq;
    private int fzr;
    private int fzs;
    private Paint fzt;
    private Bitmap fzu;
    private String fzv;
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
    private int w;

    /* loaded from: classes.dex */
    public interface b {
        /* renamed from: do */
        void mo14do(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        com.baidu.adp.lib.e.b<TbImageView> acv();
    }

    public void setDrawNum(boolean z) {
        this.fzk = z;
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
        this.fzh = false;
        this.mItemSize = 0;
        this.mPadding = 2;
        this.fzi = 0;
        this.mNormalShowCount = 3;
        this.fzk = false;
        this.fzl = null;
        this.fzn = true;
        this.fzo = true;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.k.dip2px(this.mContext, this.fzi);
        setOnHierarchyChangeListener(new e(this));
        this.w = com.baidu.adp.lib.util.k.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.k.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.fzq = String.valueOf(resources.getString(w.l.frs_item_common_image_canvas_text1)) + this.fzj + resources.getString(w.l.frs_item_common_image_canvas_text2);
        this.fzr = ((this.fzq.length() + 2) * com.baidu.adp.lib.util.k.dip2px(this.mContext, 10.0f)) / 2;
        this.fzs = com.baidu.adp.lib.util.k.dip2px(this.mContext, 10.0f);
        this.fzt = new Paint((int) SapiErrorCode.PHONE_NULL);
        this.fzt.setColor(-1);
        this.fzt.setTextSize(resources.getDimension(w.f.ds20));
        this.fzu = BitmapHelper.getCashBitmap(w.g.bg_look_photo_1);
        if (this.fzu != null) {
            this.HA = new Rect(0, 0, this.fzu.getWidth(), this.fzu.getHeight());
            this.HB = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(b bVar) {
        this.fzf = bVar;
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
            if (FrsCommonImageLayout.this.fzf != null) {
                FrsCommonImageLayout.this.fzf.mo14do(this.mIndex);
            } else if (FrsCommonImageLayout.this.fzg != null && this.mIndex < FrsCommonImageLayout.this.fzg.length) {
                if (FrsCommonImageLayout.this.fzg[this.mIndex].getType() == 5) {
                    if (FrsCommonImageLayout.this.fzp instanceof TbPageContext) {
                        bb.vy().c((TbPageContext) FrsCommonImageLayout.this.fzp, new String[]{FrsCommonImageLayout.this.fzg[this.mIndex].getVideoUrl()});
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    for (MediaData mediaData : FrsCommonImageLayout.this.fzg) {
                        if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                            arrayList.add(mediaData.getSrc_pic());
                            if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.urlType = FrsCommonImageLayout.this.mIsFromCDN ? 13 : 14;
                                imageUrlData.imageUrl = mediaData.getPicUrl();
                                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                                imageUrlData.originalSize = mediaData.getOriginalSize();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(FrsCommonImageLayout.this.mThreadId, -1L);
                                imageUrlData.postId = mediaData.getPostId();
                                concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                            }
                        }
                    }
                    if (arrayList.size() <= 0) {
                        for (MediaData mediaData2 : FrsCommonImageLayout.this.fzg) {
                            if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                arrayList.add(mediaData2.getPicUrl());
                            }
                        }
                    }
                    if (FrsCommonImageLayout.this.fzp == null) {
                        pageActivity = FrsCommonImageLayout.this.mContext;
                    } else {
                        pageActivity = FrsCommonImageLayout.this.fzp.getPageActivity();
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(pageActivity).createConfig(arrayList, this.mIndex, FrsCommonImageLayout.this.mForumName, FrsCommonImageLayout.this.mForumId, FrsCommonImageLayout.this.mThreadId, FrsCommonImageLayout.this.mIsFromCDN, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
                    createConfig.getIntent().putExtra("from", "frs");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    TiebaStatic.eventStat(FrsCommonImageLayout.this.mContext, "pic_frs", "");
                }
            } else {
                return;
            }
            if (FrsCommonImageLayout.this.fzm != null) {
                FrsCommonImageLayout.this.fzm.onClick(view);
            }
        }
    }

    public void setChildrenClickable(boolean z) {
        this.fzn = z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.fzn) {
            view.setOnClickListener(new a(this, getChildCount() - 1, null));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        if (this.fzn) {
            view.setOnClickListener(new a(this, getChildCount() - 1, null));
        }
    }

    public void a(bl blVar, String str, String str2, String str3) {
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void a(com.baidu.adp.base.g<?> gVar, MediaData[] mediaDataArr, int i) {
        this.fzg = mediaDataArr;
        this.fzj = i;
        this.fzp = gVar;
        Resources resources = getResources();
        this.fzq = String.valueOf(resources.getString(w.l.frs_item_common_image_canvas_text1)) + this.fzj + resources.getString(w.l.frs_item_common_image_canvas_text2);
        if (this.fzl == null && (gVar.getOrignalPage() instanceof c)) {
            this.fzl = ((c) gVar.getOrignalPage()).acv();
        }
        if (this.fzl != null) {
            if (this.fzg == null || this.fzg.length <= 0) {
                requestLayout();
                return;
            }
            this.mChildCount = this.fzg.length;
            if (this.mChildCount > this.mNormalShowCount) {
                this.mChildCount = this.mNormalShowCount;
            }
            int childCount = getChildCount();
            if (this.mChildCount > childCount) {
                int i2 = this.mChildCount - childCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    TbImageView fK = this.fzl.fK();
                    fK.setContentDescription(String.valueOf(gVar.getString(w.l.editor_image)) + (i3 + 1));
                    if (fK != null) {
                        addView(fK);
                    }
                }
            } else if (this.mChildCount < childCount) {
                removeViews(this.mChildCount, childCount - this.mChildCount);
            }
            int childCount2 = getChildCount();
            for (int i4 = 0; i4 < childCount2 && i4 < this.fzg.length; i4++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i4);
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType() && tbImageView != null) {
                    tbImageView.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                a(tbImageView, this.fzg[i4], i4);
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
            tbImageView.setDefaultResource(w.g.transparent_bg);
            tbImageView.setDefaultErrorResource(w.g.img_default_100);
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(w.g.pic_video);
                tbImageView.setDefaultErrorResource(w.g.pic_bg_video_h5);
            }
            tbImageView.c(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.fzg != null && this.fzg.length > 0) {
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
                if (this.fzj > 3 && this.fzk) {
                    p(canvas);
                }
            }
        }
    }

    private void p(Canvas canvas) {
        if (this.fzu == null || this.fzu.isRecycled()) {
            this.fzu = BitmapHelper.getCashBitmap(w.g.bg_look_photo_1);
            if (this.fzu != null) {
                this.HA = new Rect(0, 0, this.fzu.getWidth(), this.fzu.getHeight());
                this.HB = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.fzu != null && !this.fzu.isRecycled()) {
            this.HA.set(0, 0, this.fzu.getWidth(), this.fzu.getHeight());
            this.HB.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.fzu, this.HA, this.HB, this.paint);
        }
        canvas.drawText(this.fzq, (getWidth() - this.w) + ((this.w - this.fzr) / 2), getHeight() + ((this.fzs - this.h) / 2), this.fzt);
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
        this.fzh = z;
        if (this.fzh) {
            this.fzv = "_small";
        } else {
            this.fzv = "_mobile";
        }
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        this.fzm = onClickListener;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> r(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new f(context), i, 0);
    }
}
