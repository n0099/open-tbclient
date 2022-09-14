package com.baidu.tieba.setting.im.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bx4;
import com.baidu.tieba.cg8;
import com.baidu.tieba.eg8;
import com.baidu.tieba.eu4;
import com.baidu.tieba.nu4;
import com.baidu.tieba.pb;
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eg8 a;
    public cg8 b;
    public boolean c;
    public ArrayList<nu4> d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public MsgRemindModel m;
    public eu4 n;
    public eg8.b o;
    public HttpMessageListener p;
    public pb q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public MsgRemindModel.f t;

    /* loaded from: classes5.dex */
    public class a implements eg8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        public a(SecretSettingActivity secretSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        @Override // com.baidu.tieba.eg8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("reply", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f29));
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.sendMessage(new CustomMessage(2002001, new ForbiddenForumActivityConfig(this.a.getPageContext().getPageActivity())));
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("live", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f024c));
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(this.a.getPageContext().getPageActivity());
                privacyMarkActivityConfig.setMarkState(this.a.k, this.a.l);
                this.a.sendMessage(new CustomMessage(2002001, privacyMarkActivityConfig));
                TiebaStatic.log(new StatisticItem("c14002").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("group", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f25));
                TiebaStatic.log("c10652");
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(this.a.getPageContext().getPageActivity())));
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Y1("like", secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b55));
                TiebaStatic.log("c12514");
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{TbConfig.URL_RECOMMEND_SETTING});
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.W1();
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{bx4.k().q("sync_ad_privacy_url", "")}, false);
            }
        }

        @Override // com.baidu.tieba.eg8.b
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SecretSettingActivity secretSettingActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            this.a.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(this.a);
                    bdTopToast.h(true);
                    bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0327));
                    bdTopToast.i((ViewGroup) this.a.findViewById(16908290));
                    if (TextUtils.equals("location", operation)) {
                        return;
                    }
                    this.a.b.n(operation, type);
                    this.a.a.E(operation, type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a);
                bdTopToast2.h(false);
                bdTopToast2.g(errorString);
                bdTopToast2.i((ViewGroup) this.a.findViewById(16908290));
                SecretSettingActivity secretSettingActivity = this.a;
                secretSettingActivity.Z1(secretSettingActivity.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SecretSettingActivity secretSettingActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.hideProgressBar();
                if (responsedMessage == null) {
                    return;
                }
                this.a.c = true;
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    cg8 privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                    if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                        privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                    }
                    if (privacyData == null) {
                        return;
                    }
                    this.a.b.l(privacyData);
                    this.a.b.m();
                    this.a.a.C(true);
                    this.a.a.F(this.a.b);
                    SecretSettingActivity secretSettingActivity = this.a;
                    secretSettingActivity.Z1(secretSettingActivity.b);
                    TbadkCoreApplication.getInst().setLocationShared(this.a.b.j());
                    return;
                }
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.a.showToast(errorString);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SecretSettingActivity secretSettingActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                bx4 k = bx4.k();
                int l = k.l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
                bx4 k2 = bx4.k();
                int l2 = k2.l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
                this.a.k = l;
                this.a.l = l2;
                this.a.a.D(l, l2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SecretSettingActivity b;

        public e(SecretSettingActivity secretSettingActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = secretSettingActivity;
            this.a = str;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.b.showProgressBar();
                String b = ((nu4) this.b.d.get(i)).b();
                int i2 = 7;
                if ("showAll".equals(b)) {
                    this.b.X1(this.a, 1);
                    i2 = 1;
                } else if ("friendOnly".equals(b)) {
                    this.b.X1(this.a, 2);
                    i2 = 2;
                } else if ("hideAll".equals(b)) {
                    this.b.X1(this.a, 3);
                    i2 = 3;
                } else if ("my_fans_reply".equals(b)) {
                    this.b.X1(this.a, 5);
                    i2 = 5;
                } else if ("my_attention_reply".equals(b)) {
                    this.b.X1(this.a, 6);
                    i2 = 6;
                } else if ("myselfOnly".equals(b)) {
                    this.b.X1(this.a, 7);
                } else {
                    i2 = 0;
                }
                this.b.n.h(i);
                if ("group".equals(this.a)) {
                    this.b.g = i2;
                } else if ("post".equals(this.a)) {
                    this.b.f = i2;
                } else if ("like".equals(this.a)) {
                    this.b.e = i2;
                } else if ("live".equals(this.a)) {
                    this.b.h = i2;
                } else if ("reply".equals(this.a)) {
                    this.b.i = i2;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SecretSettingActivity secretSettingActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.b.y(((Integer) customResponsedMessage.getData()).intValue());
                this.a.a.F(this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements MsgRemindModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecretSettingActivity a;

        public g(SecretSettingActivity secretSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secretSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secretSettingActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.f
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i != 8) {
                    if (i != 9 || z) {
                        return;
                    }
                    if (z2) {
                        this.a.a.w().j();
                    } else {
                        this.a.a.w().m();
                    }
                } else if (z) {
                } else {
                    if (z2) {
                        this.a.a.v().j();
                        this.a.a.B(false);
                        return;
                    }
                    this.a.a.v().m();
                    this.a.a.B(true);
                }
            }
        }
    }

    public SecretSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.o = new a(this);
        this.p = new b(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.q = new c(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.r = new d(this, 2921499);
        this.s = new f(this, 2921065);
        this.t = new g(this);
    }

    public final ArrayList<nu4> R1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<nu4> arrayList = new ArrayList<>();
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0903), "", i == 1, "showAll"));
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0905), "", i == 3, "hideAll"));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    public final ArrayList<nu4> S1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            ArrayList<nu4> arrayList = new ArrayList<>();
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0903), "", i == 1, "showAll"));
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0904), "", i == 2, "friendOnly"));
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0905), "", i == 3, "hideAll"));
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    public final ArrayList<nu4> T1(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            ArrayList<nu4> arrayList = new ArrayList<>();
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0275), "", i == 1, "showAll"));
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b59), "", i == 5, "my_fans_reply"));
            arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b56), "", i == 6, "my_attention_reply"));
            if (i2 == 1) {
                arrayList.add(new nu4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b77), "", i == 7, "myselfOnly"));
            }
            return arrayList;
        }
        return (ArrayList) invokeII.objValue;
    }

    public final void U1(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, switchState, i) == null) {
            V1(switchState, i, "");
        }
    }

    public final void V1(BdSwitchView.SwitchState switchState, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, switchState, i, str) == null) {
            int i2 = switchState == BdSwitchView.SwitchState.ON ? 1 : 2;
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 2).param("obj_type", NotificationManagerCompat.from(this).areNotificationsEnabled() ? 1 : 2);
            StatisticItem param2 = param.param("obj_source", i + "_" + i2);
            if (i == 9 && !TextUtils.isEmpty(str)) {
                param2.param("obj_param1", str);
            }
            TiebaStatic.log(param2);
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(getPageContext().getPageActivity(), "UserBlacklistPage", null)));
        }
    }

    public final void X1(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            sendMessage(new PrivacySettingMessage(str, i));
        }
    }

    public final void Y1(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && this.c) {
            if ("group".equals(str)) {
                this.d = S1(this.g);
            } else if ("post".equals(str)) {
                this.d = S1(this.f);
            } else if ("like".equals(str)) {
                this.d = S1(this.e);
            } else if ("live".equals(str)) {
                this.d = R1(this.h);
            } else if ("reply".equals(str)) {
                this.d = T1(this.i, this.j);
            }
            eu4 eu4Var = this.n;
            if (eu4Var != null) {
                eu4Var.d();
            }
            eu4 eu4Var2 = new eu4(getPageContext());
            this.n = eu4Var2;
            eu4Var2.m(str2);
            eu4 eu4Var3 = this.n;
            eu4Var3.k(this.d, new e(this, str));
            eu4Var3.m(str2);
            eu4 eu4Var4 = this.n;
            eu4Var4.c();
            eu4Var4.n();
        }
    }

    public final void Z1(cg8 cg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cg8Var) == null) {
            this.e = cg8Var.c();
            this.f = cg8Var.i();
            this.g = cg8Var.d();
            this.h = cg8Var.e();
            this.i = cg8Var.g();
            this.j = cg8Var.h();
            this.k = cg8Var.a();
            this.l = cg8Var.b();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void i0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, switchState) == null) {
            if (view2 == this.a.v()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.m.E(8, true, this.t);
                    this.a.B(true);
                } else {
                    this.m.E(8, false, this.t);
                    this.a.B(false);
                }
                U1(switchState, 5);
            } else if (view2 == this.a.w()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.m.E(9, true, this.t);
                } else {
                    this.m.E(9, false, this.t);
                }
                U1(switchState, 6);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
            eu4 eu4Var = this.n;
            if (eu4Var != null) {
                eu4Var.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new eg8(this);
            this.b = new cg8();
            this.a.A(this.o);
            this.m = new MsgRemindModel(getPageContext());
            if (this.b.k()) {
                this.a.C(true);
                this.a.F(this.b);
                Z1(this.b);
            } else {
                this.a.C(false);
            }
            registerListener(this.q);
            registerListener(this.p);
            registerListener(this.s);
            registerListener(this.r);
            sendMessage(new PrivateInfoNetMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            eu4 eu4Var = this.n;
            if (eu4Var != null) {
                eu4Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResourceRecycle();
            this.a.z();
        }
    }
}
