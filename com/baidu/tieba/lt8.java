package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.personCenter.view.PersonCenterSmartAppPageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class lt8 extends me6<bt8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rs8> i;
    public List<PersonCenterSmartAppPageView> j;
    public BdBaseViewPager k;
    public View l;
    public a m;
    public PersonCenterSmartAppPageView n;
    public LinearLayout o;
    public TextView p;
    public LinearLayout q;

    @Override // com.baidu.tieba.me6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d075b : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PersonCenterSmartAppPageView> a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public a(lt8 lt8Var, List<PersonCenterSmartAppPageView> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        public void b(List<PersonCenterSmartAppPageView> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a = list;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                int indexOf = this.a.indexOf(obj);
                if (indexOf == -1) {
                    return -2;
                }
                return indexOf;
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i, obj) == null) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
                PersonCenterSmartAppPageView personCenterSmartAppPageView = this.a.get(i);
                viewGroup.addView(personCenterSmartAppPageView);
                return personCenterSmartAppPageView;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lt8(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = h();
        int g = hi.g(this.c, R.dimen.M_W_X003);
        this.l.setPadding(g, 0, g, 0);
        this.q = (LinearLayout) this.l.findViewById(R.id.obfuscated_res_0x7f0915de);
        this.p = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f0920df);
        this.k = (BdBaseViewPager) this.l.findViewById(R.id.obfuscated_res_0x7f092863);
        this.o = (LinearLayout) this.l.findViewById(R.id.obfuscated_res_0x7f0920e0);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        a aVar = new a(this, arrayList);
        this.m = aVar;
        this.k.setAdapter(aVar);
        m(g(), this.a);
    }

    @Override // com.baidu.tieba.me6
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.j) {
                if (personCenterSmartAppPageView != null) {
                    personCenterSmartAppPageView.c();
                }
            }
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            n15 d = n15.d(this.k);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            n15 d2 = n15.d(this.o);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }

    public final void r(rs8 rs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rs8Var) == null) {
            if (this.n.b()) {
                this.n.a(rs8Var);
                return;
            }
            PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(getContext());
            this.n = personCenterSmartAppPageView;
            this.j.add(personCenterSmartAppPageView);
            this.n.a(rs8Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.me6
    /* renamed from: s */
    public void l(bt8 bt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bt8Var) == null) {
            if (bt8Var != null && bt8Var.c() != null && !ListUtils.isEmpty(bt8Var.c())) {
                q(0);
                this.j.clear();
                this.i = bt8Var.c();
                PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(getContext());
                this.n = personCenterSmartAppPageView;
                this.j.add(personCenterSmartAppPageView);
                int min = Math.min(7, this.i.size());
                for (int i = 0; i < min; i++) {
                    r((rs8) ListUtils.getItem(this.i, i));
                }
                if (this.i.isEmpty()) {
                    q(8);
                } else {
                    r(new ct8());
                }
                this.m.b(this.j);
                m(g(), this.a);
                return;
            }
            q(8);
        }
    }
}
