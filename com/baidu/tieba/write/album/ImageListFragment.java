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
import com.baidu.tieba.e;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private ImageView crE;
    private View daQ;
    private RelativeLayout drQ;
    private TextView dxd;
    private boolean fWs;
    private c hVX;
    private com.baidu.tbadk.album.f hWU;
    private TextView hWV;
    private com.baidu.tieba.write.view.a hWW;
    private TransparentHeadGridView hWX;
    private h hWY;
    private View hWZ;
    private i hWh;
    private AlbumActivity hWl;
    private View hWr;
    private TextView hWs;
    private TextView hWt;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d biP = null;
    private View.OnClickListener hWH = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hVX != null) {
                int maxImagesAllowed = ImageListFragment.this.hVX.getMaxImagesAllowed();
                if (ImageListFragment.this.hVX.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hWl != null) {
                        ImageListFragment.this.hWl.b(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hVX != null) {
                if (ImageListFragment.this.hWh == null || !ImageListFragment.this.hWh.bPx()) {
                    if (view == ImageListFragment.this.dxd) {
                        ImageListFragment.this.hWW.setData(ImageListFragment.this.hVX.bPj(), ImageListFragment.this.hVX.bPh());
                        ImageListFragment.this.hWW.aN(ImageListFragment.this.daQ);
                        ImageListFragment.this.dxd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hWr) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hWK = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bPr() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hWL = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bPs() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.dxd != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(e.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.dxd.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hWI = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hVX != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hVX.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hWl.xp(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0341a hXa = new a.InterfaceC0341a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0341a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> xR;
            if (ImageListFragment.this.hVX != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hVX.bPh()) && (xR = ImageListFragment.this.hVX.xR(albumId)) != null) {
                    ImageListFragment.this.hVX.xP(albumId);
                    ImageListFragment.this.hWY.setData(xR);
                    ImageListFragment.this.dxd.setText(name);
                    ImageListFragment.this.hWX.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hWJ = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hWl == null || ImageListFragment.this.hVX == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hVX.bPe()) {
                    ImageListFragment.this.hWl.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hVX.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hWl.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hWl.c(imageFileInfo);
                }
                ImageListFragment.this.hVX.a(null);
                ImageListFragment.this.hWY.notifyDataSetChanged();
                ImageListFragment.this.bPn();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hVX.bPd()) {
                    ImageListFragment.this.hWl.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hVX.b(videoFileInfo)) {
                        ImageListFragment.this.hVX.a(null);
                    } else {
                        ImageListFragment.this.hVX.a(videoFileInfo);
                    }
                    ImageListFragment.this.hVX.bPf();
                    ImageListFragment.this.hWY.notifyDataSetChanged();
                    ImageListFragment.this.bPn();
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
        this.hWl = (AlbumActivity) getBaseFragmentActivity();
        this.hVX = this.hWl.bOO();
        d.bPk().a(this);
        this.hWU = new com.baidu.tbadk.album.f(this.hWl);
        this.hWW = new com.baidu.tieba.write.view.a(this.hWl);
        this.hWW.setOnDismissListener(this.mOnDismissListener);
        this.hWW.a(this.hXa);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.drQ = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.daQ = this.mView.findViewById(e.g.layout_title);
        this.dxd = (TextView) this.mView.findViewById(e.g.album_title);
        this.crE = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hWV = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hWZ = this.mView.findViewById(e.g.navi_line);
        this.hWr = this.mView.findViewById(e.g.layout_bottom);
        this.hWt = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hWs = (TextView) this.mView.findViewById(e.g.next_step);
        this.hVX.xP(com.baidu.tbadk.album.a.amh);
        this.dxd.setText(this.hWl.getPageContext().getString(e.j.album_all_media));
        if (this.hVX.getWriteImagesInfo() != null) {
            this.hWt.setVisibility(this.hVX.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hWl.getPageContext().getPageActivity(), this.drQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.H(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hWX = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hWX.setSelector(e.d.transparent);
        this.hWY = new h(this.hWl, this.hVX);
        this.hWY.oC(this.hWl.bON() != 1);
        this.hWX.setAdapter((ListAdapter) this.hWY);
        this.hWX.setOuterOnScrollListener(this);
        this.hWY.a(this.hWJ);
        this.hWY.a(this.hWI);
        this.hWY.Y(this.hWH);
        this.hWY.setOnOpenCameraFailedListener(this.hWL);
        this.hWY.setOnRequestPermissionListener(this.hWK);
        this.hWs.setOnClickListener(this.hWl);
        this.crE.setOnClickListener(this.hWl);
        this.hWV.setOnClickListener(this.hWl);
        this.hWt.setOnClickListener(this.hWl);
        this.dxd.setOnClickListener(this.mOnClickListener);
        this.hWr.setOnClickListener(this.mOnClickListener);
        bPn();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.biP == null) {
            this.biP = new com.baidu.tbadk.core.view.d(getPageContext());
        }
        this.biP.d(null);
        this.biP.ec(e.j.loading);
        this.biP.bB(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hWl.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPn() {
        int H;
        String string;
        if (this.hVX != null && this.hWs != null) {
            if (this.hVX.bPe()) {
                int i = this.hVX.bPe() ? 1 : 0;
                H = i;
                string = this.hWl.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                H = v.H(this.hVX.bPg());
                string = this.hWl.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hVX.getMaxImagesAllowed())});
            }
            this.hWs.setText(string);
            this.hWs.setEnabled(H > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fWs = false;
        if (isShow()) {
            aaZ();
        }
    }

    private void bPa() {
        if (this.hVX == null && this.hWl != null) {
            this.hVX = this.hWl.bOO();
        }
        if (this.hVX != null) {
            if (!this.hVX.Pd()) {
                this.hWY.notifyDataSetChanged();
            } else {
                bPo();
            }
            oz(this.hVX.isOriginalImg());
        }
    }

    private void bPo() {
        if (this.hWU == null) {
            this.hWU = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hWU.a(this.hWl.bON() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.biP != null) {
                    ImageListFragment.this.biP.bB(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hVX != null && gVar != null) {
                    ImageListFragment.this.hVX.c(gVar);
                    String bPh = ImageListFragment.this.hVX.bPh();
                    ImageListFragment.this.hVX.xP(bPh);
                    ImageListFragment.this.hWY.setData(ImageListFragment.this.hVX.xR(bPh));
                    ImageListFragment.this.hWX.smoothScrollToPosition(0);
                    ImageListFragment.this.bPn();
                }
                ImageListFragment.this.hWX.bPv();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hWZ, e.d.cp_bg_line_b, i);
        al.c(this.dxd, e.d.cp_cont_b, i);
        if (this.hWl.bON() == 1) {
            al.b(this.crE, e.f.icon_topbar_close_n, i);
            this.hWV.setVisibility(8);
        } else {
            al.h(this.hWV, e.d.navi_back_text_color);
            this.crE.setVisibility(8);
        }
        if (this.dxd != null) {
            this.dxd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hWY != null) {
            this.hWY.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hVX != null) {
            oz(this.hVX.isOriginalImg());
        }
    }

    public View bzd() {
        return this.hWl.bON() == 1 ? this.crE : this.hWV;
    }

    public View bPp() {
        return this.hWs;
    }

    public TbCameraView bOS() {
        if (this.hWY != null) {
            return this.hWY.bPl();
        }
        return null;
    }

    public TransparentHeadGridView bPq() {
        return this.hWX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hWW != null) {
            this.hWW.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hWU != null) {
            this.hWU.wr();
        }
        if (this.hWl != null) {
            this.hWl.closeLoadingDialog();
        }
        if (this.biP != null) {
            this.biP.bB(false);
        }
        d.bPk().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fWs = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void oB(boolean z) {
        aaZ();
    }

    private void aaZ() {
        if (!isHidden() && !this.fWs) {
            bPa();
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
            this.hWY.kj(true);
        } else if (this.hWY.isScroll()) {
            this.hWY.kj(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hWX != null) {
            int firstVisiblePosition = this.hWX.getFirstVisiblePosition();
            int lastVisiblePosition = this.hWX.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hWX.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hWY != null) {
                    this.hWY.d((ImageView) childAt.findViewById(e.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bPn();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hWY != null) {
            H(this.hWY.g(imageFileInfo), z);
        }
    }

    public View bOX() {
        return this.hWt;
    }

    public void oz(boolean z) {
        if (this.hWl != null && this.hWt != null) {
            this.hWt.setText(this.hWl.getResources().getString(e.j.original_img));
            if (z) {
                this.hWt.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hWt, e.d.cp_link_tip_a);
                return;
            }
            this.hWt.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hWt, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hWh = iVar;
    }
}
