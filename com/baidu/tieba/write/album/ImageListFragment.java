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
import b.a.e.e.p.l;
import b.a.q0.d1.n0;
import b.a.r0.d4.k.d;
import b.a.r0.d4.k.j;
import b.a.r0.d4.t.a;
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
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC0811d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.q0.s.g0.a A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public TbCameraView.i D;
    public TbCameraView.g E;
    public PopupWindow.OnDismissListener F;
    public b.a.r0.d4.k.g G;
    public a.f H;
    public b.a.r0.d4.k.h I;
    public j J;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f55763e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.d4.k.e f55764f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.d4.k.c f55765g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.f.f f55766h;

    /* renamed from: i  reason: collision with root package name */
    public View f55767i;
    public RelativeLayout j;
    public ImageView k;
    public TextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public b.a.r0.d4.t.a o;
    public TransparentHeadGridView p;
    public b.a.r0.d4.k.i q;
    public NoDataView r;
    public View s;
    public NavigationBar t;
    public View u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55768e;

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
            this.f55768e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || n0.b() || this.f55768e.f55765g == null) {
                return;
            }
            int l = this.f55768e.f55765g.l();
            if (this.f55768e.f55765g.D() < l) {
                if (this.f55768e.f55764f != null) {
                    this.f55768e.f55764f.a0(this.f55768e.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.f55768e;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55769e;

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
            this.f55769e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55769e.f55765g == null) {
                return;
            }
            if (this.f55769e.J == null || !this.f55769e.J.i()) {
                if (view == this.f55769e.n) {
                    this.f55769e.o.k(this.f55769e.f55765g.e(), this.f55769e.f55765g.h());
                    this.f55769e.o.n(this.f55769e.t == null ? this.f55769e.s : this.f55769e.t);
                    this.f55769e.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null), (Drawable) null);
                    return;
                }
                View unused = this.f55769e.u;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements TbCameraView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55770a;

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
            this.f55770a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.i
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !PermissionUtil.requestWriteExternalStorgeAndCameraPermission(this.f55770a.getPageContext().getPageActivity(), 1) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements TbCameraView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55771e;

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
            this.f55771e = imageListFragment;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f55771e.n != null && this.f55771e.isAdded()) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
                }
                this.f55771e.n.setCompoundDrawables(null, null, pureDrawable, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.a.r0.d4.k.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55772a;

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
            this.f55772a = imageListFragment;
        }

        @Override // b.a.r0.d4.k.g
        public void a(int i2, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, mediaFileInfo) == null) {
                if (!this.f55772a.z || this.f55772a.f55765g == null || this.f55772a.f55765g.l() != 1 || this.f55772a.I == null) {
                    if (this.f55772a.f55765g == null || this.f55772a.f55765g.m() == null || !this.f55772a.f55765g.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                        if (mediaFileInfo == null || this.f55772a.f55765g == null) {
                            return;
                        }
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            this.f55772a.f55765g.y((ImageFileInfo) mediaFileInfo);
                            if (this.f55772a.f55764f != null) {
                                this.f55772a.f55764f.W(1);
                                return;
                            }
                            return;
                        }
                        boolean z = mediaFileInfo instanceof VideoFileInfo;
                    } else if (this.f55772a.f55764f != null) {
                        this.f55772a.f55764f.m((ImageFileInfo) mediaFileInfo);
                    }
                } else if (this.f55772a.I.a(i2, mediaFileInfo)) {
                    this.f55772a.f55764f.i();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55773a;

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
            this.f55773a = imageListFragment;
        }

        @Override // b.a.r0.d4.t.a.f
        public void onItemClick(int i2, b.a.q0.f.a aVar) {
            List<MediaFileInfo> d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || this.f55773a.f55765g == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(this.f55773a.f55765g.h()) || (d2 = this.f55773a.f55765g.d(b2)) == null) {
                return;
            }
            this.f55773a.f55765g.x(b2);
            this.f55773a.q.m(d2);
            this.f55773a.n.setText(g2);
            this.f55773a.p.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes9.dex */
    public class h implements b.a.r0.d4.k.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55774a;

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
            this.f55774a = imageListFragment;
        }

        @Override // b.a.r0.d4.k.h
        public boolean a(int i2, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.f55774a.f55763e == null || this.f55774a.f55765g == null || this.f55774a.f55764f == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (b.a.r0.d4.r.a.a(imageFileInfo)) {
                        this.f55774a.f55763e.showToast(R.string.album_choose_image_low_quality_tip);
                        return false;
                    } else if (!b.a.r0.d4.r.a.b(imageFileInfo)) {
                        if (this.f55774a.f55765g.n(imageFileInfo)) {
                            this.f55774a.f55764f.j(imageFileInfo);
                        } else {
                            this.f55774a.f55764f.c(imageFileInfo);
                        }
                        this.f55774a.f55765g.w(null);
                        this.f55774a.q.notifyDataSetChanged();
                        this.f55774a.u();
                        return true;
                    } else {
                        this.f55774a.f55763e.showToast(String.format(this.f55774a.getString(R.string.album_choose_image_max_wh_tip), Integer.valueOf(b.a.q0.s.e0.b.j().k("key_upload_pic_max_width", 0)), Integer.valueOf(b.a.q0.s.e0.b.j().k("key_upload_pic_max_height", 0))));
                        return false;
                    }
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    if (this.f55774a.f55765g.o()) {
                        this.f55774a.f55763e.showToast(R.string.album_choose_switch_tip);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (this.f55774a.s(videoFileInfo) && this.f55774a.r(videoFileInfo)) {
                        this.f55774a.f55765g.w(videoFileInfo);
                        this.f55774a.f55765g.b();
                        this.f55774a.q.notifyDataSetChanged();
                        this.f55774a.f55764f.i();
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i implements b.a.q0.f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f55775a;

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
            this.f55775a = imageListFragment;
        }

        @Override // b.a.q0.f.e
        public void a(b.a.q0.f.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (this.f55775a.A != null) {
                    this.f55775a.A.h(false);
                }
                if (gVar == null) {
                    gVar = new b.a.q0.f.g();
                }
                if (this.f55775a.f55765g != null && this.f55775a.q != null) {
                    this.f55775a.f55765g.z(gVar);
                    String h2 = this.f55775a.f55765g.h();
                    this.f55775a.f55765g.x(h2);
                    this.f55775a.q.m(this.f55775a.f55765g.d(h2));
                    if (this.f55775a.p != null) {
                        this.f55775a.p.smoothScrollToPosition(0);
                    }
                    this.f55775a.u();
                }
                if (this.f55775a.p != null) {
                    this.f55775a.p.smoothScroll();
                }
            }
        }

        @Override // b.a.q0.f.e
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
            b.a.r0.d4.k.e eVar = this.f55764f;
            return (eVar == null || eVar.p() != 1) ? this.l : this.k;
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
            b.a.r0.d4.k.i iVar = this.q;
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
            if (this.f55766h == null) {
                this.f55766h = new b.a.q0.f.f(getPageContext().getPageActivity());
            }
            b.a.r0.d4.k.e eVar = this.f55764f;
            if (eVar == null) {
                return;
            }
            if (eVar.g()) {
                i2 = this.f55764f.f() ? 1 : 0;
            } else {
                i2 = this.f55764f.e() ? 2 : 3;
            }
            this.f55766h.h(i2, new i(this));
        }
    }

    public void notifyDataSetChanged() {
        b.a.r0.d4.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f55765g) == null || cVar.r()) {
            return;
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.q0.w0.a.a(getPageContext(), this.f55767i);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, i2);
            if (this.l != null && this.k != null) {
                b.a.r0.d4.k.e eVar = this.f55764f;
                if (eVar != null && eVar.p() == 1) {
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
            b.a.r0.d4.k.i iVar = this.q;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            b.a.r0.d4.k.c cVar = this.f55765g;
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
            this.f55763e = baseFragmentActivity;
            if (this.f55764f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f55764f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f55764f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            b.a.r0.d4.k.e eVar = this.f55764f;
            if (eVar != null) {
                this.f55765g = eVar.q();
                this.y = this.f55764f.v();
                this.z = this.f55764f.u();
            }
            b.a.r0.d4.k.d.f().d(this);
            this.f55766h = new b.a.q0.f.f(this.f55763e);
            b.a.r0.d4.t.a aVar = new b.a.r0.d4.t.a(this.f55763e);
            this.o = aVar;
            aVar.setOnDismissListener(this.F);
            this.o.l(this.H);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f55763e = baseFragmentActivity;
            if (this.f55764f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f55764f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f55764f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            b.a.r0.d4.k.e eVar = this.f55764f;
            if (eVar != null) {
                this.f55765g = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
            this.f55767i = inflate;
            this.j = (RelativeLayout) inflate.findViewById(R.id.album_image_list_root);
            this.s = this.f55767i.findViewById(R.id.layout_title);
            this.n = (TextView) this.f55767i.findViewById(R.id.album_title);
            this.k = (ImageView) this.f55767i.findViewById(R.id.img_close);
            this.l = (TextView) this.f55767i.findViewById(R.id.img_close_text);
            this.w = this.f55767i.findViewById(R.id.navi_line);
            this.u = this.f55767i.findViewById(R.id.layout_bottom);
            this.v = (TextView) this.f55767i.findViewById(R.id.original_select_btn);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f55767i.findViewById(R.id.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.m.getStyleConfig().l(l.g(this.f55763e, R.dimen.tbds25));
            this.f55765g.x(b.a.q0.f.a.f12212f);
            this.n.setText(this.f55763e.getPageContext().getString(R.string.album_all_media));
            if (this.f55765g.m() != null) {
                this.v.setVisibility(this.f55765g.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (this.f55765g.m() != null && this.f55765g.m().isFromQRCode()) {
                this.u.setVisibility(8);
            }
            this.r = NoDataViewFactory.a(this.f55763e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.f55767i.findViewById(R.id.gv_image_list);
            this.p = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            b.a.r0.d4.k.i iVar = new b.a.r0.d4.k.i(this.f55763e, this.f55765g);
            this.q = iVar;
            if (this.y) {
                if (this.f55765g.m() != null && this.f55765g.m().isFromQRCode()) {
                    this.q.v(false);
                } else {
                    this.q.v(true);
                }
            } else {
                iVar.v(false);
            }
            if (this.z && this.f55765g.l() == 1) {
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
            this.m.setOnClickListener(this.f55763e);
            this.k.setOnClickListener(this.f55763e);
            this.l.setOnClickListener(this.f55763e);
            this.v.setOnClickListener(this.f55763e);
            this.n.setOnClickListener(this.C);
            this.u.setOnClickListener(this.C);
            u();
            showLoadingView();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.t != null) {
                if (this.n.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.n.getParent()).removeView(this.n);
                }
                this.s.setVisibility(8);
                this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.n, (View.OnClickListener) null);
            }
            return this.f55767i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            b.a.q0.f.f fVar = this.f55766h;
            if (fVar != null) {
                fVar.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.f55763e;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            b.a.q0.s.g0.a aVar = this.A;
            if (aVar != null) {
                aVar.h(false);
            }
            b.a.r0.d4.k.d.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetach();
            b.a.r0.d4.t.a aVar = this.o;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    @Override // b.a.r0.d4.k.d.InterfaceC0811d
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

    public final boolean r(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, videoFileInfo)) == null) {
            VideoFileInfo e2 = j.e(videoFileInfo.videoPath);
            if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 3000) {
                this.f55763e.showToast(R.string.album_choose_video_resolution_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void refreshItem(int i2, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.p;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.p.getLastVisiblePosition();
                if (i2 < firstVisiblePosition || i2 > lastVisiblePosition || (childAt = this.p.getChildAt(i2 - firstVisiblePosition)) == null || this.q == null) {
                    return;
                }
                this.q.t((ImageView) childAt.findViewById(R.id.select_icon), z);
            }
            u();
        }
    }

    public final void refreshPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || isHidden() || this.x) {
            return;
        }
        t();
    }

    public final boolean s(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, videoFileInfo)) == null) {
            int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
            if (i2 < 3000 || i2 > 600000) {
                this.f55763e.showToast(R.string.album_choose_video_time_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void selectOriginalImg(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (baseFragmentActivity = this.f55763e) == null || this.v == null) {
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

    public void setAlbumView(b.a.r0.d4.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, eVar) == null) {
            this.f55764f = eVar;
        }
    }

    public void setNavBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, navigationBar) == null) {
            this.t = navigationBar;
        }
    }

    public void setVideoCompressController(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jVar) == null) {
            this.J = jVar;
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.A == null) {
                this.A = new b.a.q0.s.g0.a(getPageContext());
            }
            this.A.e(null);
            this.A.i(R.string.loading);
            this.A.h(true);
        }
    }

    public final void t() {
        b.a.r0.d4.k.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.f55765g == null && (eVar = this.f55764f) != null) {
                this.f55765g = eVar.q();
            }
            b.a.r0.d4.k.c cVar = this.f55765g;
            if (cVar == null) {
                return;
            }
            if (!cVar.r()) {
                this.q.notifyDataSetChanged();
            } else {
                loadAlbumMediaList();
            }
            selectOriginalImg(this.f55765g.s());
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [boolean, int] */
    public final void u() {
        b.a.r0.d4.k.c cVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (cVar = this.f55765g) == null || this.m == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f55765g.p();
            string = this.f55763e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f55765g.g());
            string = this.f55763e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f55765g.l())});
            i2 = count;
        }
        this.m.setText(string);
        this.m.setEnabled(i2 > 0);
    }

    public void refreshItem(ImageFileInfo imageFileInfo, boolean z) {
        b.a.r0.d4.k.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048597, this, imageFileInfo, z) == null) || imageFileInfo == null || (iVar = this.q) == null) {
            return;
        }
        refreshItem(iVar.i(imageFileInfo), z);
    }
}
