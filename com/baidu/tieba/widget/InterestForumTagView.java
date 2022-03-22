package com.baidu.tieba.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class InterestForumTagView extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public SymbolEMTextView f37261b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37262c;

    /* renamed from: d  reason: collision with root package name */
    public SelectForumData f37263d;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterestForumTagView f37264b;

        public a(InterestForumTagView interestForumTagView, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestForumTagView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37264b = interestForumTagView;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = this.a) == null) {
                return;
            }
            bVar.a(this.f37264b.f37263d);
        }
    }

    /* loaded from: classes6.dex */
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

    public void b(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || selectForumData == null || getContext() == null) {
            return;
        }
        this.f37263d = selectForumData;
        SymbolEMTextView symbolEMTextView = this.f37261b;
        if (symbolEMTextView != null) {
            symbolEMTextView.setText(getContext().getString(R.string.obfuscated_res_0x7f0f08f1, selectForumData.forumName));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int f2 = n.f(getContext(), R.dimen.M_W_X004);
            int f3 = n.f(getContext(), R.dimen.M_H_X002);
            setPadding(f2, f3, 0, f3);
            setOrientation(0);
            setGravity(16);
            SymbolEMTextView symbolEMTextView = new SymbolEMTextView(getContext());
            this.f37261b = symbolEMTextView;
            symbolEMTextView.setMaxLines(1);
            this.f37261b.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int f4 = n.f(getContext(), R.dimen.tbds5);
            layoutParams.setMargins(0, n.f(getContext(), R.dimen.tbds3), f4, 0);
            addView(this.f37261b, layoutParams);
            this.f37262c = new ImageView(getContext());
            int f5 = n.f(getContext(), R.dimen.tbds42);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(f5, f5);
            layoutParams2.setMargins(0, 0, f4 * 3, 0);
            addView(this.f37262c, layoutParams2);
            setClickable(true);
        }
    }

    public void d(float f2) {
        SymbolEMTextView symbolEMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) || (symbolEMTextView = this.f37261b) == null) {
            return;
        }
        symbolEMTextView.setMaxWidth((int) (f2 - this.a));
    }

    public int getInitialMeasuredWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.a;
            SymbolEMTextView symbolEMTextView = this.f37261b;
            return symbolEMTextView != null ? i + n.D(symbolEMTextView.getPaint(), this.f37261b.getText().toString()).right : i;
        }
        return invokeV.intValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            SymbolEMTextView symbolEMTextView = this.f37261b;
            if (symbolEMTextView != null) {
                c d2 = c.d(symbolEMTextView);
                d2.z(R.dimen.T_X09);
                d2.v(R.color.CAM_X0107);
                d2.w(R.dimen.tbds0);
                d2.A(R.string.F_X01);
            }
            ImageView imageView = this.f37262c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            }
            c d3 = c.d(this);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0202);
        }
    }

    public void setCloseListener(b bVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (imageView = this.f37262c) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestForumTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = n.f(getContext(), R.dimen.M_W_X004) + n.f(getContext(), R.dimen.M_W_X013);
        c();
    }
}
