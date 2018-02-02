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
    private FragmentTabWidget cnr;
    public LinearLayout dpQ;
    private com.baidu.tbadk.core.dialog.a hIN;
    public com.baidu.tieba.write.view.a.d hKQ;
    public com.baidu.tieba.write.view.a.c hKR;
    public com.baidu.tieba.write.view.a.b hKS;
    public StickerLayout hKU;
    private WriteImagesInfo hKW;
    private com.baidu.tieba.write.write.sticker.a.c hKX;
    private FrameLayout hqB;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hKT = null;
    public TextView hKV = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hKX = cVar;
        this.dpQ = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dR(z);
    }

    private void dR(boolean z) {
        this.hKT = (BdBaseViewPager) this.dpQ.findViewById(d.g.write_multi_imgs_viewpager);
        this.hKU = (StickerLayout) this.dpQ.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dpQ.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hKV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.hqB = (FrameLayout) this.dpQ.findViewById(d.g.edit_container);
        this.hKQ = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hKQ.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hKX == null || !g.this.hKX.A(bitmap)) {
                    g.this.B(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqB.getLayoutParams();
        layoutParams.setMargins(0, l.s(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hKQ.getRootView().setLayoutParams(layoutParams);
        this.hqB.addView(this.hKQ.getRootView());
        this.hKR = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hKS = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.hqB.addView(this.hKS.getRootView());
        this.hKS.getRootView().setVisibility(8);
        this.hqB.addView(this.hKR.getRootView());
        this.hKR.getRootView().setVisibility(8);
        nM(z);
    }

    public void B(Bitmap bitmap) {
        this.hKU.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hKU.a(bitmap, this.hKX);
    }

    private void nM(final boolean z) {
        this.cnr = (FragmentTabWidget) this.dpQ.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0108d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.gz(TbadkCoreApplication.getInst().getSkinType());
            this.cnr.addView(fragmentTabIndicator, i);
        }
        this.cnr.setDiverColor(aj.getColor(d.C0108d.cp_cont_j));
        this.cnr.a(this.mCurrentTabIndex, true, false);
        this.cnr.setDviderRectWidth(l.s(this.mTbPageContext.getContext(), d.e.ds64));
        this.cnr.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void p(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hKQ.getRootView().setVisibility(0);
                            g.this.hKR.getRootView().setVisibility(8);
                            g.this.hKS.getRootView().setVisibility(8);
                            if (v.E(g.this.mUrlList)) {
                                if (g.this.hKX != null) {
                                    g.this.hKX.bHq();
                                    break;
                                }
                            } else {
                                g.this.hKQ.dN(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hKQ.getRootView().setVisibility(8);
                                g.this.hKR.getRootView().setVisibility(8);
                                g.this.hKS.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hKU != null) {
                                    g.this.hKU.aXr();
                                }
                                g.this.hKQ.getRootView().setVisibility(8);
                                g.this.hKR.getRootView().setVisibility(0);
                                g.this.hKS.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hKU != null) {
                                g.this.hKU.aXr();
                            }
                            g.this.hKQ.getRootView().setVisibility(8);
                            g.this.hKR.getRootView().setVisibility(0);
                            g.this.hKS.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.cnr.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void xP(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(this.dpQ, d.C0108d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.d(this.hKV, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
            this.hKU.setRemoveRes(d.f.icon_sticker_delete);
            this.hKQ.onChangeSkinType();
            this.hKR.onChangeSkinType();
        }
    }

    public void bIp() {
        if (this.hIN == null) {
            this.hIN = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hIN.fb(d.j.orginal_conflict_tip);
            this.hIN.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hIN != null) {
                        g.this.hIN.dismiss();
                    }
                    g.this.nN(true);
                }
            });
            this.hIN.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hIN != null) {
                        g.this.hIN.dismiss();
                    }
                    g.this.nN(false);
                }
            });
            this.hIN.b(this.mTbPageContext);
        }
        this.hIN.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hKW);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dR(List<String> list) {
        this.mUrlList = list;
        this.hKQ.dN(list);
    }

    public void bGH() {
        this.hKQ.bGH();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hKW = writeImagesInfo;
    }
}
