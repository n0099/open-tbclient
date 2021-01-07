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
/* loaded from: classes8.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View bMu;
    private TextView bMw;
    private RelativeLayout bNf;
    private ImageView bNg;
    private TextView bNh;
    private TextView bNi;
    private View bNn;
    private View bNo;
    private NavigationBar glZ;
    private BaseFragmentActivity iJr;
    private boolean isPaused;
    private NoDataView mNoDataView;
    private View mView;
    private j nYC;
    private com.baidu.tbadk.album.f nYY;
    private com.baidu.tieba.write.view.a nYZ;
    private e nYk;
    private c nYo;
    private TBSpecificationBtn nYq;
    private TransparentHeadGridView nZa;
    private i nZb;
    private com.baidu.tbadk.core.view.a fOA = null;
    private View.OnClickListener nYL = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nYo != null) {
                int maxImagesAllowed = ImageListFragment.this.nYo.getMaxImagesAllowed();
                if (ImageListFragment.this.nYo.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nYk != null) {
                        ImageListFragment.this.nYk.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nYo != null) {
                if (ImageListFragment.this.nYC == null || !ImageListFragment.this.nYC.dYH()) {
                    if (view == ImageListFragment.this.bNi) {
                        ImageListFragment.this.nYZ.c(ImageListFragment.this.nYo.WW(), ImageListFragment.this.nYo.WU());
                        ImageListFragment.this.nYZ.O(ImageListFragment.this.glZ == null ? ImageListFragment.this.bNn : ImageListFragment.this.glZ);
                        ImageListFragment.this.bNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwr().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bMu) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nYO = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cuu() {
            return !ad.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nYP = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dYA() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bNi != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.bwr().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bNi.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nYM = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nYo != null && ImageListFragment.this.nYo.getWriteImagesInfo() != null && ImageListFragment.this.nYo.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nYk != null) {
                    ImageListFragment.this.nYk.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nYo != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nYo.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nYk != null) {
                        ImageListFragment.this.nYk.gs(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0916a nZc = new a.InterfaceC0916a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0916a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> iK;
            if (ImageListFragment.this.nYo != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nYo.WU()) && (iK = ImageListFragment.this.nYo.iK(albumId)) != null) {
                    ImageListFragment.this.nYo.iI(albumId);
                    ImageListFragment.this.nZb.setData(iK);
                    ImageListFragment.this.bNi.setText(name);
                    ImageListFragment.this.nZa.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nYN = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.iJr == null || ImageListFragment.this.nYo == null || ImageListFragment.this.nYk == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.b.b.j(imageFileInfo)) {
                    ImageListFragment.this.iJr.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.nYo.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nYk.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nYk.g(imageFileInfo);
                }
                ImageListFragment.this.nYo.a(null);
                ImageListFragment.this.nZb.notifyDataSetChanged();
                ImageListFragment.this.Xa();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nYo.WP()) {
                    ImageListFragment.this.iJr.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nYo.a(videoFileInfo);
                    ImageListFragment.this.nYo.WR();
                    ImageListFragment.this.nZb.notifyDataSetChanged();
                    ImageListFragment.this.nYk.Wv();
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
        this.iJr = getBaseFragmentActivity();
        if (this.nYk == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYk = ((AlbumFloatActivity) this.iJr).nYk;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYk = ((AlbumActivity) this.iJr).nYk;
            }
        }
        if (this.nYk != null) {
            this.nYo = this.nYk.dYv();
        }
        d.dYs().a(this);
        this.nYY = new com.baidu.tbadk.album.f(this.iJr);
        this.nYZ = new com.baidu.tieba.write.view.a(this.iJr);
        this.nYZ.setOnDismissListener(this.mOnDismissListener);
        this.nYZ.a(this.nZc);
    }

    public void a(e eVar) {
        this.nYk = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iJr = getBaseFragmentActivity();
        if (this.nYk == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYk = ((AlbumFloatActivity) this.iJr).nYk;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYk = ((AlbumActivity) this.iJr).nYk;
            }
        }
        if (this.nYk != null) {
            this.nYo = this.nYk.dYv();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bNf = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bNn = this.mView.findViewById(R.id.layout_title);
        this.bNi = (TextView) this.mView.findViewById(R.id.album_title);
        this.bNg = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bNh = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bNo = this.mView.findViewById(R.id.navi_line);
        this.bMu = this.mView.findViewById(R.id.layout_bottom);
        this.bMw = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.nYq = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nYq.setTextSize(R.dimen.tbds34);
        this.nYq.getStyleConfig().rp(l.getDimens(this.iJr, R.dimen.tbds25));
        this.nYo.iI(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bNi.setText(this.iJr.getPageContext().getString(R.string.album_all_media));
        if (this.nYo.getWriteImagesInfo() != null) {
            this.bMw.setVisibility(this.nYo.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nYo.getWriteImagesInfo() != null && this.nYo.getWriteImagesInfo().isFromQRCode()) {
            this.bMu.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.iJr.getPageContext().getPageActivity(), this.bNf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nZa = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nZa.setSelector(R.color.transparent);
        this.nZb = new i(this.iJr, this.nYo);
        if (this.nYo.getWriteImagesInfo() != null && this.nYo.getWriteImagesInfo().isFromQRCode()) {
            this.nZb.zj(false);
        } else {
            this.nZb.zj(true);
        }
        this.nZa.setAdapter((ListAdapter) this.nZb);
        this.nZa.setOuterOnScrollListener(this);
        this.nZb.a(this.nYN);
        this.nZb.a(this.nYM);
        this.nZb.ao(this.nYL);
        this.nZb.setOnOpenCameraFailedListener(this.nYP);
        this.nZb.setOnRequestPermissionListener(this.nYO);
        this.nYq.setOnClickListener(this.iJr);
        this.bNg.setOnClickListener(this.iJr);
        this.bNh.setOnClickListener(this.iJr);
        this.bMw.setOnClickListener(this.iJr);
        this.bNi.setOnClickListener(this.mOnClickListener);
        this.bMu.setOnClickListener(this.mOnClickListener);
        Xa();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.glZ != null) {
            if (this.bNi.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bNi.getParent()).removeView(this.bNi);
            }
            this.bNn.setVisibility(8);
            this.glZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bNi, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fOA == null) {
            this.fOA = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fOA.setCancelListener(null);
        this.fOA.setTipString(R.string.loading);
        this.fOA.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.iJr.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        int count;
        String string;
        if (this.nYo != null && this.nYq != null) {
            if (this.nYo.WQ()) {
                int i = this.nYo.WQ() ? 1 : 0;
                string = this.iJr.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = x.getCount(this.nYo.WS());
                string = this.iJr.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nYo.getMaxImagesAllowed())});
            }
            this.nYq.setText(string);
            this.nYq.setEnabled(count > 0);
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
            WF();
        }
    }

    private void WE() {
        if (this.nYo == null && this.nYk != null) {
            this.nYo = this.nYk.dYv();
        }
        if (this.nYo != null) {
            if (!this.nYo.isDataEmpty()) {
                this.nZb.notifyDataSetChanged();
            } else {
                Xb();
            }
            dj(this.nYo.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xb() {
        if (this.nYY == null) {
            this.nYY = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nYY.a((this.nYk == null || !this.nYk.dYw()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fOA != null) {
                    ImageListFragment.this.fOA.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.nYo != null && ImageListFragment.this.nZb != null) {
                    ImageListFragment.this.nYo.c(gVar);
                    String WU = ImageListFragment.this.nYo.WU();
                    ImageListFragment.this.nYo.iI(WU);
                    ImageListFragment.this.nZb.setData(ImageListFragment.this.nYo.iK(WU));
                    if (ImageListFragment.this.nZa != null) {
                        ImageListFragment.this.nZa.smoothScrollToPosition(0);
                    }
                    ImageListFragment.this.Xa();
                }
                if (ImageListFragment.this.nZa != null) {
                    ImageListFragment.this.nZa.Xd();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ao.setBackgroundColor(this.bNo, R.color.CAM_X0204, i);
        ao.setViewTextColor(this.bNi, R.color.CAM_X0105, i);
        if (this.bNh != null && this.bNg != null) {
            if (this.nYk != null && this.nYk.Wz() == 1) {
                SvgManager.bwr().a(this.bNg, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                this.bNh.setVisibility(8);
            } else {
                ao.setViewTextColor(this.bNh, R.color.navi_back_text_color);
                this.bNg.setVisibility(8);
            }
        }
        if (this.bNi != null) {
            this.bNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwr().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nZb != null) {
            this.nZb.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nYo != null) {
            dj(this.nYo.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.glZ = navigationBar;
    }

    public View WY() {
        return (this.nYk == null || this.nYk.Wz() != 1) ? this.bNh : this.bNg;
    }

    public View Xc() {
        return this.nYq;
    }

    public TbCameraView dYo() {
        if (this.nZb != null) {
            return this.nZb.dYx();
        }
        return null;
    }

    public TransparentHeadGridView dYz() {
        return this.nZa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nYZ != null) {
            this.nYZ.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nYY != null) {
            this.nYY.cancelLoadTask();
        }
        if (this.iJr != null) {
            this.iJr.closeLoadingDialog();
        }
        if (this.fOA != null) {
            this.fOA.setDialogVisiable(false);
        }
        d.dYs().b(this);
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
    public void dl(boolean z) {
        WF();
    }

    private void WF() {
        if (!isHidden() && !this.isPaused) {
            WE();
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
            this.nZb.dm(true);
        } else if (this.nZb.isScroll()) {
            this.nZb.dm(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nZa != null) {
            int firstVisiblePosition = this.nZa.getFirstVisiblePosition();
            int lastVisiblePosition = this.nZa.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nZa.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nZb != null) {
                    this.nZb.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Xa();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nZb != null) {
            o(this.nZb.i(imageFileInfo), z);
        }
    }

    public View WL() {
        return this.bMw;
    }

    public void dj(boolean z) {
        if (this.iJr != null && this.bMw != null) {
            this.bMw.setText(this.iJr.getResources().getString(R.string.original_img));
            if (z) {
                this.bMw.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                ao.setViewTextColor(this.bMw, R.color.CAM_X0302);
                return;
            }
            this.bMw.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.bMw, R.color.CAM_X0106);
        }
    }

    public void a(j jVar) {
        this.nYC = jVar;
    }
}
