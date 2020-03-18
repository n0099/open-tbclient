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
/* loaded from: classes13.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View aCC;
    private TextView aCD;
    private TextView aCE;
    private RelativeLayout aDf;
    private ImageView aDg;
    private TextView aDh;
    private TextView aDi;
    private View aDn;
    private View aDo;
    private boolean isPaused;
    private c kOC;
    private i kOG;
    private AlbumActivity kOJ;
    private com.baidu.tbadk.album.f kPi;
    private com.baidu.tieba.write.view.a kPj;
    private TransparentHeadGridView kPk;
    private h kPl;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a dGw = null;
    private View.OnClickListener kOV = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.kOC != null) {
                int maxImagesAllowed = ImageListFragment.this.kOC.getMaxImagesAllowed();
                if (ImageListFragment.this.kOC.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.kOJ != null) {
                        ImageListFragment.this.kOJ.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.kOC != null) {
                if (ImageListFragment.this.kOG == null || !ImageListFragment.this.kOG.cVg()) {
                    if (view == ImageListFragment.this.aDi) {
                        ImageListFragment.this.kPj.b(ImageListFragment.this.kOC.AR(), ImageListFragment.this.kOC.AP());
                        ImageListFragment.this.kPj.R(ImageListFragment.this.aDn);
                        ImageListFragment.this.aDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.aCC) {
                    }
                }
            }
        }
    };
    private TbCameraView.c kOY = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean buJ() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a kOZ = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cVd() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aDi != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aGG().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aDi.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f kOW = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.kOC != null && ImageListFragment.this.kOC.getWriteImagesInfo() != null && ImageListFragment.this.kOC.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.kOJ.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.kOC != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.kOC.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.kOJ.cM(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0639a kPm = new a.InterfaceC0639a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0639a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> eb;
            if (ImageListFragment.this.kOC != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.kOC.AP()) && (eb = ImageListFragment.this.kOC.eb(albumId)) != null) {
                    ImageListFragment.this.kOC.dZ(albumId);
                    ImageListFragment.this.kPl.setData(eb);
                    ImageListFragment.this.aDi.setText(name);
                    ImageListFragment.this.kPk.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g kOX = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.kOJ == null || ImageListFragment.this.kOC == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.kOC.AL()) {
                    ImageListFragment.this.kOJ.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.kOC.isAdded(imageFileInfo)) {
                    ImageListFragment.this.kOJ.f(imageFileInfo);
                } else {
                    ImageListFragment.this.kOJ.e(imageFileInfo);
                }
                ImageListFragment.this.kOC.a(null);
                ImageListFragment.this.kPl.notifyDataSetChanged();
                ImageListFragment.this.AU();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.kOC.AK()) {
                    ImageListFragment.this.kOJ.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.kOC.b(videoFileInfo)) {
                        ImageListFragment.this.kOC.a(null);
                    } else {
                        ImageListFragment.this.kOC.a(videoFileInfo);
                    }
                    ImageListFragment.this.kOC.AM();
                    ImageListFragment.this.kPl.notifyDataSetChanged();
                    ImageListFragment.this.AU();
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
        this.kOJ = (AlbumActivity) getBaseFragmentActivity();
        this.kOC = this.kOJ.cUW();
        d.cUZ().a(this);
        this.kPi = new com.baidu.tbadk.album.f(this.kOJ);
        this.kPj = new com.baidu.tieba.write.view.a(this.kOJ);
        this.kPj.setOnDismissListener(this.mOnDismissListener);
        this.kPj.a(this.kPm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aDf = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aDn = this.mView.findViewById(R.id.layout_title);
        this.aDi = (TextView) this.mView.findViewById(R.id.album_title);
        this.aDg = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aDh = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aDo = this.mView.findViewById(R.id.navi_line);
        this.aCC = this.mView.findViewById(R.id.layout_bottom);
        this.aCE = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.aCD = (TextView) this.mView.findViewById(R.id.next_step);
        this.kOC.dZ(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aDi.setText(this.kOJ.getPageContext().getString(R.string.album_all_media));
        if (this.kOC.getWriteImagesInfo() != null) {
            this.aCE.setVisibility(this.kOC.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.kOC.getWriteImagesInfo() != null && this.kOC.getWriteImagesInfo().isFromQRCode()) {
            this.aCC.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.kOJ.getPageContext().getPageActivity(), this.aDf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aF(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.kPk = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.kPk.setSelector(R.color.transparent);
        this.kPl = new h(this.kOJ, this.kOC);
        if (this.kOC.getWriteImagesInfo() != null && this.kOC.getWriteImagesInfo().isFromQRCode()) {
            this.kPl.tT(false);
        } else {
            this.kPl.tT(this.kOJ.Au() != 1);
        }
        this.kPk.setAdapter((ListAdapter) this.kPl);
        this.kPk.setOuterOnScrollListener(this);
        this.kPl.a(this.kOX);
        this.kPl.a(this.kOW);
        this.kPl.af(this.kOV);
        this.kPl.setOnOpenCameraFailedListener(this.kOZ);
        this.kPl.setOnRequestPermissionListener(this.kOY);
        this.aCD.setOnClickListener(this.kOJ);
        this.aDg.setOnClickListener(this.kOJ);
        this.aDh.setOnClickListener(this.kOJ);
        this.aCE.setOnClickListener(this.kOJ);
        this.aDi.setOnClickListener(this.mOnClickListener);
        this.aCC.setOnClickListener(this.mOnClickListener);
        AU();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.dGw == null) {
            this.dGw = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.dGw.setCancelListener(null);
        this.dGw.setTipString(R.string.loading);
        this.dGw.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.kOJ.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        int count;
        String string;
        if (this.kOC != null && this.aCD != null) {
            if (this.kOC.AL()) {
                int i = this.kOC.AL() ? 1 : 0;
                count = i;
                string = this.kOJ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.kOC.AN());
                string = this.kOJ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kOC.getMaxImagesAllowed())});
            }
            this.aCD.setText(string);
            this.aCD.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (isShow()) {
            AJ();
        }
    }

    private void AG() {
        if (this.kOC == null && this.kOJ != null) {
            this.kOC = this.kOJ.cUW();
        }
        if (this.kOC != null) {
            if (!this.kOC.AS()) {
                this.kPl.notifyDataSetChanged();
            } else {
                AV();
            }
            bu(this.kOC.isOriginalImg());
        }
    }

    private void AV() {
        if (this.kPi == null) {
            this.kPi = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.kPi.a(this.kOJ.Au() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.dGw != null) {
                    ImageListFragment.this.dGw.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.kOC != null && gVar != null) {
                    ImageListFragment.this.kOC.c(gVar);
                    String AP = ImageListFragment.this.kOC.AP();
                    ImageListFragment.this.kOC.dZ(AP);
                    ImageListFragment.this.kPl.setData(ImageListFragment.this.kOC.eb(AP));
                    ImageListFragment.this.kPk.smoothScrollToPosition(0);
                    ImageListFragment.this.AU();
                }
                ImageListFragment.this.kPk.AX();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aDo, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aDi, R.color.cp_cont_b, i);
        if (this.kOJ.Au() == 1) {
            SvgManager.aGG().a(this.aDg, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.aDh.setVisibility(8);
        } else {
            am.setViewTextColor(this.aDh, (int) R.color.navi_back_text_color);
            this.aDg.setVisibility(8);
        }
        if (this.aDi != null) {
            this.aDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.kPl != null) {
            this.kPl.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kOC != null) {
            bu(this.kOC.isOriginalImg());
        }
    }

    public View AH() {
        return this.kOJ.Au() == 1 ? this.aDg : this.aDh;
    }

    public View AW() {
        return this.aCD;
    }

    public TbCameraView cUX() {
        if (this.kPl != null) {
            return this.kPl.cVa();
        }
        return null;
    }

    public TransparentHeadGridView cVc() {
        return this.kPk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.kPj != null) {
            this.kPj.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kPi != null) {
            this.kPi.cancelLoadTask();
        }
        if (this.kOJ != null) {
            this.kOJ.closeLoadingDialog();
        }
        if (this.dGw != null) {
            this.dGw.setDialogVisiable(false);
        }
        d.cUZ().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void bw(boolean z) {
        AJ();
    }

    private void AJ() {
        if (!isHidden() && !this.isPaused) {
            AG();
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
            this.kPl.bx(true);
        } else if (this.kPl.isScroll()) {
            this.kPl.bx(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.kPk != null) {
            int firstVisiblePosition = this.kPk.getFirstVisiblePosition();
            int lastVisiblePosition = this.kPk.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.kPk.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.kPl != null) {
                    this.kPl.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        AU();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.kPl != null) {
            i(this.kPl.i(imageFileInfo), z);
        }
    }

    public View AD() {
        return this.aCE;
    }

    public void bu(boolean z) {
        if (this.kOJ != null && this.aCE != null) {
            this.aCE.setText(this.kOJ.getResources().getString(R.string.original_img));
            if (z) {
                this.aCE.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.aCE, (int) R.color.cp_link_tip_a);
                return;
            }
            this.aCE.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.aCE, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.kOG = iVar;
    }
}
