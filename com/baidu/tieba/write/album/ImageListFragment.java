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
/* loaded from: classes11.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View axW;
    private TextView axX;
    private TextView axY;
    private ImageView ayA;
    private TextView ayB;
    private TextView ayC;
    private View ayH;
    private View ayI;
    private RelativeLayout ayz;
    private boolean isPaused;
    private c kLZ;
    private com.baidu.tbadk.album.f kME;
    private com.baidu.tieba.write.view.a kMF;
    private TransparentHeadGridView kMG;
    private h kMH;
    private i kMd;
    private AlbumActivity kMf;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a dBR = null;
    private View.OnClickListener kMr = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.kLZ != null) {
                int maxImagesAllowed = ImageListFragment.this.kLZ.getMaxImagesAllowed();
                if (ImageListFragment.this.kLZ.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.kMf != null) {
                        ImageListFragment.this.kMf.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.kLZ != null) {
                if (ImageListFragment.this.kMd == null || !ImageListFragment.this.kMd.cTu()) {
                    if (view == ImageListFragment.this.ayC) {
                        ImageListFragment.this.kMF.b(ImageListFragment.this.kLZ.yr(), ImageListFragment.this.kLZ.yp());
                        ImageListFragment.this.kMF.R(ImageListFragment.this.ayH);
                        ImageListFragment.this.ayC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.axW) {
                    }
                }
            }
        }
    };
    private TbCameraView.c kMu = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bsX() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a kMv = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cTr() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.ayC != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.ayC.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f kMs = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.kLZ != null && ImageListFragment.this.kLZ.getWriteImagesInfo() != null && ImageListFragment.this.kLZ.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.kMf.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.kLZ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.kLZ.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.kMf.cw(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0630a kMI = new a.InterfaceC0630a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0630a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> dN;
            if (ImageListFragment.this.kLZ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.kLZ.yp()) && (dN = ImageListFragment.this.kLZ.dN(albumId)) != null) {
                    ImageListFragment.this.kLZ.dL(albumId);
                    ImageListFragment.this.kMH.setData(dN);
                    ImageListFragment.this.ayC.setText(name);
                    ImageListFragment.this.kMG.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g kMt = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.kMf == null || ImageListFragment.this.kLZ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.kLZ.yl()) {
                    ImageListFragment.this.kMf.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.kLZ.isAdded(imageFileInfo)) {
                    ImageListFragment.this.kMf.f(imageFileInfo);
                } else {
                    ImageListFragment.this.kMf.e(imageFileInfo);
                }
                ImageListFragment.this.kLZ.a(null);
                ImageListFragment.this.kMH.notifyDataSetChanged();
                ImageListFragment.this.yu();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.kLZ.yk()) {
                    ImageListFragment.this.kMf.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.kLZ.b(videoFileInfo)) {
                        ImageListFragment.this.kLZ.a(null);
                    } else {
                        ImageListFragment.this.kLZ.a(videoFileInfo);
                    }
                    ImageListFragment.this.kLZ.ym();
                    ImageListFragment.this.kMH.notifyDataSetChanged();
                    ImageListFragment.this.yu();
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
        this.kMf = (AlbumActivity) getBaseFragmentActivity();
        this.kLZ = this.kMf.cTk();
        d.cTn().a(this);
        this.kME = new com.baidu.tbadk.album.f(this.kMf);
        this.kMF = new com.baidu.tieba.write.view.a(this.kMf);
        this.kMF.setOnDismissListener(this.mOnDismissListener);
        this.kMF.a(this.kMI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.ayz = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.ayH = this.mView.findViewById(R.id.layout_title);
        this.ayC = (TextView) this.mView.findViewById(R.id.album_title);
        this.ayA = (ImageView) this.mView.findViewById(R.id.img_close);
        this.ayB = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.ayI = this.mView.findViewById(R.id.navi_line);
        this.axW = this.mView.findViewById(R.id.layout_bottom);
        this.axY = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.axX = (TextView) this.mView.findViewById(R.id.next_step);
        this.kLZ.dL(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.ayC.setText(this.kMf.getPageContext().getString(R.string.album_all_media));
        if (this.kLZ.getWriteImagesInfo() != null) {
            this.axY.setVisibility(this.kLZ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.kLZ.getWriteImagesInfo() != null && this.kLZ.getWriteImagesInfo().isFromQRCode()) {
            this.axW.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.kMf.getPageContext().getPageActivity(), this.ayz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aF(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.kMG = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.kMG.setSelector(R.color.transparent);
        this.kMH = new h(this.kMf, this.kLZ);
        if (this.kLZ.getWriteImagesInfo() != null && this.kLZ.getWriteImagesInfo().isFromQRCode()) {
            this.kMH.tI(false);
        } else {
            this.kMH.tI(this.kMf.xU() != 1);
        }
        this.kMG.setAdapter((ListAdapter) this.kMH);
        this.kMG.setOuterOnScrollListener(this);
        this.kMH.a(this.kMt);
        this.kMH.a(this.kMs);
        this.kMH.af(this.kMr);
        this.kMH.setOnOpenCameraFailedListener(this.kMv);
        this.kMH.setOnRequestPermissionListener(this.kMu);
        this.axX.setOnClickListener(this.kMf);
        this.ayA.setOnClickListener(this.kMf);
        this.ayB.setOnClickListener(this.kMf);
        this.axY.setOnClickListener(this.kMf);
        this.ayC.setOnClickListener(this.mOnClickListener);
        this.axW.setOnClickListener(this.mOnClickListener);
        yu();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.dBR == null) {
            this.dBR = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.dBR.setCancelListener(null);
        this.dBR.setTipString(R.string.loading);
        this.dBR.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.kMf.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu() {
        int count;
        String string;
        if (this.kLZ != null && this.axX != null) {
            if (this.kLZ.yl()) {
                int i = this.kLZ.yl() ? 1 : 0;
                count = i;
                string = this.kMf.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.kLZ.yn());
                string = this.kMf.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kLZ.getMaxImagesAllowed())});
            }
            this.axX.setText(string);
            this.axX.setEnabled(count > 0);
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
            yj();
        }
    }

    private void yg() {
        if (this.kLZ == null && this.kMf != null) {
            this.kLZ = this.kMf.cTk();
        }
        if (this.kLZ != null) {
            if (!this.kLZ.ys()) {
                this.kMH.notifyDataSetChanged();
            } else {
                yv();
            }
            bl(this.kLZ.isOriginalImg());
        }
    }

    private void yv() {
        if (this.kME == null) {
            this.kME = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.kME.a(this.kMf.xU() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.dBR != null) {
                    ImageListFragment.this.dBR.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.kLZ != null && gVar != null) {
                    ImageListFragment.this.kLZ.c(gVar);
                    String yp = ImageListFragment.this.kLZ.yp();
                    ImageListFragment.this.kLZ.dL(yp);
                    ImageListFragment.this.kMH.setData(ImageListFragment.this.kLZ.dN(yp));
                    ImageListFragment.this.kMG.smoothScrollToPosition(0);
                    ImageListFragment.this.yu();
                }
                ImageListFragment.this.kMG.yx();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.ayI, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.ayC, R.color.cp_cont_b, i);
        if (this.kMf.xU() == 1) {
            SvgManager.aEp().a(this.ayA, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.ayB.setVisibility(8);
        } else {
            am.setViewTextColor(this.ayB, (int) R.color.navi_back_text_color);
            this.ayA.setVisibility(8);
        }
        if (this.ayC != null) {
            this.ayC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.kMH != null) {
            this.kMH.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kLZ != null) {
            bl(this.kLZ.isOriginalImg());
        }
    }

    public View yh() {
        return this.kMf.xU() == 1 ? this.ayA : this.ayB;
    }

    public View yw() {
        return this.axX;
    }

    public TbCameraView cTl() {
        if (this.kMH != null) {
            return this.kMH.cTo();
        }
        return null;
    }

    public TransparentHeadGridView cTq() {
        return this.kMG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.kMF != null) {
            this.kMF.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kME != null) {
            this.kME.cancelLoadTask();
        }
        if (this.kMf != null) {
            this.kMf.closeLoadingDialog();
        }
        if (this.dBR != null) {
            this.dBR.setDialogVisiable(false);
        }
        d.cTn().b(this);
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
    public void bn(boolean z) {
        yj();
    }

    private void yj() {
        if (!isHidden() && !this.isPaused) {
            yg();
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
            this.kMH.bo(true);
        } else if (this.kMH.isScroll()) {
            this.kMH.bo(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.kMG != null) {
            int firstVisiblePosition = this.kMG.getFirstVisiblePosition();
            int lastVisiblePosition = this.kMG.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.kMG.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.kMH != null) {
                    this.kMH.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        yu();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.kMH != null) {
            i(this.kMH.i(imageFileInfo), z);
        }
    }

    public View yd() {
        return this.axY;
    }

    public void bl(boolean z) {
        if (this.kMf != null && this.axY != null) {
            this.axY.setText(this.kMf.getResources().getString(R.string.original_img));
            if (z) {
                this.axY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.axY, (int) R.color.cp_link_tip_a);
                return;
            }
            this.axY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.axY, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.kMd = iVar;
    }
}
