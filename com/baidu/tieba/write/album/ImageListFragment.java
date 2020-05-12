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
    private RelativeLayout aWR;
    private ImageView aWS;
    private TextView aWT;
    private TextView aWU;
    private View aWZ;
    private View aWo;
    private TextView aWp;
    private TextView aWq;
    private View aXa;
    private boolean aXb;
    private c lxX;
    private com.baidu.tbadk.album.f lyE;
    private com.baidu.tieba.write.view.a lyF;
    private TransparentHeadGridView lyG;
    private h lyH;
    private i lyb;
    private AlbumActivity lye;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a egi = null;
    private View.OnClickListener lyr = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.lxX != null) {
                int maxImagesAllowed = ImageListFragment.this.lxX.getMaxImagesAllowed();
                if (ImageListFragment.this.lxX.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.lye != null) {
                        ImageListFragment.this.lye.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.lxX != null) {
                if (ImageListFragment.this.lyb == null || !ImageListFragment.this.lyb.dfA()) {
                    if (view == ImageListFragment.this.aWU) {
                        ImageListFragment.this.lyF.b(ImageListFragment.this.lxX.FO(), ImageListFragment.this.lxX.FM());
                        ImageListFragment.this.lyF.T(ImageListFragment.this.aWZ);
                        ImageListFragment.this.aWU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.aWo) {
                    }
                }
            }
        }
    };
    private TbCameraView.c lyu = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bEu() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a lyv = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dfx() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aWU != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aOR().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aWU.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f lys = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.lxX != null && ImageListFragment.this.lxX.getWriteImagesInfo() != null && ImageListFragment.this.lxX.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.lye.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.lxX != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.lxX.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.lye.db(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0705a lyI = new a.InterfaceC0705a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0705a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> eU;
            if (ImageListFragment.this.lxX != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.lxX.FM()) && (eU = ImageListFragment.this.lxX.eU(albumId)) != null) {
                    ImageListFragment.this.lxX.eS(albumId);
                    ImageListFragment.this.lyH.setData(eU);
                    ImageListFragment.this.aWU.setText(name);
                    ImageListFragment.this.lyG.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g lyt = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.lye == null || ImageListFragment.this.lxX == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.lxX.FI()) {
                    ImageListFragment.this.lye.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.lxX.isAdded(imageFileInfo)) {
                    ImageListFragment.this.lye.f(imageFileInfo);
                } else {
                    ImageListFragment.this.lye.e(imageFileInfo);
                }
                ImageListFragment.this.lxX.a(null);
                ImageListFragment.this.lyH.notifyDataSetChanged();
                ImageListFragment.this.FR();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.lxX.FH()) {
                    ImageListFragment.this.lye.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.lxX.b(videoFileInfo)) {
                        ImageListFragment.this.lxX.a(null);
                    } else {
                        ImageListFragment.this.lxX.a(videoFileInfo);
                    }
                    ImageListFragment.this.lxX.FJ();
                    ImageListFragment.this.lyH.notifyDataSetChanged();
                    ImageListFragment.this.FR();
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
        this.lye = (AlbumActivity) getBaseFragmentActivity();
        this.lxX = this.lye.dfq();
        d.dft().a(this);
        this.lyE = new com.baidu.tbadk.album.f(this.lye);
        this.lyF = new com.baidu.tieba.write.view.a(this.lye);
        this.lyF.setOnDismissListener(this.mOnDismissListener);
        this.lyF.a(this.lyI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aWR = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aWZ = this.mView.findViewById(R.id.layout_title);
        this.aWU = (TextView) this.mView.findViewById(R.id.album_title);
        this.aWS = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aWT = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aXa = this.mView.findViewById(R.id.navi_line);
        this.aWo = this.mView.findViewById(R.id.layout_bottom);
        this.aWq = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.aWp = (TextView) this.mView.findViewById(R.id.next_step);
        this.lxX.eS(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aWU.setText(this.lye.getPageContext().getString(R.string.album_all_media));
        if (this.lxX.getWriteImagesInfo() != null) {
            this.aWq.setVisibility(this.lxX.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.lxX.getWriteImagesInfo() != null && this.lxX.getWriteImagesInfo().isFromQRCode()) {
            this.aWo.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.lye.getPageContext().getPageActivity(), this.aWR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aJ(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.lyG = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.lyG.setSelector(R.color.transparent);
        this.lyH = new h(this.lye, this.lxX);
        if (this.lxX.getWriteImagesInfo() != null && this.lxX.getWriteImagesInfo().isFromQRCode()) {
            this.lyH.uT(false);
        } else {
            this.lyH.uT(this.lye.Fr() != 1);
        }
        this.lyG.setAdapter((ListAdapter) this.lyH);
        this.lyG.setOuterOnScrollListener(this);
        this.lyH.a(this.lyt);
        this.lyH.a(this.lys);
        this.lyH.ai(this.lyr);
        this.lyH.setOnOpenCameraFailedListener(this.lyv);
        this.lyH.setOnRequestPermissionListener(this.lyu);
        this.aWp.setOnClickListener(this.lye);
        this.aWS.setOnClickListener(this.lye);
        this.aWT.setOnClickListener(this.lye);
        this.aWq.setOnClickListener(this.lye);
        this.aWU.setOnClickListener(this.mOnClickListener);
        this.aWo.setOnClickListener(this.mOnClickListener);
        FR();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.egi == null) {
            this.egi = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.egi.setCancelListener(null);
        this.egi.setTipString(R.string.loading);
        this.egi.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.lye.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR() {
        int count;
        String string;
        if (this.lxX != null && this.aWp != null) {
            if (this.lxX.FI()) {
                int i = this.lxX.FI() ? 1 : 0;
                count = i;
                string = this.lye.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.lxX.FK());
                string = this.lye.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.lxX.getMaxImagesAllowed())});
            }
            this.aWp.setText(string);
            this.aWp.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aXb = false;
        if (isShow()) {
            FG();
        }
    }

    private void FD() {
        if (this.lxX == null && this.lye != null) {
            this.lxX = this.lye.dfq();
        }
        if (this.lxX != null) {
            if (!this.lxX.FP()) {
                this.lyH.notifyDataSetChanged();
            } else {
                FS();
            }
            bY(this.lxX.isOriginalImg());
        }
    }

    private void FS() {
        if (this.lyE == null) {
            this.lyE = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.lyE.a(this.lye.Fr() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.egi != null) {
                    ImageListFragment.this.egi.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.lxX != null && gVar != null) {
                    ImageListFragment.this.lxX.c(gVar);
                    String FM = ImageListFragment.this.lxX.FM();
                    ImageListFragment.this.lxX.eS(FM);
                    ImageListFragment.this.lyH.setData(ImageListFragment.this.lxX.eU(FM));
                    ImageListFragment.this.lyG.smoothScrollToPosition(0);
                    ImageListFragment.this.FR();
                }
                ImageListFragment.this.lyG.FU();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aXa, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aWU, R.color.cp_cont_b, i);
        if (this.lye.Fr() == 1) {
            SvgManager.aOR().a(this.aWS, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.aWT.setVisibility(8);
        } else {
            am.setViewTextColor(this.aWT, (int) R.color.navi_back_text_color);
            this.aWS.setVisibility(8);
        }
        if (this.aWU != null) {
            this.aWU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.lyH != null) {
            this.lyH.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.lxX != null) {
            bY(this.lxX.isOriginalImg());
        }
    }

    public View FE() {
        return this.lye.Fr() == 1 ? this.aWS : this.aWT;
    }

    public View FT() {
        return this.aWp;
    }

    public TbCameraView dfr() {
        if (this.lyH != null) {
            return this.lyH.dfu();
        }
        return null;
    }

    public TransparentHeadGridView dfw() {
        return this.lyG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.lyF != null) {
            this.lyF.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lyE != null) {
            this.lyE.cancelLoadTask();
        }
        if (this.lye != null) {
            this.lye.closeLoadingDialog();
        }
        if (this.egi != null) {
            this.egi.setDialogVisiable(false);
        }
        d.dft().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aXb = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void ca(boolean z) {
        FG();
    }

    private void FG() {
        if (!isHidden() && !this.aXb) {
            FD();
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
            this.lyH.cb(true);
        } else if (this.lyH.isScroll()) {
            this.lyH.cb(false);
        }
    }

    public void l(int i, boolean z) {
        if (this.lyG != null) {
            int firstVisiblePosition = this.lyG.getFirstVisiblePosition();
            int lastVisiblePosition = this.lyG.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.lyG.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.lyH != null) {
                    this.lyH.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        FR();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.lyH != null) {
            l(this.lyH.i(imageFileInfo), z);
        }
    }

    public View FA() {
        return this.aWq;
    }

    public void bY(boolean z) {
        if (this.lye != null && this.aWq != null) {
            this.aWq.setText(this.lye.getResources().getString(R.string.original_img));
            if (z) {
                this.aWq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.aWq, (int) R.color.cp_link_tip_a);
                return;
            }
            this.aWq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.aWq, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.lyb = iVar;
    }
}
