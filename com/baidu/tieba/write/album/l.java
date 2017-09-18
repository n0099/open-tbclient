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
    private View bNn;
    private RelativeLayout ccS;
    private boolean eId;
    private com.baidu.tbadk.c.b ezv;
    private AlbumActivity gBF;
    private e gBq;
    private View gCA;
    private View gCB;
    private View gCC;
    private View gCD;
    private View gCE;
    private View gCF;
    private Animation gCG;
    private Animation gCH;
    private View gCI;
    private View gCK;
    private View gCL;
    private TextView gCt;
    private com.baidu.tieba.write.view.a gCu;
    private TransparentHeadGridView gCv;
    private k gCw;
    private View gCx;
    private View gCz;
    private ImageView geQ;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private int mScreenWidth;
    private TextView mTitleText;
    private View mView;
    private TbCameraView gCy = null;
    private int gCJ = 0;
    private String aiO = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gCM = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gBq.getMaxImagesAllowed();
            if (l.this.gBq.size() < maxImagesAllowed) {
                l.this.gCv.byy();
                l.this.bNn.setVisibility(8);
                l.this.gCD.setAlpha(1.0f);
                l.this.gCI.setVisibility(8);
                l.this.gCI.setAlpha(1.0f);
                l.this.gCL.setVisibility(8);
                l.this.gCL.setAlpha(1.0f);
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
                l.this.gCu.c(l.this.gBq.bym(), l.this.gBq.byk());
                l.this.gCu.aS(l.this.bNn);
                if (l.this.gCJ <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gCA.getId()) {
                if (view.getId() == l.this.gCB.getId()) {
                    int maxImagesAllowed = l.this.gBq.getMaxImagesAllowed();
                    if (l.this.gBq.size() < maxImagesAllowed || l.this.gBF.bxU()) {
                        l.this.gBq.sX(String.valueOf(System.currentTimeMillis()));
                        l.this.gBF.iB(l.this.gBq.byo());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gCC.getId()) {
                    if (l.this.gCy != null) {
                        l.this.gCy.bqk();
                    }
                } else if (view.getId() != l.this.gCF.getId()) {
                    if (view.getId() == l.this.gCE.getId() && l.this.gCy != null) {
                        l.this.gCy.bqm();
                    }
                } else {
                    l.this.byr();
                }
            } else {
                l.this.nn(true);
                l.this.bqj();
            }
        }
    };
    private TbCameraView.c gCN = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bqc() {
            return !ab.d(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gCO = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bqd() {
            if (l.this.gBF != null) {
                l.this.gBF.showToast(l.this.gBF.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gCP = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void bR(int i, int i2) {
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
                ViewGroup.LayoutParams layoutParams = l.this.gCy.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gCy.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gCQ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gCJ <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gCR = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bqf() {
            l.this.nn(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bqg() {
            if (l.this.gBF != null) {
                l.this.gBF.bqg();
            }
            l.this.bqj();
            if (l.this.gBF != null) {
                l.this.gBF.bxR();
            }
        }
    };
    private TransparentHeadGridView.b gCS = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void ux(int i) {
            l.this.bNn.setAlpha(1.0f - (i / 100.0f));
            l.this.gCD.setAlpha(i / 100.0f);
            l.this.gCI.setAlpha(1.0f - (i / 100.0f));
            l.this.gCL.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void bpS() {
            l.this.bNn.setVisibility(8);
            l.this.gCD.setAlpha(1.0f);
            l.this.gCI.setVisibility(8);
            l.this.gCI.setAlpha(1.0f);
            l.this.gCL.setVisibility(8);
            l.this.gCL.setAlpha(1.0f);
        }
    };
    private Animation.AnimationListener gCT = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gCD.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gCU = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void uw(int i) {
            l.this.gCJ = i;
            if (i <= 50) {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
                l.this.gCt.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                l.this.geQ.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bNn.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable2, null);
                l.this.gCt.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                l.this.geQ.setImageResource(d.g.icon_topbar_close_n);
                l.this.bNn.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gCx.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gCi = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gBq.setCurrentIndex(i);
            l.this.gBF.up(1);
        }
    };
    private a.InterfaceC0130a gCV = new a.InterfaceC0130a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0130a
        public void a(int i, com.baidu.tbadk.c.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gBq.byk())) {
                List<ImageFileInfo> byn = l.this.gBq.byn();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : byn) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    byn = arrayList;
                }
                l.this.gBq.dB(byn);
                l.this.gBq.sW(albumId);
                l.this.setData(byn);
                l.this.mTitleText.setText(name);
                l.this.gCv.smoothScrollToPosition(0);
            }
        }
    };
    private j gCj = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean f;
            if (z) {
                l.this.gCt.setText(l.this.gBF.getResources().getText(d.l.next_step));
                f = l.this.gBF.e(imageFileInfo);
                if (l.this.gBq.isOriginalImg()) {
                    l.this.gBF.bxX();
                }
            } else {
                f = l.this.gBF.f(imageFileInfo);
            }
            l.this.bys();
            return f;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gBF = (AlbumActivity) getBaseFragmentActivity();
        this.gBq = this.gBF.bxT();
        f.byq().a(this);
        this.ezv = new com.baidu.tbadk.c.b(this.gBF.getPageContext().getPageActivity());
        this.gCu = new com.baidu.tieba.write.view.a(this.gBF);
        this.gCu.setOnDismissListener(this.gCQ);
        this.gBq.sW("-1");
        if (getActivity().getIntent() != null) {
            this.aiO = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.ccS = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.geQ = (ImageView) this.mView.findViewById(d.h.img_close);
        this.geQ.setOnClickListener(this.gBF);
        this.gCt = (TextView) this.mView.findViewById(d.h.next_step);
        this.gCt.setOnClickListener(this.gBF);
        this.mTitleText = (TextView) this.mView.findViewById(d.h.album_title);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.gCv = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gCw = new k(this.gBF, this.gBq);
        this.gCv.setAdapter((ListAdapter) this.gCw);
        this.gCv.setOuterOnScrollListener(this);
        this.gCv.setSelector(d.e.transparent);
        this.gCv.setOnHeadDisplayChangeListener(this.gCU);
        this.gCv.setOnPullChangeListener(this.gCS);
        this.gCu.a(this.gCV);
        this.gCw.a(this.gCj);
        this.gCw.a(this.gCi);
        this.gCw.h(this.gCM);
        this.mNoDataView = NoDataViewFactory.a(this.gBF.getPageContext().getPageActivity(), this.ccS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.B(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bNn = this.mView.findViewById(d.h.layout_title);
        this.gCx = this.mView.findViewById(d.h.top_bar_background);
        this.gCx.setAlpha(0.0f);
        this.gCy = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gCy.setOnGotPictureListener(this.gCR);
        this.gCy.setOnPreviewSizeChangedListener(this.gCP);
        this.gCz = this.mView.findViewById(d.h.camera_view_container);
        this.gCA = this.mView.findViewById(d.h.img_pic_cancel);
        this.gCA.setOnClickListener(this.mOnClickListener);
        this.gCB = this.mView.findViewById(d.h.img_take_picture);
        this.gCB.setOnClickListener(this.mOnClickListener);
        this.gCC = this.mView.findViewById(d.h.img_pic_save);
        this.gCC.setOnClickListener(this.mOnClickListener);
        this.gCD = this.mView.findViewById(d.h.camera_bar);
        this.gCD.setAlpha(0.0f);
        this.gCE = this.mView.findViewById(d.h.btn_camera_switch);
        this.gCE.setOnClickListener(this.mOnClickListener);
        this.gCF = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gCF.setOnClickListener(this.mOnClickListener);
        this.gCG = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gCH = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gCH.setAnimationListener(this.gCT);
        this.gCv.setBottomMoveView(this.gCz);
        this.gCK = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.ae(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gCK.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gCK.setLayoutParams(layoutParams);
        this.gCw.uu((this.mScreenWidth - com.baidu.adp.lib.util.k.f(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gCI = this.mView.findViewById(d.h.icon_camera);
        uv((int) (0.28f * com.baidu.adp.lib.util.k.af(this.gBF.getPageContext().getPageActivity())));
        this.gCL = this.mView.findViewById(d.h.view_camera_cover);
        this.gCy.setOnRequestPermissionListener(this.gCN);
        bys();
        this.gCy.setOnOpenCameraFailedListener(this.gCO);
        nn(true);
        return this.mView;
    }

    public void bqj() {
        if (this.gCy != null) {
            this.gCy.byw();
            this.gCy.bqj();
        }
    }

    public void byr() {
        this.gCv.byx();
        this.bNn.setVisibility(0);
        this.bNn.setAlpha(1.0f);
        this.bNn.startAnimation(this.gCG);
        this.gCD.startAnimation(this.gCH);
        this.gCI.setVisibility(0);
        this.gCI.startAnimation(this.gCG);
        this.gCL.setVisibility(0);
    }

    public void nn(boolean z) {
        if (z) {
            this.gCA.setVisibility(4);
            this.gCB.setVisibility(0);
            this.gCC.setVisibility(4);
            this.gCF.setVisibility(0);
            this.gCE.setVisibility(0);
            return;
        }
        this.gCA.setVisibility(0);
        this.gCB.setVisibility(4);
        this.gCC.setVisibility(0);
        this.gCF.setVisibility(8);
        this.gCE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bys() {
        if (this.gBq.getWriteImagesInfo() != null && this.gBq.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.gBq.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.aiO)) {
                this.gCt.setText(this.gBF.getResources().getText(d.l.next_step));
            } else {
                this.gCt.setText(this.gBF.getResources().getText(d.l.skip));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eId = false;
        if (isShow()) {
            ahu();
        }
    }

    private void byh() {
        if (this.gBq == null && this.gBF != null) {
            this.gBq = this.gBF.bxT();
        }
        if (this.gBq != null) {
            if (this.gBq.byn() != null) {
                this.gCw.notifyDataSetChanged();
            } else {
                sY("-1");
            }
        }
    }

    private void sY(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ezv.a(str, new com.baidu.tbadk.c.d() { // from class: com.baidu.tieba.write.album.l.6
                @Override // com.baidu.tbadk.c.d
                public void onPreLoad() {
                }

                @Override // com.baidu.tbadk.c.d
                public void a(List<com.baidu.tbadk.c.a> list, List<ImageFileInfo> list2, String str2) {
                    ArrayList arrayList = new ArrayList();
                    if (!v.v(list2)) {
                        arrayList.addAll(list2);
                    }
                    if (!str.equals("-1")) {
                        l.this.mTitleText.setText(str2);
                        l.this.byt();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!v.v(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a();
                        aVar.bW("-1");
                        String string = l.this.gBF.getPageContext().getString(d.l.album_all);
                        aVar.setName(string);
                        aVar.bX(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.mTitleText.setText(string);
                        l.this.gBq.dC(arrayList2);
                        l.this.gBq.dD(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byt() {
        this.ezv.a(new com.baidu.tbadk.c.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.c.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.c.c
            public void m(List<com.baidu.tbadk.c.a> list) {
                l.this.gBq.dC(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gCw != null) {
                this.gBq.dB(list);
                this.gCw.setData(this.gBq.byp());
            }
            bys();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gBF.getLayoutMode().ah(i == 1);
        this.gBF.getLayoutMode().t(this.mView);
        if (this.gCw != null) {
            this.gCw.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bku() {
        return this.geQ;
    }

    public View byu() {
        return this.gCt;
    }

    public TbCameraView bxY() {
        return this.gCy;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ezv != null) {
            this.ezv.nD();
        }
        f.byq().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eId = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nm(boolean z) {
        ahu();
    }

    private void ahu() {
        if (!isHidden() && !this.eId) {
            byh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        super.onScroll(absListView, i, i2, i3);
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            uv(childAt.getHeight() + iArr[1]);
        }
    }

    private void uv(int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (i >= 0) {
            if (this.gCI.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.gCI.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.topMargin = i / 2;
            this.gCI.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gCw.iH(true);
        } else if (this.gCw.isScroll()) {
            this.gCw.iH(false);
            aNG();
        }
    }

    private void aNG() {
        int childCount = this.gCv.getChildCount();
        int firstVisiblePosition = this.gCv.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gCv.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gCw.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gBF.apd().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gCv.findViewWithTag(str);
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
        if (this.gCw != null) {
            this.gCw.setData(this.gBq.byp());
        }
        bys();
    }

    public void F(int i, boolean z) {
        if (this.gCv != null) {
            int firstVisiblePosition = this.gCv.getFirstVisiblePosition();
            int lastVisiblePosition = this.gCv.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gCv.getChildAt(i - firstVisiblePosition);
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
        bys();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gCw != null) {
            F(this.gCw.h(imageFileInfo), z);
        }
    }

    public boolean byv() {
        return this.gCv != null && this.gCv.getVisibility() == 0;
    }
}
