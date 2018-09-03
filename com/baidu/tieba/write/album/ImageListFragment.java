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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.f;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View cBo;
    private RelativeLayout cSx;
    private TextView cXY;
    private ImageView fbV;
    private boolean fuU;
    private c htC;
    private i htL;
    private AlbumActivity htP;
    private View htV;
    private TextView htW;
    private TextView htX;
    private com.baidu.tieba.write.view.a huA;
    private TransparentHeadGridView huB;
    private h huC;
    private View huD;
    private com.baidu.tbadk.album.f huy;
    private TextView huz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a aVY = null;
    private View.OnClickListener hul = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.htC != null) {
                int maxImagesAllowed = ImageListFragment.this.htC.getMaxImagesAllowed();
                if (ImageListFragment.this.htC.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.htP != null) {
                        ImageListFragment.this.htP.b(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(f.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.htC != null) {
                if (ImageListFragment.this.htL == null || !ImageListFragment.this.htL.bGs()) {
                    if (view == ImageListFragment.this.cXY) {
                        ImageListFragment.this.huA.f(ImageListFragment.this.htC.bGe(), ImageListFragment.this.htC.bGc());
                        ImageListFragment.this.huA.au(ImageListFragment.this.cBo);
                        ImageListFragment.this.cXY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.htV) {
                    }
                }
            }
        }
    };
    private TbCameraView.c huo = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bGm() {
            return !ac.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hup = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bGn() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.cXY != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = am.getDrawable(f.C0146f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.cXY.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hum = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.htC != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.htC.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.htP.vn(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0259a huE = new a.InterfaceC0259a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0259a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> vG;
            if (ImageListFragment.this.htC != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.htC.bGc()) && (vG = ImageListFragment.this.htC.vG(albumId)) != null) {
                    ImageListFragment.this.htC.vE(albumId);
                    ImageListFragment.this.huC.setData(vG);
                    ImageListFragment.this.cXY.setText(name);
                    ImageListFragment.this.huB.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hun = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.htP == null || ImageListFragment.this.htC == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.htC.bFZ()) {
                    ImageListFragment.this.htP.showToast(f.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.htC.isAdded(imageFileInfo)) {
                    ImageListFragment.this.htP.d(imageFileInfo);
                } else {
                    ImageListFragment.this.htP.c(imageFileInfo);
                }
                ImageListFragment.this.htC.a(null);
                ImageListFragment.this.huC.notifyDataSetChanged();
                ImageListFragment.this.bGi();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.htC.bFY()) {
                    ImageListFragment.this.htP.showToast(f.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.htC.b(videoFileInfo)) {
                        ImageListFragment.this.htC.a(null);
                    } else {
                        ImageListFragment.this.htC.a(videoFileInfo);
                    }
                    ImageListFragment.this.htC.bGa();
                    ImageListFragment.this.huC.notifyDataSetChanged();
                    ImageListFragment.this.bGi();
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
        this.htP = (AlbumActivity) getBaseFragmentActivity();
        this.htC = this.htP.bFJ();
        d.bGf().a(this);
        this.huy = new com.baidu.tbadk.album.f(this.htP);
        this.huA = new com.baidu.tieba.write.view.a(this.htP);
        this.huA.setOnDismissListener(this.mOnDismissListener);
        this.huA.a(this.huE);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(f.h.album_image_list_view, (ViewGroup) null);
        this.cSx = (RelativeLayout) this.mView.findViewById(f.g.album_image_list_root);
        this.cBo = this.mView.findViewById(f.g.layout_title);
        this.cXY = (TextView) this.mView.findViewById(f.g.album_title);
        this.fbV = (ImageView) this.mView.findViewById(f.g.img_close);
        this.huz = (TextView) this.mView.findViewById(f.g.img_close_text);
        this.huD = this.mView.findViewById(f.g.navi_line);
        this.htV = this.mView.findViewById(f.g.layout_bottom);
        this.htX = (TextView) this.mView.findViewById(f.g.original_select_btn);
        this.htW = (TextView) this.mView.findViewById(f.g.next_step);
        this.htC.vE(com.baidu.tbadk.album.a.ZX);
        this.cXY.setText(this.htP.getPageContext().getString(f.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.htP.getPageContext().getPageActivity(), this.cSx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.E(f.j.album_list_no_data, f.j.album_list_no_data_1), null);
        this.huB = (TransparentHeadGridView) this.mView.findViewById(f.g.gv_image_list);
        this.huB.setSelector(f.d.transparent);
        this.huC = new h(this.htP, this.htC);
        this.huC.nv(this.htP.bFI() != 1);
        this.huB.setAdapter((ListAdapter) this.huC);
        this.huB.setOuterOnScrollListener(this);
        this.huC.a(this.hun);
        this.huC.a(this.hum);
        this.huC.X(this.hul);
        this.huC.setOnOpenCameraFailedListener(this.hup);
        this.huC.setOnRequestPermissionListener(this.huo);
        this.htW.setOnClickListener(this.htP);
        this.fbV.setOnClickListener(this.htP);
        this.huz.setOnClickListener(this.htP);
        this.htX.setOnClickListener(this.htP);
        this.cXY.setOnClickListener(this.mOnClickListener);
        this.htV.setOnClickListener(this.mOnClickListener);
        bGi();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aVY == null) {
            this.aVY = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.aVY.d(null);
        this.aVY.df(f.j.loading);
        this.aVY.aN(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.htP.showToast(f.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGi() {
        int y;
        String string;
        if (this.htC != null && this.htW != null) {
            if (this.htC.bFZ()) {
                int i = this.htC.bFZ() ? 1 : 0;
                y = i;
                string = this.htP.getString(f.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                y = w.y(this.htC.bGb());
                string = this.htP.getString(f.j.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.htC.getMaxImagesAllowed())});
            }
            this.htW.setText(string);
            this.htW.setEnabled(y > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fuU = false;
        if (isShow()) {
            TP();
        }
    }

    private void bFV() {
        if (this.htC == null && this.htP != null) {
            this.htC = this.htP.bFJ();
        }
        if (this.htC != null) {
            if (!this.htC.Kj()) {
                this.huC.notifyDataSetChanged();
            } else {
                bGj();
            }
            ns(this.htC.isOriginalImg());
        }
    }

    private void bGj() {
        if (this.huy == null) {
            this.huy = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.huy.a(this.htP.bFI() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.aVY != null) {
                    ImageListFragment.this.aVY.aN(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.htC != null && gVar != null) {
                    ImageListFragment.this.htC.c(gVar);
                    String bGc = ImageListFragment.this.htC.bGc();
                    ImageListFragment.this.htC.vE(bGc);
                    ImageListFragment.this.huC.setData(ImageListFragment.this.htC.vG(bGc));
                    ImageListFragment.this.huB.smoothScrollToPosition(0);
                    ImageListFragment.this.bGi();
                }
                ImageListFragment.this.huB.bGq();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        am.e(this.huD, f.d.cp_bg_line_b, i);
        am.c(this.cXY, f.d.cp_cont_b, i);
        if (this.htP.bFI() == 1) {
            am.b(this.fbV, f.C0146f.icon_topbar_close_n, i);
            this.huz.setVisibility(8);
        } else {
            am.h(this.huz, f.d.navi_back_text_color);
            this.fbV.setVisibility(8);
        }
        if (this.cXY != null) {
            this.cXY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_album_spread), (Drawable) null);
        }
        if (this.huC != null) {
            this.huC.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.htC != null) {
            ns(this.htC.isOriginalImg());
        }
    }

    public View bqy() {
        return this.htP.bFI() == 1 ? this.fbV : this.huz;
    }

    public View bGk() {
        return this.htW;
    }

    public TbCameraView bFN() {
        if (this.huC != null) {
            return this.huC.bGg();
        }
        return null;
    }

    public TransparentHeadGridView bGl() {
        return this.huB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.huA != null) {
            this.huA.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.huy != null) {
            this.huy.rF();
        }
        if (this.htP != null) {
            this.htP.closeLoadingDialog();
        }
        if (this.aVY != null) {
            this.aVY.aN(false);
        }
        d.bGf().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fuU = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void nu(boolean z) {
        TP();
    }

    private void TP() {
        if (!isHidden() && !this.fuU) {
            bFV();
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
            this.huC.je(true);
        } else if (this.huC.isScroll()) {
            this.huC.je(false);
        }
    }

    public void G(int i, boolean z) {
        if (this.huB != null) {
            int firstVisiblePosition = this.huB.getFirstVisiblePosition();
            int lastVisiblePosition = this.huB.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.huB.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.huC != null) {
                    this.huC.d((ImageView) childAt.findViewById(f.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGi();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.huC != null) {
            G(this.huC.g(imageFileInfo), z);
        }
    }

    public View bFS() {
        return this.htX;
    }

    public void ns(boolean z) {
        if (this.htP != null && this.htX != null) {
            this.htX.setText(this.htP.getResources().getString(f.j.original_img));
            if (z) {
                this.htX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.htX, f.d.cp_link_tip_a);
                return;
            }
            this.htX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.htX, f.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.htL = iVar;
    }
}
