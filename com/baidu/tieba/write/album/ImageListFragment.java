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
import com.baidu.tbadk.core.util.am;
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
    private ImageView dUj;
    private View eFf;
    private RelativeLayout evb;
    private TextView ffR;
    private boolean hKY;
    private c jNO;
    private i jNY;
    private com.baidu.tbadk.album.f jOL;
    private TextView jOM;
    private com.baidu.tieba.write.view.a jON;
    private TransparentHeadGridView jOO;
    private h jOP;
    private View jOQ;
    private AlbumActivity jOc;
    private View jOi;
    private TextView jOj;
    private TextView jOk;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cCv = null;
    private View.OnClickListener jOy = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jNO != null) {
                int maxImagesAllowed = ImageListFragment.this.jNO.getMaxImagesAllowed();
                if (ImageListFragment.this.jNO.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jOc != null) {
                        ImageListFragment.this.jOc.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jNO != null) {
                if (ImageListFragment.this.jNY == null || !ImageListFragment.this.jNY.cAR()) {
                    if (view == ImageListFragment.this.ffR) {
                        ImageListFragment.this.jON.b(ImageListFragment.this.jNO.cAE(), ImageListFragment.this.jNO.cAC());
                        ImageListFragment.this.jON.bo(ImageListFragment.this.eFf);
                        ImageListFragment.this.ffR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.jOi) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jOB = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aZn() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jOC = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cAM() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.ffR != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = am.getDrawable(R.drawable.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.ffR.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f jOz = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jNO != null && ImageListFragment.this.jNO.getWriteImagesInfo() != null && ImageListFragment.this.jNO.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jOc.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jNO != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jNO.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jOc.CS(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0439a jOR = new a.InterfaceC0439a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0439a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> GI;
            if (ImageListFragment.this.jNO != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jNO.cAC()) && (GI = ImageListFragment.this.jNO.GI(albumId)) != null) {
                    ImageListFragment.this.jNO.GG(albumId);
                    ImageListFragment.this.jOP.setData(GI);
                    ImageListFragment.this.ffR.setText(name);
                    ImageListFragment.this.jOO.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jOA = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jOc == null || ImageListFragment.this.jNO == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jNO.cAz()) {
                    ImageListFragment.this.jOc.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jNO.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jOc.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jOc.e(imageFileInfo);
                }
                ImageListFragment.this.jNO.a(null);
                ImageListFragment.this.jOP.notifyDataSetChanged();
                ImageListFragment.this.cAI();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jNO.cAy()) {
                    ImageListFragment.this.jOc.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jNO.b(videoFileInfo)) {
                        ImageListFragment.this.jNO.a(null);
                    } else {
                        ImageListFragment.this.jNO.a(videoFileInfo);
                    }
                    ImageListFragment.this.jNO.cAA();
                    ImageListFragment.this.jOP.notifyDataSetChanged();
                    ImageListFragment.this.cAI();
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
        this.jOc = (AlbumActivity) getBaseFragmentActivity();
        this.jNO = this.jOc.cAk();
        d.cAF().a(this);
        this.jOL = new com.baidu.tbadk.album.f(this.jOc);
        this.jON = new com.baidu.tieba.write.view.a(this.jOc);
        this.jON.setOnDismissListener(this.mOnDismissListener);
        this.jON.a(this.jOR);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.evb = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.eFf = this.mView.findViewById(R.id.layout_title);
        this.ffR = (TextView) this.mView.findViewById(R.id.album_title);
        this.dUj = (ImageView) this.mView.findViewById(R.id.img_close);
        this.jOM = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.jOQ = this.mView.findViewById(R.id.navi_line);
        this.jOi = this.mView.findViewById(R.id.layout_bottom);
        this.jOk = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.jOj = (TextView) this.mView.findViewById(R.id.next_step);
        this.jNO.GG(com.baidu.tbadk.album.a.bAS);
        this.ffR.setText(this.jOc.getPageContext().getString(R.string.album_all_media));
        if (this.jNO.getWriteImagesInfo() != null) {
            this.jOk.setVisibility(this.jNO.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jNO.getWriteImagesInfo() != null && this.jNO.getWriteImagesInfo().isFromQRCode()) {
            this.jOi.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jOc.getPageContext().getPageActivity(), this.evb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ag(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jOO = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jOO.setSelector(R.color.transparent);
        this.jOP = new h(this.jOc, this.jNO);
        if (this.jNO.getWriteImagesInfo() != null && this.jNO.getWriteImagesInfo().isFromQRCode()) {
            this.jOP.si(false);
        } else {
            this.jOP.si(this.jOc.cAj() != 1);
        }
        this.jOO.setAdapter((ListAdapter) this.jOP);
        this.jOO.setOuterOnScrollListener(this);
        this.jOP.a(this.jOA);
        this.jOP.a(this.jOz);
        this.jOP.ad(this.jOy);
        this.jOP.setOnOpenCameraFailedListener(this.jOC);
        this.jOP.setOnRequestPermissionListener(this.jOB);
        this.jOj.setOnClickListener(this.jOc);
        this.dUj.setOnClickListener(this.jOc);
        this.jOM.setOnClickListener(this.jOc);
        this.jOk.setOnClickListener(this.jOc);
        this.ffR.setOnClickListener(this.mOnClickListener);
        this.jOi.setOnClickListener(this.mOnClickListener);
        cAI();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cCv == null) {
            this.cCv = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cCv.e(null);
        this.cCv.iz(R.string.loading);
        this.cCv.ej(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jOc.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAI() {
        int Z;
        String string;
        if (this.jNO != null && this.jOj != null) {
            if (this.jNO.cAz()) {
                int i = this.jNO.cAz() ? 1 : 0;
                Z = i;
                string = this.jOc.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                Z = v.Z(this.jNO.cAB());
                string = this.jOc.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jNO.getMaxImagesAllowed())});
            }
            this.jOj.setText(string);
            this.jOj.setEnabled(Z > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.hKY = false;
        if (isShow()) {
            aJk();
        }
    }

    private void cAv() {
        if (this.jNO == null && this.jOc != null) {
            this.jNO = this.jOc.cAk();
        }
        if (this.jNO != null) {
            if (!this.jNO.auT()) {
                this.jOP.notifyDataSetChanged();
            } else {
                cAJ();
            }
            sf(this.jNO.isOriginalImg());
        }
    }

    private void cAJ() {
        if (this.jOL == null) {
            this.jOL = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jOL.a(this.jOc.cAj() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cCv != null) {
                    ImageListFragment.this.cCv.ej(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jNO != null && gVar != null) {
                    ImageListFragment.this.jNO.c(gVar);
                    String cAC = ImageListFragment.this.jNO.cAC();
                    ImageListFragment.this.jNO.GG(cAC);
                    ImageListFragment.this.jOP.setData(ImageListFragment.this.jNO.GI(cAC));
                    ImageListFragment.this.jOO.smoothScrollToPosition(0);
                    ImageListFragment.this.cAI();
                }
                ImageListFragment.this.jOO.cAP();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        am.h(this.jOQ, R.color.cp_bg_line_b, i);
        am.f(this.ffR, R.color.cp_cont_b, i);
        if (this.jOc.cAj() == 1) {
            am.b(this.dUj, (int) R.drawable.icon_topbar_close_n, i);
            this.jOM.setVisibility(8);
        } else {
            am.j(this.jOM, R.color.navi_back_text_color);
            this.dUj.setVisibility(8);
        }
        if (this.ffR != null) {
            this.ffR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
        }
        if (this.jOP != null) {
            this.jOP.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jNO != null) {
            sf(this.jNO.isOriginalImg());
        }
    }

    public View clg() {
        return this.jOc.cAj() == 1 ? this.dUj : this.jOM;
    }

    public View cAK() {
        return this.jOj;
    }

    public TbCameraView cAn() {
        if (this.jOP != null) {
            return this.jOP.cAG();
        }
        return null;
    }

    public TransparentHeadGridView cAL() {
        return this.jOO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jON != null) {
            this.jON.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jOL != null) {
            this.jOL.aav();
        }
        if (this.jOc != null) {
            this.jOc.closeLoadingDialog();
        }
        if (this.cCv != null) {
            this.cCv.ej(false);
        }
        d.cAF().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hKY = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void sh(boolean z) {
        aJk();
    }

    private void aJk() {
        if (!isHidden() && !this.hKY) {
            cAv();
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
            this.jOP.nP(true);
        } else if (this.jOP.isScroll()) {
            this.jOP.nP(false);
        }
    }

    public void U(int i, boolean z) {
        if (this.jOO != null) {
            int firstVisiblePosition = this.jOO.getFirstVisiblePosition();
            int lastVisiblePosition = this.jOO.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jOO.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jOP != null) {
                    this.jOP.d((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        cAI();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jOP != null) {
            U(this.jOP.i(imageFileInfo), z);
        }
    }

    public View cAs() {
        return this.jOk;
    }

    public void sf(boolean z) {
        if (this.jOc != null && this.jOk != null) {
            this.jOk.setText(this.jOc.getResources().getString(R.string.original_img));
            if (z) {
                this.jOk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.jOk, R.color.cp_link_tip_a);
                return;
            }
            this.jOk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.jOk, R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jNY = iVar;
    }
}
