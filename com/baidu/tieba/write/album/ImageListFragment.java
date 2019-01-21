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
    private ImageView crF;
    private View daR;
    private RelativeLayout drR;
    private TextView dxe;
    private boolean fWt;
    private c hVY;
    private com.baidu.tbadk.album.f hWV;
    private TextView hWW;
    private com.baidu.tieba.write.view.a hWX;
    private TransparentHeadGridView hWY;
    private h hWZ;
    private i hWi;
    private AlbumActivity hWm;
    private View hWs;
    private TextView hWt;
    private TextView hWu;
    private View hXa;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d biQ = null;
    private View.OnClickListener hWI = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hVY != null) {
                int maxImagesAllowed = ImageListFragment.this.hVY.getMaxImagesAllowed();
                if (ImageListFragment.this.hVY.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hWm != null) {
                        ImageListFragment.this.hWm.b(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.hVY != null) {
                if (ImageListFragment.this.hWi == null || !ImageListFragment.this.hWi.bPx()) {
                    if (view == ImageListFragment.this.dxe) {
                        ImageListFragment.this.hWX.setData(ImageListFragment.this.hVY.bPj(), ImageListFragment.this.hVY.bPh());
                        ImageListFragment.this.hWX.aN(ImageListFragment.this.daR);
                        ImageListFragment.this.dxe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hWs) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hWL = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bPr() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hWM = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bPs() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.dxe != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(e.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.dxe.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hWJ = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hVY != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hVY.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hWm.xp(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0341a hXb = new a.InterfaceC0341a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0341a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> xR;
            if (ImageListFragment.this.hVY != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hVY.bPh()) && (xR = ImageListFragment.this.hVY.xR(albumId)) != null) {
                    ImageListFragment.this.hVY.xP(albumId);
                    ImageListFragment.this.hWZ.setData(xR);
                    ImageListFragment.this.dxe.setText(name);
                    ImageListFragment.this.hWY.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hWK = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hWm == null || ImageListFragment.this.hVY == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hVY.bPe()) {
                    ImageListFragment.this.hWm.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hVY.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hWm.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hWm.c(imageFileInfo);
                }
                ImageListFragment.this.hVY.a(null);
                ImageListFragment.this.hWZ.notifyDataSetChanged();
                ImageListFragment.this.bPn();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hVY.bPd()) {
                    ImageListFragment.this.hWm.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hVY.b(videoFileInfo)) {
                        ImageListFragment.this.hVY.a(null);
                    } else {
                        ImageListFragment.this.hVY.a(videoFileInfo);
                    }
                    ImageListFragment.this.hVY.bPf();
                    ImageListFragment.this.hWZ.notifyDataSetChanged();
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
        this.hWm = (AlbumActivity) getBaseFragmentActivity();
        this.hVY = this.hWm.bOO();
        d.bPk().a(this);
        this.hWV = new com.baidu.tbadk.album.f(this.hWm);
        this.hWX = new com.baidu.tieba.write.view.a(this.hWm);
        this.hWX.setOnDismissListener(this.mOnDismissListener);
        this.hWX.a(this.hXb);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.drR = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.daR = this.mView.findViewById(e.g.layout_title);
        this.dxe = (TextView) this.mView.findViewById(e.g.album_title);
        this.crF = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hWW = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hXa = this.mView.findViewById(e.g.navi_line);
        this.hWs = this.mView.findViewById(e.g.layout_bottom);
        this.hWu = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hWt = (TextView) this.mView.findViewById(e.g.next_step);
        this.hVY.xP(com.baidu.tbadk.album.a.amh);
        this.dxe.setText(this.hWm.getPageContext().getString(e.j.album_all_media));
        if (this.hVY.getWriteImagesInfo() != null) {
            this.hWu.setVisibility(this.hVY.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hWm.getPageContext().getPageActivity(), this.drR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.H(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hWY = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hWY.setSelector(e.d.transparent);
        this.hWZ = new h(this.hWm, this.hVY);
        this.hWZ.oC(this.hWm.bON() != 1);
        this.hWY.setAdapter((ListAdapter) this.hWZ);
        this.hWY.setOuterOnScrollListener(this);
        this.hWZ.a(this.hWK);
        this.hWZ.a(this.hWJ);
        this.hWZ.Y(this.hWI);
        this.hWZ.setOnOpenCameraFailedListener(this.hWM);
        this.hWZ.setOnRequestPermissionListener(this.hWL);
        this.hWt.setOnClickListener(this.hWm);
        this.crF.setOnClickListener(this.hWm);
        this.hWW.setOnClickListener(this.hWm);
        this.hWu.setOnClickListener(this.hWm);
        this.dxe.setOnClickListener(this.mOnClickListener);
        this.hWs.setOnClickListener(this.mOnClickListener);
        bPn();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.biQ == null) {
            this.biQ = new com.baidu.tbadk.core.view.d(getPageContext());
        }
        this.biQ.d(null);
        this.biQ.ec(e.j.loading);
        this.biQ.bB(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hWm.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPn() {
        int H;
        String string;
        if (this.hVY != null && this.hWt != null) {
            if (this.hVY.bPe()) {
                int i = this.hVY.bPe() ? 1 : 0;
                H = i;
                string = this.hWm.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                H = v.H(this.hVY.bPg());
                string = this.hWm.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hVY.getMaxImagesAllowed())});
            }
            this.hWt.setText(string);
            this.hWt.setEnabled(H > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fWt = false;
        if (isShow()) {
            aaZ();
        }
    }

    private void bPa() {
        if (this.hVY == null && this.hWm != null) {
            this.hVY = this.hWm.bOO();
        }
        if (this.hVY != null) {
            if (!this.hVY.Pd()) {
                this.hWZ.notifyDataSetChanged();
            } else {
                bPo();
            }
            oz(this.hVY.isOriginalImg());
        }
    }

    private void bPo() {
        if (this.hWV == null) {
            this.hWV = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hWV.a(this.hWm.bON() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.biQ != null) {
                    ImageListFragment.this.biQ.bB(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hVY != null && gVar != null) {
                    ImageListFragment.this.hVY.c(gVar);
                    String bPh = ImageListFragment.this.hVY.bPh();
                    ImageListFragment.this.hVY.xP(bPh);
                    ImageListFragment.this.hWZ.setData(ImageListFragment.this.hVY.xR(bPh));
                    ImageListFragment.this.hWY.smoothScrollToPosition(0);
                    ImageListFragment.this.bPn();
                }
                ImageListFragment.this.hWY.bPv();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hXa, e.d.cp_bg_line_b, i);
        al.c(this.dxe, e.d.cp_cont_b, i);
        if (this.hWm.bON() == 1) {
            al.b(this.crF, e.f.icon_topbar_close_n, i);
            this.hWW.setVisibility(8);
        } else {
            al.h(this.hWW, e.d.navi_back_text_color);
            this.crF.setVisibility(8);
        }
        if (this.dxe != null) {
            this.dxe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hWZ != null) {
            this.hWZ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hVY != null) {
            oz(this.hVY.isOriginalImg());
        }
    }

    public View bzd() {
        return this.hWm.bON() == 1 ? this.crF : this.hWW;
    }

    public View bPp() {
        return this.hWt;
    }

    public TbCameraView bOS() {
        if (this.hWZ != null) {
            return this.hWZ.bPl();
        }
        return null;
    }

    public TransparentHeadGridView bPq() {
        return this.hWY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hWX != null) {
            this.hWX.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hWV != null) {
            this.hWV.wr();
        }
        if (this.hWm != null) {
            this.hWm.closeLoadingDialog();
        }
        if (this.biQ != null) {
            this.biQ.bB(false);
        }
        d.bPk().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fWt = true;
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
        if (!isHidden() && !this.fWt) {
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
            this.hWZ.kj(true);
        } else if (this.hWZ.isScroll()) {
            this.hWZ.kj(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hWY != null) {
            int firstVisiblePosition = this.hWY.getFirstVisiblePosition();
            int lastVisiblePosition = this.hWY.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hWY.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hWZ != null) {
                    this.hWZ.d((ImageView) childAt.findViewById(e.g.select_icon), z);
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
        if (imageFileInfo != null && this.hWZ != null) {
            H(this.hWZ.g(imageFileInfo), z);
        }
    }

    public View bOX() {
        return this.hWu;
    }

    public void oz(boolean z) {
        if (this.hWm != null && this.hWu != null) {
            this.hWu.setText(this.hWm.getResources().getString(e.j.original_img));
            if (z) {
                this.hWu.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hWu, e.d.cp_link_tip_a);
                return;
            }
            this.hWu.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hWu, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hWi = iVar;
    }
}
