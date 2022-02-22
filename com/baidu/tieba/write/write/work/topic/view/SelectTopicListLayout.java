package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import c.a.d.f.p.n;
import c.a.t0.i0.c;
import c.a.u0.s1.f;
import c.a.u0.s4.d;
import c.a.u0.s4.e;
import c.a.u0.s4.g;
import c.a.u0.s4.h;
import c.a.u0.s4.j;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.write.write.work.topic.fragment.VideoTopicListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class SelectTopicListLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50228e;

    /* renamed from: f  reason: collision with root package name */
    public TbTabLayout f50229f;

    /* renamed from: g  reason: collision with root package name */
    public CustomViewPager f50230g;

    /* renamed from: h  reason: collision with root package name */
    public SelectTopicToolBar f50231h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f50232i;

    /* renamed from: j  reason: collision with root package name */
    public List<c> f50233j;

    /* loaded from: classes13.dex */
    public static class a extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f50234b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.f50234b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<c> list = this.f50234b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NonNull
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f50234b.get(i2).a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f50234b.get(i2).f13190c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                if (obj == null || (i3 = this.a) == i2) {
                    return;
                }
                if (i3 != -1 && i3 < getCount()) {
                    ((BaseFragment) getItem(this.a)).setPrimary(false);
                }
                this.a = i2;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicListLayout(Context context) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.inflate(getContext(), h.select_topic_list_layout, this);
            this.f50228e = (LinearLayout) findViewById(g.ll_use_common);
            this.f50231h = (SelectTopicToolBar) findViewById(g.topic_common_bar);
            this.f50232i = (EMTextView) findViewById(g.common_topic_title);
            this.f50229f = (TbTabLayout) findViewById(g.topic_list_tab_layout);
            this.f50230g = (CustomViewPager) findViewById(g.topic_list_viewpager);
            this.f50231h.setmFromType(2);
            this.f50231h.showAddTopicItem(false);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f50233j = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            c cVar = new c();
            VideoTopicListFragment newInstance = VideoTopicListFragment.newInstance();
            cVar.a = newInstance;
            newInstance.setArguments(bundle);
            cVar.f13190c = TbadkCoreApplication.getInst().getResources().getString(j.select_video_topic_title);
            cVar.f13192e = 1;
            this.f50233j.add(cVar);
            Bundle bundle2 = new Bundle();
            bundle.putInt("type", 2);
            c cVar2 = new c();
            VideoTopicListFragment newInstance2 = VideoTopicListFragment.newInstance();
            cVar2.a = newInstance2;
            newInstance2.setArguments(bundle2);
            cVar2.f13190c = TbadkCoreApplication.getInst().getResources().getString(j.select_text_topic_title);
            cVar2.f13192e = 2;
            this.f50233j.add(cVar2);
            this.f50230g.setOffscreenPageLimit(this.f50233j.size());
            this.f50230g.setAdapter(new a(((FragmentActivity) getContext()).getSupportFragmentManager(), this.f50233j));
            this.f50229f.setSelectedTabTextBlod(true);
            this.f50229f.setTabTextSize(n.f(getContext(), e.T_X06));
            this.f50229f.setSelectedIndicatorBottomMargin(n.f(getContext(), e.tbds5));
            this.f50229f.setupWithViewPager(this.f50230g);
        }
    }

    public void bindData(c.a.u0.s1.c cVar, c.a.u0.s1.c cVar2, c.a.u0.s1.c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, cVar3) == null) {
            if (cVar != null && !ListUtils.isEmpty(cVar.b())) {
                this.f50228e.setVisibility(0);
                this.f50231h.bindData(cVar.c());
            } else {
                this.f50228e.setVisibility(8);
            }
            if (ListUtils.isEmpty(this.f50233j)) {
                return;
            }
            for (c cVar4 : this.f50233j) {
                int i2 = cVar4.f13192e;
                if (i2 == 1) {
                    VideoTopicListFragment videoTopicListFragment = (VideoTopicListFragment) cVar4.a;
                    if (cVar3 != null && cVar3.c() != null) {
                        f fVar = new f("", 0L, false);
                        fVar.n(true);
                        cVar3.c().add(0, fVar);
                    }
                    videoTopicListFragment.setlist(cVar3);
                } else if (i2 == 2) {
                    ((VideoTopicListFragment) cVar4.a).setlist(cVar2);
                }
            }
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.t0.s.v.c.d(this.f50232i).v(d.CAM_X0105);
            this.f50229f.setTabTextColors(SkinManager.getColor(d.CAM_X0108), SkinManager.getColor(d.CAM_X0105));
            this.f50229f.setSelectedTabIndicatorColor(SkinManager.getColor(d.CAM_X0302));
        }
    }

    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f50230g.setCurrentItem(0);
            for (c cVar : this.f50233j) {
                ((VideoTopicListFragment) cVar.a).onClose();
            }
        }
    }

    public void setSelectTopicId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f50231h.setSelectTopicId(j2);
            if (ListUtils.isEmpty(this.f50233j)) {
                return;
            }
            for (c cVar : this.f50233j) {
                if (cVar.f13192e == 1) {
                    ((VideoTopicListFragment) cVar.a).setSelectTopicId(j2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicListLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicListLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a();
    }
}
