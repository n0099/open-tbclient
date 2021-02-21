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
    private NavigationBar gjT;
    private BaseFragmentActivity iKH;
    private boolean isPaused;
    private NoDataView mNoDataView;
    private View mView;
    private j oeE;
    private e oem;
    private c oeq;
    private TBSpecificationBtn oes;
    private com.baidu.tbadk.album.f ofa;
    private com.baidu.tieba.write.view.a ofb;
    private TransparentHeadGridView ofc;
    private i ofd;
    private com.baidu.tbadk.core.view.a fMe = null;
    private View.OnClickListener oeN = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.oeq != null) {
                int maxImagesAllowed = ImageListFragment.this.oeq.getMaxImagesAllowed();
                if (ImageListFragment.this.oeq.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.oem != null) {
                        ImageListFragment.this.oem.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.oeq != null) {
                if (ImageListFragment.this.oeE == null || !ImageListFragment.this.oeE.dXl()) {
                    if (view == ImageListFragment.this.bMg) {
                        ImageListFragment.this.ofb.setData(ImageListFragment.this.oeq.UK(), ImageListFragment.this.oeq.UI());
                        ImageListFragment.this.ofb.O(ImageListFragment.this.gjT == null ? ImageListFragment.this.bMl : ImageListFragment.this.gjT);
                        ImageListFragment.this.bMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsR().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bLs) {
                    }
                }
            }
        }
    };
    private TbCameraView.c oeQ = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean crT() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a oeR = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dXe() {
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
    private g oeO = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.oeq != null && ImageListFragment.this.oeq.getWriteImagesInfo() != null && ImageListFragment.this.oeq.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.oem != null) {
                    ImageListFragment.this.oem.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.oeq != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.oeq.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.oem != null) {
                        ImageListFragment.this.oem.eP(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0904a ofe = new a.InterfaceC0904a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0904a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hV;
            if (ImageListFragment.this.oeq != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.oeq.UI()) && (hV = ImageListFragment.this.oeq.hV(albumId)) != null) {
                    ImageListFragment.this.oeq.hT(albumId);
                    ImageListFragment.this.ofd.setData(hV);
                    ImageListFragment.this.bMg.setText(name);
                    ImageListFragment.this.ofc.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h oeP = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.iKH == null || ImageListFragment.this.oeq == null || ImageListFragment.this.oem == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.b.b.j(imageFileInfo)) {
                    ImageListFragment.this.iKH.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.oeq.isAdded(imageFileInfo)) {
                    ImageListFragment.this.oem.f(imageFileInfo);
                } else {
                    ImageListFragment.this.oem.g(imageFileInfo);
                }
                ImageListFragment.this.oeq.a(null);
                ImageListFragment.this.ofd.notifyDataSetChanged();
                ImageListFragment.this.UO();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.oeq.UD()) {
                    ImageListFragment.this.iKH.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo) && ImageListFragment.this.d(videoFileInfo)) {
                    ImageListFragment.this.oeq.a(videoFileInfo);
                    ImageListFragment.this.oeq.UF();
                    ImageListFragment.this.ofd.notifyDataSetChanged();
                    ImageListFragment.this.oem.Uj();
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
        this.iKH = getBaseFragmentActivity();
        if (this.oem == null) {
            if (this.iKH instanceof AlbumFloatActivity) {
                this.oem = ((AlbumFloatActivity) this.iKH).oem;
            } else if (this.iKH instanceof AlbumActivity) {
                this.oem = ((AlbumActivity) this.iKH).oem;
            }
        }
        if (this.oem != null) {
            this.oeq = this.oem.dWZ();
        }
        d.dWW().a(this);
        this.ofa = new com.baidu.tbadk.album.f(this.iKH);
        this.ofb = new com.baidu.tieba.write.view.a(this.iKH);
        this.ofb.setOnDismissListener(this.mOnDismissListener);
        this.ofb.a(this.ofe);
    }

    public void a(e eVar) {
        this.oem = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iKH = getBaseFragmentActivity();
        if (this.oem == null) {
            if (this.iKH instanceof AlbumFloatActivity) {
                this.oem = ((AlbumFloatActivity) this.iKH).oem;
            } else if (this.iKH instanceof AlbumActivity) {
                this.oem = ((AlbumActivity) this.iKH).oem;
            }
        }
        if (this.oem != null) {
            this.oeq = this.oem.dWZ();
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
        this.oes = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.oes.setTextSize(R.dimen.tbds34);
        this.oes.getStyleConfig().pO(l.getDimens(this.iKH, R.dimen.tbds25));
        this.oeq.hT(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bMg.setText(this.iKH.getPageContext().getString(R.string.album_all_media));
        if (this.oeq.getWriteImagesInfo() != null) {
            this.bLu.setVisibility(this.oeq.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.oeq.getWriteImagesInfo() != null && this.oeq.getWriteImagesInfo().isFromQRCode()) {
            this.bLs.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.iKH.getPageContext().getPageActivity(), this.bMd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aV(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.ofc = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.ofc.setSelector(R.color.transparent);
        this.ofd = new i(this.iKH, this.oeq);
        if (this.oeq.getWriteImagesInfo() != null && this.oeq.getWriteImagesInfo().isFromQRCode()) {
            this.ofd.zB(false);
        } else {
            this.ofd.zB(true);
        }
        this.ofc.setAdapter((ListAdapter) this.ofd);
        this.ofc.setOuterOnScrollListener(this);
        this.ofd.a(this.oeP);
        this.ofd.a(this.oeO);
        this.ofd.ao(this.oeN);
        this.ofd.setOnOpenCameraFailedListener(this.oeR);
        this.ofd.setOnRequestPermissionListener(this.oeQ);
        this.oes.setOnClickListener(this.iKH);
        this.bMe.setOnClickListener(this.iKH);
        this.bMf.setOnClickListener(this.iKH);
        this.bLu.setOnClickListener(this.iKH);
        this.bMg.setOnClickListener(this.mOnClickListener);
        this.bLs.setOnClickListener(this.mOnClickListener);
        UO();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gjT != null) {
            if (this.bMg.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bMg.getParent()).removeView(this.bMg);
            }
            this.bMl.setVisibility(8);
            this.gjT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bMg, (View.OnClickListener) null);
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
            this.iKH.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(VideoFileInfo videoFileInfo) {
        VideoFileInfo Vn = j.Vn(videoFileInfo.videoPath);
        if (Vn != null && Math.max(Vn.videoWidth, Vn.videoHeight) > 4096) {
            this.iKH.showToast(R.string.album_choose_video_resolution_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO() {
        int count;
        String string;
        if (this.oeq != null && this.oes != null) {
            if (this.oeq.UE()) {
                int i = this.oeq.UE() ? 1 : 0;
                string = this.iKH.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = y.getCount(this.oeq.UG());
                string = this.iKH.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.oeq.getMaxImagesAllowed())});
            }
            this.oes.setText(string);
            this.oes.setEnabled(count > 0);
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
        if (this.oeq == null && this.oem != null) {
            this.oeq = this.oem.dWZ();
        }
        if (this.oeq != null) {
            if (!this.oeq.isDataEmpty()) {
                this.ofd.notifyDataSetChanged();
            } else {
                UP();
            }
            dn(this.oeq.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UP() {
        if (this.ofa == null) {
            this.ofa = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.ofa.a((this.oem == null || !this.oem.dXa()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.oeq != null && ImageListFragment.this.ofd != null) {
                    ImageListFragment.this.oeq.c(gVar);
                    String UI = ImageListFragment.this.oeq.UI();
                    ImageListFragment.this.oeq.hT(UI);
                    ImageListFragment.this.ofd.setData(ImageListFragment.this.oeq.hV(UI));
                    if (ImageListFragment.this.ofc != null) {
                        ImageListFragment.this.ofc.smoothScrollToPosition(0);
                    }
                    ImageListFragment.this.UO();
                }
                if (ImageListFragment.this.ofc != null) {
                    ImageListFragment.this.ofc.UR();
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
            if (this.oem != null && this.oem.Un() == 1) {
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
        if (this.ofd != null) {
            this.ofd.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.oeq != null) {
            dn(this.oeq.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.gjT = navigationBar;
    }

    public View UM() {
        return (this.oem == null || this.oem.Un() != 1) ? this.bMf : this.bMe;
    }

    public View UQ() {
        return this.oes;
    }

    public TbCameraView dWS() {
        if (this.ofd != null) {
            return this.ofd.dXb();
        }
        return null;
    }

    public TransparentHeadGridView dXd() {
        return this.ofc;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.ofb != null) {
            this.ofb.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ofa != null) {
            this.ofa.cancelLoadTask();
        }
        if (this.iKH != null) {
            this.iKH.closeLoadingDialog();
        }
        if (this.fMe != null) {
            this.fMe.setDialogVisiable(false);
        }
        d.dWW().b(this);
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
            this.ofd.dq(true);
        } else if (this.ofd.isScroll()) {
            this.ofd.dq(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.ofc != null) {
            int firstVisiblePosition = this.ofc.getFirstVisiblePosition();
            int lastVisiblePosition = this.ofc.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.ofc.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.ofd != null) {
                    this.ofd.b((ImageView) childAt.findViewById(R.id.select_icon), z);
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
        if (imageFileInfo != null && this.ofd != null) {
            o(this.ofd.i(imageFileInfo), z);
        }
    }

    public View Uz() {
        return this.bLu;
    }

    public void dn(boolean z) {
        if (this.iKH != null && this.bLu != null) {
            this.bLu.setText(this.iKH.getResources().getString(R.string.original_img));
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
        this.oeE = jVar;
    }
}
