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
    private TextView bCB;
    private View bCz;
    private RelativeLayout bDi;
    private ImageView bDj;
    private TextView bDk;
    private TextView bDl;
    private View bDq;
    private View bDr;
    private boolean bDs;
    private NavigationBar fUw;
    private BaseFragmentActivity imj;
    private NoDataView mNoDataView;
    private View mView;
    private e nGI;
    private c nGM;
    private TBSpecificationBtn nGO;
    private j nHa;
    private com.baidu.tbadk.album.f nHw;
    private com.baidu.tieba.write.view.a nHx;
    private TransparentHeadGridView nHy;
    private i nHz;
    private com.baidu.tbadk.core.view.a fxh = null;
    private View.OnClickListener nHj = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nGM != null) {
                int maxImagesAllowed = ImageListFragment.this.nGM.getMaxImagesAllowed();
                if (ImageListFragment.this.nGM.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nGI != null) {
                        ImageListFragment.this.nGI.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nGM != null) {
                if (ImageListFragment.this.nHa == null || !ImageListFragment.this.nHa.dTE()) {
                    if (view == ImageListFragment.this.bDl) {
                        ImageListFragment.this.nHx.c(ImageListFragment.this.nGM.Tt(), ImageListFragment.this.nGM.Tr());
                        ImageListFragment.this.nHx.O(ImageListFragment.this.fUw == null ? ImageListFragment.this.bDq : ImageListFragment.this.fUw);
                        ImageListFragment.this.bDl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bqB().a(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bCz) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nHm = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cnm() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nHn = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dTB() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bDl != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.bqB().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bDl.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nHk = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nGM != null && ImageListFragment.this.nGM.getWriteImagesInfo() != null && ImageListFragment.this.nGM.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nGI != null) {
                    ImageListFragment.this.nGI.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nGM != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nGM.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nGI != null) {
                        ImageListFragment.this.nGI.fS(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0887a nHA = new a.InterfaceC0887a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0887a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ir;
            if (ImageListFragment.this.nGM != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nGM.Tr()) && (ir = ImageListFragment.this.nGM.ir(albumId)) != null) {
                    ImageListFragment.this.nGM.ip(albumId);
                    ImageListFragment.this.nHz.setData(ir);
                    ImageListFragment.this.bDl.setText(name);
                    ImageListFragment.this.nHy.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nHl = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.imj == null || ImageListFragment.this.nGM == null || ImageListFragment.this.nGI == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.nGM.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nGI.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nGI.g(imageFileInfo);
                }
                ImageListFragment.this.nGM.a(null);
                ImageListFragment.this.nHz.notifyDataSetChanged();
                ImageListFragment.this.Tx();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nGM.Tm()) {
                    ImageListFragment.this.imj.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nGM.a(videoFileInfo);
                    ImageListFragment.this.nGM.To();
                    ImageListFragment.this.nHz.notifyDataSetChanged();
                    ImageListFragment.this.nGI.SS();
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
        this.imj = getBaseFragmentActivity();
        if (this.nGI == null) {
            if (this.imj instanceof AlbumFloatActivity) {
                this.nGI = ((AlbumFloatActivity) this.imj).nGI;
            } else if (this.imj instanceof AlbumActivity) {
                this.nGI = ((AlbumActivity) this.imj).nGI;
            }
        }
        if (this.nGI != null) {
            this.nGM = this.nGI.dTw();
        }
        d.dTt().a(this);
        this.nHw = new com.baidu.tbadk.album.f(this.imj);
        this.nHx = new com.baidu.tieba.write.view.a(this.imj);
        this.nHx.setOnDismissListener(this.mOnDismissListener);
        this.nHx.a(this.nHA);
    }

    public void a(e eVar) {
        this.nGI = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.imj = getBaseFragmentActivity();
        if (this.nGI == null) {
            if (this.imj instanceof AlbumFloatActivity) {
                this.nGI = ((AlbumFloatActivity) this.imj).nGI;
            } else if (this.imj instanceof AlbumActivity) {
                this.nGI = ((AlbumActivity) this.imj).nGI;
            }
        }
        if (this.nGI != null) {
            this.nGM = this.nGI.dTw();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bDi = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bDq = this.mView.findViewById(R.id.layout_title);
        this.bDl = (TextView) this.mView.findViewById(R.id.album_title);
        this.bDj = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bDk = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bDr = this.mView.findViewById(R.id.navi_line);
        this.bCz = this.mView.findViewById(R.id.layout_bottom);
        this.bCB = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.nGO = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nGO.setTextSize(R.dimen.tbds34);
        this.nGO.getStyleConfig().qD(l.getDimens(this.imj, R.dimen.tbds25));
        this.nGM.ip(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bDl.setText(this.imj.getPageContext().getString(R.string.album_all_media));
        if (this.nGM.getWriteImagesInfo() != null) {
            this.bCB.setVisibility(this.nGM.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nGM.getWriteImagesInfo() != null && this.nGM.getWriteImagesInfo().isFromQRCode()) {
            this.bCz.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.imj.getPageContext().getPageActivity(), this.bDi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nHy = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nHy.setSelector(R.color.transparent);
        this.nHz = new i(this.imj, this.nGM);
        if (this.nGM.getWriteImagesInfo() != null && this.nGM.getWriteImagesInfo().isFromQRCode()) {
            this.nHz.yD(false);
        } else {
            this.nHz.yD(true);
        }
        this.nHy.setAdapter((ListAdapter) this.nHz);
        this.nHy.setOuterOnScrollListener(this);
        this.nHz.a(this.nHl);
        this.nHz.a(this.nHk);
        this.nHz.am(this.nHj);
        this.nHz.setOnOpenCameraFailedListener(this.nHn);
        this.nHz.setOnRequestPermissionListener(this.nHm);
        this.nGO.setOnClickListener(this.imj);
        this.bDj.setOnClickListener(this.imj);
        this.bDk.setOnClickListener(this.imj);
        this.bCB.setOnClickListener(this.imj);
        this.bDl.setOnClickListener(this.mOnClickListener);
        this.bCz.setOnClickListener(this.mOnClickListener);
        Tx();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fUw != null) {
            if (this.bDl.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bDl.getParent()).removeView(this.bDl);
            }
            this.bDq.setVisibility(8);
            this.fUw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bDl, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fxh == null) {
            this.fxh = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fxh.setCancelListener(null);
        this.fxh.setTipString(R.string.loading);
        this.fxh.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.imj.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tx() {
        int count;
        String string;
        if (this.nGM != null && this.nGO != null) {
            if (this.nGM.Tn()) {
                int i = this.nGM.Tn() ? 1 : 0;
                count = i;
                string = this.imj.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.nGM.Tp());
                string = this.imj.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nGM.getMaxImagesAllowed())});
            }
            this.nGO.setText(string);
            this.nGO.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bDs = false;
        if (isShow()) {
            Tc();
        }
    }

    private void Tb() {
        if (this.nGM == null && this.nGI != null) {
            this.nGM = this.nGI.dTw();
        }
        if (this.nGM != null) {
            if (!this.nGM.bBm()) {
                this.nHz.notifyDataSetChanged();
            } else {
                Ty();
            }
            cS(this.nGM.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ty() {
        if (this.nHw == null) {
            this.nHw = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nHw.a((this.nGI == null || !this.nGI.dTx()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fxh != null) {
                    ImageListFragment.this.fxh.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.nGM != null && ImageListFragment.this.nHz != null) {
                    ImageListFragment.this.nGM.c(gVar);
                    String Tr = ImageListFragment.this.nGM.Tr();
                    ImageListFragment.this.nGM.ip(Tr);
                    ImageListFragment.this.nHz.setData(ImageListFragment.this.nGM.ir(Tr));
                    ImageListFragment.this.nHy.smoothScrollToPosition(0);
                    ImageListFragment.this.Tx();
                }
                ImageListFragment.this.nHy.TA();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bDr, R.color.CAM_X0204, i);
        ap.setViewTextColor(this.bDl, R.color.CAM_X0105, i);
        if (this.bDk != null && this.bDj != null) {
            if (this.nGI != null && this.nGI.SW() == 1) {
                SvgManager.bqB().a(this.bDj, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                this.bDk.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bDk, R.color.navi_back_text_color);
                this.bDj.setVisibility(8);
            }
        }
        if (this.bDl != null) {
            this.bDl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bqB().a(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nHz != null) {
            this.nHz.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nGM != null) {
            cS(this.nGM.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fUw = navigationBar;
    }

    public View Tv() {
        return (this.nGI == null || this.nGI.SW() != 1) ? this.bDk : this.bDj;
    }

    public View Tz() {
        return this.nGO;
    }

    public TbCameraView dTp() {
        if (this.nHz != null) {
            return this.nHz.dTy();
        }
        return null;
    }

    public TransparentHeadGridView dTA() {
        return this.nHy;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nHx != null) {
            this.nHx.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nHw != null) {
            this.nHw.cancelLoadTask();
        }
        if (this.imj != null) {
            this.imj.closeLoadingDialog();
        }
        if (this.fxh != null) {
            this.fxh.setDialogVisiable(false);
        }
        d.dTt().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bDs = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cU(boolean z) {
        Tc();
    }

    private void Tc() {
        if (!isHidden() && !this.bDs) {
            Tb();
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
            this.nHz.cV(true);
        } else if (this.nHz.isScroll()) {
            this.nHz.cV(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nHy != null) {
            int firstVisiblePosition = this.nHy.getFirstVisiblePosition();
            int lastVisiblePosition = this.nHy.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nHy.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nHz != null) {
                    this.nHz.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Tx();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nHz != null) {
            o(this.nHz.i(imageFileInfo), z);
        }
    }

    public View Ti() {
        return this.bCB;
    }

    public void cS(boolean z) {
        if (this.imj != null && this.bCB != null) {
            this.bCB.setText(this.imj.getResources().getString(R.string.original_img));
            if (z) {
                this.bCB.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.bCB, R.color.CAM_X0302);
                return;
            }
            this.bCB.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.bCB, R.color.CAM_X0106);
        }
    }

    public void a(j jVar) {
        this.nHa = jVar;
    }
}
