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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView Mf;
    private boolean cBv;
    private View cTp;
    private RelativeLayout cuP;
    private AlbumActivity dKK;
    private o dKx;
    private h dLX;
    private View dLY;
    private View dLZ;
    private com.baidu.tieba.write.view.a dMa;
    private ab dMb;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dKK = (AlbumActivity) getBaseFragmentActivity();
        this.dKx = this.dKK.aHn();
        p.aHI().a(this);
        this.dLX = new h(this.dKK.getPageContext().getPageActivity());
        this.dMa = new com.baidu.tieba.write.view.a(this.dKK);
        this.dKx.nl("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(n.g.album_image_list_view, (ViewGroup) null);
        this.cuP = (RelativeLayout) this.mView.findViewById(n.f.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(n.f.view_navigation_bar);
        this.cTp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dKK);
        this.dLZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.g.album_iamge_title_layout, (View.OnClickListener) null);
        this.Mf = (TextView) this.dLZ.findViewById(n.f.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(n.f.gv_image_list);
        this.dLY = this.mView.findViewById(n.f.gv_foot);
        this.dMb = new ab(this.dKK, this.dKx);
        this.mGridView.setAdapter((ListAdapter) this.dMb);
        this.mGridView.setOnScrollListener(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.dLZ.setOnClickListener(akVar);
        this.dMa.a(alVar);
        this.dMb.a(ahVar);
        this.dMb.a(aiVar);
        this.dMb.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.dKK.getPageContext().getPageActivity(), this.cuP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(n.i.album_list_no_data, n.i.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cBv = false;
        if (isShow()) {
            aHx();
        }
    }

    private void aHw() {
        if (this.dKx == null && this.dKK != null) {
            this.dKx = this.dKK.aHn();
        }
        if (this.dKx != null && this.dKx.aHF() == null) {
            setData(aHO(), true);
            nn("-1");
        }
    }

    private List<ImageFileInfo> aHO() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void nn(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dLX.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHP() {
        this.dLX.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.dMb != null) {
            this.dKx.bY(list);
            this.dMb.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.dLY.setVisibility(0);
                } else {
                    this.dLY.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dKK.getLayoutMode().af(i == 1);
        this.dKK.getLayoutMode().k(this.mView);
        if (this.dMb != null) {
            this.dMb.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.dKK.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View apG() {
        return this.cTp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLX != null) {
            this.dLX.aHz();
        }
        p.aHI().b(this);
    }

    public void w(int i, boolean z) {
        if (this.mGridView != null) {
            int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mGridView.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mGridView.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(n.f.select_icon);
                    if (z) {
                        as.i(imageView, n.e.btn_choose_photo_s);
                    } else {
                        as.i(imageView, n.e.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.dMb != null) {
            w(this.dMb.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cBv = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void hD(boolean z) {
        aHx();
    }

    private void aHx() {
        if (!isHidden() && !this.cBv) {
            aHw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (aP(((i + i2) - 1) + 1, 3) == aP(i3, 3)) {
            if (this.dLY.getVisibility() != 0) {
                this.dLY.setVisibility(0);
            }
        } else if (this.dLY.getVisibility() == 0) {
            this.dLY.setVisibility(8);
        }
    }

    private int aP(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.dMb.hF(true);
        } else if (this.dMb.isScroll()) {
            this.dMb.hF(false);
            aHQ();
        }
    }

    private void aHQ() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(n.f.pic);
                ImageFileInfo item = this.dMb.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.dKK.aHo().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.dMb != null) {
            this.dMb.notifyDataSetChanged();
        }
    }
}
