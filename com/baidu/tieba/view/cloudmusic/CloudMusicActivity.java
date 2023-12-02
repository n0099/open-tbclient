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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BDLayoutMode;
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
import com.baidu.tieba.lq5;
import com.baidu.tieba.mab;
import com.baidu.tieba.nab;
import com.baidu.tieba.oab;
import com.baidu.tieba.pab;
import com.baidu.tieba.sab;
import com.baidu.tieba.v07;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class CloudMusicActivity extends SuspendedActivity implements lq5, pab, sab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar k;
    public oab l;
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

    @Override // com.baidu.tieba.lq5
    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lq5
    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                if (!ListUtils.isEmpty(this.a.q) && this.a.q.size() > i) {
                    CloudMusicListFragment cloudMusicListFragment = (CloudMusicListFragment) this.a.q.get(i);
                    new mab(new CloudMusicListModel(this.a.getPageContext()), cloudMusicListFragment);
                    return cloudMusicListFragment;
                }
                return null;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (ListUtils.isEmpty(this.a.r)) {
                    return "";
                }
                return (CharSequence) this.a.r.get(i);
            }
            return (CharSequence) invokeI.objValue;
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

    @Override // com.baidu.tieba.lq5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.u;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.l.a();
            MusicPlayer.c().f();
            v07.h().d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            MusicPlayer.c().d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onRestart();
            v07.h().e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            MusicPlayer.c().g();
        }
    }

    @Override // com.baidu.tieba.sab
    public void R(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            this.u = intent;
        }
    }

    @Override // com.baidu.tieba.pab
    public void T0(oab oabVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oabVar) == null) {
            this.l = oabVar;
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            BDLayoutMode layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.o;
            if (commonPagerSlidingTabStrip != null) {
                commonPagerSlidingTabStrip.n(i);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.pab
    public void u0(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z && (view2 = this.n) != null) {
                showLoadingView(view2, false, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703d6));
            } else {
                hideLoadingView(this.n);
            }
        }
    }

    @Override // com.baidu.tieba.pab
    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.pab
    public void K(CloudMusicData cloudMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cloudMusicData) == null) {
            this.q = new ArrayList(cloudMusicData.tag_list.size());
            this.r = new ArrayList(cloudMusicData.tag_list.size());
            for (int i = 0; i < cloudMusicData.tag_list.size(); i++) {
                this.r.add(cloudMusicData.tag_list.get(i).name);
                CloudMusicListFragment I2 = CloudMusicListFragment.I2(cloudMusicData.music_tag_list.get(i));
                I2.J2(this);
                I2.K2(this.t);
                this.q.add(I2);
            }
            this.s.notifyDataSetChanged();
            this.o.m();
        }
    }

    @Override // com.baidu.tieba.lq5
    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int currentItem = this.p.getCurrentItem();
            if (currentItem >= this.s.getCount()) {
                return true;
            }
            Fragment item = this.s.getItem(currentItem);
            if (!(item instanceof CloudMusicListFragment)) {
                return true;
            }
            return ((CloudMusicListFragment) item).S();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public lq5 m1(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, linearLayout, navigationBar)) == null) {
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0032, (ViewGroup) linearLayout, true);
            new nab(new CloudMusicModel(getPageContext()), this);
            this.n = findViewById(R.id.obfuscated_res_0x7f090786);
            this.k = navigationBar;
            SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0d40)), (int) R.color.CAM_X0105);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070390)), NoDataViewFactory.e.a(R.string.no_data_text), null);
            this.m = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090788);
            this.o = commonPagerSlidingTabStrip;
            commonPagerSlidingTabStrip.k(BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070201), BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be), BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5), BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224), BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070258), R.color.CAM_X0107, R.color.CAM_X0105);
            BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f090789);
            this.p = bdBaseViewPager;
            bdBaseViewPager.setOffscreenPageLimit(2);
            b bVar = new b(this, getSupportFragmentManager());
            this.s = bVar;
            this.p.setAdapter(bVar);
            this.o.setViewPager(this.p);
            registerListener(this.v);
            oab oabVar = this.l;
            if (oabVar != null) {
                oabVar.b();
            }
            return this;
        }
        return (lq5) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
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
}
