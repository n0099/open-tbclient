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
import com.baidu.tbadk.core.util.WebPManager;
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
/* loaded from: classes7.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View bMS;
    private TextView bMU;
    private RelativeLayout bND;
    private ImageView bNE;
    private TextView bNF;
    private TextView bNG;
    private View bNL;
    private View bNM;
    private NavigationBar glw;
    private BaseFragmentActivity iMq;
    private boolean isPaused;
    private NoDataView mNoDataView;
    private View mView;
    private j ogK;
    private e ogs;
    private c ogw;
    private TBSpecificationBtn ogy;
    private com.baidu.tbadk.album.f ohg;
    private com.baidu.tieba.write.view.a ohh;
    private TransparentHeadGridView ohi;
    private i ohj;
    private com.baidu.tbadk.core.view.a fNE = null;
    private View.OnClickListener ogT = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.ogw != null) {
                int maxImagesAllowed = ImageListFragment.this.ogw.getMaxImagesAllowed();
                if (ImageListFragment.this.ogw.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.ogs != null) {
                        ImageListFragment.this.ogs.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.ogw != null) {
                if (ImageListFragment.this.ogK == null || !ImageListFragment.this.ogK.dXt()) {
                    if (view == ImageListFragment.this.bNG) {
                        ImageListFragment.this.ohh.setData(ImageListFragment.this.ogw.UN(), ImageListFragment.this.ogw.UL());
                        ImageListFragment.this.ohh.O(ImageListFragment.this.glw == null ? ImageListFragment.this.bNL : ImageListFragment.this.glw);
                        ImageListFragment.this.bNG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsU().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bMS) {
                    }
                }
            }
        }
    };
    private TbCameraView.c ogW = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean crZ() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a ogX = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dXm() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bNG != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.bsU().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bNG.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g ogU = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.ogw != null && ImageListFragment.this.ogw.getWriteImagesInfo() != null && ImageListFragment.this.ogw.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.ogs != null) {
                    ImageListFragment.this.ogs.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.ogw != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.ogw.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.ogs != null) {
                        ImageListFragment.this.ogs.eQ(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0910a ohk = new a.InterfaceC0910a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0910a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ib;
            if (ImageListFragment.this.ogw != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.ogw.UL()) && (ib = ImageListFragment.this.ogw.ib(albumId)) != null) {
                    ImageListFragment.this.ogw.hZ(albumId);
                    ImageListFragment.this.ohj.setData(ib);
                    ImageListFragment.this.bNG.setText(name);
                    ImageListFragment.this.ohi.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h ogV = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.iMq == null || ImageListFragment.this.ogw == null || ImageListFragment.this.ogs == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.b.b.j(imageFileInfo)) {
                    ImageListFragment.this.iMq.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.ogw.isAdded(imageFileInfo)) {
                    ImageListFragment.this.ogs.f(imageFileInfo);
                } else {
                    ImageListFragment.this.ogs.g(imageFileInfo);
                }
                ImageListFragment.this.ogw.a(null);
                ImageListFragment.this.ohj.notifyDataSetChanged();
                ImageListFragment.this.UR();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.ogw.UG()) {
                    ImageListFragment.this.iMq.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo) && ImageListFragment.this.d(videoFileInfo)) {
                    ImageListFragment.this.ogw.a(videoFileInfo);
                    ImageListFragment.this.ogw.UI();
                    ImageListFragment.this.ohj.notifyDataSetChanged();
                    ImageListFragment.this.ogs.Um();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iMq = getBaseFragmentActivity();
        if (this.ogs == null) {
            if (this.iMq instanceof AlbumFloatActivity) {
                this.ogs = ((AlbumFloatActivity) this.iMq).ogs;
            } else if (this.iMq instanceof AlbumActivity) {
                this.ogs = ((AlbumActivity) this.iMq).ogs;
            }
        }
        if (this.ogs != null) {
            this.ogw = this.ogs.dXh();
        }
        d.dXe().a(this);
        this.ohg = new com.baidu.tbadk.album.f(this.iMq);
        this.ohh = new com.baidu.tieba.write.view.a(this.iMq);
        this.ohh.setOnDismissListener(this.mOnDismissListener);
        this.ohh.a(this.ohk);
    }

    public void a(e eVar) {
        this.ogs = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iMq = getBaseFragmentActivity();
        if (this.ogs == null) {
            if (this.iMq instanceof AlbumFloatActivity) {
                this.ogs = ((AlbumFloatActivity) this.iMq).ogs;
            } else if (this.iMq instanceof AlbumActivity) {
                this.ogs = ((AlbumActivity) this.iMq).ogs;
            }
        }
        if (this.ogs != null) {
            this.ogw = this.ogs.dXh();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bND = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bNL = this.mView.findViewById(R.id.layout_title);
        this.bNG = (TextView) this.mView.findViewById(R.id.album_title);
        this.bNE = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bNF = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bNM = this.mView.findViewById(R.id.navi_line);
        this.bMS = this.mView.findViewById(R.id.layout_bottom);
        this.bMU = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.ogy = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.ogy.setTextSize(R.dimen.tbds34);
        this.ogy.getStyleConfig().pP(l.getDimens(this.iMq, R.dimen.tbds25));
        this.ogw.hZ(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bNG.setText(this.iMq.getPageContext().getString(R.string.album_all_media));
        if (this.ogw.getWriteImagesInfo() != null) {
            this.bMU.setVisibility(this.ogw.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.ogw.getWriteImagesInfo() != null && this.ogw.getWriteImagesInfo().isFromQRCode()) {
            this.bMS.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.iMq.getPageContext().getPageActivity(), this.bND, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aV(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.ohi = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.ohi.setSelector(R.color.transparent);
        this.ohj = new i(this.iMq, this.ogw);
        if (this.ogw.getWriteImagesInfo() != null && this.ogw.getWriteImagesInfo().isFromQRCode()) {
            this.ohj.zA(false);
        } else {
            this.ohj.zA(true);
        }
        this.ohi.setAdapter((ListAdapter) this.ohj);
        this.ohi.setOuterOnScrollListener(this);
        this.ohj.a(this.ogV);
        this.ohj.a(this.ogU);
        this.ohj.ap(this.ogT);
        this.ohj.setOnOpenCameraFailedListener(this.ogX);
        this.ohj.setOnRequestPermissionListener(this.ogW);
        this.ogy.setOnClickListener(this.iMq);
        this.bNE.setOnClickListener(this.iMq);
        this.bNF.setOnClickListener(this.iMq);
        this.bMU.setOnClickListener(this.iMq);
        this.bNG.setOnClickListener(this.mOnClickListener);
        this.bMS.setOnClickListener(this.mOnClickListener);
        UR();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.glw != null) {
            if (this.bNG.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bNG.getParent()).removeView(this.bNG);
            }
            this.bNL.setVisibility(8);
            this.glw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bNG, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fNE == null) {
            this.fNE = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fNE.setCancelListener(null);
        this.fNE.setTipString(R.string.loading);
        this.fNE.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.iMq.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(VideoFileInfo videoFileInfo) {
        VideoFileInfo Vu = j.Vu(videoFileInfo.videoPath);
        if (Vu != null && Math.max(Vu.videoWidth, Vu.videoHeight) > 4096) {
            this.iMq.showToast(R.string.album_choose_video_resolution_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UR() {
        int count;
        String string;
        if (this.ogw != null && this.ogy != null) {
            if (this.ogw.UH()) {
                int i = this.ogw.UH() ? 1 : 0;
                string = this.iMq.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = y.getCount(this.ogw.UJ());
                string = this.iMq.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.ogw.getMaxImagesAllowed())});
            }
            this.ogy.setText(string);
            this.ogy.setEnabled(count > 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (isShow()) {
            Uw();
        }
    }

    private void Uv() {
        if (this.ogw == null && this.ogs != null) {
            this.ogw = this.ogs.dXh();
        }
        if (this.ogw != null) {
            if (!this.ogw.isDataEmpty()) {
                this.ohj.notifyDataSetChanged();
            } else {
                US();
            }
            dn(this.ogw.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void US() {
        if (this.ohg == null) {
            this.ohg = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.ohg.a((this.ogs == null || !this.ogs.dXi()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fNE != null) {
                    ImageListFragment.this.fNE.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.ogw != null && ImageListFragment.this.ohj != null) {
                    ImageListFragment.this.ogw.c(gVar);
                    String UL = ImageListFragment.this.ogw.UL();
                    ImageListFragment.this.ogw.hZ(UL);
                    ImageListFragment.this.ohj.setData(ImageListFragment.this.ogw.ib(UL));
                    if (ImageListFragment.this.ohi != null) {
                        ImageListFragment.this.ohi.smoothScrollToPosition(0);
                    }
                    ImageListFragment.this.UR();
                }
                if (ImageListFragment.this.ohi != null) {
                    ImageListFragment.this.ohi.UU();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bNM, R.color.CAM_X0204, i);
        ap.setViewTextColor(this.bNG, R.color.CAM_X0105, i);
        if (this.bNF != null && this.bNE != null) {
            if (this.ogs != null && this.ogs.Uq() == 1) {
                SvgManager.bsU().a(this.bNE, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                this.bNF.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bNF, R.color.navi_back_text_color);
                this.bNE.setVisibility(8);
            }
        }
        if (this.bNG != null) {
            this.bNG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsU().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.ohj != null) {
            this.ohj.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ogw != null) {
            dn(this.ogw.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.glw = navigationBar;
    }

    public View UP() {
        return (this.ogs == null || this.ogs.Uq() != 1) ? this.bNF : this.bNE;
    }

    public View UT() {
        return this.ogy;
    }

    public TbCameraView dXa() {
        if (this.ohj != null) {
            return this.ohj.dXj();
        }
        return null;
    }

    public TransparentHeadGridView dXl() {
        return this.ohi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.ohh != null) {
            this.ohh.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ohg != null) {
            this.ohg.cancelLoadTask();
        }
        if (this.iMq != null) {
            this.iMq.closeLoadingDialog();
        }
        if (this.fNE != null) {
            this.fNE.setDialogVisiable(false);
        }
        d.dXe().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void dp(boolean z) {
        Uw();
    }

    private void Uw() {
        if (!isHidden() && !this.isPaused) {
            Uv();
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
            this.ohj.dq(true);
        } else if (this.ohj.isScroll()) {
            this.ohj.dq(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.ohi != null) {
            int firstVisiblePosition = this.ohi.getFirstVisiblePosition();
            int lastVisiblePosition = this.ohi.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.ohi.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.ohj != null) {
                    this.ohj.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        UR();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.ohj != null) {
            o(this.ohj.i(imageFileInfo), z);
        }
    }

    public View UC() {
        return this.bMU;
    }

    public void dn(boolean z) {
        if (this.iMq != null && this.bMU != null) {
            this.bMU.setText(this.iMq.getResources().getString(R.string.original_img));
            if (z) {
                this.bMU.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.bMU, R.color.CAM_X0302);
                return;
            }
            this.bMU.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.bMU, R.color.CAM_X0106);
        }
    }

    public void a(j jVar) {
        this.ogK = jVar;
    }
}
