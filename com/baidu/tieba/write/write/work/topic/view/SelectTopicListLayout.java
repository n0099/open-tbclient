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
import c.a.o0.h0.c;
import c.a.p0.t1.f;
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
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TbTabLayout f37590b;

    /* renamed from: c  reason: collision with root package name */
    public CustomViewPager f37591c;

    /* renamed from: d  reason: collision with root package name */
    public SelectTopicToolBar f37592d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f37593e;

    /* renamed from: f  reason: collision with root package name */
    public List<c> f37594f;

    /* loaded from: classes6.dex */
    public static class a extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f37595b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.f37595b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<c> list = this.f37595b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NonNull
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.f37595b.get(i).a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.f37595b.get(i).f10297c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                if (obj == null || (i2 = this.a) == i) {
                    return;
                }
                if (i2 != -1 && i2 < getCount()) {
                    ((BaseFragment) getItem(this.a)).setPrimary(false);
                }
                this.a = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    public void a(c.a.p0.t1.c cVar, c.a.p0.t1.c cVar2, c.a.p0.t1.c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, cVar2, cVar3) == null) {
            if (cVar != null && !ListUtils.isEmpty(cVar.b())) {
                this.a.setVisibility(0);
                this.f37592d.e(cVar.c());
            } else {
                this.a.setVisibility(8);
            }
            if (ListUtils.isEmpty(this.f37594f)) {
                return;
            }
            for (c cVar4 : this.f37594f) {
                int i = cVar4.f10299e;
                if (i == 1) {
                    VideoTopicListFragment videoTopicListFragment = (VideoTopicListFragment) cVar4.a;
                    if (cVar3 != null && cVar3.c() != null) {
                        f fVar = new f("", 0L, false);
                        fVar.n(true);
                        cVar3.c().add(0, fVar);
                    }
                    videoTopicListFragment.F0(cVar3);
                } else if (i == 2) {
                    ((VideoTopicListFragment) cVar4.a).F0(cVar2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d076a, this);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091304);
            this.f37592d = (SelectTopicToolBar) findViewById(R.id.obfuscated_res_0x7f0920dc);
            this.f37593e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0906a6);
            this.f37590b = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f0920f6);
            this.f37591c = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f0920f9);
            this.f37592d.setmFromType(2);
            this.f37592d.h(false);
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37594f = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            c cVar = new c();
            VideoTopicListFragment C0 = VideoTopicListFragment.C0();
            cVar.a = C0;
            C0.setArguments(bundle);
            cVar.f10297c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10d5);
            cVar.f10299e = 1;
            this.f37594f.add(cVar);
            Bundle bundle2 = new Bundle();
            bundle.putInt("type", 2);
            c cVar2 = new c();
            VideoTopicListFragment C02 = VideoTopicListFragment.C0();
            cVar2.a = C02;
            C02.setArguments(bundle2);
            cVar2.f10297c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10cf);
            cVar2.f10299e = 2;
            this.f37594f.add(cVar2);
            this.f37591c.setOffscreenPageLimit(this.f37594f.size());
            this.f37591c.setAdapter(new a(((FragmentActivity) getContext()).getSupportFragmentManager(), this.f37594f));
            this.f37590b.setSelectedTabTextBlod(true);
            this.f37590b.setTabTextSize(n.f(getContext(), R.dimen.T_X06));
            this.f37590b.setSelectedIndicatorBottomMargin(n.f(getContext(), R.dimen.tbds5));
            this.f37590b.setupWithViewPager(this.f37591c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.o0.r.v.c.d(this.f37593e).v(R.color.CAM_X0105);
            this.f37590b.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.f37590b.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f37591c.setCurrentItem(0);
            for (c cVar : this.f37594f) {
                ((VideoTopicListFragment) cVar.a).D0();
            }
        }
    }

    public void setSelectTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f37592d.setSelectTopicId(j);
            if (ListUtils.isEmpty(this.f37594f)) {
                return;
            }
            for (c cVar : this.f37594f) {
                if (cVar.f10299e == 1) {
                    ((VideoTopicListFragment) cVar.a).E0(j);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b();
    }
}
