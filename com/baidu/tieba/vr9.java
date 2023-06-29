package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t4a;
import com.baidu.tieba.x36;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class vr9 implements x36 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern j;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerView a;
    public u25 b;
    public boolean c;
    public f46 d;
    public TbPageContext e;
    public x36.a f;
    public String g;
    public String h;
    public BannerView.b i;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr9 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(vr9 vr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr9Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.a.b != null && this.a.b.i) {
                    String c = this.a.b.c();
                    if (!StringUtils.isNULL(c)) {
                        this.a.C(c);
                    }
                    this.a.b.i = false;
                }
                if (this.a.a == null || !this.a.a.i() || this.a.c) {
                    return;
                }
                this.a.c = true;
                this.a.f.a(this.a.d, this.a.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr9 a;

        public b(vr9 vr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr9Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.z();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-336991091, "Lcom/baidu/tieba/vr9$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-336991091, "Lcom/baidu/tieba/vr9$c;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948250540, "Lcom/baidu/tieba/vr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948250540, "Lcom/baidu/tieba/vr9;");
                return;
            }
        }
        j = Pattern.compile("(/p/){1}(\\d+)");
    }

    public vr9() {
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
        this.a = null;
        this.c = false;
        this.i = new b(this);
    }

    public final void B() {
        BannerView bannerView;
        x36.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bannerView = this.a) != null && (aVar = this.f) != null) {
            this.c = false;
            aVar.b(this.d, bannerView);
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.x36
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x36
    public void a(int i) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (bannerView = this.a) != null) {
            bannerView.j();
        }
    }

    @Override // com.baidu.tieba.d46
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, map) == null) && map != null && !map.isEmpty()) {
            this.g = map.get("forum_name");
            this.h = map.get("forum_id");
        }
    }

    @Override // com.baidu.tieba.x36
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (obj instanceof u25)) {
            this.b = (u25) obj;
        }
    }

    @Override // com.baidu.tieba.x36
    public void h(x36.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f = aVar;
        }
    }

    @Override // com.baidu.tieba.x36
    public void l(int i) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (bannerView = this.a) != null) {
            bannerView.setBannerMaskColor(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d46
    /* renamed from: A */
    public void f(f46 f46Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, f46Var, str) == null) {
            this.d = f46Var;
            if (f46Var != null && (f46Var.a() instanceof TbPageContext)) {
                this.e = (TbPageContext) this.d.a();
            }
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !StringUtils.isNULL(str)) {
            t4a.b b2 = t4a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.h, this.g, null);
            b2.d(TiebaStatic.Params.OBJ_URL, this.b.b());
            b2.e();
        }
    }

    public final void D(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) && !StringUtils.isNULL(str)) {
            t4a.b b2 = t4a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.h, this.g, null);
            b2.d(TiebaStatic.Params.OBJ_URL, str2);
            b2.e();
        }
    }

    @Override // com.baidu.tieba.x36
    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.e != null && this.f != null) {
            u25 u25Var = this.b;
            if (u25Var == null) {
                B();
            } else if (!u25Var.e()) {
                B();
            } else {
                if (!this.c) {
                    if (this.a != null) {
                        return;
                    }
                    BannerView bannerView = new BannerView(this.e.getPageActivity());
                    this.a = bannerView;
                    bannerView.setVisibility(8);
                    this.a.setBannerViewClickListener(this.i);
                    this.a.setBannerViewEvent(new a(this));
                    if (this.b.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
                    }
                } else {
                    this.f.a(this.d, this.a);
                }
                this.a.setBannerData(this.b);
                this.a.k();
                if (this.b.getType() == 1 && !TextUtils.isEmpty(this.b.b())) {
                    this.a.setData(this.e, this.b.b());
                }
            }
        }
    }

    public final void z() {
        u25 u25Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (u25Var = this.b) == null) {
            return;
        }
        String d = u25Var.d();
        String c2 = this.b.c();
        if (this.b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.e.getPageActivity(), d, false, "frs_banner")));
            D(c2, d);
        } else if (this.b.a() == 2) {
            if (d.contains("tieba.baidu.com")) {
                Matcher matcher = j.matcher(d);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        D(c2, d);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                    }
                }
            }
        } else if (this.b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = c.a[nativePageType.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                        createNormalCfg2.setVideo_source("frs");
                        this.e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    }
                } else {
                    this.e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                }
            } else {
                ns9.l().c().c(this.e.getPageActivity(), new String[]{d}, null);
                if (!StringUtils.isNull(d) && d.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.e.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
                }
            }
            D(c2, d);
        } else if (this.b.a() == 4) {
            this.e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.e.getPageActivity()).createNormalCfg(d, "frs_banner")));
            D(c2, d);
        }
    }
}
