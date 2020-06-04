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
    private i lSB;
    private AlbumActivity lSE;
    private c lSx;
    private com.baidu.tbadk.album.f lTe;
    private com.baidu.tieba.write.view.a lTf;
    private TransparentHeadGridView lTg;
    private h lTh;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.a euw = null;
    private View.OnClickListener lSR = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.lSx != null) {
                int maxImagesAllowed = ImageListFragment.this.lSx.getMaxImagesAllowed();
                if (ImageListFragment.this.lSx.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.lSE != null) {
                        ImageListFragment.this.lSE.d(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.lSx != null) {
                if (ImageListFragment.this.lSB == null || !ImageListFragment.this.lSB.dng()) {
                    if (view == ImageListFragment.this.bem) {
                        ImageListFragment.this.lTf.b(ImageListFragment.this.lSx.HF(), ImageListFragment.this.lSx.HD());
                        ImageListFragment.this.lTf.S(ImageListFragment.this.ber);
                        ImageListFragment.this.bem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.bdz) {
                    }
                }
            }
        }
    };
    private TbCameraView.c lSU = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bKN() {
            return !ab.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a lSV = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void dnd() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bem != null && ImageListFragment.this.isAdded()) {
                Drawable a = SvgManager.aUW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                ImageListFragment.this.bem.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private f lSS = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.lSx != null && ImageListFragment.this.lSx.getWriteImagesInfo() != null && ImageListFragment.this.lSx.getWriteImagesInfo().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageListFragment.this.lSE.d((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo != null && ImageListFragment.this.lSx != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.lSx.h((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.lSE.dk(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0759a lTi = new a.InterfaceC0759a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0759a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> fG;
            if (ImageListFragment.this.lSx != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.lSx.HD()) && (fG = ImageListFragment.this.lSx.fG(albumId)) != null) {
                    ImageListFragment.this.lSx.fE(albumId);
                    ImageListFragment.this.lTh.setData(fG);
                    ImageListFragment.this.bem.setText(name);
                    ImageListFragment.this.lTg.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g lST = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.lSE == null || ImageListFragment.this.lSx == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.lSx.Hz()) {
                    ImageListFragment.this.lSE.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.lSx.isAdded(imageFileInfo)) {
                    ImageListFragment.this.lSE.f(imageFileInfo);
                } else {
                    ImageListFragment.this.lSE.e(imageFileInfo);
                }
                ImageListFragment.this.lSx.a(null);
                ImageListFragment.this.lTh.notifyDataSetChanged();
                ImageListFragment.this.HK();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.lSx.Hy()) {
                    ImageListFragment.this.lSE.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.lSx.b(videoFileInfo)) {
                        ImageListFragment.this.lSx.a(null);
                    } else {
                        ImageListFragment.this.lSx.a(videoFileInfo);
                    }
                    ImageListFragment.this.lSx.HA();
                    ImageListFragment.this.lTh.notifyDataSetChanged();
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
        this.lSE = (AlbumActivity) getBaseFragmentActivity();
        this.lSx = this.lSE.dmW();
        d.dmZ().a(this);
        this.lTe = new com.baidu.tbadk.album.f(this.lSE);
        this.lTf = new com.baidu.tieba.write.view.a(this.lSE);
        this.lTf.setOnDismissListener(this.mOnDismissListener);
        this.lTf.a(this.lTi);
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
        this.lSx.fE(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        this.bem.setText(this.lSE.getPageContext().getString(R.string.album_all_media));
        if (this.lSx.getWriteImagesInfo() != null) {
            this.bdB.setVisibility(this.lSx.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.lSx.getWriteImagesInfo() != null && this.lSx.getWriteImagesInfo().isFromQRCode()) {
            this.bdz.setVisibility(8);
        }
        this.mNoDataView = NoDataViewFactory.a(this.lSE.getPageContext().getPageActivity(), this.bej, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.aM(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        this.lTg = (TransparentHeadGridView) this.mView.findViewById(R.id.gv_image_list);
        this.lTg.setSelector(R.color.transparent);
        this.lTh = new h(this.lSE, this.lSx);
        if (this.lSx.getWriteImagesInfo() != null && this.lSx.getWriteImagesInfo().isFromQRCode()) {
            this.lTh.vt(false);
        } else {
            this.lTh.vt(this.lSE.Hi() != 1);
        }
        this.lTg.setAdapter((ListAdapter) this.lTh);
        this.lTg.setOuterOnScrollListener(this);
        this.lTh.a(this.lST);
        this.lTh.a(this.lSS);
        this.lTh.ai(this.lSR);
        this.lTh.setOnOpenCameraFailedListener(this.lSV);
        this.lTh.setOnRequestPermissionListener(this.lSU);
        this.bdA.setOnClickListener(this.lSE);
        this.bek.setOnClickListener(this.lSE);
        this.bel.setOnClickListener(this.lSE);
        this.bdB.setOnClickListener(this.lSE);
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
            this.lSE.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
        int count;
        String string;
        if (this.lSx != null && this.bdA != null) {
            if (this.lSx.Hz()) {
                int i = this.lSx.Hz() ? 1 : 0;
                count = i;
                string = this.lSE.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = v.getCount(this.lSx.HB());
                string = this.lSE.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.lSx.getMaxImagesAllowed())});
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
        if (this.lSx == null && this.lSE != null) {
            this.lSx = this.lSE.dmW();
        }
        if (this.lSx != null) {
            if (!this.lSx.HG()) {
                this.lTh.notifyDataSetChanged();
            } else {
                HL();
            }
            ci(this.lSx.isOriginalImg());
        }
    }

    private void HL() {
        if (this.lTe == null) {
            this.lTe = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.lTe.a(this.lSE.Hi() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
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
                if (ImageListFragment.this.lSx != null && gVar != null) {
                    ImageListFragment.this.lSx.c(gVar);
                    String HD = ImageListFragment.this.lSx.HD();
                    ImageListFragment.this.lSx.fE(HD);
                    ImageListFragment.this.lTh.setData(ImageListFragment.this.lSx.fG(HD));
                    ImageListFragment.this.lTg.smoothScrollToPosition(0);
                    ImageListFragment.this.HK();
                }
                ImageListFragment.this.lTg.HN();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mView);
        am.setBackgroundColor(this.bes, R.color.cp_bg_line_c, i);
        am.setViewTextColor(this.bem, R.color.cp_cont_b, i);
        if (this.lSE.Hi() == 1) {
            SvgManager.aUW().a(this.bek, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            this.bel.setVisibility(8);
        } else {
            am.setViewTextColor(this.bel, (int) R.color.navi_back_text_color);
            this.bek.setVisibility(8);
        }
        if (this.bem != null) {
            this.bem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
        }
        if (this.lTh != null) {
            this.lTh.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.lSx != null) {
            ci(this.lSx.isOriginalImg());
        }
    }

    public View HI() {
        return this.lSE.Hi() == 1 ? this.bek : this.bel;
    }

    public View HM() {
        return this.bdA;
    }

    public TbCameraView dmX() {
        if (this.lTh != null) {
            return this.lTh.dna();
        }
        return null;
    }

    public TransparentHeadGridView dnc() {
        return this.lTg;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.lTf != null) {
            this.lTf.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lTe != null) {
            this.lTe.cancelLoadTask();
        }
        if (this.lSE != null) {
            this.lSE.closeLoadingDialog();
        }
        if (this.euw != null) {
            this.euw.setDialogVisiable(false);
        }
        d.dmZ().b(this);
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
            this.lTh.cl(true);
        } else if (this.lTh.isScroll()) {
            this.lTh.cl(false);
        }
    }

    public void l(int i, boolean z) {
        if (this.lTg != null) {
            int firstVisiblePosition = this.lTg.getFirstVisiblePosition();
            int lastVisiblePosition = this.lTg.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.lTg.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.lTh != null) {
                    this.lTh.b((ImageView) childAt.findViewById(R.id.select_icon), z);
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
        if (imageFileInfo != null && this.lTh != null) {
            l(this.lTh.i(imageFileInfo), z);
        }
    }

    public View Hu() {
        return this.bdB;
    }

    public void ci(boolean z) {
        if (this.lSE != null && this.bdB != null) {
            this.bdB.setText(this.lSE.getResources().getString(R.string.original_img));
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
        this.lSB = iVar;
    }
}
