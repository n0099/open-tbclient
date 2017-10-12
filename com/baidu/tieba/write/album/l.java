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
    private AlbumActivity gGM;
    private TextView gGU;
    private TextView gGV;
    private View gGW;
    private e gGx;
    private View gHA;
    private View gHB;
    private View gHC;
    private Animation gHD;
    private Animation gHE;
    private View gHF;
    private View gHH;
    private View gHI;
    private com.baidu.tieba.write.view.a gHr;
    private TransparentHeadGridView gHs;
    private k gHt;
    private View gHu;
    private View gHw;
    private View gHx;
    private View gHy;
    private View gHz;
    private ImageView gcw;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private int mScreenWidth;
    private TextView mTitleText;
    private View mView;
    private TbCameraView gHv = null;
    private int gHG = 0;
    private String aiq = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gHJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gGx.getMaxImagesAllowed();
            if (l.this.gGx.size() < maxImagesAllowed) {
                l.this.gHs.bzO();
                l.this.bMQ.setVisibility(8);
                l.this.gHA.setAlpha(1.0f);
                l.this.gHF.setVisibility(8);
                l.this.gHF.setAlpha(1.0f);
                l.this.gHI.setVisibility(8);
                l.this.gHI.setAlpha(1.0f);
                l.this.gGW.setVisibility(8);
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
                l.this.gHr.d(l.this.gGx.bzB(), l.this.gGx.bzz());
                l.this.gHr.ap(l.this.bMQ);
                if (l.this.gHG <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gHx.getId()) {
                if (view.getId() == l.this.gHy.getId()) {
                    int maxImagesAllowed = l.this.gGx.getMaxImagesAllowed();
                    if (l.this.gGx.size() < maxImagesAllowed || l.this.gGM.bzj()) {
                        l.this.gGx.tb(String.valueOf(System.currentTimeMillis()));
                        l.this.gGM.iw(l.this.gGx.bzD());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gHz.getId()) {
                    if (l.this.gHv != null) {
                        l.this.gHv.bpe();
                    }
                } else if (view.getId() != l.this.gHC.getId()) {
                    if (view.getId() == l.this.gHB.getId()) {
                        if (l.this.gHv != null) {
                            l.this.gHv.bpg();
                            return;
                        }
                        return;
                    }
                    if (view == l.this.gGW) {
                    }
                } else {
                    l.this.bzG();
                }
            } else {
                l.this.nt(true);
                l.this.bpd();
            }
        }
    };
    private TbCameraView.c gHK = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean boW() {
            return !ab.d(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gHL = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void boX() {
            if (l.this.gGM != null) {
                l.this.gGM.showToast(l.this.gGM.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gHM = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
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
                ViewGroup.LayoutParams layoutParams = l.this.gHv.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gHv.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gHN = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gHG <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gHO = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void boZ() {
            l.this.nt(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bpa() {
            if (l.this.gGM != null) {
                l.this.gGM.bpa();
            }
            l.this.bpd();
            if (l.this.gGM != null) {
                l.this.gGM.bzg();
            }
        }
    };
    private TransparentHeadGridView.b gHP = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void uT(int i) {
            l.this.bMQ.setAlpha(1.0f - (i / 100.0f));
            l.this.gHA.setAlpha(i / 100.0f);
            l.this.gHF.setAlpha(1.0f - (i / 100.0f));
            l.this.gHI.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void boM() {
            l.this.bMQ.setVisibility(8);
            l.this.gHA.setAlpha(1.0f);
            l.this.gHF.setVisibility(8);
            l.this.gHF.setAlpha(1.0f);
            l.this.gHI.setVisibility(8);
            l.this.gHI.setAlpha(1.0f);
            l.this.gGW.setVisibility(8);
        }
    };
    private Animation.AnimationListener gHQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gHA.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gHR = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void uS(int i) {
            l.this.gHG = i;
            if (i <= 50) {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
                l.this.gcw.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bMQ.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable2, null);
                l.this.gcw.setImageResource(d.g.icon_topbar_close_n);
                l.this.bMQ.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gHu.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gHl = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gGx.setCurrentIndex(i);
            l.this.gGM.uM(1);
        }
    };
    private a.InterfaceC0142a gHS = new a.InterfaceC0142a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0142a
        public void a(int i, com.baidu.tbadk.b.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gGx.bzz())) {
                List<ImageFileInfo> bzC = l.this.gGx.bzC();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bzC) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bzC = arrayList;
                }
                l.this.gGx.dE(bzC);
                l.this.gGx.ta(albumId);
                l.this.setData(bzC);
                l.this.mTitleText.setText(name);
                l.this.gHs.smoothScrollToPosition(0);
            }
        }
    };
    private j gHm = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean e;
            if (z) {
                l.this.gGU.setText(l.this.gGM.getResources().getText(d.l.next_step));
                e = l.this.gGM.d(imageFileInfo);
                if (l.this.gGx.isOriginalImg()) {
                    l.this.gGM.bzh();
                }
            } else {
                e = l.this.gGM.e(imageFileInfo);
            }
            l.this.bzH();
            return e;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gGM = (AlbumActivity) getBaseFragmentActivity();
        this.gGx = this.gGM.bzi();
        f.bzF().a(this);
        this.cjq = new com.baidu.tbadk.b.b(this.gGM.getPageContext().getPageActivity());
        this.gHr = new com.baidu.tieba.write.view.a(this.gGM);
        this.gHr.setOnDismissListener(this.gHN);
        this.gGx.ta("-1");
        if (getActivity().getIntent() != null) {
            this.aiq = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.ccT = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.gcw = (ImageView) this.mView.findViewById(d.h.img_close);
        this.gcw.setOnClickListener(this.gGM);
        this.gGU = (TextView) this.mView.findViewById(d.h.next_step);
        this.gGU.setOnClickListener(this.gGM);
        this.mTitleText = (TextView) this.mView.findViewById(d.h.album_title);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.gHs = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gHt = new k(this.gGM, this.gGx);
        this.gHs.setAdapter((ListAdapter) this.gHt);
        this.gHs.setOuterOnScrollListener(this);
        this.gHs.setSelector(d.e.transparent);
        this.gHs.setOnHeadDisplayChangeListener(this.gHR);
        this.gHs.setOnPullChangeListener(this.gHP);
        this.gHr.a(this.gHS);
        this.gHt.a(this.gHm);
        this.gHt.a(this.gHl);
        this.gHt.h(this.gHJ);
        this.mNoDataView = NoDataViewFactory.a(this.gGM.getPageContext().getPageActivity(), this.ccT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bMQ = this.mView.findViewById(d.h.layout_title);
        this.gHu = this.mView.findViewById(d.h.top_bar_background);
        this.gHu.setAlpha(0.0f);
        this.gHv = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gHv.setOnGotPictureListener(this.gHO);
        this.gHv.setOnPreviewSizeChangedListener(this.gHM);
        this.gHw = this.mView.findViewById(d.h.camera_view_container);
        this.gHx = this.mView.findViewById(d.h.img_pic_cancel);
        this.gHx.setOnClickListener(this.mOnClickListener);
        this.gHy = this.mView.findViewById(d.h.img_take_picture);
        this.gHy.setOnClickListener(this.mOnClickListener);
        this.gHz = this.mView.findViewById(d.h.img_pic_save);
        this.gHz.setOnClickListener(this.mOnClickListener);
        this.gHA = this.mView.findViewById(d.h.camera_bar);
        this.gHA.setAlpha(0.0f);
        this.gHB = this.mView.findViewById(d.h.btn_camera_switch);
        this.gHB.setOnClickListener(this.mOnClickListener);
        this.gHC = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gHC.setOnClickListener(this.mOnClickListener);
        this.gHD = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gHE = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gHE.setAnimationListener(this.gHQ);
        this.gHs.setBottomMoveView(this.gHw);
        this.gHH = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.l.ad(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gHH.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gHH.setLayoutParams(layoutParams);
        this.gHt.uQ((this.mScreenWidth - com.baidu.adp.lib.util.l.f(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gHF = this.mView.findViewById(d.h.icon_camera);
        uR((int) (com.baidu.adp.lib.util.l.af(this.gGM.getPageContext().getPageActivity()) * 0.28f));
        this.gHI = this.mView.findViewById(d.h.view_camera_cover);
        this.gHv.setOnRequestPermissionListener(this.gHK);
        bzH();
        this.gHv.setOnOpenCameraFailedListener(this.gHL);
        nt(true);
        this.gGV = (TextView) this.mView.findViewById(d.h.original_select_btn);
        this.gGV.setOnClickListener(this.gGM);
        this.gGW = this.mView.findViewById(d.h.layout_bottom);
        this.gGW.setOnClickListener(this.mOnClickListener);
        return this.mView;
    }

    public void bpd() {
        if (this.gHv != null) {
            this.gHv.bzL();
            this.gHv.bpd();
        }
    }

    public void bzG() {
        this.gHs.bzN();
        this.bMQ.setVisibility(0);
        this.bMQ.setAlpha(1.0f);
        this.bMQ.startAnimation(this.gHD);
        this.gHA.startAnimation(this.gHE);
        this.gHF.setVisibility(0);
        this.gHF.startAnimation(this.gHD);
        this.gHI.setVisibility(0);
        this.gGW.setVisibility(0);
    }

    public void nt(boolean z) {
        if (z) {
            this.gHx.setVisibility(4);
            this.gHy.setVisibility(0);
            this.gHz.setVisibility(4);
            this.gHC.setVisibility(0);
            this.gHB.setVisibility(0);
            return;
        }
        this.gHx.setVisibility(0);
        this.gHy.setVisibility(4);
        this.gHz.setVisibility(0);
        this.gHC.setVisibility(8);
        this.gHB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzH() {
        if (this.gGx.getWriteImagesInfo() != null && this.gGx.getWriteImagesInfo().getChosedFiles() != null) {
            int t = v.t(this.gGx.getWriteImagesInfo().getChosedFiles());
            this.gGU.setText(this.gGM.getResources().getText(d.l.next_step));
            this.gGU.setEnabled(t > 0);
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

    private void bzw() {
        if (this.gGx == null && this.gGM != null) {
            this.gGx = this.gGM.bzi();
        }
        if (this.gGx != null) {
            if (this.gGx.bzC() != null) {
                this.gHt.notifyDataSetChanged();
                return;
            }
            tc("-1");
            if (this.gGx.isOriginalImg()) {
                np(this.gGx.isOriginalImg());
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
                        l.this.bzI();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!v.u(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a();
                        aVar.bW("-1");
                        String string = l.this.gGM.getPageContext().getString(d.l.album_all);
                        aVar.setName(string);
                        aVar.bX(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.mTitleText.setText(string);
                        l.this.gGx.dF(arrayList2);
                        l.this.gGx.dG(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzI() {
        this.cjq.a(new com.baidu.tbadk.b.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.b.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.b.c
            public void m(List<com.baidu.tbadk.b.a> list) {
                l.this.gGx.dF(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gHt != null) {
                this.gGx.dE(list);
                this.gHt.setData(this.gGx.bzE());
            }
            bzH();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gGM.getLayoutMode().ai(i == 1);
        this.gGM.getLayoutMode().t(this.mView);
        if (this.gHt != null) {
            this.gHt.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View biW() {
        return this.gcw;
    }

    public View bzJ() {
        return this.gGU;
    }

    public TbCameraView bzm() {
        return this.gHv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cjq != null) {
            this.cjq.nD();
        }
        f.bzF().b(this);
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
            bzw();
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
            if (this.gHF.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.gHF.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.topMargin = i / 2;
            this.gHF.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gHt.ir(true);
        } else if (this.gHt.isScroll()) {
            this.gHt.ir(false);
            aeX();
        }
    }

    private void aeX() {
        int childCount = this.gHs.getChildCount();
        int firstVisiblePosition = this.gHs.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gHs.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gHt.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gGM.aLU().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gHs.findViewWithTag(str);
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
        if (this.gHt != null) {
            this.gHt.setData(this.gGx.bzE());
        }
        bzH();
    }

    public void G(int i, boolean z) {
        if (this.gHs != null) {
            int firstVisiblePosition = this.gHs.getFirstVisiblePosition();
            int lastVisiblePosition = this.gHs.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gHs.getChildAt(i - firstVisiblePosition);
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
        bzH();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gHt != null) {
            G(this.gHt.g(imageFileInfo), z);
        }
    }

    public boolean bzK() {
        return this.gHs != null && this.gHs.getVisibility() == 0;
    }

    public View bzr() {
        return this.gGV;
    }

    public void np(boolean z) {
        if (this.gGM != null && this.gGV != null) {
            String string = this.gGM.getResources().getString(d.l.original_img);
            if (z) {
                this.gGV.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                this.gGV.setText(string);
                this.gGV.setTextColor(this.gGM.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gGV.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gGV.setText(string);
            this.gGV.setTextColor(this.gGM.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
