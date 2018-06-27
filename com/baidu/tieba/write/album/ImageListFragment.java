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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
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
    private RelativeLayout cPO;
    private TextView cVn;
    private View cyM;
    private boolean fuQ;
    private i hsC;
    private AlbumActivity hsG;
    private View hsM;
    private TextView hsN;
    private TextView hsO;
    private c hss;
    private com.baidu.tbadk.album.f htp;
    private ImageView htq;
    private TextView htr;
    private com.baidu.tieba.write.view.a hts;
    private TransparentHeadGridView htt;
    private h htu;
    private View htv;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a aVW = null;
    private View.OnClickListener htc = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hss != null) {
                int maxImagesAllowed = ImageListFragment.this.hss.getMaxImagesAllowed();
                if (ImageListFragment.this.hss.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hsG != null) {
                        ImageListFragment.this.hsG.b(ImageListFragment.this.getPageContext());
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
        public void onClick(View view) {
            if (ImageListFragment.this.hss != null) {
                if (ImageListFragment.this.hsC == null || !ImageListFragment.this.hsC.bHD()) {
                    if (view == ImageListFragment.this.cVn) {
                        ImageListFragment.this.hts.f(ImageListFragment.this.hss.bHp(), ImageListFragment.this.hss.bHn());
                        ImageListFragment.this.hts.ar(ImageListFragment.this.cyM);
                        ImageListFragment.this.cVn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hsM) {
                    }
                }
            }
        }
    };
    private TbCameraView.c htf = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bHx() {
            return !ac.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a htg = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bHy() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.cVn != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = am.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.cVn.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f htd = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hss != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hss.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hsG.vo(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0259a htw = new a.InterfaceC0259a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0259a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> vB;
            if (ImageListFragment.this.hss != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hss.bHn()) && (vB = ImageListFragment.this.hss.vB(albumId)) != null) {
                    ImageListFragment.this.hss.vz(albumId);
                    ImageListFragment.this.htu.setData(vB);
                    ImageListFragment.this.cVn.setText(name);
                    ImageListFragment.this.htt.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hte = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hsG == null || ImageListFragment.this.hss == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hss.bHk()) {
                    ImageListFragment.this.hsG.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hss.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hsG.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hsG.c(imageFileInfo);
                }
                ImageListFragment.this.hss.a(null);
                ImageListFragment.this.htu.notifyDataSetChanged();
                ImageListFragment.this.bHt();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hss.bHj()) {
                    ImageListFragment.this.hsG.showToast(d.k.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hss.b(videoFileInfo)) {
                        ImageListFragment.this.hss.a(null);
                    } else {
                        ImageListFragment.this.hss.a(videoFileInfo);
                    }
                    ImageListFragment.this.hss.bHl();
                    ImageListFragment.this.htu.notifyDataSetChanged();
                    ImageListFragment.this.bHt();
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
        this.hsG = (AlbumActivity) getBaseFragmentActivity();
        this.hss = this.hsG.bGU();
        d.bHq().a(this);
        this.htp = new com.baidu.tbadk.album.f(this.hsG);
        this.hts = new com.baidu.tieba.write.view.a(this.hsG);
        this.hts.setOnDismissListener(this.mOnDismissListener);
        this.hts.a(this.htw);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.i.album_image_list_view, (ViewGroup) null);
        this.cPO = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.cyM = this.mView.findViewById(d.g.layout_title);
        this.cVn = (TextView) this.mView.findViewById(d.g.album_title);
        this.htq = (ImageView) this.mView.findViewById(d.g.img_close);
        this.htr = (TextView) this.mView.findViewById(d.g.img_close_text);
        this.htv = this.mView.findViewById(d.g.navi_line);
        this.hsM = this.mView.findViewById(d.g.layout_bottom);
        this.hsO = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.hsN = (TextView) this.mView.findViewById(d.g.next_step);
        this.hss.vz(com.baidu.tbadk.album.a.aas);
        this.cVn.setText(this.hsG.getPageContext().getString(d.k.album_all_media));
        this.mNoDataView = NoDataViewFactory.a(this.hsG.getPageContext().getPageActivity(), this.cPO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.k.album_list_no_data, d.k.album_list_no_data_1), null);
        this.htt = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.htt.setSelector(d.C0142d.transparent);
        this.htu = new h(this.hsG, this.hss);
        this.htu.nH(this.hsG.bGT() != 1);
        this.htt.setAdapter((ListAdapter) this.htu);
        this.htt.setOuterOnScrollListener(this);
        this.htu.a(this.hte);
        this.htu.a(this.htd);
        this.htu.Z(this.htc);
        this.htu.setOnOpenCameraFailedListener(this.htg);
        this.htu.setOnRequestPermissionListener(this.htf);
        this.hsN.setOnClickListener(this.hsG);
        this.htq.setOnClickListener(this.hsG);
        this.htr.setOnClickListener(this.hsG);
        this.hsO.setOnClickListener(this.hsG);
        this.cVn.setOnClickListener(this.mOnClickListener);
        this.hsM.setOnClickListener(this.mOnClickListener);
        bHt();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aVW == null) {
            this.aVW = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.aVW.d(null);
        this.aVW.dd(d.k.loading);
        this.aVW.aO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hsG.showToast(d.k.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHt() {
        int z;
        String string;
        if (this.hss != null && this.hsN != null) {
            if (this.hss.bHk()) {
                int i = this.hss.bHk() ? 1 : 0;
                z = i;
                string = this.hsG.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                z = w.z(this.hss.bHm());
                string = this.hsG.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(z), Integer.valueOf(this.hss.getMaxImagesAllowed())});
            }
            this.hsN.setText(string);
            this.hsN.setEnabled(z > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fuQ = false;
        if (isShow()) {
            TE();
        }
    }

    private void bHg() {
        if (this.hss == null && this.hsG != null) {
            this.hss = this.hsG.bGU();
        }
        if (this.hss != null) {
            if (!this.hss.Kk()) {
                this.htu.notifyDataSetChanged();
            } else {
                bHu();
            }
            nE(this.hss.isOriginalImg());
        }
    }

    private void bHu() {
        if (this.htp == null) {
            this.htp = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.htp.a(this.hsG.bGT() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.aVW != null) {
                    ImageListFragment.this.aVW.aO(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hss != null && gVar != null) {
                    ImageListFragment.this.hss.c(gVar);
                    String bHn = ImageListFragment.this.hss.bHn();
                    ImageListFragment.this.hss.vz(bHn);
                    ImageListFragment.this.htu.setData(ImageListFragment.this.hss.vB(bHn));
                    ImageListFragment.this.htt.smoothScrollToPosition(0);
                    ImageListFragment.this.bHt();
                }
                ImageListFragment.this.htt.bHB();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.mView);
        am.e(this.htv, d.C0142d.cp_bg_line_b, i);
        am.c(this.cVn, d.C0142d.cp_cont_b, i);
        if (this.hsG.bGT() == 1) {
            am.b(this.htq, d.f.icon_topbar_close_n, i);
            this.htr.setVisibility(8);
        } else {
            am.h(this.htr, d.C0142d.navi_back_text_color);
            this.htq.setVisibility(8);
        }
        if (this.cVn != null) {
            this.cVn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_album_spread), (Drawable) null);
        }
        if (this.htu != null) {
            this.htu.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hss != null) {
            nE(this.hss.isOriginalImg());
        }
    }

    public View brU() {
        return this.hsG.bGT() == 1 ? this.htq : this.htr;
    }

    public View bHv() {
        return this.hsN;
    }

    public TbCameraView bGY() {
        if (this.htu != null) {
            return this.htu.bHr();
        }
        return null;
    }

    public TransparentHeadGridView bHw() {
        return this.htt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hts != null) {
            this.hts.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.htp != null) {
            this.htp.rW();
        }
        if (this.hsG != null) {
            this.hsG.closeLoadingDialog();
        }
        if (this.aVW != null) {
            this.aVW.aO(false);
        }
        d.bHq().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fuQ = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void nG(boolean z) {
        TE();
    }

    private void TE() {
        if (!isHidden() && !this.fuQ) {
            bHg();
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
            this.htu.js(true);
        } else if (this.htu.isScroll()) {
            this.htu.js(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.htt != null) {
            int firstVisiblePosition = this.htt.getFirstVisiblePosition();
            int lastVisiblePosition = this.htt.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.htt.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.htu != null) {
                    this.htu.d((ImageView) childAt.findViewById(d.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bHt();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.htu != null) {
            H(this.htu.g(imageFileInfo), z);
        }
    }

    public View bHd() {
        return this.hsO;
    }

    public void nE(boolean z) {
        if (this.hsG != null && this.hsO != null) {
            this.hsO.setText(this.hsG.getResources().getString(d.k.original_img));
            if (z) {
                this.hsO.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.hsO, d.C0142d.cp_link_tip_a);
                return;
            }
            this.hsO.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.hsO, d.C0142d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hsC = iVar;
    }
}
