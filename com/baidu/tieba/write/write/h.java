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
    private FragmentTabWidget dPv;
    public LinearLayout fdF;
    private com.baidu.tbadk.core.dialog.a jSj;
    private com.baidu.tieba.write.write.sticker.a.c jUA;
    public com.baidu.tieba.write.view.a.c jUu;
    public com.baidu.tieba.write.view.a.b jUv;
    public StickerLayout jUx;
    private WriteImagesInfo jUz;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager jUw = null;
    public TextView jUy = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.jUA = cVar;
        this.fdF = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.jUw = (BdBaseViewPager) this.fdF.findViewById(R.id.write_multi_imgs_viewpager);
        this.jUx = (StickerLayout) this.fdF.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.fdF.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.jUy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.fdF.findViewById(R.id.edit_container);
        this.jUu = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.jUu.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void e(Bitmap bitmap, boolean z) {
                if (h.this.jUA == null || !h.this.jUA.P(bitmap)) {
                    h.this.Q(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.g(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.jUu.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.jUu.getRootView());
        this.jUv = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.jUv.getRootView());
        this.jUv.getRootView().setVisibility(8);
        aPr();
    }

    public void Q(Bitmap bitmap) {
        this.jUx.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.jUx.a(bitmap, this.jUA);
    }

    private void aPr() {
        this.dPv = (FragmentTabWidget) this.fdF.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.jc(TbadkCoreApplication.getInst().getSkinType());
            this.dPv.addView(fragmentTabIndicator, i);
        }
        this.dPv.setDiverColor(am.getColor(R.color.cp_cont_j));
        this.dPv.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dPv.setDviderRectWidth(l.g(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.dPv.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.jUu.getRootView().setVisibility(0);
                            h.this.jUv.getRootView().setVisibility(8);
                            if (v.aa(h.this.mUrlList)) {
                                if (h.this.jUA != null) {
                                    h.this.jUA.cBt();
                                    break;
                                }
                            } else {
                                h.this.jUu.eA(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.jUx != null) {
                                h.this.jUx.bQL();
                            }
                            h.this.jUu.getRootView().setVisibility(8);
                            h.this.jUv.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.jUx != null) {
                                h.this.jUx.bQL();
                            }
                            h.this.jUu.getRootView().setVisibility(8);
                            h.this.jUv.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dPv.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Do(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.fdF, R.color.cp_bg_line_d);
            am.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.e(this.jUy, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jUx.setRemoveRes(R.drawable.icon_sticker_delete);
            this.jUu.onChangeSkinType();
            this.jUv.onChangeSkinType();
        }
    }

    public void cCu() {
        if (this.jSj == null) {
            this.jSj = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jSj.hu(R.string.orginal_conflict_tip);
            this.jSj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jSj != null) {
                        h.this.jSj.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jSj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jSj != null) {
                        h.this.jSj.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jSj.b(this.mTbPageContext);
        }
        this.jSj.agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.jUz);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void eB(List<String> list) {
        this.mUrlList = list;
        this.jUu.eA(list);
    }

    public void cBj() {
        this.jUu.cBj();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.jUz = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.jUx != null) {
            this.jUx.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
