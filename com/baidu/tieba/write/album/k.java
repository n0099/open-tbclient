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
    private View cWm;
    private RelativeLayout dmk;
    private boolean fHg;
    private e hCG;
    private l hCP;
    private AlbumActivity hCT;
    private View hCZ;
    private com.baidu.tbadk.album.f hDC;
    private ImageView hDD;
    private TextView hDE;
    private com.baidu.tieba.write.view.a hDF;
    private TransparentHeadGridView hDG;
    private j hDH;
    private View hDI;
    private TextView hDa;
    private TextView hDb;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b bAA = null;
    private View.OnClickListener hDp = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hCG != null) {
                int maxImagesAllowed = k.this.hCG.getMaxImagesAllowed();
                if (k.this.hCG.size() < maxImagesAllowed) {
                    if (k.this.hCT != null) {
                        k.this.hCT.c(k.this.getPageContext());
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
            if (k.this.hCG != null) {
                if (k.this.hCP == null || !k.this.hCP.bFR()) {
                    if (view == k.this.mTitleText) {
                        k.this.hDF.e(k.this.hCG.bFD(), k.this.hCG.bFB());
                        k.this.hDF.bL(k.this.cWm);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hCZ) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hDs = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bFL() {
            return !ab.f(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hDt = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bFM() {
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
    private h hDq = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hCG != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hCG.f((ImageFileInfo) mediaFileInfo);
                    k.this.hCT.xk(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0173a hDJ = new a.InterfaceC0173a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0173a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ue;
            if (k.this.hCG != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hCG.bFB()) && (ue = k.this.hCG.ue(albumId)) != null) {
                    k.this.hCG.uc(albumId);
                    k.this.hDH.setData(ue);
                    k.this.mTitleText.setText(name);
                    k.this.hDG.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hDr = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hCT == null || k.this.hCG == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hCG.bFy()) {
                    k.this.hCT.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hCG.isAdded(imageFileInfo)) {
                    k.this.hCT.d(imageFileInfo);
                } else {
                    k.this.hCT.c(imageFileInfo);
                }
                k.this.hCG.a(null);
                k.this.hDH.notifyDataSetChanged();
                k.this.bFH();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hCG.bFx()) {
                    k.this.hCT.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hCG.b(videoFileInfo)) {
                        k.this.hCG.a(null);
                    } else {
                        k.this.hCG.a(videoFileInfo);
                    }
                    k.this.hCG.bFz();
                    k.this.hDH.notifyDataSetChanged();
                    k.this.bFH();
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
        this.hCT = (AlbumActivity) getBaseFragmentActivity();
        this.hCG = this.hCT.bFi();
        f.bFE().a(this);
        this.hDC = new com.baidu.tbadk.album.f(this.hCT);
        this.hDF = new com.baidu.tieba.write.view.a(this.hCT);
        this.hDF.setOnDismissListener(this.Ij);
        this.hDF.a(this.hDJ);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.dmk = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cWm = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hDD = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hDE = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hDI = this.mView.findViewById(d.g.navi_line);
        this.hCZ = this.mView.findViewById(d.g.layout_bottom);
        this.hDb = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hDa = (TextView) this.mView.findViewById(d.g.next_step);
        this.hCG.uc(com.baidu.tbadk.album.a.aFN);
        this.mTitleText.setText(this.hCT.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hCT.getPageContext().getPageActivity(), this.dmk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aC(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hDG = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hDG.setSelector(d.C0107d.transparent);
        this.hDH = new j(this.hCT, this.hCG);
        this.hDH.nx(this.hCT.bFh() != 1);
        this.hDG.setAdapter((ListAdapter) this.hDH);
        this.hDG.setOuterOnScrollListener(this);
        this.hDH.a(this.hDr);
        this.hDH.a(this.hDq);
        this.hDH.T(this.hDp);
        this.hDH.setOnOpenCameraFailedListener(this.hDt);
        this.hDH.setOnRequestPermissionListener(this.hDs);
        this.hDa.setOnClickListener(this.hCT);
        this.hDD.setOnClickListener(this.hCT);
        this.hDE.setOnClickListener(this.hCT);
        this.hDb.setOnClickListener(this.hCT);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hCZ.setOnClickListener(this.mOnClickListener);
        bFH();
        Va();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void Va() {
        if (this.bAA == null) {
            this.bAA = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bAA.c(null);
        this.bAA.fY(d.j.loading);
        this.bAA.bm(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hCT.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFH() {
        int D;
        String string;
        if (this.hCG != null && this.hDa != null) {
            if (this.hCG.bFy()) {
                int i = this.hCG.bFy() ? 1 : 0;
                D = i;
                string = this.hCT.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                D = v.D(this.hCG.bFA());
                string = this.hCT.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hCG.getMaxImagesAllowed())});
            }
            this.hDa.setText(string);
            this.hDa.setEnabled(D > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fHg = false;
        if (isShow()) {
            Ww();
        }
    }

    private void bFu() {
        if (this.hCG == null && this.hCT != null) {
            this.hCG = this.hCT.bFi();
        }
        if (this.hCG != null) {
            if (!this.hCG.Nc()) {
                this.hDH.notifyDataSetChanged();
            } else {
                bFI();
            }
            nu(this.hCG.isOriginalImg());
        }
    }

    private void bFI() {
        if (this.hDC == null) {
            this.hDC = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hDC.a(this.hCT.bFh() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.bAA != null) {
                    k.this.bAA.bm(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hCG != null && gVar != null) {
                    k.this.hCG.c(gVar);
                    String bFB = k.this.hCG.bFB();
                    k.this.hCG.uc(bFB);
                    k.this.hDH.setData(k.this.hCG.ue(bFB));
                    k.this.hDG.smoothScrollToPosition(0);
                    k.this.bFH();
                }
                k.this.hDG.bFP();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.g(this.hDI, d.C0107d.cp_bg_line_b, i);
        aj.e(this.mTitleText, d.C0107d.cp_cont_b, i);
        if (this.hCT.bFh() == 1) {
            aj.b(this.hDD, d.f.icon_topbar_close_n, i);
            this.hDE.setVisibility(8);
        } else {
            aj.r(this.hDE, d.C0107d.navi_back_text_color);
            this.hDD.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hDH != null) {
            this.hDH.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hCG != null) {
            nu(this.hCG.isOriginalImg());
        }
    }

    public View bpP() {
        return this.hCT.bFh() == 1 ? this.hDD : this.hDE;
    }

    public View bFJ() {
        return this.hDa;
    }

    public TbCameraView bFm() {
        if (this.hDH != null) {
            return this.hDH.bFF();
        }
        return null;
    }

    public TransparentHeadGridView bFK() {
        return this.hDG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hDF != null) {
            this.hDF.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hDC != null) {
            this.hDC.vi();
        }
        if (this.hCT != null) {
            this.hCT.closeLoadingDialog();
        }
        if (this.bAA != null) {
            this.bAA.bm(false);
        }
        f.bFE().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fHg = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nw(boolean z) {
        Ww();
    }

    private void Ww() {
        if (!isHidden() && !this.fHg) {
            bFu();
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
            this.hDH.jp(true);
        } else if (this.hDH.isScroll()) {
            this.hDH.jp(false);
        }
    }

    public void S(int i, boolean z) {
        if (this.hDG != null) {
            int firstVisiblePosition = this.hDG.getFirstVisiblePosition();
            int lastVisiblePosition = this.hDG.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hDG.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hDH != null) {
                    this.hDH.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bFH();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hDH != null) {
            S(this.hDH.g(imageFileInfo), z);
        }
    }

    public View bFr() {
        return this.hDb;
    }

    public void nu(boolean z) {
        if (this.hCT != null && this.hDb != null) {
            this.hDb.setText(this.hCT.getResources().getString(d.j.original_img));
            if (z) {
                this.hDb.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.hDb, d.C0107d.cp_link_tip_a);
                return;
            }
            this.hDb.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.hDb, d.C0107d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hCP = lVar;
    }
}
