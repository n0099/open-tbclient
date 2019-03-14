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
import com.baidu.tbadk.core.util.al;
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
    private FragmentTabWidget dBW;
    public LinearLayout eIH;
    private com.baidu.tbadk.core.dialog.a jsn;
    public StickerLayout juB;
    private WriteImagesInfo juD;
    private com.baidu.tieba.write.write.sticker.a.c juE;
    public com.baidu.tieba.write.view.a.c juy;
    public com.baidu.tieba.write.view.a.b juz;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager juA = null;
    public TextView juC = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.juE = cVar;
        this.eIH = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.juA = (BdBaseViewPager) this.eIH.findViewById(d.g.write_multi_imgs_viewpager);
        this.juB = (StickerLayout) this.eIH.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.eIH.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.juC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.eIH.findViewById(d.g.edit_container);
        this.juy = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.juy.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.juE == null || !h.this.juE.O(bitmap)) {
                    h.this.P(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.h(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.juy.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.juy.getRootView());
        this.juz = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.juz.getRootView());
        this.juz.getRootView().setVisibility(8);
        aHD();
    }

    public void P(Bitmap bitmap) {
        this.juB.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.juB.a(bitmap, this.juE);
    }

    private void aHD() {
        this.dBW = (FragmentTabWidget) this.eIH.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0277d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.ij(TbadkCoreApplication.getInst().getSkinType());
            this.dBW.addView(fragmentTabIndicator, i);
        }
        this.dBW.setDiverColor(al.getColor(d.C0277d.cp_cont_j));
        this.dBW.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dBW.setDviderRectWidth(l.h(this.mTbPageContext.getContext(), d.e.ds64));
        this.dBW.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.juy.getRootView().setVisibility(0);
                            h.this.juz.getRootView().setVisibility(8);
                            if (v.T(h.this.mUrlList)) {
                                if (h.this.juE != null) {
                                    h.this.juE.cqr();
                                    break;
                                }
                            } else {
                                h.this.juy.eq(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.juB != null) {
                                h.this.juB.bGr();
                            }
                            h.this.juy.getRootView().setVisibility(8);
                            h.this.juz.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.juB != null) {
                                h.this.juB.bGr();
                            }
                            h.this.juy.getRootView().setVisibility(8);
                            h.this.juz.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dBW.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void BC(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.eIH, d.C0277d.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.c(this.juC, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
            this.juB.setRemoveRes(d.f.icon_sticker_delete);
            this.juy.onChangeSkinType();
            this.juz.onChangeSkinType();
        }
    }

    public void crq() {
        if (this.jsn == null) {
            this.jsn = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jsn.gD(d.j.orginal_conflict_tip);
            this.jsn.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jsn != null) {
                        h.this.jsn.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jsn.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jsn != null) {
                        h.this.jsn.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jsn.b(this.mTbPageContext);
        }
        this.jsn.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.juD);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void er(List<String> list) {
        this.mUrlList = list;
        this.juy.eq(list);
    }

    public void cqh() {
        this.juy.cqh();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.juD = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.juB != null) {
            this.juB.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
