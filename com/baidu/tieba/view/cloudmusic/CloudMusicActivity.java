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
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicListModel;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import com.repackage.kw8;
import com.repackage.lw8;
import com.repackage.mi;
import com.repackage.mw8;
import com.repackage.nw8;
import com.repackage.qw8;
import com.repackage.y95;
import com.repackage.z76;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CloudMusicActivity extends SuspendedActivity implements y95, nw8, qw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b mCloudMusicPageAdapter;
    public TbMusicData mCurrentMusicData;
    public List<BaseFragment> mFragments;
    public mw8 mICloudMusicPresenter;
    public NavigationBar mNavigationBar;
    public final CustomMessageListener mNetworkChangedMessageListener;
    public NoDataView mNoDataView;
    public Intent mResultIntent;
    public View mRootView;
    public CommonPagerSlidingTabStrip mTabStrip;
    public List<String> mTitles;
    public BdBaseViewPager mViewPager;

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && ki.z() && this.a.mICloudMusicPresenter != null) {
                this.a.mICloudMusicPresenter.b();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (ListUtils.isEmpty(this.a.mFragments)) {
                    return 0;
                }
                return this.a.mFragments.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (ListUtils.isEmpty(this.a.mFragments) || this.a.mFragments.size() <= i) {
                    return null;
                }
                CloudMusicListFragment cloudMusicListFragment = (CloudMusicListFragment) this.a.mFragments.get(i);
                new kw8(new CloudMusicListModel(this.a.getPageContext()), cloudMusicListFragment);
                return cloudMusicListFragment;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? ListUtils.isEmpty(this.a.mTitles) ? "" : (CharSequence) this.a.mTitles.get(i) : (CharSequence) invokeI.objValue;
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
        this.mNetworkChangedMessageListener = new a(this, 2000994);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.repackage.nw8
    public void displayLoading(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z && (view2 = this.mRootView) != null) {
                showLoadingView(view2, false, mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702be));
            } else {
                hideLoadingView(this.mRootView);
            }
        }
    }

    @Override // com.repackage.nw8
    public void displayNoDataView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.mNoDataView.setVisibility(0);
            } else {
                this.mNoDataView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.repackage.y95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mResultIntent : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public y95 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, linearLayout, navigationBar)) == null) {
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0032, (ViewGroup) linearLayout, true);
            new lw8(new CloudMusicModel(getPageContext()), this);
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f090672);
            this.mNavigationBar = navigationBar;
            SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0b1e)), (int) R.color.CAM_X0105);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070270)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c45), null);
            this.mNoDataView = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = (CommonPagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090674);
            this.mTabStrip = commonPagerSlidingTabStrip;
            commonPagerSlidingTabStrip.k(mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070201), mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be), mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5), mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224), mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070258), R.color.CAM_X0107, R.color.CAM_X0105);
            BdBaseViewPager bdBaseViewPager = (BdBaseViewPager) findViewById(R.id.obfuscated_res_0x7f090675);
            this.mViewPager = bdBaseViewPager;
            bdBaseViewPager.setOffscreenPageLimit(2);
            b bVar = new b(this, getSupportFragmentManager());
            this.mCloudMusicPageAdapter = bVar;
            this.mViewPager.setAdapter(bVar);
            this.mTabStrip.setViewPager(this.mViewPager);
            registerListener(this.mNetworkChangedMessageListener);
            mw8 mw8Var = this.mICloudMusicPresenter;
            if (mw8Var != null) {
                mw8Var.b();
            }
            return this;
        }
        return (y95) invokeLL.objValue;
    }

    @Override // com.repackage.y95
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.y95
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int currentItem = this.mViewPager.getCurrentItem();
            if (currentItem >= this.mCloudMusicPageAdapter.getCount()) {
                return true;
            }
            Fragment item = this.mCloudMusicPageAdapter.getItem(currentItem);
            if (item instanceof CloudMusicListFragment) {
                return ((CloudMusicListFragment) item).isOnViewTop();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            getLayoutMode().k(i == 1);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = this.mTabStrip;
            if (commonPagerSlidingTabStrip != null) {
                commonPagerSlidingTabStrip.n(i);
            }
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            TbMusicData tbMusicData = (TbMusicData) getIntent().getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
            this.mCurrentMusicData = tbMusicData;
            if (tbMusicData != null) {
                if (this.mResultIntent == null) {
                    this.mResultIntent = new Intent();
                }
                this.mResultIntent.putExtra(CloudMusicActivityConfig.MUSIC_ID, StringUtils.string(this.mCurrentMusicData.id));
                this.mResultIntent.putExtra(CloudMusicActivityConfig.MUSIC_DATA, this.mCurrentMusicData);
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            this.mICloudMusicPresenter.a();
            MusicPlayer.c().f();
            z76.h().d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            MusicPlayer.c().d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onRestart();
            z76.h().e();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            MusicPlayer.c().g();
        }
    }

    @Override // com.repackage.qw8
    public void onSetResult(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            this.mResultIntent = intent;
        }
    }

    @Override // com.repackage.y95
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.repackage.nw8
    public void setPresenter(mw8 mw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mw8Var) == null) {
            this.mICloudMusicPresenter = mw8Var;
        }
    }

    @Override // com.repackage.nw8
    public void showCloudMusicWithTagData(CloudMusicData cloudMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cloudMusicData) == null) {
            this.mFragments = new ArrayList(cloudMusicData.tag_list.size());
            this.mTitles = new ArrayList(cloudMusicData.tag_list.size());
            for (int i = 0; i < cloudMusicData.tag_list.size(); i++) {
                this.mTitles.add(cloudMusicData.tag_list.get(i).name);
                CloudMusicListFragment E0 = CloudMusicListFragment.E0(cloudMusicData.music_tag_list.get(i));
                E0.F0(this);
                E0.G0(this.mCurrentMusicData);
                this.mFragments.add(E0);
            }
            this.mCloudMusicPageAdapter.notifyDataSetChanged();
            this.mTabStrip.m();
        }
    }
}
