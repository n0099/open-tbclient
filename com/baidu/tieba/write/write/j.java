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
/* loaded from: classes7.dex */
public class j {
    public LinearLayout iNK;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private FragmentTabWidget nEp;
    private com.baidu.tbadk.core.dialog.a nZq;
    private com.baidu.tieba.write.write.sticker.a.c ocA;
    public com.baidu.tieba.write.view.a.c ocu;
    public com.baidu.tieba.write.view.a.b ocv;
    public StickerLayout ocx;
    private WriteImagesInfo ocz;
    private int mSkinType = 3;
    public BdBaseViewPager ocw = null;
    public TextView ocy = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.ocA = cVar;
        this.iNK = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.ocw = (BdBaseViewPager) this.iNK.findViewById(R.id.write_multi_imgs_viewpager);
        this.ocx = (StickerLayout) this.iNK.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.iNK.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.ocy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.mTbPageContext != null && j.this.mTbPageContext.getPageActivity() != null) {
                    j.this.mTbPageContext.getPageActivity().setResult(0);
                    j.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.iNK.findViewById(R.id.edit_container);
        this.ocu = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.ocu.a(new e() { // from class: com.baidu.tieba.write.write.j.2
            @Override // com.baidu.tieba.write.write.e
            public void d(Bitmap bitmap, boolean z) {
                if (j.this.ocA == null || !j.this.ocA.U(bitmap)) {
                    j.this.V(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.ocu.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.ocu.getRootView());
        this.ocv = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.ocv.getRootView());
        this.ocv.getRootView().setVisibility(8);
        dQQ();
    }

    public void V(Bitmap bitmap) {
        this.ocx.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.ocx.a(bitmap, this.ocA);
    }

    private void dQQ() {
        this.nEp = (FragmentTabWidget) this.iNK.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.nEp.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.nEp.setDiverColor(ao.getColor(R.color.CAM_X0107));
        this.nEp.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nEp.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.nEp.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.j.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != j.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            j.this.ocu.getRootView().setVisibility(0);
                            j.this.ocv.getRootView().setVisibility(8);
                            if (x.isEmpty(j.this.mUrlList)) {
                                if (j.this.ocA != null) {
                                    j.this.ocA.dVJ();
                                    break;
                                }
                            } else {
                                j.this.ocu.gk(j.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (j.this.ocx != null) {
                                j.this.ocx.dgS();
                            }
                            j.this.ocu.getRootView().setVisibility(8);
                            j.this.ocv.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (j.this.ocx != null) {
                                j.this.ocx.dgS();
                            }
                            j.this.ocu.getRootView().setVisibility(8);
                            j.this.ocv.getRootView().setVisibility(0);
                            break;
                    }
                    j.this.mCurrentTabIndex = i2;
                    j.this.nEp.setCurrentTab(j.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Lj(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.iNK, R.color.CAM_X0205);
            SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            ao.setNavbarTitleColor(this.ocy, R.color.CAM_X0302, R.color.s_navbar_title_color);
            this.ocx.setRemoveRes(R.drawable.icon_sticker_delete);
            this.ocu.onChangeSkinType();
            this.ocv.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.nEp.setDiverColor(ao.getColor(R.color.CAM_X0107));
        }
    }

    public void dXk() {
        if (this.nZq == null) {
            this.nZq = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.nZq.nu(R.string.orginal_conflict_tip);
            this.nZq.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.j.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.nZq != null) {
                        j.this.nZq.dismiss();
                    }
                    j.this.finishActivity(true);
                }
            });
            this.nZq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.j.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (j.this.nZq != null) {
                        j.this.nZq.dismiss();
                    }
                    j.this.finishActivity(false);
                }
            });
            this.nZq.b(this.mTbPageContext);
        }
        this.nZq.bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.ocz);
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void gn(List<String> list) {
        this.mUrlList = list;
        this.ocu.gk(list);
    }

    public void bVw() {
        this.ocu.bVw();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.ocz = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.ocx != null) {
            this.ocx.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
