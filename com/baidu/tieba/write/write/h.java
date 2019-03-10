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
    private FragmentTabWidget dCa;
    public LinearLayout eIL;
    private com.baidu.tbadk.core.dialog.a jsv;
    public com.baidu.tieba.write.view.a.c juG;
    public com.baidu.tieba.write.view.a.b juH;
    public StickerLayout juJ;
    private WriteImagesInfo juL;
    private com.baidu.tieba.write.write.sticker.a.c juM;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager juI = null;
    public TextView juK = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.juM = cVar;
        this.eIL = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.juI = (BdBaseViewPager) this.eIL.findViewById(d.g.write_multi_imgs_viewpager);
        this.juJ = (StickerLayout) this.eIL.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.eIL.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.juK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.eIL.findViewById(d.g.edit_container);
        this.juG = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.juG.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.juM == null || !h.this.juM.O(bitmap)) {
                    h.this.P(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.h(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.juG.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.juG.getRootView());
        this.juH = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.juH.getRootView());
        this.juH.getRootView().setVisibility(8);
        aHE();
    }

    public void P(Bitmap bitmap) {
        this.juJ.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.juJ.a(bitmap, this.juM);
    }

    private void aHE() {
        this.dCa = (FragmentTabWidget) this.eIL.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0236d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.ij(TbadkCoreApplication.getInst().getSkinType());
            this.dCa.addView(fragmentTabIndicator, i);
        }
        this.dCa.setDiverColor(al.getColor(d.C0236d.cp_cont_j));
        this.dCa.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dCa.setDviderRectWidth(l.h(this.mTbPageContext.getContext(), d.e.ds64));
        this.dCa.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.juG.getRootView().setVisibility(0);
                            h.this.juH.getRootView().setVisibility(8);
                            if (v.T(h.this.mUrlList)) {
                                if (h.this.juM != null) {
                                    h.this.juM.cqo();
                                    break;
                                }
                            } else {
                                h.this.juG.eq(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.juJ != null) {
                                h.this.juJ.bGs();
                            }
                            h.this.juG.getRootView().setVisibility(8);
                            h.this.juH.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.juJ != null) {
                                h.this.juJ.bGs();
                            }
                            h.this.juG.getRootView().setVisibility(8);
                            h.this.juH.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dCa.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void BC(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.eIL, d.C0236d.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.c(this.juK, d.C0236d.cp_link_tip_a, d.C0236d.s_navbar_title_color);
            this.juJ.setRemoveRes(d.f.icon_sticker_delete);
            this.juG.onChangeSkinType();
            this.juH.onChangeSkinType();
        }
    }

    public void crn() {
        if (this.jsv == null) {
            this.jsv = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jsv.gD(d.j.orginal_conflict_tip);
            this.jsv.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jsv != null) {
                        h.this.jsv.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jsv.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jsv != null) {
                        h.this.jsv.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jsv.b(this.mTbPageContext);
        }
        this.jsv.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.juL);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void er(List<String> list) {
        this.mUrlList = list;
        this.juG.eq(list);
    }

    public void cqe() {
        this.juG.cqe();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.juL = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.juJ != null) {
            this.juJ.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
