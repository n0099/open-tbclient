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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public LinearLayout hsG;
    private com.baidu.tbadk.core.dialog.a mAY;
    public StickerLayout mDA;
    private WriteImagesInfo mDC;
    private com.baidu.tieba.write.write.sticker.a.c mDD;
    public com.baidu.tieba.write.view.a.c mDv;
    public com.baidu.tieba.write.view.a.b mDw;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private FragmentTabWidget mfH;
    private int mSkinType = 3;
    public BdBaseViewPager mDz = null;
    public TextView mDB = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.mDD = cVar;
        this.hsG = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.mDz = (BdBaseViewPager) this.hsG.findViewById(R.id.write_multi_imgs_viewpager);
        this.mDA = (StickerLayout) this.hsG.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.hsG.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.mDB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.hsG.findViewById(R.id.edit_container);
        this.mDv = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.mDv.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.mDD == null || !h.this.mDD.V(bitmap)) {
                    h.this.W(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.mDv.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.mDv.getRootView());
        this.mDw = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.mDw.getRootView());
        this.mDw.getRootView().setVisibility(8);
        dqB();
    }

    public void W(Bitmap bitmap) {
        this.mDA.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.mDA.a(bitmap, this.mDD);
    }

    private void dqB() {
        this.mfH = (FragmentTabWidget) this.hsG.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.mfH.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.mfH.setDiverColor(ao.getColor(R.color.cp_cont_j));
        this.mfH.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mfH.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.mfH.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.mDv.getRootView().setVisibility(0);
                            h.this.mDw.getRootView().setVisibility(8);
                            if (x.isEmpty(h.this.mUrlList)) {
                                if (h.this.mDD != null) {
                                    h.this.mDD.dvT();
                                    break;
                                }
                            } else {
                                h.this.mDv.ft(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.mDA != null) {
                                h.this.mDA.cIB();
                            }
                            h.this.mDv.getRootView().setVisibility(8);
                            h.this.mDw.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.mDA != null) {
                                h.this.mDA.cIB();
                            }
                            h.this.mDv.getRootView().setVisibility(8);
                            h.this.mDw.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.mfH.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Ht(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.hsG, R.color.cp_bg_line_e);
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ao.setNavbarTitleColor(this.mDB, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.mDA.setRemoveRes(R.drawable.icon_sticker_delete);
            this.mDv.onChangeSkinType();
            this.mDw.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.mfH.setDiverColor(ao.getColor(R.color.cp_cont_j));
        }
    }

    public void dxc() {
        if (this.mAY == null) {
            this.mAY = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.mAY.ln(R.string.orginal_conflict_tip);
            this.mAY.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.mAY != null) {
                        h.this.mAY.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.mAY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.mAY != null) {
                        h.this.mAY.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.mAY.b(this.mTbPageContext);
        }
        this.mAY.aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.mDC);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void fu(List<String> list) {
        this.mUrlList = list;
        this.mDv.ft(list);
    }

    public void bBl() {
        this.mDv.bBl();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.mDC = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.mDA != null) {
            this.mDA.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
