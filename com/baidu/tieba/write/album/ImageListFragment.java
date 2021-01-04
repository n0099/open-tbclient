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
    private j nYD;
    private com.baidu.tbadk.album.f nYZ;
    private e nYl;
    private c nYp;
    private TBSpecificationBtn nYr;
    private com.baidu.tieba.write.view.a nZa;
    private TransparentHeadGridView nZb;
    private i nZc;
    private com.baidu.tbadk.core.view.a fOA = null;
    private View.OnClickListener nYM = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nYp != null) {
                int maxImagesAllowed = ImageListFragment.this.nYp.getMaxImagesAllowed();
                if (ImageListFragment.this.nYp.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nYl != null) {
                        ImageListFragment.this.nYl.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nYp != null) {
                if (ImageListFragment.this.nYD == null || !ImageListFragment.this.nYD.dYG()) {
                    if (view == ImageListFragment.this.bNi) {
                        ImageListFragment.this.nZa.c(ImageListFragment.this.nYp.WV(), ImageListFragment.this.nYp.WT());
                        ImageListFragment.this.nZa.O(ImageListFragment.this.glZ == null ? ImageListFragment.this.bNn : ImageListFragment.this.glZ);
                        ImageListFragment.this.bNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwq().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bMu) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nYP = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cut() {
            return !ad.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nYQ = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dYz() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bNi != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.bwq().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bNi.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nYN = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nYp != null && ImageListFragment.this.nYp.getWriteImagesInfo() != null && ImageListFragment.this.nYp.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nYl != null) {
                    ImageListFragment.this.nYl.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nYp != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nYp.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nYl != null) {
                        ImageListFragment.this.nYl.gs(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0878a nZd = new a.InterfaceC0878a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0878a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> iK;
            if (ImageListFragment.this.nYp != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nYp.WT()) && (iK = ImageListFragment.this.nYp.iK(albumId)) != null) {
                    ImageListFragment.this.nYp.iI(albumId);
                    ImageListFragment.this.nZc.setData(iK);
                    ImageListFragment.this.bNi.setText(name);
                    ImageListFragment.this.nZb.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nYO = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.iJr == null || ImageListFragment.this.nYp == null || ImageListFragment.this.nYl == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (com.baidu.tieba.write.b.b.j(imageFileInfo)) {
                    ImageListFragment.this.iJr.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.nYp.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nYl.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nYl.g(imageFileInfo);
                }
                ImageListFragment.this.nYp.a(null);
                ImageListFragment.this.nZc.notifyDataSetChanged();
                ImageListFragment.this.WZ();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nYp.WO()) {
                    ImageListFragment.this.iJr.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nYp.a(videoFileInfo);
                    ImageListFragment.this.nYp.WQ();
                    ImageListFragment.this.nZc.notifyDataSetChanged();
                    ImageListFragment.this.nYl.Wu();
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
        if (this.nYl == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYl = ((AlbumFloatActivity) this.iJr).nYl;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYl = ((AlbumActivity) this.iJr).nYl;
            }
        }
        if (this.nYl != null) {
            this.nYp = this.nYl.dYu();
        }
        d.dYr().a(this);
        this.nYZ = new com.baidu.tbadk.album.f(this.iJr);
        this.nZa = new com.baidu.tieba.write.view.a(this.iJr);
        this.nZa.setOnDismissListener(this.mOnDismissListener);
        this.nZa.a(this.nZd);
    }

    public void a(e eVar) {
        this.nYl = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iJr = getBaseFragmentActivity();
        if (this.nYl == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYl = ((AlbumFloatActivity) this.iJr).nYl;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYl = ((AlbumActivity) this.iJr).nYl;
            }
        }
        if (this.nYl != null) {
            this.nYp = this.nYl.dYu();
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
        this.nYr = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nYr.setTextSize(R.dimen.tbds34);
        this.nYr.getStyleConfig().rp(l.getDimens(this.iJr, R.dimen.tbds25));
        this.nYp.iI(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bNi.setText(this.iJr.getPageContext().getString(R.string.album_all_media));
        if (this.nYp.getWriteImagesInfo() != null) {
            this.bMw.setVisibility(this.nYp.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nYp.getWriteImagesInfo() != null && this.nYp.getWriteImagesInfo().isFromQRCode()) {
            this.bMu.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.iJr.getPageContext().getPageActivity(), this.bNf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nZb = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nZb.setSelector(R.color.transparent);
        this.nZc = new i(this.iJr, this.nYp);
        if (this.nYp.getWriteImagesInfo() != null && this.nYp.getWriteImagesInfo().isFromQRCode()) {
            this.nZc.zj(false);
        } else {
            this.nZc.zj(true);
        }
        this.nZb.setAdapter((ListAdapter) this.nZc);
        this.nZb.setOuterOnScrollListener(this);
        this.nZc.a(this.nYO);
        this.nZc.a(this.nYN);
        this.nZc.ao(this.nYM);
        this.nZc.setOnOpenCameraFailedListener(this.nYQ);
        this.nZc.setOnRequestPermissionListener(this.nYP);
        this.nYr.setOnClickListener(this.iJr);
        this.bNg.setOnClickListener(this.iJr);
        this.bNh.setOnClickListener(this.iJr);
        this.bMw.setOnClickListener(this.iJr);
        this.bNi.setOnClickListener(this.mOnClickListener);
        this.bMu.setOnClickListener(this.mOnClickListener);
        WZ();
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
    public void WZ() {
        int count;
        String string;
        if (this.nYp != null && this.nYr != null) {
            if (this.nYp.WP()) {
                int i = this.nYp.WP() ? 1 : 0;
                string = this.iJr.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = x.getCount(this.nYp.WR());
                string = this.iJr.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nYp.getMaxImagesAllowed())});
            }
            this.nYr.setText(string);
            this.nYr.setEnabled(count > 0);
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
            WE();
        }
    }

    private void WD() {
        if (this.nYp == null && this.nYl != null) {
            this.nYp = this.nYl.dYu();
        }
        if (this.nYp != null) {
            if (!this.nYp.isDataEmpty()) {
                this.nZc.notifyDataSetChanged();
            } else {
                Xa();
            }
            dj(this.nYp.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xa() {
        if (this.nYZ == null) {
            this.nYZ = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nYZ.a((this.nYl == null || !this.nYl.dYv()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.nYp != null && ImageListFragment.this.nZc != null) {
                    ImageListFragment.this.nYp.c(gVar);
                    String WT = ImageListFragment.this.nYp.WT();
                    ImageListFragment.this.nYp.iI(WT);
                    ImageListFragment.this.nZc.setData(ImageListFragment.this.nYp.iK(WT));
                    if (ImageListFragment.this.nZb != null) {
                        ImageListFragment.this.nZb.smoothScrollToPosition(0);
                    }
                    ImageListFragment.this.WZ();
                }
                if (ImageListFragment.this.nZb != null) {
                    ImageListFragment.this.nZb.Xc();
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
            if (this.nYl != null && this.nYl.Wy() == 1) {
                SvgManager.bwq().a(this.bNg, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                this.bNh.setVisibility(8);
            } else {
                ao.setViewTextColor(this.bNh, R.color.navi_back_text_color);
                this.bNg.setVisibility(8);
            }
        }
        if (this.bNi != null) {
            this.bNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwq().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nZc != null) {
            this.nZc.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nYp != null) {
            dj(this.nYp.isOriginalImg());
        }
    }

    public void b(NavigationBar navigationBar) {
        this.glZ = navigationBar;
    }

    public View WX() {
        return (this.nYl == null || this.nYl.Wy() != 1) ? this.bNh : this.bNg;
    }

    public View Xb() {
        return this.nYr;
    }

    public TbCameraView dYn() {
        if (this.nZc != null) {
            return this.nZc.dYw();
        }
        return null;
    }

    public TransparentHeadGridView dYy() {
        return this.nZb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nZa != null) {
            this.nZa.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nYZ != null) {
            this.nYZ.cancelLoadTask();
        }
        if (this.iJr != null) {
            this.iJr.closeLoadingDialog();
        }
        if (this.fOA != null) {
            this.fOA.setDialogVisiable(false);
        }
        d.dYr().b(this);
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
        WE();
    }

    private void WE() {
        if (!isHidden() && !this.isPaused) {
            WD();
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
            this.nZc.dm(true);
        } else if (this.nZc.isScroll()) {
            this.nZc.dm(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nZb != null) {
            int firstVisiblePosition = this.nZb.getFirstVisiblePosition();
            int lastVisiblePosition = this.nZb.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nZb.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nZc != null) {
                    this.nZc.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        WZ();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nZc != null) {
            o(this.nZc.i(imageFileInfo), z);
        }
    }

    public View WK() {
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
        this.nYD = jVar;
    }
}
