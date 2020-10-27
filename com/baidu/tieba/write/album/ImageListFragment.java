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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View bxZ;
    private RelativeLayout byI;
    private ImageView byJ;
    private TextView byK;
    private TextView byL;
    private View byQ;
    private View byR;
    private boolean byS;
    private TextView byb;
    private NavigationBar fOZ;
    private BaseFragmentActivity ifx;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.album.f nAb;
    private com.baidu.tieba.write.view.a nAc;
    private TransparentHeadGridView nAd;
    private i nAe;
    private j nzF;
    private e nzn;
    private c nzr;
    private TBSpecificationBtn nzt;
    private com.baidu.tbadk.core.view.a fsa = null;
    private View.OnClickListener nzO = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nzr != null) {
                int maxImagesAllowed = ImageListFragment.this.nzr.getMaxImagesAllowed();
                if (ImageListFragment.this.nzr.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nzn != null) {
                        ImageListFragment.this.nzn.g(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nzr != null) {
                if (ImageListFragment.this.nzF == null || !ImageListFragment.this.nzF.dRf()) {
                    if (view == ImageListFragment.this.byL) {
                        ImageListFragment.this.nAc.c(ImageListFragment.this.nzr.Ru(), ImageListFragment.this.nzr.Rs());
                        ImageListFragment.this.nAc.O(ImageListFragment.this.fOZ == null ? ImageListFragment.this.byQ : ImageListFragment.this.fOZ);
                        ImageListFragment.this.byL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bxZ) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nzR = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean clj() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nzS = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dRc() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.byL != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.boN().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.byL.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nzP = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nzr != null && ImageListFragment.this.nzr.getWriteImagesInfo() != null && ImageListFragment.this.nzr.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nzn != null) {
                    ImageListFragment.this.nzn.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nzr != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nzr.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nzn != null) {
                        ImageListFragment.this.nzn.fJ(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0869a nAf = new a.InterfaceC0869a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0869a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ie;
            if (ImageListFragment.this.nzr != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nzr.Rs()) && (ie = ImageListFragment.this.nzr.ie(albumId)) != null) {
                    ImageListFragment.this.nzr.ic(albumId);
                    ImageListFragment.this.nAe.setData(ie);
                    ImageListFragment.this.byL.setText(name);
                    ImageListFragment.this.nAd.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nzQ = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.ifx == null || ImageListFragment.this.nzr == null || ImageListFragment.this.nzn == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.nzr.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nzn.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nzn.g(imageFileInfo);
                }
                ImageListFragment.this.nzr.a(null);
                ImageListFragment.this.nAe.notifyDataSetChanged();
                ImageListFragment.this.Ry();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nzr.Rn()) {
                    ImageListFragment.this.ifx.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nzr.a(videoFileInfo);
                    ImageListFragment.this.nzr.Rp();
                    ImageListFragment.this.nAe.notifyDataSetChanged();
                    ImageListFragment.this.nzn.QT();
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
        this.ifx = getBaseFragmentActivity();
        if (this.nzn == null) {
            if (this.ifx instanceof AlbumFloatActivity) {
                this.nzn = ((AlbumFloatActivity) this.ifx).nzn;
            } else if (this.ifx instanceof AlbumActivity) {
                this.nzn = ((AlbumActivity) this.ifx).nzn;
            }
        }
        if (this.nzn != null) {
            this.nzr = this.nzn.dQX();
        }
        d.dQU().a(this);
        this.nAb = new com.baidu.tbadk.album.f(this.ifx);
        this.nAc = new com.baidu.tieba.write.view.a(this.ifx);
        this.nAc.setOnDismissListener(this.mOnDismissListener);
        this.nAc.a(this.nAf);
    }

    public void a(e eVar) {
        this.nzn = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ifx = getBaseFragmentActivity();
        if (this.nzn == null) {
            if (this.ifx instanceof AlbumFloatActivity) {
                this.nzn = ((AlbumFloatActivity) this.ifx).nzn;
            } else if (this.ifx instanceof AlbumActivity) {
                this.nzn = ((AlbumActivity) this.ifx).nzn;
            }
        }
        if (this.nzn != null) {
            this.nzr = this.nzn.dQX();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.byI = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.byQ = this.mView.findViewById(R.id.layout_title);
        this.byL = (TextView) this.mView.findViewById(R.id.album_title);
        this.byJ = (ImageView) this.mView.findViewById(R.id.img_close);
        this.byK = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.byR = this.mView.findViewById(R.id.navi_line);
        this.bxZ = this.mView.findViewById(R.id.layout_bottom);
        this.byb = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.nzt = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nzt.setTextSize(R.dimen.tbds34);
        this.nzt.getStyleConfig().pV(l.getDimens(this.ifx, R.dimen.tbds25));
        this.nzr.ic(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.byL.setText(this.ifx.getPageContext().getString(R.string.album_all_media));
        if (this.nzr.getWriteImagesInfo() != null) {
            this.byb.setVisibility(this.nzr.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nzr.getWriteImagesInfo() != null && this.nzr.getWriteImagesInfo().isFromQRCode()) {
            this.bxZ.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.ifx.getPageContext().getPageActivity(), this.byI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nAd = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nAd.setSelector(R.color.transparent);
        this.nAe = new i(this.ifx, this.nzr);
        if (this.nzr.getWriteImagesInfo() != null && this.nzr.getWriteImagesInfo().isFromQRCode()) {
            this.nAe.yn(false);
        } else {
            this.nAe.yn(true);
        }
        this.nAd.setAdapter((ListAdapter) this.nAe);
        this.nAd.setOuterOnScrollListener(this);
        this.nAe.a(this.nzQ);
        this.nAe.a(this.nzP);
        this.nAe.al(this.nzO);
        this.nAe.setOnOpenCameraFailedListener(this.nzS);
        this.nAe.setOnRequestPermissionListener(this.nzR);
        this.nzt.setOnClickListener(this.ifx);
        this.byJ.setOnClickListener(this.ifx);
        this.byK.setOnClickListener(this.ifx);
        this.byb.setOnClickListener(this.ifx);
        this.byL.setOnClickListener(this.mOnClickListener);
        this.bxZ.setOnClickListener(this.mOnClickListener);
        Ry();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fOZ != null) {
            if (this.byL.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.byL.getParent()).removeView(this.byL);
            }
            this.byQ.setVisibility(8);
            this.fOZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.byL, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fsa == null) {
            this.fsa = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fsa.setCancelListener(null);
        this.fsa.setTipString(R.string.loading);
        this.fsa.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.ifx.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ry() {
        int count;
        String string;
        if (this.nzr != null && this.nzt != null) {
            if (this.nzr.Ro()) {
                int i = this.nzr.Ro() ? 1 : 0;
                count = i;
                string = this.ifx.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.nzr.Rq());
                string = this.ifx.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nzr.getMaxImagesAllowed())});
            }
            this.nzt.setText(string);
            this.nzt.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.byS = false;
        if (isShow()) {
            Rd();
        }
    }

    private void Rc() {
        if (this.nzr == null && this.nzn != null) {
            this.nzr = this.nzn.dQX();
        }
        if (this.nzr != null) {
            if (!this.nzr.bzx()) {
                this.nAe.notifyDataSetChanged();
            } else {
                Rz();
            }
            cJ(this.nzr.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Rz() {
        if (this.nAb == null) {
            this.nAb = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nAb.a((this.nzn == null || !this.nzn.dQY()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fsa != null) {
                    ImageListFragment.this.fsa.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.nzr != null && ImageListFragment.this.nAe != null) {
                    ImageListFragment.this.nzr.c(gVar);
                    String Rs = ImageListFragment.this.nzr.Rs();
                    ImageListFragment.this.nzr.ic(Rs);
                    ImageListFragment.this.nAe.setData(ImageListFragment.this.nzr.ie(Rs));
                    ImageListFragment.this.nAd.smoothScrollToPosition(0);
                    ImageListFragment.this.Ry();
                }
                ImageListFragment.this.nAd.RB();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.byR, R.color.cp_bg_line_c, i);
        ap.setViewTextColor(this.byL, R.color.cp_cont_b, i);
        if (this.byK != null && this.byJ != null) {
            if (this.nzn != null && this.nzn.QX() == 1) {
                SvgManager.boN().a(this.byJ, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                this.byK.setVisibility(8);
            } else {
                ap.setViewTextColor(this.byK, R.color.navi_back_text_color);
                this.byJ.setVisibility(8);
            }
        }
        if (this.byL != null) {
            this.byL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.boN().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nAe != null) {
            this.nAe.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nzr != null) {
            cJ(this.nzr.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fOZ = navigationBar;
    }

    public View Rw() {
        return (this.nzn == null || this.nzn.QX() != 1) ? this.byK : this.byJ;
    }

    public View RA() {
        return this.nzt;
    }

    public TbCameraView dQQ() {
        if (this.nAe != null) {
            return this.nAe.dQZ();
        }
        return null;
    }

    public TransparentHeadGridView dRb() {
        return this.nAd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nAc != null) {
            this.nAc.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nAb != null) {
            this.nAb.cancelLoadTask();
        }
        if (this.ifx != null) {
            this.ifx.closeLoadingDialog();
        }
        if (this.fsa != null) {
            this.fsa.setDialogVisiable(false);
        }
        d.dQU().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.byS = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cL(boolean z) {
        Rd();
    }

    private void Rd() {
        if (!isHidden() && !this.byS) {
            Rc();
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
            this.nAe.cM(true);
        } else if (this.nAe.isScroll()) {
            this.nAe.cM(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nAd != null) {
            int firstVisiblePosition = this.nAd.getFirstVisiblePosition();
            int lastVisiblePosition = this.nAd.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nAd.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nAe != null) {
                    this.nAe.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Ry();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nAe != null) {
            o(this.nAe.i(imageFileInfo), z);
        }
    }

    public View Rj() {
        return this.byb;
    }

    public void cJ(boolean z) {
        if (this.ifx != null && this.byb != null) {
            this.byb.setText(this.ifx.getResources().getString(R.string.original_img));
            if (z) {
                this.byb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.byb, R.color.cp_link_tip_a);
                return;
            }
            this.byb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.byb, R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.nzF = jVar;
    }
}
