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
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.o0.s.q.c2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes7.dex */
public class FrsCommonImageLayout extends LinearLayout implements AbsListView.RecyclerListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public int f56705e;

    /* renamed from: f  reason: collision with root package name */
    public d f56706f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56707g;

    /* renamed from: h  reason: collision with root package name */
    public MediaData[] f56708h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f56709i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56710j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public c2 r;
    public String s;
    public String t;
    public String u;
    public c.a.e.e.k.b<TbImageView> v;
    public View.OnClickListener w;
    public boolean x;
    public f<?> y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsCommonImageLayout f56711e;

        public a(FrsCommonImageLayout frsCommonImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56711e = frsCommonImageLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof TbImageView) && this.f56711e.v != null) {
                this.f56711e.v.e((TbImageView) view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements c.a.e.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56712a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56712a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.f56712a);
                tbImageView.setSupportNoImage(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderWidth(1);
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f56713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsCommonImageLayout f56714f;

        public /* synthetic */ c(FrsCommonImageLayout frsCommonImageLayout, int i2, a aVar) {
            this(frsCommonImageLayout, i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaData[] mediaDataArr;
            MediaData[] mediaDataArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56714f.f56706f != null) {
                    this.f56714f.f56706f.a(this.f56713e);
                } else if (this.f56714f.f56708h == null || this.f56713e >= this.f56714f.f56708h.length) {
                    return;
                } else {
                    if (this.f56714f.f56708h[this.f56713e].getType() == 5) {
                        if (this.f56714f.y instanceof TbPageContext) {
                            UrlManager urlManager = UrlManager.getInstance();
                            FrsCommonImageLayout frsCommonImageLayout = this.f56714f;
                            urlManager.dealOneLink((TbPageContext) frsCommonImageLayout.y, new String[]{frsCommonImageLayout.f56708h[this.f56713e].getVideoUrl()});
                        }
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        for (MediaData mediaData : this.f56714f.f56708h) {
                            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                                arrayList.add(mediaData.getSrc_pic());
                                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.urlType = this.f56714f.f56707g ? 13 : 14;
                                    imageUrlData.imageUrl = mediaData.getPicUrl();
                                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                                    imageUrlData.originalSize = mediaData.getOriginalSize();
                                    imageUrlData.isLongPic = mediaData.isLongPic();
                                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                                    imageUrlData.threadId = c.a.e.e.m.b.f(this.f56714f.u, -1L);
                                    imageUrlData.postId = mediaData.getPostId();
                                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                                }
                            }
                        }
                        if (arrayList.size() <= 0) {
                            for (MediaData mediaData2 : this.f56714f.f56708h) {
                                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                    arrayList.add(mediaData2.getPicUrl());
                                }
                            }
                        }
                        if (this.f56714f.p > this.f56714f.o && this.f56713e == this.f56714f.o - 1) {
                            PbActivityConfig addLocateParam = new PbActivityConfig(this.f56714f.f56709i).createFromThreadCfg(this.f56714f.r, this.f56714f.t, null, 18003, true, false, false).addLocateParam("");
                            addLocateParam.setForumId(String.valueOf(this.f56714f.r.T()));
                            addLocateParam.setForumName(this.f56714f.r.Z());
                            addLocateParam.setStartFrom(3);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
                        } else {
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(this.f56713e);
                            bVar.z(this.f56714f.t);
                            bVar.y(this.f56714f.s);
                            bVar.O(this.f56714f.u);
                            bVar.C(this.f56714f.f56707g);
                            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
                            bVar.F(true);
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.N(this.f56714f.r);
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            FrsCommonImageLayout frsCommonImageLayout2 = this.f56714f;
                            f<?> fVar = frsCommonImageLayout2.y;
                            ImageViewerConfig v = bVar.v(fVar == null ? frsCommonImageLayout2.f56709i : fVar.getPageActivity());
                            v.getIntent().putExtra("from", "frs");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
                            TiebaStatic.eventStat(this.f56714f.f56709i, "pic_frs", "");
                            HistoryMessage historyMessage = new HistoryMessage();
                            historyMessage.Activity = (TbPageContext) j.a(this.f56714f.f56709i);
                            historyMessage.threadId = this.f56714f.r.f0();
                            historyMessage.threadName = this.f56714f.r.getTitle();
                            historyMessage.forumName = this.f56714f.r.Z();
                            historyMessage.postID = this.f56714f.r.W();
                            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
                        }
                    }
                }
                if (this.f56714f.w != null) {
                    this.f56714f.w.onClick(view);
                }
            }
        }

        public c(FrsCommonImageLayout frsCommonImageLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonImageLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56714f = frsCommonImageLayout;
            this.f56713e = i2;
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes7.dex */
    public interface e {
        c.a.e.e.k.b<TbImageView> getFrsCommonImageLayoutPool();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsCommonImageLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static c.a.e.e.k.b<TbImageView> createFrsCommonIamgeLayoutPool(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2)) == null) ? new c.a.e.e.k.b<>(new b(context), i2, 0) : (c.a.e.e.k.b) invokeLI.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            super.addView(view);
            if (this.x) {
                view.setOnClickListener(new c(this, getChildCount() - 1, null));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (mediaDataArr = this.f56708h) == null || mediaDataArr.length <= 0) {
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
        if (n()) {
            m(canvas);
        }
    }

    public int getItemSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
    }

    public int getNormalShowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.intValue;
    }

    public int getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public boolean isDrawNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f56707g : invokeV.booleanValue;
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
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
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p > 3 && this.q : invokeV.booleanValue;
    }

    public final void o(TbImageView tbImageView, MediaData mediaData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048586, this, tbImageView, mediaData, i2) == null) || tbImageView == null) {
            return;
        }
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        String picUrl = mediaData.getPicUrl();
        if (mediaData.getType() == 5) {
            picUrl = null;
            tbImageView.setDefaultResource(R.drawable.pic_video);
        }
        if (n() && i2 == getChildCount() - 1) {
            tbImageView.setGifIconSupport(false);
            tbImageView.setLongIconSupport(false);
        } else {
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
        }
        tbImageView.setIsLongPic(mediaData.isLongPic());
        tbImageView.startLoad(picUrl, this.f56707g ? 13 : 14, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            reset();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
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
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getChildCount() <= 0) {
            return;
        }
        removeAllViews();
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setChildrenClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.x = z;
        }
    }

    public void setData(f<?> fVar, MediaData[] mediaDataArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, fVar, mediaDataArr, i2) == null) {
            this.f56708h = mediaDataArr;
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
            MediaData[] mediaDataArr2 = this.f56708h;
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
                for (int i7 = 0; i7 < childCount2 && i7 < this.f56708h.length; i7++) {
                    TbImageView tbImageView = (TbImageView) getChildAt(i7);
                    if (this.f56705e != TbadkCoreApplication.getInst().getSkinType() && tbImageView != null) {
                        tbImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                    }
                    this.f56705e = TbadkCoreApplication.getInst().getSkinType();
                    o(tbImageView, this.f56708h[i7], i7);
                }
                return;
            }
            requestLayout();
        }
    }

    public void setDrawNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.q = z;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f56707g = z;
        }
    }

    public void setImageFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }

    public void setItemSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.k = l.e(this.f56709i, i2);
        }
    }

    public void setNormalShowCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 1;
            }
            this.o = i2;
        }
    }

    public void setOnChildClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) {
            this.f56706f = dVar;
        }
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setShowBig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f56710j = z;
        }
    }

    public void setThreadData(c2 c2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, c2Var, str, str2, str3) == null) {
            this.r = c2Var;
            this.t = str;
            this.s = str2;
            this.u = str3;
        }
    }

    public void showImageFromNet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56705e = 3;
        this.f56707g = false;
        this.f56710j = false;
        this.k = 0;
        this.m = 2;
        this.n = 0;
        this.o = 3;
        this.q = false;
        this.v = null;
        this.x = true;
        this.f56709i = context;
        this.m = l.e(context, 2);
        this.k = l.e(this.f56709i, this.n);
        setOnHierarchyChangeListener(new a(this));
        this.z = l.e(this.f56709i, 50.0f);
        this.A = l.e(this.f56709i, 23.0f);
        Paint paint = new Paint();
        this.B = paint;
        paint.setDither(true);
        this.B.setFilterBitmap(true);
        Resources resources = getResources();
        String str = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.p + resources.getString(R.string.frs_item_common_image_canvas_text2);
        this.C = str;
        this.D = ((str.length() + 2) * l.e(this.f56709i, 10.0f)) / 2;
        this.E = l.e(this.f56709i, 10.0f);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            super.addView(view, i2);
            if (this.x) {
                view.setOnClickListener(new c(this, getChildCount() - 1, null));
            }
        }
    }
}
