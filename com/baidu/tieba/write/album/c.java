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
    private TextView aQj;
    private int ary = -1;
    private AlbumActivity cYB;
    private h cYC;
    private ImageView cYD;
    private m cYt;
    private com.baidu.tbadk.img.b cYw;
    private View coP;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cYB = (AlbumActivity) getBaseFragmentActivity();
        this.cYt = this.cYB.axT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(i.g.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.navigation_bar);
        this.coP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cYB);
        this.aQj = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(i.g.album_big_image_choose, (ViewGroup) null);
        this.cYD = (ImageView) inflate.findViewById(i.f.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new d(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(i.f.viewPager);
        this.cYw = this.cYB.axU();
        this.mViewPager.setOnPageChangeListener(new e(this));
        this.HL = this.mRoot.findViewById(i.f.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aya();
        }
    }

    private void axZ() {
        if (this.cYt == null && this.cYB != null) {
            this.cYt = this.cYB.axT();
        }
        if (this.cYt != null && this.cYt.ayg() != null) {
            int currentIndex = this.cYt.getCurrentIndex();
            if (currentIndex >= 0) {
                this.ary = currentIndex;
                if (this.ary > this.cYt.ayg().size() - 1) {
                    this.ary = this.cYt.ayg().size() - 1;
                }
                this.cYt.kU(-1);
                kQ(this.ary + 1);
                this.cYC = null;
                this.cYC = new h(this.cYB, this.cYw);
                this.mViewPager.setAdapter(this.cYC);
                if (this.ary == 0 && this.cYt.ayg() != null) {
                    if (this.cYt.isAdded(this.cYt.ayg().get(this.ary))) {
                        b(this.cYD, true);
                    } else {
                        b(this.cYD, false);
                    }
                }
            }
            this.cYC.setData(this.cYt.ayg());
            this.mViewPager.setCurrentItem(this.ary, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.cYC != null) {
            this.cYC.setData(null);
        }
    }

    public View aic() {
        return this.coP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cYB.getLayoutMode().ad(i == 1);
        this.cYB.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cYB.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                com.baidu.tbadk.core.util.al.h(imageView, i.e.btn_add_finish_s);
            } else {
                com.baidu.tbadk.core.util.al.h(imageView, i.e.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kQ(int i) {
        if (this.cYt != null && this.cYt.ayg() != null) {
            String string = this.cYB.getPageContext().getContext().getString(i.h.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.cYt.ayg().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aQj.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo kR;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.cYC != null && (kR = this.cYC.kR(this.ary)) != null && kR.getFilePath() != null && kR.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.cYD, z);
        }
    }

    private void aya() {
        if (!isHidden()) {
            this.HL.setVisibility(8);
            this.mViewPager.setVisibility(0);
            axZ();
        }
    }
}
