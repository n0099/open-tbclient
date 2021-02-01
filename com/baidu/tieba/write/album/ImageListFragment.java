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
/* loaded from: classes8.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View bLs;
    private TextView bLu;
    private RelativeLayout bMd;
    private ImageView bMe;
    private TextView bMf;
    private TextView bMg;
    private View bMl;
    private View bMm;
    private NavigationBar gjF;
    private BaseFragmentActivity iKt;
    private boolean isPaused;
    private NoDataView mNoDataView;
    private View mView;
    private e odM;
    private c odQ;
    private TBSpecificationBtn odS;
    private com.baidu.tbadk.album.f oeA;
    private com.baidu.tieba.write.view.a oeB;
    private TransparentHeadGridView oeC;
    private i oeD;
    private j oee;
    private com.baidu.tbadk.core.view.a fMe = null;
    private View.OnClickListener oen = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.odQ != null) {
                int maxImagesAllowed = ImageListFragment.this.odQ.getMaxImagesAllowed();
                if (ImageListFragment.this.odQ.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.odM != null) {
                        ImageListFragment.this.odM.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.odQ != null) {
                if (ImageListFragment.this.oee == null || !ImageListFragment.this.oee.dXd()) {
                    if (view == ImageListFragment.this.bMg) {
                        ImageListFragment.this.oeB.setData(ImageListFragment.this.odQ.UK(), ImageListFragment.this.odQ.UI());
                        ImageListFragment.this.oeB.O(ImageListFragment.this.gjF == null ? ImageListFragment.this.bMl : ImageListFragment.this.gjF);
                        ImageListFragment.this.bMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsR().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bLs) {
                    }
                }
            }
        }
    };
    private TbCameraView.c oeq = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean crM() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a oer = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dWW() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bMg != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.bsR().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bMg.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g oeo = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.odQ != null && ImageListFragment.this.odQ.getWriteImagesInfo() != null && ImageListFragment.this.odQ.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.odM != null) {
                    ImageListFragment.this.odM.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.odQ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.odQ.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.odM != null) {
                        ImageListFragment.this.odM.eP(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0902a oeE = new a.InterfaceC0902a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0902a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hV;
            if (ImageListFragment.this.odQ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.odQ.UI()) && (hV = ImageListFragment.this.odQ.hV(albumId)) != null) {
                    ImageListFragment.this.odQ.hT(albumId);
                    ImageListFragment.this.oeD.setData(hV);
                    ImageListFragment.this.bMg.setText(name);
                    ImageListFragment.this.oeC.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h oep = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.iKt == null || ImageListFragment.this.odQ == null || ImageListFragment.this.odM == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.b.b.j(imageFileInfo)) {
                    ImageListFragment.this.iKt.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.odQ.isAdded(imageFileInfo)) {
                    ImageListFragment.this.odM.f(imageFileInfo);
                } else {
                    ImageListFragment.this.odM.g(imageFileInfo);
                }
                ImageListFragment.this.odQ.a(null);
                ImageListFragment.this.oeD.notifyDataSetChanged();
                ImageListFragment.this.UO();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.odQ.UD()) {
                    ImageListFragment.this.iKt.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo) && ImageListFragment.this.d(videoFileInfo)) {
                    ImageListFragment.this.odQ.a(videoFileInfo);
                    ImageListFragment.this.odQ.UF();
                    ImageListFragment.this.oeD.notifyDataSetChanged();
                    ImageListFragment.this.odM.Uj();
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
        this.iKt = getBaseFragmentActivity();
        if (this.odM == null) {
            if (this.iKt instanceof AlbumFloatActivity) {
                this.odM = ((AlbumFloatActivity) this.iKt).odM;
            } else if (this.iKt instanceof AlbumActivity) {
                this.odM = ((AlbumActivity) this.iKt).odM;
            }
        }
        if (this.odM != null) {
            this.odQ = this.odM.dWR();
        }
        d.dWO().a(this);
        this.oeA = new com.baidu.tbadk.album.f(this.iKt);
        this.oeB = new com.baidu.tieba.write.view.a(this.iKt);
        this.oeB.setOnDismissListener(this.mOnDismissListener);
        this.oeB.a(this.oeE);
    }

    public void a(e eVar) {
        this.odM = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iKt = getBaseFragmentActivity();
        if (this.odM == null) {
            if (this.iKt instanceof AlbumFloatActivity) {
                this.odM = ((AlbumFloatActivity) this.iKt).odM;
            } else if (this.iKt instanceof AlbumActivity) {
                this.odM = ((AlbumActivity) this.iKt).odM;
            }
        }
        if (this.odM != null) {
            this.odQ = this.odM.dWR();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bMd = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bMl = this.mView.findViewById(R.id.layout_title);
        this.bMg = (TextView) this.mView.findViewById(R.id.album_title);
        this.bMe = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bMf = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bMm = this.mView.findViewById(R.id.navi_line);
        this.bLs = this.mView.findViewById(R.id.layout_bottom);
        this.bLu = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.odS = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.odS.setTextSize(R.dimen.tbds34);
        this.odS.getStyleConfig().pO(l.getDimens(this.iKt, R.dimen.tbds25));
        this.odQ.hT(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bMg.setText(this.iKt.getPageContext().getString(R.string.album_all_media));
        if (this.odQ.getWriteImagesInfo() != null) {
            this.bLu.setVisibility(this.odQ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.odQ.getWriteImagesInfo() != null && this.odQ.getWriteImagesInfo().isFromQRCode()) {
            this.bLs.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.iKt.getPageContext().getPageActivity(), this.bMd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aV(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.oeC = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.oeC.setSelector(R.color.transparent);
        this.oeD = new i(this.iKt, this.odQ);
        if (this.odQ.getWriteImagesInfo() != null && this.odQ.getWriteImagesInfo().isFromQRCode()) {
            this.oeD.zB(false);
        } else {
            this.oeD.zB(true);
        }
        this.oeC.setAdapter((ListAdapter) this.oeD);
        this.oeC.setOuterOnScrollListener(this);
        this.oeD.a(this.oep);
        this.oeD.a(this.oeo);
        this.oeD.ao(this.oen);
        this.oeD.setOnOpenCameraFailedListener(this.oer);
        this.oeD.setOnRequestPermissionListener(this.oeq);
        this.odS.setOnClickListener(this.iKt);
        this.bMe.setOnClickListener(this.iKt);
        this.bMf.setOnClickListener(this.iKt);
        this.bLu.setOnClickListener(this.iKt);
        this.bMg.setOnClickListener(this.mOnClickListener);
        this.bLs.setOnClickListener(this.mOnClickListener);
        UO();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gjF != null) {
            if (this.bMg.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bMg.getParent()).removeView(this.bMg);
            }
            this.bMl.setVisibility(8);
            this.gjF.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bMg, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fMe == null) {
            this.fMe = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fMe.setCancelListener(null);
        this.fMe.setTipString(R.string.loading);
        this.fMe.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.iKt.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(VideoFileInfo videoFileInfo) {
        VideoFileInfo Vb = j.Vb(videoFileInfo.videoPath);
        if (Vb != null && Math.max(Vb.videoWidth, Vb.videoHeight) > 4096) {
            this.iKt.showToast(R.string.album_choose_video_resolution_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO() {
        int count;
        String string;
        if (this.odQ != null && this.odS != null) {
            if (this.odQ.UE()) {
                int i = this.odQ.UE() ? 1 : 0;
                string = this.iKt.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = y.getCount(this.odQ.UG());
                string = this.iKt.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.odQ.getMaxImagesAllowed())});
            }
            this.odS.setText(string);
            this.odS.setEnabled(count > 0);
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
            Ut();
        }
    }

    private void Us() {
        if (this.odQ == null && this.odM != null) {
            this.odQ = this.odM.dWR();
        }
        if (this.odQ != null) {
            if (!this.odQ.isDataEmpty()) {
                this.oeD.notifyDataSetChanged();
            } else {
                UP();
            }
            dn(this.odQ.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UP() {
        if (this.oeA == null) {
            this.oeA = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.oeA.a((this.odM == null || !this.odM.dWS()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fMe != null) {
                    ImageListFragment.this.fMe.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.odQ != null && ImageListFragment.this.oeD != null) {
                    ImageListFragment.this.odQ.c(gVar);
                    String UI = ImageListFragment.this.odQ.UI();
                    ImageListFragment.this.odQ.hT(UI);
                    ImageListFragment.this.oeD.setData(ImageListFragment.this.odQ.hV(UI));
                    if (ImageListFragment.this.oeC != null) {
                        ImageListFragment.this.oeC.smoothScrollToPosition(0);
                    }
                    ImageListFragment.this.UO();
                }
                if (ImageListFragment.this.oeC != null) {
                    ImageListFragment.this.oeC.UR();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bMm, R.color.CAM_X0204, i);
        ap.setViewTextColor(this.bMg, R.color.CAM_X0105, i);
        if (this.bMf != null && this.bMe != null) {
            if (this.odM != null && this.odM.Un() == 1) {
                SvgManager.bsR().a(this.bMe, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                this.bMf.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bMf, R.color.navi_back_text_color);
                this.bMe.setVisibility(8);
            }
        }
        if (this.bMg != null) {
            this.bMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsR().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.oeD != null) {
            this.oeD.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.odQ != null) {
            dn(this.odQ.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.gjF = navigationBar;
    }

    public View UM() {
        return (this.odM == null || this.odM.Un() != 1) ? this.bMf : this.bMe;
    }

    public View UQ() {
        return this.odS;
    }

    public TbCameraView dWK() {
        if (this.oeD != null) {
            return this.oeD.dWT();
        }
        return null;
    }

    public TransparentHeadGridView dWV() {
        return this.oeC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.oeB != null) {
            this.oeB.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.oeA != null) {
            this.oeA.cancelLoadTask();
        }
        if (this.iKt != null) {
            this.iKt.closeLoadingDialog();
        }
        if (this.fMe != null) {
            this.fMe.setDialogVisiable(false);
        }
        d.dWO().b(this);
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
        Ut();
    }

    private void Ut() {
        if (!isHidden() && !this.isPaused) {
            Us();
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
            this.oeD.dq(true);
        } else if (this.oeD.isScroll()) {
            this.oeD.dq(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.oeC != null) {
            int firstVisiblePosition = this.oeC.getFirstVisiblePosition();
            int lastVisiblePosition = this.oeC.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.oeC.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.oeD != null) {
                    this.oeD.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        UO();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.oeD != null) {
            o(this.oeD.i(imageFileInfo), z);
        }
    }

    public View Uz() {
        return this.bLu;
    }

    public void dn(boolean z) {
        if (this.iKt != null && this.bLu != null) {
            this.bLu.setText(this.iKt.getResources().getString(R.string.original_img));
            if (z) {
                this.bLu.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.bLu, R.color.CAM_X0302);
                return;
            }
            this.bLu.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.bLu, R.color.CAM_X0106);
        }
    }

    public void a(j jVar) {
        this.oee = jVar;
    }
}
