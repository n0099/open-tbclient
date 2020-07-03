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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes2.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View biM;
    private TextView biO;
    private View bjD;
    private View bjE;
    private boolean bjF;
    private RelativeLayout bjv;
    private ImageView bjw;
    private TextView bjx;
    private TextView bjy;
    private NavigationBar fbi;
    private BaseFragmentActivity hep;
    private NoDataView mNoDataView;
    private View mView;
    private e mmG;
    private c mmK;
    private TBSpecificationBtn mmM;
    private j mmY;
    private com.baidu.tbadk.album.f mnv;
    private com.baidu.tieba.write.view.a mnw;
    private TransparentHeadGridView mnx;
    private i mny;
    private com.baidu.tbadk.core.view.a eDA = null;
    private View.OnClickListener mnh = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.mmK != null) {
                int maxImagesAllowed = ImageListFragment.this.mmK.getMaxImagesAllowed();
                if (ImageListFragment.this.mmK.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.mmG != null) {
                        ImageListFragment.this.mmG.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.mmK != null) {
                if (ImageListFragment.this.mmY == null || !ImageListFragment.this.mmY.drv()) {
                    if (view == ImageListFragment.this.bjy) {
                        ImageListFragment.this.mnw.b(ImageListFragment.this.mmK.IS(), ImageListFragment.this.mmK.IQ());
                        ImageListFragment.this.mnw.L(ImageListFragment.this.fbi == null ? ImageListFragment.this.bjD : ImageListFragment.this.fbi);
                        ImageListFragment.this.bjy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.biM) {
                    }
                }
            }
        }
    };
    private TbCameraView.c mnk = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bNS() {
            return !ac.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a mnl = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void drs() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bjy != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aWQ().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.bjy.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private g mni = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.mmK != null && ImageListFragment.this.mmK.getWriteImagesInfo() != null && ImageListFragment.this.mmK.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.mmG != null) {
                    ImageListFragment.this.mmG.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.mmK != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.mmK.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.mmG != null) {
                        ImageListFragment.this.mmG.du(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0775a mnz = new a.InterfaceC0775a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0775a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> fO;
            if (ImageListFragment.this.mmK != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.mmK.IQ()) && (fO = ImageListFragment.this.mmK.fO(albumId)) != null) {
                    ImageListFragment.this.mmK.fM(albumId);
                    ImageListFragment.this.mny.setData(fO);
                    ImageListFragment.this.bjy.setText(name);
                    ImageListFragment.this.mnx.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h mnj = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hep == null || ImageListFragment.this.mmK == null || ImageListFragment.this.mmG == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.mmK.IM()) {
                    ImageListFragment.this.hep.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.mmK.isAdded(imageFileInfo)) {
                    ImageListFragment.this.mmG.f(imageFileInfo);
                } else {
                    ImageListFragment.this.mmG.g(imageFileInfo);
                }
                ImageListFragment.this.mmK.a(null);
                ImageListFragment.this.mny.notifyDataSetChanged();
                ImageListFragment.this.IX();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.mmK.IL()) {
                    ImageListFragment.this.hep.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.mmK.b(videoFileInfo)) {
                        ImageListFragment.this.mmK.a(null);
                    } else {
                        ImageListFragment.this.mmK.a(videoFileInfo);
                    }
                    ImageListFragment.this.mmK.IN();
                    ImageListFragment.this.mny.notifyDataSetChanged();
                    ImageListFragment.this.IX();
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
        this.hep = getBaseFragmentActivity();
        if (this.mmG == null) {
            if (this.hep instanceof AlbumFloatActivity) {
                this.mmG = ((AlbumFloatActivity) this.hep).mmG;
            } else if (this.hep instanceof AlbumActivity) {
                this.mmG = ((AlbumActivity) this.hep).mmG;
            }
        }
        if (this.mmG != null) {
            this.mmK = this.mmG.drn();
        }
        d.drk().a(this);
        this.mnv = new com.baidu.tbadk.album.f(this.hep);
        this.mnw = new com.baidu.tieba.write.view.a(this.hep);
        this.mnw.setOnDismissListener(this.mOnDismissListener);
        this.mnw.a(this.mnz);
    }

    public void a(e eVar) {
        this.mmG = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bjv = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bjD = this.mView.findViewById(R.id.layout_title);
        this.bjy = (TextView) this.mView.findViewById(R.id.album_title);
        this.bjw = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bjx = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bjE = this.mView.findViewById(R.id.navi_line);
        this.biM = this.mView.findViewById(R.id.layout_bottom);
        this.biO = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.mmM = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.mmM.setTextSize(R.dimen.tbds34);
        this.mmM.getStyleConfig().mA(l.getDimens(this.hep, R.dimen.tbds25));
        this.mmK.fM(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bjy.setText(this.hep.getPageContext().getString(R.string.album_all_media));
        if (this.mmK.getWriteImagesInfo() != null) {
            this.biO.setVisibility(this.mmK.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.mmK.getWriteImagesInfo() != null && this.mmK.getWriteImagesInfo().isFromQRCode()) {
            this.biM.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hep.getPageContext().getPageActivity(), this.bjv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aP(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.mnx = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.mnx.setSelector(R.color.transparent);
        this.mny = new i(this.hep, this.mmK);
        if (this.mmK.getWriteImagesInfo() != null && this.mmK.getWriteImagesInfo().isFromQRCode()) {
            this.mny.vL(false);
        } else {
            this.mny.vL(true);
        }
        this.mnx.setAdapter((ListAdapter) this.mny);
        this.mnx.setOuterOnScrollListener(this);
        this.mny.a(this.mnj);
        this.mny.a(this.mni);
        this.mny.aj(this.mnh);
        this.mny.setOnOpenCameraFailedListener(this.mnl);
        this.mny.setOnRequestPermissionListener(this.mnk);
        this.mmM.setOnClickListener(this.hep);
        this.bjw.setOnClickListener(this.hep);
        this.bjx.setOnClickListener(this.hep);
        this.biO.setOnClickListener(this.hep);
        this.bjy.setOnClickListener(this.mOnClickListener);
        this.biM.setOnClickListener(this.mOnClickListener);
        IX();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fbi != null) {
            if (this.bjy.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bjy.getParent()).removeView(this.bjy);
            }
            this.bjD.setVisibility(8);
            this.fbi.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bjy, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.eDA == null) {
            this.eDA = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.eDA.setCancelListener(null);
        this.eDA.setTipString(R.string.loading);
        this.eDA.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hep.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        int count;
        String string;
        if (this.mmK != null && this.mmM != null) {
            if (this.mmK.IM()) {
                int i = this.mmK.IM() ? 1 : 0;
                count = i;
                string = this.hep.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = w.getCount(this.mmK.IO());
                string = this.hep.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mmK.getMaxImagesAllowed())});
            }
            this.mmM.setText(string);
            this.mmM.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bjF = false;
        if (isShow()) {
            IB();
        }
    }

    private void IA() {
        if (this.mmK == null && this.mmG != null) {
            this.mmK = this.mmG.drn();
        }
        if (this.mmK != null) {
            if (!this.mmK.IT()) {
                this.mny.notifyDataSetChanged();
            } else {
                IY();
            }
            cn(this.mmK.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void IY() {
        if (this.mnv == null) {
            this.mnv = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.mnv.a((this.mmG == null || !this.mmG.dro()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.eDA != null) {
                    ImageListFragment.this.eDA.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.mmK != null && gVar != null) {
                    ImageListFragment.this.mmK.c(gVar);
                    String IQ = ImageListFragment.this.mmK.IQ();
                    ImageListFragment.this.mmK.fM(IQ);
                    ImageListFragment.this.mny.setData(ImageListFragment.this.mmK.fO(IQ));
                    ImageListFragment.this.mnx.smoothScrollToPosition(0);
                    ImageListFragment.this.IX();
                }
                ImageListFragment.this.mnx.Ja();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        an.setBackgroundColor(this.bjE, R.color.cp_bg_line_c, i);
        an.setViewTextColor(this.bjy, R.color.cp_cont_b, i);
        if (this.mmG != null && this.mmG.Iv() == 1) {
            SvgManager.aWQ().a(this.bjw, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.bjx.setVisibility(8);
        } else {
            an.setViewTextColor(this.bjx, (int) R.color.navi_back_text_color);
            this.bjw.setVisibility(8);
        }
        if (this.bjy != null) {
            this.bjy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.mny != null) {
            this.mny.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.mmK != null) {
            cn(this.mmK.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fbi = navigationBar;
    }

    public View IV() {
        return (this.mmG == null || this.mmG.Iv() != 1) ? this.bjx : this.bjw;
    }

    public View IZ() {
        return this.mmM;
    }

    public TbCameraView drg() {
        if (this.mny != null) {
            return this.mny.drp();
        }
        return null;
    }

    public TransparentHeadGridView drr() {
        return this.mnx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mnw != null) {
            this.mnw.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mnv != null) {
            this.mnv.cancelLoadTask();
        }
        if (this.hep != null) {
            this.hep.closeLoadingDialog();
        }
        if (this.eDA != null) {
            this.eDA.setDialogVisiable(false);
        }
        d.drk().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bjF = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cp(boolean z) {
        IB();
    }

    private void IB() {
        if (!isHidden() && !this.bjF) {
            IA();
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
            this.mny.cq(true);
        } else if (this.mny.isScroll()) {
            this.mny.cq(false);
        }
    }

    public void m(int i, boolean z) {
        if (this.mnx != null) {
            int firstVisiblePosition = this.mnx.getFirstVisiblePosition();
            int lastVisiblePosition = this.mnx.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mnx.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.mny != null) {
                    this.mny.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        IX();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.mny != null) {
            m(this.mny.i(imageFileInfo), z);
        }
    }

    public View IH() {
        return this.biO;
    }

    public void cn(boolean z) {
        if (this.hep != null && this.biO != null) {
            this.biO.setText(this.hep.getResources().getString(R.string.original_img));
            if (z) {
                this.biO.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                an.setViewTextColor(this.biO, (int) R.color.cp_link_tip_a);
                return;
            }
            this.biO.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            an.setViewTextColor(this.biO, (int) R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.mmY = jVar;
    }
}
