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
import com.repackage.li;
import com.repackage.t17;
import com.repackage.w17;
import com.repackage.wq4;
import com.repackage.z35;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectTopicListLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TbTabLayout b;
    public CustomViewPager c;
    public SelectTopicToolBar d;
    public EMTextView e;
    public List<z35> f;

    /* loaded from: classes4.dex */
    public static class a extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final List<z35> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FragmentManager fragmentManager, List<z35> list) {
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
                List<z35> list = this.b;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.b.get(i).a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.b.get(i).c : (CharSequence) invokeI.objValue;
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

    public void a(t17 t17Var, t17 t17Var2, t17 t17Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, t17Var, t17Var2, t17Var3) == null) {
            if (t17Var != null && !ListUtils.isEmpty(t17Var.b())) {
                this.a.setVisibility(0);
                this.d.e(t17Var.c());
            } else {
                this.a.setVisibility(8);
            }
            if (ListUtils.isEmpty(this.f)) {
                return;
            }
            for (z35 z35Var : this.f) {
                int i = z35Var.e;
                if (i == 1) {
                    VideoTopicListFragment videoTopicListFragment = (VideoTopicListFragment) z35Var.a;
                    if (t17Var3 != null && t17Var3.c() != null) {
                        w17 w17Var = new w17("", 0L, false);
                        w17Var.n(true);
                        t17Var3.c().add(0, w17Var);
                    }
                    videoTopicListFragment.H0(t17Var3);
                } else if (i == 2) {
                    ((VideoTopicListFragment) z35Var.a).H0(t17Var2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0748, this);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0912c9);
            this.d = (SelectTopicToolBar) findViewById(R.id.obfuscated_res_0x7f0920c3);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f09068b);
            this.b = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f0920dd);
            this.c = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f0920e0);
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
            z35 z35Var = new z35();
            VideoTopicListFragment E0 = VideoTopicListFragment.E0();
            z35Var.a = E0;
            E0.setArguments(bundle);
            z35Var.c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1106);
            z35Var.e = 1;
            this.f.add(z35Var);
            Bundle bundle2 = new Bundle();
            bundle.putInt("type", 2);
            z35 z35Var2 = new z35();
            VideoTopicListFragment E02 = VideoTopicListFragment.E0();
            z35Var2.a = E02;
            E02.setArguments(bundle2);
            z35Var2.c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1100);
            z35Var2.e = 2;
            this.f.add(z35Var2);
            this.c.setOffscreenPageLimit(this.f.size());
            this.c.setAdapter(new a(((FragmentActivity) getContext()).getSupportFragmentManager(), this.f));
            this.b.setSelectedTabTextBlod(true);
            this.b.setTabTextSize(li.f(getContext(), R.dimen.T_X06));
            this.b.setSelectedIndicatorBottomMargin(li.f(getContext(), R.dimen.tbds5));
            this.b.setupWithViewPager(this.c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wq4.d(this.e).v(R.color.CAM_X0105);
            this.b.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.b.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setCurrentItem(0);
            for (z35 z35Var : this.f) {
                ((VideoTopicListFragment) z35Var.a).F0();
            }
        }
    }

    public void setSelectTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.d.setSelectTopicId(j);
            if (ListUtils.isEmpty(this.f)) {
                return;
            }
            for (z35 z35Var : this.f) {
                if (z35Var.e == 1) {
                    ((VideoTopicListFragment) z35Var.a).G0(j);
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
