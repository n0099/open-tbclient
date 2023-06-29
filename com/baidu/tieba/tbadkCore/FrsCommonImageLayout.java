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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.l9;
import com.baidu.tieba.mg;
import com.baidu.tieba.ng;
import com.baidu.tieba.r9;
import com.baidu.tieba.vg;
import com.baidu.tieba.xi;
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
    public Bitmap C;
    public Rect D;
    public Rect E;
    public int a;
    public d b;
    public boolean c;
    public MediaData[] d;
    public final Context e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public ThreadData n;
    public String o;
    public String p;
    public String q;
    public mg<TbImageView> r;
    public View.OnClickListener s;
    public boolean t;
    public l9<?> u;
    public int v;
    public int w;
    public Paint x;
    public String y;
    public int z;

    /* loaded from: classes7.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes7.dex */
    public interface e {
        mg<TbImageView> b0();
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
        }
    }

    public void setImageFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsCommonImageLayout a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        public a(FrsCommonImageLayout frsCommonImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsCommonImageLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) && (view3 instanceof TbImageView) && this.a.r != null) {
                this.a.r.e((TbImageView) view3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ng<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a);
                tbImageView.setSupportNoImage(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderWidth(1);
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ FrsCommonImageLayout b;

        public c(FrsCommonImageLayout frsCommonImageLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonImageLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsCommonImageLayout;
            this.a = i;
        }

        public /* synthetic */ c(FrsCommonImageLayout frsCommonImageLayout, int i, a aVar) {
            this(frsCommonImageLayout, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            MediaData[] mediaDataArr;
            String str;
            Context pageActivity;
            MediaData[] mediaDataArr2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.b != null) {
                    this.b.b.a(this.a);
                } else if (this.b.d != null && this.a < this.b.d.length) {
                    if (this.b.d[this.a].getType() == 5) {
                        if (this.b.u instanceof TbPageContext) {
                            UrlManager urlManager = UrlManager.getInstance();
                            FrsCommonImageLayout frsCommonImageLayout = this.b;
                            urlManager.dealOneLink((TbPageContext) frsCommonImageLayout.u, new String[]{frsCommonImageLayout.d[this.a].getVideoUrl()});
                        }
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        for (MediaData mediaData : this.b.d) {
                            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                                arrayList.add(mediaData.getSrc_pic());
                                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (this.b.c) {
                                        i = 13;
                                    } else {
                                        i = 14;
                                    }
                                    imageUrlData.urlType = i;
                                    String picUrl = mediaData.getPicUrl();
                                    imageUrlData.imageUrl = picUrl;
                                    imageUrlData.urlThumbType = imageUrlData.urlType;
                                    imageUrlData.imageThumbUrl = picUrl;
                                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                                    imageUrlData.originalSize = mediaData.getOriginalSize();
                                    imageUrlData.isLongPic = mediaData.isLongPic();
                                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                                    imageUrlData.threadId = vg.g(this.b.q, -1L);
                                    imageUrlData.postId = mediaData.getPostId();
                                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                                }
                            }
                        }
                        if (arrayList.size() <= 0) {
                            for (MediaData mediaData2 : this.b.d) {
                                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                                    arrayList.add(mediaData2.getPicUrl());
                                }
                            }
                        }
                        if (this.b.l > this.b.k && this.a == this.b.k - 1) {
                            PbActivityConfig addLocateParam = new PbActivityConfig(this.b.e).createFromThreadCfg(this.b.n, this.b.p, null, 18003, true, false, false).addLocateParam("");
                            addLocateParam.setForumId(String.valueOf(this.b.n.getFid()));
                            addLocateParam.setForumName(this.b.n.getForum_name());
                            addLocateParam.setStartFrom(3);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
                        } else {
                            Rect rect = new Rect();
                            view2.getGlobalVisibleRect(rect);
                            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                            builder.A(arrayList);
                            builder.E(this.a);
                            builder.C(this.b.p);
                            builder.B(this.b.o);
                            builder.R(this.b.q);
                            builder.F(this.b.c);
                            if (arrayList.size() <= 0) {
                                str = "";
                            } else {
                                str = arrayList.get(0);
                            }
                            builder.M(str);
                            builder.I(true);
                            builder.y(concurrentHashMap);
                            builder.K(true);
                            builder.Q(this.b.n);
                            builder.O(this.b.n.getFirst_post_id());
                            builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                            FrsCommonImageLayout frsCommonImageLayout2 = this.b;
                            l9<?> l9Var = frsCommonImageLayout2.u;
                            if (l9Var == null) {
                                pageActivity = frsCommonImageLayout2.e;
                            } else {
                                pageActivity = l9Var.getPageActivity();
                            }
                            ImageViewerConfig x = builder.x(pageActivity);
                            x.getIntent().putExtra("from", "frs");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x));
                            TiebaStatic.eventStat(this.b.e, "pic_frs", "");
                            HistoryMessage historyMessage = new HistoryMessage();
                            historyMessage.Activity = (TbPageContext) r9.a(this.b.e);
                            historyMessage.threadId = this.b.n.getId();
                            historyMessage.threadName = this.b.n.getTitle();
                            historyMessage.forumName = this.b.n.getForum_name();
                            historyMessage.postID = this.b.n.getFirstPostId();
                            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
                        }
                    }
                } else {
                    return;
                }
                if (this.b.s != null) {
                    this.b.s.onClick(view2);
                }
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) && (mediaDataArr = this.d) != null && mediaDataArr.length > 0) {
            int childCount = getChildCount();
            this.h = childCount;
            if (childCount == 0) {
                return;
            }
            long drawingTime = getDrawingTime();
            for (int i = 0; i < this.h; i++) {
                drawChild(canvas, (TbImageView) getChildAt(i), drawingTime);
            }
            if (o()) {
                n(canvas);
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.c = false;
        this.f = false;
        this.g = 0;
        this.i = 2;
        this.j = 0;
        this.k = 3;
        this.m = false;
        this.r = null;
        this.t = true;
        this.e = context;
        this.i = xi.d(context, 2);
        this.g = xi.d(this.e, this.j);
        setOnHierarchyChangeListener(new a(this));
        this.v = xi.d(this.e, 50.0f);
        this.w = xi.d(this.e, 23.0f);
        Paint paint = new Paint();
        this.x = paint;
        paint.setDither(true);
        this.x.setFilterBitmap(true);
        Resources resources = getResources();
        String str = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.l + resources.getString(R.string.frs_item_common_image_canvas_text2);
        this.y = str;
        this.z = ((str.length() + 2) * xi.d(this.e, 10.0f)) / 2;
        this.A = xi.d(this.e, 10.0f);
        Paint paint2 = new Paint(257);
        this.B = paint2;
        paint2.setColor(-1);
        this.B.setTextSize(resources.getDimension(R.dimen.obfuscated_res_0x7f0701d5));
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_look_photo_2);
        this.C = cashBitmap;
        if (cashBitmap != null) {
            this.D = new Rect(0, 0, this.C.getWidth(), this.C.getHeight());
            this.E = new Rect(getWidth() - this.v, getHeight() - this.w, getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.addView(view2);
            if (this.t) {
                view2.setOnClickListener(new c(this, getChildCount() - 1, null));
            }
        }
    }

    public void setAfterChildClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setChildrenClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.t = z;
        }
    }

    public void setDrawNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.m = z;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.c = z;
        }
    }

    public void setItemSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.g = xi.d(this.e, i);
        }
    }

    public void setNormalShowCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (i <= 0) {
                i = 1;
            }
            this.k = i;
        }
    }

    public void setOnChildClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void setPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.i = i;
        }
    }

    public void setShowBig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f = z;
        }
    }

    public static mg<TbImageView> m(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, context, i)) == null) {
            return new mg<>(new b(context), i, 0);
        }
        return (mg) invokeLI.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            super.addView(view2, i);
            if (this.t) {
                view2.setOnClickListener(new c(this, getChildCount() - 1, null));
            }
        }
    }

    public int getItemSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int getNormalShowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public int getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.l > 3 && this.m) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            p();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && getChildCount() > 0) {
            removeAllViews();
        }
    }

    public final void n(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            Bitmap bitmap = this.C;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_look_photo_2);
                this.C = cashBitmap;
                if (cashBitmap != null) {
                    this.D = new Rect(0, 0, this.C.getWidth(), this.C.getHeight());
                    this.E = new Rect(getWidth() - this.v, getHeight() - this.w, getWidth(), getHeight());
                }
            }
            Bitmap bitmap2 = this.C;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.D.set(0, 0, this.C.getWidth(), this.C.getHeight());
                this.E.set(getWidth() - this.v, getHeight() - this.w, getWidth(), getHeight());
                canvas.drawBitmap(this.C, this.D, this.E, this.x);
            }
            String str = this.y;
            int width = getWidth();
            int i = this.v;
            canvas.drawText(str, (width - i) + ((i - this.z) / 2), getHeight() + ((this.A - this.w) / 2), this.B);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.h == 0) {
                return;
            }
            int i5 = 0;
            while (i5 < this.h) {
                TbImageView tbImageView = (TbImageView) getChildAt(i5);
                int i6 = this.i;
                int i7 = this.g;
                int i8 = (i6 * i5) + (i7 * i5);
                int i9 = i6 * i5;
                i5++;
                int i10 = i9 + (i7 * i5);
                if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                    tbImageView.layout(i8, 0, i10, i4 - i2);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i4 = this.h;
            if (i4 == 0) {
                setMeasuredDimension(0, 0);
                return;
            }
            int i5 = this.g;
            int i6 = this.i;
            int i7 = (i5 * i4) + ((i4 - 1) * i6);
            int i8 = (i3 - (i6 * (i4 - 1))) / this.k;
            if (i5 != 0 && i7 <= i3) {
                i3 = i7;
            } else {
                this.g = i8;
            }
            setMeasuredDimension(i3, this.g);
            for (int i9 = 0; i9 < this.h; i9++) {
                TbImageView tbImageView = (TbImageView) getChildAt(i9);
                if (tbImageView != null && tbImageView.getLayoutParams() != null) {
                    int i10 = this.g;
                    measureChild(tbImageView, i10, i10);
                }
            }
        }
    }

    public final void q(TbImageView tbImageView, MediaData mediaData, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048589, this, tbImageView, mediaData, i) != null) || tbImageView == null) {
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
        if (this.c) {
            i2 = 13;
        } else {
            i2 = 14;
        }
        tbImageView.N(picUrl, i2, false);
    }

    public void setData(l9<?> l9Var, MediaData[] mediaDataArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, l9Var, mediaDataArr, i) == null) {
            this.d = mediaDataArr;
            this.l = i;
            this.u = l9Var;
            Resources resources = getResources();
            this.y = resources.getString(R.string.frs_item_common_image_canvas_text1) + this.l + resources.getString(R.string.frs_item_common_image_canvas_text2);
            if (this.r == null && (l9Var.getOrignalPage() instanceof e)) {
                this.r = ((e) l9Var.getOrignalPage()).b0();
            }
            if (this.r == null) {
                return;
            }
            MediaData[] mediaDataArr2 = this.d;
            if (mediaDataArr2 != null && mediaDataArr2.length > 0) {
                int length = mediaDataArr2.length;
                this.h = length;
                int i2 = this.k;
                if (length > i2) {
                    this.h = i2;
                }
                int childCount = getChildCount();
                int i3 = this.h;
                if (i3 > childCount) {
                    int i4 = i3 - childCount;
                    int i5 = 0;
                    while (i5 < i4) {
                        TbImageView b2 = this.r.b();
                        StringBuilder sb = new StringBuilder();
                        sb.append(l9Var.getString(R.string.editor_image));
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
                for (int i6 = 0; i6 < childCount2 && i6 < this.d.length; i6++) {
                    TbImageView tbImageView = (TbImageView) getChildAt(i6);
                    if (this.a != TbadkCoreApplication.getInst().getSkinType() && tbImageView != null) {
                        tbImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                    }
                    this.a = TbadkCoreApplication.getInst().getSkinType();
                    q(tbImageView, this.d[i6], i6);
                }
                return;
            }
            requestLayout();
        }
    }

    public void setThreadData(ThreadData threadData, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, threadData, str, str2, str3) == null) {
            this.n = threadData;
            this.p = str;
            this.o = str2;
            this.q = str3;
        }
    }
}
