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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ar4;
import com.baidu.tieba.eab;
import com.baidu.tieba.f9b;
import com.baidu.tieba.fab;
import com.baidu.tieba.g9b;
import com.baidu.tieba.h9b;
import com.baidu.tieba.iu5;
import com.baidu.tieba.j9b;
import com.baidu.tieba.k9b;
import com.baidu.tieba.l9b;
import com.baidu.tieba.m9b;
import com.baidu.tieba.mab;
import com.baidu.tieba.uq4;
import com.baidu.tieba.wp5;
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.tieba.yq4;
import com.baidu.tieba.zq4;
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
public class ImageListFragment extends BaseFragment implements g9b.d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int F = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow.OnDismissListener A;
    public j9b B;
    public mab.f C;
    public k9b D;
    public m9b E;
    public BaseFragmentActivity a;
    public h9b b;
    public f9b c;
    public zq4 d;
    public View e;
    public RelativeLayout f;
    public ImageView g;
    public TextView h;
    public TBSpecificationBtn i;
    public TextView j;
    public mab k;
    public TransparentHeadGridView l;
    public l9b m;
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
    public BlueCircleProgressDialog x;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || iu5.a() || this.a.c == null) {
                return;
            }
            int l = this.a.c.l();
            if (this.a.c.D() < l) {
                if (this.a.b != null) {
                    this.a.b.V(this.a.getPageContext());
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
            if ((this.a.E == null || !this.a.E.l()) && view2 == this.a.j) {
                this.a.k.k(this.a.c.e(), this.a.c.h());
                this.a.k.n(this.a.p == null ? this.a.o : this.a.p);
                this.a.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null), (Drawable) null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
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
    public class d implements j9b {
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

        @Override // com.baidu.tieba.j9b
        public void a(int i, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, mediaFileInfo) == null) {
                if (this.a.v && this.a.c != null && this.a.c.l() == 1 && this.a.D != null) {
                    if (this.a.D.a(i, mediaFileInfo)) {
                        this.a.b.k();
                    }
                } else if (this.a.c != null && this.a.c.m() != null && this.a.c.m().isFromQRCode() && (mediaFileInfo instanceof ImageFileInfo)) {
                    if (this.a.b != null) {
                        this.a.b.o((ImageFileInfo) mediaFileInfo);
                    }
                } else if (mediaFileInfo != null && this.a.c != null && (mediaFileInfo instanceof ImageFileInfo)) {
                    this.a.c.y((ImageFileInfo) mediaFileInfo);
                    if (this.a.b != null) {
                        this.a.b.S(1);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements mab.f {
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

        @Override // com.baidu.tieba.mab.f
        public void b(int i, uq4 uq4Var) {
            List<MediaFileInfo> d;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, uq4Var) == null) && this.a.c != null && uq4Var != null) {
                String b = uq4Var.b();
                String g = uq4Var.g();
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

    /* loaded from: classes8.dex */
    public class f implements k9b {
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

        /* JADX WARN: Code restructure failed: missing block: B:57:0x014d, code lost:
            if (r5.a.Q2(r7) != false) goto L52;
         */
        @Override // com.baidu.tieba.k9b
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
                    if (eab.a(imageFileInfo.getFilePath()) == PhotoType.APNG) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0ec0);
                        return false;
                    } else if (fab.a(imageFileInfo)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0288);
                        return false;
                    } else if (this.a.w == ImageListFragment.F && fab.c(imageFileInfo)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0289), new Object[0]));
                        return false;
                    } else if (fab.b(imageFileInfo)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f028a), Integer.valueOf(SharedPrefHelper.getInstance().getInt("key_upload_pic_max_width", 0)), Integer.valueOf(SharedPrefHelper.getInstance().getInt("key_upload_pic_max_height", 0))));
                        return false;
                    } else {
                        if (this.a.c.n(imageFileInfo)) {
                            this.a.b.l(imageFileInfo);
                        } else {
                            this.a.b.d(imageFileInfo);
                        }
                        this.a.c.w(null);
                        this.a.m.notifyDataSetChanged();
                        this.a.f3();
                        return true;
                    }
                } else if (!(mediaFileInfo instanceof VideoFileInfo)) {
                    return false;
                } else {
                    if (this.a.c.o()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f028b);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (AlbumActivityConfig.FROM_FLUTTER_GAME_VIDEO.equals(this.a.b.m)) {
                        if (!this.a.P2(videoFileInfo) || !this.a.Q2(videoFileInfo) || !this.a.O2(videoFileInfo)) {
                            return true;
                        }
                    } else {
                        if (this.a.R2(videoFileInfo)) {
                        }
                        return true;
                    }
                    this.a.c.w(videoFileInfo);
                    this.a.c.b();
                    this.a.m.notifyDataSetChanged();
                    this.a.b.k();
                    return true;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements yq4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageListFragment a;

        @Override // com.baidu.tieba.yq4
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.yq4
        public void a(ar4 ar4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ar4Var) == null) {
                if (this.a.x != null) {
                    this.a.x.setDialogVisiable(false);
                }
                if (ar4Var == null) {
                    ar4Var = new ar4();
                }
                if (this.a.c != null && this.a.m != null) {
                    this.a.c.z(ar4Var);
                    String h = this.a.c.h();
                    this.a.c.x(h);
                    this.a.m.m(this.a.c.d(h));
                    if (this.a.l != null) {
                        this.a.l.smoothScrollToPosition(0);
                    }
                    this.a.f3();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    }

    public void W2() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.b != null && getPageContext() != null) {
            if (this.d == null) {
                this.d = new zq4(getPageContext().getPageActivity());
            }
            if (this.b.h()) {
                if (this.b.g()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (this.b.f()) {
                i = 2;
            } else {
                i = 3;
            }
            this.d.h(i, new g(this));
        }
    }

    public final boolean P2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i = videoFileInfo.videoDuration;
            } else {
                i = 0;
            }
            if (i >= 10000 && i <= 60000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f028f);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Q2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoFileInfo)) == null) {
            VideoFileInfo h = m9b.h(videoFileInfo.videoPath);
            if (h == null || Math.max(h.videoWidth, h.videoHeight) <= 3000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f028d);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean R2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, videoFileInfo)) == null) {
            if (videoFileInfo != null) {
                i = videoFileInfo.videoDuration;
            } else {
                i = 0;
            }
            if (i >= 3000 && i <= 600000) {
                return true;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f028e);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.g9b.d
    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            R();
        }
    }

    public void b3(h9b h9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, h9bVar) == null) {
            this.b = h9bVar;
        }
    }

    public void c3(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, navigationBar) == null) {
            this.p = navigationBar;
        }
    }

    public void d3(m9b m9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, m9bVar) == null) {
            this.E = m9bVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onActivityCreated(bundle);
            PermissionUtil.requestWriteExternalStorgePermission(requireActivity(), 1);
        }
    }

    public void Z2(ImageFileInfo imageFileInfo, boolean z) {
        l9b l9bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048589, this, imageFileInfo, z) != null) || imageFileInfo == null || (l9bVar = this.m) == null) {
            return;
        }
        Y2(l9bVar.i(imageFileInfo), z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, absListView, i) == null) {
            super.onScrollStateChanged(absListView, i);
            if (i == 2) {
                this.m.p(true);
            } else if (this.m.j()) {
                this.m.p(false);
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !isHidden() && !this.t) {
            X2();
        }
    }

    public View S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h9b h9bVar = this.b;
            if (h9bVar != null && h9bVar.s() == 1) {
                return this.g;
            }
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public View T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public TransparentHeadGridView U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (TransparentHeadGridView) invokeV.objValue;
    }

    public View V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetach();
            mab mabVar = this.k;
            if (mabVar != null) {
                mabVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
            this.t = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            this.t = false;
            if (!isShow()) {
                return;
            }
            R();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onStop();
        }
    }

    public final boolean O2(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoFileInfo)) == null) {
            if (new File(videoFileInfo.videoPath).length() > 104857600) {
                this.a.showToast(String.format(getString(R.string.obfuscated_res_0x7f0f028c), new Object[0]));
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void X2() {
        h9b h9bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.c == null && (h9bVar = this.b) != null) {
                this.c = h9bVar.t();
            }
            f9b f9bVar = this.c;
            if (f9bVar == null) {
                return;
            }
            if (!f9bVar.r()) {
                this.m.notifyDataSetChanged();
            } else {
                W2();
            }
            a3(this.c.s());
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.x == null) {
                this.x = new BlueCircleProgressDialog(getPageContext());
            }
            this.x.setCancelListener(null);
            this.x.setTipString(R.string.obfuscated_res_0x7f0f0c22);
            this.x.setDialogVisiable(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDestroy();
            TransparentHeadGridView transparentHeadGridView = this.l;
            if (transparentHeadGridView != null) {
                transparentHeadGridView.setOuterOnScrollListener(null);
            }
            zq4 zq4Var = this.d;
            if (zq4Var != null) {
                zq4Var.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.a;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            BlueCircleProgressDialog blueCircleProgressDialog = this.x;
            if (blueCircleProgressDialog != null) {
                blueCircleProgressDialog.setDialogVisiable(false);
            }
            l9b l9bVar = this.m;
            if (l9bVar != null) {
                l9bVar.l();
            }
            g9b.f().k(this);
        }
    }

    public void Y2(int i, boolean z) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TransparentHeadGridView transparentHeadGridView = this.l;
            if (transparentHeadGridView != null) {
                int firstVisiblePosition = transparentHeadGridView.getFirstVisiblePosition();
                int lastVisiblePosition = this.l.getLastVisiblePosition();
                if (i >= firstVisiblePosition && i <= lastVisiblePosition && (childAt = this.l.getChildAt(i - firstVisiblePosition)) != null && this.m != null) {
                    this.m.r((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f0921cf), z);
                } else {
                    return;
                }
            }
            f3();
        }
    }

    public void a3(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (baseFragmentActivity = this.a) != null && this.r != null) {
            this.r.setText(baseFragmentActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0f49));
            if (z) {
                this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_select16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                return;
            }
            this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_selection16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0106);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [boolean, int] */
    public final void f3() {
        f9b f9bVar;
        String string;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (f9bVar = this.c) != null && this.i != null) {
            boolean z = false;
            if (f9bVar.p()) {
                ?? p = this.c.p();
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0a9b, new Object[]{Integer.valueOf((int) p), 1});
                i = p;
            } else {
                int count = ListUtils.getCount(this.c.g());
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0a9b, new Object[]{Integer.valueOf(count), Integer.valueOf(this.c.l())});
                i = count;
            }
            this.i.setText(string);
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (i > 0) {
                z = true;
            }
            tBSpecificationBtn.setEnabled(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            super.onChangeSkinType(i);
            wp5.a(getPageContext(), this.e);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, i);
            if (this.h != null && this.g != null) {
                h9b h9bVar = this.b;
                if (h9bVar != null && h9bVar.s() == 1) {
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
            l9b l9bVar = this.m;
            if (l9bVar != null) {
                l9bVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            f9b f9bVar = this.c;
            if (f9bVar != null) {
                a3(f9bVar.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
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
            h9b h9bVar = this.b;
            if (h9bVar != null) {
                this.c = h9bVar.t();
                this.u = this.b.A();
                this.v = this.b.z();
            }
            g9b.f().d(this);
            this.d = new zq4(this.a);
            mab mabVar = new mab(this.a);
            this.k = mabVar;
            mabVar.setOnDismissListener(this.A);
            this.k.l(this.C);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.b = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.b = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            h9b h9bVar = this.b;
            if (h9bVar != null) {
                this.c = h9bVar.t();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0124, (ViewGroup) null);
            this.e = inflate;
            this.f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090265);
            this.o = this.e.findViewById(R.id.layout_title);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09028d);
            this.g = (ImageView) this.e.findViewById(R.id.img_close);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091127);
            this.s = this.e.findViewById(R.id.obfuscated_res_0x7f091953);
            this.q = this.e.findViewById(R.id.obfuscated_res_0x7f0914e4);
            this.r = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091a98);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f0919d8);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().n(BdUtilHelper.getDimens(this.a, R.dimen.tbds25));
            this.c.x(uq4.f);
            this.j.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0285));
            if (this.c.m() != null) {
                this.w = this.c.m().getSource();
                TextView textView = this.r;
                if (this.c.m().isEnableChooseOriginalImg()) {
                    i = 0;
                } else {
                    i = 4;
                }
                textView.setVisibility(i);
            }
            if (this.c.m() != null && this.c.m().isFromQRCode()) {
                this.q.setVisibility(8);
            }
            this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0290, R.string.obfuscated_res_0x7f0f0291), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.e.findViewById(R.id.obfuscated_res_0x7f090f2c);
            this.l = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            l9b l9bVar = new l9b(this.a, this.c);
            this.m = l9bVar;
            if (this.u) {
                if (this.c.m() != null && this.c.m().isFromQRCode()) {
                    this.m.t(false);
                    this.u = false;
                } else {
                    this.m.t(true);
                }
            } else {
                l9bVar.t(false);
            }
            if (this.v && this.c.l() == 1) {
                this.m.u(false);
            } else {
                this.m.u(true);
            }
            this.l.setAdapter((ListAdapter) this.m);
            this.l.setOuterOnScrollListener(this);
            this.m.s(this.D);
            this.m.n(this.B);
            this.m.o(this.y);
            this.i.setOnClickListener(this.a);
            this.g.setOnClickListener(this.a);
            this.h.setOnClickListener(this.a);
            this.r.setOnClickListener(this.a);
            this.j.setOnClickListener(this.z);
            this.q.setOnClickListener(this.z);
            f3();
            e3();
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
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048604, this, absListView, i, i2, i3) == null) {
            super.onScroll(absListView, i, i2, i3);
        }
    }
}
