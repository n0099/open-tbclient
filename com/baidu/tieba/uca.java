package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
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
/* loaded from: classes8.dex */
public class uca extends nl6<sba> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public int j;
    public sba k;
    public b l;
    public pb<PersonCommonForumItemView> m;
    public TextView n;
    public ListViewPager o;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0817 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uca a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public b(uca ucaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ucaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ucaVar;
        }

        public /* synthetic */ b(uca ucaVar, a aVar) {
            this(ucaVar);
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
                List<vba> z = this.a.z(i);
                if (!ListUtils.isEmpty(z)) {
                    PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.a.i.getPageActivity());
                    personCommonForumCardView.setForumItemViewBdObjectPool(this.a.m);
                    personCommonForumCardView.setData(z);
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
    public uca(TbPageContext<?> tbPageContext) {
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
        View i3 = i();
        this.n = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0907c4);
        this.o = (ListViewPager) i3.findViewById(R.id.obfuscated_res_0x7f0907c5);
        if ("NX40X".equals(DeviceInfoHelper.getModel())) {
            i3.setLayerType(2, null);
            if (i3 instanceof ViewGroup) {
                ((ViewGroup) i3).setClipChildren(true);
            }
        }
        this.o.setOffscreenPageLimit(1);
    }

    public final boolean A(sba sbaVar) {
        InterceptResult invokeL;
        sba sbaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sbaVar)) == null) {
            if (sbaVar == null || ListUtils.isEmpty(sbaVar.a) || sbaVar == (sbaVar2 = this.k)) {
                return false;
            }
            if (sbaVar2 == null || ListUtils.isEmpty(sbaVar2.a)) {
                return true;
            }
            if (!ListUtils.isEmpty(sbaVar.a)) {
                if (sbaVar.a.size() != this.k.a.size()) {
                    return true;
                }
                for (int i = 0; i < sbaVar.a.size(); i++) {
                    if (this.k.a.get(i) == null || sbaVar.a.get(i).a != this.k.a.get(i).a) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void C(pb<PersonCommonForumItemView> pbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbVar) == null) {
            this.m = pbVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: B */
    public void j(sba sbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sbaVar) == null) {
            if (A(sbaVar)) {
                this.k = sbaVar;
                if (ListUtils.getCount(sbaVar.a) <= 2) {
                    this.o.getLayoutParams().height = BdUtilHelper.getDimens(this.i.getPageActivity(), R.dimen.obfuscated_res_0x7f070370);
                }
                this.o.setAdapter(this.l);
            }
            k(this.i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            if (this.j != i) {
                SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
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

    public final List<vba> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            sba sbaVar = this.k;
            if (sbaVar != null && !ListUtils.isEmpty(sbaVar.a)) {
                ArrayList arrayList = new ArrayList();
                int i2 = i * 4;
                for (int i3 = i2; i3 < i2 + 4; i3++) {
                    vba vbaVar = (vba) ListUtils.getItem(this.k.a, i3);
                    if (vbaVar != null) {
                        arrayList.add(vbaVar);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeI.objValue;
    }
}
