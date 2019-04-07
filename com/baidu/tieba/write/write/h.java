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
    private FragmentTabWidget dBm;
    public LinearLayout eIt;
    private com.baidu.tbadk.core.dialog.a jsd;
    public com.baidu.tieba.write.view.a.c juo;
    public com.baidu.tieba.write.view.a.b jup;
    public StickerLayout jur;
    private WriteImagesInfo jut;
    private com.baidu.tieba.write.write.sticker.a.c juu;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager juq = null;
    public TextView jus = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.juu = cVar;
        this.eIt = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.juq = (BdBaseViewPager) this.eIt.findViewById(d.g.write_multi_imgs_viewpager);
        this.jur = (StickerLayout) this.eIt.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.eIt.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.jus = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.eIt.findViewById(d.g.edit_container);
        this.juo = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.juo.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.juu == null || !h.this.juu.O(bitmap)) {
                    h.this.P(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.h(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.juo.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.juo.getRootView());
        this.jup = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.jup.getRootView());
        this.jup.getRootView().setVisibility(8);
        aHs();
    }

    public void P(Bitmap bitmap) {
        this.jur.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.jur.a(bitmap, this.juu);
    }

    private void aHs() {
        this.dBm = (FragmentTabWidget) this.eIt.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0277d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.ii(TbadkCoreApplication.getInst().getSkinType());
            this.dBm.addView(fragmentTabIndicator, i);
        }
        this.dBm.setDiverColor(al.getColor(d.C0277d.cp_cont_j));
        this.dBm.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dBm.setDviderRectWidth(l.h(this.mTbPageContext.getContext(), d.e.ds64));
        this.dBm.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.juo.getRootView().setVisibility(0);
                            h.this.jup.getRootView().setVisibility(8);
                            if (v.T(h.this.mUrlList)) {
                                if (h.this.juu != null) {
                                    h.this.juu.cqp();
                                    break;
                                }
                            } else {
                                h.this.juo.en(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.jur != null) {
                                h.this.jur.bGo();
                            }
                            h.this.juo.getRootView().setVisibility(8);
                            h.this.jup.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.jur != null) {
                                h.this.jur.bGo();
                            }
                            h.this.juo.getRootView().setVisibility(8);
                            h.this.jup.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dBm.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void By(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.eIt, d.C0277d.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.c(this.jus, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
            this.jur.setRemoveRes(d.f.icon_sticker_delete);
            this.juo.onChangeSkinType();
            this.jup.onChangeSkinType();
        }
    }

    public void cro() {
        if (this.jsd == null) {
            this.jsd = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jsd.gC(d.j.orginal_conflict_tip);
            this.jsd.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jsd != null) {
                        h.this.jsd.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jsd.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jsd != null) {
                        h.this.jsd.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jsd.b(this.mTbPageContext);
        }
        this.jsd.aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.jut);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void eo(List<String> list) {
        this.mUrlList = list;
        this.juo.en(list);
    }

    public void cqf() {
        this.juo.cqf();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.jut = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.jur != null) {
            this.jur.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
