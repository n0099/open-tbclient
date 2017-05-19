package com.baidu.tieba.write.album;

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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.TransparentHeadGridView;
import com.baidu.tieba.write.album.q;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends BaseFragment implements AbsListView.OnScrollListener, q.a {
    private View aTA;
    private RelativeLayout bGH;
    private TextView bKb;
    private boolean efZ;
    private p fLQ;
    private AlbumActivity fMg;
    private Animation fNA;
    private View fNB;
    private View fND;
    private View fNE;
    private i fNk;
    private ImageView fNl;
    private TextView fNm;
    private com.baidu.tieba.write.view.a fNn;
    private TransparentHeadGridView fNo;
    private y fNp;
    private View fNq;
    private View fNs;
    private View fNt;
    private View fNu;
    private View fNv;
    private View fNw;
    private View fNx;
    private View fNy;
    private Animation fNz;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private int mScreenWidth;
    private View mView;
    private TbCameraView fNr = null;
    private int fNC = 0;
    private String ahf = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener fNF = new ad(this);
    private View.OnClickListener mOnClickListener = new al(this);
    private TbCameraView.c fNG = new am(this);
    private TbCameraView.a fNH = new an(this);
    private TbCameraView.b fNI = new ao(this);
    private PopupWindow.OnDismissListener fNJ = new ap(this);
    private TbCameraView.d fNK = new aq(this);
    private TransparentHeadGridView.b fNL = new ar(this);
    private Animation.AnimationListener fNM = new as(this);
    private TransparentHeadGridView.a fNN = new ae(this);
    private w fMX = new af(this);
    private a.InterfaceC0085a fNO = new ag(this);
    private x fMY = new ah(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fMg = (AlbumActivity) getBaseFragmentActivity();
        this.fLQ = this.fMg.blS();
        q.bmx().a(this);
        this.fNk = new i(this.fMg.getPageContext().getPageActivity());
        this.fNn = new com.baidu.tieba.write.view.a(this.fMg);
        this.fNn.setOnDismissListener(this.fNJ);
        this.fLQ.qU("-1");
        if (getActivity().getIntent() != null) {
            this.ahf = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(w.j.album_image_list_view, (ViewGroup) null);
        this.bGH = (RelativeLayout) this.mView.findViewById(w.h.album_image_list_root);
        this.fNl = (ImageView) this.mView.findViewById(w.h.img_close);
        this.fNl.setOnClickListener(this.fMg);
        this.fNm = (TextView) this.mView.findViewById(w.h.next_step);
        this.fNm.setOnClickListener(this.fMg);
        this.bKb = (TextView) this.mView.findViewById(w.h.album_title);
        this.bKb.setOnClickListener(this.mOnClickListener);
        this.fNo = (TransparentHeadGridView) this.mView.findViewById(w.h.gv_image_list);
        this.fNp = new y(this.fMg, this.fLQ);
        this.fNo.setAdapter((ListAdapter) this.fNp);
        this.fNo.setOuterOnScrollListener(this);
        this.fNo.setSelector(w.e.transparent);
        this.fNo.setOnHeadDisplayChangeListener(this.fNN);
        this.fNo.setOnPullChangeListener(this.fNL);
        this.fNn.a(this.fNO);
        this.fNp.a(this.fMY);
        this.fNp.a(this.fMX);
        this.fNp.n(this.fNF);
        this.mNoDataView = NoDataViewFactory.a(this.fMg.getPageContext().getPageActivity(), this.bGH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(w.l.album_list_no_data, w.l.album_list_no_data_1), null);
        this.aTA = this.mView.findViewById(w.h.layout_title);
        this.fNq = this.mView.findViewById(w.h.top_bar_background);
        this.fNq.setAlpha(0.0f);
        this.fNr = (TbCameraView) this.mView.findViewById(w.h.camera_surfaceview);
        this.fNr.setOnGotPictureListener(this.fNK);
        this.fNr.setOnPreviewSizeChangedListener(this.fNI);
        this.fNs = this.mView.findViewById(w.h.camera_view_container);
        this.fNt = this.mView.findViewById(w.h.img_pic_cancel);
        this.fNt.setOnClickListener(this.mOnClickListener);
        this.fNu = this.mView.findViewById(w.h.img_take_picture);
        this.fNu.setOnClickListener(this.mOnClickListener);
        this.fNv = this.mView.findViewById(w.h.img_pic_save);
        this.fNv.setOnClickListener(this.mOnClickListener);
        this.fNw = this.mView.findViewById(w.h.camera_bar);
        this.fNw.setAlpha(0.0f);
        this.fNx = this.mView.findViewById(w.h.btn_camera_switch);
        this.fNx.setOnClickListener(this.mOnClickListener);
        this.fNy = this.mView.findViewById(w.h.btn_back_to_pictures);
        this.fNy.setOnClickListener(this.mOnClickListener);
        this.fNz = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.fade_in);
        this.fNA = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.fade_out);
        this.fNA.setAnimationListener(this.fNM);
        this.fNo.setBottomMoveView(this.fNs);
        this.fND = this.mView.findViewById(w.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.fND.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.fND.setLayoutParams(layoutParams);
        this.fNp.sQ((this.mScreenWidth - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds16)) / 3);
        this.fNB = this.mView.findViewById(w.h.icon_camera);
        this.fNE = this.mView.findViewById(w.h.view_camera_cover);
        this.fNr.setOnRequestPermissionListener(this.fNG);
        bmA();
        this.fNr.setOnOpenCameraFailedListener(this.fNH);
        lE(true);
        return this.mView;
    }

    public void bmy() {
        if (this.fNr != null) {
            this.fNr.bmK();
            this.fNr.bmy();
        }
    }

    public void bmz() {
        this.fNo.bmM();
        this.aTA.setVisibility(0);
        this.aTA.setAlpha(1.0f);
        this.aTA.startAnimation(this.fNz);
        this.fNw.startAnimation(this.fNA);
        this.fNB.setVisibility(0);
        this.fNB.startAnimation(this.fNz);
        this.fNE.setVisibility(0);
    }

    public void lE(boolean z) {
        if (z) {
            this.fNt.setVisibility(4);
            this.fNu.setVisibility(0);
            this.fNv.setVisibility(4);
            this.fNy.setVisibility(0);
            this.fNx.setVisibility(0);
            return;
        }
        this.fNt.setVisibility(0);
        this.fNu.setVisibility(4);
        this.fNv.setVisibility(0);
        this.fNy.setVisibility(8);
        this.fNx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmA() {
        if (this.fLQ.getWriteImagesInfo() != null && this.fLQ.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.fLQ.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.ahf)) {
                this.fNm.setText(this.fMg.getResources().getText(w.l.next_step));
            } else {
                this.fNm.setText(this.fMg.getResources().getText(w.l.skip));
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
        this.efZ = false;
        if (isShow()) {
            Zu();
        }
    }

    private void bml() {
        if (this.fLQ == null && this.fMg != null) {
            this.fLQ = this.fMg.blS();
        }
        if (this.fLQ != null) {
            if (this.fLQ.bmu() != null) {
                this.fNp.notifyDataSetChanged();
            } else {
                qW("-1");
            }
        }
    }

    private void qW(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fNk.a(str, new ai(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmB() {
        this.fNk.a(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.fNp != null) {
                this.fLQ.cN(list);
                this.fNp.setData(this.fLQ.bmw());
            }
            bmA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fMg.getLayoutMode().ai(i == 1);
        this.fMg.getLayoutMode().t(this.mView);
        if (this.fNp != null) {
            this.fNp.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bbq() {
        return this.fNl;
    }

    public View bmC() {
        return this.fNm;
    }

    public TbCameraView bma() {
        return this.fNr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fNk != null) {
            this.fNk.bmo();
        }
        q.bmx().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.efZ = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.q.a
    public void lC(boolean z) {
        Zu();
    }

    private void Zu() {
        if (!isHidden() && !this.efZ) {
            bml();
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
                if (height >= 0 && (this.fNB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fNB.getLayoutParams();
                    layoutParams.topMargin = height / 2;
                    this.fNB.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.fNp.lD(true);
        } else if (this.fNp.isScroll()) {
            this.fNp.lD(false);
            bmD();
        }
    }

    private void bmD() {
        int childCount = this.fNo.getChildCount();
        int firstVisiblePosition = this.fNo.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fNo.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.pic);
                ImageFileInfo item = this.fNp.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fMg.afY().a(item, new ak(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fNp != null) {
            this.fNp.setData(this.fLQ.bmw());
        }
        bmA();
    }

    public void J(int i, boolean z) {
        if (this.fNo != null) {
            int firstVisiblePosition = this.fNo.getFirstVisiblePosition();
            int lastVisiblePosition = this.fNo.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.fNo.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    View findViewById = childAt.findViewById(w.h.select_icon);
                    if (z) {
                        com.baidu.tbadk.core.util.aq.j(findViewById, w.g.btn_choose_photo_s);
                    } else {
                        com.baidu.tbadk.core.util.aq.j(findViewById, w.g.btn_choose_photo_n);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bmA();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.fNp != null) {
            J(this.fNp.g(imageFileInfo), z);
        }
    }

    public boolean bmE() {
        return this.fNo != null && this.fNo.getVisibility() == 0;
    }
}
