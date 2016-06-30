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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View KB;
    private TextView aSd;
    private com.baidu.tbadk.img.b anf;
    private ViewPager asW;
    private int atp = -1;
    private View eqH;
    private o fCA;
    private AlbumActivity fCP;
    private j fCQ;
    private ImageView fCR;
    private NavigationBar mNavigationBar;
    private View zf;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCP = (AlbumActivity) getBaseFragmentActivity();
        this.fCA = this.fCP.bjO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.KB = layoutInflater.inflate(u.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.KB.findViewById(u.g.navigation_bar);
        this.eqH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fCP);
        this.aSd = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(u.h.album_big_image_choose, (ViewGroup) null);
        this.fCR = (ImageView) inflate.findViewById(u.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.asW = (ViewPager) this.KB.findViewById(u.g.viewPager);
        this.anf = this.fCP.afd();
        this.asW.setOnPageChangeListener(new g(this));
        this.zf = this.KB.findViewById(u.g.album_no_data);
        return this.KB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjX() {
        if (this.fCA.isOriginalImg()) {
            this.fCP.bjT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            bjZ();
        }
    }

    private void bjY() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fCA == null && this.fCP != null) {
            this.fCA = this.fCP.bjO();
        }
        if (this.fCA != null && this.fCA.bkc() != null) {
            if ("-1".equals(this.fCA.bkb())) {
                currentIndex = this.fCA.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fCA.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.atp = currentIndex;
                if (this.atp > this.fCA.bkc().size() - 1) {
                    this.atp = this.fCA.bkc().size() - 1;
                }
                this.fCA.rX(-1);
                sa(this.atp + 1);
                this.fCQ = null;
                this.fCQ = new j(this.fCP, this.anf);
                this.asW.setAdapter(this.fCQ);
                if (this.atp == 0 && this.fCA.bkc() != null) {
                    if ("-1".equals(this.fCA.bkb())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.fCA.bkc(), this.atp + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.fCA.bkc(), this.atp);
                    }
                    if (this.fCA.isAdded(imageFileInfo)) {
                        b(this.fCR, true);
                    } else {
                        b(this.fCR, false);
                    }
                }
                this.fCQ.setData(this.fCA.bkc());
                this.asW.setCurrentItem(this.atp, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fCQ != null) {
            this.fCQ.setData(null);
        }
    }

    public View aNm() {
        return this.eqH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fCP.getLayoutMode().ad(i == 1);
        this.fCP.getLayoutMode().w(this.KB);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fCP.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m9getInst().getSkinType();
            if (z) {
                av.k(imageView, u.f.btn_add_finish_s);
                imageView.setContentDescription(getString(u.j.check_box_checked));
                return;
            }
            av.k(imageView, u.f.btn_add_finish_n);
            imageView.setContentDescription(getString(u.j.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(int i) {
        int size;
        if (this.fCA != null && this.fCA.bkc() != null) {
            if ("-1".equals(this.fCA.bkb())) {
                size = this.fCA.bkc().size() - 1;
            } else {
                size = this.fCA.bkc().size();
            }
            String string = this.fCP.getPageContext().getContext().getString(u.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aSd.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sb;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fCQ != null) {
            if ("-1".equals(this.fCA.bkb())) {
                sb = this.fCQ.sb(this.atp + 1);
            } else {
                sb = this.fCQ.sb(this.atp);
            }
            if (sb != null && sb.getFilePath() != null && sb.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.fCR, z);
            }
        }
    }

    private void bjZ() {
        if (!isHidden()) {
            this.zf.setVisibility(8);
            this.asW.setVisibility(0);
            bjY();
        }
    }
}
