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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View IP;
    private View PL;
    private TextView aSh;
    private ViewPager aim;
    private com.baidu.tbadk.img.b aqL;
    private int awy = -1;
    private View dEn;
    private o eGD;
    private AlbumActivity eGS;
    private j eGT;
    private ImageView eGU;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eGS = (AlbumActivity) getBaseFragmentActivity();
        this.eGD = this.eGS.aYX();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.PL = layoutInflater.inflate(t.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.PL.findViewById(t.g.navigation_bar);
        this.dEn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eGS);
        this.aSh = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(t.h.album_big_image_choose, (ViewGroup) null);
        this.eGU = (ImageView) inflate.findViewById(t.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.aim = (ViewPager) this.PL.findViewById(t.g.viewPager);
        this.aqL = this.eGS.YO();
        this.aim.setOnPageChangeListener(new g(this));
        this.IP = this.PL.findViewById(t.g.album_no_data);
        return this.PL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZe() {
        if (this.eGD.isOriginalImg()) {
            this.eGS.aZb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aZg();
        }
    }

    private void aZf() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.eGD == null && this.eGS != null) {
            this.eGD = this.eGS.aYX();
        }
        if (this.eGD != null && this.eGD.aZk() != null) {
            if ("-1".equals(this.eGD.aZj())) {
                currentIndex = this.eGD.getCurrentIndex() - 1;
            } else {
                currentIndex = this.eGD.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.awy = currentIndex;
                if (this.awy > this.eGD.aZk().size() - 1) {
                    this.awy = this.eGD.aZk().size() - 1;
                }
                this.eGD.qr(-1);
                qn(this.awy + 1);
                this.eGT = null;
                this.eGT = new j(this.eGS, this.aqL);
                this.aim.setAdapter(this.eGT);
                if (this.awy == 0 && this.eGD.aZk() != null) {
                    if ("-1".equals(this.eGD.aZj())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.eGD.aZk(), this.awy + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.eGD.aZk(), this.awy);
                    }
                    if (this.eGD.isAdded(imageFileInfo)) {
                        b(this.eGU, true);
                    } else {
                        b(this.eGU, false);
                    }
                }
                this.eGT.setData(this.eGD.aZk());
                this.aim.setCurrentItem(this.awy, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.eGT != null) {
            this.eGT.setData(null);
        }
    }

    public View aDR() {
        return this.dEn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eGS.getLayoutMode().ab(i == 1);
        this.eGS.getLayoutMode().x(this.PL);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eGS.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                at.k(imageView, t.f.btn_add_finish_s);
                imageView.setContentDescription(getString(t.j.check_box_checked));
                return;
            }
            at.k(imageView, t.f.btn_add_finish_n);
            imageView.setContentDescription(getString(t.j.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(int i) {
        int size;
        if (this.eGD != null && this.eGD.aZk() != null) {
            if ("-1".equals(this.eGD.aZj())) {
                size = this.eGD.aZk().size() - 1;
            } else {
                size = this.eGD.aZk().size();
            }
            String string = this.eGS.getPageContext().getContext().getString(t.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aSh.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo qo;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.eGT != null) {
            if ("-1".equals(this.eGD.aZj())) {
                qo = this.eGT.qo(this.awy + 1);
            } else {
                qo = this.eGT.qo(this.awy);
            }
            if (qo != null && qo.getFilePath() != null && qo.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.eGU, z);
            }
        }
    }

    private void aZg() {
        if (!isHidden()) {
            this.IP.setVisibility(8);
            this.aim.setVisibility(0);
            aZf();
        }
    }
}
