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
import com.baidu.tbadk.core.util.ak;
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
    private FragmentTabWidget bIH;
    public LinearLayout cMv;
    private com.baidu.tbadk.core.dialog.a hhg;
    public com.baidu.tieba.write.view.a.c hjq;
    public com.baidu.tieba.write.view.a.b hjr;
    public StickerLayout hjt;
    private WriteImagesInfo hjv;
    private com.baidu.tieba.write.write.sticker.a.c hjw;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hjs = null;
    public TextView hju = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hjw = cVar;
        this.cMv = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hjs = (BdBaseViewPager) this.cMv.findViewById(d.g.write_multi_imgs_viewpager);
        this.hjt = (StickerLayout) this.cMv.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cMv.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.k.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hju = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.k.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.cMv.findViewById(d.g.edit_container);
        this.hjq = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hjq.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hjw == null || !h.this.hjw.H(bitmap)) {
                    h.this.I(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.e(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hjq.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hjq.getRootView());
        this.hjr = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hjr.getRootView());
        this.hjr.getRootView().setVisibility(8);
        VN();
    }

    public void I(Bitmap bitmap) {
        this.hjt.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hjt.a(bitmap, this.hjw);
    }

    private void VN() {
        this.bIH = (FragmentTabWidget) this.cMv.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0126d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dA(TbadkCoreApplication.getInst().getSkinType());
            this.bIH.addView(fragmentTabIndicator, i);
        }
        this.bIH.setDiverColor(ak.getColor(d.C0126d.cp_cont_j));
        this.bIH.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bIH.setDviderRectWidth(l.e(this.mTbPageContext.getContext(), d.e.ds64));
        this.bIH.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.hjq.getRootView().setVisibility(0);
                            h.this.hjr.getRootView().setVisibility(8);
                            if (v.w(h.this.mUrlList)) {
                                if (h.this.hjw != null) {
                                    h.this.hjw.bCS();
                                    break;
                                }
                            } else {
                                h.this.hjq.dN(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hjt != null) {
                                h.this.hjt.aTV();
                            }
                            h.this.hjq.getRootView().setVisibility(8);
                            h.this.hjr.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hjt != null) {
                                h.this.hjt.aTV();
                            }
                            h.this.hjq.getRootView().setVisibility(8);
                            h.this.hjr.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.bIH.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void vk(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(this.cMv, d.C0126d.cp_bg_line_d);
            ak.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ak.b(this.hju, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.hjt.setRemoveRes(d.f.icon_sticker_delete);
            this.hjq.onChangeSkinType();
            this.hjr.onChangeSkinType();
        }
    }

    public void bDS() {
        if (this.hhg == null) {
            this.hhg = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hhg.ca(d.k.orginal_conflict_tip);
            this.hhg.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hhg != null) {
                        h.this.hhg.dismiss();
                    }
                    h.this.nA(true);
                }
            });
            this.hhg.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hhg != null) {
                        h.this.hhg.dismiss();
                    }
                    h.this.nA(false);
                }
            });
            this.hhg.b(this.mTbPageContext);
        }
        this.hhg.tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nA(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hjv);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dO(List<String> list) {
        this.mUrlList = list;
        this.hjq.dN(list);
    }

    public void bCJ() {
        this.hjq.bCJ();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hjv = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hjt != null) {
            this.hjt.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
