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

    /* renamed from: a  reason: collision with root package name */
    public List<String> f19762a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f19763b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, videoPbFragment};
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
        if (this.f19762a == null) {
            this.f19762a = new ArrayList();
        }
        this.f19762a.clear();
        if (videoPbFragment.I3()) {
            this.f19762a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
            this.f19762a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        } else {
            this.f19762a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        }
        if (this.f19763b == null) {
            this.f19763b = new ArrayList<>();
        }
        this.f19763b.clear();
        if (videoPbFragment.I3()) {
            this.f19763b.add(DetailInfoFragment.S0(videoPbFragment));
            this.f19763b.add(ReplyFragment.h1(videoPbFragment));
            return;
        }
        this.f19763b.add(DetailInfoAndReplyFragment.k1(videoPbFragment));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<BaseFragment> arrayList = this.f19763b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i(i2) : (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<String> list = this.f19762a;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f19762a.get(i2);
        }
        return (CharSequence) invokeI.objValue;
    }

    public BaseFragment i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ArrayList<BaseFragment> arrayList = this.f19763b;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f19763b.get(i2);
        }
        return (BaseFragment) invokeI.objValue;
    }

    public ArrayList<BaseFragment> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19763b : (ArrayList) invokeV.objValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f19763b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f19763b.size()) {
            if (this.f19763b.get(i3) != null) {
                this.f19763b.get(i3).setPrimary(i3 == i2);
            }
            i3++;
        }
    }
}
