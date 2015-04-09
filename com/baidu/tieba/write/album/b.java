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
    private View bUn;
    private n ctF;
    private com.baidu.tbadk.img.e ctI;
    private AlbumActivity ctK;
    private h ctL;
    private ImageView ctM;
    private View ctN;
    private int mCurrentIndex = -1;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctK = (AlbumActivity) getBaseFragmentActivity();
        this.ctF = this.ctK.apM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.navigation_bar);
        this.bUn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ctK);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_choose, (ViewGroup) null);
        this.ctM = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.v.viewPager);
        this.ctI = this.ctK.apN();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.ctN = this.mRoot.findViewById(com.baidu.tieba.v.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            apT();
        }
    }

    private void apS() {
        if (this.ctF == null && this.ctK != null) {
            this.ctF = this.ctK.apM();
        }
        if (this.ctF != null && this.ctF.apZ() != null) {
            int currentIndex = this.ctF.getCurrentIndex();
            if (currentIndex >= 0) {
                this.mCurrentIndex = currentIndex;
                if (this.mCurrentIndex > this.ctF.apZ().size() - 1) {
                    this.mCurrentIndex = this.ctF.apZ().size() - 1;
                }
                this.ctF.setCurrentIndex(-1);
                iP(this.mCurrentIndex + 1);
                this.ctL = null;
                this.ctL = new h(this.ctK, this.ctI);
                this.mViewPager.setAdapter(this.ctL);
                if (this.mCurrentIndex == 0 && this.ctF.apZ() != null) {
                    if (this.ctF.isAdded(this.ctF.apZ().get(this.mCurrentIndex))) {
                        b(this.ctM, true);
                    } else {
                        b(this.ctM, false);
                    }
                }
            }
            this.ctL.setData(this.ctF.apZ());
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.ctL != null) {
            this.ctL.setData(null);
        }
    }

    public View aeH() {
        return this.bUn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctK.getLayoutMode().X(i == 1);
        this.ctK.getLayoutMode().h(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ctK.getPageContext(), i);
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
    public void iP(int i) {
        if (this.ctF != null && this.ctF.apZ() != null) {
            String string = this.ctK.getPageContext().getContext().getString(com.baidu.tieba.y.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.ctF.apZ().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo iQ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.ctL != null && (iQ = this.ctL.iQ(this.mCurrentIndex)) != null && iQ.getFilePath() != null && iQ.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.ctM, z);
        }
    }

    private void apT() {
        if (!isHidden()) {
            this.ctN.setVisibility(8);
            this.mViewPager.setVisibility(0);
            apS();
        }
    }
}
