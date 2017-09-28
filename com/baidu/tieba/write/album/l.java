package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.TransparentHeadGridView;
import com.baidu.tieba.write.album.f;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends BaseFragment implements AbsListView.OnScrollListener, f.a {
    private View bMQ;
    private RelativeLayout ccT;
    private com.baidu.tbadk.b.b cjq;
    private boolean eBx;
    private AlbumActivity gGN;
    private TextView gGV;
    private TextView gGW;
    private View gGX;
    private e gGy;
    private View gHA;
    private View gHB;
    private View gHC;
    private View gHD;
    private Animation gHE;
    private Animation gHF;
    private View gHG;
    private View gHI;
    private View gHJ;
    private com.baidu.tieba.write.view.a gHs;
    private TransparentHeadGridView gHt;
    private k gHu;
    private View gHv;
    private View gHx;
    private View gHy;
    private View gHz;
    private ImageView gcx;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private int mScreenWidth;
    private TextView mTitleText;
    private View mView;
    private TbCameraView gHw = null;
    private int gHH = 0;
    private String aiq = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gHK = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gGy.getMaxImagesAllowed();
            if (l.this.gGy.size() < maxImagesAllowed) {
                l.this.gHt.bzP();
                l.this.bMQ.setVisibility(8);
                l.this.gHB.setAlpha(1.0f);
                l.this.gHG.setVisibility(8);
                l.this.gHG.setAlpha(1.0f);
                l.this.gHJ.setVisibility(8);
                l.this.gHJ.setAlpha(1.0f);
                l.this.gGX.setVisibility(8);
                return;
            }
            l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (view.getId() == l.this.mTitleText.getId()) {
                l.this.gHs.d(l.this.gGy.bzC(), l.this.gGy.bzA());
                l.this.gHs.ap(l.this.bMQ);
                if (l.this.gHH <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gHy.getId()) {
                if (view.getId() == l.this.gHz.getId()) {
                    int maxImagesAllowed = l.this.gGy.getMaxImagesAllowed();
                    if (l.this.gGy.size() < maxImagesAllowed || l.this.gGN.bzk()) {
                        l.this.gGy.tb(String.valueOf(System.currentTimeMillis()));
                        l.this.gGN.ix(l.this.gGy.bzE());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gHA.getId()) {
                    if (l.this.gHw != null) {
                        l.this.gHw.bpf();
                    }
                } else if (view.getId() != l.this.gHD.getId()) {
                    if (view.getId() == l.this.gHC.getId()) {
                        if (l.this.gHw != null) {
                            l.this.gHw.bph();
                            return;
                        }
                        return;
                    }
                    if (view == l.this.gGX) {
                    }
                } else {
                    l.this.bzH();
                }
            } else {
                l.this.nt(true);
                l.this.bpe();
            }
        }
    };
    private TbCameraView.c gHL = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean boX() {
            return !ab.d(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gHM = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void boY() {
            if (l.this.gGN != null) {
                l.this.gGN.showToast(l.this.gGN.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gHN = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void cd(int i, int i2) {
            int i3;
            int i4;
            if (i != 0 && i2 != 0) {
                if ((i2 * 1.0f) / i >= 0.75f) {
                    i3 = (int) (l.this.mScreenWidth * 1.3333334f * ((i2 * 1.0f) / i));
                    i4 = (int) (l.this.mScreenWidth * 1.3333334f);
                } else {
                    i3 = l.this.mScreenWidth;
                    i4 = (int) (l.this.mScreenWidth * ((i * 1.0f) / i2));
                }
                ViewGroup.LayoutParams layoutParams = l.this.gHw.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gHw.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gHO = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gHH <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gHP = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bpa() {
            l.this.nt(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bpb() {
            if (l.this.gGN != null) {
                l.this.gGN.bpb();
            }
            l.this.bpe();
            if (l.this.gGN != null) {
                l.this.gGN.bzh();
            }
        }
    };
    private TransparentHeadGridView.b gHQ = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void uT(int i) {
            l.this.bMQ.setAlpha(1.0f - (i / 100.0f));
            l.this.gHB.setAlpha(i / 100.0f);
            l.this.gHG.setAlpha(1.0f - (i / 100.0f));
            l.this.gHJ.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void boN() {
            l.this.bMQ.setVisibility(8);
            l.this.gHB.setAlpha(1.0f);
            l.this.gHG.setVisibility(8);
            l.this.gHG.setAlpha(1.0f);
            l.this.gHJ.setVisibility(8);
            l.this.gHJ.setAlpha(1.0f);
            l.this.gGX.setVisibility(8);
        }
    };
    private Animation.AnimationListener gHR = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gHB.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gHS = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void uS(int i) {
            l.this.gHH = i;
            if (i <= 50) {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
                l.this.gcx.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bMQ.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable2, null);
                l.this.gcx.setImageResource(d.g.icon_topbar_close_n);
                l.this.bMQ.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gHv.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gHm = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gGy.setCurrentIndex(i);
            l.this.gGN.uM(1);
        }
    };
    private a.InterfaceC0142a gHT = new a.InterfaceC0142a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0142a
        public void a(int i, com.baidu.tbadk.b.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gGy.bzA())) {
                List<ImageFileInfo> bzD = l.this.gGy.bzD();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bzD) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bzD = arrayList;
                }
                l.this.gGy.dE(bzD);
                l.this.gGy.ta(albumId);
                l.this.setData(bzD);
                l.this.mTitleText.setText(name);
                l.this.gHt.smoothScrollToPosition(0);
            }
        }
    };
    private j gHn = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean e;
            if (z) {
                l.this.gGV.setText(l.this.gGN.getResources().getText(d.l.next_step));
                e = l.this.gGN.d(imageFileInfo);
                if (l.this.gGy.isOriginalImg()) {
                    l.this.gGN.bzi();
                }
            } else {
                e = l.this.gGN.e(imageFileInfo);
            }
            l.this.bzI();
            return e;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gGN = (AlbumActivity) getBaseFragmentActivity();
        this.gGy = this.gGN.bzj();
        f.bzG().a(this);
        this.cjq = new com.baidu.tbadk.b.b(this.gGN.getPageContext().getPageActivity());
        this.gHs = new com.baidu.tieba.write.view.a(this.gGN);
        this.gHs.setOnDismissListener(this.gHO);
        this.gGy.ta("-1");
        if (getActivity().getIntent() != null) {
            this.aiq = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.ccT = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.gcx = (ImageView) this.mView.findViewById(d.h.img_close);
        this.gcx.setOnClickListener(this.gGN);
        this.gGV = (TextView) this.mView.findViewById(d.h.next_step);
        this.gGV.setOnClickListener(this.gGN);
        this.mTitleText = (TextView) this.mView.findViewById(d.h.album_title);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.gHt = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gHu = new k(this.gGN, this.gGy);
        this.gHt.setAdapter((ListAdapter) this.gHu);
        this.gHt.setOuterOnScrollListener(this);
        this.gHt.setSelector(d.e.transparent);
        this.gHt.setOnHeadDisplayChangeListener(this.gHS);
        this.gHt.setOnPullChangeListener(this.gHQ);
        this.gHs.a(this.gHT);
        this.gHu.a(this.gHn);
        this.gHu.a(this.gHm);
        this.gHu.h(this.gHK);
        this.mNoDataView = NoDataViewFactory.a(this.gGN.getPageContext().getPageActivity(), this.ccT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bMQ = this.mView.findViewById(d.h.layout_title);
        this.gHv = this.mView.findViewById(d.h.top_bar_background);
        this.gHv.setAlpha(0.0f);
        this.gHw = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gHw.setOnGotPictureListener(this.gHP);
        this.gHw.setOnPreviewSizeChangedListener(this.gHN);
        this.gHx = this.mView.findViewById(d.h.camera_view_container);
        this.gHy = this.mView.findViewById(d.h.img_pic_cancel);
        this.gHy.setOnClickListener(this.mOnClickListener);
        this.gHz = this.mView.findViewById(d.h.img_take_picture);
        this.gHz.setOnClickListener(this.mOnClickListener);
        this.gHA = this.mView.findViewById(d.h.img_pic_save);
        this.gHA.setOnClickListener(this.mOnClickListener);
        this.gHB = this.mView.findViewById(d.h.camera_bar);
        this.gHB.setAlpha(0.0f);
        this.gHC = this.mView.findViewById(d.h.btn_camera_switch);
        this.gHC.setOnClickListener(this.mOnClickListener);
        this.gHD = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gHD.setOnClickListener(this.mOnClickListener);
        this.gHE = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gHF = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gHF.setAnimationListener(this.gHR);
        this.gHt.setBottomMoveView(this.gHx);
        this.gHI = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.l.ad(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gHI.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gHI.setLayoutParams(layoutParams);
        this.gHu.uQ((this.mScreenWidth - com.baidu.adp.lib.util.l.f(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gHG = this.mView.findViewById(d.h.icon_camera);
        uR((int) (com.baidu.adp.lib.util.l.af(this.gGN.getPageContext().getPageActivity()) * 0.28f));
        this.gHJ = this.mView.findViewById(d.h.view_camera_cover);
        this.gHw.setOnRequestPermissionListener(this.gHL);
        bzI();
        this.gHw.setOnOpenCameraFailedListener(this.gHM);
        nt(true);
        this.gGW = (TextView) this.mView.findViewById(d.h.original_select_btn);
        this.gGW.setOnClickListener(this.gGN);
        this.gGX = this.mView.findViewById(d.h.layout_bottom);
        this.gGX.setOnClickListener(this.mOnClickListener);
        return this.mView;
    }

    public void bpe() {
        if (this.gHw != null) {
            this.gHw.bzM();
            this.gHw.bpe();
        }
    }

    public void bzH() {
        this.gHt.bzO();
        this.bMQ.setVisibility(0);
        this.bMQ.setAlpha(1.0f);
        this.bMQ.startAnimation(this.gHE);
        this.gHB.startAnimation(this.gHF);
        this.gHG.setVisibility(0);
        this.gHG.startAnimation(this.gHE);
        this.gHJ.setVisibility(0);
        this.gGX.setVisibility(0);
    }

    public void nt(boolean z) {
        if (z) {
            this.gHy.setVisibility(4);
            this.gHz.setVisibility(0);
            this.gHA.setVisibility(4);
            this.gHD.setVisibility(0);
            this.gHC.setVisibility(0);
            return;
        }
        this.gHy.setVisibility(0);
        this.gHz.setVisibility(4);
        this.gHA.setVisibility(0);
        this.gHD.setVisibility(8);
        this.gHC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzI() {
        if (this.gGy.getWriteImagesInfo() != null && this.gGy.getWriteImagesInfo().getChosedFiles() != null) {
            int t = v.t(this.gGy.getWriteImagesInfo().getChosedFiles());
            this.gGV.setText(this.gGN.getResources().getText(d.l.next_step));
            this.gGV.setEnabled(t > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eBx = false;
        if (isShow()) {
            NI();
        }
    }

    private void bzx() {
        if (this.gGy == null && this.gGN != null) {
            this.gGy = this.gGN.bzj();
        }
        if (this.gGy != null) {
            if (this.gGy.bzD() != null) {
                this.gHu.notifyDataSetChanged();
                return;
            }
            tc("-1");
            if (this.gGy.isOriginalImg()) {
                np(this.gGy.isOriginalImg());
            }
        }
    }

    private void tc(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cjq.a(str, new com.baidu.tbadk.b.d() { // from class: com.baidu.tieba.write.album.l.6
                @Override // com.baidu.tbadk.b.d
                public void onPreLoad() {
                }

                @Override // com.baidu.tbadk.b.d
                public void a(List<com.baidu.tbadk.b.a> list, List<ImageFileInfo> list2, String str2) {
                    ArrayList arrayList = new ArrayList();
                    if (!v.u(list2)) {
                        arrayList.addAll(list2);
                    }
                    if (!str.equals("-1")) {
                        l.this.mTitleText.setText(str2);
                        l.this.bzJ();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!v.u(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a();
                        aVar.bW("-1");
                        String string = l.this.gGN.getPageContext().getString(d.l.album_all);
                        aVar.setName(string);
                        aVar.bX(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.mTitleText.setText(string);
                        l.this.gGy.dF(arrayList2);
                        l.this.gGy.dG(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzJ() {
        this.cjq.a(new com.baidu.tbadk.b.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.b.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.b.c
            public void m(List<com.baidu.tbadk.b.a> list) {
                l.this.gGy.dF(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gHu != null) {
                this.gGy.dE(list);
                this.gHu.setData(this.gGy.bzF());
            }
            bzI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gGN.getLayoutMode().ai(i == 1);
        this.gGN.getLayoutMode().t(this.mView);
        if (this.gHu != null) {
            this.gHu.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View biX() {
        return this.gcx;
    }

    public View bzK() {
        return this.gGV;
    }

    public TbCameraView bzn() {
        return this.gHw;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cjq != null) {
            this.cjq.nD();
        }
        f.bzG().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eBx = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void ns(boolean z) {
        NI();
    }

    private void NI() {
        if (!isHidden() && !this.eBx) {
            bzx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        super.onScroll(absListView, i, i2, i3);
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            uR(childAt.getHeight() + iArr[1]);
        }
    }

    private void uR(int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (i >= 0) {
            if (this.gHG.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.gHG.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.topMargin = i / 2;
            this.gHG.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gHu.ir(true);
        } else if (this.gHu.isScroll()) {
            this.gHu.ir(false);
            aeX();
        }
    }

    private void aeX() {
        int childCount = this.gHt.getChildCount();
        int firstVisiblePosition = this.gHt.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gHt.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gHu.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gGN.aLU().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gHt.findViewWithTag(str);
                            if (headImageView2 != null && aVar != null) {
                                headImageView2.invalidate();
                            }
                        }
                    }, false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.gHu != null) {
            this.gHu.setData(this.gGy.bzF());
        }
        bzI();
    }

    public void G(int i, boolean z) {
        if (this.gHt != null) {
            int firstVisiblePosition = this.gHt.getFirstVisiblePosition();
            int lastVisiblePosition = this.gHt.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gHt.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    View findViewById = childAt.findViewById(d.h.select_icon);
                    if (z) {
                        aj.j(findViewById, d.g.btn_choose_photo_s);
                    } else {
                        aj.j(findViewById, d.g.btn_choose_photo_n);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bzI();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gHu != null) {
            G(this.gHu.g(imageFileInfo), z);
        }
    }

    public boolean bzL() {
        return this.gHt != null && this.gHt.getVisibility() == 0;
    }

    public View bzs() {
        return this.gGW;
    }

    public void np(boolean z) {
        if (this.gGN != null && this.gGW != null) {
            String string = this.gGN.getResources().getString(d.l.original_img);
            if (z) {
                this.gGW.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                this.gGW.setText(string);
                this.gGW.setTextColor(this.gGN.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gGW.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gGW.setText(string);
            this.gGW.setTextColor(this.gGN.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
