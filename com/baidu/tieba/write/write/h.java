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
    private com.baidu.tbadk.core.dialog.a hOe;
    public com.baidu.tieba.write.view.a.c hQo;
    public com.baidu.tieba.write.view.a.b hQp;
    public StickerLayout hQr;
    private WriteImagesInfo hQt;
    private com.baidu.tieba.write.write.sticker.a.c hQu;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hQq = null;
    public TextView hQs = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hQu = cVar;
        this.dkp = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hQq = (BdBaseViewPager) this.dkp.findViewById(e.g.write_multi_imgs_viewpager);
        this.hQr = (StickerLayout) this.dkp.findViewById(e.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dkp.findViewById(e.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(e.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hQs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(e.j.done));
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
        this.hQo = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hQo.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hQu == null || !h.this.hQu.G(bitmap)) {
                    h.this.H(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.h(this.mTbPageContext.getContext(), e.C0175e.ds36), 0, 0);
        this.hQo.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hQo.getRootView());
        this.hQp = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hQp.getRootView());
        this.hQp.getRootView().setVisibility(8);
        afv();
    }

    public void H(Bitmap bitmap) {
        this.hQr.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hQr.a(bitmap, this.hQu);
    }

    private void afv() {
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
                            h.this.hQo.getRootView().setVisibility(0);
                            h.this.hQp.getRootView().setVisibility(8);
                            if (v.J(h.this.mUrlList)) {
                                if (h.this.hQu != null) {
                                    h.this.hQu.bNr();
                                    break;
                                }
                            } else {
                                h.this.hQo.eh(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hQr != null) {
                                h.this.hQr.bdn();
                            }
                            h.this.hQo.getRootView().setVisibility(8);
                            h.this.hQp.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hQr != null) {
                                h.this.hQr.bdn();
                            }
                            h.this.hQo.getRootView().setVisibility(8);
                            h.this.hQp.getRootView().setVisibility(0);
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
            al.b(this.hQs, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.hQr.setRemoveRes(e.f.icon_sticker_delete);
            this.hQo.onChangeSkinType();
            this.hQp.onChangeSkinType();
        }
    }

    public void bOr() {
        if (this.hOe == null) {
            this.hOe = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hOe.cz(e.j.orginal_conflict_tip);
            this.hOe.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hOe != null) {
                        h.this.hOe.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.hOe.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hOe != null) {
                        h.this.hOe.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.hOe.b(this.mTbPageContext);
        }
        this.hOe.Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hQt);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ei(List<String> list) {
        this.mUrlList = list;
        this.hQo.eh(list);
    }

    public void bNh() {
        this.hQo.bNh();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hQt = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hQr != null) {
            this.hQr.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
