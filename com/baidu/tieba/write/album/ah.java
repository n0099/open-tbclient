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
    private GridView bAv;
    private RelativeLayout bEy;
    private boolean bHF;
    private View bTX;
    private n ctp;
    private AlbumActivity ctu;
    private e cuC;
    private View cuD;
    private View cuE;
    private com.baidu.tieba.write.view.a cuF;
    private aa cuG;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private TextView mTitleText;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctu = (AlbumActivity) getBaseFragmentActivity();
        this.ctp = this.ctu.apx();
        o.apO().a(this);
        this.cuC = new e(this.ctu.getPageContext().getPageActivity());
        this.cuF = new com.baidu.tieba.write.view.a(this.ctu);
        this.ctp.jb("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.w.album_image_list_view, (ViewGroup) null);
        this.bEy = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.v.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.bTX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ctu);
        this.cuE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.album_iamge_title_layout, (View.OnClickListener) null);
        this.mTitleText = (TextView) this.cuE.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.bAv = (GridView) this.mView.findViewById(com.baidu.tieba.v.gv_image_list);
        this.cuD = this.mView.findViewById(com.baidu.tieba.v.gv_foot);
        this.cuG = new aa(this.ctu, this.ctp);
        this.bAv.setAdapter((ListAdapter) this.cuG);
        this.bAv.setOnScrollListener(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        am amVar = new am(this);
        this.cuE.setOnClickListener(alVar);
        this.cuF.a(amVar);
        this.cuG.a(aiVar);
        this.cuG.a(ajVar);
        this.cuG.a(akVar);
        this.mNoDataView = NoDataViewFactory.a(this.ctu.getPageContext().getPageActivity(), this.bEy, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.album_list_no_data, com.baidu.tieba.y.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bHF = false;
        if (isShow()) {
            apE();
        }
    }

    private void apD() {
        if (this.ctp == null && this.ctu != null) {
            this.ctp = this.ctu.apx();
        }
        if (this.ctp != null && this.ctp.apM() == null) {
            setData(apT(), true);
            jd("-1");
        }
    }

    private List<ImageFileInfo> apT() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void jd(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cuC.a(str, new an(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apU() {
        this.cuC.a(new ao(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.cuG != null) {
            this.ctp.aY(list);
            this.cuG.setData(list, z);
            if (list != null) {
                if (list.size() <= 15) {
                    this.cuD.setVisibility(0);
                } else {
                    this.cuD.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctu.getLayoutMode().X(i == 1);
        this.ctu.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(this.ctu.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View aes() {
        return this.bTX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cuC != null) {
            this.cuC.apG();
        }
        o.apO().b(this);
    }

    public void u(int i, boolean z) {
        if (this.bAv != null) {
            int firstVisiblePosition = this.bAv.getFirstVisiblePosition();
            int lastVisiblePosition = this.bAv.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bAv.getChildAt(i - firstVisiblePosition);
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
        if (imageFileInfo != null && this.cuG != null) {
            u(this.cuG.h(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bHF = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.s
    public void fd(boolean z) {
        apE();
    }

    private void apE() {
        if (!isHidden() && !this.bHF) {
            apD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (am(((i + i2) - 1) + 1, 3) == am(i3, 3)) {
            if (this.cuD.getVisibility() != 0) {
                this.cuD.setVisibility(0);
            }
        } else if (this.cuD.getVisibility() == 0) {
            this.cuD.setVisibility(8);
        }
    }

    private int am(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.cuG.ff(true);
        } else if (this.cuG.isScroll()) {
            this.cuG.ff(false);
            apV();
        }
    }

    private void apV() {
        int childCount = this.bAv.getChildCount();
        int firstVisiblePosition = this.bAv.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bAv.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.v.pic);
                ImageFileInfo item = this.cuG.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.ctu.apy().a(item, new ap(this), false, false);
                }
            }
        }
    }
}
