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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private FragmentTabWidget dPC;
    public LinearLayout fef;
    private com.baidu.tbadk.core.dialog.a jTp;
    public com.baidu.tieba.write.view.a.c jVA;
    public com.baidu.tieba.write.view.a.b jVB;
    public StickerLayout jVD;
    private WriteImagesInfo jVF;
    private com.baidu.tieba.write.write.sticker.a.c jVG;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager jVC = null;
    public TextView jVE = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.jVG = cVar;
        this.fef = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.jVC = (BdBaseViewPager) this.fef.findViewById(R.id.write_multi_imgs_viewpager);
        this.jVD = (StickerLayout) this.fef.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.fef.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.jVE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.fef.findViewById(R.id.edit_container);
        this.jVA = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.jVA.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void e(Bitmap bitmap, boolean z) {
                if (h.this.jVG == null || !h.this.jVG.P(bitmap)) {
                    h.this.Q(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.g(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.jVA.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.jVA.getRootView());
        this.jVB = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.jVB.getRootView());
        this.jVB.getRootView().setVisibility(8);
        aPt();
    }

    public void Q(Bitmap bitmap) {
        this.jVD.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.jVD.a(bitmap, this.jVG);
    }

    private void aPt() {
        this.dPC = (FragmentTabWidget) this.fef.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.jd(TbadkCoreApplication.getInst().getSkinType());
            this.dPC.addView(fragmentTabIndicator, i);
        }
        this.dPC.setDiverColor(am.getColor(R.color.cp_cont_j));
        this.dPC.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dPC.setDviderRectWidth(l.g(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.dPC.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.jVA.getRootView().setVisibility(0);
                            h.this.jVB.getRootView().setVisibility(8);
                            if (v.aa(h.this.mUrlList)) {
                                if (h.this.jVG != null) {
                                    h.this.jVG.cBO();
                                    break;
                                }
                            } else {
                                h.this.jVA.ez(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.jVD != null) {
                                h.this.jVD.bQZ();
                            }
                            h.this.jVA.getRootView().setVisibility(8);
                            h.this.jVB.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.jVD != null) {
                                h.this.jVD.bQZ();
                            }
                            h.this.jVA.getRootView().setVisibility(8);
                            h.this.jVB.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dPC.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Dq(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.fef, R.color.cp_bg_line_d);
            am.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.e(this.jVE, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jVD.setRemoveRes(R.drawable.icon_sticker_delete);
            this.jVA.onChangeSkinType();
            this.jVB.onChangeSkinType();
        }
    }

    public void cCP() {
        if (this.jTp == null) {
            this.jTp = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jTp.hu(R.string.orginal_conflict_tip);
            this.jTp.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jTp != null) {
                        h.this.jTp.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jTp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jTp != null) {
                        h.this.jTp.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jTp.b(this.mTbPageContext);
        }
        this.jTp.agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.jVF);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void eA(List<String> list) {
        this.mUrlList = list;
        this.jVA.ez(list);
    }

    public void cBE() {
        this.jVA.cBE();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.jVF = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.jVD != null) {
            this.jVD.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
