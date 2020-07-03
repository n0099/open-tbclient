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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    public LinearLayout hmU;
    private FragmentTabWidget lYn;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private com.baidu.tbadk.core.dialog.a msW;
    public com.baidu.tieba.write.view.a.c mvq;
    public com.baidu.tieba.write.view.a.b mvr;
    public StickerLayout mvt;
    private WriteImagesInfo mvv;
    private com.baidu.tieba.write.write.sticker.a.c mvw;
    private int mSkinType = 3;
    public BdBaseViewPager mvs = null;
    public TextView mvu = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.mvw = cVar;
        this.hmU = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.mvs = (BdBaseViewPager) this.hmU.findViewById(R.id.write_multi_imgs_viewpager);
        this.mvt = (StickerLayout) this.hmU.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.hmU.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.mvu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.hmU.findViewById(R.id.edit_container);
        this.mvq = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.mvq.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.mvw == null || !h.this.mvw.S(bitmap)) {
                    h.this.T(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.mvq.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.mvq.getRootView());
        this.mvr = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.mvr.getRootView());
        this.mvr.getRootView().setVisibility(8);
        dnn();
    }

    public void T(Bitmap bitmap) {
        this.mvt.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.mvt.a(bitmap, this.mvw);
    }

    private void dnn() {
        this.lYn = (FragmentTabWidget) this.hmU.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.lYn.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.lYn.setDiverColor(an.getColor(R.color.cp_cont_j));
        this.lYn.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lYn.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.lYn.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.mvq.getRootView().setVisibility(0);
                            h.this.mvr.getRootView().setVisibility(8);
                            if (w.isEmpty(h.this.mUrlList)) {
                                if (h.this.mvw != null) {
                                    h.this.mvw.dsD();
                                    break;
                                }
                            } else {
                                h.this.mvq.fk(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.mvt != null) {
                                h.this.mvt.cER();
                            }
                            h.this.mvq.getRootView().setVisibility(8);
                            h.this.mvr.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.mvt != null) {
                                h.this.mvt.cER();
                            }
                            h.this.mvq.getRootView().setVisibility(8);
                            h.this.mvr.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.lYn.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void GY(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setBackgroundResource(this.hmU, R.color.cp_bg_line_e);
            SvgManager.aWQ().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            an.setNavbarTitleColor(this.mvu, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.mvt.setRemoveRes(R.drawable.icon_sticker_delete);
            this.mvq.onChangeSkinType();
            this.mvr.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.lYn.setDiverColor(an.getColor(R.color.cp_cont_j));
        }
    }

    public void dtM() {
        if (this.msW == null) {
            this.msW = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.msW.kT(R.string.orginal_conflict_tip);
            this.msW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.msW != null) {
                        h.this.msW.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.msW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.msW != null) {
                        h.this.msW.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.msW.b(this.mTbPageContext);
        }
        this.msW.aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.mvv);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void fl(List<String> list) {
        this.mUrlList = list;
        this.mvq.fk(list);
    }

    public void bxV() {
        this.mvq.bxV();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.mvv = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.mvt != null) {
            this.mvt.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
