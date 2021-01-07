package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes9.dex */
public class PickFaceTabActivity extends BaseFragmentActivity implements f {
    private NoNetworkView fOl;
    private FaceGroupMakeTitleBar lxh;
    private LinearLayout lxj;
    private FaceSearchFragment lyQ;
    private FaceCollectFragment lyR;
    private FaceAlbumFragment lyS;
    private Activity mActivity;
    private NavigationBar mNavigationBar;
    private FragmentTabHost mTabHost;
    private int iVJ = 0;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.newfaceshop.facemake.PickFaceTabActivity.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PickFaceTabActivity.this.setTitleText(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mActivity = getPageContext().getPageActivity();
        setContentView(R.layout.pick_face_tab_activity);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mTabHost.setShouldDrawIndicatorLine(false);
        this.mTabHost.needShowTopDiver(true);
        Lh();
        WG();
    }

    private void Lh() {
        this.lxj = (LinearLayout) findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.lxh = new FaceGroupMakeTitleBar(getPageContext().getPageActivity());
        this.lxh.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), -1));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.lxh, (View.OnClickListener) null);
        this.fOl = (NoNetworkView) findViewById(R.id.view_no_network);
        this.lxh.setRightListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.PickFaceTabActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList();
                if (PickFaceTabActivity.this.lyQ != null && PickFaceTabActivity.this.lyQ.dkm() != null) {
                    for (Map.Entry<String, EmotionImageData> entry : PickFaceTabActivity.this.lyQ.dkm().entrySet()) {
                        FaceData faceData = new FaceData();
                        faceData.type = 2;
                        faceData.emotionImageData = entry.getValue();
                        arrayList.add(faceData);
                    }
                }
                if (PickFaceTabActivity.this.lyS != null && PickFaceTabActivity.this.lyS.dkm() != null) {
                    for (Map.Entry<String, ImageFileInfo> entry2 : PickFaceTabActivity.this.lyS.dkm().entrySet()) {
                        FaceData faceData2 = new FaceData();
                        faceData2.type = 3;
                        faceData2.imageFileInfo = entry2.getValue();
                        arrayList.add(faceData2);
                    }
                }
                if (PickFaceTabActivity.this.lyR != null && PickFaceTabActivity.this.lyR.dkm() != null) {
                    for (Map.Entry<String, EmotionImageData> entry3 : PickFaceTabActivity.this.lyR.dkm().entrySet()) {
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
        });
        ao.setBackgroundColor(this.lxh, R.color.CAM_X0201);
        setTitleText(0);
        cCm();
    }

    private void WG() {
        ArrayList arrayList;
        this.lyQ = new FaceSearchFragment();
        this.lyQ.a(this);
        this.lyS = new FaceAlbumFragment();
        this.lyS.a(this);
        this.lyR = new FaceCollectFragment();
        this.lyR.a(this);
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST);
            if (serializableExtra == null || !(serializableExtra instanceof ArrayList)) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) serializableExtra;
            }
            if (!x.isEmpty(arrayList)) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
                this.lyQ.setArguments(bundle);
                this.lyR.setArguments(bundle);
                this.lyS.setArguments(bundle);
                this.iVJ = arrayList.size();
                cCm();
            }
        }
        a(this.lyQ, 1, this.mActivity.getText(R.string.face_group_make_search).toString());
        a(this.lyS, 3, this.mActivity.getText(R.string.face_group_make_album).toString());
        a(this.lyR, 2, this.mActivity.getText(R.string.my_mark).toString());
        this.mTabHost.initViewPager(1);
        this.mTabHost.setCurrentTab(0);
        this.mTabHost.getFragmentTabWidget().getLayoutParams().height = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds110);
        this.mTabHost.getFragmentTabWidget().setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d_alpha90));
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            bVar.mContentFragment = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            bVar.fbC = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lxj);
        ao.setBackgroundResource(this.lxj, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lyQ.onChangeSkinType(i);
        this.lyR.onChangeSkinType(i);
        this.lyS.onChangeSkinType(i);
        this.fOl.onChangeSkinType(getPageContext(), i);
        this.mTabHost.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleText(int i) {
        if (this.mNavigationBar != null) {
            switch (i) {
                case 0:
                    this.lxh.setTitle(this.mActivity.getText(R.string.face_group_tab_search).toString());
                    return;
                case 1:
                    this.lxh.setTitle(this.mActivity.getText(R.string.album_all).toString());
                    return;
                case 2:
                    this.lxh.setTitle(this.mActivity.getText(R.string.my_mark).toString());
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void cCj() {
        this.iVJ++;
        cCm();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void cCk() {
        if (this.iVJ > 0) {
            this.iVJ--;
        }
        cCm();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public boolean cCl() {
        return this.iVJ < 24;
    }

    private void cCm() {
        String string = this.mActivity.getString(R.string.add);
        if (this.iVJ > 0) {
            this.lxh.setRightText(string + "(" + this.iVJ + ")");
        } else {
            this.lxh.setRightText(string);
        }
    }
}
