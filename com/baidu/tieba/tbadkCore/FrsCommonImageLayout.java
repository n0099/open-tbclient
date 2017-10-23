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
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private Rect Hm;
    private Rect Hn;
    private int gdA;
    private boolean gdB;
    private com.baidu.adp.lib.e.b<TbImageView> gdC;
    private View.OnClickListener gdD;
    private boolean gdE;
    private boolean gdF;
    com.baidu.adp.base.e<?> gdG;
    private String gdH;
    private int gdI;
    private int gdJ;
    private Paint gdK;
    private Bitmap gdL;
    private String gdM;
    private b gdw;
    private MediaData[] gdx;
    private boolean gdy;
    private int gdz;
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
        void dE(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        com.baidu.adp.lib.e.b<TbImageView> agu();
    }

    public void setDrawNum(boolean z) {
        this.gdB = z;
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
        this.mItemSize = com.baidu.adp.lib.util.l.dip2px(this.mContext, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.gdy = false;
        this.mItemSize = 0;
        this.mPadding = 2;
        this.gdz = 0;
        this.mNormalShowCount = 3;
        this.gdB = false;
        this.gdC = null;
        this.gdE = true;
        this.gdF = true;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.gdz);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.tbadkCore.FrsCommonImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && FrsCommonImageLayout.this.gdC != null) {
                    FrsCommonImageLayout.this.gdC.m((TbImageView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
        this.w = com.baidu.adp.lib.util.l.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.l.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.gdH = resources.getString(d.l.frs_item_common_image_canvas_text1) + this.gdA + resources.getString(d.l.frs_item_common_image_canvas_text2);
        this.gdI = ((this.gdH.length() + 2) * com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f)) / 2;
        this.gdJ = com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
        this.gdK = new Paint((int) SapiErrorCode.PHONE_NULL);
        this.gdK.setColor(-1);
        this.gdK.setTextSize(resources.getDimension(d.f.ds20));
        this.gdL = BitmapHelper.getCashBitmap(d.g.bg_look_photo_1);
        if (this.gdL != null) {
            this.Hm = new Rect(0, 0, this.gdL.getWidth(), this.gdL.getHeight());
            this.Hn = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(b bVar) {
        this.gdw = bVar;
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaData[] mediaDataArr;
            Context pageActivity;
            MediaData[] mediaDataArr2;
            if (FrsCommonImageLayout.this.gdw != null) {
                FrsCommonImageLayout.this.gdw.dE(this.mIndex);
            } else if (FrsCommonImageLayout.this.gdx != null && this.mIndex < FrsCommonImageLayout.this.gdx.length) {
                if (FrsCommonImageLayout.this.gdx[this.mIndex].getType() == 5) {
                    if (FrsCommonImageLayout.this.gdG instanceof TbPageContext) {
                        av.vA().c((TbPageContext) FrsCommonImageLayout.this.gdG, new String[]{FrsCommonImageLayout.this.gdx[this.mIndex].getVideoUrl()});
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    for (MediaData mediaData : FrsCommonImageLayout.this.gdx) {
                        if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                            arrayList.add(mediaData.getSrc_pic());
                            if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.urlType = FrsCommonImageLayout.this.mIsFromCDN ? 13 : 14;
                                imageUrlData.imageUrl = mediaData.getPicUrl();
                                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                                imageUrlData.originalSize = mediaData.getOriginalSize();
                                imageUrlData.isLongPic = mediaData.isLongPic();
                                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(FrsCommonImageLayout.this.mThreadId, -1L);
                                imageUrlData.postId = mediaData.getPostId();
                                concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                            }
                        }
                    }
                    if (arrayList.size() <= 0) {
                        for (MediaData mediaData2 : FrsCommonImageLayout.this.gdx) {
                            if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                arrayList.add(mediaData2.getPicUrl());
                            }
                        }
                    }
                    if (FrsCommonImageLayout.this.gdG == null) {
                        pageActivity = FrsCommonImageLayout.this.mContext;
                    } else {
                        pageActivity = FrsCommonImageLayout.this.gdG.getPageActivity();
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(pageActivity).createConfig(arrayList, this.mIndex, FrsCommonImageLayout.this.mForumName, FrsCommonImageLayout.this.mForumId, FrsCommonImageLayout.this.mThreadId, FrsCommonImageLayout.this.mIsFromCDN, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
                    createConfig.getIntent().putExtra("from", "frs");
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    TiebaStatic.eventStat(FrsCommonImageLayout.this.mContext, "pic_frs", "");
                }
            } else {
                return;
            }
            if (FrsCommonImageLayout.this.gdD != null) {
                FrsCommonImageLayout.this.gdD.onClick(view);
            }
        }
    }

    public void setChildrenClickable(boolean z) {
        this.gdE = z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.gdE) {
            view.setOnClickListener(new a(getChildCount() - 1));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        if (this.gdE) {
            view.setOnClickListener(new a(getChildCount() - 1));
        }
    }

    public void a(bh bhVar, String str, String str2, String str3) {
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void a(com.baidu.adp.base.e<?> eVar, MediaData[] mediaDataArr, int i) {
        this.gdx = mediaDataArr;
        this.gdA = i;
        this.gdG = eVar;
        Resources resources = getResources();
        this.gdH = resources.getString(d.l.frs_item_common_image_canvas_text1) + this.gdA + resources.getString(d.l.frs_item_common_image_canvas_text2);
        if (this.gdC == null && (eVar.getOrignalPage() instanceof c)) {
            this.gdC = ((c) eVar.getOrignalPage()).agu();
        }
        if (this.gdC != null) {
            if (this.gdx == null || this.gdx.length <= 0) {
                requestLayout();
                return;
            }
            this.mChildCount = this.gdx.length;
            if (this.mChildCount > this.mNormalShowCount) {
                this.mChildCount = this.mNormalShowCount;
            }
            int childCount = getChildCount();
            if (this.mChildCount > childCount) {
                int i2 = this.mChildCount - childCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    TbImageView fH = this.gdC.fH();
                    fH.setContentDescription(eVar.getString(d.l.editor_image) + (i3 + 1));
                    if (fH != null) {
                        addView(fH);
                    }
                }
            } else if (this.mChildCount < childCount) {
                removeViews(this.mChildCount, childCount - this.mChildCount);
            }
            int childCount2 = getChildCount();
            for (int i4 = 0; i4 < childCount2 && i4 < this.gdx.length; i4++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i4);
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType() && tbImageView != null) {
                    tbImageView.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                a(tbImageView, this.gdx[i4], i4);
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
            tbImageView.setDefaultResource(d.g.transparent_bg);
            tbImageView.setDefaultErrorResource(d.g.img_default_100);
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(d.g.pic_video);
                tbImageView.setDefaultErrorResource(d.g.pic_bg_video_h5);
            }
            if (bpj() && i == getChildCount() - 1) {
                tbImageView.setGifIconSupport(false);
                tbImageView.setLongIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
            }
            tbImageView.setIsLongPic(mediaData.isLongPic());
            tbImageView.c(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gdx != null && this.gdx.length > 0) {
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
                if (bpj()) {
                    z(canvas);
                }
            }
        }
    }

    private boolean bpj() {
        return this.gdA > 3 && this.gdB;
    }

    private void z(Canvas canvas) {
        if (this.gdL == null || this.gdL.isRecycled()) {
            this.gdL = BitmapHelper.getCashBitmap(d.g.bg_look_photo_1);
            if (this.gdL != null) {
                this.Hm = new Rect(0, 0, this.gdL.getWidth(), this.gdL.getHeight());
                this.Hn = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.gdL != null && !this.gdL.isRecycled()) {
            this.Hm.set(0, 0, this.gdL.getWidth(), this.gdL.getHeight());
            this.Hn.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.gdL, this.Hm, this.Hn, this.paint);
        }
        canvas.drawText(this.gdH, (getWidth() - this.w) + ((this.w - this.gdI) / 2), getHeight() + ((this.gdJ - this.h) / 2), this.gdK);
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
        this.gdy = z;
        if (this.gdy) {
            this.gdM = "_small";
        } else {
            this.gdM = "_mobile";
        }
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        this.gdD = onClickListener;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> p(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.tbadkCore.FrsCommonImageLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wF */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setSupportNoImage(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderWidth(1);
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView o(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView p(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
                return tbImageView;
            }
        }, i, 0);
    }
}
