package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import c.a.e.e.p.l;
import c.a.r0.o2.e.c;
import c.a.r0.o2.e.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f56172e;

    /* renamed from: f  reason: collision with root package name */
    public int f56173f;

    /* renamed from: g  reason: collision with root package name */
    public c f56174g;

    /* renamed from: h  reason: collision with root package name */
    public b f56175h;

    /* renamed from: i  reason: collision with root package name */
    public View f56176i;

    /* renamed from: j  reason: collision with root package name */
    public View f56177j;
    public c.a.e.e.k.b<PersonCommonForumItemView> k;
    public TextView mTitle;
    public ListViewPager mViewPager;

    /* loaded from: classes7.dex */
    public class a implements c.a.e.e.k.c<PersonCommonForumItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterAttentionBarListView f56178a;

        public a(PersonCenterAttentionBarListView personCenterAttentionBarListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterAttentionBarListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56178a = personCenterAttentionBarListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView a(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            e(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView c(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            h(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        public PersonCommonForumItemView e(PersonCommonForumItemView personCommonForumItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, personCommonForumItemView)) == null) ? personCommonForumItemView : (PersonCommonForumItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(PersonCommonForumItemView personCommonForumItemView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, personCommonForumItemView) == null) || personCommonForumItemView == null) {
                return;
            }
            personCommonForumItemView.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public PersonCommonForumItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new PersonCommonForumItemView(this.f56178a.f56172e) : (PersonCommonForumItemView) invokeV.objValue;
        }

        public PersonCommonForumItemView h(PersonCommonForumItemView personCommonForumItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, personCommonForumItemView)) == null) ? personCommonForumItemView : (PersonCommonForumItemView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterAttentionBarListView f56179a;

        public b(PersonCenterAttentionBarListView personCenterAttentionBarListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterAttentionBarListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56179a = personCenterAttentionBarListView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) && (obj instanceof PersonCommonForumCardView)) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.recycle();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f56179a.f56174g == null || ListUtils.isEmpty(this.f56179a.f56174g.f23207e)) {
                    return 0;
                }
                return this.f56179a.f56174g.f23207e.size() % 4 == 0 ? this.f56179a.f56174g.f23207e.size() / 4 : (this.f56179a.f56174g.f23207e.size() / 4) + 1;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                List<f> e2 = this.f56179a.e(i2);
                if (ListUtils.isEmpty(e2)) {
                    return null;
                }
                PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.f56179a.f56172e);
                personCommonForumCardView.setForumItemViewBdObjectPool(this.f56179a.k);
                personCommonForumCardView.setData(e2);
                personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                personCommonForumCardView.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds48));
                viewGroup.addView(personCommonForumCardView);
                return personCommonForumCardView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }

        public /* synthetic */ b(PersonCenterAttentionBarListView personCenterAttentionBarListView, a aVar) {
            this(personCenterAttentionBarListView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterAttentionBarListView(Context context) {
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
        this.f56173f = 3;
        this.f56175h = new b(this, null);
        this.k = new c.a.e.e.k.b<>(new a(this), 12, 0);
        f(context);
    }

    public final List<f> e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            c cVar = this.f56174g;
            if (cVar == null || ListUtils.isEmpty(cVar.f23207e)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = i2 * 4;
            for (int i4 = i3; i4 < i3 + 4; i4++) {
                f fVar = (f) ListUtils.getItem(this.f56174g.f23207e, i4);
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f56172e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.person_info_common_forum_layout, this);
            this.f56176i = inflate;
            this.mTitle = (TextView) inflate.findViewById(R.id.common_forum_title);
            this.mViewPager = (ListViewPager) this.f56176i.findViewById(R.id.common_forum_viewpager);
            this.f56177j = this.f56176i.findViewById(R.id.divider_line);
            this.mViewPager.setOffscreenPageLimit(1);
        }
    }

    public final boolean g(c cVar) {
        InterceptResult invokeL;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            if (cVar == null || ListUtils.isEmpty(cVar.f23207e) || cVar == (cVar2 = this.f56174g)) {
                return false;
            }
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f23207e)) {
                return true;
            }
            if (!ListUtils.isEmpty(cVar.f23207e)) {
                if (cVar.f23207e.size() != this.f56174g.f23207e.size()) {
                    return true;
                }
                for (int i2 = 0; i2 < cVar.f23207e.size(); i2++) {
                    if (this.f56174g.f23207e.get(i2) == null || cVar.f23207e.get(i2).f23219e != this.f56174g.f23207e.get(i2).f23219e) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.person_info_common_forum_layout : invokeV.intValue;
    }

    public void onBindDataToView(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null) {
            return;
        }
        if (g(cVar)) {
            this.f56174g = cVar;
            if (ListUtils.getCount(cVar.f23207e) <= 2) {
                this.mViewPager.getLayoutParams().height = l.g(this.f56172e, R.dimen.tbds172);
            } else {
                this.mViewPager.getLayoutParams().height = l.g(this.f56172e, R.dimen.tbds344);
            }
            this.mViewPager.setAdapter(this.f56175h);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (this.f56173f != i2) {
                SkinManager.setBackgroundResource(this.f56176i, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f56177j, R.color.CAM_X0204);
                int childCount = this.mViewPager.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.mViewPager.getChildAt(i3);
                    if (childAt instanceof PersonCommonForumCardView) {
                        ((PersonCommonForumCardView) childAt).onChangeSkinType();
                    }
                }
            }
            this.f56173f = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet) {
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
        this.f56173f = 3;
        this.f56175h = new b(this, null);
        this.k = new c.a.e.e.k.b<>(new a(this), 12, 0);
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56173f = 3;
        this.f56175h = new b(this, null);
        this.k = new c.a.e.e.k.b<>(new a(this), 12, 0);
        f(context);
    }
}
