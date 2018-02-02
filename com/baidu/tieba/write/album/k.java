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
    private View cWH;
    private RelativeLayout dmF;
    private boolean fHB;
    private com.baidu.tbadk.album.f hDW;
    private ImageView hDX;
    private TextView hDY;
    private com.baidu.tieba.write.view.a hDZ;
    private e hDa;
    private l hDj;
    private AlbumActivity hDn;
    private View hDt;
    private TextView hDu;
    private TextView hDv;
    private TransparentHeadGridView hEa;
    private j hEb;
    private View hEc;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b bAI = null;
    private View.OnClickListener hDJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hDa != null) {
                int maxImagesAllowed = k.this.hDa.getMaxImagesAllowed();
                if (k.this.hDa.size() < maxImagesAllowed) {
                    if (k.this.hDn != null) {
                        k.this.hDn.c(k.this.getPageContext());
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
            if (k.this.hDa != null) {
                if (k.this.hDj == null || !k.this.hDj.bFT()) {
                    if (view == k.this.mTitleText) {
                        k.this.hDZ.e(k.this.hDa.bFF(), k.this.hDa.bFD());
                        k.this.hDZ.bL(k.this.cWH);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hDt) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hDM = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bFN() {
            return !ab.e(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hDN = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bFO() {
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
    private h hDK = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hDa != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hDa.f((ImageFileInfo) mediaFileInfo);
                    k.this.hDn.xk(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0174a hEd = new a.InterfaceC0174a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0174a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> um;
            if (k.this.hDa != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hDa.bFD()) && (um = k.this.hDa.um(albumId)) != null) {
                    k.this.hDa.uk(albumId);
                    k.this.hEb.setData(um);
                    k.this.mTitleText.setText(name);
                    k.this.hEa.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hDL = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hDn == null || k.this.hDa == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hDa.bFA()) {
                    k.this.hDn.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hDa.isAdded(imageFileInfo)) {
                    k.this.hDn.d(imageFileInfo);
                } else {
                    k.this.hDn.c(imageFileInfo);
                }
                k.this.hDa.a(null);
                k.this.hEb.notifyDataSetChanged();
                k.this.bFJ();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hDa.bFz()) {
                    k.this.hDn.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hDa.b(videoFileInfo)) {
                        k.this.hDa.a(null);
                    } else {
                        k.this.hDa.a(videoFileInfo);
                    }
                    k.this.hDa.bFB();
                    k.this.hEb.notifyDataSetChanged();
                    k.this.bFJ();
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
        this.hDn = (AlbumActivity) getBaseFragmentActivity();
        this.hDa = this.hDn.bFk();
        f.bFG().a(this);
        this.hDW = new com.baidu.tbadk.album.f(this.hDn);
        this.hDZ = new com.baidu.tieba.write.view.a(this.hDn);
        this.hDZ.setOnDismissListener(this.Ij);
        this.hDZ.a(this.hEd);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.dmF = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cWH = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hDX = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hDY = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hEc = this.mView.findViewById(d.g.navi_line);
        this.hDt = this.mView.findViewById(d.g.layout_bottom);
        this.hDv = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hDu = (TextView) this.mView.findViewById(d.g.next_step);
        this.hDa.uk(com.baidu.tbadk.album.a.aFQ);
        this.mTitleText.setText(this.hDn.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hDn.getPageContext().getPageActivity(), this.dmF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aC(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hEa = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hEa.setSelector(d.C0108d.transparent);
        this.hEb = new j(this.hDn, this.hDa);
        this.hEb.nA(this.hDn.bFj() != 1);
        this.hEa.setAdapter((ListAdapter) this.hEb);
        this.hEa.setOuterOnScrollListener(this);
        this.hEb.a(this.hDL);
        this.hEb.a(this.hDK);
        this.hEb.T(this.hDJ);
        this.hEb.setOnOpenCameraFailedListener(this.hDN);
        this.hEb.setOnRequestPermissionListener(this.hDM);
        this.hDu.setOnClickListener(this.hDn);
        this.hDX.setOnClickListener(this.hDn);
        this.hDY.setOnClickListener(this.hDn);
        this.hDv.setOnClickListener(this.hDn);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hDt.setOnClickListener(this.mOnClickListener);
        bFJ();
        Vc();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void Vc() {
        if (this.bAI == null) {
            this.bAI = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bAI.c(null);
        this.bAI.fY(d.j.loading);
        this.bAI.bn(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hDn.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFJ() {
        int D;
        String string;
        if (this.hDa != null && this.hDu != null) {
            if (this.hDa.bFA()) {
                int i = this.hDa.bFA() ? 1 : 0;
                D = i;
                string = this.hDn.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                D = v.D(this.hDa.bFC());
                string = this.hDn.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hDa.getMaxImagesAllowed())});
            }
            this.hDu.setText(string);
            this.hDu.setEnabled(D > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fHB = false;
        if (isShow()) {
            Wy();
        }
    }

    private void bFw() {
        if (this.hDa == null && this.hDn != null) {
            this.hDa = this.hDn.bFk();
        }
        if (this.hDa != null) {
            if (!this.hDa.Ne()) {
                this.hEb.notifyDataSetChanged();
            } else {
                bFK();
            }
            nx(this.hDa.isOriginalImg());
        }
    }

    private void bFK() {
        if (this.hDW == null) {
            this.hDW = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hDW.a(this.hDn.bFj() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.bAI != null) {
                    k.this.bAI.bn(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hDa != null && gVar != null) {
                    k.this.hDa.c(gVar);
                    String bFD = k.this.hDa.bFD();
                    k.this.hDa.uk(bFD);
                    k.this.hEb.setData(k.this.hDa.um(bFD));
                    k.this.hEa.smoothScrollToPosition(0);
                    k.this.bFJ();
                }
                k.this.hEa.bFR();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.g(this.hEc, d.C0108d.cp_bg_line_b, i);
        aj.e(this.mTitleText, d.C0108d.cp_cont_b, i);
        if (this.hDn.bFj() == 1) {
            aj.b(this.hDX, d.f.icon_topbar_close_n, i);
            this.hDY.setVisibility(8);
        } else {
            aj.r(this.hDY, d.C0108d.navi_back_text_color);
            this.hDX.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hEb != null) {
            this.hEb.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hDa != null) {
            nx(this.hDa.isOriginalImg());
        }
    }

    public View bpR() {
        return this.hDn.bFj() == 1 ? this.hDX : this.hDY;
    }

    public View bFL() {
        return this.hDu;
    }

    public TbCameraView bFo() {
        if (this.hEb != null) {
            return this.hEb.bFH();
        }
        return null;
    }

    public TransparentHeadGridView bFM() {
        return this.hEa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hDZ != null) {
            this.hDZ.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hDW != null) {
            this.hDW.vj();
        }
        if (this.hDn != null) {
            this.hDn.closeLoadingDialog();
        }
        if (this.bAI != null) {
            this.bAI.bn(false);
        }
        f.bFG().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fHB = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nz(boolean z) {
        Wy();
    }

    private void Wy() {
        if (!isHidden() && !this.fHB) {
            bFw();
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
            this.hEb.js(true);
        } else if (this.hEb.isScroll()) {
            this.hEb.js(false);
        }
    }

    public void S(int i, boolean z) {
        if (this.hEa != null) {
            int firstVisiblePosition = this.hEa.getFirstVisiblePosition();
            int lastVisiblePosition = this.hEa.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hEa.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hEb != null) {
                    this.hEb.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bFJ();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hEb != null) {
            S(this.hEb.g(imageFileInfo), z);
        }
    }

    public View bFt() {
        return this.hDv;
    }

    public void nx(boolean z) {
        if (this.hDn != null && this.hDv != null) {
            this.hDv.setText(this.hDn.getResources().getString(d.j.original_img));
            if (z) {
                this.hDv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.hDv, d.C0108d.cp_link_tip_a);
                return;
            }
            this.hDv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.hDv, d.C0108d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hDj = lVar;
    }
}
