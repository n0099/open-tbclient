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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View BW;
    private View MJ;
    private TextView aNY;
    private ViewPager aid;
    private com.baidu.tbadk.img.b ari;
    private int axc = -1;
    private o fxZ;
    private AlbumActivity fyo;
    private View fyp;
    private j fyq;
    private ImageView fyr;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fyo = (AlbumActivity) getBaseFragmentActivity();
        this.fxZ = this.fyo.bls();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.MJ = layoutInflater.inflate(r.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.MJ.findViewById(r.g.navigation_bar);
        this.fyp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fyo);
        this.aNY = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(r.h.album_big_image_choose, (ViewGroup) null);
        this.fyr = (ImageView) inflate.findViewById(r.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.aid = (ViewPager) this.MJ.findViewById(r.g.viewPager);
        this.ari = this.fyo.ahb();
        this.aid.setOnPageChangeListener(new g(this));
        this.BW = this.MJ.findViewById(r.g.album_no_data);
        return this.MJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blB() {
        if (this.fxZ.isOriginalImg()) {
            this.fyo.blx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            blD();
        }
    }

    private void blC() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fxZ == null && this.fyo != null) {
            this.fxZ = this.fyo.bls();
        }
        if (this.fxZ != null && this.fxZ.blJ() != null) {
            if ("-1".equals(this.fxZ.blI())) {
                currentIndex = this.fxZ.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fxZ.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.axc = currentIndex;
                if (this.axc > this.fxZ.blJ().size() - 1) {
                    this.axc = this.fxZ.blJ().size() - 1;
                }
                this.fxZ.sc(-1);
                se(this.axc + 1);
                this.fyq = null;
                this.fyq = new j(this.fyo, this.ari);
                this.aid.setAdapter(this.fyq);
                if (this.axc == 0 && this.fxZ.blJ() != null) {
                    if ("-1".equals(this.fxZ.blI())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fxZ.blJ(), this.axc + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fxZ.blJ(), this.axc);
                    }
                    if (this.fxZ.isAdded(imageFileInfo)) {
                        b(this.fyr, true);
                    } else {
                        b(this.fyr, false);
                    }
                }
                this.fyq.setData(this.fxZ.blJ());
                this.aid.setCurrentItem(this.axc, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fyq != null) {
            this.fyq.setData(null);
        }
    }

    public View baC() {
        return this.fyp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fyo.getLayoutMode().ai(i == 1);
        this.fyo.getLayoutMode().x(this.MJ);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fyo.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m9getInst().getSkinType();
            if (z) {
                ar.k(imageView, r.f.btn_add_finish_s);
                imageView.setContentDescription(getString(r.j.check_box_checked));
                return;
            }
            ar.k(imageView, r.f.btn_add_finish_n);
            imageView.setContentDescription(getString(r.j.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se(int i) {
        int size;
        if (this.fxZ != null && this.fxZ.blJ() != null) {
            if ("-1".equals(this.fxZ.blI())) {
                size = this.fxZ.blJ().size() - 1;
            } else {
                size = this.fxZ.blJ().size();
            }
            String string = this.fyo.getPageContext().getContext().getString(r.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aNY.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sf;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fyq != null) {
            if ("-1".equals(this.fxZ.blI())) {
                sf = this.fyq.sf(this.axc + 1);
            } else {
                sf = this.fyq.sf(this.axc);
            }
            if (sf != null && sf.getFilePath() != null && sf.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.fyr, z);
            }
        }
    }

    private void blD() {
        if (!isHidden()) {
            this.BW.setVisibility(8);
            this.aid.setVisibility(0);
            blC();
        }
    }
}
