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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aj extends BaseFragment implements AbsListView.OnScrollListener, u {
    private RelativeLayout bHG;
    private boolean bKh;
    private View bWU;
    private p cxU;
    private AlbumActivity cxZ;
    private e czk;
    private View czl;
    private View czm;
    private com.baidu.tieba.write.view.a czn;
    private ac czo;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private TextView mTitleText;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cxZ = (AlbumActivity) getBaseFragmentActivity();
        this.cxU = this.cxZ.arC();
        q.arT().a(this);
        this.czk = new e(this.cxZ.getPageContext().getPageActivity());
        this.czn = new com.baidu.tieba.write.view.a(this.cxZ);
        this.cxU.jX("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.r.album_image_list_view, (ViewGroup) null);
        this.bHG = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.q.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.bWU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cxZ);
        this.czm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.album_iamge_title_layout, (View.OnClickListener) null);
        this.mTitleText = (TextView) this.czm.findViewById(com.baidu.tieba.q.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(com.baidu.tieba.q.gv_image_list);
        this.czl = this.mView.findViewById(com.baidu.tieba.q.gv_foot);
        this.czo = new ac(this.cxZ, this.cxU);
        this.mGridView.setAdapter((ListAdapter) this.czo);
        this.mGridView.setOnScrollListener(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        am amVar = new am(this);
        an anVar = new an(this);
        ao aoVar = new ao(this);
        this.czm.setOnClickListener(anVar);
        this.czn.a(aoVar);
        this.czo.a(akVar);
        this.czo.a(alVar);
        this.czo.a(amVar);
        this.mNoDataView = NoDataViewFactory.a(this.cxZ.getPageContext().getPageActivity(), this.bHG, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.s(com.baidu.tieba.t.album_list_no_data, com.baidu.tieba.t.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bKh = false;
        if (isShow()) {
            arJ();
        }
    }

    private void arI() {
        if (this.cxU == null && this.cxZ != null) {
            this.cxU = this.cxZ.arC();
        }
        if (this.cxU != null && this.cxU.arR() == null) {
            setData(arY(), true);
            jZ("-1");
        }
    }

    private List<ImageFileInfo> arY() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void jZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.czk.a(str, new ap(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arZ() {
        this.czk.a(new aq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.czo != null) {
            this.cxU.be(list);
            this.czo.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.czl.setVisibility(0);
                } else {
                    this.czl.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cxZ.getLayoutMode().ab(i == 1);
        this.cxZ.getLayoutMode().j(this.mView);
        this.mNavigationBar.onChangeSkinType(this.cxZ.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View afN() {
        return this.bWU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.czk != null) {
            this.czk.arL();
        }
        q.arT().b(this);
    }

    public void t(int i, boolean z) {
        if (this.mGridView != null) {
            int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mGridView.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mGridView.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.q.select_icon);
                    if (z) {
                        ay.i(imageView, com.baidu.tieba.p.btn_choose_photo_s);
                    } else {
                        ay.i(imageView, com.baidu.tieba.p.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.czo != null) {
            t(this.czo.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bKh = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.u
    public void fx(boolean z) {
        arJ();
    }

    private void arJ() {
        if (!isHidden() && !this.bKh) {
            arI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (an(((i + i2) - 1) + 1, 3) == an(i3, 3)) {
            if (this.czl.getVisibility() != 0) {
                this.czl.setVisibility(0);
            }
        } else if (this.czl.getVisibility() == 0) {
            this.czl.setVisibility(8);
        }
    }

    private int an(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.czo.fz(true);
        } else if (this.czo.isScroll()) {
            this.czo.fz(false);
            asa();
        }
    }

    private void asa() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.q.pic);
                ImageFileInfo item = this.czo.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.cxZ.arD().a(item, new ar(this), false, false);
                }
            }
        }
    }
}
