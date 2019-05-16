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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
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
    private ImageView dQn;
    private View eAb;
    private RelativeLayout epV;
    private TextView fap;
    private boolean hDO;
    private c jFA;
    private i jFK;
    private AlbumActivity jFO;
    private View jFU;
    private TextView jFV;
    private TextView jFW;
    private TransparentHeadGridView jGA;
    private h jGB;
    private View jGC;
    private com.baidu.tbadk.album.f jGx;
    private TextView jGy;
    private com.baidu.tieba.write.view.a jGz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cAW = null;
    private View.OnClickListener jGk = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jFA != null) {
                int maxImagesAllowed = ImageListFragment.this.jFA.getMaxImagesAllowed();
                if (ImageListFragment.this.jFA.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jFO != null) {
                        ImageListFragment.this.jFO.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jFA != null) {
                if (ImageListFragment.this.jFK == null || !ImageListFragment.this.jFK.cxu()) {
                    if (view == ImageListFragment.this.fap) {
                        ImageListFragment.this.jGz.b(ImageListFragment.this.jFA.cxh(), ImageListFragment.this.jFA.cxf());
                        ImageListFragment.this.jGz.bm(ImageListFragment.this.eAb);
                        ImageListFragment.this.fap.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jFU) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jGn = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aXl() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jGo = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cxp() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.fap != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(R.drawable.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.fap.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jGl = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jFA != null && ImageListFragment.this.jFA.getWriteImagesInfo() != null && ImageListFragment.this.jFA.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jFO.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jFA != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jFA.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jFO.Cj(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0434a jGD = new a.InterfaceC0434a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0434a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> FL;
            if (ImageListFragment.this.jFA != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jFA.cxf()) && (FL = ImageListFragment.this.jFA.FL(albumId)) != null) {
                    ImageListFragment.this.jFA.FJ(albumId);
                    ImageListFragment.this.jGB.setData(FL);
                    ImageListFragment.this.fap.setText(name);
                    ImageListFragment.this.jGA.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jGm = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jFO == null || ImageListFragment.this.jFA == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jFA.cxc()) {
                    ImageListFragment.this.jFO.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jFA.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jFO.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jFO.e(imageFileInfo);
                }
                ImageListFragment.this.jFA.a(null);
                ImageListFragment.this.jGB.notifyDataSetChanged();
                ImageListFragment.this.cxl();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jFA.cxb()) {
                    ImageListFragment.this.jFO.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jFA.b(videoFileInfo)) {
                        ImageListFragment.this.jFA.a(null);
                    } else {
                        ImageListFragment.this.jFA.a(videoFileInfo);
                    }
                    ImageListFragment.this.jFA.cxd();
                    ImageListFragment.this.jGB.notifyDataSetChanged();
                    ImageListFragment.this.cxl();
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
        this.jFO = (AlbumActivity) getBaseFragmentActivity();
        this.jFA = this.jFO.cwN();
        d.cxi().a(this);
        this.jGx = new com.baidu.tbadk.album.f(this.jFO);
        this.jGz = new com.baidu.tieba.write.view.a(this.jFO);
        this.jGz.setOnDismissListener(this.mOnDismissListener);
        this.jGz.a(this.jGD);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.epV = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.eAb = this.mView.findViewById(R.id.layout_title);
        this.fap = (TextView) this.mView.findViewById(R.id.album_title);
        this.dQn = (ImageView) this.mView.findViewById(R.id.img_close);
        this.jGy = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.jGC = this.mView.findViewById(R.id.navi_line);
        this.jFU = this.mView.findViewById(R.id.layout_bottom);
        this.jFW = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.jFV = (TextView) this.mView.findViewById(R.id.next_step);
        this.jFA.FJ(com.baidu.tbadk.album.a.bzV);
        this.fap.setText(this.jFO.getPageContext().getString(R.string.album_all_media));
        if (this.jFA.getWriteImagesInfo() != null) {
            this.jFW.setVisibility(this.jFA.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jFA.getWriteImagesInfo() != null && this.jFA.getWriteImagesInfo().isFromQRCode()) {
            this.jFU.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jFO.getPageContext().getPageActivity(), this.epV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ad(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jGA = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jGA.setSelector(R.color.transparent);
        this.jGB = new h(this.jFO, this.jFA);
        if (this.jFA.getWriteImagesInfo() != null && this.jFA.getWriteImagesInfo().isFromQRCode()) {
            this.jGB.rR(false);
        } else {
            this.jGB.rR(this.jFO.cwM() != 1);
        }
        this.jGA.setAdapter((ListAdapter) this.jGB);
        this.jGA.setOuterOnScrollListener(this);
        this.jGB.a(this.jGm);
        this.jGB.a(this.jGl);
        this.jGB.ab(this.jGk);
        this.jGB.setOnOpenCameraFailedListener(this.jGo);
        this.jGB.setOnRequestPermissionListener(this.jGn);
        this.jFV.setOnClickListener(this.jFO);
        this.dQn.setOnClickListener(this.jFO);
        this.jGy.setOnClickListener(this.jFO);
        this.jFW.setOnClickListener(this.jFO);
        this.fap.setOnClickListener(this.mOnClickListener);
        this.jFU.setOnClickListener(this.mOnClickListener);
        cxl();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cAW == null) {
            this.cAW = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cAW.e(null);
        this.cAW.it(R.string.loading);
        this.cAW.ef(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jFO.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxl() {
        int Z;
        String string;
        if (this.jFA != null && this.jFV != null) {
            if (this.jFA.cxc()) {
                int i = this.jFA.cxc() ? 1 : 0;
                Z = i;
                string = this.jFO.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                Z = v.Z(this.jFA.cxe());
                string = this.jFO.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jFA.getMaxImagesAllowed())});
            }
            this.jFV.setText(string);
            this.jFV.setEnabled(Z > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hDO = false;
        if (isShow()) {
            aHI();
        }
    }

    private void cwY() {
        if (this.jFA == null && this.jFO != null) {
            this.jFA = this.jFO.cwN();
        }
        if (this.jFA != null) {
            if (!this.jFA.atJ()) {
                this.jGB.notifyDataSetChanged();
            } else {
                cxm();
            }
            rO(this.jFA.isOriginalImg());
        }
    }

    private void cxm() {
        if (this.jGx == null) {
            this.jGx = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jGx.a(this.jFO.cwM() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cAW != null) {
                    ImageListFragment.this.cAW.ef(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jFA != null && gVar != null) {
                    ImageListFragment.this.jFA.c(gVar);
                    String cxf = ImageListFragment.this.jFA.cxf();
                    ImageListFragment.this.jFA.FJ(cxf);
                    ImageListFragment.this.jGB.setData(ImageListFragment.this.jFA.FL(cxf));
                    ImageListFragment.this.jGA.smoothScrollToPosition(0);
                    ImageListFragment.this.cxl();
                }
                ImageListFragment.this.jGA.cxs();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        al.h(this.jGC, R.color.cp_bg_line_b, i);
        al.f(this.fap, R.color.cp_cont_b, i);
        if (this.jFO.cwM() == 1) {
            al.b(this.dQn, (int) R.drawable.icon_topbar_close_n, i);
            this.jGy.setVisibility(8);
        } else {
            al.j(this.jGy, R.color.navi_back_text_color);
            this.dQn.setVisibility(8);
        }
        if (this.fap != null) {
            this.fap.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
        }
        if (this.jGB != null) {
            this.jGB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jFA != null) {
            rO(this.jFA.isOriginalImg());
        }
    }

    public View chU() {
        return this.jFO.cwM() == 1 ? this.dQn : this.jGy;
    }

    public View cxn() {
        return this.jFV;
    }

    public TbCameraView cwQ() {
        if (this.jGB != null) {
            return this.jGB.cxj();
        }
        return null;
    }

    public TransparentHeadGridView cxo() {
        return this.jGA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jGz != null) {
            this.jGz.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jGx != null) {
            this.jGx.Zw();
        }
        if (this.jFO != null) {
            this.jFO.closeLoadingDialog();
        }
        if (this.cAW != null) {
            this.cAW.ef(false);
        }
        d.cxi().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hDO = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void rQ(boolean z) {
        aHI();
    }

    private void aHI() {
        if (!isHidden() && !this.hDO) {
            cwY();
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
            this.jGB.nA(true);
        } else if (this.jGB.isScroll()) {
            this.jGB.nA(false);
        }
    }

    public void S(int i, boolean z) {
        if (this.jGA != null) {
            int firstVisiblePosition = this.jGA.getFirstVisiblePosition();
            int lastVisiblePosition = this.jGA.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jGA.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jGB != null) {
                    this.jGB.d((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cxl();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jGB != null) {
            S(this.jGB.i(imageFileInfo), z);
        }
    }

    public View cwV() {
        return this.jFW;
    }

    public void rO(boolean z) {
        if (this.jFO != null && this.jFW != null) {
            this.jFW.setText(this.jFO.getResources().getString(R.string.original_img));
            if (z) {
                this.jFW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.jFW, R.color.cp_link_tip_a);
                return;
            }
            this.jFW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.jFW, R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jFK = iVar;
    }
}
