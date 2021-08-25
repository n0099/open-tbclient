package com.baidu.tieba.imMessageCenter.mention;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MessageFragmentPagerAdapter extends FragmentPagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f53374a;

    /* renamed from: b  reason: collision with root package name */
    public int f53375b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53376c;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Fragment f53377a;

        /* renamed from: b  reason: collision with root package name */
        public String f53378b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager};
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
        this.f53375b = -1;
        this.f53374a = new ArrayList();
    }

    public void add(a aVar) {
        List<a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (list = this.f53374a) == null || aVar == null) {
            return;
        }
        list.add(aVar);
        notifyDataSetChanged();
    }

    public void addAll(List<a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f53374a == null || list == null || list.size() <= 0) {
            return;
        }
        this.f53374a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<a> list = this.f53374a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            List<a> list = this.f53374a;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f53374a.get(i2) == null) {
                return null;
            }
            return this.f53374a.get(i2).f53377a;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<a> list = this.f53374a;
            if (list != null && i2 >= 0 && i2 < list.size() && this.f53374a.get(i2) != null) {
                return this.f53374a.get(i2).hashCode();
            }
            return super.getItemId(i2);
        }
        return invokeI.longValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<a> list = this.f53374a;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f53374a.get(i2) == null) {
                return null;
            }
            return this.f53374a.get(i2).f53378b;
        }
        return (CharSequence) invokeI.objValue;
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f53376c = z;
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (!this.f53376c || (i3 = this.f53375b) == i2) {
                return;
            }
            if (i3 != -1) {
                ((BaseFragment) getItem(i3)).setPrimary(false);
            }
            this.f53375b = i2;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageFragmentPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53375b = -1;
        this.f53374a = new ArrayList();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f53374a.addAll(list);
    }

    public void add(a aVar, int i2) {
        List<a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2) == null) || (list = this.f53374a) == null || aVar == null || i2 < 0 || i2 > list.size()) {
            return;
        }
        this.f53374a.add(i2, aVar);
        notifyDataSetChanged();
    }

    public void addAll(List<a> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) || this.f53374a == null || list == null || list.size() <= 0 || i2 < 0 || i2 > this.f53374a.size()) {
            return;
        }
        this.f53374a.addAll(i2, list);
        notifyDataSetChanged();
    }
}
