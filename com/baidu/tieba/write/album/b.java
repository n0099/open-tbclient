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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private View bTX;
    private n ctp;
    private com.baidu.tbadk.img.e cts;
    private AlbumActivity ctu;
    private h ctv;
    private ImageView ctw;
    private View ctx;
    private int mCurrentIndex = -1;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctu = (AlbumActivity) getBaseFragmentActivity();
        this.ctp = this.ctu.apx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.navigation_bar);
        this.bTX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ctu);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_choose, (ViewGroup) null);
        this.ctw = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.v.viewPager);
        this.cts = this.ctu.apy();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.ctx = this.mRoot.findViewById(com.baidu.tieba.v.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            apE();
        }
    }

    private void apD() {
        if (this.ctp == null && this.ctu != null) {
            this.ctp = this.ctu.apx();
        }
        if (this.ctp != null && this.ctp.apK() != null) {
            int currentIndex = this.ctp.getCurrentIndex();
            if (currentIndex >= 0) {
                this.mCurrentIndex = currentIndex;
                if (this.mCurrentIndex > this.ctp.apK().size() - 1) {
                    this.mCurrentIndex = this.ctp.apK().size() - 1;
                }
                this.ctp.setCurrentIndex(-1);
                iM(this.mCurrentIndex + 1);
                this.ctv = null;
                this.ctv = new h(this.ctu, this.cts);
                this.mViewPager.setAdapter(this.ctv);
                if (this.mCurrentIndex == 0 && this.ctp.apK() != null) {
                    if (this.ctp.isAdded(this.ctp.apK().get(this.mCurrentIndex))) {
                        b(this.ctw, true);
                    } else {
                        b(this.ctw, false);
                    }
                }
            }
            this.ctv.setData(this.ctp.apK());
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.ctv != null) {
            this.ctv.setData(null);
        }
    }

    public View aes() {
        return this.bTX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctu.getLayoutMode().X(i == 1);
        this.ctu.getLayoutMode().h(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ctu.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                ba.i(imageView, com.baidu.tieba.u.btn_add_finish_s);
            } else {
                ba.i(imageView, com.baidu.tieba.u.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(int i) {
        if (this.ctp != null && this.ctp.apK() != null) {
            String string = this.ctu.getPageContext().getContext().getString(com.baidu.tieba.y.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.ctp.apK().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo iN;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.ctv != null && (iN = this.ctv.iN(this.mCurrentIndex)) != null && iN.getFilePath() != null && iN.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.ctw, z);
        }
    }

    private void apE() {
        if (!isHidden()) {
            this.ctx.setVisibility(8);
            this.mViewPager.setVisibility(0);
            apD();
        }
    }
}
