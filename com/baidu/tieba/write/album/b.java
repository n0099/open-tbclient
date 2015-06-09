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
    private View bWV;
    private p cxV;
    private com.baidu.tbadk.img.e cxY;
    private AlbumActivity cya;
    private j cyb;
    private ImageView cyc;
    private View cyd;
    private int mCurrentIndex = -1;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cya = (AlbumActivity) getBaseFragmentActivity();
        this.cxV = this.cya.arD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.r.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.q.navigation_bar);
        this.bWV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cya);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.r.album_big_image_choose, (ViewGroup) null);
        this.cyc = (ImageView) inflate.findViewById(com.baidu.tieba.q.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.q.viewPager);
        this.cxY = this.cya.arE();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.cyd = this.mRoot.findViewById(com.baidu.tieba.q.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            arK();
        }
    }

    private void arJ() {
        if (this.cxV == null && this.cya != null) {
            this.cxV = this.cya.arD();
        }
        if (this.cxV != null && this.cxV.arQ() != null) {
            int currentIndex = this.cxV.getCurrentIndex();
            if (currentIndex >= 0) {
                this.mCurrentIndex = currentIndex;
                if (this.mCurrentIndex > this.cxV.arQ().size() - 1) {
                    this.mCurrentIndex = this.cxV.arQ().size() - 1;
                }
                this.cxV.setCurrentIndex(-1);
                jl(this.mCurrentIndex + 1);
                this.cyb = null;
                this.cyb = new j(this.cya, this.cxY);
                this.mViewPager.setAdapter(this.cyb);
                if (this.mCurrentIndex == 0 && this.cxV.arQ() != null) {
                    if (this.cxV.isAdded(this.cxV.arQ().get(this.mCurrentIndex))) {
                        b(this.cyc, true);
                    } else {
                        b(this.cyc, false);
                    }
                }
            }
            this.cyb.setData(this.cxV.arQ());
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.cyb != null) {
            this.cyb.setData(null);
        }
    }

    public View afO() {
        return this.bWV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cya.getLayoutMode().ab(i == 1);
        this.cya.getLayoutMode().j(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cya.getPageContext(), i);
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
        if (this.cxV != null && this.cxV.arQ() != null) {
            String string = this.cya.getPageContext().getContext().getString(com.baidu.tieba.t.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.cxV.arQ().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo jm;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.cyb != null && (jm = this.cyb.jm(this.mCurrentIndex)) != null && jm.getFilePath() != null && jm.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.cyc, z);
        }
    }

    private void arK() {
        if (!isHidden()) {
            this.cyd.setVisibility(8);
            this.mViewPager.setVisibility(0);
            arJ();
        }
    }
}
