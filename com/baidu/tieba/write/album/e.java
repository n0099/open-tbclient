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
    private View Rt;
    private int aBT = -1;
    private com.baidu.tbadk.img.b awb;
    private o fPd;
    private AlbumActivity fPr;
    private View fPs;
    private j fPt;
    private ImageView fPu;
    private NavigationBar mNavigationBar;
    private View mNoDataView;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fPr = (AlbumActivity) getBaseFragmentActivity();
        this.fPd = this.fPr.boo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Rt = layoutInflater.inflate(w.j.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.Rt.findViewById(w.h.navigation_bar);
        this.fPs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fPr);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(w.j.album_big_image_choose, (ViewGroup) null);
        this.fPu = (ImageView) inflate.findViewById(w.h.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.mViewPager = (ViewPager) this.Rt.findViewById(w.h.viewPager);
        this.awb = this.fPr.aip();
        this.mViewPager.setOnPageChangeListener(new g(this));
        this.mNoDataView = this.Rt.findViewById(w.h.album_no_data);
        return this.Rt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void box() {
        if (this.fPd.isOriginalImg()) {
            this.fPr.bot();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            boz();
        }
    }

    private void boy() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fPd == null && this.fPr != null) {
            this.fPd = this.fPr.boo();
        }
        if (this.fPd != null && this.fPd.boF() != null) {
            if ("-1".equals(this.fPd.boE())) {
                currentIndex = this.fPd.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fPd.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.aBT = currentIndex;
                if (this.aBT > this.fPd.boF().size() - 1) {
                    this.aBT = this.fPd.boF().size() - 1;
                }
                this.fPd.sQ(-1);
                sS(this.aBT + 1);
                this.fPt = null;
                this.fPt = new j(this.fPr, this.awb);
                this.mViewPager.setAdapter(this.fPt);
                if (this.aBT == 0 && this.fPd.boF() != null) {
                    if ("-1".equals(this.fPd.boE())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fPd.boF(), this.aBT + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fPd.boF(), this.aBT);
                    }
                    if (this.fPd.isAdded(imageFileInfo)) {
                        c(this.fPu, true);
                    } else {
                        c(this.fPu, false);
                    }
                }
                this.fPt.setData(this.fPd.boF());
                this.mViewPager.setCurrentItem(this.aBT, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fPt != null) {
            this.fPt.setData(null);
        }
    }

    public View bdN() {
        return this.fPs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fPr.getLayoutMode().aj(i == 1);
        this.fPr.getLayoutMode().t(this.Rt);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fPr.getPageContext(), i);
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
    public void sS(int i) {
        int size;
        if (this.fPd != null && this.fPd.boF() != null) {
            if ("-1".equals(this.fPd.boE())) {
                size = this.fPd.boF().size() - 1;
            } else {
                size = this.fPd.boF().size();
            }
            String string = this.fPr.getPageContext().getContext().getString(w.l.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sT;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fPt != null) {
            if ("-1".equals(this.fPd.boE())) {
                sT = this.fPt.sT(this.aBT + 1);
            } else {
                sT = this.fPt.sT(this.aBT);
            }
            if (sT != null && sT.getFilePath() != null && sT.getFilePath().equals(imageFileInfo.getFilePath())) {
                c(this.fPu, z);
            }
        }
    }

    private void boz() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            boy();
        }
    }
}
