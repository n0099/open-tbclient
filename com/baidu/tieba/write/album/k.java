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
    private View cZi;
    private RelativeLayout dpk;
    private boolean fKB;
    private View hED;
    private TextView hEE;
    private TextView hEF;
    private e hEk;
    private l hEt;
    private AlbumActivity hEx;
    private com.baidu.tbadk.album.f hFg;
    private ImageView hFh;
    private TextView hFi;
    private com.baidu.tieba.write.view.a hFj;
    private TransparentHeadGridView hFk;
    private j hFl;
    private View hFm;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b bCz = null;
    private View.OnClickListener hET = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hEk != null) {
                int maxImagesAllowed = k.this.hEk.getMaxImagesAllowed();
                if (k.this.hEk.size() < maxImagesAllowed) {
                    if (k.this.hEx != null) {
                        k.this.hEx.b(k.this.getPageContext());
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
            if (k.this.hEk != null) {
                if (k.this.hEt == null || !k.this.hEt.bGG()) {
                    if (view == k.this.mTitleText) {
                        k.this.hFj.e(k.this.hEk.bGs(), k.this.hEk.bGq());
                        k.this.hFj.bK(k.this.cZi);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hED) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hEW = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bGA() {
            return !ab.e(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hEX = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bGB() {
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
    private h hEU = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hEk != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hEk.f((ImageFileInfo) mediaFileInfo);
                    k.this.hEx.xk(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0257a hFn = new a.InterfaceC0257a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0257a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> us;
            if (k.this.hEk != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hEk.bGq()) && (us = k.this.hEk.us(albumId)) != null) {
                    k.this.hEk.uq(albumId);
                    k.this.hFl.setData(us);
                    k.this.mTitleText.setText(name);
                    k.this.hFk.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hEV = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hEx == null || k.this.hEk == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hEk.bGn()) {
                    k.this.hEx.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hEk.isAdded(imageFileInfo)) {
                    k.this.hEx.d(imageFileInfo);
                } else {
                    k.this.hEx.c(imageFileInfo);
                }
                k.this.hEk.a(null);
                k.this.hFl.notifyDataSetChanged();
                k.this.bGw();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hEk.bGm()) {
                    k.this.hEx.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hEk.b(videoFileInfo)) {
                        k.this.hEk.a(null);
                    } else {
                        k.this.hEk.a(videoFileInfo);
                    }
                    k.this.hEk.bGo();
                    k.this.hFl.notifyDataSetChanged();
                    k.this.bGw();
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
        this.hEx = (AlbumActivity) getBaseFragmentActivity();
        this.hEk = this.hEx.bFX();
        f.bGt().a(this);
        this.hFg = new com.baidu.tbadk.album.f(this.hEx);
        this.hFj = new com.baidu.tieba.write.view.a(this.hEx);
        this.hFj.setOnDismissListener(this.Id);
        this.hFj.a(this.hFn);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.dpk = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cZi = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hFh = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hFi = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hFm = this.mView.findViewById(d.g.navi_line);
        this.hED = this.mView.findViewById(d.g.layout_bottom);
        this.hEF = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hEE = (TextView) this.mView.findViewById(d.g.next_step);
        this.hEk.uq(com.baidu.tbadk.album.a.aGY);
        this.mTitleText.setText(this.hEx.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hEx.getPageContext().getPageActivity(), this.dpk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aC(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hFk = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hFk.setSelector(d.C0141d.transparent);
        this.hFl = new j(this.hEx, this.hEk);
        this.hFl.nH(this.hEx.bFW() != 1);
        this.hFk.setAdapter((ListAdapter) this.hFl);
        this.hFk.setOuterOnScrollListener(this);
        this.hFl.a(this.hEV);
        this.hFl.a(this.hEU);
        this.hFl.T(this.hET);
        this.hFl.setOnOpenCameraFailedListener(this.hEX);
        this.hFl.setOnRequestPermissionListener(this.hEW);
        this.hEE.setOnClickListener(this.hEx);
        this.hFh.setOnClickListener(this.hEx);
        this.hFi.setOnClickListener(this.hEx);
        this.hEF.setOnClickListener(this.hEx);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hED.setOnClickListener(this.mOnClickListener);
        bGw();
        VT();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void VT() {
        if (this.bCz == null) {
            this.bCz = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bCz.d(null);
        this.bCz.ga(d.j.loading);
        this.bCz.bq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hEx.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGw() {
        int D;
        String string;
        if (this.hEk != null && this.hEE != null) {
            if (this.hEk.bGn()) {
                int i = this.hEk.bGn() ? 1 : 0;
                D = i;
                string = this.hEx.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                D = v.D(this.hEk.bGp());
                string = this.hEx.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hEk.getMaxImagesAllowed())});
            }
            this.hEE.setText(string);
            this.hEE.setEnabled(D > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fKB = false;
        if (isShow()) {
            Xo();
        }
    }

    private void bGj() {
        if (this.hEk == null && this.hEx != null) {
            this.hEk = this.hEx.bFX();
        }
        if (this.hEk != null) {
            if (!this.hEk.NJ()) {
                this.hFl.notifyDataSetChanged();
            } else {
                bGx();
            }
            nE(this.hEk.isOriginalImg());
        }
    }

    private void bGx() {
        if (this.hFg == null) {
            this.hFg = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hFg.a(this.hEx.bFW() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.bCz != null) {
                    k.this.bCz.bq(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hEk != null && gVar != null) {
                    k.this.hEk.c(gVar);
                    String bGq = k.this.hEk.bGq();
                    k.this.hEk.uq(bGq);
                    k.this.hFl.setData(k.this.hEk.us(bGq));
                    k.this.hFk.smoothScrollToPosition(0);
                    k.this.bGw();
                }
                k.this.hFk.bGE();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.g(this.hFm, d.C0141d.cp_bg_line_b, i);
        aj.e(this.mTitleText, d.C0141d.cp_cont_b, i);
        if (this.hEx.bFW() == 1) {
            aj.b(this.hFh, d.f.icon_topbar_close_n, i);
            this.hFi.setVisibility(8);
        } else {
            aj.r(this.hFi, d.C0141d.navi_back_text_color);
            this.hFh.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hFl != null) {
            this.hFl.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hEk != null) {
            nE(this.hEk.isOriginalImg());
        }
    }

    public View brl() {
        return this.hEx.bFW() == 1 ? this.hFh : this.hFi;
    }

    public View bGy() {
        return this.hEE;
    }

    public TbCameraView bGb() {
        if (this.hFl != null) {
            return this.hFl.bGu();
        }
        return null;
    }

    public TransparentHeadGridView bGz() {
        return this.hFk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hFj != null) {
            this.hFj.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hFg != null) {
            this.hFg.vV();
        }
        if (this.hEx != null) {
            this.hEx.closeLoadingDialog();
        }
        if (this.bCz != null) {
            this.bCz.bq(false);
        }
        f.bGt().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fKB = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nG(boolean z) {
        Xo();
    }

    private void Xo() {
        if (!isHidden() && !this.fKB) {
            bGj();
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
            this.hFl.jB(true);
        } else if (this.hFl.isScroll()) {
            this.hFl.jB(false);
        }
    }

    public void Y(int i, boolean z) {
        if (this.hFk != null) {
            int firstVisiblePosition = this.hFk.getFirstVisiblePosition();
            int lastVisiblePosition = this.hFk.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hFk.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hFl != null) {
                    this.hFl.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGw();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hFl != null) {
            Y(this.hFl.g(imageFileInfo), z);
        }
    }

    public View bGg() {
        return this.hEF;
    }

    public void nE(boolean z) {
        if (this.hEx != null && this.hEF != null) {
            this.hEF.setText(this.hEx.getResources().getString(d.j.original_img));
            if (z) {
                this.hEF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.hEF, d.C0141d.cp_link_tip_a);
                return;
            }
            this.hEF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.hEF, d.C0141d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hEt = lVar;
    }
}
