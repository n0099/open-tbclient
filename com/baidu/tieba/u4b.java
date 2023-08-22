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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QuestionTagChooseActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.t4b;
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
/* loaded from: classes8.dex */
public class u4b implements dt5, ln {
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
    public LoadingView n;
    public dn5 o;
    public Intent p;
    public String q;
    public t4b r;
    public String s;
    public String t;

    @Override // com.baidu.tieba.dt5
    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

        public a(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.p = null;
            this.a.c.finish();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

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

        public b(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable == null) {
                    obj = null;
                } else {
                    obj = editable.toString();
                }
                if (this.a.r != null) {
                    this.a.r.i(obj);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

        public c(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p = new Intent();
                this.a.p.putExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, true);
                this.a.p.putExtra(QuestionTagChooseActivityConfig.KEY_QUESTION_TAG_REFER, this.a.s);
                this.a.p.putExtra(QuestionTagChooseActivityConfig.KEY_QUESTION_TAG_DEFAULT_CATEGORY, this.a.t);
                this.a.c.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements NestedScrollView.OnScrollChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

        public d(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{nestedScrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) != null && i2 >= nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() && i2 > i4) {
                this.a.F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

        public e(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    BdUtilHelper.hideSoftKeyPad(this.a.c, this.a.a);
                    this.a.f.clearFocus();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements t4b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

        public f(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // com.baidu.tieba.t4b.b
        public void a(boolean z, List<bn> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.v();
                this.a.w();
                if (ListUtils.isEmpty(list)) {
                    this.a.l.setVisibility(8);
                    this.a.L();
                    return;
                }
                this.a.l.setVisibility(0);
                this.a.l.setData(list);
                if (!z) {
                    this.a.K();
                } else {
                    this.a.J();
                }
            }
        }

        @Override // com.baidu.tieba.t4b.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    if (this.a.l.getAdapter() != null) {
                        this.a.l.getData().clear();
                        this.a.l.getAdapter().notifyDataSetChanged();
                    }
                    this.a.l.setVisibility(8);
                    this.a.N();
                } else {
                    this.a.l.setVisibility(0);
                    this.a.J();
                }
                this.a.w();
            }
        }

        @Override // com.baidu.tieba.t4b.b
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
                if (z) {
                    this.a.l.setVisibility(0);
                    this.a.I();
                    return;
                }
                this.a.l.setVisibility(8);
                this.a.v();
                this.a.M(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

        public g(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.F();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u4b a;

        public h(u4b u4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f == null) {
                    obj = null;
                } else {
                    obj = this.a.f.getText().toString();
                }
                this.a.r.i(obj);
            }
        }
    }

    public u4b(@NonNull LinearLayout linearLayout, @NonNull NavigationBar navigationBar, @NonNull QuestionTagChooseActivity questionTagChooseActivity, @NonNull String str) {
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
        y();
        A();
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.t = str;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.s = str;
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            O(str, false);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            t4b t4bVar = new t4b();
            this.r = t4bVar;
            t4bVar.j();
            this.r.m(this.q);
            this.r.l(u());
            this.r.i(null);
        }
    }

    @Override // com.baidu.tieba.dt5
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NestedScrollView nestedScrollView = this.g;
            if (nestedScrollView == null || nestedScrollView.getScrollY() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.addTextChangedListener(new b(this));
        }
    }

    public final void F() {
        t4b t4bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (t4bVar = this.r) == null) {
            return;
        }
        if (t4bVar.h(false)) {
            J();
        } else {
            K();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            O(this.c.getString(R.string.new_text_no_search_result), true);
        }
    }

    @Override // com.baidu.tieba.dt5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.p;
        }
        return (Intent) invokeV.objValue;
    }

    public void onDestroy() {
        t4b t4bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (t4bVar = this.r) != null) {
            t4bVar.n();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final t4b.b u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return new f(this);
        }
        return (t4b.b) invokeV.objValue;
    }

    public final void v() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.k != null && (loadingView = this.n) != null && loadingView.isViewAttached()) {
            this.n.dettachView(this.k);
        }
    }

    public final void w() {
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.k != null && (dn5Var = this.o) != null && dn5Var.isViewAttached()) {
            this.o.dettachView(this.k);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ArrayList arrayList = new ArrayList();
            QuestionTagAdapter questionTagAdapter = new QuestionTagAdapter(this.c, QuestionTagListData.QuestionTag.TYPE_TAG);
            questionTagAdapter.setOnAdapterItemClickListener(this);
            arrayList.add(questionTagAdapter);
            this.l.addAdapters(arrayList);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.h.setOnClickListener(new c(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.setCenterTextTitle(this.c.getString(R.string.activity_select_tag_title));
            this.b.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
            this.b.setIsClose(true);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.H(this.c.getResources().getString(R.string.list_click_load_more));
            this.m.g();
            this.m.P(BdUtilHelper.getDimens(this.l.getContext(), R.dimen.tbds44));
            this.m.G(new g(this));
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m.N();
            this.m.U();
            this.m.H(this.c.getString(R.string.list_loading));
            this.m.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m.G(null);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.m.H(this.c.getResources().getString(R.string.list_no_more));
            this.m.g();
            this.m.P(BdUtilHelper.getDimens(this.l.getContext(), R.dimen.tbds44));
            this.m.G(null);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.k == null) {
            return;
        }
        LoadingView loadingView = this.n;
        if (loadingView != null && loadingView.isViewAttached()) {
            return;
        }
        if (this.n == null) {
            this.n = new LoadingView(this.c);
        }
        this.n.attachView(this.k);
        this.n.setTopMargin(BdUtilHelper.getDimens(this.c, R.dimen.tbds300));
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.setNestedScrollingEnabled(false);
            this.g.setOnScrollChangeListener(new d(this));
            this.l.setLayoutManager(new XLinearLayoutManager(this.a.getContext()));
            PbListView pbListView = new PbListView(this.a.getContext());
            this.m = pbListView;
            pbListView.a();
            this.m.s(R.color.CAM_X0205);
            this.m.B();
            this.m.J(SkinManager.getColor(R.color.CAM_X0107));
            this.m.L(R.dimen.tbfontsize33);
            this.m.F(R.color.CAM_X0110);
            this.l.setNextPage(this.m);
            this.l.addOnScrollListener(new e(this));
            J();
        }
    }

    public final void O(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048590, this, str, z) != null) || this.k == null) {
            return;
        }
        dn5 dn5Var = this.o;
        if (dn5Var != null && dn5Var.isViewAttached()) {
            return;
        }
        if (this.o == null) {
            this.o = new dn5(this.c, new h(this));
        }
        if (z) {
            this.o.h(R.drawable.new_pic_emotion_10);
            this.o.d();
        } else {
            this.o.h(R.drawable.new_pic_emotion_08);
            this.o.o();
        }
        this.o.n(str);
        this.o.attachView(this.k, true);
        this.o.e(R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ln
    public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof QuestionTagListData.QuestionTag)) {
            Intent intent = new Intent();
            this.p = intent;
            intent.putExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_TAG, (QuestionTagListData.QuestionTag) bnVar);
            this.p.putExtra(QuestionTagChooseActivityConfig.KEY_QUESTION_TAG_REFER, this.s);
            this.p.putExtra(QuestionTagChooseActivityConfig.KEY_QUESTION_TAG_DEFAULT_CATEGORY, this.t);
            this.c.finish();
        }
    }

    @Override // com.baidu.tieba.dt5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
            EMManager.from(this.d).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            this.f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null && bdTypeRecyclerView.getAdapter() != null) {
                this.l.getAdapter().notifyDataSetChanged();
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.e(i);
            }
            dn5 dn5Var = this.o;
            if (dn5Var != null) {
                dn5Var.onChangeSkinType();
                this.o.e(R.color.CAM_X0201);
            }
            if (this.b.getBackImageView() != null) {
                this.b.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_close40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0550, (ViewGroup) this.a, true);
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092116);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092128);
            this.f = (EditText) this.a.findViewById(R.id.obfuscated_res_0x7f092142);
            this.g = (NestedScrollView) this.a.findViewById(R.id.obfuscated_res_0x7f091916);
            this.h = (ConstraintLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090820);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0923d8);
            this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09081f);
            this.k = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092134);
            this.l = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f09213c);
            B();
            E();
            z();
            D();
            x();
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
