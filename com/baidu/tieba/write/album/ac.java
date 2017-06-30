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
    private View bDz;
    private RelativeLayout bSW;
    private TextView bWL;
    private boolean euy;
    private p gei;
    private AlbumActivity gex;
    private i gfC;
    private ImageView gfD;
    private TextView gfE;
    private com.baidu.tieba.write.view.a gfF;
    private TransparentHeadGridView gfG;
    private y gfH;
    private View gfI;
    private View gfK;
    private View gfL;
    private View gfM;
    private View gfN;
    private View gfO;
    private View gfP;
    private View gfQ;
    private Animation gfR;
    private Animation gfS;
    private View gfT;
    private View gfV;
    private View gfW;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private int mScreenWidth;
    private View mView;
    private TbCameraView gfJ = null;
    private int gfU = 0;
    private String ahE = AlbumActivityConfig.FROM_WRITE;
    private View.OnClickListener gfX = new ad(this);
    private View.OnClickListener mOnClickListener = new al(this);
    private TbCameraView.c gfY = new am(this);
    private TbCameraView.a gfZ = new an(this);
    private TbCameraView.b gga = new ao(this);
    private PopupWindow.OnDismissListener ggb = new ap(this);
    private TbCameraView.d ggc = new aq(this);
    private TransparentHeadGridView.b ggd = new ar(this);
    private Animation.AnimationListener gge = new as(this);
    private TransparentHeadGridView.a ggf = new ae(this);
    private w gfo = new af(this);
    private a.InterfaceC0090a ggg = new ag(this);
    private x gfp = new ah(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gex = (AlbumActivity) getBaseFragmentActivity();
        this.gei = this.gex.brM();
        q.bsr().a(this);
        this.gfC = new i(this.gex.getPageContext().getPageActivity());
        this.gfF = new com.baidu.tieba.write.view.a(this.gex);
        this.gfF.setOnDismissListener(this.ggb);
        this.gei.sg("-1");
        if (getActivity().getIntent() != null) {
            this.ahE = getActivity().getIntent().getStringExtra("from");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(w.j.album_image_list_view, (ViewGroup) null);
        this.bSW = (RelativeLayout) this.mView.findViewById(w.h.album_image_list_root);
        this.gfD = (ImageView) this.mView.findViewById(w.h.img_close);
        this.gfD.setOnClickListener(this.gex);
        this.gfE = (TextView) this.mView.findViewById(w.h.next_step);
        this.gfE.setOnClickListener(this.gex);
        this.bWL = (TextView) this.mView.findViewById(w.h.album_title);
        this.bWL.setOnClickListener(this.mOnClickListener);
        this.gfG = (TransparentHeadGridView) this.mView.findViewById(w.h.gv_image_list);
        this.gfH = new y(this.gex, this.gei);
        this.gfG.setAdapter((ListAdapter) this.gfH);
        this.gfG.setOuterOnScrollListener(this);
        this.gfG.setSelector(w.e.transparent);
        this.gfG.setOnHeadDisplayChangeListener(this.ggf);
        this.gfG.setOnPullChangeListener(this.ggd);
        this.gfF.a(this.ggg);
        this.gfH.a(this.gfp);
        this.gfH.a(this.gfo);
        this.gfH.m(this.gfX);
        this.mNoDataView = NoDataViewFactory.a(this.gex.getPageContext().getPageActivity(), this.bSW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.B(w.l.album_list_no_data, w.l.album_list_no_data_1), null);
        this.bDz = this.mView.findViewById(w.h.layout_title);
        this.gfI = this.mView.findViewById(w.h.top_bar_background);
        this.gfI.setAlpha(0.0f);
        this.gfJ = (TbCameraView) this.mView.findViewById(w.h.camera_surfaceview);
        this.gfJ.setOnGotPictureListener(this.ggc);
        this.gfJ.setOnPreviewSizeChangedListener(this.gga);
        this.gfK = this.mView.findViewById(w.h.camera_view_container);
        this.gfL = this.mView.findViewById(w.h.img_pic_cancel);
        this.gfL.setOnClickListener(this.mOnClickListener);
        this.gfM = this.mView.findViewById(w.h.img_take_picture);
        this.gfM.setOnClickListener(this.mOnClickListener);
        this.gfN = this.mView.findViewById(w.h.img_pic_save);
        this.gfN.setOnClickListener(this.mOnClickListener);
        this.gfO = this.mView.findViewById(w.h.camera_bar);
        this.gfO.setAlpha(0.0f);
        this.gfP = this.mView.findViewById(w.h.btn_camera_switch);
        this.gfP.setOnClickListener(this.mOnClickListener);
        this.gfQ = this.mView.findViewById(w.h.btn_back_to_pictures);
        this.gfQ.setOnClickListener(this.mOnClickListener);
        this.gfR = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.fade_in);
        this.gfS = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), w.a.fade_out);
        this.gfS.setAnimationListener(this.gge);
        this.gfG.setBottomMoveView(this.gfK);
        this.gfV = this.mView.findViewById(w.h.layout_camera_view_clip);
        this.mScreenWidth = com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = this.gfV.getLayoutParams();
        layoutParams.height = (this.mScreenWidth * 4) / 3;
        this.gfV.setLayoutParams(layoutParams);
        this.gfH.tG((this.mScreenWidth - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds16)) / 3);
        this.gfT = this.mView.findViewById(w.h.icon_camera);
        this.gfW = this.mView.findViewById(w.h.view_camera_cover);
        this.gfJ.setOnRequestPermissionListener(this.gfY);
        bsu();
        this.gfJ.setOnOpenCameraFailedListener(this.gfZ);
        my(true);
        return this.mView;
    }

    public void bss() {
        if (this.gfJ != null) {
            this.gfJ.bsE();
            this.gfJ.bss();
        }
    }

    public void bst() {
        this.gfG.bsG();
        this.bDz.setVisibility(0);
        this.bDz.setAlpha(1.0f);
        this.bDz.startAnimation(this.gfR);
        this.gfO.startAnimation(this.gfS);
        this.gfT.setVisibility(0);
        this.gfT.startAnimation(this.gfR);
        this.gfW.setVisibility(0);
    }

    public void my(boolean z) {
        if (z) {
            this.gfL.setVisibility(4);
            this.gfM.setVisibility(0);
            this.gfN.setVisibility(4);
            this.gfQ.setVisibility(0);
            this.gfP.setVisibility(0);
            return;
        }
        this.gfL.setVisibility(0);
        this.gfM.setVisibility(4);
        this.gfN.setVisibility(0);
        this.gfQ.setVisibility(8);
        this.gfP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsu() {
        if (this.gei.getWriteImagesInfo() != null && this.gei.getWriteImagesInfo().getChosedFiles() != null) {
            if (this.gei.getWriteImagesInfo().getChosedFiles().size() > 0 || AlbumActivityConfig.FROM_WRITE.equals(this.ahE)) {
                this.gfE.setText(this.gex.getResources().getText(w.l.next_step));
            } else {
                this.gfE.setText(this.gex.getResources().getText(w.l.skip));
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
        this.euy = false;
        if (isShow()) {
            aen();
        }
    }

    private void bsf() {
        if (this.gei == null && this.gex != null) {
            this.gei = this.gex.brM();
        }
        if (this.gei != null) {
            if (this.gei.bso() != null) {
                this.gfH.notifyDataSetChanged();
            } else {
                si("-1");
            }
        }
    }

    private void si(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gfC.a(str, new ai(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsv() {
        this.gfC.a(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (list != null) {
            if (this.gfH != null) {
                this.gei.de(list);
                this.gfH.setData(this.gei.bsq());
            }
            bsu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gex.getLayoutMode().ah(i == 1);
        this.gex.getLayoutMode().t(this.mView);
        if (this.gfH != null) {
            this.gfH.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View bgZ() {
        return this.gfD;
    }

    public View bsw() {
        return this.gfE;
    }

    public TbCameraView brU() {
        return this.gfJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gfC != null) {
            this.gfC.bsi();
        }
        q.bsr().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.euy = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.q.a
    public void mw(boolean z) {
        aen();
    }

    private void aen() {
        if (!isHidden() && !this.euy) {
            bsf();
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
                if (height >= 0 && (this.gfT.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfT.getLayoutParams();
                    layoutParams.topMargin = height / 2;
                    this.gfT.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.gfH.mx(true);
        } else if (this.gfH.isScroll()) {
            this.gfH.mx(false);
            bsx();
        }
    }

    private void bsx() {
        int childCount = this.gfG.getChildCount();
        int firstVisiblePosition = this.gfG.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gfG.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.pic);
                ImageFileInfo item = this.gfH.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.gex.akX().a(item, new ak(this), false, false);
                }
            }
        }
    }

    public void refresh() {
        if (this.gfH != null) {
            this.gfH.setData(this.gei.bsq());
        }
        bsu();
    }

    public void H(int i, boolean z) {
        if (this.gfG != null) {
            int firstVisiblePosition = this.gfG.getFirstVisiblePosition();
            int lastVisiblePosition = this.gfG.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.gfG.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    View findViewById = childAt.findViewById(w.h.select_icon);
                    if (z) {
                        com.baidu.tbadk.core.util.as.j(findViewById, w.g.btn_choose_photo_s);
                    } else {
                        com.baidu.tbadk.core.util.as.j(findViewById, w.g.btn_choose_photo_n);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bsu();
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.gfH != null) {
            H(this.gfH.g(imageFileInfo), z);
        }
    }

    public boolean bsy() {
        return this.gfG != null && this.gfG.getVisibility() == 0;
    }
}
