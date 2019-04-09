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
    private FragmentTabWidget dBn;
    public LinearLayout eIu;
    private com.baidu.tbadk.core.dialog.a jse;
    public com.baidu.tieba.write.view.a.c jup;
    public com.baidu.tieba.write.view.a.b juq;
    public StickerLayout jus;
    private WriteImagesInfo juu;
    private com.baidu.tieba.write.write.sticker.a.c juv;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager jur = null;
    public TextView jut = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.juv = cVar;
        this.eIu = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.jur = (BdBaseViewPager) this.eIu.findViewById(d.g.write_multi_imgs_viewpager);
        this.jus = (StickerLayout) this.eIu.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.eIu.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.jut = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.eIu.findViewById(d.g.edit_container);
        this.jup = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.jup.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.juv == null || !h.this.juv.O(bitmap)) {
                    h.this.P(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.h(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.jup.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.jup.getRootView());
        this.juq = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.juq.getRootView());
        this.juq.getRootView().setVisibility(8);
        aHs();
    }

    public void P(Bitmap bitmap) {
        this.jus.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.jus.a(bitmap, this.juv);
    }

    private void aHs() {
        this.dBn = (FragmentTabWidget) this.eIu.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0277d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.ii(TbadkCoreApplication.getInst().getSkinType());
            this.dBn.addView(fragmentTabIndicator, i);
        }
        this.dBn.setDiverColor(al.getColor(d.C0277d.cp_cont_j));
        this.dBn.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dBn.setDviderRectWidth(l.h(this.mTbPageContext.getContext(), d.e.ds64));
        this.dBn.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.jup.getRootView().setVisibility(0);
                            h.this.juq.getRootView().setVisibility(8);
                            if (v.T(h.this.mUrlList)) {
                                if (h.this.juv != null) {
                                    h.this.juv.cqp();
                                    break;
                                }
                            } else {
                                h.this.jup.en(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.jus != null) {
                                h.this.jus.bGo();
                            }
                            h.this.jup.getRootView().setVisibility(8);
                            h.this.juq.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.jus != null) {
                                h.this.jus.bGo();
                            }
                            h.this.jup.getRootView().setVisibility(8);
                            h.this.juq.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dBn.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void By(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.eIu, d.C0277d.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.c(this.jut, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
            this.jus.setRemoveRes(d.f.icon_sticker_delete);
            this.jup.onChangeSkinType();
            this.juq.onChangeSkinType();
        }
    }

    public void cro() {
        if (this.jse == null) {
            this.jse = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jse.gC(d.j.orginal_conflict_tip);
            this.jse.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jse != null) {
                        h.this.jse.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jse.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jse != null) {
                        h.this.jse.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jse.b(this.mTbPageContext);
        }
        this.jse.aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.juu);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void eo(List<String> list) {
        this.mUrlList = list;
        this.jup.en(list);
    }

    public void cqf() {
        this.jup.cqf();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.juu = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.jus != null) {
            this.jus.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
