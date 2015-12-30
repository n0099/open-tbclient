package com.baidu.tieba.write.album;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View Iu;
    private TextView aOn;
    private com.baidu.tbadk.img.b apC;
    private int auZ = -1;
    private View cYb;
    private o dRW;
    private AlbumActivity dSj;
    private j dSk;
    private ImageView dSl;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dSj = (AlbumActivity) getBaseFragmentActivity();
        this.dRW = this.dSj.aJH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(n.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.navigation_bar);
        this.cYb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dSj);
        this.aOn = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(n.h.album_big_image_choose, (ViewGroup) null);
        this.dSl = (ImageView) inflate.findViewById(n.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(n.g.viewPager);
        this.apC = this.dSj.aJI();
        this.mViewPager.setOnPageChangeListener(new g(this));
        this.Iu = this.mRoot.findViewById(n.g.album_no_data);
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJQ() {
        if (this.dRW.isOriginalImg()) {
            this.dSj.aJM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aJS();
        }
    }

    private void aJR() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.dRW == null && this.dSj != null) {
            this.dRW = this.dSj.aJH();
        }
        if (this.dRW != null && this.dRW.aJY() != null) {
            if ("-1".equals(this.dRW.aJX())) {
                currentIndex = this.dRW.getCurrentIndex() - 1;
            } else {
                currentIndex = this.dRW.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.auZ = currentIndex;
                if (this.auZ > this.dRW.aJY().size() - 1) {
                    this.auZ = this.dRW.aJY().size() - 1;
                }
                this.dRW.od(-1);
                nZ(this.auZ + 1);
                this.dSk = null;
                this.dSk = new j(this.dSj, this.apC);
                this.mViewPager.setAdapter(this.dSk);
                if (this.auZ == 0 && this.dRW.aJY() != null) {
                    if ("-1".equals(this.dRW.aJX())) {
                        imageFileInfo = this.dRW.aJY().get(this.auZ + 1);
                    } else {
                        imageFileInfo = this.dRW.aJY().get(this.auZ);
                    }
                    if (this.dRW.isAdded(imageFileInfo)) {
                        b(this.dSl, true);
                    } else {
                        b(this.dSl, false);
                    }
                }
                this.dSk.setData(this.dRW.aJY());
                this.mViewPager.setCurrentItem(this.auZ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.dSk != null) {
            this.dSk.setData(null);
        }
    }

    public View aqV() {
        return this.cYb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dSj.getLayoutMode().ac(i == 1);
        this.dSj.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dSj.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                as.i(imageView, n.f.btn_add_finish_s);
            } else {
                as.i(imageView, n.f.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(int i) {
        int size;
        if (this.dRW != null && this.dRW.aJY() != null) {
            if ("-1".equals(this.dRW.aJX())) {
                size = this.dRW.aJY().size() - 1;
            } else {
                size = this.dRW.aJY().size();
            }
            String string = this.dSj.getPageContext().getContext().getString(n.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aOn.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo oa;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.dSk != null) {
            if ("-1".equals(this.dRW.aJX())) {
                oa = this.dSk.oa(this.auZ + 1);
            } else {
                oa = this.dSk.oa(this.auZ);
            }
            if (oa != null && oa.getFilePath() != null && oa.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.dSl, z);
            }
        }
    }

    private void aJS() {
        if (!isHidden()) {
            this.Iu.setVisibility(8);
            this.mViewPager.setVisibility(0);
            aJR();
        }
    }
}
