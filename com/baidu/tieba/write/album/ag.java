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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView FZ;
    private RelativeLayout dKv;
    private boolean dYU;
    private GridView dyJ;
    private o fxZ;
    private AlbumActivity fyo;
    private View fyp;
    private h fzD;
    private View fzE;
    private com.baidu.tieba.write.view.a fzF;
    private ab fzG;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fyo = (AlbumActivity) getBaseFragmentActivity();
        this.fxZ = this.fyo.bls();
        p.blO().a(this);
        this.fzD = new h(this.fyo.getPageContext().getPageActivity());
        this.fzF = new com.baidu.tieba.write.view.a(this.fyo);
        this.fxZ.re("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(r.h.album_image_list_view, (ViewGroup) null);
        this.dKv = (RelativeLayout) this.mView.findViewById(r.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(r.g.view_navigation_bar);
        this.fyp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fyo);
        this.fzE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, r.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.FZ = (TextView) this.fzE.findViewById(r.g.navigationTitle_frs);
        this.dyJ = (GridView) this.mView.findViewById(r.g.gv_image_list);
        this.fzG = new ab(this.fyo, this.fxZ);
        this.dyJ.setAdapter((ListAdapter) this.fzG);
        this.dyJ.setOnScrollListener(this);
        this.dyJ.setSelector(r.d.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.fzE.setOnClickListener(akVar);
        this.fzF.a(alVar);
        this.fzG.a(ahVar);
        this.fzG.a(aiVar);
        this.fzG.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.fyo.getPageContext().getPageActivity(), this.dKv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.x(r.j.album_list_no_data, r.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.dYU = false;
        if (isShow()) {
            blD();
        }
    }

    private void blC() {
        if (this.fxZ == null && this.fyo != null) {
            this.fxZ = this.fyo.bls();
        }
        if (this.fxZ != null && this.fxZ.blL() == null) {
            setData(blU(), true);
            rg("-1");
        }
    }

    private List<ImageFileInfo> blU() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void rg(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fzD.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blV() {
        this.fzD.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.fzG != null) {
            this.fxZ.dm(list);
            this.fzG.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fyo.getLayoutMode().ai(i == 1);
        this.fyo.getLayoutMode().x(this.mView);
        if (this.fzG != null) {
            this.fzG.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.fyo.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View baC() {
        return this.fyp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fzD != null) {
            this.fzD.blF();
        }
        p.blO().b(this);
    }

    public void K(int i, boolean z) {
        if (this.dyJ != null) {
            int firstVisiblePosition = this.dyJ.getFirstVisiblePosition();
            int lastVisiblePosition = this.dyJ.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dyJ.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(r.g.select_icon);
                    if (z) {
                        ar.k(imageView, r.f.btn_choose_photo_s);
                    } else {
                        ar.k(imageView, r.f.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.fzG != null) {
            K(this.fzG.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dYU = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void ly(boolean z) {
        blD();
    }

    private void blD() {
        if (!isHidden() && !this.dYU) {
            blC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.fzG.lA(true);
        } else if (this.fzG.isScroll()) {
            this.fzG.lA(false);
            blW();
        }
    }

    private void blW() {
        int childCount = this.dyJ.getChildCount();
        int firstVisiblePosition = this.dyJ.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dyJ.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.g.pic);
                ImageFileInfo item = this.fzG.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fyo.ahb().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fzG != null) {
            this.fzG.notifyDataSetChanged();
        }
    }
}
