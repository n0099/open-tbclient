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
    private RelativeLayout aCR;
    private ImageView aCS;
    private TextView aCT;
    private TextView aCU;
    private View aCZ;
    private View aCo;
    private TextView aCp;
    private TextView aCq;
    private View aDa;
    private boolean isPaused;
    private c kMT;
    private i kMX;
    private AlbumActivity kMZ;
    private TransparentHeadGridView kNA;
    private h kNB;
    private com.baidu.tbadk.album.f kNy;
    private com.baidu.tieba.write.view.a kNz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a dGg = null;
    private View.OnClickListener kNl = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.kMT != null) {
                int maxImagesAllowed = ImageListFragment.this.kMT.getMaxImagesAllowed();
                if (ImageListFragment.this.kMT.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.kMZ != null) {
                        ImageListFragment.this.kMZ.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.kMT != null) {
                if (ImageListFragment.this.kMX == null || !ImageListFragment.this.kMX.cUL()) {
                    if (view == ImageListFragment.this.aCU) {
                        ImageListFragment.this.kNz.b(ImageListFragment.this.kMT.AK(), ImageListFragment.this.kMT.AI());
                        ImageListFragment.this.kNz.R(ImageListFragment.this.aCZ);
                        ImageListFragment.this.aCU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.aCo) {
                    }
                }
            }
        }
    };
    private TbCameraView.c kNo = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean buE() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a kNp = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cUI() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aCU != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aCU.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f kNm = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.kMT != null && ImageListFragment.this.kMT.getWriteImagesInfo() != null && ImageListFragment.this.kMT.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.kMZ.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.kMT != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.kMT.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.kMZ.cM(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0638a kNC = new a.InterfaceC0638a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0638a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ec;
            if (ImageListFragment.this.kMT != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.kMT.AI()) && (ec = ImageListFragment.this.kMT.ec(albumId)) != null) {
                    ImageListFragment.this.kMT.ea(albumId);
                    ImageListFragment.this.kNB.setData(ec);
                    ImageListFragment.this.aCU.setText(name);
                    ImageListFragment.this.kNA.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g kNn = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.kMZ == null || ImageListFragment.this.kMT == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.kMT.AE()) {
                    ImageListFragment.this.kMZ.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.kMT.isAdded(imageFileInfo)) {
                    ImageListFragment.this.kMZ.f(imageFileInfo);
                } else {
                    ImageListFragment.this.kMZ.e(imageFileInfo);
                }
                ImageListFragment.this.kMT.a(null);
                ImageListFragment.this.kNB.notifyDataSetChanged();
                ImageListFragment.this.AN();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.kMT.AD()) {
                    ImageListFragment.this.kMZ.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.kMT.b(videoFileInfo)) {
                        ImageListFragment.this.kMT.a(null);
                    } else {
                        ImageListFragment.this.kMT.a(videoFileInfo);
                    }
                    ImageListFragment.this.kMT.AF();
                    ImageListFragment.this.kNB.notifyDataSetChanged();
                    ImageListFragment.this.AN();
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
        this.kMZ = (AlbumActivity) getBaseFragmentActivity();
        this.kMT = this.kMZ.cUB();
        d.cUE().a(this);
        this.kNy = new com.baidu.tbadk.album.f(this.kMZ);
        this.kNz = new com.baidu.tieba.write.view.a(this.kMZ);
        this.kNz.setOnDismissListener(this.mOnDismissListener);
        this.kNz.a(this.kNC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aCR = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aCZ = this.mView.findViewById(R.id.layout_title);
        this.aCU = (TextView) this.mView.findViewById(R.id.album_title);
        this.aCS = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aCT = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aDa = this.mView.findViewById(R.id.navi_line);
        this.aCo = this.mView.findViewById(R.id.layout_bottom);
        this.aCq = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.aCp = (TextView) this.mView.findViewById(R.id.next_step);
        this.kMT.ea(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aCU.setText(this.kMZ.getPageContext().getString(R.string.album_all_media));
        if (this.kMT.getWriteImagesInfo() != null) {
            this.aCq.setVisibility(this.kMT.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.kMT.getWriteImagesInfo() != null && this.kMT.getWriteImagesInfo().isFromQRCode()) {
            this.aCo.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.kMZ.getPageContext().getPageActivity(), this.aCR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aF(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.kNA = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.kNA.setSelector(R.color.transparent);
        this.kNB = new h(this.kMZ, this.kMT);
        if (this.kMT.getWriteImagesInfo() != null && this.kMT.getWriteImagesInfo().isFromQRCode()) {
            this.kNB.tM(false);
        } else {
            this.kNB.tM(this.kMZ.An() != 1);
        }
        this.kNA.setAdapter((ListAdapter) this.kNB);
        this.kNA.setOuterOnScrollListener(this);
        this.kNB.a(this.kNn);
        this.kNB.a(this.kNm);
        this.kNB.af(this.kNl);
        this.kNB.setOnOpenCameraFailedListener(this.kNp);
        this.kNB.setOnRequestPermissionListener(this.kNo);
        this.aCp.setOnClickListener(this.kMZ);
        this.aCS.setOnClickListener(this.kMZ);
        this.aCT.setOnClickListener(this.kMZ);
        this.aCq.setOnClickListener(this.kMZ);
        this.aCU.setOnClickListener(this.mOnClickListener);
        this.aCo.setOnClickListener(this.mOnClickListener);
        AN();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.dGg == null) {
            this.dGg = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.dGg.setCancelListener(null);
        this.dGg.setTipString(R.string.loading);
        this.dGg.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.kMZ.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN() {
        int count;
        String string;
        if (this.kMT != null && this.aCp != null) {
            if (this.kMT.AE()) {
                int i = this.kMT.AE() ? 1 : 0;
                count = i;
                string = this.kMZ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.kMT.AG());
                string = this.kMZ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kMT.getMaxImagesAllowed())});
            }
            this.aCp.setText(string);
            this.aCp.setEnabled(count > 0);
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
            AC();
        }
    }

    private void Az() {
        if (this.kMT == null && this.kMZ != null) {
            this.kMT = this.kMZ.cUB();
        }
        if (this.kMT != null) {
            if (!this.kMT.AL()) {
                this.kNB.notifyDataSetChanged();
            } else {
                AO();
            }
            bt(this.kMT.isOriginalImg());
        }
    }

    private void AO() {
        if (this.kNy == null) {
            this.kNy = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.kNy.a(this.kMZ.An() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.dGg != null) {
                    ImageListFragment.this.dGg.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.kMT != null && gVar != null) {
                    ImageListFragment.this.kMT.c(gVar);
                    String AI = ImageListFragment.this.kMT.AI();
                    ImageListFragment.this.kMT.ea(AI);
                    ImageListFragment.this.kNB.setData(ImageListFragment.this.kMT.ec(AI));
                    ImageListFragment.this.kNA.smoothScrollToPosition(0);
                    ImageListFragment.this.AN();
                }
                ImageListFragment.this.kNA.AQ();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aDa, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aCU, R.color.cp_cont_b, i);
        if (this.kMZ.An() == 1) {
            SvgManager.aGC().a(this.aCS, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.aCT.setVisibility(8);
        } else {
            am.setViewTextColor(this.aCT, (int) R.color.navi_back_text_color);
            this.aCS.setVisibility(8);
        }
        if (this.aCU != null) {
            this.aCU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.kNB != null) {
            this.kNB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kMT != null) {
            bt(this.kMT.isOriginalImg());
        }
    }

    public View AA() {
        return this.kMZ.An() == 1 ? this.aCS : this.aCT;
    }

    public View AP() {
        return this.aCp;
    }

    public TbCameraView cUC() {
        if (this.kNB != null) {
            return this.kNB.cUF();
        }
        return null;
    }

    public TransparentHeadGridView cUH() {
        return this.kNA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.kNz != null) {
            this.kNz.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kNy != null) {
            this.kNy.cancelLoadTask();
        }
        if (this.kMZ != null) {
            this.kMZ.closeLoadingDialog();
        }
        if (this.dGg != null) {
            this.dGg.setDialogVisiable(false);
        }
        d.cUE().b(this);
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
    public void bv(boolean z) {
        AC();
    }

    private void AC() {
        if (!isHidden() && !this.isPaused) {
            Az();
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
            this.kNB.bw(true);
        } else if (this.kNB.isScroll()) {
            this.kNB.bw(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.kNA != null) {
            int firstVisiblePosition = this.kNA.getFirstVisiblePosition();
            int lastVisiblePosition = this.kNA.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.kNA.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.kNB != null) {
                    this.kNB.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        AN();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.kNB != null) {
            i(this.kNB.i(imageFileInfo), z);
        }
    }

    public View Aw() {
        return this.aCq;
    }

    public void bt(boolean z) {
        if (this.kMZ != null && this.aCq != null) {
            this.aCq.setText(this.kMZ.getResources().getString(R.string.original_img));
            if (z) {
                this.aCq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.aCq, (int) R.color.cp_link_tip_a);
                return;
            }
            this.aCq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.aCq, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.kMX = iVar;
    }
}
