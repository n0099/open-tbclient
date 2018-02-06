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
    private FragmentTabWidget crt;
    public LinearLayout dsJ;
    private com.baidu.tbadk.core.dialog.a hKj;
    public com.baidu.tieba.write.view.a.d hMo;
    public com.baidu.tieba.write.view.a.c hMp;
    public com.baidu.tieba.write.view.a.b hMq;
    public StickerLayout hMs;
    private WriteImagesInfo hMu;
    private com.baidu.tieba.write.write.sticker.a.c hMv;
    private FrameLayout hrQ;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager hMr = null;
    public TextView hMt = null;
    public int mCurrentTabIndex = 0;

    public g(TbPageContext<WriteMultiImgsActivity> tbPageContext, boolean z, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.hMv = cVar;
        this.dsJ = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.write_multi_imgs_activity, (ViewGroup) null);
        dY(z);
    }

    private void dY(boolean z) {
        this.hMr = (BdBaseViewPager) this.dsJ.findViewById(d.g.write_multi_imgs_viewpager);
        this.hMs = (StickerLayout) this.dsJ.findViewById(d.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dsJ.findViewById(d.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(d.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.hMt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(d.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.mTbPageContext != null && g.this.mTbPageContext.getPageActivity() != null) {
                    g.this.mTbPageContext.getPageActivity().setResult(0);
                    g.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        this.hrQ = (FrameLayout) this.dsJ.findViewById(d.g.edit_container);
        this.hMo = new com.baidu.tieba.write.view.a.d(this.mTbPageContext);
        this.hMo.a(new c() { // from class: com.baidu.tieba.write.write.g.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z2) {
                if (g.this.hMv == null || !g.this.hMv.D(bitmap)) {
                    g.this.E(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hrQ.getLayoutParams();
        layoutParams.setMargins(0, l.t(this.mTbPageContext.getContext(), d.e.ds36), 0, 0);
        this.hMo.getRootView().setLayoutParams(layoutParams);
        this.hrQ.addView(this.hMo.getRootView());
        this.hMp = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.hMq = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        this.hrQ.addView(this.hMq.getRootView());
        this.hMq.getRootView().setVisibility(8);
        this.hrQ.addView(this.hMp.getRootView());
        this.hMp.getRootView().setVisibility(8);
        nU(z);
    }

    public void E(Bitmap bitmap) {
        this.hMs.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.hMs.a(bitmap, this.hMv);
    }

    private void nU(final boolean z) {
        this.crt = (FragmentTabWidget) this.dsJ.findViewById(d.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = z ? resources.getStringArray(d.b.edit_pic_tab) : resources.getStringArray(d.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0140d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(d.e.fontsize34));
            fragmentTabIndicator.gB(TbadkCoreApplication.getInst().getSkinType());
            this.crt.addView(fragmentTabIndicator, i);
        }
        this.crt.setDiverColor(aj.getColor(d.C0140d.cp_cont_j));
        this.crt.a(this.mCurrentTabIndex, true, false);
        this.crt.setDviderRectWidth(l.t(this.mTbPageContext.getContext(), d.e.ds64));
        this.crt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.g.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void u(int i2, boolean z2) {
                if (i2 != g.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            g.this.hMo.getRootView().setVisibility(0);
                            g.this.hMp.getRootView().setVisibility(8);
                            g.this.hMq.getRootView().setVisibility(8);
                            if (v.E(g.this.mUrlList)) {
                                if (g.this.hMv != null) {
                                    g.this.hMv.bIe();
                                    break;
                                }
                            } else {
                                g.this.hMo.dT(g.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (z) {
                                g.this.hMo.getRootView().setVisibility(8);
                                g.this.hMp.getRootView().setVisibility(8);
                                g.this.hMq.getRootView().setVisibility(0);
                                break;
                            } else {
                                if (g.this.hMs != null) {
                                    g.this.hMs.aZa();
                                }
                                g.this.hMo.getRootView().setVisibility(8);
                                g.this.hMp.getRootView().setVisibility(0);
                                g.this.hMq.getRootView().setVisibility(8);
                                break;
                            }
                        case 2:
                            if (g.this.hMs != null) {
                                g.this.hMs.aZa();
                            }
                            g.this.hMo.getRootView().setVisibility(8);
                            g.this.hMp.getRootView().setVisibility(0);
                            g.this.hMq.getRootView().setVisibility(8);
                            break;
                    }
                    g.this.mCurrentTabIndex = i2;
                    g.this.crt.a(g.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void xO(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(this.dsJ, d.C0140d.cp_bg_line_d);
            aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            aj.d(this.hMt, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
            this.hMs.setRemoveRes(d.f.icon_sticker_delete);
            this.hMo.onChangeSkinType();
            this.hMp.onChangeSkinType();
        }
    }

    public void bJd() {
        if (this.hKj == null) {
            this.hKj = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.hKj.fb(d.j.orginal_conflict_tip);
            this.hKj.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hKj != null) {
                        g.this.hKj.dismiss();
                    }
                    g.this.nV(true);
                }
            });
            this.hKj.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.g.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (g.this.hKj != null) {
                        g.this.hKj.dismiss();
                    }
                    g.this.nV(false);
                }
            });
            this.hKj.b(this.mTbPageContext);
        }
        this.hKj.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nV(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.hMu);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void dX(List<String> list) {
        this.mUrlList = list;
        this.hMo.dT(list);
    }

    public void bHv() {
        this.hMo.bHv();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.hMu = writeImagesInfo;
    }
}
