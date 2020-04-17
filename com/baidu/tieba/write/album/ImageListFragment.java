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
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes2.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private RelativeLayout aWM;
    private ImageView aWN;
    private TextView aWO;
    private TextView aWP;
    private View aWU;
    private View aWV;
    private boolean aWW;
    private View aWj;
    private TextView aWk;
    private TextView aWl;
    private c lxT;
    private i lxX;
    private com.baidu.tbadk.album.f lyA;
    private com.baidu.tieba.write.view.a lyB;
    private TransparentHeadGridView lyC;
    private h lyD;
    private AlbumActivity lya;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a egd = null;
    private View.OnClickListener lym = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.lxT != null) {
                int maxImagesAllowed = ImageListFragment.this.lxT.getMaxImagesAllowed();
                if (ImageListFragment.this.lxT.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.lya != null) {
                        ImageListFragment.this.lya.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.lxT != null) {
                if (ImageListFragment.this.lxX == null || !ImageListFragment.this.lxX.dfC()) {
                    if (view == ImageListFragment.this.aWP) {
                        ImageListFragment.this.lyB.b(ImageListFragment.this.lxT.FP(), ImageListFragment.this.lxT.FN());
                        ImageListFragment.this.lyB.T(ImageListFragment.this.aWU);
                        ImageListFragment.this.aWP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.aWj) {
                    }
                }
            }
        }
    };
    private TbCameraView.c lyq = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bEv() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a lyr = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dfz() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aWP != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aOU().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aWP.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f lyn = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.lxT != null && ImageListFragment.this.lxT.getWriteImagesInfo() != null && ImageListFragment.this.lxT.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.lya.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.lxT != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.lxT.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.lya.db(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0684a lyE = new a.InterfaceC0684a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0684a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> eU;
            if (ImageListFragment.this.lxT != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.lxT.FN()) && (eU = ImageListFragment.this.lxT.eU(albumId)) != null) {
                    ImageListFragment.this.lxT.eS(albumId);
                    ImageListFragment.this.lyD.setData(eU);
                    ImageListFragment.this.aWP.setText(name);
                    ImageListFragment.this.lyC.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g lyp = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.lya == null || ImageListFragment.this.lxT == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.lxT.FJ()) {
                    ImageListFragment.this.lya.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.lxT.isAdded(imageFileInfo)) {
                    ImageListFragment.this.lya.f(imageFileInfo);
                } else {
                    ImageListFragment.this.lya.e(imageFileInfo);
                }
                ImageListFragment.this.lxT.a(null);
                ImageListFragment.this.lyD.notifyDataSetChanged();
                ImageListFragment.this.FS();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.lxT.FI()) {
                    ImageListFragment.this.lya.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.lxT.b(videoFileInfo)) {
                        ImageListFragment.this.lxT.a(null);
                    } else {
                        ImageListFragment.this.lxT.a(videoFileInfo);
                    }
                    ImageListFragment.this.lxT.FK();
                    ImageListFragment.this.lyD.notifyDataSetChanged();
                    ImageListFragment.this.FS();
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
        this.lya = (AlbumActivity) getBaseFragmentActivity();
        this.lxT = this.lya.dfs();
        d.dfv().a(this);
        this.lyA = new com.baidu.tbadk.album.f(this.lya);
        this.lyB = new com.baidu.tieba.write.view.a(this.lya);
        this.lyB.setOnDismissListener(this.mOnDismissListener);
        this.lyB.a(this.lyE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aWM = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aWU = this.mView.findViewById(R.id.layout_title);
        this.aWP = (TextView) this.mView.findViewById(R.id.album_title);
        this.aWN = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aWO = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aWV = this.mView.findViewById(R.id.navi_line);
        this.aWj = this.mView.findViewById(R.id.layout_bottom);
        this.aWl = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.aWk = (TextView) this.mView.findViewById(R.id.next_step);
        this.lxT.eS(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aWP.setText(this.lya.getPageContext().getString(R.string.album_all_media));
        if (this.lxT.getWriteImagesInfo() != null) {
            this.aWl.setVisibility(this.lxT.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.lxT.getWriteImagesInfo() != null && this.lxT.getWriteImagesInfo().isFromQRCode()) {
            this.aWj.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.lya.getPageContext().getPageActivity(), this.aWM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aJ(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.lyC = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.lyC.setSelector(R.color.transparent);
        this.lyD = new h(this.lya, this.lxT);
        if (this.lxT.getWriteImagesInfo() != null && this.lxT.getWriteImagesInfo().isFromQRCode()) {
            this.lyD.uT(false);
        } else {
            this.lyD.uT(this.lya.Fs() != 1);
        }
        this.lyC.setAdapter((ListAdapter) this.lyD);
        this.lyC.setOuterOnScrollListener(this);
        this.lyD.a(this.lyp);
        this.lyD.a(this.lyn);
        this.lyD.ai(this.lym);
        this.lyD.setOnOpenCameraFailedListener(this.lyr);
        this.lyD.setOnRequestPermissionListener(this.lyq);
        this.aWk.setOnClickListener(this.lya);
        this.aWN.setOnClickListener(this.lya);
        this.aWO.setOnClickListener(this.lya);
        this.aWl.setOnClickListener(this.lya);
        this.aWP.setOnClickListener(this.mOnClickListener);
        this.aWj.setOnClickListener(this.mOnClickListener);
        FS();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.egd == null) {
            this.egd = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.egd.setCancelListener(null);
        this.egd.setTipString(R.string.loading);
        this.egd.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.lya.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS() {
        int count;
        String string;
        if (this.lxT != null && this.aWk != null) {
            if (this.lxT.FJ()) {
                int i = this.lxT.FJ() ? 1 : 0;
                count = i;
                string = this.lya.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.lxT.FL());
                string = this.lya.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.lxT.getMaxImagesAllowed())});
            }
            this.aWk.setText(string);
            this.aWk.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aWW = false;
        if (isShow()) {
            FH();
        }
    }

    private void FE() {
        if (this.lxT == null && this.lya != null) {
            this.lxT = this.lya.dfs();
        }
        if (this.lxT != null) {
            if (!this.lxT.FQ()) {
                this.lyD.notifyDataSetChanged();
            } else {
                FT();
            }
            bY(this.lxT.isOriginalImg());
        }
    }

    private void FT() {
        if (this.lyA == null) {
            this.lyA = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.lyA.a(this.lya.Fs() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.egd != null) {
                    ImageListFragment.this.egd.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.lxT != null && gVar != null) {
                    ImageListFragment.this.lxT.c(gVar);
                    String FN = ImageListFragment.this.lxT.FN();
                    ImageListFragment.this.lxT.eS(FN);
                    ImageListFragment.this.lyD.setData(ImageListFragment.this.lxT.eU(FN));
                    ImageListFragment.this.lyC.smoothScrollToPosition(0);
                    ImageListFragment.this.FS();
                }
                ImageListFragment.this.lyC.FV();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aWV, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aWP, R.color.cp_cont_b, i);
        if (this.lya.Fs() == 1) {
            SvgManager.aOU().a(this.aWN, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.aWO.setVisibility(8);
        } else {
            am.setViewTextColor(this.aWO, (int) R.color.navi_back_text_color);
            this.aWN.setVisibility(8);
        }
        if (this.aWP != null) {
            this.aWP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.lyD != null) {
            this.lyD.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.lxT != null) {
            bY(this.lxT.isOriginalImg());
        }
    }

    public View FF() {
        return this.lya.Fs() == 1 ? this.aWN : this.aWO;
    }

    public View FU() {
        return this.aWk;
    }

    public TbCameraView dft() {
        if (this.lyD != null) {
            return this.lyD.dfw();
        }
        return null;
    }

    public TransparentHeadGridView dfy() {
        return this.lyC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.lyB != null) {
            this.lyB.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lyA != null) {
            this.lyA.cancelLoadTask();
        }
        if (this.lya != null) {
            this.lya.closeLoadingDialog();
        }
        if (this.egd != null) {
            this.egd.setDialogVisiable(false);
        }
        d.dfv().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aWW = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void ca(boolean z) {
        FH();
    }

    private void FH() {
        if (!isHidden() && !this.aWW) {
            FE();
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
            this.lyD.cb(true);
        } else if (this.lyD.isScroll()) {
            this.lyD.cb(false);
        }
    }

    public void l(int i, boolean z) {
        if (this.lyC != null) {
            int firstVisiblePosition = this.lyC.getFirstVisiblePosition();
            int lastVisiblePosition = this.lyC.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.lyC.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.lyD != null) {
                    this.lyD.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        FS();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.lyD != null) {
            l(this.lyD.i(imageFileInfo), z);
        }
    }

    public View FB() {
        return this.aWl;
    }

    public void bY(boolean z) {
        if (this.lya != null && this.aWl != null) {
            this.aWl.setText(this.lya.getResources().getString(R.string.original_img));
            if (z) {
                this.aWl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.aWl, (int) R.color.cp_link_tip_a);
                return;
            }
            this.aWl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.aWl, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.lxX = iVar;
    }
}
