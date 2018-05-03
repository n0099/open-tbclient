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
    private RelativeLayout cHA;
    private View crg;
    private boolean fet;
    private View hbD;
    private TextView hbE;
    private TextView hbF;
    private c hbk;
    private i hbt;
    private AlbumActivity hbx;
    private com.baidu.tbadk.album.f hcg;
    private ImageView hch;
    private TextView hci;
    private com.baidu.tieba.write.view.a hcj;
    private TransparentHeadGridView hck;
    private h hcl;
    private View hcm;
    private NoDataView mNoDataView;
    private TextView mTitleText;
    private View mView;
    private com.baidu.tbadk.core.view.a aNc = null;
    private View.OnClickListener hbT = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ImageListFragment.this.hbk != null) {
                int maxImagesAllowed = ImageListFragment.this.hbk.getMaxImagesAllowed();
                if (ImageListFragment.this.hbk.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hbx != null) {
                        ImageListFragment.this.hbx.b(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.hbk != null) {
                if (ImageListFragment.this.hbt == null || !ImageListFragment.this.hbt.bBY()) {
                    if (view2 == ImageListFragment.this.mTitleText) {
                        ImageListFragment.this.hcj.f(ImageListFragment.this.hbk.bBK(), ImageListFragment.this.hbk.bBI());
                        ImageListFragment.this.hcj.ap(ImageListFragment.this.crg);
                        ImageListFragment.this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view2 == ImageListFragment.this.hbD) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hbW = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bBS() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hbX = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
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
    private f hbU = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hbk != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hbk.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hbx.uO(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0240a hcn = new a.InterfaceC0240a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0240a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> uI;
            if (ImageListFragment.this.hbk != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hbk.bBI()) && (uI = ImageListFragment.this.hbk.uI(albumId)) != null) {
                    ImageListFragment.this.hbk.uG(albumId);
                    ImageListFragment.this.hcl.setData(uI);
                    ImageListFragment.this.mTitleText.setText(name);
                    ImageListFragment.this.hck.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hbV = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hbx == null || ImageListFragment.this.hbk == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hbk.bBF()) {
                    ImageListFragment.this.hbx.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hbk.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hbx.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hbx.c(imageFileInfo);
                }
                ImageListFragment.this.hbk.a(null);
                ImageListFragment.this.hcl.notifyDataSetChanged();
                ImageListFragment.this.bBO();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hbk.bBE()) {
                    ImageListFragment.this.hbx.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hbk.b(videoFileInfo)) {
                        ImageListFragment.this.hbk.a(null);
                    } else {
                        ImageListFragment.this.hbk.a(videoFileInfo);
                    }
                    ImageListFragment.this.hbk.bBG();
                    ImageListFragment.this.hcl.notifyDataSetChanged();
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
        this.hbx = (AlbumActivity) getBaseFragmentActivity();
        this.hbk = this.hbx.bBp();
        d.bBL().a(this);
        this.hcg = new com.baidu.tbadk.album.f(this.hbx);
        this.hcj = new com.baidu.tieba.write.view.a(this.hbx);
        this.hcj.setOnDismissListener(this.mOnDismissListener);
        this.hcj.a(this.hcn);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.i.album_image_list_view, (ViewGroup) null);
        this.cHA = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.crg = this.mView.findViewById(d.g.layout_title);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.hch = (ImageView) this.mView.findViewById(d.g.img_close);
        this.hci = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.hcm = this.mView.findViewById(d.g.navi_line);
        this.hbD = this.mView.findViewById(d.g.layout_bottom);
        this.hbF = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hbE = (TextView) this.mView.findViewById(d.g.next_step);
        this.hbk.uG(com.baidu.tbadk.album.a.Sj);
        this.mTitleText.setText(this.hbx.getPageContext().getString(d.k.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hbx.getPageContext().getPageActivity(), this.cHA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(d.k.album_list_no_data, d.k.album_list_no_data_1), null);
        this.hck = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.hck.setSelector(d.C0126d.transparent);
        this.hcl = new h(this.hbx, this.hbk);
        this.hcl.nq(this.hbx.bBo() != 1);
        this.hck.setAdapter((ListAdapter) this.hcl);
        this.hck.setOuterOnScrollListener(this);
        this.hcl.a(this.hbV);
        this.hcl.a(this.hbU);
        this.hcl.V(this.hbT);
        this.hcl.setOnOpenCameraFailedListener(this.hbX);
        this.hcl.setOnRequestPermissionListener(this.hbW);
        this.hbE.setOnClickListener(this.hbx);
        this.hch.setOnClickListener(this.hbx);
        this.hci.setOnClickListener(this.hbx);
        this.hbF.setOnClickListener(this.hbx);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.hbD.setOnClickListener(this.mOnClickListener);
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
        this.aNc.cZ(d.k.loading);
        this.aNc.aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hbx.showToast(d.k.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBO() {
        int v;
        String string;
        if (this.hbk != null && this.hbE != null) {
            if (this.hbk.bBF()) {
                int i = this.hbk.bBF() ? 1 : 0;
                v = i;
                string = this.hbx.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                v = v.v(this.hbk.bBH());
                string = this.hbx.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hbk.getMaxImagesAllowed())});
            }
            this.hbE.setText(string);
            this.hbE.setEnabled(v > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fet = false;
        if (isShow()) {
            PP();
        }
    }

    private void bBB() {
        if (this.hbk == null && this.hbx != null) {
            this.hbk = this.hbx.bBp();
        }
        if (this.hbk != null) {
            if (!this.hbk.Gm()) {
                this.hcl.notifyDataSetChanged();
            } else {
                bBP();
            }
            nn(this.hbk.isOriginalImg());
        }
    }

    private void bBP() {
        if (this.hcg == null) {
            this.hcg = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hcg.a(this.hbx.bBo() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.hbk != null && gVar != null) {
                    ImageListFragment.this.hbk.c(gVar);
                    String bBI = ImageListFragment.this.hbk.bBI();
                    ImageListFragment.this.hbk.uG(bBI);
                    ImageListFragment.this.hcl.setData(ImageListFragment.this.hbk.uI(bBI));
                    ImageListFragment.this.hck.smoothScrollToPosition(0);
                    ImageListFragment.this.bBO();
                }
                ImageListFragment.this.hck.bBW();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        ak.e(this.hcm, d.C0126d.cp_bg_line_b, i);
        ak.c(this.mTitleText, d.C0126d.cp_cont_b, i);
        if (this.hbx.bBo() == 1) {
            ak.b(this.hch, d.f.icon_topbar_close_n, i);
            this.hci.setVisibility(8);
        } else {
            ak.h(this.hci, d.C0126d.navi_back_text_color);
            this.hch.setVisibility(8);
        }
        if (this.mTitleText != null) {
            this.mTitleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.hcl != null) {
            this.hcl.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hbk != null) {
            nn(this.hbk.isOriginalImg());
        }
    }

    public View bmv() {
        return this.hbx.bBo() == 1 ? this.hch : this.hci;
    }

    public View bBQ() {
        return this.hbE;
    }

    public TbCameraView bBt() {
        if (this.hcl != null) {
            return this.hcl.bBM();
        }
        return null;
    }

    public TransparentHeadGridView bBR() {
        return this.hck;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hcj != null) {
            this.hcj.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hcg != null) {
            this.hcg.oC();
        }
        if (this.hbx != null) {
            this.hbx.closeLoadingDialog();
        }
        if (this.aNc != null) {
            this.aNc.aI(false);
        }
        d.bBL().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fet = true;
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
        if (!isHidden() && !this.fet) {
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
            this.hcl.jc(true);
        } else if (this.hcl.isScroll()) {
            this.hcl.jc(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hck != null) {
            int firstVisiblePosition = this.hck.getFirstVisiblePosition();
            int lastVisiblePosition = this.hck.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hck.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hcl != null) {
                    this.hcl.d((ImageView) childAt.findViewById(d.g.select_icon), z);
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
        if (imageFileInfo != null && this.hcl != null) {
            H(this.hcl.g(imageFileInfo), z);
        }
    }

    public View bBy() {
        return this.hbF;
    }

    public void nn(boolean z) {
        if (this.hbx != null && this.hbF != null) {
            this.hbF.setText(this.hbx.getResources().getString(d.k.original_img));
            if (z) {
                this.hbF.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.hbF, d.C0126d.cp_link_tip_a);
                return;
            }
            this.hbF.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.hbF, d.C0126d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hbt = iVar;
    }
}
