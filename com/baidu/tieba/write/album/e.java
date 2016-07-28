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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View KA;
    private TextView aSZ;
    private com.baidu.tbadk.img.b anU;
    private ViewPager atL;
    private int aue = -1;
    private View eCs;
    private o fPM;
    private AlbumActivity fQb;
    private j fQc;
    private ImageView fQd;
    private NavigationBar mNavigationBar;
    private View zG;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fQb = (AlbumActivity) getBaseFragmentActivity();
        this.fPM = this.fQb.bnk();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.KA = layoutInflater.inflate(u.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.KA.findViewById(u.g.navigation_bar);
        this.eCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fQb);
        this.aSZ = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(u.h.album_big_image_choose, (ViewGroup) null);
        this.fQd = (ImageView) inflate.findViewById(u.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.atL = (ViewPager) this.KA.findViewById(u.g.viewPager);
        this.anU = this.fQb.afG();
        this.atL.setOnPageChangeListener(new g(this));
        this.zG = this.KA.findViewById(u.g.album_no_data);
        return this.KA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnt() {
        if (this.fPM.isOriginalImg()) {
            this.fQb.bnp();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bnv();
        }
    }

    private void bnu() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fPM == null && this.fQb != null) {
            this.fPM = this.fQb.bnk();
        }
        if (this.fPM != null && this.fPM.bny() != null) {
            if ("-1".equals(this.fPM.bnx())) {
                currentIndex = this.fPM.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fPM.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.aue = currentIndex;
                if (this.aue > this.fPM.bny().size() - 1) {
                    this.aue = this.fPM.bny().size() - 1;
                }
                this.fPM.ss(-1);
                su(this.aue + 1);
                this.fQc = null;
                this.fQc = new j(this.fQb, this.anU);
                this.atL.setAdapter(this.fQc);
                if (this.aue == 0 && this.fPM.bny() != null) {
                    if ("-1".equals(this.fPM.bnx())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.fPM.bny(), this.aue + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.fPM.bny(), this.aue);
                    }
                    if (this.fPM.isAdded(imageFileInfo)) {
                        b(this.fQd, true);
                    } else {
                        b(this.fQd, false);
                    }
                }
                this.fQc.setData(this.fPM.bny());
                this.atL.setCurrentItem(this.aue, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fQc != null) {
            this.fQc.setData(null);
        }
    }

    public View aQp() {
        return this.eCs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fQb.getLayoutMode().af(i == 1);
        this.fQb.getLayoutMode().w(this.KA);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fQb.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m10getInst().getSkinType();
            if (z) {
                av.k(imageView, u.f.btn_add_finish_s);
                imageView.setContentDescription(getString(u.j.check_box_checked));
                return;
            }
            av.k(imageView, u.f.btn_add_finish_n);
            imageView.setContentDescription(getString(u.j.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(int i) {
        int size;
        if (this.fPM != null && this.fPM.bny() != null) {
            if ("-1".equals(this.fPM.bnx())) {
                size = this.fPM.bny().size() - 1;
            } else {
                size = this.fPM.bny().size();
            }
            String string = this.fQb.getPageContext().getContext().getString(u.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aSZ.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fQc != null) {
            if ("-1".equals(this.fPM.bnx())) {
                sv = this.fQc.sv(this.aue + 1);
            } else {
                sv = this.fQc.sv(this.aue);
            }
            if (sv != null && sv.getFilePath() != null && sv.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.fQd, z);
            }
        }
    }

    private void bnv() {
        if (!isHidden()) {
            this.zG.setVisibility(8);
            this.atL.setVisibility(0);
            bnu();
        }
    }
}
