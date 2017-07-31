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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
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
/* loaded from: classes.dex */
public class l extends BaseFragment implements AbsListView.OnScrollListener, f.a {
    private View bIU;
    private RelativeLayout bYq;
    private TextView cdk;
    private boolean eGT;
    private com.baidu.tbadk.c.b epT;
    private TextView gAV;
    private com.baidu.tieba.write.view.a gAW;
    private TransparentHeadGridView gAX;
    private k gAY;
    private View gAZ;
    private AlbumActivity gAh;
    private View gBb;
    private View gBc;
    private View gBd;
    private View gBe;
    private View gBf;
    private View gBg;
    private View gBh;
    private Animation gBi;
    private Animation gBj;
    private View gBk;
    private View gBm;
    private View gBn;
    private ImageView gdB;
    private e gzR;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private int mScreenWidth;
    private View mView;
    private TbCameraView gBa = null;
    private int gBl = 0;
    private String ajt = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gBo = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gzR.getMaxImagesAllowed();
            if (l.this.gzR.size() < maxImagesAllowed) {
                l.this.gAX.byx();
                l.this.bIU.setVisibility(8);
                l.this.gBf.setAlpha(1.0f);
                l.this.gBk.setVisibility(8);
                l.this.gBk.setAlpha(1.0f);
                l.this.gBn.setVisibility(8);
                l.this.gBn.setAlpha(1.0f);
                return;
            }
            l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (view.getId() == l.this.cdk.getId()) {
                l.this.gAW.c(l.this.gzR.byl(), l.this.gzR.byj());
                l.this.gAW.aJ(l.this.bIU);
                if (l.this.gBl <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.cdk.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gBc.getId()) {
                if (view.getId() == l.this.gBd.getId()) {
                    int maxImagesAllowed = l.this.gzR.getMaxImagesAllowed();
                    if (l.this.gzR.size() < maxImagesAllowed || l.this.gAh.bxS()) {
                        l.this.gzR.sT(String.valueOf(System.currentTimeMillis()));
                        l.this.gAh.iw(l.this.gzR.byn());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gBe.getId()) {
                    if (l.this.gBa != null) {
                        l.this.gBa.bqj();
                    }
                } else if (view.getId() != l.this.gBh.getId()) {
                    if (view.getId() == l.this.gBg.getId() && l.this.gBa != null) {
                        l.this.gBa.bql();
                    }
                } else {
                    l.this.byq();
                }
            } else {
                l.this.nd(true);
                l.this.bqi();
            }
        }
    };
    private TbCameraView.c gBp = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bqb() {
            return !aa.d(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gBq = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bqc() {
            if (l.this.gAh != null) {
                l.this.gAh.showToast(l.this.gAh.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gBr = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void bD(int i, int i2) {
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
                ViewGroup.LayoutParams layoutParams = l.this.gBa.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gBa.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gBs = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gBl <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.cdk.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gBt = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bqe() {
            l.this.nd(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bqf() {
            if (l.this.gAh != null) {
                l.this.gAh.bqf();
            }
            l.this.bqi();
            if (l.this.gAh != null) {
                l.this.gAh.bxP();
            }
        }
    };
    private TransparentHeadGridView.b gBu = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void uj(int i) {
            l.this.bIU.setAlpha(1.0f - (i / 100.0f));
            l.this.gBf.setAlpha(i / 100.0f);
            l.this.gBk.setAlpha(1.0f - (i / 100.0f));
            l.this.gBn.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void bpP() {
            l.this.bIU.setVisibility(8);
            l.this.gBf.setAlpha(1.0f);
            l.this.gBk.setVisibility(8);
            l.this.gBk.setAlpha(1.0f);
            l.this.gBn.setVisibility(8);
            l.this.gBn.setAlpha(1.0f);
        }
    };
    private Animation.AnimationListener gBv = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gBf.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gBw = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void ui(int i) {
            l.this.gBl = i;
            if (i <= 50) {
                l.this.cdk.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.cdk.setCompoundDrawables(null, null, drawable, null);
                l.this.gAV.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                l.this.gdB.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bIU.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.cdk.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.cdk.setCompoundDrawables(null, null, drawable2, null);
                l.this.gAV.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                l.this.gdB.setImageResource(d.g.icon_topbar_close_n);
                l.this.bIU.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gAZ.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gAK = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gzR.ub(i);
            l.this.gAh.uc(1);
        }
    };
    private a.InterfaceC0127a gBx = new a.InterfaceC0127a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0127a
        public void a(int i, com.baidu.tbadk.c.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gzR.byj())) {
                List<ImageFileInfo> bym = l.this.gzR.bym();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bym) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bym = arrayList;
                }
                l.this.gzR.dz(bym);
                l.this.gzR.sS(albumId);
                l.this.setData(bym);
                l.this.cdk.setText(name);
                l.this.gAX.smoothScrollToPosition(0);
            }
        }
    };
    private j gAL = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean f;
            if (z) {
                l.this.gAV.setText(l.this.gAh.getResources().getText(d.l.next_step));
                f = l.this.gAh.e(imageFileInfo);
                if (l.this.gzR.isOriginalImg()) {
                    l.this.gAh.bxV();
                }
            } else {
                f = l.this.gAh.f(imageFileInfo);
            }
            l.this.byr();
            return f;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAh = (AlbumActivity) getBaseFragmentActivity();
        this.gzR = this.gAh.bxR();
        f.byp().a(this);
        this.epT = new com.baidu.tbadk.c.b(this.gAh.getPageContext().getPageActivity());
        this.gAW = new com.baidu.tieba.write.view.a(this.gAh);
        this.gAW.setOnDismissListener(this.gBs);
        this.gzR.sS("-1");
        if (getActivity().getIntent() != null) {
            this.ajt = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.bYq = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.gdB = (ImageView) this.mView.findViewById(d.h.img_close);
        this.gdB.setOnClickListener(this.gAh);
        this.gAV = (TextView) this.mView.findViewById(d.h.next_step);
        this.gAV.setOnClickListener(this.gAh);
        this.cdk = (TextView) this.mView.findViewById(d.h.album_title);
        this.cdk.setOnClickListener(this.mOnClickListener);
        this.gAX = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gAY = new k(this.gAh, this.gzR);
        this.gAX.setAdapter((ListAdapter) this.gAY);
        this.gAX.setOuterOnScrollListener(this);
        this.gAX.setSelector(d.e.transparent);
        this.gAX.setOnHeadDisplayChangeListener(this.gBw);
        this.gAX.setOnPullChangeListener(this.gBu);
        this.gAW.a(this.gBx);
        this.gAY.a(this.gAL);
        this.gAY.a(this.gAK);
        this.gAY.l(this.gBo);
        this.mNoDataView = NoDataViewFactory.a(this.gAh.getPageContext().getPageActivity(), this.bYq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bIU = this.mView.findViewById(d.h.layout_title);
        this.gAZ = this.mView.findViewById(d.h.top_bar_background);
        this.gAZ.setAlpha(0.0f);
        this.gBa = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gBa.setOnGotPictureListener(this.gBt);
        this.gBa.setOnPreviewSizeChangedListener(this.gBr);
        this.gBb = this.mView.findViewById(d.h.camera_view_container);
        this.gBc = this.mView.findViewById(d.h.img_pic_cancel);
        this.gBc.setOnClickListener(this.mOnClickListener);
        this.gBd = this.mView.findViewById(d.h.img_take_picture);
        this.gBd.setOnClickListener(this.mOnClickListener);
        this.gBe = this.mView.findViewById(d.h.img_pic_save);
        this.gBe.setOnClickListener(this.mOnClickListener);
        this.gBf = this.mView.findViewById(d.h.camera_bar);
        this.gBf.setAlpha(0.0f);
        this.gBg = this.mView.findViewById(d.h.btn_camera_switch);
        this.gBg.setOnClickListener(this.mOnClickListener);
        this.gBh = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gBh.setOnClickListener(this.mOnClickListener);
        this.gBi = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gBj = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gBj.setAnimationListener(this.gBv);
        this.gAX.setBottomMoveView(this.gBb);
        this.gBm = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gBm.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gBm.setLayoutParams(layoutParams);
        this.gAY.uh((this.mScreenWidth - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gBk = this.mView.findViewById(d.h.icon_camera);
        this.gBn = this.mView.findViewById(d.h.view_camera_cover);
        this.gBa.setOnRequestPermissionListener(this.gBp);
        byr();
        this.gBa.setOnOpenCameraFailedListener(this.gBq);
        nd(true);
        return this.mView;
    }

    public void bqi() {
        if (this.gBa != null) {
            this.gBa.byv();
            this.gBa.bqi();
        }
    }

    public void byq() {
        this.gAX.byw();
        this.bIU.setVisibility(0);
        this.bIU.setAlpha(1.0f);
        this.bIU.startAnimation(this.gBi);
        this.gBf.startAnimation(this.gBj);
        this.gBk.setVisibility(0);
        this.gBk.startAnimation(this.gBi);
        this.gBn.setVisibility(0);
    }

    public void nd(boolean z) {
        if (z) {
            this.gBc.setVisibility(4);
            this.gBd.setVisibility(0);
            this.gBe.setVisibility(4);
            this.gBh.setVisibility(0);
            this.gBg.setVisibility(0);
            return;
        }
        this.gBc.setVisibility(0);
        this.gBd.setVisibility(4);
        this.gBe.setVisibility(0);
        this.gBh.setVisibility(8);
        this.gBg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byr() {
        if (this.gzR.getWriteImagesInfo() != null && this.gzR.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.gzR.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.ajt)) {
                this.gAV.setText(this.gAh.getResources().getText(d.l.next_step));
            } else {
                this.gAV.setText(this.gAh.getResources().getText(d.l.skip));
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
        this.eGT = false;
        if (isShow()) {
            afu();
        }
    }

    private void byg() {
        if (this.gzR == null && this.gAh != null) {
            this.gzR = this.gAh.bxR();
        }
        if (this.gzR != null) {
            if (this.gzR.bym() != null) {
                this.gAY.notifyDataSetChanged();
            } else {
                sU("-1");
            }
        }
    }

    private void sU(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.epT.a(str, new com.baidu.tbadk.c.d() { // from class: com.baidu.tieba.write.album.l.6
                @Override // com.baidu.tbadk.c.d
                public void onPreLoad() {
                }

                @Override // com.baidu.tbadk.c.d
                public void a(List<com.baidu.tbadk.c.a> list, List<ImageFileInfo> list2, String str2) {
                    ArrayList arrayList = new ArrayList();
                    if (!u.v(list2)) {
                        arrayList.addAll(list2);
                    }
                    if (!str.equals("-1")) {
                        l.this.cdk.setText(str2);
                        l.this.bys();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!u.v(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a();
                        aVar.cd("-1");
                        String string = l.this.gAh.getPageContext().getString(d.l.write_album_all);
                        aVar.setName(string);
                        aVar.ce(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.cdk.setText(string);
                        l.this.gzR.dA(arrayList2);
                        l.this.gzR.dB(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bys() {
        this.epT.a(new com.baidu.tbadk.c.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.c.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.c.c
            public void m(List<com.baidu.tbadk.c.a> list) {
                l.this.gzR.dA(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gAY != null) {
                this.gzR.dz(list);
                this.gAY.setData(this.gzR.byo());
            }
            byr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAh.getLayoutMode().ah(i == 1);
        this.gAh.getLayoutMode().t(this.mView);
        if (this.gAY != null) {
            this.gAY.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bkK() {
        return this.gdB;
    }

    public View byt() {
        return this.gAV;
    }

    public TbCameraView bxX() {
        return this.gBa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.epT != null) {
            this.epT.nI();
        }
        f.byp().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eGT = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nc(boolean z) {
        afu();
    }

    private void afu() {
        if (!isHidden() && !this.eGT) {
            byg();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (i == 0) {
            int[] iArr = new int[2];
            View childAt = absListView.getChildAt(0);
            if (childAt != null) {
                childAt.getLocationInWindow(iArr);
                int height = childAt.getHeight() + iArr[1];
                if (height >= 0 && (this.gBk.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gBk.getLayoutParams();
                    layoutParams.topMargin = height / 2;
                    this.gBk.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gAY.iv(true);
        } else if (this.gAY.isScroll()) {
            this.gAY.iv(false);
            aLh();
        }
    }

    private void aLh() {
        int childCount = this.gAX.getChildCount();
        int firstVisiblePosition = this.gAX.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gAX.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gAY.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gAh.amK().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gAX.findViewWithTag(str);
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
        if (this.gAY != null) {
            this.gAY.setData(this.gzR.byo());
        }
        byr();
    }

    public void J(int i, boolean z) {
        if (this.gAX != null) {
            int firstVisiblePosition = this.gAX.getFirstVisiblePosition();
            int lastVisiblePosition = this.gAX.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gAX.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    View findViewById = childAt.findViewById(d.h.select_icon);
                    if (z) {
                        ai.j(findViewById, d.g.btn_choose_photo_s);
                    } else {
                        ai.j(findViewById, d.g.btn_choose_photo_n);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        byr();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gAY != null) {
            J(this.gAY.h(imageFileInfo), z);
        }
    }

    public boolean byu() {
        return this.gAX != null && this.gAX.getVisibility() == 0;
    }
}
