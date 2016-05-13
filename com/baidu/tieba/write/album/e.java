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
    private AlbumActivity eXL;
    private j eXM;
    private ImageView eXN;
    private o eXw;
    private NavigationBar mNavigationBar;
    private View zg;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXL = (AlbumActivity) getBaseFragmentActivity();
        this.eXw = this.eXL.bbu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.KB = layoutInflater.inflate(t.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.KB.findViewById(t.g.navigation_bar);
        this.dHC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eXL);
        this.aOG = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(t.h.album_big_image_choose, (ViewGroup) null);
        this.eXN = (ImageView) inflate.findViewById(t.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.asg = (ViewPager) this.KB.findViewById(t.g.viewPager);
        this.amz = this.eXL.YK();
        this.asg.setOnPageChangeListener(new g(this));
        this.zg = this.KB.findViewById(t.g.album_no_data);
        return this.KB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbB() {
        if (this.eXw.isOriginalImg()) {
            this.eXL.bby();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bbD();
        }
    }

    private void bbC() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.eXw == null && this.eXL != null) {
            this.eXw = this.eXL.bbu();
        }
        if (this.eXw != null && this.eXw.bbG() != null) {
            if ("-1".equals(this.eXw.bbF())) {
                currentIndex = this.eXw.getCurrentIndex() - 1;
            } else {
                currentIndex = this.eXw.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.asz = currentIndex;
                if (this.asz > this.eXw.bbG().size() - 1) {
                    this.asz = this.eXw.bbG().size() - 1;
                }
                this.eXw.qG(-1);
                qJ(this.asz + 1);
                this.eXM = null;
                this.eXM = new j(this.eXL, this.amz);
                this.asg.setAdapter(this.eXM);
                if (this.asz == 0 && this.eXw.bbG() != null) {
                    if ("-1".equals(this.eXw.bbF())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.eXw.bbG(), this.asz + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.eXw.bbG(), this.asz);
                    }
                    if (this.eXw.isAdded(imageFileInfo)) {
                        b(this.eXN, true);
                    } else {
                        b(this.eXN, false);
                    }
                }
                this.eXM.setData(this.eXw.bbG());
                this.asg.setCurrentItem(this.asz, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.eXM != null) {
            this.eXM.setData(null);
        }
    }

    public View aEr() {
        return this.dHC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eXL.getLayoutMode().ae(i == 1);
        this.eXL.getLayoutMode().x(this.KB);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eXL.getPageContext(), i);
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
    public void qJ(int i) {
        int size;
        if (this.eXw != null && this.eXw.bbG() != null) {
            if ("-1".equals(this.eXw.bbF())) {
                size = this.eXw.bbG().size() - 1;
            } else {
                size = this.eXw.bbG().size();
            }
            String string = this.eXL.getPageContext().getContext().getString(t.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aOG.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo qK;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.eXM != null) {
            if ("-1".equals(this.eXw.bbF())) {
                qK = this.eXM.qK(this.asz + 1);
            } else {
                qK = this.eXM.qK(this.asz);
            }
            if (qK != null && qK.getFilePath() != null && qK.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.eXN, z);
            }
        }
    }

    private void bbD() {
        if (!isHidden()) {
            this.zg.setVisibility(8);
            this.asg.setVisibility(0);
            bbC();
        }
    }
}
