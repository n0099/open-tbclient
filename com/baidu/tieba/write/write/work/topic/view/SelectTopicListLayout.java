package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.tieba.q95;
import com.baidu.tieba.u77;
import com.baidu.tieba.write.write.work.topic.fragment.VideoTopicListFragment;
import com.baidu.tieba.x77;
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
    public TbTabLayout b;
    public CustomViewPager c;
    public SelectTopicToolBar d;
    public EMTextView e;
    public List f;

    /* loaded from: classes6.dex */
    public class a extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FragmentManager fragmentManager, List list) {
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
            this.b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List list = this.b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return ((q95) this.b.get(i)).a;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return ((q95) this.b.get(i)).c;
            }
            return (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                if (obj != null && (i2 = this.a) != i) {
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

    public void setSelectTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.d.setSelectTopicId(j);
            if (!ListUtils.isEmpty(this.f)) {
                for (q95 q95Var : this.f) {
                    if (q95Var.e == 1) {
                        ((VideoTopicListFragment) q95Var.a).s1(j);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicListLayout(Context context, AttributeSet attributeSet) {
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
    public SelectTopicListLayout(Context context, AttributeSet attributeSet, int i) {
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

    public void a(u77 u77Var, u77 u77Var2, u77 u77Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, u77Var, u77Var2, u77Var3) == null) {
            if (u77Var != null && !ListUtils.isEmpty(u77Var.b())) {
                this.a.setVisibility(0);
                this.d.e(u77Var.c());
            } else {
                this.a.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.f)) {
                for (q95 q95Var : this.f) {
                    int i = q95Var.e;
                    if (i == 1) {
                        VideoTopicListFragment videoTopicListFragment = (VideoTopicListFragment) q95Var.a;
                        if (u77Var3 != null && u77Var3.c() != null) {
                            x77 x77Var = new x77("", 0L, false);
                            x77Var.n(true);
                            u77Var3.c().add(0, x77Var);
                        }
                        videoTopicListFragment.t1(u77Var3);
                    } else if (i == 2) {
                        ((VideoTopicListFragment) q95Var.a).t1(u77Var2);
                    }
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d07b3, this);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0913fd);
            this.d = (SelectTopicToolBar) findViewById(R.id.obfuscated_res_0x7f0922ad);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0906aa);
            this.b = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f0922c9);
            this.c = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f0922cc);
            this.d.setmFromType(2);
            this.d.h(false);
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            q95 q95Var = new q95();
            VideoTopicListFragment q1 = VideoTopicListFragment.q1();
            q95Var.a = q1;
            q1.setArguments(bundle);
            q95Var.c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1131);
            q95Var.e = 1;
            this.f.add(q95Var);
            Bundle bundle2 = new Bundle();
            bundle.putInt("type", 2);
            q95 q95Var2 = new q95();
            VideoTopicListFragment q12 = VideoTopicListFragment.q1();
            q95Var2.a = q12;
            q12.setArguments(bundle2);
            q95Var2.c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f112b);
            q95Var2.e = 2;
            this.f.add(q95Var2);
            this.c.setOffscreenPageLimit(this.f.size());
            this.c.setAdapter(new a(((FragmentActivity) getContext()).getSupportFragmentManager(), this.f));
            this.b.setSelectedTabTextBlod(true);
            this.b.setTabTextSize(fj.f(getContext(), R.dimen.T_X06));
            this.b.setSelectedIndicatorBottomMargin(fj.f(getContext(), R.dimen.tbds5));
            this.b.setupWithViewPager(this.c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            nv4.d(this.e).v(R.color.CAM_X0105);
            this.b.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.b.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setCurrentItem(0);
            for (q95 q95Var : this.f) {
                ((VideoTopicListFragment) q95Var.a).r1();
            }
        }
    }
}
