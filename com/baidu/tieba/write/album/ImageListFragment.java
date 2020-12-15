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
    private NavigationBar gcI;
    private BaseFragmentActivity ixe;
    private NoDataView mNoDataView;
    private View mView;
    private e nUQ;
    private c nUU;
    private TBSpecificationBtn nUW;
    private com.baidu.tbadk.album.f nVE;
    private com.baidu.tieba.write.view.a nVF;
    private TransparentHeadGridView nVG;
    private i nVH;
    private j nVi;
    private com.baidu.tbadk.core.view.a fEW = null;
    private View.OnClickListener nVr = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nUU != null) {
                int maxImagesAllowed = ImageListFragment.this.nUU.getMaxImagesAllowed();
                if (ImageListFragment.this.nUU.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nUQ != null) {
                        ImageListFragment.this.nUQ.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nUU != null) {
                if (ImageListFragment.this.nVi == null || !ImageListFragment.this.nVi.dYZ()) {
                    if (view == ImageListFragment.this.bIt) {
                        ImageListFragment.this.nVF.c(ImageListFragment.this.nUU.VT(), ImageListFragment.this.nUU.VR());
                        ImageListFragment.this.nVF.O(ImageListFragment.this.gcI == null ? ImageListFragment.this.bIy : ImageListFragment.this.gcI);
                        ImageListFragment.this.bIt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.btW().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bHH) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nVu = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean crA() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nVv = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dYW() {
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
    private g nVs = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nUU != null && ImageListFragment.this.nUU.getWriteImagesInfo() != null && ImageListFragment.this.nUU.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nUQ != null) {
                    ImageListFragment.this.nUQ.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nUU != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nUU.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nUQ != null) {
                        ImageListFragment.this.nUQ.gr(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0903a nVI = new a.InterfaceC0903a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0903a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> iV;
            if (ImageListFragment.this.nUU != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nUU.VR()) && (iV = ImageListFragment.this.nUU.iV(albumId)) != null) {
                    ImageListFragment.this.nUU.iT(albumId);
                    ImageListFragment.this.nVH.setData(iV);
                    ImageListFragment.this.bIt.setText(name);
                    ImageListFragment.this.nVG.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nVt = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.ixe == null || ImageListFragment.this.nUU == null || ImageListFragment.this.nUQ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.c.b.l(imageFileInfo)) {
                    ImageListFragment.this.ixe.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.nUU.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nUQ.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nUQ.g(imageFileInfo);
                }
                ImageListFragment.this.nUU.a(null);
                ImageListFragment.this.nVH.notifyDataSetChanged();
                ImageListFragment.this.VX();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nUU.VM()) {
                    ImageListFragment.this.ixe.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nUU.a(videoFileInfo);
                    ImageListFragment.this.nUU.VO();
                    ImageListFragment.this.nVH.notifyDataSetChanged();
                    ImageListFragment.this.nUQ.Vs();
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
        this.ixe = getBaseFragmentActivity();
        if (this.nUQ == null) {
            if (this.ixe instanceof AlbumFloatActivity) {
                this.nUQ = ((AlbumFloatActivity) this.ixe).nUQ;
            } else if (this.ixe instanceof AlbumActivity) {
                this.nUQ = ((AlbumActivity) this.ixe).nUQ;
            }
        }
        if (this.nUQ != null) {
            this.nUU = this.nUQ.dYR();
        }
        d.dYO().a(this);
        this.nVE = new com.baidu.tbadk.album.f(this.ixe);
        this.nVF = new com.baidu.tieba.write.view.a(this.ixe);
        this.nVF.setOnDismissListener(this.mOnDismissListener);
        this.nVF.a(this.nVI);
    }

    public void a(e eVar) {
        this.nUQ = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ixe = getBaseFragmentActivity();
        if (this.nUQ == null) {
            if (this.ixe instanceof AlbumFloatActivity) {
                this.nUQ = ((AlbumFloatActivity) this.ixe).nUQ;
            } else if (this.ixe instanceof AlbumActivity) {
                this.nUQ = ((AlbumActivity) this.ixe).nUQ;
            }
        }
        if (this.nUQ != null) {
            this.nUU = this.nUQ.dYR();
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
        this.nUW = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nUW.setTextSize(R.dimen.tbds34);
        this.nUW.getStyleConfig().re(l.getDimens(this.ixe, R.dimen.tbds25));
        this.nUU.iT(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bIt.setText(this.ixe.getPageContext().getString(R.string.album_all_media));
        if (this.nUU.getWriteImagesInfo() != null) {
            this.bHJ.setVisibility(this.nUU.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nUU.getWriteImagesInfo() != null && this.nUU.getWriteImagesInfo().isFromQRCode()) {
            this.bHH.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.ixe.getPageContext().getPageActivity(), this.bIq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ba(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nVG = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nVG.setSelector(R.color.transparent);
        this.nVH = new i(this.ixe, this.nUU);
        if (this.nUU.getWriteImagesInfo() != null && this.nUU.getWriteImagesInfo().isFromQRCode()) {
            this.nVH.zi(false);
        } else {
            this.nVH.zi(true);
        }
        this.nVG.setAdapter((ListAdapter) this.nVH);
        this.nVG.setOuterOnScrollListener(this);
        this.nVH.a(this.nVt);
        this.nVH.a(this.nVs);
        this.nVH.am(this.nVr);
        this.nVH.setOnOpenCameraFailedListener(this.nVv);
        this.nVH.setOnRequestPermissionListener(this.nVu);
        this.nUW.setOnClickListener(this.ixe);
        this.bIr.setOnClickListener(this.ixe);
        this.bIs.setOnClickListener(this.ixe);
        this.bHJ.setOnClickListener(this.ixe);
        this.bIt.setOnClickListener(this.mOnClickListener);
        this.bHH.setOnClickListener(this.mOnClickListener);
        VX();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gcI != null) {
            if (this.bIt.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bIt.getParent()).removeView(this.bIt);
            }
            this.bIy.setVisibility(8);
            this.gcI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bIt, (View.OnClickListener) null);
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
            this.ixe.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VX() {
        int count;
        String string;
        if (this.nUU != null && this.nUW != null) {
            if (this.nUU.VN()) {
                int i = this.nUU.VN() ? 1 : 0;
                count = i;
                string = this.ixe.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.nUU.VP());
                string = this.ixe.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nUU.getMaxImagesAllowed())});
            }
            this.nUW.setText(string);
            this.nUW.setEnabled(count > 0);
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
        if (this.nUU == null && this.nUQ != null) {
            this.nUU = this.nUQ.dYR();
        }
        if (this.nUU != null) {
            if (!this.nUU.bEO()) {
                this.nVH.notifyDataSetChanged();
            } else {
                VY();
            }
            dg(this.nUU.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VY() {
        if (this.nVE == null) {
            this.nVE = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nVE.a((this.nUQ == null || !this.nUQ.dYS()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.nUU != null && ImageListFragment.this.nVH != null) {
                    ImageListFragment.this.nUU.c(gVar);
                    String VR = ImageListFragment.this.nUU.VR();
                    ImageListFragment.this.nUU.iT(VR);
                    ImageListFragment.this.nVH.setData(ImageListFragment.this.nUU.iV(VR));
                    ImageListFragment.this.nVG.smoothScrollToPosition(0);
                    ImageListFragment.this.VX();
                }
                ImageListFragment.this.nVG.Wa();
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
            if (this.nUQ != null && this.nUQ.Vw() == 1) {
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
        if (this.nVH != null) {
            this.nVH.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nUU != null) {
            dg(this.nUU.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.gcI = navigationBar;
    }

    public View VV() {
        return (this.nUQ == null || this.nUQ.Vw() != 1) ? this.bIs : this.bIr;
    }

    public View VZ() {
        return this.nUW;
    }

    public TbCameraView dYK() {
        if (this.nVH != null) {
            return this.nVH.dYT();
        }
        return null;
    }

    public TransparentHeadGridView dYV() {
        return this.nVG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nVF != null) {
            this.nVF.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nVE != null) {
            this.nVE.cancelLoadTask();
        }
        if (this.ixe != null) {
            this.ixe.closeLoadingDialog();
        }
        if (this.fEW != null) {
            this.fEW.setDialogVisiable(false);
        }
        d.dYO().b(this);
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
            this.nVH.dj(true);
        } else if (this.nVH.isScroll()) {
            this.nVH.dj(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nVG != null) {
            int firstVisiblePosition = this.nVG.getFirstVisiblePosition();
            int lastVisiblePosition = this.nVG.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nVG.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nVH != null) {
                    this.nVH.b((ImageView) childAt.findViewById(R.id.select_icon), z);
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
        if (imageFileInfo != null && this.nVH != null) {
            o(this.nVH.i(imageFileInfo), z);
        }
    }

    public View VI() {
        return this.bHJ;
    }

    public void dg(boolean z) {
        if (this.ixe != null && this.bHJ != null) {
            this.bHJ.setText(this.ixe.getResources().getString(R.string.original_img));
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
        this.nVi = jVar;
    }
}
