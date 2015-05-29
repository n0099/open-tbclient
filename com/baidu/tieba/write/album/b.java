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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private View bWU;
    private p cxU;
    private com.baidu.tbadk.img.e cxX;
    private AlbumActivity cxZ;
    private j cya;
    private ImageView cyb;
    private View cyc;
    private int mCurrentIndex = -1;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cxZ = (AlbumActivity) getBaseFragmentActivity();
        this.cxU = this.cxZ.arC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.r.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.q.navigation_bar);
        this.bWU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cxZ);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.r.album_big_image_choose, (ViewGroup) null);
        this.cyb = (ImageView) inflate.findViewById(com.baidu.tieba.q.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.q.viewPager);
        this.cxX = this.cxZ.arD();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.cyc = this.mRoot.findViewById(com.baidu.tieba.q.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            arJ();
        }
    }

    private void arI() {
        if (this.cxU == null && this.cxZ != null) {
            this.cxU = this.cxZ.arC();
        }
        if (this.cxU != null && this.cxU.arP() != null) {
            int currentIndex = this.cxU.getCurrentIndex();
            if (currentIndex >= 0) {
                this.mCurrentIndex = currentIndex;
                if (this.mCurrentIndex > this.cxU.arP().size() - 1) {
                    this.mCurrentIndex = this.cxU.arP().size() - 1;
                }
                this.cxU.setCurrentIndex(-1);
                jl(this.mCurrentIndex + 1);
                this.cya = null;
                this.cya = new j(this.cxZ, this.cxX);
                this.mViewPager.setAdapter(this.cya);
                if (this.mCurrentIndex == 0 && this.cxU.arP() != null) {
                    if (this.cxU.isAdded(this.cxU.arP().get(this.mCurrentIndex))) {
                        b(this.cyb, true);
                    } else {
                        b(this.cyb, false);
                    }
                }
            }
            this.cya.setData(this.cxU.arP());
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.cya != null) {
            this.cya.setData(null);
        }
    }

    public View afN() {
        return this.bWU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cxZ.getLayoutMode().ab(i == 1);
        this.cxZ.getLayoutMode().j(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cxZ.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                ay.i(imageView, com.baidu.tieba.p.btn_add_finish_s);
            } else {
                ay.i(imageView, com.baidu.tieba.p.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(int i) {
        if (this.cxU != null && this.cxU.arP() != null) {
            String string = this.cxZ.getPageContext().getContext().getString(com.baidu.tieba.t.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.cxU.arP().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo jm;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.cya != null && (jm = this.cya.jm(this.mCurrentIndex)) != null && jm.getFilePath() != null && jm.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.cyb, z);
        }
    }

    private void arJ() {
        if (!isHidden()) {
            this.cyc.setVisibility(8);
            this.mViewPager.setVisibility(0);
            arI();
        }
    }
}
