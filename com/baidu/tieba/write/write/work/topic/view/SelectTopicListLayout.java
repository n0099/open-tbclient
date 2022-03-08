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
import c.a.q0.h0.c;
import c.a.r0.r1.f;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.topic.fragment.VideoTopicListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SelectTopicListLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f48647e;

    /* renamed from: f  reason: collision with root package name */
    public TbTabLayout f48648f;

    /* renamed from: g  reason: collision with root package name */
    public CustomViewPager f48649g;

    /* renamed from: h  reason: collision with root package name */
    public SelectTopicToolBar f48650h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f48651i;

    /* renamed from: j  reason: collision with root package name */
    public List<c> f48652j;

    /* loaded from: classes6.dex */
    public static class a extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f48653b;

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
            this.f48653b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<c> list = this.f48653b;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f48653b.get(i2).a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f48653b.get(i2).f12600c : (CharSequence) invokeI.objValue;
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
            LinearLayout.inflate(getContext(), R.layout.select_topic_list_layout, this);
            this.f48647e = (LinearLayout) findViewById(R.id.ll_use_common);
            this.f48650h = (SelectTopicToolBar) findViewById(R.id.topic_common_bar);
            this.f48651i = (EMTextView) findViewById(R.id.common_topic_title);
            this.f48648f = (TbTabLayout) findViewById(R.id.topic_list_tab_layout);
            this.f48649g = (CustomViewPager) findViewById(R.id.topic_list_viewpager);
            this.f48650h.setmFromType(2);
            this.f48650h.showAddTopicItem(false);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f48652j = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            c cVar = new c();
            VideoTopicListFragment newInstance = VideoTopicListFragment.newInstance();
            cVar.a = newInstance;
            newInstance.setArguments(bundle);
            cVar.f12600c = TbadkCoreApplication.getInst().getResources().getString(R.string.select_video_topic_title);
            cVar.f12602e = 1;
            this.f48652j.add(cVar);
            Bundle bundle2 = new Bundle();
            bundle.putInt("type", 2);
            c cVar2 = new c();
            VideoTopicListFragment newInstance2 = VideoTopicListFragment.newInstance();
            cVar2.a = newInstance2;
            newInstance2.setArguments(bundle2);
            cVar2.f12600c = TbadkCoreApplication.getInst().getResources().getString(R.string.select_text_topic_title);
            cVar2.f12602e = 2;
            this.f48652j.add(cVar2);
            this.f48649g.setOffscreenPageLimit(this.f48652j.size());
            this.f48649g.setAdapter(new a(((FragmentActivity) getContext()).getSupportFragmentManager(), this.f48652j));
            this.f48648f.setSelectedTabTextBlod(true);
            this.f48648f.setTabTextSize(n.f(getContext(), R.dimen.T_X06));
            this.f48648f.setSelectedIndicatorBottomMargin(n.f(getContext(), R.dimen.tbds5));
            this.f48648f.setupWithViewPager(this.f48649g);
        }
    }

    public void bindData(c.a.r0.r1.c cVar, c.a.r0.r1.c cVar2, c.a.r0.r1.c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, cVar3) == null) {
            if (cVar != null && !ListUtils.isEmpty(cVar.b())) {
                this.f48647e.setVisibility(0);
                this.f48650h.bindData(cVar.c());
            } else {
                this.f48647e.setVisibility(8);
            }
            if (ListUtils.isEmpty(this.f48652j)) {
                return;
            }
            for (c cVar4 : this.f48652j) {
                int i2 = cVar4.f12602e;
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
            c.a.q0.r.v.c.d(this.f48651i).v(R.color.CAM_X0105);
            this.f48648f.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.f48648f.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f48649g.setCurrentItem(0);
            for (c cVar : this.f48652j) {
                ((VideoTopicListFragment) cVar.a).onClose();
            }
        }
    }

    public void setSelectTopicId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f48650h.setSelectTopicId(j2);
            if (ListUtils.isEmpty(this.f48652j)) {
                return;
            }
            for (c cVar : this.f48652j) {
                if (cVar.f12602e == 1) {
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
