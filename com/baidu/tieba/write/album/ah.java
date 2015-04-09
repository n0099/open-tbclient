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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends BaseFragment implements AbsListView.OnScrollListener, s {
    private GridView bAI;
    private RelativeLayout bEL;
    private boolean bHS;
    private View bUn;
    private n ctF;
    private AlbumActivity ctK;
    private e cuS;
    private View cuT;
    private View cuU;
    private com.baidu.tieba.write.view.a cuV;
    private aa cuW;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private TextView mTitleText;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctK = (AlbumActivity) getBaseFragmentActivity();
        this.ctF = this.ctK.apM();
        o.aqd().a(this);
        this.cuS = new e(this.ctK.getPageContext().getPageActivity());
        this.cuV = new com.baidu.tieba.write.view.a(this.ctK);
        this.ctF.je("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.w.album_image_list_view, (ViewGroup) null);
        this.bEL = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.v.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.bUn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ctK);
        this.cuU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.album_iamge_title_layout, (View.OnClickListener) null);
        this.mTitleText = (TextView) this.cuU.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.bAI = (GridView) this.mView.findViewById(com.baidu.tieba.v.gv_image_list);
        this.cuT = this.mView.findViewById(com.baidu.tieba.v.gv_foot);
        this.cuW = new aa(this.ctK, this.ctF);
        this.bAI.setAdapter((ListAdapter) this.cuW);
        this.bAI.setOnScrollListener(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        am amVar = new am(this);
        this.cuU.setOnClickListener(alVar);
        this.cuV.a(amVar);
        this.cuW.a(aiVar);
        this.cuW.a(ajVar);
        this.cuW.a(akVar);
        this.mNoDataView = NoDataViewFactory.a(this.ctK.getPageContext().getPageActivity(), this.bEL, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.album_list_no_data, com.baidu.tieba.y.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bHS = false;
        if (isShow()) {
            apT();
        }
    }

    private void apS() {
        if (this.ctF == null && this.ctK != null) {
            this.ctF = this.ctK.apM();
        }
        if (this.ctF != null && this.ctF.aqb() == null) {
            setData(aqi(), true);
            jg("-1");
        }
    }

    private List<ImageFileInfo> aqi() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void jg(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cuS.a(str, new an(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqj() {
        this.cuS.a(new ao(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.cuW != null) {
            this.ctF.bc(list);
            this.cuW.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.cuT.setVisibility(0);
                } else {
                    this.cuT.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctK.getLayoutMode().X(i == 1);
        this.ctK.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(this.ctK.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aeH() {
        return this.bUn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cuS != null) {
            this.cuS.apV();
        }
        o.aqd().b(this);
    }

    public void u(int i, boolean z) {
        if (this.bAI != null) {
            int firstVisiblePosition = this.bAI.getFirstVisiblePosition();
            int lastVisiblePosition = this.bAI.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bAI.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.v.select_icon);
                    if (z) {
                        ba.i(imageView, com.baidu.tieba.u.btn_choose_photo_s);
                    } else {
                        ba.i(imageView, com.baidu.tieba.u.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.cuW != null) {
            u(this.cuW.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bHS = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.s
    public void fb(boolean z) {
        apT();
    }

    private void apT() {
        if (!isHidden() && !this.bHS) {
            apS();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (am(((i + i2) - 1) + 1, 3) == am(i3, 3)) {
            if (this.cuT.getVisibility() != 0) {
                this.cuT.setVisibility(0);
            }
        } else if (this.cuT.getVisibility() == 0) {
            this.cuT.setVisibility(8);
        }
    }

    private int am(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.cuW.fd(true);
        } else if (this.cuW.isScroll()) {
            this.cuW.fd(false);
            aqk();
        }
    }

    private void aqk() {
        int childCount = this.bAI.getChildCount();
        int firstVisiblePosition = this.bAI.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bAI.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.v.pic);
                ImageFileInfo item = this.cuW.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.ctK.apN().a(item, new ap(this), false, false);
                }
            }
        }
    }
}
