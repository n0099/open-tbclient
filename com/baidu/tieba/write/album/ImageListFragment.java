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
    private View brX;
    private TextView brZ;
    private RelativeLayout bsG;
    private ImageView bsH;
    private TextView bsI;
    private TextView bsJ;
    private View bsO;
    private View bsP;
    private boolean bsQ;
    private NavigationBar fuv;
    private BaseFragmentActivity hEa;
    private NoDataView mNoDataView;
    private View mView;
    private j mXG;
    private e mXo;
    private c mXs;
    private TBSpecificationBtn mXu;
    private com.baidu.tbadk.album.f mYc;
    private com.baidu.tieba.write.view.a mYd;
    private TransparentHeadGridView mYe;
    private i mYf;
    private com.baidu.tbadk.core.view.a eXp = null;
    private View.OnClickListener mXP = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.mXs != null) {
                int maxImagesAllowed = ImageListFragment.this.mXs.getMaxImagesAllowed();
                if (ImageListFragment.this.mXs.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.mXo != null) {
                        ImageListFragment.this.mXo.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.mXs != null) {
                if (ImageListFragment.this.mXG == null || !ImageListFragment.this.mXG.dKl()) {
                    if (view == ImageListFragment.this.bsJ) {
                        ImageListFragment.this.mYd.b(ImageListFragment.this.mXs.Pu(), ImageListFragment.this.mXs.Ps());
                        ImageListFragment.this.mYd.O(ImageListFragment.this.fuv == null ? ImageListFragment.this.bsO : ImageListFragment.this.fuv);
                        ImageListFragment.this.bsJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.brX) {
                    }
                }
            }
        }
    };
    private TbCameraView.c mXS = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean ceG() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a mXT = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dKi() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bsJ != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.bkl().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.bsJ.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private g mXQ = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.mXs != null && ImageListFragment.this.mXs.getWriteImagesInfo() != null && ImageListFragment.this.mXs.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.mXo != null) {
                    ImageListFragment.this.mXo.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.mXs != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.mXs.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.mXo != null) {
                        ImageListFragment.this.mXo.fy(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0836a mYg = new a.InterfaceC0836a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0836a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hx;
            if (ImageListFragment.this.mXs != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.mXs.Ps()) && (hx = ImageListFragment.this.mXs.hx(albumId)) != null) {
                    ImageListFragment.this.mXs.hv(albumId);
                    ImageListFragment.this.mYf.setData(hx);
                    ImageListFragment.this.bsJ.setText(name);
                    ImageListFragment.this.mYe.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h mXR = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hEa == null || ImageListFragment.this.mXs == null || ImageListFragment.this.mXo == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.mXs.isAdded(imageFileInfo)) {
                    ImageListFragment.this.mXo.f(imageFileInfo);
                } else {
                    ImageListFragment.this.mXo.g(imageFileInfo);
                }
                ImageListFragment.this.mXs.a(null);
                ImageListFragment.this.mYf.notifyDataSetChanged();
                ImageListFragment.this.Py();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.mXs.Pn()) {
                    ImageListFragment.this.hEa.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.mXs.a(videoFileInfo);
                    ImageListFragment.this.mXs.Pp();
                    ImageListFragment.this.mYf.notifyDataSetChanged();
                    ImageListFragment.this.mXo.OT();
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
        this.hEa = getBaseFragmentActivity();
        if (this.mXo == null) {
            if (this.hEa instanceof AlbumFloatActivity) {
                this.mXo = ((AlbumFloatActivity) this.hEa).mXo;
            } else if (this.hEa instanceof AlbumActivity) {
                this.mXo = ((AlbumActivity) this.hEa).mXo;
            }
        }
        if (this.mXo != null) {
            this.mXs = this.mXo.dKd();
        }
        d.dKa().a(this);
        this.mYc = new com.baidu.tbadk.album.f(this.hEa);
        this.mYd = new com.baidu.tieba.write.view.a(this.hEa);
        this.mYd.setOnDismissListener(this.mOnDismissListener);
        this.mYd.a(this.mYg);
    }

    public void a(e eVar) {
        this.mXo = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hEa = getBaseFragmentActivity();
        if (this.mXo == null) {
            if (this.hEa instanceof AlbumFloatActivity) {
                this.mXo = ((AlbumFloatActivity) this.hEa).mXo;
            } else if (this.hEa instanceof AlbumActivity) {
                this.mXo = ((AlbumActivity) this.hEa).mXo;
            }
        }
        if (this.mXo != null) {
            this.mXs = this.mXo.dKd();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bsG = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bsO = this.mView.findViewById(R.id.layout_title);
        this.bsJ = (TextView) this.mView.findViewById(R.id.album_title);
        this.bsH = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bsI = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bsP = this.mView.findViewById(R.id.navi_line);
        this.brX = this.mView.findViewById(R.id.layout_bottom);
        this.brZ = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.mXu = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.mXu.setTextSize(R.dimen.tbds34);
        this.mXu.getStyleConfig().pl(l.getDimens(this.hEa, R.dimen.tbds25));
        this.mXs.hv(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bsJ.setText(this.hEa.getPageContext().getString(R.string.album_all_media));
        if (this.mXs.getWriteImagesInfo() != null) {
            this.brZ.setVisibility(this.mXs.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.mXs.getWriteImagesInfo() != null && this.mXs.getWriteImagesInfo().isFromQRCode()) {
            this.brX.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hEa.getPageContext().getPageActivity(), this.bsG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.mYe = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.mYe.setSelector(R.color.transparent);
        this.mYf = new i(this.hEa, this.mXs);
        if (this.mXs.getWriteImagesInfo() != null && this.mXs.getWriteImagesInfo().isFromQRCode()) {
            this.mYf.xp(false);
        } else {
            this.mYf.xp(true);
        }
        this.mYe.setAdapter((ListAdapter) this.mYf);
        this.mYe.setOuterOnScrollListener(this);
        this.mYf.a(this.mXR);
        this.mYf.a(this.mXQ);
        this.mYf.al(this.mXP);
        this.mYf.setOnOpenCameraFailedListener(this.mXT);
        this.mYf.setOnRequestPermissionListener(this.mXS);
        this.mXu.setOnClickListener(this.hEa);
        this.bsH.setOnClickListener(this.hEa);
        this.bsI.setOnClickListener(this.hEa);
        this.brZ.setOnClickListener(this.hEa);
        this.bsJ.setOnClickListener(this.mOnClickListener);
        this.brX.setOnClickListener(this.mOnClickListener);
        Py();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fuv != null) {
            if (this.bsJ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bsJ.getParent()).removeView(this.bsJ);
            }
            this.bsO.setVisibility(8);
            this.fuv.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bsJ, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.eXp == null) {
            this.eXp = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.eXp.setCancelListener(null);
        this.eXp.setTipString(R.string.loading);
        this.eXp.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hEa.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py() {
        int count;
        String string;
        if (this.mXs != null && this.mXu != null) {
            if (this.mXs.Po()) {
                int i = this.mXs.Po() ? 1 : 0;
                count = i;
                string = this.hEa.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.mXs.Pq());
                string = this.hEa.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mXs.getMaxImagesAllowed())});
            }
            this.mXu.setText(string);
            this.mXu.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bsQ = false;
        if (isShow()) {
            Pd();
        }
    }

    private void Pc() {
        if (this.mXs == null && this.mXo != null) {
            this.mXs = this.mXo.dKd();
        }
        if (this.mXs != null) {
            if (!this.mXs.buU()) {
                this.mYf.notifyDataSetChanged();
            } else {
                Pz();
            }
            cA(this.mXs.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pz() {
        if (this.mYc == null) {
            this.mYc = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.mYc.a((this.mXo == null || !this.mXo.dKe()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.eXp != null) {
                    ImageListFragment.this.eXp.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.mXs != null && ImageListFragment.this.mYf != null) {
                    ImageListFragment.this.mXs.c(gVar);
                    String Ps = ImageListFragment.this.mXs.Ps();
                    ImageListFragment.this.mXs.hv(Ps);
                    ImageListFragment.this.mYf.setData(ImageListFragment.this.mXs.hx(Ps));
                    ImageListFragment.this.mYe.smoothScrollToPosition(0);
                    ImageListFragment.this.Py();
                }
                ImageListFragment.this.mYe.PB();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bsP, R.color.cp_bg_line_c, i);
        ap.setViewTextColor(this.bsJ, R.color.cp_cont_b, i);
        if (this.bsI != null && this.bsH != null) {
            if (this.mXo != null && this.mXo.OX() == 1) {
                SvgManager.bkl().a(this.bsH, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                this.bsI.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bsI, R.color.navi_back_text_color);
                this.bsH.setVisibility(8);
            }
        }
        if (this.bsJ != null) {
            this.bsJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bkl().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.mYf != null) {
            this.mYf.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.mXs != null) {
            cA(this.mXs.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fuv = navigationBar;
    }

    public View Pw() {
        return (this.mXo == null || this.mXo.OX() != 1) ? this.bsI : this.bsH;
    }

    public View PA() {
        return this.mXu;
    }

    public TbCameraView dJW() {
        if (this.mYf != null) {
            return this.mYf.dKf();
        }
        return null;
    }

    public TransparentHeadGridView dKh() {
        return this.mYe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mYd != null) {
            this.mYd.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mYc != null) {
            this.mYc.cancelLoadTask();
        }
        if (this.hEa != null) {
            this.hEa.closeLoadingDialog();
        }
        if (this.eXp != null) {
            this.eXp.setDialogVisiable(false);
        }
        d.dKa().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bsQ = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cC(boolean z) {
        Pd();
    }

    private void Pd() {
        if (!isHidden() && !this.bsQ) {
            Pc();
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
            this.mYf.cD(true);
        } else if (this.mYf.isScroll()) {
            this.mYf.cD(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.mYe != null) {
            int firstVisiblePosition = this.mYe.getFirstVisiblePosition();
            int lastVisiblePosition = this.mYe.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mYe.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.mYf != null) {
                    this.mYf.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Py();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.mYf != null) {
            o(this.mYf.i(imageFileInfo), z);
        }
    }

    public View Pj() {
        return this.brZ;
    }

    public void cA(boolean z) {
        if (this.hEa != null && this.brZ != null) {
            this.brZ.setText(this.hEa.getResources().getString(R.string.original_img));
            if (z) {
                this.brZ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.brZ, R.color.cp_link_tip_a);
                return;
            }
            this.brZ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.brZ, R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.mXG = jVar;
    }
}
