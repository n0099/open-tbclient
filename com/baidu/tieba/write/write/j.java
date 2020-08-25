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
    public LinearLayout hFW;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.dialog.a mTO;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    public StickerLayout mWB;
    private WriteImagesInfo mWD;
    private com.baidu.tieba.write.write.sticker.a.c mWE;
    public com.baidu.tieba.write.view.a.c mWy;
    public com.baidu.tieba.write.view.a.b mWz;
    private FragmentTabWidget mxt;
    private int mSkinType = 3;
    public BdBaseViewPager mWA = null;
    public TextView mWC = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.mWE = cVar;
        this.hFW = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.mWA = (BdBaseViewPager) this.hFW.findViewById(R.id.write_multi_imgs_viewpager);
        this.mWB = (StickerLayout) this.hFW.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.hFW.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.mWC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.hFW.findViewById(R.id.edit_container);
        this.mWy = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.mWy.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.mWE == null || !j.this.mWE.V(bitmap)) {
                    j.this.W(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.mWy.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.mWy.getRootView());
        this.mWz = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.mWz.getRootView());
        this.mWz.getRootView().setVisibility(8);
        dBX();
    }

    public void W(Bitmap bitmap) {
        this.mWB.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.mWB.a(bitmap, this.mWE);
    }

    private void dBX() {
        this.mxt = (FragmentTabWidget) this.hFW.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.mxt.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.mxt.setDiverColor(ap.getColor(R.color.cp_cont_j));
        this.mxt.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mxt.setDviderRectWidth(com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.mxt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.mWy.getRootView().setVisibility(0);
                            j.this.mWz.getRootView().setVisibility(8);
                            if (y.isEmpty(j.this.mUrlList)) {
                                if (j.this.mWE != null) {
                                    j.this.mWE.dHx();
                                    break;
                                }
                            } else {
                                j.this.mWy.fB(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.mWB != null) {
                                j.this.mWB.cTq();
                            }
                            j.this.mWy.getRootView().setVisibility(8);
                            j.this.mWz.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.mWB != null) {
                                j.this.mWB.cTq();
                            }
                            j.this.mWy.getRootView().setVisibility(8);
                            j.this.mWz.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.mxt.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void JT(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.hFW, R.color.cp_bg_line_e);
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ap.setNavbarTitleColor(this.mWC, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.mWB.setRemoveRes(R.drawable.icon_sticker_delete);
            this.mWy.onChangeSkinType();
            this.mWz.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.mxt.setDiverColor(ap.getColor(R.color.cp_cont_j));
        }
    }

    public void dIR() {
        if (this.mTO == null) {
            this.mTO = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.mTO.nt(R.string.orginal_conflict_tip);
            this.mTO.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.mTO != null) {
                        j.this.mTO.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.mTO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.mTO != null) {
                        j.this.mTO.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.mTO.b(this.mTbPageContext);
        }
        this.mTO.bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.mWD);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void fE(List<String> list) {
        this.mUrlList = list;
        this.mWy.fB(list);
    }

    public void bKF() {
        this.mWy.bKF();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.mWD = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.mWB != null) {
            this.mWB.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
