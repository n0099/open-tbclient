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
import d.a.c.e.p.l;
import d.a.o0.z0.k0;
import d.a.p0.a4.k.d;
import d.a.p0.a4.k.j;
import d.a.p0.a4.t.a;
import java.util.List;
/* loaded from: classes4.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC1268d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.o0.r.f0.a A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public TbCameraView.g D;
    public TbCameraView.e E;
    public PopupWindow.OnDismissListener F;
    public d.a.p0.a4.k.g G;
    public a.f H;
    public d.a.p0.a4.k.h I;
    public j J;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f22550e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.a4.k.e f22551f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.a4.k.c f22552g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.e.f f22553h;

    /* renamed from: i  reason: collision with root package name */
    public View f22554i;
    public RelativeLayout j;
    public ImageView k;
    public TextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public d.a.p0.a4.t.a o;
    public TransparentHeadGridView p;
    public d.a.p0.a4.k.i q;
    public NoDataView r;
    public View s;
    public NavigationBar t;
    public View u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22555e;

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
            this.f22555e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k0.b() || this.f22555e.f22552g == null) {
                return;
            }
            int l = this.f22555e.f22552g.l();
            if (this.f22555e.f22552g.D() < l) {
                if (this.f22555e.f22551f != null) {
                    this.f22555e.f22551f.W(this.f22555e.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.f22555e;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22556e;

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
            this.f22556e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22556e.f22552g == null) {
                return;
            }
            if (this.f22556e.J == null || !this.f22556e.J.i()) {
                if (view == this.f22556e.n) {
                    this.f22556e.o.k(this.f22556e.f22552g.e(), this.f22556e.f22552g.h());
                    this.f22556e.o.n(this.f22556e.t == null ? this.f22556e.s : this.f22556e.t);
                    this.f22556e.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null), (Drawable) null);
                    return;
                }
                View unused = this.f22556e.u;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbCameraView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22557a;

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
            this.f22557a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.g
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !PermissionUtil.requestWriteExternalStorgeAndCameraPermission(this.f22557a.getPageContext().getPageActivity(), 1) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TbCameraView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22558a;

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
            this.f22558a = imageListFragment;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22559e;

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
            this.f22559e = imageListFragment;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22559e.n != null && this.f22559e.isAdded()) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
                }
                this.f22559e.n.setCompoundDrawables(null, null, pureDrawable, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.p0.a4.k.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22560a;

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
            this.f22560a = imageListFragment;
        }

        @Override // d.a.p0.a4.k.g
        public void a(int i2, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, mediaFileInfo) == null) {
                if (!this.f22560a.z || this.f22560a.f22552g == null || this.f22560a.f22552g.l() != 1 || this.f22560a.I == null) {
                    if (this.f22560a.f22552g == null || this.f22560a.f22552g.m() == null || !this.f22560a.f22552g.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                        if (mediaFileInfo == null || this.f22560a.f22552g == null) {
                            return;
                        }
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            this.f22560a.f22552g.y((ImageFileInfo) mediaFileInfo);
                            if (this.f22560a.f22551f != null) {
                                this.f22560a.f22551f.R(1);
                                return;
                            }
                            return;
                        }
                        boolean z = mediaFileInfo instanceof VideoFileInfo;
                    } else if (this.f22560a.f22551f != null) {
                        this.f22560a.f22551f.m((ImageFileInfo) mediaFileInfo);
                    }
                } else if (this.f22560a.I.a(i2, mediaFileInfo)) {
                    this.f22560a.f22551f.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22561a;

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
            this.f22561a = imageListFragment;
        }

        @Override // d.a.p0.a4.t.a.f
        public void onItemClick(int i2, d.a.o0.e.a aVar) {
            List<MediaFileInfo> d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || this.f22561a.f22552g == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(this.f22561a.f22552g.h()) || (d2 = this.f22561a.f22552g.d(b2)) == null) {
                return;
            }
            this.f22561a.f22552g.x(b2);
            this.f22561a.q.m(d2);
            this.f22561a.n.setText(g2);
            this.f22561a.p.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.a.p0.a4.k.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22562a;

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
            this.f22562a = imageListFragment;
        }

        @Override // d.a.p0.a4.k.h
        public boolean a(int i2, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.f22562a.f22550e == null || this.f22562a.f22552g == null || this.f22562a.f22551f == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (d.a.p0.a4.r.a.a(imageFileInfo)) {
                        this.f22562a.f22550e.showToast(R.string.album_choose_image_low_quality_tip);
                        return false;
                    }
                    if (this.f22562a.f22552g.n(imageFileInfo)) {
                        this.f22562a.f22551f.j(imageFileInfo);
                    } else {
                        this.f22562a.f22551f.c(imageFileInfo);
                    }
                    this.f22562a.f22552g.w(null);
                    this.f22562a.q.notifyDataSetChanged();
                    this.f22562a.o1();
                    return true;
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    if (this.f22562a.f22552g.o()) {
                        this.f22562a.f22550e.showToast(R.string.album_choose_switch_tip);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (this.f22562a.Z0(videoFileInfo) && this.f22562a.Y0(videoFileInfo)) {
                        this.f22562a.f22552g.w(videoFileInfo);
                        this.f22562a.f22552g.b();
                        this.f22562a.q.notifyDataSetChanged();
                        this.f22562a.f22551f.i();
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements d.a.o0.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f22563a;

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
            this.f22563a = imageListFragment;
        }

        @Override // d.a.o0.e.e
        public void a(d.a.o0.e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (this.f22563a.A != null) {
                    this.f22563a.A.h(false);
                }
                if (gVar == null) {
                    gVar = new d.a.o0.e.g();
                }
                if (this.f22563a.f22552g != null && this.f22563a.q != null) {
                    this.f22563a.f22552g.z(gVar);
                    String h2 = this.f22563a.f22552g.h();
                    this.f22563a.f22552g.x(h2);
                    this.f22563a.q.m(this.f22563a.f22552g.d(h2));
                    if (this.f22563a.p != null) {
                        this.f22563a.p.smoothScrollToPosition(0);
                    }
                    this.f22563a.o1();
                }
                if (this.f22563a.p != null) {
                    this.f22563a.p.n();
                }
            }
        }

        @Override // d.a.o0.e.e
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

    public final boolean Y0(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoFileInfo)) == null) {
            VideoFileInfo e2 = j.e(videoFileInfo.videoPath);
            if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 4096) {
                this.f22550e.showToast(R.string.album_choose_video_resolution_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean Z0(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFileInfo)) == null) {
            int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
            if (i2 < 3000 || i2 > 600000) {
                this.f22550e.showToast(R.string.album_choose_video_time_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.p0.a4.k.e eVar = this.f22551f;
            return (eVar == null || eVar.p() != 1) ? this.l : this.k;
        }
        return (View) invokeV.objValue;
    }

    public View b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public TbCameraView c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.p0.a4.k.i iVar = this.q;
            if (iVar != null) {
                return iVar.j();
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public TransparentHeadGridView d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (TransparentHeadGridView) invokeV.objValue;
    }

    public View e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.v : (View) invokeV.objValue;
    }

    public void f1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f22553h == null) {
                this.f22553h = new d.a.o0.e.f(getPageContext().getPageActivity());
            }
            d.a.p0.a4.k.e eVar = this.f22551f;
            if (eVar == null) {
                return;
            }
            if (eVar.g()) {
                i2 = this.f22551f.f() ? 1 : 0;
            } else {
                i2 = this.f22551f.e() ? 2 : 3;
            }
            this.f22553h.h(i2, new i(this));
        }
    }

    public final void g1() {
        d.a.p0.a4.k.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f22552g == null && (eVar = this.f22551f) != null) {
                this.f22552g = eVar.q();
            }
            d.a.p0.a4.k.c cVar = this.f22552g;
            if (cVar == null) {
                return;
            }
            if (!cVar.r()) {
                this.q.notifyDataSetChanged();
            } else {
                f1();
            }
            j1(this.f22552g.s());
        }
    }

    public void h1(int i2, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.p;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.p.getLastVisiblePosition();
                if (i2 < firstVisiblePosition || i2 > lastVisiblePosition || (childAt = this.p.getChildAt(i2 - firstVisiblePosition)) == null || this.q == null) {
                    return;
                }
                this.q.t((ImageView) childAt.findViewById(R.id.select_icon), z);
            }
            o1();
        }
    }

    public void i1(ImageFileInfo imageFileInfo, boolean z) {
        d.a.p0.a4.k.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, imageFileInfo, z) == null) || imageFileInfo == null || (iVar = this.q) == null) {
            return;
        }
        h1(iVar.i(imageFileInfo), z);
    }

    public void j1(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (baseFragmentActivity = this.f22550e) == null || this.v == null) {
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

    public void k1(d.a.p0.a4.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.f22551f = eVar;
        }
    }

    public void l1(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, navigationBar) == null) {
            this.t = navigationBar;
        }
    }

    public void m1(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            this.J = jVar;
        }
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.A == null) {
                this.A = new d.a.o0.r.f0.a(getPageContext());
            }
            this.A.e(null);
            this.A.i(R.string.loading);
            this.A.h(true);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || isHidden() || this.x) {
            return;
        }
        g1();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [boolean, int] */
    public final void o1() {
        d.a.p0.a4.k.c cVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (cVar = this.f22552g) == null || this.m == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f22552g.p();
            string = this.f22550e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f22552g.g());
            string = this.f22550e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f22552g.l())});
            i2 = count;
        }
        this.m.setText(string);
        this.m.setEnabled(i2 > 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.o0.s0.a.a(getPageContext(), this.f22554i);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, i2);
            if (this.l != null && this.k != null) {
                d.a.p0.a4.k.e eVar = this.f22551f;
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
            d.a.p0.a4.k.i iVar = this.q;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            d.a.p0.a4.k.c cVar = this.f22552g;
            if (cVar != null) {
                j1(cVar.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f22550e = baseFragmentActivity;
            if (this.f22551f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f22551f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f22551f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            d.a.p0.a4.k.e eVar = this.f22551f;
            if (eVar != null) {
                this.f22552g = eVar.q();
                this.y = this.f22551f.v();
                this.z = this.f22551f.u();
            }
            d.a.p0.a4.k.d.f().d(this);
            this.f22553h = new d.a.o0.e.f(this.f22550e);
            d.a.p0.a4.t.a aVar = new d.a.p0.a4.t.a(this.f22550e);
            this.o = aVar;
            aVar.setOnDismissListener(this.F);
            this.o.l(this.H);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f22550e = baseFragmentActivity;
            if (this.f22551f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f22551f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f22551f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            d.a.p0.a4.k.e eVar = this.f22551f;
            if (eVar != null) {
                this.f22552g = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
            this.f22554i = inflate;
            this.j = (RelativeLayout) inflate.findViewById(R.id.album_image_list_root);
            this.s = this.f22554i.findViewById(R.id.layout_title);
            this.n = (TextView) this.f22554i.findViewById(R.id.album_title);
            this.k = (ImageView) this.f22554i.findViewById(R.id.img_close);
            this.l = (TextView) this.f22554i.findViewById(R.id.img_close_text);
            this.w = this.f22554i.findViewById(R.id.navi_line);
            this.u = this.f22554i.findViewById(R.id.layout_bottom);
            this.v = (TextView) this.f22554i.findViewById(R.id.original_select_btn);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f22554i.findViewById(R.id.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.m.getStyleConfig().k(l.g(this.f22550e, R.dimen.tbds25));
            this.f22552g.x(d.a.o0.e.a.f51921f);
            this.n.setText(this.f22550e.getPageContext().getString(R.string.album_all_media));
            if (this.f22552g.m() != null) {
                this.v.setVisibility(this.f22552g.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (this.f22552g.m() != null && this.f22552g.m().isFromQRCode()) {
                this.u.setVisibility(8);
            }
            this.r = NoDataViewFactory.a(this.f22550e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.f22554i.findViewById(R.id.gv_image_list);
            this.p = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            d.a.p0.a4.k.i iVar = new d.a.p0.a4.k.i(this.f22550e, this.f22552g);
            this.q = iVar;
            if (this.y) {
                if (this.f22552g.m() != null && this.f22552g.m().isFromQRCode()) {
                    this.q.v(false);
                } else {
                    this.q.v(true);
                }
            } else {
                iVar.v(false);
            }
            if (this.z && this.f22552g.l() == 1) {
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
            this.m.setOnClickListener(this.f22550e);
            this.k.setOnClickListener(this.f22550e);
            this.l.setOnClickListener(this.f22550e);
            this.v.setOnClickListener(this.f22550e);
            this.n.setOnClickListener(this.C);
            this.u.setOnClickListener(this.C);
            o1();
            n1();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.t != null) {
                if (this.n.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.n.getParent()).removeView(this.n);
                }
                this.s.setVisibility(8);
                this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.n, (View.OnClickListener) null);
            }
            return this.f22554i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            d.a.o0.e.f fVar = this.f22553h;
            if (fVar != null) {
                fVar.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.f22550e;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            d.a.o0.r.f0.a aVar = this.A;
            if (aVar != null) {
                aVar.h(false);
            }
            d.a.p0.a4.k.d.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetach();
            d.a.p0.a4.t.a aVar = this.o;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            this.x = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            this.x = false;
            if (isShow()) {
                o();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048601, this, absListView, i2, i3, i4) == null) {
            super.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, absListView, i2) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStop();
        }
    }

    @Override // d.a.p0.a4.k.d.InterfaceC1268d
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            o();
        }
    }
}
