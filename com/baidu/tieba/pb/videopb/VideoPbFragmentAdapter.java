package com.baidu.tieba.pb.videopb;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import c.a.r0.q2.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes11.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f47969b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbFragmentAdapter(FragmentManager fragmentManager, AbsVideoPbFragment absVideoPbFragment) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, absVideoPbFragment};
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
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        if (absVideoPbFragment.isShowDoubleTab()) {
            this.a.add(TbadkCoreApplication.getInst().getString(l.pb_video_detail_info));
            this.a.add(TbadkCoreApplication.getInst().getString(l.pb_video_reply));
        } else {
            this.a.add(TbadkCoreApplication.getInst().getString(l.pb_video_reply));
        }
        if (this.f47969b == null) {
            this.f47969b = new ArrayList<>();
        }
        this.f47969b.clear();
        if (absVideoPbFragment.isShowDoubleTab()) {
            this.f47969b.add(DetailInfoFragment.newInstance(absVideoPbFragment));
            this.f47969b.add(ReplyFragment.newInstance(absVideoPbFragment));
            return;
        }
        this.f47969b.add(DetailInfoAndReplyFragment.newInstance(absVideoPbFragment));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<BaseFragment> arrayList = this.f47969b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public BaseFragment getFragmentByIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ArrayList<BaseFragment> arrayList = this.f47969b;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f47969b.get(i2);
        }
        return (BaseFragment) invokeI.objValue;
    }

    public ArrayList<BaseFragment> getFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47969b : (ArrayList) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? getFragmentByIndex(i2) : (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<String> list = this.a;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.a.get(i2);
        }
        return (CharSequence) invokeI.objValue;
    }

    public void onChangeSkinType(int i2) {
        ArrayList<BaseFragment> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (arrayList = this.f47969b) == null || arrayList.size() <= 0) {
            return;
        }
        int size = this.f47969b.size();
        for (int i3 = 0; i3 < size; i3++) {
            BaseFragment baseFragment = this.f47969b.get(i3);
            if (baseFragment != null) {
                baseFragment.onChangeSkinType(i2);
            }
        }
    }

    public void setItemPrimary(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f47969b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f47969b.size()) {
            if (this.f47969b.get(i3) != null) {
                this.f47969b.get(i3).setPrimary(i3 == i2);
            }
            i3++;
        }
    }
}
