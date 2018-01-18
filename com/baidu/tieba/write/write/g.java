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
    private FragmentTabWidget cnj;
    public LinearLayout dpv;
    private com.baidu.tbadk.core.dialog.a hIt;
    public StickerLayout hKA;
    private WriteImagesInfo hKC;
    private com.baidu.tieba.write.write.sticker.a.c hKD;
    public com.baidu.tieba.write.view.a.d hKw;
    public com.baidu.tieba.write.view.a.c hKx;
    public com.baidu.tieba.write.view.a.b hKy;
    private FrameLayout hqh;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hKz = null;
    public TextView hKB = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hKD = cVar;
        this.dpv = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dP(z);
    }

    private void dP(boolean z) {
        this.hKz = (BdBaseViewPager) this.dpv.findViewById(d.g.write_multi_imgs_viewpager);
        this.hKA = (StickerLayout) this.dpv.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dpv.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hKB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.hqh = (FrameLayout) this.dpv.findViewById(d.g.edit_container);
        this.hKw = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hKw.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hKD == null || !g.this.hKD.A(bitmap)) {
                    g.this.B(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqh.getLayoutParams();
        layoutParams.setMargins(0, l.s(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hKw.getRootView().setLayoutParams(layoutParams);
        this.hqh.addView(this.hKw.getRootView());
        this.hKx = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hKy = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.hqh.addView(this.hKy.getRootView());
        this.hKy.getRootView().setVisibility(8);
        this.hqh.addView(this.hKx.getRootView());
        this.hKx.getRootView().setVisibility(8);
        nJ(z);
    }

    public void B(Bitmap bitmap) {
        this.hKA.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hKA.a(bitmap, this.hKD);
    }

    private void nJ(final boolean z) {
        this.cnj = (FragmentTabWidget) this.dpv.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0107d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.gz(TbadkCoreApplication.getInst().getSkinType());
            this.cnj.addView(fragmentTabIndicator, i);
        }
        this.cnj.setDiverColor(aj.getColor(d.C0107d.cp_cont_j));
        this.cnj.a(this.mCurrentTabIndex, true, false);
        this.cnj.setDviderRectWidth(l.s(this.mTbPageContext.getContext(), d.e.ds64));
        this.cnj.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void p(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hKw.getRootView().setVisibility(0);
                            g.this.hKx.getRootView().setVisibility(8);
                            g.this.hKy.getRootView().setVisibility(8);
                            if (v.E(g.this.mUrlList)) {
                                if (g.this.hKD != null) {
                                    g.this.hKD.bHo();
                                    break;
                                }
                            } else {
                                g.this.hKw.dN(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hKw.getRootView().setVisibility(8);
                                g.this.hKx.getRootView().setVisibility(8);
                                g.this.hKy.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hKA != null) {
                                    g.this.hKA.aXm();
                                }
                                g.this.hKw.getRootView().setVisibility(8);
                                g.this.hKx.getRootView().setVisibility(0);
                                g.this.hKy.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hKA != null) {
                                g.this.hKA.aXm();
                            }
                            g.this.hKw.getRootView().setVisibility(8);
                            g.this.hKx.getRootView().setVisibility(0);
                            g.this.hKy.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.cnj.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void xP(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(this.dpv, d.C0107d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.d(this.hKB, d.C0107d.cp_link_tip_a, d.C0107d.s_navbar_title_color);
            this.hKA.setRemoveRes(d.f.icon_sticker_delete);
            this.hKw.onChangeSkinType();
            this.hKx.onChangeSkinType();
        }
    }

    public void bIn() {
        if (this.hIt == null) {
            this.hIt = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hIt.fb(d.j.orginal_conflict_tip);
            this.hIt.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hIt != null) {
                        g.this.hIt.dismiss();
                    }
                    g.this.nK(true);
                }
            });
            this.hIt.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hIt != null) {
                        g.this.hIt.dismiss();
                    }
                    g.this.nK(false);
                }
            });
            this.hIt.b(this.mTbPageContext);
        }
        this.hIt.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hKC);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dR(List<String> list) {
        this.mUrlList = list;
        this.hKw.dN(list);
    }

    public void bGF() {
        this.hKw.bGF();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hKC = writeImagesInfo;
    }
}
