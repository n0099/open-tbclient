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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.album.d;
import com.baidu.tieba.write.view.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View cXn;
    private ImageView cqo;
    private RelativeLayout dor;
    private TextView dtG;
    private boolean fSD;
    private c hRF;
    private i hRP;
    private AlbumActivity hRT;
    private View hRZ;
    private com.baidu.tbadk.album.f hSC;
    private TextView hSD;
    private com.baidu.tieba.write.view.a hSE;
    private TransparentHeadGridView hSF;
    private h hSG;
    private View hSH;
    private TextView hSa;
    private TextView hSb;
    private NoDataView mNoDataView;
    private View mView;
    private com.baidu.tbadk.core.view.d bib = null;
    private View.OnClickListener hSp = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hRF != null) {
                int maxImagesAllowed = ImageListFragment.this.hRF.getMaxImagesAllowed();
                if (ImageListFragment.this.hRF.size() < maxImagesAllowed) {
                    if (ImageListFragment.this.hRT != null) {
                        ImageListFragment.this.hRT.b(ImageListFragment.this.getPageContext());
                        return;
                    }
                    return;
                }
                ImageListFragment.this.showToast(String.format(ImageListFragment.this.getPageContext().getString(e.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.hRF != null) {
                if (ImageListFragment.this.hRP == null || !ImageListFragment.this.hRP.bNY()) {
                    if (view == ImageListFragment.this.dtG) {
                        ImageListFragment.this.hSE.setData(ImageListFragment.this.hRF.bNK(), ImageListFragment.this.hRF.bNI());
                        ImageListFragment.this.hSE.aK(ImageListFragment.this.cXn);
                        ImageListFragment.this.dtG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_retract), (Drawable) null);
                        return;
                    }
                    if (view == ImageListFragment.this.hRZ) {
                    }
                }
            }
        }
    };
    private TbCameraView.c hSs = new TbCameraView.c() { // from class: com.baidu.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.tieba.write.album.TbCameraView.c
        public boolean bNS() {
            return !ab.e(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    };
    private TbCameraView.a hSt = new TbCameraView.a() { // from class: com.baidu.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.tieba.write.album.TbCameraView.a
        public void bNT() {
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.album.ImageListFragment.5
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.dtG != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = al.getDrawable(e.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.dtG.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f hSq = new f() { // from class: com.baidu.tieba.write.album.ImageListFragment.6
        @Override // com.baidu.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.hRF != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.hRF.f((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.hRT.xa(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0342a hSI = new a.InterfaceC0342a() { // from class: com.baidu.tieba.write.album.ImageListFragment.7
        @Override // com.baidu.tieba.write.view.a.InterfaceC0342a
        public void a(int i, com.baidu.tbadk.album.a aVar) {
            List<MediaFileInfo> xy;
            if (ImageListFragment.this.hRF != null && aVar != null) {
                String albumId = aVar.getAlbumId();
                String name = aVar.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.hRF.bNI()) && (xy = ImageListFragment.this.hRF.xy(albumId)) != null) {
                    ImageListFragment.this.hRF.xw(albumId);
                    ImageListFragment.this.hSG.setData(xy);
                    ImageListFragment.this.dtG.setText(name);
                    ImageListFragment.this.hSF.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g hSr = new g() { // from class: com.baidu.tieba.write.album.ImageListFragment.8
        @Override // com.baidu.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.hRT == null || ImageListFragment.this.hRF == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.hRF.bNF()) {
                    ImageListFragment.this.hRT.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.hRF.isAdded(imageFileInfo)) {
                    ImageListFragment.this.hRT.d(imageFileInfo);
                } else {
                    ImageListFragment.this.hRT.c(imageFileInfo);
                }
                ImageListFragment.this.hRF.a(null);
                ImageListFragment.this.hSG.notifyDataSetChanged();
                ImageListFragment.this.bNO();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.hRF.bNE()) {
                    ImageListFragment.this.hRT.showToast(e.j.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.hRF.b(videoFileInfo)) {
                        ImageListFragment.this.hRF.a(null);
                    } else {
                        ImageListFragment.this.hRF.a(videoFileInfo);
                    }
                    ImageListFragment.this.hRF.bNG();
                    ImageListFragment.this.hSG.notifyDataSetChanged();
                    ImageListFragment.this.bNO();
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
        this.hRT = (AlbumActivity) getBaseFragmentActivity();
        this.hRF = this.hRT.bNp();
        d.bNL().a(this);
        this.hSC = new com.baidu.tbadk.album.f(this.hRT);
        this.hSE = new com.baidu.tieba.write.view.a(this.hRT);
        this.hSE.setOnDismissListener(this.mOnDismissListener);
        this.hSE.a(this.hSI);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(e.h.album_image_list_view, (ViewGroup) null);
        this.dor = (RelativeLayout) this.mView.findViewById(e.g.album_image_list_root);
        this.cXn = this.mView.findViewById(e.g.layout_title);
        this.dtG = (TextView) this.mView.findViewById(e.g.album_title);
        this.cqo = (ImageView) this.mView.findViewById(e.g.img_close);
        this.hSD = (TextView) this.mView.findViewById(e.g.img_close_text);
        this.hSH = this.mView.findViewById(e.g.navi_line);
        this.hRZ = this.mView.findViewById(e.g.layout_bottom);
        this.hSb = (TextView) this.mView.findViewById(e.g.original_select_btn);
        this.hSa = (TextView) this.mView.findViewById(e.g.next_step);
        this.hRF.xw(com.baidu.tbadk.album.a.alN);
        this.dtG.setText(this.hRT.getPageContext().getString(e.j.album_all_media));
        if (this.hRF.getWriteImagesInfo() != null) {
            this.hSb.setVisibility(this.hRF.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        this.mNoDataView = NoDataViewFactory.a(this.hRT.getPageContext().getPageActivity(), this.dor, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.H(e.j.album_list_no_data, e.j.album_list_no_data_1), null);
        this.hSF = (TransparentHeadGridView) this.mView.findViewById(e.g.gv_image_list);
        this.hSF.setSelector(e.d.transparent);
        this.hSG = new h(this.hRT, this.hRF);
        this.hSG.oy(this.hRT.bNo() != 1);
        this.hSF.setAdapter((ListAdapter) this.hSG);
        this.hSF.setOuterOnScrollListener(this);
        this.hSG.a(this.hSr);
        this.hSG.a(this.hSq);
        this.hSG.Y(this.hSp);
        this.hSG.setOnOpenCameraFailedListener(this.hSt);
        this.hSG.setOnRequestPermissionListener(this.hSs);
        this.hSa.setOnClickListener(this.hRT);
        this.cqo.setOnClickListener(this.hRT);
        this.hSD.setOnClickListener(this.hRT);
        this.hSb.setOnClickListener(this.hRT);
        this.dtG.setOnClickListener(this.mOnClickListener);
        this.hRZ.setOnClickListener(this.mOnClickListener);
        bNO();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bib == null) {
            this.bib = new com.baidu.tbadk.core.view.d(getPageContext());
        }
        this.bib.d(null);
        this.bib.ec(e.j.loading);
        this.bib.bA(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.hRT.showToast(e.j.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNO() {
        int H;
        String string;
        if (this.hRF != null && this.hSa != null) {
            if (this.hRF.bNF()) {
                int i = this.hRF.bNF() ? 1 : 0;
                H = i;
                string = this.hRT.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                H = v.H(this.hRF.bNH());
                string = this.hRT.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hRF.getMaxImagesAllowed())});
            }
            this.hSa.setText(string);
            this.hSa.setEnabled(H > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fSD = false;
        if (isShow()) {
            aaA();
        }
    }

    private void bNB() {
        if (this.hRF == null && this.hRT != null) {
            this.hRF = this.hRT.bNp();
        }
        if (this.hRF != null) {
            if (!this.hRF.OK()) {
                this.hSG.notifyDataSetChanged();
            } else {
                bNP();
            }
            ov(this.hRF.isOriginalImg());
        }
    }

    private void bNP() {
        if (this.hSC == null) {
            this.hSC = new com.baidu.tbadk.album.f(getPageContext().getPageActivity());
        }
        this.hSC.a(this.hRT.bNo() == 1 ? 0 : 2, new com.baidu.tbadk.album.e() { // from class: com.baidu.tieba.write.album.ImageListFragment.9
            @Override // com.baidu.tbadk.album.e
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.e
            public void a(com.baidu.tbadk.album.g gVar) {
                if (ImageListFragment.this.bib != null) {
                    ImageListFragment.this.bib.bA(false);
                }
                if (gVar == null) {
                    gVar = new com.baidu.tbadk.album.g();
                }
                if (ImageListFragment.this.hRF != null && gVar != null) {
                    ImageListFragment.this.hRF.c(gVar);
                    String bNI = ImageListFragment.this.hRF.bNI();
                    ImageListFragment.this.hRF.xw(bNI);
                    ImageListFragment.this.hSG.setData(ImageListFragment.this.hRF.xy(bNI));
                    ImageListFragment.this.hSF.smoothScrollToPosition(0);
                    ImageListFragment.this.bNO();
                }
                ImageListFragment.this.hSF.bNW();
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.mView);
        al.e(this.hSH, e.d.cp_bg_line_b, i);
        al.c(this.dtG, e.d.cp_cont_b, i);
        if (this.hRT.bNo() == 1) {
            al.b(this.cqo, e.f.icon_topbar_close_n, i);
            this.hSD.setVisibility(8);
        } else {
            al.h(this.hSD, e.d.navi_back_text_color);
            this.cqo.setVisibility(8);
        }
        if (this.dtG != null) {
            this.dtG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_album_spread), (Drawable) null);
        }
        if (this.hSG != null) {
            this.hSG.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.hRF != null) {
            ov(this.hRF.isOriginalImg());
        }
    }

    public View bxE() {
        return this.hRT.bNo() == 1 ? this.cqo : this.hSD;
    }

    public View bNQ() {
        return this.hSa;
    }

    public TbCameraView bNt() {
        if (this.hSG != null) {
            return this.hSG.bNM();
        }
        return null;
    }

    public TransparentHeadGridView bNR() {
        return this.hSF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.hSE != null) {
            this.hSE.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hSC != null) {
            this.hSC.wk();
        }
        if (this.hRT != null) {
            this.hRT.closeLoadingDialog();
        }
        if (this.bib != null) {
            this.bib.bA(false);
        }
        d.bNL().b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fSD = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.write.album.d.a
    public void ox(boolean z) {
        aaA();
    }

    private void aaA() {
        if (!isHidden() && !this.fSD) {
            bNB();
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
            this.hSG.kg(true);
        } else if (this.hSG.isScroll()) {
            this.hSG.kg(false);
        }
    }

    public void H(int i, boolean z) {
        if (this.hSF != null) {
            int firstVisiblePosition = this.hSF.getFirstVisiblePosition();
            int lastVisiblePosition = this.hSF.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.hSF.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.hSG != null) {
                    this.hSG.d((ImageView) childAt.findViewById(e.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        bNO();
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.hSG != null) {
            H(this.hSG.g(imageFileInfo), z);
        }
    }

    public View bNy() {
        return this.hSb;
    }

    public void ov(boolean z) {
        if (this.hRT != null && this.hSb != null) {
            this.hSb.setText(this.hRT.getResources().getString(e.j.original_img));
            if (z) {
                this.hSb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.hSb, e.d.cp_link_tip_a);
                return;
            }
            this.hSb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.hSb, e.d.cp_cont_f);
        }
    }

    public void a(i iVar) {
        this.hRP = iVar;
    }
}
