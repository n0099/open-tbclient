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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private View bHI;
    private TextView bHK;
    private View bIB;
    private View bIC;
    private RelativeLayout bIt;
    private ImageView bIu;
    private TextView bIv;
    private TextView bIw;
    private NavigationBar ghr;
    private BaseFragmentActivity iEK;
    private boolean isPaused;
    private NoDataView mNoDataView;
    private View mView;
    private e nTG;
    private c nTK;
    private TBSpecificationBtn nTM;
    private j nTY;
    private com.baidu.tbadk.album.f nUu;
    private com.baidu.tieba.write.view.a nUv;
    private TransparentHeadGridView nUw;
    private i nUx;
    private com.baidu.tbadk.core.view.a fJT = null;
    private View.OnClickListener nUh = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nTK != null) {
                int maxImagesAllowed = ImageListFragment.this.nTK.getMaxImagesAllowed();
                if (ImageListFragment.this.nTK.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nTG != null) {
                        ImageListFragment.this.nTG.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nTK != null) {
                if (ImageListFragment.this.nTY == null || !ImageListFragment.this.nTY.dUP()) {
                    if (view == ImageListFragment.this.bIw) {
                        ImageListFragment.this.nUv.c(ImageListFragment.this.nTK.Td(), ImageListFragment.this.nTK.Tb());
                        ImageListFragment.this.nUv.O(ImageListFragment.this.ghr == null ? ImageListFragment.this.bIB : ImageListFragment.this.ghr);
                        ImageListFragment.this.bIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsx().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bHI) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nUk = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cqC() {
            return !ad.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nUl = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dUI() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bIw != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.bsx().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bIw.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nUi = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nTK != null && ImageListFragment.this.nTK.getWriteImagesInfo() != null && ImageListFragment.this.nTK.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nTG != null) {
                    ImageListFragment.this.nTG.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nTK != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nTK.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nTG != null) {
                        ImageListFragment.this.nTG.eL(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0899a nUy = new a.InterfaceC0899a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0899a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hz;
            if (ImageListFragment.this.nTK != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nTK.Tb()) && (hz = ImageListFragment.this.nTK.hz(albumId)) != null) {
                    ImageListFragment.this.nTK.hx(albumId);
                    ImageListFragment.this.nUx.setData(hz);
                    ImageListFragment.this.bIw.setText(name);
                    ImageListFragment.this.nUw.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nUj = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.iEK == null || ImageListFragment.this.nTK == null || ImageListFragment.this.nTG == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.b.b.j(imageFileInfo)) {
                    ImageListFragment.this.iEK.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.nTK.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nTG.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nTG.g(imageFileInfo);
                }
                ImageListFragment.this.nTK.a(null);
                ImageListFragment.this.nUx.notifyDataSetChanged();
                ImageListFragment.this.Th();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nTK.SW()) {
                    ImageListFragment.this.iEK.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nTK.a(videoFileInfo);
                    ImageListFragment.this.nTK.SY();
                    ImageListFragment.this.nUx.notifyDataSetChanged();
                    ImageListFragment.this.nTG.SC();
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
        this.iEK = getBaseFragmentActivity();
        if (this.nTG == null) {
            if (this.iEK instanceof AlbumFloatActivity) {
                this.nTG = ((AlbumFloatActivity) this.iEK).nTG;
            } else if (this.iEK instanceof AlbumActivity) {
                this.nTG = ((AlbumActivity) this.iEK).nTG;
            }
        }
        if (this.nTG != null) {
            this.nTK = this.nTG.dUD();
        }
        d.dUA().a(this);
        this.nUu = new com.baidu.tbadk.album.f(this.iEK);
        this.nUv = new com.baidu.tieba.write.view.a(this.iEK);
        this.nUv.setOnDismissListener(this.mOnDismissListener);
        this.nUv.a(this.nUy);
    }

    public void a(e eVar) {
        this.nTG = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iEK = getBaseFragmentActivity();
        if (this.nTG == null) {
            if (this.iEK instanceof AlbumFloatActivity) {
                this.nTG = ((AlbumFloatActivity) this.iEK).nTG;
            } else if (this.iEK instanceof AlbumActivity) {
                this.nTG = ((AlbumActivity) this.iEK).nTG;
            }
        }
        if (this.nTG != null) {
            this.nTK = this.nTG.dUD();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bIt = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bIB = this.mView.findViewById(R.id.layout_title);
        this.bIw = (TextView) this.mView.findViewById(R.id.album_title);
        this.bIu = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bIv = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bIC = this.mView.findViewById(R.id.navi_line);
        this.bHI = this.mView.findViewById(R.id.layout_bottom);
        this.bHK = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.nTM = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nTM.setTextSize(R.dimen.tbds34);
        this.nTM.getStyleConfig().pJ(l.getDimens(this.iEK, R.dimen.tbds25));
        this.nTK.hx(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bIw.setText(this.iEK.getPageContext().getString(R.string.album_all_media));
        if (this.nTK.getWriteImagesInfo() != null) {
            this.bHK.setVisibility(this.nTK.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nTK.getWriteImagesInfo() != null && this.nTK.getWriteImagesInfo().isFromQRCode()) {
            this.bHI.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.iEK.getPageContext().getPageActivity(), this.bIt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nUw = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nUw.setSelector(R.color.transparent);
        this.nUx = new i(this.iEK, this.nTK);
        if (this.nTK.getWriteImagesInfo() != null && this.nTK.getWriteImagesInfo().isFromQRCode()) {
            this.nUx.zf(false);
        } else {
            this.nUx.zf(true);
        }
        this.nUw.setAdapter((ListAdapter) this.nUx);
        this.nUw.setOuterOnScrollListener(this);
        this.nUx.a(this.nUj);
        this.nUx.a(this.nUi);
        this.nUx.ao(this.nUh);
        this.nUx.setOnOpenCameraFailedListener(this.nUl);
        this.nUx.setOnRequestPermissionListener(this.nUk);
        this.nTM.setOnClickListener(this.iEK);
        this.bIu.setOnClickListener(this.iEK);
        this.bIv.setOnClickListener(this.iEK);
        this.bHK.setOnClickListener(this.iEK);
        this.bIw.setOnClickListener(this.mOnClickListener);
        this.bHI.setOnClickListener(this.mOnClickListener);
        Th();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ghr != null) {
            if (this.bIw.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bIw.getParent()).removeView(this.bIw);
            }
            this.bIB.setVisibility(8);
            this.ghr.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bIw, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fJT == null) {
            this.fJT = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fJT.setCancelListener(null);
        this.fJT.setTipString(R.string.loading);
        this.fJT.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.iEK.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        int count;
        String string;
        if (this.nTK != null && this.nTM != null) {
            if (this.nTK.SX()) {
                int i = this.nTK.SX() ? 1 : 0;
                string = this.iEK.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = x.getCount(this.nTK.SZ());
                string = this.iEK.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nTK.getMaxImagesAllowed())});
            }
            this.nTM.setText(string);
            this.nTM.setEnabled(count > 0);
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
            SM();
        }
    }

    private void SL() {
        if (this.nTK == null && this.nTG != null) {
            this.nTK = this.nTG.dUD();
        }
        if (this.nTK != null) {
            if (!this.nTK.isDataEmpty()) {
                this.nUx.notifyDataSetChanged();
            } else {
                Ti();
            }
            df(this.nTK.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ti() {
        if (this.nUu == null) {
            this.nUu = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nUu.a((this.nTG == null || !this.nTG.dUE()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fJT != null) {
                    ImageListFragment.this.fJT.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.nTK != null && ImageListFragment.this.nUx != null) {
                    ImageListFragment.this.nTK.c(gVar);
                    String Tb = ImageListFragment.this.nTK.Tb();
                    ImageListFragment.this.nTK.hx(Tb);
                    ImageListFragment.this.nUx.setData(ImageListFragment.this.nTK.hz(Tb));
                    if (ImageListFragment.this.nUw != null) {
                        ImageListFragment.this.nUw.smoothScrollToPosition(0);
                    }
                    ImageListFragment.this.Th();
                }
                if (ImageListFragment.this.nUw != null) {
                    ImageListFragment.this.nUw.Tk();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ao.setBackgroundColor(this.bIC, R.color.CAM_X0204, i);
        ao.setViewTextColor(this.bIw, R.color.CAM_X0105, i);
        if (this.bIv != null && this.bIu != null) {
            if (this.nTG != null && this.nTG.SG() == 1) {
                SvgManager.bsx().a(this.bIu, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                this.bIv.setVisibility(8);
            } else {
                ao.setViewTextColor(this.bIv, R.color.navi_back_text_color);
                this.bIu.setVisibility(8);
            }
        }
        if (this.bIw != null) {
            this.bIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsx().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nUx != null) {
            this.nUx.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nTK != null) {
            df(this.nTK.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.ghr = navigationBar;
    }

    public View Tf() {
        return (this.nTG == null || this.nTG.SG() != 1) ? this.bIv : this.bIu;
    }

    public View Tj() {
        return this.nTM;
    }

    public TbCameraView dUw() {
        if (this.nUx != null) {
            return this.nUx.dUF();
        }
        return null;
    }

    public TransparentHeadGridView dUH() {
        return this.nUw;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nUv != null) {
            this.nUv.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nUu != null) {
            this.nUu.cancelLoadTask();
        }
        if (this.iEK != null) {
            this.iEK.closeLoadingDialog();
        }
        if (this.fJT != null) {
            this.fJT.setDialogVisiable(false);
        }
        d.dUA().b(this);
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
    public void dh(boolean z) {
        SM();
    }

    private void SM() {
        if (!isHidden() && !this.isPaused) {
            SL();
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
            this.nUx.di(true);
        } else if (this.nUx.isScroll()) {
            this.nUx.di(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nUw != null) {
            int firstVisiblePosition = this.nUw.getFirstVisiblePosition();
            int lastVisiblePosition = this.nUw.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nUw.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nUx != null) {
                    this.nUx.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Th();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nUx != null) {
            o(this.nUx.i(imageFileInfo), z);
        }
    }

    public View SS() {
        return this.bHK;
    }

    public void df(boolean z) {
        if (this.iEK != null && this.bHK != null) {
            this.bHK.setText(this.iEK.getResources().getString(R.string.original_img));
            if (z) {
                this.bHK.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                ao.setViewTextColor(this.bHK, R.color.CAM_X0302);
                return;
            }
            this.bHK.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.bHK, R.color.CAM_X0106);
        }
    }

    public void a(j jVar) {
        this.nTY = jVar;
    }
}
