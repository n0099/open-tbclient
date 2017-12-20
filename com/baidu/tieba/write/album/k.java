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
    private View cdd;
    private RelativeLayout cth;
    private boolean eTa;
    private ImageView gxv;
    private e heY;
    private com.baidu.tbadk.album.f hfU;
    private com.baidu.tieba.write.view.a hfV;
    private TransparentHeadGridView hfW;
    private j hfX;
    private View hfY;
    private l hfg;
    private AlbumActivity hfk;
    private View hfq;
    private TextView hfr;
    private TextView hfs;
    private com.baidu.tbadk.core.view.g mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b aMB = null;
    private View.OnClickListener hfH = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.heY != null) {
                int maxImagesAllowed = k.this.heY.getMaxImagesAllowed();
                if (k.this.heY.size() < maxImagesAllowed) {
                    if (k.this.hfk != null) {
                        k.this.hfk.c(k.this.getPageContext());
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
            if (k.this.heY != null) {
                if (k.this.hfg == null || !k.this.hfg.bGD()) {
                    if (view == k.this.mTitleText) {
                        k.this.hfV.d(k.this.heY.bGu(), k.this.heY.bGs());
                        k.this.hfV.aw(k.this.cdd);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hfq) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hfK = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean buq() {
            return !ab.f(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hfL = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bur() {
        }
    };
    private PopupWindow.OnDismissListener hfZ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.k.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (k.this.mTitleText != null && k.this.isAdded()) {
                Drawable drawable = aj.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                k.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private h hfI = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.heY != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.heY.f((ImageFileInfo) mediaFileInfo);
                    k.this.hfk.vQ(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0162a hga = new a.InterfaceC0162a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0162a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> uG;
            if (k.this.heY != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.heY.bGs()) && (uG = k.this.heY.uG(albumId)) != null) {
                    k.this.heY.uE(albumId);
                    k.this.hfX.setData(uG);
                    k.this.mTitleText.setText(name);
                    k.this.hfW.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hfJ = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hfk == null || k.this.heY == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.heY.bGp()) {
                    k.this.hfk.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.heY.isAdded(imageFileInfo)) {
                    k.this.hfk.d(imageFileInfo);
                } else {
                    k.this.hfk.c(imageFileInfo);
                }
                k.this.heY.a(null);
                k.this.hfX.notifyDataSetChanged();
                k.this.bGy();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.heY.bGo()) {
                    k.this.hfk.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.heY.b(videoFileInfo)) {
                        k.this.heY.a(null);
                    } else {
                        k.this.heY.a(videoFileInfo);
                    }
                    k.this.heY.bGq();
                    k.this.hfX.notifyDataSetChanged();
                    k.this.bGy();
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
        this.hfk = (AlbumActivity) getBaseFragmentActivity();
        this.heY = this.hfk.bFZ();
        f.bGv().a(this);
        this.hfU = new com.baidu.tbadk.album.f(this.hfk);
        this.hfV = new com.baidu.tieba.write.view.a(this.hfk);
        this.hfV.setOnDismissListener(this.hfZ);
        this.hfV.a(this.hga);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.cth = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cdd = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.gxv = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hfY = this.mView.findViewById(d.g.navi_line);
        this.hfq = this.mView.findViewById(d.g.layout_bottom);
        this.hfs = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hfr = (TextView) this.mView.findViewById(d.g.next_step);
        this.heY.uE(com.baidu.tbadk.album.a.Rg);
        this.mTitleText.setText(this.hfk.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hfk.getPageContext().getPageActivity(), this.cth, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hfW = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hfW.setSelector(d.C0096d.transparent);
        this.hfX = new j(this.hfk, this.heY);
        this.hfX.oa(this.hfk.bFY() != 1);
        this.hfW.setAdapter((ListAdapter) this.hfX);
        this.hfW.setOuterOnScrollListener(this);
        this.hfX.a(this.hfJ);
        this.hfX.a(this.hfI);
        this.hfX.W(this.hfH);
        this.hfX.setOnOpenCameraFailedListener(this.hfL);
        this.hfX.setOnRequestPermissionListener(this.hfK);
        this.hfr.setOnClickListener(this.hfk);
        this.gxv.setOnClickListener(this.hfk);
        this.hfs.setOnClickListener(this.hfk);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hfq.setOnClickListener(this.mOnClickListener);
        bGy();
        NN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void NN() {
        if (this.aMB == null) {
            this.aMB = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.aMB.c(null);
        this.aMB.db(d.j.loading);
        this.aMB.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hfk.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGy() {
        int v;
        String string;
        if (this.heY != null && this.hfr != null) {
            if (this.heY.bGp()) {
                int i = this.heY.bGp() ? 1 : 0;
                v = i;
                string = this.hfk.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                v = v.v(this.heY.bGr());
                string = this.hfk.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.heY.getMaxImagesAllowed())});
            }
            this.hfr.setText(string);
            this.hfr.setEnabled(v > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eTa = false;
        if (isShow()) {
            Pj();
        }
    }

    private void bGl() {
        if (this.heY == null && this.hfk != null) {
            this.heY = this.hfk.bFZ();
        }
        if (this.heY != null) {
            if (!this.heY.FP()) {
                this.hfX.notifyDataSetChanged();
            } else {
                bGz();
            }
            nX(this.heY.isOriginalImg());
        }
    }

    private void bGz() {
        if (this.hfU == null) {
            this.hfU = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hfU.a(this.hfk.bFY() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.aMB != null) {
                    k.this.aMB.aE(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.heY != null && gVar != null) {
                    k.this.heY.c(gVar);
                    String bGs = k.this.heY.bGs();
                    k.this.heY.uE(bGs);
                    k.this.hfX.setData(k.this.heY.uG(bGs));
                    k.this.hfW.smoothScrollToPosition(0);
                    k.this.bGy();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.e(this.hfY, d.C0096d.cp_bg_line_b, i);
        aj.c(this.mTitleText, d.C0096d.cp_cont_b, i);
        aj.b(this.gxv, d.f.icon_topbar_close_n, i);
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hfX != null) {
            this.hfX.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.heY != null) {
            nX(this.heY.isOriginalImg());
        }
    }

    public View boM() {
        return this.gxv;
    }

    public View bGA() {
        return this.hfr;
    }

    public TbCameraView bGd() {
        if (this.hfX != null) {
            return this.hfX.bGw();
        }
        return null;
    }

    public TransparentHeadGridView bGB() {
        return this.hfW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hfV != null) {
            this.hfV.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hfU != null) {
            this.hfU.nF();
        }
        if (this.hfk != null) {
            this.hfk.closeLoadingDialog();
        }
        if (this.aMB != null) {
            this.aMB.aE(false);
        }
        f.bGv().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eTa = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nZ(boolean z) {
        Pj();
    }

    private void Pj() {
        if (!isHidden() && !this.eTa) {
            bGl();
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
            this.hfX.iK(true);
        } else if (this.hfX.isScroll()) {
            this.hfX.iK(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hfW != null) {
            int firstVisiblePosition = this.hfW.getFirstVisiblePosition();
            int lastVisiblePosition = this.hfW.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hfW.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hfX != null) {
                    this.hfX.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGy();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hfX != null) {
            H(this.hfX.g(imageFileInfo), z);
        }
    }

    public View bGi() {
        return this.hfs;
    }

    public void nX(boolean z) {
        if (this.hfk != null && this.hfs != null) {
            this.hfs.setText(this.hfk.getResources().getString(d.j.original_img));
            if (z) {
                this.hfs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.hfs, d.C0096d.cp_link_tip_a);
                return;
            }
            this.hfs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.hfs, d.C0096d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hfg = lVar;
    }
}
