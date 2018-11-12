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
    private View cQG;
    private ImageView cmu;
    private RelativeLayout dhJ;
    private TextView dne;
    private boolean fLN;
    private i hKE;
    private AlbumActivity hKI;
    private View hKO;
    private TextView hKP;
    private TextView hKQ;
    private c hKu;
    private com.baidu.tbadk.album.f hLr;
    private TextView hLs;
    private com.baidu.tieba.write.view.a hLt;
    private TransparentHeadGridView hLu;
    private h hLv;
    private View hLw;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d beC = null;
    private View.OnClickListener hLe = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hKu != null) {
                int maxImagesAllowed = ImageListFragment.this.hKu.getMaxImagesAllowed();
                if (ImageListFragment.this.hKu.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hKI != null) {
                        ImageListFragment.this.hKI.b(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.hKu != null) {
                if (ImageListFragment.this.hKE == null || !ImageListFragment.this.hKE.bLT()) {
                    if (view == ImageListFragment.this.dne) {
                        ImageListFragment.this.hLt.setData(ImageListFragment.this.hKu.bLF(), ImageListFragment.this.hKu.bLD());
                        ImageListFragment.this.hLt.aK(ImageListFragment.this.cQG);
                        ImageListFragment.this.dne.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hKO) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hLh = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bLN() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hLi = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bLO() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.dne != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(e.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.dne.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hLf = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hKu != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hKu.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hKI.wD(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0328a hLx = new a.InterfaceC0328a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0328a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> wV;
            if (ImageListFragment.this.hKu != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hKu.bLD()) && (wV = ImageListFragment.this.hKu.wV(albumId)) != null) {
                    ImageListFragment.this.hKu.wT(albumId);
                    ImageListFragment.this.hLv.setData(wV);
                    ImageListFragment.this.dne.setText(name);
                    ImageListFragment.this.hLu.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hLg = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hKI == null || ImageListFragment.this.hKu == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hKu.bLA()) {
                    ImageListFragment.this.hKI.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hKu.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hKI.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hKI.c(imageFileInfo);
                }
                ImageListFragment.this.hKu.a(null);
                ImageListFragment.this.hLv.notifyDataSetChanged();
                ImageListFragment.this.bLJ();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hKu.bLz()) {
                    ImageListFragment.this.hKI.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hKu.b(videoFileInfo)) {
                        ImageListFragment.this.hKu.a(null);
                    } else {
                        ImageListFragment.this.hKu.a(videoFileInfo);
                    }
                    ImageListFragment.this.hKu.bLB();
                    ImageListFragment.this.hLv.notifyDataSetChanged();
                    ImageListFragment.this.bLJ();
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
        this.hKI = (AlbumActivity) getBaseFragmentActivity();
        this.hKu = this.hKI.bLk();
        d.bLG().a(this);
        this.hLr = new com.baidu.tbadk.album.f(this.hKI);
        this.hLt = new com.baidu.tieba.write.view.a(this.hKI);
        this.hLt.setOnDismissListener(this.mOnDismissListener);
        this.hLt.a(this.hLx);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.dhJ = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.cQG = this.mView.findViewById(e.g.layout_title);
        this.dne = (TextView) this.mView.findViewById(e.g.album_title);
        this.cmu = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hLs = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hLw = this.mView.findViewById(e.g.navi_line);
        this.hKO = this.mView.findViewById(e.g.layout_bottom);
        this.hKQ = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hKP = (TextView) this.mView.findViewById(e.g.next_step);
        this.hKu.wT(com.baidu.tbadk.album.a.ail);
        this.dne.setText(this.hKI.getPageContext().getString(e.j.album_all_media));
        if (this.hKu.getWriteImagesInfo() != null) {
            this.hKQ.setVisibility(this.hKu.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hKI.getPageContext().getPageActivity(), this.dhJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.G(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hLu = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hLu.setSelector(e.d.transparent);
        this.hLv = new h(this.hKI, this.hKu);
        this.hLv.ow(this.hKI.bLj() != 1);
        this.hLu.setAdapter((ListAdapter) this.hLv);
        this.hLu.setOuterOnScrollListener(this);
        this.hLv.a(this.hLg);
        this.hLv.a(this.hLf);
        this.hLv.Y(this.hLe);
        this.hLv.setOnOpenCameraFailedListener(this.hLi);
        this.hLv.setOnRequestPermissionListener(this.hLh);
        this.hKP.setOnClickListener(this.hKI);
        this.cmu.setOnClickListener(this.hKI);
        this.hLs.setOnClickListener(this.hKI);
        this.hKQ.setOnClickListener(this.hKI);
        this.dne.setOnClickListener(this.mOnClickListener);
        this.hKO.setOnClickListener(this.mOnClickListener);
        bLJ();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.beC == null) {
            this.beC = new com.baidu.tbadk.core.view.d(getPageContext());
        }
        this.beC.d(null);
        this.beC.dO(e.j.loading);
        this.beC.bz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hKI.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLJ() {
        int H;
        String string;
        if (this.hKu != null && this.hKP != null) {
            if (this.hKu.bLA()) {
                int i = this.hKu.bLA() ? 1 : 0;
                H = i;
                string = this.hKI.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                H = v.H(this.hKu.bLC());
                string = this.hKI.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hKu.getMaxImagesAllowed())});
            }
            this.hKP.setText(string);
            this.hKP.setEnabled(H > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fLN = false;
        if (isShow()) {
            Zu();
        }
    }

    private void bLw() {
        if (this.hKu == null && this.hKI != null) {
            this.hKu = this.hKI.bLk();
        }
        if (this.hKu != null) {
            if (!this.hKu.NG()) {
                this.hLv.notifyDataSetChanged();
            } else {
                bLK();
            }
            ot(this.hKu.isOriginalImg());
        }
    }

    private void bLK() {
        if (this.hLr == null) {
            this.hLr = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hLr.a(this.hKI.bLj() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.beC != null) {
                    ImageListFragment.this.beC.bz(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hKu != null && gVar != null) {
                    ImageListFragment.this.hKu.c(gVar);
                    String bLD = ImageListFragment.this.hKu.bLD();
                    ImageListFragment.this.hKu.wT(bLD);
                    ImageListFragment.this.hLv.setData(ImageListFragment.this.hKu.wV(bLD));
                    ImageListFragment.this.hLu.smoothScrollToPosition(0);
                    ImageListFragment.this.bLJ();
                }
                ImageListFragment.this.hLu.bLR();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hLw, e.d.cp_bg_line_b, i);
        al.c(this.dne, e.d.cp_cont_b, i);
        if (this.hKI.bLj() == 1) {
            al.b(this.cmu, e.f.icon_topbar_close_n, i);
            this.hLs.setVisibility(8);
        } else {
            al.h(this.hLs, e.d.navi_back_text_color);
            this.cmu.setVisibility(8);
        }
        if (this.dne != null) {
            this.dne.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hLv != null) {
            this.hLv.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hKu != null) {
            ot(this.hKu.isOriginalImg());
        }
    }

    public View bvM() {
        return this.hKI.bLj() == 1 ? this.cmu : this.hLs;
    }

    public View bLL() {
        return this.hKP;
    }

    public TbCameraView bLo() {
        if (this.hLv != null) {
            return this.hLv.bLH();
        }
        return null;
    }

    public TransparentHeadGridView bLM() {
        return this.hLu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hLt != null) {
            this.hLt.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hLr != null) {
            this.hLr.vg();
        }
        if (this.hKI != null) {
            this.hKI.closeLoadingDialog();
        }
        if (this.beC != null) {
            this.beC.bz(false);
        }
        d.bLG().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fLN = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void ov(boolean z) {
        Zu();
    }

    private void Zu() {
        if (!isHidden() && !this.fLN) {
            bLw();
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
            this.hLv.kd(true);
        } else if (this.hLv.isScroll()) {
            this.hLv.kd(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hLu != null) {
            int firstVisiblePosition = this.hLu.getFirstVisiblePosition();
            int lastVisiblePosition = this.hLu.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hLu.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hLv != null) {
                    this.hLv.d((ImageView) childAt.findViewById(e.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bLJ();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hLv != null) {
            H(this.hLv.g(imageFileInfo), z);
        }
    }

    public View bLt() {
        return this.hKQ;
    }

    public void ot(boolean z) {
        if (this.hKI != null && this.hKQ != null) {
            this.hKQ.setText(this.hKI.getResources().getString(e.j.original_img));
            if (z) {
                this.hKQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hKQ, e.d.cp_link_tip_a);
                return;
            }
            this.hKQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hKQ, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hKE = iVar;
    }
}
