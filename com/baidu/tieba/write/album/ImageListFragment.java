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
    private ImageView dFN;
    private RelativeLayout eCg;
    private TextView eKf;
    private View ekm;
    private boolean hmn;
    private i jmH;
    private AlbumActivity jmL;
    private View jmR;
    private TextView jmS;
    private TextView jmT;
    private c jmx;
    private com.baidu.tbadk.album.f jnu;
    private TextView jnv;
    private com.baidu.tieba.write.view.a jnw;
    private TransparentHeadGridView jnx;
    private h jny;
    private View jnz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b csM = null;
    private View.OnClickListener jnh = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jmx != null) {
                int maxImagesAllowed = ImageListFragment.this.jmx.getMaxImagesAllowed();
                if (ImageListFragment.this.jmx.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jmL != null) {
                        ImageListFragment.this.jmL.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jmx != null) {
                if (ImageListFragment.this.jmH == null || !ImageListFragment.this.jmH.cpp()) {
                    if (view == ImageListFragment.this.eKf) {
                        ImageListFragment.this.jnw.b(ImageListFragment.this.jmx.cpb(), ImageListFragment.this.jmx.coZ());
                        ImageListFragment.this.jnw.bg(ImageListFragment.this.ekm);
                        ImageListFragment.this.eKf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jmR) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jnk = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cpj() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jnl = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cpk() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.eKf != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.eKf.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jni = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.jmx != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jmx.g((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jmL.Ba(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0415a jnA = new a.InterfaceC0415a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0415a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> Ep;
            if (ImageListFragment.this.jmx != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jmx.coZ()) && (Ep = ImageListFragment.this.jmx.Ep(albumId)) != null) {
                    ImageListFragment.this.jmx.En(albumId);
                    ImageListFragment.this.jny.setData(Ep);
                    ImageListFragment.this.eKf.setText(name);
                    ImageListFragment.this.jnx.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jnj = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jmL == null || ImageListFragment.this.jmx == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jmx.coW()) {
                    ImageListFragment.this.jmL.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jmx.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jmL.e(imageFileInfo);
                } else {
                    ImageListFragment.this.jmL.d(imageFileInfo);
                }
                ImageListFragment.this.jmx.a(null);
                ImageListFragment.this.jny.notifyDataSetChanged();
                ImageListFragment.this.cpf();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jmx.coV()) {
                    ImageListFragment.this.jmL.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jmx.b(videoFileInfo)) {
                        ImageListFragment.this.jmx.a(null);
                    } else {
                        ImageListFragment.this.jmx.a(videoFileInfo);
                    }
                    ImageListFragment.this.jmx.coX();
                    ImageListFragment.this.jny.notifyDataSetChanged();
                    ImageListFragment.this.cpf();
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
        this.jmL = (AlbumActivity) getBaseFragmentActivity();
        this.jmx = this.jmL.coG();
        d.cpc().a(this);
        this.jnu = new com.baidu.tbadk.album.f(this.jmL);
        this.jnw = new com.baidu.tieba.write.view.a(this.jmL);
        this.jnw.setOnDismissListener(this.mOnDismissListener);
        this.jnw.a(this.jnA);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.eCg = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.ekm = this.mView.findViewById(d.g.layout_title);
        this.eKf = (TextView) this.mView.findViewById(d.g.album_title);
        this.dFN = (ImageView) this.mView.findViewById(d.g.img_close);
        this.jnv = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.jnz = this.mView.findViewById(d.g.navi_line);
        this.jmR = this.mView.findViewById(d.g.layout_bottom);
        this.jmT = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.jmS = (TextView) this.mView.findViewById(d.g.next_step);
        this.jmx.En(com.baidu.tbadk.album.a.bsR);
        this.eKf.setText(this.jmL.getPageContext().getString(d.j.album_all_media));
        if (this.jmx.getWriteImagesInfo() != null) {
            this.jmT.setVisibility(this.jmx.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jmL.getPageContext().getPageActivity(), this.eCg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ad(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.jnx = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.jnx.setSelector(d.C0277d.transparent);
        this.jny = new h(this.jmL, this.jmx);
        this.jny.rc(this.jmL.coF() != 1);
        this.jnx.setAdapter((ListAdapter) this.jny);
        this.jnx.setOuterOnScrollListener(this);
        this.jny.a(this.jnj);
        this.jny.a(this.jni);
        this.jny.Y(this.jnh);
        this.jny.setOnOpenCameraFailedListener(this.jnl);
        this.jny.setOnRequestPermissionListener(this.jnk);
        this.jmS.setOnClickListener(this.jmL);
        this.dFN.setOnClickListener(this.jmL);
        this.jnv.setOnClickListener(this.jmL);
        this.jmT.setOnClickListener(this.jmL);
        this.eKf.setOnClickListener(this.mOnClickListener);
        this.jmR.setOnClickListener(this.mOnClickListener);
        cpf();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.csM == null) {
            this.csM = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.csM.e(null);
        this.csM.hF(d.j.loading);
        this.csM.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jmL.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpf() {
        int S;
        String string;
        if (this.jmx != null && this.jmS != null) {
            if (this.jmx.coW()) {
                int i = this.jmx.coW() ? 1 : 0;
                S = i;
                string = this.jmL.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                S = v.S(this.jmx.coY());
                string = this.jmL.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmx.getMaxImagesAllowed())});
            }
            this.jmS.setText(string);
            this.jmS.setEnabled(S > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hmn = false;
        if (isShow()) {
            aBr();
        }
    }

    private void coS() {
        if (this.jmx == null && this.jmL != null) {
            this.jmx = this.jmL.coG();
        }
        if (this.jmx != null) {
            if (!this.jmx.aoF()) {
                this.jny.notifyDataSetChanged();
            } else {
                cpg();
            }
            qZ(this.jmx.isOriginalImg());
        }
    }

    private void cpg() {
        if (this.jnu == null) {
            this.jnu = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jnu.a(this.jmL.coF() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.csM != null) {
                    ImageListFragment.this.csM.dJ(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jmx != null && gVar != null) {
                    ImageListFragment.this.jmx.c(gVar);
                    String coZ = ImageListFragment.this.jmx.coZ();
                    ImageListFragment.this.jmx.En(coZ);
                    ImageListFragment.this.jny.setData(ImageListFragment.this.jmx.Ep(coZ));
                    ImageListFragment.this.jnx.smoothScrollToPosition(0);
                    ImageListFragment.this.cpf();
                }
                ImageListFragment.this.jnx.cpn();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        al.f(this.jnz, d.C0277d.cp_bg_line_b, i);
        al.d(this.eKf, d.C0277d.cp_cont_b, i);
        if (this.jmL.coF() == 1) {
            al.b(this.dFN, d.f.icon_topbar_close_n, i);
            this.jnv.setVisibility(8);
        } else {
            al.j(this.jnv, d.C0277d.navi_back_text_color);
            this.dFN.setVisibility(8);
        }
        if (this.eKf != null) {
            this.eKf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.jny != null) {
            this.jny.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jmx != null) {
            qZ(this.jmx.isOriginalImg());
        }
    }

    public View bZQ() {
        return this.jmL.coF() == 1 ? this.dFN : this.jnv;
    }

    public View cph() {
        return this.jmS;
    }

    public TbCameraView coK() {
        if (this.jny != null) {
            return this.jny.cpd();
        }
        return null;
    }

    public TransparentHeadGridView cpi() {
        return this.jnx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jnw != null) {
            this.jnw.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jnu != null) {
            this.jnu.US();
        }
        if (this.jmL != null) {
            this.jmL.closeLoadingDialog();
        }
        if (this.csM != null) {
            this.csM.dJ(false);
        }
        d.cpc().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hmn = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void rb(boolean z) {
        aBr();
    }

    private void aBr() {
        if (!isHidden() && !this.hmn) {
            coS();
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
            this.jny.mL(true);
        } else if (this.jny.isScroll()) {
            this.jny.mL(false);
        }
    }

    public void N(int i, boolean z) {
        if (this.jnx != null) {
            int firstVisiblePosition = this.jnx.getFirstVisiblePosition();
            int lastVisiblePosition = this.jnx.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jnx.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jny != null) {
                    this.jny.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cpf();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jny != null) {
            N(this.jny.h(imageFileInfo), z);
        }
    }

    public View coP() {
        return this.jmT;
    }

    public void qZ(boolean z) {
        if (this.jmL != null && this.jmT != null) {
            this.jmT.setText(this.jmL.getResources().getString(d.j.original_img));
            if (z) {
                this.jmT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.jmT, d.C0277d.cp_link_tip_a);
                return;
            }
            this.jmT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.jmT, d.C0277d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jmH = iVar;
    }
}
