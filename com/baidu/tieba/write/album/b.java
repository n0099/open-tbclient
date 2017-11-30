package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private View Sh;
    private ViewPager aEt;
    private View hcA;
    private TextView hcB;
    private TextView hcC;
    private e hci;
    private AlbumActivity hcu;
    private c hcy;
    private ImageView hcz;
    private ImageView mBackBtn;
    private View mNoDataView;
    private int aEN = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hcA && view == b.this.hcz && b.this.hcy != null && b.this.hci != null && b.this.hcu != null) {
                if (b.this.hci.bFE()) {
                    b.this.hcu.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hcy.vH(b.this.aEN)) {
                    ImageFileInfo pv = b.this.hcy.pv(b.this.aEN);
                    if (b.this.hci.isAdded(pv)) {
                        if (b.this.hcu.d(pv)) {
                            b.this.c(b.this.hcz, false);
                            b.this.hcu.f(pv, false);
                        }
                    } else if (b.this.hcu.c(pv)) {
                        b.this.c(b.this.hcz, true);
                        b.this.hcu.f(pv, true);
                    }
                    b.this.bFz();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEN = i;
            if (b.this.hcy != null && b.this.hci != null) {
                ImageFileInfo pv = b.this.hcy.pv(b.this.aEN);
                if (b.this.hci.isAdded(pv)) {
                    b.this.c(b.this.hcz, true);
                } else {
                    b.this.c(b.this.hcz, false);
                }
                if (pv == null || !pv.isGif()) {
                    b.this.hcC.setVisibility(0);
                } else {
                    b.this.hcC.setVisibility(8);
                }
                b.this.nW(b.this.hci.isOriginalImg());
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hcu = (AlbumActivity) getBaseFragmentActivity();
        this.hci = this.hcu.bFo();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Sh = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.Sh.findViewById(d.g.img_back);
        this.hcz = (ImageView) this.Sh.findViewById(d.g.img_choose);
        this.aEt = (ViewPager) this.Sh.findViewById(d.g.viewPager);
        this.mNoDataView = this.Sh.findViewById(d.g.album_no_data);
        this.hcB = (TextView) this.Sh.findViewById(d.g.btn_next_step);
        this.hcC = (TextView) this.Sh.findViewById(d.g.original_select_btn);
        this.hcA = this.Sh.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hcu);
        this.hcB.setOnClickListener(this.hcu);
        this.hcz.setOnClickListener(this.mOnClickListener);
        this.hcC.setOnClickListener(this.hcu);
        this.hcA.setOnClickListener(this.mOnClickListener);
        this.aEt.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.Sh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFz() {
        this.hcu.bFm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Pj();
        }
    }

    private void bFA() {
        List<ImageFileInfo> bFI;
        int currentIndex;
        if (this.hci == null && this.hcu != null) {
            this.hci = this.hcu.bFo();
        }
        if (this.hci != null && (bFI = this.hci.bFI()) != null && (currentIndex = this.hci.getCurrentIndex()) >= 0) {
            this.aEN = currentIndex;
            this.hcy = new c(this.hcu);
            this.aEt.setAdapter(this.hcy);
            if (this.aEN == 0 && bFI != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(bFI, this.aEN);
                if (this.hci.isAdded(imageFileInfo)) {
                    c(this.hcz, true);
                } else {
                    c(this.hcz, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hcC.setVisibility(8);
                } else {
                    this.hcC.setVisibility(0);
                }
            }
            this.hcy.setData(bFI);
            this.aEt.setCurrentItem(this.aEN, false);
            nW(this.hci.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hcy != null) {
            this.hcy.setData(null);
        }
    }

    public View boh() {
        return this.mBackBtn;
    }

    public View bFB() {
        return this.hcB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.Sh);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hci != null) {
            nW(this.hci.isOriginalImg());
        }
        if (this.hcy != null) {
            this.hcy.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hcu != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hcB != null) {
                int v = this.hci != null ? v.v(this.hci.bFG()) : 0;
                this.hcB.setText(this.hcu.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hci.getMaxImagesAllowed())}));
                this.hcB.setEnabled(v > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hcy != null && (pv = this.hcy.pv(this.aEN)) != null && pv.getFilePath() != null && pv.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hcz, z);
        }
    }

    private void Pj() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.aEt.setVisibility(0);
            bFA();
        }
    }

    public View bFx() {
        return this.hcC;
    }

    public void nW(boolean z) {
        long j;
        if (this.hcu != null && this.hcC != null) {
            if (this.hcy != null) {
                ImageFileInfo pv = this.hcy.pv(this.aEN);
                j = pv != null ? com.baidu.tbadk.core.util.k.dx(pv.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hcu.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.i(this.hcC, d.C0082d.cp_link_tip_a);
                this.hcC.setText(sb2);
                this.hcC.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.i(this.hcC, d.C0082d.cp_cont_f);
            this.hcC.setText(string);
            this.hcC.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
