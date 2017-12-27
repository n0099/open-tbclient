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
    private FragmentTabWidget cna;
    public LinearLayout dkU;
    private FrameLayout hAE;
    private com.baidu.tbadk.core.dialog.a hSK;
    public com.baidu.tieba.write.view.a.d hUM;
    public com.baidu.tieba.write.view.a.c hUN;
    public com.baidu.tieba.write.view.a.b hUO;
    public StickerLayout hUQ;
    private WriteImagesInfo hUS;
    private com.baidu.tieba.write.write.sticker.a.c hUT;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hUP = null;
    public TextView hUR = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hUT = cVar;
        this.dkU = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dQ(z);
    }

    private void dQ(boolean z) {
        this.hUP = (BdBaseViewPager) this.dkU.findViewById(d.g.write_multi_imgs_viewpager);
        this.hUQ = (StickerLayout) this.dkU.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dkU.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hUR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.hAE = (FrameLayout) this.dkU.findViewById(d.g.edit_container);
        this.hUM = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hUM.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hUT == null || !g.this.hUT.A(bitmap)) {
                    g.this.B(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hAE.getLayoutParams();
        layoutParams.setMargins(0, l.s(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hUM.getRootView().setLayoutParams(layoutParams);
        this.hAE.addView(this.hUM.getRootView());
        this.hUN = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hUO = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.hAE.addView(this.hUO.getRootView());
        this.hUO.getRootView().setVisibility(8);
        this.hAE.addView(this.hUN.getRootView());
        this.hUN.getRootView().setVisibility(8);
        oG(z);
    }

    public void B(Bitmap bitmap) {
        this.hUQ.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hUQ.a(bitmap, this.hUT);
    }

    private void oG(final boolean z) {
        this.cna = (FragmentTabWidget) this.dkU.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0108d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.gC(TbadkCoreApplication.getInst().getSkinType());
            this.cna.addView(fragmentTabIndicator, i);
        }
        this.cna.setDiverColor(aj.getColor(d.C0108d.cp_cont_j));
        this.cna.a(this.mCurrentTabIndex, true, false);
        this.cna.setDviderRectWidth(l.s(this.mTbPageContext.getContext(), d.e.ds64));
        this.cna.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void p(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hUM.getRootView().setVisibility(0);
                            g.this.hUN.getRootView().setVisibility(8);
                            g.this.hUO.getRootView().setVisibility(8);
                            if (v.G(g.this.mUrlList)) {
                                if (g.this.hUT != null) {
                                    g.this.hUT.bNO();
                                    break;
                                }
                            } else {
                                g.this.hUM.ee(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hUM.getRootView().setVisibility(8);
                                g.this.hUN.getRootView().setVisibility(8);
                                g.this.hUO.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hUQ != null) {
                                    g.this.hUQ.aXh();
                                }
                                g.this.hUM.getRootView().setVisibility(8);
                                g.this.hUN.getRootView().setVisibility(0);
                                g.this.hUO.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hUQ != null) {
                                g.this.hUQ.aXh();
                            }
                            g.this.hUM.getRootView().setVisibility(8);
                            g.this.hUN.getRootView().setVisibility(0);
                            g.this.hUO.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.cna.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void zm(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(this.dkU, d.C0108d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.d(this.hUR, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
            this.hUQ.setRemoveRes(d.f.icon_sticker_delete);
            this.hUM.onChangeSkinType();
            this.hUN.onChangeSkinType();
        }
    }

    public void bOK() {
        if (this.hSK == null) {
            this.hSK = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hSK.fd(d.j.orginal_conflict_tip);
            this.hSK.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hSK != null) {
                        g.this.hSK.dismiss();
                    }
                    g.this.oH(true);
                }
            });
            this.hSK.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hSK != null) {
                        g.this.hSK.dismiss();
                    }
                    g.this.oH(false);
                }
            });
            this.hSK.b(this.mTbPageContext);
        }
        this.hSK.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hUS);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ei(List<String> list) {
        this.mUrlList = list;
        this.hUM.ee(list);
    }

    public void bNf() {
        this.hUM.bNf();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hUS = writeImagesInfo;
    }
}
