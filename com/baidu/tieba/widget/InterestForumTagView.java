package com.baidu.tieba.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.d.f.p.m;
import c.a.l.q;
import c.a.r0.s.v.c;
import c.a.s0.y2.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class InterestForumTagView extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f51296e;

    /* renamed from: f  reason: collision with root package name */
    public SymbolEMTextView f51297f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f51298g;

    /* renamed from: h  reason: collision with root package name */
    public SelectForumData f51299h;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ InterestForumTagView f51301f;

        public a(InterestForumTagView interestForumTagView, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestForumTagView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51301f = interestForumTagView;
            this.f51300e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = this.f51300e) == null) {
                return;
            }
            bVar.a(this.f51301f.f51299h);
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(SelectForumData selectForumData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagView(Context context) {
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int f2 = m.f(getContext(), c.a.s0.y2.b.M_W_X004);
            int f3 = m.f(getContext(), c.a.s0.y2.b.M_H_X002);
            setPadding(f2, f3, 0, f3);
            setOrientation(0);
            setGravity(16);
            SymbolEMTextView symbolEMTextView = new SymbolEMTextView(getContext());
            this.f51297f = symbolEMTextView;
            symbolEMTextView.setMaxLines(1);
            this.f51297f.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int f4 = m.f(getContext(), c.a.s0.y2.b.tbds5);
            layoutParams.setMargins(0, m.f(getContext(), c.a.s0.y2.b.tbds3), f4, 0);
            addView(this.f51297f, layoutParams);
            this.f51298g = new ImageView(getContext());
            int f5 = m.f(getContext(), c.a.s0.y2.b.tbds42);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(f5, f5);
            layoutParams2.setMargins(0, 0, f4 * 3, 0);
            addView(this.f51298g, layoutParams2);
            setClickable(true);
        }
    }

    public void bindForum(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, selectForumData) == null) || selectForumData == null || getContext() == null) {
            return;
        }
        this.f51299h = selectForumData;
        SymbolEMTextView symbolEMTextView = this.f51297f;
        if (symbolEMTextView != null) {
            symbolEMTextView.setText(getContext().getString(g.interest_forum_name, selectForumData.forumName));
        }
    }

    public int getInitialMeasuredWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f51296e;
            SymbolEMTextView symbolEMTextView = this.f51297f;
            return symbolEMTextView != null ? i2 + m.D(symbolEMTextView.getPaint(), this.f51297f.getText().toString()).right : i2;
        }
        return invokeV.intValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            SymbolEMTextView symbolEMTextView = this.f51297f;
            if (symbolEMTextView != null) {
                c d2 = c.d(symbolEMTextView);
                d2.z(c.a.s0.y2.b.T_X09);
                d2.v(c.a.s0.y2.a.CAM_X0107);
                d2.w(c.a.s0.y2.b.tbds0);
                d2.A(g.F_X01);
            }
            ImageView imageView = this.f51298g;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, c.a.s0.y2.c.icon_pure_card_close22, c.a.s0.y2.a.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            }
            c d3 = c.d(this);
            d3.n(g.J_X01);
            d3.f(c.a.s0.y2.a.CAM_X0202);
        }
    }

    public void resetNameWithMaxWidth(float f2) {
        SymbolEMTextView symbolEMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (symbolEMTextView = this.f51297f) == null) {
            return;
        }
        symbolEMTextView.setMaxWidth((int) (f2 - this.f51296e));
    }

    public void setCloseListener(b bVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (imageView = this.f51298g) == null) {
            return;
        }
        imageView.setOnClickListener(new a(this, bVar));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestForumTagView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51296e = m.f(getContext(), c.a.s0.y2.b.M_W_X004) + m.f(getContext(), c.a.s0.y2.b.M_W_X013);
        b();
    }
}
