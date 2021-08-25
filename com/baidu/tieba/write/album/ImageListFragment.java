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
import c.a.e.e.p.l;
import c.a.p0.b1.m0;
import c.a.q0.b4.k.d;
import c.a.q0.b4.k.j;
import c.a.q0.b4.t.a;
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
/* loaded from: classes7.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC0773d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.s.f0.a A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public TbCameraView.i D;
    public TbCameraView.g E;
    public PopupWindow.OnDismissListener F;
    public c.a.q0.b4.k.g G;
    public a.f H;
    public c.a.q0.b4.k.h I;
    public j J;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f58543e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.b4.k.e f58544f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.b4.k.c f58545g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f.f f58546h;

    /* renamed from: i  reason: collision with root package name */
    public View f58547i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f58548j;
    public ImageView k;
    public TextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public c.a.q0.b4.t.a o;
    public TransparentHeadGridView p;
    public c.a.q0.b4.k.i q;
    public NoDataView r;
    public View s;
    public NavigationBar t;
    public View u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58549e;

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
            this.f58549e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || m0.b() || this.f58549e.f58545g == null) {
                return;
            }
            int l = this.f58549e.f58545g.l();
            if (this.f58549e.f58545g.D() < l) {
                if (this.f58549e.f58544f != null) {
                    this.f58549e.f58544f.Z(this.f58549e.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.f58549e;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58550e;

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
            this.f58550e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58550e.f58545g == null) {
                return;
            }
            if (this.f58550e.J == null || !this.f58550e.J.i()) {
                if (view == this.f58550e.n) {
                    this.f58550e.o.k(this.f58550e.f58545g.e(), this.f58550e.f58545g.h());
                    this.f58550e.o.n(this.f58550e.t == null ? this.f58550e.s : this.f58550e.t);
                    this.f58550e.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null), (Drawable) null);
                    return;
                }
                View unused = this.f58550e.u;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbCameraView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58551a;

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
            this.f58551a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.i
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !PermissionUtil.requestWriteExternalStorgeAndCameraPermission(this.f58551a.getPageContext().getPageActivity(), 1) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TbCameraView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58552a;

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
            this.f58552a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58553e;

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
            this.f58553e = imageListFragment;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58553e.n != null && this.f58553e.isAdded()) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
                }
                this.f58553e.n.setCompoundDrawables(null, null, pureDrawable, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.q0.b4.k.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58554a;

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
            this.f58554a = imageListFragment;
        }

        @Override // c.a.q0.b4.k.g
        public void a(int i2, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, mediaFileInfo) == null) {
                if (!this.f58554a.z || this.f58554a.f58545g == null || this.f58554a.f58545g.l() != 1 || this.f58554a.I == null) {
                    if (this.f58554a.f58545g == null || this.f58554a.f58545g.m() == null || !this.f58554a.f58545g.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                        if (mediaFileInfo == null || this.f58554a.f58545g == null) {
                            return;
                        }
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            this.f58554a.f58545g.y((ImageFileInfo) mediaFileInfo);
                            if (this.f58554a.f58544f != null) {
                                this.f58554a.f58544f.V(1);
                                return;
                            }
                            return;
                        }
                        boolean z = mediaFileInfo instanceof VideoFileInfo;
                    } else if (this.f58554a.f58544f != null) {
                        this.f58554a.f58544f.m((ImageFileInfo) mediaFileInfo);
                    }
                } else if (this.f58554a.I.a(i2, mediaFileInfo)) {
                    this.f58554a.f58544f.i();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58555a;

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
            this.f58555a = imageListFragment;
        }

        @Override // c.a.q0.b4.t.a.f
        public void onItemClick(int i2, c.a.p0.f.a aVar) {
            List<MediaFileInfo> d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || this.f58555a.f58545g == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(this.f58555a.f58545g.h()) || (d2 = this.f58555a.f58545g.d(b2)) == null) {
                return;
            }
            this.f58555a.f58545g.x(b2);
            this.f58555a.q.m(d2);
            this.f58555a.n.setText(g2);
            this.f58555a.p.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements c.a.q0.b4.k.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58556a;

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
            this.f58556a = imageListFragment;
        }

        @Override // c.a.q0.b4.k.h
        public boolean a(int i2, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.f58556a.f58543e == null || this.f58556a.f58545g == null || this.f58556a.f58544f == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (c.a.q0.b4.r.a.a(imageFileInfo)) {
                        this.f58556a.f58543e.showToast(R.string.album_choose_image_low_quality_tip);
                        return false;
                    } else if (!c.a.q0.b4.r.a.b(imageFileInfo)) {
                        if (this.f58556a.f58545g.n(imageFileInfo)) {
                            this.f58556a.f58544f.j(imageFileInfo);
                        } else {
                            this.f58556a.f58544f.c(imageFileInfo);
                        }
                        this.f58556a.f58545g.w(null);
                        this.f58556a.q.notifyDataSetChanged();
                        this.f58556a.u();
                        return true;
                    } else {
                        this.f58556a.f58543e.showToast(String.format(this.f58556a.getString(R.string.album_choose_image_max_wh_tip), Integer.valueOf(c.a.p0.s.d0.b.j().k("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.p0.s.d0.b.j().k("key_upload_pic_max_height", 0))));
                        return false;
                    }
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    if (this.f58556a.f58545g.o()) {
                        this.f58556a.f58543e.showToast(R.string.album_choose_switch_tip);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (this.f58556a.s(videoFileInfo) && this.f58556a.r(videoFileInfo)) {
                        this.f58556a.f58545g.w(videoFileInfo);
                        this.f58556a.f58545g.b();
                        this.f58556a.q.notifyDataSetChanged();
                        this.f58556a.f58544f.i();
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements c.a.p0.f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f58557a;

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
            this.f58557a = imageListFragment;
        }

        @Override // c.a.p0.f.e
        public void a(c.a.p0.f.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (this.f58557a.A != null) {
                    this.f58557a.A.h(false);
                }
                if (gVar == null) {
                    gVar = new c.a.p0.f.g();
                }
                if (this.f58557a.f58545g != null && this.f58557a.q != null) {
                    this.f58557a.f58545g.z(gVar);
                    String h2 = this.f58557a.f58545g.h();
                    this.f58557a.f58545g.x(h2);
                    this.f58557a.q.m(this.f58557a.f58545g.d(h2));
                    if (this.f58557a.p != null) {
                        this.f58557a.p.smoothScrollToPosition(0);
                    }
                    this.f58557a.u();
                }
                if (this.f58557a.p != null) {
                    this.f58557a.p.smoothScroll();
                }
            }
        }

        @Override // c.a.p0.f.e
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
            c.a.q0.b4.k.e eVar = this.f58544f;
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
            c.a.q0.b4.k.i iVar = this.q;
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
            if (this.f58546h == null) {
                this.f58546h = new c.a.p0.f.f(getPageContext().getPageActivity());
            }
            c.a.q0.b4.k.e eVar = this.f58544f;
            if (eVar == null) {
                return;
            }
            if (eVar.g()) {
                i2 = this.f58544f.f() ? 1 : 0;
            } else {
                i2 = this.f58544f.e() ? 2 : 3;
            }
            this.f58546h.h(i2, new i(this));
        }
    }

    public void notifyDataSetChanged() {
        c.a.q0.b4.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f58545g) == null || cVar.r()) {
            return;
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.p0.u0.a.a(getPageContext(), this.f58547i);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, i2);
            if (this.l != null && this.k != null) {
                c.a.q0.b4.k.e eVar = this.f58544f;
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
            c.a.q0.b4.k.i iVar = this.q;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            c.a.q0.b4.k.c cVar = this.f58545g;
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
            this.f58543e = baseFragmentActivity;
            if (this.f58544f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f58544f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f58544f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.q0.b4.k.e eVar = this.f58544f;
            if (eVar != null) {
                this.f58545g = eVar.q();
                this.y = this.f58544f.v();
                this.z = this.f58544f.u();
            }
            c.a.q0.b4.k.d.f().d(this);
            this.f58546h = new c.a.p0.f.f(this.f58543e);
            c.a.q0.b4.t.a aVar = new c.a.q0.b4.t.a(this.f58543e);
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
            this.f58543e = baseFragmentActivity;
            if (this.f58544f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f58544f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f58544f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.q0.b4.k.e eVar = this.f58544f;
            if (eVar != null) {
                this.f58545g = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
            this.f58547i = inflate;
            this.f58548j = (RelativeLayout) inflate.findViewById(R.id.album_image_list_root);
            this.s = this.f58547i.findViewById(R.id.layout_title);
            this.n = (TextView) this.f58547i.findViewById(R.id.album_title);
            this.k = (ImageView) this.f58547i.findViewById(R.id.img_close);
            this.l = (TextView) this.f58547i.findViewById(R.id.img_close_text);
            this.w = this.f58547i.findViewById(R.id.navi_line);
            this.u = this.f58547i.findViewById(R.id.layout_bottom);
            this.v = (TextView) this.f58547i.findViewById(R.id.original_select_btn);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f58547i.findViewById(R.id.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.m.getStyleConfig().k(l.g(this.f58543e, R.dimen.tbds25));
            this.f58545g.x(c.a.p0.f.a.f13401f);
            this.n.setText(this.f58543e.getPageContext().getString(R.string.album_all_media));
            if (this.f58545g.m() != null) {
                this.v.setVisibility(this.f58545g.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (this.f58545g.m() != null && this.f58545g.m().isFromQRCode()) {
                this.u.setVisibility(8);
            }
            this.r = NoDataViewFactory.a(this.f58543e.getPageContext().getPageActivity(), this.f58548j, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.f58547i.findViewById(R.id.gv_image_list);
            this.p = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            c.a.q0.b4.k.i iVar = new c.a.q0.b4.k.i(this.f58543e, this.f58545g);
            this.q = iVar;
            if (this.y) {
                if (this.f58545g.m() != null && this.f58545g.m().isFromQRCode()) {
                    this.q.v(false);
                } else {
                    this.q.v(true);
                }
            } else {
                iVar.v(false);
            }
            if (this.z && this.f58545g.l() == 1) {
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
            this.m.setOnClickListener(this.f58543e);
            this.k.setOnClickListener(this.f58543e);
            this.l.setOnClickListener(this.f58543e);
            this.v.setOnClickListener(this.f58543e);
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
            return this.f58547i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            c.a.p0.f.f fVar = this.f58546h;
            if (fVar != null) {
                fVar.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.f58543e;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            c.a.p0.s.f0.a aVar = this.A;
            if (aVar != null) {
                aVar.h(false);
            }
            c.a.q0.b4.k.d.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetach();
            c.a.q0.b4.t.a aVar = this.o;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    @Override // c.a.q0.b4.k.d.InterfaceC0773d
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
                this.f58543e.showToast(R.string.album_choose_video_resolution_tip);
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
                this.f58543e.showToast(R.string.album_choose_video_time_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void selectOriginalImg(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (baseFragmentActivity = this.f58543e) == null || this.v == null) {
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

    public void setAlbumView(c.a.q0.b4.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, eVar) == null) {
            this.f58544f = eVar;
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
                this.A = new c.a.p0.s.f0.a(getPageContext());
            }
            this.A.e(null);
            this.A.i(R.string.loading);
            this.A.h(true);
        }
    }

    public final void t() {
        c.a.q0.b4.k.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.f58545g == null && (eVar = this.f58544f) != null) {
                this.f58545g = eVar.q();
            }
            c.a.q0.b4.k.c cVar = this.f58545g;
            if (cVar == null) {
                return;
            }
            if (!cVar.r()) {
                this.q.notifyDataSetChanged();
            } else {
                loadAlbumMediaList();
            }
            selectOriginalImg(this.f58545g.s());
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [int, boolean] */
    public final void u() {
        c.a.q0.b4.k.c cVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (cVar = this.f58545g) == null || this.m == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f58545g.p();
            string = this.f58543e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f58545g.g());
            string = this.f58543e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f58545g.l())});
            i2 = count;
        }
        this.m.setText(string);
        this.m.setEnabled(i2 > 0);
    }

    public void refreshItem(ImageFileInfo imageFileInfo, boolean z) {
        c.a.q0.b4.k.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048597, this, imageFileInfo, z) == null) || imageFileInfo == null || (iVar = this.q) == null) {
            return;
        }
        refreshItem(iVar.i(imageFileInfo), z);
    }
}
