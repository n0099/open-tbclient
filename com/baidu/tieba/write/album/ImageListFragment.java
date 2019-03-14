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
    private ImageView dGx;
    private RelativeLayout eCv;
    private TextView eKt;
    private View ekA;
    private boolean hmA;
    private c jmJ;
    private i jmT;
    private AlbumActivity jmX;
    private com.baidu.tbadk.album.f jnG;
    private TextView jnH;
    private com.baidu.tieba.write.view.a jnI;
    private TransparentHeadGridView jnJ;
    private h jnK;
    private View jnL;
    private View jnd;
    private TextView jne;
    private TextView jnf;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b csK = null;
    private View.OnClickListener jnt = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jmJ != null) {
                int maxImagesAllowed = ImageListFragment.this.jmJ.getMaxImagesAllowed();
                if (ImageListFragment.this.jmJ.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jmX != null) {
                        ImageListFragment.this.jmX.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jmJ != null) {
                if (ImageListFragment.this.jmT == null || !ImageListFragment.this.jmT.cpr()) {
                    if (view == ImageListFragment.this.eKt) {
                        ImageListFragment.this.jnI.b(ImageListFragment.this.jmJ.cpd(), ImageListFragment.this.jmJ.cpb());
                        ImageListFragment.this.jnI.bg(ImageListFragment.this.ekA);
                        ImageListFragment.this.eKt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jnd) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jnw = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean cpl() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jnx = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cpm() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.eKt != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.eKt.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jnu = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.jmJ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jmJ.g((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jmX.Be(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0415a jnM = new a.InterfaceC0415a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0415a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> Eq;
            if (ImageListFragment.this.jmJ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jmJ.cpb()) && (Eq = ImageListFragment.this.jmJ.Eq(albumId)) != null) {
                    ImageListFragment.this.jmJ.Eo(albumId);
                    ImageListFragment.this.jnK.setData(Eq);
                    ImageListFragment.this.eKt.setText(name);
                    ImageListFragment.this.jnJ.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jnv = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jmX == null || ImageListFragment.this.jmJ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jmJ.coY()) {
                    ImageListFragment.this.jmX.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jmJ.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jmX.e(imageFileInfo);
                } else {
                    ImageListFragment.this.jmX.d(imageFileInfo);
                }
                ImageListFragment.this.jmJ.a(null);
                ImageListFragment.this.jnK.notifyDataSetChanged();
                ImageListFragment.this.cph();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jmJ.coX()) {
                    ImageListFragment.this.jmX.showToast(d.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jmJ.b(videoFileInfo)) {
                        ImageListFragment.this.jmJ.a(null);
                    } else {
                        ImageListFragment.this.jmJ.a(videoFileInfo);
                    }
                    ImageListFragment.this.jmJ.coZ();
                    ImageListFragment.this.jnK.notifyDataSetChanged();
                    ImageListFragment.this.cph();
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
        this.jmX = (AlbumActivity) getBaseFragmentActivity();
        this.jmJ = this.jmX.coI();
        d.cpe().a(this);
        this.jnG = new com.baidu.tbadk.album.f(this.jmX);
        this.jnI = new com.baidu.tieba.write.view.a(this.jmX);
        this.jnI.setOnDismissListener(this.mOnDismissListener);
        this.jnI.a(this.jnM);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.eCv = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.ekA = this.mView.findViewById(d.g.layout_title);
        this.eKt = (TextView) this.mView.findViewById(d.g.album_title);
        this.dGx = (ImageView) this.mView.findViewById(d.g.img_close);
        this.jnH = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.jnL = this.mView.findViewById(d.g.navi_line);
        this.jnd = this.mView.findViewById(d.g.layout_bottom);
        this.jnf = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.jne = (TextView) this.mView.findViewById(d.g.next_step);
        this.jmJ.Eo(com.baidu.tbadk.album.a.bsO);
        this.eKt.setText(this.jmX.getPageContext().getString(d.j.album_all_media));
        if (this.jmJ.getWriteImagesInfo() != null) {
            this.jnf.setVisibility(this.jmJ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jmX.getPageContext().getPageActivity(), this.eCv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ad(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.jnJ = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.jnJ.setSelector(d.C0277d.transparent);
        this.jnK = new h(this.jmX, this.jmJ);
        this.jnK.rc(this.jmX.coH() != 1);
        this.jnJ.setAdapter((ListAdapter) this.jnK);
        this.jnJ.setOuterOnScrollListener(this);
        this.jnK.a(this.jnv);
        this.jnK.a(this.jnu);
        this.jnK.Y(this.jnt);
        this.jnK.setOnOpenCameraFailedListener(this.jnx);
        this.jnK.setOnRequestPermissionListener(this.jnw);
        this.jne.setOnClickListener(this.jmX);
        this.dGx.setOnClickListener(this.jmX);
        this.jnH.setOnClickListener(this.jmX);
        this.jnf.setOnClickListener(this.jmX);
        this.eKt.setOnClickListener(this.mOnClickListener);
        this.jnd.setOnClickListener(this.mOnClickListener);
        cph();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.csK == null) {
            this.csK = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.csK.e(null);
        this.csK.hG(d.j.loading);
        this.csK.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jmX.showToast(d.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cph() {
        int S;
        String string;
        if (this.jmJ != null && this.jne != null) {
            if (this.jmJ.coY()) {
                int i = this.jmJ.coY() ? 1 : 0;
                S = i;
                string = this.jmX.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                S = v.S(this.jmJ.cpa());
                string = this.jmX.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmJ.getMaxImagesAllowed())});
            }
            this.jne.setText(string);
            this.jne.setEnabled(S > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hmA = false;
        if (isShow()) {
            aBu();
        }
    }

    private void coU() {
        if (this.jmJ == null && this.jmX != null) {
            this.jmJ = this.jmX.coI();
        }
        if (this.jmJ != null) {
            if (!this.jmJ.aoI()) {
                this.jnK.notifyDataSetChanged();
            } else {
                cpi();
            }
            qZ(this.jmJ.isOriginalImg());
        }
    }

    private void cpi() {
        if (this.jnG == null) {
            this.jnG = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jnG.a(this.jmX.coH() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.csK != null) {
                    ImageListFragment.this.csK.dJ(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jmJ != null && gVar != null) {
                    ImageListFragment.this.jmJ.c(gVar);
                    String cpb = ImageListFragment.this.jmJ.cpb();
                    ImageListFragment.this.jmJ.Eo(cpb);
                    ImageListFragment.this.jnK.setData(ImageListFragment.this.jmJ.Eq(cpb));
                    ImageListFragment.this.jnJ.smoothScrollToPosition(0);
                    ImageListFragment.this.cph();
                }
                ImageListFragment.this.jnJ.cpp();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        al.f(this.jnL, d.C0277d.cp_bg_line_b, i);
        al.d(this.eKt, d.C0277d.cp_cont_b, i);
        if (this.jmX.coH() == 1) {
            al.b(this.dGx, d.f.icon_topbar_close_n, i);
            this.jnH.setVisibility(8);
        } else {
            al.j(this.jnH, d.C0277d.navi_back_text_color);
            this.dGx.setVisibility(8);
        }
        if (this.eKt != null) {
            this.eKt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.jnK != null) {
            this.jnK.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jmJ != null) {
            qZ(this.jmJ.isOriginalImg());
        }
    }

    public View bZU() {
        return this.jmX.coH() == 1 ? this.dGx : this.jnH;
    }

    public View cpj() {
        return this.jne;
    }

    public TbCameraView coM() {
        if (this.jnK != null) {
            return this.jnK.cpf();
        }
        return null;
    }

    public TransparentHeadGridView cpk() {
        return this.jnJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jnI != null) {
            this.jnI.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jnG != null) {
            this.jnG.UV();
        }
        if (this.jmX != null) {
            this.jmX.closeLoadingDialog();
        }
        if (this.csK != null) {
            this.csK.dJ(false);
        }
        d.cpe().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hmA = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void rb(boolean z) {
        aBu();
    }

    private void aBu() {
        if (!isHidden() && !this.hmA) {
            coU();
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
            this.jnK.mL(true);
        } else if (this.jnK.isScroll()) {
            this.jnK.mL(false);
        }
    }

    public void N(int i, boolean z) {
        if (this.jnJ != null) {
            int firstVisiblePosition = this.jnJ.getFirstVisiblePosition();
            int lastVisiblePosition = this.jnJ.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jnJ.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jnK != null) {
                    this.jnK.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cph();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jnK != null) {
            N(this.jnK.h(imageFileInfo), z);
        }
    }

    public View coR() {
        return this.jnf;
    }

    public void qZ(boolean z) {
        if (this.jmX != null && this.jnf != null) {
            this.jnf.setText(this.jmX.getResources().getString(d.j.original_img));
            if (z) {
                this.jnf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.jnf, d.C0277d.cp_link_tip_a);
                return;
            }
            this.jnf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.jnf, d.C0277d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jmT = iVar;
    }
}
