package com.baidu.tieba.write.album;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends BaseFragment implements AbsListView.OnScrollListener, n.a {
    private TextView LO;
    private RelativeLayout ccO;
    private boolean ciY;
    private View cwi;
    private AlbumActivity dlE;
    private m dlv;
    private f dmR;
    private View dmS;
    private View dmT;
    private com.baidu.tieba.write.view.a dmU;
    private z dmV;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dlE = (AlbumActivity) getBaseFragmentActivity();
        this.dlv = this.dlE.aBQ();
        n.aCl().a(this);
        this.dmR = new f(this.dlE.getPageContext().getPageActivity());
        this.dmU = new com.baidu.tieba.write.view.a(this.dlE);
        this.dlv.mq("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(i.g.album_image_list_view, (ViewGroup) null);
        this.ccO = (RelativeLayout) this.mView.findViewById(i.f.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(i.f.view_navigation_bar);
        this.cwi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dlE);
        this.dmT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.album_iamge_title_layout, (View.OnClickListener) null);
        this.LO = (TextView) this.dmT.findViewById(i.f.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(i.f.gv_image_list);
        this.dmS = this.mView.findViewById(i.f.gv_foot);
        this.dmV = new z(this.dlE, this.dlv);
        this.mGridView.setAdapter((ListAdapter) this.dmV);
        this.mGridView.setOnScrollListener(this);
        af afVar = new af(this);
        ag agVar = new ag(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        this.dmT.setOnClickListener(aiVar);
        this.dmU.a(ajVar);
        this.dmV.a(afVar);
        this.dmV.a(agVar);
        this.dmV.a(ahVar);
        this.mNoDataView = NoDataViewFactory.a(this.dlE.getPageContext().getPageActivity(), this.ccO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.album_list_no_data, i.h.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ciY = false;
        if (isShow()) {
            aCa();
        }
    }

    private void aBZ() {
        if (this.dlv == null && this.dlE != null) {
            this.dlv = this.dlE.aBQ();
        }
        if (this.dlv != null && this.dlv.aCi() == null) {
            setData(aCr(), true);
            ms("-1");
        }
    }

    private List<ImageFileInfo> aCr() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void ms(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dmR.a(str, new ak(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCs() {
        this.dmR.a(new al(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.dmV != null) {
            this.dlv.bK(list);
            this.dmV.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.dmS.setVisibility(0);
                } else {
                    this.dmS.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dlE.getLayoutMode().ad(i == 1);
        this.dlE.getLayoutMode().k(this.mView);
        this.mNavigationBar.onChangeSkinType(this.dlE.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View akF() {
        return this.cwi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dmR != null) {
            this.dmR.aCc();
        }
        n.aCl().b(this);
    }

    public void v(int i, boolean z) {
        if (this.mGridView != null) {
            int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mGridView.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mGridView.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(i.f.select_icon);
                    if (z) {
                        com.baidu.tbadk.core.util.an.i(imageView, i.e.btn_choose_photo_s);
                    } else {
                        com.baidu.tbadk.core.util.an.i(imageView, i.e.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.dmV != null) {
            v(this.dmV.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ciY = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.n.a
    public void gV(boolean z) {
        aCa();
    }

    private void aCa() {
        if (!isHidden() && !this.ciY) {
            aBZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (aN(((i + i2) - 1) + 1, 3) == aN(i3, 3)) {
            if (this.dmS.getVisibility() != 0) {
                this.dmS.setVisibility(0);
            }
        } else if (this.dmS.getVisibility() == 0) {
            this.dmS.setVisibility(8);
        }
    }

    private int aN(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.dmV.gX(true);
        } else if (this.dmV.isScroll()) {
            this.dmV.gX(false);
            aCt();
        }
    }

    private void aCt() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.pic);
                ImageFileInfo item = this.dmV.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.dlE.aBR().a(item, new am(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.dmV != null) {
            this.dmV.notifyDataSetChanged();
        }
    }
}
