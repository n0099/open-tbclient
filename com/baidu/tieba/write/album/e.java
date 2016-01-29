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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View IJ;
    private View Sn;
    private TextView aPr;
    private ViewPager ahW;
    private com.baidu.tbadk.img.b aqu;
    private int avR = -1;
    private View djN;
    private o emG;
    private AlbumActivity emU;
    private j emV;
    private ImageView emW;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.emU = (AlbumActivity) getBaseFragmentActivity();
        this.emG = this.emU.aSv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Sn = layoutInflater.inflate(t.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.Sn.findViewById(t.g.navigation_bar);
        this.djN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.emU);
        this.aPr = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(t.h.album_big_image_choose, (ViewGroup) null);
        this.emW = (ImageView) inflate.findViewById(t.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.ahW = (ViewPager) this.Sn.findViewById(t.g.viewPager);
        this.aqu = this.emU.aSw();
        this.ahW.setOnPageChangeListener(new g(this));
        this.IJ = this.Sn.findViewById(t.g.album_no_data);
        return this.Sn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSE() {
        if (this.emG.isOriginalImg()) {
            this.emU.aSA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aSG();
        }
    }

    private void aSF() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.emG == null && this.emU != null) {
            this.emG = this.emU.aSv();
        }
        if (this.emG != null && this.emG.aSK() != null) {
            if ("-1".equals(this.emG.aSJ())) {
                currentIndex = this.emG.getCurrentIndex() - 1;
            } else {
                currentIndex = this.emG.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.avR = currentIndex;
                if (this.avR > this.emG.aSK().size() - 1) {
                    this.avR = this.emG.aSK().size() - 1;
                }
                this.emG.py(-1);
                pu(this.avR + 1);
                this.emV = null;
                this.emV = new j(this.emU, this.aqu);
                this.ahW.setAdapter(this.emV);
                if (this.avR == 0 && this.emG.aSK() != null) {
                    if ("-1".equals(this.emG.aSJ())) {
                        imageFileInfo = this.emG.aSK().get(this.avR + 1);
                    } else {
                        imageFileInfo = this.emG.aSK().get(this.avR);
                    }
                    if (this.emG.isAdded(imageFileInfo)) {
                        b(this.emW, true);
                    } else {
                        b(this.emW, false);
                    }
                }
                this.emV.setData(this.emG.aSK());
                this.ahW.setCurrentItem(this.avR, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.emV != null) {
            this.emV.setData(null);
        }
    }

    public View awm() {
        return this.djN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emU.getLayoutMode().ac(i == 1);
        this.emU.getLayoutMode().x(this.Sn);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.emU.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m411getInst().getSkinType();
            if (z) {
                ar.k(imageView, t.f.btn_add_finish_s);
            } else {
                ar.k(imageView, t.f.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(int i) {
        int size;
        if (this.emG != null && this.emG.aSK() != null) {
            if ("-1".equals(this.emG.aSJ())) {
                size = this.emG.aSK().size() - 1;
            } else {
                size = this.emG.aSK().size();
            }
            String string = this.emU.getPageContext().getContext().getString(t.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aPr.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.emV != null) {
            if ("-1".equals(this.emG.aSJ())) {
                pv = this.emV.pv(this.avR + 1);
            } else {
                pv = this.emV.pv(this.avR);
            }
            if (pv != null && pv.getFilePath() != null && pv.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.emW, z);
            }
        }
    }

    private void aSG() {
        if (!isHidden()) {
            this.IJ.setVisibility(8);
            this.ahW.setVisibility(0);
            aSF();
        }
    }
}
