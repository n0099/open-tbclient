package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.d.a;
import d.a.o0.a0.b;
import java.util.ArrayList;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes4.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21038e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21039f;

    /* renamed from: g  reason: collision with root package name */
    public final int f21040g;

    /* renamed from: h  reason: collision with root package name */
    public final int f21041h;

    /* renamed from: i  reason: collision with root package name */
    public final int f21042i;
    public ArrayList<TbImageView> j;
    public int k;
    public float l;
    public int m;
    public View n;

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

    @Override // d.a.o0.a0.b
    public void a(a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
            b(str);
        }
    }

    public final void b(String str) {
        View view;
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (view = this.n) == null || (headImageView = (HeadImageView) view.findViewWithTag(str)) == null) {
            return;
        }
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
                    paddingLeft += childAt.getMeasuredWidth() + this.f21040g;
                    if (i7 != 0) {
                        paddingTop += childAt.getMeasuredHeight() + this.f21040g;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int childCount = getChildCount();
            int i5 = i4 - (this.f21039f * 2);
            int i6 = (int) ((((i5 - this.f21040g) / 2.0f) * this.l) + 0.5f);
            for (int i7 = 0; i7 < childCount; i7++) {
                getChildAt(i7).measure(((i5 - this.f21040g) / 2) + 1073741824, 1073741824 + i6);
            }
            int i8 = this.m / 2;
            setMeasuredDimension(i4, (i6 * i8) + ((i8 - 1) * this.f21040g) + this.f21042i);
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
        this.j = new ArrayList<>(4);
        this.k = 0;
        this.l = 0.62222224f;
        this.m = 0;
        this.n = null;
        this.f21038e = context;
        this.f21041h = l.k(context);
        this.f21039f = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.f21040g = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.f21042i = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.j.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        int i4 = this.f21041h;
        int i5 = this.f21039f;
        this.k = ((i4 - (i5 * 2)) - this.f21040g) / 2;
        setPadding(i5, 0, i5, 0);
    }
}
