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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View cAS;
    private RelativeLayout cRQ;
    private boolean fqX;
    private View hoC;
    private TextView hoD;
    private TextView hoE;
    private c hoj;
    private i hos;
    private AlbumActivity how;
    private com.baidu.tbadk.album.f hpf;
    private ImageView hpg;
    private TextView hph;
    private com.baidu.tieba.write.view.a hpi;
    private TransparentHeadGridView hpj;
    private h hpk;
    private View hpl;
    private NoDataView mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.a aVb = null;
    private View.OnClickListener hoS = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hoj != null) {
                int maxImagesAllowed = ImageListFragment.this.hoj.getMaxImagesAllowed();
                if (ImageListFragment.this.hoj.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.how != null) {
                        ImageListFragment.this.how.b(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hoj != null) {
                if (ImageListFragment.this.hos == null || !ImageListFragment.this.hos.bHc()) {
                    if (view == ImageListFragment.this.mTitleText) {
                        ImageListFragment.this.hpi.f(ImageListFragment.this.hoj.bGO(), ImageListFragment.this.hoj.bGM());
                        ImageListFragment.this.hpi.ap(ImageListFragment.this.cAS);
                        ImageListFragment.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hoC) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hoV = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bGW() {
            return !ac.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hoW = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bGX() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.mTitleText != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hoT = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hoj != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hoj.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.how.vf(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0257a hpm = new a.InterfaceC0257a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0257a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> vF;
            if (ImageListFragment.this.hoj != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hoj.bGM()) && (vF = ImageListFragment.this.hoj.vF(albumId)) != null) {
                    ImageListFragment.this.hoj.vD(albumId);
                    ImageListFragment.this.hpk.setData(vF);
                    ImageListFragment.this.mTitleText.setText(name);
                    ImageListFragment.this.hpj.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hoU = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.how == null || ImageListFragment.this.hoj == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hoj.bGJ()) {
                    ImageListFragment.this.how.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hoj.isAdded(imageFileInfo)) {
                    ImageListFragment.this.how.d(imageFileInfo);
                } else {
                    ImageListFragment.this.how.c(imageFileInfo);
                }
                ImageListFragment.this.hoj.a(null);
                ImageListFragment.this.hpk.notifyDataSetChanged();
                ImageListFragment.this.bGS();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hoj.bGI()) {
                    ImageListFragment.this.how.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hoj.b(videoFileInfo)) {
                        ImageListFragment.this.hoj.a(null);
                    } else {
                        ImageListFragment.this.hoj.a(videoFileInfo);
                    }
                    ImageListFragment.this.hoj.bGK();
                    ImageListFragment.this.hpk.notifyDataSetChanged();
                    ImageListFragment.this.bGS();
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
        this.how = (AlbumActivity) getBaseFragmentActivity();
        this.hoj = this.how.bGt();
        d.bGP().a(this);
        this.hpf = new com.baidu.tbadk.album.f(this.how);
        this.hpi = new com.baidu.tieba.write.view.a(this.how);
        this.hpi.setOnDismissListener(this.mOnDismissListener);
        this.hpi.a(this.hpm);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.i.album_image_list_view, (ViewGroup) null);
        this.cRQ = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cAS = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hpg = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hph = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hpl = this.mView.findViewById(d.g.navi_line);
        this.hoC = this.mView.findViewById(d.g.layout_bottom);
        this.hoE = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hoD = (TextView) this.mView.findViewById(d.g.next_step);
        this.hoj.vD(com.baidu.tbadk.album.a.aap);
        this.mTitleText.setText(this.how.getPageContext().getString(d.k.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.how.getPageContext().getPageActivity(), this.cRQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.k.album_list_no_data, d.k.album_list_no_data_1), null);
        this.hpj = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hpj.setSelector(d.C0141d.transparent);
        this.hpk = new h(this.how, this.hoj);
        this.hpk.nz(this.how.bGs() != 1);
        this.hpj.setAdapter((ListAdapter) this.hpk);
        this.hpj.setOuterOnScrollListener(this);
        this.hpk.a(this.hoU);
        this.hpk.a(this.hoT);
        this.hpk.V(this.hoS);
        this.hpk.setOnOpenCameraFailedListener(this.hoW);
        this.hpk.setOnRequestPermissionListener(this.hoV);
        this.hoD.setOnClickListener(this.how);
        this.hpg.setOnClickListener(this.how);
        this.hph.setOnClickListener(this.how);
        this.hoE.setOnClickListener(this.how);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hoC.setOnClickListener(this.mOnClickListener);
        bGS();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aVb == null) {
            this.aVb = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.aVb.d(null);
        this.aVb.dc(d.k.loading);
        this.aVb.aM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.how.showToast(d.k.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        int y;
        String string;
        if (this.hoj != null && this.hoD != null) {
            if (this.hoj.bGJ()) {
                int i = this.hoj.bGJ() ? 1 : 0;
                y = i;
                string = this.how.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                y = w.y(this.hoj.bGL());
                string = this.how.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.hoj.getMaxImagesAllowed())});
            }
            this.hoD.setText(string);
            this.hoD.setEnabled(y > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fqX = false;
        if (isShow()) {
            Tk();
        }
    }

    private void bGF() {
        if (this.hoj == null && this.how != null) {
            this.hoj = this.how.bGt();
        }
        if (this.hoj != null) {
            if (!this.hoj.JS()) {
                this.hpk.notifyDataSetChanged();
            } else {
                bGT();
            }
            nw(this.hoj.isOriginalImg());
        }
    }

    private void bGT() {
        if (this.hpf == null) {
            this.hpf = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hpf.a(this.how.bGs() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.aVb != null) {
                    ImageListFragment.this.aVb.aM(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hoj != null && gVar != null) {
                    ImageListFragment.this.hoj.c(gVar);
                    String bGM = ImageListFragment.this.hoj.bGM();
                    ImageListFragment.this.hoj.vD(bGM);
                    ImageListFragment.this.hpk.setData(ImageListFragment.this.hoj.vF(bGM));
                    ImageListFragment.this.hpj.smoothScrollToPosition(0);
                    ImageListFragment.this.bGS();
                }
                ImageListFragment.this.hpj.bHa();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        al.e(this.hpl, d.C0141d.cp_bg_line_b, i);
        al.c(this.mTitleText, d.C0141d.cp_cont_b, i);
        if (this.how.bGs() == 1) {
            al.b(this.hpg, d.f.icon_topbar_close_n, i);
            this.hph.setVisibility(8);
        } else {
            al.h(this.hph, d.C0141d.navi_back_text_color);
            this.hpg.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hpk != null) {
            this.hpk.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hoj != null) {
            nw(this.hoj.isOriginalImg());
        }
    }

    public View brt() {
        return this.how.bGs() == 1 ? this.hpg : this.hph;
    }

    public View bGU() {
        return this.hoD;
    }

    public TbCameraView bGx() {
        if (this.hpk != null) {
            return this.hpk.bGQ();
        }
        return null;
    }

    public TransparentHeadGridView bGV() {
        return this.hpj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hpi != null) {
            this.hpi.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hpf != null) {
            this.hpf.rW();
        }
        if (this.how != null) {
            this.how.closeLoadingDialog();
        }
        if (this.aVb != null) {
            this.aVb.aM(false);
        }
        d.bGP().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fqX = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void ny(boolean z) {
        Tk();
    }

    private void Tk() {
        if (!isHidden() && !this.fqX) {
            bGF();
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
            this.hpk.jj(true);
        } else if (this.hpk.isScroll()) {
            this.hpk.jj(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hpj != null) {
            int firstVisiblePosition = this.hpj.getFirstVisiblePosition();
            int lastVisiblePosition = this.hpj.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hpj.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hpk != null) {
                    this.hpk.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bGS();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hpk != null) {
            H(this.hpk.g(imageFileInfo), z);
        }
    }

    public View bGC() {
        return this.hoE;
    }

    public void nw(boolean z) {
        if (this.how != null && this.hoE != null) {
            this.hoE.setText(this.how.getResources().getString(d.k.original_img));
            if (z) {
                this.hoE.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hoE, d.C0141d.cp_link_tip_a);
                return;
            }
            this.hoE.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hoE, d.C0141d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hos = iVar;
    }
}
