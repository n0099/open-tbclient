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
    private View bCG;
    private RelativeLayout bMv;
    private TextView bPO;
    private boolean ely;
    private AlbumActivity fTN;
    private p fTx;
    private i fUR;
    private ImageView fUS;
    private TextView fUT;
    private com.baidu.tieba.write.view.a fUU;
    private TransparentHeadGridView fUV;
    private y fUW;
    private View fUX;
    private View fUZ;
    private View fVa;
    private View fVb;
    private View fVc;
    private View fVd;
    private View fVe;
    private View fVf;
    private Animation fVg;
    private Animation fVh;
    private View fVi;
    private View fVk;
    private View fVl;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private int mScreenWidth;
    private View mView;
    private TbCameraView fUY = null;
    private int fVj = 0;
    private String agW = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener fVm = new ad(this);
    private View.OnClickListener mOnClickListener = new al(this);
    private TbCameraView.c fVn = new am(this);
    private TbCameraView.a fVo = new an(this);
    private TbCameraView.b fVp = new ao(this);
    private PopupWindow.OnDismissListener fVq = new ap(this);
    private TbCameraView.d fVr = new aq(this);
    private TransparentHeadGridView.b fVs = new ar(this);
    private Animation.AnimationListener fVt = new as(this);
    private TransparentHeadGridView.a fVu = new ae(this);
    private w fUE = new af(this);
    private a.InterfaceC0088a fVv = new ag(this);
    private x fUF = new ah(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fTN = (AlbumActivity) getBaseFragmentActivity();
        this.fTx = this.fTN.bnp();
        q.bnU().a(this);
        this.fUR = new i(this.fTN.getPageContext().getPageActivity());
        this.fUU = new com.baidu.tieba.write.view.a(this.fTN);
        this.fUU.setOnDismissListener(this.fVq);
        this.fTx.rh("-1");
        if (getActivity().getIntent() != null) {
            this.agW = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(w.j.album_image_list_view, (ViewGroup) null);
        this.bMv = (RelativeLayout) this.mView.findViewById(w.h.album_image_list_root);
        this.fUS = (ImageView) this.mView.findViewById(w.h.img_close);
        this.fUS.setOnClickListener(this.fTN);
        this.fUT = (TextView) this.mView.findViewById(w.h.next_step);
        this.fUT.setOnClickListener(this.fTN);
        this.bPO = (TextView) this.mView.findViewById(w.h.album_title);
        this.bPO.setOnClickListener(this.mOnClickListener);
        this.fUV = (TransparentHeadGridView) this.mView.findViewById(w.h.gv_image_list);
        this.fUW = new y(this.fTN, this.fTx);
        this.fUV.setAdapter((ListAdapter) this.fUW);
        this.fUV.setOuterOnScrollListener(this);
        this.fUV.setSelector(w.e.transparent);
        this.fUV.setOnHeadDisplayChangeListener(this.fVu);
        this.fUV.setOnPullChangeListener(this.fVs);
        this.fUU.a(this.fVv);
        this.fUW.a(this.fUF);
        this.fUW.a(this.fUE);
        this.fUW.m(this.fVm);
        this.mNoDataView = NoDataViewFactory.a(this.fTN.getPageContext().getPageActivity(), this.bMv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.B(w.l.album_list_no_data, w.l.album_list_no_data_1), null);
        this.bCG = this.mView.findViewById(w.h.layout_title);
        this.fUX = this.mView.findViewById(w.h.top_bar_background);
        this.fUX.setAlpha(0.0f);
        this.fUY = (TbCameraView) this.mView.findViewById(w.h.camera_surfaceview);
        this.fUY.setOnGotPictureListener(this.fVr);
        this.fUY.setOnPreviewSizeChangedListener(this.fVp);
        this.fUZ = this.mView.findViewById(w.h.camera_view_container);
        this.fVa = this.mView.findViewById(w.h.img_pic_cancel);
        this.fVa.setOnClickListener(this.mOnClickListener);
        this.fVb = this.mView.findViewById(w.h.img_take_picture);
        this.fVb.setOnClickListener(this.mOnClickListener);
        this.fVc = this.mView.findViewById(w.h.img_pic_save);
        this.fVc.setOnClickListener(this.mOnClickListener);
        this.fVd = this.mView.findViewById(w.h.camera_bar);
        this.fVd.setAlpha(0.0f);
        this.fVe = this.mView.findViewById(w.h.btn_camera_switch);
        this.fVe.setOnClickListener(this.mOnClickListener);
        this.fVf = this.mView.findViewById(w.h.btn_back_to_pictures);
        this.fVf.setOnClickListener(this.mOnClickListener);
        this.fVg = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.fade_in);
        this.fVh = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.fade_out);
        this.fVh.setAnimationListener(this.fVt);
        this.fUV.setBottomMoveView(this.fUZ);
        this.fVk = this.mView.findViewById(w.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.fVk.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.fVk.setLayoutParams(layoutParams);
        this.fUW.tl((this.mScreenWidth - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds16)) / 3);
        this.fVi = this.mView.findViewById(w.h.icon_camera);
        this.fVl = this.mView.findViewById(w.h.view_camera_cover);
        this.fUY.setOnRequestPermissionListener(this.fVn);
        bnX();
        this.fUY.setOnOpenCameraFailedListener(this.fVo);
        lX(true);
        return this.mView;
    }

    public void bnV() {
        if (this.fUY != null) {
            this.fUY.boh();
            this.fUY.bnV();
        }
    }

    public void bnW() {
        this.fUV.boj();
        this.bCG.setVisibility(0);
        this.bCG.setAlpha(1.0f);
        this.bCG.startAnimation(this.fVg);
        this.fVd.startAnimation(this.fVh);
        this.fVi.setVisibility(0);
        this.fVi.startAnimation(this.fVg);
        this.fVl.setVisibility(0);
    }

    public void lX(boolean z) {
        if (z) {
            this.fVa.setVisibility(4);
            this.fVb.setVisibility(0);
            this.fVc.setVisibility(4);
            this.fVf.setVisibility(0);
            this.fVe.setVisibility(0);
            return;
        }
        this.fVa.setVisibility(0);
        this.fVb.setVisibility(4);
        this.fVc.setVisibility(0);
        this.fVf.setVisibility(8);
        this.fVe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnX() {
        if (this.fTx.getWriteImagesInfo() != null && this.fTx.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.fTx.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.agW)) {
                this.fUT.setText(this.fTN.getResources().getText(w.l.next_step));
            } else {
                this.fUT.setText(this.fTN.getResources().getText(w.l.skip));
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
        this.ely = false;
        if (isShow()) {
            aax();
        }
    }

    private void bnI() {
        if (this.fTx == null && this.fTN != null) {
            this.fTx = this.fTN.bnp();
        }
        if (this.fTx != null) {
            if (this.fTx.bnR() != null) {
                this.fUW.notifyDataSetChanged();
            } else {
                rj("-1");
            }
        }
    }

    private void rj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fUR.a(str, new ai(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnY() {
        this.fUR.a(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.fUW != null) {
                this.fTx.cP(list);
                this.fUW.setData(this.fTx.bnT());
            }
            bnX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fTN.getLayoutMode().ah(i == 1);
        this.fTN.getLayoutMode().t(this.mView);
        if (this.fUW != null) {
            this.fUW.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bcK() {
        return this.fUS;
    }

    public View bnZ() {
        return this.fUT;
    }

    public TbCameraView bnx() {
        return this.fUY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fUR != null) {
            this.fUR.bnL();
        }
        q.bnU().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ely = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.q.a
    public void lV(boolean z) {
        aax();
    }

    private void aax() {
        if (!isHidden() && !this.ely) {
            bnI();
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
                if (height >= 0 && (this.fVi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVi.getLayoutParams();
                    layoutParams.topMargin = height / 2;
                    this.fVi.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.fUW.lW(true);
        } else if (this.fUW.isScroll()) {
            this.fUW.lW(false);
            boa();
        }
    }

    private void boa() {
        int childCount = this.fUV.getChildCount();
        int firstVisiblePosition = this.fUV.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fUV.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.pic);
                ImageFileInfo item = this.fUW.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.fTN.ahn().a(item, new ak(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.fUW != null) {
            this.fUW.setData(this.fTx.bnT());
        }
        bnX();
    }

    public void H(int i, boolean z) {
        if (this.fUV != null) {
            int firstVisiblePosition = this.fUV.getFirstVisiblePosition();
            int lastVisiblePosition = this.fUV.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.fUV.getChildAt(i - firstVisiblePosition);
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
        bnX();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.fUW != null) {
            H(this.fUW.g(imageFileInfo), z);
        }
    }

    public boolean bob() {
        return this.fUV != null && this.fUV.getVisibility() == 0;
    }
}
