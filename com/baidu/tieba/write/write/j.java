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
/* loaded from: classes8.dex */
public class j {
    public LinearLayout iSr;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private FragmentTabWidget nIU;
    private com.baidu.tbadk.core.dialog.a odX;
    public com.baidu.tieba.write.view.a.c oha;
    public com.baidu.tieba.write.view.a.b ohb;
    public StickerLayout ohd;
    private WriteImagesInfo ohf;
    private com.baidu.tieba.write.write.sticker.a.c ohg;
    private int mSkinType = 3;
    public BdBaseViewPager ohc = null;
    public TextView ohe = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.ohg = cVar;
        this.iSr = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.ohc = (BdBaseViewPager) this.iSr.findViewById(R.id.write_multi_imgs_viewpager);
        this.ohd = (StickerLayout) this.iSr.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.iSr.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.ohe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.iSr.findViewById(R.id.edit_container);
        this.oha = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.oha.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.ohg == null || !j.this.ohg.U(bitmap)) {
                    j.this.V(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.oha.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.oha.getRootView());
        this.ohb = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.ohb.getRootView());
        this.ohb.getRootView().setVisibility(8);
        dUH();
    }

    public void V(Bitmap bitmap) {
        this.ohd.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.ohd.a(bitmap, this.ohg);
    }

    private void dUH() {
        this.nIU = (FragmentTabWidget) this.iSr.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.nIU.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.nIU.setDiverColor(ao.getColor(R.color.CAM_X0107));
        this.nIU.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nIU.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.nIU.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.oha.getRootView().setVisibility(0);
                            j.this.ohb.getRootView().setVisibility(8);
                            if (x.isEmpty(j.this.mUrlList)) {
                                if (j.this.ohg != null) {
                                    j.this.ohg.dZA();
                                    break;
                                }
                            } else {
                                j.this.oha.gk(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.ohd != null) {
                                j.this.ohd.dkJ();
                            }
                            j.this.oha.getRootView().setVisibility(8);
                            j.this.ohb.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.ohd != null) {
                                j.this.ohd.dkJ();
                            }
                            j.this.oha.getRootView().setVisibility(8);
                            j.this.ohb.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.nIU.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void MQ(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.iSr, R.color.CAM_X0205);
            SvgManager.bwq().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ao.setNavbarTitleColor(this.ohe, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.ohd.setRemoveRes(R.drawable.icon_sticker_delete);
            this.oha.onChangeSkinType();
            this.ohb.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.nIU.setDiverColor(ao.getColor(R.color.CAM_X0107));
        }
    }

    public void ebb() {
        if (this.odX == null) {
            this.odX = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.odX.pa(R.string.orginal_conflict_tip);
            this.odX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.odX != null) {
                        j.this.odX.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.odX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.odX != null) {
                        j.this.odX.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.odX.b(this.mTbPageContext);
        }
        this.odX.btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.ohf);
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void gn(List<String> list) {
        this.mUrlList = list;
        this.oha.gk(list);
    }

    public void bZn() {
        this.oha.bZn();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.ohf = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.ohd != null) {
            this.ohd.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
