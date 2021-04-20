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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import d.b.c.e.p.l;
import d.b.i0.v3.l.d;
import d.b.i0.v3.l.j;
import d.b.i0.v3.u.a;
import java.util.List;
/* loaded from: classes5.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC1676d, AbsListView.OnScrollListener {
    public j H;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f21931e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.v3.l.e f21932f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.v3.l.c f21933g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.e.f f21934h;
    public View i;
    public RelativeLayout j;
    public ImageView k;
    public TextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public d.b.i0.v3.u.a o;
    public TransparentHeadGridView p;
    public d.b.i0.v3.l.i q;
    public NoDataView r;
    public View s;
    public NavigationBar t;
    public View u;
    public TextView v;
    public View w;
    public boolean x;
    public d.b.h0.r.f0.a y = null;
    public View.OnClickListener z = new a();
    public View.OnClickListener A = new b();
    public TbCameraView.g B = new c();
    public TbCameraView.e C = new d();
    public PopupWindow.OnDismissListener D = new e();
    public d.b.i0.v3.l.g E = new f();
    public a.f F = new g();
    public d.b.i0.v3.l.h G = new h();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.f21933g == null) {
                return;
            }
            int l = ImageListFragment.this.f21933g.l();
            if (ImageListFragment.this.f21933g.D() < l) {
                if (ImageListFragment.this.f21932f != null) {
                    ImageListFragment.this.f21932f.T(ImageListFragment.this.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = ImageListFragment.this;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.f21933g == null) {
                return;
            }
            if (ImageListFragment.this.H == null || !ImageListFragment.this.H.i()) {
                if (view == ImageListFragment.this.n) {
                    ImageListFragment.this.o.k(ImageListFragment.this.f21933g.e(), ImageListFragment.this.f21933g.h());
                    ImageListFragment.this.o.n(ImageListFragment.this.t == null ? ImageListFragment.this.s : ImageListFragment.this.t);
                    ImageListFragment.this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null), (Drawable) null);
                    return;
                }
                View unused = ImageListFragment.this.u;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbCameraView.g {
        public c() {
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.g
        public boolean a() {
            return !PermissionUtil.requestWriteExternalStorgeAndCameraPermission(ImageListFragment.this.getPageContext().getPageActivity(), 1);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TbCameraView.e {
        public d() {
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
        }
    }

    /* loaded from: classes5.dex */
    public class e implements PopupWindow.OnDismissListener {
        public e() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.n == null || !ImageListFragment.this.isAdded()) {
                return;
            }
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            if (pureDrawable != null) {
                pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
            }
            ImageListFragment.this.n.setCompoundDrawables(null, null, pureDrawable, null);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements d.b.i0.v3.l.g {
        public f() {
        }

        @Override // d.b.i0.v3.l.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.f21933g == null || ImageListFragment.this.f21933g.m() == null || !ImageListFragment.this.f21933g.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                if (mediaFileInfo == null || ImageListFragment.this.f21933g == null) {
                    return;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.f21933g.y((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.f21932f != null) {
                        ImageListFragment.this.f21932f.P(1);
                        return;
                    }
                    return;
                }
                boolean z = mediaFileInfo instanceof VideoFileInfo;
            } else if (ImageListFragment.this.f21932f != null) {
                ImageListFragment.this.f21932f.l((ImageFileInfo) mediaFileInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.f {
        public g() {
        }

        @Override // d.b.i0.v3.u.a.f
        public void onItemClick(int i, d.b.h0.e.a aVar) {
            List<MediaFileInfo> d2;
            if (ImageListFragment.this.f21933g == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(ImageListFragment.this.f21933g.h()) || (d2 = ImageListFragment.this.f21933g.d(b2)) == null) {
                return;
            }
            ImageListFragment.this.f21933g.x(b2);
            ImageListFragment.this.q.m(d2);
            ImageListFragment.this.n.setText(g2);
            ImageListFragment.this.p.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements d.b.i0.v3.l.h {
        public h() {
        }

        @Override // d.b.i0.v3.l.h
        public boolean a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.f21931e == null || ImageListFragment.this.f21933g == null || ImageListFragment.this.f21932f == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (d.b.i0.v3.s.b.a(imageFileInfo)) {
                    ImageListFragment.this.f21931e.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.f21933g.n(imageFileInfo)) {
                    ImageListFragment.this.f21932f.i(imageFileInfo);
                } else {
                    ImageListFragment.this.f21932f.c(imageFileInfo);
                }
                ImageListFragment.this.f21933g.w(null);
                ImageListFragment.this.q.notifyDataSetChanged();
                ImageListFragment.this.j1();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.f21933g.o()) {
                    ImageListFragment.this.f21931e.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.U0(videoFileInfo) && ImageListFragment.this.T0(videoFileInfo)) {
                    ImageListFragment.this.f21933g.w(videoFileInfo);
                    ImageListFragment.this.f21933g.b();
                    ImageListFragment.this.q.notifyDataSetChanged();
                    ImageListFragment.this.f21932f.h();
                }
                return true;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements d.b.h0.e.e {
        public i() {
        }

        @Override // d.b.h0.e.e
        public void a(d.b.h0.e.g gVar) {
            if (ImageListFragment.this.y != null) {
                ImageListFragment.this.y.h(false);
            }
            if (gVar == null) {
                gVar = new d.b.h0.e.g();
            }
            if (ImageListFragment.this.f21933g != null && ImageListFragment.this.q != null) {
                ImageListFragment.this.f21933g.z(gVar);
                String h2 = ImageListFragment.this.f21933g.h();
                ImageListFragment.this.f21933g.x(h2);
                ImageListFragment.this.q.m(ImageListFragment.this.f21933g.d(h2));
                if (ImageListFragment.this.p != null) {
                    ImageListFragment.this.p.smoothScrollToPosition(0);
                }
                ImageListFragment.this.j1();
            }
            if (ImageListFragment.this.p != null) {
                ImageListFragment.this.p.n();
            }
        }

        @Override // d.b.h0.e.e
        public void onPreLoad() {
        }
    }

    public final boolean T0(VideoFileInfo videoFileInfo) {
        VideoFileInfo e2 = j.e(videoFileInfo.videoPath);
        if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 4096) {
            this.f21931e.showToast(R.string.album_choose_video_resolution_tip);
            return false;
        }
        return true;
    }

    public final boolean U0(VideoFileInfo videoFileInfo) {
        int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i2 < 3000 || i2 > 600000) {
            this.f21931e.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    public View V0() {
        d.b.i0.v3.l.e eVar = this.f21932f;
        return (eVar == null || eVar.o() != 1) ? this.l : this.k;
    }

    public View W0() {
        return this.m;
    }

    public TbCameraView X0() {
        d.b.i0.v3.l.i iVar = this.q;
        if (iVar != null) {
            return iVar.j();
        }
        return null;
    }

    public TransparentHeadGridView Y0() {
        return this.p;
    }

    public View Z0() {
        return this.v;
    }

    public void a1() {
        if (this.f21934h == null) {
            this.f21934h = new d.b.h0.e.f(getPageContext().getPageActivity());
        }
        d.b.i0.v3.l.e eVar = this.f21932f;
        this.f21934h.h((eVar == null || !eVar.e()) ? 2 : 0, new i());
    }

    public final void b1() {
        d.b.i0.v3.l.e eVar;
        if (this.f21933g == null && (eVar = this.f21932f) != null) {
            this.f21933g = eVar.p();
        }
        d.b.i0.v3.l.c cVar = this.f21933g;
        if (cVar == null) {
            return;
        }
        if (!cVar.r()) {
            this.q.notifyDataSetChanged();
        } else {
            a1();
        }
        e1(this.f21933g.s());
    }

    public void c1(int i2, boolean z) {
        TransparentHeadGridView transparentHeadGridView = this.p;
        if (transparentHeadGridView != null) {
            int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
            int lastVisiblePosition = this.p.getLastVisiblePosition();
            if (i2 < firstVisiblePosition || i2 > lastVisiblePosition) {
                return;
            }
            View childAt = this.p.getChildAt(i2 - firstVisiblePosition);
            if (childAt == null || this.q == null) {
                return;
            }
            this.q.t((ImageView) childAt.findViewById(R.id.select_icon), z);
        }
        j1();
    }

    public void d1(ImageFileInfo imageFileInfo, boolean z) {
        d.b.i0.v3.l.i iVar;
        if (imageFileInfo == null || (iVar = this.q) == null) {
            return;
        }
        c1(iVar.i(imageFileInfo), z);
    }

    public void e1(boolean z) {
        BaseFragmentActivity baseFragmentActivity = this.f21931e;
        if (baseFragmentActivity == null || this.v == null) {
            return;
        }
        this.v.setText(baseFragmentActivity.getResources().getString(R.string.original_img));
        if (z) {
            this.v.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_select16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
            return;
        }
        this.v.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_selection16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
    }

    public void f1(d.b.i0.v3.l.e eVar) {
        this.f21932f = eVar;
    }

    public void g1(NavigationBar navigationBar) {
        this.t = navigationBar;
    }

    public void h1(j jVar) {
        this.H = jVar;
    }

    public final void i1() {
        if (this.y == null) {
            this.y = new d.b.h0.r.f0.a(getPageContext());
        }
        this.y.e(null);
        this.y.i(R.string.loading);
        this.y.h(true);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    public final void j1() {
        String string;
        int i2;
        d.b.i0.v3.l.c cVar = this.f21933g;
        if (cVar == null || this.m == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f21933g.p();
            string = this.f21931e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f21933g.g());
            string = this.f21931e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f21933g.l())});
            i2 = count;
        }
        this.m.setText(string);
        this.m.setEnabled(i2 > 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.b.h0.s0.a.a(getPageContext(), this.i);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204, i2);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, i2);
        if (this.l != null && this.k != null) {
            d.b.i0.v3.l.e eVar = this.f21932f;
            if (eVar != null && eVar.o() == 1) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, null);
                this.l.setVisibility(8);
            } else {
                SkinManager.setViewTextColor(this.l, R.color.navi_back_text_color);
                this.k.setVisibility(8);
            }
        }
        if (this.n != null) {
            this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null), (Drawable) null);
        }
        d.b.i0.v3.l.i iVar = this.q;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
        NoDataView noDataView = this.r;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        d.b.i0.v3.l.c cVar = this.f21933g;
        if (cVar != null) {
            e1(cVar.s());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f21931e = baseFragmentActivity;
        if (this.f21932f == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f21932f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f21932f = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        d.b.i0.v3.l.e eVar = this.f21932f;
        if (eVar != null) {
            this.f21933g = eVar.p();
        }
        d.b.i0.v3.l.d.f().d(this);
        this.f21934h = new d.b.h0.e.f(this.f21931e);
        d.b.i0.v3.u.a aVar = new d.b.i0.v3.u.a(this.f21931e);
        this.o = aVar;
        aVar.setOnDismissListener(this.D);
        this.o.l(this.F);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f21931e = baseFragmentActivity;
        if (this.f21932f == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f21932f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f21932f = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        d.b.i0.v3.l.e eVar = this.f21932f;
        if (eVar != null) {
            this.f21933g = eVar.p();
        }
        View inflate = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.i = inflate;
        this.j = (RelativeLayout) inflate.findViewById(R.id.album_image_list_root);
        this.s = this.i.findViewById(R.id.layout_title);
        this.n = (TextView) this.i.findViewById(R.id.album_title);
        this.k = (ImageView) this.i.findViewById(R.id.img_close);
        this.l = (TextView) this.i.findViewById(R.id.img_close_text);
        this.w = this.i.findViewById(R.id.navi_line);
        this.u = this.i.findViewById(R.id.layout_bottom);
        this.v = (TextView) this.i.findViewById(R.id.original_select_btn);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.i.findViewById(R.id.next_step);
        this.m = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        this.m.getStyleConfig().k(l.g(this.f21931e, R.dimen.tbds25));
        this.f21933g.x(d.b.h0.e.a.f50513f);
        this.n.setText(this.f21931e.getPageContext().getString(R.string.album_all_media));
        if (this.f21933g.m() != null) {
            this.v.setVisibility(this.f21933g.m().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.f21933g.m() != null && this.f21933g.m().isFromQRCode()) {
            this.u.setVisibility(8);
        }
        this.r = NoDataViewFactory.a(this.f21931e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.i.findViewById(R.id.gv_image_list);
        this.p = transparentHeadGridView;
        transparentHeadGridView.setSelector(R.color.transparent);
        this.q = new d.b.i0.v3.l.i(this.f21931e, this.f21933g);
        if (this.f21933g.m() != null && this.f21933g.m().isFromQRCode()) {
            this.q.v(false);
        } else {
            this.q.v(true);
        }
        this.p.setAdapter((ListAdapter) this.q);
        this.p.setOuterOnScrollListener(this);
        this.q.u(this.G);
        this.q.n(this.E);
        this.q.q(this.z);
        this.q.o(this.C);
        this.q.p(this.B);
        this.m.setOnClickListener(this.f21931e);
        this.k.setOnClickListener(this.f21931e);
        this.l.setOnClickListener(this.f21931e);
        this.v.setOnClickListener(this.f21931e);
        this.n.setOnClickListener(this.A);
        this.u.setOnClickListener(this.A);
        j1();
        i1();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.t != null) {
            if (this.n.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.n.getParent()).removeView(this.n);
            }
            this.s.setVisibility(8);
            this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.n, (View.OnClickListener) null);
        }
        return this.i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.h0.e.f fVar = this.f21934h;
        if (fVar != null) {
            fVar.c();
        }
        BaseFragmentActivity baseFragmentActivity = this.f21931e;
        if (baseFragmentActivity != null) {
            baseFragmentActivity.closeLoadingDialog();
        }
        d.b.h0.r.f0.a aVar = this.y;
        if (aVar != null) {
            aVar.h(false);
        }
        d.b.i0.v3.l.d.f().k(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        d.b.i0.v3.u.a aVar = this.o;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.x = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.x = false;
        if (isShow()) {
            w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        super.onScroll(absListView, i2, i3, i4);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 2) {
            this.q.r(true);
        } else if (this.q.k()) {
            this.q.r(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public final void w() {
        if (isHidden() || this.x) {
            return;
        }
        b1();
    }

    @Override // d.b.i0.v3.l.d.InterfaceC1676d
    public void z(boolean z) {
        w();
    }
}
