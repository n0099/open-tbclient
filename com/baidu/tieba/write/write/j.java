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
    public LinearLayout iGd;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private FragmentTabWidget nEN;
    private com.baidu.tbadk.core.dialog.a obK;
    public com.baidu.tieba.write.view.a.c oeL;
    public com.baidu.tieba.write.view.a.b oeM;
    public StickerLayout oeO;
    private WriteImagesInfo oeQ;
    private com.baidu.tieba.write.write.sticker.a.c oeR;
    private int mSkinType = 3;
    public BdBaseViewPager oeN = null;
    public TextView oeP = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.oeR = cVar;
        this.iGd = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.oeN = (BdBaseViewPager) this.iGd.findViewById(R.id.write_multi_imgs_viewpager);
        this.oeO = (StickerLayout) this.iGd.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.iGd.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.oeP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.iGd.findViewById(R.id.edit_container);
        this.oeL = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.oeL.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.oeR == null || !j.this.oeR.U(bitmap)) {
                    j.this.V(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.oeL.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.oeL.getRootView());
        this.oeM = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.oeM.getRootView());
        this.oeM.getRootView().setVisibility(8);
        dUP();
    }

    public void V(Bitmap bitmap) {
        this.oeO.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.oeO.a(bitmap, this.oeR);
    }

    private void dUP() {
        this.nEN = (FragmentTabWidget) this.iGd.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.nEN.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.nEN.setDiverColor(ap.getColor(R.color.CAM_X0107));
        this.nEN.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nEN.setDviderRectWidth(com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.nEN.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.oeL.getRootView().setVisibility(0);
                            j.this.oeM.getRootView().setVisibility(8);
                            if (y.isEmpty(j.this.mUrlList)) {
                                if (j.this.oeR != null) {
                                    j.this.oeR.eaq();
                                    break;
                                }
                            } else {
                                j.this.oeL.gr(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.oeO != null) {
                                j.this.oeO.dkY();
                            }
                            j.this.oeL.getRootView().setVisibility(8);
                            j.this.oeM.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.oeO != null) {
                                j.this.oeO.dkY();
                            }
                            j.this.oeL.getRootView().setVisibility(8);
                            j.this.oeM.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.nEN.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Ne(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.iGd, R.color.CAM_X0205);
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ap.setNavbarTitleColor(this.oeP, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.oeO.setRemoveRes(R.drawable.icon_sticker_delete);
            this.oeL.onChangeSkinType();
            this.oeM.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.nEN.setDiverColor(ap.getColor(R.color.CAM_X0107));
        }
    }

    public void ebO() {
        if (this.obK == null) {
            this.obK = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.obK.oQ(R.string.orginal_conflict_tip);
            this.obK.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.obK != null) {
                        j.this.obK.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.obK.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.obK != null) {
                        j.this.obK.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.obK.b(this.mTbPageContext);
        }
        this.obK.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.oeQ);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void gu(List<String> list) {
        this.mUrlList = list;
        this.oeL.gr(list);
    }

    public void bWH() {
        this.oeL.bWH();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.oeQ = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.oeO != null) {
            this.oeO.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
