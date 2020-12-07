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
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View bHH;
    private TextView bHJ;
    private boolean bIA;
    private RelativeLayout bIq;
    private ImageView bIr;
    private TextView bIs;
    private TextView bIt;
    private View bIy;
    private View bIz;
    private NavigationBar gcG;
    private BaseFragmentActivity ixc;
    private NoDataView mNoDataView;
    private View mView;
    private e nUO;
    private c nUS;
    private TBSpecificationBtn nUU;
    private com.baidu.tbadk.album.f nVC;
    private com.baidu.tieba.write.view.a nVD;
    private TransparentHeadGridView nVE;
    private i nVF;
    private j nVg;
    private com.baidu.tbadk.core.view.a fEW = null;
    private View.OnClickListener nVp = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nUS != null) {
                int maxImagesAllowed = ImageListFragment.this.nUS.getMaxImagesAllowed();
                if (ImageListFragment.this.nUS.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nUO != null) {
                        ImageListFragment.this.nUO.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nUS != null) {
                if (ImageListFragment.this.nVg == null || !ImageListFragment.this.nVg.dYY()) {
                    if (view == ImageListFragment.this.bIt) {
                        ImageListFragment.this.nVD.c(ImageListFragment.this.nUS.VT(), ImageListFragment.this.nUS.VR());
                        ImageListFragment.this.nVD.O(ImageListFragment.this.gcG == null ? ImageListFragment.this.bIy : ImageListFragment.this.gcG);
                        ImageListFragment.this.bIt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.btW().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bHH) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nVs = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean crz() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nVt = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dYV() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bIt != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.btW().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bIt.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nVq = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nUS != null && ImageListFragment.this.nUS.getWriteImagesInfo() != null && ImageListFragment.this.nUS.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nUO != null) {
                    ImageListFragment.this.nUO.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nUS != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nUS.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nUO != null) {
                        ImageListFragment.this.nUO.gr(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0903a nVG = new a.InterfaceC0903a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0903a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> iV;
            if (ImageListFragment.this.nUS != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nUS.VR()) && (iV = ImageListFragment.this.nUS.iV(albumId)) != null) {
                    ImageListFragment.this.nUS.iT(albumId);
                    ImageListFragment.this.nVF.setData(iV);
                    ImageListFragment.this.bIt.setText(name);
                    ImageListFragment.this.nVE.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nVr = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.ixc == null || ImageListFragment.this.nUS == null || ImageListFragment.this.nUO == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.c.b.l(imageFileInfo)) {
                    ImageListFragment.this.ixc.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.nUS.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nUO.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nUO.g(imageFileInfo);
                }
                ImageListFragment.this.nUS.a(null);
                ImageListFragment.this.nVF.notifyDataSetChanged();
                ImageListFragment.this.VX();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nUS.VM()) {
                    ImageListFragment.this.ixc.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nUS.a(videoFileInfo);
                    ImageListFragment.this.nUS.VO();
                    ImageListFragment.this.nVF.notifyDataSetChanged();
                    ImageListFragment.this.nUO.Vs();
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
        this.ixc = getBaseFragmentActivity();
        if (this.nUO == null) {
            if (this.ixc instanceof AlbumFloatActivity) {
                this.nUO = ((AlbumFloatActivity) this.ixc).nUO;
            } else if (this.ixc instanceof AlbumActivity) {
                this.nUO = ((AlbumActivity) this.ixc).nUO;
            }
        }
        if (this.nUO != null) {
            this.nUS = this.nUO.dYQ();
        }
        d.dYN().a(this);
        this.nVC = new com.baidu.tbadk.album.f(this.ixc);
        this.nVD = new com.baidu.tieba.write.view.a(this.ixc);
        this.nVD.setOnDismissListener(this.mOnDismissListener);
        this.nVD.a(this.nVG);
    }

    public void a(e eVar) {
        this.nUO = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ixc = getBaseFragmentActivity();
        if (this.nUO == null) {
            if (this.ixc instanceof AlbumFloatActivity) {
                this.nUO = ((AlbumFloatActivity) this.ixc).nUO;
            } else if (this.ixc instanceof AlbumActivity) {
                this.nUO = ((AlbumActivity) this.ixc).nUO;
            }
        }
        if (this.nUO != null) {
            this.nUS = this.nUO.dYQ();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bIq = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bIy = this.mView.findViewById(R.id.layout_title);
        this.bIt = (TextView) this.mView.findViewById(R.id.album_title);
        this.bIr = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bIs = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bIz = this.mView.findViewById(R.id.navi_line);
        this.bHH = this.mView.findViewById(R.id.layout_bottom);
        this.bHJ = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.nUU = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nUU.setTextSize(R.dimen.tbds34);
        this.nUU.getStyleConfig().re(l.getDimens(this.ixc, R.dimen.tbds25));
        this.nUS.iT(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bIt.setText(this.ixc.getPageContext().getString(R.string.album_all_media));
        if (this.nUS.getWriteImagesInfo() != null) {
            this.bHJ.setVisibility(this.nUS.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nUS.getWriteImagesInfo() != null && this.nUS.getWriteImagesInfo().isFromQRCode()) {
            this.bHH.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.ixc.getPageContext().getPageActivity(), this.bIq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ba(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nVE = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nVE.setSelector(R.color.transparent);
        this.nVF = new i(this.ixc, this.nUS);
        if (this.nUS.getWriteImagesInfo() != null && this.nUS.getWriteImagesInfo().isFromQRCode()) {
            this.nVF.zi(false);
        } else {
            this.nVF.zi(true);
        }
        this.nVE.setAdapter((ListAdapter) this.nVF);
        this.nVE.setOuterOnScrollListener(this);
        this.nVF.a(this.nVr);
        this.nVF.a(this.nVq);
        this.nVF.am(this.nVp);
        this.nVF.setOnOpenCameraFailedListener(this.nVt);
        this.nVF.setOnRequestPermissionListener(this.nVs);
        this.nUU.setOnClickListener(this.ixc);
        this.bIr.setOnClickListener(this.ixc);
        this.bIs.setOnClickListener(this.ixc);
        this.bHJ.setOnClickListener(this.ixc);
        this.bIt.setOnClickListener(this.mOnClickListener);
        this.bHH.setOnClickListener(this.mOnClickListener);
        VX();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gcG != null) {
            if (this.bIt.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bIt.getParent()).removeView(this.bIt);
            }
            this.bIy.setVisibility(8);
            this.gcG.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bIt, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fEW == null) {
            this.fEW = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fEW.setCancelListener(null);
        this.fEW.setTipString(R.string.loading);
        this.fEW.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.ixc.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VX() {
        int count;
        String string;
        if (this.nUS != null && this.nUU != null) {
            if (this.nUS.VN()) {
                int i = this.nUS.VN() ? 1 : 0;
                count = i;
                string = this.ixc.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.nUS.VP());
                string = this.ixc.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nUS.getMaxImagesAllowed())});
            }
            this.nUU.setText(string);
            this.nUU.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bIA = false;
        if (isShow()) {
            VC();
        }
    }

    private void VB() {
        if (this.nUS == null && this.nUO != null) {
            this.nUS = this.nUO.dYQ();
        }
        if (this.nUS != null) {
            if (!this.nUS.bEO()) {
                this.nVF.notifyDataSetChanged();
            } else {
                VY();
            }
            dg(this.nUS.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VY() {
        if (this.nVC == null) {
            this.nVC = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nVC.a((this.nUO == null || !this.nUO.dYR()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fEW != null) {
                    ImageListFragment.this.fEW.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.nUS != null && ImageListFragment.this.nVF != null) {
                    ImageListFragment.this.nUS.c(gVar);
                    String VR = ImageListFragment.this.nUS.VR();
                    ImageListFragment.this.nUS.iT(VR);
                    ImageListFragment.this.nVF.setData(ImageListFragment.this.nUS.iV(VR));
                    ImageListFragment.this.nVE.smoothScrollToPosition(0);
                    ImageListFragment.this.VX();
                }
                ImageListFragment.this.nVE.Wa();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bIz, R.color.CAM_X0204, i);
        ap.setViewTextColor(this.bIt, R.color.CAM_X0105, i);
        if (this.bIs != null && this.bIr != null) {
            if (this.nUO != null && this.nUO.Vw() == 1) {
                SvgManager.btW().a(this.bIr, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                this.bIs.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bIs, R.color.navi_back_text_color);
                this.bIr.setVisibility(8);
            }
        }
        if (this.bIt != null) {
            this.bIt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.btW().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nVF != null) {
            this.nVF.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nUS != null) {
            dg(this.nUS.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.gcG = navigationBar;
    }

    public View VV() {
        return (this.nUO == null || this.nUO.Vw() != 1) ? this.bIs : this.bIr;
    }

    public View VZ() {
        return this.nUU;
    }

    public TbCameraView dYJ() {
        if (this.nVF != null) {
            return this.nVF.dYS();
        }
        return null;
    }

    public TransparentHeadGridView dYU() {
        return this.nVE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nVD != null) {
            this.nVD.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nVC != null) {
            this.nVC.cancelLoadTask();
        }
        if (this.ixc != null) {
            this.ixc.closeLoadingDialog();
        }
        if (this.fEW != null) {
            this.fEW.setDialogVisiable(false);
        }
        d.dYN().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bIA = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void di(boolean z) {
        VC();
    }

    private void VC() {
        if (!isHidden() && !this.bIA) {
            VB();
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
            this.nVF.dj(true);
        } else if (this.nVF.isScroll()) {
            this.nVF.dj(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nVE != null) {
            int firstVisiblePosition = this.nVE.getFirstVisiblePosition();
            int lastVisiblePosition = this.nVE.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nVE.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nVF != null) {
                    this.nVF.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        VX();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nVF != null) {
            o(this.nVF.i(imageFileInfo), z);
        }
    }

    public View VI() {
        return this.bHJ;
    }

    public void dg(boolean z) {
        if (this.ixc != null && this.bHJ != null) {
            this.bHJ.setText(this.ixc.getResources().getString(R.string.original_img));
            if (z) {
                this.bHJ.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.bHJ, R.color.CAM_X0302);
                return;
            }
            this.bHJ.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.bHJ, R.color.CAM_X0106);
        }
    }

    public void a(j jVar) {
        this.nVg = jVar;
    }
}
