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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class h {
    public LinearLayout gbN;
    private com.baidu.tbadk.core.dialog.a kSi;
    public com.baidu.tieba.write.view.a.c kUs;
    public com.baidu.tieba.write.view.a.b kUt;
    public StickerLayout kUv;
    private WriteImagesInfo kUx;
    private com.baidu.tieba.write.write.sticker.a.c kUy;
    private FragmentTabWidget kyH;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager kUu = null;
    public TextView kUw = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.kUy = cVar;
        this.gbN = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.kUu = (BdBaseViewPager) this.gbN.findViewById(R.id.write_multi_imgs_viewpager);
        this.kUv = (StickerLayout) this.gbN.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.gbN.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.kUw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.gbN.findViewById(R.id.edit_container);
        this.kUs = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.kUs.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.kUy == null || !h.this.kUy.N(bitmap)) {
                    h.this.O(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.kUs.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.kUs.getRootView());
        this.kUt = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.kUt.getRootView());
        this.kUt.getRootView().setVisibility(8);
        cQm();
    }

    public void O(Bitmap bitmap) {
        this.kUv.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.kUv.a(bitmap, this.kUy);
    }

    private void cQm() {
        this.kyH = (FragmentTabWidget) this.gbN.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.kyH.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.kyH.setDiverColor(am.getColor(R.color.cp_cont_j));
        this.kyH.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kyH.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.kyH.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.kUs.getRootView().setVisibility(0);
                            h.this.kUt.getRootView().setVisibility(8);
                            if (v.isEmpty(h.this.mUrlList)) {
                                if (h.this.kUy != null) {
                                    h.this.kUy.cVG();
                                    break;
                                }
                            } else {
                                h.this.kUs.ez(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.kUv != null) {
                                h.this.kUv.ciK();
                            }
                            h.this.kUs.getRootView().setVisibility(8);
                            h.this.kUt.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.kUv != null) {
                                h.this.kUv.ciK();
                            }
                            h.this.kUs.getRootView().setVisibility(8);
                            h.this.kUt.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.kyH.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Ew(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.gbN, R.color.cp_bg_line_e);
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.setNavbarTitleColor(this.kUw, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kUv.setRemoveRes(R.drawable.icon_sticker_delete);
            this.kUs.onChangeSkinType();
            this.kUt.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.kyH.setDiverColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void cWI() {
        if (this.kSi == null) {
            this.kSi = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.kSi.jW(R.string.orginal_conflict_tip);
            this.kSi.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.kSi != null) {
                        h.this.kSi.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.kSi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.kSi != null) {
                        h.this.kSi.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.kSi.b(this.mTbPageContext);
        }
        this.kSi.aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.kUx);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void eA(List<String> list) {
        this.mUrlList = list;
        this.kUs.ez(list);
    }

    public void bfN() {
        this.kUs.bfN();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.kUx = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.kUv != null) {
            this.kUv.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
