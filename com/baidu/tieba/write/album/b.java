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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private View HM;
    private TextView aPq;
    private com.baidu.tbadk.img.b amg;
    private int apZ = -1;
    private View cuM;
    private l djP;
    private AlbumActivity djW;
    private g djX;
    private ImageView djY;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djW = (AlbumActivity) getBaseFragmentActivity();
        this.djP = this.djW.aBe();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(i.g.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.navigation_bar);
        this.cuM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.djW);
        this.aPq = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(i.g.album_big_image_choose, (ViewGroup) null);
        this.djY = (ImageView) inflate.findViewById(i.f.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(i.f.viewPager);
        this.amg = this.djW.aBf();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.HM = this.mRoot.findViewById(i.f.album_no_data);
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBm() {
        if (this.djP.isOriginalImg()) {
            this.djW.aBj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aBo();
        }
    }

    private void aBn() {
        if (this.djP == null && this.djW != null) {
            this.djP = this.djW.aBe();
        }
        if (this.djP != null && this.djP.aBu() != null) {
            int currentIndex = this.djP.getCurrentIndex();
            if (currentIndex >= 0) {
                this.apZ = currentIndex;
                if (this.apZ > this.djP.aBu().size() - 1) {
                    this.apZ = this.djP.aBu().size() - 1;
                }
                this.djP.lL(-1);
                lH(this.apZ + 1);
                this.djX = null;
                this.djX = new g(this.djW, this.amg);
                this.mViewPager.setAdapter(this.djX);
                if (this.apZ == 0 && this.djP.aBu() != null) {
                    if (this.djP.isAdded(this.djP.aBu().get(this.apZ))) {
                        b(this.djY, true);
                    } else {
                        b(this.djY, false);
                    }
                }
            }
            this.djX.setData(this.djP.aBu());
            this.mViewPager.setCurrentItem(this.apZ, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.djX != null) {
            this.djX.setData(null);
        }
    }

    public View akd() {
        return this.cuM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djW.getLayoutMode().ad(i == 1);
        this.djW.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.djW.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                an.i(imageView, i.e.btn_add_finish_s);
            } else {
                an.i(imageView, i.e.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(int i) {
        if (this.djP != null && this.djP.aBu() != null) {
            String string = this.djW.getPageContext().getContext().getString(i.h.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.djP.aBu().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aPq.setText(string);
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo lI;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.djX != null && (lI = this.djX.lI(this.apZ)) != null && lI.getFilePath() != null && lI.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.djY, z);
        }
    }

    private void aBo() {
        if (!isHidden()) {
            this.HM.setVisibility(8);
            this.mViewPager.setVisibility(0);
            aBn();
        }
    }
}
