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
    private RelativeLayout bYq;
    private AlbumActivity cYB;
    private m cYt;
    private f cZL;
    private View cZM;
    private View cZN;
    private com.baidu.tieba.write.view.a cZO;
    private y cZP;
    private boolean cbv;
    private View coP;
    private GridView mGridView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cYB = (AlbumActivity) getBaseFragmentActivity();
        this.cYt = this.cYB.axT();
        n.ayk().a(this);
        this.cZL = new f(this.cYB.getPageContext().getPageActivity());
        this.cZO = new com.baidu.tieba.write.view.a(this.cYB);
        this.cYt.lE("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(i.g.album_image_list_view, (ViewGroup) null);
        this.bYq = (RelativeLayout) this.mView.findViewById(i.f.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(i.f.view_navigation_bar);
        this.coP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cYB);
        this.cZN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, i.g.album_iamge_title_layout, (View.OnClickListener) null);
        this.LM = (TextView) this.cZN.findViewById(i.f.navigationTitle_frs);
        this.mGridView = (GridView) this.mView.findViewById(i.f.gv_image_list);
        this.cZM = this.mView.findViewById(i.f.gv_foot);
        this.cZP = new y(this.cYB, this.cYt);
        this.mGridView.setAdapter((ListAdapter) this.cZP);
        this.mGridView.setOnScrollListener(this);
        ae aeVar = new ae(this);
        af afVar = new af(this);
        ag agVar = new ag(this);
        ah ahVar = new ah(this);
        ai aiVar = new ai(this);
        this.cZN.setOnClickListener(ahVar);
        this.cZO.a(aiVar);
        this.cZP.a(aeVar);
        this.cZP.a(afVar);
        this.cZP.a(agVar);
        this.mNoDataView = NoDataViewFactory.a(this.cYB.getPageContext().getPageActivity(), this.bYq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.album_list_no_data, i.h.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cbv = false;
        if (isShow()) {
            aya();
        }
    }

    private void axZ() {
        if (this.cYt == null && this.cYB != null) {
            this.cYt = this.cYB.axT();
        }
        if (this.cYt != null && this.cYt.ayi() == null) {
            setData(ayp(), true);
            lG("-1");
        }
    }

    private List<ImageFileInfo> ayp() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void lG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cZL.a(str, new aj(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayq() {
        this.cZL.a(new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.cZP != null) {
            this.cYt.bw(list);
            this.cZP.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.cZM.setVisibility(0);
                } else {
                    this.cZM.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cYB.getLayoutMode().ad(i == 1);
        this.cYB.getLayoutMode().k(this.mView);
        this.mNavigationBar.onChangeSkinType(this.cYB.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aic() {
        return this.coP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cZL != null) {
            this.cZL.ayc();
        }
        n.ayk().b(this);
    }

    public void s(int i, boolean z) {
        if (this.mGridView != null) {
            int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mGridView.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mGridView.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(i.f.select_icon);
                    if (z) {
                        com.baidu.tbadk.core.util.al.h(imageView, i.e.btn_choose_photo_s);
                    } else {
                        com.baidu.tbadk.core.util.al.h(imageView, i.e.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.cZP != null) {
            s(this.cZP.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cbv = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.n.a
    public void gD(boolean z) {
        aya();
    }

    private void aya() {
        if (!isHidden() && !this.cbv) {
            axZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (aM(((i + i2) - 1) + 1, 3) == aM(i3, 3)) {
            if (this.cZM.getVisibility() != 0) {
                this.cZM.setVisibility(0);
            }
        } else if (this.cZM.getVisibility() == 0) {
            this.cZM.setVisibility(8);
        }
    }

    private int aM(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.cZP.gF(true);
        } else if (this.cZP.isScroll()) {
            this.cZP.gF(false);
            ayr();
        }
    }

    private void ayr() {
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.pic);
                ImageFileInfo item = this.cZP.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.cYB.axU().a(item, new al(this), false, false);
                }
            }
        }
    }
}
