package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes7.dex */
public class m9a extends nl6<c9a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<s8a> i;
    public List<PersonCenterSmartAppPageView> j;
    public BdBaseViewPager k;
    public View l;
    public a m;
    public PersonCenterSmartAppPageView n;
    public LinearLayout o;
    public TextView p;
    public LinearLayout q;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0805 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
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

        public a(m9a m9aVar, List<PersonCenterSmartAppPageView> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m9aVar, list};
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
    public m9a(TbPageContext<?> tbPageContext) {
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
        this.l = i();
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.l.setPadding(dimens, 0, dimens, 0);
        this.q = (LinearLayout) this.l.findViewById(R.id.obfuscated_res_0x7f091765);
        this.p = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092335);
        this.k = (BdBaseViewPager) this.l.findViewById(R.id.obfuscated_res_0x7f092aea);
        this.o = (LinearLayout) this.l.findViewById(R.id.obfuscated_res_0x7f092336);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        a aVar = new a(this, arrayList);
        this.m = aVar;
        this.k.setAdapter(aVar);
        k(h(), this.a);
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.j) {
                if (personCenterSmartAppPageView != null) {
                    personCenterSmartAppPageView.c();
                }
            }
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            EMManager.from(this.k).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.o).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        }
    }

    public final void p(s8a s8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s8aVar) == null) {
            if (this.n.b()) {
                this.n.a(s8aVar);
                return;
            }
            PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(c());
            this.n = personCenterSmartAppPageView;
            this.j.add(personCenterSmartAppPageView);
            this.n.a(s8aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: r */
    public void j(c9a c9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c9aVar) == null) {
            if (c9aVar != null && c9aVar.c() != null && !ListUtils.isEmpty(c9aVar.c())) {
                o(0);
                this.j.clear();
                this.i = c9aVar.c();
                PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(c());
                this.n = personCenterSmartAppPageView;
                this.j.add(personCenterSmartAppPageView);
                int min = Math.min(7, this.i.size());
                for (int i = 0; i < min; i++) {
                    p((s8a) ListUtils.getItem(this.i, i));
                }
                if (this.i.isEmpty()) {
                    o(8);
                } else {
                    p(new d9a());
                }
                this.m.b(this.j);
                k(h(), this.a);
                return;
            }
            o(8);
        }
    }
}
