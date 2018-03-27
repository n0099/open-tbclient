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
    private View cZl;
    private RelativeLayout dpn;
    private boolean fKR;
    private e hEI;
    private l hER;
    private AlbumActivity hEV;
    private com.baidu.tbadk.album.f hFE;
    private ImageView hFF;
    private TextView hFG;
    private com.baidu.tieba.write.view.a hFH;
    private TransparentHeadGridView hFI;
    private j hFJ;
    private View hFK;
    private View hFb;
    private TextView hFc;
    private TextView hFd;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b bCC = null;
    private View.OnClickListener hFr = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hEI != null) {
                int maxImagesAllowed = k.this.hEI.getMaxImagesAllowed();
                if (k.this.hEI.size() < maxImagesAllowed) {
                    if (k.this.hEV != null) {
                        k.this.hEV.b(k.this.getPageContext());
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
            if (k.this.hEI != null) {
                if (k.this.hER == null || !k.this.hER.bGL()) {
                    if (view == k.this.mTitleText) {
                        k.this.hFH.e(k.this.hEI.bGx(), k.this.hEI.bGv());
                        k.this.hFH.bK(k.this.cZl);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hFb) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hFu = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bGF() {
            return !ab.e(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hFv = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bGG() {
        }
    };
    private PopupWindow.OnDismissListener Id = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.k.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (k.this.mTitleText != null && k.this.isAdded()) {
                Drawable drawable = aj.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                k.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private h hFs = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hEI != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hEI.f((ImageFileInfo) mediaFileInfo);
                    k.this.hEV.xk(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0257a hFL = new a.InterfaceC0257a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0257a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> us;
            if (k.this.hEI != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hEI.bGv()) && (us = k.this.hEI.us(albumId)) != null) {
                    k.this.hEI.uq(albumId);
                    k.this.hFJ.setData(us);
                    k.this.mTitleText.setText(name);
                    k.this.hFI.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hFt = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hEV == null || k.this.hEI == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hEI.bGs()) {
                    k.this.hEV.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hEI.isAdded(imageFileInfo)) {
                    k.this.hEV.d(imageFileInfo);
                } else {
                    k.this.hEV.c(imageFileInfo);
                }
                k.this.hEI.a(null);
                k.this.hFJ.notifyDataSetChanged();
                k.this.bGB();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hEI.bGr()) {
                    k.this.hEV.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hEI.b(videoFileInfo)) {
                        k.this.hEI.a(null);
                    } else {
                        k.this.hEI.a(videoFileInfo);
                    }
                    k.this.hEI.bGt();
                    k.this.hFJ.notifyDataSetChanged();
                    k.this.bGB();
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
        this.hEV = (AlbumActivity) getBaseFragmentActivity();
        this.hEI = this.hEV.bGc();
        f.bGy().a(this);
        this.hFE = new com.baidu.tbadk.album.f(this.hEV);
        this.hFH = new com.baidu.tieba.write.view.a(this.hEV);
        this.hFH.setOnDismissListener(this.Id);
        this.hFH.a(this.hFL);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.dpn = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cZl = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hFF = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hFG = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hFK = this.mView.findViewById(d.g.navi_line);
        this.hFb = this.mView.findViewById(d.g.layout_bottom);
        this.hFd = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hFc = (TextView) this.mView.findViewById(d.g.next_step);
        this.hEI.uq(com.baidu.tbadk.album.a.aGZ);
        this.mTitleText.setText(this.hEV.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hEV.getPageContext().getPageActivity(), this.dpn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aC(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hFI = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hFI.setSelector(d.C0141d.transparent);
        this.hFJ = new j(this.hEV, this.hEI);
        this.hFJ.nM(this.hEV.bGb() != 1);
        this.hFI.setAdapter((ListAdapter) this.hFJ);
        this.hFI.setOuterOnScrollListener(this);
        this.hFJ.a(this.hFt);
        this.hFJ.a(this.hFs);
        this.hFJ.T(this.hFr);
        this.hFJ.setOnOpenCameraFailedListener(this.hFv);
        this.hFJ.setOnRequestPermissionListener(this.hFu);
        this.hFc.setOnClickListener(this.hEV);
        this.hFF.setOnClickListener(this.hEV);
        this.hFG.setOnClickListener(this.hEV);
        this.hFd.setOnClickListener(this.hEV);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hFb.setOnClickListener(this.mOnClickListener);
        bGB();
        VU();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void VU() {
        if (this.bCC == null) {
            this.bCC = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bCC.d(null);
        this.bCC.ga(d.j.loading);
        this.bCC.bq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hEV.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGB() {
        int D;
        String string;
        if (this.hEI != null && this.hFc != null) {
            if (this.hEI.bGs()) {
                int i = this.hEI.bGs() ? 1 : 0;
                D = i;
                string = this.hEV.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                D = v.D(this.hEI.bGu());
                string = this.hEV.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hEI.getMaxImagesAllowed())});
            }
            this.hFc.setText(string);
            this.hFc.setEnabled(D > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fKR = false;
        if (isShow()) {
            Xp();
        }
    }

    private void bGo() {
        if (this.hEI == null && this.hEV != null) {
            this.hEI = this.hEV.bGc();
        }
        if (this.hEI != null) {
            if (!this.hEI.NK()) {
                this.hFJ.notifyDataSetChanged();
            } else {
                bGC();
            }
            nJ(this.hEI.isOriginalImg());
        }
    }

    private void bGC() {
        if (this.hFE == null) {
            this.hFE = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hFE.a(this.hEV.bGb() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.bCC != null) {
                    k.this.bCC.bq(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hEI != null && gVar != null) {
                    k.this.hEI.c(gVar);
                    String bGv = k.this.hEI.bGv();
                    k.this.hEI.uq(bGv);
                    k.this.hFJ.setData(k.this.hEI.us(bGv));
                    k.this.hFI.smoothScrollToPosition(0);
                    k.this.bGB();
                }
                k.this.hFI.bGJ();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.g(this.hFK, d.C0141d.cp_bg_line_b, i);
        aj.e(this.mTitleText, d.C0141d.cp_cont_b, i);
        if (this.hEV.bGb() == 1) {
            aj.b(this.hFF, d.f.icon_topbar_close_n, i);
            this.hFG.setVisibility(8);
        } else {
            aj.r(this.hFG, d.C0141d.navi_back_text_color);
            this.hFF.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hFJ != null) {
            this.hFJ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hEI != null) {
            nJ(this.hEI.isOriginalImg());
        }
    }

    public View brm() {
        return this.hEV.bGb() == 1 ? this.hFF : this.hFG;
    }

    public View bGD() {
        return this.hFc;
    }

    public TbCameraView bGg() {
        if (this.hFJ != null) {
            return this.hFJ.bGz();
        }
        return null;
    }

    public TransparentHeadGridView bGE() {
        return this.hFI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hFH != null) {
            this.hFH.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hFE != null) {
            this.hFE.vV();
        }
        if (this.hEV != null) {
            this.hEV.closeLoadingDialog();
        }
        if (this.bCC != null) {
            this.bCC.bq(false);
        }
        f.bGy().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fKR = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nL(boolean z) {
        Xp();
    }

    private void Xp() {
        if (!isHidden() && !this.fKR) {
            bGo();
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
            this.hFJ.jG(true);
        } else if (this.hFJ.isScroll()) {
            this.hFJ.jG(false);
        }
    }

    public void Y(int i, boolean z) {
        if (this.hFI != null) {
            int firstVisiblePosition = this.hFI.getFirstVisiblePosition();
            int lastVisiblePosition = this.hFI.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hFI.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hFJ != null) {
                    this.hFJ.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGB();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hFJ != null) {
            Y(this.hFJ.g(imageFileInfo), z);
        }
    }

    public View bGl() {
        return this.hFd;
    }

    public void nJ(boolean z) {
        if (this.hEV != null && this.hFd != null) {
            this.hFd.setText(this.hEV.getResources().getString(d.j.original_img));
            if (z) {
                this.hFd.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.hFd, d.C0141d.cp_link_tip_a);
                return;
            }
            this.hFd.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.hFd, d.C0141d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hER = lVar;
    }
}
