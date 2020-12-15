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
    public LinearLayout iGf;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private FragmentTabWidget nEP;
    private com.baidu.tbadk.core.dialog.a obM;
    public com.baidu.tieba.write.view.a.c oeN;
    public com.baidu.tieba.write.view.a.b oeO;
    public StickerLayout oeQ;
    private WriteImagesInfo oeS;
    private com.baidu.tieba.write.write.sticker.a.c oeT;
    private int mSkinType = 3;
    public BdBaseViewPager oeP = null;
    public TextView oeR = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.oeT = cVar;
        this.iGf = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.oeP = (BdBaseViewPager) this.iGf.findViewById(R.id.write_multi_imgs_viewpager);
        this.oeQ = (StickerLayout) this.iGf.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.iGf.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.oeR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.iGf.findViewById(R.id.edit_container);
        this.oeN = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.oeN.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.oeT == null || !j.this.oeT.U(bitmap)) {
                    j.this.V(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.oeN.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.oeN.getRootView());
        this.oeO = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.oeO.getRootView());
        this.oeO.getRootView().setVisibility(8);
        dUQ();
    }

    public void V(Bitmap bitmap) {
        this.oeQ.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.oeQ.a(bitmap, this.oeT);
    }

    private void dUQ() {
        this.nEP = (FragmentTabWidget) this.iGf.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.nEP.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.nEP.setDiverColor(ap.getColor(R.color.CAM_X0107));
        this.nEP.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nEP.setDviderRectWidth(com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.nEP.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.oeN.getRootView().setVisibility(0);
                            j.this.oeO.getRootView().setVisibility(8);
                            if (y.isEmpty(j.this.mUrlList)) {
                                if (j.this.oeT != null) {
                                    j.this.oeT.ear();
                                    break;
                                }
                            } else {
                                j.this.oeN.gr(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.oeQ != null) {
                                j.this.oeQ.dkZ();
                            }
                            j.this.oeN.getRootView().setVisibility(8);
                            j.this.oeO.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.oeQ != null) {
                                j.this.oeQ.dkZ();
                            }
                            j.this.oeN.getRootView().setVisibility(8);
                            j.this.oeO.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.nEP.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Ne(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.iGf, R.color.CAM_X0205);
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ap.setNavbarTitleColor(this.oeR, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.oeQ.setRemoveRes(R.drawable.icon_sticker_delete);
            this.oeN.onChangeSkinType();
            this.oeO.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.nEP.setDiverColor(ap.getColor(R.color.CAM_X0107));
        }
    }

    public void ebP() {
        if (this.obM == null) {
            this.obM = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.obM.oQ(R.string.orginal_conflict_tip);
            this.obM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.obM != null) {
                        j.this.obM.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.obM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.obM != null) {
                        j.this.obM.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.obM.b(this.mTbPageContext);
        }
        this.obM.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.oeS);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void gu(List<String> list) {
        this.mUrlList = list;
        this.oeN.gr(list);
    }

    public void bWI() {
        this.oeN.bWI();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.oeS = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.oeQ != null) {
            this.oeQ.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
