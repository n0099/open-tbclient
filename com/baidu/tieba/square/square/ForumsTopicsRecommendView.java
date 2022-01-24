package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.c0.b;
import c.a.s0.s.q.b2;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes13.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODULE_NAME = "forum_topics_recommend";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48031e;

    /* renamed from: f  reason: collision with root package name */
    public final int f48032f;

    /* renamed from: g  reason: collision with root package name */
    public final int f48033g;

    /* renamed from: h  reason: collision with root package name */
    public final int f48034h;

    /* renamed from: i  reason: collision with root package name */
    public final int f48035i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<TbImageView> f48036j;
    public int k;
    public int l;
    public float m;
    public int n;
    public ArrayList<b2> o;
    public View p;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b2 f48037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48038f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48039g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumsTopicsRecommendView f48040h;

        public a(ForumsTopicsRecommendView forumsTopicsRecommendView, b2 b2Var, int i2, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumsTopicsRecommendView, b2Var, Integer.valueOf(i2), tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48040h = forumsTopicsRecommendView;
            this.f48037e = b2Var;
            this.f48038f = i2;
            this.f48039g = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f48039g, new String[]{this.f48037e.b(), null, SingleSquareActivityConfig.makeStatisticsParam(ForumsTopicsRecommendView.MODULE_NAME, String.valueOf(this.f48038f))});
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForumsTopicsRecommendView(Context context) {
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

    public final void a(TbPageContext<?> tbPageContext, ArrayList<b2> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, arrayList) == null) {
            int size = arrayList.size();
            this.n = size;
            requestLayout();
            for (int i2 = 0; i2 < size; i2++) {
                TbImageView tbImageView = this.f48036j.get(i2);
                b2 b2Var = arrayList.get(i2);
                tbImageView.setVisibility(0);
                tbImageView.setTag(b2Var.a());
                tbImageView.setOnClickListener(new a(this, b2Var, i2, tbPageContext));
            }
        }
    }

    public final ArrayList<b2> b(ArrayList<b2> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            if (arrayList != null) {
                int size = (arrayList.size() / 2) * 2;
                if (size > 4) {
                    size = 4;
                }
                if (size > 0) {
                    return new ArrayList<>(arrayList.subList(0, size));
                }
                return null;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void c(String str) {
        View view;
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (view = this.p) == null || (headImageView = (HeadImageView) view.findViewWithTag(str)) == null) {
            return;
        }
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.invalidate();
    }

    public void cancelLoadImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.a.s0.c0.b
    public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, aVar, str, z) == null) {
            c(str);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            Iterator<TbImageView> it = this.f48036j.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    int i7 = i6 % 2;
                    if (i7 == 0) {
                        paddingLeft = getPaddingLeft();
                    }
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft += childAt.getMeasuredWidth() + this.f48033g;
                    if (i7 != 0) {
                        paddingTop += childAt.getMeasuredHeight() + this.f48033g;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int childCount = getChildCount();
            int i5 = i4 - (this.f48032f * 2);
            int i6 = (int) ((((i5 - this.f48033g) / 2.0f) * this.m) + 0.5f);
            for (int i7 = 0; i7 < childCount; i7++) {
                getChildAt(i7).measure(((i5 - this.f48033g) / 2) + 1073741824, 1073741824 + i6);
            }
            int i8 = this.n / 2;
            setMeasuredDimension(i4, (i6 * i8) + ((i8 - 1) * this.f48033g) + this.f48035i);
        }
    }

    public boolean setData(TbPageContext<?> tbPageContext, ArrayList<b2> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, arrayList)) == null) {
            this.o = b(arrayList);
            Iterator<TbImageView> it = this.f48036j.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
            if (this.o != null) {
                setVisibility(0);
                a(tbPageContext, this.o);
                return true;
            }
            setVisibility(8);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void startLoadImage(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, view, i2, i3) == null) {
            this.p = view;
            try {
                if (this.o == null || this.o.size() <= 0) {
                    return;
                }
                for (int i4 = 0; i4 < this.o.size(); i4++) {
                    String a2 = this.o.get(i4).a();
                    if (a2 != null && a2.length() > 0 && view != null) {
                        HeadImageView headImageView = (HeadImageView) this.p.findViewWithTag(a2);
                        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER);
                        headImageView.startLoad(a2, 10, this.k, this.l, false);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
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
        this.f48036j = new ArrayList<>(4);
        this.k = 0;
        this.l = 0;
        this.m = 0.62222224f;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.f48031e = context;
        this.f48034h = n.k(context);
        this.f48032f = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.f48033g = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.f48035i = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.f48036j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.f48036j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.f48036j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.f48036j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        int i4 = this.f48034h;
        int i5 = this.f48032f;
        int i6 = ((i4 - (i5 * 2)) - this.f48033g) / 2;
        this.k = i6;
        this.l = (int) (i6 * this.m);
        setPadding(i5, 0, i5, 0);
    }
}
