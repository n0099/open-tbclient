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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View LW;
    private TextView aNb;
    private com.baidu.tbadk.img.b aqo;
    private int awg = -1;
    private o fGE;
    private AlbumActivity fGS;
    private View fGT;
    private j fGU;
    private ImageView fGV;
    private NavigationBar mNavigationBar;
    private View mNoDataView;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fGS = (AlbumActivity) getBaseFragmentActivity();
        this.fGE = this.fGS.bmQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.LW = layoutInflater.inflate(r.j.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.LW.findViewById(r.h.navigation_bar);
        this.fGT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fGS);
        this.aNb = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(r.j.album_big_image_choose, (ViewGroup) null);
        this.fGV = (ImageView) inflate.findViewById(r.h.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.mViewPager = (ViewPager) this.LW.findViewById(r.h.viewPager);
        this.aqo = this.fGS.aii();
        this.mViewPager.setOnPageChangeListener(new g(this));
        this.mNoDataView = this.LW.findViewById(r.h.album_no_data);
        return this.LW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmZ() {
        if (this.fGE.isOriginalImg()) {
            this.fGS.bmV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bnb();
        }
    }

    private void bna() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fGE == null && this.fGS != null) {
            this.fGE = this.fGS.bmQ();
        }
        if (this.fGE != null && this.fGE.bnh() != null) {
            if ("-1".equals(this.fGE.bng())) {
                currentIndex = this.fGE.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fGE.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.awg = currentIndex;
                if (this.awg > this.fGE.bnh().size() - 1) {
                    this.awg = this.fGE.bnh().size() - 1;
                }
                this.fGE.sN(-1);
                sP(this.awg + 1);
                this.fGU = null;
                this.fGU = new j(this.fGS, this.aqo);
                this.mViewPager.setAdapter(this.fGU);
                if (this.awg == 0 && this.fGE.bnh() != null) {
                    if ("-1".equals(this.fGE.bng())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.w.c(this.fGE.bnh(), this.awg + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.w.c(this.fGE.bnh(), this.awg);
                    }
                    if (this.fGE.isAdded(imageFileInfo)) {
                        b(this.fGV, true);
                    } else {
                        b(this.fGV, false);
                    }
                }
                this.fGU.setData(this.fGE.bnh());
                this.mViewPager.setCurrentItem(this.awg, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fGU != null) {
            this.fGU.setData(null);
        }
    }

    public View bcs() {
        return this.fGT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fGS.getLayoutMode().ai(i == 1);
        this.fGS.getLayoutMode().v(this.LW);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fGS.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m9getInst().getSkinType();
            if (z) {
                com.baidu.tbadk.core.util.ap.j(imageView, r.g.btn_add_finish_s);
                imageView.setContentDescription(getString(r.l.check_box_checked));
                return;
            }
            com.baidu.tbadk.core.util.ap.j(imageView, r.g.btn_add_finish_n);
            imageView.setContentDescription(getString(r.l.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(int i) {
        int size;
        if (this.fGE != null && this.fGE.bnh() != null) {
            if ("-1".equals(this.fGE.bng())) {
                size = this.fGE.bnh().size() - 1;
            } else {
                size = this.fGE.bnh().size();
            }
            String string = this.fGS.getPageContext().getContext().getString(r.l.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aNb.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sQ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fGU != null) {
            if ("-1".equals(this.fGE.bng())) {
                sQ = this.fGU.sQ(this.awg + 1);
            } else {
                sQ = this.fGU.sQ(this.awg);
            }
            if (sQ != null && sQ.getFilePath() != null && sQ.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.fGV, z);
            }
        }
    }

    private void bnb() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bna();
        }
    }
}
