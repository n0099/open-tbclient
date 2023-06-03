package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.SpriteInterceptHomeTipSwitch;
import com.baidu.tieba.mr6;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.q55;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class k3a extends q55 {
    public static /* synthetic */ Interceptable $ic;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;
    public final v0a c;
    public final MainTabActivity d;
    public final String e;
    public String f;
    @NonNull
    public kr6 g;

    /* loaded from: classes6.dex */
    public class a implements q55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q55.a a;
        public final /* synthetic */ k3a b;

        public a(k3a k3aVar, q55.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k3aVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k3aVar;
            this.a = aVar;
        }

        @Override // com.baidu.tieba.q55.a
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.b.j();
                }
                this.a.callback(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mr6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k3a a;

        public b(k3a k3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k3aVar;
        }

        @Override // com.baidu.tieba.mr6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
                this.a.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k3a b;

        public c(k3a k3aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k3aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k3aVar;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    if (!StringUtils.isNull(this.a)) {
                        if ("source_from_virtual_image".equals(this.b.e)) {
                            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                                str = "&skin=dark";
                            } else {
                                str = "";
                            }
                            UrlManager.getInstance().dealOneLink(this.b.d.getPageContext(), new String[]{this.a + str + "&from=2"});
                        } else if ("source_from_theme".equals(this.b.e)) {
                            UrlManager.getInstance().dealOneLink(this.b.d.getPageContext(), new String[]{this.a});
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_DRESS_UP_BUNDLE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.b.f));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3a(@NonNull MainTabActivity mainTabActivity, @NonNull v0a v0aVar, @NonNull String str) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, v0aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = v0aVar;
        this.d = mainTabActivity;
        this.e = str;
    }

    public static HashMap<String, String> k(String str) {
        InterceptResult invokeL;
        char c2;
        String string;
        nd5 nd5Var;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            int hashCode = str.hashCode();
            if (hashCode != -867211368) {
                if (hashCode != 525854610) {
                    if (hashCode == 1522674166 && str.equals("source_from_virtual_image")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("source_from_help")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
            } else {
                if (str.equals("source_from_theme")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            String str5 = "";
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        string = "";
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.set_theme);
                    }
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.set_virtual_image);
                }
            } else {
                string = TbadkApplication.getInst().getString(R.string.send_for_help_tips);
            }
            md5 mainTabPopConfig = TbSingleton.getInstance().getMainTabPopConfig();
            if (mainTabPopConfig != null) {
                nd5Var = mainTabPopConfig.b(str);
            } else {
                nd5Var = null;
            }
            if (nd5Var == null) {
                return null;
            }
            if (!StringUtils.isNull(nd5Var.d())) {
                string = nd5Var.d();
            }
            if (StringUtils.isNull(nd5Var.b())) {
                str2 = "";
            } else {
                str2 = nd5Var.b();
            }
            if (!StringUtils.isNull(nd5Var.a())) {
                str5 = nd5Var.a();
            }
            if (!StringUtils.isNull(nd5Var.e())) {
                str3 = nd5Var.e();
            } else {
                str3 = "3000";
            }
            if (!StringUtils.isNull(nd5Var.c())) {
                str4 = nd5Var.c();
            } else {
                str4 = "1";
            }
            hashMap.put("pop_params_key_text", string);
            hashMap.put("pop_params_key_link", str2);
            hashMap.put("pop_params_key_img", str5);
            hashMap.put("pop_params_key_time", str3);
            hashMap.put("pop_params_key_max", str4);
            hashMap.put("pop_params_key_source", str);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q55
    public void b() {
        kr6 kr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kr6Var = this.g) != null) {
            kr6Var.h();
        }
    }

    @Override // com.baidu.tieba.q55
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j();
        }
    }

    @Override // com.baidu.tieba.q55
    public void d(q55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            a aVar2 = new a(this, aVar);
            v0a v0aVar = this.c;
            if (v0aVar != null && v0aVar.y() != null) {
                if (SpriteInterceptHomeTipSwitch.isOn() && r3a.a().g()) {
                    aVar2.callback(false);
                    return;
                }
                FragmentTabWidget fragmentTabWidget = this.c.y().getFragmentTabWidget();
                if ("source_from_help".equals(this.e)) {
                    l(aVar2, k(this.e), fragmentTabWidget);
                    return;
                } else if ("source_from_virtual_image".equals(this.e) || "source_from_theme".equals(this.e)) {
                    n(aVar2, k(this.e), fragmentTabWidget);
                    return;
                } else {
                    return;
                }
            }
            aVar2.callback(false);
        }
    }

    @Override // com.baidu.tieba.q55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            kr6 kr6Var = this.g;
            if (kr6Var == null) {
                j();
                c();
                return;
            }
            kr6Var.z(new b(this));
            this.g.W(this.f, h, true, false);
            if ("source_from_theme".equals(this.e)) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_DRESS_UP_BUNDLE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.f));
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wq8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("MainTabTip", "首页引导展示结束：" + this.e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921802, this.e));
        }
    }

    public void l(q55.a aVar, HashMap<String, String> hashMap, FragmentTabWidget fragmentTabWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, aVar, hashMap, fragmentTabWidget) == null) {
            h = "SendHelpTipTask";
            if (hashMap == null) {
                aVar.callback(false);
                return;
            }
            if (fragmentTabWidget != null && fragmentTabWidget.getChildCount() > 2) {
                kr6 kr6Var = new kr6(this.d.getPageContext(), fragmentTabWidget.getChildAt(2), this.e, hashMap);
                this.g = kr6Var;
                kr6Var.s(false);
                this.g.t(true);
                this.g.L(R.drawable.bg_tip_blue_dropdown);
                this.g.l(2);
                this.g.o(32);
                this.g.N(true);
                this.g.R(-vi.g(this.b, R.dimen.tbds10));
                this.g.Q(-vi.g(this.b, R.dimen.tbds60));
                this.g.C(R.color.CAM_X0101);
                this.g.J(R.dimen.T_X09);
                this.g.w(Integer.valueOf(hashMap.get("pop_params_key_max")).intValue());
                this.g.n(Integer.valueOf(hashMap.get("pop_params_key_time")).intValue());
                this.g.q(R.dimen.tbds90);
                this.f = hashMap.get("pop_params_key_text");
                int g = vi.g(this.b, R.dimen.obfuscated_res_0x7f070393);
                this.g.E(g, 0, g, vi.g(this.b, R.dimen.obfuscated_res_0x7f07040a));
                this.g.A(h);
            }
            kr6 kr6Var2 = this.g;
            if (kr6Var2 == null) {
                aVar.callback(false);
            } else if (!kr6Var2.d()) {
                aVar.callback(false);
            } else {
                this.g.c(this.f, h, true, false, aVar);
            }
        }
    }

    public void n(q55.a aVar, HashMap<String, String> hashMap, FragmentTabWidget fragmentTabWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, aVar, hashMap, fragmentTabWidget) == null) {
            if ("source_from_virtual_image".equals(this.e)) {
                h = "setVirtualImage";
            } else {
                h = "setThemeSuit";
            }
            if (hashMap == null) {
                aVar.callback(false);
            } else if (fragmentTabWidget != null && fragmentTabWidget.getChildCount() >= 4) {
                if (!ProfileVirtualImageInfo.getInstance().isNetDataRespond() && "source_from_virtual_image".equals(this.e)) {
                    aVar.callback(false);
                    return;
                }
                kr6 kr6Var = new kr6(this.d.getPageContext(), fragmentTabWidget.getChildAt(4), this.e, hashMap);
                this.g = kr6Var;
                kr6Var.L(R.drawable.bg_tip_blue_dropdown_right);
                this.g.l(2);
                this.g.o(48);
                this.g.s(false);
                boolean z = true;
                this.g.N(true);
                this.g.Q(-vi.g(this.b, R.dimen.tbds62));
                this.g.C(R.color.CAM_X0101);
                this.g.J(R.dimen.T_X09);
                this.g.w(Integer.valueOf(hashMap.get("pop_params_key_max")).intValue());
                this.g.n(Integer.valueOf(hashMap.get("pop_params_key_time")).intValue());
                this.g.A(h);
                this.f = hashMap.get("pop_params_key_text");
                if (StringUtils.isNull(hashMap.get("pop_params_key_img"))) {
                    this.g.q(R.dimen.tbds90);
                    int g = vi.g(this.b, R.dimen.obfuscated_res_0x7f070393);
                    this.g.E(g, 0, g, vi.g(this.b, R.dimen.obfuscated_res_0x7f07040a));
                }
                this.g.m(new c(this, hashMap.get("pop_params_key_link")));
                if ("source_from_virtual_image".equals(this.e)) {
                    if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 1) {
                        z = false;
                    }
                    boolean d = this.g.d();
                    if (!z || !d) {
                        aVar.callback(false);
                        return;
                    }
                }
                this.g.c(this.f, h, true, false, aVar);
            } else {
                aVar.callback(false);
            }
        }
    }
}
