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
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
import com.baidu.tieba.e39;
import com.baidu.tieba.f39;
import com.baidu.tieba.fj;
import com.baidu.tieba.go4;
import com.baidu.tieba.j29;
import com.baidu.tieba.k29;
import com.baidu.tieba.ko4;
import com.baidu.tieba.l29;
import com.baidu.tieba.lo4;
import com.baidu.tieba.m39;
import com.baidu.tieba.me5;
import com.baidu.tieba.mo4;
import com.baidu.tieba.n29;
import com.baidu.tieba.o29;
import com.baidu.tieba.p29;
import com.baidu.tieba.pi5;
import com.baidu.tieba.q29;
import com.baidu.tieba.ux4;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.tieba.yx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ImageListFragment extends BaseFragment implements k29.d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbCameraView.e A;
    public PopupWindow.OnDismissListener B;
    public n29 C;
    public m39.f D;
    public o29 E;
    public q29 F;
    public BaseFragmentActivity a;
    public l29 b;
    public j29 c;
    public lo4 d;
    public View e;
    public RelativeLayout f;
    public ImageView g;
    public TextView h;
    public TBSpecificationBtn i;
    public TextView j;
    public m39 k;
    public TransparentHeadGridView l;
    public p29 m;
    public NoDataView n;
    public View o;
    public NavigationBar p;
    public View q;
    public TextView r;
    public View s;
    public boolean t;
    public boolean u;
    public boolean v;
    public yx4 w;
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || pi5.a() || this.a.c == null) {
                return;
            }
            int l = this.a.c.l();
            if (this.a.c.D() < l) {
                if (this.a.b != null) {
                    this.a.b.X(this.a.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.a;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0acc), Integer.valueOf(l)));
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c == null) {
                return;
            }
            if ((this.a.F == null || !this.a.F.l()) && view2 == this.a.j) {
                this.a.k.k(this.a.c.e(), this.a.c.h());
                this.a.k.n(this.a.p == null ? this.a.o : this.a.p);
                this.a.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080951, R.color.CAM_X0105, null), (Drawable) null);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return !PermissionUtil.requestWriteExternalStorgeAndCameraPermission(this.a.getPageContext().getPageActivity(), 1);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TbCameraView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.j == null || !this.a.isAdded()) {
                return;
            }
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            if (pureDrawable != null) {
                pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
            }
            this.a.j.setCompoundDrawables(null, null, pureDrawable, null);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements n29 {
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

        @Override // com.baidu.tieba.n29
        public void a(int i, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, mediaFileInfo) == null) {
                if (this.a.v && this.a.c != null && this.a.c.l() == 1 && this.a.E != null) {
                    if (this.a.E.a(i, mediaFileInfo)) {
                        this.a.b.j();
                    }
                } else if (this.a.c != null && this.a.c.m() != null && this.a.c.m().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                    if (this.a.b != null) {
                        this.a.b.o((ImageFileInfo) mediaFileInfo);
                    }
                } else if (mediaFileInfo != null && this.a.c != null && (mediaFileInfo instanceof ImageFileInfo)) {
                    this.a.c.y((ImageFileInfo) mediaFileInfo);
                    if (this.a.b != null) {
                        this.a.b.T(1);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements m39.f {
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

        @Override // com.baidu.tieba.m39.f
        public void a(int i, go4 go4Var) {
            List d;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, go4Var) == null) && this.a.c != null && go4Var != null) {
                String b = go4Var.b();
                String g = go4Var.g();
                if (b == null || b.equals(this.a.c.h()) || (d = this.a.c.d(b)) == null) {
                    return;
                }
                this.a.c.x(b);
                this.a.m.m(d);
                this.a.j.setText(g);
                this.a.l.smoothScrollToPosition(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements o29 {
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

        /* JADX WARN: Code restructure failed: missing block: B:49:0x011a, code lost:
            if (r5.a.J1(r7) != false) goto L44;
         */
        @Override // com.baidu.tieba.o29
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.a.a == null || this.a.c == null || this.a.b == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (e39.a(imageFileInfo.getFilePath()) == PhotoType.APNG) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0cc2);
                        return false;
                    } else if (f39.a(imageFileInfo)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0258);
                        return false;
                    } else if (f39.b(imageFileInfo)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0259), Integer.valueOf(ux4.k().l("key_upload_pic_max_width", 0)), Integer.valueOf(ux4.k().l("key_upload_pic_max_height", 0))));
                        return false;
                    } else {
                        if (this.a.c.n(imageFileInfo)) {
                            this.a.b.k(imageFileInfo);
                        } else {
                            this.a.b.d(imageFileInfo);
                        }
                        this.a.c.w(null);
                        this.a.m.notifyDataSetChanged();
                        this.a.Z1();
                        return true;
                    }
                } else if (!(mediaFileInfo instanceof VideoFileInfo)) {
                    return false;
                } else {
                    if (this.a.c.o()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f025a);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (AlbumActivityConfig.FROM_FLUTTER_GAME_VIDEO.equals(this.a.b.m)) {
                        if (!this.a.I1(videoFileInfo) || !this.a.J1(videoFileInfo)) {
                            return true;
                        }
                    } else {
                        if (this.a.K1(videoFileInfo)) {
                        }
                        return true;
                    }
                    this.a.c.w(videoFileInfo);
                    this.a.c.b();
                    this.a.m.notifyDataSetChanged();
                    this.a.b.j();
                    return true;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ko4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        @Override // com.baidu.tieba.ko4
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.ko4
        public void a(mo4 mo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mo4Var) == null) {
                if (this.a.w != null) {
                    this.a.w.h(false);
                }
                if (mo4Var == null) {
                    mo4Var = new mo4();
                }
                if (this.a.c != null && this.a.m != null) {
                    this.a.c.z(mo4Var);
                    String h = this.a.c.h();
                    this.a.c.x(h);
                    this.a.m.m(this.a.c.d(h));
                    if (this.a.l != null) {
                        this.a.l.smoothScrollToPosition(0);
                    }
                    this.a.Z1();
                }
                if (this.a.l != null) {
                    this.a.l.n();
                }
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

    public void Q1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.d == null) {
                this.d = new lo4(getPageContext().getPageActivity());
            }
            l29 l29Var = this.b;
            if (l29Var == null) {
                return;
            }
            if (l29Var.h()) {
                if (this.b.g()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            } else if (this.b.f()) {
                i2 = 2;
            } else {
                i2 = 3;
            }
            this.d.h(i2, new i(this));
        }
    }

    public final boolean I1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i2 = videoFileInfo.videoDuration;
            } else {
                i2 = 0;
            }
            if (i2 >= 10000 && i2 <= 60000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f025d);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean J1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFileInfo)) == null) {
            VideoFileInfo h2 = q29.h(videoFileInfo.videoPath);
            if (h2 == null || Math.max(h2.videoWidth, h2.videoHeight) <= 3000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f025b);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean K1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i2 = videoFileInfo.videoDuration;
            } else {
                i2 = 0;
            }
            if (i2 >= 3000 && i2 <= 600000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f025c);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void V1(l29 l29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l29Var) == null) {
            this.b = l29Var;
        }
    }

    public void W1(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, navigationBar) == null) {
            this.p = navigationBar;
        }
    }

    public void X1(q29 q29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, q29Var) == null) {
            this.F = q29Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (!this.u) {
                PermissionUtil.requestWriteExternalStorgePermission(requireActivity(), 1);
            }
        }
    }

    @Override // com.baidu.tieba.k29.d
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            t();
        }
    }

    public void T1(ImageFileInfo imageFileInfo, boolean z) {
        p29 p29Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048587, this, imageFileInfo, z) != null) || imageFileInfo == null || (p29Var = this.m) == null) {
            return;
        }
        S1(p29Var.i(imageFileInfo), z);
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

    public View L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            l29 l29Var = this.b;
            if (l29Var != null && l29Var.t() == 1) {
                return this.g;
            }
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public View M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            p29 p29Var = this.m;
            if (p29Var != null) {
                return p29Var.j();
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public TransparentHeadGridView O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (TransparentHeadGridView) invokeV.objValue;
    }

    public View P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            lo4 lo4Var = this.d;
            if (lo4Var != null) {
                lo4Var.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.a;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            yx4 yx4Var = this.w;
            if (yx4Var != null) {
                yx4Var.h(false);
            }
            k29.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDetach();
            m39 m39Var = this.k;
            if (m39Var != null) {
                m39Var.f();
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
            if (!isShow()) {
                return;
            }
            t();
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

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && !isHidden() && !this.t) {
            R1();
        }
    }

    public final void R1() {
        l29 l29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.c == null && (l29Var = this.b) != null) {
                this.c = l29Var.u();
            }
            j29 j29Var = this.c;
            if (j29Var == null) {
                return;
            }
            if (!j29Var.r()) {
                this.m.notifyDataSetChanged();
            } else {
                Q1();
            }
            U1(this.c.s());
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.w == null) {
                this.w = new yx4(getPageContext());
            }
            this.w.e(null);
            this.w.i(R.string.obfuscated_res_0x7f0f0a63);
            this.w.h(true);
        }
    }

    public void S1(int i2, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.l;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.l.getLastVisiblePosition();
                if (i2 >= firstVisiblePosition && i2 <= lastVisiblePosition && (childAt = this.l.getChildAt(i2 - firstVisiblePosition)) != null && this.m != null) {
                    this.m.t((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f091e3e), z);
                } else {
                    return;
                }
            }
            Z1();
        }
    }

    public void U1(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (baseFragmentActivity = this.a) != null && this.r != null) {
            this.r.setText(baseFragmentActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0d3d));
            if (z) {
                this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080968, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                return;
            }
            this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080969, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0106);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [boolean, int] */
    public final void Z1() {
        j29 j29Var;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (j29Var = this.c) != null && this.i != null) {
            boolean z = false;
            if (j29Var.p()) {
                ?? p = this.c.p();
                string = this.a.getString(R.string.obfuscated_res_0x7f0f08f9, new Object[]{Integer.valueOf((int) p), 1});
                i2 = p;
            } else {
                int count = ListUtils.getCount(this.c.g());
                string = this.a.getString(R.string.obfuscated_res_0x7f0f08f9, new Object[]{Integer.valueOf(count), Integer.valueOf(this.c.l())});
                i2 = count;
            }
            this.i.setText(string);
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (i2 > 0) {
                z = true;
            }
            tBSpecificationBtn.setEnabled(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onChangeSkinType(i2);
            me5.a(getPageContext(), this.e);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, i2);
            if (this.h != null && this.g != null) {
                l29 l29Var = this.b;
                if (l29Var != null && l29Var.t() == 1) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080a14, R.color.CAM_X0105, null);
                    this.h.setVisibility(8);
                } else {
                    SkinManager.setViewTextColor(this.h, (int) R.color.navi_back_text_color);
                    this.g.setVisibility(8);
                }
            }
            if (this.j != null) {
                this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null), (Drawable) null);
            }
            p29 p29Var = this.m;
            if (p29Var != null) {
                p29Var.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            j29 j29Var = this.c;
            if (j29Var != null) {
                U1(j29Var.s());
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
            if (this.b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.b = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.b = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            l29 l29Var = this.b;
            if (l29Var != null) {
                this.c = l29Var.u();
                this.u = this.b.z();
                this.v = this.b.y();
            }
            k29.f().d(this);
            this.d = new lo4(this.a);
            m39 m39Var = new m39(this.a);
            this.k = m39Var;
            m39Var.setOnDismissListener(this.B);
            this.k.l(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.b = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.b = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            l29 l29Var = this.b;
            if (l29Var != null) {
                this.c = l29Var.u();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0118, (ViewGroup) null);
            this.e = inflate;
            this.f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09023f);
            this.o = this.e.findViewById(R.id.obfuscated_res_0x7f0912a1);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090265);
            this.g = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090ecc);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090ece);
            this.s = this.e.findViewById(R.id.obfuscated_res_0x7f091630);
            this.q = this.e.findViewById(R.id.obfuscated_res_0x7f09126c);
            this.r = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091752);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f0916ac);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().l(fj.f(this.a, R.dimen.tbds25));
            this.c.x(go4.f);
            this.j.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0255));
            if (this.c.m() != null) {
                TextView textView = this.r;
                if (this.c.m().isEnableChooseOriginalImg()) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                textView.setVisibility(i2);
            }
            if (this.c.m() != null && this.c.m().isFromQRCode()) {
                this.q.setVisibility(8);
            }
            this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f025e, R.string.obfuscated_res_0x7f0f025f), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.e.findViewById(R.id.obfuscated_res_0x7f090d23);
            this.l = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            p29 p29Var = new p29(this.a, this.c);
            this.m = p29Var;
            if (this.u) {
                if (this.c.m() != null && this.c.m().isFromQRCode()) {
                    this.m.v(false);
                    this.u = false;
                } else {
                    this.m.v(true);
                }
            } else {
                p29Var.v(false);
            }
            if (this.v && this.c.l() == 1) {
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
            this.g.setOnClickListener(this.a);
            this.h.setOnClickListener(this.a);
            this.r.setOnClickListener(this.a);
            this.j.setOnClickListener(this.y);
            this.q.setOnClickListener(this.y);
            Z1();
            Y1();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.p != null) {
                if (this.j.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.j.getParent()).removeView(this.j);
                }
                this.o.setVisibility(8);
                this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.j, (View.OnClickListener) null);
            }
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048602, this, absListView, i2, i3, i4) == null) {
            super.onScroll(absListView, i2, i3, i4);
        }
    }
}
