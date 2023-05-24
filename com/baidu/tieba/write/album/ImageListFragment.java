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
import com.baidu.tieba.a9a;
import com.baidu.tieba.au4;
import com.baidu.tieba.b8a;
import com.baidu.tieba.c8a;
import com.baidu.tieba.cp5;
import com.baidu.tieba.d8a;
import com.baidu.tieba.e8a;
import com.baidu.tieba.eu4;
import com.baidu.tieba.fu4;
import com.baidu.tieba.gu4;
import com.baidu.tieba.mt5;
import com.baidu.tieba.o65;
import com.baidu.tieba.ri;
import com.baidu.tieba.s65;
import com.baidu.tieba.s8a;
import com.baidu.tieba.t8a;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.tieba.x7a;
import com.baidu.tieba.y7a;
import com.baidu.tieba.z7a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class ImageListFragment extends BaseFragment implements y7a.d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int H = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public TbCameraView.f A;
    public TbCameraView.d B;
    public PopupWindow.OnDismissListener C;
    public b8a D;
    public a9a.f E;
    public c8a F;
    public e8a G;
    public BaseFragmentActivity a;
    public z7a b;
    public x7a c;
    public fu4 d;
    public View e;
    public RelativeLayout f;
    public ImageView g;
    public TextView h;
    public TBSpecificationBtn i;
    public TextView j;
    public a9a k;
    public TransparentHeadGridView l;
    public d8a m;
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
    public s65 x;
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

    /* loaded from: classes8.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || mt5.a() || this.a.c == null) {
                return;
            }
            int l = this.a.c.l();
            if (this.a.c.D() < l) {
                if (this.a.b != null) {
                    this.a.b.Y(this.a.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.a;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class f implements b8a {
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

        @Override // com.baidu.tieba.b8a
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
                        this.a.b.U(1);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements a9a.f {
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

        @Override // com.baidu.tieba.a9a.f
        public void a(int i, au4 au4Var) {
            List<MediaFileInfo> d;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, au4Var) == null) && this.a.c != null && au4Var != null) {
                String b = au4Var.b();
                String g = au4Var.g();
                if (b == null || b.equals(this.a.c.h()) || (d = this.a.c.d(b)) == null) {
                    return;
                }
                this.a.c.x(b);
                this.a.m.n(d);
                this.a.j.setText(g);
                this.a.l.smoothScrollToPosition(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements c8a {
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
            if (r5.a.c2(r7) != false) goto L52;
         */
        @Override // com.baidu.tieba.c8a
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
                    if (s8a.a(imageFileInfo.getFilePath()) == PhotoType.APNG) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e15);
                        return false;
                    } else if (t8a.a(imageFileInfo)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0283);
                        return false;
                    } else if (this.a.w == ImageListFragment.H && t8a.c(imageFileInfo)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0284), new Object[0]));
                        return false;
                    } else if (t8a.b(imageFileInfo)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0285), Integer.valueOf(o65.m().n("key_upload_pic_max_width", 0)), Integer.valueOf(o65.m().n("key_upload_pic_max_height", 0))));
                        return false;
                    } else {
                        if (this.a.c.n(imageFileInfo)) {
                            this.a.b.k(imageFileInfo);
                        } else {
                            this.a.b.d(imageFileInfo);
                        }
                        this.a.c.w(null);
                        this.a.m.notifyDataSetChanged();
                        this.a.s2();
                        return true;
                    }
                } else if (!(mediaFileInfo instanceof VideoFileInfo)) {
                    return false;
                } else {
                    if (this.a.c.o()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0286);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (AlbumActivityConfig.FROM_FLUTTER_GAME_VIDEO.equals(this.a.b.m)) {
                        if (!this.a.b2(videoFileInfo) || !this.a.c2(videoFileInfo) || !this.a.a2(videoFileInfo)) {
                            return true;
                        }
                    } else {
                        if (this.a.d2(videoFileInfo)) {
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

    /* loaded from: classes8.dex */
    public class i implements eu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        @Override // com.baidu.tieba.eu4
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

        @Override // com.baidu.tieba.eu4
        public void a(gu4 gu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gu4Var) == null) {
                if (this.a.x != null) {
                    this.a.x.h(false);
                }
                if (gu4Var == null) {
                    gu4Var = new gu4();
                }
                if (this.a.c != null && this.a.m != null) {
                    this.a.c.z(gu4Var);
                    String h = this.a.c.h();
                    this.a.c.x(h);
                    this.a.m.n(this.a.c.d(h));
                    if (this.a.l != null) {
                        this.a.l.smoothScrollToPosition(0);
                    }
                    this.a.s2();
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

    public void j2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.b != null && getPageContext() != null) {
            if (this.d == null) {
                this.d = new fu4(getPageContext().getPageActivity());
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

    @Override // com.baidu.tieba.y7a.d
    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            y();
        }
    }

    public final boolean b2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i2 = videoFileInfo.videoDuration;
            } else {
                i2 = 0;
            }
            if (i2 >= 10000 && i2 <= 60000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f028a);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean c2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, videoFileInfo)) == null) {
            VideoFileInfo h2 = e8a.h(videoFileInfo.videoPath);
            if (h2 == null || Math.max(h2.videoWidth, h2.videoHeight) <= 3000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f0288);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean d2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i2 = videoFileInfo.videoDuration;
            } else {
                i2 = 0;
            }
            if (i2 >= 3000 && i2 <= 600000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f0289);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o2(z7a z7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, z7aVar) == null) {
            this.b = z7aVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (!this.u) {
                PermissionUtil.requestWriteExternalStorgePermission(requireActivity(), 1);
            }
        }
    }

    public void p2(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, navigationBar) == null) {
            this.p = navigationBar;
        }
    }

    public void q2(e8a e8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, e8aVar) == null) {
            this.G = e8aVar;
        }
    }

    public View e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            z7a z7aVar = this.b;
            if (z7aVar != null && z7aVar.s() == 1) {
                return this.g;
            }
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public View f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d8a d8aVar = this.m;
            if (d8aVar != null) {
                return d8aVar.j();
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public TransparentHeadGridView h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return (TransparentHeadGridView) invokeV.objValue;
    }

    public View i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDetach();
            a9a a9aVar = this.k;
            if (a9aVar != null) {
                a9aVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            this.t = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            this.t = false;
            if (!isShow()) {
                return;
            }
            y();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onStop();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && !isHidden() && !this.t) {
            k2();
        }
    }

    public void m2(ImageFileInfo imageFileInfo, boolean z) {
        d8a d8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048589, this, imageFileInfo, z) != null) || imageFileInfo == null || (d8aVar = this.m) == null) {
            return;
        }
        l2(d8aVar.i(imageFileInfo), z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, absListView, i2) == null) {
            super.onScrollStateChanged(absListView, i2);
            if (i2 == 2) {
                this.m.s(true);
            } else if (this.m.k()) {
                this.m.s(false);
            }
        }
    }

    public final boolean a2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFileInfo)) == null) {
            if (new File(videoFileInfo.videoPath).length() > 104857600) {
                this.a.showToast(String.format(getString(R.string.obfuscated_res_0x7f0f0287), new Object[0]));
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void k2() {
        z7a z7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.c == null && (z7aVar = this.b) != null) {
                this.c = z7aVar.t();
            }
            x7a x7aVar = this.c;
            if (x7aVar == null) {
                return;
            }
            if (!x7aVar.r()) {
                this.m.notifyDataSetChanged();
            } else {
                j2();
            }
            n2(this.c.s());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            TransparentHeadGridView transparentHeadGridView = this.l;
            if (transparentHeadGridView != null) {
                transparentHeadGridView.setOuterOnScrollListener(null);
            }
            fu4 fu4Var = this.d;
            if (fu4Var != null) {
                fu4Var.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.a;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            s65 s65Var = this.x;
            if (s65Var != null) {
                s65Var.h(false);
            }
            d8a d8aVar = this.m;
            if (d8aVar != null) {
                d8aVar.m();
            }
            y7a.f().k(this);
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.x == null) {
                this.x = new s65(getPageContext());
            }
            this.x.e(null);
            this.x.i(R.string.obfuscated_res_0x7f0f0b95);
            this.x.h(true);
        }
    }

    public void l2(int i2, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.l;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.l.getLastVisiblePosition();
                if (i2 >= firstVisiblePosition && i2 <= lastVisiblePosition && (childAt = this.l.getChildAt(i2 - firstVisiblePosition)) != null && this.m != null) {
                    this.m.u((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f092063), z);
                } else {
                    return;
                }
            }
            s2();
        }
    }

    public void n2(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (baseFragmentActivity = this.a) != null && this.r != null) {
            this.r.setText(baseFragmentActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0e96));
            if (z) {
                this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_select16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                return;
            }
            this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_selection16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0106);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.onChangeSkinType(i2);
            cp5.a(getPageContext(), this.e);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, i2);
            if (this.h != null && this.g != null) {
                z7a z7aVar = this.b;
                if (z7aVar != null && z7aVar.s() == 1) {
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
            d8a d8aVar = this.m;
            if (d8aVar != null) {
                d8aVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            x7a x7aVar = this.c;
            if (x7aVar != null) {
                n2(x7aVar.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
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
            z7a z7aVar = this.b;
            if (z7aVar != null) {
                this.c = z7aVar.t();
                this.u = this.b.B();
                this.v = this.b.A();
            }
            y7a.f().d(this);
            this.d = new fu4(this.a);
            a9a a9aVar = new a9a(this.a);
            this.k = a9aVar;
            a9aVar.setOnDismissListener(this.C);
            this.k.l(this.E);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.b = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.b = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            z7a z7aVar = this.b;
            if (z7aVar != null) {
                this.c = z7aVar.t();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d011f, (ViewGroup) null);
            this.e = inflate;
            this.f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09024f);
            this.o = this.e.findViewById(R.id.layout_title);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090275);
            this.g = (ImageView) this.e.findViewById(R.id.img_close);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091084);
            this.s = this.e.findViewById(R.id.obfuscated_res_0x7f09181a);
            this.q = this.e.findViewById(R.id.obfuscated_res_0x7f09142d);
            this.r = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09194b);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f09189d);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().m(ri.g(this.a, R.dimen.tbds25));
            this.c.x(au4.f);
            this.j.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0280));
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
            this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f028b, R.string.obfuscated_res_0x7f0f028c), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.e.findViewById(R.id.obfuscated_res_0x7f090e9f);
            this.l = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            d8a d8aVar = new d8a(this.a, this.c);
            this.m = d8aVar;
            if (this.u) {
                if (this.c.m() != null && this.c.m().isFromQRCode()) {
                    this.m.w(false);
                    this.u = false;
                } else {
                    this.m.w(true);
                }
            } else {
                d8aVar.w(false);
            }
            if (this.v && this.c.l() == 1) {
                this.m.x(false);
            } else {
                this.m.x(true);
            }
            this.l.setAdapter((ListAdapter) this.m);
            this.l.setOuterOnScrollListener(this);
            this.m.v(this.F);
            this.m.o(this.D);
            this.m.r(this.y);
            this.m.p(this.B);
            this.m.q(this.A);
            this.i.setOnClickListener(this.a);
            this.g.setOnClickListener(this.a);
            this.h.setOnClickListener(this.a);
            this.r.setOnClickListener(this.a);
            this.j.setOnClickListener(this.z);
            this.q.setOnClickListener(this.z);
            s2();
            r2();
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
        if (interceptable == null || interceptable.invokeLIII(1048600, this, absListView, i2, i3, i4) == null) {
            super.onScroll(absListView, i2, i3, i4);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [int, boolean] */
    public final void s2() {
        x7a x7aVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (x7aVar = this.c) != null && this.i != null) {
            boolean z = false;
            if (x7aVar.p()) {
                ?? p = this.c.p();
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0a22, new Object[]{Integer.valueOf((int) p), 1});
                i2 = p;
            } else {
                int count = ListUtils.getCount(this.c.g());
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0a22, new Object[]{Integer.valueOf(count), Integer.valueOf(this.c.l())});
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
}
