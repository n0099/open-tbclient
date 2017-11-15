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
    private View bUv;
    private ImageView bvX;
    private RelativeLayout cku;
    private com.baidu.tbadk.b.b cqS;
    private boolean eKs;
    private AlbumActivity gRD;
    private TextView gRL;
    private TextView gRM;
    private View gRN;
    private e gRn;
    private com.baidu.tieba.write.view.a gSi;
    private TransparentHeadGridView gSj;
    private k gSk;
    private View gSl;
    private View gSn;
    private View gSo;
    private View gSp;
    private View gSq;
    private View gSr;
    private View gSs;
    private View gSt;
    private Animation gSu;
    private Animation gSv;
    private View gSw;
    private View gSy;
    private View gSz;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private int mScreenWidth;
    private TextView mTitleText;
    private View mView;
    private TbCameraView gSm = null;
    private int gSx = 0;
    private String aiB = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gSA = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gRn.getMaxImagesAllowed();
            if (l.this.gRn.size() < maxImagesAllowed) {
                l.this.gSj.bDs();
                l.this.bUv.setVisibility(8);
                l.this.gSr.setAlpha(1.0f);
                l.this.gSw.setVisibility(8);
                l.this.gSw.setAlpha(1.0f);
                l.this.gSz.setVisibility(8);
                l.this.gSz.setAlpha(1.0f);
                l.this.gRN.setVisibility(8);
                return;
            }
            l.this.showToast(String.format(l.this.getPageContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (view.getId() == l.this.mTitleText.getId()) {
                l.this.gSi.d(l.this.gRn.bDf(), l.this.gRn.bDd());
                l.this.gSi.at(l.this.bUv);
                if (l.this.gSx <= 50) {
                    i = d.f.d_ic_post_gallery_spread_s;
                } else {
                    i = d.f.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gSo.getId()) {
                if (view.getId() == l.this.gSp.getId()) {
                    int maxImagesAllowed = l.this.gRn.getMaxImagesAllowed();
                    if (l.this.gRn.size() < maxImagesAllowed || l.this.gRD.bCN()) {
                        l.this.gRn.tT(String.valueOf(System.currentTimeMillis()));
                        l.this.gRD.iU(l.this.gRn.bDh());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gSq.getId()) {
                    if (l.this.gSm != null) {
                        l.this.gSm.bsm();
                    }
                } else if (view.getId() != l.this.gSt.getId()) {
                    if (view.getId() == l.this.gSs.getId()) {
                        if (l.this.gSm != null) {
                            l.this.gSm.bso();
                            return;
                        }
                        return;
                    }
                    if (view == l.this.gRN) {
                    }
                } else {
                    l.this.bDk();
                }
            } else {
                l.this.ny(true);
                l.this.bsl();
            }
        }
    };
    private TbCameraView.c gSB = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bse() {
            return !ab.e(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gSC = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bsf() {
            if (l.this.gRD != null) {
                l.this.gRD.showToast(l.this.gRD.getResources().getString(d.j.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gSD = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void ce(int i, int i2) {
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
                ViewGroup.LayoutParams layoutParams = l.this.gSm.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gSm.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gSE = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gSx <= 50) {
                i = d.f.d_ic_post_gallery_spread_n;
            } else {
                i = d.f.ic_post_gallery_spread_n;
            }
            if (l.this.isAdded()) {
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private TbCameraView.d gSF = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bsh() {
            l.this.ny(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bsi() {
            if (l.this.gRD != null) {
                l.this.gRD.bsi();
            }
            l.this.bsl();
            if (l.this.gRD != null) {
                l.this.gRD.bCK();
            }
        }
    };
    private TransparentHeadGridView.b gSG = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void vq(int i) {
            l.this.bUv.setAlpha(1.0f - (i / 100.0f));
            l.this.gSr.setAlpha(i / 100.0f);
            l.this.gSw.setAlpha(1.0f - (i / 100.0f));
            l.this.gSz.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void brU() {
            l.this.bUv.setVisibility(8);
            l.this.gSr.setAlpha(1.0f);
            l.this.gSw.setVisibility(8);
            l.this.gSw.setAlpha(1.0f);
            l.this.gSz.setVisibility(8);
            l.this.gSz.setAlpha(1.0f);
            l.this.gRN.setVisibility(8);
        }
    };
    private Animation.AnimationListener gSH = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gSr.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gSI = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void vp(int i) {
            l.this.gSx = i;
            if (i <= 50) {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.C0080d.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.f.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
                l.this.bvX.setImageResource(d.f.d_con_pb_post_close_n);
                l.this.bUv.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.C0080d.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.f.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable2, null);
                l.this.bvX.setImageResource(d.f.icon_topbar_close_n);
                l.this.bUv.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gSl.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gSc = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gRn.setCurrentIndex(i);
            l.this.gRD.vj(1);
        }
    };
    private a.InterfaceC0147a gSJ = new a.InterfaceC0147a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0147a
        public void a(int i, com.baidu.tbadk.b.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gRn.bDd())) {
                List<ImageFileInfo> bDg = l.this.gRn.bDg();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bDg) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bDg = arrayList;
                }
                l.this.gRn.dH(bDg);
                l.this.gRn.tS(albumId);
                l.this.setData(bDg);
                l.this.mTitleText.setText(name);
                l.this.gSj.smoothScrollToPosition(0);
            }
        }
    };
    private j gSd = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean e;
            if (z) {
                l.this.gRL.setText(l.this.gRD.getResources().getText(d.j.next_step));
                e = l.this.gRD.d(imageFileInfo);
                if (l.this.gRn.isOriginalImg()) {
                    l.this.gRD.bCL();
                }
            } else {
                e = l.this.gRD.e(imageFileInfo);
            }
            l.this.bDl();
            return e;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gRD = (AlbumActivity) getBaseFragmentActivity();
        this.gRn = this.gRD.bCM();
        f.bDj().a(this);
        this.cqS = new com.baidu.tbadk.b.b(this.gRD.getPageContext().getPageActivity());
        this.gSi = new com.baidu.tieba.write.view.a(this.gRD);
        this.gSi.setOnDismissListener(this.gSE);
        this.gRn.tS("-1");
        if (getActivity().getIntent() != null) {
            this.aiB = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.cku = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.bvX = (ImageView) this.mView.findViewById(d.g.img_close);
        this.bvX.setOnClickListener(this.gRD);
        this.gRL = (TextView) this.mView.findViewById(d.g.next_step);
        this.gRL.setOnClickListener(this.gRD);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.gSj = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.gSk = new k(this.gRD, this.gRn);
        this.gSj.setAdapter((ListAdapter) this.gSk);
        this.gSj.setOuterOnScrollListener(this);
        this.gSj.setSelector(d.C0080d.transparent);
        this.gSj.setOnHeadDisplayChangeListener(this.gSI);
        this.gSj.setOnPullChangeListener(this.gSG);
        this.gSi.a(this.gSJ);
        this.gSk.a(this.gSd);
        this.gSk.a(this.gSc);
        this.gSk.U(this.gSA);
        this.mNoDataView = NoDataViewFactory.a(this.gRD.getPageContext().getPageActivity(), this.cku, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.bUv = this.mView.findViewById(d.g.layout_title);
        this.gSl = this.mView.findViewById(d.g.top_bar_background);
        this.gSl.setAlpha(0.0f);
        this.gSm = (TbCameraView) this.mView.findViewById(d.g.camera_surfaceview);
        this.gSm.setOnGotPictureListener(this.gSF);
        this.gSm.setOnPreviewSizeChangedListener(this.gSD);
        this.gSn = this.mView.findViewById(d.g.camera_view_container);
        this.gSo = this.mView.findViewById(d.g.img_pic_cancel);
        this.gSo.setOnClickListener(this.mOnClickListener);
        this.gSp = this.mView.findViewById(d.g.img_take_picture);
        this.gSp.setOnClickListener(this.mOnClickListener);
        this.gSq = this.mView.findViewById(d.g.img_pic_save);
        this.gSq.setOnClickListener(this.mOnClickListener);
        this.gSr = this.mView.findViewById(d.g.camera_bar);
        this.gSr.setAlpha(0.0f);
        this.gSs = this.mView.findViewById(d.g.btn_camera_switch);
        this.gSs.setOnClickListener(this.mOnClickListener);
        this.gSt = this.mView.findViewById(d.g.btn_back_to_pictures);
        this.gSt.setOnClickListener(this.mOnClickListener);
        this.gSu = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gSv = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gSv.setAnimationListener(this.gSH);
        this.gSj.setBottomMoveView(this.gSn);
        this.gSy = this.mView.findViewById(d.g.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.l.ac(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gSy.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gSy.setLayoutParams(layoutParams);
        this.gSk.vn((this.mScreenWidth - com.baidu.adp.lib.util.l.f(getPageContext().getPageActivity(), d.e.ds16)) / 3);
        this.gSw = this.mView.findViewById(d.g.icon_camera);
        vo((int) (com.baidu.adp.lib.util.l.ae(this.gRD.getPageContext().getPageActivity()) * 0.28f));
        this.gSz = this.mView.findViewById(d.g.view_camera_cover);
        this.gSm.setOnRequestPermissionListener(this.gSB);
        bDl();
        this.gSm.setOnOpenCameraFailedListener(this.gSC);
        ny(true);
        this.gRM = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.gRM.setOnClickListener(this.gRD);
        this.gRN = this.mView.findViewById(d.g.layout_bottom);
        this.gRN.setOnClickListener(this.mOnClickListener);
        return this.mView;
    }

    public void bsl() {
        if (this.gSm != null) {
            this.gSm.bDp();
            this.gSm.bsl();
        }
    }

    public void bDk() {
        this.gSj.bDr();
        this.bUv.setVisibility(0);
        this.bUv.setAlpha(1.0f);
        this.bUv.startAnimation(this.gSu);
        this.gSr.startAnimation(this.gSv);
        this.gSw.setVisibility(0);
        this.gSw.startAnimation(this.gSu);
        this.gSz.setVisibility(0);
        this.gRN.setVisibility(0);
    }

    public void ny(boolean z) {
        if (z) {
            this.gSo.setVisibility(4);
            this.gSp.setVisibility(0);
            this.gSq.setVisibility(4);
            this.gSt.setVisibility(0);
            this.gSs.setVisibility(0);
            return;
        }
        this.gSo.setVisibility(0);
        this.gSp.setVisibility(4);
        this.gSq.setVisibility(0);
        this.gSt.setVisibility(8);
        this.gSs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDl() {
        if (this.gRn.getWriteImagesInfo() != null && this.gRn.getWriteImagesInfo().getChosedFiles() != null) {
            int u = v.u(this.gRn.getWriteImagesInfo().getChosedFiles());
            this.gRL.setText(this.gRD.getResources().getText(d.j.next_step));
            this.gRL.setEnabled(u > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eKs = false;
        if (isShow()) {
            Oa();
        }
    }

    private void bDa() {
        if (this.gRn == null && this.gRD != null) {
            this.gRn = this.gRD.bCM();
        }
        if (this.gRn != null) {
            if (this.gRn.bDg() != null) {
                this.gSk.notifyDataSetChanged();
                return;
            }
            tU("-1");
            if (this.gRn.isOriginalImg()) {
                nu(this.gRn.isOriginalImg());
            }
        }
    }

    private void tU(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cqS.a(str, new com.baidu.tbadk.b.d() { // from class: com.baidu.tieba.write.album.l.6
                @Override // com.baidu.tbadk.b.d
                public void onPreLoad() {
                }

                @Override // com.baidu.tbadk.b.d
                public void a(List<com.baidu.tbadk.b.a> list, List<ImageFileInfo> list2, String str2) {
                    ArrayList arrayList = new ArrayList();
                    if (!v.v(list2)) {
                        arrayList.addAll(list2);
                    }
                    if (!str.equals("-1")) {
                        l.this.mTitleText.setText(str2);
                        l.this.bDm();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!v.v(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a();
                        aVar.ca("-1");
                        String string = l.this.gRD.getPageContext().getString(d.j.album_all);
                        aVar.setName(string);
                        aVar.cb(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.mTitleText.setText(string);
                        l.this.gRn.dI(arrayList2);
                        l.this.gRn.dJ(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDm() {
        this.cqS.a(new com.baidu.tbadk.b.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.b.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.b.c
            public void n(List<com.baidu.tbadk.b.a> list) {
                l.this.gRn.dI(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gSk != null) {
                this.gRn.dH(list);
                this.gSk.setData(this.gRn.bDi());
            }
            bDl();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gRD.getLayoutMode().ag(i == 1);
        this.gRD.getLayoutMode().t(this.mView);
        if (this.gSk != null) {
            this.gSk.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bmj() {
        return this.bvX;
    }

    public View bDn() {
        return this.gRL;
    }

    public TbCameraView bCQ() {
        return this.gSm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.gSi != null) {
            this.gSi.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cqS != null) {
            this.cqS.nz();
        }
        f.bDj().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eKs = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nx(boolean z) {
        Oa();
    }

    private void Oa() {
        if (!isHidden() && !this.eKs) {
            bDa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        super.onScroll(absListView, i, i2, i3);
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            vo(childAt.getHeight() + iArr[1]);
        }
    }

    private void vo(int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (i >= 0) {
            if (this.gSw.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.gSw.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.topMargin = i / 2;
            this.gSw.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gSk.is(true);
        } else if (this.gSk.isScroll()) {
            this.gSk.is(false);
            ahn();
        }
    }

    private void ahn() {
        int childCount = this.gSj.getChildCount();
        int firstVisiblePosition = this.gSj.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gSj.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.pic);
                ImageFileInfo item = this.gSk.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gRD.aOP().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gSj.findViewWithTag(str);
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
        if (this.gSk != null) {
            this.gSk.setData(this.gRn.bDi());
        }
        bDl();
    }

    public void I(int i, boolean z) {
        if (this.gSj != null) {
            int firstVisiblePosition = this.gSj.getFirstVisiblePosition();
            int lastVisiblePosition = this.gSj.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gSj.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    View findViewById = childAt.findViewById(d.g.select_icon);
                    if (z) {
                        aj.j(findViewById, d.f.btn_choose_photo_s);
                    } else {
                        aj.j(findViewById, d.f.btn_choose_photo_n);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bDl();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gSk != null) {
            I(this.gSk.g(imageFileInfo), z);
        }
    }

    public boolean bDo() {
        return this.gSj != null && this.gSj.getVisibility() == 0;
    }

    public View bCV() {
        return this.gRM;
    }

    public void nu(boolean z) {
        if (this.gRD != null && this.gRM != null) {
            String string = this.gRD.getResources().getString(d.j.original_img);
            if (z) {
                this.gRM.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                this.gRM.setText(string);
                this.gRM.setTextColor(this.gRD.getResources().getColor(d.C0080d.cp_link_tip_a));
                return;
            }
            this.gRM.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gRM.setText(string);
            this.gRM.setTextColor(this.gRD.getResources().getColor(d.C0080d.cp_cont_i));
        }
    }
}
