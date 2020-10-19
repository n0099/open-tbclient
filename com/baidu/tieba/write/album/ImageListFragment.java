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
    private View bvL;
    private TextView bvN;
    private View bwC;
    private View bwD;
    private boolean bwE;
    private RelativeLayout bwu;
    private ImageView bwv;
    private TextView bww;
    private TextView bwx;
    private NavigationBar fGE;
    private BaseFragmentActivity hSW;
    private NoDataView mNoDataView;
    private View mView;
    private e nmM;
    private c nmQ;
    private TBSpecificationBtn nmS;
    private com.baidu.tbadk.album.f nnA;
    private com.baidu.tieba.write.view.a nnB;
    private TransparentHeadGridView nnC;
    private i nnD;
    private j nne;
    private com.baidu.tbadk.core.view.a fjB = null;
    private View.OnClickListener nnn = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.nmQ != null) {
                int maxImagesAllowed = ImageListFragment.this.nmQ.getMaxImagesAllowed();
                if (ImageListFragment.this.nmQ.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.nmM != null) {
                        ImageListFragment.this.nmM.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.nmQ != null) {
                if (ImageListFragment.this.nne == null || !ImageListFragment.this.nne.dNX()) {
                    if (view == ImageListFragment.this.bwx) {
                        ImageListFragment.this.nnB.b(ImageListFragment.this.nmQ.Qz(), ImageListFragment.this.nmQ.Qx());
                        ImageListFragment.this.nnB.O(ImageListFragment.this.fGE == null ? ImageListFragment.this.bwC : ImageListFragment.this.fGE);
                        ImageListFragment.this.bwx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bvL) {
                    }
                }
            }
        }
    };
    private TbCameraView.c nnq = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cic() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a nnr = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dNU() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bwx != null && ImageListFragment.this.isAdded()) {
                Drawable a2 = SvgManager.bmU().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                ImageListFragment.this.bwx.setCompoundDrawables(null, null, a2, null);
            }
        }
    };
    private g nno = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.nmQ != null && ImageListFragment.this.nmQ.getWriteImagesInfo() != null && ImageListFragment.this.nmQ.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.nmM != null) {
                    ImageListFragment.this.nmM.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.nmQ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.nmQ.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.nmM != null) {
                        ImageListFragment.this.nmM.fH(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0854a nnE = new a.InterfaceC0854a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0854a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hO;
            if (ImageListFragment.this.nmQ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.nmQ.Qx()) && (hO = ImageListFragment.this.nmQ.hO(albumId)) != null) {
                    ImageListFragment.this.nmQ.hM(albumId);
                    ImageListFragment.this.nnD.setData(hO);
                    ImageListFragment.this.bwx.setText(name);
                    ImageListFragment.this.nnC.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h nnp = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hSW == null || ImageListFragment.this.nmQ == null || ImageListFragment.this.nmM == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.nmQ.isAdded(imageFileInfo)) {
                    ImageListFragment.this.nmM.f(imageFileInfo);
                } else {
                    ImageListFragment.this.nmM.g(imageFileInfo);
                }
                ImageListFragment.this.nmQ.a(null);
                ImageListFragment.this.nnD.notifyDataSetChanged();
                ImageListFragment.this.QD();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.nmQ.Qs()) {
                    ImageListFragment.this.hSW.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.nmQ.a(videoFileInfo);
                    ImageListFragment.this.nmQ.Qu();
                    ImageListFragment.this.nnD.notifyDataSetChanged();
                    ImageListFragment.this.nmM.PY();
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
        this.hSW = getBaseFragmentActivity();
        if (this.nmM == null) {
            if (this.hSW instanceof AlbumFloatActivity) {
                this.nmM = ((AlbumFloatActivity) this.hSW).nmM;
            } else if (this.hSW instanceof AlbumActivity) {
                this.nmM = ((AlbumActivity) this.hSW).nmM;
            }
        }
        if (this.nmM != null) {
            this.nmQ = this.nmM.dNP();
        }
        d.dNM().a(this);
        this.nnA = new com.baidu.tbadk.album.f(this.hSW);
        this.nnB = new com.baidu.tieba.write.view.a(this.hSW);
        this.nnB.setOnDismissListener(this.mOnDismissListener);
        this.nnB.a(this.nnE);
    }

    public void a(e eVar) {
        this.nmM = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hSW = getBaseFragmentActivity();
        if (this.nmM == null) {
            if (this.hSW instanceof AlbumFloatActivity) {
                this.nmM = ((AlbumFloatActivity) this.hSW).nmM;
            } else if (this.hSW instanceof AlbumActivity) {
                this.nmM = ((AlbumActivity) this.hSW).nmM;
            }
        }
        if (this.nmM != null) {
            this.nmQ = this.nmM.dNP();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bwu = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bwC = this.mView.findViewById(R.id.layout_title);
        this.bwx = (TextView) this.mView.findViewById(R.id.album_title);
        this.bwv = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bww = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bwD = this.mView.findViewById(R.id.navi_line);
        this.bvL = this.mView.findViewById(R.id.layout_bottom);
        this.bvN = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.nmS = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.nmS.setTextSize(R.dimen.tbds34);
        this.nmS.getStyleConfig().pK(l.getDimens(this.hSW, R.dimen.tbds25));
        this.nmQ.hM(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bwx.setText(this.hSW.getPageContext().getString(R.string.album_all_media));
        if (this.nmQ.getWriteImagesInfo() != null) {
            this.bvN.setVisibility(this.nmQ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.nmQ.getWriteImagesInfo() != null && this.nmQ.getWriteImagesInfo().isFromQRCode()) {
            this.bvL.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hSW.getPageContext().getPageActivity(), this.bwu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aX(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.nnC = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.nnC.setSelector(R.color.transparent);
        this.nnD = new i(this.hSW, this.nmQ);
        if (this.nmQ.getWriteImagesInfo() != null && this.nmQ.getWriteImagesInfo().isFromQRCode()) {
            this.nnD.xW(false);
        } else {
            this.nnD.xW(true);
        }
        this.nnC.setAdapter((ListAdapter) this.nnD);
        this.nnC.setOuterOnScrollListener(this);
        this.nnD.a(this.nnp);
        this.nnD.a(this.nno);
        this.nnD.al(this.nnn);
        this.nnD.setOnOpenCameraFailedListener(this.nnr);
        this.nnD.setOnRequestPermissionListener(this.nnq);
        this.nmS.setOnClickListener(this.hSW);
        this.bwv.setOnClickListener(this.hSW);
        this.bww.setOnClickListener(this.hSW);
        this.bvN.setOnClickListener(this.hSW);
        this.bwx.setOnClickListener(this.mOnClickListener);
        this.bvL.setOnClickListener(this.mOnClickListener);
        QD();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fGE != null) {
            if (this.bwx.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bwx.getParent()).removeView(this.bwx);
            }
            this.bwC.setVisibility(8);
            this.fGE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bwx, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.fjB == null) {
            this.fjB = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.fjB.setCancelListener(null);
        this.fjB.setTipString(R.string.loading);
        this.fjB.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hSW.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD() {
        int count;
        String string;
        if (this.nmQ != null && this.nmS != null) {
            if (this.nmQ.Qt()) {
                int i = this.nmQ.Qt() ? 1 : 0;
                count = i;
                string = this.hSW.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.nmQ.Qv());
                string = this.hSW.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nmQ.getMaxImagesAllowed())});
            }
            this.nmS.setText(string);
            this.nmS.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bwE = false;
        if (isShow()) {
            Qi();
        }
    }

    private void Qh() {
        if (this.nmQ == null && this.nmM != null) {
            this.nmQ = this.nmM.dNP();
        }
        if (this.nmQ != null) {
            if (!this.nmQ.bxE()) {
                this.nnD.notifyDataSetChanged();
            } else {
                QE();
            }
            cD(this.nmQ.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void QE() {
        if (this.nnA == null) {
            this.nnA = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.nnA.a((this.nmM == null || !this.nmM.dNQ()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.fjB != null) {
                    ImageListFragment.this.fjB.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.nmQ != null && ImageListFragment.this.nnD != null) {
                    ImageListFragment.this.nmQ.c(gVar);
                    String Qx = ImageListFragment.this.nmQ.Qx();
                    ImageListFragment.this.nmQ.hM(Qx);
                    ImageListFragment.this.nnD.setData(ImageListFragment.this.nmQ.hO(Qx));
                    ImageListFragment.this.nnC.smoothScrollToPosition(0);
                    ImageListFragment.this.QD();
                }
                ImageListFragment.this.nnC.QG();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bwD, R.color.cp_bg_line_c, i);
        ap.setViewTextColor(this.bwx, R.color.cp_cont_b, i);
        if (this.bww != null && this.bwv != null) {
            if (this.nmM != null && this.nmM.Qc() == 1) {
                SvgManager.bmU().a(this.bwv, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                this.bww.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bww, R.color.navi_back_text_color);
                this.bwv.setVisibility(8);
            }
        }
        if (this.bwx != null) {
            this.bwx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bmU().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.nnD != null) {
            this.nnD.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.nmQ != null) {
            cD(this.nmQ.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fGE = navigationBar;
    }

    public View QB() {
        return (this.nmM == null || this.nmM.Qc() != 1) ? this.bww : this.bwv;
    }

    public View QF() {
        return this.nmS;
    }

    public TbCameraView dNI() {
        if (this.nnD != null) {
            return this.nnD.dNR();
        }
        return null;
    }

    public TransparentHeadGridView dNT() {
        return this.nnC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.nnB != null) {
            this.nnB.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nnA != null) {
            this.nnA.cancelLoadTask();
        }
        if (this.hSW != null) {
            this.hSW.closeLoadingDialog();
        }
        if (this.fjB != null) {
            this.fjB.setDialogVisiable(false);
        }
        d.dNM().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bwE = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cF(boolean z) {
        Qi();
    }

    private void Qi() {
        if (!isHidden() && !this.bwE) {
            Qh();
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
            this.nnD.cG(true);
        } else if (this.nnD.isScroll()) {
            this.nnD.cG(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.nnC != null) {
            int firstVisiblePosition = this.nnC.getFirstVisiblePosition();
            int lastVisiblePosition = this.nnC.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.nnC.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.nnD != null) {
                    this.nnD.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        QD();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.nnD != null) {
            o(this.nnD.i(imageFileInfo), z);
        }
    }

    public View Qo() {
        return this.bvN;
    }

    public void cD(boolean z) {
        if (this.hSW != null && this.bvN != null) {
            this.bvN.setText(this.hSW.getResources().getString(R.string.original_img));
            if (z) {
                this.bvN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.bvN, R.color.cp_link_tip_a);
                return;
            }
            this.bvN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.bvN, R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.nne = jVar;
    }
}
