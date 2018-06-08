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
    private FragmentTabWidget bQI;
    public LinearLayout cVB;
    private com.baidu.tbadk.core.dialog.a htc;
    public com.baidu.tieba.write.view.a.c hvl;
    public com.baidu.tieba.write.view.a.b hvm;
    public StickerLayout hvo;
    private WriteImagesInfo hvq;
    private com.baidu.tieba.write.write.sticker.a.c hvr;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hvn = null;
    public TextView hvp = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hvr = cVar;
        this.cVB = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.hvn = (BdBaseViewPager) this.cVB.findViewById(d.g.write_multi_imgs_viewpager);
        this.hvo = (StickerLayout) this.cVB.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cVB.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.k.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hvp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.k.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.cVB.findViewById(d.g.edit_container);
        this.hvl = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hvl.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.hvr == null || !h.this.hvr.G(bitmap)) {
                    h.this.H(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.e(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hvl.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.hvl.getRootView());
        this.hvm = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.hvm.getRootView());
        this.hvm.getRootView().setVisibility(8);
        Zm();
    }

    public void H(Bitmap bitmap) {
        this.hvo.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hvo.a(bitmap, this.hvr);
    }

    private void Zm() {
        this.bQI = (FragmentTabWidget) this.cVB.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0141d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dC(TbadkCoreApplication.getInst().getSkinType());
            this.bQI.addView(fragmentTabIndicator, i);
        }
        this.bQI.setDiverColor(al.getColor(d.C0141d.cp_cont_j));
        this.bQI.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bQI.setDviderRectWidth(l.e(this.mTbPageContext.getContext(), d.e.ds64));
        this.bQI.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.hvl.getRootView().setVisibility(0);
                            h.this.hvm.getRootView().setVisibility(8);
                            if (w.z(h.this.mUrlList)) {
                                if (h.this.hvr != null) {
                                    h.this.hvr.bHX();
                                    break;
                                }
                            } else {
                                h.this.hvl.dT(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.hvo != null) {
                                h.this.hvo.aYR();
                            }
                            h.this.hvl.getRootView().setVisibility(8);
                            h.this.hvm.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.hvo != null) {
                                h.this.hvo.aYR();
                            }
                            h.this.hvl.getRootView().setVisibility(8);
                            h.this.hvm.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.bQI.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void vC(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.cVB, d.C0141d.cp_bg_line_d);
            al.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.b(this.hvp, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
            this.hvo.setRemoveRes(d.f.icon_sticker_delete);
            this.hvl.onChangeSkinType();
            this.hvm.onChangeSkinType();
        }
    }

    public void bIX() {
        if (this.htc == null) {
            this.htc = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.htc.cc(d.k.orginal_conflict_tip);
            this.htc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.htc != null) {
                        h.this.htc.dismiss();
                    }
                    h.this.nI(true);
                }
            });
            this.htc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.htc != null) {
                        h.this.htc.dismiss();
                    }
                    h.this.nI(false);
                }
            });
            this.htc.b(this.mTbPageContext);
        }
        this.htc.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nI(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hvq);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dU(List<String> list) {
        this.mUrlList = list;
        this.hvl.dT(list);
    }

    public void bHO() {
        this.hvl.bHO();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hvq = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.hvo != null) {
            this.hvo.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
