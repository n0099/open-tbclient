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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView MR;
    private GridView cQM;
    private RelativeLayout cYO;
    private View dEn;
    private boolean dgn;
    private o eGD;
    private AlbumActivity eGS;
    private h eHX;
    private View eHY;
    private View eHZ;
    private com.baidu.tieba.write.view.a eIa;
    private ab eIb;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.p mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eGS = (AlbumActivity) getBaseFragmentActivity();
        this.eGD = this.eGS.aYX();
        p.aZo().a(this);
        this.eHX = new h(this.eGS.getPageContext().getPageActivity());
        this.eIa = new com.baidu.tieba.write.view.a(this.eGS);
        this.eGD.oM("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(t.h.album_image_list_view, (ViewGroup) null);
        this.cYO = (RelativeLayout) this.mView.findViewById(t.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(t.g.view_navigation_bar);
        this.dEn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eGS);
        this.eHZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.MR = (TextView) this.eHZ.findViewById(t.g.navigationTitle_frs);
        this.cQM = (GridView) this.mView.findViewById(t.g.gv_image_list);
        this.eHY = this.mView.findViewById(t.g.gv_foot);
        this.eIb = new ab(this.eGS, this.eGD);
        this.cQM.setAdapter((ListAdapter) this.eIb);
        this.cQM.setOnScrollListener(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.eHZ.setOnClickListener(akVar);
        this.eIa.a(alVar);
        this.eIb.a(ahVar);
        this.eIb.a(aiVar);
        this.eIb.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.eGS.getPageContext().getPageActivity(), this.cYO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.v(t.j.album_list_no_data, t.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dgn = false;
        if (isShow()) {
            aZg();
        }
    }

    private void aZf() {
        if (this.eGD == null && this.eGS != null) {
            this.eGD = this.eGS.aYX();
        }
        if (this.eGD != null && this.eGD.aZl() == null) {
            setData(aZu(), true);
            oO("-1");
        }
    }

    private List<ImageFileInfo> aZu() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void oO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eHX.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZv() {
        this.eHX.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.eIb != null) {
            this.eGD.cE(list);
            this.eIb.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.eHY.setVisibility(0);
                } else {
                    this.eHY.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eGS.getLayoutMode().ab(i == 1);
        this.eGS.getLayoutMode().x(this.mView);
        if (this.eIb != null) {
            this.eIb.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.eGS.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aDR() {
        return this.dEn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eHX != null) {
            this.eHX.aWZ();
        }
        p.aZo().b(this);
    }

    public void z(int i, boolean z) {
        if (this.cQM != null) {
            int firstVisiblePosition = this.cQM.getFirstVisiblePosition();
            int lastVisiblePosition = this.cQM.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.cQM.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(t.g.select_icon);
                    if (z) {
                        at.k(imageView, t.f.btn_choose_photo_s);
                    } else {
                        at.k(imageView, t.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.eIb != null) {
            z(this.eIb.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dgn = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void jo(boolean z) {
        aZg();
    }

    private void aZg() {
        if (!isHidden() && !this.dgn) {
            aZf();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (bl(((i + i2) - 1) + 1, 3) == bl(i3, 3)) {
            if (this.eHY.getVisibility() != 0) {
                this.eHY.setVisibility(0);
            }
        } else if (this.eHY.getVisibility() == 0) {
            this.eHY.setVisibility(8);
        }
    }

    private int bl(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.eIb.je(true);
        } else if (this.eIb.isScroll()) {
            this.eIb.je(false);
            aWw();
        }
    }

    private void aWw() {
        int childCount = this.cQM.getChildCount();
        int firstVisiblePosition = this.cQM.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cQM.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.pic);
                ImageFileInfo item = this.eIb.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.eGS.YO().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.eIb != null) {
            this.eIb.notifyDataSetChanged();
        }
    }
}
