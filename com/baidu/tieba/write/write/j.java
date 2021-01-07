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
    private FragmentTabWidget nIT;
    private com.baidu.tbadk.core.dialog.a odW;
    public com.baidu.tieba.write.view.a.c ogZ;
    public com.baidu.tieba.write.view.a.b oha;
    public StickerLayout ohc;
    private WriteImagesInfo ohe;
    private com.baidu.tieba.write.write.sticker.a.c ohf;
    private int mSkinType = 3;
    public BdBaseViewPager ohb = null;
    public TextView ohd = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.ohf = cVar;
        this.iSr = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.ohb = (BdBaseViewPager) this.iSr.findViewById(R.id.write_multi_imgs_viewpager);
        this.ohc = (StickerLayout) this.iSr.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.iSr.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.ohd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
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
        this.ogZ = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.ogZ.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.ohf == null || !j.this.ohf.U(bitmap)) {
                    j.this.V(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.ogZ.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.ogZ.getRootView());
        this.oha = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.oha.getRootView());
        this.oha.getRootView().setVisibility(8);
        dUI();
    }

    public void V(Bitmap bitmap) {
        this.ohc.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.ohc.a(bitmap, this.ohf);
    }

    private void dUI() {
        this.nIT = (FragmentTabWidget) this.iSr.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.nIT.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.nIT.setDiverColor(ao.getColor(R.color.CAM_X0107));
        this.nIT.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nIT.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.nIT.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.ogZ.getRootView().setVisibility(0);
                            j.this.oha.getRootView().setVisibility(8);
                            if (x.isEmpty(j.this.mUrlList)) {
                                if (j.this.ohf != null) {
                                    j.this.ohf.dZB();
                                    break;
                                }
                            } else {
                                j.this.ogZ.gk(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.ohc != null) {
                                j.this.ohc.dkK();
                            }
                            j.this.ogZ.getRootView().setVisibility(8);
                            j.this.oha.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.ohc != null) {
                                j.this.ohc.dkK();
                            }
                            j.this.ogZ.getRootView().setVisibility(8);
                            j.this.oha.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.nIT.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void MQ(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.iSr, R.color.CAM_X0205);
            SvgManager.bwr().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ao.setNavbarTitleColor(this.ohd, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.ohc.setRemoveRes(R.drawable.icon_sticker_delete);
            this.ogZ.onChangeSkinType();
            this.oha.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.nIT.setDiverColor(ao.getColor(R.color.CAM_X0107));
        }
    }

    public void ebc() {
        if (this.odW == null) {
            this.odW = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.odW.pa(R.string.orginal_conflict_tip);
            this.odW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.odW != null) {
                        j.this.odW.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.odW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.odW != null) {
                        j.this.odW.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.odW.b(this.mTbPageContext);
        }
        this.odW.btY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.ohe);
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void gn(List<String> list) {
        this.mUrlList = list;
        this.ogZ.gk(list);
    }

    public void bZo() {
        this.ogZ.bZo();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.ohe = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.ohc != null) {
            this.ohc.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
