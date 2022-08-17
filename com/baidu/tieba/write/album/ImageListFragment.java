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
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fb5;
import com.repackage.jf5;
import com.repackage.k09;
import com.repackage.l09;
import com.repackage.oz8;
import com.repackage.pz8;
import com.repackage.qi;
import com.repackage.ql4;
import com.repackage.qz8;
import com.repackage.r09;
import com.repackage.ru4;
import com.repackage.sz8;
import com.repackage.tz8;
import com.repackage.ul4;
import com.repackage.uu4;
import com.repackage.uz8;
import com.repackage.vl4;
import com.repackage.vz8;
import com.repackage.wl4;
import java.util.List;
/* loaded from: classes4.dex */
public class ImageListFragment extends BaseFragment implements pz8.d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbCameraView.e A;
    public PopupWindow.OnDismissListener B;
    public sz8 C;
    public r09.f D;
    public tz8 E;
    public vz8 F;
    public BaseFragmentActivity a;
    public qz8 b;
    public oz8 c;
    public vl4 d;
    public View e;
    public RelativeLayout f;
    public ImageView g;
    public TextView h;
    public TBSpecificationBtn i;
    public TextView j;
    public r09 k;
    public TransparentHeadGridView l;
    public uz8 m;
    public NoDataView n;
    public View o;
    public NavigationBar p;
    public View q;
    public TextView r;
    public View s;
    public boolean t;
    public boolean u;
    public boolean v;
    public uu4 w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbCameraView.g z;

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || jf5.a() || this.a.c == null) {
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
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0aa5), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null) {
                return;
            }
            if ((this.a.F == null || !this.a.F.i()) && view2 == this.a.j) {
                this.a.k.k(this.a.c.e(), this.a.c.h());
                this.a.k.n(this.a.p == null ? this.a.o : this.a.p);
                this.a.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080932, R.color.CAM_X0105, null), (Drawable) null);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class f implements sz8 {
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

        @Override // com.repackage.sz8
        public void a(int i, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, mediaFileInfo) == null) {
                if (!this.a.v || this.a.c == null || this.a.c.l() != 1 || this.a.E == null) {
                    if (this.a.c == null || this.a.c.m() == null || !this.a.c.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                        if (mediaFileInfo == null || this.a.c == null || !(mediaFileInfo instanceof ImageFileInfo)) {
                            return;
                        }
                        this.a.c.y((ImageFileInfo) mediaFileInfo);
                        if (this.a.b != null) {
                            this.a.b.R(1);
                        }
                    } else if (this.a.b != null) {
                        this.a.b.m((ImageFileInfo) mediaFileInfo);
                    }
                } else if (this.a.E.a(i, mediaFileInfo)) {
                    this.a.b.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements r09.f {
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

        @Override // com.repackage.r09.f
        public void a(int i, ql4 ql4Var) {
            List<MediaFileInfo> d;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, ql4Var) == null) || this.a.c == null || ql4Var == null) {
                return;
            }
            String b = ql4Var.b();
            String g = ql4Var.g();
            if (b == null || b.equals(this.a.c.h()) || (d = this.a.c.d(b)) == null) {
                return;
            }
            this.a.c.x(b);
            this.a.m.m(d);
            this.a.j.setText(g);
            this.a.l.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements tz8 {
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

        @Override // com.repackage.tz8
        public boolean a(int i, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.a.a == null || this.a.c == null || this.a.b == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (k09.a(imageFileInfo.getFilePath()) == PhotoType.APNG) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c95);
                        return false;
                    } else if (l09.a(imageFileInfo)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0254);
                        return false;
                    } else if (!l09.b(imageFileInfo)) {
                        if (this.a.c.n(imageFileInfo)) {
                            this.a.b.j(imageFileInfo);
                        } else {
                            this.a.b.c(imageFileInfo);
                        }
                        this.a.c.w(null);
                        this.a.m.notifyDataSetChanged();
                        this.a.Y1();
                        return true;
                    } else {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0255), Integer.valueOf(ru4.k().l("key_upload_pic_max_width", 0)), Integer.valueOf(ru4.k().l("key_upload_pic_max_height", 0))));
                        return false;
                    }
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    if (this.a.c.o()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0256);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (this.a.J1(videoFileInfo) && this.a.I1(videoFileInfo)) {
                        this.a.c.w(videoFileInfo);
                        this.a.c.b();
                        this.a.m.notifyDataSetChanged();
                        this.a.b.i();
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
    public class i implements ul4 {
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

        @Override // com.repackage.ul4
        public void a(wl4 wl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wl4Var) == null) {
                if (this.a.w != null) {
                    this.a.w.h(false);
                }
                if (wl4Var == null) {
                    wl4Var = new wl4();
                }
                if (this.a.c != null && this.a.m != null) {
                    this.a.c.z(wl4Var);
                    String h = this.a.c.h();
                    this.a.c.x(h);
                    this.a.m.m(this.a.c.d(h));
                    if (this.a.l != null) {
                        this.a.l.smoothScrollToPosition(0);
                    }
                    this.a.Y1();
                }
                if (this.a.l != null) {
                    this.a.l.n();
                }
            }
        }

        @Override // com.repackage.ul4
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

    public final boolean I1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoFileInfo)) == null) {
            VideoFileInfo e2 = vz8.e(videoFileInfo.videoPath);
            if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 3000) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0257);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean J1(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFileInfo)) == null) {
            int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
            if (i2 < 3000 || i2 > 600000) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0258);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public View K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            qz8 qz8Var = this.b;
            return (qz8Var == null || qz8Var.q() != 1) ? this.h : this.g;
        }
        return (View) invokeV.objValue;
    }

    public View L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public TbCameraView M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            uz8 uz8Var = this.m;
            if (uz8Var != null) {
                return uz8Var.j();
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public TransparentHeadGridView N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (TransparentHeadGridView) invokeV.objValue;
    }

    public View O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    public void P1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.d == null) {
                this.d = new vl4(getPageContext().getPageActivity());
            }
            qz8 qz8Var = this.b;
            if (qz8Var == null) {
                return;
            }
            if (qz8Var.g()) {
                i2 = this.b.f() ? 1 : 0;
            } else {
                i2 = this.b.e() ? 2 : 3;
            }
            this.d.h(i2, new i(this));
        }
    }

    public final void Q1() {
        qz8 qz8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.c == null && (qz8Var = this.b) != null) {
                this.c = qz8Var.r();
            }
            oz8 oz8Var = this.c;
            if (oz8Var == null) {
                return;
            }
            if (!oz8Var.r()) {
                this.m.notifyDataSetChanged();
            } else {
                P1();
            }
            T1(this.c.s());
        }
    }

    public void R1(int i2, boolean z) {
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
                this.m.t((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f091ded), z);
            }
            Y1();
        }
    }

    public void S1(ImageFileInfo imageFileInfo, boolean z) {
        uz8 uz8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, imageFileInfo, z) == null) || imageFileInfo == null || (uz8Var = this.m) == null) {
            return;
        }
        R1(uz8Var.i(imageFileInfo), z);
    }

    public void T1(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (baseFragmentActivity = this.a) == null || this.r == null) {
            return;
        }
        this.r.setText(baseFragmentActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0d0f));
        if (z) {
            this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080948, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            return;
        }
        this.r.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080949, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0106);
    }

    public void U1(qz8 qz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, qz8Var) == null) {
            this.b = qz8Var;
        }
    }

    public void V1(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, navigationBar) == null) {
            this.p = navigationBar;
        }
    }

    public void W1(vz8 vz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vz8Var) == null) {
            this.F = vz8Var;
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.w == null) {
                this.w = new uu4(getPageContext());
            }
            this.w.e(null);
            this.w.i(R.string.obfuscated_res_0x7f0f0a3d);
            this.w.h(true);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [int, boolean] */
    public final void Y1() {
        oz8 oz8Var;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (oz8Var = this.c) == null || this.i == null) {
            return;
        }
        if (oz8Var.p()) {
            ?? p = this.c.p();
            string = this.a.getString(R.string.obfuscated_res_0x7f0f08d6, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.c.g());
            string = this.a.getString(R.string.obfuscated_res_0x7f0f08d6, new Object[]{Integer.valueOf(count), Integer.valueOf(this.c.l())});
            i2 = count;
        }
        this.i.setText(string);
        this.i.setEnabled(i2 > 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            super.onChangeSkinType(i2);
            fb5.a(getPageContext(), this.e);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, i2);
            if (this.h != null && this.g != null) {
                qz8 qz8Var = this.b;
                if (qz8Var != null && qz8Var.q() == 1) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f0809f4, R.color.CAM_X0105, null);
                    this.h.setVisibility(8);
                } else {
                    SkinManager.setViewTextColor(this.h, (int) R.color.navi_back_text_color);
                    this.g.setVisibility(8);
                }
            }
            if (this.j != null) {
                this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null), (Drawable) null);
            }
            uz8 uz8Var = this.m;
            if (uz8Var != null) {
                uz8Var.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            oz8 oz8Var = this.c;
            if (oz8Var != null) {
                T1(oz8Var.s());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
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
            qz8 qz8Var = this.b;
            if (qz8Var != null) {
                this.c = qz8Var.r();
                this.u = this.b.x();
                this.v = this.b.w();
            }
            pz8.f().d(this);
            this.d = new vl4(this.a);
            r09 r09Var = new r09(this.a);
            this.k = r09Var;
            r09Var.setOnDismissListener(this.B);
            this.k.l(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.b == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.b = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.b = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            qz8 qz8Var = this.b;
            if (qz8Var != null) {
                this.c = qz8Var.r();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0114, (ViewGroup) null);
            this.e = inflate;
            this.f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090238);
            this.o = this.e.findViewById(R.id.obfuscated_res_0x7f09128d);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09025e);
            this.g = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090ebc);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090ebe);
            this.s = this.e.findViewById(R.id.obfuscated_res_0x7f09160c);
            this.q = this.e.findViewById(R.id.obfuscated_res_0x7f091258);
            this.r = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091729);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f091683);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().l(qi.f(this.a, R.dimen.tbds25));
            this.c.x(ql4.f);
            this.j.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0251));
            if (this.c.m() != null) {
                this.r.setVisibility(this.c.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (this.c.m() != null && this.c.m().isFromQRCode()) {
                this.q.setVisibility(8);
            }
            this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0259, R.string.obfuscated_res_0x7f0f025a), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.e.findViewById(R.id.obfuscated_res_0x7f090cfb);
            this.l = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            uz8 uz8Var = new uz8(this.a, this.c);
            this.m = uz8Var;
            if (this.u) {
                if (this.c.m() != null && this.c.m().isFromQRCode()) {
                    this.m.v(false);
                    this.u = false;
                } else {
                    this.m.v(true);
                }
            } else {
                uz8Var.v(false);
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
            Y1();
            X1();
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            vl4 vl4Var = this.d;
            if (vl4Var != null) {
                vl4Var.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.a;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            uu4 uu4Var = this.w;
            if (uu4Var != null) {
                uu4Var.h(false);
            }
            pz8.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetach();
            r09 r09Var = this.k;
            if (r09Var != null) {
                r09Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            this.t = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            this.t = false;
            if (isShow()) {
                t();
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
                this.m.r(true);
            } else if (this.m.k()) {
                this.m.r(false);
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

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || isHidden() || this.t) {
            return;
        }
        Q1();
    }

    @Override // com.repackage.pz8.d
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            t();
        }
    }
}
