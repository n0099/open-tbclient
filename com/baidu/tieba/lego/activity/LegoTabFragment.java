package com.baidu.tieba.lego.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.e49;
import com.baidu.tieba.f29;
import com.baidu.tieba.f49;
import com.baidu.tieba.g29;
import com.baidu.tieba.g49;
import com.baidu.tieba.lego.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.m29;
import com.baidu.tieba.wn5;
import com.baidu.tieba.y39;
import com.baidu.tieba.z39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes6.dex */
public class LegoTabFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScrollFragmentTabHost a;
    public f49 b;
    public wn5 c;
    public LoadingView d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public List<y39> j;
    public m29 k;
    public g29 l;
    public f29 m;
    public CustomMessageListener n;

    /* loaded from: classes6.dex */
    public class a implements g29 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoTabFragment a;

        public a(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoTabFragment;
        }

        @Override // com.baidu.tieba.g29
        public void a(int i, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
                this.a.b.c(2, j, str, i, str2);
            }
        }

        @Override // com.baidu.tieba.g29
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                this.a.b.a(j, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f29 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoTabFragment a;

        public b(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoTabFragment;
        }

        @Override // com.baidu.tieba.f29
        public void a(List<y39> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LegoTabFragment legoTabFragment = this.a;
                List<y39> list2 = legoTabFragment.j;
                if (list2 == null) {
                    legoTabFragment.j = new ArrayList();
                } else {
                    list2.clear();
                }
                if (list != null && list.size() > 0) {
                    this.a.j.addAll(list);
                }
                this.a.s2();
            }
        }

        @Override // com.baidu.tieba.f29
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LegoTabFragment legoTabFragment = this.a;
                legoTabFragment.j2(legoTabFragment.getView());
            }
        }

        @Override // com.baidu.tieba.f29
        public void c(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, str) == null) {
                this.a.b.c(1, j, str, 1, "");
            }
        }

        @Override // com.baidu.tieba.f29
        public void d(String str, String str2, String str3, List<z39> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) {
                this.a.g = str;
                this.a.h = str2;
                this.a.i = str3;
                this.a.n2();
                this.a.m2(list);
            }
        }

        @Override // com.baidu.tieba.f29
        public void e(long j, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i), str2}) == null) {
                this.a.b.c(1, j, str, i, str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LegoTabFragment legoTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.n2();
                this.a.s2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements g49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoTabFragment a;

        public d(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoTabFragment;
        }

        @Override // com.baidu.tieba.g49
        public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
                this.a.n2();
                if (z) {
                    LegoTabFragment legoTabFragment = this.a;
                    legoTabFragment.j2(legoTabFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (z && !this.a.a.f() && (dataRes == null || dataRes.cards == null)) {
                    if (this.a.getPageContext() != null && this.a.getPageContext().getResources() != null) {
                        LegoTabFragment legoTabFragment2 = this.a;
                        legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e40), false);
                        return;
                    }
                    return;
                }
                this.a.a.n(z, j, str, dataRes, z2, i);
            }
        }

        @Override // com.baidu.tieba.g49
        public void b(long j, String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) {
                LegoTabFragment legoTabFragment = this.a;
                legoTabFragment.j2(legoTabFragment.getView());
                if (!this.a.a.f()) {
                    if (this.a.getPageContext() != null && this.a.getPageContext().getResources() != null) {
                        LegoTabFragment legoTabFragment2 = this.a;
                        legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
                        return;
                    }
                    return;
                }
                this.a.a.o(j, str, str2, i);
            }
        }

        @Override // com.baidu.tieba.g49
        public void c(long j, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
                LegoTabFragment legoTabFragment = this.a;
                legoTabFragment.j2(legoTabFragment.getView());
                this.a.a.p(j, str, (DataRes) message, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoTabFragment a;

        public e(LegoTabFragment legoTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.c(1, this.a.e, this.a.f, 1, "");
                this.a.k2();
                LegoTabFragment legoTabFragment = this.a;
                legoTabFragment.r2(legoTabFragment.getView(), false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cc));
            }
        }
    }

    public LegoTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this, 2016449);
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.k != null) {
            if (!TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.i)) {
                this.k.j(this.h, this.i);
            } else {
                this.k.i(this.g);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            if (isPrimary() && (scrollFragmentTabHost = this.a) != null && scrollFragmentTabHost.j()) {
                this.a.m(this.e, this.f);
                r2(getView(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cc));
            }
        }
    }

    public final void j2(View view2) {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (loadingView = this.d) != null) {
            loadingView.dettachView(view2);
            this.d = null;
        }
    }

    public void o2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.k(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.n);
        }
    }

    public void p2(m29 m29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, m29Var) == null) {
            this.k = m29Var;
        }
    }

    public void q2(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.e = j;
        }
    }

    public final void k2() {
        wn5 wn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (wn5Var = this.c) != null) {
            wn5Var.dettachView(getView());
            this.c = null;
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f49 c2 = e49.d().c(getPageContext(), getUniqueId());
            this.b = c2;
            c2.b(new d(this));
        }
    }

    public final void s2() {
        m29 m29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (m29Var = this.k) != null) {
            m29Var.g(this.j);
        }
    }

    public final void m2(List<z39> list) {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && (count = ListUtils.getCount(list)) > 0 && this.a != null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    break;
                } else if (list.get(i2).a == this.e) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.a.setFirstPosition(i);
            this.a.d(list, i);
            this.a.setCurrentTab(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            l2();
            ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) getView().findViewById(R.id.obfuscated_res_0x7f09150a);
            this.a = scrollFragmentTabHost;
            scrollFragmentTabHost.setPageUniqueId(getUniqueId());
            this.a.h(this.l, this.m);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05bb, (ViewGroup) null);
            inflate.setDrawingCacheEnabled(false);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public final void r2(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (this.d == null) {
                if (i < 0) {
                    this.d = new LoadingView(getActivity());
                } else {
                    this.d = new LoadingView(getActivity(), i);
                }
                this.d.onChangeSkinType();
            }
            this.d.attachView(view2, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048591, this, view2, str, z) == null) {
            if (this.c == null) {
                this.c = new wn5(getPageContext().getPageActivity(), new e(this));
            }
            this.c.j(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07037e));
            this.c.l(str);
            this.c.attachView(view2, z);
            this.c.o();
        }
    }
}
