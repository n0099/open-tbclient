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
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private ImageView dQo;
    private View eAc;
    private RelativeLayout epW;
    private TextView faq;
    private boolean hDS;
    private c jFE;
    private i jFO;
    private AlbumActivity jFS;
    private View jFY;
    private TextView jFZ;
    private com.baidu.tbadk.album.f jGB;
    private TextView jGC;
    private com.baidu.tieba.write.view.a jGD;
    private TransparentHeadGridView jGE;
    private h jGF;
    private View jGG;
    private TextView jGa;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cAX = null;
    private View.OnClickListener jGo = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jFE != null) {
                int maxImagesAllowed = ImageListFragment.this.jFE.getMaxImagesAllowed();
                if (ImageListFragment.this.jFE.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jFS != null) {
                        ImageListFragment.this.jFS.c(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jFE != null) {
                if (ImageListFragment.this.jFO == null || !ImageListFragment.this.jFO.cxv()) {
                    if (view == ImageListFragment.this.faq) {
                        ImageListFragment.this.jGD.b(ImageListFragment.this.jFE.cxi(), ImageListFragment.this.jFE.cxg());
                        ImageListFragment.this.jGD.bm(ImageListFragment.this.eAc);
                        ImageListFragment.this.faq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jFY) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jGr = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aXo() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jGs = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cxq() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.faq != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(R.drawable.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.faq.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jGp = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jFE != null && ImageListFragment.this.jFE.getWriteImagesInfo() != null && ImageListFragment.this.jFE.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jFS.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jFE != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jFE.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jFS.Cj(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0434a jGH = new a.InterfaceC0434a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0434a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> FN;
            if (ImageListFragment.this.jFE != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jFE.cxg()) && (FN = ImageListFragment.this.jFE.FN(albumId)) != null) {
                    ImageListFragment.this.jFE.FL(albumId);
                    ImageListFragment.this.jGF.setData(FN);
                    ImageListFragment.this.faq.setText(name);
                    ImageListFragment.this.jGE.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jGq = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jFS == null || ImageListFragment.this.jFE == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jFE.cxd()) {
                    ImageListFragment.this.jFS.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jFE.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jFS.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jFS.e(imageFileInfo);
                }
                ImageListFragment.this.jFE.a(null);
                ImageListFragment.this.jGF.notifyDataSetChanged();
                ImageListFragment.this.cxm();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jFE.cxc()) {
                    ImageListFragment.this.jFS.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jFE.b(videoFileInfo)) {
                        ImageListFragment.this.jFE.a(null);
                    } else {
                        ImageListFragment.this.jFE.a(videoFileInfo);
                    }
                    ImageListFragment.this.jFE.cxe();
                    ImageListFragment.this.jGF.notifyDataSetChanged();
                    ImageListFragment.this.cxm();
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
        this.jFS = (AlbumActivity) getBaseFragmentActivity();
        this.jFE = this.jFS.cwO();
        d.cxj().a(this);
        this.jGB = new com.baidu.tbadk.album.f(this.jFS);
        this.jGD = new com.baidu.tieba.write.view.a(this.jFS);
        this.jGD.setOnDismissListener(this.mOnDismissListener);
        this.jGD.a(this.jGH);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.epW = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.eAc = this.mView.findViewById(R.id.layout_title);
        this.faq = (TextView) this.mView.findViewById(R.id.album_title);
        this.dQo = (ImageView) this.mView.findViewById(R.id.img_close);
        this.jGC = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.jGG = this.mView.findViewById(R.id.navi_line);
        this.jFY = this.mView.findViewById(R.id.layout_bottom);
        this.jGa = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.jFZ = (TextView) this.mView.findViewById(R.id.next_step);
        this.jFE.FL(com.baidu.tbadk.album.a.bzV);
        this.faq.setText(this.jFS.getPageContext().getString(R.string.album_all_media));
        if (this.jFE.getWriteImagesInfo() != null) {
            this.jGa.setVisibility(this.jFE.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jFE.getWriteImagesInfo() != null && this.jFE.getWriteImagesInfo().isFromQRCode()) {
            this.jFY.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jFS.getPageContext().getPageActivity(), this.epW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ad(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jGE = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jGE.setSelector(R.color.transparent);
        this.jGF = new h(this.jFS, this.jFE);
        if (this.jFE.getWriteImagesInfo() != null && this.jFE.getWriteImagesInfo().isFromQRCode()) {
            this.jGF.rS(false);
        } else {
            this.jGF.rS(this.jFS.cwN() != 1);
        }
        this.jGE.setAdapter((ListAdapter) this.jGF);
        this.jGE.setOuterOnScrollListener(this);
        this.jGF.a(this.jGq);
        this.jGF.a(this.jGp);
        this.jGF.ab(this.jGo);
        this.jGF.setOnOpenCameraFailedListener(this.jGs);
        this.jGF.setOnRequestPermissionListener(this.jGr);
        this.jFZ.setOnClickListener(this.jFS);
        this.dQo.setOnClickListener(this.jFS);
        this.jGC.setOnClickListener(this.jFS);
        this.jGa.setOnClickListener(this.jFS);
        this.faq.setOnClickListener(this.mOnClickListener);
        this.jFY.setOnClickListener(this.mOnClickListener);
        cxm();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cAX == null) {
            this.cAX = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cAX.e(null);
        this.cAX.it(R.string.loading);
        this.cAX.ef(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jFS.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxm() {
        int Z;
        String string;
        if (this.jFE != null && this.jFZ != null) {
            if (this.jFE.cxd()) {
                int i = this.jFE.cxd() ? 1 : 0;
                Z = i;
                string = this.jFS.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                Z = v.Z(this.jFE.cxf());
                string = this.jFS.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jFE.getMaxImagesAllowed())});
            }
            this.jFZ.setText(string);
            this.jFZ.setEnabled(Z > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hDS = false;
        if (isShow()) {
            aHL();
        }
    }

    private void cwZ() {
        if (this.jFE == null && this.jFS != null) {
            this.jFE = this.jFS.cwO();
        }
        if (this.jFE != null) {
            if (!this.jFE.atJ()) {
                this.jGF.notifyDataSetChanged();
            } else {
                cxn();
            }
            rP(this.jFE.isOriginalImg());
        }
    }

    private void cxn() {
        if (this.jGB == null) {
            this.jGB = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jGB.a(this.jFS.cwN() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cAX != null) {
                    ImageListFragment.this.cAX.ef(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jFE != null && gVar != null) {
                    ImageListFragment.this.jFE.c(gVar);
                    String cxg = ImageListFragment.this.jFE.cxg();
                    ImageListFragment.this.jFE.FL(cxg);
                    ImageListFragment.this.jGF.setData(ImageListFragment.this.jFE.FN(cxg));
                    ImageListFragment.this.jGE.smoothScrollToPosition(0);
                    ImageListFragment.this.cxm();
                }
                ImageListFragment.this.jGE.cxt();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        al.h(this.jGG, R.color.cp_bg_line_b, i);
        al.f(this.faq, R.color.cp_cont_b, i);
        if (this.jFS.cwN() == 1) {
            al.b(this.dQo, (int) R.drawable.icon_topbar_close_n, i);
            this.jGC.setVisibility(8);
        } else {
            al.j(this.jGC, R.color.navi_back_text_color);
            this.dQo.setVisibility(8);
        }
        if (this.faq != null) {
            this.faq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
        }
        if (this.jGF != null) {
            this.jGF.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jFE != null) {
            rP(this.jFE.isOriginalImg());
        }
    }

    public View chX() {
        return this.jFS.cwN() == 1 ? this.dQo : this.jGC;
    }

    public View cxo() {
        return this.jFZ;
    }

    public TbCameraView cwR() {
        if (this.jGF != null) {
            return this.jGF.cxk();
        }
        return null;
    }

    public TransparentHeadGridView cxp() {
        return this.jGE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jGD != null) {
            this.jGD.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jGB != null) {
            this.jGB.Zw();
        }
        if (this.jFS != null) {
            this.jFS.closeLoadingDialog();
        }
        if (this.cAX != null) {
            this.cAX.ef(false);
        }
        d.cxj().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hDS = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void rR(boolean z) {
        aHL();
    }

    private void aHL() {
        if (!isHidden() && !this.hDS) {
            cwZ();
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
            this.jGF.nB(true);
        } else if (this.jGF.isScroll()) {
            this.jGF.nB(false);
        }
    }

    public void S(int i, boolean z) {
        if (this.jGE != null) {
            int firstVisiblePosition = this.jGE.getFirstVisiblePosition();
            int lastVisiblePosition = this.jGE.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jGE.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jGF != null) {
                    this.jGF.d((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cxm();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jGF != null) {
            S(this.jGF.i(imageFileInfo), z);
        }
    }

    public View cwW() {
        return this.jGa;
    }

    public void rP(boolean z) {
        if (this.jFS != null && this.jGa != null) {
            this.jGa.setText(this.jFS.getResources().getString(R.string.original_img));
            if (z) {
                this.jGa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.jGa, R.color.cp_link_tip_a);
                return;
            }
            this.jGa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.jGa, R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jFO = iVar;
    }
}
