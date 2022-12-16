package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumCardView;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class oe8 extends h46<md8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public int j;
    public md8 k;
    public b l;
    public og<PersonCommonForumItemView> m;
    public TextView n;
    public ListViewPager o;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.h46
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d073e : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe8 a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public b(oe8 oe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe8Var;
        }

        public /* synthetic */ b(oe8 oe8Var, a aVar) {
            this(oe8Var);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) && (obj instanceof PersonCommonForumCardView)) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.k();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.k != null && !ListUtils.isEmpty(this.a.k.a)) {
                    if (this.a.k.a.size() % 4 == 0) {
                        return this.a.k.a.size() / 4;
                    }
                    return (this.a.k.a.size() / 4) + 1;
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                List<pd8> v = this.a.v(i);
                if (!ListUtils.isEmpty(v)) {
                    PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.a.i.getPageActivity());
                    personCommonForumCardView.setForumItemViewBdObjectPool(this.a.m);
                    personCommonForumCardView.setData(v);
                    personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                    viewGroup.addView(personCommonForumCardView);
                    return personCommonForumCardView;
                }
                return null;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oe8(TbPageContext<?> tbPageContext) {
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
        this.j = 3;
        this.l = new b(this, null);
        this.i = tbPageContext;
        View h = h();
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0906c4);
        this.o = (ListViewPager) h.findViewById(R.id.obfuscated_res_0x7f0906c5);
        if ("NX40X".equals(aj.g())) {
            h.setLayerType(2, null);
            if (h instanceof ViewGroup) {
                ((ViewGroup) h).setClipChildren(true);
            }
        }
        this.o.setOffscreenPageLimit(1);
    }

    public final boolean w(md8 md8Var) {
        InterceptResult invokeL;
        md8 md8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, md8Var)) == null) {
            if (md8Var == null || ListUtils.isEmpty(md8Var.a) || md8Var == (md8Var2 = this.k)) {
                return false;
            }
            if (md8Var2 == null || ListUtils.isEmpty(md8Var2.a)) {
                return true;
            }
            if (!ListUtils.isEmpty(md8Var.a)) {
                if (md8Var.a.size() != this.k.a.size()) {
                    return true;
                }
                for (int i = 0; i < md8Var.a.size(); i++) {
                    if (this.k.a.get(i) == null || md8Var.a.get(i).a != this.k.a.get(i).a) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(og<PersonCommonForumItemView> ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ogVar) == null) {
            this.m = ogVar;
        }
    }

    @Override // com.baidu.tieba.h46
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.j != i) {
                SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
                int childCount = this.o.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.o.getChildAt(i2);
                    if (childAt instanceof PersonCommonForumCardView) {
                        ((PersonCommonForumCardView) childAt).j();
                    }
                }
            }
            this.j = i;
        }
    }

    public final List<pd8> v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            md8 md8Var = this.k;
            if (md8Var != null && !ListUtils.isEmpty(md8Var.a)) {
                ArrayList arrayList = new ArrayList();
                int i2 = i * 4;
                for (int i3 = i2; i3 < i2 + 4; i3++) {
                    pd8 pd8Var = (pd8) ListUtils.getItem(this.k.a, i3);
                    if (pd8Var != null) {
                        arrayList.add(pd8Var);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h46
    /* renamed from: x */
    public void i(md8 md8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, md8Var) == null) {
            if (w(md8Var)) {
                this.k = md8Var;
                if (ListUtils.getCount(md8Var.a) <= 2) {
                    this.o.getLayoutParams().height = yi.g(this.i.getPageActivity(), R.dimen.obfuscated_res_0x7f070247);
                }
                this.o.setAdapter(this.l);
            }
            j(this.i, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
