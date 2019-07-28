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
    private ImageView dUc;
    private View eEY;
    private RelativeLayout euU;
    private TextView ffr;
    private boolean hKf;
    private c jMH;
    private i jMR;
    private AlbumActivity jMV;
    private com.baidu.tbadk.album.f jNE;
    private TextView jNF;
    private com.baidu.tieba.write.view.a jNG;
    private TransparentHeadGridView jNH;
    private h jNI;
    private View jNJ;
    private View jNb;
    private TextView jNc;
    private TextView jNd;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cCo = null;
    private View.OnClickListener jNr = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jMH != null) {
                int maxImagesAllowed = ImageListFragment.this.jMH.getMaxImagesAllowed();
                if (ImageListFragment.this.jMH.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jMV != null) {
                        ImageListFragment.this.jMV.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jMH != null) {
                if (ImageListFragment.this.jMR == null || !ImageListFragment.this.jMR.cAw()) {
                    if (view == ImageListFragment.this.ffr) {
                        ImageListFragment.this.jNG.b(ImageListFragment.this.jMH.cAj(), ImageListFragment.this.jMH.cAh());
                        ImageListFragment.this.jNG.bo(ImageListFragment.this.eEY);
                        ImageListFragment.this.ffr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jNb) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jNu = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aZl() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jNv = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cAr() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.ffr != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = am.getDrawable(R.drawable.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.ffr.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jNs = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jMH != null && ImageListFragment.this.jMH.getWriteImagesInfo() != null && ImageListFragment.this.jMH.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jMV.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jMH != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jMH.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jMV.CQ(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0439a jNK = new a.InterfaceC0439a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0439a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> GH;
            if (ImageListFragment.this.jMH != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jMH.cAh()) && (GH = ImageListFragment.this.jMH.GH(albumId)) != null) {
                    ImageListFragment.this.jMH.GF(albumId);
                    ImageListFragment.this.jNI.setData(GH);
                    ImageListFragment.this.ffr.setText(name);
                    ImageListFragment.this.jNH.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jNt = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jMV == null || ImageListFragment.this.jMH == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jMH.cAe()) {
                    ImageListFragment.this.jMV.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jMH.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jMV.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jMV.e(imageFileInfo);
                }
                ImageListFragment.this.jMH.a(null);
                ImageListFragment.this.jNI.notifyDataSetChanged();
                ImageListFragment.this.cAn();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jMH.cAd()) {
                    ImageListFragment.this.jMV.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jMH.b(videoFileInfo)) {
                        ImageListFragment.this.jMH.a(null);
                    } else {
                        ImageListFragment.this.jMH.a(videoFileInfo);
                    }
                    ImageListFragment.this.jMH.cAf();
                    ImageListFragment.this.jNI.notifyDataSetChanged();
                    ImageListFragment.this.cAn();
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
        this.jMV = (AlbumActivity) getBaseFragmentActivity();
        this.jMH = this.jMV.czP();
        d.cAk().a(this);
        this.jNE = new com.baidu.tbadk.album.f(this.jMV);
        this.jNG = new com.baidu.tieba.write.view.a(this.jMV);
        this.jNG.setOnDismissListener(this.mOnDismissListener);
        this.jNG.a(this.jNK);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.euU = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.eEY = this.mView.findViewById(R.id.layout_title);
        this.ffr = (TextView) this.mView.findViewById(R.id.album_title);
        this.dUc = (ImageView) this.mView.findViewById(R.id.img_close);
        this.jNF = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.jNJ = this.mView.findViewById(R.id.navi_line);
        this.jNb = this.mView.findViewById(R.id.layout_bottom);
        this.jNd = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.jNc = (TextView) this.mView.findViewById(R.id.next_step);
        this.jMH.GF(com.baidu.tbadk.album.a.bAS);
        this.ffr.setText(this.jMV.getPageContext().getString(R.string.album_all_media));
        if (this.jMH.getWriteImagesInfo() != null) {
            this.jNd.setVisibility(this.jMH.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jMH.getWriteImagesInfo() != null && this.jMH.getWriteImagesInfo().isFromQRCode()) {
            this.jNb.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jMV.getPageContext().getPageActivity(), this.euU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ag(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jNH = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jNH.setSelector(R.color.transparent);
        this.jNI = new h(this.jMV, this.jMH);
        if (this.jMH.getWriteImagesInfo() != null && this.jMH.getWriteImagesInfo().isFromQRCode()) {
            this.jNI.sh(false);
        } else {
            this.jNI.sh(this.jMV.czO() != 1);
        }
        this.jNH.setAdapter((ListAdapter) this.jNI);
        this.jNH.setOuterOnScrollListener(this);
        this.jNI.a(this.jNt);
        this.jNI.a(this.jNs);
        this.jNI.ad(this.jNr);
        this.jNI.setOnOpenCameraFailedListener(this.jNv);
        this.jNI.setOnRequestPermissionListener(this.jNu);
        this.jNc.setOnClickListener(this.jMV);
        this.dUc.setOnClickListener(this.jMV);
        this.jNF.setOnClickListener(this.jMV);
        this.jNd.setOnClickListener(this.jMV);
        this.ffr.setOnClickListener(this.mOnClickListener);
        this.jNb.setOnClickListener(this.mOnClickListener);
        cAn();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cCo == null) {
            this.cCo = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cCo.e(null);
        this.cCo.iz(R.string.loading);
        this.cCo.ej(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jMV.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAn() {
        int Z;
        String string;
        if (this.jMH != null && this.jNc != null) {
            if (this.jMH.cAe()) {
                int i = this.jMH.cAe() ? 1 : 0;
                Z = i;
                string = this.jMV.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                Z = v.Z(this.jMH.cAg());
                string = this.jMV.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jMH.getMaxImagesAllowed())});
            }
            this.jNc.setText(string);
            this.jNc.setEnabled(Z > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hKf = false;
        if (isShow()) {
            aJi();
        }
    }

    private void cAa() {
        if (this.jMH == null && this.jMV != null) {
            this.jMH = this.jMV.czP();
        }
        if (this.jMH != null) {
            if (!this.jMH.auR()) {
                this.jNI.notifyDataSetChanged();
            } else {
                cAo();
            }
            se(this.jMH.isOriginalImg());
        }
    }

    private void cAo() {
        if (this.jNE == null) {
            this.jNE = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jNE.a(this.jMV.czO() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cCo != null) {
                    ImageListFragment.this.cCo.ej(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jMH != null && gVar != null) {
                    ImageListFragment.this.jMH.c(gVar);
                    String cAh = ImageListFragment.this.jMH.cAh();
                    ImageListFragment.this.jMH.GF(cAh);
                    ImageListFragment.this.jNI.setData(ImageListFragment.this.jMH.GH(cAh));
                    ImageListFragment.this.jNH.smoothScrollToPosition(0);
                    ImageListFragment.this.cAn();
                }
                ImageListFragment.this.jNH.cAu();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        am.h(this.jNJ, R.color.cp_bg_line_b, i);
        am.f(this.ffr, R.color.cp_cont_b, i);
        if (this.jMV.czO() == 1) {
            am.b(this.dUc, (int) R.drawable.icon_topbar_close_n, i);
            this.jNF.setVisibility(8);
        } else {
            am.j(this.jNF, R.color.navi_back_text_color);
            this.dUc.setVisibility(8);
        }
        if (this.ffr != null) {
            this.ffr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
        }
        if (this.jNI != null) {
            this.jNI.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jMH != null) {
            se(this.jMH.isOriginalImg());
        }
    }

    public View ckO() {
        return this.jMV.czO() == 1 ? this.dUc : this.jNF;
    }

    public View cAp() {
        return this.jNc;
    }

    public TbCameraView czS() {
        if (this.jNI != null) {
            return this.jNI.cAl();
        }
        return null;
    }

    public TransparentHeadGridView cAq() {
        return this.jNH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jNG != null) {
            this.jNG.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jNE != null) {
            this.jNE.aav();
        }
        if (this.jMV != null) {
            this.jMV.closeLoadingDialog();
        }
        if (this.cCo != null) {
            this.cCo.ej(false);
        }
        d.cAk().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hKf = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void sg(boolean z) {
        aJi();
    }

    private void aJi() {
        if (!isHidden() && !this.hKf) {
            cAa();
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
            this.jNI.nP(true);
        } else if (this.jNI.isScroll()) {
            this.jNI.nP(false);
        }
    }

    public void U(int i, boolean z) {
        if (this.jNH != null) {
            int firstVisiblePosition = this.jNH.getFirstVisiblePosition();
            int lastVisiblePosition = this.jNH.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jNH.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jNI != null) {
                    this.jNI.d((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cAn();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jNI != null) {
            U(this.jNI.i(imageFileInfo), z);
        }
    }

    public View czX() {
        return this.jNd;
    }

    public void se(boolean z) {
        if (this.jMV != null && this.jNd != null) {
            this.jNd.setText(this.jMV.getResources().getString(R.string.original_img));
            if (z) {
                this.jNd.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.jNd, R.color.cp_link_tip_a);
                return;
            }
            this.jNd.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.jNd, R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jMR = iVar;
    }
}
