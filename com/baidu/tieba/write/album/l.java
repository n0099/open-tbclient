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
    private View bUi;
    private ImageView bvM;
    private RelativeLayout ckd;
    private com.baidu.tbadk.b.b cqz;
    private boolean eJY;
    private TextView gQD;
    private TextView gQE;
    private View gQF;
    private e gQf;
    private AlbumActivity gQv;
    private com.baidu.tieba.write.view.a gRa;
    private TransparentHeadGridView gRb;
    private k gRc;
    private View gRd;
    private View gRf;
    private View gRg;
    private View gRh;
    private View gRi;
    private View gRj;
    private View gRk;
    private View gRl;
    private Animation gRm;
    private Animation gRn;
    private View gRo;
    private View gRq;
    private View gRr;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private int mScreenWidth;
    private TextView mTitleText;
    private View mView;
    private TbCameraView gRe = null;
    private int gRp = 0;
    private String aiB = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gRs = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gQf.getMaxImagesAllowed();
            if (l.this.gQf.size() < maxImagesAllowed) {
                l.this.gRb.bDg();
                l.this.bUi.setVisibility(8);
                l.this.gRj.setAlpha(1.0f);
                l.this.gRo.setVisibility(8);
                l.this.gRo.setAlpha(1.0f);
                l.this.gRr.setVisibility(8);
                l.this.gRr.setAlpha(1.0f);
                l.this.gQF.setVisibility(8);
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
                l.this.gRa.d(l.this.gQf.bCT(), l.this.gQf.bCR());
                l.this.gRa.as(l.this.bUi);
                if (l.this.gRp <= 50) {
                    i = d.f.d_ic_post_gallery_spread_s;
                } else {
                    i = d.f.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gRg.getId()) {
                if (view.getId() == l.this.gRh.getId()) {
                    int maxImagesAllowed = l.this.gQf.getMaxImagesAllowed();
                    if (l.this.gQf.size() < maxImagesAllowed || l.this.gQv.bCB()) {
                        l.this.gQf.tN(String.valueOf(System.currentTimeMillis()));
                        l.this.gQv.iT(l.this.gQf.bCV());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gRi.getId()) {
                    if (l.this.gRe != null) {
                        l.this.gRe.bsb();
                    }
                } else if (view.getId() != l.this.gRl.getId()) {
                    if (view.getId() == l.this.gRk.getId()) {
                        if (l.this.gRe != null) {
                            l.this.gRe.bsd();
                            return;
                        }
                        return;
                    }
                    if (view == l.this.gQF) {
                    }
                } else {
                    l.this.bCY();
                }
            } else {
                l.this.nq(true);
                l.this.bsa();
            }
        }
    };
    private TbCameraView.c gRt = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean brT() {
            return !ab.e(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gRu = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void brU() {
            if (l.this.gQv != null) {
                l.this.gQv.showToast(l.this.gQv.getResources().getString(d.j.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gRv = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void cf(int i, int i2) {
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
                ViewGroup.LayoutParams layoutParams = l.this.gRe.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gRe.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gRw = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gRp <= 50) {
                i = d.f.d_ic_post_gallery_spread_n;
            } else {
                i = d.f.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gRx = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void brW() {
            l.this.nq(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void brX() {
            if (l.this.gQv != null) {
                l.this.gQv.brX();
            }
            l.this.bsa();
            if (l.this.gQv != null) {
                l.this.gQv.bCy();
            }
        }
    };
    private TransparentHeadGridView.b gRy = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void vm(int i) {
            l.this.bUi.setAlpha(1.0f - (i / 100.0f));
            l.this.gRj.setAlpha(i / 100.0f);
            l.this.gRo.setAlpha(1.0f - (i / 100.0f));
            l.this.gRr.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void brJ() {
            l.this.bUi.setVisibility(8);
            l.this.gRj.setAlpha(1.0f);
            l.this.gRo.setVisibility(8);
            l.this.gRo.setAlpha(1.0f);
            l.this.gRr.setVisibility(8);
            l.this.gRr.setAlpha(1.0f);
            l.this.gQF.setVisibility(8);
        }
    };
    private Animation.AnimationListener gRz = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gRj.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gRA = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void vl(int i) {
            l.this.gRp = i;
            if (i <= 50) {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.C0080d.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.f.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
                l.this.bvM.setImageResource(d.f.d_con_pb_post_close_n);
                l.this.bUi.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.C0080d.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.f.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable2, null);
                l.this.bvM.setImageResource(d.f.icon_topbar_close_n);
                l.this.bUi.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gRd.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gQU = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gQf.setCurrentIndex(i);
            l.this.gQv.vf(1);
        }
    };
    private a.InterfaceC0144a gRB = new a.InterfaceC0144a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0144a
        public void a(int i, com.baidu.tbadk.b.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gQf.bCR())) {
                List<ImageFileInfo> bCU = l.this.gQf.bCU();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bCU) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bCU = arrayList;
                }
                l.this.gQf.dG(bCU);
                l.this.gQf.tM(albumId);
                l.this.setData(bCU);
                l.this.mTitleText.setText(name);
                l.this.gRb.smoothScrollToPosition(0);
            }
        }
    };
    private j gQV = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean e;
            if (z) {
                l.this.gQD.setText(l.this.gQv.getResources().getText(d.j.next_step));
                e = l.this.gQv.d(imageFileInfo);
                if (l.this.gQf.isOriginalImg()) {
                    l.this.gQv.bCz();
                }
            } else {
                e = l.this.gQv.e(imageFileInfo);
            }
            l.this.bCZ();
            return e;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQv = (AlbumActivity) getBaseFragmentActivity();
        this.gQf = this.gQv.bCA();
        f.bCX().a(this);
        this.cqz = new com.baidu.tbadk.b.b(this.gQv.getPageContext().getPageActivity());
        this.gRa = new com.baidu.tieba.write.view.a(this.gQv);
        this.gRa.setOnDismissListener(this.gRw);
        this.gQf.tM("-1");
        if (getActivity().getIntent() != null) {
            this.aiB = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.h.album_image_list_view, (ViewGroup) null);
        this.ckd = (RelativeLayout) this.mView.findViewById(d.g.album_image_list_root);
        this.bvM = (ImageView) this.mView.findViewById(d.g.img_close);
        this.bvM.setOnClickListener(this.gQv);
        this.gQD = (TextView) this.mView.findViewById(d.g.next_step);
        this.gQD.setOnClickListener(this.gQv);
        this.mTitleText = (TextView) this.mView.findViewById(d.g.album_title);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.gRb = (TransparentHeadGridView) this.mView.findViewById(d.g.gv_image_list);
        this.gRc = new k(this.gQv, this.gQf);
        this.gRb.setAdapter((ListAdapter) this.gRc);
        this.gRb.setOuterOnScrollListener(this);
        this.gRb.setSelector(d.C0080d.transparent);
        this.gRb.setOnHeadDisplayChangeListener(this.gRA);
        this.gRb.setOnPullChangeListener(this.gRy);
        this.gRa.a(this.gRB);
        this.gRc.a(this.gQV);
        this.gRc.a(this.gQU);
        this.gRc.U(this.gRs);
        this.mNoDataView = NoDataViewFactory.a(this.gQv.getPageContext().getPageActivity(), this.ckd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.j.album_list_no_data, d.j.album_list_no_data_1), null);
        this.bUi = this.mView.findViewById(d.g.layout_title);
        this.gRd = this.mView.findViewById(d.g.top_bar_background);
        this.gRd.setAlpha(0.0f);
        this.gRe = (TbCameraView) this.mView.findViewById(d.g.camera_surfaceview);
        this.gRe.setOnGotPictureListener(this.gRx);
        this.gRe.setOnPreviewSizeChangedListener(this.gRv);
        this.gRf = this.mView.findViewById(d.g.camera_view_container);
        this.gRg = this.mView.findViewById(d.g.img_pic_cancel);
        this.gRg.setOnClickListener(this.mOnClickListener);
        this.gRh = this.mView.findViewById(d.g.img_take_picture);
        this.gRh.setOnClickListener(this.mOnClickListener);
        this.gRi = this.mView.findViewById(d.g.img_pic_save);
        this.gRi.setOnClickListener(this.mOnClickListener);
        this.gRj = this.mView.findViewById(d.g.camera_bar);
        this.gRj.setAlpha(0.0f);
        this.gRk = this.mView.findViewById(d.g.btn_camera_switch);
        this.gRk.setOnClickListener(this.mOnClickListener);
        this.gRl = this.mView.findViewById(d.g.btn_back_to_pictures);
        this.gRl.setOnClickListener(this.mOnClickListener);
        this.gRm = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gRn = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gRn.setAnimationListener(this.gRz);
        this.gRb.setBottomMoveView(this.gRf);
        this.gRq = this.mView.findViewById(d.g.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.l.ac(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gRq.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gRq.setLayoutParams(layoutParams);
        this.gRc.vj((this.mScreenWidth - com.baidu.adp.lib.util.l.f(getPageContext().getPageActivity(), d.e.ds16)) / 3);
        this.gRo = this.mView.findViewById(d.g.icon_camera);
        vk((int) (com.baidu.adp.lib.util.l.ae(this.gQv.getPageContext().getPageActivity()) * 0.28f));
        this.gRr = this.mView.findViewById(d.g.view_camera_cover);
        this.gRe.setOnRequestPermissionListener(this.gRt);
        bCZ();
        this.gRe.setOnOpenCameraFailedListener(this.gRu);
        nq(true);
        this.gQE = (TextView) this.mView.findViewById(d.g.original_select_btn);
        this.gQE.setOnClickListener(this.gQv);
        this.gQF = this.mView.findViewById(d.g.layout_bottom);
        this.gQF.setOnClickListener(this.mOnClickListener);
        return this.mView;
    }

    public void bsa() {
        if (this.gRe != null) {
            this.gRe.bDd();
            this.gRe.bsa();
        }
    }

    public void bCY() {
        this.gRb.bDf();
        this.bUi.setVisibility(0);
        this.bUi.setAlpha(1.0f);
        this.bUi.startAnimation(this.gRm);
        this.gRj.startAnimation(this.gRn);
        this.gRo.setVisibility(0);
        this.gRo.startAnimation(this.gRm);
        this.gRr.setVisibility(0);
        this.gQF.setVisibility(0);
    }

    public void nq(boolean z) {
        if (z) {
            this.gRg.setVisibility(4);
            this.gRh.setVisibility(0);
            this.gRi.setVisibility(4);
            this.gRl.setVisibility(0);
            this.gRk.setVisibility(0);
            return;
        }
        this.gRg.setVisibility(0);
        this.gRh.setVisibility(4);
        this.gRi.setVisibility(0);
        this.gRl.setVisibility(8);
        this.gRk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCZ() {
        if (this.gQf.getWriteImagesInfo() != null && this.gQf.getWriteImagesInfo().getChosedFiles() != null) {
            int u = v.u(this.gQf.getWriteImagesInfo().getChosedFiles());
            this.gQD.setText(this.gQv.getResources().getText(d.j.next_step));
            this.gQD.setEnabled(u > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eJY = false;
        if (isShow()) {
            NP();
        }
    }

    private void bCO() {
        if (this.gQf == null && this.gQv != null) {
            this.gQf = this.gQv.bCA();
        }
        if (this.gQf != null) {
            if (this.gQf.bCU() != null) {
                this.gRc.notifyDataSetChanged();
                return;
            }
            tO("-1");
            if (this.gQf.isOriginalImg()) {
                nm(this.gQf.isOriginalImg());
            }
        }
    }

    private void tO(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cqz.a(str, new com.baidu.tbadk.b.d() { // from class: com.baidu.tieba.write.album.l.6
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
                        l.this.bDa();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!v.v(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a();
                        aVar.ca("-1");
                        String string = l.this.gQv.getPageContext().getString(d.j.album_all);
                        aVar.setName(string);
                        aVar.cb(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.mTitleText.setText(string);
                        l.this.gQf.dH(arrayList2);
                        l.this.gQf.dI(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        this.cqz.a(new com.baidu.tbadk.b.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.b.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.b.c
            public void n(List<com.baidu.tbadk.b.a> list) {
                l.this.gQf.dH(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gRc != null) {
                this.gQf.dG(list);
                this.gRc.setData(this.gQf.bCW());
            }
            bCZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gQv.getLayoutMode().ag(i == 1);
        this.gQv.getLayoutMode().t(this.mView);
        if (this.gRc != null) {
            this.gRc.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View blY() {
        return this.bvM;
    }

    public View bDb() {
        return this.gQD;
    }

    public TbCameraView bCE() {
        return this.gRe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cqz != null) {
            this.cqz.nz();
        }
        f.bCX().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eJY = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void np(boolean z) {
        NP();
    }

    private void NP() {
        if (!isHidden() && !this.eJY) {
            bCO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        super.onScroll(absListView, i, i2, i3);
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            vk(childAt.getHeight() + iArr[1]);
        }
    }

    private void vk(int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (i >= 0) {
            if (this.gRo.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.gRo.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.topMargin = i / 2;
            this.gRo.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gRc.im(true);
        } else if (this.gRc.isScroll()) {
            this.gRc.im(false);
            agZ();
        }
    }

    private void agZ() {
        int childCount = this.gRb.getChildCount();
        int firstVisiblePosition = this.gRb.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gRb.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.pic);
                ImageFileInfo item = this.gRc.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gQv.aOH().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gRb.findViewWithTag(str);
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
        if (this.gRc != null) {
            this.gRc.setData(this.gQf.bCW());
        }
        bCZ();
    }

    public void H(int i, boolean z) {
        if (this.gRb != null) {
            int firstVisiblePosition = this.gRb.getFirstVisiblePosition();
            int lastVisiblePosition = this.gRb.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gRb.getChildAt(i - firstVisiblePosition);
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
        bCZ();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gRc != null) {
            H(this.gRc.g(imageFileInfo), z);
        }
    }

    public boolean bDc() {
        return this.gRb != null && this.gRb.getVisibility() == 0;
    }

    public View bCJ() {
        return this.gQE;
    }

    public void nm(boolean z) {
        if (this.gQv != null && this.gQE != null) {
            String string = this.gQv.getResources().getString(d.j.original_img);
            if (z) {
                this.gQE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                this.gQE.setText(string);
                this.gQE.setTextColor(this.gQv.getResources().getColor(d.C0080d.cp_link_tip_a));
                return;
            }
            this.gQE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gQE.setText(string);
            this.gQE.setTextColor(this.gQv.getResources().getColor(d.C0080d.cp_cont_i));
        }
    }
}
