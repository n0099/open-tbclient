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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class h {
    public LinearLayout fZy;
    private com.baidu.tbadk.core.dialog.a kRj;
    public com.baidu.tieba.write.view.a.c kTt;
    public com.baidu.tieba.write.view.a.b kTu;
    public StickerLayout kTw;
    private WriteImagesInfo kTy;
    private com.baidu.tieba.write.write.sticker.a.c kTz;
    private FragmentTabWidget kxt;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteMultiImgsActivity> mTbPageContext;
    private List<String> mUrlList;
    private int mSkinType = 3;
    public BdBaseViewPager kTv = null;
    public TextView kTx = null;
    public int mCurrentTabIndex = 0;
    private ArrayList<FragmentTabIndicator> mTabs = new ArrayList<>();

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, com.baidu.tieba.write.write.sticker.a.c cVar) {
        this.mTbPageContext = tbPageContext;
        this.kTz = cVar;
        this.fZy = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        initUI();
    }

    private void initUI() {
        this.kTv = (BdBaseViewPager) this.fZy.findViewById(R.id.write_multi_imgs_viewpager);
        this.kTw = (StickerLayout) this.fZy.findViewById(R.id.stickers_container);
        Resources resources = this.mTbPageContext.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.mTbPageContext.getResources();
        this.mNavigationBar = (NavigationBar) this.fZy.findViewById(R.id.write_multi_imgs_navibar);
        this.mNavigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.mNavigationBar.showBottomLine();
        this.kTx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.mTbPageContext != null && h.this.mTbPageContext.getPageActivity() != null) {
                    h.this.mTbPageContext.getPageActivity().setResult(0);
                    h.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.fZy.findViewById(R.id.edit_container);
        this.kTt = new com.baidu.tieba.write.view.a.c(this.mTbPageContext);
        this.kTt.a(new c() { // from class: com.baidu.tieba.write.write.h.2
            @Override // com.baidu.tieba.write.write.c
            public void d(Bitmap bitmap, boolean z) {
                if (h.this.kTz == null || !h.this.kTz.N(bitmap)) {
                    h.this.O(bitmap);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds36), 0, 0);
        this.kTt.getRootView().setLayoutParams(layoutParams);
        frameLayout.addView(this.kTt.getRootView());
        this.kTu = new com.baidu.tieba.write.view.a.b(this.mTbPageContext);
        frameLayout.addView(this.kTu.getRootView());
        this.kTu.getRootView().setVisibility(8);
        cOO();
    }

    public void O(Bitmap bitmap) {
        this.kTw.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.kTw.a(bitmap, this.kTz);
    }

    private void cOO() {
        this.kxt = (FragmentTabWidget) this.fZy.findViewById(R.id.tab_widget);
        Resources resources = this.mTbPageContext.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.mTabs.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mTbPageContext.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.kxt.addView(fragmentTabIndicator, i);
            this.mTabs.add(fragmentTabIndicator);
        }
        this.kxt.setDiverColor(am.getColor(R.color.cp_cont_j));
        this.kxt.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kxt.setDviderRectWidth(l.getDimens(this.mTbPageContext.getContext(), R.dimen.ds64));
        this.kxt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.write.write.h.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != h.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            h.this.kTt.getRootView().setVisibility(0);
                            h.this.kTu.getRootView().setVisibility(8);
                            if (v.isEmpty(h.this.mUrlList)) {
                                if (h.this.kTz != null) {
                                    h.this.kTz.cUn();
                                    break;
                                }
                            } else {
                                h.this.kTt.eE(h.this.mUrlList);
                                break;
                            }
                            break;
                        case 1:
                            if (h.this.kTw != null) {
                                h.this.kTw.chc();
                            }
                            h.this.kTt.getRootView().setVisibility(8);
                            h.this.kTu.getRootView().setVisibility(0);
                            break;
                        case 2:
                            if (h.this.kTw != null) {
                                h.this.kTw.chc();
                            }
                            h.this.kTt.getRootView().setVisibility(8);
                            h.this.kTu.getRootView().setVisibility(0);
                            break;
                    }
                    h.this.mCurrentTabIndex = i2;
                    h.this.kxt.setCurrentTab(h.this.mCurrentTabIndex, true, true);
                }
            }
        });
    }

    public void Er(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.fZy, R.color.cp_bg_line_e);
            SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
            am.setNavbarTitleColor(this.kTx, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kTw.setRemoveRes(R.drawable.icon_sticker_delete);
            this.kTt.onChangeSkinType();
            this.kTu.onChangeSkinType();
            Iterator<FragmentTabIndicator> it = this.mTabs.iterator();
            while (it.hasNext()) {
                FragmentTabIndicator next = it.next();
                if (next != null) {
                    next.onChangeSkin(i);
                }
            }
            this.kxt.setDiverColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void cVp() {
        if (this.kRj == null) {
            this.kRj = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            this.kRj.jF(R.string.orginal_conflict_tip);
            this.kRj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.kRj != null) {
                        h.this.kRj.dismiss();
                    }
                    h.this.finishActivity(true);
                }
            });
            this.kRj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.kRj != null) {
                        h.this.kRj.dismiss();
                    }
                    h.this.finishActivity(false);
                }
            });
            this.kRj.b(this.mTbPageContext);
        }
        this.kRj.aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(boolean z) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, this.kTy);
        }
    }

    public void b(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mTbPageContext != null && this.mTbPageContext.getOrignalPage() != null) {
            this.mTbPageContext.getOrignalPage().a(z, writeImagesInfo);
        }
    }

    public void eF(List<String> list) {
        this.mUrlList = list;
        this.kTt.eE(list);
    }

    public void bdC() {
        this.kTt.bdC();
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        this.kTy = writeImagesInfo;
    }

    public void onDestroy() {
        if (this.kTw != null) {
            this.kTw.a((com.baidu.tieba.write.write.sticker.a.c) null);
        }
    }
}
