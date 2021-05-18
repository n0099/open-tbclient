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
import d.a.c.e.p.l;
import d.a.k0.v3.k.d;
import d.a.k0.v3.k.j;
import d.a.k0.v3.t.a;
import java.util.List;
/* loaded from: classes5.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC1701d, AbsListView.OnScrollListener {
    public j H;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f21856e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.v3.k.e f21857f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.v3.k.c f21858g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.e.f f21859h;

    /* renamed from: i  reason: collision with root package name */
    public View f21860i;
    public RelativeLayout j;
    public ImageView k;
    public TextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public d.a.k0.v3.t.a o;
    public TransparentHeadGridView p;
    public d.a.k0.v3.k.i q;
    public NoDataView r;
    public View s;
    public NavigationBar t;
    public View u;
    public TextView v;
    public View w;
    public boolean x;
    public d.a.j0.r.f0.a y = null;
    public View.OnClickListener z = new a();
    public View.OnClickListener A = new b();
    public TbCameraView.g B = new c();
    public TbCameraView.e C = new d();
    public PopupWindow.OnDismissListener D = new e();
    public d.a.k0.v3.k.g E = new f();
    public a.f F = new g();
    public d.a.k0.v3.k.h G = new h();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.f21858g == null) {
                return;
            }
            int l = ImageListFragment.this.f21858g.l();
            if (ImageListFragment.this.f21858g.D() < l) {
                if (ImageListFragment.this.f21857f != null) {
                    ImageListFragment.this.f21857f.Q(ImageListFragment.this.getPageContext());
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
            if (ImageListFragment.this.f21858g == null) {
                return;
            }
            if (ImageListFragment.this.H == null || !ImageListFragment.this.H.i()) {
                if (view == ImageListFragment.this.n) {
                    ImageListFragment.this.o.k(ImageListFragment.this.f21858g.e(), ImageListFragment.this.f21858g.h());
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
    public class f implements d.a.k0.v3.k.g {
        public f() {
        }

        @Override // d.a.k0.v3.k.g
        public void a(int i2, MediaFileInfo mediaFileInfo) {
            if (ImageListFragment.this.f21858g == null || ImageListFragment.this.f21858g.m() == null || !ImageListFragment.this.f21858g.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                if (mediaFileInfo == null || ImageListFragment.this.f21858g == null) {
                    return;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.f21858g.y((ImageFileInfo) mediaFileInfo);
                    if (ImageListFragment.this.f21857f != null) {
                        ImageListFragment.this.f21857f.M(1);
                        return;
                    }
                    return;
                }
                boolean z = mediaFileInfo instanceof VideoFileInfo;
            } else if (ImageListFragment.this.f21857f != null) {
                ImageListFragment.this.f21857f.k((ImageFileInfo) mediaFileInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.f {
        public g() {
        }

        @Override // d.a.k0.v3.t.a.f
        public void onItemClick(int i2, d.a.j0.e.a aVar) {
            List<MediaFileInfo> d2;
            if (ImageListFragment.this.f21858g == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(ImageListFragment.this.f21858g.h()) || (d2 = ImageListFragment.this.f21858g.d(b2)) == null) {
                return;
            }
            ImageListFragment.this.f21858g.x(b2);
            ImageListFragment.this.q.m(d2);
            ImageListFragment.this.n.setText(g2);
            ImageListFragment.this.p.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements d.a.k0.v3.k.h {
        public h() {
        }

        @Override // d.a.k0.v3.k.h
        public boolean a(int i2, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.f21856e == null || ImageListFragment.this.f21858g == null || ImageListFragment.this.f21857f == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (d.a.k0.v3.r.b.a(imageFileInfo)) {
                    ImageListFragment.this.f21856e.showToast(R.string.album_choose_image_low_quality_tip);
                    return false;
                }
                if (ImageListFragment.this.f21858g.n(imageFileInfo)) {
                    ImageListFragment.this.f21857f.h(imageFileInfo);
                } else {
                    ImageListFragment.this.f21857f.c(imageFileInfo);
                }
                ImageListFragment.this.f21858g.w(null);
                ImageListFragment.this.q.notifyDataSetChanged();
                ImageListFragment.this.i1();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.f21858g.o()) {
                    ImageListFragment.this.f21856e.showToast(R.string.album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.T0(videoFileInfo) && ImageListFragment.this.S0(videoFileInfo)) {
                    ImageListFragment.this.f21858g.w(videoFileInfo);
                    ImageListFragment.this.f21858g.b();
                    ImageListFragment.this.q.notifyDataSetChanged();
                    ImageListFragment.this.f21857f.g();
                }
                return true;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements d.a.j0.e.e {
        public i() {
        }

        @Override // d.a.j0.e.e
        public void a(d.a.j0.e.g gVar) {
            if (ImageListFragment.this.y != null) {
                ImageListFragment.this.y.h(false);
            }
            if (gVar == null) {
                gVar = new d.a.j0.e.g();
            }
            if (ImageListFragment.this.f21858g != null && ImageListFragment.this.q != null) {
                ImageListFragment.this.f21858g.z(gVar);
                String h2 = ImageListFragment.this.f21858g.h();
                ImageListFragment.this.f21858g.x(h2);
                ImageListFragment.this.q.m(ImageListFragment.this.f21858g.d(h2));
                if (ImageListFragment.this.p != null) {
                    ImageListFragment.this.p.smoothScrollToPosition(0);
                }
                ImageListFragment.this.i1();
            }
            if (ImageListFragment.this.p != null) {
                ImageListFragment.this.p.n();
            }
        }

        @Override // d.a.j0.e.e
        public void onPreLoad() {
        }
    }

    public final boolean S0(VideoFileInfo videoFileInfo) {
        VideoFileInfo e2 = j.e(videoFileInfo.videoPath);
        if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 4096) {
            this.f21856e.showToast(R.string.album_choose_video_resolution_tip);
            return false;
        }
        return true;
    }

    public final boolean T0(VideoFileInfo videoFileInfo) {
        int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i2 < 3000 || i2 > 600000) {
            this.f21856e.showToast(R.string.album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    public View U0() {
        d.a.k0.v3.k.e eVar = this.f21857f;
        return (eVar == null || eVar.n() != 1) ? this.l : this.k;
    }

    public View V0() {
        return this.m;
    }

    public TbCameraView W0() {
        d.a.k0.v3.k.i iVar = this.q;
        if (iVar != null) {
            return iVar.j();
        }
        return null;
    }

    public TransparentHeadGridView X0() {
        return this.p;
    }

    public View Y0() {
        return this.v;
    }

    public void Z0() {
        if (this.f21859h == null) {
            this.f21859h = new d.a.j0.e.f(getPageContext().getPageActivity());
        }
        d.a.k0.v3.k.e eVar = this.f21857f;
        this.f21859h.h((eVar == null || !eVar.e()) ? 2 : 0, new i());
    }

    public final void a1() {
        d.a.k0.v3.k.e eVar;
        if (this.f21858g == null && (eVar = this.f21857f) != null) {
            this.f21858g = eVar.o();
        }
        d.a.k0.v3.k.c cVar = this.f21858g;
        if (cVar == null) {
            return;
        }
        if (!cVar.r()) {
            this.q.notifyDataSetChanged();
        } else {
            Z0();
        }
        d1(this.f21858g.s());
    }

    public void b1(int i2, boolean z) {
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
        i1();
    }

    public void c1(ImageFileInfo imageFileInfo, boolean z) {
        d.a.k0.v3.k.i iVar;
        if (imageFileInfo == null || (iVar = this.q) == null) {
            return;
        }
        b1(iVar.i(imageFileInfo), z);
    }

    public void d1(boolean z) {
        BaseFragmentActivity baseFragmentActivity = this.f21856e;
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

    public void e1(d.a.k0.v3.k.e eVar) {
        this.f21857f = eVar;
    }

    public void f1(NavigationBar navigationBar) {
        this.t = navigationBar;
    }

    public void g1(j jVar) {
        this.H = jVar;
    }

    public final void h1() {
        if (this.y == null) {
            this.y = new d.a.j0.r.f0.a(getPageContext());
        }
        this.y.e(null);
        this.y.i(R.string.loading);
        this.y.h(true);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    public final void i1() {
        String string;
        int i2;
        d.a.k0.v3.k.c cVar = this.f21858g;
        if (cVar == null || this.m == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f21858g.p();
            string = this.f21856e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f21858g.g());
            string = this.f21856e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f21858g.l())});
            i2 = count;
        }
        this.m.setText(string);
        this.m.setEnabled(i2 > 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.j0.s0.a.a(getPageContext(), this.f21860i);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204, i2);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, i2);
        if (this.l != null && this.k != null) {
            d.a.k0.v3.k.e eVar = this.f21857f;
            if (eVar != null && eVar.n() == 1) {
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
        d.a.k0.v3.k.i iVar = this.q;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
        NoDataView noDataView = this.r;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        d.a.k0.v3.k.c cVar = this.f21858g;
        if (cVar != null) {
            d1(cVar.s());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f21856e = baseFragmentActivity;
        if (this.f21857f == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f21857f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f21857f = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        d.a.k0.v3.k.e eVar = this.f21857f;
        if (eVar != null) {
            this.f21858g = eVar.o();
        }
        d.a.k0.v3.k.d.f().d(this);
        this.f21859h = new d.a.j0.e.f(this.f21856e);
        d.a.k0.v3.t.a aVar = new d.a.k0.v3.t.a(this.f21856e);
        this.o = aVar;
        aVar.setOnDismissListener(this.D);
        this.o.l(this.F);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f21856e = baseFragmentActivity;
        if (this.f21857f == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f21857f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f21857f = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        d.a.k0.v3.k.e eVar = this.f21857f;
        if (eVar != null) {
            this.f21858g = eVar.o();
        }
        View inflate = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.f21860i = inflate;
        this.j = (RelativeLayout) inflate.findViewById(R.id.album_image_list_root);
        this.s = this.f21860i.findViewById(R.id.layout_title);
        this.n = (TextView) this.f21860i.findViewById(R.id.album_title);
        this.k = (ImageView) this.f21860i.findViewById(R.id.img_close);
        this.l = (TextView) this.f21860i.findViewById(R.id.img_close_text);
        this.w = this.f21860i.findViewById(R.id.navi_line);
        this.u = this.f21860i.findViewById(R.id.layout_bottom);
        this.v = (TextView) this.f21860i.findViewById(R.id.original_select_btn);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f21860i.findViewById(R.id.next_step);
        this.m = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        this.m.getStyleConfig().k(l.g(this.f21856e, R.dimen.tbds25));
        this.f21858g.x(d.a.j0.e.a.f49255f);
        this.n.setText(this.f21856e.getPageContext().getString(R.string.album_all_media));
        if (this.f21858g.m() != null) {
            this.v.setVisibility(this.f21858g.m().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (this.f21858g.m() != null && this.f21858g.m().isFromQRCode()) {
            this.u.setVisibility(8);
        }
        this.r = NoDataViewFactory.a(this.f21856e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
        TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.f21860i.findViewById(R.id.gv_image_list);
        this.p = transparentHeadGridView;
        transparentHeadGridView.setSelector(R.color.transparent);
        this.q = new d.a.k0.v3.k.i(this.f21856e, this.f21858g);
        if (this.f21858g.m() != null && this.f21858g.m().isFromQRCode()) {
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
        this.m.setOnClickListener(this.f21856e);
        this.k.setOnClickListener(this.f21856e);
        this.l.setOnClickListener(this.f21856e);
        this.v.setOnClickListener(this.f21856e);
        this.n.setOnClickListener(this.A);
        this.u.setOnClickListener(this.A);
        i1();
        h1();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.t != null) {
            if (this.n.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.n.getParent()).removeView(this.n);
            }
            this.s.setVisibility(8);
            this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.n, (View.OnClickListener) null);
        }
        return this.f21860i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.e.f fVar = this.f21859h;
        if (fVar != null) {
            fVar.c();
        }
        BaseFragmentActivity baseFragmentActivity = this.f21856e;
        if (baseFragmentActivity != null) {
            baseFragmentActivity.closeLoadingDialog();
        }
        d.a.j0.r.f0.a aVar = this.y;
        if (aVar != null) {
            aVar.h(false);
        }
        d.a.k0.v3.k.d.f().k(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        d.a.k0.v3.t.a aVar = this.o;
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
            p();
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

    public final void p() {
        if (isHidden() || this.x) {
            return;
        }
        a1();
    }

    @Override // d.a.k0.v3.k.d.InterfaceC1701d
    public void r(boolean z) {
        p();
    }
}
