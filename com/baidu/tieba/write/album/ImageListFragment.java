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
    private e nTF;
    private c nTJ;
    private TBSpecificationBtn nTL;
    private j nTX;
    private com.baidu.tbadk.album.f nUt;
    private com.baidu.tieba.write.view.a nUu;
    private TransparentHeadGridView nUv;
    private i nUw;
    private com.baidu.tbadk.core.view.a fJT = null;
    private View.OnClickListener nUg = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nTJ != null) {
                int maxImagesAllowed = ImageListFragment.this.nTJ.getMaxImagesAllowed();
                if (ImageListFragment.this.nTJ.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nTF != null) {
                        ImageListFragment.this.nTF.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nTJ != null) {
                if (ImageListFragment.this.nTX == null || !ImageListFragment.this.nTX.dUP()) {
                    if (view == ImageListFragment.this.bIw) {
                        ImageListFragment.this.nUu.c(ImageListFragment.this.nTJ.Td(), ImageListFragment.this.nTJ.Tb());
                        ImageListFragment.this.nUu.O(ImageListFragment.this.ghr == null ? ImageListFragment.this.bIB : ImageListFragment.this.ghr);
                        ImageListFragment.this.bIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsx().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bHI) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nUj = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cqC() {
            return !ad.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nUk = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
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
    private g nUh = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nTJ != null && ImageListFragment.this.nTJ.getWriteImagesInfo() != null && ImageListFragment.this.nTJ.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nTF != null) {
                    ImageListFragment.this.nTF.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nTJ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nTJ.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nTF != null) {
                        ImageListFragment.this.nTF.eL(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0899a nUx = new a.InterfaceC0899a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0899a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hz;
            if (ImageListFragment.this.nTJ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nTJ.Tb()) && (hz = ImageListFragment.this.nTJ.hz(albumId)) != null) {
                    ImageListFragment.this.nTJ.hx(albumId);
                    ImageListFragment.this.nUw.setData(hz);
                    ImageListFragment.this.bIw.setText(name);
                    ImageListFragment.this.nUv.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nUi = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.iEK == null || ImageListFragment.this.nTJ == null || ImageListFragment.this.nTF == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.b.b.j(imageFileInfo)) {
                    ImageListFragment.this.iEK.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.nTJ.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nTF.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nTF.g(imageFileInfo);
                }
                ImageListFragment.this.nTJ.a(null);
                ImageListFragment.this.nUw.notifyDataSetChanged();
                ImageListFragment.this.Th();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nTJ.SW()) {
                    ImageListFragment.this.iEK.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nTJ.a(videoFileInfo);
                    ImageListFragment.this.nTJ.SY();
                    ImageListFragment.this.nUw.notifyDataSetChanged();
                    ImageListFragment.this.nTF.SC();
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
        if (this.nTF == null) {
            if (this.iEK instanceof AlbumFloatActivity) {
                this.nTF = ((AlbumFloatActivity) this.iEK).nTF;
            } else if (this.iEK instanceof AlbumActivity) {
                this.nTF = ((AlbumActivity) this.iEK).nTF;
            }
        }
        if (this.nTF != null) {
            this.nTJ = this.nTF.dUD();
        }
        d.dUA().a(this);
        this.nUt = new com.baidu.tbadk.album.f(this.iEK);
        this.nUu = new com.baidu.tieba.write.view.a(this.iEK);
        this.nUu.setOnDismissListener(this.mOnDismissListener);
        this.nUu.a(this.nUx);
    }

    public void a(e eVar) {
        this.nTF = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iEK = getBaseFragmentActivity();
        if (this.nTF == null) {
            if (this.iEK instanceof AlbumFloatActivity) {
                this.nTF = ((AlbumFloatActivity) this.iEK).nTF;
            } else if (this.iEK instanceof AlbumActivity) {
                this.nTF = ((AlbumActivity) this.iEK).nTF;
            }
        }
        if (this.nTF != null) {
            this.nTJ = this.nTF.dUD();
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
        this.nTL = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nTL.setTextSize(R.dimen.tbds34);
        this.nTL.getStyleConfig().pJ(l.getDimens(this.iEK, R.dimen.tbds25));
        this.nTJ.hx(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bIw.setText(this.iEK.getPageContext().getString(R.string.album_all_media));
        if (this.nTJ.getWriteImagesInfo() != null) {
            this.bHK.setVisibility(this.nTJ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nTJ.getWriteImagesInfo() != null && this.nTJ.getWriteImagesInfo().isFromQRCode()) {
            this.bHI.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.iEK.getPageContext().getPageActivity(), this.bIt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nUv = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nUv.setSelector(R.color.transparent);
        this.nUw = new i(this.iEK, this.nTJ);
        if (this.nTJ.getWriteImagesInfo() != null && this.nTJ.getWriteImagesInfo().isFromQRCode()) {
            this.nUw.zf(false);
        } else {
            this.nUw.zf(true);
        }
        this.nUv.setAdapter((ListAdapter) this.nUw);
        this.nUv.setOuterOnScrollListener(this);
        this.nUw.a(this.nUi);
        this.nUw.a(this.nUh);
        this.nUw.ao(this.nUg);
        this.nUw.setOnOpenCameraFailedListener(this.nUk);
        this.nUw.setOnRequestPermissionListener(this.nUj);
        this.nTL.setOnClickListener(this.iEK);
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
        if (this.nTJ != null && this.nTL != null) {
            if (this.nTJ.SX()) {
                int i = this.nTJ.SX() ? 1 : 0;
                string = this.iEK.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = x.getCount(this.nTJ.SZ());
                string = this.iEK.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nTJ.getMaxImagesAllowed())});
            }
            this.nTL.setText(string);
            this.nTL.setEnabled(count > 0);
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
        if (this.nTJ == null && this.nTF != null) {
            this.nTJ = this.nTF.dUD();
        }
        if (this.nTJ != null) {
            if (!this.nTJ.isDataEmpty()) {
                this.nUw.notifyDataSetChanged();
            } else {
                Ti();
            }
            df(this.nTJ.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ti() {
        if (this.nUt == null) {
            this.nUt = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nUt.a((this.nTF == null || !this.nTF.dUE()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.nTJ != null && ImageListFragment.this.nUw != null) {
                    ImageListFragment.this.nTJ.c(gVar);
                    String Tb = ImageListFragment.this.nTJ.Tb();
                    ImageListFragment.this.nTJ.hx(Tb);
                    ImageListFragment.this.nUw.setData(ImageListFragment.this.nTJ.hz(Tb));
                    if (ImageListFragment.this.nUv != null) {
                        ImageListFragment.this.nUv.smoothScrollToPosition(0);
                    }
                    ImageListFragment.this.Th();
                }
                if (ImageListFragment.this.nUv != null) {
                    ImageListFragment.this.nUv.Tk();
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
            if (this.nTF != null && this.nTF.SG() == 1) {
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
        if (this.nUw != null) {
            this.nUw.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nTJ != null) {
            df(this.nTJ.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.ghr = navigationBar;
    }

    public View Tf() {
        return (this.nTF == null || this.nTF.SG() != 1) ? this.bIv : this.bIu;
    }

    public View Tj() {
        return this.nTL;
    }

    public TbCameraView dUw() {
        if (this.nUw != null) {
            return this.nUw.dUF();
        }
        return null;
    }

    public TransparentHeadGridView dUH() {
        return this.nUv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nUu != null) {
            this.nUu.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nUt != null) {
            this.nUt.cancelLoadTask();
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
            this.nUw.di(true);
        } else if (this.nUw.isScroll()) {
            this.nUw.di(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nUv != null) {
            int firstVisiblePosition = this.nUv.getFirstVisiblePosition();
            int lastVisiblePosition = this.nUv.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nUv.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nUw != null) {
                    this.nUw.b((ImageView) childAt.findViewById(R.id.select_icon), z);
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
        if (imageFileInfo != null && this.nUw != null) {
            o(this.nUw.i(imageFileInfo), z);
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
        this.nTX = jVar;
    }
}
