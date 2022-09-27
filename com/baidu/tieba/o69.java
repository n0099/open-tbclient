package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QuestionTagChooseActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.n69;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.tieba.write.write.relevance.list.XLinearLayoutManager;
import com.baidu.tieba.write.write.tag.QuestionTagAdapter;
import com.baidu.tieba.write.write.tag.QuestionTagChooseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o69 implements ie5, no {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final NavigationBar b;
    @NonNull
    public final QuestionTagChooseActivity c;
    public LinearLayout d;
    public ImageView e;
    public EditText f;
    public NestedScrollView g;
    public ConstraintLayout h;
    public TextView i;
    public TextView j;
    public FrameLayout k;
    public BdTypeRecyclerView l;
    public PbListView m;
    public f95 n;
    public g95 o;
    public Intent p;
    public String q;
    public n69 r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public a(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p = null;
                this.a.c.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public b(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable == null ? null : editable.toString();
                if (this.a.r != null) {
                    this.a.r.i(obj);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public c(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p = new Intent();
                this.a.p.putExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, true);
                this.a.c.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements NestedScrollView.OnScrollChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public d(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{nestedScrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4) {
                return;
            }
            this.a.D();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public e(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    ej.x(this.a.c, this.a.a);
                    this.a.f.clearFocus();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements n69.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public f(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // com.baidu.tieba.n69.b
        public void a(boolean z, List<Cdo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.u();
                this.a.v();
                if (ListUtils.isEmpty(list)) {
                    this.a.l.setVisibility(8);
                    this.a.I();
                    return;
                }
                this.a.l.setVisibility(0);
                this.a.l.setData(list);
                if (!z) {
                    this.a.H();
                } else {
                    this.a.G();
                }
            }
        }

        @Override // com.baidu.tieba.n69.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    if (this.a.l.getAdapter() != null) {
                        this.a.l.getData().clear();
                        this.a.l.getAdapter().notifyDataSetChanged();
                    }
                    this.a.l.setVisibility(8);
                    this.a.K();
                } else {
                    this.a.l.setVisibility(0);
                    this.a.G();
                }
                this.a.v();
            }
        }

        @Override // com.baidu.tieba.n69.b
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
                if (z) {
                    this.a.l.setVisibility(0);
                    this.a.F();
                    return;
                }
                this.a.l.setVisibility(8);
                this.a.u();
                this.a.J(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public g(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o69 a;

        public h(o69 o69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.i(this.a.f == null ? null : this.a.f.getText().toString());
            }
        }
    }

    public o69(@NonNull LinearLayout linearLayout, @NonNull NavigationBar navigationBar, @NonNull QuestionTagChooseActivity questionTagChooseActivity, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayout, navigationBar, questionTagChooseActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = linearLayout;
        this.b = navigationBar;
        this.c = questionTagChooseActivity;
        this.q = str;
        x();
        z();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setCenterTextTitle(this.c.getString(R.string.obfuscated_res_0x7f0f009b));
            this.b.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
            this.b.setIsClose(true);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g.setNestedScrollingEnabled(false);
            this.g.setOnScrollChangeListener(new d(this));
            this.l.setLayoutManager(new XLinearLayoutManager(this.a.getContext()));
            PbListView pbListView = new PbListView(this.a.getContext());
            this.m = pbListView;
            pbListView.a();
            this.m.p(R.color.CAM_X0205);
            this.m.y();
            this.m.F(SkinManager.getColor(R.color.CAM_X0107));
            this.m.H(R.dimen.tbfontsize33);
            this.m.B(R.color.CAM_X0110);
            this.l.setNextPage(this.m);
            this.l.addOnScrollListener(new e(this));
            G();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.addTextChangedListener(new b(this));
        }
    }

    public final void D() {
        n69 n69Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (n69Var = this.r) == null) {
            return;
        }
        if (n69Var.h(false)) {
            G();
        } else {
            H();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.D(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f09fe));
            this.m.f();
            this.m.M(ej.f(this.l.getContext(), R.dimen.tbds44));
            this.m.C(new g(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m.K();
            this.m.R();
            this.m.D(this.c.getString(R.string.obfuscated_res_0x7f0f0a00));
            this.m.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m.C(null);
        }
    }

    @Override // com.baidu.tieba.ie5
    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m.D(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0a01));
            this.m.f();
            this.m.M(ej.f(this.l.getContext(), R.dimen.tbds44));
            this.m.C(null);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            L(this.c.getString(R.string.obfuscated_res_0x7f0f0c60), true);
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            L(str, false);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.k == null) {
            return;
        }
        f95 f95Var = this.n;
        if (f95Var == null || !f95Var.isViewAttached()) {
            if (this.n == null) {
                this.n = new f95(this.c);
            }
            this.n.attachView(this.k);
            this.n.s(ej.f(this.c, R.dimen.tbds300));
        }
    }

    public final void L(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || this.k == null) {
            return;
        }
        g95 g95Var = this.o;
        if (g95Var == null || !g95Var.isViewAttached()) {
            if (this.o == null) {
                this.o = new g95(this.c, new h(this));
            }
            if (z) {
                this.o.i(R.drawable.new_pic_emotion_07);
                this.o.e();
            } else {
                this.o.i(R.drawable.new_pic_emotion_08);
                this.o.p();
            }
            this.o.o(str);
            this.o.attachView(this.k, true);
            this.o.f(R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.no
    public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof QuestionTagListData.QuestionTag)) {
            Intent intent = new Intent();
            this.p = intent;
            intent.putExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_TAG, (QuestionTagListData.QuestionTag) cdo);
            this.c.finish();
        }
    }

    @Override // com.baidu.tieba.ie5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ie5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
            hv4 d2 = hv4.d(this.d);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            this.f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null && bdTypeRecyclerView.getAdapter() != null) {
                this.l.getAdapter().notifyDataSetChanged();
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.d(i);
            }
            g95 g95Var = this.o;
            if (g95Var != null) {
                g95Var.onChangeSkinType();
                this.o.f(R.color.CAM_X0201);
            }
            if (this.b.getBackImageView() != null) {
                this.b.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a10, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
        }
    }

    public void onDestroy() {
        n69 n69Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (n69Var = this.r) == null) {
            return;
        }
        n69Var.n();
    }

    @Override // com.baidu.tieba.ie5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            NestedScrollView nestedScrollView = this.g;
            return nestedScrollView == null || nestedScrollView.getScrollY() == 0;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final n69.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new f(this) : (n69.b) invokeV.objValue;
    }

    public final void u() {
        f95 f95Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.k == null || (f95Var = this.n) == null || !f95Var.isViewAttached()) {
            return;
        }
        this.n.dettachView(this.k);
    }

    public final void v() {
        g95 g95Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.k == null || (g95Var = this.o) == null || !g95Var.isViewAttached()) {
            return;
        }
        this.o.dettachView(this.k);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList arrayList = new ArrayList();
            QuestionTagAdapter questionTagAdapter = new QuestionTagAdapter(this.c, QuestionTagListData.QuestionTag.TYPE_TAG);
            questionTagAdapter.setOnAdapterItemClickListener(this);
            arrayList.add(questionTagAdapter);
            this.l.a(arrayList);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d04cc, (ViewGroup) this.a, true);
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091de7);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091df9);
            this.f = (EditText) this.a.findViewById(R.id.obfuscated_res_0x7f091e13);
            this.g = (NestedScrollView) this.a.findViewById(R.id.obfuscated_res_0x7f091676);
            this.h = (ConstraintLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090730);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092067);
            this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09072f);
            this.k = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e05);
            this.l = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f091e0d);
            A();
            C();
            y();
            B();
            w();
            n(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.h.setOnClickListener(new c(this));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            n69 n69Var = new n69();
            this.r = n69Var;
            n69Var.j();
            this.r.m(this.q);
            this.r.l(t());
            this.r.i(null);
        }
    }
}
