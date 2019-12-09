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
    private View apw;
    private TextView apx;
    private TextView apy;
    private RelativeLayout aqa;
    private ImageView aqb;
    private TextView aqc;
    private TextView aqd;
    private View aqi;
    private View aqj;
    private boolean aqk;
    private c jNF;
    private i jNJ;
    private AlbumActivity jNL;
    private com.baidu.tbadk.album.f jOk;
    private com.baidu.tieba.write.view.a jOl;
    private TransparentHeadGridView jOm;
    private h jOn;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.b cNJ = null;
    private View.OnClickListener jNX = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.jNF != null) {
                int maxImagesAllowed = ImageListFragment.this.jNF.getMaxImagesAllowed();
                if (ImageListFragment.this.jNF.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.jNL != null) {
                        ImageListFragment.this.jNL.c(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.jNF != null) {
                if (ImageListFragment.this.jNJ == null || !ImageListFragment.this.jNJ.cyn()) {
                    if (view == ImageListFragment.this.aqd) {
                        ImageListFragment.this.jOl.b(ImageListFragment.this.jNF.wd(), ImageListFragment.this.jNF.wb());
                        ImageListFragment.this.jOl.O(ImageListFragment.this.aqi);
                        ImageListFragment.this.aqd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.apw) {
                    }
                }
            }
        }
    };
    private TbCameraView.c jOa = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean aZS() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a jOb = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void cyk() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aqd != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.aqd.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f jNY = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.jNF != null && ImageListFragment.this.jNF.getWriteImagesInfo() != null && ImageListFragment.this.jNF.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.jNL.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.jNF != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.jNF.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.jNL.cd(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0540a jOo = new a.InterfaceC0540a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0540a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> cS;
            if (ImageListFragment.this.jNF != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.jNF.wb()) && (cS = ImageListFragment.this.jNF.cS(albumId)) != null) {
                    ImageListFragment.this.jNF.cQ(albumId);
                    ImageListFragment.this.jOn.setData(cS);
                    ImageListFragment.this.aqd.setText(name);
                    ImageListFragment.this.jOm.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g jNZ = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.jNL == null || ImageListFragment.this.jNF == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.jNF.vX()) {
                    ImageListFragment.this.jNL.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.jNF.isAdded(imageFileInfo)) {
                    ImageListFragment.this.jNL.f(imageFileInfo);
                } else {
                    ImageListFragment.this.jNL.e(imageFileInfo);
                }
                ImageListFragment.this.jNF.a(null);
                ImageListFragment.this.jOn.notifyDataSetChanged();
                ImageListFragment.this.wg();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.jNF.vW()) {
                    ImageListFragment.this.jNL.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.jNF.b(videoFileInfo)) {
                        ImageListFragment.this.jNF.a(null);
                    } else {
                        ImageListFragment.this.jNF.a(videoFileInfo);
                    }
                    ImageListFragment.this.jNF.vY();
                    ImageListFragment.this.jOn.notifyDataSetChanged();
                    ImageListFragment.this.wg();
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
        this.jNL = (AlbumActivity) getBaseFragmentActivity();
        this.jNF = this.jNL.cyd();
        d.cyg().a(this);
        this.jOk = new com.baidu.tbadk.album.f(this.jNL);
        this.jOl = new com.baidu.tieba.write.view.a(this.jNL);
        this.jOl.setOnDismissListener(this.mOnDismissListener);
        this.jOl.a(this.jOo);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.aqa = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.aqi = this.mView.findViewById(R.id.layout_title);
        this.aqd = (TextView) this.mView.findViewById(R.id.album_title);
        this.aqb = (ImageView) this.mView.findViewById(R.id.img_close);
        this.aqc = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.aqj = this.mView.findViewById(R.id.navi_line);
        this.apw = this.mView.findViewById(R.id.layout_bottom);
        this.apy = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.apx = (TextView) this.mView.findViewById(R.id.next_step);
        this.jNF.cQ(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.aqd.setText(this.jNL.getPageContext().getString(R.string.album_all_media));
        if (this.jNF.getWriteImagesInfo() != null) {
            this.apy.setVisibility(this.jNF.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.jNF.getWriteImagesInfo() != null && this.jNF.getWriteImagesInfo().isFromQRCode()) {
            this.apw.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.jNL.getPageContext().getPageActivity(), this.aqa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ai(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.jOm = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.jOm.setSelector(R.color.transparent);
        this.jOn = new h(this.jNL, this.jNF);
        if (this.jNF.getWriteImagesInfo() != null && this.jNF.getWriteImagesInfo().isFromQRCode()) {
            this.jOn.rQ(false);
        } else {
            this.jOn.rQ(this.jNL.vG() != 1);
        }
        this.jOm.setAdapter((ListAdapter) this.jOn);
        this.jOm.setOuterOnScrollListener(this);
        this.jOn.a(this.jNZ);
        this.jOn.a(this.jNY);
        this.jOn.ae(this.jNX);
        this.jOn.setOnOpenCameraFailedListener(this.jOb);
        this.jOn.setOnRequestPermissionListener(this.jOa);
        this.apx.setOnClickListener(this.jNL);
        this.aqb.setOnClickListener(this.jNL);
        this.aqc.setOnClickListener(this.jNL);
        this.apy.setOnClickListener(this.jNL);
        this.aqd.setOnClickListener(this.mOnClickListener);
        this.apw.setOnClickListener(this.mOnClickListener);
        wg();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.cNJ == null) {
            this.cNJ = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.cNJ.setCancelListener(null);
        this.cNJ.setTipString(R.string.loading);
        this.cNJ.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.jNL.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg() {
        int count;
        String string;
        if (this.jNF != null && this.apx != null) {
            if (this.jNF.vX()) {
                int i = this.jNF.vX() ? 1 : 0;
                count = i;
                string = this.jNL.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.jNF.vZ());
                string = this.jNL.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.jNF.getMaxImagesAllowed())});
            }
            this.apx.setText(string);
            this.apx.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aqk = false;
        if (isShow()) {
            vV();
        }
    }

    private void vS() {
        if (this.jNF == null && this.jNL != null) {
            this.jNF = this.jNL.cyd();
        }
        if (this.jNF != null) {
            if (!this.jNF.we()) {
                this.jOn.notifyDataSetChanged();
            } else {
                wh();
            }
            aQ(this.jNF.isOriginalImg());
        }
    }

    private void wh() {
        if (this.jOk == null) {
            this.jOk = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.jOk.a(this.jNL.vG() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.cNJ != null) {
                    ImageListFragment.this.cNJ.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.jNF != null && gVar != null) {
                    ImageListFragment.this.jNF.c(gVar);
                    String wb = ImageListFragment.this.jNF.wb();
                    ImageListFragment.this.jNF.cQ(wb);
                    ImageListFragment.this.jOn.setData(ImageListFragment.this.jNF.cS(wb));
                    ImageListFragment.this.jOm.smoothScrollToPosition(0);
                    ImageListFragment.this.wg();
                }
                ImageListFragment.this.jOm.wj();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.aqj, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.aqd, R.color.cp_cont_b, i);
        if (this.jNL.vG() == 1) {
            SvgManager.amL().a(this.aqb, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, null);
            this.aqc.setVisibility(8);
        } else {
            am.setViewTextColor(this.aqc, (int) R.color.navi_back_text_color);
            this.aqb.setVisibility(8);
        }
        if (this.aqd != null) {
            this.aqd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.jOn != null) {
            this.jOn.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jNF != null) {
            aQ(this.jNF.isOriginalImg());
        }
    }

    public View vT() {
        return this.jNL.vG() == 1 ? this.aqb : this.aqc;
    }

    public View wi() {
        return this.apx;
    }

    public TbCameraView cye() {
        if (this.jOn != null) {
            return this.jOn.cyh();
        }
        return null;
    }

    public TransparentHeadGridView cyj() {
        return this.jOm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.jOl != null) {
            this.jOl.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jOk != null) {
            this.jOk.cancelLoadTask();
        }
        if (this.jNL != null) {
            this.jNL.closeLoadingDialog();
        }
        if (this.cNJ != null) {
            this.cNJ.setDialogVisiable(false);
        }
        d.cyg().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aqk = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void aS(boolean z) {
        vV();
    }

    private void vV() {
        if (!isHidden() && !this.aqk) {
            vS();
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
            this.jOn.aT(true);
        } else if (this.jOn.isScroll()) {
            this.jOn.aT(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.jOm != null) {
            int firstVisiblePosition = this.jOm.getFirstVisiblePosition();
            int lastVisiblePosition = this.jOm.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.jOm.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.jOn != null) {
                    this.jOn.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        wg();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.jOn != null) {
            i(this.jOn.i(imageFileInfo), z);
        }
    }

    public View vP() {
        return this.apy;
    }

    public void aQ(boolean z) {
        if (this.jNL != null && this.apy != null) {
            this.apy.setText(this.jNL.getResources().getString(R.string.original_img));
            if (z) {
                this.apy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.apy, (int) R.color.cp_link_tip_a);
                return;
            }
            this.apy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.apy, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.jNJ = iVar;
    }
}
