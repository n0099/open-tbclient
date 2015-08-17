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
public class ad extends BaseFragment implements AbsListView.OnScrollListener, n.a {
    private TextView LM;
    private RelativeLayout aGb;
    private m cPJ;
    private AlbumActivity cPQ;
    private f cRa;
    private View cRb;
    private View cRc;
    private com.baidu.tieba.write.view.a cRd;
    private y cRe;
    private boolean caA;
    private View cnO;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cPQ = (AlbumActivity) getBaseFragmentActivity();
        this.cPJ = this.cPQ.atA();
        n.atR().a(this);
        this.cRa = new f(this.cPQ.getPageContext().getPageActivity());
        this.cRd = new com.baidu.tieba.write.view.a(this.cPQ);
        this.cPJ.kX("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(i.g.album_image_list_view, (ViewGroup) null);
        this.aGb = (RelativeLayout) this.mView.findViewById(i.f.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(i.f.view_navigation_bar);
        this.cnO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cPQ);
        this.cRc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.album_iamge_title_layout, (View.OnClickListener) null);
        this.LM = (TextView) this.cRc.findViewById(i.f.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(i.f.gv_image_list);
        this.cRb = this.mView.findViewById(i.f.gv_foot);
        this.cRe = new y(this.cPQ, this.cPJ);
        this.mGridView.setAdapter((ListAdapter) this.cRe);
        this.mGridView.setOnScrollListener(this);
        ae aeVar = new ae(this);
        af afVar = new af(this);
        ag agVar = new ag(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        this.cRc.setOnClickListener(ahVar);
        this.cRd.a(aiVar);
        this.cRe.a(aeVar);
        this.cRe.a(afVar);
        this.cRe.a(agVar);
        this.mNoDataView = NoDataViewFactory.a(this.cPQ.getPageContext().getPageActivity(), this.aGb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.C0057i.album_list_no_data, i.C0057i.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.caA = false;
        if (isShow()) {
            atH();
        }
    }

    private void atG() {
        if (this.cPJ == null && this.cPQ != null) {
            this.cPJ = this.cPQ.atA();
        }
        if (this.cPJ != null && this.cPJ.atP() == null) {
            setData(atW(), true);
            kZ("-1");
        }
    }

    private List<ImageFileInfo> atW() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void kZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cRa.a(str, new aj(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atX() {
        this.cRa.a(new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.cRe != null) {
            this.cPJ.bn(list);
            this.cRe.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.cRb.setVisibility(0);
                } else {
                    this.cRb.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cPQ.getLayoutMode().ad(i == 1);
        this.cPQ.getLayoutMode().k(this.mView);
        this.mNavigationBar.onChangeSkinType(this.cPQ.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View ahK() {
        return this.cnO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cRa != null) {
            this.cRa.atJ();
        }
        n.atR().b(this);
    }

    public void r(int i, boolean z) {
        if (this.mGridView != null) {
            int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mGridView.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mGridView.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(i.f.select_icon);
                    if (z) {
                        com.baidu.tbadk.core.util.al.i(imageView, i.e.btn_choose_photo_s);
                    } else {
                        com.baidu.tbadk.core.util.al.i(imageView, i.e.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.cRe != null) {
            r(this.cRe.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.caA = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.n.a
    public void fS(boolean z) {
        atH();
    }

    private void atH() {
        if (!isHidden() && !this.caA) {
            atG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (aD(((i + i2) - 1) + 1, 3) == aD(i3, 3)) {
            if (this.cRb.getVisibility() != 0) {
                this.cRb.setVisibility(0);
            }
        } else if (this.cRb.getVisibility() == 0) {
            this.cRb.setVisibility(8);
        }
    }

    private int aD(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.cRe.fU(true);
        } else if (this.cRe.isScroll()) {
            this.cRe.fU(false);
            atY();
        }
    }

    private void atY() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.pic);
                ImageFileInfo item = this.cRe.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.cPQ.atB().a(item, new al(this), false, false);
                }
            }
        }
    }
}
