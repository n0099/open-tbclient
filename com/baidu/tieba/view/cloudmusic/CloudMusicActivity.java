package com.baidu.tieba.view.cloudmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.b09;
import com.baidu.tieba.ej;
import com.baidu.tieba.ie5;
import com.baidu.tieba.jc6;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.tieba.vz8;
import com.baidu.tieba.wz8;
import com.baidu.tieba.xz8;
import com.baidu.tieba.yz8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class CloudMusicActivity extends SuspendedActivity implements ie5, yz8, b09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar k;
    public xz8 l;
    public NoDataView m;
    public View n;
    public CommonPagerSlidingTabStrip o;
    public BdBaseViewPager p;
    public List<BaseFragment> q;
    public List<String> r;
    public b s;
    public TbMusicData t;
    public Intent u;
    public final CustomMessageListener v;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CloudMusicActivity cloudMusicActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudMusicActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cloudMusicActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable() && this.a.l != null) {
                this.a.l.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CloudMusicActivity cloudMusicActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudMusicActivity, fragmentManager};
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
            this.a = cloudMusicActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ListUtils.isEmpty(this.a.q)) {
                    return 0;
                }
                return this.a.q.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (ListUtils.isEmpty(this.a.q) || this.a.q.size() <= i) {
                    return null;
                }
                CloudMusicListFragment cloudMusicListFragment = (CloudMusicListFragment) this.a.q.get(i);
                new vz8(new CloudMusicListModel(this.a.getPageContext()), cloudMusicListFragment);
                return cloudMusicListFragment;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? ListUtils.isEmpty(this.a.r) ? "" : (CharSequence) this.a.r.get(i) : (CharSequence) invokeI.objValue;
        }
    }

    public CloudMusicActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new a(this, 2000994);
    }

    @Override // com.baidu.tieba.yz8
    public void A0(xz8 xz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xz8Var) == null) {
            this.l = xz8Var;
        }
    }

    @Override // com.baidu.tieba.yz8
    public void B(CloudMusicData cloudMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudMusicData) == null) {
            this.q = new ArrayList(cloudMusicData.tag_list.size());
            this.r = new ArrayList(cloudMusicData.tag_list.size());
            for (int i = 0; i < cloudMusicData.tag_list.size(); i++) {
                this.r.add(cloudMusicData.tag_list.get(i).name);
                CloudMusicListFragment s1 = CloudMusicListFragment.s1(cloudMusicData.music_tag_list.get(i));
                s1.t1(this);
                s1.u1(this.t);
                this.q.add(s1);
            }
            this.s.notifyDataSetChanged();
            this.o.m();
        }
    }

    @Override // com.baidu.tieba.ie5
    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public ie5 N0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, linearLayout, navigationBar)) == null) {
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0031, (ViewGroup) linearLayout, true);
            new wz8(new CloudMusicModel(getPageContext()), this);
            this.n = findViewById(R.id.obfuscated_res_0x7f090665);
            this.k = navigationBar;
            SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0b42)), (int) R.color.CAM_X0105);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026c)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c73), null);
            this.m = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090667);
            this.o = commonPagerSlidingTabStrip;
            commonPagerSlidingTabStrip.k(ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070201), ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be), ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5), ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224), ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070258), R.color.CAM_X0107, R.color.CAM_X0105);
            BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f090668);
            this.p = bdBaseViewPager;
            bdBaseViewPager.setOffscreenPageLimit(2);
            b bVar = new b(this, getSupportFragmentManager());
            this.s = bVar;
            this.p.setAdapter(bVar);
            this.o.setViewPager(this.p);
            registerListener(this.v);
            xz8 xz8Var = this.l;
            if (xz8Var != null) {
                xz8Var.b();
            }
            return this;
        }
        return (ie5) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.b09
    public void X(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            this.u = intent;
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tieba.ie5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.u : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yz8
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.yz8
    public void l0(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z && (view2 = this.n) != null) {
                showLoadingView(view2, false, ej.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702bb));
            } else {
                hideLoadingView(this.n);
            }
        }
    }

    @Override // com.baidu.tieba.ie5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            getLayoutMode().l(i == 1);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.o;
            if (commonPagerSlidingTabStrip != null) {
                commonPagerSlidingTabStrip.n(i);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            TbMusicData tbMusicData = (TbMusicData) getIntent().getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
            this.t = tbMusicData;
            if (tbMusicData != null) {
                if (this.u == null) {
                    this.u = new Intent();
                }
                this.u.putExtra(CloudMusicActivityConfig.MUSIC_ID, StringUtils.string(this.t.id));
                this.u.putExtra(CloudMusicActivityConfig.MUSIC_DATA, this.t);
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            this.l.a();
            MusicPlayer.c().f();
            jc6.h().d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            MusicPlayer.c().d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onRestart();
            jc6.h().e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            MusicPlayer.c().g();
        }
    }

    @Override // com.baidu.tieba.ie5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int currentItem = this.p.getCurrentItem();
            if (currentItem >= this.s.getCount()) {
                return true;
            }
            Fragment item = this.s.getItem(currentItem);
            if (item instanceof CloudMusicListFragment) {
                return ((CloudMusicListFragment) item).s();
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
