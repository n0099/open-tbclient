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
    private View boL;
    private TextView boN;
    private View bpC;
    private View bpD;
    private boolean bpE;
    private RelativeLayout bpu;
    private ImageView bpv;
    private TextView bpw;
    private TextView bpx;
    private NavigationBar fre;
    private BaseFragmentActivity hwQ;
    private e mMZ;
    private com.baidu.tbadk.album.f mNN;
    private com.baidu.tieba.write.view.a mNO;
    private TransparentHeadGridView mNP;
    private i mNQ;
    private c mNd;
    private TBSpecificationBtn mNf;
    private NoDataView mNoDataView;
    private j mNr;
    private View mView;
    private com.baidu.tbadk.core.view.a eUv = null;
    private View.OnClickListener mNA = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.mNd != null) {
                int maxImagesAllowed = ImageListFragment.this.mNd.getMaxImagesAllowed();
                if (ImageListFragment.this.mNd.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.mMZ != null) {
                        ImageListFragment.this.mMZ.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.mNd != null) {
                if (ImageListFragment.this.mNr == null || !ImageListFragment.this.mNr.dGi()) {
                    if (view == ImageListFragment.this.bpx) {
                        ImageListFragment.this.mNO.b(ImageListFragment.this.mNd.OR(), ImageListFragment.this.mNd.OP());
                        ImageListFragment.this.mNO.O(ImageListFragment.this.fre == null ? ImageListFragment.this.bpC : ImageListFragment.this.fre);
                        ImageListFragment.this.bpx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.boL) {
                    }
                }
            }
        }
    };
    private TbCameraView.c mND = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cbq() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a mNE = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dGf() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bpx != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.bjq().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.bpx.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private g mNB = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.mNd != null && ImageListFragment.this.mNd.getWriteImagesInfo() != null && ImageListFragment.this.mNd.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.mMZ != null) {
                    ImageListFragment.this.mMZ.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.mNd != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.mNd.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.mMZ != null) {
                        ImageListFragment.this.mMZ.fn(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0839a mNR = new a.InterfaceC0839a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0839a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hg;
            if (ImageListFragment.this.mNd != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.mNd.OP()) && (hg = ImageListFragment.this.mNd.hg(albumId)) != null) {
                    ImageListFragment.this.mNd.he(albumId);
                    ImageListFragment.this.mNQ.setData(hg);
                    ImageListFragment.this.bpx.setText(name);
                    ImageListFragment.this.mNP.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h mNC = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hwQ == null || ImageListFragment.this.mNd == null || ImageListFragment.this.mMZ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.mNd.isAdded(imageFileInfo)) {
                    ImageListFragment.this.mMZ.f(imageFileInfo);
                } else {
                    ImageListFragment.this.mMZ.g(imageFileInfo);
                }
                ImageListFragment.this.mNd.a(null);
                ImageListFragment.this.mNQ.notifyDataSetChanged();
                ImageListFragment.this.OV();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.mNd.OK()) {
                    ImageListFragment.this.hwQ.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.mNd.a(videoFileInfo);
                    ImageListFragment.this.mNd.OM();
                    ImageListFragment.this.mNQ.notifyDataSetChanged();
                    ImageListFragment.this.mMZ.Oq();
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
        this.hwQ = getBaseFragmentActivity();
        if (this.mMZ == null) {
            if (this.hwQ instanceof AlbumFloatActivity) {
                this.mMZ = ((AlbumFloatActivity) this.hwQ).mMZ;
            } else if (this.hwQ instanceof AlbumActivity) {
                this.mMZ = ((AlbumActivity) this.hwQ).mMZ;
            }
        }
        if (this.mMZ != null) {
            this.mNd = this.mMZ.dGa();
        }
        d.dFX().a(this);
        this.mNN = new com.baidu.tbadk.album.f(this.hwQ);
        this.mNO = new com.baidu.tieba.write.view.a(this.hwQ);
        this.mNO.setOnDismissListener(this.mOnDismissListener);
        this.mNO.a(this.mNR);
    }

    public void a(e eVar) {
        this.mMZ = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hwQ = getBaseFragmentActivity();
        if (this.mMZ == null) {
            if (this.hwQ instanceof AlbumFloatActivity) {
                this.mMZ = ((AlbumFloatActivity) this.hwQ).mMZ;
            } else if (this.hwQ instanceof AlbumActivity) {
                this.mMZ = ((AlbumActivity) this.hwQ).mMZ;
            }
        }
        if (this.mMZ != null) {
            this.mNd = this.mMZ.dGa();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bpu = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bpC = this.mView.findViewById(R.id.layout_title);
        this.bpx = (TextView) this.mView.findViewById(R.id.album_title);
        this.bpv = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bpw = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bpD = this.mView.findViewById(R.id.navi_line);
        this.boL = this.mView.findViewById(R.id.layout_bottom);
        this.boN = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.mNf = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.mNf.setTextSize(R.dimen.tbds34);
        this.mNf.getStyleConfig().oZ(l.getDimens(this.hwQ, R.dimen.tbds25));
        this.mNd.he(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bpx.setText(this.hwQ.getPageContext().getString(R.string.album_all_media));
        if (this.mNd.getWriteImagesInfo() != null) {
            this.boN.setVisibility(this.mNd.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.mNd.getWriteImagesInfo() != null && this.mNd.getWriteImagesInfo().isFromQRCode()) {
            this.boL.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hwQ.getPageContext().getPageActivity(), this.bpu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.mNP = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.mNP.setSelector(R.color.transparent);
        this.mNQ = new i(this.hwQ, this.mNd);
        if (this.mNd.getWriteImagesInfo() != null && this.mNd.getWriteImagesInfo().isFromQRCode()) {
            this.mNQ.xe(false);
        } else {
            this.mNQ.xe(true);
        }
        this.mNP.setAdapter((ListAdapter) this.mNQ);
        this.mNP.setOuterOnScrollListener(this);
        this.mNQ.a(this.mNC);
        this.mNQ.a(this.mNB);
        this.mNQ.al(this.mNA);
        this.mNQ.setOnOpenCameraFailedListener(this.mNE);
        this.mNQ.setOnRequestPermissionListener(this.mND);
        this.mNf.setOnClickListener(this.hwQ);
        this.bpv.setOnClickListener(this.hwQ);
        this.bpw.setOnClickListener(this.hwQ);
        this.boN.setOnClickListener(this.hwQ);
        this.bpx.setOnClickListener(this.mOnClickListener);
        this.boL.setOnClickListener(this.mOnClickListener);
        OV();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fre != null) {
            if (this.bpx.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bpx.getParent()).removeView(this.bpx);
            }
            this.bpC.setVisibility(8);
            this.fre.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bpx, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.eUv == null) {
            this.eUv = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.eUv.setCancelListener(null);
        this.eUv.setTipString(R.string.loading);
        this.eUv.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hwQ.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OV() {
        int count;
        String string;
        if (this.mNd != null && this.mNf != null) {
            if (this.mNd.OL()) {
                int i = this.mNd.OL() ? 1 : 0;
                count = i;
                string = this.hwQ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.mNd.ON());
                string = this.hwQ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mNd.getMaxImagesAllowed())});
            }
            this.mNf.setText(string);
            this.mNf.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bpE = false;
        if (isShow()) {
            OA();
        }
    }

    private void Oz() {
        if (this.mNd == null && this.mMZ != null) {
            this.mNd = this.mMZ.dGa();
        }
        if (this.mNd != null) {
            if (!this.mNd.btP()) {
                this.mNQ.notifyDataSetChanged();
            } else {
                OW();
            }
            cy(this.mNd.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void OW() {
        if (this.mNN == null) {
            this.mNN = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.mNN.a((this.mMZ == null || !this.mMZ.dGb()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.eUv != null) {
                    ImageListFragment.this.eUv.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.mNd != null && gVar != null) {
                    ImageListFragment.this.mNd.c(gVar);
                    String OP = ImageListFragment.this.mNd.OP();
                    ImageListFragment.this.mNd.he(OP);
                    ImageListFragment.this.mNQ.setData(ImageListFragment.this.mNd.hg(OP));
                    ImageListFragment.this.mNP.smoothScrollToPosition(0);
                    ImageListFragment.this.OV();
                }
                ImageListFragment.this.mNP.OY();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bpD, R.color.cp_bg_line_c, i);
        ap.setViewTextColor(this.bpx, R.color.cp_cont_b, i);
        if (this.bpw != null && this.bpv != null) {
            if (this.mMZ != null && this.mMZ.Ou() == 1) {
                SvgManager.bjq().a(this.bpv, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                this.bpw.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bpw, R.color.navi_back_text_color);
                this.bpv.setVisibility(8);
            }
        }
        if (this.bpx != null) {
            this.bpx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.mNQ != null) {
            this.mNQ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNd != null) {
            cy(this.mNd.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fre = navigationBar;
    }

    public View OT() {
        return (this.mMZ == null || this.mMZ.Ou() != 1) ? this.bpw : this.bpv;
    }

    public View OX() {
        return this.mNf;
    }

    public TbCameraView dFT() {
        if (this.mNQ != null) {
            return this.mNQ.dGc();
        }
        return null;
    }

    public TransparentHeadGridView dGe() {
        return this.mNP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mNO != null) {
            this.mNO.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mNN != null) {
            this.mNN.cancelLoadTask();
        }
        if (this.hwQ != null) {
            this.hwQ.closeLoadingDialog();
        }
        if (this.eUv != null) {
            this.eUv.setDialogVisiable(false);
        }
        d.dFX().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bpE = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cA(boolean z) {
        OA();
    }

    private void OA() {
        if (!isHidden() && !this.bpE) {
            Oz();
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
            this.mNQ.cB(true);
        } else if (this.mNQ.isScroll()) {
            this.mNQ.cB(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.mNP != null) {
            int firstVisiblePosition = this.mNP.getFirstVisiblePosition();
            int lastVisiblePosition = this.mNP.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mNP.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.mNQ != null) {
                    this.mNQ.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        OV();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.mNQ != null) {
            o(this.mNQ.i(imageFileInfo), z);
        }
    }

    public View OG() {
        return this.boN;
    }

    public void cy(boolean z) {
        if (this.hwQ != null && this.boN != null) {
            this.boN.setText(this.hwQ.getResources().getString(R.string.original_img));
            if (z) {
                this.boN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.boN, R.color.cp_link_tip_a);
                return;
            }
            this.boN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.boN, R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.mNr = jVar;
    }
}
