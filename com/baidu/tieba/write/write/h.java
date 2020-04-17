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
/* loaded from: classes2.dex */
public class h {
    public LinearLayout gLG;
    private com.baidu.tbadk.core.dialog.a lDL;
    public com.baidu.tieba.write.view.a.c lFW;
    public com.baidu.tieba.write.view.a.b lFX;
    public StickerLayout lFZ;
    private WriteImagesInfo lGb;
    private com.baidu.tieba.write.write.sticker.a.c lGc;
    private FragmentTabWidget lkG;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager lFY = null;
    public TextView lGa = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.lGc = cVar;
        this.gLG = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.lFY = (BdBaseViewPager) this.gLG.findViewById(R.id.write_multi_imgs_viewpager);
        this.lFZ = (StickerLayout) this.gLG.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.gLG.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.lGa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.gLG.findViewById(R.id.edit_container);
        this.lFW = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.lFW.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.lGc == null || !h.this.lGc.Q(bitmap)) {
                    h.this.R(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.lFW.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.lFW.getRootView());
        this.lFX = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.lFX.getRootView());
        this.lFX.getRootView().setVisibility(8);
        dbD();
    }

    public void R(Bitmap bitmap) {
        this.lFZ.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.lFZ.a(bitmap, this.lGc);
    }

    private void dbD() {
        this.lkG = (FragmentTabWidget) this.gLG.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.lkG.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.lkG.setDiverColor(am.getColor(R.color.cp_cont_j));
        this.lkG.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lkG.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.lkG.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.lFW.getRootView().setVisibility(0);
                            h.this.lFX.getRootView().setVisibility(8);
                            if (v.isEmpty(h.this.mUrlList)) {
                                if (h.this.lGc != null) {
                                    h.this.lGc.dgL();
                                    break;
                                }
                            } else {
                                h.this.lFW.eO(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.lFZ != null) {
                                h.this.lFZ.ctK();
                            }
                            h.this.lFW.getRootView().setVisibility(8);
                            h.this.lFX.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.lFZ != null) {
                                h.this.lFZ.ctK();
                            }
                            h.this.lFW.getRootView().setVisibility(8);
                            h.this.lFX.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.lkG.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Fe(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.gLG, R.color.cp_bg_line_e);
            SvgManager.aOU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.setNavbarTitleColor(this.lGa, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.lFZ.setRemoveRes(R.drawable.icon_sticker_delete);
            this.lFW.onChangeSkinType();
            this.lFX.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.lkG.setDiverColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void dhO() {
        if (this.lDL == null) {
            this.lDL = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.lDL.kd(R.string.orginal_conflict_tip);
            this.lDL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.lDL != null) {
                        h.this.lDL.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.lDL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.lDL != null) {
                        h.this.lDL.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.lDL.b(this.mTbPageContext);
        }
        this.lDL.aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.lGb);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void eP(List<String> list) {
        this.mUrlList = list;
        this.lFW.eO(list);
    }

    public void bpj() {
        this.lFW.bpj();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.lGb = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.lFZ != null) {
            this.lFZ.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
