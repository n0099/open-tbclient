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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private bw ajx;
    private Rect dst;
    private int h;
    private String lIh;
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
    private MediaData[] mbL;
    private boolean mbM;
    private b mcJ;
    private int mcK;
    private int mcL;
    private boolean mcM;
    private com.baidu.adp.lib.d.b<TbImageView> mcN;
    private View.OnClickListener mcO;
    private boolean mcP;
    private boolean mcQ;
    com.baidu.adp.base.e<?> mcR;
    private int mcS;
    private int mcT;
    private Paint mcU;
    private Bitmap mcV;
    private Paint paint;
    private Rect src;
    private String str;
    private int w;

    /* loaded from: classes2.dex */
    public interface b {
        void oU(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        com.baidu.adp.lib.d.b<TbImageView> clf();
    }

    public void setDrawNum(boolean z) {
        this.mcM = z;
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
        this.mbM = false;
        this.mItemSize = 0;
        this.mPadding = 2;
        this.mcK = 0;
        this.mNormalShowCount = 3;
        this.mcM = false;
        this.mcN = null;
        this.mcP = true;
        this.mcQ = true;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mcK);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.tbadkCore.FrsCommonImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && FrsCommonImageLayout.this.mcN != null) {
                    FrsCommonImageLayout.this.mcN.returnObject((TbImageView) view2);
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
        this.str = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.mcL + resources.getString(R.string.frs_item_common_image_canvas_text2);
        this.mcS = ((this.str.length() + 2) * com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f)) / 2;
        this.mcT = com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
        this.mcU = new Paint(257);
        this.mcU.setColor(-1);
        this.mcU.setTextSize(resources.getDimension(R.dimen.ds20));
        this.mcV = BitmapHelper.getCashBitmap(R.drawable.bg_look_photo_1);
        if (this.mcV != null) {
            this.src = new Rect(0, 0, this.mcV.getWidth(), this.mcV.getHeight());
            this.dst = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(b bVar) {
        this.mcJ = bVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
            if (FrsCommonImageLayout.this.mcJ != null) {
                FrsCommonImageLayout.this.mcJ.oU(this.mIndex);
            } else if (FrsCommonImageLayout.this.mbL != null && this.mIndex < FrsCommonImageLayout.this.mbL.length) {
                if (FrsCommonImageLayout.this.mbL[this.mIndex].getType() == 5) {
                    if (FrsCommonImageLayout.this.mcR instanceof TbPageContext) {
                        be.bju().b((TbPageContext) FrsCommonImageLayout.this.mcR, new String[]{FrsCommonImageLayout.this.mbL[this.mIndex].getVideoUrl()});
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    for (MediaData mediaData : FrsCommonImageLayout.this.mbL) {
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
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(FrsCommonImageLayout.this.mThreadId, -1L);
                                imageUrlData.postId = mediaData.getPostId();
                                concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                            }
                        }
                    }
                    if (arrayList.size() <= 0) {
                        for (MediaData mediaData2 : FrsCommonImageLayout.this.mbL) {
                            if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                arrayList.add(mediaData2.getPicUrl());
                            }
                        }
                    }
                    if (FrsCommonImageLayout.this.mcL > FrsCommonImageLayout.this.mNormalShowCount && this.mIndex == FrsCommonImageLayout.this.mNormalShowCount - 1) {
                        PbActivityConfig addLocateParam = new PbActivityConfig(FrsCommonImageLayout.this.mContext).createFromThreadCfg(FrsCommonImageLayout.this.ajx, FrsCommonImageLayout.this.mForumName, null, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
                        addLocateParam.setForumId(String.valueOf(FrsCommonImageLayout.this.ajx.getFid()));
                        addLocateParam.setForumName(FrsCommonImageLayout.this.ajx.beI());
                        addLocateParam.setStartFrom(3);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
                    } else {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).mM(this.mIndex).yP(FrsCommonImageLayout.this.mForumName).yQ(FrsCommonImageLayout.this.mForumId).yR(FrsCommonImageLayout.this.mThreadId).hH(FrsCommonImageLayout.this.mIsFromCDN).yS(arrayList.size() > 0 ? arrayList.get(0) : "").hI(true).a(concurrentHashMap).hJ(true).r(FrsCommonImageLayout.this.ajx).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (FrsCommonImageLayout.this.mcR == null) {
                            pageActivity = FrsCommonImageLayout.this.mContext;
                        } else {
                            pageActivity = FrsCommonImageLayout.this.mcR.getPageActivity();
                        }
                        ImageViewerConfig dP = aVar.dP(pageActivity);
                        dP.getIntent().putExtra("from", "frs");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
                        TiebaStatic.eventStat(FrsCommonImageLayout.this.mContext, "pic_frs", "");
                        HistoryMessage historyMessage = new HistoryMessage();
                        historyMessage.Activity = (TbPageContext) com.baidu.adp.base.i.I(FrsCommonImageLayout.this.mContext);
                        historyMessage.threadId = FrsCommonImageLayout.this.ajx.getId();
                        historyMessage.threadName = FrsCommonImageLayout.this.ajx.getTitle();
                        historyMessage.forumName = FrsCommonImageLayout.this.ajx.beI();
                        historyMessage.postID = FrsCommonImageLayout.this.ajx.beV();
                        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
                    }
                }
            } else {
                return;
            }
            if (FrsCommonImageLayout.this.mcO != null) {
                FrsCommonImageLayout.this.mcO.onClick(view);
            }
        }
    }

    public void setChildrenClickable(boolean z) {
        this.mcP = z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.mcP) {
            view.setOnClickListener(new a(getChildCount() - 1));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        if (this.mcP) {
            view.setOnClickListener(new a(getChildCount() - 1));
        }
    }

    public void setThreadData(bw bwVar, String str, String str2, String str3) {
        this.ajx = bwVar;
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void setData(com.baidu.adp.base.e<?> eVar, MediaData[] mediaDataArr, int i) {
        this.mbL = mediaDataArr;
        this.mcL = i;
        this.mcR = eVar;
        Resources resources = getResources();
        this.str = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.mcL + resources.getString(R.string.frs_item_common_image_canvas_text2);
        if (this.mcN == null && (eVar.getOrignalPage() instanceof c)) {
            this.mcN = ((c) eVar.getOrignalPage()).clf();
        }
        if (this.mcN != null) {
            if (this.mbL == null || this.mbL.length <= 0) {
                requestLayout();
                return;
            }
            this.mChildCount = this.mbL.length;
            if (this.mChildCount > this.mNormalShowCount) {
                this.mChildCount = this.mNormalShowCount;
            }
            int childCount = getChildCount();
            if (this.mChildCount > childCount) {
                int i2 = this.mChildCount - childCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    TbImageView borrowObject = this.mcN.borrowObject();
                    borrowObject.setContentDescription(eVar.getString(R.string.editor_image) + (i3 + 1));
                    if (borrowObject != null) {
                        addView(borrowObject);
                    }
                }
            } else if (this.mChildCount < childCount) {
                removeViews(this.mChildCount, childCount - this.mChildCount);
            }
            int childCount2 = getChildCount();
            for (int i4 = 0; i4 < childCount2 && i4 < this.mbL.length; i4++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i4);
                if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType() && tbImageView != null) {
                    tbImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
                }
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                a(tbImageView, this.mbL[i4], i4);
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
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            tbImageView.setDefaultErrorResource(R.drawable.img_default_100);
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(R.drawable.pic_video);
                tbImageView.setDefaultErrorResource(R.drawable.pic_bg_video_h5);
            }
            if (dvL() && i == getChildCount() - 1) {
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
        if (this.mbL != null && this.mbL.length > 0) {
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
                if (dvL()) {
                    al(canvas);
                }
            }
        }
    }

    private boolean dvL() {
        return this.mcL > 3 && this.mcM;
    }

    private void al(Canvas canvas) {
        if (this.mcV == null || this.mcV.isRecycled()) {
            this.mcV = BitmapHelper.getCashBitmap(R.drawable.bg_look_photo_1);
            if (this.mcV != null) {
                this.src = new Rect(0, 0, this.mcV.getWidth(), this.mcV.getHeight());
                this.dst = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.mcV != null && !this.mcV.isRecycled()) {
            this.src.set(0, 0, this.mcV.getWidth(), this.mcV.getHeight());
            this.dst.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.mcV, this.src, this.dst, this.paint);
        }
        canvas.drawText(this.str, (getWidth() - this.w) + ((this.w - this.mcS) / 2), getHeight() + ((this.mcT - this.h) / 2), this.mcU);
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
        this.mbM = z;
        if (this.mbM) {
            this.lIh = "_small";
        } else {
            this.lIh = "_mobile";
        }
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        this.mcO = onClickListener;
    }

    public static com.baidu.adp.lib.d.b<TbImageView> D(final Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.tbadkCore.FrsCommonImageLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setSupportNoImage(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderWidth(1);
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
                return tbImageView;
            }
        }, i, 0);
    }
}
