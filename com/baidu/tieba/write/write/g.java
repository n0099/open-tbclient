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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private FragmentTabWidget crk;
    public LinearLayout dsA;
    private com.baidu.tbadk.core.dialog.a hKu;
    public com.baidu.tieba.write.view.a.c hMA;
    public com.baidu.tieba.write.view.a.b hMB;
    public StickerLayout hMD;
    private WriteImagesInfo hMF;
    private com.baidu.tieba.write.write.sticker.a.c hMG;
    public com.baidu.tieba.write.view.a.d hMz;
    private FrameLayout hsb;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hMC = null;
    public TextView hME = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hMG = cVar;
        this.dsA = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dY(z);
    }

    private void dY(boolean z) {
        this.hMC = (BdBaseViewPager) this.dsA.findViewById(d.g.write_multi_imgs_viewpager);
        this.hMD = (StickerLayout) this.dsA.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dsA.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hME = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.hsb = (FrameLayout) this.dsA.findViewById(d.g.edit_container);
        this.hMz = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hMz.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hMG == null || !g.this.hMG.D(bitmap)) {
                    g.this.E(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hsb.getLayoutParams();
        layoutParams.setMargins(0, l.t(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hMz.getRootView().setLayoutParams(layoutParams);
        this.hsb.addView(this.hMz.getRootView());
        this.hMA = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hMB = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.hsb.addView(this.hMB.getRootView());
        this.hMB.getRootView().setVisibility(8);
        this.hsb.addView(this.hMA.getRootView());
        this.hMA.getRootView().setVisibility(8);
        nZ(z);
    }

    public void E(Bitmap bitmap) {
        this.hMD.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hMD.a(bitmap, this.hMG);
    }

    private void nZ(final boolean z) {
        this.crk = (FragmentTabWidget) this.dsA.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0141d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.gB(TbadkCoreApplication.getInst().getSkinType());
            this.crk.addView(fragmentTabIndicator, i);
        }
        this.crk.setDiverColor(aj.getColor(d.C0141d.cp_cont_j));
        this.crk.a(this.mCurrentTabIndex, true, false);
        this.crk.setDviderRectWidth(l.t(this.mTbPageContext.getContext(), d.e.ds64));
        this.crk.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void u(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hMz.getRootView().setVisibility(0);
                            g.this.hMA.getRootView().setVisibility(8);
                            g.this.hMB.getRootView().setVisibility(8);
                            if (v.E(g.this.mUrlList)) {
                                if (g.this.hMG != null) {
                                    g.this.hMG.bIi();
                                    break;
                                }
                            } else {
                                g.this.hMz.dT(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hMz.getRootView().setVisibility(8);
                                g.this.hMA.getRootView().setVisibility(8);
                                g.this.hMB.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hMD != null) {
                                    g.this.hMD.aZa();
                                }
                                g.this.hMz.getRootView().setVisibility(8);
                                g.this.hMA.getRootView().setVisibility(0);
                                g.this.hMB.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hMD != null) {
                                g.this.hMD.aZa();
                            }
                            g.this.hMz.getRootView().setVisibility(8);
                            g.this.hMA.getRootView().setVisibility(0);
                            g.this.hMB.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.crk.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void xP(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(this.dsA, d.C0141d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.d(this.hME, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
            this.hMD.setRemoveRes(d.f.icon_sticker_delete);
            this.hMz.onChangeSkinType();
            this.hMA.onChangeSkinType();
        }
    }

    public void bJh() {
        if (this.hKu == null) {
            this.hKu = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hKu.fb(d.j.orginal_conflict_tip);
            this.hKu.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hKu != null) {
                        g.this.hKu.dismiss();
                    }
                    g.this.oa(true);
                }
            });
            this.hKu.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hKu != null) {
                        g.this.hKu.dismiss();
                    }
                    g.this.oa(false);
                }
            });
            this.hKu.b(this.mTbPageContext);
        }
        this.hKu.AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hMF);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dX(List<String> list) {
        this.mUrlList = list;
        this.hMz.dT(list);
    }

    public void bHz() {
        this.hMz.bHz();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hMF = writeImagesInfo;
    }
}
