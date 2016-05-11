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
    private View KB;
    private TextView aOG;
    private com.baidu.tbadk.img.b amz;
    private ViewPager asg;
    private int asz = -1;
    private View dHC;
    private AlbumActivity eXM;
    private j eXN;
    private ImageView eXO;
    private o eXx;
    private NavigationBar mNavigationBar;
    private View zg;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXM = (AlbumActivity) getBaseFragmentActivity();
        this.eXx = this.eXM.bbn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.KB = layoutInflater.inflate(t.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.KB.findViewById(t.g.navigation_bar);
        this.dHC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eXM);
        this.aOG = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(t.h.album_big_image_choose, (ViewGroup) null);
        this.eXO = (ImageView) inflate.findViewById(t.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.asg = (ViewPager) this.KB.findViewById(t.g.viewPager);
        this.amz = this.eXM.YI();
        this.asg.setOnPageChangeListener(new g(this));
        this.zg = this.KB.findViewById(t.g.album_no_data);
        return this.KB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbu() {
        if (this.eXx.isOriginalImg()) {
            this.eXM.bbr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bbw();
        }
    }

    private void bbv() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.eXx == null && this.eXM != null) {
            this.eXx = this.eXM.bbn();
        }
        if (this.eXx != null && this.eXx.bbz() != null) {
            if ("-1".equals(this.eXx.bby())) {
                currentIndex = this.eXx.getCurrentIndex() - 1;
            } else {
                currentIndex = this.eXx.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.asz = currentIndex;
                if (this.asz > this.eXx.bbz().size() - 1) {
                    this.asz = this.eXx.bbz().size() - 1;
                }
                this.eXx.qH(-1);
                qK(this.asz + 1);
                this.eXN = null;
                this.eXN = new j(this.eXM, this.amz);
                this.asg.setAdapter(this.eXN);
                if (this.asz == 0 && this.eXx.bbz() != null) {
                    if ("-1".equals(this.eXx.bby())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.eXx.bbz(), this.asz + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.eXx.bbz(), this.asz);
                    }
                    if (this.eXx.isAdded(imageFileInfo)) {
                        b(this.eXO, true);
                    } else {
                        b(this.eXO, false);
                    }
                }
                this.eXN.setData(this.eXx.bbz());
                this.asg.setCurrentItem(this.asz, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.eXN != null) {
            this.eXN.setData(null);
        }
    }

    public View aEo() {
        return this.dHC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eXM.getLayoutMode().ae(i == 1);
        this.eXM.getLayoutMode().x(this.KB);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eXM.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m11getInst().getSkinType();
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
    public void qK(int i) {
        int size;
        if (this.eXx != null && this.eXx.bbz() != null) {
            if ("-1".equals(this.eXx.bby())) {
                size = this.eXx.bbz().size() - 1;
            } else {
                size = this.eXx.bbz().size();
            }
            String string = this.eXM.getPageContext().getContext().getString(t.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aOG.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo qL;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.eXN != null) {
            if ("-1".equals(this.eXx.bby())) {
                qL = this.eXN.qL(this.asz + 1);
            } else {
                qL = this.eXN.qL(this.asz);
            }
            if (qL != null && qL.getFilePath() != null && qL.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.eXO, z);
            }
        }
    }

    private void bbw() {
        if (!isHidden()) {
            this.zg.setVisibility(8);
            this.asg.setVisibility(0);
            bbv();
        }
    }
}
