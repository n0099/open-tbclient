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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends BaseFragment implements AbsListView.OnScrollListener, p.a {
    private TextView bIN;
    private GridView dKz;
    private RelativeLayout dWm;
    private boolean eku;
    private o fKY;
    private AlbumActivity fLm;
    private View fLn;
    private h fMA;
    private View fMB;
    private com.baidu.tieba.write.view.a fMC;
    private ab fMD;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fLm = (AlbumActivity) getBaseFragmentActivity();
        this.fKY = this.fLm.bmD();
        p.bmZ().a(this);
        this.fMA = new h(this.fLm.getPageContext().getPageActivity());
        this.fMC = new com.baidu.tieba.write.view.a(this.fLm);
        this.fKY.qF("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(w.j.album_image_list_view, (ViewGroup) null);
        this.dWm = (RelativeLayout) this.mView.findViewById(w.h.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(w.h.view_navigation_bar);
        this.fLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fLm);
        this.fMB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.album_iamge_title_layout, (View.OnClickListener) null);
        this.bIN = (TextView) this.fMB.findViewById(w.h.navigationTitle_frs);
        this.dKz = (GridView) this.mView.findViewById(w.h.gv_image_list);
        this.fMD = new ab(this.fLm, this.fKY);
        this.dKz.setAdapter((ListAdapter) this.fMD);
        this.dKz.setOnScrollListener(this);
        this.dKz.setSelector(w.e.transparent);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.fMB.setOnClickListener(akVar);
        this.fMC.a(alVar);
        this.fMD.a(ahVar);
        this.fMD.a(aiVar);
        this.fMD.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.fLm.getPageContext().getPageActivity(), this.dWm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.E(w.l.album_list_no_data, w.l.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eku = false;
        if (isShow()) {
            bmO();
        }
    }

    private void bmN() {
        if (this.fKY == null && this.fLm != null) {
            this.fKY = this.fLm.bmD();
        }
        if (this.fKY != null && this.fKY.bmW() == null) {
            setData(bnf(), true);
            qH("-1");
        }
    }

    private List<ImageFileInfo> bnf() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void qH(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fMA.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bng() {
        this.fMA.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.fMD != null) {
            this.fKY.cY(list);
            this.fMD.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fLm.getLayoutMode().ah(i == 1);
        this.fLm.getLayoutMode().t(this.mView);
        if (this.fMD != null) {
            this.fMD.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.fLm.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bcd() {
        return this.fLn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fMA != null) {
            this.fMA.bmQ();
        }
        p.bmZ().b(this);
    }

    public void L(int i, boolean z) {
        if (this.dKz != null) {
            int firstVisiblePosition = this.dKz.getFirstVisiblePosition();
            int lastVisiblePosition = this.dKz.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.dKz.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(w.h.select_icon);
                    if (z) {
                        aq.j(imageView, w.g.btn_choose_photo_s);
                    } else {
                        aq.j(imageView, w.g.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.fMD != null) {
            L(this.fMD.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eku = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void lH(boolean z) {
        bmO();
    }

    private void bmO() {
        if (!isHidden() && !this.eku) {
            bmN();
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
            this.fMD.lJ(true);
        } else if (this.fMD.isScroll()) {
            this.fMD.lJ(false);
            bnh();
        }
    }

    private void bnh() {
        int childCount = this.dKz.getChildCount();
        int firstVisiblePosition = this.dKz.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dKz.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.pic);
                ImageFileInfo item = this.fMD.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fLm.ahu().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fMD != null) {
            this.fMD.notifyDataSetChanged();
        }
    }
}
