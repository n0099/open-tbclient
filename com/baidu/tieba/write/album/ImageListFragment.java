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
import com.baidu.tbadk.core.util.ak;
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
    private RelativeLayout cHD;
    private View crj;
    private boolean few;
    private AlbumActivity hbA;
    private View hbG;
    private TextView hbH;
    private TextView hbI;
    private c hbn;
    private i hbw;
    private com.baidu.tbadk.album.f hcj;
    private ImageView hck;
    private TextView hcl;
    private com.baidu.tieba.write.view.a hcm;
    private TransparentHeadGridView hcn;
    private h hco;
    private View hcp;
    private NoDataView mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.a aNc = null;
    private View.OnClickListener hbW = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ImageListFragment.this.hbn != null) {
                int maxImagesAllowed = ImageListFragment.this.hbn.getMaxImagesAllowed();
                if (ImageListFragment.this.hbn.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hbA != null) {
                        ImageListFragment.this.hbA.b(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ImageListFragment.this.hbn != null) {
                if (ImageListFragment.this.hbw == null || !ImageListFragment.this.hbw.bBY()) {
                    if (view2 == ImageListFragment.this.mTitleText) {
                        ImageListFragment.this.hcm.f(ImageListFragment.this.hbn.bBK(), ImageListFragment.this.hbn.bBI());
                        ImageListFragment.this.hcm.ap(ImageListFragment.this.crj);
                        ImageListFragment.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view2 == ImageListFragment.this.hbG) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hbZ = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bBS() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hca = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bBT() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.mTitleText != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = ak.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hbX = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hbn != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hbn.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hbA.uP(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0240a hcq = new a.InterfaceC0240a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0240a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> uI;
            if (ImageListFragment.this.hbn != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hbn.bBI()) && (uI = ImageListFragment.this.hbn.uI(albumId)) != null) {
                    ImageListFragment.this.hbn.uG(albumId);
                    ImageListFragment.this.hco.setData(uI);
                    ImageListFragment.this.mTitleText.setText(name);
                    ImageListFragment.this.hcn.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hbY = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hbA == null || ImageListFragment.this.hbn == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hbn.bBF()) {
                    ImageListFragment.this.hbA.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hbn.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hbA.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hbA.c(imageFileInfo);
                }
                ImageListFragment.this.hbn.a(null);
                ImageListFragment.this.hco.notifyDataSetChanged();
                ImageListFragment.this.bBO();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hbn.bBE()) {
                    ImageListFragment.this.hbA.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hbn.b(videoFileInfo)) {
                        ImageListFragment.this.hbn.a(null);
                    } else {
                        ImageListFragment.this.hbn.a(videoFileInfo);
                    }
                    ImageListFragment.this.hbn.bBG();
                    ImageListFragment.this.hco.notifyDataSetChanged();
                    ImageListFragment.this.bBO();
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
        this.hbA = (AlbumActivity) getBaseFragmentActivity();
        this.hbn = this.hbA.bBp();
        d.bBL().a(this);
        this.hcj = new com.baidu.tbadk.album.f(this.hbA);
        this.hcm = new com.baidu.tieba.write.view.a(this.hbA);
        this.hcm.setOnDismissListener(this.mOnDismissListener);
        this.hcm.a(this.hcq);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.i.album_image_list_view, (ViewGroup) null);
        this.cHD = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.crj = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hck = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hcl = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hcp = this.mView.findViewById(d.g.navi_line);
        this.hbG = this.mView.findViewById(d.g.layout_bottom);
        this.hbI = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hbH = (TextView) this.mView.findViewById(d.g.next_step);
        this.hbn.uG(com.baidu.tbadk.album.a.Sj);
        this.mTitleText.setText(this.hbA.getPageContext().getString(d.k.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hbA.getPageContext().getPageActivity(), this.cHD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(d.k.album_list_no_data, d.k.album_list_no_data_1), null);
        this.hcn = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hcn.setSelector(d.C0126d.transparent);
        this.hco = new h(this.hbA, this.hbn);
        this.hco.nq(this.hbA.bBo() != 1);
        this.hcn.setAdapter((ListAdapter) this.hco);
        this.hcn.setOuterOnScrollListener(this);
        this.hco.a(this.hbY);
        this.hco.a(this.hbX);
        this.hco.V(this.hbW);
        this.hco.setOnOpenCameraFailedListener(this.hca);
        this.hco.setOnRequestPermissionListener(this.hbZ);
        this.hbH.setOnClickListener(this.hbA);
        this.hck.setOnClickListener(this.hbA);
        this.hcl.setOnClickListener(this.hbA);
        this.hbI.setOnClickListener(this.hbA);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hbG.setOnClickListener(this.mOnClickListener);
        bBO();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aNc == null) {
            this.aNc = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.aNc.d(null);
        this.aNc.da(d.k.loading);
        this.aNc.aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hbA.showToast(d.k.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBO() {
        int v;
        String string;
        if (this.hbn != null && this.hbH != null) {
            if (this.hbn.bBF()) {
                int i = this.hbn.bBF() ? 1 : 0;
                v = i;
                string = this.hbA.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                v = v.v(this.hbn.bBH());
                string = this.hbA.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hbn.getMaxImagesAllowed())});
            }
            this.hbH.setText(string);
            this.hbH.setEnabled(v > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.few = false;
        if (isShow()) {
            PP();
        }
    }

    private void bBB() {
        if (this.hbn == null && this.hbA != null) {
            this.hbn = this.hbA.bBp();
        }
        if (this.hbn != null) {
            if (!this.hbn.Gm()) {
                this.hco.notifyDataSetChanged();
            } else {
                bBP();
            }
            nn(this.hbn.isOriginalImg());
        }
    }

    private void bBP() {
        if (this.hcj == null) {
            this.hcj = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hcj.a(this.hbA.bBo() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.aNc != null) {
                    ImageListFragment.this.aNc.aI(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hbn != null && gVar != null) {
                    ImageListFragment.this.hbn.c(gVar);
                    String bBI = ImageListFragment.this.hbn.bBI();
                    ImageListFragment.this.hbn.uG(bBI);
                    ImageListFragment.this.hco.setData(ImageListFragment.this.hbn.uI(bBI));
                    ImageListFragment.this.hcn.smoothScrollToPosition(0);
                    ImageListFragment.this.bBO();
                }
                ImageListFragment.this.hcn.bBW();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        ak.e(this.hcp, d.C0126d.cp_bg_line_b, i);
        ak.c(this.mTitleText, d.C0126d.cp_cont_b, i);
        if (this.hbA.bBo() == 1) {
            ak.b(this.hck, d.f.icon_topbar_close_n, i);
            this.hcl.setVisibility(8);
        } else {
            ak.h(this.hcl, d.C0126d.navi_back_text_color);
            this.hck.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hco != null) {
            this.hco.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hbn != null) {
            nn(this.hbn.isOriginalImg());
        }
    }

    public View bmv() {
        return this.hbA.bBo() == 1 ? this.hck : this.hcl;
    }

    public View bBQ() {
        return this.hbH;
    }

    public TbCameraView bBt() {
        if (this.hco != null) {
            return this.hco.bBM();
        }
        return null;
    }

    public TransparentHeadGridView bBR() {
        return this.hcn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hcm != null) {
            this.hcm.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hcj != null) {
            this.hcj.oC();
        }
        if (this.hbA != null) {
            this.hbA.closeLoadingDialog();
        }
        if (this.aNc != null) {
            this.aNc.aI(false);
        }
        d.bBL().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.few = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void np(boolean z) {
        PP();
    }

    private void PP() {
        if (!isHidden() && !this.few) {
            bBB();
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
            this.hco.jc(true);
        } else if (this.hco.isScroll()) {
            this.hco.jc(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hcn != null) {
            int firstVisiblePosition = this.hcn.getFirstVisiblePosition();
            int lastVisiblePosition = this.hcn.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hcn.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hco != null) {
                    this.hco.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bBO();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hco != null) {
            H(this.hco.g(imageFileInfo), z);
        }
    }

    public View bBy() {
        return this.hbI;
    }

    public void nn(boolean z) {
        if (this.hbA != null && this.hbI != null) {
            this.hbI.setText(this.hbA.getResources().getString(d.k.original_img));
            if (z) {
                this.hbI.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.hbI, d.C0126d.cp_link_tip_a);
                return;
            }
            this.hbI.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.hbI, d.C0126d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hbw = iVar;
    }
}
