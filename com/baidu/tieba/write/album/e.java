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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private View BV;
    private View MN;
    private TextView aYh;
    private com.baidu.tbadk.img.b arb;
    private ViewPager awS;
    private int axl = -1;
    private o fZQ;
    private AlbumActivity gaf;
    private View gag;
    private j gah;
    private ImageView gai;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gaf = (AlbumActivity) getBaseFragmentActivity();
        this.fZQ = this.gaf.brA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.MN = layoutInflater.inflate(t.h.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.MN.findViewById(t.g.navigation_bar);
        this.gag = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gaf);
        this.aYh = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(t.h.album_big_image_choose, (ViewGroup) null);
        this.gai = (ImageView) inflate.findViewById(t.g.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new f(this));
        this.awS = (ViewPager) this.MN.findViewById(t.g.viewPager);
        this.arb = this.gaf.akr();
        this.awS.setOnPageChangeListener(new g(this));
        this.BV = this.MN.findViewById(t.g.album_no_data);
        return this.MN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brJ() {
        if (this.fZQ.isOriginalImg()) {
            this.gaf.brF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            brL();
        }
    }

    private void brK() {
        int currentIndex;
        ImageFileInfo imageFileInfo;
        if (this.fZQ == null && this.gaf != null) {
            this.fZQ = this.gaf.brA();
        }
        if (this.fZQ != null && this.fZQ.brO() != null) {
            if ("-1".equals(this.fZQ.brN())) {
                currentIndex = this.fZQ.getCurrentIndex() - 1;
            } else {
                currentIndex = this.fZQ.getCurrentIndex();
            }
            if (currentIndex >= 0) {
                this.axl = currentIndex;
                if (this.axl > this.fZQ.brO().size() - 1) {
                    this.axl = this.fZQ.brO().size() - 1;
                }
                this.fZQ.sT(-1);
                sV(this.axl + 1);
                this.gah = null;
                this.gah = new j(this.gaf, this.arb);
                this.awS.setAdapter(this.gah);
                if (this.axl == 0 && this.fZQ.brO() != null) {
                    if ("-1".equals(this.fZQ.brN())) {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.fZQ.brO(), this.axl + 1);
                    } else {
                        imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.fZQ.brO(), this.axl);
                    }
                    if (this.fZQ.isAdded(imageFileInfo)) {
                        b(this.gai, true);
                    } else {
                        b(this.gai, false);
                    }
                }
                this.gah.setData(this.fZQ.brO());
                this.awS.setCurrentItem(this.axl, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gah != null) {
            this.gah.setData(null);
        }
    }

    public View bdG() {
        return this.gag;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gaf.getLayoutMode().ah(i == 1);
        this.gaf.getLayoutMode().x(this.MN);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gaf.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m9getInst().getSkinType();
            if (z) {
                av.k(imageView, t.f.btn_add_finish_s);
                imageView.setContentDescription(getString(t.j.check_box_checked));
                return;
            }
            av.k(imageView, t.f.btn_add_finish_n);
            imageView.setContentDescription(getString(t.j.check_box_not_checked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sV(int i) {
        int size;
        if (this.fZQ != null && this.fZQ.brO() != null) {
            if ("-1".equals(this.fZQ.brN())) {
                size = this.fZQ.brO().size() - 1;
            } else {
                size = this.fZQ.brO().size();
            }
            String string = this.gaf.getPageContext().getContext().getString(t.j.album_big_image_title, Integer.valueOf(i), Integer.valueOf(size));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.aYh.setText(string);
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sW;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gah != null) {
            if ("-1".equals(this.fZQ.brN())) {
                sW = this.gah.sW(this.axl + 1);
            } else {
                sW = this.gah.sW(this.axl);
            }
            if (sW != null && sW.getFilePath() != null && sW.getFilePath().equals(imageFileInfo.getFilePath())) {
                b(this.gai, z);
            }
        }
    }

    private void brL() {
        if (!isHidden()) {
            this.BV.setVisibility(8);
            this.awS.setVisibility(0);
            brK();
        }
    }
}
