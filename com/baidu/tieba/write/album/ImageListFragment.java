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
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View apO;
    private TextView apP;
    private TextView apQ;
    private View aqA;
    private View aqB;
    private boolean aqC;
    private RelativeLayout aqs;
    private ImageView aqt;
    private TextView aqu;
    private TextView aqv;
    private i jOA;
    private AlbumActivity jOC;
    private c jOw;
    private com.baidu.tbadk.album.f jPb;
    private com.baidu.tieba.write.view.a jPc;
    private TransparentHeadGridView jPd;
    private h jPe;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cOA = null;
    private View.OnClickListener jOO = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jOw != null) {
                int maxImagesAllowed = ImageListFragment.this.jOw.getMaxImagesAllowed();
                if (ImageListFragment.this.jOw.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jOC != null) {
                        ImageListFragment.this.jOC.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jOw != null) {
                if (ImageListFragment.this.jOA == null || !ImageListFragment.this.jOA.cyp()) {
                    if (view == ImageListFragment.this.aqv) {
                        ImageListFragment.this.jPc.b(ImageListFragment.this.jOw.wc(), ImageListFragment.this.jOw.wa());
                        ImageListFragment.this.jPc.O(ImageListFragment.this.aqA);
                        ImageListFragment.this.aqv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.apO) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jOR = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aZU() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jOS = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cym() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aqv != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aqv.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f jOP = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jOw != null && ImageListFragment.this.jOw.getWriteImagesInfo() != null && ImageListFragment.this.jOw.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jOC.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jOw != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jOw.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jOC.cd(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0545a jPf = new a.InterfaceC0545a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0545a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> cS;
            if (ImageListFragment.this.jOw != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jOw.wa()) && (cS = ImageListFragment.this.jOw.cS(albumId)) != null) {
                    ImageListFragment.this.jOw.cQ(albumId);
                    ImageListFragment.this.jPe.setData(cS);
                    ImageListFragment.this.aqv.setText(name);
                    ImageListFragment.this.jPd.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jOQ = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jOC == null || ImageListFragment.this.jOw == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jOw.vW()) {
                    ImageListFragment.this.jOC.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jOw.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jOC.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jOC.e(imageFileInfo);
                }
                ImageListFragment.this.jOw.a(null);
                ImageListFragment.this.jPe.notifyDataSetChanged();
                ImageListFragment.this.wf();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jOw.vV()) {
                    ImageListFragment.this.jOC.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jOw.b(videoFileInfo)) {
                        ImageListFragment.this.jOw.a(null);
                    } else {
                        ImageListFragment.this.jOw.a(videoFileInfo);
                    }
                    ImageListFragment.this.jOw.vX();
                    ImageListFragment.this.jPe.notifyDataSetChanged();
                    ImageListFragment.this.wf();
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
        this.jOC = (AlbumActivity) getBaseFragmentActivity();
        this.jOw = this.jOC.cyf();
        d.cyi().a(this);
        this.jPb = new com.baidu.tbadk.album.f(this.jOC);
        this.jPc = new com.baidu.tieba.write.view.a(this.jOC);
        this.jPc.setOnDismissListener(this.mOnDismissListener);
        this.jPc.a(this.jPf);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aqs = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aqA = this.mView.findViewById(R.id.layout_title);
        this.aqv = (TextView) this.mView.findViewById(R.id.album_title);
        this.aqt = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aqu = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aqB = this.mView.findViewById(R.id.navi_line);
        this.apO = this.mView.findViewById(R.id.layout_bottom);
        this.apQ = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.apP = (TextView) this.mView.findViewById(R.id.next_step);
        this.jOw.cQ(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aqv.setText(this.jOC.getPageContext().getString(R.string.album_all_media));
        if (this.jOw.getWriteImagesInfo() != null) {
            this.apQ.setVisibility(this.jOw.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jOw.getWriteImagesInfo() != null && this.jOw.getWriteImagesInfo().isFromQRCode()) {
            this.apO.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jOC.getPageContext().getPageActivity(), this.aqs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ak(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jPd = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jPd.setSelector(R.color.transparent);
        this.jPe = new h(this.jOC, this.jOw);
        if (this.jOw.getWriteImagesInfo() != null && this.jOw.getWriteImagesInfo().isFromQRCode()) {
            this.jPe.rQ(false);
        } else {
            this.jPe.rQ(this.jOC.vF() != 1);
        }
        this.jPd.setAdapter((ListAdapter) this.jPe);
        this.jPd.setOuterOnScrollListener(this);
        this.jPe.a(this.jOQ);
        this.jPe.a(this.jOP);
        this.jPe.ae(this.jOO);
        this.jPe.setOnOpenCameraFailedListener(this.jOS);
        this.jPe.setOnRequestPermissionListener(this.jOR);
        this.apP.setOnClickListener(this.jOC);
        this.aqt.setOnClickListener(this.jOC);
        this.aqu.setOnClickListener(this.jOC);
        this.apQ.setOnClickListener(this.jOC);
        this.aqv.setOnClickListener(this.mOnClickListener);
        this.apO.setOnClickListener(this.mOnClickListener);
        wf();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cOA == null) {
            this.cOA = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cOA.setCancelListener(null);
        this.cOA.setTipString(R.string.loading);
        this.cOA.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jOC.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf() {
        int count;
        String string;
        if (this.jOw != null && this.apP != null) {
            if (this.jOw.vW()) {
                int i = this.jOw.vW() ? 1 : 0;
                count = i;
                string = this.jOC.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.jOw.vY());
                string = this.jOC.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.jOw.getMaxImagesAllowed())});
            }
            this.apP.setText(string);
            this.apP.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aqC = false;
        if (isShow()) {
            vU();
        }
    }

    private void vR() {
        if (this.jOw == null && this.jOC != null) {
            this.jOw = this.jOC.cyf();
        }
        if (this.jOw != null) {
            if (!this.jOw.wd()) {
                this.jPe.notifyDataSetChanged();
            } else {
                wg();
            }
            aQ(this.jOw.isOriginalImg());
        }
    }

    private void wg() {
        if (this.jPb == null) {
            this.jPb = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jPb.a(this.jOC.vF() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cOA != null) {
                    ImageListFragment.this.cOA.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jOw != null && gVar != null) {
                    ImageListFragment.this.jOw.c(gVar);
                    String wa = ImageListFragment.this.jOw.wa();
                    ImageListFragment.this.jOw.cQ(wa);
                    ImageListFragment.this.jPe.setData(ImageListFragment.this.jOw.cS(wa));
                    ImageListFragment.this.jPd.smoothScrollToPosition(0);
                    ImageListFragment.this.wf();
                }
                ImageListFragment.this.jPd.wi();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aqB, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aqv, R.color.cp_cont_b, i);
        if (this.jOC.vF() == 1) {
            SvgManager.amN().a(this.aqt, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, null);
            this.aqu.setVisibility(8);
        } else {
            am.setViewTextColor(this.aqu, (int) R.color.navi_back_text_color);
            this.aqt.setVisibility(8);
        }
        if (this.aqv != null) {
            this.aqv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.jPe != null) {
            this.jPe.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jOw != null) {
            aQ(this.jOw.isOriginalImg());
        }
    }

    public View vS() {
        return this.jOC.vF() == 1 ? this.aqt : this.aqu;
    }

    public View wh() {
        return this.apP;
    }

    public TbCameraView cyg() {
        if (this.jPe != null) {
            return this.jPe.cyj();
        }
        return null;
    }

    public TransparentHeadGridView cyl() {
        return this.jPd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jPc != null) {
            this.jPc.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jPb != null) {
            this.jPb.cancelLoadTask();
        }
        if (this.jOC != null) {
            this.jOC.closeLoadingDialog();
        }
        if (this.cOA != null) {
            this.cOA.setDialogVisiable(false);
        }
        d.cyi().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aqC = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void aS(boolean z) {
        vU();
    }

    private void vU() {
        if (!isHidden() && !this.aqC) {
            vR();
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
            this.jPe.aT(true);
        } else if (this.jPe.isScroll()) {
            this.jPe.aT(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.jPd != null) {
            int firstVisiblePosition = this.jPd.getFirstVisiblePosition();
            int lastVisiblePosition = this.jPd.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jPd.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jPe != null) {
                    this.jPe.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        wf();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jPe != null) {
            i(this.jPe.i(imageFileInfo), z);
        }
    }

    public View vO() {
        return this.apQ;
    }

    public void aQ(boolean z) {
        if (this.jOC != null && this.apQ != null) {
            this.apQ.setText(this.jOC.getResources().getString(R.string.original_img));
            if (z) {
                this.apQ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.apQ, (int) R.color.cp_link_tip_a);
                return;
            }
            this.apQ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.apQ, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jOA = iVar;
    }
}
