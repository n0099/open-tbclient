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
    private FragmentTabWidget byT;
    public LinearLayout cwu;
    private FrameLayout gTw;
    private com.baidu.tbadk.core.dialog.a hkz;
    public com.baidu.tieba.write.view.a.d hmB;
    public com.baidu.tieba.write.view.a.c hmC;
    public com.baidu.tieba.write.view.a.b hmD;
    public StickerLayout hmF;
    private WriteImagesInfo hmH;
    private com.baidu.tieba.write.write.sticker.a.c hmI;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hmE = null;
    public TextView hmG = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hmI = cVar;
        this.cwu = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dl(z);
    }

    private void dl(boolean z) {
        this.hmE = (BdBaseViewPager) this.cwu.findViewById(d.g.write_multi_imgs_viewpager);
        this.hmF = (StickerLayout) this.cwu.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cwu.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hmG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.gTw = (FrameLayout) this.cwu.findViewById(d.g.edit_container);
        this.hmB = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hmB.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hmI == null || !g.this.hmI.A(bitmap)) {
                    g.this.B(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTw.getLayoutParams();
        layoutParams.setMargins(0, l.f(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hmB.getRootView().setLayoutParams(layoutParams);
        this.gTw.addView(this.hmB.getRootView());
        this.hmC = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hmD = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.gTw.addView(this.hmD.getRootView());
        this.hmD.getRootView().setVisibility(8);
        this.gTw.addView(this.hmC.getRootView());
        this.hmC.getRootView().setVisibility(8);
        ol(z);
    }

    public void B(Bitmap bitmap) {
        this.hmF.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hmF.a(bitmap, this.hmI);
    }

    private void ol(final boolean z) {
        this.byT = (FragmentTabWidget) this.cwu.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0096d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dE(TbadkCoreApplication.getInst().getSkinType());
            this.byT.addView(fragmentTabIndicator, i);
        }
        this.byT.setDiverColor(aj.getColor(d.C0096d.cp_cont_j));
        this.byT.a(this.mCurrentTabIndex, true, false);
        this.byT.setDviderRectWidth(l.f(this.mTbPageContext.getContext(), d.e.ds64));
        this.byT.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hmB.getRootView().setVisibility(0);
                            g.this.hmC.getRootView().setVisibility(8);
                            g.this.hmD.getRootView().setVisibility(8);
                            if (v.w(g.this.mUrlList)) {
                                if (g.this.hmI != null) {
                                    g.this.hmI.bHZ();
                                    break;
                                }
                            } else {
                                g.this.hmB.dY(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hmB.getRootView().setVisibility(8);
                                g.this.hmC.getRootView().setVisibility(8);
                                g.this.hmD.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hmF != null) {
                                    g.this.hmF.aPW();
                                }
                                g.this.hmB.getRootView().setVisibility(8);
                                g.this.hmC.getRootView().setVisibility(0);
                                g.this.hmD.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hmF != null) {
                                g.this.hmF.aPW();
                            }
                            g.this.hmB.getRootView().setVisibility(8);
                            g.this.hmC.getRootView().setVisibility(0);
                            g.this.hmD.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.byT.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void wv(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.j(this.cwu, d.C0096d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.b(this.hmG, d.C0096d.cp_link_tip_a, d.C0096d.s_navbar_title_color);
            this.hmF.setRemoveRes(d.f.icon_sticker_delete);
            this.hmB.onChangeSkinType();
            this.hmC.onChangeSkinType();
        }
    }

    public void bIV() {
        if (this.hkz == null) {
            this.hkz = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hkz.cd(d.j.orginal_conflict_tip);
            this.hkz.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hkz != null) {
                        g.this.hkz.dismiss();
                    }
                    g.this.om(true);
                }
            });
            this.hkz.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hkz != null) {
                        g.this.hkz.dismiss();
                    }
                    g.this.om(false);
                }
            });
            this.hkz.b(this.mTbPageContext);
        }
        this.hkz.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hmH);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ec(List<String> list) {
        this.mUrlList = list;
        this.hmB.dY(list);
    }

    public void bHq() {
        this.hmB.bHq();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hmH = writeImagesInfo;
    }
}
