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
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes10.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private RelativeLayout axQ;
    private ImageView axR;
    private TextView axS;
    private TextView axT;
    private View axY;
    private View axZ;
    private View axn;
    private TextView axo;
    private TextView axp;
    private boolean isPaused;
    private com.baidu.tbadk.album.f kIY;
    private com.baidu.tieba.write.view.a kIZ;
    private c kIt;
    private i kIx;
    private AlbumActivity kIz;
    private TransparentHeadGridView kJa;
    private h kJb;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a dBH = null;
    private View.OnClickListener kIL = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.kIt != null) {
                int maxImagesAllowed = ImageListFragment.this.kIt.getMaxImagesAllowed();
                if (ImageListFragment.this.kIt.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.kIz != null) {
                        ImageListFragment.this.kIz.e(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.kIt != null) {
                if (ImageListFragment.this.kIx == null || !ImageListFragment.this.kIx.cSp()) {
                    if (view == ImageListFragment.this.axT) {
                        ImageListFragment.this.kIZ.b(ImageListFragment.this.kIt.yb(), ImageListFragment.this.kIt.xZ());
                        ImageListFragment.this.kIZ.P(ImageListFragment.this.axY);
                        ImageListFragment.this.axT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.axn) {
                    }
                }
            }
        }
    };
    private TbCameraView.c kIO = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean brV() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a kIP = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cSm() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.axT != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aDW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.axT.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f kIM = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.kIt != null && ImageListFragment.this.kIt.getWriteImagesInfo() != null && ImageListFragment.this.kIt.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.kIz.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.kIt != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.kIt.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.kIz.cv(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0625a kJc = new a.InterfaceC0625a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0625a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> dL;
            if (ImageListFragment.this.kIt != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.kIt.xZ()) && (dL = ImageListFragment.this.kIt.dL(albumId)) != null) {
                    ImageListFragment.this.kIt.dJ(albumId);
                    ImageListFragment.this.kJb.setData(dL);
                    ImageListFragment.this.axT.setText(name);
                    ImageListFragment.this.kJa.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g kIN = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.kIz == null || ImageListFragment.this.kIt == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.kIt.xV()) {
                    ImageListFragment.this.kIz.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.kIt.isAdded(imageFileInfo)) {
                    ImageListFragment.this.kIz.f(imageFileInfo);
                } else {
                    ImageListFragment.this.kIz.e(imageFileInfo);
                }
                ImageListFragment.this.kIt.a(null);
                ImageListFragment.this.kJb.notifyDataSetChanged();
                ImageListFragment.this.ye();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.kIt.xU()) {
                    ImageListFragment.this.kIz.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.kIt.b(videoFileInfo)) {
                        ImageListFragment.this.kIt.a(null);
                    } else {
                        ImageListFragment.this.kIt.a(videoFileInfo);
                    }
                    ImageListFragment.this.kIt.xW();
                    ImageListFragment.this.kJb.notifyDataSetChanged();
                    ImageListFragment.this.ye();
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
        this.kIz = (AlbumActivity) getBaseFragmentActivity();
        this.kIt = this.kIz.cSf();
        d.cSi().a(this);
        this.kIY = new com.baidu.tbadk.album.f(this.kIz);
        this.kIZ = new com.baidu.tieba.write.view.a(this.kIz);
        this.kIZ.setOnDismissListener(this.mOnDismissListener);
        this.kIZ.a(this.kJc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.axQ = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.axY = this.mView.findViewById(R.id.layout_title);
        this.axT = (TextView) this.mView.findViewById(R.id.album_title);
        this.axR = (ImageView) this.mView.findViewById(R.id.img_close);
        this.axS = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.axZ = this.mView.findViewById(R.id.navi_line);
        this.axn = this.mView.findViewById(R.id.layout_bottom);
        this.axp = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.axo = (TextView) this.mView.findViewById(R.id.next_step);
        this.kIt.dJ(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.axT.setText(this.kIz.getPageContext().getString(R.string.album_all_media));
        if (this.kIt.getWriteImagesInfo() != null) {
            this.axp.setVisibility(this.kIt.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.kIt.getWriteImagesInfo() != null && this.kIt.getWriteImagesInfo().isFromQRCode()) {
            this.axn.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.kIz.getPageContext().getPageActivity(), this.axQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aB(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.kJa = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.kJa.setSelector(R.color.transparent);
        this.kJb = new h(this.kIz, this.kIt);
        if (this.kIt.getWriteImagesInfo() != null && this.kIt.getWriteImagesInfo().isFromQRCode()) {
            this.kJb.tw(false);
        } else {
            this.kJb.tw(this.kIz.xE() != 1);
        }
        this.kJa.setAdapter((ListAdapter) this.kJb);
        this.kJa.setOuterOnScrollListener(this);
        this.kJb.a(this.kIN);
        this.kJb.a(this.kIM);
        this.kJb.ag(this.kIL);
        this.kJb.setOnOpenCameraFailedListener(this.kIP);
        this.kJb.setOnRequestPermissionListener(this.kIO);
        this.axo.setOnClickListener(this.kIz);
        this.axR.setOnClickListener(this.kIz);
        this.axS.setOnClickListener(this.kIz);
        this.axp.setOnClickListener(this.kIz);
        this.axT.setOnClickListener(this.mOnClickListener);
        this.axn.setOnClickListener(this.mOnClickListener);
        ye();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.dBH == null) {
            this.dBH = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.dBH.setCancelListener(null);
        this.dBH.setTipString(R.string.loading);
        this.dBH.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.kIz.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ye() {
        int count;
        String string;
        if (this.kIt != null && this.axo != null) {
            if (this.kIt.xV()) {
                int i = this.kIt.xV() ? 1 : 0;
                count = i;
                string = this.kIz.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.kIt.xX());
                string = this.kIz.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kIt.getMaxImagesAllowed())});
            }
            this.axo.setText(string);
            this.axo.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (isShow()) {
            xT();
        }
    }

    private void xQ() {
        if (this.kIt == null && this.kIz != null) {
            this.kIt = this.kIz.cSf();
        }
        if (this.kIt != null) {
            if (!this.kIt.yc()) {
                this.kJb.notifyDataSetChanged();
            } else {
                yf();
            }
            bh(this.kIt.isOriginalImg());
        }
    }

    private void yf() {
        if (this.kIY == null) {
            this.kIY = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.kIY.a(this.kIz.xE() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.dBH != null) {
                    ImageListFragment.this.dBH.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.kIt != null && gVar != null) {
                    ImageListFragment.this.kIt.c(gVar);
                    String xZ = ImageListFragment.this.kIt.xZ();
                    ImageListFragment.this.kIt.dJ(xZ);
                    ImageListFragment.this.kJb.setData(ImageListFragment.this.kIt.dL(xZ));
                    ImageListFragment.this.kJa.smoothScrollToPosition(0);
                    ImageListFragment.this.ye();
                }
                ImageListFragment.this.kJa.yh();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.axZ, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.axT, R.color.cp_cont_b, i);
        if (this.kIz.xE() == 1) {
            SvgManager.aDW().a(this.axR, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.axS.setVisibility(8);
        } else {
            am.setViewTextColor(this.axS, (int) R.color.navi_back_text_color);
            this.axR.setVisibility(8);
        }
        if (this.axT != null) {
            this.axT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.kJb != null) {
            this.kJb.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kIt != null) {
            bh(this.kIt.isOriginalImg());
        }
    }

    public View xR() {
        return this.kIz.xE() == 1 ? this.axR : this.axS;
    }

    public View yg() {
        return this.axo;
    }

    public TbCameraView cSg() {
        if (this.kJb != null) {
            return this.kJb.cSj();
        }
        return null;
    }

    public TransparentHeadGridView cSl() {
        return this.kJa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.kIZ != null) {
            this.kIZ.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kIY != null) {
            this.kIY.cancelLoadTask();
        }
        if (this.kIz != null) {
            this.kIz.closeLoadingDialog();
        }
        if (this.dBH != null) {
            this.dBH.setDialogVisiable(false);
        }
        d.cSi().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void bj(boolean z) {
        xT();
    }

    private void xT() {
        if (!isHidden() && !this.isPaused) {
            xQ();
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
            this.kJb.bk(true);
        } else if (this.kJb.isScroll()) {
            this.kJb.bk(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.kJa != null) {
            int firstVisiblePosition = this.kJa.getFirstVisiblePosition();
            int lastVisiblePosition = this.kJa.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.kJa.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.kJb != null) {
                    this.kJb.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        ye();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.kJb != null) {
            i(this.kJb.i(imageFileInfo), z);
        }
    }

    public View xN() {
        return this.axp;
    }

    public void bh(boolean z) {
        if (this.kIz != null && this.axp != null) {
            this.axp.setText(this.kIz.getResources().getString(R.string.original_img));
            if (z) {
                this.axp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.axp, (int) R.color.cp_link_tip_a);
                return;
            }
            this.axp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.axp, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.kIx = iVar;
    }
}
