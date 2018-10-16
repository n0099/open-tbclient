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
    private View cPA;
    private RelativeLayout dgE;
    private TextView dma;
    private boolean fKn;
    private ImageView fra;
    private c hIJ;
    private i hIT;
    private AlbumActivity hIX;
    private com.baidu.tbadk.album.f hJG;
    private TextView hJH;
    private com.baidu.tieba.write.view.a hJI;
    private TransparentHeadGridView hJJ;
    private h hJK;
    private View hJL;
    private View hJd;
    private TextView hJe;
    private TextView hJf;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d bdN = null;
    private View.OnClickListener hJt = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hIJ != null) {
                int maxImagesAllowed = ImageListFragment.this.hIJ.getMaxImagesAllowed();
                if (ImageListFragment.this.hIJ.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hIX != null) {
                        ImageListFragment.this.hIX.b(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.hIJ != null) {
                if (ImageListFragment.this.hIT == null || !ImageListFragment.this.hIT.bMu()) {
                    if (view == ImageListFragment.this.dma) {
                        ImageListFragment.this.hJI.f(ImageListFragment.this.hIJ.bMg(), ImageListFragment.this.hIJ.bMe());
                        ImageListFragment.this.hJI.aI(ImageListFragment.this.cPA);
                        ImageListFragment.this.dma.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hJd) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hJw = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bMo() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hJx = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bMp() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.dma != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(e.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.dma.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hJu = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hIJ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hIJ.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hIX.wk(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0300a hJM = new a.InterfaceC0300a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0300a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> wQ;
            if (ImageListFragment.this.hIJ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hIJ.bMe()) && (wQ = ImageListFragment.this.hIJ.wQ(albumId)) != null) {
                    ImageListFragment.this.hIJ.wO(albumId);
                    ImageListFragment.this.hJK.setData(wQ);
                    ImageListFragment.this.dma.setText(name);
                    ImageListFragment.this.hJJ.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hJv = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hIX == null || ImageListFragment.this.hIJ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hIJ.bMb()) {
                    ImageListFragment.this.hIX.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hIJ.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hIX.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hIX.c(imageFileInfo);
                }
                ImageListFragment.this.hIJ.a(null);
                ImageListFragment.this.hJK.notifyDataSetChanged();
                ImageListFragment.this.bMk();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hIJ.bMa()) {
                    ImageListFragment.this.hIX.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hIJ.b(videoFileInfo)) {
                        ImageListFragment.this.hIJ.a(null);
                    } else {
                        ImageListFragment.this.hIJ.a(videoFileInfo);
                    }
                    ImageListFragment.this.hIJ.bMc();
                    ImageListFragment.this.hJK.notifyDataSetChanged();
                    ImageListFragment.this.bMk();
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
        this.hIX = (AlbumActivity) getBaseFragmentActivity();
        this.hIJ = this.hIX.bLL();
        d.bMh().a(this);
        this.hJG = new com.baidu.tbadk.album.f(this.hIX);
        this.hJI = new com.baidu.tieba.write.view.a(this.hIX);
        this.hJI.setOnDismissListener(this.mOnDismissListener);
        this.hJI.a(this.hJM);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.dgE = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.cPA = this.mView.findViewById(e.g.layout_title);
        this.dma = (TextView) this.mView.findViewById(e.g.album_title);
        this.fra = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hJH = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hJL = this.mView.findViewById(e.g.navi_line);
        this.hJd = this.mView.findViewById(e.g.layout_bottom);
        this.hJf = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hJe = (TextView) this.mView.findViewById(e.g.next_step);
        this.hIJ.wO(com.baidu.tbadk.album.a.ahy);
        this.dma.setText(this.hIX.getPageContext().getString(e.j.album_all_media));
        if (this.hIJ.getWriteImagesInfo() != null) {
            this.hJf.setVisibility(this.hIJ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hIX.getPageContext().getPageActivity(), this.dgE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.G(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hJJ = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hJJ.setSelector(e.d.transparent);
        this.hJK = new h(this.hIX, this.hIJ);
        this.hJK.oi(this.hIX.bLK() != 1);
        this.hJJ.setAdapter((ListAdapter) this.hJK);
        this.hJJ.setOuterOnScrollListener(this);
        this.hJK.a(this.hJv);
        this.hJK.a(this.hJu);
        this.hJK.W(this.hJt);
        this.hJK.setOnOpenCameraFailedListener(this.hJx);
        this.hJK.setOnRequestPermissionListener(this.hJw);
        this.hJe.setOnClickListener(this.hIX);
        this.fra.setOnClickListener(this.hIX);
        this.hJH.setOnClickListener(this.hIX);
        this.hJf.setOnClickListener(this.hIX);
        this.dma.setOnClickListener(this.mOnClickListener);
        this.hJd.setOnClickListener(this.mOnClickListener);
        bMk();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bdN == null) {
            this.bdN = new com.baidu.tbadk.core.view.d(getPageContext());
        }
        this.bdN.d(null);
        this.bdN.dA(e.j.loading);
        this.bdN.bj(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hIX.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMk() {
        int I;
        String string;
        if (this.hIJ != null && this.hJe != null) {
            if (this.hIJ.bMb()) {
                int i = this.hIJ.bMb() ? 1 : 0;
                I = i;
                string = this.hIX.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                I = v.I(this.hIJ.bMd());
                string = this.hIX.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(I), Integer.valueOf(this.hIJ.getMaxImagesAllowed())});
            }
            this.hJe.setText(string);
            this.hJe.setEnabled(I > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fKn = false;
        if (isShow()) {
            Zj();
        }
    }

    private void bLX() {
        if (this.hIJ == null && this.hIX != null) {
            this.hIJ = this.hIX.bLL();
        }
        if (this.hIJ != null) {
            if (!this.hIJ.Nx()) {
                this.hJK.notifyDataSetChanged();
            } else {
                bMl();
            }
            of(this.hIJ.isOriginalImg());
        }
    }

    private void bMl() {
        if (this.hJG == null) {
            this.hJG = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hJG.a(this.hIX.bLK() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.bdN != null) {
                    ImageListFragment.this.bdN.bj(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hIJ != null && gVar != null) {
                    ImageListFragment.this.hIJ.c(gVar);
                    String bMe = ImageListFragment.this.hIJ.bMe();
                    ImageListFragment.this.hIJ.wO(bMe);
                    ImageListFragment.this.hJK.setData(ImageListFragment.this.hIJ.wQ(bMe));
                    ImageListFragment.this.hJJ.smoothScrollToPosition(0);
                    ImageListFragment.this.bMk();
                }
                ImageListFragment.this.hJJ.bMs();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hJL, e.d.cp_bg_line_b, i);
        al.c(this.dma, e.d.cp_cont_b, i);
        if (this.hIX.bLK() == 1) {
            al.b(this.fra, e.f.icon_topbar_close_n, i);
            this.hJH.setVisibility(8);
        } else {
            al.h(this.hJH, e.d.navi_back_text_color);
            this.fra.setVisibility(8);
        }
        if (this.dma != null) {
            this.dma.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hJK != null) {
            this.hJK.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hIJ != null) {
            of(this.hIJ.isOriginalImg());
        }
    }

    public View bwq() {
        return this.hIX.bLK() == 1 ? this.fra : this.hJH;
    }

    public View bMm() {
        return this.hJe;
    }

    public TbCameraView bLP() {
        if (this.hJK != null) {
            return this.hJK.bMi();
        }
        return null;
    }

    public TransparentHeadGridView bMn() {
        return this.hJJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hJI != null) {
            this.hJI.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hJG != null) {
            this.hJG.uW();
        }
        if (this.hIX != null) {
            this.hIX.closeLoadingDialog();
        }
        if (this.bdN != null) {
            this.bdN.bj(false);
        }
        d.bMh().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fKn = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void oh(boolean z) {
        Zj();
    }

    private void Zj() {
        if (!isHidden() && !this.fKn) {
            bLX();
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
            this.hJK.jT(true);
        } else if (this.hJK.isScroll()) {
            this.hJK.jT(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hJJ != null) {
            int firstVisiblePosition = this.hJJ.getFirstVisiblePosition();
            int lastVisiblePosition = this.hJJ.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hJJ.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hJK != null) {
                    this.hJK.d((ImageView) childAt.findViewById(e.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bMk();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hJK != null) {
            H(this.hJK.g(imageFileInfo), z);
        }
    }

    public View bLU() {
        return this.hJf;
    }

    public void of(boolean z) {
        if (this.hIX != null && this.hJf != null) {
            this.hJf.setText(this.hIX.getResources().getString(e.j.original_img));
            if (z) {
                this.hJf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hJf, e.d.cp_link_tip_a);
                return;
            }
            this.hJf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hJf, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hIT = iVar;
    }
}
