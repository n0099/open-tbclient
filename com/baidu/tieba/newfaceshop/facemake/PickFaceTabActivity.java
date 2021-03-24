package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
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
import d.b.b.e.p.l;
import d.b.i0.x1.g.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes4.dex */
public class PickFaceTabActivity extends BaseFragmentActivity implements f {
    public static final int ALBUM_TYPE = 3;
    public static final int COLLECT_TYPE = 2;
    public static final int SEARCH_TYPE = 1;
    public Activity mActivity;
    public FaceAlbumFragment mAlbumFragment;
    public FaceCollectFragment mCollectFragment;
    public LinearLayout mLayoutRoot;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public FaceSearchFragment mSearchFragment;
    public FragmentTabHost mTabHost;
    public FaceGroupMakeTitleBar mTitleBar;
    public int mChoosedNum = 0;
    public ViewPager.OnPageChangeListener mOnPageChangeListener = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            if (PickFaceTabActivity.this.mSearchFragment != null && PickFaceTabActivity.this.mSearchFragment.T0() != null) {
                for (Map.Entry<String, EmotionImageData> entry : PickFaceTabActivity.this.mSearchFragment.T0().entrySet()) {
                    FaceData faceData = new FaceData();
                    faceData.type = 2;
                    faceData.emotionImageData = entry.getValue();
                    arrayList.add(faceData);
                }
            }
            if (PickFaceTabActivity.this.mAlbumFragment != null && PickFaceTabActivity.this.mAlbumFragment.I0() != null) {
                for (Map.Entry<String, ImageFileInfo> entry2 : PickFaceTabActivity.this.mAlbumFragment.I0().entrySet()) {
                    FaceData faceData2 = new FaceData();
                    faceData2.type = 3;
                    faceData2.imageFileInfo = entry2.getValue();
                    arrayList.add(faceData2);
                }
            }
            if (PickFaceTabActivity.this.mCollectFragment != null && PickFaceTabActivity.this.mCollectFragment.I0() != null) {
                for (Map.Entry<String, EmotionImageData> entry3 : PickFaceTabActivity.this.mCollectFragment.I0().entrySet()) {
                    FaceData faceData3 = new FaceData();
                    faceData3.type = 1;
                    faceData3.emotionImageData = entry3.getValue();
                    arrayList.add(faceData3);
                }
            }
            intent.putExtra(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
            PickFaceTabActivity.this.setResult(-1, intent);
            PickFaceTabActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PickFaceTabActivity.this.setTitleText(i);
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f13312c = fragment;
        bVar.f13310a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        bVar.f13311b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initFragment() {
        FaceSearchFragment faceSearchFragment = new FaceSearchFragment();
        this.mSearchFragment = faceSearchFragment;
        faceSearchFragment.Z0(this);
        FaceAlbumFragment faceAlbumFragment = new FaceAlbumFragment();
        this.mAlbumFragment = faceAlbumFragment;
        faceAlbumFragment.M0(this);
        FaceCollectFragment faceCollectFragment = new FaceCollectFragment();
        this.mCollectFragment = faceCollectFragment;
        faceCollectFragment.K0(this);
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

    private void initTitleBar() {
        this.mLayoutRoot = (LinearLayout) findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleBar = new FaceGroupMakeTitleBar(getPageContext().getPageActivity());
        this.mTitleBar.setLayoutParams(new RelativeLayout.LayoutParams(l.k(getPageContext().getPageActivity()), -1));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleBar, (View.OnClickListener) null);
        this.mNoNetView = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mTitleBar.setRightListener(new a());
        SkinManager.setBackgroundColor(this.mTitleBar, R.color.CAM_X0201);
        setTitleText(0);
        updateChoosedNum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleText(int i) {
        if (this.mNavigationBar != null) {
            if (i == 0) {
                this.mTitleBar.setTitle(this.mActivity.getText(R.string.face_group_tab_search).toString());
            } else if (i == 1) {
                this.mTitleBar.setTitle(this.mActivity.getText(R.string.album_all).toString());
            } else if (i != 2) {
            } else {
                this.mTitleBar.setTitle(this.mActivity.getText(R.string.my_mark).toString());
            }
        }
    }

    private void updateChoosedNum() {
        String string = this.mActivity.getString(R.string.add);
        if (this.mChoosedNum > 0) {
            FaceGroupMakeTitleBar faceGroupMakeTitleBar = this.mTitleBar;
            faceGroupMakeTitleBar.setRightText(string + "(" + this.mChoosedNum + SmallTailInfo.EMOTION_SUFFIX);
            return;
        }
        this.mTitleBar.setRightText(string);
    }

    @Override // d.b.i0.x1.g.f
    public boolean canChooseMore() {
        return this.mChoosedNum < 24;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().k(i == 1);
        getLayoutMode().j(this.mLayoutRoot);
        SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mSearchFragment.onChangeSkinType(i);
        this.mCollectFragment.onChangeSkinType(i);
        this.mAlbumFragment.onChangeSkinType(i);
        this.mNoNetView.c(getPageContext(), i);
        this.mTabHost.o(i);
    }

    @Override // d.b.i0.x1.g.f
    public void onChoose() {
        this.mChoosedNum++;
        updateChoosedNum();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mActivity = getPageContext().getPageActivity();
        setContentView(R.layout.pick_face_tab_activity);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mTabHost.setShouldDrawIndicatorLine(false);
        this.mTabHost.n(true);
        initTitleBar();
        initFragment();
    }

    @Override // d.b.i0.x1.g.f
    public void onUnChoose() {
        int i = this.mChoosedNum;
        if (i > 0) {
            this.mChoosedNum = i - 1;
        }
        updateChoosedNum();
    }
}
