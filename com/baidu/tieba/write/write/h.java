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
    private FragmentTabWidget bHs;
    public LinearLayout cLo;
    private com.baidu.tbadk.core.dialog.a hgc;
    public com.baidu.tieba.write.view.a.c him;
    public com.baidu.tieba.write.view.a.b hin;
    public StickerLayout hip;
    private WriteImagesInfo hir;
    private com.baidu.tieba.write.write.sticker.a.c his;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hio = null;
    public TextView hiq = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.his = cVar;
        this.cLo = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hio = (BdBaseViewPager) this.cLo.findViewById(d.g.write_multi_imgs_viewpager);
        this.hip = (StickerLayout) this.cLo.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cLo.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.k.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hiq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.k.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.cLo.findViewById(d.g.edit_container);
        this.him = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.him.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.his == null || !h.this.his.H(bitmap)) {
                    h.this.I(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.e(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.him.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.him.getRootView());
        this.hin = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hin.getRootView());
        this.hin.getRootView().setVisibility(8);
        VI();
    }

    public void I(Bitmap bitmap) {
        this.hip.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hip.a(bitmap, this.his);
    }

    private void VI() {
        this.bHs = (FragmentTabWidget) this.cLo.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0126d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dz(TbadkCoreApplication.getInst().getSkinType());
            this.bHs.addView(fragmentTabIndicator, i);
        }
        this.bHs.setDiverColor(ak.getColor(d.C0126d.cp_cont_j));
        this.bHs.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bHs.setDviderRectWidth(l.e(this.mTbPageContext.getContext(), d.e.ds64));
        this.bHs.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.him.getRootView().setVisibility(0);
                            h.this.hin.getRootView().setVisibility(8);
                            if (v.w(h.this.mUrlList)) {
                                if (h.this.his != null) {
                                    h.this.his.bCU();
                                    break;
                                }
                            } else {
                                h.this.him.dK(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hip != null) {
                                h.this.hip.aTV();
                            }
                            h.this.him.getRootView().setVisibility(8);
                            h.this.hin.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hip != null) {
                                h.this.hip.aTV();
                            }
                            h.this.him.getRootView().setVisibility(8);
                            h.this.hin.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.bHs.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void vl(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(this.cLo, d.C0126d.cp_bg_line_d);
            ak.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ak.b(this.hiq, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.hip.setRemoveRes(d.f.icon_sticker_delete);
            this.him.onChangeSkinType();
            this.hin.onChangeSkinType();
        }
    }

    public void bDU() {
        if (this.hgc == null) {
            this.hgc = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hgc.bZ(d.k.orginal_conflict_tip);
            this.hgc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hgc != null) {
                        h.this.hgc.dismiss();
                    }
                    h.this.nz(true);
                }
            });
            this.hgc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hgc != null) {
                        h.this.hgc.dismiss();
                    }
                    h.this.nz(false);
                }
            });
            this.hgc.b(this.mTbPageContext);
        }
        this.hgc.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hir);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dL(List<String> list) {
        this.mUrlList = list;
        this.him.dK(list);
    }

    public void bCL() {
        this.him.bCL();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hir = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hip != null) {
            this.hip.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
