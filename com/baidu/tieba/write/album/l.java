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
    private View bHK;
    private RelativeLayout bXk;
    private TextView cce;
    private boolean eFG;
    private com.baidu.tbadk.c.b eoC;
    private View gAb;
    private View gAc;
    private ImageView gcp;
    private e gyG;
    private AlbumActivity gyW;
    private TextView gzK;
    private com.baidu.tieba.write.view.a gzL;
    private TransparentHeadGridView gzM;
    private k gzN;
    private View gzO;
    private View gzQ;
    private View gzR;
    private View gzS;
    private View gzT;
    private View gzU;
    private View gzV;
    private View gzW;
    private Animation gzX;
    private Animation gzY;
    private View gzZ;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private int mScreenWidth;
    private View mView;
    private TbCameraView gzP = null;
    private int gAa = 0;
    private String aia = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gAd = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gyG.getMaxImagesAllowed();
            if (l.this.gyG.size() < maxImagesAllowed) {
                l.this.gzM.byq();
                l.this.bHK.setVisibility(8);
                l.this.gzU.setAlpha(1.0f);
                l.this.gzZ.setVisibility(8);
                l.this.gzZ.setAlpha(1.0f);
                l.this.gAc.setVisibility(8);
                l.this.gAc.setAlpha(1.0f);
                return;
            }
            l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (view.getId() == l.this.cce.getId()) {
                l.this.gzL.c(l.this.gyG.bye(), l.this.gyG.byc());
                l.this.gzL.aJ(l.this.bHK);
                if (l.this.gAa <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.cce.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gzR.getId()) {
                if (view.getId() == l.this.gzS.getId()) {
                    int maxImagesAllowed = l.this.gyG.getMaxImagesAllowed();
                    if (l.this.gyG.size() < maxImagesAllowed || l.this.gyW.bxL()) {
                        l.this.gyG.sO(String.valueOf(System.currentTimeMillis()));
                        l.this.gyW.ir(l.this.gyG.byg());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gzT.getId()) {
                    if (l.this.gzP != null) {
                        l.this.gzP.bqc();
                    }
                } else if (view.getId() != l.this.gzW.getId()) {
                    if (view.getId() == l.this.gzV.getId() && l.this.gzP != null) {
                        l.this.gzP.bqe();
                    }
                } else {
                    l.this.byj();
                }
            } else {
                l.this.nd(true);
                l.this.bqb();
            }
        }
    };
    private TbCameraView.c gAe = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bpU() {
            return !aa.d(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gAf = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bpV() {
            if (l.this.gyW != null) {
                l.this.gyW.showToast(l.this.gyW.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gAg = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void bC(int i, int i2) {
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
                ViewGroup.LayoutParams layoutParams = l.this.gzP.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gzP.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gAh = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gAa <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.cce.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gAi = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bpX() {
            l.this.nd(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bpY() {
            if (l.this.gyW != null) {
                l.this.gyW.bpY();
            }
            l.this.bqb();
            if (l.this.gyW != null) {
                l.this.gyW.bxI();
            }
        }
    };
    private TransparentHeadGridView.b gAj = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void uk(int i) {
            l.this.bHK.setAlpha(1.0f - (i / 100.0f));
            l.this.gzU.setAlpha(i / 100.0f);
            l.this.gzZ.setAlpha(1.0f - (i / 100.0f));
            l.this.gAc.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void bpI() {
            l.this.bHK.setVisibility(8);
            l.this.gzU.setAlpha(1.0f);
            l.this.gzZ.setVisibility(8);
            l.this.gzZ.setAlpha(1.0f);
            l.this.gAc.setVisibility(8);
            l.this.gAc.setAlpha(1.0f);
        }
    };
    private Animation.AnimationListener gAk = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gzU.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gAl = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void uj(int i) {
            l.this.gAa = i;
            if (i <= 50) {
                l.this.cce.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.cce.setCompoundDrawables(null, null, drawable, null);
                l.this.gzK.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                l.this.gcp.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bHK.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.cce.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.cce.setCompoundDrawables(null, null, drawable2, null);
                l.this.gzK.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                l.this.gcp.setImageResource(d.g.icon_topbar_close_n);
                l.this.bHK.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gzO.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gzz = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gyG.uc(i);
            l.this.gyW.ud(1);
        }
    };
    private a.InterfaceC0128a gAm = new a.InterfaceC0128a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0128a
        public void a(int i, com.baidu.tbadk.c.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gyG.byc())) {
                List<ImageFileInfo> byf = l.this.gyG.byf();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : byf) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    byf = arrayList;
                }
                l.this.gyG.dz(byf);
                l.this.gyG.sN(albumId);
                l.this.setData(byf);
                l.this.cce.setText(name);
                l.this.gzM.smoothScrollToPosition(0);
            }
        }
    };
    private j gzA = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean f;
            if (z) {
                l.this.gzK.setText(l.this.gyW.getResources().getText(d.l.next_step));
                f = l.this.gyW.e(imageFileInfo);
                if (l.this.gyG.isOriginalImg()) {
                    l.this.gyW.bxO();
                }
            } else {
                f = l.this.gyW.f(imageFileInfo);
            }
            l.this.byk();
            return f;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gyW = (AlbumActivity) getBaseFragmentActivity();
        this.gyG = this.gyW.bxK();
        f.byi().a(this);
        this.eoC = new com.baidu.tbadk.c.b(this.gyW.getPageContext().getPageActivity());
        this.gzL = new com.baidu.tieba.write.view.a(this.gyW);
        this.gzL.setOnDismissListener(this.gAh);
        this.gyG.sN("-1");
        if (getActivity().getIntent() != null) {
            this.aia = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.bXk = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.gcp = (ImageView) this.mView.findViewById(d.h.img_close);
        this.gcp.setOnClickListener(this.gyW);
        this.gzK = (TextView) this.mView.findViewById(d.h.next_step);
        this.gzK.setOnClickListener(this.gyW);
        this.cce = (TextView) this.mView.findViewById(d.h.album_title);
        this.cce.setOnClickListener(this.mOnClickListener);
        this.gzM = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gzN = new k(this.gyW, this.gyG);
        this.gzM.setAdapter((ListAdapter) this.gzN);
        this.gzM.setOuterOnScrollListener(this);
        this.gzM.setSelector(d.e.transparent);
        this.gzM.setOnHeadDisplayChangeListener(this.gAl);
        this.gzM.setOnPullChangeListener(this.gAj);
        this.gzL.a(this.gAm);
        this.gzN.a(this.gzA);
        this.gzN.a(this.gzz);
        this.gzN.l(this.gAd);
        this.mNoDataView = NoDataViewFactory.a(this.gyW.getPageContext().getPageActivity(), this.bXk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.B(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bHK = this.mView.findViewById(d.h.layout_title);
        this.gzO = this.mView.findViewById(d.h.top_bar_background);
        this.gzO.setAlpha(0.0f);
        this.gzP = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gzP.setOnGotPictureListener(this.gAi);
        this.gzP.setOnPreviewSizeChangedListener(this.gAg);
        this.gzQ = this.mView.findViewById(d.h.camera_view_container);
        this.gzR = this.mView.findViewById(d.h.img_pic_cancel);
        this.gzR.setOnClickListener(this.mOnClickListener);
        this.gzS = this.mView.findViewById(d.h.img_take_picture);
        this.gzS.setOnClickListener(this.mOnClickListener);
        this.gzT = this.mView.findViewById(d.h.img_pic_save);
        this.gzT.setOnClickListener(this.mOnClickListener);
        this.gzU = this.mView.findViewById(d.h.camera_bar);
        this.gzU.setAlpha(0.0f);
        this.gzV = this.mView.findViewById(d.h.btn_camera_switch);
        this.gzV.setOnClickListener(this.mOnClickListener);
        this.gzW = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gzW.setOnClickListener(this.mOnClickListener);
        this.gzX = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gzY = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gzY.setAnimationListener(this.gAk);
        this.gzM.setBottomMoveView(this.gzQ);
        this.gAb = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gAb.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gAb.setLayoutParams(layoutParams);
        this.gzN.ui((this.mScreenWidth - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gzZ = this.mView.findViewById(d.h.icon_camera);
        this.gAc = this.mView.findViewById(d.h.view_camera_cover);
        this.gzP.setOnRequestPermissionListener(this.gAe);
        byk();
        this.gzP.setOnOpenCameraFailedListener(this.gAf);
        nd(true);
        return this.mView;
    }

    public void bqb() {
        if (this.gzP != null) {
            this.gzP.byo();
            this.gzP.bqb();
        }
    }

    public void byj() {
        this.gzM.byp();
        this.bHK.setVisibility(0);
        this.bHK.setAlpha(1.0f);
        this.bHK.startAnimation(this.gzX);
        this.gzU.startAnimation(this.gzY);
        this.gzZ.setVisibility(0);
        this.gzZ.startAnimation(this.gzX);
        this.gAc.setVisibility(0);
    }

    public void nd(boolean z) {
        if (z) {
            this.gzR.setVisibility(4);
            this.gzS.setVisibility(0);
            this.gzT.setVisibility(4);
            this.gzW.setVisibility(0);
            this.gzV.setVisibility(0);
            return;
        }
        this.gzR.setVisibility(0);
        this.gzS.setVisibility(4);
        this.gzT.setVisibility(0);
        this.gzW.setVisibility(8);
        this.gzV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byk() {
        if (this.gyG.getWriteImagesInfo() != null && this.gyG.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.gyG.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.aia)) {
                this.gzK.setText(this.gyW.getResources().getText(d.l.next_step));
            } else {
                this.gzK.setText(this.gyW.getResources().getText(d.l.skip));
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
        this.eFG = false;
        if (isShow()) {
            afp();
        }
    }

    private void bxZ() {
        if (this.gyG == null && this.gyW != null) {
            this.gyG = this.gyW.bxK();
        }
        if (this.gyG != null) {
            if (this.gyG.byf() != null) {
                this.gzN.notifyDataSetChanged();
            } else {
                sP("-1");
            }
        }
    }

    private void sP(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eoC.a(str, new com.baidu.tbadk.c.d() { // from class: com.baidu.tieba.write.album.l.6
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
                        l.this.cce.setText(str2);
                        l.this.byl();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!u.v(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a();
                        aVar.bX("-1");
                        String string = l.this.gyW.getPageContext().getString(d.l.write_album_all);
                        aVar.setName(string);
                        aVar.bY(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.cce.setText(string);
                        l.this.gyG.dA(arrayList2);
                        l.this.gyG.dB(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byl() {
        this.eoC.a(new com.baidu.tbadk.c.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.c.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.c.c
            public void m(List<com.baidu.tbadk.c.a> list) {
                l.this.gyG.dA(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gzN != null) {
                this.gyG.dz(list);
                this.gzN.setData(this.gyG.byh());
            }
            byk();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gyW.getLayoutMode().ah(i == 1);
        this.gyW.getLayoutMode().t(this.mView);
        if (this.gzN != null) {
            this.gzN.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bkA() {
        return this.gcp;
    }

    public View bym() {
        return this.gzK;
    }

    public TbCameraView bxQ() {
        return this.gzP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eoC != null) {
            this.eoC.ny();
        }
        f.byi().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eFG = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nc(boolean z) {
        afp();
    }

    private void afp() {
        if (!isHidden() && !this.eFG) {
            bxZ();
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
                if (height >= 0 && (this.gzZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzZ.getLayoutParams();
                    layoutParams.topMargin = height / 2;
                    this.gzZ.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gzN.iv(true);
        } else if (this.gzN.isScroll()) {
            this.gzN.iv(false);
            aKW();
        }
    }

    private void aKW() {
        int childCount = this.gzM.getChildCount();
        int firstVisiblePosition = this.gzM.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gzM.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gzN.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gyW.amx().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gzM.findViewWithTag(str);
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
        if (this.gzN != null) {
            this.gzN.setData(this.gyG.byh());
        }
        byk();
    }

    public void I(int i, boolean z) {
        if (this.gzM != null) {
            int firstVisiblePosition = this.gzM.getFirstVisiblePosition();
            int lastVisiblePosition = this.gzM.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gzM.getChildAt(i - firstVisiblePosition);
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
        byk();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gzN != null) {
            I(this.gzN.h(imageFileInfo), z);
        }
    }

    public boolean byn() {
        return this.gzM != null && this.gzM.getVisibility() == 0;
    }
}
