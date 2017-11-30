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
    private FragmentTabWidget byR;
    public LinearLayout cwl;
    private FrameLayout gQN;
    private com.baidu.tbadk.core.dialog.a hhG;
    public com.baidu.tieba.write.view.a.d hjJ;
    public com.baidu.tieba.write.view.a.c hjK;
    public com.baidu.tieba.write.view.a.b hjL;
    public StickerLayout hjN;
    private WriteImagesInfo hjP;
    private com.baidu.tieba.write.write.sticker.a.c hjQ;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hjM = null;
    public TextView hjO = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hjQ = cVar;
        this.cwl = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dk(z);
    }

    private void dk(boolean z) {
        this.hjM = (BdBaseViewPager) this.cwl.findViewById(d.g.write_multi_imgs_viewpager);
        this.hjN = (StickerLayout) this.cwl.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.cwl.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hjO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.gQN = (FrameLayout) this.cwl.findViewById(d.g.edit_container);
        this.hjJ = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hjJ.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hjQ == null || !g.this.hjQ.z(bitmap)) {
                    g.this.A(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gQN.getLayoutParams();
        layoutParams.setMargins(0, l.f(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hjJ.getRootView().setLayoutParams(layoutParams);
        this.gQN.addView(this.hjJ.getRootView());
        this.hjK = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hjL = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.gQN.addView(this.hjL.getRootView());
        this.hjL.getRootView().setVisibility(8);
        this.gQN.addView(this.hjK.getRootView());
        this.hjK.getRootView().setVisibility(8);
        ok(z);
    }

    public void A(Bitmap bitmap) {
        this.hjN.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hjN.a(bitmap, this.hjQ);
    }

    private void ok(final boolean z) {
        this.byR = (FragmentTabWidget) this.cwl.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0082d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.dE(TbadkCoreApplication.getInst().getSkinType());
            this.byR.addView(fragmentTabIndicator, i);
        }
        this.byR.setDiverColor(aj.getColor(d.C0082d.cp_cont_j));
        this.byR.a(this.mCurrentTabIndex, true, false);
        this.byR.setDviderRectWidth(l.f(this.mTbPageContext.getContext(), d.e.ds64));
        this.byR.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hjJ.getRootView().setVisibility(0);
                            g.this.hjK.getRootView().setVisibility(8);
                            g.this.hjL.getRootView().setVisibility(8);
                            if (v.w(g.this.mUrlList)) {
                                if (g.this.hjQ != null) {
                                    g.this.hjQ.bHn();
                                    break;
                                }
                            } else {
                                g.this.hjJ.dZ(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hjJ.getRootView().setVisibility(8);
                                g.this.hjK.getRootView().setVisibility(8);
                                g.this.hjL.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hjN != null) {
                                    g.this.hjN.aPO();
                                }
                                g.this.hjJ.getRootView().setVisibility(8);
                                g.this.hjK.getRootView().setVisibility(0);
                                g.this.hjL.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hjN != null) {
                                g.this.hjN.aPO();
                            }
                            g.this.hjJ.getRootView().setVisibility(8);
                            g.this.hjK.getRootView().setVisibility(0);
                            g.this.hjL.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.byR.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void wi(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.j(this.cwl, d.C0082d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.b(this.hjO, d.C0082d.cp_link_tip_a, d.C0082d.s_navbar_title_color);
            this.hjN.setRemoveRes(d.f.icon_sticker_delete);
            this.hjJ.onChangeSkinType();
            this.hjK.onChangeSkinType();
        }
    }

    public void bIj() {
        if (this.hhG == null) {
            this.hhG = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hhG.cd(d.j.orginal_conflict_tip);
            this.hhG.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hhG != null) {
                        g.this.hhG.dismiss();
                    }
                    g.this.ol(true);
                }
            });
            this.hhG.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hhG != null) {
                        g.this.hhG.dismiss();
                    }
                    g.this.ol(false);
                }
            });
            this.hhG.b(this.mTbPageContext);
        }
        this.hhG.tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hjP);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ed(List<String> list) {
        this.mUrlList = list;
        this.hjJ.dZ(list);
    }

    public void bGF() {
        this.hjJ.bGF();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hjP = writeImagesInfo;
    }
}
