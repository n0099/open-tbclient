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
    private View QZ;
    private int aBB = -1;
    private TextView aSO;
    private com.baidu.tbadk.img.b avJ;
    private o fKY;
    private AlbumActivity fLm;
    private View fLn;
    private j fLo;
    private ImageView fLp;
    private NavigationBar mNavigationBar;
    private View mNoDataView;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fLm = (AlbumActivity) getBaseFragmentActivity();
        this.fKY = this.fLm.bmD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.QZ = layoutInflater.inflate(w.j.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.QZ.findViewById(w.h.navigation_bar);
        this.fLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fLm);
        this.aSO = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(w.j.album_big_image_choose, (ViewGroup) null);
        this.fLp = (ImageView) inflate.findViewById(w.h.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.mViewPager = (ViewPager) this.QZ.findViewById(w.h.viewPager);
        this.avJ = this.fLm.ahu();
        this.mViewPager.setOnPageChangeListener(new g(this));
        this.mNoDataView = this.QZ.findViewById(w.h.album_no_data);
        return this.QZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmM() {
        if (this.fKY.isOriginalImg()) {
            this.fLm.bmI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bmO();
        }
    }

    private void bmN() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fKY == null && this.fLm != null) {
            this.fKY = this.fLm.bmD();
        }
        if (this.fKY != null && this.fKY.bmU() != null) {
            if ("-1".equals(this.fKY.bmT())) {
                currentIndex = this.fKY.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fKY.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.aBB = currentIndex;
                if (this.aBB > this.fKY.bmU().size() - 1) {
                    this.aBB = this.fKY.bmU().size() - 1;
                }
                this.fKY.sM(-1);
                sO(this.aBB + 1);
                this.fLo = null;
                this.fLo = new j(this.fLm, this.avJ);
                this.mViewPager.setAdapter(this.fLo);
                if (this.aBB == 0 && this.fKY.bmU() != null) {
                    if ("-1".equals(this.fKY.bmT())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fKY.bmU(), this.aBB + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fKY.bmU(), this.aBB);
                    }
                    if (this.fKY.isAdded(imageFileInfo)) {
                        b(this.fLp, true);
                    } else {
                        b(this.fLp, false);
                    }
                }
                this.fLo.setData(this.fKY.bmU());
                this.mViewPager.setCurrentItem(this.aBB, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fLo != null) {
            this.fLo.setData(null);
        }
    }

    public View bcd() {
        return this.fLn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fLm.getLayoutMode().ah(i == 1);
        this.fLm.getLayoutMode().t(this.QZ);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fLm.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
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
    public void sO(int i) {
        int size;
        if (this.fKY != null && this.fKY.bmU() != null) {
            if ("-1".equals(this.fKY.bmT())) {
                size = this.fKY.bmU().size() - 1;
            } else {
                size = this.fKY.bmU().size();
            }
            String string = this.fLm.getPageContext().getContext().getString(w.l.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aSO.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fLo != null) {
            if ("-1".equals(this.fKY.bmT())) {
                sP = this.fLo.sP(this.aBB + 1);
            } else {
                sP = this.fLo.sP(this.aBB);
            }
            if (sP != null && sP.getFilePath() != null && sP.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.fLp, z);
            }
        }
    }

    private void bmO() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bmN();
        }
    }
}
