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
    public LinearLayout ioA;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private com.baidu.tbadk.core.dialog.a nFX;
    public com.baidu.tieba.write.view.a.c nIM;
    public com.baidu.tieba.write.view.a.b nIN;
    public StickerLayout nIP;
    private WriteImagesInfo nIR;
    private com.baidu.tieba.write.write.sticker.a.c nIS;
    private FragmentTabWidget njI;
    private int mSkinType = 3;
    public BdBaseViewPager nIO = null;
    public TextView nIQ = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.nIS = cVar;
        this.ioA = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.nIO = (BdBaseViewPager) this.ioA.findViewById(R.id.write_multi_imgs_viewpager);
        this.nIP = (StickerLayout) this.ioA.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.ioA.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.nIQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.ioA.findViewById(R.id.edit_container);
        this.nIM = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.nIM.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.nIS == null || !j.this.nIS.U(bitmap)) {
                    j.this.V(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.nIM.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.nIM.getRootView());
        this.nIN = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.nIN.getRootView());
        this.nIN.getRootView().setVisibility(8);
        dMU();
    }

    public void V(Bitmap bitmap) {
        this.nIP.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.nIP.a(bitmap, this.nIS);
    }

    private void dMU() {
        this.njI = (FragmentTabWidget) this.ioA.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.njI.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.njI.setDiverColor(ap.getColor(R.color.cp_cont_j));
        this.njI.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.njI.setDviderRectWidth(com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.njI.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.nIM.getRootView().setVisibility(0);
                            j.this.nIN.getRootView().setVisibility(8);
                            if (y.isEmpty(j.this.mUrlList)) {
                                if (j.this.nIS != null) {
                                    j.this.nIS.dSv();
                                    break;
                                }
                            } else {
                                j.this.nIM.fV(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.nIP != null) {
                                j.this.nIP.ddN();
                            }
                            j.this.nIM.getRootView().setVisibility(8);
                            j.this.nIN.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.nIP != null) {
                                j.this.nIP.ddN();
                            }
                            j.this.nIM.getRootView().setVisibility(8);
                            j.this.nIN.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.njI.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Lw(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.ioA, R.color.cp_bg_line_e);
            SvgManager.boN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ap.setNavbarTitleColor(this.nIQ, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.nIP.setRemoveRes(R.drawable.icon_sticker_delete);
            this.nIM.onChangeSkinType();
            this.nIN.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.njI.setDiverColor(ap.getColor(R.color.cp_cont_j));
        }
    }

    public void dTS() {
        if (this.nFX == null) {
            this.nFX = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.nFX.om(R.string.orginal_conflict_tip);
            this.nFX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.nFX != null) {
                        j.this.nFX.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.nFX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.nFX != null) {
                        j.this.nFX.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.nFX.b(this.mTbPageContext);
        }
        this.nFX.bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.nIR);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void fY(List<String> list) {
        this.mUrlList = list;
        this.nIM.fV(list);
    }

    public void bRf() {
        this.nIM.bRf();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.nIR = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.nIP != null) {
            this.nIP.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
