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
import c.a.d.f.p.l;
import c.a.q0.d1.n0;
import c.a.r0.l4.k.d;
import c.a.r0.l4.k.j;
import c.a.r0.l4.t.b;
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
/* loaded from: classes11.dex */
public class ImageListFragment extends BaseFragment implements d.InterfaceC1165d, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.s.g0.a A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public TbCameraView.i D;
    public TbCameraView.g E;
    public PopupWindow.OnDismissListener F;
    public c.a.r0.l4.k.g G;
    public b.f H;
    public c.a.r0.l4.k.h I;
    public j J;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f50770e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.l4.k.e f50771f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.l4.k.c f50772g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.f.f f50773h;

    /* renamed from: i  reason: collision with root package name */
    public View f50774i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f50775j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f50776k;
    public TextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public c.a.r0.l4.t.b o;
    public TransparentHeadGridView p;
    public c.a.r0.l4.k.i q;
    public NoDataView r;
    public View s;
    public NavigationBar t;
    public View u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f50777e;

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
            this.f50777e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || n0.b() || this.f50777e.f50772g == null) {
                return;
            }
            int l = this.f50777e.f50772g.l();
            if (this.f50777e.f50772g.D() < l) {
                if (this.f50777e.f50771f != null) {
                    this.f50777e.f50771f.Z(this.f50777e.getPageContext());
                    return;
                }
                return;
            }
            ImageListFragment imageListFragment = this.f50777e;
            imageListFragment.showToast(String.format(imageListFragment.getPageContext().getString(R.string.max_choose_image_count), Integer.valueOf(l)));
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f50778e;

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
            this.f50778e = imageListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50778e.f50772g == null) {
                return;
            }
            if (this.f50778e.J == null || !this.f50778e.J.i()) {
                if (view == this.f50778e.n) {
                    this.f50778e.o.k(this.f50778e.f50772g.e(), this.f50778e.f50772g.h());
                    this.f50778e.o.n(this.f50778e.t == null ? this.f50778e.s : this.f50778e.t);
                    this.f50778e.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null), (Drawable) null);
                    return;
                }
                View unused = this.f50778e.u;
            }
        }
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageListFragment f50779e;

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
            this.f50779e = imageListFragment;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f50779e.n != null && this.f50779e.isAdded()) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                if (pureDrawable != null) {
                    pureDrawable.setBounds(0, 0, pureDrawable.getMinimumWidth(), pureDrawable.getMinimumHeight());
                }
                this.f50779e.n.setCompoundDrawables(null, null, pureDrawable, null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements c.a.r0.l4.k.g {
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

        @Override // c.a.r0.l4.k.g
        public void a(int i2, MediaFileInfo mediaFileInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, mediaFileInfo) == null) {
                if (!this.a.z || this.a.f50772g == null || this.a.f50772g.l() != 1 || this.a.I == null) {
                    if (this.a.f50772g == null || this.a.f50772g.m() == null || !this.a.f50772g.m().isFromQRCode() || !(mediaFileInfo instanceof ImageFileInfo)) {
                        if (mediaFileInfo == null || this.a.f50772g == null) {
                            return;
                        }
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            this.a.f50772g.y((ImageFileInfo) mediaFileInfo);
                            if (this.a.f50771f != null) {
                                this.a.f50771f.V(1);
                                return;
                            }
                            return;
                        }
                        boolean z = mediaFileInfo instanceof VideoFileInfo;
                    } else if (this.a.f50771f != null) {
                        this.a.f50771f.m((ImageFileInfo) mediaFileInfo);
                    }
                } else if (this.a.I.a(i2, mediaFileInfo)) {
                    this.a.f50771f.i();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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

        @Override // c.a.r0.l4.t.b.f
        public void onItemClick(int i2, c.a.q0.f.a aVar) {
            List<MediaFileInfo> d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || this.a.f50772g == null || aVar == null) {
                return;
            }
            String b2 = aVar.b();
            String g2 = aVar.g();
            if (b2 == null || b2.equals(this.a.f50772g.h()) || (d2 = this.a.f50772g.d(b2)) == null) {
                return;
            }
            this.a.f50772g.x(b2);
            this.a.q.m(d2);
            this.a.n.setText(g2);
            this.a.p.smoothScrollToPosition(0);
        }
    }

    /* loaded from: classes11.dex */
    public class h implements c.a.r0.l4.k.h {
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

        @Override // c.a.r0.l4.k.h
        public boolean a(int i2, MediaFileInfo mediaFileInfo) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, mediaFileInfo)) == null) {
                if (mediaFileInfo == null || this.a.f50770e == null || this.a.f50772g == null || this.a.f50771f == null) {
                    return true;
                }
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                    if (c.a.r0.l4.r.a.a(imageFileInfo)) {
                        this.a.f50770e.showToast(R.string.album_choose_image_low_quality_tip);
                        return false;
                    } else if (!c.a.r0.l4.r.a.b(imageFileInfo)) {
                        if (this.a.f50772g.n(imageFileInfo)) {
                            this.a.f50771f.j(imageFileInfo);
                        } else {
                            this.a.f50771f.c(imageFileInfo);
                        }
                        this.a.f50772g.w(null);
                        this.a.q.notifyDataSetChanged();
                        this.a.y();
                        return true;
                    } else {
                        this.a.f50770e.showToast(String.format(this.a.getString(R.string.album_choose_image_max_wh_tip), Integer.valueOf(c.a.q0.s.e0.b.j().k("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.q0.s.e0.b.j().k("key_upload_pic_max_height", 0))));
                        return false;
                    }
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    if (this.a.f50772g.o()) {
                        this.a.f50770e.showToast(R.string.album_choose_switch_tip);
                        return true;
                    }
                    VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                    if (this.a.w(videoFileInfo) && this.a.v(videoFileInfo)) {
                        this.a.f50772g.w(videoFileInfo);
                        this.a.f50772g.b();
                        this.a.q.notifyDataSetChanged();
                        this.a.f50771f.i();
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class i implements c.a.q0.f.e {
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

        @Override // c.a.q0.f.e
        public void a(c.a.q0.f.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (this.a.A != null) {
                    this.a.A.h(false);
                }
                if (gVar == null) {
                    gVar = new c.a.q0.f.g();
                }
                if (this.a.f50772g != null && this.a.q != null) {
                    this.a.f50772g.z(gVar);
                    String h2 = this.a.f50772g.h();
                    this.a.f50772g.x(h2);
                    this.a.q.m(this.a.f50772g.d(h2));
                    if (this.a.p != null) {
                        this.a.p.smoothScrollToPosition(0);
                    }
                    this.a.y();
                }
                if (this.a.p != null) {
                    this.a.p.smoothScroll();
                }
            }
        }

        @Override // c.a.q0.f.e
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
            c.a.r0.l4.k.e eVar = this.f50771f;
            return (eVar == null || eVar.p() != 1) ? this.l : this.f50776k;
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
            c.a.r0.l4.k.i iVar = this.q;
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
            if (this.f50773h == null) {
                this.f50773h = new c.a.q0.f.f(getPageContext().getPageActivity());
            }
            c.a.r0.l4.k.e eVar = this.f50771f;
            if (eVar == null) {
                return;
            }
            if (eVar.g()) {
                i2 = this.f50771f.f() ? 1 : 0;
            } else {
                i2 = this.f50771f.e() ? 2 : 3;
            }
            this.f50773h.h(i2, new i(this));
        }
    }

    public void notifyDataSetChanged() {
        c.a.r0.l4.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f50772g) == null || cVar.r()) {
            return;
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.w0.a.a(getPageContext(), this.f50774i);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, i2);
            if (this.l != null && this.f50776k != null) {
                c.a.r0.l4.k.e eVar = this.f50771f;
                if (eVar != null && eVar.p() == 1) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50776k, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, null);
                    this.l.setVisibility(8);
                } else {
                    SkinManager.setViewTextColor(this.l, R.color.navi_back_text_color);
                    this.f50776k.setVisibility(8);
                }
            }
            if (this.n != null) {
                this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null), (Drawable) null);
            }
            c.a.r0.l4.k.i iVar = this.q;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            c.a.r0.l4.k.c cVar = this.f50772g;
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
            this.f50770e = baseFragmentActivity;
            if (this.f50771f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f50771f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f50771f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.r0.l4.k.e eVar = this.f50771f;
            if (eVar != null) {
                this.f50772g = eVar.q();
                this.y = this.f50771f.v();
                this.z = this.f50771f.u();
            }
            c.a.r0.l4.k.d.f().d(this);
            this.f50773h = new c.a.q0.f.f(this.f50770e);
            c.a.r0.l4.t.b bVar = new c.a.r0.l4.t.b(this.f50770e);
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
            this.f50770e = baseFragmentActivity;
            if (this.f50771f == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f50771f = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f50771f = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            c.a.r0.l4.k.e eVar = this.f50771f;
            if (eVar != null) {
                this.f50772g = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
            this.f50774i = inflate;
            this.f50775j = (RelativeLayout) inflate.findViewById(R.id.album_image_list_root);
            this.s = this.f50774i.findViewById(R.id.layout_title);
            this.n = (TextView) this.f50774i.findViewById(R.id.album_title);
            this.f50776k = (ImageView) this.f50774i.findViewById(R.id.img_close);
            this.l = (TextView) this.f50774i.findViewById(R.id.img_close_text);
            this.w = this.f50774i.findViewById(R.id.navi_line);
            this.u = this.f50774i.findViewById(R.id.layout_bottom);
            this.v = (TextView) this.f50774i.findViewById(R.id.original_select_btn);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f50774i.findViewById(R.id.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.m.getStyleConfig().l(l.f(this.f50770e, R.dimen.tbds25));
            this.f50772g.x(c.a.q0.f.a.f11963f);
            this.n.setText(this.f50770e.getPageContext().getString(R.string.album_all_media));
            if (this.f50772g.m() != null) {
                this.v.setVisibility(this.f50772g.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (this.f50772g.m() != null && this.f50772g.m().isFromQRCode()) {
                this.u.setVisibility(8);
            }
            this.r = NoDataViewFactory.a(this.f50770e.getPageContext().getPageActivity(), this.f50775j, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.b(R.string.album_list_no_data, R.string.album_list_no_data_1), null);
            TransparentHeadGridView transparentHeadGridView = (TransparentHeadGridView) this.f50774i.findViewById(R.id.gv_image_list);
            this.p = transparentHeadGridView;
            transparentHeadGridView.setSelector(R.color.transparent);
            c.a.r0.l4.k.i iVar = new c.a.r0.l4.k.i(this.f50770e, this.f50772g);
            this.q = iVar;
            if (this.y) {
                if (this.f50772g.m() != null && this.f50772g.m().isFromQRCode()) {
                    this.q.v(false);
                } else {
                    this.q.v(true);
                }
            } else {
                iVar.v(false);
            }
            if (this.z && this.f50772g.l() == 1) {
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
            this.m.setOnClickListener(this.f50770e);
            this.f50776k.setOnClickListener(this.f50770e);
            this.l.setOnClickListener(this.f50770e);
            this.v.setOnClickListener(this.f50770e);
            this.n.setOnClickListener(this.C);
            this.u.setOnClickListener(this.C);
            y();
            showLoadingView();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.t != null) {
                if (this.n.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.n.getParent()).removeView(this.n);
                }
                this.s.setVisibility(8);
                this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.n, (View.OnClickListener) null);
            }
            return this.f50774i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            c.a.q0.f.f fVar = this.f50773h;
            if (fVar != null) {
                fVar.c();
            }
            BaseFragmentActivity baseFragmentActivity = this.f50770e;
            if (baseFragmentActivity != null) {
                baseFragmentActivity.closeLoadingDialog();
            }
            c.a.q0.s.g0.a aVar = this.A;
            if (aVar != null) {
                aVar.h(false);
            }
            c.a.r0.l4.k.d.f().k(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetach();
            c.a.r0.l4.t.b bVar = this.o;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    @Override // c.a.r0.l4.k.d.InterfaceC1165d
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
                this.q.t((ImageView) childAt.findViewById(R.id.select_icon), z);
            }
            y();
        }
    }

    public final void refreshPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || isHidden() || this.x) {
            return;
        }
        x();
    }

    public void selectOriginalImg(boolean z) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (baseFragmentActivity = this.f50770e) == null || this.v == null) {
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

    public void setAlbumView(c.a.r0.l4.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.f50771f = eVar;
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
                this.A = new c.a.q0.s.g0.a(getPageContext());
            }
            this.A.e(null);
            this.A.i(R.string.loading);
            this.A.h(true);
        }
    }

    public final boolean v(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, videoFileInfo)) == null) {
            VideoFileInfo e2 = j.e(videoFileInfo.videoPath);
            if (e2 != null && Math.max(e2.videoWidth, e2.videoHeight) > 3000) {
                this.f50770e.showToast(R.string.album_choose_video_resolution_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean w(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, videoFileInfo)) == null) {
            int i2 = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
            if (i2 < 3000 || i2 > 600000) {
                this.f50770e.showToast(R.string.album_choose_video_time_tip);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void x() {
        c.a.r0.l4.k.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.f50772g == null && (eVar = this.f50771f) != null) {
                this.f50772g = eVar.q();
            }
            c.a.r0.l4.k.c cVar = this.f50772g;
            if (cVar == null) {
                return;
            }
            if (!cVar.r()) {
                this.q.notifyDataSetChanged();
            } else {
                loadAlbumMediaList();
            }
            selectOriginalImg(this.f50772g.s());
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [int, boolean] */
    public final void y() {
        c.a.r0.l4.k.c cVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (cVar = this.f50772g) == null || this.m == null) {
            return;
        }
        if (cVar.p()) {
            ?? p = this.f50772g.p();
            string = this.f50770e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf((int) p), 1});
            i2 = p;
        } else {
            int count = ListUtils.getCount(this.f50772g.g());
            string = this.f50770e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.f50772g.l())});
            i2 = count;
        }
        this.m.setText(string);
        this.m.setEnabled(i2 > 0);
    }

    public void refreshItem(ImageFileInfo imageFileInfo, boolean z) {
        c.a.r0.l4.k.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, imageFileInfo, z) == null) || imageFileInfo == null || (iVar = this.q) == null) {
            return;
        }
        refreshItem(iVar.i(imageFileInfo), z);
    }
}
