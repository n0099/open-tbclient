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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View cBr;
    private RelativeLayout cSA;
    private TextView cYc;
    private ImageView fcb;
    private boolean fvb;
    private c htA;
    private i htJ;
    private AlbumActivity htN;
    private View htT;
    private TextView htU;
    private TextView htV;
    private h huA;
    private View huB;
    private com.baidu.tbadk.album.f huw;
    private TextView hux;
    private com.baidu.tieba.write.view.a huy;
    private TransparentHeadGridView huz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a aVY = null;
    private View.OnClickListener huj = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.htA != null) {
                int maxImagesAllowed = ImageListFragment.this.htA.getMaxImagesAllowed();
                if (ImageListFragment.this.htA.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.htN != null) {
                        ImageListFragment.this.htN.b(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.htA != null) {
                if (ImageListFragment.this.htJ == null || !ImageListFragment.this.htJ.bGo()) {
                    if (view == ImageListFragment.this.cYc) {
                        ImageListFragment.this.huy.f(ImageListFragment.this.htA.bGa(), ImageListFragment.this.htA.bFY());
                        ImageListFragment.this.huy.au(ImageListFragment.this.cBr);
                        ImageListFragment.this.cYc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.htT) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hum = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bGi() {
            return !ac.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hun = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bGj() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.cYc != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = am.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.cYc.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f huk = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.htA != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.htA.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.htN.vn(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0259a huC = new a.InterfaceC0259a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0259a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> vC;
            if (ImageListFragment.this.htA != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.htA.bFY()) && (vC = ImageListFragment.this.htA.vC(albumId)) != null) {
                    ImageListFragment.this.htA.vA(albumId);
                    ImageListFragment.this.huA.setData(vC);
                    ImageListFragment.this.cYc.setText(name);
                    ImageListFragment.this.huz.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hul = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.htN == null || ImageListFragment.this.htA == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.htA.bFV()) {
                    ImageListFragment.this.htN.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.htA.isAdded(imageFileInfo)) {
                    ImageListFragment.this.htN.d(imageFileInfo);
                } else {
                    ImageListFragment.this.htN.c(imageFileInfo);
                }
                ImageListFragment.this.htA.a(null);
                ImageListFragment.this.huA.notifyDataSetChanged();
                ImageListFragment.this.bGe();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.htA.bFU()) {
                    ImageListFragment.this.htN.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.htA.b(videoFileInfo)) {
                        ImageListFragment.this.htA.a(null);
                    } else {
                        ImageListFragment.this.htA.a(videoFileInfo);
                    }
                    ImageListFragment.this.htA.bFW();
                    ImageListFragment.this.huA.notifyDataSetChanged();
                    ImageListFragment.this.bGe();
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
        this.htN = (AlbumActivity) getBaseFragmentActivity();
        this.htA = this.htN.bFF();
        d.bGb().a(this);
        this.huw = new com.baidu.tbadk.album.f(this.htN);
        this.huy = new com.baidu.tieba.write.view.a(this.htN);
        this.huy.setOnDismissListener(this.mOnDismissListener);
        this.huy.a(this.huC);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.cSA = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cBr = this.mView.findViewById(d.g.layout_title);
        this.cYc = (TextView) this.mView.findViewById(d.g.album_title);
        this.fcb = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hux = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.huB = this.mView.findViewById(d.g.navi_line);
        this.htT = this.mView.findViewById(d.g.layout_bottom);
        this.htV = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.htU = (TextView) this.mView.findViewById(d.g.next_step);
        this.htA.vA(com.baidu.tbadk.album.a.ZW);
        this.cYc.setText(this.htN.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.htN.getPageContext().getPageActivity(), this.cSA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.E(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.huz = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.huz.setSelector(d.C0140d.transparent);
        this.huA = new h(this.htN, this.htA);
        this.huA.nv(this.htN.bFE() != 1);
        this.huz.setAdapter((ListAdapter) this.huA);
        this.huz.setOuterOnScrollListener(this);
        this.huA.a(this.hul);
        this.huA.a(this.huk);
        this.huA.X(this.huj);
        this.huA.setOnOpenCameraFailedListener(this.hun);
        this.huA.setOnRequestPermissionListener(this.hum);
        this.htU.setOnClickListener(this.htN);
        this.fcb.setOnClickListener(this.htN);
        this.hux.setOnClickListener(this.htN);
        this.htV.setOnClickListener(this.htN);
        this.cYc.setOnClickListener(this.mOnClickListener);
        this.htT.setOnClickListener(this.mOnClickListener);
        bGe();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aVY == null) {
            this.aVY = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.aVY.d(null);
        this.aVY.df(d.j.loading);
        this.aVY.aM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.htN.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGe() {
        int y;
        String string;
        if (this.htA != null && this.htU != null) {
            if (this.htA.bFV()) {
                int i = this.htA.bFV() ? 1 : 0;
                y = i;
                string = this.htN.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                y = w.y(this.htA.bFX());
                string = this.htN.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.htA.getMaxImagesAllowed())});
            }
            this.htU.setText(string);
            this.htU.setEnabled(y > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fvb = false;
        if (isShow()) {
            TM();
        }
    }

    private void bFR() {
        if (this.htA == null && this.htN != null) {
            this.htA = this.htN.bFF();
        }
        if (this.htA != null) {
            if (!this.htA.Kf()) {
                this.huA.notifyDataSetChanged();
            } else {
                bGf();
            }
            ns(this.htA.isOriginalImg());
        }
    }

    private void bGf() {
        if (this.huw == null) {
            this.huw = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.huw.a(this.htN.bFE() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.aVY != null) {
                    ImageListFragment.this.aVY.aM(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.htA != null && gVar != null) {
                    ImageListFragment.this.htA.c(gVar);
                    String bFY = ImageListFragment.this.htA.bFY();
                    ImageListFragment.this.htA.vA(bFY);
                    ImageListFragment.this.huA.setData(ImageListFragment.this.htA.vC(bFY));
                    ImageListFragment.this.huz.smoothScrollToPosition(0);
                    ImageListFragment.this.bGe();
                }
                ImageListFragment.this.huz.bGm();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        am.e(this.huB, d.C0140d.cp_bg_line_b, i);
        am.c(this.cYc, d.C0140d.cp_cont_b, i);
        if (this.htN.bFE() == 1) {
            am.b(this.fcb, d.f.icon_topbar_close_n, i);
            this.hux.setVisibility(8);
        } else {
            am.h(this.hux, d.C0140d.navi_back_text_color);
            this.fcb.setVisibility(8);
        }
        if (this.cYc != null) {
            this.cYc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.huA != null) {
            this.huA.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.htA != null) {
            ns(this.htA.isOriginalImg());
        }
    }

    public View bqx() {
        return this.htN.bFE() == 1 ? this.fcb : this.hux;
    }

    public View bGg() {
        return this.htU;
    }

    public TbCameraView bFJ() {
        if (this.huA != null) {
            return this.huA.bGc();
        }
        return null;
    }

    public TransparentHeadGridView bGh() {
        return this.huz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.huy != null) {
            this.huy.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.huw != null) {
            this.huw.rH();
        }
        if (this.htN != null) {
            this.htN.closeLoadingDialog();
        }
        if (this.aVY != null) {
            this.aVY.aM(false);
        }
        d.bGb().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fvb = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void nu(boolean z) {
        TM();
    }

    private void TM() {
        if (!isHidden() && !this.fvb) {
            bFR();
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
            this.huA.je(true);
        } else if (this.huA.isScroll()) {
            this.huA.je(false);
        }
    }

    public void G(int i, boolean z) {
        if (this.huz != null) {
            int firstVisiblePosition = this.huz.getFirstVisiblePosition();
            int lastVisiblePosition = this.huz.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.huz.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.huA != null) {
                    this.huA.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGe();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.huA != null) {
            G(this.huA.g(imageFileInfo), z);
        }
    }

    public View bFO() {
        return this.htV;
    }

    public void ns(boolean z) {
        if (this.htN != null && this.htV != null) {
            this.htV.setText(this.htN.getResources().getString(d.j.original_img));
            if (z) {
                this.htV.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.htV, d.C0140d.cp_link_tip_a);
                return;
            }
            this.htV.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.htV, d.C0140d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.htJ = iVar;
    }
}
