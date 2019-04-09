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
    private ImageView dFO;
    private RelativeLayout eCh;
    private TextView eKg;
    private View ekn;
    private boolean hmo;
    private i jmI;
    private AlbumActivity jmM;
    private View jmS;
    private TextView jmT;
    private TextView jmU;
    private c jmy;
    private View jnA;
    private com.baidu.tbadk.album.f jnv;
    private TextView jnw;
    private com.baidu.tieba.write.view.a jnx;
    private TransparentHeadGridView jny;
    private h jnz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b csN = null;
    private View.OnClickListener jni = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jmy != null) {
                int maxImagesAllowed = ImageListFragment.this.jmy.getMaxImagesAllowed();
                if (ImageListFragment.this.jmy.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jmM != null) {
                        ImageListFragment.this.jmM.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jmy != null) {
                if (ImageListFragment.this.jmI == null || !ImageListFragment.this.jmI.cpp()) {
                    if (view == ImageListFragment.this.eKg) {
                        ImageListFragment.this.jnx.b(ImageListFragment.this.jmy.cpb(), ImageListFragment.this.jmy.coZ());
                        ImageListFragment.this.jnx.bg(ImageListFragment.this.ekn);
                        ImageListFragment.this.eKg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jmS) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jnl = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cpj() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jnm = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cpk() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.eKg != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.eKg.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jnj = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.jmy != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jmy.g((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jmM.Ba(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0415a jnB = new a.InterfaceC0415a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0415a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> Ep;
            if (ImageListFragment.this.jmy != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jmy.coZ()) && (Ep = ImageListFragment.this.jmy.Ep(albumId)) != null) {
                    ImageListFragment.this.jmy.En(albumId);
                    ImageListFragment.this.jnz.setData(Ep);
                    ImageListFragment.this.eKg.setText(name);
                    ImageListFragment.this.jny.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jnk = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jmM == null || ImageListFragment.this.jmy == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jmy.coW()) {
                    ImageListFragment.this.jmM.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jmy.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jmM.e(imageFileInfo);
                } else {
                    ImageListFragment.this.jmM.d(imageFileInfo);
                }
                ImageListFragment.this.jmy.a(null);
                ImageListFragment.this.jnz.notifyDataSetChanged();
                ImageListFragment.this.cpf();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jmy.coV()) {
                    ImageListFragment.this.jmM.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jmy.b(videoFileInfo)) {
                        ImageListFragment.this.jmy.a(null);
                    } else {
                        ImageListFragment.this.jmy.a(videoFileInfo);
                    }
                    ImageListFragment.this.jmy.coX();
                    ImageListFragment.this.jnz.notifyDataSetChanged();
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
        this.jmM = (AlbumActivity) getBaseFragmentActivity();
        this.jmy = this.jmM.coG();
        d.cpc().a(this);
        this.jnv = new com.baidu.tbadk.album.f(this.jmM);
        this.jnx = new com.baidu.tieba.write.view.a(this.jmM);
        this.jnx.setOnDismissListener(this.mOnDismissListener);
        this.jnx.a(this.jnB);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.eCh = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.ekn = this.mView.findViewById(d.g.layout_title);
        this.eKg = (TextView) this.mView.findViewById(d.g.album_title);
        this.dFO = (ImageView) this.mView.findViewById(d.g.img_close);
        this.jnw = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.jnA = this.mView.findViewById(d.g.navi_line);
        this.jmS = this.mView.findViewById(d.g.layout_bottom);
        this.jmU = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.jmT = (TextView) this.mView.findViewById(d.g.next_step);
        this.jmy.En(com.baidu.tbadk.album.a.bsS);
        this.eKg.setText(this.jmM.getPageContext().getString(d.j.album_all_media));
        if (this.jmy.getWriteImagesInfo() != null) {
            this.jmU.setVisibility(this.jmy.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jmM.getPageContext().getPageActivity(), this.eCh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ad(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.jny = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.jny.setSelector(d.C0277d.transparent);
        this.jnz = new h(this.jmM, this.jmy);
        this.jnz.rc(this.jmM.coF() != 1);
        this.jny.setAdapter((ListAdapter) this.jnz);
        this.jny.setOuterOnScrollListener(this);
        this.jnz.a(this.jnk);
        this.jnz.a(this.jnj);
        this.jnz.Y(this.jni);
        this.jnz.setOnOpenCameraFailedListener(this.jnm);
        this.jnz.setOnRequestPermissionListener(this.jnl);
        this.jmT.setOnClickListener(this.jmM);
        this.dFO.setOnClickListener(this.jmM);
        this.jnw.setOnClickListener(this.jmM);
        this.jmU.setOnClickListener(this.jmM);
        this.eKg.setOnClickListener(this.mOnClickListener);
        this.jmS.setOnClickListener(this.mOnClickListener);
        cpf();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.csN == null) {
            this.csN = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.csN.e(null);
        this.csN.hF(d.j.loading);
        this.csN.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jmM.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpf() {
        int S;
        String string;
        if (this.jmy != null && this.jmT != null) {
            if (this.jmy.coW()) {
                int i = this.jmy.coW() ? 1 : 0;
                S = i;
                string = this.jmM.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                S = v.S(this.jmy.coY());
                string = this.jmM.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmy.getMaxImagesAllowed())});
            }
            this.jmT.setText(string);
            this.jmT.setEnabled(S > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hmo = false;
        if (isShow()) {
            aBr();
        }
    }

    private void coS() {
        if (this.jmy == null && this.jmM != null) {
            this.jmy = this.jmM.coG();
        }
        if (this.jmy != null) {
            if (!this.jmy.aoF()) {
                this.jnz.notifyDataSetChanged();
            } else {
                cpg();
            }
            qZ(this.jmy.isOriginalImg());
        }
    }

    private void cpg() {
        if (this.jnv == null) {
            this.jnv = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jnv.a(this.jmM.coF() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.jmy != null && gVar != null) {
                    ImageListFragment.this.jmy.c(gVar);
                    String coZ = ImageListFragment.this.jmy.coZ();
                    ImageListFragment.this.jmy.En(coZ);
                    ImageListFragment.this.jnz.setData(ImageListFragment.this.jmy.Ep(coZ));
                    ImageListFragment.this.jny.smoothScrollToPosition(0);
                    ImageListFragment.this.cpf();
                }
                ImageListFragment.this.jny.cpn();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        al.f(this.jnA, d.C0277d.cp_bg_line_b, i);
        al.d(this.eKg, d.C0277d.cp_cont_b, i);
        if (this.jmM.coF() == 1) {
            al.b(this.dFO, d.f.icon_topbar_close_n, i);
            this.jnw.setVisibility(8);
        } else {
            al.j(this.jnw, d.C0277d.navi_back_text_color);
            this.dFO.setVisibility(8);
        }
        if (this.eKg != null) {
            this.eKg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.jnz != null) {
            this.jnz.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jmy != null) {
            qZ(this.jmy.isOriginalImg());
        }
    }

    public View bZQ() {
        return this.jmM.coF() == 1 ? this.dFO : this.jnw;
    }

    public View cph() {
        return this.jmT;
    }

    public TbCameraView coK() {
        if (this.jnz != null) {
            return this.jnz.cpd();
        }
        return null;
    }

    public TransparentHeadGridView cpi() {
        return this.jny;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jnx != null) {
            this.jnx.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jnv != null) {
            this.jnv.US();
        }
        if (this.jmM != null) {
            this.jmM.closeLoadingDialog();
        }
        if (this.csN != null) {
            this.csN.dJ(false);
        }
        d.cpc().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hmo = true;
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
        if (!isHidden() && !this.hmo) {
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
            this.jnz.mL(true);
        } else if (this.jnz.isScroll()) {
            this.jnz.mL(false);
        }
    }

    public void N(int i, boolean z) {
        if (this.jny != null) {
            int firstVisiblePosition = this.jny.getFirstVisiblePosition();
            int lastVisiblePosition = this.jny.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jny.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jnz != null) {
                    this.jnz.d((ImageView) childAt.findViewById(d.g.select_icon), z);
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
        if (imageFileInfo != null && this.jnz != null) {
            N(this.jnz.h(imageFileInfo), z);
        }
    }

    public View coP() {
        return this.jmU;
    }

    public void qZ(boolean z) {
        if (this.jmM != null && this.jmU != null) {
            this.jmU.setText(this.jmM.getResources().getString(d.j.original_img));
            if (z) {
                this.jmU.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.jmU, d.C0277d.cp_link_tip_a);
                return;
            }
            this.jmU.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.jmU, d.C0277d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jmI = iVar;
    }
}
