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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.e1.p0;
import c.a.t0.o4.d0.b;
import c.a.t0.o4.u.d;
import c.a.t0.o4.u.j;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC1315d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.s.i0.a A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public TbCameraView.i D;
    public TbCameraView.g E;
    public PopupWindow.OnDismissListener F;
    public c.a.t0.o4.u.g G;
    public b.f H;
    public c.a.t0.o4.u.h I;
    public j J;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f51570e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.o4.u.e f51571f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.o4.u.c f51572g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.f.f f51573h;

    /* renamed from: i  reason: collision with root package name */
    public View f51574i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f51575j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f51576k;
    public TextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public c.a.t0.o4.d0.b o;
    public TransparentHeadGridView p;
    public c.a.t0.o4.u.i q;
    public NoDataView r;
    public View s;
    public NavigationBar t;
    public View u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f51577e;

        public a(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51577e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || p0.b() || this.f51577e.f51572g == null) {
                return;
            }
            int l = this.f51577e.f51572g.l();
            if (this.f51577e.f51572g.D() < l) {
                if (this.f51577e.f51571f != null) {
                    this.f51577e.f51571f.S(this.f51577e.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.f51577e;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(c.a.t0.o4.j.max_choose_image_count), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f51578e;

        public b(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51578e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51578e.f51572g == null) {
                return;
            }
            if (this.f51578e.J == null || !this.f51578e.J.i()) {
                if (view == this.f51578e.n) {
                    this.f51578e.o.k(this.f51578e.f51572g.e(), this.f51578e.f51572g.h());
                    this.f51578e.o.n(this.f51578e.t == null ? this.f51578e.s : this.f51578e.t);
                    this.f51578e.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(c.a.t0.o4.f.icon_pure_fold12_svg, c.a.t0.o4.d.CAM_X0105, null), (Drawable) null);
                    return;
                }
                View unused = this.f51578e.u;
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements TbCameraView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public c(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.i
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !PermissionUtil.requestWriteExternalStorgeAndCameraPermission(this.a.getPageContext().getPageActivity(), 1) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class d implements TbCameraView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public d(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f51579e;

        public e(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51579e = imageListFragment;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f51579e.n != null && this.f51579e.isAdded()) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(c.a.t0.o4.f.icon_pure_unfold12_svg, c.a.t0.o4.d.CAM_X0105, null);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
                }
                this.f51579e.n.setCompoundDrawables(null, null, pureDrawable, null);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class f implements c.a.t0.o4.u.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public f(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.t0.o4.u.g
        public void a(int i2, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, mediaFileInfo) == null) {
                if (!this.a.z || this.a.f51572g == null || this.a.f51572g.l() != 1 || this.a.I == null) {
                    if (this.a.f51572g == null || this.a.f51572g.m() == null || !this.a.f51572g.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                        if (mediaFileInfo == null || this.a.f51572g == null) {
                            return;
                        }
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            this.a.f51572g.y((ImageFileInfo) mediaFileInfo);
                            if (this.a.f51571f != null) {
                                this.a.f51571f.O(1);
                                return;
                            }
                            return;
                        }
                        boolean z = mediaFileInfo instanceof VideoFileInfo;
                    } else if (this.a.f51571f != null) {
                        this.a.f51571f.n((ImageFileInfo) mediaFileInfo);
                    }
                } else if (this.a.I.a(i2, mediaFileInfo)) {
                    this.a.f51571f.j();
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class g implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public g(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.t0.o4.d0.b.f
        public void onItemClick(int i2, c.a.s0.f.a aVar) {
            List<MediaFileInfo> d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || this.a.f51572g == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(this.a.f51572g.h()) || (d2 = this.a.f51572g.d(b2)) == null) {
                return;
            }
            this.a.f51572g.x(b2);
            this.a.q.m(d2);
            this.a.n.setText(g2);
            this.a.p.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes13.dex */
    public class h implements c.a.t0.o4.u.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public h(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.t0.o4.u.h
        public boolean a(int i2, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.a.f51570e == null || this.a.f51572g == null || this.a.f51571f == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (c.a.t0.o4.b0.a.a(imageFileInfo)) {
                        this.a.f51570e.showToast(c.a.t0.o4.j.album_choose_image_low_quality_tip);
                        return false;
                    } else if (!c.a.t0.o4.b0.a.b(imageFileInfo)) {
                        if (this.a.f51572g.n(imageFileInfo)) {
                            this.a.f51571f.k(imageFileInfo);
                        } else {
                            this.a.f51571f.d(imageFileInfo);
                        }
                        this.a.f51572g.w(null);
                        this.a.q.notifyDataSetChanged();
                        this.a.z();
                        return true;
                    } else {
                        this.a.f51570e.showToast(String.format(this.a.getString(c.a.t0.o4.j.album_choose_image_max_wh_tip), Integer.valueOf(c.a.s0.s.g0.b.j().k("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.s0.s.g0.b.j().k("key_upload_pic_max_height", 0))));
                        return false;
                    }
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    if (this.a.f51572g.o()) {
                        this.a.f51570e.showToast(c.a.t0.o4.j.album_choose_switch_tip);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (this.a.x(videoFileInfo) && this.a.w(videoFileInfo)) {
                        this.a.f51572g.w(videoFileInfo);
                        this.a.f51572g.b();
                        this.a.q.notifyDataSetChanged();
                        this.a.f51571f.j();
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class i implements c.a.s0.f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public i(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.s0.f.e
        public void a(c.a.s0.f.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (this.a.A != null) {
                    this.a.A.h(false);
                }
                if (gVar == null) {
                    gVar = new c.a.s0.f.g();
                }
                if (this.a.f51572g != null && this.a.q != null) {
                    this.a.f51572g.z(gVar);
                    String h2 = this.a.f51572g.h();
                    this.a.f51572g.x(h2);
                    this.a.q.m(this.a.f51572g.d(h2));
                    if (this.a.p != null) {
                        this.a.p.smoothScrollToPosition(0);
                    }
                    this.a.z();
                }
                if (this.a.p != null) {
                    this.a.p.smoothScroll();
                }
            }
        }

        @Override // c.a.s0.f.e
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public ImageListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = true;
        this.z = false;
        this.A = null;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this);
        this.G = new f(this);
        this.H = new g(this);
        this.I = new h(this);
    }

    public View getBackBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.t0.o4.u.e eVar = this.f51571f;
            return (eVar == null || eVar.q() != 1) ? this.l : this.f51576k;
        }
        return (View) invokeV.objValue;
    }

    public View getBtnNextStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public TbCameraView getCameraView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.t0.o4.u.i iVar = this.q;
            if (iVar != null) {
                return iVar.j();
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public TransparentHeadGridView getGridView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : (TransparentHeadGridView) invokeV.objValue;
    }

    public View getOriginSelectBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : (View) invokeV.objValue;
    }

    public void loadAlbumMediaList() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f51573h == null) {
                this.f51573h = new c.a.s0.f.f(getPageContext().getPageActivity());
            }
            c.a.t0.o4.u.e eVar = this.f51571f;
            if (eVar == null) {
                return;
            }
            if (eVar.h()) {
                i2 = this.f51571f.g() ? 1 : 0;
            } else {
                i2 = this.f51571f.f() ? 2 : 3;
            }
            this.f51573h.h(i2, new i(this));
        }
    }

    public void notifyDataSetChanged() {
        c.a.t0.o4.u.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f51572g) == null || cVar.r()) {
            return;
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.s0.x0.a.a(getPageContext(), this.f51574i);
            SkinManager.setBackgroundColor(this.w, c.a.t0.o4.d.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.n, c.a.t0.o4.d.CAM_X0105, i2);
            if (this.l != null && this.f51576k != null) {
                c.a.t0.o4.u.e eVar = this.f51571f;
                if (eVar != null && eVar.q() == 1) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51576k, c.a.t0.o4.f.icon_pure_topbar_close44_svg, c.a.t0.o4.d.CAM_X0105, null);
                    this.l.setVisibility(8);
                } else {
                    SkinManager.setViewTextColor(this.l, c.a.t0.o4.d.navi_back_text_color);
                    this.f51576k.setVisibility(8);
                }
            }
            if (this.n != null) {
                this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(c.a.t0.o4.f.icon_pure_unfold12_svg, c.a.t0.o4.d.CAM_X0105, null), (Drawable) null);
            }
            c.a.t0.o4.u.i iVar = this.q;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            c.a.t0.o4.u.c cVar = this.f51572g;
            if (cVar != null) {
                selectOriginalImg(cVar.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f51570e = baseFragmentActivity;
            if (this.f51571f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f51571f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f51571f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.t0.o4.u.e eVar = this.f51571f;
            if (eVar != null) {
                this.f51572g = eVar.r();
                this.y = this.f51571f.w();
                this.z = this.f51571f.v();
            }
            c.a.t0.o4.u.d.f().d(this);
            this.f51573h = new c.a.s0.f.f(this.f51570e);
            c.a.t0.o4.d0.b bVar = new c.a.t0.o4.d0.b(this.f51570e);
            this.o = bVar;
            bVar.setOnDismissListener(this.F);
            this.o.l(this.H);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f51570e = baseFragmentActivity;
            if (this.f51571f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f51571f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f51571f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.t0.o4.u.e eVar = this.f51571f;
            if (eVar != null) {
                this.f51572g = eVar.r();
            }
            View inflate = layoutInflater.inflate(c.a.t0.o4.h.album_image_list_view, (ViewGroup) null);
            this.f51574i = inflate;
            this.f51575j = (RelativeLayout) inflate.findViewById(c.a.t0.o4.g.album_image_list_root);
            this.s = this.f51574i.findViewById(c.a.t0.o4.g.layout_title);
            this.n = (TextView) this.f51574i.findViewById(c.a.t0.o4.g.album_title);
            this.f51576k = (ImageView) this.f51574i.findViewById(c.a.t0.o4.g.img_close);
            this.l = (TextView) this.f51574i.findViewById(c.a.t0.o4.g.img_close_text);
            this.w = this.f51574i.findViewById(c.a.t0.o4.g.navi_line);
            this.u = this.f51574i.findViewById(c.a.t0.o4.g.layout_bottom);
            this.v = (TextView) this.f51574i.findViewById(c.a.t0.o4.g.original_select_btn);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f51574i.findViewById(c.a.t0.o4.g.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(c.a.t0.o4.e.tbds34);
            this.m.getStyleConfig().l(n.f(this.f51570e, c.a.t0.o4.e.tbds25));
            this.f51572g.x(c.a.s0.f.a.f12745f);
            this.n.setText(this.f51570e.getPageContext().getString(c.a.t0.o4.j.album_all_media));
            if (this.f51572g.m() != null) {
                this.v.setVisibility(this.f51572g.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (this.f51572g.m() != null && this.f51572g.m().isFromQRCode()) {
                this.u.setVisibility(8);
            }
            this.r = NoDataViewFactory.a(this.f51570e.getPageContext().getPageActivity(), this.f51575j, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(c.a.t0.o4.j.album_list_no_data, c.a.t0.o4.j.album_list_no_data_1), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.f51574i.findViewById(c.a.t0.o4.g.gv_image_list);
            this.p = transparentHeadGridView;
            transparentHeadGridView.setSelector(c.a.t0.o4.d.transparent);
            c.a.t0.o4.u.i iVar = new c.a.t0.o4.u.i(this.f51570e, this.f51572g);
            this.q = iVar;
            if (this.y) {
                if (this.f51572g.m() != null && this.f51572g.m().isFromQRCode()) {
                    this.q.v(false);
                } else {
                    this.q.v(true);
                }
            } else {
                iVar.v(false);
            }
            if (this.z && this.f51572g.l() == 1) {
                this.q.w(false);
            } else {
                this.q.w(true);
            }
            this.p.setAdapter((ListAdapter) this.q);
            this.p.setOuterOnScrollListener(this);
            this.q.u(this.I);
            this.q.n(this.G);
            this.q.q(this.B);
            this.q.o(this.E);
            this.q.p(this.D);
            this.m.setOnClickListener(this.f51570e);
            this.f51576k.setOnClickListener(this.f51570e);
            this.l.setOnClickListener(this.f51570e);
            this.v.setOnClickListener(this.f51570e);
            this.n.setOnClickListener(this.C);
            this.u.setOnClickListener(this.C);
            z();
            showLoadingView();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.t != null) {
                if (this.n.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.n.getParent()).removeView(this.n);
                }
                this.s.setVisibility(8);
                this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.n, (View.OnClickListener) null);
            }
            return this.f51574i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            c.a.s0.f.f fVar = this.f51573h;
            if (fVar != null) {
                fVar.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.f51570e;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            c.a.s0.s.i0.a aVar = this.A;
            if (aVar != null) {
                aVar.h(false);
            }
            c.a.t0.o4.u.d.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetach();
            c.a.t0.o4.d0.b bVar = this.o;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    @Override // c.a.t0.o4.u.d.InterfaceC1315d
    public void onImageRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            refreshPage();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            this.x = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            this.x = false;
            if (isShow()) {
                refreshPage();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048591, this, absListView, i2, i3, i4) == null) {
            super.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, absListView, i2) == null) {
            super.onScrollStateChanged(absListView, i2);
            if (i2 == 2) {
                this.q.r(true);
            } else if (this.q.k()) {
                this.q.r(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
        }
    }

    public void refreshItem(int i2, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.p;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.p.getLastVisiblePosition();
                if (i2 < firstVisiblePosition || i2 > lastVisiblePosition || (childAt = this.p.getChildAt(i2 - firstVisiblePosition)) == null || this.q == null) {
                    return;
                }
                this.q.t((ImageView) childAt.findViewById(c.a.t0.o4.g.select_icon), z);
            }
            z();
        }
    }

    public final void refreshPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || isHidden() || this.x) {
            return;
        }
        y();
    }

    public void selectOriginalImg(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (baseFragmentActivity = this.f51570e) == null || this.v == null) {
            return;
        }
        this.v.setText(baseFragmentActivity.getResources().getString(c.a.t0.o4.j.original_img));
        if (z) {
            this.v.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(c.a.t0.o4.f.icon_pure_image_ok_select16, SkinManager.getColor(c.a.t0.o4.d.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.v, c.a.t0.o4.d.CAM_X0302);
            return;
        }
        this.v.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(c.a.t0.o4.f.icon_pure_image_ok_selection16, SkinManager.getColor(c.a.t0.o4.d.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this.v, c.a.t0.o4.d.CAM_X0106);
    }

    public void setAlbumView(c.a.t0.o4.u.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.f51571f = eVar;
        }
    }

    public void setNavBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, navigationBar) == null) {
            this.t = navigationBar;
        }
    }

    public void setVideoCompressController(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jVar) == null) {
            this.J = jVar;
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.A == null) {
                this.A = new c.a.s0.s.i0.a(getPageContext());
            }
            this.A.e(null);
            this.A.i(c.a.t0.o4.j.loading);
            this.A.h(true);
        }
    }

    public final boolean w(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, videoFileInfo)) == null) {
            VideoFileInfo e2 = j.e(videoFileInfo.videoPath);
            if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 3000) {
                this.f51570e.showToast(c.a.t0.o4.j.album_choose_video_resolution_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean x(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, videoFileInfo)) == null) {
            int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
            if (i2 < 3000 || i2 > 600000) {
                this.f51570e.showToast(c.a.t0.o4.j.album_choose_video_time_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y() {
        c.a.t0.o4.u.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.f51572g == null && (eVar = this.f51571f) != null) {
                this.f51572g = eVar.r();
            }
            c.a.t0.o4.u.c cVar = this.f51572g;
            if (cVar == null) {
                return;
            }
            if (!cVar.r()) {
                this.q.notifyDataSetChanged();
            } else {
                loadAlbumMediaList();
            }
            selectOriginalImg(this.f51572g.s());
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [boolean, int] */
    public final void z() {
        c.a.t0.o4.u.c cVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (cVar = this.f51572g) == null || this.m == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f51572g.p();
            string = this.f51570e.getString(c.a.t0.o4.j.image_selected_list_count_max, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f51572g.g());
            string = this.f51570e.getString(c.a.t0.o4.j.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f51572g.l())});
            i2 = count;
        }
        this.m.setText(string);
        this.m.setEnabled(i2 > 0);
    }

    public void refreshItem(ImageFileInfo imageFileInfo, boolean z) {
        c.a.t0.o4.u.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, imageFileInfo, z) == null) || imageFileInfo == null || (iVar = this.q) == null) {
            return;
        }
        refreshItem(iVar.i(imageFileInfo), z);
    }
}
