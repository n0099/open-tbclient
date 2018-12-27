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
    private ImageView cqS;
    private View dad;
    private RelativeLayout drh;
    private TextView dwu;
    private boolean fVv;
    private c hUQ;
    private com.baidu.tbadk.album.f hVN;
    private TextView hVO;
    private com.baidu.tieba.write.view.a hVP;
    private TransparentHeadGridView hVQ;
    private h hVR;
    private View hVS;
    private i hVa;
    private AlbumActivity hVe;
    private View hVk;
    private TextView hVl;
    private TextView hVm;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d bif = null;
    private View.OnClickListener hVA = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hUQ != null) {
                int maxImagesAllowed = ImageListFragment.this.hUQ.getMaxImagesAllowed();
                if (ImageListFragment.this.hUQ.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hVe != null) {
                        ImageListFragment.this.hVe.b(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.hUQ != null) {
                if (ImageListFragment.this.hVa == null || !ImageListFragment.this.hVa.bOP()) {
                    if (view == ImageListFragment.this.dwu) {
                        ImageListFragment.this.hVP.setData(ImageListFragment.this.hUQ.bOB(), ImageListFragment.this.hUQ.bOz());
                        ImageListFragment.this.hVP.aN(ImageListFragment.this.dad);
                        ImageListFragment.this.dwu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hVk) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hVD = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bOJ() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hVE = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bOK() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.dwu != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(e.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.dwu.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hVB = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hUQ != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hUQ.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hVe.xn(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0342a hVT = new a.InterfaceC0342a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0342a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> xB;
            if (ImageListFragment.this.hUQ != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hUQ.bOz()) && (xB = ImageListFragment.this.hUQ.xB(albumId)) != null) {
                    ImageListFragment.this.hUQ.xz(albumId);
                    ImageListFragment.this.hVR.setData(xB);
                    ImageListFragment.this.dwu.setText(name);
                    ImageListFragment.this.hVQ.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hVC = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hVe == null || ImageListFragment.this.hUQ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hUQ.bOw()) {
                    ImageListFragment.this.hVe.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hUQ.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hVe.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hVe.c(imageFileInfo);
                }
                ImageListFragment.this.hUQ.a(null);
                ImageListFragment.this.hVR.notifyDataSetChanged();
                ImageListFragment.this.bOF();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hUQ.bOv()) {
                    ImageListFragment.this.hVe.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hUQ.b(videoFileInfo)) {
                        ImageListFragment.this.hUQ.a(null);
                    } else {
                        ImageListFragment.this.hUQ.a(videoFileInfo);
                    }
                    ImageListFragment.this.hUQ.bOx();
                    ImageListFragment.this.hVR.notifyDataSetChanged();
                    ImageListFragment.this.bOF();
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
        this.hVe = (AlbumActivity) getBaseFragmentActivity();
        this.hUQ = this.hVe.bOg();
        d.bOC().a(this);
        this.hVN = new com.baidu.tbadk.album.f(this.hVe);
        this.hVP = new com.baidu.tieba.write.view.a(this.hVe);
        this.hVP.setOnDismissListener(this.mOnDismissListener);
        this.hVP.a(this.hVT);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.drh = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.dad = this.mView.findViewById(e.g.layout_title);
        this.dwu = (TextView) this.mView.findViewById(e.g.album_title);
        this.cqS = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hVO = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hVS = this.mView.findViewById(e.g.navi_line);
        this.hVk = this.mView.findViewById(e.g.layout_bottom);
        this.hVm = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hVl = (TextView) this.mView.findViewById(e.g.next_step);
        this.hUQ.xz(com.baidu.tbadk.album.a.alN);
        this.dwu.setText(this.hVe.getPageContext().getString(e.j.album_all_media));
        if (this.hUQ.getWriteImagesInfo() != null) {
            this.hVm.setVisibility(this.hUQ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hVe.getPageContext().getPageActivity(), this.drh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.H(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hVQ = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hVQ.setSelector(e.d.transparent);
        this.hVR = new h(this.hVe, this.hUQ);
        this.hVR.oB(this.hVe.bOf() != 1);
        this.hVQ.setAdapter((ListAdapter) this.hVR);
        this.hVQ.setOuterOnScrollListener(this);
        this.hVR.a(this.hVC);
        this.hVR.a(this.hVB);
        this.hVR.Y(this.hVA);
        this.hVR.setOnOpenCameraFailedListener(this.hVE);
        this.hVR.setOnRequestPermissionListener(this.hVD);
        this.hVl.setOnClickListener(this.hVe);
        this.cqS.setOnClickListener(this.hVe);
        this.hVO.setOnClickListener(this.hVe);
        this.hVm.setOnClickListener(this.hVe);
        this.dwu.setOnClickListener(this.mOnClickListener);
        this.hVk.setOnClickListener(this.mOnClickListener);
        bOF();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bif == null) {
            this.bif = new com.baidu.tbadk.core.view.d(getPageContext());
        }
        this.bif.d(null);
        this.bif.ec(e.j.loading);
        this.bif.bA(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hVe.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOF() {
        int H;
        String string;
        if (this.hUQ != null && this.hVl != null) {
            if (this.hUQ.bOw()) {
                int i = this.hUQ.bOw() ? 1 : 0;
                H = i;
                string = this.hVe.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                H = v.H(this.hUQ.bOy());
                string = this.hVe.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hUQ.getMaxImagesAllowed())});
            }
            this.hVl.setText(string);
            this.hVl.setEnabled(H > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fVv = false;
        if (isShow()) {
            aaC();
        }
    }

    private void bOs() {
        if (this.hUQ == null && this.hVe != null) {
            this.hUQ = this.hVe.bOg();
        }
        if (this.hUQ != null) {
            if (!this.hUQ.OL()) {
                this.hVR.notifyDataSetChanged();
            } else {
                bOG();
            }
            oy(this.hUQ.isOriginalImg());
        }
    }

    private void bOG() {
        if (this.hVN == null) {
            this.hVN = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hVN.a(this.hVe.bOf() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.bif != null) {
                    ImageListFragment.this.bif.bA(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hUQ != null && gVar != null) {
                    ImageListFragment.this.hUQ.c(gVar);
                    String bOz = ImageListFragment.this.hUQ.bOz();
                    ImageListFragment.this.hUQ.xz(bOz);
                    ImageListFragment.this.hVR.setData(ImageListFragment.this.hUQ.xB(bOz));
                    ImageListFragment.this.hVQ.smoothScrollToPosition(0);
                    ImageListFragment.this.bOF();
                }
                ImageListFragment.this.hVQ.bON();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hVS, e.d.cp_bg_line_b, i);
        al.c(this.dwu, e.d.cp_cont_b, i);
        if (this.hVe.bOf() == 1) {
            al.b(this.cqS, e.f.icon_topbar_close_n, i);
            this.hVO.setVisibility(8);
        } else {
            al.h(this.hVO, e.d.navi_back_text_color);
            this.cqS.setVisibility(8);
        }
        if (this.dwu != null) {
            this.dwu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hVR != null) {
            this.hVR.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hUQ != null) {
            oy(this.hUQ.isOriginalImg());
        }
    }

    public View byu() {
        return this.hVe.bOf() == 1 ? this.cqS : this.hVO;
    }

    public View bOH() {
        return this.hVl;
    }

    public TbCameraView bOk() {
        if (this.hVR != null) {
            return this.hVR.bOD();
        }
        return null;
    }

    public TransparentHeadGridView bOI() {
        return this.hVQ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hVP != null) {
            this.hVP.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hVN != null) {
            this.hVN.wk();
        }
        if (this.hVe != null) {
            this.hVe.closeLoadingDialog();
        }
        if (this.bif != null) {
            this.bif.bA(false);
        }
        d.bOC().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fVv = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void oA(boolean z) {
        aaC();
    }

    private void aaC() {
        if (!isHidden() && !this.fVv) {
            bOs();
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
            this.hVR.kj(true);
        } else if (this.hVR.isScroll()) {
            this.hVR.kj(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hVQ != null) {
            int firstVisiblePosition = this.hVQ.getFirstVisiblePosition();
            int lastVisiblePosition = this.hVQ.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hVQ.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hVR != null) {
                    this.hVR.d((ImageView) childAt.findViewById(e.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bOF();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hVR != null) {
            H(this.hVR.g(imageFileInfo), z);
        }
    }

    public View bOp() {
        return this.hVm;
    }

    public void oy(boolean z) {
        if (this.hVe != null && this.hVm != null) {
            this.hVm.setText(this.hVe.getResources().getString(e.j.original_img));
            if (z) {
                this.hVm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hVm, e.d.cp_link_tip_a);
                return;
            }
            this.hVm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hVm, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hVa = iVar;
    }
}
