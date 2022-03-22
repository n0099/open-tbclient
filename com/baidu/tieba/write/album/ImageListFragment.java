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
import c.a.o0.c1.p0;
import c.a.p0.s4.k.d;
import c.a.p0.s4.k.j;
import c.a.p0.s4.t.b;
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
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC1389d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbCameraView.e A;
    public PopupWindow.OnDismissListener B;
    public c.a.p0.s4.k.g C;
    public b.f D;
    public c.a.p0.s4.k.h E;
    public j F;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.s4.k.e f37280b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s4.k.c f37281c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.e.f f37282d;

    /* renamed from: e  reason: collision with root package name */
    public View f37283e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f37284f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f37285g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37286h;
    public TBSpecificationBtn i;
    public TextView j;
    public c.a.p0.s4.t.b k;
    public TransparentHeadGridView l;
    public c.a.p0.s4.k.i m;
    public NoDataView n;
    public View o;
    public NavigationBar p;
    public View q;
    public TextView r;
    public View s;
    public boolean t;
    public boolean u;
    public boolean v;
    public c.a.o0.r.l0.a w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbCameraView.g z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public a(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || p0.b() || this.a.f37281c == null) {
                return;
            }
            int l = this.a.f37281c.l();
            if (this.a.f37281c.D() < l) {
                if (this.a.f37280b != null) {
                    this.a.f37280b.S(this.a.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.a;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a92), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public b(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f37281c == null) {
                return;
            }
            if (this.a.F == null || !this.a.F.i()) {
                if (view == this.a.j) {
                    this.a.k.k(this.a.f37281c.e(), this.a.f37281c.h());
                    this.a.k.n(this.a.p == null ? this.a.o : this.a.p);
                    this.a.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f0808ff, R.color.CAM_X0105, null), (Drawable) null);
                    return;
                }
                View unused = this.a.q;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TbCameraView.g {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.g
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !PermissionUtil.requestWriteExternalStorgeAndCameraPermission(this.a.getPageContext().getPageActivity(), 1) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TbCameraView.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        public e(ImageListFragment imageListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j != null && this.a.isAdded()) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
                }
                this.a.j.setCompoundDrawables(null, null, pureDrawable, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements c.a.p0.s4.k.g {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.p0.s4.k.g
        public void a(int i, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, mediaFileInfo) == null) {
                if (!this.a.v || this.a.f37281c == null || this.a.f37281c.l() != 1 || this.a.E == null) {
                    if (this.a.f37281c == null || this.a.f37281c.m() == null || !this.a.f37281c.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                        if (mediaFileInfo == null || this.a.f37281c == null) {
                            return;
                        }
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            this.a.f37281c.y((ImageFileInfo) mediaFileInfo);
                            if (this.a.f37280b != null) {
                                this.a.f37280b.O(1);
                                return;
                            }
                            return;
                        }
                        boolean z = mediaFileInfo instanceof VideoFileInfo;
                    } else if (this.a.f37280b != null) {
                        this.a.f37280b.m((ImageFileInfo) mediaFileInfo);
                    }
                } else if (this.a.E.a(i, mediaFileInfo)) {
                    this.a.f37280b.i();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.p0.s4.t.b.f
        public void onItemClick(int i, c.a.o0.e.a aVar) {
            List<MediaFileInfo> d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, aVar) == null) || this.a.f37281c == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(this.a.f37281c.h()) || (d2 = this.a.f37281c.d(b2)) == null) {
                return;
            }
            this.a.f37281c.x(b2);
            this.a.m.m(d2);
            this.a.j.setText(g2);
            this.a.l.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements c.a.p0.s4.k.h {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.p0.s4.k.h
        public boolean a(int i, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.a.a == null || this.a.f37281c == null || this.a.f37280b == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (c.a.p0.s4.r.a.a(imageFileInfo.getFilePath()) == PhotoType.APNG) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                        return false;
                    } else if (c.a.p0.s4.r.b.a(imageFileInfo)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f024b);
                        return false;
                    } else if (!c.a.p0.s4.r.b.b(imageFileInfo)) {
                        if (this.a.f37281c.n(imageFileInfo)) {
                            this.a.f37280b.j(imageFileInfo);
                        } else {
                            this.a.f37280b.c(imageFileInfo);
                        }
                        this.a.f37281c.w(null);
                        this.a.m.notifyDataSetChanged();
                        this.a.j1();
                        return true;
                    } else {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f024c), Integer.valueOf(c.a.o0.r.j0.b.k().l("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.o0.r.j0.b.k().l("key_upload_pic_max_height", 0))));
                        return false;
                    }
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    if (this.a.f37281c.o()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f024d);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (this.a.U0(videoFileInfo) && this.a.T0(videoFileInfo)) {
                        this.a.f37281c.w(videoFileInfo);
                        this.a.f37281c.b();
                        this.a.m.notifyDataSetChanged();
                        this.a.f37280b.i();
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements c.a.o0.e.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageListFragment;
        }

        @Override // c.a.o0.e.e
        public void a(c.a.o0.e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (this.a.w != null) {
                    this.a.w.h(false);
                }
                if (gVar == null) {
                    gVar = new c.a.o0.e.g();
                }
                if (this.a.f37281c != null && this.a.m != null) {
                    this.a.f37281c.z(gVar);
                    String h2 = this.a.f37281c.h();
                    this.a.f37281c.x(h2);
                    this.a.m.m(this.a.f37281c.d(h2));
                    if (this.a.l != null) {
                        this.a.l.smoothScrollToPosition(0);
                    }
                    this.a.j1();
                }
                if (this.a.l != null) {
                    this.a.l.n();
                }
            }
        }

        @Override // c.a.o0.e.e
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
        this.u = true;
        this.v = false;
        this.w = null;
        this.x = new a(this);
        this.y = new b(this);
        this.z = new c(this);
        this.A = new d(this);
        this.B = new e(this);
        this.C = new f(this);
        this.D = new g(this);
        this.E = new h(this);
    }

    public final boolean T0(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoFileInfo)) == null) {
            VideoFileInfo e2 = j.e(videoFileInfo.videoPath);
            if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 3000) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f024e);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean U0(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFileInfo)) == null) {
            int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
            if (i2 < 3000 || i2 > 600000) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f024f);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public View V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.s4.k.e eVar = this.f37280b;
            return (eVar == null || eVar.p() != 1) ? this.f37286h : this.f37285g;
        }
        return (View) invokeV.objValue;
    }

    public View W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public TbCameraView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.s4.k.i iVar = this.m;
            if (iVar != null) {
                return iVar.j();
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public TransparentHeadGridView Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (TransparentHeadGridView) invokeV.objValue;
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    public void a1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f37282d == null) {
                this.f37282d = new c.a.o0.e.f(getPageContext().getPageActivity());
            }
            c.a.p0.s4.k.e eVar = this.f37280b;
            if (eVar == null) {
                return;
            }
            if (eVar.g()) {
                i2 = this.f37280b.f() ? 1 : 0;
            } else {
                i2 = this.f37280b.e() ? 2 : 3;
            }
            this.f37282d.h(i2, new i(this));
        }
    }

    public final void b1() {
        c.a.p0.s4.k.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f37281c == null && (eVar = this.f37280b) != null) {
                this.f37281c = eVar.q();
            }
            c.a.p0.s4.k.c cVar = this.f37281c;
            if (cVar == null) {
                return;
            }
            if (!cVar.r()) {
                this.m.notifyDataSetChanged();
            } else {
                a1();
            }
            e1(this.f37281c.s());
        }
    }

    public void c1(int i2, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.l;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.l.getLastVisiblePosition();
                if (i2 < firstVisiblePosition || i2 > lastVisiblePosition || (childAt = this.l.getChildAt(i2 - firstVisiblePosition)) == null || this.m == null) {
                    return;
                }
                this.m.t((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f091c77), z);
            }
            j1();
        }
    }

    public void d1(ImageFileInfo imageFileInfo, boolean z) {
        c.a.p0.s4.k.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, imageFileInfo, z) == null) || imageFileInfo == null || (iVar = this.m) == null) {
            return;
        }
        c1(iVar.i(imageFileInfo), z);
    }

    public void e1(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (baseFragmentActivity = this.a) == null || this.r == null) {
            return;
        }
        this.r.setText(baseFragmentActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ce3));
        if (z) {
            this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080910, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            return;
        }
        this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080911, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0106);
    }

    public void f1(c.a.p0.s4.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.f37280b = eVar;
        }
    }

    public void g1(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, navigationBar) == null) {
            this.p = navigationBar;
        }
    }

    public void h1(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            this.F = jVar;
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.w == null) {
                this.w = new c.a.o0.r.l0.a(getPageContext());
            }
            this.w.e(null);
            this.w.i(R.string.obfuscated_res_0x7f0f0a2e);
            this.w.h(true);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [boolean, int] */
    public final void j1() {
        c.a.p0.s4.k.c cVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (cVar = this.f37281c) == null || this.i == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f37281c.p();
            string = this.a.getString(R.string.obfuscated_res_0x7f0f08af, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f37281c.g());
            string = this.a.getString(R.string.obfuscated_res_0x7f0f08af, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f37281c.l())});
            i2 = count;
        }
        this.i.setText(string);
        this.i.setEnabled(i2 > 0);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || isHidden() || this.t) {
            return;
        }
        b1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.u) {
                return;
            }
            PermissionUtil.requestWriteExternalStorgePermission(requireActivity(), 1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.o0.w0.a.a(getPageContext(), this.f37283e);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, i2);
            if (this.f37286h != null && this.f37285g != null) {
                c.a.p0.s4.k.e eVar = this.f37280b;
                if (eVar != null && eVar.p() == 1) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f37285g, R.drawable.obfuscated_res_0x7f0809b1, R.color.CAM_X0105, null);
                    this.f37286h.setVisibility(8);
                } else {
                    SkinManager.setViewTextColor(this.f37286h, (int) R.color.navi_back_text_color);
                    this.f37285g.setVisibility(8);
                }
            }
            if (this.j != null) {
                this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null), (Drawable) null);
            }
            c.a.p0.s4.k.i iVar = this.m;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            c.a.p0.s4.k.c cVar = this.f37281c;
            if (cVar != null) {
                e1(cVar.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.f37280b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f37280b = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f37280b = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.p0.s4.k.e eVar = this.f37280b;
            if (eVar != null) {
                this.f37281c = eVar.q();
                this.u = this.f37280b.w();
                this.v = this.f37280b.u();
            }
            c.a.p0.s4.k.d.f().d(this);
            this.f37282d = new c.a.o0.e.f(this.a);
            c.a.p0.s4.t.b bVar = new c.a.p0.s4.t.b(this.a);
            this.k = bVar;
            bVar.setOnDismissListener(this.B);
            this.k.l(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.f37280b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f37280b = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f37280b = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.p0.s4.k.e eVar = this.f37280b;
            if (eVar != null) {
                this.f37281c = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0119, (ViewGroup) null);
            this.f37283e = inflate;
            this.f37284f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090232);
            this.o = this.f37283e.findViewById(R.id.obfuscated_res_0x7f0911fc);
            this.j = (TextView) this.f37283e.findViewById(R.id.obfuscated_res_0x7f090258);
            this.f37285g = (ImageView) this.f37283e.findViewById(R.id.obfuscated_res_0x7f090eab);
            this.f37286h = (TextView) this.f37283e.findViewById(R.id.obfuscated_res_0x7f090ead);
            this.s = this.f37283e.findViewById(R.id.obfuscated_res_0x7f091500);
            this.q = this.f37283e.findViewById(R.id.obfuscated_res_0x7f0911c6);
            this.r = (TextView) this.f37283e.findViewById(R.id.obfuscated_res_0x7f09161f);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f37283e.findViewById(R.id.obfuscated_res_0x7f091573);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().l(n.f(this.a, R.dimen.tbds25));
            this.f37281c.x(c.a.o0.e.a.f10003f);
            this.j.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0248));
            if (this.f37281c.m() != null) {
                this.r.setVisibility(this.f37281c.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (this.f37281c.m() != null && this.f37281c.m().isFromQRCode()) {
                this.q.setVisibility(8);
            }
            this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f37284f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0250, R.string.obfuscated_res_0x7f0f0251), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.f37283e.findViewById(R.id.obfuscated_res_0x7f090d0c);
            this.l = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            c.a.p0.s4.k.i iVar = new c.a.p0.s4.k.i(this.a, this.f37281c);
            this.m = iVar;
            if (this.u) {
                if (this.f37281c.m() != null && this.f37281c.m().isFromQRCode()) {
                    this.m.v(false);
                    this.u = false;
                } else {
                    this.m.v(true);
                }
            } else {
                iVar.v(false);
            }
            if (this.v && this.f37281c.l() == 1) {
                this.m.w(false);
            } else {
                this.m.w(true);
            }
            this.l.setAdapter((ListAdapter) this.m);
            this.l.setOuterOnScrollListener(this);
            this.m.u(this.E);
            this.m.n(this.C);
            this.m.q(this.x);
            this.m.o(this.A);
            this.m.p(this.z);
            this.i.setOnClickListener(this.a);
            this.f37285g.setOnClickListener(this.a);
            this.f37286h.setOnClickListener(this.a);
            this.r.setOnClickListener(this.a);
            this.j.setOnClickListener(this.y);
            this.q.setOnClickListener(this.y);
            j1();
            i1();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.p != null) {
                if (this.j.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.j.getParent()).removeView(this.j);
                }
                this.o.setVisibility(8);
                this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.j, (View.OnClickListener) null);
            }
            return this.f37283e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            c.a.o0.e.f fVar = this.f37282d;
            if (fVar != null) {
                fVar.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.a;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            c.a.o0.r.l0.a aVar = this.w;
            if (aVar != null) {
                aVar.h(false);
            }
            c.a.p0.s4.k.d.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDetach();
            c.a.p0.s4.t.b bVar = this.k;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            this.t = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            this.t = false;
            if (isShow()) {
                n();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048602, this, absListView, i2, i3, i4) == null) {
            super.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, absListView, i2) == null) {
            super.onScrollStateChanged(absListView, i2);
            if (i2 == 2) {
                this.m.r(true);
            } else if (this.m.k()) {
                this.m.r(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStop();
        }
    }

    @Override // c.a.p0.s4.k.d.InterfaceC1389d
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            n();
        }
    }
}
