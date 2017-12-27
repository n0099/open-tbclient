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
    private View cRK;
    private RelativeLayout dhJ;
    private boolean fFG;
    private e hMZ;
    private com.baidu.tbadk.album.f hNU;
    private ImageView hNV;
    private TextView hNW;
    private com.baidu.tieba.write.view.a hNX;
    private TransparentHeadGridView hNY;
    private j hNZ;
    private l hNh;
    private AlbumActivity hNl;
    private View hNr;
    private TextView hNs;
    private TextView hNt;
    private View hOa;
    private com.baidu.tbadk.core.view.g mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b bAr = null;
    private View.OnClickListener hNH = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hMZ != null) {
                int maxImagesAllowed = k.this.hMZ.getMaxImagesAllowed();
                if (k.this.hMZ.size() < maxImagesAllowed) {
                    if (k.this.hNl != null) {
                        k.this.hNl.c(k.this.getPageContext());
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
            if (k.this.hMZ != null) {
                if (k.this.hNh == null || !k.this.hNh.bMr()) {
                    if (view == k.this.mTitleText) {
                        k.this.hNX.e(k.this.hMZ.bMd(), k.this.hMZ.bMb());
                        k.this.hNX.bJ(k.this.cRK);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hNr) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hNK = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bMl() {
            return !ab.f(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hNL = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bMm() {
        }
    };
    private PopupWindow.OnDismissListener Ij = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.k.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (k.this.mTitleText != null && k.this.isAdded()) {
                Drawable drawable = aj.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                k.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private h hNI = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hMZ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hMZ.f((ImageFileInfo) mediaFileInfo);
                    k.this.hNl.yH(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0174a hOb = new a.InterfaceC0174a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0174a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> uJ;
            if (k.this.hMZ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hMZ.bMb()) && (uJ = k.this.hMZ.uJ(albumId)) != null) {
                    k.this.hMZ.uH(albumId);
                    k.this.hNZ.setData(uJ);
                    k.this.mTitleText.setText(name);
                    k.this.hNY.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hNJ = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hNl == null || k.this.hMZ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hMZ.bLY()) {
                    k.this.hNl.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hMZ.isAdded(imageFileInfo)) {
                    k.this.hNl.d(imageFileInfo);
                } else {
                    k.this.hNl.c(imageFileInfo);
                }
                k.this.hMZ.a(null);
                k.this.hNZ.notifyDataSetChanged();
                k.this.bMh();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hMZ.bLX()) {
                    k.this.hNl.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hMZ.b(videoFileInfo)) {
                        k.this.hMZ.a(null);
                    } else {
                        k.this.hMZ.a(videoFileInfo);
                    }
                    k.this.hMZ.bLZ();
                    k.this.hNZ.notifyDataSetChanged();
                    k.this.bMh();
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
        this.hNl = (AlbumActivity) getBaseFragmentActivity();
        this.hMZ = this.hNl.bLI();
        f.bMe().a(this);
        this.hNU = new com.baidu.tbadk.album.f(this.hNl);
        this.hNX = new com.baidu.tieba.write.view.a(this.hNl);
        this.hNX.setOnDismissListener(this.Ij);
        this.hNX.a(this.hOb);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.dhJ = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cRK = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hNV = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hNW = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hOa = this.mView.findViewById(d.g.navi_line);
        this.hNr = this.mView.findViewById(d.g.layout_bottom);
        this.hNt = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hNs = (TextView) this.mView.findViewById(d.g.next_step);
        this.hMZ.uH(com.baidu.tbadk.album.a.aFO);
        this.mTitleText.setText(this.hNl.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hNl.getPageContext().getPageActivity(), this.dhJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aC(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hNY = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hNY.setSelector(d.C0108d.transparent);
        this.hNZ = new j(this.hNl, this.hMZ);
        this.hNZ.ou(this.hNl.bLH() != 1);
        this.hNY.setAdapter((ListAdapter) this.hNZ);
        this.hNY.setOuterOnScrollListener(this);
        this.hNZ.a(this.hNJ);
        this.hNZ.a(this.hNI);
        this.hNZ.V(this.hNH);
        this.hNZ.setOnOpenCameraFailedListener(this.hNL);
        this.hNZ.setOnRequestPermissionListener(this.hNK);
        this.hNs.setOnClickListener(this.hNl);
        this.hNV.setOnClickListener(this.hNl);
        this.hNW.setOnClickListener(this.hNl);
        this.hNt.setOnClickListener(this.hNl);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hNr.setOnClickListener(this.mOnClickListener);
        bMh();
        Vm();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void Vm() {
        if (this.bAr == null) {
            this.bAr = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bAr.c(null);
        this.bAr.ga(d.j.loading);
        this.bAr.bm(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hNl.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMh() {
        int F;
        String string;
        if (this.hMZ != null && this.hNs != null) {
            if (this.hMZ.bLY()) {
                int i = this.hMZ.bLY() ? 1 : 0;
                F = i;
                string = this.hNl.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                F = v.F(this.hMZ.bMa());
                string = this.hNl.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(F), Integer.valueOf(this.hMZ.getMaxImagesAllowed())});
            }
            this.hNs.setText(string);
            this.hNs.setEnabled(F > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fFG = false;
        if (isShow()) {
            WI();
        }
    }

    private void bLU() {
        if (this.hMZ == null && this.hNl != null) {
            this.hMZ = this.hNl.bLI();
        }
        if (this.hMZ != null) {
            if (!this.hMZ.No()) {
                this.hNZ.notifyDataSetChanged();
            } else {
                bMi();
            }
            or(this.hMZ.isOriginalImg());
        }
    }

    private void bMi() {
        if (this.hNU == null) {
            this.hNU = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hNU.a(this.hNl.bLH() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.bAr != null) {
                    k.this.bAr.bm(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hMZ != null && gVar != null) {
                    k.this.hMZ.c(gVar);
                    String bMb = k.this.hMZ.bMb();
                    k.this.hMZ.uH(bMb);
                    k.this.hNZ.setData(k.this.hMZ.uJ(bMb));
                    k.this.hNY.smoothScrollToPosition(0);
                    k.this.bMh();
                }
                k.this.hNY.bMp();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.g(this.hOa, d.C0108d.cp_bg_line_b, i);
        aj.e(this.mTitleText, d.C0108d.cp_cont_b, i);
        if (this.hNl.bLH() == 1) {
            aj.b(this.hNV, d.f.icon_topbar_close_n, i);
            this.hNW.setVisibility(8);
        } else {
            aj.r(this.hNW, d.C0108d.navi_back_text_color);
            this.hNV.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hNZ != null) {
            this.hNZ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hMZ != null) {
            or(this.hMZ.isOriginalImg());
        }
    }

    public View bwv() {
        return this.hNl.bLH() == 1 ? this.hNV : this.hNW;
    }

    public View bMj() {
        return this.hNs;
    }

    public TbCameraView bLM() {
        if (this.hNZ != null) {
            return this.hNZ.bMf();
        }
        return null;
    }

    public TransparentHeadGridView bMk() {
        return this.hNY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hNX != null) {
            this.hNX.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hNU != null) {
            this.hNU.vi();
        }
        if (this.hNl != null) {
            this.hNl.closeLoadingDialog();
        }
        if (this.bAr != null) {
            this.bAr.bm(false);
        }
        f.bMe().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fFG = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void ot(boolean z) {
        WI();
    }

    private void WI() {
        if (!isHidden() && !this.fFG) {
            bLU();
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
            this.hNZ.jm(true);
        } else if (this.hNZ.isScroll()) {
            this.hNZ.jm(false);
        }
    }

    public void S(int i, boolean z) {
        if (this.hNY != null) {
            int firstVisiblePosition = this.hNY.getFirstVisiblePosition();
            int lastVisiblePosition = this.hNY.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hNY.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hNZ != null) {
                    this.hNZ.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bMh();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hNZ != null) {
            S(this.hNZ.g(imageFileInfo), z);
        }
    }

    public View bLR() {
        return this.hNt;
    }

    public void or(boolean z) {
        if (this.hNl != null && this.hNt != null) {
            this.hNt.setText(this.hNl.getResources().getString(d.j.original_img));
            if (z) {
                this.hNt.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.hNt, d.C0108d.cp_link_tip_a);
                return;
            }
            this.hNt.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.hNt, d.C0108d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hNh = lVar;
    }
}
