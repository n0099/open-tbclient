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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View Rr;
    private int aBR = -1;
    private com.baidu.tbadk.img.b avZ;
    private o fMH;
    private AlbumActivity fMV;
    private View fMW;
    private j fMX;
    private ImageView fMY;
    private NavigationBar mNavigationBar;
    private View mNoDataView;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fMV = (AlbumActivity) getBaseFragmentActivity();
        this.fMH = this.fMV.bnn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Rr = layoutInflater.inflate(w.j.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.Rr.findViewById(w.h.navigation_bar);
        this.fMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fMV);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(w.j.album_big_image_choose, (ViewGroup) null);
        this.fMY = (ImageView) inflate.findViewById(w.h.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.mViewPager = (ViewPager) this.Rr.findViewById(w.h.viewPager);
        this.avZ = this.fMV.aho();
        this.mViewPager.setOnPageChangeListener(new g(this));
        this.mNoDataView = this.Rr.findViewById(w.h.album_no_data);
        return this.Rr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnw() {
        if (this.fMH.isOriginalImg()) {
            this.fMV.bns();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bny();
        }
    }

    private void bnx() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fMH == null && this.fMV != null) {
            this.fMH = this.fMV.bnn();
        }
        if (this.fMH != null && this.fMH.bnE() != null) {
            if ("-1".equals(this.fMH.bnD())) {
                currentIndex = this.fMH.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fMH.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.aBR = currentIndex;
                if (this.aBR > this.fMH.bnE().size() - 1) {
                    this.aBR = this.fMH.bnE().size() - 1;
                }
                this.fMH.sK(-1);
                sM(this.aBR + 1);
                this.fMX = null;
                this.fMX = new j(this.fMV, this.avZ);
                this.mViewPager.setAdapter(this.fMX);
                if (this.aBR == 0 && this.fMH.bnE() != null) {
                    if ("-1".equals(this.fMH.bnD())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fMH.bnE(), this.aBR + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fMH.bnE(), this.aBR);
                    }
                    if (this.fMH.isAdded(imageFileInfo)) {
                        c(this.fMY, true);
                    } else {
                        c(this.fMY, false);
                    }
                }
                this.fMX.setData(this.fMH.bnE());
                this.mViewPager.setCurrentItem(this.aBR, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fMX != null) {
            this.fMX.setData(null);
        }
    }

    public View bcM() {
        return this.fMW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fMV.getLayoutMode().aj(i == 1);
        this.fMV.getLayoutMode().t(this.Rr);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fMV.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m9getInst().getSkinType();
            if (z) {
                aq.j(imageView, w.g.btn_add_finish_s);
                imageView.setContentDescription(getString(w.l.check_box_checked));
                return;
            }
            aq.j(imageView, w.g.btn_add_finish_n);
            imageView.setContentDescription(getString(w.l.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM(int i) {
        int size;
        if (this.fMH != null && this.fMH.bnE() != null) {
            if ("-1".equals(this.fMH.bnD())) {
                size = this.fMH.bnE().size() - 1;
            } else {
                size = this.fMH.bnE().size();
            }
            String string = this.fMV.getPageContext().getContext().getString(w.l.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sN;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fMX != null) {
            if ("-1".equals(this.fMH.bnD())) {
                sN = this.fMX.sN(this.aBR + 1);
            } else {
                sN = this.fMX.sN(this.aBR);
            }
            if (sN != null && sN.getFilePath() != null && sN.getFilePath().equals(imageFileInfo.getFilePath())) {
                c(this.fMY, z);
            }
        }
    }

    private void bny() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bnx();
        }
    }
}
