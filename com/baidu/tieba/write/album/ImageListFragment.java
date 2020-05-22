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
/* loaded from: classes2.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private TextView bdA;
    private TextView bdB;
    private View bdz;
    private RelativeLayout bej;
    private ImageView bek;
    private TextView bel;
    private TextView bem;
    private View ber;
    private View bes;
    private boolean beu;
    private com.baidu.tbadk.album.f lRT;
    private com.baidu.tieba.write.view.a lRU;
    private TransparentHeadGridView lRV;
    private h lRW;
    private c lRm;
    private i lRq;
    private AlbumActivity lRt;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a euw = null;
    private View.OnClickListener lRG = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.lRm != null) {
                int maxImagesAllowed = ImageListFragment.this.lRm.getMaxImagesAllowed();
                if (ImageListFragment.this.lRm.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.lRt != null) {
                        ImageListFragment.this.lRt.d(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.lRm != null) {
                if (ImageListFragment.this.lRq == null || !ImageListFragment.this.lRq.dmQ()) {
                    if (view == ImageListFragment.this.bem) {
                        ImageListFragment.this.lRU.b(ImageListFragment.this.lRm.HF(), ImageListFragment.this.lRm.HD());
                        ImageListFragment.this.lRU.S(ImageListFragment.this.ber);
                        ImageListFragment.this.bem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bdz) {
                    }
                }
            }
        }
    };
    private TbCameraView.c lRJ = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bKL() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a lRK = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dmN() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bem != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aUV().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.bem.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f lRH = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.lRm != null && ImageListFragment.this.lRm.getWriteImagesInfo() != null && ImageListFragment.this.lRm.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.lRt.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.lRm != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.lRm.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.lRt.di(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0758a lRX = new a.InterfaceC0758a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0758a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> fG;
            if (ImageListFragment.this.lRm != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.lRm.HD()) && (fG = ImageListFragment.this.lRm.fG(albumId)) != null) {
                    ImageListFragment.this.lRm.fE(albumId);
                    ImageListFragment.this.lRW.setData(fG);
                    ImageListFragment.this.bem.setText(name);
                    ImageListFragment.this.lRV.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g lRI = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.lRt == null || ImageListFragment.this.lRm == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.lRm.Hz()) {
                    ImageListFragment.this.lRt.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.lRm.isAdded(imageFileInfo)) {
                    ImageListFragment.this.lRt.f(imageFileInfo);
                } else {
                    ImageListFragment.this.lRt.e(imageFileInfo);
                }
                ImageListFragment.this.lRm.a(null);
                ImageListFragment.this.lRW.notifyDataSetChanged();
                ImageListFragment.this.HK();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.lRm.Hy()) {
                    ImageListFragment.this.lRt.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.lRm.b(videoFileInfo)) {
                        ImageListFragment.this.lRm.a(null);
                    } else {
                        ImageListFragment.this.lRm.a(videoFileInfo);
                    }
                    ImageListFragment.this.lRm.HA();
                    ImageListFragment.this.lRW.notifyDataSetChanged();
                    ImageListFragment.this.HK();
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
        this.lRt = (AlbumActivity) getBaseFragmentActivity();
        this.lRm = this.lRt.dmG();
        d.dmJ().a(this);
        this.lRT = new com.baidu.tbadk.album.f(this.lRt);
        this.lRU = new com.baidu.tieba.write.view.a(this.lRt);
        this.lRU.setOnDismissListener(this.mOnDismissListener);
        this.lRU.a(this.lRX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.bej = (RelativeLayout) this.mView.findViewById(R.id.album_image_list_root);
        this.ber = this.mView.findViewById(R.id.layout_title);
        this.bem = (TextView) this.mView.findViewById(R.id.album_title);
        this.bek = (ImageView) this.mView.findViewById(R.id.img_close);
        this.bel = (TextView) this.mView.findViewById(R.id.img_close_text);
        this.bes = this.mView.findViewById(R.id.navi_line);
        this.bdz = this.mView.findViewById(R.id.layout_bottom);
        this.bdB = (TextView) this.mView.findViewById(R.id.original_select_btn);
        this.bdA = (TextView) this.mView.findViewById(R.id.next_step);
        this.lRm.fE(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bem.setText(this.lRt.getPageContext().getString(R.string.album_all_media));
        if (this.lRm.getWriteImagesInfo() != null) {
            this.bdB.setVisibility(this.lRm.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.lRm.getWriteImagesInfo() != null && this.lRm.getWriteImagesInfo().isFromQRCode()) {
            this.bdz.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.lRt.getPageContext().getPageActivity(), this.bej, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aM(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.lRV = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.lRV.setSelector(R.color.transparent);
        this.lRW = new h(this.lRt, this.lRm);
        if (this.lRm.getWriteImagesInfo() != null && this.lRm.getWriteImagesInfo().isFromQRCode()) {
            this.lRW.vr(false);
        } else {
            this.lRW.vr(this.lRt.Hi() != 1);
        }
        this.lRV.setAdapter((ListAdapter) this.lRW);
        this.lRV.setOuterOnScrollListener(this);
        this.lRW.a(this.lRI);
        this.lRW.a(this.lRH);
        this.lRW.ai(this.lRG);
        this.lRW.setOnOpenCameraFailedListener(this.lRK);
        this.lRW.setOnRequestPermissionListener(this.lRJ);
        this.bdA.setOnClickListener(this.lRt);
        this.bek.setOnClickListener(this.lRt);
        this.bel.setOnClickListener(this.lRt);
        this.bdB.setOnClickListener(this.lRt);
        this.bem.setOnClickListener(this.mOnClickListener);
        this.bdz.setOnClickListener(this.mOnClickListener);
        HK();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.euw == null) {
            this.euw = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.euw.setCancelListener(null);
        this.euw.setTipString(R.string.loading);
        this.euw.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.lRt.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
        int count;
        String string;
        if (this.lRm != null && this.bdA != null) {
            if (this.lRm.Hz()) {
                int i = this.lRm.Hz() ? 1 : 0;
                count = i;
                string = this.lRt.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.lRm.HB());
                string = this.lRt.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.lRm.getMaxImagesAllowed())});
            }
            this.bdA.setText(string);
            this.bdA.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.beu = false;
        if (isShow()) {
            Ho();
        }
    }

    private void Hn() {
        if (this.lRm == null && this.lRt != null) {
            this.lRm = this.lRt.dmG();
        }
        if (this.lRm != null) {
            if (!this.lRm.HG()) {
                this.lRW.notifyDataSetChanged();
            } else {
                HL();
            }
            ci(this.lRm.isOriginalImg());
        }
    }

    private void HL() {
        if (this.lRT == null) {
            this.lRT = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.lRT.a(this.lRt.Hi() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.euw != null) {
                    ImageListFragment.this.euw.setDialogVisiable(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.lRm != null && gVar != null) {
                    ImageListFragment.this.lRm.c(gVar);
                    String HD = ImageListFragment.this.lRm.HD();
                    ImageListFragment.this.lRm.fE(HD);
                    ImageListFragment.this.lRW.setData(ImageListFragment.this.lRm.fG(HD));
                    ImageListFragment.this.lRV.smoothScrollToPosition(0);
                    ImageListFragment.this.HK();
                }
                ImageListFragment.this.lRV.HN();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.bes, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.bem, R.color.cp_cont_b, i);
        if (this.lRt.Hi() == 1) {
            SvgManager.aUV().a(this.bek, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.bel.setVisibility(8);
        } else {
            am.setViewTextColor(this.bel, (int) R.color.navi_back_text_color);
            this.bek.setVisibility(8);
        }
        if (this.bem != null) {
            this.bem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.lRW != null) {
            this.lRW.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.lRm != null) {
            ci(this.lRm.isOriginalImg());
        }
    }

    public View HI() {
        return this.lRt.Hi() == 1 ? this.bek : this.bel;
    }

    public View HM() {
        return this.bdA;
    }

    public TbCameraView dmH() {
        if (this.lRW != null) {
            return this.lRW.dmK();
        }
        return null;
    }

    public TransparentHeadGridView dmM() {
        return this.lRV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.lRU != null) {
            this.lRU.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lRT != null) {
            this.lRT.cancelLoadTask();
        }
        if (this.lRt != null) {
            this.lRt.closeLoadingDialog();
        }
        if (this.euw != null) {
            this.euw.setDialogVisiable(false);
        }
        d.dmJ().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.beu = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void ck(boolean z) {
        Ho();
    }

    private void Ho() {
        if (!isHidden() && !this.beu) {
            Hn();
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
            this.lRW.cl(true);
        } else if (this.lRW.isScroll()) {
            this.lRW.cl(false);
        }
    }

    public void l(int i, boolean z) {
        if (this.lRV != null) {
            int firstVisiblePosition = this.lRV.getFirstVisiblePosition();
            int lastVisiblePosition = this.lRV.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.lRV.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.lRW != null) {
                    this.lRW.b((ImageView) childAt.findViewById(R.id.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        HK();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.lRW != null) {
            l(this.lRW.i(imageFileInfo), z);
        }
    }

    public View Hu() {
        return this.bdB;
    }

    public void ci(boolean z) {
        if (this.lRt != null && this.bdB != null) {
            this.bdB.setText(this.lRt.getResources().getString(R.string.original_img));
            if (z) {
                this.bdB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.bdB, (int) R.color.cp_link_tip_a);
                return;
            }
            this.bdB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.bdB, (int) R.color.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.lRq = iVar;
    }
}
