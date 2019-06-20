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
    private FragmentTabWidget dLN;
    public LinearLayout eYE;
    private com.baidu.tbadk.core.dialog.a jLk;
    private WriteImagesInfo jNA;
    private com.baidu.tieba.write.write.sticker.a.c jNB;
    public com.baidu.tieba.write.view.a.c jNv;
    public com.baidu.tieba.write.view.a.b jNw;
    public StickerLayout jNy;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager jNx = null;
    public TextView jNz = null;
    public int mCurrentTabIndex = 0;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.jNB = cVar;
        this.eYE = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.jNx = (BdBaseViewPager) this.eYE.findViewById(R.id.write_multi_imgs_viewpager);
        this.jNy = (StickerLayout) this.eYE.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.eYE.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.jNz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.eYE.findViewById(R.id.edit_container);
        this.jNv = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.jNv.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void e(Bitmap bitmap, boolean z) {
                if (h.this.jNB == null || !h.this.jNB.P(bitmap)) {
                    h.this.Q(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.g(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.jNv.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.jNv.getRootView());
        this.jNw = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.jNw.getRootView());
        this.jNw.getRootView().setVisibility(8);
        aNF();
    }

    public void Q(Bitmap bitmap) {
        this.jNy.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.jNy.a(bitmap, this.jNB);
    }

    private void aNF() {
        this.dLN = (FragmentTabWidget) this.eYE.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            this.dLN.addView(fragmentTabIndicator, i);
        }
        this.dLN.setDiverColor(al.getColor(R.color.cp_cont_j));
        this.dLN.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dLN.setDviderRectWidth(l.g(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.dLN.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.jNv.getRootView().setVisibility(0);
                            h.this.jNw.getRootView().setVisibility(8);
                            if (v.aa(h.this.mUrlList)) {
                                if (h.this.jNB != null) {
                                    h.this.jNB.cyv();
                                    break;
                                }
                            } else {
                                h.this.jNv.ex(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.jNy != null) {
                                h.this.jNy.bOc();
                            }
                            h.this.jNv.getRootView().setVisibility(8);
                            h.this.jNw.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.jNy != null) {
                                h.this.jNy.bOc();
                            }
                            h.this.jNv.getRootView().setVisibility(8);
                            h.this.jNw.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.dLN.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void CH(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.eYE, R.color.cp_bg_line_d);
            al.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_white_s, 0);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            al.e(this.jNz, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jNy.setRemoveRes(R.drawable.icon_sticker_delete);
            this.jNv.onChangeSkinType();
            this.jNw.onChangeSkinType();
        }
    }

    public void czw() {
        if (this.jLk == null) {
            this.jLk = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.jLk.ho(R.string.orginal_conflict_tip);
            this.jLk.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jLk != null) {
                        h.this.jLk.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.jLk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.jLk != null) {
                        h.this.jLk.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.jLk.b(this.mTbPageContext);
        }
        this.jLk.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.jNA);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void ey(List<String> list) {
        this.mUrlList = list;
        this.jNv.ex(list);
    }

    public void cyl() {
        this.jNv.cyl();
    }

    public void d(WriteImagesInfo writeImagesInfo) {
        this.jNA = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.jNy != null) {
            this.jNy.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
