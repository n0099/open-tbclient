package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.t0.f2.c.k.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class CategoryView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47619e;

    /* renamed from: f  reason: collision with root package name */
    public View f47620f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47621g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47622h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f47623i;

    /* renamed from: j  reason: collision with root package name */
    public d f47624j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f47625k;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CategoryView f47626e;

        public a(CategoryView categoryView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {categoryView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47626e = categoryView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f47626e.f47624j == null || StringUtils.isNull(this.f47626e.f47624j.d()) || StringUtils.isNull(this.f47626e.f47624j.c())) {
                return;
            }
            int b2 = this.f47626e.f47624j.b();
            if (b2 == 1) {
                TiebaStatic.log("c10441");
            } else if (b2 == 2) {
                TiebaStatic.log("c10443");
            } else if (b2 == 3) {
                TiebaStatic.log("c10449");
            }
            MemberCenterStatic.a((TbPageContext) j.a(this.f47626e.f47619e), new String[]{this.f47626e.f47624j.d()});
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47625k = new a(this);
        this.f47619e = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f47619e).inflate(R.layout.index_category, this);
            this.f47620f = inflate;
            this.f47621g = (TextView) inflate.findViewById(R.id.class_name);
            this.f47622h = (TextView) this.f47620f.findViewById(R.id.sprend_name);
            this.f47623i = (ImageView) this.f47620f.findViewById(R.id.spread_icon);
            this.f47620f.setOnClickListener(this.f47625k);
            this.f47623i.setOnClickListener(this.f47625k);
        }
    }

    public void fillView(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f47624j = dVar;
        this.f47621g.setText(dVar.a());
        if (StringUtils.isNull(dVar.d())) {
            this.f47623i.setVisibility(8);
            this.f47622h.setVisibility(8);
            return;
        }
        if (StringUtils.isNull(dVar.c())) {
            this.f47622h.setVisibility(8);
        } else {
            this.f47622h.setVisibility(0);
            this.f47622h.setText(dVar.c());
        }
        this.f47623i.setVisibility(0);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a((TbPageContext) j.a(this.f47619e), this.f47620f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryView(Context context, AttributeSet attributeSet) {
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
        this.f47625k = new a(this);
        this.f47619e = context;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47625k = new a(this);
        this.f47619e = context;
        c();
    }
}
