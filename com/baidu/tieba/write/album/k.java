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
    private View cZu;
    private RelativeLayout dpw;
    private boolean fKM;
    private l hEG;
    private AlbumActivity hEK;
    private View hEQ;
    private TextView hER;
    private TextView hES;
    private e hEx;
    private com.baidu.tbadk.album.f hFt;
    private ImageView hFu;
    private TextView hFv;
    private com.baidu.tieba.write.view.a hFw;
    private TransparentHeadGridView hFx;
    private j hFy;
    private View hFz;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.b bCM = null;
    private View.OnClickListener hFg = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.hEx != null) {
                int maxImagesAllowed = k.this.hEx.getMaxImagesAllowed();
                if (k.this.hEx.size() < maxImagesAllowed) {
                    if (k.this.hEK != null) {
                        k.this.hEK.b(k.this.getPageContext());
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
            if (k.this.hEx != null) {
                if (k.this.hEG == null || !k.this.hEG.bGH()) {
                    if (view == k.this.mTitleText) {
                        k.this.hFw.e(k.this.hEx.bGt(), k.this.hEx.bGr());
                        k.this.hFw.bK(k.this.cZu);
                        k.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == k.this.hEQ) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hFj = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.k.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bGB() {
            return !ab.e(k.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hFk = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.k.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bGC() {
        }
    };
    private PopupWindow.OnDismissListener Ii = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.k.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (k.this.mTitleText != null && k.this.isAdded()) {
                Drawable drawable = aj.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                k.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private h hFh = new h() { // from class: com.baidu.tieba.write.album.k.6
        @Override // com.baidu.tieba.write.album.h
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && k.this.hEx != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    k.this.hEx.f((ImageFileInfo) mediaFileInfo);
                    k.this.hEK.xj(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0256a hFA = new a.InterfaceC0256a() { // from class: com.baidu.tieba.write.album.k.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0256a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> us;
            if (k.this.hEx != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(k.this.hEx.bGr()) && (us = k.this.hEx.us(albumId)) != null) {
                    k.this.hEx.uq(albumId);
                    k.this.hFy.setData(us);
                    k.this.mTitleText.setText(name);
                    k.this.hFx.smoothScrollToPosition(0);
                }
            }
        }
    };
    private i hFi = new i() { // from class: com.baidu.tieba.write.album.k.8
        @Override // com.baidu.tieba.write.album.i
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || k.this.hEK == null || k.this.hEx == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (k.this.hEx.bGo()) {
                    k.this.hEK.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (k.this.hEx.isAdded(imageFileInfo)) {
                    k.this.hEK.d(imageFileInfo);
                } else {
                    k.this.hEK.c(imageFileInfo);
                }
                k.this.hEx.a(null);
                k.this.hFy.notifyDataSetChanged();
                k.this.bGx();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (k.this.hEx.bGn()) {
                    k.this.hEK.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (k.this.c(videoFileInfo)) {
                    if (k.this.hEx.b(videoFileInfo)) {
                        k.this.hEx.a(null);
                    } else {
                        k.this.hEx.a(videoFileInfo);
                    }
                    k.this.hEx.bGp();
                    k.this.hFy.notifyDataSetChanged();
                    k.this.bGx();
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
        this.hEK = (AlbumActivity) getBaseFragmentActivity();
        this.hEx = this.hEK.bFY();
        f.bGu().a(this);
        this.hFt = new com.baidu.tbadk.album.f(this.hEK);
        this.hFw = new com.baidu.tieba.write.view.a(this.hEK);
        this.hFw.setOnDismissListener(this.Ii);
        this.hFw.a(this.hFA);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.dpw = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cZu = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hFu = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hFv = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hFz = this.mView.findViewById(d.g.navi_line);
        this.hEQ = this.mView.findViewById(d.g.layout_bottom);
        this.hES = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hER = (TextView) this.mView.findViewById(d.g.next_step);
        this.hEx.uq(com.baidu.tbadk.album.a.aHj);
        this.mTitleText.setText(this.hEK.getPageContext().getString(d.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hEK.getPageContext().getPageActivity(), this.dpw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aC(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.hFx = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hFx.setSelector(d.C0140d.transparent);
        this.hFy = new j(this.hEK, this.hEx);
        this.hFy.nH(this.hEK.bFX() != 1);
        this.hFx.setAdapter((ListAdapter) this.hFy);
        this.hFx.setOuterOnScrollListener(this);
        this.hFy.a(this.hFi);
        this.hFy.a(this.hFh);
        this.hFy.T(this.hFg);
        this.hFy.setOnOpenCameraFailedListener(this.hFk);
        this.hFy.setOnRequestPermissionListener(this.hFj);
        this.hER.setOnClickListener(this.hEK);
        this.hFu.setOnClickListener(this.hEK);
        this.hFv.setOnClickListener(this.hEK);
        this.hES.setOnClickListener(this.hEK);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hEQ.setOnClickListener(this.mOnClickListener);
        bGx();
        VU();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void VU() {
        if (this.bCM == null) {
            this.bCM = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bCM.d(null);
        this.bCM.ga(d.j.loading);
        this.bCM.bq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hEK.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGx() {
        int D;
        String string;
        if (this.hEx != null && this.hER != null) {
            if (this.hEx.bGo()) {
                int i = this.hEx.bGo() ? 1 : 0;
                D = i;
                string = this.hEK.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                D = v.D(this.hEx.bGq());
                string = this.hEK.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hEx.getMaxImagesAllowed())});
            }
            this.hER.setText(string);
            this.hER.setEnabled(D > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fKM = false;
        if (isShow()) {
            Xp();
        }
    }

    private void bGk() {
        if (this.hEx == null && this.hEK != null) {
            this.hEx = this.hEK.bFY();
        }
        if (this.hEx != null) {
            if (!this.hEx.NK()) {
                this.hFy.notifyDataSetChanged();
            } else {
                bGy();
            }
            nE(this.hEx.isOriginalImg());
        }
    }

    private void bGy() {
        if (this.hFt == null) {
            this.hFt = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hFt.a(this.hEK.bFX() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.k.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (k.this.bCM != null) {
                    k.this.bCM.bq(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (k.this.hEx != null && gVar != null) {
                    k.this.hEx.c(gVar);
                    String bGr = k.this.hEx.bGr();
                    k.this.hEx.uq(bGr);
                    k.this.hFy.setData(k.this.hEx.us(bGr));
                    k.this.hFx.smoothScrollToPosition(0);
                    k.this.bGx();
                }
                k.this.hFx.bGF();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        aj.g(this.hFz, d.C0140d.cp_bg_line_b, i);
        aj.e(this.mTitleText, d.C0140d.cp_cont_b, i);
        if (this.hEK.bFX() == 1) {
            aj.b(this.hFu, d.f.icon_topbar_close_n, i);
            this.hFv.setVisibility(8);
        } else {
            aj.r(this.hFv, d.C0140d.navi_back_text_color);
            this.hFu.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hFy != null) {
            this.hFy.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hEx != null) {
            nE(this.hEx.isOriginalImg());
        }
    }

    public View brm() {
        return this.hEK.bFX() == 1 ? this.hFu : this.hFv;
    }

    public View bGz() {
        return this.hER;
    }

    public TbCameraView bGc() {
        if (this.hFy != null) {
            return this.hFy.bGv();
        }
        return null;
    }

    public TransparentHeadGridView bGA() {
        return this.hFx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hFw != null) {
            this.hFw.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hFt != null) {
            this.hFt.vV();
        }
        if (this.hEK != null) {
            this.hEK.closeLoadingDialog();
        }
        if (this.bCM != null) {
            this.bCM.bq(false);
        }
        f.bGu().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fKM = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nG(boolean z) {
        Xp();
    }

    private void Xp() {
        if (!isHidden() && !this.fKM) {
            bGk();
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
            this.hFy.jB(true);
        } else if (this.hFy.isScroll()) {
            this.hFy.jB(false);
        }
    }

    public void Y(int i, boolean z) {
        if (this.hFx != null) {
            int firstVisiblePosition = this.hFx.getFirstVisiblePosition();
            int lastVisiblePosition = this.hFx.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hFx.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hFy != null) {
                    this.hFy.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGx();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hFy != null) {
            Y(this.hFy.g(imageFileInfo), z);
        }
    }

    public View bGh() {
        return this.hES;
    }

    public void nE(boolean z) {
        if (this.hEK != null && this.hES != null) {
            this.hES.setText(this.hEK.getResources().getString(d.j.original_img));
            if (z) {
                this.hES.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.hES, d.C0140d.cp_link_tip_a);
                return;
            }
            this.hES.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.hES, d.C0140d.cp_cont_f);
        }
    }

    public void a(l lVar) {
        this.hEG = lVar;
    }
}
