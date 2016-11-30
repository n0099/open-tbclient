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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View BV;
    private View MM;
    private TextView aOH;
    private ViewPager aiC;
    private com.baidu.tbadk.img.b arF;
    private int axF = -1;
    private o gjE;
    private AlbumActivity gjT;
    private View gjU;
    private j gjV;
    private ImageView gjW;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjT = (AlbumActivity) getBaseFragmentActivity();
        this.gjE = this.gjT.buB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.MM = layoutInflater.inflate(r.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.MM.findViewById(r.g.navigation_bar);
        this.gjU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gjT);
        this.aOH = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(r.h.album_big_image_choose, (ViewGroup) null);
        this.gjW = (ImageView) inflate.findViewById(r.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.aiC = (ViewPager) this.MM.findViewById(r.g.viewPager);
        this.arF = this.gjT.amA();
        this.aiC.setOnPageChangeListener(new g(this));
        this.BV = this.MM.findViewById(r.g.album_no_data);
        return this.MM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buK() {
        if (this.gjE.isOriginalImg()) {
            this.gjT.buG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            buM();
        }
    }

    private void buL() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.gjE == null && this.gjT != null) {
            this.gjE = this.gjT.buB();
        }
        if (this.gjE != null && this.gjE.buP() != null) {
            if ("-1".equals(this.gjE.buO())) {
                currentIndex = this.gjE.getCurrentIndex() - 1;
            } else {
                currentIndex = this.gjE.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.axF = currentIndex;
                if (this.axF > this.gjE.buP().size() - 1) {
                    this.axF = this.gjE.buP().size() - 1;
                }
                this.gjE.tD(-1);
                tF(this.axF + 1);
                this.gjV = null;
                this.gjV = new j(this.gjT, this.arF);
                this.aiC.setAdapter(this.gjV);
                if (this.axF == 0 && this.gjE.buP() != null) {
                    if ("-1".equals(this.gjE.buO())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.gjE.buP(), this.axF + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.gjE.buP(), this.axF);
                    }
                    if (this.gjE.isAdded(imageFileInfo)) {
                        b(this.gjW, true);
                    } else {
                        b(this.gjW, false);
                    }
                }
                this.gjV.setData(this.gjE.buP());
                this.aiC.setCurrentItem(this.axF, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gjV != null) {
            this.gjV.setData(null);
        }
    }

    public View bgN() {
        return this.gjU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gjT.getLayoutMode().ai(i == 1);
        this.gjT.getLayoutMode().x(this.MM);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gjT.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m9getInst().getSkinType();
            if (z) {
                at.k(imageView, r.f.btn_add_finish_s);
                imageView.setContentDescription(getString(r.j.check_box_checked));
                return;
            }
            at.k(imageView, r.f.btn_add_finish_n);
            imageView.setContentDescription(getString(r.j.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tF(int i) {
        int size;
        if (this.gjE != null && this.gjE.buP() != null) {
            if ("-1".equals(this.gjE.buO())) {
                size = this.gjE.buP().size() - 1;
            } else {
                size = this.gjE.buP().size();
            }
            String string = this.gjT.getPageContext().getContext().getString(r.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aOH.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo tG;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gjV != null) {
            if ("-1".equals(this.gjE.buO())) {
                tG = this.gjV.tG(this.axF + 1);
            } else {
                tG = this.gjV.tG(this.axF);
            }
            if (tG != null && tG.getFilePath() != null && tG.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.gjW, z);
            }
        }
    }

    private void buM() {
        if (!isHidden()) {
            this.BV.setVisibility(8);
            this.aiC.setVisibility(0);
            buL();
        }
    }
}
