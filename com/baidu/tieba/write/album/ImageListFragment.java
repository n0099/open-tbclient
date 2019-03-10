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
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private ImageView dGB;
    private RelativeLayout eCz;
    private TextView eKx;
    private View ekE;
    private boolean hmF;
    private c jmR;
    private com.baidu.tbadk.album.f jnO;
    private TextView jnP;
    private com.baidu.tieba.write.view.a jnQ;
    private TransparentHeadGridView jnR;
    private h jnS;
    private View jnT;
    private i jnb;
    private AlbumActivity jnf;
    private View jnl;
    private TextView jnm;
    private TextView jnn;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b csN = null;
    private View.OnClickListener jnB = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jmR != null) {
                int maxImagesAllowed = ImageListFragment.this.jmR.getMaxImagesAllowed();
                if (ImageListFragment.this.jmR.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jnf != null) {
                        ImageListFragment.this.jnf.c(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(d.j.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jmR != null) {
                if (ImageListFragment.this.jnb == null || !ImageListFragment.this.jnb.cpo()) {
                    if (view == ImageListFragment.this.eKx) {
                        ImageListFragment.this.jnQ.b(ImageListFragment.this.jmR.cpa(), ImageListFragment.this.jmR.coY());
                        ImageListFragment.this.jnQ.bg(ImageListFragment.this.ekE);
                        ImageListFragment.this.eKx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jnl) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jnE = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cpi() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jnF = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cpj() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.eKx != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.eKx.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jnC = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.jmR != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jmR.g((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jnf.Be(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0322a jnU = new a.InterfaceC0322a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0322a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> Es;
            if (ImageListFragment.this.jmR != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jmR.coY()) && (Es = ImageListFragment.this.jmR.Es(albumId)) != null) {
                    ImageListFragment.this.jmR.Eq(albumId);
                    ImageListFragment.this.jnS.setData(Es);
                    ImageListFragment.this.eKx.setText(name);
                    ImageListFragment.this.jnR.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jnD = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jnf == null || ImageListFragment.this.jmR == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jmR.coV()) {
                    ImageListFragment.this.jnf.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jmR.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jnf.e(imageFileInfo);
                } else {
                    ImageListFragment.this.jnf.d(imageFileInfo);
                }
                ImageListFragment.this.jmR.a(null);
                ImageListFragment.this.jnS.notifyDataSetChanged();
                ImageListFragment.this.cpe();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jmR.coU()) {
                    ImageListFragment.this.jnf.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jmR.b(videoFileInfo)) {
                        ImageListFragment.this.jmR.a(null);
                    } else {
                        ImageListFragment.this.jmR.a(videoFileInfo);
                    }
                    ImageListFragment.this.jmR.coW();
                    ImageListFragment.this.jnS.notifyDataSetChanged();
                    ImageListFragment.this.cpe();
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
        this.jnf = (AlbumActivity) getBaseFragmentActivity();
        this.jmR = this.jnf.coF();
        d.cpb().a(this);
        this.jnO = new com.baidu.tbadk.album.f(this.jnf);
        this.jnQ = new com.baidu.tieba.write.view.a(this.jnf);
        this.jnQ.setOnDismissListener(this.mOnDismissListener);
        this.jnQ.a(this.jnU);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.eCz = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.ekE = this.mView.findViewById(d.g.layout_title);
        this.eKx = (TextView) this.mView.findViewById(d.g.album_title);
        this.dGB = (ImageView) this.mView.findViewById(d.g.img_close);
        this.jnP = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.jnT = this.mView.findViewById(d.g.navi_line);
        this.jnl = this.mView.findViewById(d.g.layout_bottom);
        this.jnn = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.jnm = (TextView) this.mView.findViewById(d.g.next_step);
        this.jmR.Eq(com.baidu.tbadk.album.a.bsN);
        this.eKx.setText(this.jnf.getPageContext().getString(d.j.album_all_media));
        if (this.jmR.getWriteImagesInfo() != null) {
            this.jnn.setVisibility(this.jmR.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jnf.getPageContext().getPageActivity(), this.eCz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ad(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.jnR = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.jnR.setSelector(d.C0236d.transparent);
        this.jnS = new h(this.jnf, this.jmR);
        this.jnS.rc(this.jnf.coE() != 1);
        this.jnR.setAdapter((ListAdapter) this.jnS);
        this.jnR.setOuterOnScrollListener(this);
        this.jnS.a(this.jnD);
        this.jnS.a(this.jnC);
        this.jnS.Y(this.jnB);
        this.jnS.setOnOpenCameraFailedListener(this.jnF);
        this.jnS.setOnRequestPermissionListener(this.jnE);
        this.jnm.setOnClickListener(this.jnf);
        this.dGB.setOnClickListener(this.jnf);
        this.jnP.setOnClickListener(this.jnf);
        this.jnn.setOnClickListener(this.jnf);
        this.eKx.setOnClickListener(this.mOnClickListener);
        this.jnl.setOnClickListener(this.mOnClickListener);
        cpe();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.csN == null) {
            this.csN = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.csN.e(null);
        this.csN.hG(d.j.loading);
        this.csN.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jnf.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpe() {
        int S;
        String string;
        if (this.jmR != null && this.jnm != null) {
            if (this.jmR.coV()) {
                int i = this.jmR.coV() ? 1 : 0;
                S = i;
                string = this.jnf.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                S = v.S(this.jmR.coX());
                string = this.jnf.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmR.getMaxImagesAllowed())});
            }
            this.jnm.setText(string);
            this.jnm.setEnabled(S > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hmF = false;
        if (isShow()) {
            aBv();
        }
    }

    private void coR() {
        if (this.jmR == null && this.jnf != null) {
            this.jmR = this.jnf.coF();
        }
        if (this.jmR != null) {
            if (!this.jmR.aoJ()) {
                this.jnS.notifyDataSetChanged();
            } else {
                cpf();
            }
            qZ(this.jmR.isOriginalImg());
        }
    }

    private void cpf() {
        if (this.jnO == null) {
            this.jnO = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jnO.a(this.jnf.coE() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.csN != null) {
                    ImageListFragment.this.csN.dJ(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jmR != null && gVar != null) {
                    ImageListFragment.this.jmR.c(gVar);
                    String coY = ImageListFragment.this.jmR.coY();
                    ImageListFragment.this.jmR.Eq(coY);
                    ImageListFragment.this.jnS.setData(ImageListFragment.this.jmR.Es(coY));
                    ImageListFragment.this.jnR.smoothScrollToPosition(0);
                    ImageListFragment.this.cpe();
                }
                ImageListFragment.this.jnR.cpm();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        al.f(this.jnT, d.C0236d.cp_bg_line_b, i);
        al.d(this.eKx, d.C0236d.cp_cont_b, i);
        if (this.jnf.coE() == 1) {
            al.b(this.dGB, d.f.icon_topbar_close_n, i);
            this.jnP.setVisibility(8);
        } else {
            al.j(this.jnP, d.C0236d.navi_back_text_color);
            this.dGB.setVisibility(8);
        }
        if (this.eKx != null) {
            this.eKx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.jnS != null) {
            this.jnS.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jmR != null) {
            qZ(this.jmR.isOriginalImg());
        }
    }

    public View bZS() {
        return this.jnf.coE() == 1 ? this.dGB : this.jnP;
    }

    public View cpg() {
        return this.jnm;
    }

    public TbCameraView coJ() {
        if (this.jnS != null) {
            return this.jnS.cpc();
        }
        return null;
    }

    public TransparentHeadGridView cph() {
        return this.jnR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jnQ != null) {
            this.jnQ.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jnO != null) {
            this.jnO.UV();
        }
        if (this.jnf != null) {
            this.jnf.closeLoadingDialog();
        }
        if (this.csN != null) {
            this.csN.dJ(false);
        }
        d.cpb().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hmF = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void rb(boolean z) {
        aBv();
    }

    private void aBv() {
        if (!isHidden() && !this.hmF) {
            coR();
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
            this.jnS.mL(true);
        } else if (this.jnS.isScroll()) {
            this.jnS.mL(false);
        }
    }

    public void N(int i, boolean z) {
        if (this.jnR != null) {
            int firstVisiblePosition = this.jnR.getFirstVisiblePosition();
            int lastVisiblePosition = this.jnR.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jnR.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jnS != null) {
                    this.jnS.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cpe();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jnS != null) {
            N(this.jnS.h(imageFileInfo), z);
        }
    }

    public View coO() {
        return this.jnn;
    }

    public void qZ(boolean z) {
        if (this.jnf != null && this.jnn != null) {
            this.jnn.setText(this.jnf.getResources().getString(d.j.original_img));
            if (z) {
                this.jnn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.jnn, d.C0236d.cp_link_tip_a);
                return;
            }
            this.jnn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.jnn, d.C0236d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jnb = iVar;
    }
}
