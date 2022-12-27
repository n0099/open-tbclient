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
import com.baidu.tieba.cp4;
import com.baidu.tieba.dp4;
import com.baidu.tieba.ep4;
import com.baidu.tieba.ig5;
import com.baidu.tieba.j89;
import com.baidu.tieba.k89;
import com.baidu.tieba.o79;
import com.baidu.tieba.p79;
import com.baidu.tieba.q79;
import com.baidu.tieba.qk5;
import com.baidu.tieba.r89;
import com.baidu.tieba.ry4;
import com.baidu.tieba.s79;
import com.baidu.tieba.t79;
import com.baidu.tieba.u79;
import com.baidu.tieba.uy4;
import com.baidu.tieba.v79;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.tieba.yi;
import com.baidu.tieba.yo4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class ImageListFragment extends BaseFragment implements p79.d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int H = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public TbCameraView.f A;
    public TbCameraView.d B;
    public PopupWindow.OnDismissListener C;
    public s79 D;
    public r89.f E;
    public t79 F;
    public v79 G;
    public BaseFragmentActivity a;
    public q79 b;
    public o79 c;
    public dp4 d;
    public View e;
    public RelativeLayout f;
    public ImageView g;
    public TextView h;
    public TBSpecificationBtn i;
    public TextView j;
    public r89 k;
    public TransparentHeadGridView l;
    public u79 m;
    public NoDataView n;
    public View o;
    public NavigationBar p;
    public View q;
    public TextView r;
    public View s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public uy4 x;
    public View.OnClickListener y;
    public View.OnClickListener z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-522418032, "Lcom/baidu/tieba/write/album/ImageListFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-522418032, "Lcom/baidu/tieba/write/album/ImageListFragment;");
        }
    }

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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || qk5.a() || this.a.c == null) {
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
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(l)));
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
            if ((this.a.G == null || !this.a.G.l()) && view2 == this.a.j) {
                this.a.k.k(this.a.c.e(), this.a.c.h());
                this.a.k.n(this.a.p == null ? this.a.o : this.a.p);
                this.a.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null), (Drawable) null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TbCameraView.f {
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

        @Override // com.baidu.tieba.write.album.TbCameraView.f
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
    public class d implements TbCameraView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        @Override // com.baidu.tieba.write.album.TbCameraView.d
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
    public class f implements s79 {
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

        @Override // com.baidu.tieba.s79
        public void a(int i, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, mediaFileInfo) == null) {
                if (this.a.v && this.a.c != null && this.a.c.l() == 1 && this.a.F != null) {
                    if (this.a.F.a(i, mediaFileInfo)) {
                        this.a.b.j();
                    }
                } else if (this.a.c != null && this.a.c.m() != null && this.a.c.m().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                    if (this.a.b != null) {
                        this.a.b.n((ImageFileInfo) mediaFileInfo);
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
    public class g implements r89.f {
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

        @Override // com.baidu.tieba.r89.f
        public void a(int i, yo4 yo4Var) {
            List<MediaFileInfo> d;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, yo4Var) == null) && this.a.c != null && yo4Var != null) {
                String b = yo4Var.b();
                String g = yo4Var.g();
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
    public class h implements t79 {
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

        /* JADX WARN: Code restructure failed: missing block: B:57:0x014d, code lost:
            if (r5.a.T1(r7) != false) goto L52;
         */
        @Override // com.baidu.tieba.t79
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
                    if (j89.a(imageFileInfo.getFilePath()) == PhotoType.APNG) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0d12);
                        return false;
                    } else if (k89.a(imageFileInfo)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f025c);
                        return false;
                    } else if (this.a.w == ImageListFragment.H && k89.c(imageFileInfo)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f025d), new Object[0]));
                        return false;
                    } else if (k89.b(imageFileInfo)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f025e), Integer.valueOf(ry4.l().m("key_upload_pic_max_width", 0)), Integer.valueOf(ry4.l().m("key_upload_pic_max_height", 0))));
                        return false;
                    } else {
                        if (this.a.c.n(imageFileInfo)) {
                            this.a.b.k(imageFileInfo);
                        } else {
                            this.a.b.d(imageFileInfo);
                        }
                        this.a.c.w(null);
                        this.a.m.notifyDataSetChanged();
                        this.a.j2();
                        return true;
                    }
                } else if (!(mediaFileInfo instanceof VideoFileInfo)) {
                    return false;
                } else {
                    if (this.a.c.o()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f025f);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (AlbumActivityConfig.FROM_FLUTTER_GAME_VIDEO.equals(this.a.b.m)) {
                        if (!this.a.S1(videoFileInfo) || !this.a.T1(videoFileInfo) || !this.a.R1(videoFileInfo)) {
                            return true;
                        }
                    } else {
                        if (this.a.U1(videoFileInfo)) {
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
    public class i implements cp4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        @Override // com.baidu.tieba.cp4
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

        @Override // com.baidu.tieba.cp4
        public void a(ep4 ep4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ep4Var) == null) {
                if (this.a.x != null) {
                    this.a.x.h(false);
                }
                if (ep4Var == null) {
                    ep4Var = new ep4();
                }
                if (this.a.c != null && this.a.m != null) {
                    this.a.c.z(ep4Var);
                    String h = this.a.c.h();
                    this.a.c.x(h);
                    this.a.m.m(this.a.c.d(h));
                    if (this.a.l != null) {
                        this.a.l.smoothScrollToPosition(0);
                    }
                    this.a.j2();
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = true;
        this.v = false;
        this.x = null;
        this.y = new a(this);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new d(this);
        this.C = new e(this);
        this.D = new f(this);
        this.E = new g(this);
        this.F = new h(this);
    }

    public void a2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.b != null && getPageContext() != null) {
            if (this.d == null) {
                this.d = new dp4(getPageContext().getPageActivity());
            }
            if (this.b.h()) {
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

    public final boolean S1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i2 = videoFileInfo.videoDuration;
            } else {
                i2 = 0;
            }
            if (i2 >= 10000 && i2 <= 60000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f0263);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean T1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoFileInfo)) == null) {
            VideoFileInfo h2 = v79.h(videoFileInfo.videoPath);
            if (h2 == null || Math.max(h2.videoWidth, h2.videoHeight) <= 3000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f0261);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean U1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i2 = videoFileInfo.videoDuration;
            } else {
                i2 = 0;
            }
            if (i2 >= 3000 && i2 <= 600000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f0262);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f2(q79 q79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, q79Var) == null) {
            this.b = q79Var;
        }
    }

    public void g2(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, navigationBar) == null) {
            this.p = navigationBar;
        }
    }

    public void h2(v79 v79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, v79Var) == null) {
            this.G = v79Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (!this.u) {
                PermissionUtil.requestWriteExternalStorgePermission(requireActivity(), 1);
            }
        }
    }

    @Override // com.baidu.tieba.p79.d
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            u();
        }
    }

    public View V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q79 q79Var = this.b;
            if (q79Var != null && q79Var.s() == 1) {
                return this.g;
            }
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public View W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u79 u79Var = this.m;
            if (u79Var != null) {
                return u79Var.j();
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public TransparentHeadGridView Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (TransparentHeadGridView) invokeV.objValue;
    }

    public View Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroy();
            dp4 dp4Var = this.d;
            if (dp4Var != null) {
                dp4Var.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.a;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            uy4 uy4Var = this.x;
            if (uy4Var != null) {
                uy4Var.h(false);
            }
            p79.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDetach();
            r89 r89Var = this.k;
            if (r89Var != null) {
                r89Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPause();
            this.t = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onResume();
            this.t = false;
            if (!isShow()) {
                return;
            }
            u();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStop();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && !isHidden() && !this.t) {
            b2();
        }
    }

    public void d2(ImageFileInfo imageFileInfo, boolean z) {
        u79 u79Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048588, this, imageFileInfo, z) != null) || imageFileInfo == null || (u79Var = this.m) == null) {
            return;
        }
        c2(u79Var.i(imageFileInfo), z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, absListView, i2) == null) {
            super.onScrollStateChanged(absListView, i2);
            if (i2 == 2) {
                this.m.r(true);
            } else if (this.m.k()) {
                this.m.r(false);
            }
        }
    }

    public final boolean R1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoFileInfo)) == null) {
            if (new File(videoFileInfo.videoPath).length() > 104857600) {
                this.a.showToast(String.format(getString(R.string.obfuscated_res_0x7f0f0260), new Object[0]));
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void b2() {
        q79 q79Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.c == null && (q79Var = this.b) != null) {
                this.c = q79Var.u();
            }
            o79 o79Var = this.c;
            if (o79Var == null) {
                return;
            }
            if (!o79Var.r()) {
                this.m.notifyDataSetChanged();
            } else {
                a2();
            }
            e2(this.c.s());
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.x == null) {
                this.x = new uy4(getPageContext());
            }
            this.x.e(null);
            this.x.i(R.string.obfuscated_res_0x7f0f0aa7);
            this.x.h(true);
        }
    }

    public void c2(int i2, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.l;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.l.getLastVisiblePosition();
                if (i2 >= firstVisiblePosition && i2 <= lastVisiblePosition && (childAt = this.l.getChildAt(i2 - firstVisiblePosition)) != null && this.m != null) {
                    this.m.t((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f091f01), z);
                } else {
                    return;
                }
            }
            j2();
        }
    }

    public void e2(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (baseFragmentActivity = this.a) != null && this.r != null) {
            this.r.setText(baseFragmentActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0d8d));
            if (z) {
                this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_select16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                return;
            }
            this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_selection16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0106);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [int, boolean] */
    public final void j2() {
        o79 o79Var;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (o79Var = this.c) != null && this.i != null) {
            boolean z = false;
            if (o79Var.p()) {
                ?? p = this.c.p();
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0938, new Object[]{Integer.valueOf((int) p), 1});
                i2 = p;
            } else {
                int count = ListUtils.getCount(this.c.g());
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0938, new Object[]{Integer.valueOf(count), Integer.valueOf(this.c.l())});
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
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            super.onChangeSkinType(i2);
            ig5.a(getPageContext(), this.e);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, i2);
            if (this.h != null && this.g != null) {
                q79 q79Var = this.b;
                if (q79Var != null && q79Var.s() == 1) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, null);
                    this.h.setVisibility(8);
                } else {
                    SkinManager.setViewTextColor(this.h, (int) R.color.navi_back_text_color);
                    this.g.setVisibility(8);
                }
            }
            if (this.j != null) {
                this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null), (Drawable) null);
            }
            u79 u79Var = this.m;
            if (u79Var != null) {
                u79Var.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            o79 o79Var = this.c;
            if (o79Var != null) {
                e2(o79Var.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
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
            q79 q79Var = this.b;
            if (q79Var != null) {
                this.c = q79Var.u();
                this.u = this.b.z();
                this.v = this.b.y();
            }
            p79.f().d(this);
            this.d = new dp4(this.a);
            r89 r89Var = new r89(this.a);
            this.k = r89Var;
            r89Var.setOnDismissListener(this.C);
            this.k.l(this.E);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.b = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.b = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            q79 q79Var = this.b;
            if (q79Var != null) {
                this.c = q79Var.u();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d011a, (ViewGroup) null);
            this.e = inflate;
            this.f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09024e);
            this.o = this.e.findViewById(R.id.layout_title);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090274);
            this.g = (ImageView) this.e.findViewById(R.id.img_close);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090f65);
            this.s = this.e.findViewById(R.id.obfuscated_res_0x7f0916da);
            this.q = this.e.findViewById(R.id.obfuscated_res_0x7f09130b);
            this.r = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091803);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f091757);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().l(yi.g(this.a, R.dimen.tbds25));
            this.c.x(yo4.f);
            this.j.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0259));
            if (this.c.m() != null) {
                this.w = this.c.m().getSource();
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
            this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0264, R.string.obfuscated_res_0x7f0f0265), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.e.findViewById(R.id.obfuscated_res_0x7f090d92);
            this.l = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            u79 u79Var = new u79(this.a, this.c);
            this.m = u79Var;
            if (this.u) {
                if (this.c.m() != null && this.c.m().isFromQRCode()) {
                    this.m.v(false);
                    this.u = false;
                } else {
                    this.m.v(true);
                }
            } else {
                u79Var.v(false);
            }
            if (this.v && this.c.l() == 1) {
                this.m.w(false);
            } else {
                this.m.w(true);
            }
            this.l.setAdapter((ListAdapter) this.m);
            this.l.setOuterOnScrollListener(this);
            this.m.u(this.F);
            this.m.n(this.D);
            this.m.q(this.y);
            this.m.o(this.B);
            this.m.p(this.A);
            this.i.setOnClickListener(this.a);
            this.g.setOnClickListener(this.a);
            this.h.setOnClickListener(this.a);
            this.r.setOnClickListener(this.a);
            this.j.setOnClickListener(this.z);
            this.q.setOnClickListener(this.z);
            j2();
            i2();
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
        if (interceptable == null || interceptable.invokeLIII(1048603, this, absListView, i2, i3, i4) == null) {
            super.onScroll(absListView, i2, i3, i4);
        }
    }
}
