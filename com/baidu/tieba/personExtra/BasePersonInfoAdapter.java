package com.baidu.tieba.personExtra;

import android.os.Bundle;
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
/* loaded from: classes5.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f20000a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f20001b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {basePersonInfoActivity, Boolean.valueOf(z)};
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
        this.f20001b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment e2 = e();
        e2.setArguments(bundle);
        this.f20001b.add(e2);
        if (z) {
            this.f20000a = new int[]{0};
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment e3 = e();
        e3.setArguments(bundle2);
        this.f20001b.add(e3);
        this.f20000a = new int[]{0, 1};
    }

    public abstract BaseFragment e();

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20000a.length : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 >= this.f20000a.length || i2 < 0) {
                return null;
            }
            return this.f20001b.get(i2);
        }
        return (Fragment) invokeI.objValue;
    }

    public int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f20000a[i2] : invokeI.intValue;
    }
}
