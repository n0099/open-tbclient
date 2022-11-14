package com.baidu.tieba.pb.videopb;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public ArrayList<BaseFragment> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbFragmentAdapter(FragmentManager fragmentManager, AbsVideoPbFragment absVideoPbFragment) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, absVideoPbFragment};
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
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        if (absVideoPbFragment.x4()) {
            this.a.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e40));
            this.a.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e48));
        } else {
            this.a.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e48));
        }
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        this.b.clear();
        if (absVideoPbFragment.x4()) {
            this.b.add(DetailInfoFragment.D1(absVideoPbFragment));
            this.b.add(ReplyFragment.S1(absVideoPbFragment));
            return;
        }
        this.b.add(DetailInfoAndReplyFragment.W1(absVideoPbFragment));
    }

    public BaseFragment b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<BaseFragment> arrayList = this.b;
            if (arrayList != null && i < arrayList.size()) {
                return this.b.get(i);
            }
            return null;
        }
        return (BaseFragment) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return b(i);
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            List<String> list = this.a;
            if (list != null && i >= 0 && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (CharSequence) invokeI.objValue;
    }

    public ArrayList<BaseFragment> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<BaseFragment> arrayList = this.b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public void d(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (this.b.get(i2) != null) {
                BaseFragment baseFragment = this.b.get(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                baseFragment.setPrimary(z);
            }
        }
    }
}
