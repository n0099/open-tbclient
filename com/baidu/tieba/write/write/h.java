package com.baidu.tieba.write.write;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private FragmentTabWidget bHt;
    public LinearLayout cLr;
    private com.baidu.tbadk.core.dialog.a hgf;
    public com.baidu.tieba.write.view.a.c hip;
    public com.baidu.tieba.write.view.a.b hiq;
    public StickerLayout his;
    private WriteImagesInfo hiu;
    private com.baidu.tieba.write.write.sticker.a.c hiv;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hir = null;
    public TextView hit = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hiv = cVar;
        this.cLr = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hir = (BdBaseViewPager) this.cLr.findViewById(d.g.write_multi_imgs_viewpager);
        this.his = (StickerLayout) this.cLr.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cLr.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.k.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hit = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.k.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.cLr.findViewById(d.g.edit_container);
        this.hip = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hip.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hiv == null || !h.this.hiv.H(bitmap)) {
                    h.this.I(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.e(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hip.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hip.getRootView());
        this.hiq = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hiq.getRootView());
        this.hiq.getRootView().setVisibility(8);
        VI();
    }

    public void I(Bitmap bitmap) {
        this.his.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.his.a(bitmap, this.hiv);
    }

    private void VI() {
        this.bHt = (FragmentTabWidget) this.cLr.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0126d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dA(TbadkCoreApplication.getInst().getSkinType());
            this.bHt.addView(fragmentTabIndicator, i);
        }
        this.bHt.setDiverColor(ak.getColor(d.C0126d.cp_cont_j));
        this.bHt.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bHt.setDviderRectWidth(l.e(this.mTbPageContext.getContext(), d.e.ds64));
        this.bHt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.hip.getRootView().setVisibility(0);
                            h.this.hiq.getRootView().setVisibility(8);
                            if (v.w(h.this.mUrlList)) {
                                if (h.this.hiv != null) {
                                    h.this.hiv.bCU();
                                    break;
                                }
                            } else {
                                h.this.hip.dK(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.his != null) {
                                h.this.his.aTV();
                            }
                            h.this.hip.getRootView().setVisibility(8);
                            h.this.hiq.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.his != null) {
                                h.this.his.aTV();
                            }
                            h.this.hip.getRootView().setVisibility(8);
                            h.this.hiq.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.bHt.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void vm(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(this.cLr, d.C0126d.cp_bg_line_d);
            ak.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ak.b(this.hit, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.his.setRemoveRes(d.f.icon_sticker_delete);
            this.hip.onChangeSkinType();
            this.hiq.onChangeSkinType();
        }
    }

    public void bDU() {
        if (this.hgf == null) {
            this.hgf = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hgf.ca(d.k.orginal_conflict_tip);
            this.hgf.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hgf != null) {
                        h.this.hgf.dismiss();
                    }
                    h.this.nz(true);
                }
            });
            this.hgf.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hgf != null) {
                        h.this.hgf.dismiss();
                    }
                    h.this.nz(false);
                }
            });
            this.hgf.b(this.mTbPageContext);
        }
        this.hgf.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hiu);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dL(List<String> list) {
        this.mUrlList = list;
        this.hip.dK(list);
    }

    public void bCL() {
        this.hip.bCL();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hiu = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.his != null) {
            this.his.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
