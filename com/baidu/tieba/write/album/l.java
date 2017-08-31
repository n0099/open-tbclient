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
    private View bMw;
    private RelativeLayout cca;
    private boolean eHj;
    private com.baidu.tbadk.c.b eyB;
    private AlbumActivity gAM;
    private e gAx;
    private TextView gBA;
    private com.baidu.tieba.write.view.a gBB;
    private TransparentHeadGridView gBC;
    private k gBD;
    private View gBE;
    private View gBG;
    private View gBH;
    private View gBI;
    private View gBJ;
    private View gBK;
    private View gBL;
    private View gBM;
    private Animation gBN;
    private Animation gBO;
    private View gBP;
    private View gBR;
    private View gBS;
    private ImageView gdW;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private int mScreenWidth;
    private TextView mTitleText;
    private View mView;
    private TbCameraView gBF = null;
    private int gBQ = 0;
    private String aiP = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gBT = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gAx.getMaxImagesAllowed();
            if (l.this.gAx.size() < maxImagesAllowed) {
                l.this.gBC.byn();
                l.this.bMw.setVisibility(8);
                l.this.gBK.setAlpha(1.0f);
                l.this.gBP.setVisibility(8);
                l.this.gBP.setAlpha(1.0f);
                l.this.gBS.setVisibility(8);
                l.this.gBS.setAlpha(1.0f);
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
                l.this.gBB.c(l.this.gAx.byb(), l.this.gAx.bxZ());
                l.this.gBB.aS(l.this.bMw);
                if (l.this.gBQ <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gBH.getId()) {
                if (view.getId() == l.this.gBI.getId()) {
                    int maxImagesAllowed = l.this.gAx.getMaxImagesAllowed();
                    if (l.this.gAx.size() < maxImagesAllowed || l.this.gAM.bxJ()) {
                        l.this.gAx.sV(String.valueOf(System.currentTimeMillis()));
                        l.this.gAM.iB(l.this.gAx.byd());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gBJ.getId()) {
                    if (l.this.gBF != null) {
                        l.this.gBF.bpZ();
                    }
                } else if (view.getId() != l.this.gBM.getId()) {
                    if (view.getId() == l.this.gBL.getId() && l.this.gBF != null) {
                        l.this.gBF.bqb();
                    }
                } else {
                    l.this.byg();
                }
            } else {
                l.this.nm(true);
                l.this.bpY();
            }
        }
    };
    private TbCameraView.c gBU = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bpR() {
            return !ab.d(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gBV = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bpS() {
            if (l.this.gAM != null) {
                l.this.gAM.showToast(l.this.gAM.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gBW = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void bN(int i, int i2) {
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
                ViewGroup.LayoutParams layoutParams = l.this.gBF.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gBF.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gBX = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gBQ <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gBY = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bpU() {
            l.this.nm(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bpV() {
            if (l.this.gAM != null) {
                l.this.gAM.bpV();
            }
            l.this.bpY();
            if (l.this.gAM != null) {
                l.this.gAM.bxG();
            }
        }
    };
    private TransparentHeadGridView.b gBZ = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void uv(int i) {
            l.this.bMw.setAlpha(1.0f - (i / 100.0f));
            l.this.gBK.setAlpha(i / 100.0f);
            l.this.gBP.setAlpha(1.0f - (i / 100.0f));
            l.this.gBS.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void bpH() {
            l.this.bMw.setVisibility(8);
            l.this.gBK.setAlpha(1.0f);
            l.this.gBP.setVisibility(8);
            l.this.gBP.setAlpha(1.0f);
            l.this.gBS.setVisibility(8);
            l.this.gBS.setAlpha(1.0f);
        }
    };
    private Animation.AnimationListener gCa = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gBK.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gCb = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void uu(int i) {
            l.this.gBQ = i;
            if (i <= 50) {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
                l.this.gBA.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                l.this.gdW.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bMw.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable2, null);
                l.this.gBA.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                l.this.gdW.setImageResource(d.g.icon_topbar_close_n);
                l.this.bMw.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gBE.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gBp = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gAx.setCurrentIndex(i);
            l.this.gAM.un(1);
        }
    };
    private a.InterfaceC0131a gCc = new a.InterfaceC0131a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0131a
        public void a(int i, com.baidu.tbadk.c.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gAx.bxZ())) {
                List<ImageFileInfo> byc = l.this.gAx.byc();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : byc) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    byc = arrayList;
                }
                l.this.gAx.dA(byc);
                l.this.gAx.sU(albumId);
                l.this.setData(byc);
                l.this.mTitleText.setText(name);
                l.this.gBC.smoothScrollToPosition(0);
            }
        }
    };
    private j gBq = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean f;
            if (z) {
                l.this.gBA.setText(l.this.gAM.getResources().getText(d.l.next_step));
                f = l.this.gAM.e(imageFileInfo);
                if (l.this.gAx.isOriginalImg()) {
                    l.this.gAM.bxM();
                }
            } else {
                f = l.this.gAM.f(imageFileInfo);
            }
            l.this.byh();
            return f;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAM = (AlbumActivity) getBaseFragmentActivity();
        this.gAx = this.gAM.bxI();
        f.byf().a(this);
        this.eyB = new com.baidu.tbadk.c.b(this.gAM.getPageContext().getPageActivity());
        this.gBB = new com.baidu.tieba.write.view.a(this.gAM);
        this.gBB.setOnDismissListener(this.gBX);
        this.gAx.sU("-1");
        if (getActivity().getIntent() != null) {
            this.aiP = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.cca = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.gdW = (ImageView) this.mView.findViewById(d.h.img_close);
        this.gdW.setOnClickListener(this.gAM);
        this.gBA = (TextView) this.mView.findViewById(d.h.next_step);
        this.gBA.setOnClickListener(this.gAM);
        this.mTitleText = (TextView) this.mView.findViewById(d.h.album_title);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.gBC = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gBD = new k(this.gAM, this.gAx);
        this.gBC.setAdapter((ListAdapter) this.gBD);
        this.gBC.setOuterOnScrollListener(this);
        this.gBC.setSelector(d.e.transparent);
        this.gBC.setOnHeadDisplayChangeListener(this.gCb);
        this.gBC.setOnPullChangeListener(this.gBZ);
        this.gBB.a(this.gCc);
        this.gBD.a(this.gBq);
        this.gBD.a(this.gBp);
        this.gBD.h(this.gBT);
        this.mNoDataView = NoDataViewFactory.a(this.gAM.getPageContext().getPageActivity(), this.cca, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.B(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bMw = this.mView.findViewById(d.h.layout_title);
        this.gBE = this.mView.findViewById(d.h.top_bar_background);
        this.gBE.setAlpha(0.0f);
        this.gBF = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gBF.setOnGotPictureListener(this.gBY);
        this.gBF.setOnPreviewSizeChangedListener(this.gBW);
        this.gBG = this.mView.findViewById(d.h.camera_view_container);
        this.gBH = this.mView.findViewById(d.h.img_pic_cancel);
        this.gBH.setOnClickListener(this.mOnClickListener);
        this.gBI = this.mView.findViewById(d.h.img_take_picture);
        this.gBI.setOnClickListener(this.mOnClickListener);
        this.gBJ = this.mView.findViewById(d.h.img_pic_save);
        this.gBJ.setOnClickListener(this.mOnClickListener);
        this.gBK = this.mView.findViewById(d.h.camera_bar);
        this.gBK.setAlpha(0.0f);
        this.gBL = this.mView.findViewById(d.h.btn_camera_switch);
        this.gBL.setOnClickListener(this.mOnClickListener);
        this.gBM = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gBM.setOnClickListener(this.mOnClickListener);
        this.gBN = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gBO = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gBO.setAnimationListener(this.gCa);
        this.gBC.setBottomMoveView(this.gBG);
        this.gBR = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.ad(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gBR.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gBR.setLayoutParams(layoutParams);
        this.gBD.us((this.mScreenWidth - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gBP = this.mView.findViewById(d.h.icon_camera);
        ut((int) (0.28f * com.baidu.adp.lib.util.k.ae(this.gAM.getPageContext().getPageActivity())));
        this.gBS = this.mView.findViewById(d.h.view_camera_cover);
        this.gBF.setOnRequestPermissionListener(this.gBU);
        byh();
        this.gBF.setOnOpenCameraFailedListener(this.gBV);
        nm(true);
        return this.mView;
    }

    public void bpY() {
        if (this.gBF != null) {
            this.gBF.byl();
            this.gBF.bpY();
        }
    }

    public void byg() {
        this.gBC.bym();
        this.bMw.setVisibility(0);
        this.bMw.setAlpha(1.0f);
        this.bMw.startAnimation(this.gBN);
        this.gBK.startAnimation(this.gBO);
        this.gBP.setVisibility(0);
        this.gBP.startAnimation(this.gBN);
        this.gBS.setVisibility(0);
    }

    public void nm(boolean z) {
        if (z) {
            this.gBH.setVisibility(4);
            this.gBI.setVisibility(0);
            this.gBJ.setVisibility(4);
            this.gBM.setVisibility(0);
            this.gBL.setVisibility(0);
            return;
        }
        this.gBH.setVisibility(0);
        this.gBI.setVisibility(4);
        this.gBJ.setVisibility(0);
        this.gBM.setVisibility(8);
        this.gBL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byh() {
        if (this.gAx.getWriteImagesInfo() != null && this.gAx.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.gAx.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.aiP)) {
                this.gBA.setText(this.gAM.getResources().getText(d.l.next_step));
            } else {
                this.gBA.setText(this.gAM.getResources().getText(d.l.skip));
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
        this.eHj = false;
        if (isShow()) {
            ahj();
        }
    }

    private void bxW() {
        if (this.gAx == null && this.gAM != null) {
            this.gAx = this.gAM.bxI();
        }
        if (this.gAx != null) {
            if (this.gAx.byc() != null) {
                this.gBD.notifyDataSetChanged();
            } else {
                sW("-1");
            }
        }
    }

    private void sW(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eyB.a(str, new com.baidu.tbadk.c.d() { // from class: com.baidu.tieba.write.album.l.6
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
                        l.this.byi();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!v.v(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a();
                        aVar.bW("-1");
                        String string = l.this.gAM.getPageContext().getString(d.l.album_all);
                        aVar.setName(string);
                        aVar.bX(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.mTitleText.setText(string);
                        l.this.gAx.dB(arrayList2);
                        l.this.gAx.dC(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byi() {
        this.eyB.a(new com.baidu.tbadk.c.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.c.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.c.c
            public void m(List<com.baidu.tbadk.c.a> list) {
                l.this.gAx.dB(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gBD != null) {
                this.gAx.dA(list);
                this.gBD.setData(this.gAx.bye());
            }
            byh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAM.getLayoutMode().ah(i == 1);
        this.gAM.getLayoutMode().t(this.mView);
        if (this.gBD != null) {
            this.gBD.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bkj() {
        return this.gdW;
    }

    public View byj() {
        return this.gBA;
    }

    public TbCameraView bxN() {
        return this.gBF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eyB != null) {
            this.eyB.nD();
        }
        f.byf().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eHj = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nl(boolean z) {
        ahj();
    }

    private void ahj() {
        if (!isHidden() && !this.eHj) {
            bxW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        super.onScroll(absListView, i, i2, i3);
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            ut(childAt.getHeight() + iArr[1]);
        }
    }

    private void ut(int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (i >= 0) {
            if (this.gBP.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.gBP.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.topMargin = i / 2;
            this.gBP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gBD.iG(true);
        } else if (this.gBD.isScroll()) {
            this.gBD.iG(false);
            aNv();
        }
    }

    private void aNv() {
        int childCount = this.gBC.getChildCount();
        int firstVisiblePosition = this.gBC.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gBC.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gBD.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gAM.aoS().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gBC.findViewWithTag(str);
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
        if (this.gBD != null) {
            this.gBD.setData(this.gAx.bye());
        }
        byh();
    }

    public void F(int i, boolean z) {
        if (this.gBC != null) {
            int firstVisiblePosition = this.gBC.getFirstVisiblePosition();
            int lastVisiblePosition = this.gBC.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gBC.getChildAt(i - firstVisiblePosition);
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
        byh();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gBD != null) {
            F(this.gBD.h(imageFileInfo), z);
        }
    }

    public boolean byk() {
        return this.gBC != null && this.gBC.getVisibility() == 0;
    }
}
