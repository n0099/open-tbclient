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
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private ImageView dVU;
    private View eGO;
    private RelativeLayout ewL;
    private TextView fhE;
    private boolean hMV;
    private View jQD;
    private TextView jQE;
    private TextView jQF;
    private c jQj;
    private i jQt;
    private AlbumActivity jQx;
    private com.baidu.tbadk.album.f jRg;
    private TextView jRh;
    private com.baidu.tieba.write.view.a jRi;
    private TransparentHeadGridView jRj;
    private h jRk;
    private View jRl;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cDr = null;
    private View.OnClickListener jQT = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jQj != null) {
                int maxImagesAllowed = ImageListFragment.this.jQj.getMaxImagesAllowed();
                if (ImageListFragment.this.jQj.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jQx != null) {
                        ImageListFragment.this.jQx.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jQj != null) {
                if (ImageListFragment.this.jQt == null || !ImageListFragment.this.jQt.cBF()) {
                    if (view == ImageListFragment.this.fhE) {
                        ImageListFragment.this.jRi.b(ImageListFragment.this.jQj.cBs(), ImageListFragment.this.jQj.cBq());
                        ImageListFragment.this.jRi.bo(ImageListFragment.this.eGO);
                        ImageListFragment.this.fhE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jQD) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jQW = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aZR() {
            return !ab.f(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jQX = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cBA() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.fhE != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.fhE.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f jQU = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jQj != null && ImageListFragment.this.jQj.getWriteImagesInfo() != null && ImageListFragment.this.jQj.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jQx.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jQj != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jQj.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jQx.CW(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0450a jRm = new a.InterfaceC0450a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0450a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> Hi;
            if (ImageListFragment.this.jQj != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jQj.cBq()) && (Hi = ImageListFragment.this.jQj.Hi(albumId)) != null) {
                    ImageListFragment.this.jQj.Hg(albumId);
                    ImageListFragment.this.jRk.setData(Hi);
                    ImageListFragment.this.fhE.setText(name);
                    ImageListFragment.this.jRj.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jQV = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jQx == null || ImageListFragment.this.jQj == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jQj.cBn()) {
                    ImageListFragment.this.jQx.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jQj.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jQx.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jQx.e(imageFileInfo);
                }
                ImageListFragment.this.jQj.a(null);
                ImageListFragment.this.jRk.notifyDataSetChanged();
                ImageListFragment.this.cBw();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jQj.cBm()) {
                    ImageListFragment.this.jQx.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jQj.b(videoFileInfo)) {
                        ImageListFragment.this.jQj.a(null);
                    } else {
                        ImageListFragment.this.jQj.a(videoFileInfo);
                    }
                    ImageListFragment.this.jQj.cBo();
                    ImageListFragment.this.jRk.notifyDataSetChanged();
                    ImageListFragment.this.cBw();
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
        this.jQx = (AlbumActivity) getBaseFragmentActivity();
        this.jQj = this.jQx.cAY();
        d.cBt().a(this);
        this.jRg = new com.baidu.tbadk.album.f(this.jQx);
        this.jRi = new com.baidu.tieba.write.view.a(this.jQx);
        this.jRi.setOnDismissListener(this.mOnDismissListener);
        this.jRi.a(this.jRm);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.ewL = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.eGO = this.mView.findViewById(R.id.layout_title);
        this.fhE = (TextView) this.mView.findViewById(R.id.album_title);
        this.dVU = (ImageView) this.mView.findViewById(R.id.img_close);
        this.jRh = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.jRl = this.mView.findViewById(R.id.navi_line);
        this.jQD = this.mView.findViewById(R.id.layout_bottom);
        this.jQF = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.jQE = (TextView) this.mView.findViewById(R.id.next_step);
        this.jQj.Hg(com.baidu.tbadk.album.a.bBq);
        this.fhE.setText(this.jQx.getPageContext().getString(R.string.album_all_media));
        if (this.jQj.getWriteImagesInfo() != null) {
            this.jQF.setVisibility(this.jQj.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jQj.getWriteImagesInfo() != null && this.jQj.getWriteImagesInfo().isFromQRCode()) {
            this.jQD.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jQx.getPageContext().getPageActivity(), this.ewL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ag(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jRj = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jRj.setSelector(R.color.transparent);
        this.jRk = new h(this.jQx, this.jQj);
        if (this.jQj.getWriteImagesInfo() != null && this.jQj.getWriteImagesInfo().isFromQRCode()) {
            this.jRk.sl(false);
        } else {
            this.jRk.sl(this.jQx.cAX() != 1);
        }
        this.jRj.setAdapter((ListAdapter) this.jRk);
        this.jRj.setOuterOnScrollListener(this);
        this.jRk.a(this.jQV);
        this.jRk.a(this.jQU);
        this.jRk.ad(this.jQT);
        this.jRk.setOnOpenCameraFailedListener(this.jQX);
        this.jRk.setOnRequestPermissionListener(this.jQW);
        this.jQE.setOnClickListener(this.jQx);
        this.dVU.setOnClickListener(this.jQx);
        this.jRh.setOnClickListener(this.jQx);
        this.jQF.setOnClickListener(this.jQx);
        this.fhE.setOnClickListener(this.mOnClickListener);
        this.jQD.setOnClickListener(this.mOnClickListener);
        cBw();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cDr == null) {
            this.cDr = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cDr.e(null);
        this.cDr.iC(R.string.loading);
        this.cDr.em(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jQx.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBw() {
        int Z;
        String string;
        if (this.jQj != null && this.jQE != null) {
            if (this.jQj.cBn()) {
                int i = this.jQj.cBn() ? 1 : 0;
                Z = i;
                string = this.jQx.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                Z = v.Z(this.jQj.cBp());
                string = this.jQx.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jQj.getMaxImagesAllowed())});
            }
            this.jQE.setText(string);
            this.jQE.setEnabled(Z > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hMV = false;
        if (isShow()) {
            aJO();
        }
    }

    private void cBj() {
        if (this.jQj == null && this.jQx != null) {
            this.jQj = this.jQx.cAY();
        }
        if (this.jQj != null) {
            if (!this.jQj.avf()) {
                this.jRk.notifyDataSetChanged();
            } else {
                cBx();
            }
            si(this.jQj.isOriginalImg());
        }
    }

    private void cBx() {
        if (this.jRg == null) {
            this.jRg = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jRg.a(this.jQx.cAX() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cDr != null) {
                    ImageListFragment.this.cDr.em(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jQj != null && gVar != null) {
                    ImageListFragment.this.jQj.c(gVar);
                    String cBq = ImageListFragment.this.jQj.cBq();
                    ImageListFragment.this.jQj.Hg(cBq);
                    ImageListFragment.this.jRk.setData(ImageListFragment.this.jQj.Hi(cBq));
                    ImageListFragment.this.jRj.smoothScrollToPosition(0);
                    ImageListFragment.this.cBw();
                }
                ImageListFragment.this.jRj.cBD();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        am.h(this.jRl, R.color.cp_bg_line_c, i);
        am.f(this.fhE, R.color.cp_cont_b, i);
        if (this.jQx.cAX() == 1) {
            SvgManager.ajv().a(this.dVU, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, null);
            this.jRh.setVisibility(8);
        } else {
            am.j(this.jRh, R.color.navi_back_text_color);
            this.dVU.setVisibility(8);
        }
        if (this.fhE != null) {
            this.fhE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.jRk != null) {
            this.jRk.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jQj != null) {
            si(this.jQj.isOriginalImg());
        }
    }

    public View clS() {
        return this.jQx.cAX() == 1 ? this.dVU : this.jRh;
    }

    public View cBy() {
        return this.jQE;
    }

    public TbCameraView cBb() {
        if (this.jRk != null) {
            return this.jRk.cBu();
        }
        return null;
    }

    public TransparentHeadGridView cBz() {
        return this.jRj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jRi != null) {
            this.jRi.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jRg != null) {
            this.jRg.aaz();
        }
        if (this.jQx != null) {
            this.jQx.closeLoadingDialog();
        }
        if (this.cDr != null) {
            this.cDr.em(false);
        }
        d.cBt().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hMV = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void sk(boolean z) {
        aJO();
    }

    private void aJO() {
        if (!isHidden() && !this.hMV) {
            cBj();
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
            this.jRk.nT(true);
        } else if (this.jRk.isScroll()) {
            this.jRk.nT(false);
        }
    }

    public void V(int i, boolean z) {
        if (this.jRj != null) {
            int firstVisiblePosition = this.jRj.getFirstVisiblePosition();
            int lastVisiblePosition = this.jRj.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jRj.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jRk != null) {
                    this.jRk.d((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cBw();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jRk != null) {
            V(this.jRk.i(imageFileInfo), z);
        }
    }

    public View cBg() {
        return this.jQF;
    }

    public void si(boolean z) {
        if (this.jQx != null && this.jQF != null) {
            this.jQF.setText(this.jQx.getResources().getString(R.string.original_img));
            if (z) {
                this.jQF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.jQF, R.color.cp_link_tip_a);
                return;
            }
            this.jQF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.jQF, R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jQt = iVar;
    }
}
