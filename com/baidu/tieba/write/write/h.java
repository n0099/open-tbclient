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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private FragmentTabWidget dLM;
    public LinearLayout eYD;
    private com.baidu.tbadk.core.dialog.a jLg;
    public com.baidu.tieba.write.view.a.c jNr;
    public com.baidu.tieba.write.view.a.b jNs;
    public StickerLayout jNu;
    private WriteImagesInfo jNw;
    private com.baidu.tieba.write.write.sticker.a.c jNx;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager jNt = null;
    public TextView jNv = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.jNx = cVar;
        this.eYD = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.jNt = (BdBaseViewPager) this.eYD.findViewById(R.id.write_multi_imgs_viewpager);
        this.jNu = (StickerLayout) this.eYD.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.eYD.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.jNv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.eYD.findViewById(R.id.edit_container);
        this.jNr = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.jNr.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void e(Bitmap bitmap, boolean z) {
                if (h.this.jNx == null || !h.this.jNx.P(bitmap)) {
                    h.this.Q(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.g(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.jNr.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.jNr.getRootView());
        this.jNs = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.jNs.getRootView());
        this.jNs.getRootView().setVisibility(8);
        aNC();
    }

    public void Q(Bitmap bitmap) {
        this.jNu.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.jNu.a(bitmap, this.jNx);
    }

    private void aNC() {
        this.dLM = (FragmentTabWidget) this.eYD.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            this.dLM.addView(fragmentTabIndicator, i);
        }
        this.dLM.setDiverColor(al.getColor(R.color.cp_cont_j));
        this.dLM.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dLM.setDviderRectWidth(l.g(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.dLM.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.jNr.getRootView().setVisibility(0);
                            h.this.jNs.getRootView().setVisibility(8);
                            if (v.aa(h.this.mUrlList)) {
                                if (h.this.jNx != null) {
                                    h.this.jNx.cyu();
                                    break;
                                }
                            } else {
                                h.this.jNr.ex(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.jNu != null) {
                                h.this.jNu.bNY();
                            }
                            h.this.jNr.getRootView().setVisibility(8);
                            h.this.jNs.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.jNu != null) {
                                h.this.jNu.bNY();
                            }
                            h.this.jNr.getRootView().setVisibility(8);
                            h.this.jNs.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dLM.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void CH(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.eYD, R.color.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.e(this.jNv, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jNu.setRemoveRes(R.drawable.icon_sticker_delete);
            this.jNr.onChangeSkinType();
            this.jNs.onChangeSkinType();
        }
    }

    public void czv() {
        if (this.jLg == null) {
            this.jLg = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jLg.ho(R.string.orginal_conflict_tip);
            this.jLg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jLg != null) {
                        h.this.jLg.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jLg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jLg != null) {
                        h.this.jLg.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jLg.b(this.mTbPageContext);
        }
        this.jLg.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.jNw);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ey(List<String> list) {
        this.mUrlList = list;
        this.jNr.ex(list);
    }

    public void cyk() {
        this.jNr.cyk();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.jNw = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.jNu != null) {
            this.jNu.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
