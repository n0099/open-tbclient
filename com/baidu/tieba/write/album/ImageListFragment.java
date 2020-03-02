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
    private RelativeLayout aCQ;
    private ImageView aCR;
    private TextView aCS;
    private TextView aCT;
    private View aCY;
    private View aCZ;
    private View aCn;
    private TextView aCo;
    private TextView aCp;
    private boolean isPaused;
    private c kMH;
    private i kML;
    private AlbumActivity kMN;
    private com.baidu.tbadk.album.f kNm;
    private com.baidu.tieba.write.view.a kNn;
    private TransparentHeadGridView kNo;
    private h kNp;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a dFT = null;
    private View.OnClickListener kMZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.kMH != null) {
                int maxImagesAllowed = ImageListFragment.this.kMH.getMaxImagesAllowed();
                if (ImageListFragment.this.kMH.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.kMN != null) {
                        ImageListFragment.this.kMN.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.kMH != null) {
                if (ImageListFragment.this.kML == null || !ImageListFragment.this.kML.cUK()) {
                    if (view == ImageListFragment.this.aCT) {
                        ImageListFragment.this.kNn.b(ImageListFragment.this.kMH.AK(), ImageListFragment.this.kMH.AI());
                        ImageListFragment.this.kNn.R(ImageListFragment.this.aCY);
                        ImageListFragment.this.aCT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.aCn) {
                    }
                }
            }
        }
    };
    private TbCameraView.c kNc = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean buD() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a kNd = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cUH() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aCT != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aCT.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f kNa = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.kMH != null && ImageListFragment.this.kMH.getWriteImagesInfo() != null && ImageListFragment.this.kMH.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.kMN.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.kMH != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.kMH.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.kMN.cM(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0638a kNq = new a.InterfaceC0638a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0638a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ec;
            if (ImageListFragment.this.kMH != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.kMH.AI()) && (ec = ImageListFragment.this.kMH.ec(albumId)) != null) {
                    ImageListFragment.this.kMH.ea(albumId);
                    ImageListFragment.this.kNp.setData(ec);
                    ImageListFragment.this.aCT.setText(name);
                    ImageListFragment.this.kNo.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g kNb = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.kMN == null || ImageListFragment.this.kMH == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.kMH.AE()) {
                    ImageListFragment.this.kMN.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.kMH.isAdded(imageFileInfo)) {
                    ImageListFragment.this.kMN.f(imageFileInfo);
                } else {
                    ImageListFragment.this.kMN.e(imageFileInfo);
                }
                ImageListFragment.this.kMH.a(null);
                ImageListFragment.this.kNp.notifyDataSetChanged();
                ImageListFragment.this.AN();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.kMH.AD()) {
                    ImageListFragment.this.kMN.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.kMH.b(videoFileInfo)) {
                        ImageListFragment.this.kMH.a(null);
                    } else {
                        ImageListFragment.this.kMH.a(videoFileInfo);
                    }
                    ImageListFragment.this.kMH.AF();
                    ImageListFragment.this.kNp.notifyDataSetChanged();
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
        this.kMN = (AlbumActivity) getBaseFragmentActivity();
        this.kMH = this.kMN.cUA();
        d.cUD().a(this);
        this.kNm = new com.baidu.tbadk.album.f(this.kMN);
        this.kNn = new com.baidu.tieba.write.view.a(this.kMN);
        this.kNn.setOnDismissListener(this.mOnDismissListener);
        this.kNn.a(this.kNq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aCQ = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aCY = this.mView.findViewById(R.id.layout_title);
        this.aCT = (TextView) this.mView.findViewById(R.id.album_title);
        this.aCR = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aCS = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aCZ = this.mView.findViewById(R.id.navi_line);
        this.aCn = this.mView.findViewById(R.id.layout_bottom);
        this.aCp = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.aCo = (TextView) this.mView.findViewById(R.id.next_step);
        this.kMH.ea(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aCT.setText(this.kMN.getPageContext().getString(R.string.album_all_media));
        if (this.kMH.getWriteImagesInfo() != null) {
            this.aCp.setVisibility(this.kMH.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.kMH.getWriteImagesInfo() != null && this.kMH.getWriteImagesInfo().isFromQRCode()) {
            this.aCn.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.kMN.getPageContext().getPageActivity(), this.aCQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aF(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.kNo = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.kNo.setSelector(R.color.transparent);
        this.kNp = new h(this.kMN, this.kMH);
        if (this.kMH.getWriteImagesInfo() != null && this.kMH.getWriteImagesInfo().isFromQRCode()) {
            this.kNp.tM(false);
        } else {
            this.kNp.tM(this.kMN.An() != 1);
        }
        this.kNo.setAdapter((ListAdapter) this.kNp);
        this.kNo.setOuterOnScrollListener(this);
        this.kNp.a(this.kNb);
        this.kNp.a(this.kNa);
        this.kNp.af(this.kMZ);
        this.kNp.setOnOpenCameraFailedListener(this.kNd);
        this.kNp.setOnRequestPermissionListener(this.kNc);
        this.aCo.setOnClickListener(this.kMN);
        this.aCR.setOnClickListener(this.kMN);
        this.aCS.setOnClickListener(this.kMN);
        this.aCp.setOnClickListener(this.kMN);
        this.aCT.setOnClickListener(this.mOnClickListener);
        this.aCn.setOnClickListener(this.mOnClickListener);
        AN();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.dFT == null) {
            this.dFT = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.dFT.setCancelListener(null);
        this.dFT.setTipString(R.string.loading);
        this.dFT.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.kMN.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN() {
        int count;
        String string;
        if (this.kMH != null && this.aCo != null) {
            if (this.kMH.AE()) {
                int i = this.kMH.AE() ? 1 : 0;
                count = i;
                string = this.kMN.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.kMH.AG());
                string = this.kMN.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kMH.getMaxImagesAllowed())});
            }
            this.aCo.setText(string);
            this.aCo.setEnabled(count > 0);
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
        if (this.kMH == null && this.kMN != null) {
            this.kMH = this.kMN.cUA();
        }
        if (this.kMH != null) {
            if (!this.kMH.AL()) {
                this.kNp.notifyDataSetChanged();
            } else {
                AO();
            }
            bt(this.kMH.isOriginalImg());
        }
    }

    private void AO() {
        if (this.kNm == null) {
            this.kNm = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.kNm.a(this.kMN.An() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.dFT != null) {
                    ImageListFragment.this.dFT.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.kMH != null && gVar != null) {
                    ImageListFragment.this.kMH.c(gVar);
                    String AI = ImageListFragment.this.kMH.AI();
                    ImageListFragment.this.kMH.ea(AI);
                    ImageListFragment.this.kNp.setData(ImageListFragment.this.kMH.ec(AI));
                    ImageListFragment.this.kNo.smoothScrollToPosition(0);
                    ImageListFragment.this.AN();
                }
                ImageListFragment.this.kNo.AQ();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aCZ, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aCT, R.color.cp_cont_b, i);
        if (this.kMN.An() == 1) {
            SvgManager.aGC().a(this.aCR, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.aCS.setVisibility(8);
        } else {
            am.setViewTextColor(this.aCS, (int) R.color.navi_back_text_color);
            this.aCR.setVisibility(8);
        }
        if (this.aCT != null) {
            this.aCT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.kNp != null) {
            this.kNp.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kMH != null) {
            bt(this.kMH.isOriginalImg());
        }
    }

    public View AA() {
        return this.kMN.An() == 1 ? this.aCR : this.aCS;
    }

    public View AP() {
        return this.aCo;
    }

    public TbCameraView cUB() {
        if (this.kNp != null) {
            return this.kNp.cUE();
        }
        return null;
    }

    public TransparentHeadGridView cUG() {
        return this.kNo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.kNn != null) {
            this.kNn.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kNm != null) {
            this.kNm.cancelLoadTask();
        }
        if (this.kMN != null) {
            this.kMN.closeLoadingDialog();
        }
        if (this.dFT != null) {
            this.dFT.setDialogVisiable(false);
        }
        d.cUD().b(this);
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
            this.kNp.bw(true);
        } else if (this.kNp.isScroll()) {
            this.kNp.bw(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.kNo != null) {
            int firstVisiblePosition = this.kNo.getFirstVisiblePosition();
            int lastVisiblePosition = this.kNo.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.kNo.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.kNp != null) {
                    this.kNp.b((ImageView) childAt.findViewById(R.id.select_icon), z);
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
        if (imageFileInfo != null && this.kNp != null) {
            i(this.kNp.i(imageFileInfo), z);
        }
    }

    public View Aw() {
        return this.aCp;
    }

    public void bt(boolean z) {
        if (this.kMN != null && this.aCp != null) {
            this.aCp.setText(this.kMN.getResources().getString(R.string.original_img));
            if (z) {
                this.aCp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.aCp, (int) R.color.cp_link_tip_a);
                return;
            }
            this.aCp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.aCp, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.kML = iVar;
    }
}
