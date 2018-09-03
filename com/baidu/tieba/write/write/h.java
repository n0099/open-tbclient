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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.f;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private FragmentTabWidget bTL;
    public LinearLayout cWm;
    public com.baidu.tieba.write.view.a.c hAE;
    public com.baidu.tieba.write.view.a.b hAF;
    public StickerLayout hAH;
    private WriteImagesInfo hAJ;
    private com.baidu.tieba.write.write.sticker.a.c hAK;
    private com.baidu.tbadk.core.dialog.a hyu;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hAG = null;
    public TextView hAI = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hAK = cVar;
        this.cWm = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(f.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hAG = (BdBaseViewPager) this.cWm.findViewById(f.g.write_multi_imgs_viewpager);
        this.hAH = (StickerLayout) this.cWm.findViewById(f.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cWm.findViewById(f.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(f.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hAI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(f.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.cWm.findViewById(f.g.edit_container);
        this.hAE = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hAE.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hAK == null || !h.this.hAK.F(bitmap)) {
                    h.this.G(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.f(this.mTbPageContext.getContext(), f.e.ds36), 0, 0);
        this.hAE.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hAE.getRootView());
        this.hAF = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hAF.getRootView());
        this.hAF.getRootView().setVisibility(8);
        aab();
    }

    public void G(Bitmap bitmap) {
        this.hAH.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hAH.a(bitmap, this.hAK);
    }

    private void aab() {
        this.bTL = (FragmentTabWidget) this.cWm.findViewById(f.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(f.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(f.d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(f.e.fontsize34));
            fragmentTabIndicator.dF(TbadkCoreApplication.getInst().getSkinType());
            this.bTL.addView(fragmentTabIndicator, i);
        }
        this.bTL.setDiverColor(am.getColor(f.d.cp_cont_j));
        this.bTL.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bTL.setDviderRectWidth(l.f(this.mTbPageContext.getContext(), f.e.ds64));
        this.bTL.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.hAE.getRootView().setVisibility(0);
                            h.this.hAF.getRootView().setVisibility(8);
                            if (w.z(h.this.mUrlList)) {
                                if (h.this.hAK != null) {
                                    h.this.hAK.bHo();
                                    break;
                                }
                            } else {
                                h.this.hAE.dS(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hAH != null) {
                                h.this.hAH.aXO();
                            }
                            h.this.hAE.getRootView().setVisibility(8);
                            h.this.hAF.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hAH != null) {
                                h.this.hAH.aXO();
                            }
                            h.this.hAE.getRootView().setVisibility(8);
                            h.this.hAF.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.bTL.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void vK(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(this.cWm, f.d.cp_bg_line_d);
            am.b(this.mNavigationBar.getBackImageView(), f.C0146f.icon_topbar_return_s, f.C0146f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.b(this.hAI, f.d.cp_link_tip_a, f.d.s_navbar_title_color);
            this.hAH.setRemoveRes(f.C0146f.icon_sticker_delete);
            this.hAE.onChangeSkinType();
            this.hAF.onChangeSkinType();
        }
    }

    public void bIp() {
        if (this.hyu == null) {
            this.hyu = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hyu.cf(f.j.orginal_conflict_tip);
            this.hyu.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hyu != null) {
                        h.this.hyu.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.hyu.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hyu != null) {
                        h.this.hyu.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.hyu.b(this.mTbPageContext);
        }
        this.hyu.xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hAJ);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dT(List<String> list) {
        this.mUrlList = list;
        this.hAE.dS(list);
    }

    public void bHe() {
        this.hAE.bHe();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hAJ = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hAH != null) {
            this.hAH.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
