package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    private Rect GR;
    private Rect GS;
    private MediaData[] ade;
    private boolean adf;
    private b cGH;
    private int cGI;
    private int cGJ;
    private boolean cGK;
    private com.baidu.adp.lib.e.b<TbImageView> cGL;
    com.baidu.adp.base.h<?> cGM;
    private int cGN;
    private int cGO;
    private Paint cGP;
    private Bitmap cGQ;
    private String cGR;
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
    private String str;
    private int w;

    /* loaded from: classes.dex */
    public interface b {
        void onChildClickCallback(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        com.baidu.adp.lib.e.b<TbImageView> KU();
    }

    public void setDrawNum(boolean z) {
        this.cGK = z;
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
        this.mItemSize = com.baidu.adp.lib.util.k.dip2px(this.mContext, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFromCDN = false;
        this.adf = false;
        this.mItemSize = 0;
        this.mPadding = 3;
        this.cGI = 110;
        this.mNormalShowCount = 3;
        this.cGK = false;
        this.cGL = null;
        this.mContext = context;
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(this.mContext, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.k.dip2px(this.mContext, this.cGI);
        setOnHierarchyChangeListener(new e(this));
        this.w = com.baidu.adp.lib.util.k.dip2px(this.mContext, 50.0f);
        this.h = com.baidu.adp.lib.util.k.dip2px(this.mContext, 23.0f);
        this.paint = new Paint();
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        Resources resources = getResources();
        this.str = String.valueOf(resources.getString(i.C0057i.frs_item_common_image_canvas_text1)) + this.cGJ + resources.getString(i.C0057i.frs_item_common_image_canvas_text2);
        this.cGN = ((this.str.length() + 2) * com.baidu.adp.lib.util.k.dip2px(this.mContext, 10.0f)) / 2;
        this.cGO = com.baidu.adp.lib.util.k.dip2px(this.mContext, 10.0f);
        this.cGP = new Paint((int) SapiErrorCode.PHONE_NULL);
        this.cGP.setColor(-1);
        this.cGP.setTextSize(resources.getDimension(i.d.ds20));
        this.cGQ = com.baidu.tbadk.core.util.c.bZ(i.e.bg_look_photo_1);
        if (this.cGQ != null) {
            this.GR = new Rect(0, 0, this.cGQ.getWidth(), this.cGQ.getHeight());
            this.GS = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
        }
    }

    public void setOnChildClickListener(b bVar) {
        this.cGH = bVar;
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
            if (FrsCommonImageLayout.this.cGH != null) {
                FrsCommonImageLayout.this.cGH.onChildClickCallback(this.mIndex);
            } else if (FrsCommonImageLayout.this.ade != null && this.mIndex < FrsCommonImageLayout.this.ade.length) {
                if (FrsCommonImageLayout.this.ade[this.mIndex].getType() == 5) {
                    if (FrsCommonImageLayout.this.cGM instanceof TbPageContext) {
                        ax.uR().b((TbPageContext) FrsCommonImageLayout.this.cGM, new String[]{FrsCommonImageLayout.this.ade[this.mIndex].getVideoUrl()});
                        return;
                    }
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                for (MediaData mediaData : FrsCommonImageLayout.this.ade) {
                    if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                        arrayList.add(mediaData.getSrc_pic());
                        if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.urlType = FrsCommonImageLayout.this.mIsFromCDN ? 13 : 14;
                            imageUrlData.imageUrl = mediaData.getPicUrl();
                            hashMap.put(mediaData.getSrc_pic(), imageUrlData);
                        }
                    }
                }
                if (arrayList.size() <= 0) {
                    for (MediaData mediaData2 : FrsCommonImageLayout.this.ade) {
                        if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                            arrayList.add(mediaData2.getPicUrl());
                        }
                    }
                }
                MessageManager messageManager = MessageManager.getInstance();
                if (FrsCommonImageLayout.this.cGM == null) {
                    pageActivity = FrsCommonImageLayout.this.mContext;
                } else {
                    pageActivity = FrsCommonImageLayout.this.cGM.getPageActivity();
                }
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(pageActivity).createConfig(arrayList, this.mIndex, FrsCommonImageLayout.this.mForumName, FrsCommonImageLayout.this.mForumId, FrsCommonImageLayout.this.mThreadId, FrsCommonImageLayout.this.mIsFromCDN, arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : "", true, hashMap)));
                TiebaStatic.eventStat(FrsCommonImageLayout.this.mContext, "pic_frs", "");
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

    public void a(com.baidu.tbadk.core.data.v vVar, String str, String str2, String str3) {
        this.mForumName = str;
        this.mForumId = str2;
        this.mThreadId = str3;
    }

    public void a(com.baidu.adp.base.h<?> hVar, MediaData[] mediaDataArr, int i) {
        reset();
        this.ade = mediaDataArr;
        this.cGJ = i;
        this.cGM = hVar;
        Resources resources = getResources();
        this.str = String.valueOf(resources.getString(i.C0057i.frs_item_common_image_canvas_text1)) + this.cGJ + resources.getString(i.C0057i.frs_item_common_image_canvas_text2);
        if (this.cGL == null && (hVar.getOrignalPage() instanceof c)) {
            this.cGL = ((c) hVar.getOrignalPage()).KU();
        }
        if (this.ade == null || this.ade.length <= 0) {
            requestLayout();
            return;
        }
        this.mChildCount = this.ade.length;
        if (this.mChildCount > this.mNormalShowCount) {
            this.mChildCount = this.mNormalShowCount;
        }
        Drawable drawable = al.getDrawable(i.c.pb_default_image_bg);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mChildCount) {
                TbImageView ha = this.cGL.ha();
                ha.setSupportNoImage(true);
                ha.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ha.setDefaultBg(drawable);
                addView(ha);
                a(ha, this.ade[i3], i3);
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
            this.mItemSize = this.cGI;
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
            tbImageView.setDefaultResource(i.e.img_default_100);
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(i.e.pic_video);
            }
            tbImageView.d(picUrl, this.mIsFromCDN ? 13 : 14, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ade != null && this.ade.length > 0) {
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
                if (this.cGJ > 3 && this.cGK) {
                    h(canvas);
                }
            }
        }
    }

    private void h(Canvas canvas) {
        if (this.cGQ == null || this.cGQ.isRecycled()) {
            this.cGQ = com.baidu.tbadk.core.util.c.bZ(i.e.bg_look_photo_1);
            if (this.cGQ != null) {
                this.GR = new Rect(0, 0, this.cGQ.getWidth(), this.cGQ.getHeight());
                this.GS = new Rect(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            }
        }
        if (this.cGQ != null && !this.cGQ.isRecycled()) {
            this.GR.set(0, 0, this.cGQ.getWidth(), this.cGQ.getHeight());
            this.GS.set(getWidth() - this.w, getHeight() - this.h, getWidth(), getHeight());
            canvas.drawBitmap(this.cGQ, this.GR, this.GS, this.paint);
        }
        canvas.drawText(this.str, (getWidth() - this.w) + ((this.w - this.cGN) / 2), getHeight() + ((this.cGO - this.h) / 2), this.cGP);
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
        this.adf = z;
        if (this.adf) {
            this.cGR = "_small";
        } else {
            this.cGR = "_mobile";
        }
    }

    public static com.baidu.adp.lib.e.b<TbImageView> n(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new f(context), i, 0);
    }
}
