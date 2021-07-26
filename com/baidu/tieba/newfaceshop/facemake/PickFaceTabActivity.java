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
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.d.e.p.l;
import d.a.q0.c2.g.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes4.dex */
public class PickFaceTabActivity extends BaseFragmentActivity implements f {
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickFaceTabActivity f19002e;

        public a(PickFaceTabActivity pickFaceTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickFaceTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19002e = pickFaceTabActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList();
                if (this.f19002e.mSearchFragment != null && this.f19002e.mSearchFragment.b1() != null) {
                    for (Map.Entry<String, EmotionImageData> entry : this.f19002e.mSearchFragment.b1().entrySet()) {
                        FaceData faceData = new FaceData();
                        faceData.type = 2;
                        faceData.emotionImageData = entry.getValue();
                        arrayList.add(faceData);
                    }
                }
                if (this.f19002e.mAlbumFragment != null && this.f19002e.mAlbumFragment.Q0() != null) {
                    for (Map.Entry<String, ImageFileInfo> entry2 : this.f19002e.mAlbumFragment.Q0().entrySet()) {
                        FaceData faceData2 = new FaceData();
                        faceData2.type = 3;
                        faceData2.imageFileInfo = entry2.getValue();
                        arrayList.add(faceData2);
                    }
                }
                if (this.f19002e.mCollectFragment != null && this.f19002e.mCollectFragment.Q0() != null) {
                    for (Map.Entry<String, EmotionImageData> entry3 : this.f19002e.mCollectFragment.Q0().entrySet()) {
                        FaceData faceData3 = new FaceData();
                        faceData3.type = 1;
                        faceData3.emotionImageData = entry3.getValue();
                        arrayList.add(faceData3);
                    }
                }
                intent.putExtra(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
                this.f19002e.setResult(-1, intent);
                this.f19002e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickFaceTabActivity f19003e;

        public b(PickFaceTabActivity pickFaceTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickFaceTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19003e = pickFaceTabActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f19003e.setTitleText(i2);
            }
        }
    }

    public PickFaceTabActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mChoosedNum = 0;
        this.mOnPageChangeListener = new b(this);
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f12395c = fragment;
        bVar.f12393a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        bVar.f12394b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            FaceSearchFragment faceSearchFragment = new FaceSearchFragment();
            this.mSearchFragment = faceSearchFragment;
            faceSearchFragment.h1(this);
            FaceAlbumFragment faceAlbumFragment = new FaceAlbumFragment();
            this.mAlbumFragment = faceAlbumFragment;
            faceAlbumFragment.U0(this);
            FaceCollectFragment faceCollectFragment = new FaceCollectFragment();
            this.mCollectFragment = faceCollectFragment;
            faceCollectFragment.S0(this);
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
            createAndAddTabSpec(this.mSearchFragment, 1, this.mActivity.getText(R.string.face_group_make_search).toString());
            createAndAddTabSpec(this.mAlbumFragment, 3, this.mActivity.getText(R.string.face_group_make_album).toString());
            createAndAddTabSpec(this.mCollectFragment, 2, this.mActivity.getText(R.string.my_mark).toString());
            this.mTabHost.k(1);
            this.mTabHost.setCurrentTab(0);
            this.mTabHost.getFragmentTabWidget().getLayoutParams().height = l.g(getPageContext().getPageActivity(), R.dimen.ds110);
            this.mTabHost.getFragmentTabWidget().setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d_alpha90));
        }
    }

    private void initTitleBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mLayoutRoot = (LinearLayout) findViewById(R.id.layout_root);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mTitleBar = new FaceGroupMakeTitleBar(getPageContext().getPageActivity());
            this.mTitleBar.setLayoutParams(new RelativeLayout.LayoutParams(l.k(getPageContext().getPageActivity()), -1));
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleBar, (View.OnClickListener) null);
            this.mNoNetView = (NoNetworkView) findViewById(R.id.view_no_network);
            this.mTitleBar.setRightListener(new a(this));
            SkinManager.setBackgroundColor(this.mTitleBar, R.color.CAM_X0201);
            setTitleText(0);
            updateChoosedNum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleText(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i2) == null) || this.mNavigationBar == null) {
            return;
        }
        if (i2 == 0) {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.face_group_tab_search).toString());
        } else if (i2 == 1) {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.album_all).toString());
        } else if (i2 != 2) {
        } else {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.my_mark).toString());
        }
    }

    private void updateChoosedNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            String string = this.mActivity.getString(R.string.add);
            if (this.mChoosedNum > 0) {
                FaceGroupMakeTitleBar faceGroupMakeTitleBar = this.mTitleBar;
                faceGroupMakeTitleBar.setRightText(string + "(" + this.mChoosedNum + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            this.mTitleBar.setRightText(string);
        }
    }

    @Override // d.a.q0.c2.g.f
    public boolean canChooseMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mChoosedNum < 24 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mLayoutRoot);
            SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mSearchFragment.onChangeSkinType(i2);
            this.mCollectFragment.onChangeSkinType(i2);
            this.mAlbumFragment.onChangeSkinType(i2);
            this.mNoNetView.c(getPageContext(), i2);
            this.mTabHost.p(i2);
        }
    }

    @Override // d.a.q0.c2.g.f
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
            setContentView(R.layout.pick_face_tab_activity);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.o(true);
            initTitleBar();
            initFragment();
        }
    }

    @Override // d.a.q0.c2.g.f
    public void onUnChoose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = this.mChoosedNum;
            if (i2 > 0) {
                this.mChoosedNum = i2 - 1;
            }
            updateChoosedNum();
        }
    }
}
