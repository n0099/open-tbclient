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
    private View cHg;
    private RelativeLayout cYo;
    private TextView ddU;
    private boolean fCM;
    private ImageView fjs;
    private i hBG;
    private AlbumActivity hBK;
    private View hBQ;
    private TextView hBR;
    private TextView hBS;
    private c hBx;
    private com.baidu.tbadk.album.f hCt;
    private TextView hCu;
    private com.baidu.tieba.write.view.a hCv;
    private TransparentHeadGridView hCw;
    private h hCx;
    private View hCy;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d aZn = null;
    private View.OnClickListener hCg = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hBx != null) {
                int maxImagesAllowed = ImageListFragment.this.hBx.getMaxImagesAllowed();
                if (ImageListFragment.this.hBx.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hBK != null) {
                        ImageListFragment.this.hBK.b(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.hBx != null) {
                if (ImageListFragment.this.hBG == null || !ImageListFragment.this.hBG.bJi()) {
                    if (view == ImageListFragment.this.ddU) {
                        ImageListFragment.this.hCv.f(ImageListFragment.this.hBx.bIU(), ImageListFragment.this.hBx.bIS());
                        ImageListFragment.this.hCv.aI(ImageListFragment.this.cHg);
                        ImageListFragment.this.ddU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hBQ) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hCj = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bJc() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hCk = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bJd() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.ddU != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(e.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.ddU.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hCh = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hBx != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hBx.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hBK.vN(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0265a hCz = new a.InterfaceC0265a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0265a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> wp;
            if (ImageListFragment.this.hBx != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hBx.bIS()) && (wp = ImageListFragment.this.hBx.wp(albumId)) != null) {
                    ImageListFragment.this.hBx.wn(albumId);
                    ImageListFragment.this.hCx.setData(wp);
                    ImageListFragment.this.ddU.setText(name);
                    ImageListFragment.this.hCw.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hCi = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hBK == null || ImageListFragment.this.hBx == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hBx.bIP()) {
                    ImageListFragment.this.hBK.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hBx.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hBK.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hBK.c(imageFileInfo);
                }
                ImageListFragment.this.hBx.a(null);
                ImageListFragment.this.hCx.notifyDataSetChanged();
                ImageListFragment.this.bIY();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hBx.bIO()) {
                    ImageListFragment.this.hBK.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hBx.b(videoFileInfo)) {
                        ImageListFragment.this.hBx.a(null);
                    } else {
                        ImageListFragment.this.hBx.a(videoFileInfo);
                    }
                    ImageListFragment.this.hBx.bIQ();
                    ImageListFragment.this.hCx.notifyDataSetChanged();
                    ImageListFragment.this.bIY();
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
        this.hBK = (AlbumActivity) getBaseFragmentActivity();
        this.hBx = this.hBK.bIz();
        d.bIV().a(this);
        this.hCt = new com.baidu.tbadk.album.f(this.hBK);
        this.hCv = new com.baidu.tieba.write.view.a(this.hBK);
        this.hCv.setOnDismissListener(this.mOnDismissListener);
        this.hCv.a(this.hCz);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.cYo = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.cHg = this.mView.findViewById(e.g.layout_title);
        this.ddU = (TextView) this.mView.findViewById(e.g.album_title);
        this.fjs = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hCu = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hCy = this.mView.findViewById(e.g.navi_line);
        this.hBQ = this.mView.findViewById(e.g.layout_bottom);
        this.hBS = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hBR = (TextView) this.mView.findViewById(e.g.next_step);
        this.hBx.wn(com.baidu.tbadk.album.a.acz);
        this.ddU.setText(this.hBK.getPageContext().getString(e.j.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hBK.getPageContext().getPageActivity(), this.cYo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.G(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hCw = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hCw.setSelector(e.d.transparent);
        this.hCx = new h(this.hBK, this.hBx);
        this.hCx.nS(this.hBK.bIy() != 1);
        this.hCw.setAdapter((ListAdapter) this.hCx);
        this.hCw.setOuterOnScrollListener(this);
        this.hCx.a(this.hCi);
        this.hCx.a(this.hCh);
        this.hCx.W(this.hCg);
        this.hCx.setOnOpenCameraFailedListener(this.hCk);
        this.hCx.setOnRequestPermissionListener(this.hCj);
        this.hBR.setOnClickListener(this.hBK);
        this.fjs.setOnClickListener(this.hBK);
        this.hCu.setOnClickListener(this.hBK);
        this.hBS.setOnClickListener(this.hBK);
        this.ddU.setOnClickListener(this.mOnClickListener);
        this.hBQ.setOnClickListener(this.mOnClickListener);
        bIY();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aZn == null) {
            this.aZn = new com.baidu.tbadk.core.view.d(getPageContext());
        }
        this.aZn.d(null);
        this.aZn.dq(e.j.loading);
        this.aZn.aZ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hBK.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIY() {
        int y;
        String string;
        if (this.hBx != null && this.hBR != null) {
            if (this.hBx.bIP()) {
                int i = this.hBx.bIP() ? 1 : 0;
                y = i;
                string = this.hBK.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                y = v.y(this.hBx.bIR());
                string = this.hBK.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.hBx.getMaxImagesAllowed())});
            }
            this.hBR.setText(string);
            this.hBR.setEnabled(y > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fCM = false;
        if (isShow()) {
            VC();
        }
    }

    private void bIL() {
        if (this.hBx == null && this.hBK != null) {
            this.hBx = this.hBK.bIz();
        }
        if (this.hBx != null) {
            if (!this.hBx.Lz()) {
                this.hCx.notifyDataSetChanged();
            } else {
                bIZ();
            }
            nP(this.hBx.isOriginalImg());
        }
    }

    private void bIZ() {
        if (this.hCt == null) {
            this.hCt = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hCt.a(this.hBK.bIy() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.aZn != null) {
                    ImageListFragment.this.aZn.aZ(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hBx != null && gVar != null) {
                    ImageListFragment.this.hBx.c(gVar);
                    String bIS = ImageListFragment.this.hBx.bIS();
                    ImageListFragment.this.hBx.wn(bIS);
                    ImageListFragment.this.hCx.setData(ImageListFragment.this.hBx.wp(bIS));
                    ImageListFragment.this.hCw.smoothScrollToPosition(0);
                    ImageListFragment.this.bIY();
                }
                ImageListFragment.this.hCw.bJg();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hCy, e.d.cp_bg_line_b, i);
        al.c(this.ddU, e.d.cp_cont_b, i);
        if (this.hBK.bIy() == 1) {
            al.b(this.fjs, e.f.icon_topbar_close_n, i);
            this.hCu.setVisibility(8);
        } else {
            al.h(this.hCu, e.d.navi_back_text_color);
            this.fjs.setVisibility(8);
        }
        if (this.ddU != null) {
            this.ddU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hCx != null) {
            this.hCx.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hBx != null) {
            nP(this.hBx.isOriginalImg());
        }
    }

    public View btb() {
        return this.hBK.bIy() == 1 ? this.fjs : this.hCu;
    }

    public View bJa() {
        return this.hBR;
    }

    public TbCameraView bID() {
        if (this.hCx != null) {
            return this.hCx.bIW();
        }
        return null;
    }

    public TransparentHeadGridView bJb() {
        return this.hCw;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hCv != null) {
            this.hCv.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hCt != null) {
            this.hCt.sL();
        }
        if (this.hBK != null) {
            this.hBK.closeLoadingDialog();
        }
        if (this.aZn != null) {
            this.aZn.aZ(false);
        }
        d.bIV().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fCM = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void nR(boolean z) {
        VC();
    }

    private void VC() {
        if (!isHidden() && !this.fCM) {
            bIL();
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
            this.hCx.jC(true);
        } else if (this.hCx.isScroll()) {
            this.hCx.jC(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hCw != null) {
            int firstVisiblePosition = this.hCw.getFirstVisiblePosition();
            int lastVisiblePosition = this.hCw.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hCw.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hCx != null) {
                    this.hCx.d((ImageView) childAt.findViewById(e.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bIY();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hCx != null) {
            H(this.hCx.g(imageFileInfo), z);
        }
    }

    public View bII() {
        return this.hBS;
    }

    public void nP(boolean z) {
        if (this.hBK != null && this.hBS != null) {
            this.hBS.setText(this.hBK.getResources().getString(e.j.original_img));
            if (z) {
                this.hBS.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hBS, e.d.cp_link_tip_a);
                return;
            }
            this.hBS.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hBS, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hBG = iVar;
    }
}
