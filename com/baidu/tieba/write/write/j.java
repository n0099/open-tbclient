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
/* loaded from: classes8.dex */
public class j {
    public LinearLayout iTr;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private FragmentTabWidget nNZ;
    private com.baidu.tbadk.core.dialog.a ojl;
    public com.baidu.tieba.write.view.a.c omm;
    public com.baidu.tieba.write.view.a.b omn;
    public StickerLayout omp;
    private WriteImagesInfo omr;
    private com.baidu.tieba.write.write.sticker.a.c oms;
    private int mSkinType = 3;
    public BdBaseViewPager omo = null;
    public TextView omq = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.oms = cVar;
        this.iTr = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.omo = (BdBaseViewPager) this.iTr.findViewById(R.id.write_multi_imgs_viewpager);
        this.omp = (StickerLayout) this.iTr.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.iTr.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.omq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.iTr.findViewById(R.id.edit_container);
        this.omm = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.omm.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.oms == null || !j.this.oms.T(bitmap)) {
                    j.this.U(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.omm.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.omm.getRootView());
        this.omn = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.omn.getRootView());
        this.omn.getRootView().setVisibility(8);
        dTb();
    }

    public void U(Bitmap bitmap) {
        this.omp.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.omp.a(bitmap, this.oms);
    }

    private void dTb() {
        this.nNZ = (FragmentTabWidget) this.iTr.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.nNZ.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.nNZ.setDiverColor(ap.getColor(R.color.CAM_X0107));
        this.nNZ.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nNZ.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.nNZ.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.omm.getRootView().setVisibility(0);
                            j.this.omn.getRootView().setVisibility(8);
                            if (y.isEmpty(j.this.mUrlList)) {
                                if (j.this.oms != null) {
                                    j.this.oms.dXU();
                                    break;
                                }
                            } else {
                                j.this.omm.gi(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.omp != null) {
                                j.this.omp.diT();
                            }
                            j.this.omm.getRootView().setVisibility(8);
                            j.this.omn.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.omp != null) {
                                j.this.omp.diT();
                            }
                            j.this.omm.getRootView().setVisibility(8);
                            j.this.omn.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.nNZ.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void LD(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.iTr, R.color.CAM_X0205);
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ap.setNavbarTitleColor(this.omq, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.omp.setRemoveRes(R.drawable.icon_sticker_delete);
            this.omm.onChangeSkinType();
            this.omn.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.nNZ.setDiverColor(ap.getColor(R.color.CAM_X0107));
        }
    }

    public void dZv() {
        if (this.ojl == null) {
            this.ojl = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.ojl.nx(R.string.orginal_conflict_tip);
            this.ojl.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.ojl != null) {
                        j.this.ojl.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.ojl.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.ojl != null) {
                        j.this.ojl.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.ojl.b(this.mTbPageContext);
        }
        this.ojl.bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.omr);
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void gl(List<String> list) {
        this.mUrlList = list;
        this.omm.gi(list);
    }

    public void bWa() {
        this.omm.bWa();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.omr = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.omp != null) {
            this.omp.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
