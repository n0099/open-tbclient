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
    private boolean hDR;
    private c jFB;
    private i jFL;
    private AlbumActivity jFP;
    private View jFV;
    private TextView jFW;
    private TextView jFX;
    private com.baidu.tieba.write.view.a jGA;
    private TransparentHeadGridView jGB;
    private h jGC;
    private View jGD;
    private com.baidu.tbadk.album.f jGy;
    private TextView jGz;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cAW = null;
    private View.OnClickListener jGl = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jFB != null) {
                int maxImagesAllowed = ImageListFragment.this.jFB.getMaxImagesAllowed();
                if (ImageListFragment.this.jFB.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jFP != null) {
                        ImageListFragment.this.jFP.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jFB != null) {
                if (ImageListFragment.this.jFL == null || !ImageListFragment.this.jFL.cxw()) {
                    if (view == ImageListFragment.this.faq) {
                        ImageListFragment.this.jGA.b(ImageListFragment.this.jFB.cxj(), ImageListFragment.this.jFB.cxh());
                        ImageListFragment.this.jGA.bm(ImageListFragment.this.eAc);
                        ImageListFragment.this.faq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jFV) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jGo = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aXo() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jGp = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cxr() {
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
    private f jGm = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jFB != null && ImageListFragment.this.jFB.getWriteImagesInfo() != null && ImageListFragment.this.jFB.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jFP.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jFB != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jFB.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jFP.Cj(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0434a jGE = new a.InterfaceC0434a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0434a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> FL;
            if (ImageListFragment.this.jFB != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jFB.cxh()) && (FL = ImageListFragment.this.jFB.FL(albumId)) != null) {
                    ImageListFragment.this.jFB.FJ(albumId);
                    ImageListFragment.this.jGC.setData(FL);
                    ImageListFragment.this.faq.setText(name);
                    ImageListFragment.this.jGB.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jGn = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jFP == null || ImageListFragment.this.jFB == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jFB.cxe()) {
                    ImageListFragment.this.jFP.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jFB.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jFP.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jFP.e(imageFileInfo);
                }
                ImageListFragment.this.jFB.a(null);
                ImageListFragment.this.jGC.notifyDataSetChanged();
                ImageListFragment.this.cxn();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jFB.cxd()) {
                    ImageListFragment.this.jFP.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jFB.b(videoFileInfo)) {
                        ImageListFragment.this.jFB.a(null);
                    } else {
                        ImageListFragment.this.jFB.a(videoFileInfo);
                    }
                    ImageListFragment.this.jFB.cxf();
                    ImageListFragment.this.jGC.notifyDataSetChanged();
                    ImageListFragment.this.cxn();
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
        this.jFP = (AlbumActivity) getBaseFragmentActivity();
        this.jFB = this.jFP.cwP();
        d.cxk().a(this);
        this.jGy = new com.baidu.tbadk.album.f(this.jFP);
        this.jGA = new com.baidu.tieba.write.view.a(this.jFP);
        this.jGA.setOnDismissListener(this.mOnDismissListener);
        this.jGA.a(this.jGE);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.epW = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.eAc = this.mView.findViewById(R.id.layout_title);
        this.faq = (TextView) this.mView.findViewById(R.id.album_title);
        this.dQo = (ImageView) this.mView.findViewById(R.id.img_close);
        this.jGz = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.jGD = this.mView.findViewById(R.id.navi_line);
        this.jFV = this.mView.findViewById(R.id.layout_bottom);
        this.jFX = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.jFW = (TextView) this.mView.findViewById(R.id.next_step);
        this.jFB.FJ(com.baidu.tbadk.album.a.bzV);
        this.faq.setText(this.jFP.getPageContext().getString(R.string.album_all_media));
        if (this.jFB.getWriteImagesInfo() != null) {
            this.jFX.setVisibility(this.jFB.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jFB.getWriteImagesInfo() != null && this.jFB.getWriteImagesInfo().isFromQRCode()) {
            this.jFV.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jFP.getPageContext().getPageActivity(), this.epW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ad(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jGB = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jGB.setSelector(R.color.transparent);
        this.jGC = new h(this.jFP, this.jFB);
        if (this.jFB.getWriteImagesInfo() != null && this.jFB.getWriteImagesInfo().isFromQRCode()) {
            this.jGC.rR(false);
        } else {
            this.jGC.rR(this.jFP.cwO() != 1);
        }
        this.jGB.setAdapter((ListAdapter) this.jGC);
        this.jGB.setOuterOnScrollListener(this);
        this.jGC.a(this.jGn);
        this.jGC.a(this.jGm);
        this.jGC.ab(this.jGl);
        this.jGC.setOnOpenCameraFailedListener(this.jGp);
        this.jGC.setOnRequestPermissionListener(this.jGo);
        this.jFW.setOnClickListener(this.jFP);
        this.dQo.setOnClickListener(this.jFP);
        this.jGz.setOnClickListener(this.jFP);
        this.jFX.setOnClickListener(this.jFP);
        this.faq.setOnClickListener(this.mOnClickListener);
        this.jFV.setOnClickListener(this.mOnClickListener);
        cxn();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cAW == null) {
            this.cAW = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cAW.e(null);
        this.cAW.it(R.string.loading);
        this.cAW.ef(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jFP.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxn() {
        int Z;
        String string;
        if (this.jFB != null && this.jFW != null) {
            if (this.jFB.cxe()) {
                int i = this.jFB.cxe() ? 1 : 0;
                Z = i;
                string = this.jFP.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                Z = v.Z(this.jFB.cxg());
                string = this.jFP.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jFB.getMaxImagesAllowed())});
            }
            this.jFW.setText(string);
            this.jFW.setEnabled(Z > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hDR = false;
        if (isShow()) {
            aHL();
        }
    }

    private void cxa() {
        if (this.jFB == null && this.jFP != null) {
            this.jFB = this.jFP.cwP();
        }
        if (this.jFB != null) {
            if (!this.jFB.atJ()) {
                this.jGC.notifyDataSetChanged();
            } else {
                cxo();
            }
            rO(this.jFB.isOriginalImg());
        }
    }

    private void cxo() {
        if (this.jGy == null) {
            this.jGy = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jGy.a(this.jFP.cwO() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cAW != null) {
                    ImageListFragment.this.cAW.ef(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jFB != null && gVar != null) {
                    ImageListFragment.this.jFB.c(gVar);
                    String cxh = ImageListFragment.this.jFB.cxh();
                    ImageListFragment.this.jFB.FJ(cxh);
                    ImageListFragment.this.jGC.setData(ImageListFragment.this.jFB.FL(cxh));
                    ImageListFragment.this.jGB.smoothScrollToPosition(0);
                    ImageListFragment.this.cxn();
                }
                ImageListFragment.this.jGB.cxu();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        al.h(this.jGD, R.color.cp_bg_line_b, i);
        al.f(this.faq, R.color.cp_cont_b, i);
        if (this.jFP.cwO() == 1) {
            al.b(this.dQo, (int) R.drawable.icon_topbar_close_n, i);
            this.jGz.setVisibility(8);
        } else {
            al.j(this.jGz, R.color.navi_back_text_color);
            this.dQo.setVisibility(8);
        }
        if (this.faq != null) {
            this.faq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
        }
        if (this.jGC != null) {
            this.jGC.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jFB != null) {
            rO(this.jFB.isOriginalImg());
        }
    }

    public View chW() {
        return this.jFP.cwO() == 1 ? this.dQo : this.jGz;
    }

    public View cxp() {
        return this.jFW;
    }

    public TbCameraView cwS() {
        if (this.jGC != null) {
            return this.jGC.cxl();
        }
        return null;
    }

    public TransparentHeadGridView cxq() {
        return this.jGB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jGA != null) {
            this.jGA.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jGy != null) {
            this.jGy.Zw();
        }
        if (this.jFP != null) {
            this.jFP.closeLoadingDialog();
        }
        if (this.cAW != null) {
            this.cAW.ef(false);
        }
        d.cxk().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hDR = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void rQ(boolean z) {
        aHL();
    }

    private void aHL() {
        if (!isHidden() && !this.hDR) {
            cxa();
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
            this.jGC.nA(true);
        } else if (this.jGC.isScroll()) {
            this.jGC.nA(false);
        }
    }

    public void S(int i, boolean z) {
        if (this.jGB != null) {
            int firstVisiblePosition = this.jGB.getFirstVisiblePosition();
            int lastVisiblePosition = this.jGB.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jGB.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jGC != null) {
                    this.jGC.d((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cxn();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jGC != null) {
            S(this.jGC.i(imageFileInfo), z);
        }
    }

    public View cwX() {
        return this.jFX;
    }

    public void rO(boolean z) {
        if (this.jFP != null && this.jFX != null) {
            this.jFX.setText(this.jFP.getResources().getString(R.string.original_img));
            if (z) {
                this.jFX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.jFX, R.color.cp_link_tip_a);
                return;
            }
            this.jFX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.jFX, R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jFL = iVar;
    }
}
