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
import d.b.b.a.f;
import d.b.b.a.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
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
    public int f21300e;

    /* renamed from: f  reason: collision with root package name */
    public d f21301f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21302g;

    /* renamed from: h  reason: collision with root package name */
    public MediaData[] f21303h;
    public final Context i;
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
    public d.b.b.e.k.b<TbImageView> v;
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
    public static class b implements d.b.b.e.k.c<TbImageView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f21305a;

        public b(Context context) {
            this.f21305a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setBackgroundResource(0);
            tbImageView.setImageDrawable(null);
            tbImageView.setTag(null);
            tbImageView.setOnClickListener(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(this.f21305a);
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
        public final int f21306e;

        public /* synthetic */ c(FrsCommonImageLayout frsCommonImageLayout, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaData[] mediaDataArr;
            MediaData[] mediaDataArr2;
            if (FrsCommonImageLayout.this.f21301f != null) {
                FrsCommonImageLayout.this.f21301f.a(this.f21306e);
            } else if (FrsCommonImageLayout.this.f21303h == null || this.f21306e >= FrsCommonImageLayout.this.f21303h.length) {
                return;
            } else {
                if (FrsCommonImageLayout.this.f21303h[this.f21306e].getType() == 5) {
                    if (FrsCommonImageLayout.this.y instanceof TbPageContext) {
                        UrlManager urlManager = UrlManager.getInstance();
                        FrsCommonImageLayout frsCommonImageLayout = FrsCommonImageLayout.this;
                        urlManager.dealOneLink((TbPageContext) frsCommonImageLayout.y, new String[]{frsCommonImageLayout.f21303h[this.f21306e].getVideoUrl()});
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    for (MediaData mediaData : FrsCommonImageLayout.this.f21303h) {
                        if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                            arrayList.add(mediaData.getSrc_pic());
                            if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.urlType = FrsCommonImageLayout.this.f21302g ? 13 : 14;
                                imageUrlData.imageUrl = mediaData.getPicUrl();
                                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                                imageUrlData.originalSize = mediaData.getOriginalSize();
                                imageUrlData.isLongPic = mediaData.isLongPic();
                                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                                imageUrlData.threadId = d.b.b.e.m.b.f(FrsCommonImageLayout.this.u, -1L);
                                imageUrlData.postId = mediaData.getPostId();
                                concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                            }
                        }
                    }
                    if (arrayList.size() <= 0) {
                        for (MediaData mediaData2 : FrsCommonImageLayout.this.f21303h) {
                            if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                arrayList.add(mediaData2.getPicUrl());
                            }
                        }
                    }
                    if (FrsCommonImageLayout.this.p > FrsCommonImageLayout.this.o && this.f21306e == FrsCommonImageLayout.this.o - 1) {
                        PbActivityConfig addLocateParam = new PbActivityConfig(FrsCommonImageLayout.this.i).createFromThreadCfg(FrsCommonImageLayout.this.r, FrsCommonImageLayout.this.t, null, 18003, true, false, false).addLocateParam("");
                        addLocateParam.setForumId(String.valueOf(FrsCommonImageLayout.this.r.c0()));
                        addLocateParam.setForumName(FrsCommonImageLayout.this.r.i0());
                        addLocateParam.setStartFrom(3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
                    } else {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(this.f21306e);
                        bVar.z(FrsCommonImageLayout.this.t);
                        bVar.y(FrsCommonImageLayout.this.s);
                        bVar.P(FrsCommonImageLayout.this.u);
                        bVar.C(FrsCommonImageLayout.this.f21302g);
                        bVar.K(arrayList.size() > 0 ? arrayList.get(0) : "");
                        bVar.G(true);
                        bVar.w(concurrentHashMap);
                        bVar.I(true);
                        bVar.O(FrsCommonImageLayout.this.r);
                        bVar.N(rect, UtilHelper.fixedDrawableRect(rect, view));
                        FrsCommonImageLayout frsCommonImageLayout2 = FrsCommonImageLayout.this;
                        f<?> fVar = frsCommonImageLayout2.y;
                        ImageViewerConfig v = bVar.v(fVar == null ? frsCommonImageLayout2.i : fVar.getPageActivity());
                        v.getIntent().putExtra("from", "frs");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
                        TiebaStatic.eventStat(FrsCommonImageLayout.this.i, "pic_frs", "");
                        HistoryMessage historyMessage = new HistoryMessage();
                        historyMessage.Activity = (TbPageContext) j.a(FrsCommonImageLayout.this.i);
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

        public c(int i) {
            this.f21306e = i;
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public interface e {
        d.b.b.e.k.b<TbImageView> getFrsCommonImageLayoutPool();
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public static d.b.b.e.k.b<TbImageView> m(Context context, int i) {
        return new d.b.b.e.k.b<>(new b(context), i, 0);
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
        MediaData[] mediaDataArr = this.f21303h;
        if (mediaDataArr == null || mediaDataArr.length <= 0) {
            return;
        }
        int childCount = getChildCount();
        this.l = childCount;
        if (childCount == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        for (int i = 0; i < this.l; i++) {
            drawChild(canvas, (TbImageView) getChildAt(i), drawingTime);
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
        int i = this.z;
        canvas.drawText(str, (width - i) + ((i - this.D) / 2), getHeight() + ((this.E - this.A) / 2), this.F);
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.l == 0) {
            return;
        }
        int i5 = 0;
        while (i5 < this.l) {
            TbImageView tbImageView = (TbImageView) getChildAt(i5);
            int i6 = this.m;
            int i7 = this.k;
            int i8 = (i6 * i5) + (i7 * i5);
            int i9 = i6 * i5;
            i5++;
            int i10 = i9 + (i7 * i5);
            if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                tbImageView.layout(i8, 0, i10, i4 - i2);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = this.l;
        if (i4 == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i5 = this.k;
        int i6 = this.m;
        int i7 = (i5 * i4) + ((i4 - 1) * i6);
        int i8 = (i3 - (i6 * (i4 - 1))) / this.o;
        if (i5 == 0 || i7 > i3) {
            this.k = i8;
        } else {
            i3 = i7;
        }
        setMeasuredDimension(i3, this.k);
        for (int i9 = 0; i9 < this.l; i9++) {
            TbImageView tbImageView = (TbImageView) getChildAt(i9);
            if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                int i10 = this.k;
                measureChild(tbImageView, i10, i10);
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

    public final void q(TbImageView tbImageView, MediaData mediaData, int i) {
        if (tbImageView == null) {
            return;
        }
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        String picUrl = mediaData.getPicUrl();
        if (mediaData.getType() == 5) {
            picUrl = null;
            tbImageView.setDefaultResource(R.drawable.pic_video);
        }
        if (o() && i == getChildCount() - 1) {
            tbImageView.setGifIconSupport(false);
            tbImageView.setLongIconSupport(false);
        } else {
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
        }
        tbImageView.setIsLongPic(mediaData.isLongPic());
        tbImageView.W(picUrl, this.f21302g ? 13 : 14, false);
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    public void setChildrenClickable(boolean z) {
        this.x = z;
    }

    public void setData(f<?> fVar, MediaData[] mediaDataArr, int i) {
        this.f21303h = mediaDataArr;
        this.p = i;
        this.y = fVar;
        Resources resources = getResources();
        this.C = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.p + resources.getString(R.string.frs_item_common_image_canvas_text2);
        if (this.v == null && (fVar.getOrignalPage() instanceof e)) {
            this.v = ((e) fVar.getOrignalPage()).getFrsCommonImageLayoutPool();
        }
        if (this.v == null) {
            return;
        }
        MediaData[] mediaDataArr2 = this.f21303h;
        if (mediaDataArr2 != null && mediaDataArr2.length > 0) {
            int length = mediaDataArr2.length;
            this.l = length;
            int i2 = this.o;
            if (length > i2) {
                this.l = i2;
            }
            int childCount = getChildCount();
            int i3 = this.l;
            if (i3 > childCount) {
                int i4 = i3 - childCount;
                int i5 = 0;
                while (i5 < i4) {
                    TbImageView b2 = this.v.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(fVar.getString(R.string.editor_image));
                    i5++;
                    sb.append(i5);
                    b2.setContentDescription(sb.toString());
                    if (b2 != null) {
                        addView(b2);
                    }
                }
            } else if (i3 < childCount) {
                removeViews(i3, childCount - i3);
            }
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2 && i6 < this.f21303h.length; i6++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i6);
                if (this.f21300e != TbadkCoreApplication.getInst().getSkinType() && tbImageView != null) {
                    tbImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                }
                this.f21300e = TbadkCoreApplication.getInst().getSkinType();
                q(tbImageView, this.f21303h[i6], i6);
            }
            return;
        }
        requestLayout();
    }

    public void setDrawNum(boolean z) {
        this.q = z;
    }

    public void setFromCDN(boolean z) {
        this.f21302g = z;
    }

    public void setImageFrom(String str) {
    }

    public void setItemSize(int i) {
        this.k = l.e(this.i, i);
    }

    public void setNormalShowCount(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.o = i;
    }

    public void setOnChildClickListener(d dVar) {
        this.f21301f = dVar;
    }

    public void setPadding(int i) {
        this.m = i;
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
        this.f21300e = 3;
        this.f21302g = false;
        this.j = false;
        this.k = 0;
        this.m = 2;
        this.n = 0;
        this.o = 3;
        this.q = false;
        this.v = null;
        this.x = true;
        this.i = context;
        this.m = l.e(context, 2);
        this.k = l.e(this.i, this.n);
        setOnHierarchyChangeListener(new a());
        this.z = l.e(this.i, 50.0f);
        this.A = l.e(this.i, 23.0f);
        Paint paint = new Paint();
        this.B = paint;
        paint.setDither(true);
        this.B.setFilterBitmap(true);
        Resources resources = getResources();
        String str = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.p + resources.getString(R.string.frs_item_common_image_canvas_text2);
        this.C = str;
        this.D = ((str.length() + 2) * l.e(this.i, 10.0f)) / 2;
        this.E = l.e(this.i, 10.0f);
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
    public void addView(View view, int i) {
        super.addView(view, i);
        if (this.x) {
            view.setOnClickListener(new c(this, getChildCount() - 1, null));
        }
    }
}
