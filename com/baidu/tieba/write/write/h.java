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
    private FragmentTabWidget cna;
    public LinearLayout dvu;
    private com.baidu.tbadk.core.dialog.a ibr;
    public com.baidu.tieba.write.view.a.c idE;
    public com.baidu.tieba.write.view.a.b idF;
    public StickerLayout idH;
    private WriteImagesInfo idJ;
    private com.baidu.tieba.write.write.sticker.a.c idK;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager idG = null;
    public TextView idI = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.idK = cVar;
        this.dvu = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.idG = (BdBaseViewPager) this.dvu.findViewById(e.g.write_multi_imgs_viewpager);
        this.idH = (StickerLayout) this.dvu.findViewById(e.g.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.dvu.findViewById(e.g.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(e.j.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.idI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(e.j.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.dvu.findViewById(e.g.edit_container);
        this.idE = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.idE.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.idK == null || !h.this.idK.G(bitmap)) {
                    h.this.H(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.h(this.mTbPageContext.getContext(), e.C0210e.ds36), 0, 0);
        this.idE.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.idE.getRootView());
        this.idF = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.idF.getRootView());
        this.idF.getRootView().setVisibility(8);
        agI();
    }

    public void H(Bitmap bitmap) {
        this.idH.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.idH.a(bitmap, this.idK);
    }

    private void agI() {
        this.cna = (FragmentTabWidget) this.dvu.findViewById(e.g.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(e.b.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(e.C0210e.fontsize34));
            fragmentTabIndicator.eD(TbadkCoreApplication.getInst().getSkinType());
            this.cna.addView(fragmentTabIndicator, i);
        }
        this.cna.setDiverColor(al.getColor(e.d.cp_cont_j));
        this.cna.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cna.setDviderRectWidth(l.h(this.mTbPageContext.getContext(), e.C0210e.ds64));
        this.cna.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.idE.getRootView().setVisibility(0);
                            h.this.idF.getRootView().setVisibility(8);
                            if (v.I(h.this.mUrlList)) {
                                if (h.this.idK != null) {
                                    h.this.idK.bQu();
                                    break;
                                }
                            } else {
                                h.this.idE.el(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.idH != null) {
                                h.this.idH.bfO();
                            }
                            h.this.idE.getRootView().setVisibility(8);
                            h.this.idF.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.idH != null) {
                                h.this.idH.bfO();
                            }
                            h.this.idE.getRootView().setVisibility(8);
                            h.this.idF.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.cna.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void xM(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.dvu, e.d.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.b(this.idI, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
            this.idH.setRemoveRes(e.f.icon_sticker_delete);
            this.idE.onChangeSkinType();
            this.idF.onChangeSkinType();
        }
    }

    public void bRu() {
        if (this.ibr == null) {
            this.ibr = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.ibr.db(e.j.orginal_conflict_tip);
            this.ibr.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.ibr != null) {
                        h.this.ibr.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.ibr.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.ibr != null) {
                        h.this.ibr.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.ibr.b(this.mTbPageContext);
        }
        this.ibr.BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.idJ);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void em(List<String> list) {
        this.mUrlList = list;
        this.idE.el(list);
    }

    public void bQk() {
        this.idE.bQk();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.idJ = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.idH != null) {
            this.idH.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
