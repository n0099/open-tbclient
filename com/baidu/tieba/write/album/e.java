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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View BV;
    private View MM;
    private TextView aMI;
    private com.baidu.tbadk.img.b aqL;
    private int awO = -1;
    private ViewPager awv;
    private o gbZ;
    private AlbumActivity gco;
    private View gcp;
    private j gcq;
    private ImageView gcr;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gco = (AlbumActivity) getBaseFragmentActivity();
        this.gbZ = this.gco.bsg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.MM = layoutInflater.inflate(r.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.MM.findViewById(r.g.navigation_bar);
        this.gcp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gco);
        this.aMI = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(r.h.album_big_image_choose, (ViewGroup) null);
        this.gcr = (ImageView) inflate.findViewById(r.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.awv = (ViewPager) this.MM.findViewById(r.g.viewPager);
        this.aqL = this.gco.akF();
        this.awv.setOnPageChangeListener(new g(this));
        this.BV = this.MM.findViewById(r.g.album_no_data);
        return this.MM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsp() {
        if (this.gbZ.isOriginalImg()) {
            this.gco.bsl();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bsr();
        }
    }

    private void bsq() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.gbZ == null && this.gco != null) {
            this.gbZ = this.gco.bsg();
        }
        if (this.gbZ != null && this.gbZ.bsu() != null) {
            if ("-1".equals(this.gbZ.bst())) {
                currentIndex = this.gbZ.getCurrentIndex() - 1;
            } else {
                currentIndex = this.gbZ.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.awO = currentIndex;
                if (this.awO > this.gbZ.bsu().size() - 1) {
                    this.awO = this.gbZ.bsu().size() - 1;
                }
                this.gbZ.th(-1);
                tj(this.awO + 1);
                this.gcq = null;
                this.gcq = new j(this.gco, this.aqL);
                this.awv.setAdapter(this.gcq);
                if (this.awO == 0 && this.gbZ.bsu() != null) {
                    if ("-1".equals(this.gbZ.bst())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.gbZ.bsu(), this.awO + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.gbZ.bsu(), this.awO);
                    }
                    if (this.gbZ.isAdded(imageFileInfo)) {
                        b(this.gcr, true);
                    } else {
                        b(this.gcr, false);
                    }
                }
                this.gcq.setData(this.gbZ.bsu());
                this.awv.setCurrentItem(this.awO, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gcq != null) {
            this.gcq.setData(null);
        }
    }

    public View ber() {
        return this.gcp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gco.getLayoutMode().ah(i == 1);
        this.gco.getLayoutMode().x(this.MM);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gco.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m9getInst().getSkinType();
            if (z) {
                av.k(imageView, r.f.btn_add_finish_s);
                imageView.setContentDescription(getString(r.j.check_box_checked));
                return;
            }
            av.k(imageView, r.f.btn_add_finish_n);
            imageView.setContentDescription(getString(r.j.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        int size;
        if (this.gbZ != null && this.gbZ.bsu() != null) {
            if ("-1".equals(this.gbZ.bst())) {
                size = this.gbZ.bsu().size() - 1;
            } else {
                size = this.gbZ.bsu().size();
            }
            String string = this.gco.getPageContext().getContext().getString(r.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aMI.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo tk;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gcq != null) {
            if ("-1".equals(this.gbZ.bst())) {
                tk = this.gcq.tk(this.awO + 1);
            } else {
                tk = this.gcq.tk(this.awO);
            }
            if (tk != null && tk.getFilePath() != null && tk.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.gcr, z);
            }
        }
    }

    private void bsr() {
        if (!isHidden()) {
            this.BV.setVisibility(8);
            this.awv.setVisibility(0);
            bsq();
        }
    }
}
