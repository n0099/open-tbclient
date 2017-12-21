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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private FragmentTabWidget byX;
    public LinearLayout cwy;
    private FrameLayout gTB;
    private com.baidu.tbadk.core.dialog.a hkE;
    public com.baidu.tieba.write.view.a.d hmG;
    public com.baidu.tieba.write.view.a.c hmH;
    public com.baidu.tieba.write.view.a.b hmI;
    public StickerLayout hmK;
    private WriteImagesInfo hmM;
    private com.baidu.tieba.write.write.sticker.a.c hmN;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hmJ = null;
    public TextView hmL = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hmN = cVar;
        this.cwy = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dl(z);
    }

    private void dl(boolean z) {
        this.hmJ = (BdBaseViewPager) this.cwy.findViewById(d.g.write_multi_imgs_viewpager);
        this.hmK = (StickerLayout) this.cwy.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cwy.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hmL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.gTB = (FrameLayout) this.cwy.findViewById(d.g.edit_container);
        this.hmG = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hmG.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hmN == null || !g.this.hmN.A(bitmap)) {
                    g.this.B(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTB.getLayoutParams();
        layoutParams.setMargins(0, l.f(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hmG.getRootView().setLayoutParams(layoutParams);
        this.gTB.addView(this.hmG.getRootView());
        this.hmH = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hmI = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.gTB.addView(this.hmI.getRootView());
        this.hmI.getRootView().setVisibility(8);
        this.gTB.addView(this.hmH.getRootView());
        this.hmH.getRootView().setVisibility(8);
        ol(z);
    }

    public void B(Bitmap bitmap) {
        this.hmK.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hmK.a(bitmap, this.hmN);
    }

    private void ol(final boolean z) {
        this.byX = (FragmentTabWidget) this.cwy.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0095d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dE(TbadkCoreApplication.getInst().getSkinType());
            this.byX.addView(fragmentTabIndicator, i);
        }
        this.byX.setDiverColor(aj.getColor(d.C0095d.cp_cont_j));
        this.byX.a(this.mCurrentTabIndex, true, false);
        this.byX.setDviderRectWidth(l.f(this.mTbPageContext.getContext(), d.e.ds64));
        this.byX.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hmG.getRootView().setVisibility(0);
                            g.this.hmH.getRootView().setVisibility(8);
                            g.this.hmI.getRootView().setVisibility(8);
                            if (v.w(g.this.mUrlList)) {
                                if (g.this.hmN != null) {
                                    g.this.hmN.bIa();
                                    break;
                                }
                            } else {
                                g.this.hmG.dY(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hmG.getRootView().setVisibility(8);
                                g.this.hmH.getRootView().setVisibility(8);
                                g.this.hmI.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hmK != null) {
                                    g.this.hmK.aPX();
                                }
                                g.this.hmG.getRootView().setVisibility(8);
                                g.this.hmH.getRootView().setVisibility(0);
                                g.this.hmI.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hmK != null) {
                                g.this.hmK.aPX();
                            }
                            g.this.hmG.getRootView().setVisibility(8);
                            g.this.hmH.getRootView().setVisibility(0);
                            g.this.hmI.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.byX.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void wv(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.j(this.cwy, d.C0095d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.b(this.hmL, d.C0095d.cp_link_tip_a, d.C0095d.s_navbar_title_color);
            this.hmK.setRemoveRes(d.f.icon_sticker_delete);
            this.hmG.onChangeSkinType();
            this.hmH.onChangeSkinType();
        }
    }

    public void bIW() {
        if (this.hkE == null) {
            this.hkE = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hkE.cd(d.j.orginal_conflict_tip);
            this.hkE.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hkE != null) {
                        g.this.hkE.dismiss();
                    }
                    g.this.om(true);
                }
            });
            this.hkE.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hkE != null) {
                        g.this.hkE.dismiss();
                    }
                    g.this.om(false);
                }
            });
            this.hkE.b(this.mTbPageContext);
        }
        this.hkE.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hmM);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ec(List<String> list) {
        this.mUrlList = list;
        this.hmG.dY(list);
    }

    public void bHr() {
        this.hmG.bHr();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hmM = writeImagesInfo;
    }
}
