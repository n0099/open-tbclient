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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends BaseFragment {
    private View HL;
    private TextView aPV;
    private int apO = -1;
    private m cPJ;
    private com.baidu.tbadk.img.b cPM;
    private AlbumActivity cPQ;
    private h cPR;
    private ImageView cPS;
    private View cnO;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cPQ = (AlbumActivity) getBaseFragmentActivity();
        this.cPJ = this.cPQ.atA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(i.g.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.navigation_bar);
        this.cnO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cPQ);
        this.aPV = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(i.g.album_big_image_choose, (ViewGroup) null);
        this.cPS = (ImageView) inflate.findViewById(i.f.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new d(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(i.f.viewPager);
        this.cPM = this.cPQ.atB();
        this.mViewPager.setOnPageChangeListener(new e(this));
        this.HL = this.mRoot.findViewById(i.f.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            atH();
        }
    }

    private void atG() {
        if (this.cPJ == null && this.cPQ != null) {
            this.cPJ = this.cPQ.atA();
        }
        if (this.cPJ != null && this.cPJ.atN() != null) {
            int currentIndex = this.cPJ.getCurrentIndex();
            if (currentIndex >= 0) {
                this.apO = currentIndex;
                if (this.apO > this.cPJ.atN().size() - 1) {
                    this.apO = this.cPJ.atN().size() - 1;
                }
                this.cPJ.kj(-1);
                kf(this.apO + 1);
                this.cPR = null;
                this.cPR = new h(this.cPQ, this.cPM);
                this.mViewPager.setAdapter(this.cPR);
                if (this.apO == 0 && this.cPJ.atN() != null) {
                    if (this.cPJ.isAdded(this.cPJ.atN().get(this.apO))) {
                        b(this.cPS, true);
                    } else {
                        b(this.cPS, false);
                    }
                }
            }
            this.cPR.setData(this.cPJ.atN());
            this.mViewPager.setCurrentItem(this.apO, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.cPR != null) {
            this.cPR.setData(null);
        }
    }

    public View ahK() {
        return this.cnO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cPQ.getLayoutMode().ad(i == 1);
        this.cPQ.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cPQ.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                com.baidu.tbadk.core.util.al.i(imageView, i.e.btn_add_finish_s);
            } else {
                com.baidu.tbadk.core.util.al.i(imageView, i.e.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(int i) {
        if (this.cPJ != null && this.cPJ.atN() != null) {
            String string = this.cPQ.getPageContext().getContext().getString(i.C0057i.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.cPJ.atN().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aPV.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo kg;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.cPR != null && (kg = this.cPR.kg(this.apO)) != null && kg.getFilePath() != null && kg.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.cPS, z);
        }
    }

    private void atH() {
        if (!isHidden()) {
            this.HL.setVisibility(8);
            this.mViewPager.setVisibility(0);
            atG();
        }
    }
}
