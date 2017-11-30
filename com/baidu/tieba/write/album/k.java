package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.f;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener, f.a {
    private ImageView bCA;
    private View ccP;
    private RelativeLayout csY;
    private boolean eRX;
    private View hcA;
    private TextView hcB;
    private TextView hcC;
    private e hci;
    private l hcq;
    private AlbumActivity hcu;
    private com.baidu.tbadk.album.f hde;
    private com.baidu.tieba.write.view.a hdf;
    private TransparentHeadGridView hdg;
    private j hdh;
    private View hdi;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.a aMx = null;
    private View.OnClickListener hcR = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hci != null) {
                int maxImagesAllowed = k.this.hci.getMaxImagesAllowed();
                if (k.this.hci.size() < maxImagesAllowed) {
                    if (k.this.hcu != null) {
                        k.this.hcu.c(k.this.getPageContext());
                        return;
                    }
                    return;
                }
                k.this.showToast(String.format(k.this.getPageContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hci != null) {
                if (k.this.hcq == null || !k.this.hcq.bFS()) {
                    if (view == k.this.mTitleText) {
                        k.this.hdf.d(k.this.hci.bFJ(), k.this.hci.bFH());
                        k.this.hdf.au(k.this.ccP);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hcA) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hcU = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean btL() {
            return !ab.e(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hcV = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void btM() {
        }
    };
    private PopupWindow.OnDismissListener hdj = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.k.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (k.this.mTitleText != null && k.this.isAdded()) {
                Drawable drawable = aj.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                k.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private h hcS = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hci != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hci.f((ImageFileInfo) mediaFileInfo);
                    k.this.hcu.vE(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0145a hdk = new a.InterfaceC0145a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0145a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> uB;
            if (k.this.hci != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hci.bFH()) && (uB = k.this.hci.uB(albumId)) != null) {
                    k.this.hci.uz(albumId);
                    k.this.hdh.setData(uB);
                    k.this.mTitleText.setText(name);
                    k.this.hdg.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hcT = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hcu == null || k.this.hci == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hci.bFE()) {
                    k.this.hcu.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hci.isAdded(imageFileInfo)) {
                    k.this.hcu.d(imageFileInfo);
                } else {
                    k.this.hcu.c(imageFileInfo);
                }
                k.this.hci.a(null);
                k.this.hdh.notifyDataSetChanged();
                k.this.bFN();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hci.bFD()) {
                    k.this.hcu.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hci.b(videoFileInfo)) {
                        k.this.hci.a(null);
                    } else {
                        k.this.hci.a(videoFileInfo);
                    }
                    k.this.hci.bFF();
                    k.this.hdh.notifyDataSetChanged();
                    k.this.bFN();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hcu = (AlbumActivity) getBaseFragmentActivity();
        this.hci = this.hcu.bFo();
        f.bFK().a(this);
        this.hde = new com.baidu.tbadk.album.f(this.hcu);
        this.hdf = new com.baidu.tieba.write.view.a(this.hcu);
        this.hdf.setOnDismissListener(this.hdj);
        this.hdf.a(this.hdk);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.csY = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.ccP = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.bCA = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hdi = this.mView.findViewById(d.g.navi_line);
        this.hcA = this.mView.findViewById(d.g.layout_bottom);
        this.hcC = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hcB = (TextView) this.mView.findViewById(d.g.next_step);
        this.hci.uz(com.baidu.tbadk.album.a.Ri);
        this.mTitleText.setText(this.hcu.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hcu.getPageContext().getPageActivity(), this.csY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hdg = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hdg.setSelector(d.C0082d.transparent);
        this.hdh = new j(this.hcu, this.hci);
        this.hdh.nZ(this.hcu.bFn() != 1);
        this.hdg.setAdapter((ListAdapter) this.hdh);
        this.hdg.setOuterOnScrollListener(this);
        this.hdh.a(this.hcT);
        this.hdh.a(this.hcS);
        this.hdh.W(this.hcR);
        this.hdh.setOnOpenCameraFailedListener(this.hcV);
        this.hdh.setOnRequestPermissionListener(this.hcU);
        this.hcB.setOnClickListener(this.hcu);
        this.bCA.setOnClickListener(this.hcu);
        this.hcC.setOnClickListener(this.hcu);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hcA.setOnClickListener(this.mOnClickListener);
        bFN();
        NN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void NN() {
        if (this.aMx == null) {
            this.aMx = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.aMx.c(null);
        this.aMx.db(d.j.loading);
        this.aMx.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hcu.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFN() {
        int v;
        String string;
        if (this.hci != null && this.hcB != null) {
            if (this.hci.bFE()) {
                int i = this.hci.bFE() ? 1 : 0;
                v = i;
                string = this.hcu.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                v = v.v(this.hci.bFG());
                string = this.hcu.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hci.getMaxImagesAllowed())});
            }
            this.hcB.setText(string);
            this.hcB.setEnabled(v > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eRX = false;
        if (isShow()) {
            Pj();
        }
    }

    private void bFA() {
        if (this.hci == null && this.hcu != null) {
            this.hci = this.hcu.bFo();
        }
        if (this.hci != null) {
            if (!this.hci.FO()) {
                this.hdh.notifyDataSetChanged();
            } else {
                bFO();
            }
            nW(this.hci.isOriginalImg());
        }
    }

    private void bFO() {
        if (this.hde == null) {
            this.hde = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hde.a(this.hcu.bFn() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.aMx != null) {
                    k.this.aMx.aE(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hci != null && gVar != null) {
                    k.this.hci.c(gVar);
                    String bFH = k.this.hci.bFH();
                    k.this.hci.uz(bFH);
                    k.this.hdh.setData(k.this.hci.uB(bFH));
                    k.this.hdg.smoothScrollToPosition(0);
                    k.this.bFN();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.e(this.hdi, d.C0082d.cp_bg_line_b, i);
        aj.c(this.mTitleText, d.C0082d.cp_cont_b, i);
        aj.b(this.bCA, d.f.icon_topbar_close_n, i);
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hdh != null) {
            this.hdh.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hci != null) {
            nW(this.hci.isOriginalImg());
        }
    }

    public View boh() {
        return this.bCA;
    }

    public View bFP() {
        return this.hcB;
    }

    public TbCameraView bFs() {
        if (this.hdh != null) {
            return this.hdh.bFL();
        }
        return null;
    }

    public TransparentHeadGridView bFQ() {
        return this.hdg;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hdf != null) {
            this.hdf.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hde != null) {
            this.hde.nH();
        }
        if (this.hcu != null) {
            this.hcu.closeLoadingDialog();
        }
        if (this.aMx != null) {
            this.aMx.aE(false);
        }
        f.bFK().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eRX = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nY(boolean z) {
        Pj();
    }

    private void Pj() {
        if (!isHidden() && !this.eRX) {
            bFA();
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
            this.hdh.iJ(true);
        } else if (this.hdh.isScroll()) {
            this.hdh.iJ(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hdg != null) {
            int firstVisiblePosition = this.hdg.getFirstVisiblePosition();
            int lastVisiblePosition = this.hdg.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hdg.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hdh != null) {
                    this.hdh.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bFN();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hdh != null) {
            H(this.hdh.g(imageFileInfo), z);
        }
    }

    public View bFx() {
        return this.hcC;
    }

    public void nW(boolean z) {
        if (this.hcu != null && this.hcC != null) {
            this.hcC.setText(this.hcu.getResources().getString(d.j.original_img));
            if (z) {
                this.hcC.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.hcC, d.C0082d.cp_link_tip_a);
                return;
            }
            this.hcC.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.hcC, d.C0082d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hcq = lVar;
    }
}
