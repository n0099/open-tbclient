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
    private View bME;
    private RelativeLayout ccH;
    private com.baidu.tbadk.b.b cje;
    private boolean eBj;
    private TextView gGF;
    private TextView gGG;
    private View gGH;
    private e gGi;
    private AlbumActivity gGx;
    private com.baidu.tieba.write.view.a gHc;
    private TransparentHeadGridView gHd;
    private k gHe;
    private View gHf;
    private View gHh;
    private View gHi;
    private View gHj;
    private View gHk;
    private View gHl;
    private View gHm;
    private View gHn;
    private Animation gHo;
    private Animation gHp;
    private View gHq;
    private View gHs;
    private View gHt;
    private ImageView gci;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private int mScreenWidth;
    private TextView mTitleText;
    private View mView;
    private TbCameraView gHg = null;
    private int gHr = 0;
    private String aie = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gHu = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maxImagesAllowed = l.this.gGi.getMaxImagesAllowed();
            if (l.this.gGi.size() < maxImagesAllowed) {
                l.this.gHd.bzI();
                l.this.bME.setVisibility(8);
                l.this.gHl.setAlpha(1.0f);
                l.this.gHq.setVisibility(8);
                l.this.gHq.setAlpha(1.0f);
                l.this.gHt.setVisibility(8);
                l.this.gHt.setAlpha(1.0f);
                l.this.gGH.setVisibility(8);
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
                l.this.gHc.d(l.this.gGi.bzv(), l.this.gGi.bzt());
                l.this.gHc.ap(l.this.bME);
                if (l.this.gHr <= 50) {
                    i = d.g.d_ic_post_gallery_spread_s;
                } else {
                    i = d.g.ic_post_gallery_spread_s;
                }
                Drawable drawable = l.this.getResources().getDrawable(i);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
            } else if (view.getId() != l.this.gHi.getId()) {
                if (view.getId() == l.this.gHj.getId()) {
                    int maxImagesAllowed = l.this.gGi.getMaxImagesAllowed();
                    if (l.this.gGi.size() < maxImagesAllowed || l.this.gGx.bzd()) {
                        l.this.gGi.ta(String.valueOf(System.currentTimeMillis()));
                        l.this.gGx.iv(l.this.gGi.bzx());
                        return;
                    }
                    l.this.showToast(String.format(l.this.getPageContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                } else if (view.getId() == l.this.gHk.getId()) {
                    if (l.this.gHg != null) {
                        l.this.gHg.boX();
                    }
                } else if (view.getId() != l.this.gHn.getId()) {
                    if (view.getId() == l.this.gHm.getId()) {
                        if (l.this.gHg != null) {
                            l.this.gHg.boZ();
                            return;
                        }
                        return;
                    }
                    if (view == l.this.gGH) {
                    }
                } else {
                    l.this.bzA();
                }
            } else {
                l.this.ns(true);
                l.this.boW();
            }
        }
    };
    private TbCameraView.c gHv = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.l.10
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean boP() {
            return !ab.e(l.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a gHw = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.l.11
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void boQ() {
            if (l.this.gGx != null) {
                l.this.gGx.showToast(l.this.gGx.getResources().getString(d.l.camera_permission_disabled));
            }
        }
    };
    private TbCameraView.b gHx = new TbCameraView.b() { // from class: com.baidu.tieba.write.album.l.12
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
                ViewGroup.LayoutParams layoutParams = l.this.gHg.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                l.this.gHg.setLayoutParams(layoutParams);
            }
        }
    };
    private PopupWindow.OnDismissListener gHy = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.l.13
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            int i;
            if (l.this.gHr <= 50) {
                i = d.g.d_ic_post_gallery_spread_n;
            } else {
                i = d.g.ic_post_gallery_spread_n;
            }
            Drawable drawable = l.this.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
        }
    };
    private TbCameraView.d gHz = new TbCameraView.d() { // from class: com.baidu.tieba.write.album.l.14
        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void boS() {
            l.this.ns(false);
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void boT() {
            if (l.this.gGx != null) {
                l.this.gGx.boT();
            }
            l.this.boW();
            if (l.this.gGx != null) {
                l.this.gGx.bza();
            }
        }
    };
    private TransparentHeadGridView.b gHA = new TransparentHeadGridView.b() { // from class: com.baidu.tieba.write.album.l.15
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void uS(int i) {
            l.this.bME.setAlpha(1.0f - (i / 100.0f));
            l.this.gHl.setAlpha(i / 100.0f);
            l.this.gHq.setAlpha(1.0f - (i / 100.0f));
            l.this.gHt.setAlpha(1.0f - (i / 100.0f));
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.b
        public void boF() {
            l.this.bME.setVisibility(8);
            l.this.gHl.setAlpha(1.0f);
            l.this.gHq.setVisibility(8);
            l.this.gHq.setAlpha(1.0f);
            l.this.gHt.setVisibility(8);
            l.this.gHt.setAlpha(1.0f);
            l.this.gGH.setVisibility(8);
        }
    };
    private Animation.AnimationListener gHB = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.l.16
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            l.this.gHl.setAlpha(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private TransparentHeadGridView.a gHC = new TransparentHeadGridView.a() { // from class: com.baidu.tieba.write.album.l.2
        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
        public void uR(int i) {
            l.this.gHr = i;
            if (i <= 50) {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.white_alpha100));
                Drawable drawable = l.this.getResources().getDrawable(d.g.d_ic_post_gallery_spread_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable, null);
                l.this.gci.setImageResource(d.g.d_con_pb_post_close_n);
                l.this.bME.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
            } else {
                l.this.mTitleText.setTextColor(l.this.getResources().getColor(d.e.cp_cont_b));
                Drawable drawable2 = l.this.getResources().getDrawable(d.g.ic_post_gallery_spread_n);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                l.this.mTitleText.setCompoundDrawables(null, null, drawable2, null);
                l.this.gci.setImageResource(d.g.icon_topbar_close_n);
                l.this.bME.setAlpha(((i - 50) * 2.0f) / 100.0f);
            }
            l.this.gHf.setAlpha((i * 1.0f) / 100.0f);
        }
    };
    private i gGW = new i() { // from class: com.baidu.tieba.write.album.l.3
        @Override // com.baidu.tieba.write.album.i
        public void a(int i, ImageFileInfo imageFileInfo) {
            l.this.gGi.setCurrentIndex(i);
            l.this.gGx.uL(1);
        }
    };
    private a.InterfaceC0142a gHD = new a.InterfaceC0142a() { // from class: com.baidu.tieba.write.album.l.4
        @Override // com.baidu.tieba.write.view.a.InterfaceC0142a
        public void a(int i, com.baidu.tbadk.b.a aVar) {
            String albumId = aVar.getAlbumId();
            String name = aVar.getName();
            if (!TextUtils.isEmpty(albumId) && !albumId.equals(l.this.gGi.bzt())) {
                List<ImageFileInfo> bzw = l.this.gGi.bzw();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bzw) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bzw = arrayList;
                }
                l.this.gGi.dE(bzw);
                l.this.gGi.sZ(albumId);
                l.this.setData(bzw);
                l.this.mTitleText.setText(name);
                l.this.gHd.smoothScrollToPosition(0);
            }
        }
    };
    private j gGX = new j() { // from class: com.baidu.tieba.write.album.l.5
        @Override // com.baidu.tieba.write.album.j
        public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
            boolean e;
            if (z) {
                l.this.gGF.setText(l.this.gGx.getResources().getText(d.l.next_step));
                e = l.this.gGx.d(imageFileInfo);
                if (l.this.gGi.isOriginalImg()) {
                    l.this.gGx.bzb();
                }
            } else {
                e = l.this.gGx.e(imageFileInfo);
            }
            l.this.bzB();
            return e;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gGx = (AlbumActivity) getBaseFragmentActivity();
        this.gGi = this.gGx.bzc();
        f.bzz().a(this);
        this.cje = new com.baidu.tbadk.b.b(this.gGx.getPageContext().getPageActivity());
        this.gHc = new com.baidu.tieba.write.view.a(this.gGx);
        this.gHc.setOnDismissListener(this.gHy);
        this.gGi.sZ("-1");
        if (getActivity().getIntent() != null) {
            this.aie = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(d.j.album_image_list_view, (ViewGroup) null);
        this.ccH = (RelativeLayout) this.mView.findViewById(d.h.album_image_list_root);
        this.gci = (ImageView) this.mView.findViewById(d.h.img_close);
        this.gci.setOnClickListener(this.gGx);
        this.gGF = (TextView) this.mView.findViewById(d.h.next_step);
        this.gGF.setOnClickListener(this.gGx);
        this.mTitleText = (TextView) this.mView.findViewById(d.h.album_title);
        this.mTitleText.setOnClickListener(this.mOnClickListener);
        this.gHd = (TransparentHeadGridView) this.mView.findViewById(d.h.gv_image_list);
        this.gHe = new k(this.gGx, this.gGi);
        this.gHd.setAdapter((ListAdapter) this.gHe);
        this.gHd.setOuterOnScrollListener(this);
        this.gHd.setSelector(d.e.transparent);
        this.gHd.setOnHeadDisplayChangeListener(this.gHC);
        this.gHd.setOnPullChangeListener(this.gHA);
        this.gHc.a(this.gHD);
        this.gHe.a(this.gGX);
        this.gHe.a(this.gGW);
        this.gHe.h(this.gHu);
        this.mNoDataView = NoDataViewFactory.a(this.gGx.getPageContext().getPageActivity(), this.ccH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(d.l.album_list_no_data, d.l.album_list_no_data_1), null);
        this.bME = this.mView.findViewById(d.h.layout_title);
        this.gHf = this.mView.findViewById(d.h.top_bar_background);
        this.gHf.setAlpha(0.0f);
        this.gHg = (TbCameraView) this.mView.findViewById(d.h.camera_surfaceview);
        this.gHg.setOnGotPictureListener(this.gHz);
        this.gHg.setOnPreviewSizeChangedListener(this.gHx);
        this.gHh = this.mView.findViewById(d.h.camera_view_container);
        this.gHi = this.mView.findViewById(d.h.img_pic_cancel);
        this.gHi.setOnClickListener(this.mOnClickListener);
        this.gHj = this.mView.findViewById(d.h.img_take_picture);
        this.gHj.setOnClickListener(this.mOnClickListener);
        this.gHk = this.mView.findViewById(d.h.img_pic_save);
        this.gHk.setOnClickListener(this.mOnClickListener);
        this.gHl = this.mView.findViewById(d.h.camera_bar);
        this.gHl.setAlpha(0.0f);
        this.gHm = this.mView.findViewById(d.h.btn_camera_switch);
        this.gHm.setOnClickListener(this.mOnClickListener);
        this.gHn = this.mView.findViewById(d.h.btn_back_to_pictures);
        this.gHn.setOnClickListener(this.mOnClickListener);
        this.gHo = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_in);
        this.gHp = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.fade_out);
        this.gHp.setAnimationListener(this.gHB);
        this.gHd.setBottomMoveView(this.gHh);
        this.gHs = this.mView.findViewById(d.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.l.ad(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gHs.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gHs.setLayoutParams(layoutParams);
        this.gHe.uP((this.mScreenWidth - com.baidu.adp.lib.util.l.f(getPageContext().getPageActivity(), d.f.ds16)) / 3);
        this.gHq = this.mView.findViewById(d.h.icon_camera);
        uQ((int) (com.baidu.adp.lib.util.l.af(this.gGx.getPageContext().getPageActivity()) * 0.28f));
        this.gHt = this.mView.findViewById(d.h.view_camera_cover);
        this.gHg.setOnRequestPermissionListener(this.gHv);
        bzB();
        this.gHg.setOnOpenCameraFailedListener(this.gHw);
        ns(true);
        this.gGG = (TextView) this.mView.findViewById(d.h.original_select_btn);
        this.gGG.setOnClickListener(this.gGx);
        this.gGH = this.mView.findViewById(d.h.layout_bottom);
        this.gGH.setOnClickListener(this.mOnClickListener);
        return this.mView;
    }

    public void boW() {
        if (this.gHg != null) {
            this.gHg.bzF();
            this.gHg.boW();
        }
    }

    public void bzA() {
        this.gHd.bzH();
        this.bME.setVisibility(0);
        this.bME.setAlpha(1.0f);
        this.bME.startAnimation(this.gHo);
        this.gHl.startAnimation(this.gHp);
        this.gHq.setVisibility(0);
        this.gHq.startAnimation(this.gHo);
        this.gHt.setVisibility(0);
        this.gGH.setVisibility(0);
    }

    public void ns(boolean z) {
        if (z) {
            this.gHi.setVisibility(4);
            this.gHj.setVisibility(0);
            this.gHk.setVisibility(4);
            this.gHn.setVisibility(0);
            this.gHm.setVisibility(0);
            return;
        }
        this.gHi.setVisibility(0);
        this.gHj.setVisibility(4);
        this.gHk.setVisibility(0);
        this.gHn.setVisibility(8);
        this.gHm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzB() {
        if (this.gGi.getWriteImagesInfo() != null && this.gGi.getWriteImagesInfo().getChosedFiles() != null) {
            int t = v.t(this.gGi.getWriteImagesInfo().getChosedFiles());
            this.gGF.setText(this.gGx.getResources().getText(d.l.next_step));
            this.gGF.setEnabled(t > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eBj = false;
        if (isShow()) {
            NC();
        }
    }

    private void bzq() {
        if (this.gGi == null && this.gGx != null) {
            this.gGi = this.gGx.bzc();
        }
        if (this.gGi != null) {
            if (this.gGi.bzw() != null) {
                this.gHe.notifyDataSetChanged();
                return;
            }
            tb("-1");
            if (this.gGi.isOriginalImg()) {
                no(this.gGi.isOriginalImg());
            }
        }
    }

    private void tb(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cje.a(str, new com.baidu.tbadk.b.d() { // from class: com.baidu.tieba.write.album.l.6
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
                        l.this.bzC();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (!v.u(list)) {
                            arrayList2.addAll(list);
                        }
                        com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a();
                        aVar.bV("-1");
                        String string = l.this.gGx.getPageContext().getString(d.l.album_all);
                        aVar.setName(string);
                        aVar.bW(String.valueOf(arrayList.size()));
                        if (arrayList.size() > 0) {
                            aVar.a((ImageFileInfo) arrayList.get(0));
                        }
                        arrayList2.add(0, aVar);
                        l.this.mTitleText.setText(string);
                        l.this.gGi.dF(arrayList2);
                        l.this.gGi.dG(arrayList);
                    }
                    l.this.setData(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzC() {
        this.cje.a(new com.baidu.tbadk.b.c() { // from class: com.baidu.tieba.write.album.l.7
            @Override // com.baidu.tbadk.b.c
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.b.c
            public void m(List<com.baidu.tbadk.b.a> list) {
                l.this.gGi.dF(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gHe != null) {
                this.gGi.dE(list);
                this.gHe.setData(this.gGi.bzy());
            }
            bzB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gGx.getLayoutMode().ah(i == 1);
        this.gGx.getLayoutMode().t(this.mView);
        if (this.gHe != null) {
            this.gHe.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View biR() {
        return this.gci;
    }

    public View bzD() {
        return this.gGF;
    }

    public TbCameraView bzg() {
        return this.gHg;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cje != null) {
            this.cje.nv();
        }
        f.bzz().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eBj = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.f.a
    public void nr(boolean z) {
        NC();
    }

    private void NC() {
        if (!isHidden() && !this.eBj) {
            bzq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        super.onScroll(absListView, i, i2, i3);
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            uQ(childAt.getHeight() + iArr[1]);
        }
    }

    private void uQ(int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (i >= 0) {
            if (this.gHq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.gHq.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.topMargin = i / 2;
            this.gHq.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gHe.iq(true);
        } else if (this.gHe.isScroll()) {
            this.gHe.iq(false);
            aeS();
        }
    }

    private void aeS() {
        int childCount = this.gHd.getChildCount();
        int firstVisiblePosition = this.gHd.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gHd.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.pic);
                ImageFileInfo item = this.gHe.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gGx.aLP().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.l.8
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            HeadImageView headImageView2 = (HeadImageView) l.this.gHd.findViewWithTag(str);
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
        if (this.gHe != null) {
            this.gHe.setData(this.gGi.bzy());
        }
        bzB();
    }

    public void G(int i, boolean z) {
        if (this.gHd != null) {
            int firstVisiblePosition = this.gHd.getFirstVisiblePosition();
            int lastVisiblePosition = this.gHd.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gHd.getChildAt(i - firstVisiblePosition);
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
        bzB();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gHe != null) {
            G(this.gHe.g(imageFileInfo), z);
        }
    }

    public boolean bzE() {
        return this.gHd != null && this.gHd.getVisibility() == 0;
    }

    public View bzl() {
        return this.gGG;
    }

    public void no(boolean z) {
        if (this.gGx != null && this.gGG != null) {
            String string = this.gGx.getResources().getString(d.l.original_img);
            if (z) {
                this.gGG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                this.gGG.setText(string);
                this.gGG.setTextColor(this.gGx.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gGG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gGG.setText(string);
            this.gGG.setTextColor(this.gGx.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
