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
    private View boO;
    private TextView boQ;
    private TextView bpA;
    private View bpF;
    private View bpG;
    private boolean bpH;
    private RelativeLayout bpx;
    private ImageView bpy;
    private TextView bpz;
    private NavigationBar fri;
    private BaseFragmentActivity hwW;
    private j mNJ;
    private NoDataView mNoDataView;
    private e mNr;
    private c mNv;
    private TBSpecificationBtn mNx;
    private com.baidu.tbadk.album.f mOf;
    private com.baidu.tieba.write.view.a mOg;
    private TransparentHeadGridView mOh;
    private i mOi;
    private View mView;
    private com.baidu.tbadk.core.view.a eUz = null;
    private View.OnClickListener mNS = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.mNv != null) {
                int maxImagesAllowed = ImageListFragment.this.mNv.getMaxImagesAllowed();
                if (ImageListFragment.this.mNv.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.mNr != null) {
                        ImageListFragment.this.mNr.g(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.mNv != null) {
                if (ImageListFragment.this.mNJ == null || !ImageListFragment.this.mNJ.dGr()) {
                    if (view == ImageListFragment.this.bpA) {
                        ImageListFragment.this.mOg.b(ImageListFragment.this.mNv.OR(), ImageListFragment.this.mNv.OP());
                        ImageListFragment.this.mOg.O(ImageListFragment.this.fri == null ? ImageListFragment.this.bpF : ImageListFragment.this.fri);
                        ImageListFragment.this.bpA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.boO) {
                    }
                }
            }
        }
    };
    private TbCameraView.c mNV = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cbr() {
            return !ae.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a mNW = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dGo() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bpA != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.bjq().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.bpA.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private g mNT = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.mNv != null && ImageListFragment.this.mNv.getWriteImagesInfo() != null && ImageListFragment.this.mNv.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.mNr != null) {
                    ImageListFragment.this.mNr.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.mNv != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.mNv.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.mNr != null) {
                        ImageListFragment.this.mNr.fn(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0839a mOj = new a.InterfaceC0839a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0839a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> hh;
            if (ImageListFragment.this.mNv != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.mNv.OP()) && (hh = ImageListFragment.this.mNv.hh(albumId)) != null) {
                    ImageListFragment.this.mNv.hf(albumId);
                    ImageListFragment.this.mOi.setData(hh);
                    ImageListFragment.this.bpA.setText(name);
                    ImageListFragment.this.mOh.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h mNU = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hwW == null || ImageListFragment.this.mNv == null || ImageListFragment.this.mNr == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.mNv.isAdded(imageFileInfo)) {
                    ImageListFragment.this.mNr.f(imageFileInfo);
                } else {
                    ImageListFragment.this.mNr.g(imageFileInfo);
                }
                ImageListFragment.this.mNv.a(null);
                ImageListFragment.this.mOi.notifyDataSetChanged();
                ImageListFragment.this.OV();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.mNv.OK()) {
                    ImageListFragment.this.hwW.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    ImageListFragment.this.mNv.a(videoFileInfo);
                    ImageListFragment.this.mNv.OM();
                    ImageListFragment.this.mOi.notifyDataSetChanged();
                    ImageListFragment.this.mNr.Oq();
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
        this.hwW = getBaseFragmentActivity();
        if (this.mNr == null) {
            if (this.hwW instanceof AlbumFloatActivity) {
                this.mNr = ((AlbumFloatActivity) this.hwW).mNr;
            } else if (this.hwW instanceof AlbumActivity) {
                this.mNr = ((AlbumActivity) this.hwW).mNr;
            }
        }
        if (this.mNr != null) {
            this.mNv = this.mNr.dGj();
        }
        d.dGg().a(this);
        this.mOf = new com.baidu.tbadk.album.f(this.hwW);
        this.mOg = new com.baidu.tieba.write.view.a(this.hwW);
        this.mOg.setOnDismissListener(this.mOnDismissListener);
        this.mOg.a(this.mOj);
    }

    public void a(e eVar) {
        this.mNr = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hwW = getBaseFragmentActivity();
        if (this.mNr == null) {
            if (this.hwW instanceof AlbumFloatActivity) {
                this.mNr = ((AlbumFloatActivity) this.hwW).mNr;
            } else if (this.hwW instanceof AlbumActivity) {
                this.mNr = ((AlbumActivity) this.hwW).mNr;
            }
        }
        if (this.mNr != null) {
            this.mNv = this.mNr.dGj();
        }
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bpx = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bpF = this.mView.findViewById(R.id.layout_title);
        this.bpA = (TextView) this.mView.findViewById(R.id.album_title);
        this.bpy = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bpz = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bpG = this.mView.findViewById(R.id.navi_line);
        this.boO = this.mView.findViewById(R.id.layout_bottom);
        this.boQ = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.mNx = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.mNx.setTextSize(R.dimen.tbds34);
        this.mNx.getStyleConfig().oZ(l.getDimens(this.hwW, R.dimen.tbds25));
        this.mNv.hf(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bpA.setText(this.hwW.getPageContext().getString(R.string.album_all_media));
        if (this.mNv.getWriteImagesInfo() != null) {
            this.boQ.setVisibility(this.mNv.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.mNv.getWriteImagesInfo() != null && this.mNv.getWriteImagesInfo().isFromQRCode()) {
            this.boO.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hwW.getPageContext().getPageActivity(), this.bpx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aY(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.mOh = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.mOh.setSelector(R.color.transparent);
        this.mOi = new i(this.hwW, this.mNv);
        if (this.mNv.getWriteImagesInfo() != null && this.mNv.getWriteImagesInfo().isFromQRCode()) {
            this.mOi.xg(false);
        } else {
            this.mOi.xg(true);
        }
        this.mOh.setAdapter((ListAdapter) this.mOi);
        this.mOh.setOuterOnScrollListener(this);
        this.mOi.a(this.mNU);
        this.mOi.a(this.mNT);
        this.mOi.al(this.mNS);
        this.mOi.setOnOpenCameraFailedListener(this.mNW);
        this.mOi.setOnRequestPermissionListener(this.mNV);
        this.mNx.setOnClickListener(this.hwW);
        this.bpy.setOnClickListener(this.hwW);
        this.bpz.setOnClickListener(this.hwW);
        this.boQ.setOnClickListener(this.hwW);
        this.bpA.setOnClickListener(this.mOnClickListener);
        this.boO.setOnClickListener(this.mOnClickListener);
        OV();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fri != null) {
            if (this.bpA.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bpA.getParent()).removeView(this.bpA);
            }
            this.bpF.setVisibility(8);
            this.fri.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bpA, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.eUz == null) {
            this.eUz = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.eUz.setCancelListener(null);
        this.eUz.setTipString(R.string.loading);
        this.eUz.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hwW.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OV() {
        int count;
        String string;
        if (this.mNv != null && this.mNx != null) {
            if (this.mNv.OL()) {
                int i = this.mNv.OL() ? 1 : 0;
                count = i;
                string = this.hwW.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = y.getCount(this.mNv.ON());
                string = this.hwW.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mNv.getMaxImagesAllowed())});
            }
            this.mNx.setText(string);
            this.mNx.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bpH = false;
        if (isShow()) {
            OA();
        }
    }

    private void Oz() {
        if (this.mNv == null && this.mNr != null) {
            this.mNv = this.mNr.dGj();
        }
        if (this.mNv != null) {
            if (!this.mNv.btQ()) {
                this.mOi.notifyDataSetChanged();
            } else {
                OW();
            }
            cz(this.mNv.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void OW() {
        if (this.mOf == null) {
            this.mOf = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.mOf.a((this.mNr == null || !this.mNr.dGk()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.eUz != null) {
                    ImageListFragment.this.eUz.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.mNv != null && gVar != null) {
                    ImageListFragment.this.mNv.c(gVar);
                    String OP = ImageListFragment.this.mNv.OP();
                    ImageListFragment.this.mNv.hf(OP);
                    ImageListFragment.this.mOi.setData(ImageListFragment.this.mNv.hh(OP));
                    ImageListFragment.this.mOh.smoothScrollToPosition(0);
                    ImageListFragment.this.OV();
                }
                ImageListFragment.this.mOh.OY();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ap.setBackgroundColor(this.bpG, R.color.cp_bg_line_c, i);
        ap.setViewTextColor(this.bpA, R.color.cp_cont_b, i);
        if (this.bpz != null && this.bpy != null) {
            if (this.mNr != null && this.mNr.Ou() == 1) {
                SvgManager.bjq().a(this.bpy, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                this.bpz.setVisibility(8);
            } else {
                ap.setViewTextColor(this.bpz, R.color.navi_back_text_color);
                this.bpy.setVisibility(8);
            }
        }
        if (this.bpA != null) {
            this.bpA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.mOi != null) {
            this.mOi.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNv != null) {
            cz(this.mNv.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.fri = navigationBar;
    }

    public View OT() {
        return (this.mNr == null || this.mNr.Ou() != 1) ? this.bpz : this.bpy;
    }

    public View OX() {
        return this.mNx;
    }

    public TbCameraView dGc() {
        if (this.mOi != null) {
            return this.mOi.dGl();
        }
        return null;
    }

    public TransparentHeadGridView dGn() {
        return this.mOh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mOg != null) {
            this.mOg.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mOf != null) {
            this.mOf.cancelLoadTask();
        }
        if (this.hwW != null) {
            this.hwW.closeLoadingDialog();
        }
        if (this.eUz != null) {
            this.eUz.setDialogVisiable(false);
        }
        d.dGg().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bpH = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cB(boolean z) {
        OA();
    }

    private void OA() {
        if (!isHidden() && !this.bpH) {
            Oz();
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
            this.mOi.cC(true);
        } else if (this.mOi.isScroll()) {
            this.mOi.cC(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.mOh != null) {
            int firstVisiblePosition = this.mOh.getFirstVisiblePosition();
            int lastVisiblePosition = this.mOh.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mOh.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.mOi != null) {
                    this.mOi.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        OV();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.mOi != null) {
            o(this.mOi.i(imageFileInfo), z);
        }
    }

    public View OG() {
        return this.boQ;
    }

    public void cz(boolean z) {
        if (this.hwW != null && this.boQ != null) {
            this.boQ.setText(this.hwW.getResources().getString(R.string.original_img));
            if (z) {
                this.boQ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.setViewTextColor(this.boQ, R.color.cp_link_tip_a);
                return;
            }
            this.boQ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.boQ, R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.mNJ = jVar;
    }
}
