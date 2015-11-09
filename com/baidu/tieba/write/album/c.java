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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends BaseFragment {
    private View HN;
    private TextView aPy;
    private com.baidu.tbadk.img.b aml;
    private int aru = -1;
    private View cwi;
    private AlbumActivity dlE;
    private h dlF;
    private ImageView dlG;
    private m dlv;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dlE = (AlbumActivity) getBaseFragmentActivity();
        this.dlv = this.dlE.aBQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(i.g.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.navigation_bar);
        this.cwi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dlE);
        this.aPy = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(i.g.album_big_image_choose, (ViewGroup) null);
        this.dlG = (ImageView) inflate.findViewById(i.f.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new d(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(i.f.viewPager);
        this.aml = this.dlE.aBR();
        this.mViewPager.setOnPageChangeListener(new e(this));
        this.HN = this.mRoot.findViewById(i.f.album_no_data);
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBY() {
        if (this.dlv.isOriginalImg()) {
            this.dlE.aBV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aCa();
        }
    }

    private void aBZ() {
        if (this.dlv == null && this.dlE != null) {
            this.dlv = this.dlE.aBQ();
        }
        if (this.dlv != null && this.dlv.aCg() != null) {
            int currentIndex = this.dlv.getCurrentIndex();
            if (currentIndex >= 0) {
                this.aru = currentIndex;
                if (this.aru > this.dlv.aCg().size() - 1) {
                    this.aru = this.dlv.aCg().size() - 1;
                }
                this.dlv.lZ(-1);
                lV(this.aru + 1);
                this.dlF = null;
                this.dlF = new h(this.dlE, this.aml);
                this.mViewPager.setAdapter(this.dlF);
                if (this.aru == 0 && this.dlv.aCg() != null) {
                    if (this.dlv.isAdded(this.dlv.aCg().get(this.aru))) {
                        b(this.dlG, true);
                    } else {
                        b(this.dlG, false);
                    }
                }
            }
            this.dlF.setData(this.dlv.aCg());
            this.mViewPager.setCurrentItem(this.aru, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.dlF != null) {
            this.dlF.setData(null);
        }
    }

    public View akF() {
        return this.cwi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dlE.getLayoutMode().ad(i == 1);
        this.dlE.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dlE.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                com.baidu.tbadk.core.util.an.i(imageView, i.e.btn_add_finish_s);
            } else {
                com.baidu.tbadk.core.util.an.i(imageView, i.e.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(int i) {
        if (this.dlv != null && this.dlv.aCg() != null) {
            String string = this.dlE.getPageContext().getContext().getString(i.h.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.dlv.aCg().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aPy.setText(string);
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo lW;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.dlF != null && (lW = this.dlF.lW(this.aru)) != null && lW.getFilePath() != null && lW.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.dlG, z);
        }
    }

    private void aCa() {
        if (!isHidden()) {
            this.HN.setVisibility(8);
            this.mViewPager.setVisibility(0);
            aBZ();
        }
    }
}
