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
    private boolean fKo;
    private ImageView frb;
    private c hIK;
    private i hIU;
    private AlbumActivity hIY;
    private com.baidu.tbadk.album.f hJH;
    private TextView hJI;
    private com.baidu.tieba.write.view.a hJJ;
    private TransparentHeadGridView hJK;
    private h hJL;
    private View hJM;
    private View hJe;
    private TextView hJf;
    private TextView hJg;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d bdN = null;
    private View.OnClickListener hJu = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hIK != null) {
                int maxImagesAllowed = ImageListFragment.this.hIK.getMaxImagesAllowed();
                if (ImageListFragment.this.hIK.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hIY != null) {
                        ImageListFragment.this.hIY.b(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.hIK != null) {
                if (ImageListFragment.this.hIU == null || !ImageListFragment.this.hIU.bMu()) {
                    if (view == ImageListFragment.this.dma) {
                        ImageListFragment.this.hJJ.f(ImageListFragment.this.hIK.bMg(), ImageListFragment.this.hIK.bMe());
                        ImageListFragment.this.hJJ.aI(ImageListFragment.this.cPA);
                        ImageListFragment.this.dma.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hJe) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hJx = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bMo() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hJy = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
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
    private f hJv = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hIK != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hIK.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hIY.wk(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0300a hJN = new a.InterfaceC0300a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0300a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> wQ;
            if (ImageListFragment.this.hIK != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hIK.bMe()) && (wQ = ImageListFragment.this.hIK.wQ(albumId)) != null) {
                    ImageListFragment.this.hIK.wO(albumId);
                    ImageListFragment.this.hJL.setData(wQ);
                    ImageListFragment.this.dma.setText(name);
                    ImageListFragment.this.hJK.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hJw = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hIY == null || ImageListFragment.this.hIK == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hIK.bMb()) {
                    ImageListFragment.this.hIY.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hIK.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hIY.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hIY.c(imageFileInfo);
                }
                ImageListFragment.this.hIK.a(null);
                ImageListFragment.this.hJL.notifyDataSetChanged();
                ImageListFragment.this.bMk();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hIK.bMa()) {
                    ImageListFragment.this.hIY.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hIK.b(videoFileInfo)) {
                        ImageListFragment.this.hIK.a(null);
                    } else {
                        ImageListFragment.this.hIK.a(videoFileInfo);
                    }
                    ImageListFragment.this.hIK.bMc();
                    ImageListFragment.this.hJL.notifyDataSetChanged();
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
        this.hIY = (AlbumActivity) getBaseFragmentActivity();
        this.hIK = this.hIY.bLL();
        d.bMh().a(this);
        this.hJH = new com.baidu.tbadk.album.f(this.hIY);
        this.hJJ = new com.baidu.tieba.write.view.a(this.hIY);
        this.hJJ.setOnDismissListener(this.mOnDismissListener);
        this.hJJ.a(this.hJN);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.dgE = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.cPA = this.mView.findViewById(e.g.layout_title);
        this.dma = (TextView) this.mView.findViewById(e.g.album_title);
        this.frb = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hJI = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hJM = this.mView.findViewById(e.g.navi_line);
        this.hJe = this.mView.findViewById(e.g.layout_bottom);
        this.hJg = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hJf = (TextView) this.mView.findViewById(e.g.next_step);
        this.hIK.wO(com.baidu.tbadk.album.a.ahy);
        this.dma.setText(this.hIY.getPageContext().getString(e.j.album_all_media));
        if (this.hIK.getWriteImagesInfo() != null) {
            this.hJg.setVisibility(this.hIK.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hIY.getPageContext().getPageActivity(), this.dgE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.G(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hJK = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hJK.setSelector(e.d.transparent);
        this.hJL = new h(this.hIY, this.hIK);
        this.hJL.oi(this.hIY.bLK() != 1);
        this.hJK.setAdapter((ListAdapter) this.hJL);
        this.hJK.setOuterOnScrollListener(this);
        this.hJL.a(this.hJw);
        this.hJL.a(this.hJv);
        this.hJL.W(this.hJu);
        this.hJL.setOnOpenCameraFailedListener(this.hJy);
        this.hJL.setOnRequestPermissionListener(this.hJx);
        this.hJf.setOnClickListener(this.hIY);
        this.frb.setOnClickListener(this.hIY);
        this.hJI.setOnClickListener(this.hIY);
        this.hJg.setOnClickListener(this.hIY);
        this.dma.setOnClickListener(this.mOnClickListener);
        this.hJe.setOnClickListener(this.mOnClickListener);
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
            this.hIY.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMk() {
        int I;
        String string;
        if (this.hIK != null && this.hJf != null) {
            if (this.hIK.bMb()) {
                int i = this.hIK.bMb() ? 1 : 0;
                I = i;
                string = this.hIY.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                I = v.I(this.hIK.bMd());
                string = this.hIY.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(I), Integer.valueOf(this.hIK.getMaxImagesAllowed())});
            }
            this.hJf.setText(string);
            this.hJf.setEnabled(I > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fKo = false;
        if (isShow()) {
            Zk();
        }
    }

    private void bLX() {
        if (this.hIK == null && this.hIY != null) {
            this.hIK = this.hIY.bLL();
        }
        if (this.hIK != null) {
            if (!this.hIK.Nx()) {
                this.hJL.notifyDataSetChanged();
            } else {
                bMl();
            }
            of(this.hIK.isOriginalImg());
        }
    }

    private void bMl() {
        if (this.hJH == null) {
            this.hJH = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hJH.a(this.hIY.bLK() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.hIK != null && gVar != null) {
                    ImageListFragment.this.hIK.c(gVar);
                    String bMe = ImageListFragment.this.hIK.bMe();
                    ImageListFragment.this.hIK.wO(bMe);
                    ImageListFragment.this.hJL.setData(ImageListFragment.this.hIK.wQ(bMe));
                    ImageListFragment.this.hJK.smoothScrollToPosition(0);
                    ImageListFragment.this.bMk();
                }
                ImageListFragment.this.hJK.bMs();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hJM, e.d.cp_bg_line_b, i);
        al.c(this.dma, e.d.cp_cont_b, i);
        if (this.hIY.bLK() == 1) {
            al.b(this.frb, e.f.icon_topbar_close_n, i);
            this.hJI.setVisibility(8);
        } else {
            al.h(this.hJI, e.d.navi_back_text_color);
            this.frb.setVisibility(8);
        }
        if (this.dma != null) {
            this.dma.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hJL != null) {
            this.hJL.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hIK != null) {
            of(this.hIK.isOriginalImg());
        }
    }

    public View bwq() {
        return this.hIY.bLK() == 1 ? this.frb : this.hJI;
    }

    public View bMm() {
        return this.hJf;
    }

    public TbCameraView bLP() {
        if (this.hJL != null) {
            return this.hJL.bMi();
        }
        return null;
    }

    public TransparentHeadGridView bMn() {
        return this.hJK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hJJ != null) {
            this.hJJ.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hJH != null) {
            this.hJH.uW();
        }
        if (this.hIY != null) {
            this.hIY.closeLoadingDialog();
        }
        if (this.bdN != null) {
            this.bdN.bj(false);
        }
        d.bMh().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fKo = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void oh(boolean z) {
        Zk();
    }

    private void Zk() {
        if (!isHidden() && !this.fKo) {
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
            this.hJL.jT(true);
        } else if (this.hJL.isScroll()) {
            this.hJL.jT(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hJK != null) {
            int firstVisiblePosition = this.hJK.getFirstVisiblePosition();
            int lastVisiblePosition = this.hJK.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hJK.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hJL != null) {
                    this.hJL.d((ImageView) childAt.findViewById(e.g.select_icon), z);
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
        if (imageFileInfo != null && this.hJL != null) {
            H(this.hJL.g(imageFileInfo), z);
        }
    }

    public View bLU() {
        return this.hJg;
    }

    public void of(boolean z) {
        if (this.hIY != null && this.hJg != null) {
            this.hJg.setText(this.hIY.getResources().getString(e.j.original_img));
            if (z) {
                this.hJg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hJg, e.d.cp_link_tip_a);
                return;
            }
            this.hJg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hJg, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hIU = iVar;
    }
}
