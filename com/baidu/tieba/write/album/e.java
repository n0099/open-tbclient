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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View Ie;
    private TextView aUB;
    private com.baidu.tbadk.img.b anY;
    private int atv = -1;
    private View cTp;
    private AlbumActivity dKK;
    private j dKL;
    private ImageView dKM;
    private o dKx;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dKK = (AlbumActivity) getBaseFragmentActivity();
        this.dKx = this.dKK.aHn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(n.g.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.navigation_bar);
        this.cTp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dKK);
        this.aUB = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(n.g.album_big_image_choose, (ViewGroup) null);
        this.dKM = (ImageView) inflate.findViewById(n.f.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(n.f.viewPager);
        this.anY = this.dKK.aHo();
        this.mViewPager.setOnPageChangeListener(new g(this));
        this.Ie = this.mRoot.findViewById(n.f.album_no_data);
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHv() {
        if (this.dKx.isOriginalImg()) {
            this.dKK.aHs();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aHx();
        }
    }

    private void aHw() {
        int currentIndex;
        if (this.dKx == null && this.dKK != null) {
            this.dKx = this.dKK.aHn();
        }
        if (this.dKx != null && this.dKx.aHD() != null) {
            if ("-1".equals(this.dKx.aHC())) {
                currentIndex = this.dKx.getCurrentIndex() - 1;
            } else {
                currentIndex = this.dKx.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.atv = currentIndex;
                if (this.atv > this.dKx.aHD().size() - 1) {
                    this.atv = this.dKx.aHD().size() - 1;
                }
                this.dKx.nl(-1);
                nh(this.atv + 1);
                this.dKL = null;
                this.dKL = new j(this.dKK, this.anY);
                this.mViewPager.setAdapter(this.dKL);
                if (this.atv == 0 && this.dKx.aHD() != null) {
                    if (this.dKx.isAdded(this.dKx.aHD().get(this.atv))) {
                        b(this.dKM, true);
                    } else {
                        b(this.dKM, false);
                    }
                }
                this.dKL.setData(this.dKx.aHD());
                this.mViewPager.setCurrentItem(this.atv, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.dKL != null) {
            this.dKL.setData(null);
        }
    }

    public View apG() {
        return this.cTp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dKK.getLayoutMode().af(i == 1);
        this.dKK.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dKK.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                as.i(imageView, n.e.btn_add_finish_s);
            } else {
                as.i(imageView, n.e.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nh(int i) {
        int size;
        if (this.dKx != null && this.dKx.aHD() != null) {
            if ("-1".equals(this.dKx.aHC())) {
                size = this.dKx.aHD().size() - 1;
            } else {
                size = this.dKx.aHD().size();
            }
            String string = this.dKK.getPageContext().getContext().getString(n.i.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aUB.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo ni;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.dKL != null && (ni = this.dKL.ni(this.atv)) != null && ni.getFilePath() != null && ni.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.dKM, z);
        }
    }

    private void aHx() {
        if (!isHidden()) {
            this.Ie.setVisibility(8);
            this.mViewPager.setVisibility(0);
            aHw();
        }
    }
}
