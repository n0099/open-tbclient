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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private View HL;
    private TextView aPf;
    private com.baidu.tbadk.img.b amf;
    private int apY = -1;
    private View cuB;
    private l djp;
    private AlbumActivity djw;
    private g djx;
    private ImageView djy;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djw = (AlbumActivity) getBaseFragmentActivity();
        this.djp = this.djw.aAU();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(i.g.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.navigation_bar);
        this.cuB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.djw);
        this.aPf = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(i.g.album_big_image_choose, (ViewGroup) null);
        this.djy = (ImageView) inflate.findViewById(i.f.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(i.f.viewPager);
        this.amf = this.djw.aAV();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.HL = this.mRoot.findViewById(i.f.album_no_data);
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        if (this.djp.isOriginalImg()) {
            this.djw.aAZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aBe();
        }
    }

    private void aBd() {
        if (this.djp == null && this.djw != null) {
            this.djp = this.djw.aAU();
        }
        if (this.djp != null && this.djp.aBk() != null) {
            int currentIndex = this.djp.getCurrentIndex();
            if (currentIndex >= 0) {
                this.apY = currentIndex;
                if (this.apY > this.djp.aBk().size() - 1) {
                    this.apY = this.djp.aBk().size() - 1;
                }
                this.djp.lJ(-1);
                lF(this.apY + 1);
                this.djx = null;
                this.djx = new g(this.djw, this.amf);
                this.mViewPager.setAdapter(this.djx);
                if (this.apY == 0 && this.djp.aBk() != null) {
                    if (this.djp.isAdded(this.djp.aBk().get(this.apY))) {
                        b(this.djy, true);
                    } else {
                        b(this.djy, false);
                    }
                }
            }
            this.djx.setData(this.djp.aBk());
            this.mViewPager.setCurrentItem(this.apY, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.djx != null) {
            this.djx.setData(null);
        }
    }

    public View akd() {
        return this.cuB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djw.getLayoutMode().ad(i == 1);
        this.djw.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.djw.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                am.i(imageView, i.e.btn_add_finish_s);
            } else {
                am.i(imageView, i.e.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(int i) {
        if (this.djp != null && this.djp.aBk() != null) {
            String string = this.djw.getPageContext().getContext().getString(i.h.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.djp.aBk().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aPf.setText(string);
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo lG;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.djx != null && (lG = this.djx.lG(this.apY)) != null && lG.getFilePath() != null && lG.getFilePath().equals(imageFileInfo.getFilePath())) {
            b(this.djy, z);
        }
    }

    private void aBe() {
        if (!isHidden()) {
            this.HL.setVisibility(8);
            this.mViewPager.setVisibility(0);
            aBd();
        }
    }
}
