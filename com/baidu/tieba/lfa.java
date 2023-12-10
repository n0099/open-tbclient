package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.f05;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class lfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;
    public View b;
    public View c;
    public BdListView d;
    public ki9 e;
    public View f;
    public f05 g;
    public NoDataView h;
    public boolean i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lfa a;

        public a(lfa lfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.l();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lfa a;

        public b(lfa lfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfaVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                TiebaStatic.log(new StatisticItem("c12403").param("fid", this.a.a.e).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.a.d));
                String str = (String) this.a.d.getItemAtPosition(i + 1);
                this.a.a.u1(str);
                this.a.a.v1(str);
                TiebaStatic.log(new StatisticItem("c12842").param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", this.a.a.e));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lfa a;

        public c(lfa lfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfaVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.a.p1();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(lfa lfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lfa a;

        public e(lfa lfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfaVar;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                this.a.a.m1().g();
                this.a.d.setVisibility(8);
                this.a.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lfa a;

        public f(lfa lfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfaVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.a.p1();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public lfa(PostSearchActivity postSearchActivity, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.f = null;
        this.i = false;
        this.a = postSearchActivity;
        this.b = view2;
        h();
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            jq5.a(this.a.getPageContext(), this.f);
            this.e.notifyDataSetChanged();
            NoDataView noDataView = this.h;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = false;
            this.a.hideLoadingView(this.c);
        }
    }

    public void g() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.h) != null) {
            noDataView.setVisibility(8);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.getVisibility() == 0 && !this.i && ((noDataView = this.h) == null || 8 == noDataView.getVisibility())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i = true;
            PostSearchActivity postSearchActivity = this.a;
            postSearchActivity.showLoadingView(this.c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d1));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(R.string.obfuscated_res_0x7f0f0e7d, NoDataViewFactory.ImgType.NODATA);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.setVisibility(8);
            o(R.string.new_text_no_search_result, NoDataViewFactory.ImgType.NORESULT);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = this.a.findViewById(R.id.obfuscated_res_0x7f090fcd);
            this.d = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f090fce);
            BdListViewHelper.d(this.a.getActivity(), this.d, BdListViewHelper.HeadType.DEFAULT);
            ki9 ki9Var = new ki9(this.a.getPageContext().getPageActivity(), null);
            this.e = ki9Var;
            ki9Var.b(false);
            this.d.setAdapter((ListAdapter) this.e);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d041b, (ViewGroup) null);
            this.f = inflate;
            this.d.addFooterView(inflate);
            this.f.setOnClickListener(new a(this));
            this.d.setOnItemClickListener(new b(this));
            this.d.setOnTouchListener(new c(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.g == null) {
                this.g = new f05(this.a.getPageContext().getPageActivity()).setMessage(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f029b)).setPositiveButton(this.a.getPageContext().getString(R.string.clear_all_text), new e(this)).setNegativeButton(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f03db), new d(this)).create(this.a.getPageContext());
            }
            this.g.show();
        }
    }

    public void k(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.c.setVisibility(0);
            f();
            if (arrayList != null && arrayList.size() != 0) {
                g();
                this.d.setVisibility(0);
                this.e.a(arrayList);
                this.e.notifyDataSetChanged();
                return;
            }
            this.d.setVisibility(8);
            n();
        }
    }

    public final void o(int i, NoDataViewFactory.ImgType imgType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, imgType) == null) {
            if (this.h == null) {
                NoDataView a2 = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0703bd)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f1681), null);
                this.h = a2;
                a2.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                this.h.setOnTouchListener(new f(this));
            }
            this.h.setTextOption(NoDataViewFactory.e.d(null, this.a.getResources().getString(i)));
            this.h.setImgOption(NoDataViewFactory.d.a(imgType));
            this.h.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.h.setVisibility(0);
        }
    }
}
