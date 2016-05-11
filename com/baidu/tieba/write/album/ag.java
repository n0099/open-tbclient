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
    private TextView Di;
    private GridView cRJ;
    private View dHC;
    private RelativeLayout dbg;
    private boolean diA;
    private AlbumActivity eXM;
    private o eXx;
    private h eYR;
    private View eYS;
    private com.baidu.tieba.write.view.a eYT;
    private ab eYU;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXM = (AlbumActivity) getBaseFragmentActivity();
        this.eXx = this.eXM.bbn();
        p.bbD().a(this);
        this.eYR = new h(this.eXM.getPageContext().getPageActivity());
        this.eYT = new com.baidu.tieba.write.view.a(this.eXM);
        this.eXx.pb("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(t.h.album_image_list_view, (ViewGroup) null);
        this.dbg = (RelativeLayout) this.mView.findViewById(t.g.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(t.g.view_navigation_bar);
        this.dHC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eXM);
        this.eYS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, t.h.album_iamge_title_layout, (View.OnClickListener) null);
        this.Di = (TextView) this.eYS.findViewById(t.g.navigationTitle_frs);
        this.cRJ = (GridView) this.mView.findViewById(t.g.gv_image_list);
        this.eYU = new ab(this.eXM, this.eXx);
        this.cRJ.setAdapter((ListAdapter) this.eYU);
        this.cRJ.setOnScrollListener(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        this.eYS.setOnClickListener(akVar);
        this.eYT.a(alVar);
        this.eYU.a(ahVar);
        this.eYU.a(aiVar);
        this.eYU.a(ajVar);
        this.mNoDataView = NoDataViewFactory.a(this.eXM.getPageContext().getPageActivity(), this.dbg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.v(t.j.album_list_no_data, t.j.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.diA = false;
        if (isShow()) {
            bbw();
        }
    }

    private void bbv() {
        if (this.eXx == null && this.eXM != null) {
            this.eXx = this.eXM.bbn();
        }
        if (this.eXx != null && this.eXx.bbA() == null) {
            setData(bbJ(), true);
            pd("-1");
        }
    }

    private List<ImageFileInfo> bbJ() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void pd(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eYR.a(str, new am(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbK() {
        this.eYR.a(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.eYU != null) {
            this.eXx.cM(list);
            this.eYU.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eXM.getLayoutMode().ae(i == 1);
        this.eXM.getLayoutMode().x(this.mView);
        if (this.eYU != null) {
            this.eYU.notifyDataSetChanged();
        }
        this.mNavigationBar.onChangeSkinType(this.eXM.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aEo() {
        return this.dHC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eYR != null) {
            this.eYR.aYF();
        }
        p.bbD().b(this);
    }

    public void D(int i, boolean z) {
        if (this.cRJ != null) {
            int firstVisiblePosition = this.cRJ.getFirstVisiblePosition();
            int lastVisiblePosition = this.cRJ.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.cRJ.getChildAt(i - firstVisiblePosition);
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
        if (imageFileInfo != null && this.eYU != null) {
            D(this.eYU.i(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.diA = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.p.a
    public void ku(boolean z) {
        bbw();
    }

    private void bbw() {
        if (!isHidden() && !this.diA) {
            bbv();
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
            this.eYU.kc(true);
        } else if (this.eYU.isScroll()) {
            this.eYU.kc(false);
            aXp();
        }
    }

    private void aXp() {
        int childCount = this.cRJ.getChildCount();
        int firstVisiblePosition = this.cRJ.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cRJ.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.pic);
                ImageFileInfo item = this.eYU.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.eXM.YI().a(item, new ao(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.eYU != null) {
            this.eYU.notifyDataSetChanged();
        }
    }
}
