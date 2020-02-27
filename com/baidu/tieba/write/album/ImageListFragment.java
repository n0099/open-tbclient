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
    private RelativeLayout aCP;
    private ImageView aCQ;
    private TextView aCR;
    private TextView aCS;
    private View aCX;
    private View aCY;
    private View aCm;
    private TextView aCn;
    private TextView aCo;
    private boolean isPaused;
    private c kMF;
    private i kMJ;
    private AlbumActivity kML;
    private com.baidu.tbadk.album.f kNk;
    private com.baidu.tieba.write.view.a kNl;
    private TransparentHeadGridView kNm;
    private h kNn;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a dFS = null;
    private View.OnClickListener kMX = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.kMF != null) {
                int maxImagesAllowed = ImageListFragment.this.kMF.getMaxImagesAllowed();
                if (ImageListFragment.this.kMF.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.kML != null) {
                        ImageListFragment.this.kML.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.kMF != null) {
                if (ImageListFragment.this.kMJ == null || !ImageListFragment.this.kMJ.cUI()) {
                    if (view == ImageListFragment.this.aCS) {
                        ImageListFragment.this.kNl.b(ImageListFragment.this.kMF.AI(), ImageListFragment.this.kMF.AG());
                        ImageListFragment.this.kNl.R(ImageListFragment.this.aCX);
                        ImageListFragment.this.aCS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.aCm) {
                    }
                }
            }
        }
    };
    private TbCameraView.c kNa = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean buB() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a kNb = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cUF() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aCS != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aCS.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f kMY = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.kMF != null && ImageListFragment.this.kMF.getWriteImagesInfo() != null && ImageListFragment.this.kMF.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.kML.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.kMF != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.kMF.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.kML.cM(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0638a kNo = new a.InterfaceC0638a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0638a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> ec;
            if (ImageListFragment.this.kMF != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.kMF.AG()) && (ec = ImageListFragment.this.kMF.ec(albumId)) != null) {
                    ImageListFragment.this.kMF.ea(albumId);
                    ImageListFragment.this.kNn.setData(ec);
                    ImageListFragment.this.aCS.setText(name);
                    ImageListFragment.this.kNm.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g kMZ = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.kML == null || ImageListFragment.this.kMF == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.kMF.AC()) {
                    ImageListFragment.this.kML.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.kMF.isAdded(imageFileInfo)) {
                    ImageListFragment.this.kML.f(imageFileInfo);
                } else {
                    ImageListFragment.this.kML.e(imageFileInfo);
                }
                ImageListFragment.this.kMF.a(null);
                ImageListFragment.this.kNn.notifyDataSetChanged();
                ImageListFragment.this.AL();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.kMF.AB()) {
                    ImageListFragment.this.kML.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.kMF.b(videoFileInfo)) {
                        ImageListFragment.this.kMF.a(null);
                    } else {
                        ImageListFragment.this.kMF.a(videoFileInfo);
                    }
                    ImageListFragment.this.kMF.AD();
                    ImageListFragment.this.kNn.notifyDataSetChanged();
                    ImageListFragment.this.AL();
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
        this.kML = (AlbumActivity) getBaseFragmentActivity();
        this.kMF = this.kML.cUy();
        d.cUB().a(this);
        this.kNk = new com.baidu.tbadk.album.f(this.kML);
        this.kNl = new com.baidu.tieba.write.view.a(this.kML);
        this.kNl.setOnDismissListener(this.mOnDismissListener);
        this.kNl.a(this.kNo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aCP = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aCX = this.mView.findViewById(R.id.layout_title);
        this.aCS = (TextView) this.mView.findViewById(R.id.album_title);
        this.aCQ = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aCR = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aCY = this.mView.findViewById(R.id.navi_line);
        this.aCm = this.mView.findViewById(R.id.layout_bottom);
        this.aCo = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.aCn = (TextView) this.mView.findViewById(R.id.next_step);
        this.kMF.ea(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aCS.setText(this.kML.getPageContext().getString(R.string.album_all_media));
        if (this.kMF.getWriteImagesInfo() != null) {
            this.aCo.setVisibility(this.kMF.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.kMF.getWriteImagesInfo() != null && this.kMF.getWriteImagesInfo().isFromQRCode()) {
            this.aCm.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.kML.getPageContext().getPageActivity(), this.aCP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aF(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.kNm = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.kNm.setSelector(R.color.transparent);
        this.kNn = new h(this.kML, this.kMF);
        if (this.kMF.getWriteImagesInfo() != null && this.kMF.getWriteImagesInfo().isFromQRCode()) {
            this.kNn.tM(false);
        } else {
            this.kNn.tM(this.kML.Al() != 1);
        }
        this.kNm.setAdapter((ListAdapter) this.kNn);
        this.kNm.setOuterOnScrollListener(this);
        this.kNn.a(this.kMZ);
        this.kNn.a(this.kMY);
        this.kNn.af(this.kMX);
        this.kNn.setOnOpenCameraFailedListener(this.kNb);
        this.kNn.setOnRequestPermissionListener(this.kNa);
        this.aCn.setOnClickListener(this.kML);
        this.aCQ.setOnClickListener(this.kML);
        this.aCR.setOnClickListener(this.kML);
        this.aCo.setOnClickListener(this.kML);
        this.aCS.setOnClickListener(this.mOnClickListener);
        this.aCm.setOnClickListener(this.mOnClickListener);
        AL();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.dFS == null) {
            this.dFS = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.dFS.setCancelListener(null);
        this.dFS.setTipString(R.string.loading);
        this.dFS.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.kML.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AL() {
        int count;
        String string;
        if (this.kMF != null && this.aCn != null) {
            if (this.kMF.AC()) {
                int i = this.kMF.AC() ? 1 : 0;
                count = i;
                string = this.kML.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.kMF.AE());
                string = this.kML.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kMF.getMaxImagesAllowed())});
            }
            this.aCn.setText(string);
            this.aCn.setEnabled(count > 0);
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
            AA();
        }
    }

    private void Ax() {
        if (this.kMF == null && this.kML != null) {
            this.kMF = this.kML.cUy();
        }
        if (this.kMF != null) {
            if (!this.kMF.AJ()) {
                this.kNn.notifyDataSetChanged();
            } else {
                AM();
            }
            bt(this.kMF.isOriginalImg());
        }
    }

    private void AM() {
        if (this.kNk == null) {
            this.kNk = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.kNk.a(this.kML.Al() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.dFS != null) {
                    ImageListFragment.this.dFS.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.kMF != null && gVar != null) {
                    ImageListFragment.this.kMF.c(gVar);
                    String AG = ImageListFragment.this.kMF.AG();
                    ImageListFragment.this.kMF.ea(AG);
                    ImageListFragment.this.kNn.setData(ImageListFragment.this.kMF.ec(AG));
                    ImageListFragment.this.kNm.smoothScrollToPosition(0);
                    ImageListFragment.this.AL();
                }
                ImageListFragment.this.kNm.AO();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aCY, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aCS, R.color.cp_cont_b, i);
        if (this.kML.Al() == 1) {
            SvgManager.aGA().a(this.aCQ, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.aCR.setVisibility(8);
        } else {
            am.setViewTextColor(this.aCR, (int) R.color.navi_back_text_color);
            this.aCQ.setVisibility(8);
        }
        if (this.aCS != null) {
            this.aCS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.kNn != null) {
            this.kNn.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kMF != null) {
            bt(this.kMF.isOriginalImg());
        }
    }

    public View Ay() {
        return this.kML.Al() == 1 ? this.aCQ : this.aCR;
    }

    public View AN() {
        return this.aCn;
    }

    public TbCameraView cUz() {
        if (this.kNn != null) {
            return this.kNn.cUC();
        }
        return null;
    }

    public TransparentHeadGridView cUE() {
        return this.kNm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.kNl != null) {
            this.kNl.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kNk != null) {
            this.kNk.cancelLoadTask();
        }
        if (this.kML != null) {
            this.kML.closeLoadingDialog();
        }
        if (this.dFS != null) {
            this.dFS.setDialogVisiable(false);
        }
        d.cUB().b(this);
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
        AA();
    }

    private void AA() {
        if (!isHidden() && !this.isPaused) {
            Ax();
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
            this.kNn.bw(true);
        } else if (this.kNn.isScroll()) {
            this.kNn.bw(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.kNm != null) {
            int firstVisiblePosition = this.kNm.getFirstVisiblePosition();
            int lastVisiblePosition = this.kNm.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.kNm.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.kNn != null) {
                    this.kNn.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        AL();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.kNn != null) {
            i(this.kNn.i(imageFileInfo), z);
        }
    }

    public View Au() {
        return this.aCo;
    }

    public void bt(boolean z) {
        if (this.kML != null && this.aCo != null) {
            this.aCo.setText(this.kML.getResources().getString(R.string.original_img));
            if (z) {
                this.aCo.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.aCo, (int) R.color.cp_link_tip_a);
                return;
            }
            this.aCo.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.aCo, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.kMJ = iVar;
    }
}
