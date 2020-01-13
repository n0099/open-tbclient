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
    private c kLU;
    private i kLY;
    private com.baidu.tieba.write.view.a kMA;
    private TransparentHeadGridView kMB;
    private h kMC;
    private AlbumActivity kMa;
    private com.baidu.tbadk.album.f kMz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a dBR = null;
    private View.OnClickListener kMm = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.kLU != null) {
                int maxImagesAllowed = ImageListFragment.this.kLU.getMaxImagesAllowed();
                if (ImageListFragment.this.kLU.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.kMa != null) {
                        ImageListFragment.this.kMa.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.kLU != null) {
                if (ImageListFragment.this.kLY == null || !ImageListFragment.this.kLY.cTs()) {
                    if (view == ImageListFragment.this.ayC) {
                        ImageListFragment.this.kMA.b(ImageListFragment.this.kLU.yr(), ImageListFragment.this.kLU.yp());
                        ImageListFragment.this.kMA.R(ImageListFragment.this.ayH);
                        ImageListFragment.this.ayC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.axW) {
                    }
                }
            }
        }
    };
    private TbCameraView.c kMp = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bsX() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a kMq = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cTp() {
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
    private f kMn = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.kLU != null && ImageListFragment.this.kLU.getWriteImagesInfo() != null && ImageListFragment.this.kLU.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.kMa.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.kLU != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.kLU.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.kMa.cw(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0630a kMD = new a.InterfaceC0630a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0630a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> dN;
            if (ImageListFragment.this.kLU != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.kLU.yp()) && (dN = ImageListFragment.this.kLU.dN(albumId)) != null) {
                    ImageListFragment.this.kLU.dL(albumId);
                    ImageListFragment.this.kMC.setData(dN);
                    ImageListFragment.this.ayC.setText(name);
                    ImageListFragment.this.kMB.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g kMo = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.kMa == null || ImageListFragment.this.kLU == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.kLU.yl()) {
                    ImageListFragment.this.kMa.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.kLU.isAdded(imageFileInfo)) {
                    ImageListFragment.this.kMa.f(imageFileInfo);
                } else {
                    ImageListFragment.this.kMa.e(imageFileInfo);
                }
                ImageListFragment.this.kLU.a(null);
                ImageListFragment.this.kMC.notifyDataSetChanged();
                ImageListFragment.this.yu();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.kLU.yk()) {
                    ImageListFragment.this.kMa.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.kLU.b(videoFileInfo)) {
                        ImageListFragment.this.kLU.a(null);
                    } else {
                        ImageListFragment.this.kLU.a(videoFileInfo);
                    }
                    ImageListFragment.this.kLU.ym();
                    ImageListFragment.this.kMC.notifyDataSetChanged();
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
        this.kMa = (AlbumActivity) getBaseFragmentActivity();
        this.kLU = this.kMa.cTi();
        d.cTl().a(this);
        this.kMz = new com.baidu.tbadk.album.f(this.kMa);
        this.kMA = new com.baidu.tieba.write.view.a(this.kMa);
        this.kMA.setOnDismissListener(this.mOnDismissListener);
        this.kMA.a(this.kMD);
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
        this.kLU.dL(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.ayC.setText(this.kMa.getPageContext().getString(R.string.album_all_media));
        if (this.kLU.getWriteImagesInfo() != null) {
            this.axY.setVisibility(this.kLU.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.kLU.getWriteImagesInfo() != null && this.kLU.getWriteImagesInfo().isFromQRCode()) {
            this.axW.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.kMa.getPageContext().getPageActivity(), this.ayz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aF(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.kMB = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.kMB.setSelector(R.color.transparent);
        this.kMC = new h(this.kMa, this.kLU);
        if (this.kLU.getWriteImagesInfo() != null && this.kLU.getWriteImagesInfo().isFromQRCode()) {
            this.kMC.tI(false);
        } else {
            this.kMC.tI(this.kMa.xU() != 1);
        }
        this.kMB.setAdapter((ListAdapter) this.kMC);
        this.kMB.setOuterOnScrollListener(this);
        this.kMC.a(this.kMo);
        this.kMC.a(this.kMn);
        this.kMC.af(this.kMm);
        this.kMC.setOnOpenCameraFailedListener(this.kMq);
        this.kMC.setOnRequestPermissionListener(this.kMp);
        this.axX.setOnClickListener(this.kMa);
        this.ayA.setOnClickListener(this.kMa);
        this.ayB.setOnClickListener(this.kMa);
        this.axY.setOnClickListener(this.kMa);
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
            this.kMa.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu() {
        int count;
        String string;
        if (this.kLU != null && this.axX != null) {
            if (this.kLU.yl()) {
                int i = this.kLU.yl() ? 1 : 0;
                count = i;
                string = this.kMa.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.kLU.yn());
                string = this.kMa.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kLU.getMaxImagesAllowed())});
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
        if (this.kLU == null && this.kMa != null) {
            this.kLU = this.kMa.cTi();
        }
        if (this.kLU != null) {
            if (!this.kLU.ys()) {
                this.kMC.notifyDataSetChanged();
            } else {
                yv();
            }
            bl(this.kLU.isOriginalImg());
        }
    }

    private void yv() {
        if (this.kMz == null) {
            this.kMz = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.kMz.a(this.kMa.xU() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.kLU != null && gVar != null) {
                    ImageListFragment.this.kLU.c(gVar);
                    String yp = ImageListFragment.this.kLU.yp();
                    ImageListFragment.this.kLU.dL(yp);
                    ImageListFragment.this.kMC.setData(ImageListFragment.this.kLU.dN(yp));
                    ImageListFragment.this.kMB.smoothScrollToPosition(0);
                    ImageListFragment.this.yu();
                }
                ImageListFragment.this.kMB.yx();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.ayI, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.ayC, R.color.cp_cont_b, i);
        if (this.kMa.xU() == 1) {
            SvgManager.aEp().a(this.ayA, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.ayB.setVisibility(8);
        } else {
            am.setViewTextColor(this.ayB, (int) R.color.navi_back_text_color);
            this.ayA.setVisibility(8);
        }
        if (this.ayC != null) {
            this.ayC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.kMC != null) {
            this.kMC.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kLU != null) {
            bl(this.kLU.isOriginalImg());
        }
    }

    public View yh() {
        return this.kMa.xU() == 1 ? this.ayA : this.ayB;
    }

    public View yw() {
        return this.axX;
    }

    public TbCameraView cTj() {
        if (this.kMC != null) {
            return this.kMC.cTm();
        }
        return null;
    }

    public TransparentHeadGridView cTo() {
        return this.kMB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.kMA != null) {
            this.kMA.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kMz != null) {
            this.kMz.cancelLoadTask();
        }
        if (this.kMa != null) {
            this.kMa.closeLoadingDialog();
        }
        if (this.dBR != null) {
            this.dBR.setDialogVisiable(false);
        }
        d.cTl().b(this);
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
            this.kMC.bo(true);
        } else if (this.kMC.isScroll()) {
            this.kMC.bo(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.kMB != null) {
            int firstVisiblePosition = this.kMB.getFirstVisiblePosition();
            int lastVisiblePosition = this.kMB.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.kMB.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.kMC != null) {
                    this.kMC.b((ImageView) childAt.findViewById(R.id.select_icon), z);
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
        if (imageFileInfo != null && this.kMC != null) {
            i(this.kMC.i(imageFileInfo), z);
        }
    }

    public View yd() {
        return this.axY;
    }

    public void bl(boolean z) {
        if (this.kMa != null && this.axY != null) {
            this.axY.setText(this.kMa.getResources().getString(R.string.original_img));
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
        this.kLY = iVar;
    }
}
