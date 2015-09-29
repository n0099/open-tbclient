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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends BaseFragment implements AbsListView.OnScrollListener, m.a {
    private TextView LM;
    private RelativeLayout ccc;
    private boolean chK;
    private View cuB;
    private l djp;
    private AlbumActivity djw;
    private e dkJ;
    private View dkK;
    private View dkL;
    private com.baidu.tieba.write.view.a dkM;
    private x dkN;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djw = (AlbumActivity) getBaseFragmentActivity();
        this.djp = this.djw.aAU();
        m.aBp().a(this);
        this.dkJ = new e(this.djw.getPageContext().getPageActivity());
        this.dkM = new com.baidu.tieba.write.view.a(this.djw);
        this.djp.mj("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(i.g.album_image_list_view, (ViewGroup) null);
        this.ccc = (RelativeLayout) this.mView.findViewById(i.f.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(i.f.view_navigation_bar);
        this.cuB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.djw);
        this.dkL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.album_iamge_title_layout, (View.OnClickListener) null);
        this.LM = (TextView) this.dkL.findViewById(i.f.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(i.f.gv_image_list);
        this.dkK = this.mView.findViewById(i.f.gv_foot);
        this.dkN = new x(this.djw, this.djp);
        this.mGridView.setAdapter((ListAdapter) this.dkN);
        this.mGridView.setOnScrollListener(this);
        ad adVar = new ad(this);
        ae aeVar = new ae(this);
        af afVar = new af(this);
        ag agVar = new ag(this);
        ah ahVar = new ah(this);
        this.dkL.setOnClickListener(agVar);
        this.dkM.a(ahVar);
        this.dkN.a(adVar);
        this.dkN.a(aeVar);
        this.dkN.a(afVar);
        this.mNoDataView = NoDataViewFactory.a(this.djw.getPageContext().getPageActivity(), this.ccc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.album_list_no_data, i.h.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.chK = false;
        if (isShow()) {
            aBe();
        }
    }

    private void aBd() {
        if (this.djp == null && this.djw != null) {
            this.djp = this.djw.aAU();
        }
        if (this.djp != null && this.djp.aBm() == null) {
            setData(aBv(), true);
            ml("-1");
        }
    }

    private List<ImageFileInfo> aBv() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void ml(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dkJ.a(str, new ai(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        this.dkJ.a(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.dkN != null) {
            this.djp.bF(list);
            this.dkN.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.dkK.setVisibility(0);
                } else {
                    this.dkK.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djw.getLayoutMode().ad(i == 1);
        this.djw.getLayoutMode().k(this.mView);
        this.mNavigationBar.onChangeSkinType(this.djw.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View akd() {
        return this.cuB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dkJ != null) {
            this.dkJ.aBg();
        }
        m.aBp().b(this);
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
                        am.i(imageView, i.e.btn_choose_photo_s);
                    } else {
                        am.i(imageView, i.e.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.dkN != null) {
            v(this.dkN.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.chK = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.m.a
    public void gS(boolean z) {
        aBe();
    }

    private void aBe() {
        if (!isHidden() && !this.chK) {
            aBd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (aL(((i + i2) - 1) + 1, 3) == aL(i3, 3)) {
            if (this.dkK.getVisibility() != 0) {
                this.dkK.setVisibility(0);
            }
        } else if (this.dkK.getVisibility() == 0) {
            this.dkK.setVisibility(8);
        }
    }

    private int aL(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.dkN.gU(true);
        } else if (this.dkN.isScroll()) {
            this.dkN.gU(false);
            aBx();
        }
    }

    private void aBx() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.pic);
                ImageFileInfo item = this.dkN.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.djw.aAV().a(item, new ak(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.dkN != null) {
            this.dkN.notifyDataSetChanged();
        }
    }
}
