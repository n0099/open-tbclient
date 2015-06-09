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
    private RelativeLayout bHH;
    private boolean bKi;
    private View bWV;
    private p cxV;
    private AlbumActivity cya;
    private e czl;
    private View czm;
    private View czn;
    private com.baidu.tieba.write.view.a czo;
    private ac czp;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private TextView mTitleText;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cya = (AlbumActivity) getBaseFragmentActivity();
        this.cxV = this.cya.arD();
        q.arU().a(this);
        this.czl = new e(this.cya.getPageContext().getPageActivity());
        this.czo = new com.baidu.tieba.write.view.a(this.cya);
        this.cxV.jX("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.r.album_image_list_view, (ViewGroup) null);
        this.bHH = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.q.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.bWV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cya);
        this.czn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.album_iamge_title_layout, (View.OnClickListener) null);
        this.mTitleText = (TextView) this.czn.findViewById(com.baidu.tieba.q.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(com.baidu.tieba.q.gv_image_list);
        this.czm = this.mView.findViewById(com.baidu.tieba.q.gv_foot);
        this.czp = new ac(this.cya, this.cxV);
        this.mGridView.setAdapter((ListAdapter) this.czp);
        this.mGridView.setOnScrollListener(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        am amVar = new am(this);
        an anVar = new an(this);
        ao aoVar = new ao(this);
        this.czn.setOnClickListener(anVar);
        this.czo.a(aoVar);
        this.czp.a(akVar);
        this.czp.a(alVar);
        this.czp.a(amVar);
        this.mNoDataView = NoDataViewFactory.a(this.cya.getPageContext().getPageActivity(), this.bHH, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.s(com.baidu.tieba.t.album_list_no_data, com.baidu.tieba.t.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bKi = false;
        if (isShow()) {
            arK();
        }
    }

    private void arJ() {
        if (this.cxV == null && this.cya != null) {
            this.cxV = this.cya.arD();
        }
        if (this.cxV != null && this.cxV.arS() == null) {
            setData(arZ(), true);
            jZ("-1");
        }
    }

    private List<ImageFileInfo> arZ() {
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
            this.czl.a(str, new ap(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asa() {
        this.czl.a(new aq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.czp != null) {
            this.cxV.be(list);
            this.czp.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.czm.setVisibility(0);
                } else {
                    this.czm.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cya.getLayoutMode().ab(i == 1);
        this.cya.getLayoutMode().j(this.mView);
        this.mNavigationBar.onChangeSkinType(this.cya.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View afO() {
        return this.bWV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.czl != null) {
            this.czl.arM();
        }
        q.arU().b(this);
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
        if (imageFileInfo != null && this.czp != null) {
            t(this.czp.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bKi = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.u
    public void fx(boolean z) {
        arK();
    }

    private void arK() {
        if (!isHidden() && !this.bKi) {
            arJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (an(((i + i2) - 1) + 1, 3) == an(i3, 3)) {
            if (this.czm.getVisibility() != 0) {
                this.czm.setVisibility(0);
            }
        } else if (this.czm.getVisibility() == 0) {
            this.czm.setVisibility(8);
        }
    }

    private int an(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.czp.fz(true);
        } else if (this.czp.isScroll()) {
            this.czp.fz(false);
            asb();
        }
    }

    private void asb() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.q.pic);
                ImageFileInfo item = this.czp.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.cya.arE().a(item, new ar(this), false, false);
                }
            }
        }
    }
}
