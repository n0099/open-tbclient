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
import com.baidu.tieba.e;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private FragmentTabWidget cia;
    public LinearLayout dkp;
    private com.baidu.tbadk.core.dialog.a hOd;
    public com.baidu.tieba.write.view.a.c hQn;
    public com.baidu.tieba.write.view.a.b hQo;
    public StickerLayout hQq;
    private WriteImagesInfo hQs;
    private com.baidu.tieba.write.write.sticker.a.c hQt;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hQp = null;
    public TextView hQr = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hQt = cVar;
        this.dkp = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hQp = (BdBaseViewPager) this.dkp.findViewById(e.g.write_multi_imgs_viewpager);
        this.hQq = (StickerLayout) this.dkp.findViewById(e.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dkp.findViewById(e.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(e.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hQr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(e.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.dkp.findViewById(e.g.edit_container);
        this.hQn = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hQn.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hQt == null || !h.this.hQt.G(bitmap)) {
                    h.this.H(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.h(this.mTbPageContext.getContext(), e.C0175e.ds36), 0, 0);
        this.hQn.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hQn.getRootView());
        this.hQo = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hQo.getRootView());
        this.hQo.getRootView().setVisibility(8);
        afu();
    }

    public void H(Bitmap bitmap) {
        this.hQq.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hQq.a(bitmap, this.hQt);
    }

    private void afu() {
        this.cia = (FragmentTabWidget) this.dkp.findViewById(e.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(e.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(e.C0175e.fontsize34));
            fragmentTabIndicator.ea(TbadkCoreApplication.getInst().getSkinType());
            this.cia.addView(fragmentTabIndicator, i);
        }
        this.cia.setDiverColor(al.getColor(e.d.cp_cont_j));
        this.cia.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cia.setDviderRectWidth(l.h(this.mTbPageContext.getContext(), e.C0175e.ds64));
        this.cia.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.hQn.getRootView().setVisibility(0);
                            h.this.hQo.getRootView().setVisibility(8);
                            if (v.J(h.this.mUrlList)) {
                                if (h.this.hQt != null) {
                                    h.this.hQt.bNr();
                                    break;
                                }
                            } else {
                                h.this.hQn.eh(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hQq != null) {
                                h.this.hQq.bdn();
                            }
                            h.this.hQn.getRootView().setVisibility(8);
                            h.this.hQo.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hQq != null) {
                                h.this.hQq.bdn();
                            }
                            h.this.hQn.getRootView().setVisibility(8);
                            h.this.hQo.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.cia.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void wH(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.dkp, e.d.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.b(this.hQr, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.hQq.setRemoveRes(e.f.icon_sticker_delete);
            this.hQn.onChangeSkinType();
            this.hQo.onChangeSkinType();
        }
    }

    public void bOr() {
        if (this.hOd == null) {
            this.hOd = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hOd.cz(e.j.orginal_conflict_tip);
            this.hOd.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hOd != null) {
                        h.this.hOd.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.hOd.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hOd != null) {
                        h.this.hOd.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.hOd.b(this.mTbPageContext);
        }
        this.hOd.Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hQs);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ei(List<String> list) {
        this.mUrlList = list;
        this.hQn.eh(list);
    }

    public void bNh() {
        this.hQn.bNh();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hQs = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hQq != null) {
            this.hQq.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
