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
    private View bJE;
    private RelativeLayout bZd;
    private TextView cdX;
    private boolean eIP;
    private com.baidu.tbadk.c.b erP;
    private e gBJ;
    private AlbumActivity gBZ;
    private TextView gCN;
    private com.baidu.tieba.write.view.a gCO;
    private TransparentHeadGridView gCP;
    private k gCQ;
    private View gCR;
    private View gCT;
    private View gCU;
    private View gCV;
    private View gCW;
    private View gCX;
    private View gCY;
    private View gCZ;
    private Animation gDa;
    private Animation gDb;
    private View gDc;
    private View gDe;
    private View gDf;
    private ImageView gft;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private int mScreenWidth;
    private View mView;
    private TbCameraView gCS = null;
    private int gDd = 0;
    private String ajv = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gDg = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gBJ.getMaxImagesAllowed();
            if (l.this.gBJ.size() < maxImagesAllowed) {
                l.this.gCP.byW();
                l.this.bJE.setVisibility(8);
                l.this.gCX.setAlpha(1.0f);
                l.this.gDc.setVisibility(8);
                l.this.gDc.setAlpha(1.0f);
                l.this.gDf.setVisibility(8);
                l.this.gDf.setAlpha(1.0f);
                return;
            }
            l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (view.getId() == l.this.cdX.getId()) {
                l.this.gCO.c(l.this.gBJ.byK(), l.this.gBJ.byI());
                l.this.gCO.aK(l.this.bJE);
                if (l.this.gDd <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.cdX.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gCU.getId()) {
                if (view.getId() == l.this.gCV.getId()) {
                    int maxImagesAllowed = l.this.gBJ.getMaxImagesAllowed();
                    if (l.this.gBJ.size() < maxImagesAllowed || l.this.gBZ.bys()) {
                        l.this.gBJ.ta(String.valueOf(System.currentTimeMillis()));
                        l.this.gBZ.iz(l.this.gBJ.byM());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gCW.getId()) {
                    if (l.this.gCS != null) {
                        l.this.gCS.bqK();
                    }
                } else if (view.getId() != l.this.gCZ.getId()) {
                    if (view.getId() == l.this.gCY.getId() && l.this.gCS != null) {
                        l.this.gCS.bqM();
                    }
                } else {
                    l.this.byP();
                }
            } else {
                l.this.ng(true);
                l.this.bqJ();
            }
        }
    };
    private TbCameraView.c gDh = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bqC() {
            return !aa.d(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gDi = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bqD() {
            if (l.this.gBZ != null) {
                l.this.gBZ.showToast(l.this.gBZ.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gDj = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
        @Override // com.baidu.tieba.write.album.TbCameraView.b
        public void bL(int i, int i2) {
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
                ViewGroup.LayoutParams layoutParams = l.this.gCS.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gCS.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gDk = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gDd <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.cdX.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gDl = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bqF() {
            l.this.ng(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void bqG() {
            if (l.this.gBZ != null) {
                l.this.gBZ.bqG();
            }
            l.this.bqJ();
            if (l.this.gBZ != null) {
                l.this.gBZ.byp();
            }
        }
    };
    private TransparentHeadGridView.b gDm = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void us(int i) {
            l.this.bJE.setAlpha(1.0f - (i / 100.0f));
            l.this.gCX.setAlpha(i / 100.0f);
            l.this.gDc.setAlpha(1.0f - (i / 100.0f));
            l.this.gDf.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void bqq() {
            l.this.bJE.setVisibility(8);
            l.this.gCX.setAlpha(1.0f);
            l.this.gDc.setVisibility(8);
            l.this.gDc.setAlpha(1.0f);
            l.this.gDf.setVisibility(8);
            l.this.gDf.setAlpha(1.0f);
        }
    };
    private Animation.AnimationListener gDn = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gCX.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gDo = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void ur(int i) {
            l.this.gDd = i;
            if (i <= 50) {
                l.this.cdX.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.cdX.setCompoundDrawables(null, null, drawable, null);
                l.this.gCN.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                l.this.gft.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bJE.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.cdX.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.cdX.setCompoundDrawables(null, null, drawable2, null);
                l.this.gCN.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                l.this.gft.setImageResource(d.g.icon_topbar_close_n);
                l.this.bJE.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gCR.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gCC = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gBJ.setCurrentIndex(i);
            l.this.gBZ.ul(1);
        }
    };
    private a.InterfaceC0128a gDp = new a.InterfaceC0128a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0128a
        public void a(int i, com.baidu.tbadk.c.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gBJ.byI())) {
                List<ImageFileInfo> byL = l.this.gBJ.byL();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : byL) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    byL = arrayList;
                }
                l.this.gBJ.dC(byL);
                l.this.gBJ.sZ(albumId);
                l.this.setData(byL);
                l.this.cdX.setText(name);
                l.this.gCP.smoothScrollToPosition(0);
            }
        }
    };
    private j gCD = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean f;
            if (z) {
                l.this.gCN.setText(l.this.gBZ.getResources().getText(d.l.next_step));
                f = l.this.gBZ.e(imageFileInfo);
                if (l.this.gBJ.isOriginalImg()) {
                    l.this.gBZ.byv();
                }
            } else {
                f = l.this.gBZ.f(imageFileInfo);
            }
            l.this.byQ();
            return f;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gBZ = (AlbumActivity) getBaseFragmentActivity();
        this.gBJ = this.gBZ.byr();
        f.byO().a(this);
        this.erP = new com.baidu.tbadk.c.b(this.gBZ.getPageContext().getPageActivity());
        this.gCO = new com.baidu.tieba.write.view.a(this.gBZ);
        this.gCO.setOnDismissListener(this.gDk);
        this.gBJ.sZ("-1");
        if (getActivity().getIntent() != null) {
            this.ajv = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.bZd = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.gft = (ImageView) this.mView.findViewById(d.h.img_close);
        this.gft.setOnClickListener(this.gBZ);
        this.gCN = (TextView) this.mView.findViewById(d.h.next_step);
        this.gCN.setOnClickListener(this.gBZ);
        this.cdX = (TextView) this.mView.findViewById(d.h.album_title);
        this.cdX.setOnClickListener(this.mOnClickListener);
        this.gCP = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gCQ = new k(this.gBZ, this.gBJ);
        this.gCP.setAdapter((ListAdapter) this.gCQ);
        this.gCP.setOuterOnScrollListener(this);
        this.gCP.setSelector(d.e.transparent);
        this.gCP.setOnHeadDisplayChangeListener(this.gDo);
        this.gCP.setOnPullChangeListener(this.gDm);
        this.gCO.a(this.gDp);
        this.gCQ.a(this.gCD);
        this.gCQ.a(this.gCC);
        this.gCQ.h(this.gDg);
        this.mNoDataView = NoDataViewFactory.a(this.gBZ.getPageContext().getPageActivity(), this.bZd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bJE = this.mView.findViewById(d.h.layout_title);
        this.gCR = this.mView.findViewById(d.h.top_bar_background);
        this.gCR.setAlpha(0.0f);
        this.gCS = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gCS.setOnGotPictureListener(this.gDl);
        this.gCS.setOnPreviewSizeChangedListener(this.gDj);
        this.gCT = this.mView.findViewById(d.h.camera_view_container);
        this.gCU = this.mView.findViewById(d.h.img_pic_cancel);
        this.gCU.setOnClickListener(this.mOnClickListener);
        this.gCV = this.mView.findViewById(d.h.img_take_picture);
        this.gCV.setOnClickListener(this.mOnClickListener);
        this.gCW = this.mView.findViewById(d.h.img_pic_save);
        this.gCW.setOnClickListener(this.mOnClickListener);
        this.gCX = this.mView.findViewById(d.h.camera_bar);
        this.gCX.setAlpha(0.0f);
        this.gCY = this.mView.findViewById(d.h.btn_camera_switch);
        this.gCY.setOnClickListener(this.mOnClickListener);
        this.gCZ = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gCZ.setOnClickListener(this.mOnClickListener);
        this.gDa = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gDb = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gDb.setAnimationListener(this.gDn);
        this.gCP.setBottomMoveView(this.gCT);
        this.gDe = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gDe.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gDe.setLayoutParams(layoutParams);
        this.gCQ.uq((this.mScreenWidth - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gDc = this.mView.findViewById(d.h.icon_camera);
        this.gDf = this.mView.findViewById(d.h.view_camera_cover);
        this.gCS.setOnRequestPermissionListener(this.gDh);
        byQ();
        this.gCS.setOnOpenCameraFailedListener(this.gDi);
        ng(true);
        return this.mView;
    }

    public void bqJ() {
        if (this.gCS != null) {
            this.gCS.byU();
            this.gCS.bqJ();
        }
    }

    public void byP() {
        this.gCP.byV();
        this.bJE.setVisibility(0);
        this.bJE.setAlpha(1.0f);
        this.bJE.startAnimation(this.gDa);
        this.gCX.startAnimation(this.gDb);
        this.gDc.setVisibility(0);
        this.gDc.startAnimation(this.gDa);
        this.gDf.setVisibility(0);
    }

    public void ng(boolean z) {
        if (z) {
            this.gCU.setVisibility(4);
            this.gCV.setVisibility(0);
            this.gCW.setVisibility(4);
            this.gCZ.setVisibility(0);
            this.gCY.setVisibility(0);
            return;
        }
        this.gCU.setVisibility(0);
        this.gCV.setVisibility(4);
        this.gCW.setVisibility(0);
        this.gCZ.setVisibility(8);
        this.gCY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byQ() {
        if (this.gBJ.getWriteImagesInfo() != null && this.gBJ.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.gBJ.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.ajv)) {
                this.gCN.setText(this.gBZ.getResources().getText(d.l.next_step));
            } else {
                this.gCN.setText(this.gBZ.getResources().getText(d.l.skip));
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
        this.eIP = false;
        if (isShow()) {
            afL();
        }
    }

    private void byF() {
        if (this.gBJ == null && this.gBZ != null) {
            this.gBJ = this.gBZ.byr();
        }
        if (this.gBJ != null) {
            if (this.gBJ.byL() != null) {
                this.gCQ.notifyDataSetChanged();
            } else {
                tb("-1");
            }
        }
    }

    private void tb(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.erP.a(str, new com.baidu.tbadk.c.d() { // from class: com.baidu.tieba.write.album.l.6
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
                        l.this.cdX.setText(str2);
                        l.this.byR();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!u.v(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a();
                        aVar.cg("-1");
                        String string = l.this.gBZ.getPageContext().getString(d.l.write_album_all);
                        aVar.setName(string);
                        aVar.ch(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.cdX.setText(string);
                        l.this.gBJ.dD(arrayList2);
                        l.this.gBJ.dE(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byR() {
        this.erP.a(new com.baidu.tbadk.c.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.c.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.c.c
            public void m(List<com.baidu.tbadk.c.a> list) {
                l.this.gBJ.dD(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gCQ != null) {
                this.gBJ.dC(list);
                this.gCQ.setData(this.gBJ.byN());
            }
            byQ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gBZ.getLayoutMode().ah(i == 1);
        this.gBZ.getLayoutMode().t(this.mView);
        if (this.gCQ != null) {
            this.gCQ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View blk() {
        return this.gft;
    }

    public View byS() {
        return this.gCN;
    }

    public TbCameraView byw() {
        return this.gCS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.erP != null) {
            this.erP.nJ();
        }
        f.byO().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eIP = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nf(boolean z) {
        afL();
    }

    private void afL() {
        if (!isHidden() && !this.eIP) {
            byF();
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
                if (height >= 0 && (this.gDc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDc.getLayoutParams();
                    layoutParams.topMargin = height / 2;
                    this.gDc.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gCQ.iy(true);
        } else if (this.gCQ.isScroll()) {
            this.gCQ.iy(false);
            aLJ();
        }
    }

    private void aLJ() {
        int childCount = this.gCP.getChildCount();
        int firstVisiblePosition = this.gCP.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gCP.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gCQ.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gBZ.ank().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gCP.findViewWithTag(str);
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
        if (this.gCQ != null) {
            this.gCQ.setData(this.gBJ.byN());
        }
        byQ();
    }

    public void J(int i, boolean z) {
        if (this.gCP != null) {
            int firstVisiblePosition = this.gCP.getFirstVisiblePosition();
            int lastVisiblePosition = this.gCP.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gCP.getChildAt(i - firstVisiblePosition);
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
        byQ();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gCQ != null) {
            J(this.gCQ.h(imageFileInfo), z);
        }
    }

    public boolean byT() {
        return this.gCP != null && this.gCP.getVisibility() == 0;
    }
}
