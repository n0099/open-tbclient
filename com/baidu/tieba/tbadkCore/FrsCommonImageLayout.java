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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private bd bso;
    private b gFT;
    private int gFU;
    private int gFV;
    private boolean gFW;
    private com.baidu.adp.lib.e.b<TbImageView> gFX;
    private View.OnClickListener gFY;
    private boolean gFZ;
    private MediaData[] gFu;
    private boolean gFv;
    private boolean gGa;
    com.baidu.adp.base.e<?> gGb;
    private String gGc;
    private int gGd;
    private int gGe;
    private Paint gGf;
    private Bitmap gGg;
    private String gpk;
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
    private Rect pf;
    private Rect pg;
    private int w;

    /* loaded from: classes.dex */
    public interface b {
        void dD(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        com.baidu.adp.lib.e.b<TbImageView> asR();
    }

    public void setDrawNum(boolean z) {
        this.gFW = z;
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
        this.gFv = false;
        this.mItemSize = 0;
        this.mPadding = 2;
        this.gFU = 0;
        this.mNormalShowCount = 3;
        this.gFW = false;
        this.gFX = null;
        this.gFZ = true;
        this.gGa = true;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.gFU);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.tbadkCore.FrsCommonImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && FrsCommonImageLayout.this.gFX != null) {
                    FrsCommonImageLayout.this.gFX.p((TbImageView) view2);
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
        this.gGc = resources.getString(d.k.frs_item_common_image_canvas_text1) + this.gFV + resources.getString(d.k.frs_item_common_image_canvas_text2);
        this.gGd = ((this.gGc.length() + 2) * com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f)) / 2;
        this.gGe = com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
        this.gGf = new Paint(257);
        this.gGf.setColor(-1);
        this.gGf.setTextSize(resources.getDimension(d.e.ds20));
        this.gGg = BitmapHelper.getCashBitmap(d.f.bg_look_photo_1);
        if (this.gGg != null) {
            this.pf = new Rect(0, 0, this.gGg.getWidth(), this.gGg.getHeight());
            this.pg = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(b bVar) {
        this.gFT = bVar;
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
            if (FrsCommonImageLayout.this.gFT != null) {
                FrsCommonImageLayout.this.gFT.dD(this.mIndex);
            } else if (FrsCommonImageLayout.this.gFu != null && this.mIndex < FrsCommonImageLayout.this.gFu.length) {
                if (FrsCommonImageLayout.this.gFu[this.mIndex].getType() == 5) {
                    if (FrsCommonImageLayout.this.gGb instanceof TbPageContext) {
                        ay.zG().c((TbPageContext) FrsCommonImageLayout.this.gGb, new String[]{FrsCommonImageLayout.this.gFu[this.mIndex].getVideoUrl()});
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    for (MediaData mediaData : FrsCommonImageLayout.this.gFu) {
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
                        for (MediaData mediaData2 : FrsCommonImageLayout.this.gFu) {
                            if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                arrayList.add(mediaData2.getPicUrl());
                            }
                        }
                    }
                    if (FrsCommonImageLayout.this.gFV > FrsCommonImageLayout.this.mNormalShowCount && this.mIndex == FrsCommonImageLayout.this.mNormalShowCount - 1) {
                        PbActivityConfig addLocateParam = new PbActivityConfig(FrsCommonImageLayout.this.mContext).createFromThreadCfg(FrsCommonImageLayout.this.bso, FrsCommonImageLayout.this.mForumName, null, 18003, true, false, false).addLocateParam("");
                        addLocateParam.setForumId(String.valueOf(FrsCommonImageLayout.this.bso.getFid()));
                        addLocateParam.setForumName(FrsCommonImageLayout.this.bso.vr());
                        addLocateParam.setStartFrom(3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
                    } else {
                        if (FrsCommonImageLayout.this.gGb == null) {
                            pageActivity = FrsCommonImageLayout.this.mContext;
                        } else {
                            pageActivity = FrsCommonImageLayout.this.gGb.getPageActivity();
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(pageActivity).createConfig(arrayList, this.mIndex, FrsCommonImageLayout.this.mForumName, FrsCommonImageLayout.this.mForumId, FrsCommonImageLayout.this.mThreadId, FrsCommonImageLayout.this.mIsFromCDN, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.setSrcRectInScreen(rect);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
                        TiebaStatic.eventStat(FrsCommonImageLayout.this.mContext, "pic_frs", "");
                    }
                }
            } else {
                return;
            }
            if (FrsCommonImageLayout.this.gFY != null) {
                FrsCommonImageLayout.this.gFY.onClick(view);
            }
        }
    }

    public void setChildrenClickable(boolean z) {
        this.gFZ = z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.gFZ) {
            view.setOnClickListener(new a(getChildCount() - 1));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        if (this.gFZ) {
            view.setOnClickListener(new a(getChildCount() - 1));
        }
    }

    public void setThreadData(bd bdVar, String str, String str2, String str3) {
        this.bso = bdVar;
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void setData(com.baidu.adp.base.e<?> eVar, MediaData[] mediaDataArr, int i) {
        this.gFu = mediaDataArr;
        this.gFV = i;
        this.gGb = eVar;
        Resources resources = getResources();
        this.gGc = resources.getString(d.k.frs_item_common_image_canvas_text1) + this.gFV + resources.getString(d.k.frs_item_common_image_canvas_text2);
        if (this.gFX == null && (eVar.getOrignalPage() instanceof c)) {
            this.gFX = ((c) eVar.getOrignalPage()).asR();
        }
        if (this.gFX != null) {
            if (this.gFu == null || this.gFu.length <= 0) {
                requestLayout();
                return;
            }
            this.mChildCount = this.gFu.length;
            if (this.mChildCount > this.mNormalShowCount) {
                this.mChildCount = this.mNormalShowCount;
            }
            int childCount = getChildCount();
            if (this.mChildCount > childCount) {
                int i2 = this.mChildCount - childCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    TbImageView ie = this.gFX.ie();
                    ie.setContentDescription(eVar.getString(d.k.editor_image) + (i3 + 1));
                    if (ie != null) {
                        addView(ie);
                    }
                }
            } else if (this.mChildCount < childCount) {
                removeViews(this.mChildCount, childCount - this.mChildCount);
            }
            int childCount2 = getChildCount();
            for (int i4 = 0; i4 < childCount2 && i4 < this.gFu.length; i4++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i4);
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType() && tbImageView != null) {
                    tbImageView.setDefaultBg(al.getDrawable(d.C0141d.common_color_10220));
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                a(tbImageView, this.gFu[i4], i4);
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
            tbImageView.setDefaultResource(d.f.transparent_bg);
            tbImageView.setDefaultErrorResource(d.f.img_default_100);
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(d.f.pic_video);
                tbImageView.setDefaultErrorResource(d.f.pic_bg_video_h5);
            }
            if (buQ() && i == getChildCount() - 1) {
                tbImageView.setGifIconSupport(false);
                tbImageView.setLongIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
            }
            tbImageView.setIsLongPic(mediaData.isLongPic());
            tbImageView.startLoad(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gFu != null && this.gFu.length > 0) {
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
                if (buQ()) {
                    F(canvas);
                }
            }
        }
    }

    private boolean buQ() {
        return this.gFV > 3 && this.gFW;
    }

    private void F(Canvas canvas) {
        if (this.gGg == null || this.gGg.isRecycled()) {
            this.gGg = BitmapHelper.getCashBitmap(d.f.bg_look_photo_1);
            if (this.gGg != null) {
                this.pf = new Rect(0, 0, this.gGg.getWidth(), this.gGg.getHeight());
                this.pg = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.gGg != null && !this.gGg.isRecycled()) {
            this.pf.set(0, 0, this.gGg.getWidth(), this.gGg.getHeight());
            this.pg.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.gGg, this.pf, this.pg, this.paint);
        }
        canvas.drawText(this.gGc, (getWidth() - this.w) + ((this.w - this.gGd) / 2), getHeight() + ((this.gGe - this.h) / 2), this.gGf);
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
        this.gFv = z;
        if (this.gFv) {
            this.gpk = "_small";
        } else {
            this.gpk = "_mobile";
        }
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        this.gFY = onClickListener;
    }

    public static com.baidu.adp.lib.e.b<TbImageView> o(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.tbadkCore.FrsCommonImageLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AI */
            public TbImageView mo9if() {
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
            public void q(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
                return tbImageView;
            }
        }, i, 0);
    }
}
