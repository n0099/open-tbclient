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
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes5.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    public int A;
    public Paint B;
    public String C;
    public int D;
    public int E;
    public Paint F;
    public Bitmap G;
    public Rect H;
    public Rect I;

    /* renamed from: e  reason: collision with root package name */
    public int f21573e;

    /* renamed from: f  reason: collision with root package name */
    public d f21574f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21575g;

    /* renamed from: h  reason: collision with root package name */
    public MediaData[] f21576h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f21577i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public a2 r;
    public String s;
    public String t;
    public String u;
    public d.a.c.e.k.b<TbImageView> v;
    public View.OnClickListener w;
    public boolean x;
    public f<?> y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof TbImageView) || FrsCommonImageLayout.this.v == null) {
                return;
            }
            FrsCommonImageLayout.this.v.e((TbImageView) view2);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements d.a.c.e.k.c<TbImageView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f21579a;

        public b(Context context) {
            this.f21579a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setBackgroundResource(0);
            tbImageView.setImageDrawable(null);
            tbImageView.setTag(null);
            tbImageView.setOnClickListener(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(this.f21579a);
            tbImageView.setSupportNoImage(true);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(1);
            return tbImageView;
        }

        public TbImageView h(TbImageView tbImageView) {
            tbImageView.setBackgroundResource(0);
            tbImageView.setImageDrawable(null);
            tbImageView.setTag(null);
            tbImageView.setOnClickListener(null);
            return tbImageView;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f21580e;

        public /* synthetic */ c(FrsCommonImageLayout frsCommonImageLayout, int i2, a aVar) {
            this(i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaData[] mediaDataArr;
            MediaData[] mediaDataArr2;
            if (FrsCommonImageLayout.this.f21574f != null) {
                FrsCommonImageLayout.this.f21574f.a(this.f21580e);
            } else if (FrsCommonImageLayout.this.f21576h == null || this.f21580e >= FrsCommonImageLayout.this.f21576h.length) {
                return;
            } else {
                if (FrsCommonImageLayout.this.f21576h[this.f21580e].getType() == 5) {
                    if (FrsCommonImageLayout.this.y instanceof TbPageContext) {
                        UrlManager urlManager = UrlManager.getInstance();
                        FrsCommonImageLayout frsCommonImageLayout = FrsCommonImageLayout.this;
                        urlManager.dealOneLink((TbPageContext) frsCommonImageLayout.y, new String[]{frsCommonImageLayout.f21576h[this.f21580e].getVideoUrl()});
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    for (MediaData mediaData : FrsCommonImageLayout.this.f21576h) {
                        if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                            arrayList.add(mediaData.getSrc_pic());
                            if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.urlType = FrsCommonImageLayout.this.f21575g ? 13 : 14;
                                imageUrlData.imageUrl = mediaData.getPicUrl();
                                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                                imageUrlData.originalSize = mediaData.getOriginalSize();
                                imageUrlData.isLongPic = mediaData.isLongPic();
                                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                                imageUrlData.threadId = d.a.c.e.m.b.f(FrsCommonImageLayout.this.u, -1L);
                                imageUrlData.postId = mediaData.getPostId();
                                concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                            }
                        }
                    }
                    if (arrayList.size() <= 0) {
                        for (MediaData mediaData2 : FrsCommonImageLayout.this.f21576h) {
                            if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                arrayList.add(mediaData2.getPicUrl());
                            }
                        }
                    }
                    if (FrsCommonImageLayout.this.p > FrsCommonImageLayout.this.o && this.f21580e == FrsCommonImageLayout.this.o - 1) {
                        PbActivityConfig addLocateParam = new PbActivityConfig(FrsCommonImageLayout.this.f21577i).createFromThreadCfg(FrsCommonImageLayout.this.r, FrsCommonImageLayout.this.t, null, 18003, true, false, false).addLocateParam("");
                        addLocateParam.setForumId(String.valueOf(FrsCommonImageLayout.this.r.c0()));
                        addLocateParam.setForumName(FrsCommonImageLayout.this.r.i0());
                        addLocateParam.setStartFrom(3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
                    } else {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(this.f21580e);
                        bVar.z(FrsCommonImageLayout.this.t);
                        bVar.y(FrsCommonImageLayout.this.s);
                        bVar.P(FrsCommonImageLayout.this.u);
                        bVar.C(FrsCommonImageLayout.this.f21575g);
                        bVar.K(arrayList.size() > 0 ? arrayList.get(0) : "");
                        bVar.G(true);
                        bVar.w(concurrentHashMap);
                        bVar.I(true);
                        bVar.O(FrsCommonImageLayout.this.r);
                        bVar.N(rect, UtilHelper.fixedDrawableRect(rect, view));
                        FrsCommonImageLayout frsCommonImageLayout2 = FrsCommonImageLayout.this;
                        f<?> fVar = frsCommonImageLayout2.y;
                        ImageViewerConfig v = bVar.v(fVar == null ? frsCommonImageLayout2.f21577i : fVar.getPageActivity());
                        v.getIntent().putExtra("from", "frs");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
                        TiebaStatic.eventStat(FrsCommonImageLayout.this.f21577i, "pic_frs", "");
                        HistoryMessage historyMessage = new HistoryMessage();
                        historyMessage.Activity = (TbPageContext) j.a(FrsCommonImageLayout.this.f21577i);
                        historyMessage.threadId = FrsCommonImageLayout.this.r.o0();
                        historyMessage.threadName = FrsCommonImageLayout.this.r.x1();
                        historyMessage.forumName = FrsCommonImageLayout.this.r.i0();
                        historyMessage.postID = FrsCommonImageLayout.this.r.f0();
                        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
                    }
                }
            }
            if (FrsCommonImageLayout.this.w != null) {
                FrsCommonImageLayout.this.w.onClick(view);
            }
        }

        public c(int i2) {
            this.f21580e = i2;
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes5.dex */
    public interface e {
        d.a.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool();
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public static d.a.c.e.k.b<TbImageView> m(Context context, int i2) {
        return new d.a.c.e.k.b<>(new b(context), i2, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (this.x) {
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr = this.f21576h;
        if (mediaDataArr == null || mediaDataArr.length <= 0) {
            return;
        }
        int childCount = getChildCount();
        this.l = childCount;
        if (childCount == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        for (int i2 = 0; i2 < this.l; i2++) {
            drawChild(canvas, (TbImageView) getChildAt(i2), drawingTime);
        }
        if (o()) {
            n(canvas);
        }
    }

    public int getItemSize() {
        return this.k;
    }

    public int getNormalShowCount() {
        return this.o;
    }

    public int getPadding() {
        return this.m;
    }

    public final void n(Canvas canvas) {
        Bitmap bitmap = this.G;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_look_photo_1);
            this.G = cashBitmap;
            if (cashBitmap != null) {
                this.H = new Rect(0, 0, this.G.getWidth(), this.G.getHeight());
                this.I = new Rect(getWidth() - this.z, getHeight() - this.A, getWidth(), getHeight());
            }
        }
        Bitmap bitmap2 = this.G;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.H.set(0, 0, this.G.getWidth(), this.G.getHeight());
            this.I.set(getWidth() - this.z, getHeight() - this.A, getWidth(), getHeight());
            canvas.drawBitmap(this.G, this.H, this.I, this.B);
        }
        String str = this.C;
        int width = getWidth();
        int i2 = this.z;
        canvas.drawText(str, (width - i2) + ((i2 - this.D) / 2), getHeight() + ((this.E - this.A) / 2), this.F);
    }

    public final boolean o() {
        return this.p > 3 && this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.l == 0) {
            return;
        }
        int i6 = 0;
        while (i6 < this.l) {
            TbImageView tbImageView = (TbImageView) getChildAt(i6);
            int i7 = this.m;
            int i8 = this.k;
            int i9 = (i7 * i6) + (i8 * i6);
            int i10 = i7 * i6;
            i6++;
            int i11 = i10 + (i8 * i6);
            if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                tbImageView.layout(i9, 0, i11, i5 - i3);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i5 = this.l;
        if (i5 == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i6 = this.k;
        int i7 = this.m;
        int i8 = (i6 * i5) + ((i5 - 1) * i7);
        int i9 = (i4 - (i7 * (i5 - 1))) / this.o;
        if (i6 == 0 || i8 > i4) {
            this.k = i9;
        } else {
            i4 = i8;
        }
        setMeasuredDimension(i4, this.k);
        for (int i10 = 0; i10 < this.l; i10++) {
            TbImageView tbImageView = (TbImageView) getChildAt(i10);
            if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                int i11 = this.k;
                measureChild(tbImageView, i11, i11);
            }
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
    }

    public void p() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    public final void q(TbImageView tbImageView, MediaData mediaData, int i2) {
        if (tbImageView == null) {
            return;
        }
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        String picUrl = mediaData.getPicUrl();
        if (mediaData.getType() == 5) {
            picUrl = null;
            tbImageView.setDefaultResource(R.drawable.pic_video);
        }
        if (o() && i2 == getChildCount() - 1) {
            tbImageView.setGifIconSupport(false);
            tbImageView.setLongIconSupport(false);
        } else {
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
        }
        tbImageView.setIsLongPic(mediaData.isLongPic());
        tbImageView.V(picUrl, this.f21575g ? 13 : 14, false);
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    public void setChildrenClickable(boolean z) {
        this.x = z;
    }

    public void setData(f<?> fVar, MediaData[] mediaDataArr, int i2) {
        this.f21576h = mediaDataArr;
        this.p = i2;
        this.y = fVar;
        Resources resources = getResources();
        this.C = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.p + resources.getString(R.string.frs_item_common_image_canvas_text2);
        if (this.v == null && (fVar.getOrignalPage() instanceof e)) {
            this.v = ((e) fVar.getOrignalPage()).getFrsCommonImageLayoutPool();
        }
        if (this.v == null) {
            return;
        }
        MediaData[] mediaDataArr2 = this.f21576h;
        if (mediaDataArr2 != null && mediaDataArr2.length > 0) {
            int length = mediaDataArr2.length;
            this.l = length;
            int i3 = this.o;
            if (length > i3) {
                this.l = i3;
            }
            int childCount = getChildCount();
            int i4 = this.l;
            if (i4 > childCount) {
                int i5 = i4 - childCount;
                int i6 = 0;
                while (i6 < i5) {
                    TbImageView b2 = this.v.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(fVar.getString(R.string.editor_image));
                    i6++;
                    sb.append(i6);
                    b2.setContentDescription(sb.toString());
                    if (b2 != null) {
                        addView(b2);
                    }
                }
            } else if (i4 < childCount) {
                removeViews(i4, childCount - i4);
            }
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2 && i7 < this.f21576h.length; i7++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i7);
                if (this.f21573e != TbadkCoreApplication.getInst().getSkinType() && tbImageView != null) {
                    tbImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                }
                this.f21573e = TbadkCoreApplication.getInst().getSkinType();
                q(tbImageView, this.f21576h[i7], i7);
            }
            return;
        }
        requestLayout();
    }

    public void setDrawNum(boolean z) {
        this.q = z;
    }

    public void setFromCDN(boolean z) {
        this.f21575g = z;
    }

    public void setImageFrom(String str) {
    }

    public void setItemSize(int i2) {
        this.k = l.e(this.f21577i, i2);
    }

    public void setNormalShowCount(int i2) {
        if (i2 <= 0) {
            i2 = 1;
        }
        this.o = i2;
    }

    public void setOnChildClickListener(d dVar) {
        this.f21574f = dVar;
    }

    public void setPadding(int i2) {
        this.m = i2;
    }

    public void setShowBig(boolean z) {
        this.j = z;
    }

    public void setThreadData(a2 a2Var, String str, String str2, String str3) {
        this.r = a2Var;
        this.t = str;
        this.s = str2;
        this.u = str3;
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21573e = 3;
        this.f21575g = false;
        this.j = false;
        this.k = 0;
        this.m = 2;
        this.n = 0;
        this.o = 3;
        this.q = false;
        this.v = null;
        this.x = true;
        this.f21577i = context;
        this.m = l.e(context, 2);
        this.k = l.e(this.f21577i, this.n);
        setOnHierarchyChangeListener(new a());
        this.z = l.e(this.f21577i, 50.0f);
        this.A = l.e(this.f21577i, 23.0f);
        Paint paint = new Paint();
        this.B = paint;
        paint.setDither(true);
        this.B.setFilterBitmap(true);
        Resources resources = getResources();
        String str = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.p + resources.getString(R.string.frs_item_common_image_canvas_text2);
        this.C = str;
        this.D = ((str.length() + 2) * l.e(this.f21577i, 10.0f)) / 2;
        this.E = l.e(this.f21577i, 10.0f);
        Paint paint2 = new Paint(257);
        this.F = paint2;
        paint2.setColor(-1);
        this.F.setTextSize(resources.getDimension(R.dimen.ds20));
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_look_photo_1);
        this.G = cashBitmap;
        if (cashBitmap != null) {
            this.H = new Rect(0, 0, this.G.getWidth(), this.G.getHeight());
            this.I = new Rect(getWidth() - this.z, getHeight() - this.A, getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        super.addView(view, i2);
        if (this.x) {
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }
}
