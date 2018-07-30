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
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private FragmentTabWidget bTM;
    public LinearLayout cWq;
    public com.baidu.tieba.write.view.a.c hAC;
    public com.baidu.tieba.write.view.a.b hAD;
    public StickerLayout hAF;
    private WriteImagesInfo hAH;
    private com.baidu.tieba.write.write.sticker.a.c hAI;
    private com.baidu.tbadk.core.dialog.a hys;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hAE = null;
    public TextView hAG = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hAI = cVar;
        this.cWq = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hAE = (BdBaseViewPager) this.cWq.findViewById(d.g.write_multi_imgs_viewpager);
        this.hAF = (StickerLayout) this.cWq.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cWq.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hAG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.cWq.findViewById(d.g.edit_container);
        this.hAC = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hAC.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hAI == null || !h.this.hAI.F(bitmap)) {
                    h.this.G(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.f(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hAC.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hAC.getRootView());
        this.hAD = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hAD.getRootView());
        this.hAD.getRootView().setVisibility(8);
        ZZ();
    }

    public void G(Bitmap bitmap) {
        this.hAF.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hAF.a(bitmap, this.hAI);
    }

    private void ZZ() {
        this.bTM = (FragmentTabWidget) this.cWq.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0140d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dG(TbadkCoreApplication.getInst().getSkinType());
            this.bTM.addView(fragmentTabIndicator, i);
        }
        this.bTM.setDiverColor(am.getColor(d.C0140d.cp_cont_j));
        this.bTM.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bTM.setDviderRectWidth(l.f(this.mTbPageContext.getContext(), d.e.ds64));
        this.bTM.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.hAC.getRootView().setVisibility(0);
                            h.this.hAD.getRootView().setVisibility(8);
                            if (w.z(h.this.mUrlList)) {
                                if (h.this.hAI != null) {
                                    h.this.hAI.bHk();
                                    break;
                                }
                            } else {
                                h.this.hAC.dS(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hAF != null) {
                                h.this.hAF.aXT();
                            }
                            h.this.hAC.getRootView().setVisibility(8);
                            h.this.hAD.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hAF != null) {
                                h.this.hAF.aXT();
                            }
                            h.this.hAC.getRootView().setVisibility(8);
                            h.this.hAD.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.bTM.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void vK(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(this.cWq, d.C0140d.cp_bg_line_d);
            am.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.b(this.hAG, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
            this.hAF.setRemoveRes(d.f.icon_sticker_delete);
            this.hAC.onChangeSkinType();
            this.hAD.onChangeSkinType();
        }
    }

    public void bIl() {
        if (this.hys == null) {
            this.hys = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hys.cf(d.j.orginal_conflict_tip);
            this.hys.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hys != null) {
                        h.this.hys.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.hys.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hys != null) {
                        h.this.hys.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.hys.b(this.mTbPageContext);
        }
        this.hys.xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hAH);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dT(List<String> list) {
        this.mUrlList = list;
        this.hAC.dS(list);
    }

    public void bHa() {
        this.hAC.bHa();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hAH = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hAF != null) {
            this.hAF.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
