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
    private View cdh;
    private RelativeLayout ctl;
    private boolean eTf;
    private ImageView gxA;
    private com.baidu.tbadk.album.f hfZ;
    private e hfd;
    private l hfl;
    private AlbumActivity hfp;
    private View hfv;
    private TextView hfw;
    private TextView hfx;
    private com.baidu.tieba.write.view.a hga;
    private TransparentHeadGridView hgb;
    private j hgc;
    private View hgd;
    private com.baidu.tbadk.core.view.g mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b aME = null;
    private View.OnClickListener hfM = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hfd != null) {
                int maxImagesAllowed = k.this.hfd.getMaxImagesAllowed();
                if (k.this.hfd.size() < maxImagesAllowed) {
                    if (k.this.hfp != null) {
                        k.this.hfp.c(k.this.getPageContext());
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
            if (k.this.hfd != null) {
                if (k.this.hfl == null || !k.this.hfl.bGE()) {
                    if (view == k.this.mTitleText) {
                        k.this.hga.d(k.this.hfd.bGv(), k.this.hfd.bGt());
                        k.this.hga.aw(k.this.cdh);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hfv) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hfP = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bur() {
            return !ab.f(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hfQ = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bus() {
        }
    };
    private PopupWindow.OnDismissListener hge = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.k.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (k.this.mTitleText != null && k.this.isAdded()) {
                Drawable drawable = aj.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                k.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private h hfN = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hfd != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hfd.f((ImageFileInfo) mediaFileInfo);
                    k.this.hfp.vQ(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0161a hgf = new a.InterfaceC0161a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0161a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> uG;
            if (k.this.hfd != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hfd.bGt()) && (uG = k.this.hfd.uG(albumId)) != null) {
                    k.this.hfd.uE(albumId);
                    k.this.hgc.setData(uG);
                    k.this.mTitleText.setText(name);
                    k.this.hgb.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hfO = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hfp == null || k.this.hfd == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hfd.bGq()) {
                    k.this.hfp.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hfd.isAdded(imageFileInfo)) {
                    k.this.hfp.d(imageFileInfo);
                } else {
                    k.this.hfp.c(imageFileInfo);
                }
                k.this.hfd.a(null);
                k.this.hgc.notifyDataSetChanged();
                k.this.bGz();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hfd.bGp()) {
                    k.this.hfp.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hfd.b(videoFileInfo)) {
                        k.this.hfd.a(null);
                    } else {
                        k.this.hfd.a(videoFileInfo);
                    }
                    k.this.hfd.bGr();
                    k.this.hgc.notifyDataSetChanged();
                    k.this.bGz();
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
        this.hfp = (AlbumActivity) getBaseFragmentActivity();
        this.hfd = this.hfp.bGa();
        f.bGw().a(this);
        this.hfZ = new com.baidu.tbadk.album.f(this.hfp);
        this.hga = new com.baidu.tieba.write.view.a(this.hfp);
        this.hga.setOnDismissListener(this.hge);
        this.hga.a(this.hgf);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.ctl = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cdh = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.gxA = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hgd = this.mView.findViewById(d.g.navi_line);
        this.hfv = this.mView.findViewById(d.g.layout_bottom);
        this.hfx = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hfw = (TextView) this.mView.findViewById(d.g.next_step);
        this.hfd.uE(com.baidu.tbadk.album.a.Rh);
        this.mTitleText.setText(this.hfp.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hfp.getPageContext().getPageActivity(), this.ctl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hgb = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hgb.setSelector(d.C0095d.transparent);
        this.hgc = new j(this.hfp, this.hfd);
        this.hgc.oa(this.hfp.bFZ() != 1);
        this.hgb.setAdapter((ListAdapter) this.hgc);
        this.hgb.setOuterOnScrollListener(this);
        this.hgc.a(this.hfO);
        this.hgc.a(this.hfN);
        this.hgc.W(this.hfM);
        this.hgc.setOnOpenCameraFailedListener(this.hfQ);
        this.hgc.setOnRequestPermissionListener(this.hfP);
        this.hfw.setOnClickListener(this.hfp);
        this.gxA.setOnClickListener(this.hfp);
        this.hfx.setOnClickListener(this.hfp);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hfv.setOnClickListener(this.mOnClickListener);
        bGz();
        NN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void NN() {
        if (this.aME == null) {
            this.aME = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.aME.c(null);
        this.aME.db(d.j.loading);
        this.aME.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hfp.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGz() {
        int v;
        String string;
        if (this.hfd != null && this.hfw != null) {
            if (this.hfd.bGq()) {
                int i = this.hfd.bGq() ? 1 : 0;
                v = i;
                string = this.hfp.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                v = v.v(this.hfd.bGs());
                string = this.hfp.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hfd.getMaxImagesAllowed())});
            }
            this.hfw.setText(string);
            this.hfw.setEnabled(v > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eTf = false;
        if (isShow()) {
            Pj();
        }
    }

    private void bGm() {
        if (this.hfd == null && this.hfp != null) {
            this.hfd = this.hfp.bGa();
        }
        if (this.hfd != null) {
            if (!this.hfd.FP()) {
                this.hgc.notifyDataSetChanged();
            } else {
                bGA();
            }
            nX(this.hfd.isOriginalImg());
        }
    }

    private void bGA() {
        if (this.hfZ == null) {
            this.hfZ = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hfZ.a(this.hfp.bFZ() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.aME != null) {
                    k.this.aME.aE(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hfd != null && gVar != null) {
                    k.this.hfd.c(gVar);
                    String bGt = k.this.hfd.bGt();
                    k.this.hfd.uE(bGt);
                    k.this.hgc.setData(k.this.hfd.uG(bGt));
                    k.this.hgb.smoothScrollToPosition(0);
                    k.this.bGz();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.e(this.hgd, d.C0095d.cp_bg_line_b, i);
        aj.c(this.mTitleText, d.C0095d.cp_cont_b, i);
        aj.b(this.gxA, d.f.icon_topbar_close_n, i);
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hgc != null) {
            this.hgc.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hfd != null) {
            nX(this.hfd.isOriginalImg());
        }
    }

    public View boN() {
        return this.gxA;
    }

    public View bGB() {
        return this.hfw;
    }

    public TbCameraView bGe() {
        if (this.hgc != null) {
            return this.hgc.bGx();
        }
        return null;
    }

    public TransparentHeadGridView bGC() {
        return this.hgb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hga != null) {
            this.hga.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hfZ != null) {
            this.hfZ.nF();
        }
        if (this.hfp != null) {
            this.hfp.closeLoadingDialog();
        }
        if (this.aME != null) {
            this.aME.aE(false);
        }
        f.bGw().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eTf = true;
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
        if (!isHidden() && !this.eTf) {
            bGm();
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
            this.hgc.iK(true);
        } else if (this.hgc.isScroll()) {
            this.hgc.iK(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hgb != null) {
            int firstVisiblePosition = this.hgb.getFirstVisiblePosition();
            int lastVisiblePosition = this.hgb.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hgb.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hgc != null) {
                    this.hgc.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGz();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hgc != null) {
            H(this.hgc.g(imageFileInfo), z);
        }
    }

    public View bGj() {
        return this.hfx;
    }

    public void nX(boolean z) {
        if (this.hfp != null && this.hfx != null) {
            this.hfx.setText(this.hfp.getResources().getString(d.j.original_img));
            if (z) {
                this.hfx.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.hfx, d.C0095d.cp_link_tip_a);
                return;
            }
            this.hfx.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.hfx, d.C0095d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hfl = lVar;
    }
}
