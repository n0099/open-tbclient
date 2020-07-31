package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private RelativeLayout bjP;
    private ImageView bjQ;
    private TextView bjR;
    private TextView bjS;
    private View bjX;
    private View bjY;
    private boolean bjZ;
    private View bjg;
    private TextView bji;
    private NavigationBar ffK;
    private BaseFragmentActivity hjZ;
    private NoDataView mNoDataView;
    private View mView;
    private e muJ;
    private c muN;
    private TBSpecificationBtn muP;
    private TransparentHeadGridView mvA;
    private i mvB;
    private j mvb;
    private com.baidu.tbadk.album.f mvy;
    private com.baidu.tieba.write.view.a mvz;
    private com.baidu.tbadk.core.view.a eJP = null;
    private View.OnClickListener mvk = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.muN != null) {
                int maxImagesAllowed = ImageListFragment.this.muN.getMaxImagesAllowed();
                if (ImageListFragment.this.muN.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.muJ != null) {
                        ImageListFragment.this.muJ.g(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.muN != null) {
                if (ImageListFragment.this.mvb == null || !ImageListFragment.this.mvb.duL()) {
                    if (view == ImageListFragment.this.bjS) {
                        ImageListFragment.this.mvz.b(ImageListFragment.this.muN.IY(), ImageListFragment.this.muN.IW());
                        ImageListFragment.this.mvz.O(ImageListFragment.this.ffK == null ? ImageListFragment.this.bjX : ImageListFragment.this.ffK);
                        ImageListFragment.this.bjS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bjg) {
                    }
                }
            }
        }
    };
    private TbCameraView.c mvn = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bRe() {
            return !ad.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a mvo = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void duI() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bjS != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.baR().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.bjS.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private g mvl = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.muN != null && ImageListFragment.this.muN.getWriteImagesInfo() != null && ImageListFragment.this.muN.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                if (ImageListFragment.this.muJ != null) {
                    ImageListFragment.this.muJ.e((ImageFileInfo) mediaFileInfo);
                }
            } else if (mediaFileInfo != null && ImageListFragment.this.muN != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.muN.d((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.muJ != null) {
                        ImageListFragment.this.muJ.du(1);
                        return;
                    }
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0786a mvC = new a.InterfaceC0786a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0786a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> fM;
            if (ImageListFragment.this.muN != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.muN.IW()) && (fM = ImageListFragment.this.muN.fM(albumId)) != null) {
                    ImageListFragment.this.muN.fK(albumId);
                    ImageListFragment.this.mvB.setData(fM);
                    ImageListFragment.this.bjS.setText(name);
                    ImageListFragment.this.mvA.smoothScrollToPosition(0);
                }
            }
        }
    };
    private h mvm = new h() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.h
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hjZ == null || ImageListFragment.this.muN == null || ImageListFragment.this.muJ == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.muN.IS()) {
                    ImageListFragment.this.hjZ.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.muN.isAdded(imageFileInfo)) {
                    ImageListFragment.this.muJ.f(imageFileInfo);
                } else {
                    ImageListFragment.this.muJ.g(imageFileInfo);
                }
                ImageListFragment.this.muN.a(null);
                ImageListFragment.this.mvB.notifyDataSetChanged();
                ImageListFragment.this.Jd();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.muN.IR()) {
                    ImageListFragment.this.hjZ.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.muN.b(videoFileInfo)) {
                        ImageListFragment.this.muN.a(null);
                    } else {
                        ImageListFragment.this.muN.a(videoFileInfo);
                    }
                    ImageListFragment.this.muN.IT();
                    ImageListFragment.this.mvB.notifyDataSetChanged();
                    ImageListFragment.this.Jd();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hjZ = getBaseFragmentActivity();
        if (this.muJ == null) {
            if (this.hjZ instanceof AlbumFloatActivity) {
                this.muJ = ((AlbumFloatActivity) this.hjZ).muJ;
            } else if (this.hjZ instanceof AlbumActivity) {
                this.muJ = ((AlbumActivity) this.hjZ).muJ;
            }
        }
        if (this.muJ != null) {
            this.muN = this.muJ.duD();
        }
        d.duA().a(this);
        this.mvy = new com.baidu.tbadk.album.f(this.hjZ);
        this.mvz = new com.baidu.tieba.write.view.a(this.hjZ);
        this.mvz.setOnDismissListener(this.mOnDismissListener);
        this.mvz.a(this.mvC);
    }

    public void a(e eVar) {
        this.muJ = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bjP = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.bjX = this.mView.findViewById(R.id.layout_title);
        this.bjS = (TextView) this.mView.findViewById(R.id.album_title);
        this.bjQ = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bjR = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bjY = this.mView.findViewById(R.id.navi_line);
        this.bjg = this.mView.findViewById(R.id.layout_bottom);
        this.bji = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.muP = (TBSpecificationBtn) this.mView.findViewById(R.id.next_step);
        this.muP.setTextSize(R.dimen.tbds34);
        this.muP.getStyleConfig().mT(l.getDimens(this.hjZ, R.dimen.tbds25));
        this.muN.fK(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bjS.setText(this.hjZ.getPageContext().getString(R.string.album_all_media));
        if (this.muN.getWriteImagesInfo() != null) {
            this.bji.setVisibility(this.muN.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.muN.getWriteImagesInfo() != null && this.muN.getWriteImagesInfo().isFromQRCode()) {
            this.bjg.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hjZ.getPageContext().getPageActivity(), this.bjP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aQ(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.mvA = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.mvA.setSelector(R.color.transparent);
        this.mvB = new i(this.hjZ, this.muN);
        if (this.muN.getWriteImagesInfo() != null && this.muN.getWriteImagesInfo().isFromQRCode()) {
            this.mvB.wp(false);
        } else {
            this.mvB.wp(true);
        }
        this.mvA.setAdapter((ListAdapter) this.mvB);
        this.mvA.setOuterOnScrollListener(this);
        this.mvB.a(this.mvm);
        this.mvB.a(this.mvl);
        this.mvB.ak(this.mvk);
        this.mvB.setOnOpenCameraFailedListener(this.mvo);
        this.mvB.setOnRequestPermissionListener(this.mvn);
        this.muP.setOnClickListener(this.hjZ);
        this.bjQ.setOnClickListener(this.hjZ);
        this.bjR.setOnClickListener(this.hjZ);
        this.bji.setOnClickListener(this.hjZ);
        this.bjS.setOnClickListener(this.mOnClickListener);
        this.bjg.setOnClickListener(this.mOnClickListener);
        Jd();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ffK != null) {
            if (this.bjS.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bjS.getParent()).removeView(this.bjS);
            }
            this.bjX.setVisibility(8);
            this.ffK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.bjS, (View.OnClickListener) null);
        }
        return this.mView;
    }

    private void showLoadingView() {
        if (this.eJP == null) {
            this.eJP = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.eJP.setCancelListener(null);
        this.eJP.setTipString(R.string.loading);
        this.eJP.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hjZ.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jd() {
        int count;
        String string;
        if (this.muN != null && this.muP != null) {
            if (this.muN.IS()) {
                int i = this.muN.IS() ? 1 : 0;
                count = i;
                string = this.hjZ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = x.getCount(this.muN.IU());
                string = this.hjZ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.muN.getMaxImagesAllowed())});
            }
            this.muP.setText(string);
            this.muP.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bjZ = false;
        if (isShow()) {
            IH();
        }
    }

    private void IG() {
        if (this.muN == null && this.muJ != null) {
            this.muN = this.muJ.duD();
        }
        if (this.muN != null) {
            if (!this.muN.IZ()) {
                this.mvB.notifyDataSetChanged();
            } else {
                Je();
            }
            cp(this.muN.isOriginalImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Je() {
        if (this.mvy == null) {
            this.mvy = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.mvy.a((this.muJ == null || !this.muJ.duE()) ? 2 : 0, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.eJP != null) {
                    ImageListFragment.this.eJP.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.muN != null && gVar != null) {
                    ImageListFragment.this.muN.c(gVar);
                    String IW = ImageListFragment.this.muN.IW();
                    ImageListFragment.this.muN.fK(IW);
                    ImageListFragment.this.mvB.setData(ImageListFragment.this.muN.fM(IW));
                    ImageListFragment.this.mvA.smoothScrollToPosition(0);
                    ImageListFragment.this.Jd();
                }
                ImageListFragment.this.mvA.Jg();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mView);
        ao.setBackgroundColor(this.bjY, R.color.cp_bg_line_c, i);
        ao.setViewTextColor(this.bjS, R.color.cp_cont_b, i);
        if (this.muJ != null && this.muJ.IB() == 1) {
            SvgManager.baR().a(this.bjQ, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.bjR.setVisibility(8);
        } else {
            ao.setViewTextColor(this.bjR, R.color.navi_back_text_color);
            this.bjQ.setVisibility(8);
        }
        if (this.bjS != null) {
            this.bjS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.mvB != null) {
            this.mvB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.muN != null) {
            cp(this.muN.isOriginalImg());
        }
    }

    public void a(NavigationBar navigationBar) {
        this.ffK = navigationBar;
    }

    public View Jb() {
        return (this.muJ == null || this.muJ.IB() != 1) ? this.bjR : this.bjQ;
    }

    public View Jf() {
        return this.muP;
    }

    public TbCameraView duw() {
        if (this.mvB != null) {
            return this.mvB.duF();
        }
        return null;
    }

    public TransparentHeadGridView duH() {
        return this.mvA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mvz != null) {
            this.mvz.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mvy != null) {
            this.mvy.cancelLoadTask();
        }
        if (this.hjZ != null) {
            this.hjZ.closeLoadingDialog();
        }
        if (this.eJP != null) {
            this.eJP.setDialogVisiable(false);
        }
        d.duA().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bjZ = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void cr(boolean z) {
        IH();
    }

    private void IH() {
        if (!isHidden() && !this.bjZ) {
            IG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.mvB.cs(true);
        } else if (this.mvB.isScroll()) {
            this.mvB.cs(false);
        }
    }

    public void m(int i, boolean z) {
        if (this.mvA != null) {
            int firstVisiblePosition = this.mvA.getFirstVisiblePosition();
            int lastVisiblePosition = this.mvA.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.mvA.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.mvB != null) {
                    this.mvB.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Jd();
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.mvB != null) {
            m(this.mvB.i(imageFileInfo), z);
        }
    }

    public View IN() {
        return this.bji;
    }

    public void cp(boolean z) {
        if (this.hjZ != null && this.bji != null) {
            this.bji.setText(this.hjZ.getResources().getString(R.string.original_img));
            if (z) {
                this.bji.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                ao.setViewTextColor(this.bji, R.color.cp_link_tip_a);
                return;
            }
            this.bji.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.bji, R.color.cp_cont_f);
        }
    }

    public void a(j jVar) {
        this.mvb = jVar;
    }
}
