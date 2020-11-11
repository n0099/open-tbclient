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
    private RelativeLayout bET;
    private ImageView bEU;
    private TextView bEV;
    private TextView bEW;
    private View bEk;
    private TextView bEm;
    private View bFb;
    private View bFc;
    private boolean bFd;
    private NavigationBar fUP;
    private BaseFragmentActivity ilu;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.album.f nFV;
    private com.baidu.tieba.write.view.a nFW;
    private TransparentHeadGridView nFX;
    private i nFY;
    private e nFh;
    private c nFl;
    private TBSpecificationBtn nFn;
    private j nFz;
    private com.baidu.tbadk.core.view.a fxS = null;
    private View.OnClickListener nFI = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nFl != null) {
                int maxImagesAllowed = ImageListFragment.this.nFl.getMaxImagesAllowed();
                if (ImageListFragment.this.nFl.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nFh != null) {
                        ImageListFragment.this.nFh.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nFl != null) {
                if (ImageListFragment.this.nFz == null || !ImageListFragment.this.nFz.dTF()) {
                    if (view == ImageListFragment.this.bEW) {
                        ImageListFragment.this.nFW.c(ImageListFragment.this.nFl.Uc(), ImageListFragment.this.nFl.Ua());
                        ImageListFragment.this.nFW.O(ImageListFragment.this.fUP == null ? ImageListFragment.this.bFb : ImageListFragment.this.fUP);
                        ImageListFragment.this.bEW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bEk) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nFL = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cnK() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nFM = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dTC() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bEW != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.brn().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bEW.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nFJ = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nFl != null && ImageListFragment.this.nFl.getWriteImagesInfo() != null && ImageListFragment.this.nFl.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nFh != null) {
                    ImageListFragment.this.nFh.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nFl != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nFl.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nFh != null) {
                        ImageListFragment.this.nFh.fW(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0884a nFZ = new a.InterfaceC0884a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0884a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ix;
            if (ImageListFragment.this.nFl != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nFl.Ua()) && (ix = ImageListFragment.this.nFl.ix(albumId)) != null) {
                    ImageListFragment.this.nFl.iv(albumId);
                    ImageListFragment.this.nFY.setData(ix);
                    ImageListFragment.this.bEW.setText(name);
                    ImageListFragment.this.nFX.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nFK = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.ilu == null || ImageListFragment.this.nFl == null || ImageListFragment.this.nFh == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.nFl.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nFh.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nFh.g(imageFileInfo);
                }
                ImageListFragment.this.nFl.a(null);
                ImageListFragment.this.nFY.notifyDataSetChanged();
                ImageListFragment.this.Ug();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nFl.TV()) {
                    ImageListFragment.this.ilu.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nFl.a(videoFileInfo);
                    ImageListFragment.this.nFl.TX();
                    ImageListFragment.this.nFY.notifyDataSetChanged();
                    ImageListFragment.this.nFh.TB();
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
        this.ilu = getBaseFragmentActivity();
        if (this.nFh == null) {
            if (this.ilu instanceof AlbumFloatActivity) {
                this.nFh = ((AlbumFloatActivity) this.ilu).nFh;
            } else if (this.ilu instanceof AlbumActivity) {
                this.nFh = ((AlbumActivity) this.ilu).nFh;
            }
        }
        if (this.nFh != null) {
            this.nFl = this.nFh.dTx();
        }
        d.dTu().a(this);
        this.nFV = new com.baidu.tbadk.album.f(this.ilu);
        this.nFW = new com.baidu.tieba.write.view.a(this.ilu);
        this.nFW.setOnDismissListener(this.mOnDismissListener);
        this.nFW.a(this.nFZ);
    }

    public void a(e eVar) {
        this.nFh = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ilu = getBaseFragmentActivity();
        if (this.nFh == null) {
            if (this.ilu instanceof AlbumFloatActivity) {
                this.nFh = ((AlbumFloatActivity) this.ilu).nFh;
            } else if (this.ilu instanceof AlbumActivity) {
                this.nFh = ((AlbumActivity) this.ilu).nFh;
            }
        }
        if (this.nFh != null) {
            this.nFl = this.nFh.dTx();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bET = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bFb = this.mView.findViewById(R.id.layout_title);
        this.bEW = (TextView) this.mView.findViewById(R.id.album_title);
        this.bEU = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bEV = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bFc = this.mView.findViewById(R.id.navi_line);
        this.bEk = this.mView.findViewById(R.id.layout_bottom);
        this.bEm = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.nFn = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nFn.setTextSize(R.dimen.tbds34);
        this.nFn.getStyleConfig().qf(l.getDimens(this.ilu, R.dimen.tbds25));
        this.nFl.iv(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bEW.setText(this.ilu.getPageContext().getString(R.string.album_all_media));
        if (this.nFl.getWriteImagesInfo() != null) {
            this.bEm.setVisibility(this.nFl.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nFl.getWriteImagesInfo() != null && this.nFl.getWriteImagesInfo().isFromQRCode()) {
            this.bEk.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.ilu.getPageContext().getPageActivity(), this.bET, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nFX = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nFX.setSelector(R.color.transparent);
        this.nFY = new i(this.ilu, this.nFl);
        if (this.nFl.getWriteImagesInfo() != null && this.nFl.getWriteImagesInfo().isFromQRCode()) {
            this.nFY.yw(false);
        } else {
            this.nFY.yw(true);
        }
        this.nFX.setAdapter((ListAdapter) this.nFY);
        this.nFX.setOuterOnScrollListener(this);
        this.nFY.a(this.nFK);
        this.nFY.a(this.nFJ);
        this.nFY.am(this.nFI);
        this.nFY.setOnOpenCameraFailedListener(this.nFM);
        this.nFY.setOnRequestPermissionListener(this.nFL);
        this.nFn.setOnClickListener(this.ilu);
        this.bEU.setOnClickListener(this.ilu);
        this.bEV.setOnClickListener(this.ilu);
        this.bEm.setOnClickListener(this.ilu);
        this.bEW.setOnClickListener(this.mOnClickListener);
        this.bEk.setOnClickListener(this.mOnClickListener);
        Ug();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fUP != null) {
            if (this.bEW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bEW.getParent()).removeView(this.bEW);
            }
            this.bFb.setVisibility(8);
            this.fUP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bEW, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fxS == null) {
            this.fxS = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fxS.setCancelListener(null);
        this.fxS.setTipString(R.string.loading);
        this.fxS.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.ilu.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ug() {
        int count;
        String string;
        if (this.nFl != null && this.nFn != null) {
            if (this.nFl.TW()) {
                int i = this.nFl.TW() ? 1 : 0;
                count = i;
                string = this.ilu.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.nFl.TY());
                string = this.ilu.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nFl.getMaxImagesAllowed())});
            }
            this.nFn.setText(string);
            this.nFn.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bFd = false;
        if (isShow()) {
            TL();
        }
    }

    private void TK() {
        if (this.nFl == null && this.nFh != null) {
            this.nFl = this.nFh.dTx();
        }
        if (this.nFl != null) {
            if (!this.nFl.bBW()) {
                this.nFY.notifyDataSetChanged();
            } else {
                Uh();
            }
            cQ(this.nFl.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uh() {
        if (this.nFV == null) {
            this.nFV = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nFV.a((this.nFh == null || !this.nFh.dTy()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fxS != null) {
                    ImageListFragment.this.fxS.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.nFl != null && ImageListFragment.this.nFY != null) {
                    ImageListFragment.this.nFl.c(gVar);
                    String Ua = ImageListFragment.this.nFl.Ua();
                    ImageListFragment.this.nFl.iv(Ua);
                    ImageListFragment.this.nFY.setData(ImageListFragment.this.nFl.ix(Ua));
                    ImageListFragment.this.nFX.smoothScrollToPosition(0);
                    ImageListFragment.this.Ug();
                }
                ImageListFragment.this.nFX.Uj();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bFc, R.color.cp_bg_line_c, i);
        ap.setViewTextColor(this.bEW, R.color.cp_cont_b, i);
        if (this.bEV != null && this.bEU != null) {
            if (this.nFh != null && this.nFh.TF() == 1) {
                SvgManager.brn().a(this.bEU, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                this.bEV.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bEV, R.color.navi_back_text_color);
                this.bEU.setVisibility(8);
            }
        }
        if (this.bEW != null) {
            this.bEW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.brn().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nFY != null) {
            this.nFY.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nFl != null) {
            cQ(this.nFl.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fUP = navigationBar;
    }

    public View Ue() {
        return (this.nFh == null || this.nFh.TF() != 1) ? this.bEV : this.bEU;
    }

    public View Ui() {
        return this.nFn;
    }

    public TbCameraView dTq() {
        if (this.nFY != null) {
            return this.nFY.dTz();
        }
        return null;
    }

    public TransparentHeadGridView dTB() {
        return this.nFX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nFW != null) {
            this.nFW.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nFV != null) {
            this.nFV.cancelLoadTask();
        }
        if (this.ilu != null) {
            this.ilu.closeLoadingDialog();
        }
        if (this.fxS != null) {
            this.fxS.setDialogVisiable(false);
        }
        d.dTu().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bFd = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cS(boolean z) {
        TL();
    }

    private void TL() {
        if (!isHidden() && !this.bFd) {
            TK();
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
            this.nFY.cT(true);
        } else if (this.nFY.isScroll()) {
            this.nFY.cT(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nFX != null) {
            int firstVisiblePosition = this.nFX.getFirstVisiblePosition();
            int lastVisiblePosition = this.nFX.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nFX.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nFY != null) {
                    this.nFY.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Ug();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nFY != null) {
            o(this.nFY.i(imageFileInfo), z);
        }
    }

    public View TR() {
        return this.bEm;
    }

    public void cQ(boolean z) {
        if (this.ilu != null && this.bEm != null) {
            this.bEm.setText(this.ilu.getResources().getString(R.string.original_img));
            if (z) {
                this.bEm.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.bEm, R.color.cp_link_tip_a);
                return;
            }
            this.bEm.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.bEm, R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.nFz = jVar;
    }
}
