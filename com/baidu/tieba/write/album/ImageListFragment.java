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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
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
    private RelativeLayout cIJ;
    private View csp;
    private boolean ffA;
    private AlbumActivity hcB;
    private View hcH;
    private TextView hcI;
    private TextView hcJ;
    private c hco;
    private i hcx;
    private com.baidu.tbadk.album.f hdk;
    private ImageView hdl;
    private TextView hdm;
    private com.baidu.tieba.write.view.a hdn;
    private TransparentHeadGridView hdo;
    private h hdp;
    private View hdq;
    private NoDataView mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.a aNd = null;
    private View.OnClickListener hcX = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ImageListFragment.this.hco != null) {
                int maxImagesAllowed = ImageListFragment.this.hco.getMaxImagesAllowed();
                if (ImageListFragment.this.hco.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hcB != null) {
                        ImageListFragment.this.hcB.b(ImageListFragment.this.getPageContext());
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
        public void onClick(View view2) {
            if (ImageListFragment.this.hco != null) {
                if (ImageListFragment.this.hcx == null || !ImageListFragment.this.hcx.bBW()) {
                    if (view2 == ImageListFragment.this.mTitleText) {
                        ImageListFragment.this.hdn.f(ImageListFragment.this.hco.bBI(), ImageListFragment.this.hco.bBG());
                        ImageListFragment.this.hdn.ap(ImageListFragment.this.csp);
                        ImageListFragment.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view2 == ImageListFragment.this.hcH) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hda = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bBQ() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hdb = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bBR() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.mTitleText != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = ak.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hcY = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hco != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hco.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hcB.uN(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0240a hdr = new a.InterfaceC0240a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0240a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> uL;
            if (ImageListFragment.this.hco != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hco.bBG()) && (uL = ImageListFragment.this.hco.uL(albumId)) != null) {
                    ImageListFragment.this.hco.uJ(albumId);
                    ImageListFragment.this.hdp.setData(uL);
                    ImageListFragment.this.mTitleText.setText(name);
                    ImageListFragment.this.hdo.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hcZ = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hcB == null || ImageListFragment.this.hco == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hco.bBD()) {
                    ImageListFragment.this.hcB.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hco.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hcB.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hcB.c(imageFileInfo);
                }
                ImageListFragment.this.hco.a(null);
                ImageListFragment.this.hdp.notifyDataSetChanged();
                ImageListFragment.this.bBM();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hco.bBC()) {
                    ImageListFragment.this.hcB.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hco.b(videoFileInfo)) {
                        ImageListFragment.this.hco.a(null);
                    } else {
                        ImageListFragment.this.hco.a(videoFileInfo);
                    }
                    ImageListFragment.this.hco.bBE();
                    ImageListFragment.this.hdp.notifyDataSetChanged();
                    ImageListFragment.this.bBM();
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
        this.hcB = (AlbumActivity) getBaseFragmentActivity();
        this.hco = this.hcB.bBn();
        d.bBJ().a(this);
        this.hdk = new com.baidu.tbadk.album.f(this.hcB);
        this.hdn = new com.baidu.tieba.write.view.a(this.hcB);
        this.hdn.setOnDismissListener(this.mOnDismissListener);
        this.hdn.a(this.hdr);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.i.album_image_list_view, (ViewGroup) null);
        this.cIJ = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.csp = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hdl = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hdm = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hdq = this.mView.findViewById(d.g.navi_line);
        this.hcH = this.mView.findViewById(d.g.layout_bottom);
        this.hcJ = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hcI = (TextView) this.mView.findViewById(d.g.next_step);
        this.hco.uJ(com.baidu.tbadk.album.a.Sf);
        this.mTitleText.setText(this.hcB.getPageContext().getString(d.k.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hcB.getPageContext().getPageActivity(), this.cIJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(d.k.album_list_no_data, d.k.album_list_no_data_1), null);
        this.hdo = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hdo.setSelector(d.C0126d.transparent);
        this.hdp = new h(this.hcB, this.hco);
        this.hdp.nr(this.hcB.bBm() != 1);
        this.hdo.setAdapter((ListAdapter) this.hdp);
        this.hdo.setOuterOnScrollListener(this);
        this.hdp.a(this.hcZ);
        this.hdp.a(this.hcY);
        this.hdp.V(this.hcX);
        this.hdp.setOnOpenCameraFailedListener(this.hdb);
        this.hdp.setOnRequestPermissionListener(this.hda);
        this.hcI.setOnClickListener(this.hcB);
        this.hdl.setOnClickListener(this.hcB);
        this.hdm.setOnClickListener(this.hcB);
        this.hcJ.setOnClickListener(this.hcB);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hcH.setOnClickListener(this.mOnClickListener);
        bBM();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aNd == null) {
            this.aNd = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.aNd.d(null);
        this.aNd.da(d.k.loading);
        this.aNd.aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hcB.showToast(d.k.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBM() {
        int v;
        String string;
        if (this.hco != null && this.hcI != null) {
            if (this.hco.bBD()) {
                int i = this.hco.bBD() ? 1 : 0;
                v = i;
                string = this.hcB.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                v = v.v(this.hco.bBF());
                string = this.hcB.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hco.getMaxImagesAllowed())});
            }
            this.hcI.setText(string);
            this.hcI.setEnabled(v > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ffA = false;
        if (isShow()) {
            PM();
        }
    }

    private void bBz() {
        if (this.hco == null && this.hcB != null) {
            this.hco = this.hcB.bBn();
        }
        if (this.hco != null) {
            if (!this.hco.Gk()) {
                this.hdp.notifyDataSetChanged();
            } else {
                bBN();
            }
            no(this.hco.isOriginalImg());
        }
    }

    private void bBN() {
        if (this.hdk == null) {
            this.hdk = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hdk.a(this.hcB.bBm() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.aNd != null) {
                    ImageListFragment.this.aNd.aI(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hco != null && gVar != null) {
                    ImageListFragment.this.hco.c(gVar);
                    String bBG = ImageListFragment.this.hco.bBG();
                    ImageListFragment.this.hco.uJ(bBG);
                    ImageListFragment.this.hdp.setData(ImageListFragment.this.hco.uL(bBG));
                    ImageListFragment.this.hdo.smoothScrollToPosition(0);
                    ImageListFragment.this.bBM();
                }
                ImageListFragment.this.hdo.bBU();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        ak.e(this.hdq, d.C0126d.cp_bg_line_b, i);
        ak.c(this.mTitleText, d.C0126d.cp_cont_b, i);
        if (this.hcB.bBm() == 1) {
            ak.b(this.hdl, d.f.icon_topbar_close_n, i);
            this.hdm.setVisibility(8);
        } else {
            ak.h(this.hdm, d.C0126d.navi_back_text_color);
            this.hdl.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hdp != null) {
            this.hdp.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hco != null) {
            no(this.hco.isOriginalImg());
        }
    }

    public View bmu() {
        return this.hcB.bBm() == 1 ? this.hdl : this.hdm;
    }

    public View bBO() {
        return this.hcI;
    }

    public TbCameraView bBr() {
        if (this.hdp != null) {
            return this.hdp.bBK();
        }
        return null;
    }

    public TransparentHeadGridView bBP() {
        return this.hdo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hdn != null) {
            this.hdn.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hdk != null) {
            this.hdk.oB();
        }
        if (this.hcB != null) {
            this.hcB.closeLoadingDialog();
        }
        if (this.aNd != null) {
            this.aNd.aI(false);
        }
        d.bBJ().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ffA = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void nq(boolean z) {
        PM();
    }

    private void PM() {
        if (!isHidden() && !this.ffA) {
            bBz();
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
            this.hdp.jd(true);
        } else if (this.hdp.isScroll()) {
            this.hdp.jd(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hdo != null) {
            int firstVisiblePosition = this.hdo.getFirstVisiblePosition();
            int lastVisiblePosition = this.hdo.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hdo.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hdp != null) {
                    this.hdp.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bBM();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hdp != null) {
            H(this.hdp.g(imageFileInfo), z);
        }
    }

    public View bBw() {
        return this.hcJ;
    }

    public void no(boolean z) {
        if (this.hcB != null && this.hcJ != null) {
            this.hcJ.setText(this.hcB.getResources().getString(d.k.original_img));
            if (z) {
                this.hcJ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.hcJ, d.C0126d.cp_link_tip_a);
                return;
            }
            this.hcJ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.hcJ, d.C0126d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hcx = iVar;
    }
}
