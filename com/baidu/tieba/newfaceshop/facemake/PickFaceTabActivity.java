package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lo7;
import com.repackage.mi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class PickFaceTabActivity extends BaseFragmentActivity implements lo7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALBUM_TYPE = 3;
    public static final int COLLECT_TYPE = 2;
    public static final int SEARCH_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public FaceAlbumFragment mAlbumFragment;
    public int mChoosedNum;
    public FaceCollectFragment mCollectFragment;
    public LinearLayout mLayoutRoot;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public ViewPager.OnPageChangeListener mOnPageChangeListener;
    public FaceSearchFragment mSearchFragment;
    public FragmentTabHost mTabHost;
    public FaceGroupMakeTitleBar mTitleBar;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickFaceTabActivity a;

        public a(PickFaceTabActivity pickFaceTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickFaceTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickFaceTabActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList();
                if (this.a.mSearchFragment != null && this.a.mSearchFragment.R0() != null) {
                    for (Map.Entry<String, EmotionImageData> entry : this.a.mSearchFragment.R0().entrySet()) {
                        FaceData faceData = new FaceData();
                        faceData.type = 2;
                        faceData.emotionImageData = entry.getValue();
                        arrayList.add(faceData);
                    }
                }
                if (this.a.mAlbumFragment != null && this.a.mAlbumFragment.G0() != null) {
                    for (Map.Entry<String, ImageFileInfo> entry2 : this.a.mAlbumFragment.G0().entrySet()) {
                        FaceData faceData2 = new FaceData();
                        faceData2.type = 3;
                        faceData2.imageFileInfo = entry2.getValue();
                        arrayList.add(faceData2);
                    }
                }
                if (this.a.mCollectFragment != null && this.a.mCollectFragment.G0() != null) {
                    for (Map.Entry<String, EmotionImageData> entry3 : this.a.mCollectFragment.G0().entrySet()) {
                        FaceData faceData3 = new FaceData();
                        faceData3.type = 1;
                        faceData3.emotionImageData = entry3.getValue();
                        arrayList.add(faceData3);
                    }
                }
                intent.putExtra(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickFaceTabActivity a;

        public b(PickFaceTabActivity pickFaceTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickFaceTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickFaceTabActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.setTitleText(i);
            }
        }
    }

    public PickFaceTabActivity() {
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
        this.mChoosedNum = 0;
        this.mOnPageChangeListener = new b(this);
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65541, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.c = fragment;
        bVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        bVar.b = fragmentTabIndicator;
        this.mTabHost.c(bVar);
    }

    private void initFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            FaceSearchFragment faceSearchFragment = new FaceSearchFragment();
            this.mSearchFragment = faceSearchFragment;
            faceSearchFragment.X0(this);
            FaceAlbumFragment faceAlbumFragment = new FaceAlbumFragment();
            this.mAlbumFragment = faceAlbumFragment;
            faceAlbumFragment.K0(this);
            FaceCollectFragment faceCollectFragment = new FaceCollectFragment();
            this.mCollectFragment = faceCollectFragment;
            faceCollectFragment.I0(this);
            Intent intent = getIntent();
            if (intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST);
                ArrayList arrayList = (serializableExtra == null || !(serializableExtra instanceof ArrayList)) ? null : (ArrayList) serializableExtra;
                if (!ListUtils.isEmpty(arrayList)) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
                    this.mSearchFragment.setArguments(bundle);
                    this.mCollectFragment.setArguments(bundle);
                    this.mAlbumFragment.setArguments(bundle);
                    this.mChoosedNum = arrayList.size();
                    updateChoosedNum();
                }
            }
            createAndAddTabSpec(this.mSearchFragment, 1, this.mActivity.getText(R.string.obfuscated_res_0x7f0f05e0).toString());
            createAndAddTabSpec(this.mAlbumFragment, 3, this.mActivity.getText(R.string.obfuscated_res_0x7f0f05dc).toString());
            createAndAddTabSpec(this.mCollectFragment, 2, this.mActivity.getText(R.string.obfuscated_res_0x7f0f0b45).toString());
            this.mTabHost.n(1);
            this.mTabHost.setCurrentTab(0);
            this.mTabHost.getFragmentTabWidget().getLayoutParams().height = mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070239);
            this.mTabHost.getFragmentTabWidget().setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d_alpha90));
        }
    }

    private void initTitleBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mLayoutRoot = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911f9);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091534);
            this.mTitleBar = new FaceGroupMakeTitleBar(getPageContext().getPageActivity());
            this.mTitleBar.setLayoutParams(new RelativeLayout.LayoutParams(mi.k(getPageContext().getPageActivity()), -1));
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleBar, (View.OnClickListener) null);
            this.mNoNetView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0923ff);
            this.mTitleBar.setRightListener(new a(this));
            SkinManager.setBackgroundColor(this.mTitleBar, R.color.CAM_X0201);
            setTitleText(0);
            updateChoosedNum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleText(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i) == null) || this.mNavigationBar == null) {
            return;
        }
        if (i == 0) {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.obfuscated_res_0x7f0f05e4).toString());
        } else if (i == 1) {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.obfuscated_res_0x7f0f024a).toString());
        } else if (i != 2) {
        } else {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.obfuscated_res_0x7f0f0b45).toString());
        }
    }

    private void updateChoosedNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            String string = this.mActivity.getString(R.string.obfuscated_res_0x7f0f00b8);
            if (this.mChoosedNum > 0) {
                FaceGroupMakeTitleBar faceGroupMakeTitleBar = this.mTitleBar;
                faceGroupMakeTitleBar.setRightText(string + "(" + this.mChoosedNum + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            this.mTitleBar.setRightText(string);
        }
    }

    @Override // com.repackage.lo7
    public boolean canChooseMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mChoosedNum < 24 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mLayoutRoot);
            SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mSearchFragment.onChangeSkinType(i);
            this.mCollectFragment.onChangeSkinType(i);
            this.mAlbumFragment.onChangeSkinType(i);
            this.mNoNetView.c(getPageContext(), i);
            this.mTabHost.s(i);
        }
    }

    @Override // com.repackage.lo7
    public void onChoose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mChoosedNum++;
            updateChoosedNum();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.mActivity = getPageContext().getPageActivity();
            setContentView(R.layout.obfuscated_res_0x7f0d06dc);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091e88);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.r(true);
            initTitleBar();
            initFragment();
        }
    }

    @Override // com.repackage.lo7
    public void onUnChoose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = this.mChoosedNum;
            if (i > 0) {
                this.mChoosedNum = i - 1;
            }
            updateChoosedNum();
        }
    }
}
