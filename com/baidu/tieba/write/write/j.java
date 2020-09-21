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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
public class j {
    public LinearLayout hNd;
    private FragmentTabWidget mHx;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private com.baidu.tbadk.core.dialog.a ndZ;
    public com.baidu.tieba.write.view.a.c ngP;
    public com.baidu.tieba.write.view.a.b ngQ;
    public StickerLayout ngS;
    private WriteImagesInfo ngU;
    private com.baidu.tieba.write.write.sticker.a.c ngV;
    private int mSkinType = 3;
    public BdBaseViewPager ngR = null;
    public TextView ngT = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.ngV = cVar;
        this.hNd = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.ngR = (BdBaseViewPager) this.hNd.findViewById(R.id.write_multi_imgs_viewpager);
        this.ngS = (StickerLayout) this.hNd.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.hNd.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.ngT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.hNd.findViewById(R.id.edit_container);
        this.ngP = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.ngP.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.ngV == null || !j.this.ngV.U(bitmap)) {
                    j.this.V(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.ngP.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.ngP.getRootView());
        this.ngQ = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.ngQ.getRootView());
        this.ngQ.getRootView().setVisibility(8);
        dGa();
    }

    public void V(Bitmap bitmap) {
        this.ngS.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.ngS.a(bitmap, this.ngV);
    }

    private void dGa() {
        this.mHx = (FragmentTabWidget) this.hNd.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.mHx.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.mHx.setDiverColor(ap.getColor(R.color.cp_cont_j));
        this.mHx.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mHx.setDviderRectWidth(com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.mHx.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.ngP.getRootView().setVisibility(0);
                            j.this.ngQ.getRootView().setVisibility(8);
                            if (y.isEmpty(j.this.mUrlList)) {
                                if (j.this.ngV != null) {
                                    j.this.ngV.dLB();
                                    break;
                                }
                            } else {
                                j.this.ngP.fK(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.ngS != null) {
                                j.this.ngS.cWW();
                            }
                            j.this.ngP.getRootView().setVisibility(8);
                            j.this.ngQ.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.ngS != null) {
                                j.this.ngS.cWW();
                            }
                            j.this.ngP.getRootView().setVisibility(8);
                            j.this.ngQ.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.mHx.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Ky(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.hNd, R.color.cp_bg_line_e);
            SvgManager.bkl().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ap.setNavbarTitleColor(this.ngT, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.ngS.setRemoveRes(R.drawable.icon_sticker_delete);
            this.ngP.onChangeSkinType();
            this.ngQ.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.mHx.setDiverColor(ap.getColor(R.color.cp_cont_j));
        }
    }

    public void dMY() {
        if (this.ndZ == null) {
            this.ndZ = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.ndZ.nE(R.string.orginal_conflict_tip);
            this.ndZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.ndZ != null) {
                        j.this.ndZ.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.ndZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.ndZ != null) {
                        j.this.ndZ.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.ndZ.b(this.mTbPageContext);
        }
        this.ndZ.bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.ngU);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void fN(List<String> list) {
        this.mUrlList = list;
        this.ngP.fK(list);
    }

    public void bLQ() {
        this.ngP.bLQ();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.ngU = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.ngS != null) {
            this.ngS.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
