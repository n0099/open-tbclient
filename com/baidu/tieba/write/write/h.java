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
    private FragmentTabWidget bSR;
    public LinearLayout cTD;
    private com.baidu.tbadk.core.dialog.a hxl;
    private com.baidu.tieba.write.write.sticker.a.c hzA;
    public com.baidu.tieba.write.view.a.c hzu;
    public com.baidu.tieba.write.view.a.b hzv;
    public StickerLayout hzx;
    private WriteImagesInfo hzz;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hzw = null;
    public TextView hzy = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hzA = cVar;
        this.cTD = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hzw = (BdBaseViewPager) this.cTD.findViewById(d.g.write_multi_imgs_viewpager);
        this.hzx = (StickerLayout) this.cTD.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cTD.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.k.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hzy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.k.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.cTD.findViewById(d.g.edit_container);
        this.hzu = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hzu.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hzA == null || !h.this.hzA.G(bitmap)) {
                    h.this.H(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.e(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hzu.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hzu.getRootView());
        this.hzv = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hzv.getRootView());
        this.hzv.getRootView().setVisibility(8);
        ZP();
    }

    public void H(Bitmap bitmap) {
        this.hzx.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hzx.a(bitmap, this.hzA);
    }

    private void ZP() {
        this.bSR = (FragmentTabWidget) this.cTD.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0142d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dD(TbadkCoreApplication.getInst().getSkinType());
            this.bSR.addView(fragmentTabIndicator, i);
        }
        this.bSR.setDiverColor(am.getColor(d.C0142d.cp_cont_j));
        this.bSR.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bSR.setDviderRectWidth(l.e(this.mTbPageContext.getContext(), d.e.ds64));
        this.bSR.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.hzu.getRootView().setVisibility(0);
                            h.this.hzv.getRootView().setVisibility(8);
                            if (w.A(h.this.mUrlList)) {
                                if (h.this.hzA != null) {
                                    h.this.hzA.bIy();
                                    break;
                                }
                            } else {
                                h.this.hzu.dW(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hzx != null) {
                                h.this.hzx.aZy();
                            }
                            h.this.hzu.getRootView().setVisibility(8);
                            h.this.hzv.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hzx != null) {
                                h.this.hzx.aZy();
                            }
                            h.this.hzu.getRootView().setVisibility(8);
                            h.this.hzv.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.bSR.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void vL(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(this.cTD, d.C0142d.cp_bg_line_d);
            am.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.b(this.hzy, d.C0142d.cp_link_tip_a, d.C0142d.s_navbar_title_color);
            this.hzx.setRemoveRes(d.f.icon_sticker_delete);
            this.hzu.onChangeSkinType();
            this.hzv.onChangeSkinType();
        }
    }

    public void bJy() {
        if (this.hxl == null) {
            this.hxl = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hxl.cd(d.k.orginal_conflict_tip);
            this.hxl.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hxl != null) {
                        h.this.hxl.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.hxl.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hxl != null) {
                        h.this.hxl.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.hxl.b(this.mTbPageContext);
        }
        this.hxl.xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hzz);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dX(List<String> list) {
        this.mUrlList = list;
        this.hzu.dW(list);
    }

    public void bIp() {
        this.hzu.bIp();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hzz = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hzx != null) {
            this.hzx.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
